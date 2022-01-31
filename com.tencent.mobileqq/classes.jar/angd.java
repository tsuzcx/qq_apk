import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWVoiceController;

public class angd
  implements Runnable
{
  public angd(TroopHWVoiceController paramTroopHWVoiceController) {}
  
  public void run()
  {
    String str = TroopHomeworkHelper.a(TroopHWVoiceController.a(this.a));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = TroopHWVoiceController.a(this.a).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angd
 * JD-Core Version:    0.7.0.1
 */