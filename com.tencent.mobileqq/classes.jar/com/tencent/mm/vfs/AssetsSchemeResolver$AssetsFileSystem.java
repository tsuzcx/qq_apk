package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

final class AssetsSchemeResolver$AssetsFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<AssetsFileSystem> CREATOR;
  private AssetManager mAssets;
  
  AssetsSchemeResolver$AssetsFileSystem(Context paramContext)
  {
    this.mAssets = paramContext.getAssets();
  }
  
  private void recursiveList(String paramString1, String paramString2, ArrayList<FileSystem.FileEntry> paramArrayList)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      if (paramString1.isEmpty())
      {
        paramString1 = paramString2;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(paramString2);
        paramString1 = ((StringBuilder)localObject).toString();
      }
    }
    Object localObject = this.mAssets.list(paramString1);
    int j;
    int i;
    if ((localObject != null) && (localObject.length != 0))
    {
      if (paramString2 != null) {
        paramArrayList.add(new FileSystem.FileEntry(this, paramString1, paramString2, 0L, 0L, 0L, true));
      }
      j = localObject.length;
      i = 0;
    }
    while (i < j)
    {
      paramString2 = localObject[i];
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        recursiveList(paramString1, paramString2, paramArrayList);
      }
      i += 1;
      continue;
      if (paramString2 != null) {
        paramArrayList.add(new FileSystem.FileEntry(this, paramString1, paramString2, 0L, 0L, 0L, false));
      }
    }
  }
  
  public int batchDelete(List<String> paramList)
  {
    return 0;
  }
  
  public int capabilityFlags()
  {
    return 12;
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new IOException("Not implemented");
  }
  
  public boolean delete(String paramString)
  {
    return false;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean exists(String paramString)
  {
    try
    {
      openRead(paramString).close();
      return true;
    }
    catch (IOException paramString)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return new FileSystem.FsStat();
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    Object localObject2 = paramString;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).substring(0, paramString.length() - 1);
    }
    if (paramBoolean) {}
    try
    {
      paramString = new ArrayList();
      recursiveList((String)localObject1, null, paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      int i;
      int j;
      String str;
      Object localObject3;
      String[] arrayOfString;
      return null;
    }
    localObject2 = this.mAssets.list((String)localObject1);
    if (localObject2 == null) {
      return null;
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject1);
    paramString.append('/');
    paramString = paramString.toString();
    localObject1 = new ArrayList(localObject2.length);
    i = localObject2.length;
    j = 0;
    if (j < i)
    {
      str = localObject2[j];
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(str);
      localObject3 = ((StringBuilder)localObject3).toString();
      arrayOfString = this.mAssets.list((String)localObject3);
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label225;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      ((ArrayList)localObject1).add(new FileSystem.FileEntry(this, (String)localObject3, str, 0L, 0L, 0L, paramBoolean));
      j += 1;
      break;
      return localObject1;
      label225:
      paramBoolean = false;
    }
  }
  
  public boolean mkdirs(String paramString)
  {
    return false;
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new IOException("Not implemented");
  }
  
  public InputStream openRead(String paramString)
  {
    try
    {
      paramString = this.mAssets.open(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      if ((paramString instanceof FileNotFoundException)) {
        throw ((FileNotFoundException)paramString);
      }
      throw new FileNotFoundException(paramString.getMessage());
    }
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Cannot open files for writing on read-only filesystems");
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    return false;
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    try
    {
      Object localObject = openRead(paramString);
      int i = ((InputStream)localObject).available();
      ((InputStream)localObject).close();
      int j = paramString.lastIndexOf('/');
      if (j < 0) {
        localObject = paramString;
      } else {
        localObject = paramString.substring(j + 1);
      }
      return new FileSystem.FileEntry(this, paramString, (String)localObject, i, 0L, 0L, false);
    }
    catch (IOException paramString)
    {
      label61:
      break label61;
    }
    return null;
  }
  
  public String toString()
  {
    return "AssetsFS";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver.AssetsFileSystem
 * JD-Core Version:    0.7.0.1
 */