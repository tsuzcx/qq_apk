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

public class bglv
  implements Handler.Callback, aysb, aysc, ayxr
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ayxs jdField_a_of_type_Ayxs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bglx> b;
  private HashMap<String, ayxq> c;
  
  public bglv(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Ayxs = ((ayxs)paramQQAppInterface.getManager(193));
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
  
  private void a(aysy paramaysy, int paramInt1, int paramInt2)
  {
    String str = (String)paramaysy.a();
    if (paramInt2 > 0)
    {
      paramaysy = (bglx)this.b.get(str);
      if (paramaysy == null) {
        break label95;
      }
    }
    label95:
    for (paramaysy = bglx.a(paramaysy);; paramaysy = null)
    {
      if (paramaysy != null) {
        paramaysy.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(aysz paramaysz)
  {
    String str = (String)paramaysz.jdField_a_of_type_Aysy.a();
    if (paramaysz.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (ayxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bglx localbglx = (bglx)this.b.remove(str);
      if (localbglx != null)
      {
        if (bglx.a(localbglx) != null) {
          ((ayxs)localObject).a(bglx.a(localbglx).jdField_a_of_type_JavaLangString, paramaysz.jdField_a_of_type_Long);
        }
        localObject = bglx.a(localbglx);
        a(str, paramaysz);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramaysz.jdField_a_of_type_Int + "," + str + ", " + paramaysz.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramaysz.b + ", " + paramaysz.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bgly)localObject).a(bool, str);
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
  
  private void a(String paramString, ayrx paramayrx, bgly parambgly, ayxp paramayxp)
  {
    if (parambgly != null) {
      parambgly.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (ayxq)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Ayxs.a(((ayxq)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bglx(null);
      bglx.a((bglx)localObject, paramayrx);
      bglx.a((bglx)localObject, parambgly);
      bglx.a((bglx)localObject, paramayxp);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, aysz paramaysz)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramaysz.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramaysz.b));
      localHashMap.put("mErrDesc", paramaysz.jdField_a_of_type_JavaLangString);
      Object localObject = paramaysz.jdField_a_of_type_Aysy;
      if ((paramaysz.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof ayrx))) {
        localHashMap.put("Url", ((ayrx)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = axrn.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramaysz.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((axrn)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      ayxq localayxq;
      try
      {
        localObject = (bglx)this.b.remove(paramString);
        localayxq = (ayxq)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localayxq != null))
        {
          if (localObject != null)
          {
            if (bglx.a((bglx)localObject) != null) {
              this.jdField_a_of_type_Ayxs.a(bglx.a((bglx)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Ayxs.a(bglx.a((bglx)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bglx.a((bglx)localObject);
            if (localObject != null) {
              ((bgly)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bglx.a((bglx)localObject));
      continue;
      label185:
      Object localObject = (bgly)localayxq.userData;
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
      axrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    while (!(paramaysy instanceof ayrx)) {
      return;
    }
    paramaysy = (ayrx)paramaysy;
    paramaysy.jdField_a_of_type_Long += paramaysz.c;
    paramaysz.c = 0L;
    paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
    paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
  }
  
  public void a(ayxq paramayxq)
  {
    this.c.remove(paramayxq.a.a());
    a((String)paramayxq.a.a(), paramayxq.a, (bgly)paramayxq.userData, paramayxq);
  }
  
  public void a(PluginInfo paramPluginInfo, bgly parambgly, boolean paramBoolean)
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
          localObject1 = (ayxq)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_Ayxs.a(((ayxq)localObject1).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= bbdx.a()) {
          break label235;
        }
      } while (parambgly == null);
      parambgly.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new ayrx();
    ((ayrx)localObject1).jdField_a_of_type_Aysc = this;
    ((ayrx)localObject1).jdField_a_of_type_Aysb = this;
    ((ayrx)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((ayrx)localObject1).jdField_a_of_type_Int = 0;
    ((ayrx)localObject1).jdField_a_of_type_Boolean = true;
    ((ayrx)localObject1).m = true;
    ((ayrx)localObject1).n = true;
    ((ayrx)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((ayrx)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Ayxs.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new ayxq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (ayrx)localObject1);
        ((ayxq)localObject2).userData = parambgly;
        this.jdField_a_of_type_Ayxs.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (ayxp)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((ayrx)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (ayrx)localObject1, parambgly, null);
      ((aysa)localObject2).a((aysy)localObject1);
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
      a((aysz)paramMessage.obj);
      continue;
      a((aysy)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(aysz paramaysz)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramaysz).sendToTarget();
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramaysy).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglv
 * JD-Core Version:    0.7.0.1
 */