import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.ReportItemData;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class bbhs
  implements BadcaseReportUtils.ReportItemData
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<BadcaseReportUtils.BadDataFrame> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, paramString, 80);
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: istore_3
    //   15: aload_0
    //   16: ifnull +10 -> 26
    //   19: aload_1
    //   20: ifnonnull +8 -> 28
    //   23: iload 4
    //   25: istore_3
    //   26: iload_3
    //   27: ireturn
    //   28: new 45	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 52	java/io/File:exists	()Z
    //   41: ifeq +8 -> 49
    //   44: aload_1
    //   45: invokevirtual 55	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 58	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 60	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore 5
    //   66: aload 7
    //   68: astore 6
    //   70: new 65	java/io/BufferedOutputStream
    //   73: dup
    //   74: aload_1
    //   75: sipush 20480
    //   78: invokespecial 68	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   81: astore 7
    //   83: aload_0
    //   84: getstatic 74	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   87: iload_2
    //   88: aload 7
    //   90: invokevirtual 80	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   93: istore_3
    //   94: iload_3
    //   95: istore 4
    //   97: aload 7
    //   99: ifnull +13 -> 112
    //   102: aload 7
    //   104: invokevirtual 85	java/io/OutputStream:flush	()V
    //   107: aload 7
    //   109: invokevirtual 88	java/io/OutputStream:close	()V
    //   112: iload 4
    //   114: istore_3
    //   115: aload_1
    //   116: ifnull -90 -> 26
    //   119: aload_1
    //   120: invokevirtual 89	java/io/FileOutputStream:close	()V
    //   123: iload 4
    //   125: ireturn
    //   126: astore_0
    //   127: iload 4
    //   129: ireturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload 8
    //   135: astore 7
    //   137: aload_1
    //   138: astore 5
    //   140: aload 7
    //   142: astore 6
    //   144: aload_0
    //   145: invokevirtual 92	java/io/FileNotFoundException:printStackTrace	()V
    //   148: aload 7
    //   150: ifnull +13 -> 163
    //   153: aload 7
    //   155: invokevirtual 85	java/io/OutputStream:flush	()V
    //   158: aload 7
    //   160: invokevirtual 88	java/io/OutputStream:close	()V
    //   163: iload 4
    //   165: istore_3
    //   166: aload_1
    //   167: ifnull -141 -> 26
    //   170: aload_1
    //   171: invokevirtual 89	java/io/FileOutputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload 6
    //   184: ifnull +13 -> 197
    //   187: aload 6
    //   189: invokevirtual 85	java/io/OutputStream:flush	()V
    //   192: aload 6
    //   194: invokevirtual 88	java/io/OutputStream:close	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 89	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: goto -6 -> 205
    //   214: astore 5
    //   216: goto -19 -> 197
    //   219: astore_0
    //   220: aload 5
    //   222: astore_1
    //   223: goto -41 -> 182
    //   226: astore_0
    //   227: aload 7
    //   229: astore 6
    //   231: goto -49 -> 182
    //   234: astore_0
    //   235: goto -72 -> 163
    //   238: astore_0
    //   239: aload 8
    //   241: astore 7
    //   243: goto -106 -> 137
    //   246: astore_0
    //   247: goto -110 -> 137
    //   250: astore_0
    //   251: goto -139 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramBitmap	Bitmap
    //   0	254	1	paramString	String
    //   0	254	2	paramInt	int
    //   14	152	3	bool1	boolean
    //   10	154	4	bool2	boolean
    //   64	75	5	str	String
    //   214	7	5	localIOException	IOException
    //   1	229	6	localObject1	Object
    //   4	238	7	localObject2	Object
    //   7	233	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   119	123	126	java/io/IOException
    //   54	63	130	java/io/FileNotFoundException
    //   170	174	176	java/io/IOException
    //   54	63	179	finally
    //   49	54	207	java/io/IOException
    //   201	205	210	java/io/IOException
    //   187	197	214	java/io/IOException
    //   70	83	219	finally
    //   144	148	219	finally
    //   83	94	226	finally
    //   153	163	234	java/io/IOException
    //   70	83	238	java/io/FileNotFoundException
    //   83	94	246	java/io/FileNotFoundException
    //   102	112	250	java/io/IOException
  }
  
  private static void b()
  {
    Object localObject1 = new File(c());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getName().equals(".nomedia")) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2.delete();
          }
        }
      }
    }
  }
  
  private static void b(BadcaseReportUtils.BadDataFrame paramBadDataFrame, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  private static String c()
  {
    Object localObject = new StringBuilder(alrs.a);
    ((StringBuilder)localObject).append("/sv_capture_xx");
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File((String)localObject + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localObject;
    }
    catch (IOException localIOException) {}
    return localObject;
  }
  
  private static String d()
  {
    String str = c();
    return str + VidUtil.generateVid() + "_jpg";
  }
  
  private static String e()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i = 0;
    while (i < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i += 1;
    }
    return str;
  }
  
  public void itemOK(BadcaseReportUtils.BadDataFrame paramBadDataFrame)
  {
    if (paramBadDataFrame.pictureBuffer != null)
    {
      paramBadDataFrame.picturePath = null;
      ThreadManager.post(new ReportBadCase.1(this, paramBadDataFrame), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhs
 * JD-Core Version:    0.7.0.1
 */