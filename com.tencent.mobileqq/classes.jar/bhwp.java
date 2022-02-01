import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.vashealth.PathTraceManager;

public class bhwp
  implements PluginInterfaceHelper.OnPluginInterfaceLoadedListener
{
  public bhwp(PathTraceManager paramPathTraceManager) {}
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    PathTraceManager.a(this.a, paramPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwp
 * JD-Core Version:    0.7.0.1
 */