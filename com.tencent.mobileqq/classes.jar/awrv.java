import SummaryCardTaf.SSummaryCardRsp;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awrv
  extends alpq
{
  public awrv(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    String str = this.a.app.getCurrentAccountUin();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_BackgroundId", String.valueOf(this.a.g));
    localHashMap.put("param_StyleId", String.valueOf(this.a.jdField_a_of_type_Long));
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.b();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card)) {
        ThreadManager.post(new VipProfileCardBaseActivity.2.1(this, (Card)paramObject, localHashMap, str), 5, null, true);
      }
      while (!(paramObject instanceof Pair)) {
        return;
      }
      paramObject = (Pair)paramObject;
      Message localMessage;
      if (((Integer)paramObject.first).intValue() == 101107)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.d = 2;
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      for (;;)
      {
        localHashMap.put("param_FailCode", String.valueOf(paramObject.first));
        azri.a(this.a.app.getApp()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
        return;
        if (((Integer)paramObject.first).intValue() == 101108)
        {
          this.a.jdField_a_of_type_Int = 2;
          this.a.d = 5;
          localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        else
        {
          localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            localMessage.obj = ((SSummaryCardRsp)paramObject.second).emsg;
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramObject = "-104";; paramObject = "-105")
    {
      localHashMap.put("param_FailCode", paramObject);
      azri.a(this.a.app.getApp()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awrv
 * JD-Core Version:    0.7.0.1
 */