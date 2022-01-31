import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bfdn
  implements Handler.Callback, axrs, axrt, axxi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private axxj jdField_a_of_type_Axxj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bfdp> b;
  private HashMap<String, axxh> c;
  
  public bfdn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Axxj = ((axxj)paramQQAppInterface.getManager(193));
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
  
  private void a(axsp paramaxsp, int paramInt1, int paramInt2)
  {
    String str = (String)paramaxsp.a();
    if (paramInt2 > 0)
    {
      paramaxsp = (bfdp)this.b.get(str);
      if (paramaxsp == null) {
        break label95;
      }
    }
    label95:
    for (paramaxsp = bfdp.a(paramaxsp);; paramaxsp = null)
    {
      if (paramaxsp != null) {
        paramaxsp.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(axsq paramaxsq)
  {
    String str = (String)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bfdp localbfdp = (bfdp)this.b.remove(str);
      if (localbfdp != null)
      {
        if (bfdp.a(localbfdp) != null) {
          ((axxj)localObject).a(bfdp.a(localbfdp).jdField_a_of_type_JavaLangString, paramaxsq.jdField_a_of_type_Long);
        }
        localObject = bfdp.a(localbfdp);
        a(str, paramaxsq);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramaxsq.jdField_a_of_type_Int + "," + str + ", " + paramaxsq.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramaxsq.b + ", " + paramaxsq.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bfdq)localObject).a(bool, str);
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
  
  private void a(String paramString, axro paramaxro, bfdq parambfdq, axxg paramaxxg)
  {
    if (parambfdq != null) {
      parambfdq.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (axxh)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Axxj.a(((axxh)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bfdp(null);
      bfdp.a((bfdp)localObject, paramaxro);
      bfdp.a((bfdp)localObject, parambfdq);
      bfdp.a((bfdp)localObject, paramaxxg);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, axsq paramaxsq)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramaxsq.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramaxsq.b));
      localHashMap.put("mErrDesc", paramaxsq.jdField_a_of_type_JavaLangString);
      Object localObject = paramaxsq.jdField_a_of_type_Axsp;
      if ((paramaxsq.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof axro))) {
        localHashMap.put("Url", ((axro)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = awrn.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramaxsq.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((awrn)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      axxh localaxxh;
      try
      {
        localObject = (bfdp)this.b.remove(paramString);
        localaxxh = (axxh)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localaxxh != null))
        {
          if (localObject != null)
          {
            if (bfdp.a((bfdp)localObject) != null) {
              this.jdField_a_of_type_Axxj.a(bfdp.a((bfdp)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Axxj.a(bfdp.a((bfdp)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bfdp.a((bfdp)localObject);
            if (localObject != null) {
              ((bfdq)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bfdp.a((bfdp)localObject));
      continue;
      label185:
      Object localObject = (bfdq)localaxxh.userData;
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
      awrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    while (!(paramaxsp instanceof axro)) {
      return;
    }
    paramaxsp = (axro)paramaxsp;
    paramaxsp.jdField_a_of_type_Long += paramaxsq.c;
    paramaxsq.c = 0L;
    paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
    paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
  }
  
  public void a(axxh paramaxxh)
  {
    this.c.remove(paramaxxh.a.a());
    a((String)paramaxxh.a.a(), paramaxxh.a, (bfdq)paramaxxh.userData, paramaxxh);
  }
  
  public void a(PluginInfo paramPluginInfo, bfdq parambfdq, boolean paramBoolean)
  {
    QLog.d("plugin_tag", 1, "doDownloadPlugin." + paramPluginInfo.mID + ", isPreDownload " + paramBoolean);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    Object localObject2;
    try
    {
      if (this.b.containsKey(paramPluginInfo.mID)) {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "downloading already");
        }
      }
      do
      {
        return;
        if (this.c.containsKey(paramPluginInfo.mID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "pending downloading already exist");
          }
          if (paramBoolean) {
            break;
          }
          localObject1 = (axxh)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_Axxj.a(((axxh)localObject1).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= bace.a()) {
          break label235;
        }
      } while (parambfdq == null);
      parambfdq.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new axro();
    ((axro)localObject1).jdField_a_of_type_Axrt = this;
    ((axro)localObject1).jdField_a_of_type_Axrs = this;
    ((axro)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((axro)localObject1).jdField_a_of_type_Int = 0;
    ((axro)localObject1).jdField_a_of_type_Boolean = true;
    ((axro)localObject1).m = true;
    ((axro)localObject1).n = true;
    ((axro)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((axro)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Axxj.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new axxh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (axro)localObject1);
        ((axxh)localObject2).userData = parambfdq;
        this.jdField_a_of_type_Axxj.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (axxg)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((axro)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (axro)localObject1, parambfdq, null);
      ((axrr)localObject2).a((axsp)localObject1);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((axsq)paramMessage.obj);
      continue;
      a((axsp)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramaxsq).sendToTarget();
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramaxsp).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfdn
 * JD-Core Version:    0.7.0.1
 */