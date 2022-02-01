import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;

public class asdi
{
  public static String a = "ipsite.png";
  
  protected static int a()
  {
    if (bhbx.a())
    {
      if (bhbx.b() < 1048576L)
      {
        a(" RESULT_CODE_SDCARD less 1mb .");
        return 11001;
      }
      a(" RESULT_CODE_DOWNLOAD_OTHER_ERROR .");
      return 11011;
    }
    a(" RESULT_CODE_SDCARD_UNUSABLE .");
    return 11000;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      a("default RESULT_CODE_OTHER_ERROR .");
      return 11011;
    case 10: 
      a(" RESULT_CODE_NET_UNKNOWN_HOST ");
      return 11002;
    case 9: 
      a(" RESULT_CODE_NET_UNUSABLE .");
      return 11003;
    case 8: 
      a(" RESULT_CODE_CONTENT_LOSSY .");
      return 11006;
    case 6: 
      a(" RESULT_CODE_USER_CANCEL .");
      return 11007;
    case 2: 
      a(" RESULT_CODE_NET_CONNECT_TIMEOUT .");
      return 11004;
    case 3: 
      a(" RESULT_CODE_NET_SO_TIMEOUT .");
      return 11005;
    case 11: 
      a(" RESULT_CODE_SOCKET_EXCEPTION_ERROR .");
      return 11012;
    case 4: 
      return a();
    case 12: 
      return b();
    case 14: 
      a(" RESULT_CODE_HTTP_RESPONSE_NO_OK .");
      return 11016;
    case 13: 
      a(" RESULT_CODE_URL_STRING_ILLEGAL .");
      return 11014;
    }
    a(" RESULT_CODE_IS_HTML .");
    return 11021;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      i = 11017;
    }
    boolean bool;
    do
    {
      return i;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return 11018;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + paramArrayOfByte.length + " file=" + paramString + " time=" + System.currentTimeMillis());
      }
      bool = FileUtils.pushData2File(paramString, paramArrayOfByte, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + bool + ",data.len=" + paramArrayOfByte.length + " file=" + paramString + " time=" + System.currentTimeMillis());
      }
    } while (bool);
    return 11019;
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      i = 11017;
    }
    boolean bool;
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doing decryptTEA,srcData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = a(paramArrayOfByte, paramString1.getBytes());
      if (paramArrayOfByte == null) {
        return 11017;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. decryptTEA,clearData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return 11018;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      bool = FileUtils.pushData2File(paramString2, paramArrayOfByte, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + bool + ",data.len=" + paramArrayOfByte.length + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
    } while (bool);
    return 11019;
  }
  
  public static Drawable a(int paramInt, String paramString)
  {
    Object localObject = null;
    File localFile = new File(a(paramInt, paramString));
    paramString = localObject;
    if (localFile.exists()) {
      paramString = URLDrawable.getDrawable(localFile, null);
    }
    return paramString;
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString));
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("color.png");
      continue;
      localStringBuilder.append("gray.png");
      continue;
      localStringBuilder.append("list.png");
      continue;
      localStringBuilder.append("drainage.png");
      continue;
      localStringBuilder.append(a);
    }
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    a = "ipsite_" + paramString2 + ".png";
    return a(paramInt, paramString1);
  }
  
  public static String a(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if ((paramContext == null) || (paramMessage == null)) {
      return null;
    }
    MessageForMarketFace localMessageForMarketFace = new MessageForMarketFace();
    localMessageForMarketFace.msgData = paramMessage.msgData;
    localMessageForMarketFace.parse();
    if ((localMessageForMarketFace.mMarkFaceMessage != null) && (!TextUtils.isEmpty(localMessageForMarketFace.mMarkFaceMessage.faceName)))
    {
      paramContext = new StringBuilder();
      paramContext.append("[").append(localMessageForMarketFace.mMarkFaceMessage.faceName).append("]");
      return paramContext.toString();
    }
    return paramContext.getString(2131691876);
  }
  
  public static String a(String paramString)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/" + i % 10 + "/" + paramString + "_android.json");
    return a("VIP_emosm", localStringBuilder.toString());
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/audio.zip");
    }
    for (;;)
    {
      return a("VIP_emosm", localStringBuilder.toString());
      if (1 == paramInt) {
        if ("sbig".equalsIgnoreCase(awsc.a())) {
          localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsbig.zip");
        } else if ("xbig".equalsIgnoreCase(awsc.a())) {
          localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidxbig.zip");
        } else if ("big".equalsIgnoreCase(awsc.a())) {
          localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidbig.zip");
        } else {
          localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsmall.zip");
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt == 2) {
      return new String(paramArrayOfByte);
    }
    return PkgTools.toHexStr(paramArrayOfByte).toLowerCase();
  }
  
  protected static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, paramString);
    }
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    SecurityUtile.xorInLimit(paramArrayOfByte, paramInt1, paramInt2, paramLong, 200);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = NetworkUtil.isNetSupport(BaseApplicationImpl.getContext());
    if (!bool) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131692125, 0).a();
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) != -1;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 150	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 158	java/io/File:exists	()Z
    //   11: ifeq +63 -> 74
    //   14: new 322	java/io/FileInputStream
    //   17: dup
    //   18: new 150	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 328	java/io/FileInputStream:available	()I
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 332	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 335	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 336	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 335	java/io/FileInputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull -12 -> 74
    //   89: aload_1
    //   90: invokevirtual 335	java/io/FileInputStream:close	()V
    //   93: goto -19 -> 74
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 335	java/io/FileInputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_0
    //   114: aload_2
    //   115: areturn
    //   116: astore_0
    //   117: goto -43 -> 74
    //   120: astore_0
    //   121: goto -10 -> 111
    //   124: astore_1
    //   125: goto -22 -> 103
    //   128: astore_2
    //   129: goto -50 -> 79
    //   132: astore_2
    //   133: goto -73 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   29	61	1	localFileInputStream	java.io.FileInputStream
    //   100	12	1	localObject1	Object
    //   124	1	1	localObject2	Object
    //   38	18	2	arrayOfByte	byte[]
    //   57	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	39	2	localIOException1	java.io.IOException
    //   128	1	2	localIOException2	java.io.IOException
    //   132	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	30	57	java/io/FileNotFoundException
    //   14	30	76	java/io/IOException
    //   89	93	96	java/io/IOException
    //   14	30	100	finally
    //   51	55	113	java/io/IOException
    //   70	74	116	java/io/IOException
    //   107	111	120	java/io/IOException
    //   32	39	124	finally
    //   41	47	124	finally
    //   62	66	124	finally
    //   81	85	124	finally
    //   32	39	128	java/io/IOException
    //   41	47	128	java/io/IOException
    //   32	39	132	java/io/FileNotFoundException
    //   41	47	132	java/io/FileNotFoundException
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    Object localObject = null;
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 4))
    {
      int i = paramString.length() / 2;
      byte[] arrayOfByte = new byte[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= i) {
          break;
        }
        arrayOfByte[paramInt] = Integer.valueOf(paramString.substring(paramInt * 2, paramInt * 2 + 2), 16).byteValue();
        paramInt += 1;
      }
    }
    if (paramInt == 1) {
      localObject = paramString.getBytes();
    }
    return localObject;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return SecurityUtile.xorInLimit(paramArrayOfByte, 200);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte;
    if (!VersionUtils.isrFroyo()) {
      arrayOfByte = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    do
    {
      return arrayOfByte;
      arrayOfByte = null;
    } while (0 != 0);
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static char[] a(int paramInt1, int paramInt2)
  {
    return new char[] { (char)(paramInt1 >> 8), (char)(paramInt1 & 0xFF), (char)paramInt2, 'ÿ' };
  }
  
  public static int[] a(char[] paramArrayOfChar)
  {
    return new int[] { a(new byte[] { (byte)paramArrayOfChar[0], (byte)paramArrayOfChar[1] }, 2), paramArrayOfChar[2] };
  }
  
  protected static int b()
  {
    if (bhbx.a())
    {
      if (bhbx.b() < 1048576L)
      {
        a(" RESULT_CODE_SDCARD less 1mb .");
        return 11001;
      }
      a(" RESULT_CODE_LOCAL_FILESYSTEM_FAIL .");
      return 11013;
    }
    a(" RESULT_CODE_SDCARD_UNUSABLE .");
    return 11000;
  }
  
  public static String b(int paramInt, String paramString)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return a("VIP_emosm", localStringBuilder.toString());
      localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_color.png");
      continue;
      localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_gray.png");
      continue;
      localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/126x126.png");
      continue;
      localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/color.png");
      continue;
      localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/gray.png");
      continue;
      localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/list.png");
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = a(paramString);
    } while (i == -1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/").append(i % 10).append("/").append(paramString).append("/").append("h5.zip");
    return a("VIP_emosm", localStringBuilder.toString());
  }
  
  /* Error */
  public static boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: new 393	asdg
    //   7: dup
    //   8: aload_0
    //   9: ldc_w 395
    //   12: invokespecial 398	asdg:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_0
    //   20: bipush 10
    //   22: newarray byte
    //   24: astore 5
    //   26: aload 4
    //   28: astore_0
    //   29: aload 4
    //   31: aload 5
    //   33: invokevirtual 399	asdg:read	([B)I
    //   36: pop
    //   37: iload_3
    //   38: istore_2
    //   39: aload 5
    //   41: iconst_0
    //   42: baload
    //   43: bipush 71
    //   45: if_icmpne +29 -> 74
    //   48: iload_3
    //   49: istore_2
    //   50: aload 5
    //   52: iconst_1
    //   53: baload
    //   54: bipush 73
    //   56: if_icmpne +18 -> 74
    //   59: aload 5
    //   61: iconst_2
    //   62: baload
    //   63: istore_1
    //   64: iload_3
    //   65: istore_2
    //   66: iload_1
    //   67: bipush 70
    //   69: if_icmpne +5 -> 74
    //   72: iconst_1
    //   73: istore_2
    //   74: iload_2
    //   75: istore_3
    //   76: aload 4
    //   78: ifnull +10 -> 88
    //   81: aload 4
    //   83: invokevirtual 400	asdg:close	()V
    //   86: iload_2
    //   87: istore_3
    //   88: iload_3
    //   89: ireturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   95: iload_2
    //   96: istore_3
    //   97: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -12 -> 88
    //   103: ldc_w 402
    //   106: iconst_2
    //   107: ldc_w 404
    //   110: aload_0
    //   111: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: iload_2
    //   115: ireturn
    //   116: astore 5
    //   118: aconst_null
    //   119: astore 4
    //   121: aload 4
    //   123: astore_0
    //   124: aload 5
    //   126: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   129: aload 4
    //   131: astore_0
    //   132: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +18 -> 153
    //   138: aload 4
    //   140: astore_0
    //   141: ldc_w 402
    //   144: iconst_2
    //   145: ldc_w 410
    //   148: aload 5
    //   150: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: iload_2
    //   154: istore_3
    //   155: aload 4
    //   157: ifnull -69 -> 88
    //   160: aload 4
    //   162: invokevirtual 400	asdg:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   172: iload_2
    //   173: istore_3
    //   174: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -89 -> 88
    //   180: ldc_w 402
    //   183: iconst_2
    //   184: ldc_w 404
    //   187: aload_0
    //   188: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 400	asdg:close	()V
    //   205: aload 4
    //   207: athrow
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   213: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq -11 -> 205
    //   219: ldc_w 402
    //   222: iconst_2
    //   223: ldc_w 404
    //   226: aload_0
    //   227: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: goto -25 -> 205
    //   233: astore 4
    //   235: goto -38 -> 197
    //   238: astore 5
    //   240: goto -119 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString	String
    //   63	7	1	i	int
    //   1	172	2	bool1	boolean
    //   3	171	3	bool2	boolean
    //   15	146	4	localasdg	asdg
    //   193	13	4	localObject1	Object
    //   233	1	4	localObject2	Object
    //   24	36	5	arrayOfByte	byte[]
    //   116	33	5	localIOException1	java.io.IOException
    //   238	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   81	86	90	java/io/IOException
    //   4	17	116	java/io/IOException
    //   160	165	167	java/io/IOException
    //   4	17	193	finally
    //   201	205	208	java/io/IOException
    //   20	26	233	finally
    //   29	37	233	finally
    //   124	129	233	finally
    //   132	138	233	finally
    //   141	153	233	finally
    //   20	26	238	java/io/IOException
    //   29	37	238	java/io/IOException
  }
  
  public static byte[] b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return b(paramString);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    SecurityUtile.xorInLimit(paramArrayOfByte, 0, paramArrayOfByte.length, 0L, 200);
    return paramArrayOfByte;
  }
  
  public static char[] b(int paramInt1, int paramInt2)
  {
    return new char[] { 'ÿ', (char)(paramInt1 >> 8), (char)(paramInt1 & 0xFF), (char)paramInt2 };
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString));
    localStringBuilder.append("h5.zip");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdi
 * JD-Core Version:    0.7.0.1
 */