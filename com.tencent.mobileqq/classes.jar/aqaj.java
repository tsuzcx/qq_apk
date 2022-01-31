import com.idlefish.flutterboost.FlutterBoost.BoostPluginsRegister;
import com.tencent.qflutter.TextPlatformViewPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;

final class aqaj
  implements FlutterBoost.BoostPluginsRegister
{
  public void registerPlugins(PluginRegistry paramPluginRegistry)
  {
    GeneratedPluginRegistrant.registerWith(paramPluginRegistry);
    paramPluginRegistry = paramPluginRegistry.registrarFor("TextPlatformViewPlugin");
    TextPlatformViewPlugin.register(paramPluginRegistry);
    apzk.a().a(paramPluginRegistry.messenger());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqaj
 * JD-Core Version:    0.7.0.1
 */