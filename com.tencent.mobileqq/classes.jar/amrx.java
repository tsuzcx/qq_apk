import cooperation.comic.utils.QQComicPluginBridge.PluginInstallObserver;
import cooperation.plugin.IPluginManager;

public final class amrx
  implements Runnable
{
  public amrx(IPluginManager paramIPluginManager, QQComicPluginBridge.PluginInstallObserver paramPluginInstallObserver) {}
  
  public void run()
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("comic_plugin.apk", new amry(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrx
 * JD-Core Version:    0.7.0.1
 */