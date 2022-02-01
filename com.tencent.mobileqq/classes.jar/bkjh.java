import NS_KING_PUBLIC.stAuth;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;

class bkjh
  implements bkjv
{
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Bundle jdField_a_of_type_AndroidOsBundle;
  EnterCallback jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private boolean jdField_a_of_type_Boolean;
  
  public bkjh(bkjf parambkjf, PluginManager paramPluginManager, long paramLong, Context paramContext, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = paramPluginManager;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback = paramEnterCallback;
  }
  
  public void onGetAuthInfo(boolean paramBoolean, stAuth paramstAuth)
  {
    bkkd.b("stAuth");
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        bkjf.a(this.jdField_a_of_type_Bkjf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager, this.jdField_a_of_type_AndroidOsBundle, paramstAuth, this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback);
      }
      return;
    }
    if (IlivePluginManager.getInstance().getPluginCallback() != null) {
      IlivePluginManager.getInstance().getPluginCallback().onPluginLoginFail(-1, "auth login fail");
    }
    QLog.e("IliveAuthShadowImpl", 1, "[enter] pluginManager auth fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjh
 * JD-Core Version:    0.7.0.1
 */