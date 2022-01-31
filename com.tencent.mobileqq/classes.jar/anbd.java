import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public final class anbd
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public anbd(String paramString) {}
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      QZonePluginMangerHelper.a(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      paramIQZonePluginManager = paramIQZonePluginManager.a(this.a);
    } while (paramIQZonePluginManager == null);
    QzoneLiveVideoInterface.access$002(paramIQZonePluginManager.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbd
 * JD-Core Version:    0.7.0.1
 */