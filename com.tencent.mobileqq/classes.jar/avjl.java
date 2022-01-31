import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

class avjl
  implements begw
{
  avjl(avjk paramavjk, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", avjj.a(this.jdField_a_of_type_Avjk.a), 0, "", "", "", "");
      continue;
      adra.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, avjj.a(this.jdField_a_of_type_Avjk.a), avjj.a(this.jdField_a_of_type_Avjk.a));
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", avjj.a(this.jdField_a_of_type_Avjk.a), 0, "", "", "", "");
      continue;
      if (avjj.a(this.jdField_a_of_type_Avjk.a).m == 2)
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131624110, 0).a();
        label228:
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (avjj.b(this.jdField_a_of_type_Avjk.a) != null) {
          break label338;
        }
      }
      label338:
      for (paramInt = 1;; paramInt = 2)
      {
        awqx.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
        break;
        paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, avjj.a(this.jdField_a_of_type_Avjk.a).b, null, 3020, 3, avjj.a(this.jdField_a_of_type_Avjk.a).c, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131624088), null);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        break label228;
      }
      if (avjj.b(this.jdField_a_of_type_Avjk.a).m == 3)
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131628049, 0).a();
        label375:
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (avjj.a(this.jdField_a_of_type_Avjk.a) != null) {
          break label512;
        }
      }
      label512:
      for (paramInt = 1;; paramInt = 3)
      {
        awqx.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
        break;
        if (avjj.b(this.jdField_a_of_type_Avjk.a).n == 1)
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131628048, 0).a();
          break label375;
        }
        aydb.a(this.jdField_a_of_type_AndroidContentContext, avjj.b(this.jdField_a_of_type_Avjk.a).b, avjj.b(this.jdField_a_of_type_Avjk.a).c, 114, "", avjj.b(this.jdField_a_of_type_Avjk.a).k, true, null);
        break label375;
      }
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
      paramView.putExtra("big_brother_source_key", avjj.c(this.jdField_a_of_type_Avjk.a));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", avjj.a(this.jdField_a_of_type_Avjk.a), 0, "", "", "", "");
      continue;
      axkd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", avjj.a(this.jdField_a_of_type_Avjk.a), 0, "", "", "", "");
      continue;
      azyk.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), avjj.d(this.jdField_a_of_type_Avjk.a), avjj.b(this.jdField_a_of_type_Avjk.a), this.jdField_a_of_type_JavaLangString);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", avjj.a(this.jdField_a_of_type_Avjk.a), 0, "", "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileCardActivity.class);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      localAllInOne.h = 124;
      paramView.putExtra("AllInOne", localAllInOne);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      continue;
      paramView = new Intent();
      paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString).troopcode);
      paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
      azlj.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjl
 * JD-Core Version:    0.7.0.1
 */