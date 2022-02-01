import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bagp
  implements View.OnClickListener
{
  bagp(bagl parambagl, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((bagl.a(this.jdField_a_of_type_Bagl) != null) && (bagl.a(this.jdField_a_of_type_Bagl).isShowing())) {
        bagl.a(this.jdField_a_of_type_Bagl).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        bdll.b(bagl.c(this.jdField_a_of_type_Bagl), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        bdll.b(bagl.d(this.jdField_a_of_type_Bagl), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
          PublicFragmentActivity.a(bagl.g(this.jdField_a_of_type_Bagl), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((bagl.a(this.jdField_a_of_type_Bagl) != null) && (bagl.a(this.jdField_a_of_type_Bagl).isShowing())) {
            bagl.a(this.jdField_a_of_type_Bagl).dismiss();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
            break label284;
          }
          bdll.b(bagl.e(this.jdField_a_of_type_Bagl), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(bagl.h(this.jdField_a_of_type_Bagl));
          bagl.i(this.jdField_a_of_type_Bagl).startActivityForResult(localIntent, 1022);
        }
        label284:
        bdll.b(bagl.f(this.jdField_a_of_type_Bagl), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagp
 * JD-Core Version:    0.7.0.1
 */