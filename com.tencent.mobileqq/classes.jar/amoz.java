import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.plugin.IPluginManager;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;

public class amoz
  implements Runnable
{
  public amoz(TroopPluginManager paramTroopPluginManager, String paramString, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (((IPluginManager)((QQAppInterface)localObject).getManager(26)).isPlugininstalled(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      return;
    }
    if (this.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).sendToTarget();
    }
    this.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(this.jdField_a_of_type_JavaLangString);
    ThreadManager.post(new ampb(this.jdField_a_of_type_CooperationTroopTroopPluginManager, this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoz
 * JD-Core Version:    0.7.0.1
 */