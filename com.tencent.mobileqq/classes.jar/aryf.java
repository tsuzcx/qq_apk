import com.idlefish.flutterboost.FlutterBoost.BoostPluginsRegister;
import com.tencent.qflutter.TextPlatformViewPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;

class aryf
  implements FlutterBoost.BoostPluginsRegister
{
  aryf(aryd paramaryd) {}
  
  public void registerPlugins(PluginRegistry paramPluginRegistry)
  {
    GeneratedPluginRegistrant.registerWith(paramPluginRegistry);
    paramPluginRegistry = paramPluginRegistry.registrarFor("TextPlatformViewPlugin");
    TextPlatformViewPlugin.register(paramPluginRegistry);
    arwv.a().a(paramPluginRegistry.messenger());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryf
 * JD-Core Version:    0.7.0.1
 */