import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper.StartActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.os.MqqHandler;

public final class amsx
  implements QZoneHelper.StartActivity
{
  public amsx(Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, int paramInt, Activity paramActivity, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    Class localClass = amta.a(str);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("click_time", System.currentTimeMillis());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
    localPluginParams.d = "QZone";
    localPluginParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
    localPluginParams.e = str;
    localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
    localPluginParams.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localPluginParams.c = 60000;
    localPluginParams.f = null;
    localPluginParams.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new amsy(this, str, paramBoolean1, paramBoolean2, localPluginParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsx
 * JD-Core Version:    0.7.0.1
 */