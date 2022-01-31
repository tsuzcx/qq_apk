import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public class bgxl
{
  private static volatile bgxl jdField_a_of_type_Bgxl;
  private MiniAppProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  public static bgxl a()
  {
    if (jdField_a_of_type_Bgxl == null) {}
    try
    {
      if (jdField_a_of_type_Bgxl == null) {
        jdField_a_of_type_Bgxl = new bgxl();
      }
      return jdField_a_of_type_Bgxl;
    }
    finally {}
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginType() == -1) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginType();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginType();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAccount() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAccount();
  }
  
  public byte[] a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginSig() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginSig();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getLoginSig();
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getNickName() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getNickName();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getNickName();
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenId();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenId();
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenKey() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenKey();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPayOpenKey();
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPlatformId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPlatformId();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPlatformId();
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAppId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAppId();
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxl
 * JD-Core Version:    0.7.0.1
 */