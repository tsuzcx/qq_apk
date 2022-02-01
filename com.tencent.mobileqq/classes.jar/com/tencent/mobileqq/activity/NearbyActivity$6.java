package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyActivity$6
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne("0", 41);
      localAllInOne.h = 5;
      Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, NearbyPeopleProfileActivity.class);
      ((Intent)localObject).putExtra("AllInOne", localAllInOne);
      ((Intent)localObject).putExtra("param_mode", 3);
      try
      {
        ((Intent)localObject).putExtra("param_tiny_id", Long.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
        label99:
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.startActivity((Intent)localObject);
        continue;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())) {
            continue;
          }
          localObject = "mqq://card/show_pslcard/?uin=" + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString() + "&card_type=nearby&from=1&mode=3";
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, JumpActivity.class).setData(Uri.parse((String)localObject)));
          continue;
        }
        if (paramView == this.c)
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, GameRoomInviteActivity.class);
          ((Intent)localObject).putExtra("roomNum", 10);
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.startActivity((Intent)localObject);
          continue;
        }
        if (paramView != this.d) {
          continue;
        }
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, GameRoomInviteActivity.class);
        ((Intent)localObject).putExtra("roomNum", 12);
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.startActivity((Intent)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label99;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.6
 * JD-Core Version:    0.7.0.1
 */