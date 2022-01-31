import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.vashealth.PathTraceManager;

public class bdtz
  implements PluginInterfaceHelper.OnPluginInterfaceLoadedListener
{
  public bdtz(PathTraceManager paramPathTraceManager) {}
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    PathTraceManager.a(this.a, paramPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtz
 * JD-Core Version:    0.7.0.1
 */