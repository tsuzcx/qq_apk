package com.tencent.biz.qqstory.takevideo;

import ajya;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axlk;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import vhm;
import vkj;

public class EditWebDanceMachineVideoActivity
  extends EditVideoActivity
  implements View.OnClickListener
{
  public static int a;
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString = "http://qun.qq.com/qqweb/m/qun/qun_activity/dance-game.html";
  private vkj jdField_a_of_type_Vkj;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "?ddcat=%s&ddid=%s&uuid=%s&md5=%s&uin=%s&nick=%s&score=%s&percent=%s&_wv=16778243&_bid=2932";
  private String c = "";
  private String d = "";
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 90001)
    {
      if (paramIntent == null) {
        return;
      }
      if (paramInt1 == 10004) {
        paramIntent.putExtra("result_from_dance_machine", true);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_Vkj.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (RelativeLayout)findViewById(2131363765);
    paramBundle.removeAllViews();
    paramBundle.getLayoutParams().height = axlk.a(70.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(8.0F);
    localGradientDrawable.setStroke(0, Color.parseColor("#12B7F5"));
    FadedButton localFadedButton = new FadedButton(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, axlk.a(40.0F));
    int i = axlk.a(15.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setBackgroundDrawable(localGradientDrawable);
    localFadedButton.setTextSize(1, 18.0F);
    localFadedButton.setTextColor(-1);
    localFadedButton.setText(ajya.a(2131703955));
    localFadedButton.setGravity(17);
    localFadedButton.setOnClickListener(this);
    paramBundle.addView(localFadedButton);
    this.jdField_a_of_type_Vkj = new vkj();
    paramBundle = "";
    if ((this.jdField_a_of_type_Vhm.a.a instanceof EditTakeVideoSource)) {
      paramBundle = ((EditTakeVideoSource)this.jdField_a_of_type_Vhm.a.a).jdField_b_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Vkj.a(this, paramBundle, this.jdField_a_of_type_Vhm.a.a.a(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Vhm);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Vkj != null) {
      this.jdField_a_of_type_Vkj.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Vkj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebDanceMachineVideoActivity
 * JD-Core Version:    0.7.0.1
 */