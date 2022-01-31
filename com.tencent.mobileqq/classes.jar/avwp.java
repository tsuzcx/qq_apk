import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

class avwp
  extends Handler
{
  avwp(avwo paramavwo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = avwo.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      avwq localavwq = (avwq)avwo.a(this.a).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", localavwq.a("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", localavwq.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwp
 * JD-Core Version:    0.7.0.1
 */