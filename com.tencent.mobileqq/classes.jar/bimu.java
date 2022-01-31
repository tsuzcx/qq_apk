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

public class bimu
  implements Handler.Callback, bapw, bapx, bavq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bavr jdField_a_of_type_Bavr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bimw> b;
  private HashMap<String, bavp> c;
  
  public bimu(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Bavr = ((bavr)paramQQAppInterface.getManager(193));
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
  
  private void a(baqv parambaqv, int paramInt1, int paramInt2)
  {
    String str = (String)parambaqv.a();
    if (paramInt2 > 0)
    {
      parambaqv = (bimw)this.b.get(str);
      if (parambaqv == null) {
        break label95;
      }
    }
    label95:
    for (parambaqv = bimw.a(parambaqv);; parambaqv = null)
    {
      if (parambaqv != null) {
        parambaqv.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(baqw parambaqw)
  {
    String str = (String)parambaqw.jdField_a_of_type_Baqv.a();
    if (parambaqw.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (bavr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bimw localbimw = (bimw)this.b.remove(str);
      if (localbimw != null)
      {
        if (bimw.a(localbimw) != null) {
          ((bavr)localObject).a(bimw.a(localbimw).jdField_a_of_type_JavaLangString, parambaqw.jdField_a_of_type_Long);
        }
        localObject = bimw.a(localbimw);
        a(str, parambaqw);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + parambaqw.jdField_a_of_type_Int + "," + str + ", " + parambaqw.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + parambaqw.b + ", " + parambaqw.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bimx)localObject).a(bool, str);
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
  
  private void a(String paramString, baps parambaps, bimx parambimx, bavo parambavo)
  {
    if (parambimx != null) {
      parambimx.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (bavp)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Bavr.a(((bavp)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bimw(null);
      bimw.a((bimw)localObject, parambaps);
      bimw.a((bimw)localObject, parambimx);
      bimw.a((bimw)localObject, parambavo);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, baqw parambaqw)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(parambaqw.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(parambaqw.b));
      localHashMap.put("mErrDesc", parambaqw.jdField_a_of_type_JavaLangString);
      Object localObject = parambaqw.jdField_a_of_type_Baqv;
      if ((parambaqw.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof baps))) {
        localHashMap.put("Url", ((baps)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = azmz.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (parambaqw.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((azmz)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      bavp localbavp;
      try
      {
        localObject = (bimw)this.b.remove(paramString);
        localbavp = (bavp)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localbavp != null))
        {
          if (localObject != null)
          {
            if (bimw.a((bimw)localObject) != null) {
              this.jdField_a_of_type_Bavr.a(bimw.a((bimw)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Bavr.a(bimw.a((bimw)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bimw.a((bimw)localObject);
            if (localObject != null) {
              ((bimx)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bimw.a((bimw)localObject));
      continue;
      label185:
      Object localObject = (bimx)localbavp.userData;
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
      azmz.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    while (!(parambaqv instanceof baps)) {
      return;
    }
    parambaqv = (baps)parambaqv;
    parambaqv.jdField_a_of_type_Long += parambaqw.c;
    parambaqw.c = 0L;
    parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-";
    parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
  }
  
  public void a(bavp parambavp)
  {
    this.c.remove(parambavp.a.a());
    a((String)parambavp.a.a(), parambavp.a, (bimx)parambavp.userData, parambavp);
  }
  
  public void a(PluginInfo paramPluginInfo, bimx parambimx, boolean paramBoolean)
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
          localObject1 = (bavp)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_Bavr.a(((bavp)localObject1).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= bdcs.a()) {
          break label235;
        }
      } while (parambimx == null);
      parambimx.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new baps();
    ((baps)localObject1).jdField_a_of_type_Bapx = this;
    ((baps)localObject1).jdField_a_of_type_Bapw = this;
    ((baps)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((baps)localObject1).jdField_a_of_type_Int = 0;
    ((baps)localObject1).jdField_a_of_type_Boolean = true;
    ((baps)localObject1).m = true;
    ((baps)localObject1).n = true;
    ((baps)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((baps)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Bavr.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new bavp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (baps)localObject1);
        ((bavp)localObject2).userData = parambimx;
        this.jdField_a_of_type_Bavr.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (bavo)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((baps)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (baps)localObject1, parambimx, null);
      ((bapv)localObject2).a((baqv)localObject1);
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
      a((baqw)paramMessage.obj);
      continue;
      a((baqv)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, parambaqw).sendToTarget();
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, parambaqv).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimu
 * JD-Core Version:    0.7.0.1
 */