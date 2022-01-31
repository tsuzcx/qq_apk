import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetNearbyRecommender;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class amdq
  extends allb
{
  public amdq(GetNearbyRecommender paramGetNearbyRecommender) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetNearbyRecommender onGetDetailInfo|uin=" + paramString);
    }
    if (!this.a.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */