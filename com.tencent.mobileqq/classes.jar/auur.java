import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloaderAppBabySdk.1;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloaderAppBabySdk.2;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloaderAppBabySdk.3;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class auur
{
  private static auur jdField_a_of_type_Auur;
  public static String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new auus(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private Map<String, auut> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderAppBabySdk<FileAssistant>";
  }
  
  private int a(String paramString, auut paramauut)
  {
    if ((paramauut == null) || (paramString == null)) {
      return -1;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return -2;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramauut);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramauut.jdField_a_of_type_Long + "] addDownloadCtx...total:[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url:[ " + paramString + "]");
    return 0;
  }
  
  public static auur a()
  {
    try
    {
      if (jdField_a_of_type_Auur == null) {
        jdField_a_of_type_Auur = new auur();
      }
      auur localauur = jdField_a_of_type_Auur;
      return localauur;
    }
    finally {}
  }
  
  private auut a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (auut)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (0L == paramLong) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("flowstat", 2, "fileType:" + 5 + ",busiType:" + 0);
    }
    QQAppInterface localQQAppInterface = aure.a().a();
    if (localQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. reportFlow failed.APP=null");
      return;
    }
    localQQAppInterface.sendAppDataIncerment(localQQAppInterface.getAccount(), false, paramInt, 5, 0, paramLong);
  }
  
  private void a(auut paramauut, int paramInt, String paramString)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>handleDownloadSDKTaskStateFailed. errCode:" + paramInt + " errStr" + paramString);
    int i = 5;
    auuk.a(5);
    if (!bhnv.d(BaseApplication.getContext()))
    {
      paramInt = 2;
      paramString = auuk.a(paramInt);
      if (paramauut != null)
      {
        a(paramauut.b(), paramauut.jdField_b_of_type_Int);
        paramauut.b(0L);
        if (paramauut.jdField_a_of_type_Auuq != null)
        {
          Bundle localBundle = new auuu(paramauut.a(), paramauut.a()).a();
          paramauut.jdField_a_of_type_Auuq.a(paramInt, paramString, localBundle);
        }
      }
      return;
    }
    if (601 == paramInt)
    {
      i = 38;
      label132:
      if (!bhjr.a()) {
        break label453;
      }
    }
    label453:
    for (long l = bhjr.a() * 1024L;; l = bhjr.b() * 1024L)
    {
      paramInt = i;
      if (paramauut == null) {
        break;
      }
      paramInt = i;
      if (l >= paramauut.jdField_b_of_type_Long - paramauut.a()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramauut.jdField_a_of_type_Long + "] write file failed.  space is no enough:[" + paramauut.jdField_b_of_type_Long + " " + paramauut.a() + " " + l + "]");
      paramInt = 9;
      break;
      if (702 == paramInt)
      {
        i = 23;
        break label132;
      }
      if (600 == paramInt)
      {
        i = 24;
        break label132;
      }
      if (paramInt == 0)
      {
        i = 25;
        break label132;
      }
      if (704 == paramInt)
      {
        i = 26;
        break label132;
      }
      if (706 == paramInt)
      {
        i = 27;
        break label132;
      }
      if (709 == paramInt)
      {
        i = 28;
        break label132;
      }
      if (701 == paramInt)
      {
        i = 29;
        break label132;
      }
      if (707 == paramInt)
      {
        i = 30;
        break label132;
      }
      if (602 == paramInt)
      {
        i = 31;
        break label132;
      }
      if (705 == paramInt)
      {
        i = 32;
        break label132;
      }
      if (604 == paramInt)
      {
        i = 39;
        break label132;
      }
      if (603 == paramInt)
      {
        i = 34;
        break label132;
      }
      if (708 == paramInt)
      {
        i = 35;
        break label132;
      }
      if (700 == paramInt)
      {
        i = 36;
        break label132;
      }
      if (703 != paramInt) {
        break label132;
      }
      i = 37;
      break label132;
    }
  }
  
  private void a(String paramString)
  {
    e();
    auut localauut = a(paramString);
    if (localauut == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. not found ctx.url:" + paramString);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.client = null");
    } while (localauut.jdField_a_of_type_Auuq == null);
    paramString = new auuu(0L, localauut.a()).a();
    localauut.jdField_a_of_type_Auuq.a(41, auuk.a(41), paramString);
    return;
    Object localObject1 = AppNetConnInfo.getRecentNetworkInfo();
    if (localObject1 != null) {
      localauut.jdField_b_of_type_Int = ((NetworkInfo)localObject1).getType();
    }
    int i;
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 2))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.but it is downloading.url = " + paramString);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        Object localObject2 = null;
      }
      i = 0;
      try
      {
        int j = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString, "application/vnd.android.package-archive");
        i = j;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.startDownloadTask. url = " + paramString);
        i = j;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        if (4 != i) {
          break label267;
        }
        a(paramString, localauut);
        return;
        a(paramString, localauut, i);
      }
      if (i == 0)
      {
        b(paramString, localauut);
        return;
      }
    }
    label267:
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPRunABSdkDownloadCmd.cmd:" + paramInt + " url = " + paramString);
    switch (paramInt)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPRunABSdkDownloadCmd, errcmd: " + paramInt);
      return;
    case 1: 
      a(paramString);
      return;
    case 2: 
      b(paramString);
      return;
    }
    c(paramString);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    auut localauut = a(paramString1);
    if (localauut == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged. not found ctx.  state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  unkown state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
              return;
            case 1: 
              QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[WAITING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
            }
          } while ((localauut == null) || (localauut.jdField_a_of_type_Auuq == null));
          localauut.jdField_a_of_type_Auuq.c(null);
          return;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[DOWNLOADING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        } while ((localauut == null) || (localauut.jdField_a_of_type_Auuq == null));
        localauut.jdField_a_of_type_Auuq.a(null);
        return;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[FAILED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        localauut.a(2);
        a(localauut.b(), localauut.jdField_b_of_type_Int);
        localauut.b(0L);
        a(localauut, paramInt2, paramString2);
        return;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[SUCCEED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        localauut.a(2);
        a(localauut.b(), localauut.jdField_b_of_type_Int);
        localauut.b(0L);
        d(paramString1);
      } while ((localauut == null) || (localauut.jdField_a_of_type_Auuq == null));
      paramString1 = new auuu(localauut.a(), localauut.a()).a();
      localauut.jdField_a_of_type_Auuq.a(paramString3, paramString1);
      return;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[PAUSED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
      localauut.a(2);
      a(localauut.b(), localauut.jdField_b_of_type_Int);
      localauut.b(0L);
    } while ((localauut == null) || (localauut.jdField_a_of_type_Auuq == null));
    localauut.jdField_a_of_type_Auuq.b(null);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>inPPDwonloadSDKErr errcode:" + paramInt + " errStr:" + paramString2 + " url:" + paramString1);
    auut localauut = a(paramString1);
    if (localauut == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateFailed. not found ctx.  errcode:[" + paramInt + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    }
    do
    {
      return;
      localauut.a(2);
      a(localauut.b(), localauut.jdField_b_of_type_Int);
      localauut.b(0L);
    } while (localauut.jdField_a_of_type_Auuq == null);
    paramString1 = new auuu(localauut.a(), localauut.a()).a();
    localauut.jdField_a_of_type_Auuq.a(paramInt, paramString2, paramString1);
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    auut localauut = a(paramString);
    if (localauut != null)
    {
      localauut.b(paramLong1 - localauut.a() + localauut.b());
      localauut.a(paramLong1);
      if (localauut.jdField_a_of_type_Auuq != null) {
        localauut.jdField_a_of_type_Auuq.a(i, null);
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskProgressChanged. not found ctx, url: " + paramString);
  }
  
  private void a(String paramString, auut paramauut)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. file existed. sucess dricetly. url = " + paramString);
    paramauut.a(2);
    for (;;)
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
      try
      {
        localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
        d(paramString);
        if (paramauut != null)
        {
          paramauut.a(paramauut.jdField_b_of_type_Long);
          if (paramauut.jdField_a_of_type_Auuq != null)
          {
            Bundle localBundle = new auuu(0L, paramauut.a()).a();
            paramauut = paramauut.jdField_a_of_type_Auuq;
            if (localTMAssistantDownloadTaskInfo != null) {
              break label171;
            }
            paramString = null;
            paramauut.a(paramString, localBundle);
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (paramauut == null) {
          continue;
        }
        a(paramauut.b(), paramauut.jdField_b_of_type_Int);
        paramauut.b(0L);
        if (paramauut.jdField_a_of_type_Auuq == null) {
          continue;
        }
        paramString = new auuu(0L, paramauut.a()).a();
        paramauut.jdField_a_of_type_Auuq.a(20, auuk.a(20), paramString);
        return;
      }
      label171:
      paramString = localTMAssistantDownloadTaskInfo.mSavePath;
    }
  }
  
  private void a(String paramString, auut paramauut, int paramInt)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. task failed. result:" + paramInt + ". url = " + paramString);
    paramauut.a(2);
    int i = 15;
    paramString = "start failed";
    if (5 == paramInt)
    {
      i = 16;
      paramString = "busy";
    }
    for (;;)
    {
      if ((paramauut != null) && (paramauut.jdField_a_of_type_Auuq != null))
      {
        Bundle localBundle = new auuu(0L, paramauut.a()).a();
        paramauut.jdField_a_of_type_Auuq.a(i, paramString, localBundle);
      }
      return;
      if (1 == paramInt)
      {
        i = 17;
        paramString = "net broken";
      }
      else if (2 == paramInt)
      {
        i = 18;
        paramString = "set only for wifi";
      }
      else if (3 == paramInt)
      {
        i = 19;
        paramString = "param err";
      }
    }
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DL_ABSdkThread");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>start thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(String paramString)
  {
    e();
    auut localauut = a(paramString);
    if (localauut == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload. not found ctx.url:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload.client = null");
      if ((localauut != null) && (localauut.jdField_a_of_type_Auuq != null))
      {
        paramString = new auuu(0L, localauut.a()).a();
        localauut.jdField_a_of_type_Auuq.a(41, auuk.a(41), paramString);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
          if (localTMAssistantDownloadTaskInfo != null)
          {
            try
            {
              this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
            if (localauut == null) {
              continue;
            }
            a(localauut.b(), localauut.jdField_b_of_type_Int);
            localauut.b(0L);
            if (localauut.jdField_a_of_type_Auuq == null) {
              continue;
            }
            paramString = new auuu(localauut.a(), localauut.a()).a();
            localauut.jdField_a_of_type_Auuq.a(21, auuk.a(21), paramString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (localauut != null)
            {
              a(localauut.b(), localauut.jdField_b_of_type_Int);
              localauut.b(0L);
              if (localauut.jdField_a_of_type_Auuq != null)
              {
                localBundle = new auuu(localauut.a(), localauut.a()).a();
                localauut.jdField_a_of_type_Auuq.a(20, auuk.a(20), localBundle);
              }
            }
            Bundle localBundle = null;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload. no run load");
        }
      }
    } while ((localauut == null) || (localauut.jdField_a_of_type_Auuq == null));
    localauut.jdField_a_of_type_Auuq.b(null);
  }
  
  private void b(String paramString, auut paramauut)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload success.. url = " + paramString);
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if ((paramauut != null) && (localTMAssistantDownloadTaskInfo != null))
      {
        long l = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        paramauut.a(l);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload success. rSize:" + l + " url = " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        do
        {
          paramString.printStackTrace();
        } while (paramauut == null);
        a(paramauut.b(), paramauut.jdField_b_of_type_Int);
        paramauut.b(0L);
      } while (paramauut.jdField_a_of_type_Auuq == null);
      paramString = new auuu(0L, paramauut.a()).a();
      paramauut.jdField_a_of_type_Auuq.a(20, auuk.a(20), paramString);
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_a_of_type_AndroidOsHandler = null;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>stop thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString)
  {
    e();
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload.client = null");
      return;
    }
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (localTMAssistantDownloadTaskInfo == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.cancelDownloadTask(paramString);
          d(paramString);
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          Object localObject = null;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload. no run load");
      }
    }
  }
  
  private int d(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      auut localauut = (auut)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + localauut.jdField_a_of_type_Long + "] delDownloadCtx...total:[" + i + "] add it. url:[ " + paramString + "]");
      return i;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i == 0)
      {
        c();
        a();
      }
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>create ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("UF_DL_CLIENT");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    }
  }
  
  private void f()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>inPDwonloadSDKServiceInvalid service invalid ");
    a();
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localObject3 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      if (((Iterator)localObject3).hasNext()) {
        localArrayList.add((auut)((Iterator)localObject3).next());
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      auut localauut = (auut)((Iterator)???).next();
      if (localauut != null)
      {
        a(localauut.b(), localauut.jdField_b_of_type_Int);
        localauut.b(0L);
        if (localauut.jdField_a_of_type_Auuq != null)
        {
          localObject3 = new auuu(localauut.a(), localauut.a()).a();
          localauut.jdField_a_of_type_Auuq.a(10, auuk.a(10), (Bundle)localObject3);
        }
      }
    }
  }
  
  public int a(long paramLong1, String paramString, long paramLong2, auuq paramauuq)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] [" + paramLong1 + "] initADownload, url = null");
      return -1;
    }
    auut localauut = new auut(this, paramLong1, paramString, paramLong2);
    localauut.jdField_a_of_type_Auuq = paramauuq;
    int i = a(paramString, localauut);
    if (i != 0)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]  [" + paramLong1 + "] initADownload failed:" + i);
      return -2;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload, url = null");
      return -1;
    }
    auut localauut = a(paramString);
    if (localauut == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload, not exsit download,url = " + paramString);
      return -2;
    }
    localauut.a(1);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.1(this, paramString)))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload.post failed url = " + paramString);
      localauut.a(2);
      return -3;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>release ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = null;
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).releaseDownloadSDKClient("UF_DL_CLIENT");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] releaseABSdkClient. client had be stoped");
  }
  
  public boolean a(String paramString)
  {
    return a(paramString) != null;
  }
  
  public int b(String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload, url = null");
      return -1;
    }
    auut localauut = a(paramString);
    if (localauut == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload, not exsit download,url = " + paramString);
      return -2;
    }
    localauut.a(2);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.2(this, paramString)))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload.post failed url = " + paramString);
      return -3;
    }
    return 0;
  }
  
  public int c(String paramString)
  {
    int i = 0;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, url = null");
      i = -1;
    }
    do
    {
      return i;
      auut localauut = a(paramString);
      if (localauut == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, not exsit download,url = " + paramString);
        return 0;
      }
      localauut.a(2);
      b();
    } while (this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.3(this, paramString)));
    d(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, post failed,url = " + paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auur
 * JD-Core Version:    0.7.0.1
 */