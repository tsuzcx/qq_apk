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

public class blfv
  implements Handler.Callback, bdvv, bdvw, beav
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private beaw jdField_a_of_type_Beaw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, blfx> b;
  private HashMap<String, beau> c;
  
  public blfv(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Beaw = ((beaw)paramQQAppInterface.getManager(193));
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
  
  private void a(bdws parambdws, int paramInt1, int paramInt2)
  {
    String str = (String)parambdws.a();
    if (paramInt2 > 0)
    {
      parambdws = (blfx)this.b.get(str);
      if (parambdws == null) {
        break label95;
      }
    }
    label95:
    for (parambdws = blfx.a(parambdws);; parambdws = null)
    {
      if (parambdws != null) {
        parambdws.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(bdwt parambdwt)
  {
    String str = (String)parambdwt.jdField_a_of_type_Bdws.a();
    if (parambdwt.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (beaw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      blfx localblfx = (blfx)this.b.remove(str);
      if (localblfx != null)
      {
        if (blfx.a(localblfx) != null) {
          ((beaw)localObject).a(blfx.a(localblfx).jdField_a_of_type_JavaLangString, parambdwt.jdField_a_of_type_Long);
        }
        localObject = blfx.a(localblfx);
        a(str, parambdwt);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + parambdwt.jdField_a_of_type_Int + "," + str + ", " + parambdwt.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + parambdwt.b + ", " + parambdwt.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((blfy)localObject).a(bool, str);
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
  
  private void a(String paramString, bdvs parambdvs, blfy paramblfy, beat parambeat)
  {
    if (paramblfy != null) {
      paramblfy.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (beau)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Beaw.a(((beau)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new blfx(null);
      blfx.a((blfx)localObject, parambdvs);
      blfx.a((blfx)localObject, paramblfy);
      blfx.a((blfx)localObject, parambeat);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, bdwt parambdwt)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(parambdwt.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(parambdwt.b));
      localHashMap.put("mErrDesc", parambdwt.jdField_a_of_type_JavaLangString);
      Object localObject = parambdwt.jdField_a_of_type_Bdws;
      if ((parambdwt.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof bdvs))) {
        localHashMap.put("Url", ((bdvs)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", parambdwt.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = bctj.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (parambdwt.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((bctj)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      beau localbeau;
      try
      {
        localObject = (blfx)this.b.remove(paramString);
        localbeau = (beau)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localbeau != null))
        {
          if (localObject != null)
          {
            if (blfx.a((blfx)localObject) != null) {
              this.jdField_a_of_type_Beaw.a(blfx.a((blfx)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Beaw.a(blfx.a((blfx)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = blfx.a((blfx)localObject);
            if (localObject != null) {
              ((blfy)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(blfx.a((blfx)localObject));
      continue;
      label185:
      Object localObject = (blfy)localbeau.userData;
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
      bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    while (!(parambdws instanceof bdvs)) {
      return;
    }
    parambdws = (bdvs)parambdws;
    parambdws.jdField_a_of_type_Long += parambdwt.c;
    parambdwt.c = 0L;
    parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
    parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
  }
  
  public void a(beau parambeau)
  {
    this.c.remove(parambeau.a.a());
    a((String)parambeau.a.a(), parambeau.a, (blfy)parambeau.userData, parambeau);
  }
  
  public void a(PluginInfo paramPluginInfo, blfy paramblfy, boolean paramBoolean)
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
          localObject2 = (beau)this.c.remove(paramPluginInfo.mID);
          if ((localObject2 != null) && (localObject2 != null)) {
            this.jdField_a_of_type_Beaw.a(((beau)localObject2).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        label248:
        if ((float)(paramPluginInfo.mLength * 1.75D) > bgmg.a())
        {
          if (paramblfy == null) {
            continue;
          }
          paramblfy.b(paramPluginInfo.mID);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
    Object localObject2 = new bdvs();
    ((bdvs)localObject2).jdField_a_of_type_Bdvw = this;
    ((bdvs)localObject2).jdField_a_of_type_Bdvv = this;
    ((bdvs)localObject2).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((bdvs)localObject2).jdField_a_of_type_Int = 0;
    ((bdvs)localObject2).jdField_a_of_type_Boolean = true;
    ((bdvs)localObject2).n = true;
    ((bdvs)localObject2).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((bdvs)localObject2).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Beaw.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject1 = new beau(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (bdvs)localObject2);
        ((beau)localObject1).userData = paramblfy;
        this.jdField_a_of_type_Beaw.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (beat)localObject1);
        this.c.put(paramPluginInfo.mID, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((bdvs)localObject2).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (bdvs)localObject2, paramblfy, null);
      ((bdvu)localObject1).a((bdws)localObject2);
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
      a((bdwt)paramMessage.obj);
      continue;
      a((bdws)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, parambdwt).sendToTarget();
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, parambdws).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfv
 * JD-Core Version:    0.7.0.1
 */