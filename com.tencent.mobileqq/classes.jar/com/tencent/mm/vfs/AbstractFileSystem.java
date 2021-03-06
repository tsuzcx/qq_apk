package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractFileSystem
  implements FileSystem
{
  private StatisticsCallback mStatistics;
  private String mStatisticsId;
  
  private static FileSystem resolveDelegate(FileSystem paramFileSystem, String paramString, int paramInt)
  {
    while ((paramFileSystem instanceof DelegateFileSystem)) {
      paramFileSystem = ((DelegateFileSystem)paramFileSystem).delegate(paramString, paramInt);
    }
    return paramFileSystem;
  }
  
  public int batchDelete(List<String> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext()) {
      if (delete((String)paramList.next())) {
        i += 1;
      }
    }
    return i;
  }
  
  public void configure(Map<String, String> paramMap) {}
  
  public final long copyFile(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = resolveDelegate(this, paramString1, 2);
    paramFileSystem = resolveDelegate(paramFileSystem, paramString2, 1);
    if ((localFileSystem != null) && (paramFileSystem != null))
    {
      if ((localFileSystem instanceof AbstractFileSystem)) {
        return ((AbstractFileSystem)localFileSystem).copyFileImpl(paramString1, paramFileSystem, paramString2);
      }
      return localFileSystem.copyFile(paramString1, paramFileSystem, paramString2);
    }
    throw new IOException("Cannot resolve delegate filesystem.");
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return VFSUtils.streamCopy(paramFileSystem, paramString2, this, paramString1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat) {}
  
  public final boolean moveFile(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = resolveDelegate(this, paramString1, 2);
    paramFileSystem = resolveDelegate(paramFileSystem, paramString2, 1);
    if ((localFileSystem != null) && (paramFileSystem != null))
    {
      if ((localFileSystem instanceof AbstractFileSystem)) {
        return ((AbstractFileSystem)localFileSystem).moveFileImpl(paramString1, paramFileSystem, paramString2);
      }
      return localFileSystem.moveFile(paramString1, paramFileSystem, paramString2);
    }
    throw new IOException("Cannot resolve delegate filesystem.");
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    return false;
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    return Channels.newChannel(openRead(paramString));
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    return Channels.newChannel(openWrite(paramString, paramBoolean));
  }
  
  public void setStatisticsCallback(String paramString, StatisticsCallback paramStatisticsCallback)
  {
    try
    {
      this.mStatisticsId = paramString;
      this.mStatistics = paramStatisticsCallback;
      return;
    }
    finally {}
  }
  
  protected void statistics(int paramInt, Map<String, Object> paramMap)
  {
    try
    {
      String str = this.mStatisticsId;
      StatisticsCallback localStatisticsCallback = this.mStatistics;
      if (localStatisticsCallback != null) {
        localStatisticsCallback.statistics(str, paramInt, paramMap);
      }
      return;
    }
    finally {}
  }
  
  protected void statistics(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = null;
    }
    else
    {
      HashMap localHashMap = new HashMap(paramVarArgs.length / 2);
      int j;
      for (int i = 0; i < paramVarArgs.length - 1; i = j + 1)
      {
        j = i + 1;
        Object localObject1 = paramVarArgs[i];
        if (j >= paramVarArgs.length) {
          break;
        }
        Object localObject2 = paramVarArgs[j];
        localHashMap.put(localObject1.toString(), String.valueOf(localObject2));
      }
      paramVarArgs = localHashMap;
    }
    statistics(paramInt, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.AbstractFileSystem
 * JD-Core Version:    0.7.0.1
 */