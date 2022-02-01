import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.qphone.base.util.QLog;

public class ayrj
  extends BroadcastReceiver
{
  public ayrj(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      QLog.d("OCRPerformFragment", 4, "receive videochat");
      OCRPerformFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrj
 * JD-Core Version:    0.7.0.1
 */