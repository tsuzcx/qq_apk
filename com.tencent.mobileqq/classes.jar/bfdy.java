import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;

public final class bfdy
{
  public static void a(PluginRegistry paramPluginRegistry)
  {
    if (!a(paramPluginRegistry))
    {
      PackageInfoPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.packageinfo.PackageInfoPlugin"));
      PathProviderPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
      QflutterLogPlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
      WebViewFlutterPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.webviewflutter.WebViewFlutterPlugin"));
    }
  }
  
  private static boolean a(PluginRegistry paramPluginRegistry)
  {
    String str = GeneratedPluginRegistrant.class.getCanonicalName();
    if (paramPluginRegistry.hasPlugin(str)) {
      return true;
    }
    paramPluginRegistry.registrarFor(str);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdy
 * JD-Core Version:    0.7.0.1
 */