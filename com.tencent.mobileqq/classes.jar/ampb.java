import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.plugin.IPluginManager;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;
import java.lang.ref.WeakReference;

public class ampb
  implements Runnable
{
  Handler jdField_a_of_type_AndroidOsHandler = new ampc(this, Looper.getMainLooper());
  TroopPluginManager.TroopPluginCallback jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback;
  String jdField_a_of_type_JavaLangString;
  
  public ampb(TroopPluginManager paramTroopPluginManager, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback, String paramString)
  {
    this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback = paramTroopPluginCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_CooperationTroopTroopPluginManager.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (IPluginManager)((QQAppInterface)localObject).getManager(26);
    } while (localObject == null);
    ((IPluginManager)localObject).a(this.jdField_a_of_type_JavaLangString, false, new ampd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampb
 * JD-Core Version:    0.7.0.1
 */