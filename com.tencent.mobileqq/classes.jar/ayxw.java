import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.qphone.base.util.QLog;

public class ayxw
  extends BroadcastReceiver
{
  public ayxw(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      QLog.d("OCRPerformFragment", 4, "receive videochat");
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxw
 * JD-Core Version:    0.7.0.1
 */