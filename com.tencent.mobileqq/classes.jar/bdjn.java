import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordCallback;

public class bdjn
  implements IRecordCallback
{
  public bdjn(RecordTracer paramRecordTracer) {}
  
  public void onRecordEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      bngr.a().a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjn
 * JD-Core Version:    0.7.0.1
 */