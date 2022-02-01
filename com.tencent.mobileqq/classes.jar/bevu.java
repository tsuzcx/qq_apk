import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bevu
  extends beqz
{
  public static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label54:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label54;
      n = m;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileImgDownloader", 2, "downloadImage() url = " + paramDownloadParams.url);
    }
    paramURLDrawableHandler = paramDownloadParams.url.getProtocol();
    paramOutputStream = paramDownloadParams.url.getHost();
    paramDownloadParams = paramDownloadParams.url.getFile();
    int i;
    int j;
    if ((paramOutputStream != null) && ((paramOutputStream.startsWith("[")) || (paramOutputStream.endsWith("]")))) {
      if (paramOutputStream.startsWith("["))
      {
        i = 1;
        if (!paramOutputStream.endsWith("]")) {
          break label205;
        }
        j = paramOutputStream.length() - 1;
        label112:
        if (i >= j) {
          break label435;
        }
        paramOutputStream = paramOutputStream.substring(i, j);
      }
    }
    label408:
    label435:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileImgDownloader", 2, "downloadImage() [" + paramURLDrawableHandler + "," + paramOutputStream + "," + paramDownloadParams + "]");
      }
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        throw new RuntimeException("downloadImage() path is null");
        i = 0;
        break;
        label205:
        j = paramOutputStream.length();
        break label112;
      }
      File localFile1 = new File(paramDownloadParams);
      File localFile2;
      if (!localFile1.exists())
      {
        if (!"profile_img_icon".equals(paramURLDrawableHandler)) {
          break label408;
        }
        paramURLDrawableHandler = paramDownloadParams + "_temp";
        localFile2 = new File(paramURLDrawableHandler);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        File localFile3 = localFile2.getParentFile();
        if ((localFile3 != null) && (!localFile3.exists())) {
          localFile3.mkdirs();
        }
      }
      try
      {
        bool1 = HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("qzone", paramOutputStream), localFile2);
        if (bool1)
        {
          bhmi.d(paramURLDrawableHandler, paramDownloadParams);
          localFile2.delete();
          return localFile1;
        }
      }
      catch (Exception paramOutputStream)
      {
        for (;;)
        {
          boolean bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadQzonePic() " + paramOutputStream.toString());
            bool1 = bool2;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadQzonePic() fail");
            }
          }
        }
      }
      throw new RuntimeException("downloadImage() file not exist, path = " + paramDownloadParams);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public java.lang.Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +43 -> 49
    //   9: ldc 38
    //   11: iconst_2
    //   12: new 40	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   19: ldc 173
    //   21: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 53	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   28: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: ldc 175
    //   33: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 64	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: ldc 180
    //   51: aload_2
    //   52: getfield 53	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   55: invokevirtual 69	java/net/URL:getProtocol	()Ljava/lang/String;
    //   58: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +155 -> 216
    //   64: new 13	android/graphics/BitmapFactory$Options
    //   67: dup
    //   68: invokespecial 181	android/graphics/BitmapFactory$Options:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: iconst_1
    //   76: putfield 185	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   79: aload_1
    //   80: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: aload 6
    //   85: invokestatic 190	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   88: pop
    //   89: aload 6
    //   91: aload 6
    //   93: sipush 160
    //   96: sipush 160
    //   99: invokestatic 192	bevu:b	(Landroid/graphics/BitmapFactory$Options;II)I
    //   102: putfield 195	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 6
    //   107: iconst_0
    //   108: putfield 185	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: new 197	java/io/BufferedInputStream
    //   114: dup
    //   115: new 199	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   126: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: aload 5
    //   137: aconst_null
    //   138: aload 6
    //   140: invokestatic 207	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   143: astore 6
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 212	java/io/InputStream:close	()V
    //   155: aload 6
    //   157: areturn
    //   158: astore 6
    //   160: aconst_null
    //   161: astore 5
    //   163: aload 5
    //   165: astore 4
    //   167: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +36 -> 206
    //   173: aload 5
    //   175: astore 4
    //   177: ldc 38
    //   179: iconst_2
    //   180: new 40	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   187: ldc 214
    //   189: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 6
    //   194: invokevirtual 217	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload 5
    //   208: ifnull +8 -> 216
    //   211: aload 5
    //   213: invokevirtual 212	java/io/InputStream:close	()V
    //   216: aload_0
    //   217: aload_1
    //   218: aload_2
    //   219: aload_3
    //   220: invokespecial 222	beqz:decodeFile	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   223: areturn
    //   224: astore_1
    //   225: aload 4
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 212	java/io/InputStream:close	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: aload 6
    //   241: areturn
    //   242: astore 4
    //   244: goto -28 -> 216
    //   247: astore_2
    //   248: goto -12 -> 236
    //   251: astore_1
    //   252: aload 4
    //   254: astore_2
    //   255: goto -27 -> 228
    //   258: astore 6
    //   260: goto -97 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bevu
    //   0	263	1	paramFile	File
    //   0	263	2	paramDownloadParams	DownloadParams
    //   0	263	3	paramURLDrawableHandler	URLDrawableHandler
    //   1	225	4	localObject1	java.lang.Object
    //   242	11	4	localIOException	java.io.IOException
    //   129	83	5	localBufferedInputStream	java.io.BufferedInputStream
    //   71	85	6	localObject2	java.lang.Object
    //   158	82	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   258	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   64	131	158	java/lang/OutOfMemoryError
    //   64	131	224	finally
    //   150	155	238	java/io/IOException
    //   211	216	242	java/io/IOException
    //   232	236	247	java/io/IOException
    //   135	145	251	finally
    //   167	173	251	finally
    //   177	206	251	finally
    //   135	145	258	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevu
 * JD-Core Version:    0.7.0.1
 */