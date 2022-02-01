package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class NearbyActivity$6
  implements View.OnClickListener
{
  NearbyActivity$6(NearbyActivity paramNearbyActivity, Button paramButton1, EditText paramEditText1, Button paramButton2, EditText paramEditText2, Button paramButton3, Button paramButton4) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
        return;
      }
      localObject = new AllInOne("0", 41);
      ((AllInOne)localObject).profileEntryType = 5;
      paramView = new Intent();
      paramView.putExtra("AllInOne", (Parcelable)localObject);
      paramView.putExtra("param_mode", 3);
    }
    try
    {
      paramView.putExtra("param_tiny_id", Long.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
      label86:
      RouteUtils.a(BaseApplicationImpl.getContext(), paramView, "/nearby/people/profile");
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())) {
          return;
        }
        paramView = new StringBuilder();
        paramView.append("mqq://card/show_pslcard/?uin=");
        paramView.append(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        paramView.append("&card_type=nearby&from=1&mode=3");
        paramView = paramView.toString();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
        ((NearbyActivity)localObject).startActivity(new Intent((Context)localObject, JumpActivity.class).setData(Uri.parse(paramView)));
        return;
      }
      if (paramView == this.c)
      {
        paramView = new Intent();
        paramView.putExtra("roomNum", 10);
        RouteUtils.a(BaseApplicationImpl.getContext(), paramView, "/nearby/gameroom/invite");
        return;
      }
      if (paramView == this.d)
      {
        paramView = new Intent();
        paramView.putExtra("roomNum", 12);
        RouteUtils.a(BaseApplicationImpl.getContext(), paramView, "/nearby/gameroom/invite");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label86;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.6
 * JD-Core Version:    0.7.0.1
 */