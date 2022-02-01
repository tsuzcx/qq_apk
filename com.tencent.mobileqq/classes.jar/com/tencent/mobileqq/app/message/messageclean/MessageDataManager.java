package com.tencent.mobileqq.app.message.messageclean;

import android.database.Cursor;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.Cursor2EntityConvert;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.Class<+Lcom.tencent.mobileqq.persistence.Entity;>;
import java.util.ArrayList;
import java.util.List;

public class MessageDataManager
{
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  private IMessageDataListener jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener;
  private Cursor2EntityConvert jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert;
  
  private ArrayList<String> a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ((str.endsWith("_New")) && ((str.startsWith("mr_friend_")) || (str.startsWith("mr_troop_")) || (str.startsWith("mr_discusssion_")))) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(String paramString, List<? extends Entity> paramList)
  {
    IMessageDataListener localIMessageDataListener = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener;
    if (localIMessageDataListener != null) {
      localIMessageDataListener.a(paramString, paramList);
    }
  }
  
  public AppInterface a()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: ldc 68
    //   7: astore 4
    //   9: iload_2
    //   10: ifeq +6 -> 16
    //   13: ldc 68
    //   15: areturn
    //   16: aconst_null
    //   17: astore 7
    //   19: aconst_null
    //   20: astore 6
    //   22: aload 6
    //   24: astore 5
    //   26: aload 7
    //   28: astore_3
    //   29: new 70	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   36: astore 8
    //   38: aload 6
    //   40: astore 5
    //   42: aload 7
    //   44: astore_3
    //   45: aload 8
    //   47: ldc 73
    //   49: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: astore 5
    //   57: aload 7
    //   59: astore_3
    //   60: aload 8
    //   62: aload_0
    //   63: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   66: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   69: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 6
    //   78: astore 5
    //   80: aload 7
    //   82: astore_3
    //   83: aload 8
    //   85: ldc 92
    //   87: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: astore 5
    //   95: aload 7
    //   97: astore_3
    //   98: aload 8
    //   100: aload_1
    //   101: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: astore 5
    //   109: aload 7
    //   111: astore_3
    //   112: aload 8
    //   114: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   120: astore_1
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: astore_3
    //   128: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   134: aload_1
    //   135: iconst_1
    //   136: anewarray 21	java/lang/String
    //   139: dup
    //   140: iconst_0
    //   141: ldc 115
    //   143: aastore
    //   144: aconst_null
    //   145: aconst_null
    //   146: aconst_null
    //   147: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore 6
    //   152: aload 4
    //   154: astore_1
    //   155: aload 6
    //   157: ifnull +91 -> 248
    //   160: aload 4
    //   162: astore_1
    //   163: aload 6
    //   165: astore 5
    //   167: aload 6
    //   169: astore_3
    //   170: aload 6
    //   172: invokeinterface 127 1 0
    //   177: ifeq +71 -> 248
    //   180: aload 6
    //   182: astore 5
    //   184: aload 6
    //   186: astore_3
    //   187: aload 6
    //   189: aload 6
    //   191: ldc 115
    //   193: invokeinterface 131 2 0
    //   198: invokeinterface 135 2 0
    //   203: astore 7
    //   205: aload 4
    //   207: astore_1
    //   208: aload 6
    //   210: astore 5
    //   212: aload 6
    //   214: astore_3
    //   215: aload 7
    //   217: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +28 -> 248
    //   223: aload 6
    //   225: astore 5
    //   227: aload 6
    //   229: astore_3
    //   230: new 21	java/lang/String
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 139	java/lang/String:getBytes	()[B
    //   239: ldc 141
    //   241: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   244: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore_1
    //   248: aload_1
    //   249: astore 5
    //   251: aload 6
    //   253: ifnull +99 -> 352
    //   256: aload 6
    //   258: astore_3
    //   259: aload_3
    //   260: invokeinterface 152 1 0
    //   265: aload_1
    //   266: areturn
    //   267: astore_1
    //   268: goto +87 -> 355
    //   271: astore_1
    //   272: aload_3
    //   273: astore 5
    //   275: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +53 -> 331
    //   281: aload_3
    //   282: astore 5
    //   284: new 70	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   291: astore 6
    //   293: aload_3
    //   294: astore 5
    //   296: aload 6
    //   298: ldc 159
    //   300: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_3
    //   305: astore 5
    //   307: aload 6
    //   309: aload_1
    //   310: invokevirtual 162	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_3
    //   318: astore 5
    //   320: ldc 164
    //   322: iconst_2
    //   323: aload 6
    //   325: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_3
    //   332: astore 5
    //   334: aload_1
    //   335: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   338: aload 4
    //   340: astore 5
    //   342: aload_3
    //   343: ifnull +9 -> 352
    //   346: aload 4
    //   348: astore_1
    //   349: goto -90 -> 259
    //   352: aload 5
    //   354: areturn
    //   355: aload 5
    //   357: ifnull +10 -> 367
    //   360: aload 5
    //   362: invokeinterface 152 1 0
    //   367: goto +5 -> 372
    //   370: aload_1
    //   371: athrow
    //   372: goto -2 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	MessageDataManager
    //   0	375	1	paramString	String
    //   4	6	2	bool	boolean
    //   28	315	3	localObject1	Object
    //   7	340	4	str1	String
    //   24	337	5	localObject2	Object
    //   20	304	6	localObject3	Object
    //   17	218	7	str2	String
    //   36	77	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	38	267	finally
    //   45	53	267	finally
    //   60	76	267	finally
    //   83	91	267	finally
    //   98	105	267	finally
    //   112	121	267	finally
    //   128	152	267	finally
    //   170	180	267	finally
    //   187	205	267	finally
    //   215	223	267	finally
    //   230	248	267	finally
    //   275	281	267	finally
    //   284	293	267	finally
    //   296	304	267	finally
    //   307	317	267	finally
    //   320	331	267	finally
    //   334	338	267	finally
    //   29	38	271	java/lang/Throwable
    //   45	53	271	java/lang/Throwable
    //   60	76	271	java/lang/Throwable
    //   83	91	271	java/lang/Throwable
    //   98	105	271	java/lang/Throwable
    //   112	121	271	java/lang/Throwable
    //   128	152	271	java/lang/Throwable
    //   170	180	271	java/lang/Throwable
    //   187	205	271	java/lang/Throwable
    //   215	223	271	java/lang/Throwable
    //   230	248	271	java/lang/Throwable
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: ldc 68
    //   7: astore 5
    //   9: iload_3
    //   10: ifne +467 -> 477
    //   13: aload_2
    //   14: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +6 -> 23
    //   20: ldc 68
    //   22: areturn
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 7
    //   29: aload 7
    //   31: astore 6
    //   33: aload 8
    //   35: astore 4
    //   37: new 70	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   44: astore 9
    //   46: aload 7
    //   48: astore 6
    //   50: aload 8
    //   52: astore 4
    //   54: aload 9
    //   56: ldc 174
    //   58: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: astore 6
    //   66: aload 8
    //   68: astore 4
    //   70: aload 9
    //   72: aload_0
    //   73: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   76: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   79: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 7
    //   88: astore 6
    //   90: aload 8
    //   92: astore 4
    //   94: aload 9
    //   96: ldc 92
    //   98: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 7
    //   104: astore 6
    //   106: aload 8
    //   108: astore 4
    //   110: aload 9
    //   112: aload_1
    //   113: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 7
    //   119: astore 6
    //   121: aload 8
    //   123: astore 4
    //   125: aload 9
    //   127: ldc 92
    //   129: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 7
    //   135: astore 6
    //   137: aload 8
    //   139: astore 4
    //   141: aload 9
    //   143: aload_2
    //   144: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: astore 4
    //   156: aload 9
    //   158: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   164: astore_1
    //   165: aload 7
    //   167: astore 6
    //   169: aload 8
    //   171: astore 4
    //   173: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   176: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   179: aload_1
    //   180: iconst_2
    //   181: anewarray 21	java/lang/String
    //   184: dup
    //   185: iconst_0
    //   186: ldc 176
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: ldc 178
    //   193: aastore
    //   194: aconst_null
    //   195: aconst_null
    //   196: aconst_null
    //   197: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   200: astore_2
    //   201: aload 5
    //   203: astore_1
    //   204: aload_2
    //   205: ifnull +149 -> 354
    //   208: aload 5
    //   210: astore_1
    //   211: aload_2
    //   212: astore 6
    //   214: aload_2
    //   215: astore 4
    //   217: aload_2
    //   218: invokeinterface 127 1 0
    //   223: ifeq +131 -> 354
    //   226: aload_2
    //   227: astore 6
    //   229: aload_2
    //   230: astore 4
    //   232: aload_2
    //   233: aload_2
    //   234: ldc 178
    //   236: invokeinterface 131 2 0
    //   241: invokeinterface 135 2 0
    //   246: astore_1
    //   247: aload_2
    //   248: astore 6
    //   250: aload_2
    //   251: astore 4
    //   253: aload_1
    //   254: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: istore_3
    //   258: iload_3
    //   259: ifne +29 -> 288
    //   262: aload_2
    //   263: astore 6
    //   265: aload_2
    //   266: astore 4
    //   268: new 21	java/lang/String
    //   271: dup
    //   272: aload_1
    //   273: invokevirtual 139	java/lang/String:getBytes	()[B
    //   276: ldc 141
    //   278: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   281: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_1
    //   285: goto +195 -> 480
    //   288: aload_2
    //   289: astore 6
    //   291: aload_2
    //   292: astore 4
    //   294: aload_2
    //   295: aload_2
    //   296: ldc 176
    //   298: invokeinterface 131 2 0
    //   303: invokeinterface 135 2 0
    //   308: astore 7
    //   310: aload 5
    //   312: astore_1
    //   313: aload_2
    //   314: astore 6
    //   316: aload_2
    //   317: astore 4
    //   319: aload 7
    //   321: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifne +30 -> 354
    //   327: aload_2
    //   328: astore 6
    //   330: aload_2
    //   331: astore 4
    //   333: new 21	java/lang/String
    //   336: dup
    //   337: aload 7
    //   339: invokevirtual 139	java/lang/String:getBytes	()[B
    //   342: ldc 141
    //   344: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   347: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   350: astore_1
    //   351: goto +129 -> 480
    //   354: aload_1
    //   355: astore 6
    //   357: aload_2
    //   358: ifnull +102 -> 460
    //   361: aload_2
    //   362: invokeinterface 152 1 0
    //   367: aload_1
    //   368: areturn
    //   369: astore_1
    //   370: goto +93 -> 463
    //   373: astore_1
    //   374: aload 4
    //   376: astore 6
    //   378: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +53 -> 434
    //   384: aload 4
    //   386: astore 6
    //   388: new 70	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   395: astore_2
    //   396: aload 4
    //   398: astore 6
    //   400: aload_2
    //   401: ldc 180
    //   403: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: astore 6
    //   411: aload_2
    //   412: aload_1
    //   413: invokevirtual 162	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 4
    //   422: astore 6
    //   424: ldc 164
    //   426: iconst_2
    //   427: aload_2
    //   428: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload 4
    //   436: astore 6
    //   438: aload_1
    //   439: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   442: aload 5
    //   444: astore 6
    //   446: aload 4
    //   448: ifnull +12 -> 460
    //   451: aload 5
    //   453: astore_1
    //   454: aload 4
    //   456: astore_2
    //   457: goto -96 -> 361
    //   460: aload 6
    //   462: areturn
    //   463: aload 6
    //   465: ifnull +10 -> 475
    //   468: aload 6
    //   470: invokeinterface 152 1 0
    //   475: aload_1
    //   476: athrow
    //   477: ldc 68
    //   479: areturn
    //   480: goto -126 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	MessageDataManager
    //   0	483	1	paramString1	String
    //   0	483	2	paramString2	String
    //   4	255	3	bool	boolean
    //   35	420	4	localObject1	Object
    //   7	445	5	str1	String
    //   31	438	6	localObject2	Object
    //   27	311	7	str2	String
    //   24	146	8	localObject3	Object
    //   44	113	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	46	369	finally
    //   54	62	369	finally
    //   70	86	369	finally
    //   94	102	369	finally
    //   110	117	369	finally
    //   125	133	369	finally
    //   141	148	369	finally
    //   156	165	369	finally
    //   173	201	369	finally
    //   217	226	369	finally
    //   232	247	369	finally
    //   253	258	369	finally
    //   268	285	369	finally
    //   294	310	369	finally
    //   319	327	369	finally
    //   333	351	369	finally
    //   378	384	369	finally
    //   388	396	369	finally
    //   400	407	369	finally
    //   411	420	369	finally
    //   424	434	369	finally
    //   438	442	369	finally
    //   37	46	373	java/lang/Throwable
    //   54	62	373	java/lang/Throwable
    //   70	86	373	java/lang/Throwable
    //   94	102	373	java/lang/Throwable
    //   110	117	373	java/lang/Throwable
    //   125	133	373	java/lang/Throwable
    //   141	148	373	java/lang/Throwable
    //   156	165	373	java/lang/Throwable
    //   173	201	373	java/lang/Throwable
    //   217	226	373	java/lang/Throwable
    //   232	247	373	java/lang/Throwable
    //   253	258	373	java/lang/Throwable
    //   268	285	373	java/lang/Throwable
    //   294	310	373	java/lang/Throwable
    //   319	327	373	java/lang/Throwable
    //   333	351	373	java/lang/Throwable
  }
  
  public ArrayList<String> a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageTableNames");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
    if (localObject != null) {
      try
      {
        localObject = a(((PeakAppInterface)localObject).getReadableDatabase().getAllTableNameFromDB());
        return localObject;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMessageTableNames exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("MessageDataManager", 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  protected List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, int paramInt)
  {
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
    Object localObject3 = null;
    localObject2 = null;
    Object localObject1 = localObject3;
    if (localObject4 != null) {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert == null) {
            this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert = new Cursor2EntityConvert();
          }
          localObject1 = localObject3;
          if (paramCursor != null)
          {
            localObject1 = localObject3;
            if (paramCursor.moveToFirst())
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert.a(paramClass, paramString, paramCursor);
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener.a(paramString, (Entity)localObject1);
              }
              localObject1 = localObject3;
              if (paramCursor.moveToFirst())
              {
                paramInt = paramCursor.getCount();
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("cursor2List tableName = ");
                  ((StringBuilder)localObject1).append(paramString);
                  ((StringBuilder)localObject1).append("， count = ");
                  ((StringBuilder)localObject1).append(paramInt);
                  QLog.e("MessageDataManager", 2, ((StringBuilder)localObject1).toString());
                }
                localObject2 = null;
                localObject4 = localObject2;
                j = paramInt;
                localObject1 = localObject2;
                try
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert != null)
                  {
                    localObject1 = localObject2;
                    localObject4 = this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert.a(paramClass, paramString, paramCursor);
                    localObject3 = localObject2;
                    i = paramInt;
                    if (localObject4 != null)
                    {
                      localObject3 = localObject2;
                      i = paramInt;
                      if (localObject2 == null)
                      {
                        i = paramInt;
                        if (paramInt > 1000) {
                          i = 1000;
                        }
                        localObject1 = localObject2;
                      }
                    }
                  }
                }
                catch (Exception paramString)
                {
                  boolean bool;
                  paramClass = (Class<? extends Entity>)localObject1;
                }
              }
            }
          }
        }
        catch (Exception paramString)
        {
          paramClass = (Class<? extends Entity>)localObject2;
        }
        try
        {
          localObject3 = new ArrayList(i);
          localObject1 = localObject3;
          ((List)localObject3).add(localObject4);
          localObject4 = localObject3;
          j = i;
          if (localObject3 != null)
          {
            localObject4 = localObject3;
            j = i;
            localObject1 = localObject3;
            if (((List)localObject3).size() == 1000)
            {
              localObject4 = localObject3;
              j = i;
              localObject1 = localObject3;
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener != null)
              {
                localObject1 = localObject3;
                if (QLog.isColorLevel())
                {
                  localObject1 = localObject3;
                  localObject2 = new StringBuilder();
                  localObject1 = localObject3;
                  ((StringBuilder)localObject2).append("notifyMessageData = ");
                  localObject1 = localObject3;
                  ((StringBuilder)localObject2).append(paramString);
                  localObject1 = localObject3;
                  QLog.e("MessageDataManager", 2, ((StringBuilder)localObject2).toString());
                }
                localObject1 = localObject3;
                a(paramString, (List)localObject3);
                localObject1 = localObject3;
                ((List)localObject3).clear();
                localObject4 = null;
                j = i;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = localObject2;
          j = i;
          continue;
        }
        localObject1 = localObject4;
        bool = paramCursor.moveToNext();
        localObject2 = localObject4;
        paramInt = j;
        if (!bool)
        {
          return localObject4;
          localObject1 = paramClass;
          if (QLog.isColorLevel())
          {
            QLog.e("MessageDataManager", 2, MsfSdkUtils.getStackTraceString(paramString));
            localObject1 = paramClass;
          }
        }
      }
    }
    return localObject1;
  }
  
  public List<MessageRecord> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    paramClass = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if ((paramClass != null) && (!paramClass.isEmpty())) {
      return paramClass;
    }
    return null;
  }
  
  /* Error */
  public List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 11
    //   18: aload 9
    //   20: astore 7
    //   22: aload 12
    //   24: ifnull +242 -> 266
    //   27: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +39 -> 69
    //   33: new 70	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   40: astore 7
    //   42: aload 7
    //   44: ldc_w 258
    //   47: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: aload_2
    //   54: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 164
    //   60: iconst_2
    //   61: aload 7
    //   63: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iload 6
    //   71: iconst_1
    //   72: if_icmpne +15 -> 87
    //   75: aload_0
    //   76: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   79: invokevirtual 189	com/tencent/mobileqq/app/PeakAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   82: astore 7
    //   84: goto +18 -> 102
    //   87: iload 6
    //   89: iconst_2
    //   90: if_icmpne +78 -> 168
    //   93: aload_0
    //   94: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   97: invokevirtual 260	com/tencent/mobileqq/app/PeakAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   100: astore 7
    //   102: aload 7
    //   104: aload_2
    //   105: aload_3
    //   106: aload 4
    //   108: aload 5
    //   110: invokevirtual 264	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 4
    //   115: aload 11
    //   117: astore_2
    //   118: aload 4
    //   120: ifnull +29 -> 149
    //   123: aload 4
    //   125: astore_2
    //   126: aload_0
    //   127: aload_1
    //   128: aload_3
    //   129: aload 4
    //   131: iload 6
    //   133: invokevirtual 266	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;I)Ljava/util/List;
    //   136: astore_1
    //   137: aload_1
    //   138: astore_2
    //   139: goto +10 -> 149
    //   142: astore_3
    //   143: aload 4
    //   145: astore_1
    //   146: goto +73 -> 219
    //   149: aload_2
    //   150: astore 7
    //   152: aload 4
    //   154: ifnull +112 -> 266
    //   157: aload 4
    //   159: astore_1
    //   160: aload_1
    //   161: invokeinterface 152 1 0
    //   166: aload_2
    //   167: areturn
    //   168: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +36 -> 207
    //   174: new 70	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   181: astore_1
    //   182: aload_1
    //   183: ldc_w 268
    //   186: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: iload 6
    //   193: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 164
    //   199: iconst_2
    //   200: aload_1
    //   201: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_1
    //   210: aload 10
    //   212: astore_2
    //   213: goto +41 -> 254
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: astore_2
    //   221: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +15 -> 239
    //   227: aload_1
    //   228: astore_2
    //   229: ldc 164
    //   231: iconst_2
    //   232: aload_3
    //   233: invokestatic 248	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   236: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 9
    //   241: astore 7
    //   243: aload_1
    //   244: ifnull +22 -> 266
    //   247: aload 8
    //   249: astore_2
    //   250: goto -90 -> 160
    //   253: astore_1
    //   254: aload_2
    //   255: ifnull +9 -> 264
    //   258: aload_2
    //   259: invokeinterface 152 1 0
    //   264: aload_1
    //   265: athrow
    //   266: aload 7
    //   268: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	MessageDataManager
    //   0	269	1	paramClass	Class<? extends Entity>
    //   0	269	2	paramString1	String
    //   0	269	3	paramString2	String
    //   0	269	4	paramString3	String
    //   0	269	5	paramArrayOfString	String[]
    //   0	269	6	paramInt	int
    //   20	247	7	localObject1	Object
    //   7	241	8	localObject2	Object
    //   13	227	9	localObject3	Object
    //   10	201	10	localObject4	Object
    //   16	100	11	localObject5	Object
    //   4	19	12	localPeakAppInterface	PeakAppInterface
    // Exception table:
    //   from	to	target	type
    //   126	137	142	java/lang/Exception
    //   27	69	209	finally
    //   75	84	209	finally
    //   93	102	209	finally
    //   102	115	209	finally
    //   168	207	209	finally
    //   27	69	216	java/lang/Exception
    //   75	84	216	java/lang/Exception
    //   93	102	216	java/lang/Exception
    //   102	115	216	java/lang/Exception
    //   168	207	216	java/lang/Exception
    //   126	137	253	finally
    //   221	227	253	finally
    //   229	239	253	finally
  }
  
  public List<RecentUser> a(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    PeakAppInterface localPeakAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
    if (localPeakAppInterface != null)
    {
      paramClass = localPeakAppInterface.a().rawQuery(paramClass, paramString, paramArrayOfString);
      if ((paramClass != null) && (!paramClass.isEmpty())) {
        return paramClass;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MessageDataManager", 2, "getRecentUserList list is empty");
      }
    }
    return null;
  }
  
  public void a()
  {
    a(null);
    Cursor2EntityConvert localCursor2EntityConvert = this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert;
    if (localCursor2EntityConvert != null)
    {
      localCursor2EntityConvert.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceCursor2EntityConvert = null;
    }
  }
  
  /* Error */
  public void a(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 10
    //   8: aconst_null
    //   9: astore 9
    //   11: aload 9
    //   13: astore 8
    //   15: aload 10
    //   17: astore 7
    //   19: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   25: astore 11
    //   27: aload 9
    //   29: astore 8
    //   31: aload 10
    //   33: astore 7
    //   35: new 70	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   42: astore 12
    //   44: aload 9
    //   46: astore 8
    //   48: aload 10
    //   50: astore 7
    //   52: aload 12
    //   54: ldc_w 288
    //   57: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 9
    //   63: astore 8
    //   65: aload 10
    //   67: astore 7
    //   69: aload 12
    //   71: aload_0
    //   72: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   75: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   78: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: astore 8
    //   89: aload 10
    //   91: astore 7
    //   93: aload 11
    //   95: aload 12
    //   97: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   103: iconst_3
    //   104: anewarray 21	java/lang/String
    //   107: dup
    //   108: iconst_0
    //   109: ldc_w 290
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc_w 292
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: ldc_w 294
    //   124: aastore
    //   125: aconst_null
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore 9
    //   133: aload 9
    //   135: ifnull +502 -> 637
    //   138: aload 9
    //   140: astore 8
    //   142: aload 9
    //   144: astore 7
    //   146: aload 9
    //   148: invokeinterface 127 1 0
    //   153: ifeq +484 -> 637
    //   156: aload 9
    //   158: astore 8
    //   160: aload 9
    //   162: astore 7
    //   164: aload 9
    //   166: ldc_w 290
    //   169: invokeinterface 131 2 0
    //   174: istore_3
    //   175: aload 9
    //   177: astore 8
    //   179: aload 9
    //   181: astore 7
    //   183: aload 9
    //   185: ldc_w 292
    //   188: invokeinterface 131 2 0
    //   193: istore 4
    //   195: aload 9
    //   197: astore 8
    //   199: aload 9
    //   201: astore 7
    //   203: aload 9
    //   205: ldc_w 294
    //   208: invokeinterface 131 2 0
    //   213: istore 5
    //   215: aload 9
    //   217: astore 8
    //   219: aload 9
    //   221: astore 7
    //   223: aload 9
    //   225: iload_3
    //   226: invokeinterface 135 2 0
    //   231: astore 10
    //   233: aload 9
    //   235: astore 8
    //   237: aload 9
    //   239: astore 7
    //   241: aload 10
    //   243: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifeq +6 -> 252
    //   249: goto +366 -> 615
    //   252: aload 9
    //   254: astore 8
    //   256: aload 9
    //   258: astore 7
    //   260: new 21	java/lang/String
    //   263: dup
    //   264: aload 10
    //   266: invokevirtual 139	java/lang/String:getBytes	()[B
    //   269: ldc 141
    //   271: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   274: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore 12
    //   279: aload 9
    //   281: astore 8
    //   283: aload 9
    //   285: astore 7
    //   287: aload 9
    //   289: iload 4
    //   291: invokeinterface 135 2 0
    //   296: astore 10
    //   298: aload 9
    //   300: astore 8
    //   302: aload 9
    //   304: astore 7
    //   306: aload 10
    //   308: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +101 -> 412
    //   314: aload 9
    //   316: astore 8
    //   318: aload 9
    //   320: astore 7
    //   322: new 21	java/lang/String
    //   325: dup
    //   326: aload 10
    //   328: invokevirtual 139	java/lang/String:getBytes	()[B
    //   331: ldc 141
    //   333: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   336: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 10
    //   341: aload 9
    //   343: astore 8
    //   345: aload 9
    //   347: astore 7
    //   349: new 70	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   356: astore 11
    //   358: aload 9
    //   360: astore 8
    //   362: aload 9
    //   364: astore 7
    //   366: aload 11
    //   368: aload 12
    //   370: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 9
    //   376: astore 8
    //   378: aload 9
    //   380: astore 7
    //   382: aload 11
    //   384: iload_1
    //   385: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 9
    //   391: astore 8
    //   393: aload 9
    //   395: astore 7
    //   397: aload_2
    //   398: aload 11
    //   400: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: aload 10
    //   405: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   408: pop
    //   409: goto +206 -> 615
    //   412: aload 9
    //   414: astore 8
    //   416: aload 9
    //   418: astore 7
    //   420: aload 9
    //   422: iload 5
    //   424: invokeinterface 135 2 0
    //   429: astore 10
    //   431: aload 9
    //   433: astore 8
    //   435: aload 9
    //   437: astore 7
    //   439: aload 10
    //   441: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   444: ifne +171 -> 615
    //   447: aload 9
    //   449: astore 8
    //   451: aload 9
    //   453: astore 7
    //   455: new 21	java/lang/String
    //   458: dup
    //   459: aload 10
    //   461: invokevirtual 139	java/lang/String:getBytes	()[B
    //   464: ldc 141
    //   466: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   469: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore 11
    //   474: aload 11
    //   476: astore 10
    //   478: aload 9
    //   480: astore 8
    //   482: aload 9
    //   484: astore 7
    //   486: aload 11
    //   488: invokevirtual 303	java/lang/String:length	()I
    //   491: iconst_1
    //   492: if_icmple +55 -> 547
    //   495: aload 11
    //   497: astore 10
    //   499: aload 9
    //   501: astore 8
    //   503: aload 9
    //   505: astore 7
    //   507: aload 11
    //   509: aload 11
    //   511: invokevirtual 303	java/lang/String:length	()I
    //   514: iconst_1
    //   515: isub
    //   516: invokevirtual 307	java/lang/String:charAt	(I)C
    //   519: bipush 10
    //   521: if_icmpne +26 -> 547
    //   524: aload 9
    //   526: astore 8
    //   528: aload 9
    //   530: astore 7
    //   532: aload 11
    //   534: iconst_0
    //   535: aload 11
    //   537: invokevirtual 303	java/lang/String:length	()I
    //   540: iconst_1
    //   541: isub
    //   542: invokevirtual 311	java/lang/String:substring	(II)Ljava/lang/String;
    //   545: astore 10
    //   547: aload 9
    //   549: astore 8
    //   551: aload 9
    //   553: astore 7
    //   555: new 70	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   562: astore 11
    //   564: aload 9
    //   566: astore 8
    //   568: aload 9
    //   570: astore 7
    //   572: aload 11
    //   574: aload 12
    //   576: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 9
    //   582: astore 8
    //   584: aload 9
    //   586: astore 7
    //   588: aload 11
    //   590: iload_1
    //   591: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 9
    //   597: astore 8
    //   599: aload 9
    //   601: astore 7
    //   603: aload_2
    //   604: aload 11
    //   606: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: aload 10
    //   611: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   614: pop
    //   615: aload 9
    //   617: astore 8
    //   619: aload 9
    //   621: astore 7
    //   623: aload 9
    //   625: invokeinterface 242 1 0
    //   630: istore 6
    //   632: iload 6
    //   634: ifne -419 -> 215
    //   637: aload 9
    //   639: ifnull +100 -> 739
    //   642: aload 9
    //   644: astore 7
    //   646: goto +86 -> 732
    //   649: astore_2
    //   650: goto +90 -> 740
    //   653: astore_2
    //   654: aload 7
    //   656: astore 8
    //   658: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +58 -> 719
    //   664: aload 7
    //   666: astore 8
    //   668: new 70	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   675: astore 9
    //   677: aload 7
    //   679: astore 8
    //   681: aload 9
    //   683: ldc_w 313
    //   686: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload 7
    //   692: astore 8
    //   694: aload 9
    //   696: aload_2
    //   697: invokevirtual 162	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   700: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 7
    //   706: astore 8
    //   708: ldc 164
    //   710: iconst_2
    //   711: aload 9
    //   713: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   719: aload 7
    //   721: astore 8
    //   723: aload_2
    //   724: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   727: aload 7
    //   729: ifnull +10 -> 739
    //   732: aload 7
    //   734: invokeinterface 152 1 0
    //   739: return
    //   740: aload 8
    //   742: ifnull +10 -> 752
    //   745: aload 8
    //   747: invokeinterface 152 1 0
    //   752: goto +5 -> 757
    //   755: aload_2
    //   756: athrow
    //   757: goto -2 -> 755
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	MessageDataManager
    //   0	760	1	paramInt	int
    //   0	760	2	paramHashMap	java.util.HashMap<String, String>
    //   174	52	3	i	int
    //   193	97	4	j	int
    //   213	210	5	k	int
    //   630	3	6	bool	boolean
    //   17	716	7	localObject1	Object
    //   13	733	8	localObject2	Object
    //   9	703	9	localObject3	Object
    //   6	604	10	localObject4	Object
    //   25	580	11	localObject5	Object
    //   42	533	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	649	finally
    //   35	44	649	finally
    //   52	61	649	finally
    //   69	85	649	finally
    //   93	133	649	finally
    //   146	156	649	finally
    //   164	175	649	finally
    //   183	195	649	finally
    //   203	215	649	finally
    //   223	233	649	finally
    //   241	249	649	finally
    //   260	279	649	finally
    //   287	298	649	finally
    //   306	314	649	finally
    //   322	341	649	finally
    //   349	358	649	finally
    //   366	374	649	finally
    //   382	389	649	finally
    //   397	409	649	finally
    //   420	431	649	finally
    //   439	447	649	finally
    //   455	474	649	finally
    //   486	495	649	finally
    //   507	524	649	finally
    //   532	547	649	finally
    //   555	564	649	finally
    //   572	580	649	finally
    //   588	595	649	finally
    //   603	615	649	finally
    //   623	632	649	finally
    //   658	664	649	finally
    //   668	677	649	finally
    //   681	690	649	finally
    //   694	704	649	finally
    //   708	719	649	finally
    //   723	727	649	finally
    //   19	27	653	java/lang/Throwable
    //   35	44	653	java/lang/Throwable
    //   52	61	653	java/lang/Throwable
    //   69	85	653	java/lang/Throwable
    //   93	133	653	java/lang/Throwable
    //   146	156	653	java/lang/Throwable
    //   164	175	653	java/lang/Throwable
    //   183	195	653	java/lang/Throwable
    //   203	215	653	java/lang/Throwable
    //   223	233	653	java/lang/Throwable
    //   241	249	653	java/lang/Throwable
    //   260	279	653	java/lang/Throwable
    //   287	298	653	java/lang/Throwable
    //   306	314	653	java/lang/Throwable
    //   322	341	653	java/lang/Throwable
    //   349	358	653	java/lang/Throwable
    //   366	374	653	java/lang/Throwable
    //   382	389	653	java/lang/Throwable
    //   397	409	653	java/lang/Throwable
    //   420	431	653	java/lang/Throwable
    //   439	447	653	java/lang/Throwable
    //   455	474	653	java/lang/Throwable
    //   486	495	653	java/lang/Throwable
    //   507	524	653	java/lang/Throwable
    //   532	547	653	java/lang/Throwable
    //   555	564	653	java/lang/Throwable
    //   572	580	653	java/lang/Throwable
    //   588	595	653	java/lang/Throwable
    //   603	615	653	java/lang/Throwable
    //   623	632	653	java/lang/Throwable
  }
  
  public void a(IMessageDataListener paramIMessageDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageDataListener = paramIMessageDataListener;
  }
  
  public ArrayList<String> b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableNames");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
    if (localObject != null) {
      try
      {
        localObject = a(((PeakAppInterface)localObject).a().getAllTableNameFromDB());
        return localObject;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMessageSlowTableNames exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("MessageDataManager", 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  public List<MessageRecord> b(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableRecord");
    }
    paramClass = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 2);
    if ((paramClass != null) && (!paramClass.isEmpty())) {
      return paramClass;
    }
    return null;
  }
  
  /* Error */
  public void b(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 8
    //   11: aload 8
    //   13: astore 7
    //   15: aload 9
    //   17: astore 6
    //   19: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   25: astore 10
    //   27: aload 8
    //   29: astore 7
    //   31: aload 9
    //   33: astore 6
    //   35: new 70	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   42: astore 11
    //   44: aload 8
    //   46: astore 7
    //   48: aload 9
    //   50: astore 6
    //   52: aload 11
    //   54: ldc_w 323
    //   57: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: astore 7
    //   65: aload 9
    //   67: astore 6
    //   69: aload 11
    //   71: aload_0
    //   72: getfield 57	com/tencent/mobileqq/app/message/messageclean/MessageDataManager:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   75: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   78: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 8
    //   87: astore 7
    //   89: aload 9
    //   91: astore 6
    //   93: aload 10
    //   95: aload 11
    //   97: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   103: iconst_2
    //   104: anewarray 21	java/lang/String
    //   107: dup
    //   108: iconst_0
    //   109: ldc_w 325
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc_w 327
    //   118: aastore
    //   119: aconst_null
    //   120: aconst_null
    //   121: aconst_null
    //   122: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   125: astore 8
    //   127: aload 8
    //   129: ifnull +276 -> 405
    //   132: aload 8
    //   134: astore 7
    //   136: aload 8
    //   138: astore 6
    //   140: aload 8
    //   142: invokeinterface 127 1 0
    //   147: ifeq +258 -> 405
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: astore 6
    //   158: aload 8
    //   160: ldc_w 325
    //   163: invokeinterface 131 2 0
    //   168: istore_3
    //   169: aload 8
    //   171: astore 7
    //   173: aload 8
    //   175: astore 6
    //   177: aload 8
    //   179: ldc_w 327
    //   182: invokeinterface 131 2 0
    //   187: istore 4
    //   189: aload 8
    //   191: astore 7
    //   193: aload 8
    //   195: astore 6
    //   197: aload 8
    //   199: iload_3
    //   200: invokeinterface 135 2 0
    //   205: astore 9
    //   207: aload 8
    //   209: astore 7
    //   211: aload 8
    //   213: astore 6
    //   215: aload 9
    //   217: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +6 -> 226
    //   223: goto +160 -> 383
    //   226: aload 8
    //   228: astore 7
    //   230: aload 8
    //   232: astore 6
    //   234: new 21	java/lang/String
    //   237: dup
    //   238: aload 9
    //   240: invokevirtual 139	java/lang/String:getBytes	()[B
    //   243: ldc 141
    //   245: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   248: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 9
    //   253: aload 8
    //   255: astore 7
    //   257: aload 8
    //   259: astore 6
    //   261: aload 8
    //   263: iload 4
    //   265: invokeinterface 135 2 0
    //   270: astore 10
    //   272: aload 8
    //   274: astore 7
    //   276: aload 8
    //   278: astore 6
    //   280: aload 10
    //   282: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifne +98 -> 383
    //   288: aload 8
    //   290: astore 7
    //   292: aload 8
    //   294: astore 6
    //   296: new 21	java/lang/String
    //   299: dup
    //   300: aload 10
    //   302: invokevirtual 139	java/lang/String:getBytes	()[B
    //   305: ldc 141
    //   307: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   310: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 10
    //   315: aload 8
    //   317: astore 7
    //   319: aload 8
    //   321: astore 6
    //   323: new 70	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   330: astore 11
    //   332: aload 8
    //   334: astore 7
    //   336: aload 8
    //   338: astore 6
    //   340: aload 11
    //   342: aload 9
    //   344: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 8
    //   350: astore 7
    //   352: aload 8
    //   354: astore 6
    //   356: aload 11
    //   358: iload_1
    //   359: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 8
    //   365: astore 7
    //   367: aload 8
    //   369: astore 6
    //   371: aload_2
    //   372: aload 11
    //   374: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: aload 10
    //   379: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload 8
    //   385: astore 7
    //   387: aload 8
    //   389: astore 6
    //   391: aload 8
    //   393: invokeinterface 242 1 0
    //   398: istore 5
    //   400: iload 5
    //   402: ifne -213 -> 189
    //   405: aload 8
    //   407: ifnull +100 -> 507
    //   410: aload 8
    //   412: astore 6
    //   414: goto +86 -> 500
    //   417: astore_2
    //   418: goto +90 -> 508
    //   421: astore_2
    //   422: aload 6
    //   424: astore 7
    //   426: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +58 -> 487
    //   432: aload 6
    //   434: astore 7
    //   436: new 70	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   443: astore 8
    //   445: aload 6
    //   447: astore 7
    //   449: aload 8
    //   451: ldc_w 329
    //   454: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 6
    //   460: astore 7
    //   462: aload 8
    //   464: aload_2
    //   465: invokevirtual 162	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 6
    //   474: astore 7
    //   476: ldc 164
    //   478: iconst_2
    //   479: aload 8
    //   481: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload 6
    //   489: astore 7
    //   491: aload_2
    //   492: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   495: aload 6
    //   497: ifnull +10 -> 507
    //   500: aload 6
    //   502: invokeinterface 152 1 0
    //   507: return
    //   508: aload 7
    //   510: ifnull +10 -> 520
    //   513: aload 7
    //   515: invokeinterface 152 1 0
    //   520: goto +5 -> 525
    //   523: aload_2
    //   524: athrow
    //   525: goto -2 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	MessageDataManager
    //   0	528	1	paramInt	int
    //   0	528	2	paramHashMap	java.util.HashMap<String, String>
    //   168	32	3	i	int
    //   187	77	4	j	int
    //   398	3	5	bool	boolean
    //   17	484	6	localObject1	Object
    //   13	501	7	localObject2	Object
    //   9	471	8	localObject3	Object
    //   6	337	9	str	String
    //   25	353	10	localObject4	Object
    //   42	331	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	27	417	finally
    //   35	44	417	finally
    //   52	61	417	finally
    //   69	85	417	finally
    //   93	127	417	finally
    //   140	150	417	finally
    //   158	169	417	finally
    //   177	189	417	finally
    //   197	207	417	finally
    //   215	223	417	finally
    //   234	253	417	finally
    //   261	272	417	finally
    //   280	288	417	finally
    //   296	315	417	finally
    //   323	332	417	finally
    //   340	348	417	finally
    //   356	363	417	finally
    //   371	383	417	finally
    //   391	400	417	finally
    //   426	432	417	finally
    //   436	445	417	finally
    //   449	458	417	finally
    //   462	472	417	finally
    //   476	487	417	finally
    //   491	495	417	finally
    //   19	27	421	java/lang/Throwable
    //   35	44	421	java/lang/Throwable
    //   52	61	421	java/lang/Throwable
    //   69	85	421	java/lang/Throwable
    //   93	127	421	java/lang/Throwable
    //   140	150	421	java/lang/Throwable
    //   158	169	421	java/lang/Throwable
    //   177	189	421	java/lang/Throwable
    //   197	207	421	java/lang/Throwable
    //   215	223	421	java/lang/Throwable
    //   234	253	421	java/lang/Throwable
    //   261	272	421	java/lang/Throwable
    //   280	288	421	java/lang/Throwable
    //   296	315	421	java/lang/Throwable
    //   323	332	421	java/lang/Throwable
    //   340	348	421	java/lang/Throwable
    //   356	363	421	java/lang/Throwable
    //   371	383	421	java/lang/Throwable
    //   391	400	421	java/lang/Throwable
  }
  
  public List<MessageRecord> c(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMultiMessage");
    }
    paramClass = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if ((paramClass != null) && (!paramClass.isEmpty())) {
      return paramClass;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageDataManager
 * JD-Core Version:    0.7.0.1
 */