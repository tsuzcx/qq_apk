import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bawh
  extends baqn
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int m;
    int i;
    int j;
    if (paramBitmap != null)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if (k <= m) {
        break label63;
      }
      i = m;
      if (k <= m) {
        break label68;
      }
      j = (k - m) / 2;
      label40:
      if (k <= m) {
        break label73;
      }
    }
    label63:
    label68:
    label73:
    for (int k = 0;; k = (m - k) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
      return localBitmap;
      i = k;
      break;
      j = 0;
      break label40;
    }
  }
  
  private String a(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    int k = paramString.indexOf('[');
    if (k == 0) {
      i = k + 1;
    }
    k = paramString.lastIndexOf(']');
    if (k == paramString.length() - 1) {
      j = k;
    }
    for (;;)
    {
      paramString = paramString.substring(i, j);
      if (QLog.isColorLevel()) {
        QLog.i("Q.QZoneRecentPhotoDownloader", 2, "dealHost|host = " + paramString);
      }
      return paramString;
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 49
    //   10: iconst_2
    //   11: new 51	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   18: ldc 77
    //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 79
    //   29: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: new 51	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   49: aload_1
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 81
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 5
    //   63: new 83	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 4
    //   74: aload 4
    //   76: invokevirtual 89	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 4
    //   84: invokevirtual 92	java/io/File:delete	()Z
    //   87: pop
    //   88: aload 4
    //   90: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull +17 -> 114
    //   100: aload 6
    //   102: invokevirtual 89	java/io/File:exists	()Z
    //   105: ifne +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 99	java/io/File:mkdirs	()Z
    //   113: pop
    //   114: aconst_null
    //   115: ldc 101
    //   117: aload_2
    //   118: invokestatic 107	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: aload 4
    //   123: invokestatic 112	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   126: ifeq +102 -> 228
    //   129: aload 5
    //   131: invokestatic 118	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   134: astore_2
    //   135: aload_2
    //   136: invokestatic 120	bawh:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +81 -> 222
    //   144: new 83	java/io/File
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 89	java/io/File:exists	()Z
    //   157: ifeq +8 -> 165
    //   160: aload_1
    //   161: invokevirtual 92	java/io/File:delete	()Z
    //   164: pop
    //   165: aload_1
    //   166: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   169: astore 5
    //   171: aload 5
    //   173: ifnull +17 -> 190
    //   176: aload 5
    //   178: invokevirtual 89	java/io/File:exists	()Z
    //   181: ifne +9 -> 190
    //   184: aload 5
    //   186: invokevirtual 99	java/io/File:mkdirs	()Z
    //   189: pop
    //   190: new 122	java/io/FileOutputStream
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +22 -> 222
    //   203: aload_2
    //   204: getstatic 131	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   207: bipush 70
    //   209: aload_1
    //   210: invokevirtual 135	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   213: pop
    //   214: aload_1
    //   215: invokevirtual 138	java/io/FileOutputStream:flush	()V
    //   218: aload_1
    //   219: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   222: aload 4
    //   224: invokevirtual 92	java/io/File:delete	()Z
    //   227: pop
    //   228: return
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 144	java/lang/OutOfMemoryError:printStackTrace	()V
    //   234: aconst_null
    //   235: astore_2
    //   236: goto -101 -> 135
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   244: aconst_null
    //   245: astore_2
    //   246: goto -111 -> 135
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 146	java/io/FileNotFoundException:printStackTrace	()V
    //   254: aload_3
    //   255: astore_1
    //   256: goto -57 -> 199
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   264: goto -42 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	bawh
    //   0	267	1	paramString1	String
    //   0	267	2	paramString2	String
    //   1	254	3	localObject1	Object
    //   72	151	4	localFile1	File
    //   61	124	5	localObject2	Object
    //   93	16	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   129	135	229	java/lang/OutOfMemoryError
    //   129	135	239	java/lang/Exception
    //   190	199	249	java/io/FileNotFoundException
    //   214	222	259	java/io/IOException
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    Object localObject = paramDownloadParams.url;
    paramOutputStream = paramURLDrawableHandler;
    if (localObject != null)
    {
      paramOutputStream = paramURLDrawableHandler;
      if (bdeu.a(((URL)localObject).getProtocol(), "troop_photo_qzone"))
      {
        paramURLDrawableHandler = ((URL)localObject).getFile();
        paramDownloadParams = new File(paramURLDrawableHandler);
        localObject = ((URL)localObject).getHost();
        if (QLog.isColorLevel()) {
          QLog.i("Q.QZoneRecentPhotoDownloader", 2, "downloadImage| path = " + paramURLDrawableHandler + ", host = " + (String)localObject);
        }
        if (paramDownloadParams.exists())
        {
          paramOutputStream = paramDownloadParams;
          if (paramDownloadParams.length() > 0L) {}
        }
        else
        {
          paramOutputStream = paramDownloadParams;
          if (localObject != null)
          {
            a(paramURLDrawableHandler, a((String)localObject));
            paramOutputStream = paramDownloadParams;
          }
        }
      }
    }
    return paramOutputStream;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, "decodeFile| f = " + paramFile);
    }
    if (paramFile == null) {}
    for (paramFile = null;; paramFile = paramFile.getPath())
    {
      paramURLDrawableHandler = paramFile;
      if (TextUtils.isEmpty(paramFile))
      {
        paramURLDrawableHandler = paramFile;
        if (paramDownloadParams != null)
        {
          paramURLDrawableHandler = paramFile;
          if (paramDownloadParams.url != null) {
            paramURLDrawableHandler = paramDownloadParams.url.getPath();
          }
        }
      }
      paramFile = localObject;
      if (!TextUtils.isEmpty(paramURLDrawableHandler)) {}
      try
      {
        paramFile = BitmapFactory.decodeFile(paramURLDrawableHandler);
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawh
 * JD-Core Version:    0.7.0.1
 */