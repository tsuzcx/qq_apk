package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;

final class VFSNativeAPI
{
  private static final int ALL_SUPPORTED_FLAGS = 1603;
  private static final int O_ACCMODE = 3;
  private static final int O_APPEND = 1024;
  private static final int O_CREAT = 64;
  private static final int O_RDONLY = 0;
  private static final int O_RDWR = 2;
  private static final int O_TRUNC = 512;
  private static final int O_WRONLY = 1;
  private static final String TAG = "VFS.VFSNativeAPI";
  
  static int openFd(String paramString, int paramInt)
  {
    if ((paramInt & 0xFFFFF9BC) != 0) {
      throw new IllegalArgumentException("Flags unsupported: " + paramInt);
    }
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("Invalid access mode: " + paramInt);
    case 0: 
      localObject1 = "r";
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if ((paramInt & 0x200) != 0) {
        localObject2 = (String)localObject1 + "t";
      }
      Object localObject3 = localObject2;
      if ((paramInt & 0x400) != 0) {
        localObject3 = (String)localObject2 + "a";
      }
      localObject2 = null;
      localObject1 = null;
      try
      {
        localObject3 = VFSFileOp.openFileDescriptor(paramString, (String)localObject3);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramInt = ((ParcelFileDescriptor)localObject3).detachFd();
          return paramInt;
          localObject1 = "w";
          continue;
          localObject1 = "rw";
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject2 = localObject1;
          QLog.e("VFS.VFSNativeAPI", 1, "Failed to open file descriptor for file: " + paramString, localIOException);
          VFSUtils.closeQuietly((Closeable)localObject1);
        }
      }
      finally
      {
        VFSUtils.closeQuietly((Closeable)localObject2);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSNativeAPI
 * JD-Core Version:    0.7.0.1
 */