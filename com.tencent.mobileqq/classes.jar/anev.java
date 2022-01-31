import android.content.Context;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;

class anev
  extends OnQZonePluginInstallListner.Stub
{
  anev(aneu paramaneu, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
      return;
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anev
 * JD-Core Version:    0.7.0.1
 */