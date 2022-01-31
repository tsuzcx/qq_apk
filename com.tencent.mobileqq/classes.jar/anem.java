import android.content.Context;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;

public final class anem
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public anem(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener) {}
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
      return;
    }
    paramIQZonePluginManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anem
 * JD-Core Version:    0.7.0.1
 */