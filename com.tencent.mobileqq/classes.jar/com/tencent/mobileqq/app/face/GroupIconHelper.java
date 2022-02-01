package com.tencent.mobileqq.app.face;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import anii;
import anks;
import ankw;
import anmu;
import anwd;
import aocs;
import aocx;
import aocy;
import aocz;
import awna;
import bfup;
import bgmo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msm;

public class GroupIconHelper
  extends anmu
  implements Handler.Callback, awna
{
  private static boolean jdField_a_of_type_Boolean;
  int jdField_a_of_type_Int;
  private anii jdField_a_of_type_Anii;
  private aocz jdField_a_of_type_Aocz;
  private GroupIconHelper.CheckDisIconThread jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, aocy> jdField_a_of_type_JavaUtilHashMap;
  private Hashtable<String, Long> jdField_a_of_type_JavaUtilHashtable;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  ConcurrentLinkedQueue<GroupIconHelper.GenerateIconRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int = 60000;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private int c = 90000;
  
  public GroupIconHelper(String paramString, anii paramanii)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create GroupIconHelper For [" + this.jdField_a_of_type_JavaLangString + "]");
    }
    paramString = paramanii.app;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Aocz = new aocz(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_Anii = paramanii;
    paramString.a(new GroupIconHelper.CheckIsLowPerformanceMachineRunner(this));
    ThreadManagerV2.executeOnSubThread(new GroupIconHelper.1(this, paramString));
    if ((this.jdField_a_of_type_Anii instanceof anks))
    {
      this.jdField_a_of_type_Int = 101;
      return;
    }
    this.jdField_a_of_type_Int = 113;
  }
  
  private Pair<Boolean, Bitmap> a(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramString1 == null) || (paramString1.length() <= 1))
    {
      i = 1;
      if (!paramBoolean2) {
        return Pair.create(Boolean.valueOf(false), null);
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = true;
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int k = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + k + ",hasPstnIcon: " + paramBoolean1 + ", hasRealPhoneUser: " + paramBoolean2);
    }
    if (i == 0) {}
    for (String[] arrayOfString = paramString1.split(";");; arrayOfString = null)
    {
      i = 0;
      int j;
      if (arrayOfString != null)
      {
        if (arrayOfString.length > 4) {
          i = 4;
        }
      }
      else
      {
        if ((i >= 4) || (!paramBoolean1)) {
          break label533;
        }
        paramString1 = msm.a(localQQAppInterface, paramString2, 3000, 4 - i);
        if ((paramString1 == null) || (paramString1.size() <= 0)) {
          break label526;
        }
        j = paramString1.size();
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramString2);
          j += i;
          ??? = new Bitmap[j];
          j = 0;
          paramBoolean1 = bool;
          if (j < i)
          {
            String str = arrayOfString[j];
            Pair localPair = localQQAppInterface.a(str, (byte)5, 0, 0);
            if (!((Boolean)localPair.first).booleanValue())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
              }
              paramArrayList.remove(str);
              paramBoolean1 = false;
            }
            ???[j] = ((Bitmap)localPair.second);
            j += 1;
            continue;
            i = arrayOfString.length;
          }
        }
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          j = 0;
          while (j < paramString1.size())
          {
            ???[(j + i)] = ((Bitmap)paramString1.get(j));
            j += 1;
          }
        }
        try
        {
          paramString1 = a(k, (Bitmap[])???);
          return Pair.create(Boolean.valueOf(paramBoolean1), paramString1);
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon fail, disUin=" + paramString2 + ", throwable : " + paramString1.toString());
            }
            paramBoolean1 = false;
            paramString1 = null;
          }
        }
        label526:
        j = i;
        continue;
        label533:
        paramString1 = null;
        j = i;
      }
    }
  }
  
  /* Error */
  private Pair<Boolean, Boolean> a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, QQAppInterface paramQQAppInterface, byte paramByte, String paramString4, File paramFile, boolean paramBoolean4, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 16
    //   3: aconst_null
    //   4: astore 17
    //   6: aconst_null
    //   7: astore 18
    //   9: iload_3
    //   10: ifeq +301 -> 311
    //   13: iconst_1
    //   14: istore 13
    //   16: iload 13
    //   18: istore 5
    //   20: aload 18
    //   22: astore 10
    //   24: aload 16
    //   26: astore 14
    //   28: aload 17
    //   30: astore 15
    //   32: aload_0
    //   33: getfield 107	com/tencent/mobileqq/app/face/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   36: ifnull +50 -> 86
    //   39: aload 16
    //   41: astore 14
    //   43: aload 17
    //   45: astore 15
    //   47: aload_0
    //   48: getfield 107	com/tencent/mobileqq/app/face/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   51: astore 10
    //   53: aload 16
    //   55: astore 14
    //   57: aload 17
    //   59: astore 15
    //   61: aload 10
    //   63: monitorenter
    //   64: aload_0
    //   65: getfield 107	com/tencent/mobileqq/app/face/GroupIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   68: aload_2
    //   69: invokeinterface 241 2 0
    //   74: pop
    //   75: aload 10
    //   77: monitorexit
    //   78: aload 18
    //   80: astore 10
    //   82: iload 13
    //   84: istore 5
    //   86: aload 10
    //   88: astore 14
    //   90: aload 10
    //   92: astore 15
    //   94: invokestatic 282	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   97: ifeq +90 -> 187
    //   100: aload 10
    //   102: astore 14
    //   104: aload 10
    //   106: astore 15
    //   108: ldc 65
    //   110: iconst_4
    //   111: new 67	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 284
    //   121: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 5
    //   126: invokevirtual 217	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   129: ldc_w 286
    //   132: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 286
    //   142: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 286
    //   152: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 6
    //   157: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 288
    //   163: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_3
    //   167: invokevirtual 217	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 290
    //   173: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 4
    //   178: invokevirtual 217	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload 8
    //   189: iconst_3
    //   190: if_icmpne +277 -> 467
    //   193: aload 10
    //   195: astore 14
    //   197: aload 10
    //   199: astore 15
    //   201: aload 12
    //   203: bipush 50
    //   205: bipush 50
    //   207: invokestatic 296	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   210: astore_1
    //   211: aload 10
    //   213: astore 14
    //   215: aload 10
    //   217: astore 15
    //   219: aload 7
    //   221: aload 9
    //   223: aload_1
    //   224: iconst_2
    //   225: invokevirtual 299	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   228: iload 5
    //   230: istore_3
    //   231: aload 10
    //   233: ifnull +11 -> 244
    //   236: aload 10
    //   238: invokevirtual 304	java/io/BufferedOutputStream:close	()V
    //   241: iload 5
    //   243: istore_3
    //   244: iload_3
    //   245: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   248: iload 11
    //   250: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   253: invokestatic 173	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   256: astore_2
    //   257: aload_2
    //   258: areturn
    //   259: astore_1
    //   260: aload 10
    //   262: monitorexit
    //   263: aload 16
    //   265: astore 14
    //   267: aload 17
    //   269: astore 15
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: aload 14
    //   276: astore 10
    //   278: iconst_0
    //   279: istore 4
    //   281: iload 4
    //   283: istore_3
    //   284: aload 10
    //   286: ifnull -42 -> 244
    //   289: aload 10
    //   291: invokevirtual 304	java/io/BufferedOutputStream:close	()V
    //   294: iload 4
    //   296: istore_3
    //   297: goto -53 -> 244
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 307	java/lang/Throwable:printStackTrace	()V
    //   305: iload 4
    //   307: istore_3
    //   308: goto -64 -> 244
    //   311: aload 10
    //   313: ifnonnull +76 -> 389
    //   316: aload 16
    //   318: astore 14
    //   320: aload 17
    //   322: astore 15
    //   324: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +20 -> 347
    //   330: aload 16
    //   332: astore 14
    //   334: aload 17
    //   336: astore 15
    //   338: ldc 65
    //   340: iconst_2
    //   341: ldc_w 309
    //   344: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload 16
    //   349: astore 14
    //   351: aload 17
    //   353: astore 15
    //   355: iload 5
    //   357: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   360: iconst_0
    //   361: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   364: invokestatic 173	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   367: astore_1
    //   368: aload_1
    //   369: astore_2
    //   370: iconst_0
    //   371: ifeq -114 -> 257
    //   374: new 311	java/lang/NullPointerException
    //   377: dup
    //   378: invokespecial 312	java/lang/NullPointerException:<init>	()V
    //   381: athrow
    //   382: astore_2
    //   383: aload_2
    //   384: invokevirtual 307	java/lang/Throwable:printStackTrace	()V
    //   387: aload_1
    //   388: areturn
    //   389: aload 16
    //   391: astore 14
    //   393: aload 17
    //   395: astore 15
    //   397: aload 10
    //   399: invokevirtual 317	java/io/File:exists	()Z
    //   402: ifne +17 -> 419
    //   405: aload 16
    //   407: astore 14
    //   409: aload 17
    //   411: astore 15
    //   413: aload 10
    //   415: invokevirtual 320	java/io/File:createNewFile	()Z
    //   418: pop
    //   419: aload 16
    //   421: astore 14
    //   423: aload 17
    //   425: astore 15
    //   427: new 301	java/io/BufferedOutputStream
    //   430: dup
    //   431: new 322	java/io/FileOutputStream
    //   434: dup
    //   435: aload 10
    //   437: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   440: invokespecial 328	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   443: astore 10
    //   445: aload 12
    //   447: getstatic 334	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   450: bipush 90
    //   452: aload 10
    //   454: invokevirtual 338	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   457: istore 5
    //   459: aload 10
    //   461: invokevirtual 341	java/io/BufferedOutputStream:flush	()V
    //   464: goto -378 -> 86
    //   467: aload 12
    //   469: astore_1
    //   470: iload 8
    //   472: iconst_1
    //   473: if_icmpne -262 -> 211
    //   476: aload 10
    //   478: astore 14
    //   480: aload 10
    //   482: astore 15
    //   484: aload 12
    //   486: bipush 10
    //   488: bipush 50
    //   490: bipush 50
    //   492: invokestatic 344	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   495: astore_1
    //   496: goto -285 -> 211
    //   499: astore_1
    //   500: aload_1
    //   501: invokevirtual 307	java/lang/Throwable:printStackTrace	()V
    //   504: iload 5
    //   506: istore_3
    //   507: goto -263 -> 244
    //   510: astore_1
    //   511: aload 15
    //   513: astore 10
    //   515: aload 10
    //   517: ifnull +8 -> 525
    //   520: aload 10
    //   522: invokevirtual 304	java/io/BufferedOutputStream:close	()V
    //   525: aload_1
    //   526: athrow
    //   527: astore_2
    //   528: aload_2
    //   529: invokevirtual 307	java/lang/Throwable:printStackTrace	()V
    //   532: goto -7 -> 525
    //   535: astore_1
    //   536: goto -21 -> 515
    //   539: astore_1
    //   540: goto -262 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	GroupIconHelper
    //   0	543	1	paramString1	String
    //   0	543	2	paramString2	String
    //   0	543	3	paramBoolean1	boolean
    //   0	543	4	paramBoolean2	boolean
    //   0	543	5	paramBoolean3	boolean
    //   0	543	6	paramString3	String
    //   0	543	7	paramQQAppInterface	QQAppInterface
    //   0	543	8	paramByte	byte
    //   0	543	9	paramString4	String
    //   0	543	10	paramFile	File
    //   0	543	11	paramBoolean4	boolean
    //   0	543	12	paramBitmap	Bitmap
    //   14	69	13	bool	boolean
    //   26	453	14	localObject1	Object
    //   30	482	15	localObject2	Object
    //   1	419	16	localObject3	Object
    //   4	420	17	localObject4	Object
    //   7	72	18	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   64	78	259	finally
    //   260	263	259	finally
    //   32	39	273	java/lang/Throwable
    //   47	53	273	java/lang/Throwable
    //   61	64	273	java/lang/Throwable
    //   94	100	273	java/lang/Throwable
    //   108	187	273	java/lang/Throwable
    //   201	211	273	java/lang/Throwable
    //   219	228	273	java/lang/Throwable
    //   271	273	273	java/lang/Throwable
    //   324	330	273	java/lang/Throwable
    //   338	347	273	java/lang/Throwable
    //   355	368	273	java/lang/Throwable
    //   397	405	273	java/lang/Throwable
    //   413	419	273	java/lang/Throwable
    //   427	445	273	java/lang/Throwable
    //   484	496	273	java/lang/Throwable
    //   289	294	300	java/lang/Throwable
    //   374	382	382	java/lang/Throwable
    //   236	241	499	java/lang/Throwable
    //   32	39	510	finally
    //   47	53	510	finally
    //   61	64	510	finally
    //   94	100	510	finally
    //   108	187	510	finally
    //   201	211	510	finally
    //   219	228	510	finally
    //   271	273	510	finally
    //   324	330	510	finally
    //   338	347	510	finally
    //   355	368	510	finally
    //   397	405	510	finally
    //   413	419	510	finally
    //   427	445	510	finally
    //   484	496	510	finally
    //   520	525	527	java/lang/Throwable
    //   445	464	535	finally
    //   445	464	539	java/lang/Throwable
  }
  
  private aocy a(String paramString, boolean paramBoolean1, aocy paramaocy, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1;
    if (this.jdField_a_of_type_Int == 101)
    {
      localObject1 = ((ankw)localQQAppInterface.getManager(53)).b(paramString);
      if (QLog.isColorLevel())
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
          break label227;
        }
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
      label87:
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label357;
      }
    }
    label227:
    label357:
    for (paramaocy.jdField_a_of_type_Int = 0;; paramaocy.jdField_a_of_type_Int = ((ArrayList)localObject1).size())
    {
      localObject1 = a((ArrayList)localObject1, paramBoolean2);
      paramaocy.jdField_a_of_type_JavaLangString = ((String)localObject1);
      a(paramString, paramBoolean1, paramaocy, localQQAppInterface, (String)localObject1);
      return paramaocy;
      localObject1 = (TroopManager)localQQAppInterface.getManager(52);
      Object localObject2 = ((TroopManager)localObject1).b(paramString);
      Object localObject3 = ((TroopManager)localObject1).c(paramString);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((ArrayList)localObject2).size() != 0) {
        break;
      }
      localObject1 = localObject2;
      if (((TroopInfo)localObject3).wMemberNum <= 1) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Anii == null) {
        break;
      }
      ((anwd)this.jdField_a_of_type_Anii).b(Long.parseLong(paramString));
      localObject1 = localObject2;
      break;
      localObject2 = new StringBuilder();
      localObject3 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((str != null) && (str.length() > 5)) {
          ((StringBuilder)localObject2).append(str.substring(0, 4));
        }
        for (;;)
        {
          ((StringBuilder)localObject2).append(";");
          break;
          ((StringBuilder)localObject2).append(str);
        }
      }
      QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject2).toString());
      break label87;
    }
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
      return null;
    }
    return paramString + "_" + 1001;
  }
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayList.get(i));
        i += 1;
      }
      Arrays.sort(arrayOfString, a());
      int k = 0;
      i = j;
      j = k;
      if (i < arrayOfString.length)
      {
        localStringBuilder.append(arrayOfString[i]).append(";");
        j += 1;
        if ((!paramBoolean) || (!a()) || (j < 4)) {
          break label177;
        }
      }
    }
    label127:
    for (paramArrayList = localStringBuilder.toString();; paramArrayList = " ")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "createFaceUinSet, ret=" + paramArrayList + ",sureChanged=" + paramBoolean);
      }
      return paramArrayList;
      if (j >= 4) {
        break label127;
      }
      i += 1;
      break;
    }
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QLog.d("Q.qqhead.dih", 2, "handleDiscussionSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    ArrayList localArrayList = (ArrayList)paramArrayList.clone();
    int i = paramArrayList.size();
    paramArrayList = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (i <= 4) {
      if (!localArrayList.contains(paramArrayList)) {
        localArrayList.add(paramArrayList);
      }
    }
    for (;;)
    {
      paramArrayList = localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, memberUinSize=" + localArrayList.size());
      return localArrayList;
      localArrayList.remove(paramArrayList);
    }
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList, TroopInfo paramTroopInfo)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramTroopInfo == null))
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    if (paramTroopInfo == null)
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins troopInfo is null");
      return paramArrayList;
    }
    paramArrayList = (ArrayList)paramArrayList.clone();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bfup.a(paramArrayList);
    if (paramTroopInfo.wMemberNumClient <= 4) {
      if (!paramArrayList.contains(str)) {
        paramArrayList.add(str);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, discussionUin=" + paramTroopInfo.troopuin + ",NumClient=" + paramTroopInfo.wMemberNumClient + ",memberUinSize=" + paramArrayList);
      }
      return paramArrayList;
      paramArrayList.remove(str);
    }
  }
  
  public static Comparator<String> a()
  {
    return new aocx();
  }
  
  private void a(GroupIconHelper.GenerateIconRunner paramGenerateIconRunner)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramGenerateIconRunner);
    b();
  }
  
  private void a(String paramString, aocy paramaocy, boolean paramBoolean)
  {
    if (paramaocy.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramaocy.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramaocy.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(paramaocy.jdField_a_of_type_JavaLangString, paramString, paramaocy.jdField_a_of_type_JavaUtilArrayList, paramaocy.c, paramaocy.d);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      paramaocy.jdField_b_of_type_Int += 1;
      str = a(paramaocy.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
      paramaocy.jdField_b_of_type_JavaLangString = str;
      localObject1 = null;
      if (this.jdField_a_of_type_Int == 101)
      {
        localObject1 = (ankw)((QQAppInterface)localObject2).getManager(53);
        if (localObject1 == null) {
          break label642;
        }
      }
    }
    label642:
    for (localObject1 = ((ankw)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject3 = ((QQAppInterface)localObject2).a().createEntityManager();
        ((EntityManager)localObject3).update((Entity)localObject1);
        ((EntityManager)localObject3).close();
        if (QLog.isColorLevel()) {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
      }
      for (;;)
      {
        if ((paramaocy.jdField_a_of_type_JavaUtilArrayList.size() >= paramaocy.jdField_a_of_type_Int) && (bool2)) {
          paramaocy.jdField_a_of_type_Byte = 3;
        }
        if ((this.jdField_a_of_type_Anii instanceof anks)) {
          if (paramaocy.c) {
            ((anks)this.jdField_a_of_type_Anii).a(bool1, bool2, a(paramString));
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label572;
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > 3) {
              localObject2 = ((String)localObject1).substring(0, 2) + "." + ((String)localObject1).charAt(((String)localObject1).length() - 1);
            }
          }
          QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject2 + ", isComplete=" + bool2 + ", newFaceUinSet=" + str + paramaocy.toString());
          return;
          localObject3 = (TroopManager)((QQAppInterface)localObject2).getManager(52);
          TroopInfo localTroopInfo = ((TroopManager)localObject3).c(paramString);
          if (localTroopInfo == null) {
            break;
          }
          localTroopInfo.mHeaderUinsOld = str;
          ((TroopManager)localObject3).b(localTroopInfo);
          localObject1 = localTroopInfo.getTroopName();
          break;
          ((anks)this.jdField_a_of_type_Anii).a(bool1, bool2, paramString);
          ((QQAppInterface)localObject2).a(101, paramString, 0, ((QQAppInterface)localObject2).a(101, paramString, 0));
          continue;
          if ((this.jdField_a_of_type_Anii instanceof anwd))
          {
            ((anwd)this.jdField_a_of_type_Anii).a(bool1, bool2, paramString);
            ((QQAppInterface)localObject2).a(113, paramString, 0, ((QQAppInterface)localObject2).a(113, paramString, 0));
          }
        }
        label572:
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramaocy.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramaocy.jdField_a_of_type_Int);
        return;
        localObject1 = null;
      }
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, aocy paramaocy, QQAppInterface paramQQAppInterface, String paramString2)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = null;
      if (this.jdField_a_of_type_Int != 101) {
        break label89;
      }
      paramString1 = ((ankw)paramQQAppInterface.getManager(53)).a(paramString1);
      if (paramString1 == null) {
        break label216;
      }
    }
    label216:
    for (paramString1 = paramString1.faceUinSet;; paramString1 = null)
    {
      Object localObject1 = paramString1;
      if (((localObject1 == null) || ("".equals(((String)localObject1).trim()))) && ((paramString2 == null) || ("".equals(paramString2.trim())))) {
        paramBoolean = false;
      }
      for (;;)
      {
        paramaocy.jdField_a_of_type_Boolean = paramBoolean;
        return;
        label89:
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int != 113) {
          break;
        }
        paramString1 = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString1);
        localObject1 = localObject2;
        if (paramString1 == null) {
          break;
        }
        localObject1 = paramString1.mHeaderUinsOld;
        break;
        if ((paramString2 != null) && (!paramString2.equals(localObject1))) {
          paramBoolean = true;
        } else if ((localObject1 != null) && (!((String)localObject1).equals(paramString2))) {
          paramBoolean = true;
        } else if ((paramaocy.jdField_a_of_type_Byte == 2) && (paramString2 != null) && (!paramString2.equals(paramaocy.jdField_b_of_type_JavaLangString)) && (paramaocy.e)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
      bool = false;
    }
    while (paramString.contains("_1001")) {
      return bool;
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    label390:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        aocy localaocy;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localaocy = (aocy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localaocy.jdField_a_of_type_Byte == 3)
          {
            bool = true;
            if (((!bool) && (l - localaocy.jdField_a_of_type_Long < this.c)) || ((bool) && (!paramBoolean) && (l - localaocy.jdField_a_of_type_Long < 3600000L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo notDo, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",startTime=" + localaocy.jdField_a_of_type_Long + ",state=" + localaocy.jdField_a_of_type_Byte);
              }
              return false;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo reset, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",state=" + localaocy.jdField_a_of_type_Byte);
            }
            localaocy.a(localaocy.jdField_a_of_type_Byte);
            if (a(paramString))
            {
              QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localaocy.c = true;
              localaocy.d = msm.a(localQQAppInterface, b(paramString), 3000);
            }
            localaocy.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localaocy);
            return true;
          }
        }
        else
        {
          localaocy = new aocy(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localaocy);
          if (!QLog.isColorLevel()) {
            break label390;
          }
          QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo  not hit, disUin=" + paramString);
        }
      }
      boolean bool = false;
    }
  }
  
  private boolean a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, String paramString2, File paramFile)
  {
    if ((paramString1 != null) && (paramString1.trim().length() <= 0))
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile())) {
        paramFile.delete();
      }
      if ((!paramBoolean1) || ((paramBoolean1) && (!paramBoolean2)))
      {
        paramString1 = null;
        if (this.jdField_a_of_type_Int == 101) {
          paramString1 = bgmo.h();
        }
        for (;;)
        {
          if (paramString1 != null) {
            paramQQAppInterface.a(paramString2, paramString1, (byte)2);
          }
          return true;
          if (this.jdField_a_of_type_Int == 113) {
            paramString1 = bgmo.h();
          }
        }
      }
    }
    return false;
  }
  
  private Pair<Boolean, Boolean> b(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString2 == null) || ((paramString1 == null) && (!paramBoolean2))) {
      return Pair.create(Boolean.valueOf(false), Boolean.valueOf(false));
    }
    String str1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!paramBoolean1) {
      str1 = localQQAppInterface.a(this.jdField_a_of_type_Int, paramString2, 0);
    }
    byte b1 = aocs.a((byte)3);
    String str2 = localQQAppInterface.a(this.jdField_a_of_type_Int, paramString2, b1, 0);
    if (paramBoolean1) {
      str2 = localQQAppInterface.a(1001, a(paramString2), b1, 0);
    }
    File localFile = null;
    if (!TextUtils.isEmpty(str1)) {
      localFile = new File(str1);
    }
    if (a(paramString1, paramBoolean1, paramBoolean2, localQQAppInterface, str2, localFile)) {
      return Pair.create(Boolean.valueOf(true), Boolean.valueOf(true));
    }
    boolean bool1 = true;
    try
    {
      Pair localPair = a(paramString1, paramString2, paramArrayList, paramBoolean1, paramBoolean2);
      paramArrayList = (Bitmap)localPair.second;
      boolean bool2 = ((Boolean)localPair.first).booleanValue();
      bool1 = bool2;
    }
    catch (Throwable paramArrayList)
    {
      for (;;)
      {
        paramArrayList = null;
      }
    }
    if (paramArrayList == null) {
      return Pair.create(Boolean.valueOf(false), Boolean.valueOf(false));
    }
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, false, str1, localQQAppInterface, b1, str2, localFile, bool1, paramArrayList);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i < 0) || (i > paramString.length()))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + paramString);
      return null;
    }
    return paramString.substring(0, i);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "runNext: mRunningTaskNum=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", queueSize=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 3)
    {
      GroupIconHelper.GenerateIconRunner localGenerateIconRunner = (GroupIconHelper.GenerateIconRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localGenerateIconRunner != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(localGenerateIconRunner, 10, null, true);
      }
    }
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_Aocz.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Aocz.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Aocz.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_2
    //   2: invokestatic 763	bgia:a	(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   5: astore_2
    //   6: aload_2
    //   7: astore_3
    //   8: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +20 -> 31
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: ifnonnull +14 -> 31
    //   20: ldc 65
    //   22: iconst_2
    //   23: ldc_w 765
    //   26: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_2
    //   30: astore_3
    //   31: aload_3
    //   32: areturn
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_2
    //   38: astore_3
    //   39: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq -11 -> 31
    //   45: ldc 65
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 766	java/lang/Exception:toString	()Ljava/lang/String;
    //   53: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_2
    //   57: areturn
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore_3
    //   64: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq -36 -> 31
    //   70: ldc 65
    //   72: iconst_2
    //   73: aload 4
    //   75: invokevirtual 767	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   78: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: astore_3
    //   89: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -61 -> 31
    //   95: ldc 65
    //   97: iconst_2
    //   98: aload 4
    //   100: invokevirtual 768	java/lang/Error:toString	()Ljava/lang/String;
    //   103: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_2
    //   107: areturn
    //   108: astore 4
    //   110: goto -23 -> 87
    //   113: astore 4
    //   115: goto -53 -> 62
    //   118: astore 4
    //   120: goto -83 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	GroupIconHelper
    //   0	123	1	paramInt	int
    //   0	123	2	paramArrayOfBitmap	Bitmap[]
    //   7	82	3	arrayOfBitmap	Bitmap[]
    //   33	16	4	localException1	java.lang.Exception
    //   58	16	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   83	16	4	localError1	java.lang.Error
    //   108	1	4	localError2	java.lang.Error
    //   113	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   118	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	33	java/lang/Exception
    //   0	6	58	java/lang/OutOfMemoryError
    //   0	6	83	java/lang/Error
    //   8	14	108	java/lang/Error
    //   20	29	108	java/lang/Error
    //   8	14	113	java/lang/OutOfMemoryError
    //   20	29	113	java/lang/OutOfMemoryError
    //   8	14	118	java/lang/Exception
    //   20	29	118	java/lang/Exception
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.notifyAll();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject4 = this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localObject4 != null) && ((localObject4 instanceof aocy)))
          {
            localObject4 = (aocy)localObject4;
            if ((localObject4 != null) && (((aocy)localObject4).jdField_a_of_type_Byte != 3) && ((this.jdField_a_of_type_Anii instanceof anks))) {
              ((anks)this.jdField_a_of_type_Anii).a(false, true, str);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    ??? = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)((QQAppInterface)???).getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.b(this);
    }
    ((QQAppInterface)???).removeObserver(this);
    this.jdField_a_of_type_Anii = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      g(paramString);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    boolean bool = a(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 1, paramString));
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaUtilSet != null)) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
          {
            ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilSet);
            int i = localArrayList.size();
            paramInt = 0;
            if (paramInt < i)
            {
              String str = (String)localArrayList.get(paramInt);
              if ((str != null) && (str.length() != 0)) {
                e(str);
              }
            }
            else
            {
              this.jdField_a_of_type_JavaUtilSet.clear();
            }
          }
          else
          {
            return;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.jdField_b_of_type_Int)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
      }
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
      a(new GroupIconHelper.GenerateIconRunner(this, 3, paramString));
    } while ((this.jdField_b_of_type_JavaUtilSet == null) || (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon mDisCallUinSet has it " + paramString);
    }
    synchronized (this.jdField_b_of_type_JavaUtilSet)
    {
      this.jdField_b_of_type_JavaUtilSet.remove(paramString);
      e(paramString);
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public void e(String paramString)
  {
    String str = a(paramString);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      d(str);
      localQQAppInterface.a(localQQAppInterface.a(1001, a(paramString), (byte)3, 0));
      a(str);
    }
  }
  
  public void f(String paramString)
  {
    ??? = msm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3000);
    if (((??? == null) || (((String)???).length() == 0)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      e(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleMessage ACTION_GENERATE_DISCUSSION: groupUin=" + paramMessage);
      }
      a(new GroupIconHelper.GenerateIconRunner(this, 2, paramMessage));
    }
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead isSuccess | " + paramBoolean + ", uin=");
    }
    label417:
    label420:
    label423:
    label429:
    for (;;)
    {
      ArrayList localArrayList;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        localArrayList = null;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str1);
          if ((localObject == null) || (!(localObject instanceof aocy))) {
            break label423;
          }
          localObject = (aocy)localObject;
          if ((localObject == null) || (((aocy)localObject).jdField_a_of_type_JavaLangString == null)) {
            continue;
          }
          if (((aocy)localObject).c)
          {
            str2 = ((aocy)localObject).jdField_a_of_type_JavaLangString;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label420;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (((aocy)localObject).jdField_a_of_type_Byte != 3)
            {
              ((aocy)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
              g(str1);
              break label429;
            }
            if (localArrayList != null) {
              break label417;
            }
            localArrayList = new ArrayList();
            localArrayList.add(str1);
            break label429;
          }
          if (((aocy)localObject).jdField_a_of_type_Byte == 3) {
            continue;
          }
          String str2 = ((aocy)localObject).jdField_a_of_type_JavaLangString;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          ((aocy)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramString);
          g(str1);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          e(b((String)paramString.next()));
        }
      }
      return;
      continue;
      break label429;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper
 * JD-Core Version:    0.7.0.1
 */