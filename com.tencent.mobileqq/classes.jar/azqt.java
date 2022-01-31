import android.util.SparseArray;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.HashMap;

public class azqt
{
  private static final SparseArray<Class<? extends azqk>> jdField_a_of_type_AndroidUtilSparseArray;
  private static HashMap<String, Class<? extends azqj>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("pavideo", azux.class);
    jdField_a_of_type_JavaUtilHashMap.put("video", azvm.class);
    jdField_a_of_type_JavaUtilHashMap.put("picture", azsm.class);
    jdField_a_of_type_JavaUtilHashMap.put("title", StructMsgItemTitle.class);
    jdField_a_of_type_JavaUtilHashMap.put("summary", azvd.class);
    jdField_a_of_type_JavaUtilHashMap.put("timer", azvh.class);
    jdField_a_of_type_JavaUtilHashMap.put("hr", azso.class);
    jdField_a_of_type_JavaUtilHashMap.put("image", azsp.class);
    jdField_a_of_type_JavaUtilHashMap.put("more", azur.class);
    jdField_a_of_type_JavaUtilHashMap.put("progress", azvb.class);
    jdField_a_of_type_JavaUtilHashMap.put("checklist", azvv.class);
    jdField_a_of_type_JavaUtilHashMap.put("vote", azvx.class);
    jdField_a_of_type_JavaUtilHashMap.put("price", azva.class);
    jdField_a_of_type_JavaUtilHashMap.put("button", azsg.class);
    jdField_a_of_type_JavaUtilHashMap.put("remark", azvc.class);
    jdField_a_of_type_JavaUtilHashMap.put("paaudio", azus.class);
    jdField_a_of_type_JavaUtilHashMap.put("textButton", azvf.class);
    jdField_a_of_type_JavaUtilHashMap.put("content", azsl.class);
    jdField_a_of_type_JavaUtilHashMap.put("tips", azry.class);
    jdField_a_of_type_JavaUtilHashMap.put("live", azrs.class);
    jdField_a_of_type_JavaUtilHashMap.put("tr", azvk.class);
    jdField_a_of_type_JavaUtilHashMap.put("td", azve.class);
    jdField_a_of_type_JavaUtilHashMap.put("head", azsf.class);
    jdField_a_of_type_JavaUtilHashMap.put("type", azvl.class);
    jdField_a_of_type_JavaUtilHashMap.put("tag", azrw.class);
    jdField_a_of_type_JavaUtilHashMap.put("taglist", azrx.class);
    jdField_a_of_type_JavaUtilHashMap.put("group", azrm.class);
    jdField_a_of_type_JavaUtilHashMap.put("groupitem", azro.class);
    jdField_a_of_type_JavaUtilHashMap.put("voice", azrz.class);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.append(0, azui.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(1, azsq.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(2, aztc.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(3, aztw.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(4, aztz.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(5, azua.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(6, azuc.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(7, azue.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(8, azug.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(9, azuh.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(10, azsr.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(11, azst.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(12, azsv.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(18, azsz.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(19, aztb.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(20, aztd.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(21, aztg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(22, azth.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(23, azti.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(24, aztk.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(25, aztn.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(26, azto.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(27, aztp.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(28, aztq.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(29, aztt.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(30, aztx.class);
  }
  
  public static azqj a(String paramString)
  {
    return a(paramString, 0);
  }
  
  /* Error */
  public static azqj a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 210
    //   2: aload_0
    //   3: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +72 -> 78
    //   9: getstatic 18	azqt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 220	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 222	java/lang/Class
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +421 -> 442
    //   24: aload_2
    //   25: invokevirtual 226	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   28: checkcast 228	azqj
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull +59 -> 92
    //   36: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +37 -> 76
    //   42: ldc 236
    //   44: iconst_2
    //   45: new 238	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   52: ldc 241
    //   54: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 246
    //   63: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_3
    //   77: areturn
    //   78: getstatic 143	azqt:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   81: iload_1
    //   82: invokevirtual 260	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   85: checkcast 222	java/lang/Class
    //   88: astore_2
    //   89: goto -69 -> 20
    //   92: aload_3
    //   93: ifnonnull -17 -> 76
    //   96: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -23 -> 76
    //   102: ldc 236
    //   104: iconst_2
    //   105: new 238	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 262
    //   115: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   122: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 267
    //   128: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_3
    //   138: areturn
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnonnull +45 -> 188
    //   146: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +291 -> 440
    //   152: ldc 236
    //   154: iconst_2
    //   155: new 238	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   162: ldc 241
    //   164: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 246
    //   173: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_1
    //   177: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aconst_null
    //   187: areturn
    //   188: iconst_0
    //   189: ifne +251 -> 440
    //   192: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +245 -> 440
    //   198: ldc 236
    //   200: iconst_2
    //   201: new 238	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 262
    //   211: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   218: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 267
    //   224: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnonnull +45 -> 284
    //   242: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +195 -> 440
    //   248: ldc 236
    //   250: iconst_2
    //   251: new 238	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   258: ldc 241
    //   260: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 246
    //   269: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload_1
    //   273: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aconst_null
    //   283: areturn
    //   284: iconst_0
    //   285: ifne +155 -> 440
    //   288: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +149 -> 440
    //   294: ldc 236
    //   296: iconst_2
    //   297: new 238	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 262
    //   307: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_2
    //   311: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   314: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 267
    //   320: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aconst_null
    //   330: areturn
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_2
    //   335: ifnonnull +45 -> 380
    //   338: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +37 -> 378
    //   344: ldc 236
    //   346: iconst_2
    //   347: new 238	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   354: ldc 241
    //   356: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_0
    //   360: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc 246
    //   365: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload_1
    //   369: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_3
    //   379: athrow
    //   380: iconst_0
    //   381: ifne -3 -> 378
    //   384: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -9 -> 378
    //   390: ldc 236
    //   392: iconst_2
    //   393: new 238	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 262
    //   403: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   410: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 267
    //   416: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: goto -47 -> 378
    //   428: astore_3
    //   429: goto -95 -> 334
    //   432: astore_3
    //   433: goto -195 -> 238
    //   436: astore_3
    //   437: goto -295 -> 142
    //   440: aconst_null
    //   441: areturn
    //   442: aconst_null
    //   443: astore_3
    //   444: goto -412 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramString	String
    //   0	447	1	paramInt	int
    //   19	100	2	localClass	Class
    //   139	1	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   141	74	2	localObject1	Object
    //   235	1	2	localInstantiationException1	java.lang.InstantiationException
    //   237	170	2	localObject2	Object
    //   31	107	3	localazqj	azqj
    //   331	48	3	localObject3	Object
    //   428	1	3	localObject4	Object
    //   432	1	3	localInstantiationException2	java.lang.InstantiationException
    //   436	1	3	localIllegalAccessException2	java.lang.IllegalAccessException
    //   443	1	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	20	139	java/lang/IllegalAccessException
    //   78	89	139	java/lang/IllegalAccessException
    //   0	20	235	java/lang/InstantiationException
    //   78	89	235	java/lang/InstantiationException
    //   0	20	331	finally
    //   78	89	331	finally
    //   24	32	428	finally
    //   24	32	432	java/lang/InstantiationException
    //   24	32	436	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static azqk a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 143	azqt:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 260	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 222	java/lang/Class
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +359 -> 371
    //   15: aload_2
    //   16: invokevirtual 226	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   19: checkcast 270	azqk
    //   22: astore_1
    //   23: aload_2
    //   24: ifnonnull +37 -> 61
    //   27: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +339 -> 369
    //   33: ldc 236
    //   35: iconst_2
    //   36: new 238	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 272
    //   46: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_0
    //   50: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: areturn
    //   61: aload_1
    //   62: ifnonnull +307 -> 369
    //   65: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +301 -> 369
    //   71: ldc 236
    //   73: iconst_2
    //   74: new 238	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 262
    //   84: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   91: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 267
    //   97: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aload_2
    //   110: ifnonnull +37 -> 147
    //   113: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +251 -> 367
    //   119: ldc 236
    //   121: iconst_2
    //   122: new 238	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 272
    //   132: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_0
    //   136: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aconst_null
    //   146: areturn
    //   147: iconst_0
    //   148: ifne +219 -> 367
    //   151: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +213 -> 367
    //   157: ldc 236
    //   159: iconst_2
    //   160: new 238	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 262
    //   170: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   177: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 267
    //   183: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aload_2
    //   196: ifnonnull +37 -> 233
    //   199: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +165 -> 367
    //   205: ldc 236
    //   207: iconst_2
    //   208: new 238	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 272
    //   218: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_0
    //   222: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aconst_null
    //   232: areturn
    //   233: iconst_0
    //   234: ifne +133 -> 367
    //   237: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +127 -> 367
    //   243: ldc 236
    //   245: iconst_2
    //   246: new 238	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 262
    //   256: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_2
    //   260: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   263: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 267
    //   269: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_1
    //   281: aload_2
    //   282: ifnonnull +37 -> 319
    //   285: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +29 -> 317
    //   291: ldc 236
    //   293: iconst_2
    //   294: new 238	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 272
    //   304: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload_0
    //   308: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_1
    //   318: athrow
    //   319: iconst_0
    //   320: ifne -3 -> 317
    //   323: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -9 -> 317
    //   329: ldc 236
    //   331: iconst_2
    //   332: new 238	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 262
    //   342: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_2
    //   346: invokevirtual 265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   349: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 267
    //   355: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: goto -47 -> 317
    //   367: aconst_null
    //   368: areturn
    //   369: aload_1
    //   370: areturn
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -350 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramInt	int
    //   22	85	1	localazqk1	azqk
    //   108	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   194	1	1	localInstantiationException	java.lang.InstantiationException
    //   280	90	1	localazqk2	azqk
    //   372	1	1	localObject	Object
    //   10	336	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   15	23	108	java/lang/IllegalAccessException
    //   15	23	194	java/lang/InstantiationException
    //   15	23	280	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqt
 * JD-Core Version:    0.7.0.1
 */