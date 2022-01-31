import android.os.AsyncTask;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData;
import cooperation.dingdong.DingdongCalendarSyncUtil;

public final class amkq
  extends AsyncTask
{
  public amkq(int paramInt) {}
  
  protected Void a(DingdongPluginBizObserver.ScheduleMoreSummaryData... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    DingdongCalendarSyncUtil.b(this.a, paramVarArgs);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkq
 * JD-Core Version:    0.7.0.1
 */