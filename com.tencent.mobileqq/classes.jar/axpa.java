import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordCallback;

public class axpa
  implements IRecordCallback
{
  public axpa(RecordTracer paramRecordTracer) {}
  
  public void onRecordEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      bhln.a().a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpa
 * JD-Core Version:    0.7.0.1
 */