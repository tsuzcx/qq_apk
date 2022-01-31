import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;

public class anen
  extends Handler
{
  public anen(SmartDeviceIPCHost paramSmartDeviceIPCHost, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = null;
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anen
 * JD-Core Version:    0.7.0.1
 */