import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class aszo
  implements aszg
{
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private final DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private final String jdField_a_of_type_JavaLangString = "shadow::PluginManagerWrapper";
  private final String b;
  
  public aszo(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
    this.b = paramString;
  }
  
  public void a(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    boolean bool = TextUtils.isEmpty(aszn.a().a());
    if (bool) {}
    for (String str = "idle";; str = "busy")
    {
      QLog.i("shadow::PluginManagerWrapper", 1, String.format("doPreLoad pps status is %s ", new Object[] { str }));
      if (bool) {
        enter(paramContext, paramLong, paramBundle, paramEnterCallback);
      }
      return;
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + paramLong + " enterCallback:" + paramEnterCallback);
    }
    aszn.a().a(this.b, this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager);
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    if ("Now".equals(this.b)) {}
    for (paramContext = "33669800";; paramContext = "33669805")
    {
      atbh.b(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(this.b).opType("enter").d1(paramLong + "").report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszo
 * JD-Core Version:    0.7.0.1
 */