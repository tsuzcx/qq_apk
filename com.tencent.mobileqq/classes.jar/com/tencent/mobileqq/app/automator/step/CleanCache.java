package com.tencent.mobileqq.app.automator.step;

import ains;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anhk;
import anip;
import anzn;
import anzp;
import anzq;
import anzr;
import anzs;
import anzt;
import atvo;
import bavo;
import bctj;
import bgmg;
import bhgg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CleanCache
  extends AsyncStep
{
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { anhk.bo };
  }
  
  private int a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = anhk.bM;
    arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
    int k = arrayOfString.length;
    int i = 0;
    int j = paramInt;
    paramInt = i;
    if (paramInt < k)
    {
      Object localObject = new File(arrayOfString[paramInt]);
      i = j;
      int m;
      if (((File)localObject).exists())
      {
        i = j;
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).listFiles();
          i = j;
          if (localObject != null)
          {
            i = j;
            if (localObject.length > 3000)
            {
              m = localObject.length;
              i = localObject.length;
              j = m - 2500;
              localObject = a((File[])localObject);
              i = i - localObject.length + 0;
              if (QLog.isColorLevel()) {
                QLog.d("QQInitHandler", 2, "onCleanCache. after delTemporaryQQHead. totalCount=" + m + ", currNeedDelCount=" + j + ", delCount=" + i);
              }
              if (i < j) {
                break label192;
              }
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        paramInt += 1;
        j = i;
        break;
        label192:
        Arrays.sort((Object[])localObject, new anzn(this));
        int n = localObject.length;
        localObject = a((File[])localObject, i, j);
        n = i + (n - localObject.length);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache. after delSecondaryQQHead. totalCount=" + m + ", currNeedDelCount=" + j + ", delCount=" + n);
        }
        i = j;
        if (n < j)
        {
          a((File[])localObject, n, j, m);
          i = j;
        }
      }
    }
    return j;
  }
  
  /* Error */
  private int a(File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 37	java/io/File:exists	()Z
    //   4: ifeq +496 -> 500
    //   7: aload_1
    //   8: invokevirtual 40	java/io/File:isDirectory	()Z
    //   11: ifeq +489 -> 500
    //   14: aload_1
    //   15: invokevirtual 44	java/io/File:listFiles	()[Ljava/io/File;
    //   18: astore 14
    //   20: aload 14
    //   22: ifnonnull +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload 14
    //   29: arraylength
    //   30: istore 5
    //   32: lconst_0
    //   33: lstore 8
    //   35: aload_1
    //   36: getstatic 111	bdzx:a	Ljava/io/File;
    //   39: if_acmpne +40 -> 79
    //   42: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +34 -> 79
    //   48: ldc 54
    //   50: iconst_2
    //   51: new 56	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   58: ldc 113
    //   60: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 5
    //   65: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 115
    //   70: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload 5
    //   81: iload_2
    //   82: if_icmple +406 -> 488
    //   85: aload 14
    //   87: new 117	anzo
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 118	anzo:<init>	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)V
    //   95: invokestatic 89	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   98: aload 14
    //   100: arraylength
    //   101: istore 7
    //   103: iconst_0
    //   104: istore 6
    //   106: iload 5
    //   108: istore 4
    //   110: lload 8
    //   112: lstore 10
    //   114: iload 4
    //   116: istore_2
    //   117: iload 6
    //   119: iload 7
    //   121: if_icmpge +40 -> 161
    //   124: aload 14
    //   126: iload 6
    //   128: aaload
    //   129: astore 15
    //   131: lload 8
    //   133: aload 15
    //   135: invokevirtual 122	java/io/File:length	()J
    //   138: ladd
    //   139: lstore 8
    //   141: aload 15
    //   143: invokevirtual 125	java/io/File:delete	()Z
    //   146: pop
    //   147: iload 4
    //   149: iconst_1
    //   150: isub
    //   151: istore_2
    //   152: iload_2
    //   153: iload_3
    //   154: if_icmpgt +146 -> 300
    //   157: lload 8
    //   159: lstore 10
    //   161: iload 5
    //   163: iload_3
    //   164: isub
    //   165: istore_3
    //   166: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   169: lstore 12
    //   171: aload 14
    //   173: arraylength
    //   174: istore 4
    //   176: iload 4
    //   178: iload_2
    //   179: isub
    //   180: istore 4
    //   182: iload_3
    //   183: istore_2
    //   184: iload 4
    //   186: aload 14
    //   188: arraylength
    //   189: if_icmpge +146 -> 335
    //   192: aload 14
    //   194: iload 4
    //   196: aaload
    //   197: astore 15
    //   199: lload 10
    //   201: lstore 8
    //   203: iload_2
    //   204: istore_3
    //   205: aload 15
    //   207: invokevirtual 37	java/io/File:exists	()Z
    //   210: ifeq +273 -> 483
    //   213: lload 10
    //   215: lstore 8
    //   217: iload_2
    //   218: istore_3
    //   219: aload 15
    //   221: invokevirtual 133	java/io/File:isFile	()Z
    //   224: ifeq +259 -> 483
    //   227: lload 12
    //   229: aload 15
    //   231: invokevirtual 136	java/io/File:lastModified	()J
    //   234: lsub
    //   235: ldc2_w 137
    //   238: lcmp
    //   239: ifle +96 -> 335
    //   242: lload 10
    //   244: aload 15
    //   246: invokevirtual 122	java/io/File:length	()J
    //   249: ladd
    //   250: lstore 10
    //   252: aload 15
    //   254: invokevirtual 125	java/io/File:delete	()Z
    //   257: pop
    //   258: iload_2
    //   259: iconst_1
    //   260: iadd
    //   261: istore_2
    //   262: lload 10
    //   264: lstore 8
    //   266: iload_2
    //   267: istore_3
    //   268: iload 4
    //   270: sipush 200
    //   273: irem
    //   274: ifne +209 -> 483
    //   277: ldc2_w 139
    //   280: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   283: lload 10
    //   285: lstore 8
    //   287: iload 4
    //   289: iconst_1
    //   290: iadd
    //   291: istore 4
    //   293: lload 8
    //   295: lstore 10
    //   297: goto -113 -> 184
    //   300: iload_2
    //   301: sipush 200
    //   304: irem
    //   305: ifne +9 -> 314
    //   308: ldc2_w 139
    //   311: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   314: iload 6
    //   316: iconst_1
    //   317: iadd
    //   318: istore 6
    //   320: iload_2
    //   321: istore 4
    //   323: goto -213 -> 110
    //   326: astore 15
    //   328: lload 10
    //   330: lstore 8
    //   332: goto -45 -> 287
    //   335: iload_2
    //   336: istore_3
    //   337: aload_1
    //   338: getstatic 111	bdzx:a	Ljava/io/File;
    //   341: if_acmpne +135 -> 476
    //   344: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +46 -> 393
    //   350: ldc 54
    //   352: iconst_2
    //   353: new 56	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   360: ldc 148
    //   362: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload_2
    //   366: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 150
    //   371: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: lload 10
    //   376: ldc2_w 151
    //   379: ldiv
    //   380: ldc2_w 151
    //   383: ldiv
    //   384: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iload_2
    //   394: istore_3
    //   395: iload_2
    //   396: ifle +80 -> 476
    //   399: aload_0
    //   400: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   403: getfield 164	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   406: invokevirtual 169	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   409: invokestatic 174	bgsg:a	(Ljava/lang/String;)J
    //   412: lstore 8
    //   414: invokestatic 179	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   417: ldc2_w 180
    //   420: ldiv
    //   421: lstore 10
    //   423: lload 8
    //   425: lconst_0
    //   426: lcmp
    //   427: ifeq +34 -> 461
    //   430: lload 10
    //   432: lload 8
    //   434: lcmp
    //   435: ifle +26 -> 461
    //   438: invokestatic 187	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   441: invokestatic 192	bctj:a	(Landroid/content/Context;)Lbctj;
    //   444: aconst_null
    //   445: ldc 194
    //   447: iconst_1
    //   448: lload 10
    //   450: lload 8
    //   452: lsub
    //   453: iload_2
    //   454: i2l
    //   455: aconst_null
    //   456: ldc 196
    //   458: invokevirtual 199	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   461: aload_0
    //   462: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   465: getfield 164	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   468: invokevirtual 169	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   471: invokestatic 201	bgsg:a	(Ljava/lang/String;)V
    //   474: iload_2
    //   475: istore_3
    //   476: iload_3
    //   477: ireturn
    //   478: astore 15
    //   480: goto -166 -> 314
    //   483: iload_3
    //   484: istore_2
    //   485: goto -198 -> 287
    //   488: iconst_0
    //   489: istore_3
    //   490: iload 5
    //   492: istore_2
    //   493: lload 8
    //   495: lstore 10
    //   497: goto -331 -> 166
    //   500: iconst_0
    //   501: istore_3
    //   502: goto -26 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	CleanCache
    //   0	505	1	paramFile	File
    //   0	505	2	paramInt1	int
    //   0	505	3	paramInt2	int
    //   108	214	4	i	int
    //   30	461	5	j	int
    //   104	215	6	k	int
    //   101	21	7	m	int
    //   33	461	8	l1	long
    //   112	384	10	l2	long
    //   169	59	12	l3	long
    //   18	175	14	arrayOfFile	File[]
    //   129	124	15	localFile	File
    //   326	1	15	localInterruptedException1	java.lang.InterruptedException
    //   478	1	15	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   277	283	326	java/lang/InterruptedException
    //   308	314	478	java/lang/InterruptedException
  }
  
  private int a(File[] paramArrayOfFile, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if (i < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[i];
      if (localFile.exists()) {
        localFile.delete();
      }
      paramArrayOfFile[i] = null;
      paramInt1 += 1;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache->delRemainQQHead. delete QQHead,filePath=" + localFile.getAbsolutePath());
      }
      if (paramInt1 >= paramInt2) {
        i = paramInt1;
      }
    }
    do
    {
      return i;
      i += 1;
      break;
      i = paramInt1;
    } while (!QLog.isColorLevel());
    QLog.d("QQInitHandler", 2, "onCleanCache. after delRemainQQHead. totalCount=" + paramInt3 + ", currNeedDelCount=" + paramInt2 + ", delCount=" + paramInt1);
    return paramInt1;
  }
  
  /* Error */
  private void a(EntityManager paramEntityManager, List<Setting> paramList1, int paramInt1, List<Setting> paramList2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +307 -> 308
    //   4: iload_3
    //   5: iload 5
    //   7: if_icmple +301 -> 308
    //   10: aload_2
    //   11: invokeinterface 220 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 225 1 0
    //   23: ifeq +187 -> 210
    //   26: aload_2
    //   27: invokeinterface 229 1 0
    //   32: checkcast 231	com/tencent/mobileqq/data/Setting
    //   35: astore 6
    //   37: aload 6
    //   39: ifnull -22 -> 17
    //   42: aload 6
    //   44: getfield 234	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   47: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -33 -> 17
    //   53: sipush 200
    //   56: istore_3
    //   57: aload 6
    //   59: getfield 244	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   62: bipush 32
    //   64: if_icmpne +130 -> 194
    //   67: sipush 202
    //   70: istore_3
    //   71: aload_0
    //   72: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   75: getfield 248	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: aload 6
    //   80: iload_3
    //   81: invokevirtual 253	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;I)Ljava/lang/String;
    //   84: astore 7
    //   86: aload 7
    //   88: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne -74 -> 17
    //   94: new 30	java/io/File
    //   97: dup
    //   98: aload 7
    //   100: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 37	java/io/File:exists	()Z
    //   106: ifne -89 -> 17
    //   109: aload 4
    //   111: aload 6
    //   113: invokeinterface 257 2 0
    //   118: pop
    //   119: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -105 -> 17
    //   125: ldc 54
    //   127: iconst_2
    //   128: new 56	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 259
    //   138: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 6
    //   143: getfield 234	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   146: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 261
    //   152: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 6
    //   157: getfield 244	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 261
    //   166: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   173: getfield 248	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: aload 6
    //   178: iload_3
    //   179: invokevirtual 253	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;I)Ljava/lang/String;
    //   182: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: goto -174 -> 17
    //   194: aload 6
    //   196: getfield 244	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   199: bipush 16
    //   201: if_icmpne -130 -> 71
    //   204: bipush 16
    //   206: istore_3
    //   207: goto -136 -> 71
    //   210: aload 4
    //   212: invokeinterface 265 1 0
    //   217: istore_3
    //   218: aload 4
    //   220: ifnull +88 -> 308
    //   223: iload_3
    //   224: ifle +84 -> 308
    //   227: aload_1
    //   228: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   231: ifeq +77 -> 308
    //   234: aload_1
    //   235: invokevirtual 274	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   238: invokevirtual 279	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   241: aload 4
    //   243: invokeinterface 220 1 0
    //   248: astore_2
    //   249: aload_2
    //   250: invokeinterface 225 1 0
    //   255: ifeq +54 -> 309
    //   258: aload_2
    //   259: invokeinterface 229 1 0
    //   264: checkcast 231	com/tencent/mobileqq/data/Setting
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull -22 -> 249
    //   274: aload_1
    //   275: aload 4
    //   277: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   280: pop
    //   281: goto -32 -> 249
    //   284: astore_2
    //   285: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +13 -> 301
    //   291: ldc 54
    //   293: iconst_2
    //   294: ldc_w 259
    //   297: aload_2
    //   298: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_1
    //   302: invokevirtual 274	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   305: invokevirtual 290	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   308: return
    //   309: aload_1
    //   310: invokevirtual 274	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   313: invokevirtual 293	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   316: aload_1
    //   317: invokevirtual 274	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   320: invokevirtual 290	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   323: return
    //   324: astore_2
    //   325: aload_1
    //   326: invokevirtual 274	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   329: invokevirtual 290	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   332: aload_2
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	CleanCache
    //   0	334	1	paramEntityManager	EntityManager
    //   0	334	2	paramList1	List<Setting>
    //   0	334	3	paramInt1	int
    //   0	334	4	paramList2	List<Setting>
    //   0	334	5	paramInt2	int
    //   35	160	6	localSetting	Setting
    //   84	15	7	str	String
    // Exception table:
    //   from	to	target	type
    //   234	249	284	java/lang/Exception
    //   249	269	284	java/lang/Exception
    //   274	281	284	java/lang/Exception
    //   309	316	284	java/lang/Exception
    //   234	249	324	finally
    //   249	269	324	finally
    //   274	281	324	finally
    //   285	301	324	finally
    //   309	316	324	finally
  }
  
  public static final void a(String paramString)
  {
    paramString = new File(paramString + ".nomedia");
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "create nomedia file:" + paramString.getAbsolutePath());
      }
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List<Setting> paramList)
  {
    Object localObject;
    int j;
    int i;
    int k;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      j = 0;
      for (i = 0;; i = k) {
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Setting localSetting = (Setting)((Iterator)localObject).next();
            if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)))
            {
              if (localSetting == null) {
                break label209;
              }
              if ((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32))
              {
                k = j + 1;
                j = i;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      k = i + 1;
      i = j;
      j = k;
      continue;
      localObject = new HashMap();
      if (paramList != null) {}
      for (k = paramList.size();; k = 0)
      {
        ((HashMap)localObject).put("dataSize", String.valueOf(k));
        ((HashMap)localObject).put("highSize", String.valueOf(i));
        ((HashMap)localObject).put("lowSize", String.valueOf(j));
        bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.mApp.getCurrentAccountUin(), "qq_head_setting", false, 0L, 0L, (HashMap)localObject, "");
        return;
      }
      label209:
      k = i;
      i = j;
      j = k;
    }
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   16: getfield 248	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 334	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   22: invokevirtual 340	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore 7
    //   27: aload 7
    //   29: iconst_0
    //   30: ldc 231
    //   32: invokevirtual 345	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   35: iconst_2
    //   36: anewarray 10	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc_w 346
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc_w 347
    //   50: aastore
    //   51: ldc_w 349
    //   54: iconst_1
    //   55: anewarray 10	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 351
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 355	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 8
    //   73: aload 10
    //   75: astore 9
    //   77: aload 8
    //   79: ifnull +96 -> 175
    //   82: aload 10
    //   84: astore 9
    //   86: aload 8
    //   88: invokeinterface 360 1 0
    //   93: ifeq +82 -> 175
    //   96: new 313	java/util/HashMap
    //   99: dup
    //   100: aload 8
    //   102: invokeinterface 363 1 0
    //   107: invokespecial 366	java/util/HashMap:<init>	(I)V
    //   110: astore 9
    //   112: aload 8
    //   114: iconst_0
    //   115: invokeinterface 369 2 0
    //   120: astore 10
    //   122: aload 8
    //   124: iconst_1
    //   125: invokeinterface 373 2 0
    //   130: istore_2
    //   131: aload_0
    //   132: getfield 158	com/tencent/mobileqq/app/automator/step/CleanCache:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   135: getfield 248	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   138: astore 11
    //   140: iload_2
    //   141: iconst_4
    //   142: if_icmpne +412 -> 554
    //   145: iconst_1
    //   146: istore 6
    //   148: aload 9
    //   150: aload 11
    //   152: iload 6
    //   154: aload 10
    //   156: invokevirtual 376	com/tencent/mobileqq/app/QQAppInterface:a	(ZLjava/lang/String;)Ljava/lang/String;
    //   159: aload 10
    //   161: invokevirtual 324	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: pop
    //   165: aload 8
    //   167: invokeinterface 379 1 0
    //   172: ifne -60 -> 112
    //   175: aload 7
    //   177: new 56	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 381
    //   187: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 231
    //   192: invokevirtual 345	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   195: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 383
    //   201: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 387	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   210: pop
    //   211: aload 9
    //   213: ifnull +347 -> 560
    //   216: aload 9
    //   218: invokevirtual 388	java/util/HashMap:size	()I
    //   221: ifle +339 -> 560
    //   224: iconst_0
    //   225: istore_3
    //   226: iconst_0
    //   227: istore_2
    //   228: iload_2
    //   229: istore 4
    //   231: iload_3
    //   232: aload_1
    //   233: arraylength
    //   234: if_icmpge +101 -> 335
    //   237: aload_1
    //   238: iload_3
    //   239: aaload
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: astore 11
    //   249: iload_2
    //   250: istore 4
    //   252: aload 9
    //   254: aload 11
    //   256: invokevirtual 391	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   259: ifeq +285 -> 544
    //   262: aload 10
    //   264: invokevirtual 37	java/io/File:exists	()Z
    //   267: ifeq +9 -> 276
    //   270: aload 10
    //   272: invokevirtual 125	java/io/File:delete	()Z
    //   275: pop
    //   276: aload_1
    //   277: iload_3
    //   278: aconst_null
    //   279: aastore
    //   280: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +256 -> 539
    //   286: ldc 54
    //   288: iconst_2
    //   289: new 56	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 393
    //   299: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 9
    //   304: aload 11
    //   306: invokevirtual 397	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 10	java/lang/String
    //   312: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 399
    //   318: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 11
    //   323: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto +207 -> 539
    //   335: aload_1
    //   336: astore 9
    //   338: iload 4
    //   340: ifle +59 -> 399
    //   343: aload_1
    //   344: arraylength
    //   345: iload 4
    //   347: isub
    //   348: anewarray 30	java/io/File
    //   351: astore 9
    //   353: iconst_0
    //   354: istore_2
    //   355: iload 5
    //   357: istore_3
    //   358: iload_3
    //   359: aload_1
    //   360: arraylength
    //   361: if_icmpge +38 -> 399
    //   364: iload_2
    //   365: aload 9
    //   367: arraylength
    //   368: if_icmpge +31 -> 399
    //   371: aload_1
    //   372: iload_3
    //   373: aaload
    //   374: ifnull +162 -> 536
    //   377: iload_2
    //   378: iconst_1
    //   379: iadd
    //   380: istore 4
    //   382: aload 9
    //   384: iload_2
    //   385: aload_1
    //   386: iload_3
    //   387: aaload
    //   388: aastore
    //   389: iload 4
    //   391: istore_2
    //   392: iload_3
    //   393: iconst_1
    //   394: iadd
    //   395: istore_3
    //   396: goto -38 -> 358
    //   399: aload 8
    //   401: ifnull +10 -> 411
    //   404: aload 8
    //   406: invokeinterface 402 1 0
    //   411: aload 9
    //   413: astore 10
    //   415: aload 7
    //   417: ifnull +12 -> 429
    //   420: aload 7
    //   422: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   425: aload 9
    //   427: astore 10
    //   429: aload 10
    //   431: areturn
    //   432: astore 7
    //   434: aconst_null
    //   435: astore 7
    //   437: aload 7
    //   439: ifnull +10 -> 449
    //   442: aload 7
    //   444: invokeinterface 402 1 0
    //   449: aload_1
    //   450: astore 10
    //   452: aload 8
    //   454: ifnull -25 -> 429
    //   457: aload 8
    //   459: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   462: aload_1
    //   463: areturn
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 8
    //   468: aload 9
    //   470: astore 7
    //   472: aload 8
    //   474: ifnull +10 -> 484
    //   477: aload 8
    //   479: invokeinterface 402 1 0
    //   484: aload 7
    //   486: ifnull +8 -> 494
    //   489: aload 7
    //   491: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   494: aload_1
    //   495: athrow
    //   496: astore_1
    //   497: aconst_null
    //   498: astore 8
    //   500: goto -28 -> 472
    //   503: astore_1
    //   504: goto -32 -> 472
    //   507: astore 8
    //   509: aload 7
    //   511: astore 8
    //   513: aconst_null
    //   514: astore 7
    //   516: goto -79 -> 437
    //   519: astore 9
    //   521: aload 7
    //   523: astore 9
    //   525: aload 8
    //   527: astore 7
    //   529: aload 9
    //   531: astore 8
    //   533: goto -96 -> 437
    //   536: goto -144 -> 392
    //   539: iload_2
    //   540: iconst_1
    //   541: iadd
    //   542: istore 4
    //   544: iload_3
    //   545: iconst_1
    //   546: iadd
    //   547: istore_3
    //   548: iload 4
    //   550: istore_2
    //   551: goto -323 -> 228
    //   554: iconst_0
    //   555: istore 6
    //   557: goto -409 -> 148
    //   560: iconst_0
    //   561: istore 4
    //   563: goto -228 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	CleanCache
    //   0	566	1	paramArrayOfFile	File[]
    //   130	421	2	i	int
    //   225	323	3	j	int
    //   229	333	4	k	int
    //   10	346	5	m	int
    //   146	410	6	bool	boolean
    //   25	396	7	localEntityManager	EntityManager
    //   432	1	7	localException1	Exception
    //   435	93	7	localObject1	Object
    //   1	498	8	localCursor	android.database.Cursor
    //   507	1	8	localException2	Exception
    //   511	21	8	localObject2	Object
    //   4	465	9	localObject3	Object
    //   519	1	9	localException3	Exception
    //   523	7	9	localObject4	Object
    //   7	444	10	localObject5	Object
    //   138	184	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   12	27	432	java/lang/Exception
    //   12	27	464	finally
    //   27	73	496	finally
    //   86	112	503	finally
    //   112	140	503	finally
    //   148	175	503	finally
    //   175	211	503	finally
    //   216	224	503	finally
    //   231	237	503	finally
    //   242	249	503	finally
    //   252	276	503	finally
    //   280	332	503	finally
    //   343	353	503	finally
    //   358	371	503	finally
    //   27	73	507	java/lang/Exception
    //   86	112	519	java/lang/Exception
    //   112	140	519	java/lang/Exception
    //   148	175	519	java/lang/Exception
    //   175	211	519	java/lang/Exception
    //   216	224	519	java/lang/Exception
    //   231	237	519	java/lang/Exception
    //   242	249	519	java/lang/Exception
    //   252	276	519	java/lang/Exception
    //   280	332	519	java/lang/Exception
    //   343	353	519	java/lang/Exception
    //   358	371	519	java/lang/Exception
  }
  
  private File[] a(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    int m = 0;
    EntityManager localEntityManager = null;
    localObject2 = localEntityManager;
    for (;;)
    {
      try
      {
        localObject3 = new LinkedList();
        localObject2 = localEntityManager;
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().createEntityManager();
        localObject2 = localEntityManager;
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject5;
        Object localObject3 = paramArrayOfFile;
        if (localObject2 == null) {
          continue;
        }
        ((EntityManager)localObject2).close();
        return paramArrayOfFile;
      }
      finally
      {
        Object localObject1 = null;
        if (localObject1 != null) {
          localObject1.close();
        }
      }
      try
      {
        localObject4 = (ArrayList)localEntityManager.query(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
        if (localObject4 != null)
        {
          localObject2 = localEntityManager;
          if (((ArrayList)localObject4).size() != 0)
          {
            i = 0;
            localObject2 = localEntityManager;
            if (i < ((ArrayList)localObject4).size())
            {
              localObject2 = localEntityManager;
              localObject5 = (Friends)((ArrayList)localObject4).get(i);
              localObject2 = localEntityManager;
              ((LinkedList)localObject3).add(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(false, ((Friends)localObject5).uin));
              i += 1;
              continue;
            }
          }
        }
        localObject2 = localEntityManager;
        localObject4 = (ArrayList)localEntityManager.query(TroopInfo.class, false, null, null, null, null, null, null);
        if (localObject4 == null) {
          break label589;
        }
        localObject2 = localEntityManager;
        if (((ArrayList)localObject4).size() <= 0) {
          break label589;
        }
        i = 0;
        localObject2 = localEntityManager;
        if (i >= ((ArrayList)localObject4).size()) {
          break label589;
        }
        localObject2 = localEntityManager;
        localObject5 = (TroopInfo)((ArrayList)localObject4).get(i);
        localObject2 = localEntityManager;
        ((LinkedList)localObject3).add(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(true, ((TroopInfo)localObject5).troopuin));
        i += 1;
        continue;
      }
      finally
      {
        continue;
        continue;
        j = 0;
        i = 0;
        continue;
        k = i;
        if (paramInt1 + i < paramInt2) {
          continue;
        }
        k = i;
        continue;
      }
      k = i;
      localObject2 = localEntityManager;
      if (j < paramArrayOfFile.length)
      {
        localObject4 = paramArrayOfFile[j];
        localObject2 = localEntityManager;
        localObject5 = ((File)localObject4).getAbsolutePath();
        k = i;
        localObject2 = localEntityManager;
        if (!((LinkedList)localObject3).contains(localObject5))
        {
          k = i;
          localObject2 = localEntityManager;
          if (((String)localObject5).indexOf("discussion_") < 0)
          {
            k = i;
            localObject2 = localEntityManager;
            if (((String)localObject5).indexOf("sys_") < 0)
            {
              localObject2 = localEntityManager;
              if (((File)localObject4).exists())
              {
                localObject2 = localEntityManager;
                ((File)localObject4).delete();
              }
              paramArrayOfFile[j] = null;
              i += 1;
              localObject2 = localEntityManager;
              if (!QLog.isColorLevel()) {
                break label598;
              }
              localObject2 = localEntityManager;
              QLog.d("QQInitHandler", 2, "onCleanCache->delSecondaryQQHead. delete QQHead,filePath=" + ((File)localObject4).getAbsolutePath());
              break label598;
            }
          }
        }
      }
      else
      {
        localObject2 = paramArrayOfFile;
        if (k <= 0) {
          continue;
        }
        localObject2 = localEntityManager;
        localObject3 = new File[paramArrayOfFile.length - k];
        paramInt1 = 0;
        paramInt2 = m;
        localObject2 = localEntityManager;
        if (paramInt2 >= paramArrayOfFile.length) {
          continue;
        }
        localObject2 = localEntityManager;
        if (paramInt1 >= localObject3.length) {
          continue;
        }
        if (paramArrayOfFile[paramInt2] == null) {
          break label586;
        }
        i = paramInt1 + 1;
        localObject3[paramInt1] = paramArrayOfFile[paramInt2];
        paramInt1 = i;
        paramInt2 += 1;
        continue;
      }
      j += 1;
      i = k;
    }
    localObject2 = localObject3;
    localObject3 = localObject2;
    if (localEntityManager != null)
    {
      localEntityManager.close();
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  private void f()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = anhk.bO;
    arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_stranger/";
    int m = arrayOfString.length;
    int i = 0;
    if (i < m)
    {
      Object localObject1 = new File(arrayOfString[i]);
      int n;
      int j;
      int k;
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 300))
        {
          Arrays.sort((Object[])localObject1, new anzp(this));
          n = localObject1.length;
          j = 0;
          k = 0;
        }
      }
      for (;;)
      {
        if (j < n)
        {
          Object localObject2 = localObject1[j];
          if (localObject2.exists()) {
            localObject2.delete();
          }
          localObject1[j] = null;
          k += 1;
          if (n - k > 20) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "onCleanCache. delete stranger head...");
          }
          i += 1;
          break;
        }
        j += 1;
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanZhituCache...");
    }
    long l1 = System.currentTimeMillis();
    if (ains.f()) {
      return;
    }
    ains.d(true);
    Object localObject1 = anhk.ba + "zhitu";
    localObject1 = new File(bhgg.a((String)localObject1 + "/" + "origin/"));
    int n;
    int k;
    int j;
    label158:
    int i;
    int m;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        n = localObject1.length;
        if (n > 200)
        {
          Arrays.sort((Object[])localObject1, new anzs(this));
          int i1 = localObject1.length;
          k = 0;
          j = 0;
          i = j;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "cleanZhituCache ===> deleteCount=" + j + ", delete dir=" + localObject2.getAbsolutePath());
            }
            bgmg.a(localObject2.getAbsolutePath());
            i = j + 1;
            if (i < n - 50) {
              break label334;
            }
            m = n;
          }
        }
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      ains.d(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQInitHandler", 2, "delShortVideoCache(), totalCount=" + m + ", deleteCount= " + i + ", targetDeleteCount=" + (m - 50) + ", cost: " + (l2 - l1) + " ms");
      return;
      label334:
      k += 1;
      j = i;
      break label158;
      i = 0;
      m = n;
      continue;
      i = 0;
      m = 0;
    }
  }
  
  private void h()
  {
    int i = 0;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanLightVideoCache...");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(bavo.a);
    int n;
    int k;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        n = localObject1.length;
        m = n;
        if (n > 25)
        {
          Arrays.sort((Object[])localObject1, new anzt(this));
          int i1 = localObject1.length;
          k = 0;
          i = j;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "cleanLightVideoCache ===> deleteCount=" + j + ", delete dir=" + localObject2.getAbsolutePath());
            }
            bgmg.a(localObject2.getAbsolutePath());
            i = j + 1;
            if (i < n - 10) {
              break label273;
            }
          }
        }
      }
    }
    for (int m = n;; m = 0)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "cleanLightVideoCache(), totalCount=" + m + ", deleteCount= " + i + ", targetDeleteCount=" + (m - 10) + ", cost: " + (l2 - l1) + " ms");
      }
      return;
      label273:
      k += 1;
      j = i;
      break;
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp().getSharedPreferences("HEAD", 0).edit().clear().commit();
    a();
    ThreadManager.post(new CleanCache.1(this), 2, null, false);
    return 7;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "initNoMediaFile");
    }
    anip.c();
    atvo.a();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (bgmg.a(str)) {
        a(str);
      }
      i += 1;
    }
  }
  
  void b()
  {
    int i = 10;
    try
    {
      Object localObject = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = ((File)localObject).listFiles(new anzq(this));
        if ((localObject != null) && (localObject.length > 10))
        {
          Arrays.sort((Object[])localObject, new anzr(this));
          while (i < localObject.length)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("QQInitHandler", 1, "", localThrowable);
    }
  }
  
  void e()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().createEntityManager();
    List localList = localEntityManager.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    int i;
    if (localList != null) {
      i = localList.size();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 3500;
      String[] arrayOfString = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0").split("\\|");
      int j = k;
      if (arrayOfString.length > 1) {}
      try
      {
        j = Integer.parseInt(arrayOfString[1]);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, new Object[] { "cleanSetingData", i + "," + j });
        }
        a(localEntityManager, localList, i, localArrayList, j);
        a(localList);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.e("QQInitHandler", 2, "cleanSetingData,", localException);
            j = k;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache
 * JD-Core Version:    0.7.0.1
 */