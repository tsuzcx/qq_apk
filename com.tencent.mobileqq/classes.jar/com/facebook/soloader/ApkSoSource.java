package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class ApkSoSource
  extends ExtractFromZipSoSource
{
  private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 1;
  private static final byte LIBS_DIR_DOESNT_EXIST = 1;
  private static final byte LIBS_DIR_DONT_CARE = 0;
  private static final byte LIBS_DIR_SNAPSHOT = 2;
  public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
  private static final String TAG = "ApkSoSource";
  private final int mFlags;
  
  public ApkSoSource(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, new File(paramContext.getApplicationInfo().sourceDir), "^lib/([^/]+)/([^/]+\\.so)$");
    this.mFlags = paramInt;
  }
  
  protected byte[] getDepsBlock()
    throws IOException
  {
    Object localObject1 = this.mZipFileName.getCanonicalFile();
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeByte((byte)1);
      localParcel.writeString(((File)localObject1).getPath());
      localParcel.writeLong(((File)localObject1).lastModified());
      if ((this.mFlags & 0x1) == 0)
      {
        localParcel.writeByte((byte)0);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localObject1 = this.mContext.getApplicationInfo().nativeLibraryDir;
      if (localObject1 == null)
      {
        localParcel.writeByte((byte)1);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localObject1 = new File((String)localObject1).getCanonicalFile();
      if (!((File)localObject1).exists())
      {
        localParcel.writeByte((byte)1);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localParcel.writeByte((byte)2);
      localParcel.writeString(((File)localObject1).getPath());
      localParcel.writeLong(((File)localObject1).lastModified());
      localObject1 = localParcel.marshall();
      return localObject1;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ApkUnpacker(this);
  }
  
  protected class ApkUnpacker
    extends ExtractFromZipSoSource.ZipUnpacker
  {
    private final int mFlags = ApkSoSource.this.mFlags;
    private File mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
    
    ApkUnpacker(ExtractFromZipSoSource paramExtractFromZipSoSource)
      throws IOException
    {
      super(paramExtractFromZipSoSource);
    }
    
    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      String str = paramZipEntry.getName();
      if ((this.mFlags & 0x1) == 0)
      {
        Log.d("ApkSoSource", "allowing consideration of " + str + ": self-extraction preferred");
        return true;
      }
      File localFile = new File(this.mLibDir, paramString);
      if (!localFile.isFile())
      {
        Log.d("ApkSoSource", String.format("allowing considering of %s: %s not in system lib dir", new Object[] { str, paramString }));
        return true;
      }
      long l1 = localFile.length();
      long l2 = paramZipEntry.getSize();
      if (l1 != l2)
      {
        Log.d("ApkSoSource", String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[] { localFile, Long.valueOf(l1), Long.valueOf(l2) }));
        return true;
      }
      Log.d("ApkSoSource", "not allowing consideration of " + str + ": deferring to libdir");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.ApkSoSource
 * JD-Core Version:    0.7.0.1
 */