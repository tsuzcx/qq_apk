import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;

public final class ampc
  extends Thread
{
  public ampc(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    PluginManagerHelper.getPluginInterface(this.jdField_a_of_type_AndroidContentContext, new ampd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ampc
 * JD-Core Version:    0.7.0.1
 */