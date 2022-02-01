import NS_KING_PUBLIC.stAuth;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.pb.QQALive.GetOpenInfoReq;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class bmfn
{
  private static bmfn jdField_a_of_type_Bmfn;
  private List<WeakReference<bmfo>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, bmfp> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private bmfn()
  {
    a();
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  public static bmfn a()
  {
    if (jdField_a_of_type_Bmfn == null) {}
    try
    {
      if (jdField_a_of_type_Bmfn == null) {
        jdField_a_of_type_Bmfn = new bmfn();
      }
      return jdField_a_of_type_Bmfn;
    }
    finally {}
  }
  
  private bmfp a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (bmfp)this.jdField_a_of_type_JavaUtilMap.get(a());
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    return "";
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  private void a()
  {
    if (IlivePluginManager.getInstance().getPluginCallback() != null) {
      IlivePluginManager.getInstance().getPluginCallback().onPluginLoginStart();
    }
    bmfv.a().a("AUTH_PROCESS").a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QQALive.GetOpenInfoReq localGetOpenInfoReq = new QQALive.GetOpenInfoReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), bmft.class);
    localNewIntent.putExtra("data", bhuf.a(localGetOpenInfoReq.toByteArray()));
    localNewIntent.putExtra("cmd", "qqvalivelogin.GetOpenInfo");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      try
      {
        String str1 = a();
        try
        {
          localObject3 = Long.valueOf(Long.parseLong(str1));
          localObject2 = this.jdField_a_of_type_JavaUtilMap.get(str1);
          if (localObject2 == null) {
            continue;
          }
        }
        catch (Exception localException)
        {
          QLog.e("IliveAuthManager", 1, "parse uin error ");
          bool = false;
          continue;
          localObject2 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_open_id", "", ((Long)localObject3).longValue());
          localObject3 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_access_token", "", ((Long)localObject3).longValue());
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label218;
          }
        }
        return bool;
      }
      finally {}
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        String str2 = blhj.b((String)localObject2, a());
        String str3 = blhj.b((String)localObject3, a());
        QLog.d("IliveAuthManager", 1, "use sp openId and accessToken encrypted:" + (String)localObject2 + " , " + (String)localObject3 + ", decrypt:" + str2 + " , " + str3);
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          this.jdField_a_of_type_JavaUtilMap.put(localException, new bmfp(str2, str3));
        }
      }
      else
      {
        label218:
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  private long b()
  {
    long l = QzoneConfig.getInstance().getConfig("qqLive", "qqAuthTime", 6000000L);
    QLog.i("IliveAuthManager", 1, "getQQAuthTime time = " + l);
    return l;
  }
  
  public stAuth a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = LocalMultiProcConfig.getLong4Uin("key_qq_ilive_connect_auth_time", 0L, a());
    QLog.e("IliveAuthManager", 1, "getLocalIliveAuth : offest = " + (l1 - l2));
    if ((TextUtils.isEmpty(IlivePluginManager.getInstance().getLiveToken())) && (l1 - l2 > b())) {}
    bmfp localbmfp;
    do
    {
      do
      {
        return null;
        localbmfp = a();
        if (localbmfp != null) {
          return new stAuth(1, localbmfp.a, localbmfp.b);
        }
      } while (!a());
      localbmfp = a();
    } while (localbmfp == null);
    return new stAuth(1, localbmfp.a, localbmfp.b);
  }
  
  @NotNull
  public void a(bmfo parambmfo)
  {
    stAuth localstAuth = a();
    if (localstAuth != null)
    {
      parambmfo.onGetAuthInfo(true, localstAuth);
      QLog.e("IliveAuthManager", 1, "getStAuth use local");
      return;
    }
    parambmfo = new WeakReference(parambmfo);
    this.jdField_a_of_type_JavaUtilList.add(parambmfo);
    QLog.e("IliveAuthManager", 1, "getStAuth ");
    a();
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAuthManager", 2, " auth callback , success = " + paramBoolean + " openId = " + paramString1 + " token = " + paramString2);
    }
    Object localObject2 = new HashMap();
    if (paramBoolean) {}
    for (Object localObject1 = "success";; localObject1 = "fail")
    {
      ((HashMap)localObject2).put("status", localObject1);
      bmfv.a().a("AUTH_PROCESS").a("auth_process", (HashMap)localObject2);
      if (paramBoolean)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
          this.jdField_a_of_type_JavaUtilMap.put(a(), new bmfp(paramString1, paramString2));
        }
        localObject1 = blhj.a(paramString1, a());
        localObject2 = blhj.a(paramString2, a());
        LocalMultiProcConfig.putString4Uin("key_qq_ilive_connect_open_id", (String)localObject1, a());
        LocalMultiProcConfig.putString4Uin("key_qq_ilive_connect_access_token", (String)localObject2, a());
        LocalMultiProcConfig.putLong4Uin("key_qq_ilive_connect_auth_time", System.currentTimeMillis(), a());
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (bmfo)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((bmfo)localObject2).onGetAuthInfo(paramBoolean, new stAuth(1, paramString1, paramString2));
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfn
 * JD-Core Version:    0.7.0.1
 */