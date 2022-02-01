import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

class bbkb
  extends Handler
{
  bbkb(bbka parambbka, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = bbka.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      bbkc localbbkc = (bbkc)bbka.a(this.a).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", localbbkc.a("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", localbbkc.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkb
 * JD-Core Version:    0.7.0.1
 */