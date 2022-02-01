import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.QQPermissionCallback;

final class aoue
  implements QQPermissionCallback
{
  aoue(JumpActivity paramJumpActivity, boolean paramBoolean) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpActivityHelper", 1, "system share.doShare denied sd grant");
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, new aouf(this));
    paramArrayOfString = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareDeny", true, 0L, 0L, paramArrayOfString, "");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpActivityHelper", 1, "system share.doShare user grant");
    aoud.b(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_Boolean);
    paramArrayOfString = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareGrant", true, 0L, 0L, paramArrayOfString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoue
 * JD-Core Version:    0.7.0.1
 */