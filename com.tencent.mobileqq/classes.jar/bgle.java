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

public class bgle
  implements Handler.Callback, ayrz, aysa, ayxp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ayxq jdField_a_of_type_Ayxq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bglg> b;
  private HashMap<String, ayxo> c;
  
  public bgle(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Ayxq = ((ayxq)paramQQAppInterface.getManager(193));
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
  
  private void a(aysw paramaysw, int paramInt1, int paramInt2)
  {
    String str = (String)paramaysw.a();
    if (paramInt2 > 0)
    {
      paramaysw = (bglg)this.b.get(str);
      if (paramaysw == null) {
        break label95;
      }
    }
    label95:
    for (paramaysw = bglg.a(paramaysw);; paramaysw = null)
    {
      if (paramaysw != null) {
        paramaysw.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(aysx paramaysx)
  {
    String str = (String)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (ayxq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bglg localbglg = (bglg)this.b.remove(str);
      if (localbglg != null)
      {
        if (bglg.a(localbglg) != null) {
          ((ayxq)localObject).a(bglg.a(localbglg).jdField_a_of_type_JavaLangString, paramaysx.jdField_a_of_type_Long);
        }
        localObject = bglg.a(localbglg);
        a(str, paramaysx);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramaysx.jdField_a_of_type_Int + "," + str + ", " + paramaysx.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramaysx.b + ", " + paramaysx.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bglh)localObject).a(bool, str);
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
  
  private void a(String paramString, ayrv paramayrv, bglh parambglh, ayxn paramayxn)
  {
    if (parambglh != null) {
      parambglh.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (ayxo)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Ayxq.a(((ayxo)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bglg(null);
      bglg.a((bglg)localObject, paramayrv);
      bglg.a((bglg)localObject, parambglh);
      bglg.a((bglg)localObject, paramayxn);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, aysx paramaysx)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramaysx.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramaysx.b));
      localHashMap.put("mErrDesc", paramaysx.jdField_a_of_type_JavaLangString);
      Object localObject = paramaysx.jdField_a_of_type_Aysw;
      if ((paramaysx.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof ayrv))) {
        localHashMap.put("Url", ((ayrv)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = axrl.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramaysx.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((axrl)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      ayxo localayxo;
      try
      {
        localObject = (bglg)this.b.remove(paramString);
        localayxo = (ayxo)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localayxo != null))
        {
          if (localObject != null)
          {
            if (bglg.a((bglg)localObject) != null) {
              this.jdField_a_of_type_Ayxq.a(bglg.a((bglg)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Ayxq.a(bglg.a((bglg)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bglg.a((bglg)localObject);
            if (localObject != null) {
              ((bglh)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bglg.a((bglg)localObject));
      continue;
      label185:
      Object localObject = (bglh)localayxo.userData;
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
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    while (!(paramaysw instanceof ayrv)) {
      return;
    }
    paramaysw = (ayrv)paramaysw;
    paramaysw.jdField_a_of_type_Long += paramaysx.c;
    paramaysx.c = 0L;
    paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
    paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
  }
  
  public void a(ayxo paramayxo)
  {
    this.c.remove(paramayxo.a.a());
    a((String)paramayxo.a.a(), paramayxo.a, (bglh)paramayxo.userData, paramayxo);
  }
  
  public void a(PluginInfo paramPluginInfo, bglh parambglh, boolean paramBoolean)
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
          localObject1 = (ayxo)this.c.remove(paramPluginInfo.mID);
          if ((localObject1 != null) && (localObject1 != null)) {
            this.jdField_a_of_type_Ayxq.a(((ayxo)localObject1).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= bbdj.a()) {
          break label235;
        }
      } while (parambglh == null);
      parambglh.b(paramPluginInfo.mID);
      return;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    label235:
    Object localObject1 = new ayrv();
    ((ayrv)localObject1).jdField_a_of_type_Aysa = this;
    ((ayrv)localObject1).jdField_a_of_type_Ayrz = this;
    ((ayrv)localObject1).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((ayrv)localObject1).jdField_a_of_type_Int = 0;
    ((ayrv)localObject1).jdField_a_of_type_Boolean = true;
    ((ayrv)localObject1).m = true;
    ((ayrv)localObject1).n = true;
    ((ayrv)localObject1).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((ayrv)localObject1).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Ayxq.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject2 = new ayxo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (ayrv)localObject1);
        ((ayxo)localObject2).userData = parambglh;
        this.jdField_a_of_type_Ayxq.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (ayxn)localObject2);
        this.c.put(paramPluginInfo.mID, localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((ayrv)localObject1).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (ayrv)localObject1, parambglh, null);
      ((ayry)localObject2).a((aysw)localObject1);
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
      a((aysx)paramMessage.obj);
      continue;
      a((aysw)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramaysx).sendToTarget();
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramaysw).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgle
 * JD-Core Version:    0.7.0.1
 */