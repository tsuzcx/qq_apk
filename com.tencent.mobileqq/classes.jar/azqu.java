import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class azqu
{
  public static azsa a(azsa paramazsa)
  {
    for (paramazsa = paramazsa.a(); (paramazsa != null) && (paramazsa.jdField_a_of_type_Int != 1); paramazsa = paramazsa.a()) {}
    return paramazsa;
  }
  
  public static AbsStructMsg a()
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = alpo.a(2131714978);
    localStructMsgForGeneralShare.mMsgAction = "";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    localStructMsgForGeneralShare.mFlag = 55;
    azqt.a(0).a(new StructMsgItemTitle(""));
    return localStructMsgForGeneralShare;
  }
  
  public static AbsStructMsg a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("req_type", 146))
    {
    case 4: 
    default: 
      return new StructMsgForGeneralShare(paramBundle);
    case 2: 
      return new StructMsgForAudioShare(paramBundle);
    case 3: 
      return new StructMsgForHypertext(paramBundle);
    }
    return new StructMsgForImageShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      l1 = paramArrayOfByte.mMsgServiceID;
      l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        azmj.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.getCurrentAccountUin(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
      if (l1 == 52L)
      {
        paramQQAppInterface = new StringBuilder("rec flower msg,");
        paramQQAppInterface.append(azsv.a(paramArrayOfByte));
        QLog.i("StructMsg", 1, paramQQAppInterface.toString());
      }
    }
    while (!QLog.isColorLevel())
    {
      long l1;
      long l2;
      return paramArrayOfByte;
    }
    QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = null ,error happened ");
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aload_2
    //   12: areturn
    //   13: new 181	java/io/ObjectInputStream
    //   16: dup
    //   17: new 183	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 186	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 189	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_2
    //   33: aload 5
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 193	java/io/ObjectInputStream:readInt	()I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_2
    //   44: if_icmpne +77 -> 121
    //   47: aload 4
    //   49: astore_2
    //   50: aload 5
    //   52: astore_3
    //   53: new 90	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   56: dup
    //   57: invokespecial 194	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +24 -> 86
    //   65: aload 4
    //   67: astore_2
    //   68: aload_0
    //   69: astore_3
    //   70: aload_0
    //   71: iload_1
    //   72: putfield 106	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   75: aload 4
    //   77: astore_2
    //   78: aload_0
    //   79: astore_3
    //   80: aload_0
    //   81: aload 4
    //   83: invokevirtual 198	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   86: aload_0
    //   87: astore_2
    //   88: aload 4
    //   90: ifnull -79 -> 11
    //   93: aload 4
    //   95: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -95 -> 11
    //   109: ldc 156
    //   111: iconst_2
    //   112: aload_3
    //   113: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: areturn
    //   121: iload_1
    //   122: iconst_3
    //   123: if_icmpeq +15 -> 138
    //   126: iload_1
    //   127: bipush 82
    //   129: if_icmpeq +9 -> 138
    //   132: iload_1
    //   133: bipush 120
    //   135: if_icmpne +181 -> 316
    //   138: aload 4
    //   140: astore_2
    //   141: aload 5
    //   143: astore_3
    //   144: new 93	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   147: dup
    //   148: invokespecial 205	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   151: astore_0
    //   152: goto -91 -> 61
    //   155: aload 4
    //   157: astore_2
    //   158: aload 5
    //   160: astore_3
    //   161: new 96	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   164: dup
    //   165: invokespecial 206	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   168: astore_0
    //   169: goto -108 -> 61
    //   172: iload_1
    //   173: sipush 150
    //   176: if_icmpne +20 -> 196
    //   179: aload 4
    //   181: astore_2
    //   182: aload 5
    //   184: astore_3
    //   185: new 208	com/tencent/mobileqq/structmsg/StructMsgSubImageVideo
    //   188: dup
    //   189: invokespecial 209	com/tencent/mobileqq/structmsg/StructMsgSubImageVideo:<init>	()V
    //   192: astore_0
    //   193: goto -132 -> 61
    //   196: aload 4
    //   198: astore_2
    //   199: aload 5
    //   201: astore_3
    //   202: new 18	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   205: dup
    //   206: invokespecial 22	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   209: astore_0
    //   210: goto -149 -> 61
    //   213: astore 5
    //   215: aconst_null
    //   216: astore_0
    //   217: aload_0
    //   218: astore_2
    //   219: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +16 -> 238
    //   225: aload_0
    //   226: astore_2
    //   227: ldc 156
    //   229: iconst_2
    //   230: aload 5
    //   232: invokevirtual 210	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   235: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_3
    //   239: astore_2
    //   240: aload_0
    //   241: ifnull -230 -> 11
    //   244: aload_0
    //   245: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   248: aload_3
    //   249: areturn
    //   250: astore_0
    //   251: aload_3
    //   252: astore_2
    //   253: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -245 -> 11
    //   259: ldc 156
    //   261: iconst_2
    //   262: aload_0
    //   263: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   266: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_3
    //   270: areturn
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_2
    //   274: aload_2
    //   275: ifnull +7 -> 282
    //   278: aload_2
    //   279: invokevirtual 201	java/io/ObjectInputStream:close	()V
    //   282: aload_0
    //   283: athrow
    //   284: astore_2
    //   285: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -6 -> 282
    //   291: ldc 156
    //   293: iconst_2
    //   294: aload_2
    //   295: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   298: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: goto -19 -> 282
    //   304: astore_0
    //   305: goto -31 -> 274
    //   308: astore 5
    //   310: aload 4
    //   312: astore_0
    //   313: goto -96 -> 217
    //   316: iload_1
    //   317: iconst_5
    //   318: if_icmpeq -163 -> 155
    //   321: iload_1
    //   322: sipush 137
    //   325: if_icmpne -153 -> 172
    //   328: goto -173 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramArrayOfByte	byte[]
    //   41	285	1	i	int
    //   6	273	2	localObject1	Object
    //   284	11	2	localIOException1	java.io.IOException
    //   1	79	3	localObject2	Object
    //   100	13	3	localIOException2	java.io.IOException
    //   143	127	3	localObject3	Object
    //   28	283	4	localObjectInputStream	java.io.ObjectInputStream
    //   3	197	5	localObject4	Object
    //   213	18	5	localException1	Exception
    //   308	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   93	98	100	java/io/IOException
    //   13	30	213	java/lang/Exception
    //   244	248	250	java/io/IOException
    //   13	30	271	finally
    //   278	282	284	java/io/IOException
    //   36	42	304	finally
    //   53	61	304	finally
    //   70	75	304	finally
    //   80	86	304	finally
    //   144	152	304	finally
    //   161	169	304	finally
    //   185	193	304	finally
    //   202	210	304	finally
    //   219	225	304	finally
    //   227	238	304	finally
    //   36	42	308	java/lang/Exception
    //   53	61	308	java/lang/Exception
    //   70	75	308	java/lang/Exception
    //   80	86	308	java/lang/Exception
    //   144	152	308	java/lang/Exception
    //   161	169	308	java/lang/Exception
    //   185	193	308	java/lang/Exception
    //   202	210	308	java/lang/Exception
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_2
    //   7: if_icmpge +21 -> 28
    //   10: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 156
    //   18: iconst_2
    //   19: ldc 218
    //   21: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore_0
    //   26: aload_0
    //   27: areturn
    //   28: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +25 -> 56
    //   34: ldc 156
    //   36: iconst_2
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc 220
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_0
    //   49: invokestatic 225	bdcv:a	([B)Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: iload_1
    //   58: invokestatic 233	azsd:a	([BI)[B
    //   61: astore_3
    //   62: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +11 -> 76
    //   68: ldc 156
    //   70: iconst_2
    //   71: ldc 235
    //   73: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 241	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   79: invokevirtual 242	java/util/UUID:toString	()Ljava/lang/String;
    //   82: astore_0
    //   83: new 128	java/lang/String
    //   86: dup
    //   87: aload_3
    //   88: ldc 244
    //   90: invokespecial 247	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 250	azqu:a	(Ljava/lang/String;)Z
    //   98: istore_2
    //   99: aload_3
    //   100: aload_0
    //   101: iload_2
    //   102: invokestatic 255	bahu:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   105: invokestatic 258	azqu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: invokestatic 261	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   112: ifeq +29 -> 141
    //   115: ldc 156
    //   117: iconst_4
    //   118: new 142	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 264
    //   128: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: new 183	java/io/ByteArrayInputStream
    //   144: dup
    //   145: aload_3
    //   146: invokevirtual 268	java/lang/String:getBytes	()[B
    //   149: invokespecial 186	java/io/ByteArrayInputStream:<init>	([B)V
    //   152: astore_3
    //   153: new 270	azsb
    //   156: dup
    //   157: invokespecial 271	azsb:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: aload_0
    //   165: invokevirtual 273	azsb:a	(Ljava/lang/String;)V
    //   168: aload 4
    //   170: iload_2
    //   171: invokevirtual 276	azsb:a	(Z)V
    //   174: invokestatic 282	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 286	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   182: aload_3
    //   183: aload 4
    //   185: invokevirtual 292	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   188: aload_3
    //   189: invokevirtual 295	java/io/InputStream:close	()V
    //   192: aload 4
    //   194: invokevirtual 297	azsb:a	()Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   197: astore_3
    //   198: aload_3
    //   199: astore_0
    //   200: aload_3
    //   201: ifnull -175 -> 26
    //   204: aload_3
    //   205: astore_0
    //   206: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -183 -> 26
    //   212: ldc 156
    //   214: iconst_2
    //   215: ldc_w 299
    //   218: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_3
    //   222: areturn
    //   223: astore_0
    //   224: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +13 -> 240
    //   230: ldc 156
    //   232: iconst_2
    //   233: ldc_w 301
    //   236: aload_0
    //   237: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 308	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   247: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +32 -> 282
    //   253: ldc 156
    //   255: iconst_2
    //   256: new 142	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 310
    //   266: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_0
    //   270: invokevirtual 311	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aconst_null
    //   283: areturn
    //   284: astore_0
    //   285: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -48 -> 240
    //   291: ldc 156
    //   293: iconst_2
    //   294: ldc_w 301
    //   297: aload_0
    //   298: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: goto -61 -> 240
    //   304: astore_0
    //   305: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq -68 -> 240
    //   311: ldc 156
    //   313: iconst_2
    //   314: ldc_w 301
    //   317: aload_0
    //   318: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   321: goto -81 -> 240
    //   324: astore_0
    //   325: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq -88 -> 240
    //   331: ldc 156
    //   333: iconst_2
    //   334: ldc_w 313
    //   337: aload_0
    //   338: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: goto -101 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramArrayOfByte	byte[]
    //   0	344	1	paramInt	int
    //   98	73	2	bool	boolean
    //   61	161	3	localObject	Object
    //   160	33	4	localazsb	azsb
    // Exception table:
    //   from	to	target	type
    //   178	198	223	javax/xml/parsers/ParserConfigurationException
    //   206	221	223	javax/xml/parsers/ParserConfigurationException
    //   83	141	242	java/io/UnsupportedEncodingException
    //   178	198	284	org/xml/sax/SAXException
    //   206	221	284	org/xml/sax/SAXException
    //   178	198	304	java/io/IOException
    //   206	221	304	java/io/IOException
    //   178	198	324	java/lang/Exception
    //   206	221	324	java/lang/Exception
  }
  
  public static StructMsgForGeneralShare a()
  {
    return new StructMsgForGeneralShare();
  }
  
  public static String a(azsa paramazsa)
  {
    if (paramazsa.jdField_a_of_type_Int == 3) {}
    Object localObject;
    for (paramazsa = paramazsa.jdField_a_of_type_JavaLangString;; paramazsa = ((StringBuilder)localObject).toString())
    {
      localObject = paramazsa;
      if (paramazsa == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      int j = paramazsa.a();
      int i = 0;
      if (i < j)
      {
        azsa localazsa = paramazsa.a(i);
        if (localazsa == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localazsa.jdField_a_of_type_Int == 3) {
            ((StringBuilder)localObject).append(localazsa.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public static final String a(String paramString)
  {
    Object localObject = System.getProperty("java.vm.version");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        bool = a((String)localObject, "2.0.0", ".");
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "java vm version  = " + (String)localObject + " isART = " + bool);
        }
        localObject = aekt.a().append(paramString);
        i = 0;
        k = 0;
        if (i < paramString.length())
        {
          int i1 = paramString.charAt(i);
          m = i;
          j = k;
          switch (i1)
          {
          default: 
            if (((i1 < 32) || (i1 > 55295)) && ((i1 < 57344) || (i1 > 65533))) {
              continue;
            }
            n = 1;
            if (!bool) {
              continue;
            }
            m = i;
            j = k;
            if (n == 0)
            {
              ((StringBuilder)localObject).deleteCharAt(i - k);
              k += 1;
              m = i;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("StructMsg", 2, " ContainInvalidCharacter return null ,invalid char  = " + Integer.toHexString(i1));
                j = k;
                m = i;
              }
            }
            break;
          }
          i = m + 1;
          k = j;
          continue;
        }
      }
      catch (Exception localException)
      {
        int i;
        int k;
        bool = false;
        continue;
        int n = 0;
        continue;
        int m = i;
        int j = k;
        if (n != 0) {
          continue;
        }
        n = paramString.codePointAt(i);
        if (bahu.a.get(n, -1) >= 0)
        {
          m = i;
          j = k;
          if (n <= 65535) {
            continue;
          }
          m = i + 1;
          j = k;
          continue;
        }
        ((StringBuilder)localObject).deleteCharAt(i - k);
        j = k + 1;
        m = i;
        continue;
      }
      return ((StringBuilder)localObject).toString();
      boolean bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.contains("serviceID=\"83\"")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = Pattern.compile(paramString3, 16).split(paramString1);
        paramString2 = Pattern.compile(paramString3, 16).split(paramString2);
        int m = Math.max(paramString1.length, paramString2.length);
        int i = 0;
        label49:
        if (i < m)
        {
          int j;
          if (paramString1.length > i)
          {
            j = Integer.parseInt(paramString1[i]);
            label69:
            if (paramString2.length <= i) {
              break label103;
            }
          }
          label103:
          for (int k = Integer.parseInt(paramString2[i]); j >= k; k = 0)
          {
            i += 1;
            break label49;
            j = 0;
            break label69;
          }
        }
        return true;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqu
 * JD-Core Version:    0.7.0.1
 */