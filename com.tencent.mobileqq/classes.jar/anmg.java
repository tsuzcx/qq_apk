import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.widgetai.QzoneWidgetAIInterface;

public final class anmg
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public anmg(String paramString) {}
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      QZonePluginMangerHelper.a(QzoneWidgetAIInterface.getContext(), this);
    }
    do
    {
      return;
      paramIQZonePluginManager = paramIQZonePluginManager.a(this.a);
    } while (paramIQZonePluginManager == null);
    QzoneWidgetAIInterface.access$002(paramIQZonePluginManager.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmg
 * JD-Core Version:    0.7.0.1
 */