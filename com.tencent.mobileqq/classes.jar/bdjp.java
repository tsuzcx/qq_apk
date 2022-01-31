import android.os.AsyncTask;
import java.io.File;

public class bdjp
  extends AsyncTask<String, Integer, File>
{
  private bdjq a;
  
  public bdjp(bdjq parambdjq)
  {
    this.a = parambdjq;
  }
  
  /* Error */
  protected File a(String... paramVarArgs)
  {
    // Byte code:
    //   0: new 20	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 21	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: aaload
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 23
    //   15: invokevirtual 29	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18: ifne +12 -> 30
    //   21: aload_1
    //   22: ldc 31
    //   24: invokevirtual 29	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   27: ifeq +88 -> 115
    //   30: aload_2
    //   31: aload_1
    //   32: new 33	java/util/HashMap
    //   35: dup
    //   36: invokespecial 34	java/util/HashMap:<init>	()V
    //   39: invokevirtual 38	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   42: aload_2
    //   43: invokevirtual 42	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   46: astore 4
    //   48: new 44	java/io/File
    //   51: dup
    //   52: invokestatic 49	bdeu:a	()Lbdeu;
    //   55: ldc 51
    //   57: invokevirtual 55	bdeu:b	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 62	java/io/File:exists	()Z
    //   68: ifeq +8 -> 76
    //   71: aload_3
    //   72: invokevirtual 65	java/io/File:delete	()Z
    //   75: pop
    //   76: new 67	java/io/FileOutputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore 5
    //   86: aload 4
    //   88: getstatic 76	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 90
    //   93: aload 5
    //   95: invokevirtual 82	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   98: pop
    //   99: aload 5
    //   101: invokevirtual 85	java/io/FileOutputStream:flush	()V
    //   104: aload 5
    //   106: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   109: aload_2
    //   110: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   113: aload_3
    //   114: areturn
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 93	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   120: goto -78 -> 42
    //   123: astore_1
    //   124: ldc 95
    //   126: new 97	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   133: ldc 100
    //   135: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 117	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore 4
    //   152: ldc 95
    //   154: new 97	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   161: ldc 119
    //   163: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: aload 4
    //   175: invokestatic 125	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   178: pop
    //   179: goto -70 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	bdjp
    //   0	182	1	paramVarArgs	String[]
    //   7	109	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   63	51	3	localFile	File
    //   46	41	4	localBitmap	android.graphics.Bitmap
    //   150	24	4	localException	java.lang.Exception
    //   84	21	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	8	123	java/lang/Exception
    //   12	30	123	java/lang/Exception
    //   30	42	123	java/lang/Exception
    //   42	76	123	java/lang/Exception
    //   109	113	123	java/lang/Exception
    //   115	120	123	java/lang/Exception
    //   152	179	123	java/lang/Exception
    //   76	109	150	java/lang/Exception
  }
  
  protected void a(File paramFile)
  {
    super.onPostExecute(paramFile);
    if (this.a != null) {
      this.a.a(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdjp
 * JD-Core Version:    0.7.0.1
 */