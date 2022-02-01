import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.qphone.base.util.QLog;

public class apbw
  implements bbuj
{
  public apbw(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void onCameraException(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbw
 * JD-Core Version:    0.7.0.1
 */