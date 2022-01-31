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

public class birb
  implements Handler.Callback, bauf, baug, bazz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbaa jdField_a_of_type_Bbaa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bird> b;
  private HashMap<String, bazy> c;
  
  public birb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Bbaa = ((bbaa)paramQQAppInterface.getManager(193));
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
  
  private void a(bave parambave, int paramInt1, int paramInt2)
  {
    String str = (String)parambave.a();
    if (paramInt2 > 0)
    {
      parambave = (bird)this.b.get(str);
      if (parambave == null) {
        break label95;
      }
    }
    label95:
    for (parambave = bird.a(parambave);; parambave = null)
    {
      if (parambave != null) {
        parambave.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(bavf parambavf)
  {
    String str = (String)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (bbaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bird localbird = (bird)this.b.remove(str);
      if (localbird != null)
      {
        if (bird.a(localbird) != null) {
          ((bbaa)localObject).a(bird.a(localbird).jdField_a_of_type_JavaLangString, parambavf.jdField_a_of_type_Long);
        }
        localObject = bird.a(localbird);
        a(str, parambavf);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + parambavf.jdField_a_of_type_Int + "," + str + ", " + parambavf.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + parambavf.b + ", " + parambavf.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bire)localObject).a(bool, str);
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
  
  private void a(String paramString, baub parambaub, bire parambire, bazx parambazx)
  {
    if (parambire != null) {
      parambire.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (bazy)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Bbaa.a(((bazy)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bird(null);
      bird.a((bird)localObject, parambaub);
      bird.a((bird)localObject, parambire);
      bird.a((bird)localObject, parambazx);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, bavf parambavf)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(parambavf.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(parambavf.b));
      localHashMap.put("mErrDesc", parambavf.jdField_a_of_type_JavaLangString);
      Object localObject = parambavf.jdField_a_of_type_Bave;
      if ((parambavf.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof baub))) {
        localHashMap.put("Url", ((baub)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", parambavf.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", parambavf.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = azri.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (parambavf.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((azri)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      bazy localbazy;
      try
      {
        localObject = (bird)this.b.remove(paramString);
        localbazy = (bazy)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localbazy != null))
        {
          if (localObject != null)
          {
            if (bird.a((bird)localObject) != null) {
              this.jdField_a_of_type_Bbaa.a(bird.a((bird)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Bbaa.a(bird.a((bird)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bird.a((bird)localObject);
            if (localObject != null) {
              ((bire)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bird.a((bird)localObject));
      continue;
      label185:
      Object localObject = (bire)localbazy.userData;
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
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    while (!(parambave instanceof baub)) {
      return;
    }
    parambave = (baub)parambave;
    parambave.jdField_a_of_type_Long += parambavf.c;
    parambavf.c = 0L;
    parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
    parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
  }
  
  public void a(bazy parambazy)
  {
    this.c.remove(parambazy.a.a());
    a((String)parambazy.a.a(), parambazy.a, (bire)parambazy.userData, parambazy);
  }
  
  public void a(PluginInfo paramPluginInfo, bire parambire, boolean paramBoolean)
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
          localObject1 = (bazy)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_Bbaa.a(((bazy)localObject1).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= bdhb.a()) {
          break label235;
        }
      } while (parambire == null);
      parambire.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new baub();
    ((baub)localObject1).jdField_a_of_type_Baug = this;
    ((baub)localObject1).jdField_a_of_type_Bauf = this;
    ((baub)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((baub)localObject1).jdField_a_of_type_Int = 0;
    ((baub)localObject1).jdField_a_of_type_Boolean = true;
    ((baub)localObject1).m = true;
    ((baub)localObject1).n = true;
    ((baub)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((baub)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Bbaa.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new bazy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (baub)localObject1);
        ((bazy)localObject2).userData = parambire;
        this.jdField_a_of_type_Bbaa.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (bazx)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((baub)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (baub)localObject1, parambire, null);
      ((baue)localObject2).a((bave)localObject1);
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
      a((bavf)paramMessage.obj);
      continue;
      a((bave)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(bavf parambavf)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, parambavf).sendToTarget();
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, parambave).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birb
 * JD-Core Version:    0.7.0.1
 */