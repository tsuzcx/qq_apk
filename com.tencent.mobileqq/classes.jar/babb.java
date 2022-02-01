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

class babb
  implements View.OnClickListener
{
  babb(baax parambaax, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((baax.a(this.jdField_a_of_type_Baax) != null) && (baax.a(this.jdField_a_of_type_Baax).isShowing())) {
        baax.a(this.jdField_a_of_type_Baax).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        bdla.b(baax.c(this.jdField_a_of_type_Baax), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        bdla.b(baax.d(this.jdField_a_of_type_Baax), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
          PublicFragmentActivity.a(baax.g(this.jdField_a_of_type_Baax), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((baax.a(this.jdField_a_of_type_Baax) != null) && (baax.a(this.jdField_a_of_type_Baax).isShowing())) {
            baax.a(this.jdField_a_of_type_Baax).dismiss();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
            break label284;
          }
          bdla.b(baax.e(this.jdField_a_of_type_Baax), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(baax.h(this.jdField_a_of_type_Baax));
          baax.i(this.jdField_a_of_type_Baax).startActivityForResult(localIntent, 1022);
        }
        label284:
        bdla.b(baax.f(this.jdField_a_of_type_Baax), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babb
 * JD-Core Version:    0.7.0.1
 */