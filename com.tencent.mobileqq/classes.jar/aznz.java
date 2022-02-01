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

class aznz
  implements View.OnClickListener
{
  aznz(aznv paramaznv, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aznv.a(this.jdField_a_of_type_Aznv) != null) && (aznv.a(this.jdField_a_of_type_Aznv).isShowing())) {
        aznv.a(this.jdField_a_of_type_Aznv).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        bcst.b(aznv.c(this.jdField_a_of_type_Aznv), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        bcst.b(aznv.d(this.jdField_a_of_type_Aznv), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
          PublicFragmentActivity.a(aznv.g(this.jdField_a_of_type_Aznv), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((aznv.a(this.jdField_a_of_type_Aznv) != null) && (aznv.a(this.jdField_a_of_type_Aznv).isShowing())) {
            aznv.a(this.jdField_a_of_type_Aznv).dismiss();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
            break label284;
          }
          bcst.b(aznv.e(this.jdField_a_of_type_Aznv), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(aznv.h(this.jdField_a_of_type_Aznv));
          aznv.i(this.jdField_a_of_type_Aznv).startActivityForResult(localIntent, 1022);
        }
        label284:
        bcst.b(aznv.f(this.jdField_a_of_type_Aznv), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznz
 * JD-Core Version:    0.7.0.1
 */