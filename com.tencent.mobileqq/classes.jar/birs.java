import android.content.Context;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

public class birs
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  private boolean jdField_a_of_type_Boolean;
  
  public birs(birn parambirn) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      try
      {
        AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 2, localException, new Object[0]);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      try
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 2, localException, new Object[0]);
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    birn.a(this.jdField_a_of_type_Birn).sendEmptyMessage(66304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birs
 * JD-Core Version:    0.7.0.1
 */