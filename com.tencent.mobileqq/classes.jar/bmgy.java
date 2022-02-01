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

public class bmgy
  implements Handler.Callback, beup, beuq, bezu
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bezv jdField_a_of_type_Bezv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private HashMap<String, bmha> b;
  private HashMap<String, bezt> c;
  
  public bmgy(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_Bezv = ((bezv)paramQQAppInterface.getManager(193));
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
  
  private void a(bevl parambevl, int paramInt1, int paramInt2)
  {
    String str = (String)parambevl.a();
    if (paramInt2 > 0)
    {
      parambevl = (bmha)this.b.get(str);
      if (parambevl == null) {
        break label95;
      }
    }
    label95:
    for (parambevl = bmha.a(parambevl);; parambevl = null)
    {
      if (parambevl != null) {
        parambevl.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(bevm parambevm)
  {
    String str = (String)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (bezv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
      bmha localbmha = (bmha)this.b.remove(str);
      if (localbmha != null)
      {
        if (bmha.a(localbmha) != null) {
          ((bezv)localObject).a(bmha.a(localbmha).jdField_a_of_type_JavaLangString, parambevm.jdField_a_of_type_Long);
        }
        localObject = bmha.a(localbmha);
        a(str, parambevm);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + parambevm.jdField_a_of_type_Int + "," + str + ", " + parambevm.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + parambevm.b + ", " + parambevm.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((bmhb)localObject).a(bool, str);
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
  
  private void a(String paramString, beum parambeum, bmhb parambmhb, bezs parambezs)
  {
    if (parambmhb != null) {
      parambmhb.c(paramString);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (bezt)this.c.remove(paramString);
      if (localObject != null) {
        this.jdField_a_of_type_Bezv.a(((bezt)localObject).a.jdField_a_of_type_JavaLangString);
      }
      localObject = new bmha(null);
      bmha.a((bmha)localObject, parambeum);
      bmha.a((bmha)localObject, parambmhb);
      bmha.a((bmha)localObject, parambezs);
      this.b.put(paramString, localObject);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(String paramString, bevm parambevm)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(parambevm.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(parambevm.b));
      localHashMap.put("mErrDesc", parambevm.jdField_a_of_type_JavaLangString);
      Object localObject = parambevm.jdField_a_of_type_Bevl;
      if ((parambevm.jdField_a_of_type_Int != 0) && (localObject != null) && ((localObject instanceof beum))) {
        localHashMap.put("Url", ((beum)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", parambevm.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = bdmc.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (parambevm.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((bdmc)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
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
      bezt localbezt;
      try
      {
        localObject = (bmha)this.b.remove(paramString);
        localbezt = (bezt)this.c.remove(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if ((localObject != null) || (localbezt != null))
        {
          if (localObject != null)
          {
            if (bmha.a((bmha)localObject) != null) {
              this.jdField_a_of_type_Bezv.a(bmha.a((bmha)localObject).jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject != null) {
              this.jdField_a_of_type_Bezv.a(bmha.a((bmha)localObject).jdField_a_of_type_JavaLangString);
            }
            if (localObject == null) {
              break label185;
            }
            localObject = bmha.a((bmha)localObject);
            if (localObject != null) {
              ((bmhb)localObject).d(paramString);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(bmha.a((bmha)localObject));
      continue;
      label185:
      Object localObject = (bmhb)localbezt.userData;
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
      bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    while (!(parambevl instanceof beum)) {
      return;
    }
    parambevl = (beum)parambevl;
    parambevl.jdField_a_of_type_Long += parambevm.c;
    parambevm.c = 0L;
    parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
    parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
  }
  
  public void a(bezt parambezt)
  {
    this.c.remove(parambezt.a.a());
    a((String)parambezt.a.a(), parambezt.a, (bmhb)parambezt.userData, parambezt);
  }
  
  public void a(PluginInfo paramPluginInfo, bmhb parambmhb, boolean paramBoolean)
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
          localObject2 = (bezt)this.c.remove(paramPluginInfo.mID);
          if ((localObject2 != null) && (localObject2 != null)) {
            this.jdField_a_of_type_Bezv.a(((bezt)localObject2).a.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        label248:
        if ((float)(paramPluginInfo.mLength * 1.75D) > bhmi.a())
        {
          if (parambmhb == null) {
            continue;
          }
          parambmhb.b(paramPluginInfo.mID);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
    Object localObject2 = new beum();
    ((beum)localObject2).jdField_a_of_type_Beuq = this;
    ((beum)localObject2).jdField_a_of_type_Beup = this;
    ((beum)localObject2).jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
    ((beum)localObject2).jdField_a_of_type_Int = 0;
    ((beum)localObject2).jdField_a_of_type_Boolean = true;
    ((beum)localObject2).n = true;
    ((beum)localObject2).a(paramPluginInfo.mID);
    String str = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
    ((beum)localObject2).c = str;
    if ((paramBoolean) && (this.jdField_a_of_type_Bezv.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        localObject1 = new bezt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPluginInfo.mID, this, (beum)localObject2);
        ((bezt)localObject1).userData = parambmhb;
        this.jdField_a_of_type_Bezv.a(a(paramPluginInfo.mID), null, paramPluginInfo.mID + paramPluginInfo.mMD5, 0, paramPluginInfo.mURL, str, 1, 2, false, (bezs)localObject1);
        this.c.put(paramPluginInfo.mID, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("plugin_tag", 2, "downloadPlugin: " + ((beum)localObject2).jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      a(paramPluginInfo.mID, (beum)localObject2, parambmhb, null);
      ((beuo)localObject1).a((bevl)localObject2);
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
      a((bevm)paramMessage.obj);
      continue;
      a((bevl)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, parambevm).sendToTarget();
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, parambevl).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgy
 * JD-Core Version:    0.7.0.1
 */