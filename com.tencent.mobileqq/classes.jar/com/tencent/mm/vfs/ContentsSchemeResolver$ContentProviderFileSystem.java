package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;

final class ContentsSchemeResolver$ContentProviderFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
  private final ContentResolver mCR;
  
  ContentsSchemeResolver$ContentProviderFileSystem(Context paramContext)
  {
    this.mCR = paramContext.getContentResolver();
  }
  
  public int capabilityFlags()
  {
    return 1;
  }
  
  public boolean delete(String paramString)
  {
    return this.mCR.delete(Uri.parse(paramString), null, null) >= 1;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean exists(String paramString)
  {
    return stat(paramString) != null;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return new FileSystem.FsStat();
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public boolean mkdirs(String paramString)
  {
    return false;
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    return this.mCR.openFileDescriptor(Uri.parse(paramString1), paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.mCR.openInputStream(Uri.parse(paramString));
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    throw new FileNotFoundException("Not supported.");
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    ContentResolver localContentResolver = this.mCR;
    Uri localUri = Uri.parse(paramString);
    if (paramBoolean) {}
    for (paramString = "wa";; paramString = "w") {
      return localContentResolver.openOutputStream(localUri, paramString);
    }
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
    Object localObject2 = null;
    try
    {
      Object localObject1 = this.mCR.query(Uri.parse(paramString), null, null, null, null);
      if (localObject1 == null)
      {
        VFSUtils.closeQuietly((Closeable)localObject1);
        return null;
      }
      int i;
      int j;
      boolean bool;
      VFSUtils.closeQuietly((Closeable)localObject1);
    }
    finally
    {
      try
      {
        i = ((Cursor)localObject1).getColumnIndex("_display_name");
        j = ((Cursor)localObject1).getColumnIndex("_size");
        bool = ((Cursor)localObject1).moveToFirst();
        if (!bool)
        {
          VFSUtils.closeQuietly((Closeable)localObject1);
          return null;
        }
        paramString = new FileSystem.FileEntry(this, paramString, ((Cursor)localObject1).getString(i), ((Cursor)localObject1).getLong(j), 0L, 0L, false);
        VFSUtils.closeQuietly((Closeable)localObject1);
        return paramString;
      }
      finally
      {
        break label114;
      }
      paramString = finally;
      localObject1 = localObject2;
    }
    label114:
    throw paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver.ContentProviderFileSystem
 * JD-Core Version:    0.7.0.1
 */