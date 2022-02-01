import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordCallback;
import cooperation.qzone.report.wmd.WMDReportManager;

public class bccd
  implements IRecordCallback
{
  public bccd(RecordTracer paramRecordTracer) {}
  
  public void onRecordEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      WMDReportManager.getInstance().report(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccd
 * JD-Core Version:    0.7.0.1
 */