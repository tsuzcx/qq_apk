package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CleanCache
  extends AsyncStep
{
  public static final String[] a = { AppConstants.S_DCARD_COLLECTION };
  
  private int a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.PATH_HEAD_HD;
    arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
    int k = arrayOfString.length;
    int i = paramInt;
    paramInt = 0;
    while (paramInt < k)
    {
      Object localObject = new File(arrayOfString[paramInt]);
      int j = i;
      if (((File)localObject).exists())
      {
        j = i;
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).listFiles();
          j = i;
          if (localObject != null)
          {
            j = i;
            if (localObject.length > 3000)
            {
              i = localObject.length;
              int m = localObject.length;
              j = i - 2500;
              localObject = a((File[])localObject);
              m = m - localObject.length + 0;
              StringBuilder localStringBuilder;
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("onCleanCache. after delTemporaryQQHead. totalCount=");
                localStringBuilder.append(i);
                localStringBuilder.append(", currNeedDelCount=");
                localStringBuilder.append(j);
                localStringBuilder.append(", delCount=");
                localStringBuilder.append(m);
                QLog.d("QQInitHandler", 2, localStringBuilder.toString());
              }
              if (m < j)
              {
                Arrays.sort((Object[])localObject, new CleanCache.2(this));
                int n = localObject.length;
                localObject = a((File[])localObject, m, j);
                m += n - localObject.length;
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("onCleanCache. after delSecondaryQQHead. totalCount=");
                  localStringBuilder.append(i);
                  localStringBuilder.append(", currNeedDelCount=");
                  localStringBuilder.append(j);
                  localStringBuilder.append(", delCount=");
                  localStringBuilder.append(m);
                  QLog.d("QQInitHandler", 2, localStringBuilder.toString());
                }
                if (m < j) {
                  a((File[])localObject, m, j, i);
                }
              }
            }
          }
        }
      }
      paramInt += 1;
      i = j;
    }
    return i;
  }
  
  private int a(File paramFile, int paramInt1, int paramInt2)
  {
    boolean bool = paramFile.exists();
    int m = 0;
    int j = 0;
    int k = 0;
    int i = j;
    File[] arrayOfFile;
    Object localObject;
    if (bool)
    {
      i = j;
      if (paramFile.isDirectory())
      {
        arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          return 0;
        }
        j = arrayOfFile.length;
        if ((paramFile == URLDrawableHelper.diskCachePath) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("before onCleanCache diskCachePath. ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" cache file(s)");
          QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (j > paramInt1)
        {
          Arrays.sort(arrayOfFile, new CleanCache.3(this));
          m = arrayOfFile.length;
          i = j;
          l1 = 0L;
        }
      }
    }
    for (;;)
    {
      l2 = l1;
      paramInt1 = i;
      if (k < m)
      {
        localObject = arrayOfFile[k];
        l1 += ((File)localObject).length();
        ((File)localObject).delete();
        paramInt1 = i - 1;
        if (paramInt1 <= paramInt2) {
          l2 = l1;
        } else if (paramInt1 % 200 != 0) {}
      }
      try
      {
        Thread.sleep(100L);
        label209:
        k += 1;
        i = paramInt1;
        continue;
        l1 = l2;
        paramInt2 = j - paramInt2;
        break label242;
        paramInt1 = j;
        l1 = 0L;
        paramInt2 = m;
        label242:
        long l3 = System.currentTimeMillis();
        i = arrayOfFile.length - paramInt1;
        l2 = l1;
        paramInt1 = paramInt2;
        while (i < arrayOfFile.length)
        {
          localObject = arrayOfFile[i];
          paramInt2 = paramInt1;
          l1 = l2;
          if (((File)localObject).exists())
          {
            paramInt2 = paramInt1;
            l1 = l2;
            if (((File)localObject).isFile())
            {
              if (l3 - ((File)localObject).lastModified() <= 2592000000L) {
                break;
              }
              l2 += ((File)localObject).length();
              ((File)localObject).delete();
              paramInt1 += 1;
              paramInt2 = paramInt1;
              l1 = l2;
              if (i % 200 != 0) {}
            }
          }
          try
          {
            Thread.sleep(100L);
            l1 = l2;
            paramInt2 = paramInt1;
          }
          catch (InterruptedException localInterruptedException2)
          {
            for (;;)
            {
              paramInt2 = paramInt1;
              l1 = l2;
            }
          }
          i += 1;
          paramInt1 = paramInt2;
          l2 = l1;
        }
        i = paramInt1;
        if (paramFile == URLDrawableHelper.diskCachePath)
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("after onCleanCache diskCachePath delete ");
            paramFile.append(paramInt1);
            paramFile.append(" cache file(s) sumSize:");
            paramFile.append(l2 / 1024L / 1024L);
            QLog.d("QQInitHandler", 2, paramFile.toString());
          }
          i = paramInt1;
          if (paramInt1 > 0)
          {
            l1 = SharedPreUtils.a(this.mAutomator.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
            l2 = NetConnInfoCenter.getServerTime() / 3600L;
            if ((l1 != 0L) && (l2 > l1)) {
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CleanDiskCache", true, l2 - l1, paramInt1, null, "");
            }
            SharedPreUtils.a(this.mAutomator.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
            i = paramInt1;
          }
        }
        return i;
      }
      catch (InterruptedException localInterruptedException1)
      {
        break label209;
      }
    }
  }
  
  private int a(File[] paramArrayOfFile, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[paramInt1];
      if (localFile.exists()) {
        localFile.delete();
      }
      paramArrayOfFile[paramInt1] = null;
      i += 1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCleanCache->delRemainQQHead. delete QQHead,filePath=");
        localStringBuilder.append(localFile.getAbsolutePath());
        QLog.d("QQInitHandler", 2, localStringBuilder.toString());
      }
      if (i >= paramInt2) {
        return i;
      }
      paramInt1 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfFile = new StringBuilder();
      paramArrayOfFile.append("onCleanCache. after delRemainQQHead. totalCount=");
      paramArrayOfFile.append(paramInt3);
      paramArrayOfFile.append(", currNeedDelCount=");
      paramArrayOfFile.append(paramInt2);
      paramArrayOfFile.append(", delCount=");
      paramArrayOfFile.append(i);
      QLog.d("QQInitHandler", 2, paramArrayOfFile.toString());
    }
    return i;
  }
  
  /* Error */
  private void a(EntityManager paramEntityManager, List<Setting> paramList1, int paramInt1, List<Setting> paramList2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +401 -> 402
    //   4: iload_3
    //   5: iload 5
    //   7: if_icmple +395 -> 402
    //   10: aload 4
    //   12: astore 7
    //   14: aload 4
    //   16: ifnonnull +12 -> 28
    //   19: new 218	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 219	java/util/ArrayList:<init>	()V
    //   26: astore 7
    //   28: aload_2
    //   29: invokeinterface 225 1 0
    //   34: astore_2
    //   35: aload_2
    //   36: invokeinterface 230 1 0
    //   41: ifeq +243 -> 284
    //   44: aload_2
    //   45: invokeinterface 234 1 0
    //   50: checkcast 236	com/tencent/mobileqq/data/Setting
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull -22 -> 35
    //   60: aload 4
    //   62: getfield 239	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   65: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +6 -> 74
    //   71: goto -36 -> 35
    //   74: sipush 200
    //   77: istore 5
    //   79: aload 4
    //   81: getfield 249	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   84: bipush 32
    //   86: if_icmpne +13 -> 99
    //   89: sipush 202
    //   92: istore_3
    //   93: iconst_0
    //   94: istore 6
    //   96: goto +40 -> 136
    //   99: aload 4
    //   101: getfield 249	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   104: bipush 16
    //   106: if_icmpne +9 -> 115
    //   109: bipush 16
    //   111: istore_3
    //   112: goto -19 -> 93
    //   115: iload 5
    //   117: istore_3
    //   118: aload 4
    //   120: getfield 249	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   123: bipush 116
    //   125: if_icmpne -32 -> 93
    //   128: getstatic 254	com/tencent/mobileqq/extendfriend/apollo/face/IConst:a	I
    //   131: istore 6
    //   133: iload 5
    //   135: istore_3
    //   136: aload_0
    //   137: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   140: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   143: aload 4
    //   145: iload_3
    //   146: iload 6
    //   148: invokevirtual 263	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePathBySetting	(Lcom/tencent/mobileqq/data/Setting;II)Ljava/lang/String;
    //   151: astore 8
    //   153: aload 8
    //   155: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -123 -> 35
    //   161: new 30	java/io/File
    //   164: dup
    //   165: aload 8
    //   167: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: invokevirtual 37	java/io/File:exists	()Z
    //   173: ifne -138 -> 35
    //   176: aload 7
    //   178: aload 4
    //   180: invokeinterface 267 2 0
    //   185: pop
    //   186: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -154 -> 35
    //   192: new 54	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   199: astore 8
    //   201: aload 8
    //   203: ldc_w 269
    //   206: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 8
    //   212: aload 4
    //   214: getfield 239	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   217: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 8
    //   223: ldc_w 271
    //   226: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 8
    //   232: aload 4
    //   234: getfield 249	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   237: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 8
    //   243: ldc_w 271
    //   246: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 8
    //   252: aload_0
    //   253: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   256: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: aload 4
    //   261: iload_3
    //   262: iconst_0
    //   263: invokevirtual 263	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePathBySetting	(Lcom/tencent/mobileqq/data/Setting;II)Ljava/lang/String;
    //   266: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: ldc 70
    //   272: iconst_2
    //   273: aload 8
    //   275: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: goto -246 -> 35
    //   284: aload 7
    //   286: invokeinterface 275 1 0
    //   291: ifle +111 -> 402
    //   294: aload_1
    //   295: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   298: ifeq +104 -> 402
    //   301: aload_1
    //   302: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   305: invokevirtual 289	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   308: aload 7
    //   310: invokeinterface 225 1 0
    //   315: astore_2
    //   316: aload_2
    //   317: invokeinterface 230 1 0
    //   322: ifeq +32 -> 354
    //   325: aload_2
    //   326: invokeinterface 234 1 0
    //   331: checkcast 236	com/tencent/mobileqq/data/Setting
    //   334: astore 4
    //   336: aload 4
    //   338: ifnonnull +6 -> 344
    //   341: goto -25 -> 316
    //   344: aload_1
    //   345: aload 4
    //   347: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   350: pop
    //   351: goto -35 -> 316
    //   354: aload_1
    //   355: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   358: invokevirtual 296	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   361: goto +24 -> 385
    //   364: astore_2
    //   365: goto +28 -> 393
    //   368: astore_2
    //   369: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +13 -> 385
    //   375: ldc 70
    //   377: iconst_2
    //   378: ldc_w 269
    //   381: aload_2
    //   382: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   385: aload_1
    //   386: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   389: invokevirtual 303	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   392: return
    //   393: aload_1
    //   394: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   397: invokevirtual 303	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   400: aload_2
    //   401: athrow
    //   402: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	CleanCache
    //   0	403	1	paramEntityManager	EntityManager
    //   0	403	2	paramList1	List<Setting>
    //   0	403	3	paramInt1	int
    //   0	403	4	paramList2	List<Setting>
    //   0	403	5	paramInt2	int
    //   94	53	6	i	int
    //   12	297	7	localObject1	Object
    //   151	123	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   301	316	364	finally
    //   316	336	364	finally
    //   344	351	364	finally
    //   354	361	364	finally
    //   369	385	364	finally
    //   301	316	368	java/lang/Exception
    //   316	336	368	java/lang/Exception
    //   344	351	368	java/lang/Exception
    //   354	361	368	java/lang/Exception
  }
  
  public static final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".nomedia");
    paramString = new File(localStringBuilder.toString());
    if (!paramString.exists()) {
      try
      {
        paramString.createNewFile();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("create nomedia file:");
          localStringBuilder.append(paramString.getAbsolutePath());
          QLog.d("QQInitHandler", 2, localStringBuilder.toString());
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void a(List<Setting> paramList)
  {
    if (paramList != null)
    {
      Object localObject = paramList.iterator();
      int k = 0;
      int j = 0;
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        Setting localSetting = (Setting)((Iterator)localObject).next();
        if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)) && (localSetting != null)) {
          if ((localSetting.bSourceType != 1) && (localSetting.bUsrType != 32)) {
            j += 1;
          } else {
            i += 1;
          }
        }
      }
      localObject = new HashMap();
      if (paramList != null) {
        k = paramList.size();
      }
      ((HashMap)localObject).put("dataSize", String.valueOf(k));
      ((HashMap)localObject).put("highSize", String.valueOf(j));
      ((HashMap)localObject).put("lowSize", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mAutomator.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "qq_head_setting", false, 0L, 0L, (HashMap)localObject, "");
    }
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   7: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   13: invokevirtual 351	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: astore 8
    //   18: ldc 236
    //   20: invokevirtual 356	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   23: astore_1
    //   24: iconst_0
    //   25: istore 5
    //   27: aload 8
    //   29: iconst_0
    //   30: aload_1
    //   31: iconst_2
    //   32: anewarray 10	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 357
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc_w 358
    //   46: aastore
    //   47: ldc_w 360
    //   50: iconst_1
    //   51: anewarray 10	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 362
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 366	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 9
    //   69: aload 9
    //   71: ifnull +487 -> 558
    //   74: aload 9
    //   76: invokeinterface 371 1 0
    //   81: ifeq +477 -> 558
    //   84: new 323	java/util/HashMap
    //   87: dup
    //   88: aload 9
    //   90: invokeinterface 374 1 0
    //   95: invokespecial 377	java/util/HashMap:<init>	(I)V
    //   98: astore_1
    //   99: aload 9
    //   101: iconst_0
    //   102: invokeinterface 380 2 0
    //   107: astore 10
    //   109: aload 9
    //   111: iconst_1
    //   112: invokeinterface 384 2 0
    //   117: istore_2
    //   118: aload_0
    //   119: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   122: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: astore 11
    //   127: iload_2
    //   128: iconst_4
    //   129: if_icmpne +423 -> 552
    //   132: iconst_1
    //   133: istore 6
    //   135: goto +3 -> 138
    //   138: aload_1
    //   139: aload 11
    //   141: iload 6
    //   143: aload 10
    //   145: invokevirtual 388	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ZLjava/lang/String;)Ljava/lang/String;
    //   148: aload 10
    //   150: invokevirtual 334	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: aload 9
    //   156: invokeinterface 391 1 0
    //   161: ifne -62 -> 99
    //   164: goto +3 -> 167
    //   167: new 54	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   174: astore 10
    //   176: aload 10
    //   178: ldc_w 393
    //   181: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: ldc 236
    //   189: invokevirtual 356	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 10
    //   198: ldc_w 395
    //   201: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: aload 10
    //   209: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokevirtual 399	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   215: pop
    //   216: aload_1
    //   217: ifnull +357 -> 574
    //   220: aload_1
    //   221: invokevirtual 400	java/util/HashMap:size	()I
    //   224: ifle +350 -> 574
    //   227: iconst_0
    //   228: istore 4
    //   230: iconst_0
    //   231: istore_2
    //   232: iload_2
    //   233: istore_3
    //   234: iload 4
    //   236: aload 7
    //   238: arraylength
    //   239: if_icmpge +124 -> 363
    //   242: aload 7
    //   244: iload 4
    //   246: aaload
    //   247: astore 11
    //   249: aload 11
    //   251: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: astore 10
    //   256: iload_2
    //   257: istore_3
    //   258: aload_1
    //   259: aload 10
    //   261: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   264: ifeq +299 -> 563
    //   267: aload 11
    //   269: invokevirtual 37	java/io/File:exists	()Z
    //   272: ifeq +9 -> 281
    //   275: aload 11
    //   277: invokevirtual 126	java/io/File:delete	()Z
    //   280: pop
    //   281: aload 7
    //   283: iload 4
    //   285: aconst_null
    //   286: aastore
    //   287: iload_2
    //   288: iconst_1
    //   289: iadd
    //   290: istore_2
    //   291: iload_2
    //   292: istore_3
    //   293: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +267 -> 563
    //   299: new 54	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   306: astore 11
    //   308: aload 11
    //   310: ldc_w 405
    //   313: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 11
    //   319: aload_1
    //   320: aload 10
    //   322: invokevirtual 409	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast 10	java/lang/String
    //   328: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 11
    //   334: ldc_w 411
    //   337: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 11
    //   343: aload 10
    //   345: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: ldc 70
    //   351: iconst_2
    //   352: aload 11
    //   354: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: goto +205 -> 565
    //   363: aload 7
    //   365: astore_1
    //   366: iload_3
    //   367: ifle +62 -> 429
    //   370: aload 7
    //   372: arraylength
    //   373: iload_3
    //   374: isub
    //   375: anewarray 30	java/io/File
    //   378: astore_1
    //   379: iconst_0
    //   380: istore_3
    //   381: iload 5
    //   383: istore_2
    //   384: iload_2
    //   385: aload 7
    //   387: arraylength
    //   388: if_icmpge +41 -> 429
    //   391: iload_3
    //   392: aload_1
    //   393: arraylength
    //   394: if_icmpge +35 -> 429
    //   397: iload_3
    //   398: istore 4
    //   400: aload 7
    //   402: iload_2
    //   403: aaload
    //   404: ifnull +15 -> 419
    //   407: aload_1
    //   408: iload_3
    //   409: aload 7
    //   411: iload_2
    //   412: aaload
    //   413: aastore
    //   414: iload_3
    //   415: iconst_1
    //   416: iadd
    //   417: istore 4
    //   419: iload_2
    //   420: iconst_1
    //   421: iadd
    //   422: istore_2
    //   423: iload 4
    //   425: istore_3
    //   426: goto -42 -> 384
    //   429: aload 9
    //   431: ifnull +10 -> 441
    //   434: aload 9
    //   436: invokeinterface 414 1 0
    //   441: aload 8
    //   443: ifnull +8 -> 451
    //   446: aload 8
    //   448: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   451: aload_1
    //   452: areturn
    //   453: astore_1
    //   454: aload 9
    //   456: astore 7
    //   458: goto +29 -> 487
    //   461: aload 9
    //   463: astore_1
    //   464: goto +53 -> 517
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 7
    //   471: goto +16 -> 487
    //   474: aconst_null
    //   475: astore_1
    //   476: goto +41 -> 517
    //   479: astore_1
    //   480: aconst_null
    //   481: astore 8
    //   483: aload 8
    //   485: astore 7
    //   487: aload 7
    //   489: ifnull +10 -> 499
    //   492: aload 7
    //   494: invokeinterface 414 1 0
    //   499: aload 8
    //   501: ifnull +8 -> 509
    //   504: aload 8
    //   506: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   509: aload_1
    //   510: athrow
    //   511: aconst_null
    //   512: astore 8
    //   514: aload 8
    //   516: astore_1
    //   517: aload_1
    //   518: ifnull +9 -> 527
    //   521: aload_1
    //   522: invokeinterface 414 1 0
    //   527: aload 8
    //   529: ifnull +8 -> 537
    //   532: aload 8
    //   534: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   537: aload 7
    //   539: areturn
    //   540: astore_1
    //   541: goto -30 -> 511
    //   544: astore_1
    //   545: goto -71 -> 474
    //   548: astore_1
    //   549: goto -88 -> 461
    //   552: iconst_0
    //   553: istore 6
    //   555: goto -417 -> 138
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -393 -> 167
    //   563: iload_3
    //   564: istore_2
    //   565: iload 4
    //   567: iconst_1
    //   568: iadd
    //   569: istore 4
    //   571: goto -339 -> 232
    //   574: iconst_0
    //   575: istore_3
    //   576: goto -213 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	CleanCache
    //   0	579	1	paramArrayOfFile	File[]
    //   117	448	2	i	int
    //   233	343	3	j	int
    //   228	342	4	k	int
    //   25	357	5	m	int
    //   133	421	6	bool	boolean
    //   1	537	7	localObject1	Object
    //   16	517	8	localEntityManager	EntityManager
    //   67	395	9	localCursor	android.database.Cursor
    //   107	237	10	localObject2	Object
    //   125	228	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	99	453	finally
    //   99	127	453	finally
    //   138	164	453	finally
    //   167	216	453	finally
    //   220	227	453	finally
    //   234	242	453	finally
    //   249	256	453	finally
    //   258	281	453	finally
    //   293	360	453	finally
    //   370	379	453	finally
    //   384	397	453	finally
    //   18	24	467	finally
    //   27	69	467	finally
    //   3	18	479	finally
    //   3	18	540	java/lang/Exception
    //   18	24	544	java/lang/Exception
    //   27	69	544	java/lang/Exception
    //   74	99	548	java/lang/Exception
    //   99	127	548	java/lang/Exception
    //   138	164	548	java/lang/Exception
    //   167	216	548	java/lang/Exception
    //   220	227	548	java/lang/Exception
    //   234	242	548	java/lang/Exception
    //   249	256	548	java/lang/Exception
    //   258	281	548	java/lang/Exception
    //   293	360	548	java/lang/Exception
    //   370	379	548	java/lang/Exception
    //   384	397	548	java/lang/Exception
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 417	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 418	java/util/LinkedList:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   13: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   19: invokevirtual 351	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   22: astore 8
    //   24: iconst_0
    //   25: istore 7
    //   27: aload 8
    //   29: ldc_w 420
    //   32: iconst_0
    //   33: ldc_w 422
    //   36: iconst_1
    //   37: anewarray 10	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc_w 424
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 427	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   53: checkcast 218	java/util/ArrayList
    //   56: astore 10
    //   58: aload 10
    //   60: ifnull +67 -> 127
    //   63: aload 10
    //   65: invokevirtual 428	java/util/ArrayList:size	()I
    //   68: ifeq +59 -> 127
    //   71: iconst_0
    //   72: istore 4
    //   74: iload 4
    //   76: aload 10
    //   78: invokevirtual 428	java/util/ArrayList:size	()I
    //   81: if_icmpge +46 -> 127
    //   84: aload 10
    //   86: iload 4
    //   88: invokevirtual 431	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   91: checkcast 420	com/tencent/mobileqq/data/Friends
    //   94: astore 11
    //   96: aload 9
    //   98: aload_0
    //   99: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   102: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: iconst_0
    //   106: aload 11
    //   108: getfield 432	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   111: invokevirtual 388	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ZLjava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual 433	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload 4
    //   120: iconst_1
    //   121: iadd
    //   122: istore 4
    //   124: goto -50 -> 74
    //   127: aload 8
    //   129: ldc_w 435
    //   132: iconst_0
    //   133: aconst_null
    //   134: aconst_null
    //   135: aconst_null
    //   136: aconst_null
    //   137: aconst_null
    //   138: aconst_null
    //   139: invokevirtual 427	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   142: checkcast 218	java/util/ArrayList
    //   145: astore 10
    //   147: aload 10
    //   149: ifnull +325 -> 474
    //   152: aload 10
    //   154: invokevirtual 428	java/util/ArrayList:size	()I
    //   157: ifle +317 -> 474
    //   160: iconst_0
    //   161: istore 4
    //   163: iload 4
    //   165: aload 10
    //   167: invokevirtual 428	java/util/ArrayList:size	()I
    //   170: if_icmpge +304 -> 474
    //   173: aload 10
    //   175: iload 4
    //   177: invokevirtual 431	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: checkcast 435	com/tencent/mobileqq/data/troop/TroopInfo
    //   183: astore 11
    //   185: aload 9
    //   187: aload_0
    //   188: getfield 160	com/tencent/mobileqq/app/automator/step/CleanCache:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   191: getfield 257	com/tencent/mobileqq/app/automator/Automator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   194: iconst_1
    //   195: aload 11
    //   197: getfield 438	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   200: invokevirtual 388	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ZLjava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 433	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   206: pop
    //   207: iload 4
    //   209: iconst_1
    //   210: iadd
    //   211: istore 4
    //   213: goto -50 -> 163
    //   216: iload 4
    //   218: istore 6
    //   220: iload 5
    //   222: aload_1
    //   223: arraylength
    //   224: if_icmpge +122 -> 346
    //   227: aload_1
    //   228: iload 5
    //   230: aaload
    //   231: astore 10
    //   233: aload 10
    //   235: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   238: astore 11
    //   240: aload 9
    //   242: aload 11
    //   244: invokevirtual 441	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   247: ifne +251 -> 498
    //   250: aload 11
    //   252: ldc_w 443
    //   255: invokevirtual 447	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   258: ifge +240 -> 498
    //   261: aload 11
    //   263: ldc_w 449
    //   266: invokevirtual 447	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   269: ifge +229 -> 498
    //   272: aload 10
    //   274: invokevirtual 37	java/io/File:exists	()Z
    //   277: ifeq +9 -> 286
    //   280: aload 10
    //   282: invokevirtual 126	java/io/File:delete	()Z
    //   285: pop
    //   286: aload_1
    //   287: iload 5
    //   289: aconst_null
    //   290: aastore
    //   291: iload 4
    //   293: iconst_1
    //   294: iadd
    //   295: istore 6
    //   297: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +183 -> 483
    //   303: new 54	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   310: astore 11
    //   312: aload 11
    //   314: ldc_w 451
    //   317: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 11
    //   323: aload 10
    //   325: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   328: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: ldc 70
    //   334: iconst_2
    //   335: aload 11
    //   337: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: goto +140 -> 483
    //   346: aload_1
    //   347: astore 9
    //   349: iload 6
    //   351: ifle +62 -> 413
    //   354: aload_1
    //   355: arraylength
    //   356: iload 6
    //   358: isub
    //   359: anewarray 30	java/io/File
    //   362: astore 9
    //   364: iconst_0
    //   365: istore_3
    //   366: iload 7
    //   368: istore_2
    //   369: iload_2
    //   370: aload_1
    //   371: arraylength
    //   372: if_icmpge +41 -> 413
    //   375: iload_3
    //   376: aload 9
    //   378: arraylength
    //   379: if_icmpge +34 -> 413
    //   382: iload_3
    //   383: istore 4
    //   385: aload_1
    //   386: iload_2
    //   387: aaload
    //   388: ifnull +15 -> 403
    //   391: aload 9
    //   393: iload_3
    //   394: aload_1
    //   395: iload_2
    //   396: aaload
    //   397: aastore
    //   398: iload_3
    //   399: iconst_1
    //   400: iadd
    //   401: istore 4
    //   403: iload_2
    //   404: iconst_1
    //   405: iadd
    //   406: istore_2
    //   407: iload 4
    //   409: istore_3
    //   410: goto -41 -> 369
    //   413: aload 8
    //   415: ifnull +8 -> 423
    //   418: aload 8
    //   420: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   423: aload 9
    //   425: areturn
    //   426: astore_1
    //   427: goto +10 -> 437
    //   430: goto +22 -> 452
    //   433: astore_1
    //   434: aconst_null
    //   435: astore 8
    //   437: aload 8
    //   439: ifnull +8 -> 447
    //   442: aload 8
    //   444: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   447: aload_1
    //   448: athrow
    //   449: aconst_null
    //   450: astore 8
    //   452: aload 8
    //   454: ifnull +8 -> 462
    //   457: aload 8
    //   459: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   462: aload_1
    //   463: areturn
    //   464: astore 8
    //   466: goto -17 -> 449
    //   469: astore 9
    //   471: goto -41 -> 430
    //   474: iconst_0
    //   475: istore 5
    //   477: iconst_0
    //   478: istore 4
    //   480: goto -264 -> 216
    //   483: iload 6
    //   485: istore 4
    //   487: iload_2
    //   488: iload 6
    //   490: iadd
    //   491: iload_3
    //   492: if_icmplt +6 -> 498
    //   495: goto -149 -> 346
    //   498: iload 5
    //   500: iconst_1
    //   501: iadd
    //   502: istore 5
    //   504: goto -288 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	CleanCache
    //   0	507	1	paramArrayOfFile	File[]
    //   0	507	2	paramInt1	int
    //   0	507	3	paramInt2	int
    //   72	414	4	i	int
    //   220	283	5	j	int
    //   218	273	6	k	int
    //   25	342	7	m	int
    //   22	436	8	localEntityManager	EntityManager
    //   464	1	8	localException1	Exception
    //   7	417	9	localObject1	Object
    //   469	1	9	localException2	Exception
    //   56	268	10	localObject2	Object
    //   94	242	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	58	426	finally
    //   63	71	426	finally
    //   74	118	426	finally
    //   127	147	426	finally
    //   152	160	426	finally
    //   163	207	426	finally
    //   220	227	426	finally
    //   233	286	426	finally
    //   297	343	426	finally
    //   354	364	426	finally
    //   369	382	426	finally
    //   0	24	433	finally
    //   0	24	464	java/lang/Exception
    //   27	58	469	java/lang/Exception
    //   63	71	469	java/lang/Exception
    //   74	118	469	java/lang/Exception
    //   127	147	469	java/lang/Exception
    //   152	160	469	java/lang/Exception
    //   163	207	469	java/lang/Exception
    //   220	227	469	java/lang/Exception
    //   233	286	469	java/lang/Exception
    //   297	343	469	java/lang/Exception
    //   354	364	469	java/lang/Exception
    //   369	382	469	java/lang/Exception
  }
  
  private void d()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.PATH_HEAD_STRANGER;
    arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_stranger/";
    int m = arrayOfString.length;
    int i = 0;
    while (i < m)
    {
      Object localObject1 = new File(arrayOfString[i]);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 300))
        {
          Arrays.sort((Object[])localObject1, new CleanCache.5(this));
          int n = localObject1.length;
          int j = 0;
          int k = 0;
          while (j < n)
          {
            Object localObject2 = localObject1[j];
            if (localObject2.exists()) {
              localObject2.delete();
            }
            localObject1[j] = null;
            k += 1;
            if (n - k <= 20) {
              break;
            }
            j += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "onCleanCache. delete stranger head...");
          }
        }
      }
      i += 1;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanZhituCache...");
    }
    long l1 = System.currentTimeMillis();
    if (ZhituManager.f()) {
      return;
    }
    ZhituManager.d(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("zhitu");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append((String)localObject);
    localStringBuilder1.append("/");
    localStringBuilder1.append("origin/");
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder1.toString()));
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int k = localObject.length;
        i = k;
        if (k <= 200) {
          break label302;
        }
        Arrays.sort((Object[])localObject, new CleanCache.8(this));
        int i1 = localObject.length;
        int m = 0;
        i = 0;
        for (;;)
        {
          n = k;
          j = i;
          if (m >= i1) {
            break;
          }
          localStringBuilder1 = localObject[m];
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("cleanZhituCache ===> deleteCount=");
            localStringBuilder2.append(i);
            localStringBuilder2.append(", delete dir=");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.d("QQInitHandler", 2, localStringBuilder2.toString());
          }
          FileUtils.deleteDirectory(localStringBuilder1.getAbsolutePath());
          i += 1;
          if (i >= k - 50)
          {
            n = k;
            j = i;
            break;
          }
          m += 1;
        }
      }
    }
    int i = 0;
    label302:
    int j = 0;
    int n = i;
    long l2 = System.currentTimeMillis();
    ZhituManager.d(false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delShortVideoCache(), totalCount=");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", deleteCount= ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", targetDeleteCount=");
      ((StringBuilder)localObject).append(n - 50);
      ((StringBuilder)localObject).append(", cost: ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" ms");
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanLightVideoCache...");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(CameraCaptureView.CaptureParam.a);
    boolean bool = ((File)localObject1).exists();
    int j = 0;
    int k = 0;
    if ((bool) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int m = localObject1.length;
        i = m;
        if (m <= 25) {
          break label221;
        }
        Arrays.sort((Object[])localObject1, new CleanCache.9(this));
        int n = localObject1.length;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= n) {
            break;
          }
          Object localObject2 = localObject1[k];
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cleanLightVideoCache ===> deleteCount=");
            localStringBuilder.append(i);
            localStringBuilder.append(", delete dir=");
            localStringBuilder.append(localObject2.getAbsolutePath());
            QLog.d("QQInitHandler", 2, localStringBuilder.toString());
          }
          FileUtils.deleteDirectory(localObject2.getAbsolutePath());
          i += 1;
          if (i >= m - 10)
          {
            j = i;
            break;
          }
          k += 1;
        }
        i = m;
        break label221;
      }
    }
    int i = 0;
    label221:
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cleanLightVideoCache(), totalCount=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", deleteCount= ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", targetDeleteCount=");
      ((StringBuilder)localObject1).append(i - 10);
      ((StringBuilder)localObject1).append(", cost: ");
      ((StringBuilder)localObject1).append(l2 - l1);
      ((StringBuilder)localObject1).append(" ms");
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void g()
  {
    Object localObject2 = new File(HotPicDownLoader.a);
    Object localObject1 = ((File)localObject2).listFiles();
    int i;
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      int j = localObject1.length;
      i = 500;
      if (j <= 500) {}
    }
    try
    {
      Arrays.sort((Object[])localObject1, new CleanCache.10(this));
    }
    catch (Exception localException)
    {
      label63:
      Object localObject3;
      File localFile;
      break label63;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Arrays.sort error");
    }
    localObject2 = new HashSet();
    if (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    localObject3 = ((LinkedList)HotPicManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().clone()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localFile = HotPicDownLoader.a(((HotPicData)((Iterator)localObject3).next()).url);
      if (localFile != null) {
        ((Set)localObject2).add(localFile);
      }
    }
    localObject3 = new ArrayList();
    while (i < localObject1.length)
    {
      localFile = localObject1[i];
      if (((Set)localObject2).contains(localFile)) {
        ((Set)localObject2).remove(localFile);
      } else {
        ((List)localObject3).add(localFile);
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cleanResource,delete files count:");
      ((StringBuilder)localObject1).append(((List)localObject3).size());
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = ((List)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((File)((Iterator)localObject1).next()).delete();
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "initNoMediaFile");
    }
    CardHandler.c();
    FileManagerUtil.a();
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (FileUtils.fileExists(str)) {
        a(str);
      }
      i += 1;
    }
  }
  
  void b()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQCrashReportManager.b);
      ((StringBuilder)localObject).append("crashinfo/");
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles(new CleanCache.6(this));
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 10;
          if (j > 10)
          {
            Arrays.sort((Object[])localObject, new CleanCache.7(this));
            while (i < localObject.length)
            {
              localObject[i].delete();
              i += 1;
            }
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
  
  void c()
  {
    EntityManager localEntityManager = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0").split("\\|");
    int j;
    if (arrayOfString.length > 1) {
      try
      {
        j = Integer.parseInt(arrayOfString[1]);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQInitHandler", 2, "cleanSetingData,", localException);
        }
      }
    } else {
      j = 3500;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append(",");
      localStringBuilder.append(j);
      QLog.d("QQInitHandler", 2, new Object[] { "cleanSetingData", localStringBuilder.toString() });
    }
    a(localEntityManager, localList, i, localArrayList, j);
    a(localList);
  }
  
  protected int doStep()
  {
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("HEAD", 0).edit().clear().commit();
    a();
    ThreadManager.post(new CleanCache.1(this), 2, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache
 * JD-Core Version:    0.7.0.1
 */