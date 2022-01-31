import android.os.Handler;
import android.os.Message;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;

public class ammq
  extends ajzm
{
  public ammq(LocationSelectActivity paramLocationSelectActivity) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramLBSInfo != null) {}
    for (paramLBSInfo = paramLBSInfo.a(); Math.abs(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) > 1200L; paramLBSInfo = null)
    {
      this.a.a(paramBoolean, paramLBSInfo);
      return;
    }
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000);
    localMessage.obj = new Object[] { Boolean.valueOf(paramBoolean), paramLBSInfo };
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammq
 * JD-Core Version:    0.7.0.1
 */