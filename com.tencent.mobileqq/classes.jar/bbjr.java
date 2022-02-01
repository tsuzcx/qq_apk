import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

class bbjr
  extends Handler
{
  bbjr(bbjq parambbjq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = bbjq.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      bbjs localbbjs = (bbjs)bbjq.a(this.a).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", localbbjs.a("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", localbbjs.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjr
 * JD-Core Version:    0.7.0.1
 */