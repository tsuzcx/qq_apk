import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.qphone.base.util.QLog;

public class atmn
  extends ayxl
{
  public atmn(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch get push GameCenterObserver ");
    paramBundle = this.a.a.obtainMessage(1);
    this.a.a.sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmn
 * JD-Core Version:    0.7.0.1
 */