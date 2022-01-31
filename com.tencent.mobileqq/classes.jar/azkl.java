import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordCallback;

public class azkl
  implements IRecordCallback
{
  public azkl(RecordTracer paramRecordTracer) {}
  
  public void onRecordEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      bjmy.a().a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkl
 * JD-Core Version:    0.7.0.1
 */