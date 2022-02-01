package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class AddRequestActivity$ClickJumpSpan
  extends ClickableSpan
{
  public int a;
  public Bundle a;
  public String a;
  
  public AddRequestActivity$ClickJumpSpan(AddRequestActivity paramAddRequestActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = paramView.getContext();
    } else {
      paramView = null;
    }
    if (paramView == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      Object localObject;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        try
        {
          localObject = new AllInOne(this.jdField_a_of_type_AndroidOsBundle.getString("key_profile_uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("key_profile_pa", 25));
          ((AllInOne)localObject).profileEntryType = 109;
          ((AllInOne)localObject).chatAbility = this.jdField_a_of_type_AndroidOsBundle.getInt("key_profile_chatability");
          ProfileUtils.openProfileCard(paramView, (AllInOne)localObject);
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
      try
      {
        localObject = new Intent(paramView, DiscussionInfoCardActivity.class);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        paramView.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    TroopUtils.a(paramView, this.jdField_a_of_type_AndroidOsBundle, 2);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.ClickJumpSpan
 * JD-Core Version:    0.7.0.1
 */