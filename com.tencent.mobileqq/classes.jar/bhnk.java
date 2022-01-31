import android.text.TextUtils;
import android.util.Base64;
import com.tencent.util.Pair;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;

final class bhnk
{
  private bhnl jdField_a_of_type_Bhnl;
  private File jdField_a_of_type_JavaIoFile;
  
  public bhnk(File paramFile, bhnl parambhnl)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Bhnl = parambhnl;
  }
  
  private Pair<String, bhoe> a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      String str = paramXmlPullParser.getAttributeValue(null, "Key");
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      bhoe localbhoe = new bhoe();
      localbhoe.jdField_a_of_type_Int = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "AttrType"));
      localbhoe.b = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Category"));
      localbhoe.c = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "SubCategory"));
      localbhoe.d = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Action"));
      localbhoe.jdField_a_of_type_Long = Long.parseLong(paramXmlPullParser.getAttributeValue(null, "ExpireTime"));
      paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "ExtraInfo");
      if (!TextUtils.isEmpty(paramXmlPullParser)) {
        localbhoe.jdField_a_of_type_ArrayOfByte = Base64.decode(paramXmlPullParser, 0);
      }
      paramXmlPullParser = new Pair(str, localbhoe);
      return paramXmlPullParser;
    }
    catch (Exception paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 99	javax/crypto/spec/IvParameterSpec
    //   3: dup
    //   4: invokestatic 104	bhng:a	()[B
    //   7: invokespecial 107	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   10: astore 5
    //   12: new 109	javax/crypto/spec/SecretKeySpec
    //   15: dup
    //   16: invokestatic 111	bhng:b	()[B
    //   19: ldc 113
    //   21: invokespecial 116	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   24: astore 6
    //   26: ldc 118
    //   28: invokestatic 124	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   31: astore 7
    //   33: aload 7
    //   35: iconst_2
    //   36: aload 6
    //   38: aload 5
    //   40: invokevirtual 128	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   43: new 130	javax/crypto/CipherInputStream
    //   46: dup
    //   47: new 132	java/io/BufferedInputStream
    //   50: dup
    //   51: new 134	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 14	bhnk:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   59: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 140	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: aload 7
    //   67: invokespecial 143	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   70: astore 7
    //   72: invokestatic 149	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   75: astore 8
    //   77: aload 8
    //   79: aload 7
    //   81: ldc 151
    //   83: invokeinterface 155 3 0
    //   88: aload 8
    //   90: invokeinterface 159 1 0
    //   95: istore_3
    //   96: iconst_0
    //   97: istore_1
    //   98: aconst_null
    //   99: astore 5
    //   101: iload_3
    //   102: iconst_1
    //   103: if_icmpeq +46 -> 149
    //   106: iload_3
    //   107: iconst_2
    //   108: if_icmpne +116 -> 224
    //   111: aload 8
    //   113: invokeinterface 163 1 0
    //   118: astore 6
    //   120: aload 6
    //   122: ldc 165
    //   124: invokevirtual 171	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   127: ifeq +72 -> 199
    //   130: aload 8
    //   132: aconst_null
    //   133: ldc 173
    //   135: invokeinterface 28 3 0
    //   140: invokestatic 45	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: istore_1
    //   144: iload_1
    //   145: iconst_1
    //   146: if_icmpeq +28 -> 174
    //   149: aload 7
    //   151: ifnull +8 -> 159
    //   154: aload 7
    //   156: invokevirtual 178	java/io/InputStream:close	()V
    //   159: aload_0
    //   160: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   163: ifnull +10 -> 173
    //   166: aload_0
    //   167: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   170: invokevirtual 182	bhnl:a	()V
    //   173: return
    //   174: iconst_1
    //   175: istore_1
    //   176: iload_1
    //   177: istore_2
    //   178: aload 5
    //   180: astore 6
    //   182: aload 8
    //   184: invokeinterface 185 1 0
    //   189: istore_3
    //   190: aload 6
    //   192: astore 5
    //   194: iload_2
    //   195: istore_1
    //   196: goto -95 -> 101
    //   199: iload_1
    //   200: ifeq +240 -> 440
    //   203: aload 6
    //   205: ldc 187
    //   207: invokevirtual 171	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   210: ifeq +230 -> 440
    //   213: aload_0
    //   214: aload 8
    //   216: invokespecial 189	bhnk:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/tencent/util/Pair;
    //   219: astore 5
    //   221: goto -45 -> 176
    //   224: aload 5
    //   226: astore 6
    //   228: iload_1
    //   229: istore_2
    //   230: iload_3
    //   231: iconst_3
    //   232: if_icmpne -50 -> 182
    //   235: aload 5
    //   237: astore 6
    //   239: iload_1
    //   240: istore_2
    //   241: ldc 187
    //   243: aload 8
    //   245: invokeinterface 163 1 0
    //   250: invokevirtual 171	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   253: ifeq -71 -> 182
    //   256: aload 5
    //   258: astore 6
    //   260: iload_1
    //   261: istore_2
    //   262: aload 5
    //   264: ifnull -82 -> 182
    //   267: aload_0
    //   268: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   271: ifnull +33 -> 304
    //   274: aload_0
    //   275: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   278: aload 5
    //   280: getfield 193	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   283: checkcast 167	java/lang/String
    //   286: aload 5
    //   288: getfield 196	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   291: checkcast 36	bhoe
    //   294: invokevirtual 199	bhnl:a	(Ljava/lang/String;Lbhoe;)Z
    //   297: istore 4
    //   299: iload 4
    //   301: ifeq -152 -> 149
    //   304: aconst_null
    //   305: astore 6
    //   307: iload_1
    //   308: istore_2
    //   309: goto -127 -> 182
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   319: goto -160 -> 159
    //   322: astore 6
    //   324: aconst_null
    //   325: astore 5
    //   327: aload 6
    //   329: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   332: aload 5
    //   334: ifnull +8 -> 342
    //   337: aload 5
    //   339: invokevirtual 178	java/io/InputStream:close	()V
    //   342: aload_0
    //   343: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   346: ifnull -173 -> 173
    //   349: aload_0
    //   350: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   353: invokevirtual 182	bhnl:a	()V
    //   356: return
    //   357: astore 5
    //   359: aload 5
    //   361: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   364: goto -22 -> 342
    //   367: astore 5
    //   369: aconst_null
    //   370: astore 6
    //   372: aload 6
    //   374: ifnull +8 -> 382
    //   377: aload 6
    //   379: invokevirtual 178	java/io/InputStream:close	()V
    //   382: aload_0
    //   383: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   386: ifnull +10 -> 396
    //   389: aload_0
    //   390: getfield 16	bhnk:jdField_a_of_type_Bhnl	Lbhnl;
    //   393: invokevirtual 182	bhnl:a	()V
    //   396: aload 5
    //   398: athrow
    //   399: astore 6
    //   401: aload 6
    //   403: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   406: goto -24 -> 382
    //   409: astore 5
    //   411: aload 7
    //   413: astore 6
    //   415: goto -43 -> 372
    //   418: astore 7
    //   420: aload 5
    //   422: astore 6
    //   424: aload 7
    //   426: astore 5
    //   428: goto -56 -> 372
    //   431: astore 6
    //   433: aload 7
    //   435: astore 5
    //   437: goto -110 -> 327
    //   440: goto -264 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	bhnk
    //   97	211	1	i	int
    //   177	132	2	j	int
    //   95	138	3	k	int
    //   297	3	4	bool	boolean
    //   10	277	5	localObject1	Object
    //   312	3	5	localIOException1	java.io.IOException
    //   325	13	5	localObject2	Object
    //   357	3	5	localIOException2	java.io.IOException
    //   367	30	5	localObject3	Object
    //   409	12	5	localObject4	Object
    //   426	10	5	localObject5	Object
    //   24	282	6	localObject6	Object
    //   322	6	6	localException1	Exception
    //   370	8	6	localObject7	Object
    //   399	3	6	localIOException3	java.io.IOException
    //   413	10	6	localObject8	Object
    //   431	1	6	localException2	Exception
    //   31	381	7	localObject9	Object
    //   418	16	7	localObject10	Object
    //   75	169	8	localXmlPullParser	XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   154	159	312	java/io/IOException
    //   0	72	322	java/lang/Exception
    //   337	342	357	java/io/IOException
    //   0	72	367	finally
    //   377	382	399	java/io/IOException
    //   72	96	409	finally
    //   111	144	409	finally
    //   182	190	409	finally
    //   203	221	409	finally
    //   241	256	409	finally
    //   267	299	409	finally
    //   327	332	418	finally
    //   72	96	431	java/lang/Exception
    //   111	144	431	java/lang/Exception
    //   182	190	431	java/lang/Exception
    //   203	221	431	java/lang/Exception
    //   241	256	431	java/lang/Exception
    //   267	299	431	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnk
 * JD-Core Version:    0.7.0.1
 */