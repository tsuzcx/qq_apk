import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bfbr
  extends aofu
{
  public bfbr(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void onModifyTroopNickRule(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d("TroopNickRuleFragment", 2, "onModifyTroopNickRule success uin = " + paramLong1);
      if (TroopNickRuleFragment.a(this.a).equals(String.valueOf(paramLong1))) {
        this.a.c();
      }
      return;
    }
    QLog.i("TroopNickRuleFragment", 2, "onModifyTroopNickRule failed errCode = " + paramLong2 + ", errInfo = " + paramString);
    paramString = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    int i;
    QQAppInterface localQQAppInterface;
    String str;
    if (paramLong2 == 1298L)
    {
      i = 2131719696;
      QQToast.a(paramString, i, 0).a();
      localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = String.valueOf(TroopNickRuleFragment.a(this.a));
      if (paramLong2 != 1298L) {
        break label191;
      }
    }
    label191:
    for (paramString = "3";; paramString = "1")
    {
      localQQAppInterface.reportClickEvent("dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, str, paramString, "", "");
      return;
      i = 2131719695;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbr
 * JD-Core Version:    0.7.0.1
 */