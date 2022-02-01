import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bdzc
  implements INetInfoHandler
{
  private static final String c = anhk.cu + "longMsgList.ini";
  private static final String d = anhk.cu + "longMsgList.tmp";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bdzc()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this);
    d();
    b();
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("^http://((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(:(\\d{1,4}|[1-5]\\d\\d\\d\\d|6[0-4]\\d\\d\\d|65[0-4]\\d\\d|655[0-2]\\d|6553[0-5]))?/$").matcher(paramString).matches();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_2
    //   8: astore_1
    //   9: getstatic 36	bdzc:c	Ljava/lang/String;
    //   12: invokestatic 88	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   15: astore 5
    //   17: aload_2
    //   18: astore_1
    //   19: aload 5
    //   21: invokevirtual 94	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne +40 -> 66
    //   29: aload_2
    //   30: astore_1
    //   31: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +13 -> 47
    //   37: aload_2
    //   38: astore_1
    //   39: ldc 101
    //   41: iconst_2
    //   42: ldc 103
    //   44: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 108	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 109	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: aload_2
    //   67: astore_1
    //   68: new 114	java/io/BufferedReader
    //   71: dup
    //   72: new 116	java/io/InputStreamReader
    //   75: dup
    //   76: new 118	java/io/FileInputStream
    //   79: dup
    //   80: aload 5
    //   82: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   88: invokespecial 127	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   91: astore_2
    //   92: aload_0
    //   93: aload_2
    //   94: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: putfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: aload_0
    //   101: aload_2
    //   102: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: putfield 134	bdzc:b	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: ifnull +14 -> 126
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: invokespecial 136	bdzc:a	(Ljava/lang/String;)Z
    //   123: ifne +8 -> 131
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: aload_0
    //   132: getfield 134	bdzc:b	Ljava/lang/String;
    //   135: ifnull +14 -> 149
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 134	bdzc:b	Ljava/lang/String;
    //   143: invokespecial 136	bdzc:a	(Ljava/lang/String;)Z
    //   146: ifne +8 -> 154
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield 134	bdzc:b	Ljava/lang/String;
    //   154: aload_2
    //   155: ifnull -96 -> 59
    //   158: aload_2
    //   159: invokevirtual 139	java/io/BufferedReader:close	()V
    //   162: return
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   168: return
    //   169: astore_1
    //   170: aload_3
    //   171: astore_2
    //   172: aload_1
    //   173: astore_3
    //   174: aload_2
    //   175: astore_1
    //   176: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +13 -> 192
    //   182: aload_2
    //   183: astore_1
    //   184: ldc 101
    //   186: iconst_2
    //   187: ldc 141
    //   189: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: invokevirtual 142	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull -140 -> 59
    //   202: aload_2
    //   203: invokevirtual 139	java/io/BufferedReader:close	()V
    //   206: return
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   212: return
    //   213: astore_3
    //   214: aload 4
    //   216: astore_2
    //   217: aload_2
    //   218: astore_1
    //   219: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +13 -> 235
    //   225: aload_2
    //   226: astore_1
    //   227: ldc 101
    //   229: iconst_2
    //   230: ldc 144
    //   232: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_3
    //   238: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   241: aload_2
    //   242: ifnull -183 -> 59
    //   245: aload_2
    //   246: invokevirtual 139	java/io/BufferedReader:close	()V
    //   249: return
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   255: return
    //   256: astore_3
    //   257: aload_1
    //   258: astore_2
    //   259: aload_3
    //   260: astore_1
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 139	java/io/BufferedReader:close	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   276: goto -7 -> 269
    //   279: astore_1
    //   280: goto -19 -> 261
    //   283: astore_3
    //   284: goto -67 -> 217
    //   287: astore_3
    //   288: goto -114 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	bdzc
    //   8	31	1	localObject1	Object
    //   60	2	1	localIOException1	java.io.IOException
    //   67	1	1	localObject2	Object
    //   163	2	1	localIOException2	java.io.IOException
    //   169	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   175	19	1	localObject3	Object
    //   207	2	1	localIOException3	java.io.IOException
    //   218	19	1	localObject4	Object
    //   250	8	1	localIOException4	java.io.IOException
    //   260	10	1	localObject5	Object
    //   279	1	1	localObject6	Object
    //   4	262	2	localObject7	Object
    //   271	2	2	localIOException5	java.io.IOException
    //   6	189	3	localObject8	Object
    //   213	25	3	localException1	java.lang.Exception
    //   256	4	3	localObject9	Object
    //   283	1	3	localException2	java.lang.Exception
    //   287	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	214	4	localObject10	Object
    //   15	66	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   51	59	60	java/io/IOException
    //   158	162	163	java/io/IOException
    //   9	17	169	java/io/FileNotFoundException
    //   19	29	169	java/io/FileNotFoundException
    //   31	37	169	java/io/FileNotFoundException
    //   39	47	169	java/io/FileNotFoundException
    //   68	92	169	java/io/FileNotFoundException
    //   202	206	207	java/io/IOException
    //   9	17	213	java/lang/Exception
    //   19	29	213	java/lang/Exception
    //   31	37	213	java/lang/Exception
    //   39	47	213	java/lang/Exception
    //   68	92	213	java/lang/Exception
    //   245	249	250	java/io/IOException
    //   9	17	256	finally
    //   19	29	256	finally
    //   31	37	256	finally
    //   39	47	256	finally
    //   68	92	256	finally
    //   176	182	256	finally
    //   184	192	256	finally
    //   194	198	256	finally
    //   219	225	256	finally
    //   227	235	256	finally
    //   237	241	256	finally
    //   265	269	271	java/io/IOException
    //   92	126	279	finally
    //   126	131	279	finally
    //   131	149	279	finally
    //   149	154	279	finally
    //   92	126	283	java/lang/Exception
    //   126	131	283	java/lang/Exception
    //   131	149	283	java/lang/Exception
    //   149	154	283	java/lang/Exception
    //   92	126	287	java/io/FileNotFoundException
    //   126	131	287	java/io/FileNotFoundException
    //   131	149	287	java/io/FileNotFoundException
    //   149	154	287	java/io/FileNotFoundException
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_2
    //   10: astore_1
    //   11: getstatic 36	bdzc:c	Ljava/lang/String;
    //   14: invokestatic 88	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   17: astore 5
    //   19: aload_2
    //   20: astore_1
    //   21: aload 5
    //   23: invokevirtual 148	java/io/File:exists	()Z
    //   26: ifeq +11 -> 37
    //   29: aload_2
    //   30: astore_1
    //   31: aload 5
    //   33: invokevirtual 151	java/io/File:delete	()Z
    //   36: pop
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: ifnonnull +52 -> 95
    //   46: aload_2
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 134	bdzc:b	Ljava/lang/String;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnonnull +39 -> 95
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 108	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 109	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   79: goto -8 -> 71
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   92: goto -21 -> 71
    //   95: aload_2
    //   96: astore_1
    //   97: getstatic 40	bdzc:d	Ljava/lang/String;
    //   100: invokestatic 88	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   103: astore 6
    //   105: aload_2
    //   106: astore_1
    //   107: aload 6
    //   109: invokevirtual 148	java/io/File:exists	()Z
    //   112: ifeq +11 -> 123
    //   115: aload_2
    //   116: astore_1
    //   117: aload 6
    //   119: invokevirtual 151	java/io/File:delete	()Z
    //   122: pop
    //   123: aload_2
    //   124: astore_1
    //   125: aload 6
    //   127: invokevirtual 154	java/io/File:createNewFile	()Z
    //   130: pop
    //   131: aload_2
    //   132: astore_1
    //   133: new 156	java/io/BufferedWriter
    //   136: dup
    //   137: new 158	java/io/OutputStreamWriter
    //   140: dup
    //   141: new 160	java/io/FileOutputStream
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: invokespecial 164	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   153: invokespecial 167	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   156: astore_2
    //   157: aload_0
    //   158: getfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: ifnull +77 -> 238
    //   164: aload_0
    //   165: getfield 132	bdzc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: astore_1
    //   169: aload_2
    //   170: aload_1
    //   171: invokevirtual 171	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   174: aload_2
    //   175: ldc 173
    //   177: invokevirtual 171	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 134	bdzc:b	Ljava/lang/String;
    //   184: ifnull +60 -> 244
    //   187: aload_0
    //   188: getfield 134	bdzc:b	Ljava/lang/String;
    //   191: astore_1
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual 171	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   197: aload_2
    //   198: invokevirtual 176	java/io/BufferedWriter:flush	()V
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 177	java/io/BufferedWriter:close	()V
    //   209: aload 6
    //   211: ifnull -140 -> 71
    //   214: aload 5
    //   216: ifnull -145 -> 71
    //   219: aload 6
    //   221: aload 5
    //   223: invokevirtual 181	java/io/File:renameTo	(Ljava/io/File;)Z
    //   226: pop
    //   227: goto -156 -> 71
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   235: goto -164 -> 71
    //   238: ldc 183
    //   240: astore_1
    //   241: goto -72 -> 169
    //   244: ldc 183
    //   246: astore_1
    //   247: goto -55 -> 192
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   255: goto -184 -> 71
    //   258: astore_1
    //   259: aload_3
    //   260: astore_2
    //   261: aload_1
    //   262: astore_3
    //   263: aload_2
    //   264: astore_1
    //   265: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +13 -> 281
    //   271: aload_2
    //   272: astore_1
    //   273: ldc 101
    //   275: iconst_2
    //   276: ldc 141
    //   278: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_2
    //   282: astore_1
    //   283: aload_3
    //   284: invokevirtual 142	java/io/FileNotFoundException:printStackTrace	()V
    //   287: aload_2
    //   288: ifnull -217 -> 71
    //   291: aload_2
    //   292: invokevirtual 177	java/io/BufferedWriter:close	()V
    //   295: goto -224 -> 71
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   303: goto -232 -> 71
    //   306: astore_1
    //   307: aload_1
    //   308: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   311: goto -240 -> 71
    //   314: astore_3
    //   315: aload 4
    //   317: astore_2
    //   318: aload_2
    //   319: astore_1
    //   320: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +13 -> 336
    //   326: aload_2
    //   327: astore_1
    //   328: ldc 101
    //   330: iconst_2
    //   331: ldc 144
    //   333: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_2
    //   337: astore_1
    //   338: aload_3
    //   339: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   342: aload_2
    //   343: ifnull -272 -> 71
    //   346: aload_2
    //   347: invokevirtual 177	java/io/BufferedWriter:close	()V
    //   350: goto -279 -> 71
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   358: goto -287 -> 71
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   366: goto -295 -> 71
    //   369: astore_3
    //   370: aload_1
    //   371: astore_2
    //   372: aload_3
    //   373: astore_1
    //   374: aload_2
    //   375: ifnull +7 -> 382
    //   378: aload_2
    //   379: invokevirtual 177	java/io/BufferedWriter:close	()V
    //   382: aload_1
    //   383: athrow
    //   384: astore_2
    //   385: aload_2
    //   386: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   389: goto -7 -> 382
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   397: goto -15 -> 382
    //   400: astore_1
    //   401: goto -27 -> 374
    //   404: astore_3
    //   405: goto -87 -> 318
    //   408: astore_3
    //   409: goto -146 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	bdzc
    //   10	38	1	localObject1	Object
    //   74	2	1	localIOException1	java.io.IOException
    //   82	4	1	localObject2	Object
    //   87	2	1	localException1	java.lang.Exception
    //   96	98	1	localObject3	Object
    //   230	2	1	localIOException2	java.io.IOException
    //   240	7	1	str	String
    //   250	2	1	localException2	java.lang.Exception
    //   258	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   264	19	1	localObject4	Object
    //   298	2	1	localIOException3	java.io.IOException
    //   306	2	1	localException3	java.lang.Exception
    //   319	19	1	localObject5	Object
    //   353	2	1	localIOException4	java.io.IOException
    //   361	10	1	localException4	java.lang.Exception
    //   373	10	1	localObject6	Object
    //   400	1	1	localObject7	Object
    //   6	373	2	localObject8	Object
    //   384	2	2	localIOException5	java.io.IOException
    //   392	2	2	localException5	java.lang.Exception
    //   8	276	3	localObject9	Object
    //   314	25	3	localException6	java.lang.Exception
    //   369	4	3	localObject10	Object
    //   404	1	3	localException7	java.lang.Exception
    //   408	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   3	313	4	localObject11	Object
    //   17	205	5	localFile	java.io.File
    //   52	168	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   63	71	74	java/io/IOException
    //   63	71	82	finally
    //   75	79	82	finally
    //   88	92	82	finally
    //   205	209	82	finally
    //   219	227	82	finally
    //   231	235	82	finally
    //   251	255	82	finally
    //   291	295	82	finally
    //   299	303	82	finally
    //   307	311	82	finally
    //   346	350	82	finally
    //   354	358	82	finally
    //   362	366	82	finally
    //   378	382	82	finally
    //   382	384	82	finally
    //   385	389	82	finally
    //   393	397	82	finally
    //   63	71	87	java/lang/Exception
    //   205	209	230	java/io/IOException
    //   219	227	230	java/io/IOException
    //   205	209	250	java/lang/Exception
    //   219	227	250	java/lang/Exception
    //   11	19	258	java/io/FileNotFoundException
    //   21	29	258	java/io/FileNotFoundException
    //   31	37	258	java/io/FileNotFoundException
    //   39	46	258	java/io/FileNotFoundException
    //   48	54	258	java/io/FileNotFoundException
    //   97	105	258	java/io/FileNotFoundException
    //   107	115	258	java/io/FileNotFoundException
    //   117	123	258	java/io/FileNotFoundException
    //   125	131	258	java/io/FileNotFoundException
    //   133	157	258	java/io/FileNotFoundException
    //   291	295	298	java/io/IOException
    //   291	295	306	java/lang/Exception
    //   11	19	314	java/lang/Exception
    //   21	29	314	java/lang/Exception
    //   31	37	314	java/lang/Exception
    //   39	46	314	java/lang/Exception
    //   48	54	314	java/lang/Exception
    //   97	105	314	java/lang/Exception
    //   107	115	314	java/lang/Exception
    //   117	123	314	java/lang/Exception
    //   125	131	314	java/lang/Exception
    //   133	157	314	java/lang/Exception
    //   346	350	353	java/io/IOException
    //   346	350	361	java/lang/Exception
    //   11	19	369	finally
    //   21	29	369	finally
    //   31	37	369	finally
    //   39	46	369	finally
    //   48	54	369	finally
    //   97	105	369	finally
    //   107	115	369	finally
    //   117	123	369	finally
    //   125	131	369	finally
    //   133	157	369	finally
    //   265	271	369	finally
    //   273	281	369	finally
    //   283	287	369	finally
    //   320	326	369	finally
    //   328	336	369	finally
    //   338	342	369	finally
    //   378	382	384	java/io/IOException
    //   378	382	392	java/lang/Exception
    //   157	169	400	finally
    //   169	192	400	finally
    //   192	201	400	finally
    //   157	169	404	java/lang/Exception
    //   169	192	404	java/lang/Exception
    //   192	201	404	java/lang/Exception
    //   157	169	408	java/io/FileNotFoundException
    //   169	192	408	java/io/FileNotFoundException
    //   192	201	408	java/io/FileNotFoundException
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        int i = bgnt.b(BaseApplicationImpl.getContext());
        switch (i)
        {
        default: 
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_Int = 2;
      continue;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return this.b;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void a(bdyf parambdyf)
  {
    if (parambdyf == null) {}
    int j;
    do
    {
      return;
      j = 0;
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("http://").append(parambdyf.jdField_a_of_type_JavaLangString);
      if (parambdyf.jdField_a_of_type_Int != 80) {
        localStringBuilder.append(":").append(parambdyf.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
      parambdyf = localStringBuilder.toString();
      int i = j;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        i = j;
        if (this.jdField_a_of_type_JavaLangString.equals(parambdyf))
        {
          this.jdField_a_of_type_JavaLangString = null;
          i = 1;
        }
      }
      j = i;
      if (this.b != null)
      {
        j = i;
        if (this.b.equals(parambdyf))
        {
          this.b = null;
          j = 1;
        }
      }
    } while (j == 0);
    c();
  }
  
  public void b(bdyf parambdyf)
  {
    if ((parambdyf != null) && (this.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("http://").append(parambdyf.jdField_a_of_type_JavaLangString);
      if (parambdyf.jdField_a_of_type_Int != 80) {
        localStringBuilder.append(":").append(parambdyf.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
      parambdyf = localStringBuilder.toString();
      if (this.jdField_a_of_type_Int != 1) {
        break label89;
      }
      this.b = parambdyf;
    }
    for (;;)
    {
      c();
      return;
      label89:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_JavaLangString = parambdyf;
      }
    }
  }
  
  public void onNetMobile2None()
  {
    try
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Int = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Int = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzc
 * JD-Core Version:    0.7.0.1
 */