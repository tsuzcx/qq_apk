import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bkle
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, HttpEngineTask.IHttpEngineTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bklg> b;
  private HashMap<String, HttpEngineTask> c;
  
  public bkle(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)paramQQAppInterface.getManager(193));
  }
  
  private int a(String paramString)
  {
    if ("qqreaderplugin.apk".equals(paramString)) {
      return 10010;
    }
    if ("comic_plugin.apk".equals(paramString)) {
      return 10011;
    }
    if ("qqdataline.apk".equals(paramString)) {
      return 10013;
    }
    if ("qqsmartdevice.apk".equals(paramString)) {
      return 10014;
    }
    if ("qlink_plugin.apk".equals(paramString)) {
      return 10060;
    }
    return 10058;
  }
  
  public static final File a(Context paramContext)
  {
    paramContext = new File(new File(new File(paramContext.getFilesDir(), "pddata"), "prd"), "plugin_download");
    paramContext.mkdirs();
    return paramContext;
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    String str = (String)paramNetReq.getUserData();
    if (paramInt2 > 0)
    {
      paramNetReq = (bklg)this.b.get(str);
      if (paramNetReq == null) {
        break label95;
      }
    }
    label95:
    for (paramNetReq = bklg.a(paramNetReq);; paramNetReq = null)
    {
      if (paramNetReq != null) {
        paramNetReq.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bklg localbklg = (bklg)this.b.remove(str);
      if (localbklg != null)
      {
        if (bklg.a(localbklg) != null) {
          ((PreDownloadController)localObject).preDownloadSuccess(bklg.a(localbklg).mReqUrl, paramNetResp.mTotalFileLen);
        }
        localObject = bklg.a(localbklg);
        a(str, paramNetResp);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramNetResp.mResult + "," + str + ", " + paramNetResp.mTotalFileLen);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramNetResp.mErrCode + ", " + paramNetResp.mErrDesc);
          }
        }
        if (localObject != null) {
          ((bklh)localObject).a(bool, str);
        }
      }
      return;
    }
  }
  
  private void a(File paramFile, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + paramString);
    }
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramFile[i];
          String str = localObject.getPath();
          if ((str == null) || (!str.startsWith(paramString))) {}
          for (;;)
          {
            i += 1;
            break;
            if (!str.endsWith(".cfg")) {
              if (str.equals(paramString))
              {
                if (paramBoolean)
                {
                  localObject.delete();
                  if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                  }
                }
              }
              else
              {
                localObject.delete();
                if (QLog.isColorLevel()) {
                  QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, HttpNetReq paramHttpNetReq, bklh parambklh, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if (parambklh != null) {
      parambklh.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (HttpEngineTask)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(((HttpEngineTask)localObject).httpReq.mReqUrl);
      }
      localObject = new bklg(null);
      bklg.a((bklg)localObject, paramHttpNetReq);
      bklg.a((bklg)localObject, parambklh);
      bklg.a((bklg)localObject, paramAbsPreDownloadTask);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, NetResp paramNetResp)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramNetResp.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
      localHashMap.put("mErrDesc", paramNetResp.mErrDesc);
      Object localObject = paramNetResp.mReq;
      if ((paramNetResp.mResult != 0) && (localObject != null) && ((localObject instanceof HttpNetReq))) {
        localHashMap.put("Url", ((HttpNetReq)localObject).mReqUrl);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramNetResp.mRespProperties.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.mRespProperties.get("param_reqHeader"));
      localObject = StatisticCollector.getInstance(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramNetResp.mResult == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject).collectPerformance(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      HttpEngineTask localHttpEngineTask;
      try
      {
        localObject = (bklg)this.b.remove(paramString);
        localHttpEngineTask = (HttpEngineTask)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localHttpEngineTask != null))
        {
          if (localObject != null)
          {
            if (bklg.a((bklg)localObject) != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(bklg.a((bklg)localObject).mReqUrl);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(bklg.a((bklg)localObject).mReqUrl);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bklg.a((bklg)localObject);
            if (localObject != null) {
              ((bklh)localObject).d(paramString);
            }
            c(paramString);
          }
        }
        else {
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).cancelReq(bklg.a((bklg)localObject));
      continue;
      label185:
      Object localObject = (bklh)localHttpEngineTask.userData;
    }
  }
  
  private void c(String paramString)
  {
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "0");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(PluginInfo paramPluginInfo, bklh parambklh, boolean paramBoolean)
  {
    QLog.d("plugin_tag", 1, "doDownloadPlugin." + paramPluginInfo.mID + ", isPreDownload " + paramBoolean);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    if (localObject1 == null) {
      QLog.d("plugin_tag", 1, "doDownloadPlugin nohttpabort" + paramPluginInfo.mID);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        if (this.b.containsKey(paramPluginInfo.mID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "downloading already");
          }
          return;
        }
        if (this.c.containsKey(paramPluginInfo.mID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "pending downloading already exist");
          }
          if (paramBoolean) {
            break label248;
          }
          localObject2 = (HttpEngineTask)this.c.remove(paramPluginInfo.mID);
          if ((localObject2 != null) && (localObject2 != null)) {
            this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(((HttpEngineTask)localObject2).httpReq.mReqUrl);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        label248:
        if ((float)(paramPluginInfo.mLength * 1.75D) > FileUtils.getAvailableInnernalMemorySize())
        {
          if (parambklh == null) {
            continue;
          }
          parambklh.b(paramPluginInfo.mID);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
    Object localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = this;
    ((HttpNetReq)localObject2).mBreakDownFix = this;
    ((HttpNetReq)localObject2).mReqUrl = paramPluginInfo.mURL;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    ((HttpNetReq)localObject2).mNeedIpConnect = true;
    ((HttpNetReq)localObject2).bAcceptNegativeContentLength = true;
    ((HttpNetReq)localObject2).setUserData(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((HttpNetReq)localObject2).mOutPath = str;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.isEnable())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject1 = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (HttpNetReq)localObject2);
        ((HttpEngineTask)localObject1).userData = parambklh;
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (AbsPreDownloadTask)localObject1);
        this.c.put(paramPluginInfo.mID, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((HttpNetReq)localObject2).mReqUrl);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (HttpNetReq)localObject2, parambklh, null);
      ((INetEngine)localObject1).sendReq((NetReq)localObject2);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
    paramNetResp.mWrittenBlockLen = 0L;
    paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
    paramNetReq.mReqProperties.put("Range", paramNetResp);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    this.c.remove(paramHttpEngineTask.httpReq.getUserData());
    a((String)paramHttpEngineTask.httpReq.getUserData(), paramHttpEngineTask.httpReq, (bklh)paramHttpEngineTask.userData, paramHttpEngineTask);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkle
 * JD-Core Version:    0.7.0.1
 */