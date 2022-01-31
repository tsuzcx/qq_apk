import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;

public class beuc
{
  private static volatile beuc jdField_a_of_type_Beuc;
  private MiniAppProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  public static beuc a()
  {
    if (jdField_a_of_type_Beuc == null) {}
    try
    {
      if (jdField_a_of_type_Beuc == null) {
        jdField_a_of_type_Beuc = new beuc();
      }
      return jdField_a_of_type_Beuc;
    }
    finally {}
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginType() == -1) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().a();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginType();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAccount() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().a();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAccount();
  }
  
  public byte[] a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginSig() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().a();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginSig();
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getNickName() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().b();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getNickName();
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenId() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().c();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenId();
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenKey() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().d();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenKey();
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPlatformId() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().e();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPlatformId();
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAppId() == null) && (MiniAppEnv.g().getLoginInfo() != null)) {
      return MiniAppEnv.g().getLoginInfo().f();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuc
 * JD-Core Version:    0.7.0.1
 */