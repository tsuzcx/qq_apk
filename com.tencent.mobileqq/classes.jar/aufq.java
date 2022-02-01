import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener;
import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

class aufq
  implements FlutterBoost.BoostLifecycleListener
{
  aufq(aufo paramaufo) {}
  
  public void beforeCreateEngine()
  {
    QLog.d("QFlutter.launcher", 1, "beforeCreateEngine");
  }
  
  public void onEngineCreated()
  {
    QLog.d("QFlutter.launcher", 1, "onEngineCreated");
    FlutterEngine localFlutterEngine = FlutterBoost.instance().engineProvider();
    GeneratedPluginRegistrant.registerWith(localFlutterEngine);
    auef.a().a(localFlutterEngine.getDartExecutor(), localFlutterEngine.getRenderer());
    aufo.a(this.a).e();
    aufo.a(this.a, 0, true);
  }
  
  public void onEngineDestroy()
  {
    QLog.d("QFlutter.launcher", 1, "onEngineDestroy");
  }
  
  public void onPluginsRegistered() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufq
 * JD-Core Version:    0.7.0.1
 */