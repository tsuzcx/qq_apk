import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

class axoo
  extends Handler
{
  axoo(axon paramaxon, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = axon.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      axop localaxop = (axop)axon.a(this.a).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", localaxop.a("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", localaxop.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axoo
 * JD-Core Version:    0.7.0.1
 */