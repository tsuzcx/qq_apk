import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class baca
  implements babz
{
  private final DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private final String jdField_a_of_type_JavaLangString = "shadow::PluginManagerWrapper";
  private final String b;
  
  public baca(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
    this.b = paramString;
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + paramLong + " enterCallback:" + paramEnterCallback);
    }
    aszn.a().a(this.b, this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (babo)((QQAppInterface)localObject).getManager(362);
      if (localObject != null) {
        ((babo)localObject).a(this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager);
      }
    }
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baca
 * JD-Core Version:    0.7.0.1
 */