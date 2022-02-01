package com.tencent.biz.qqstory.takevideo;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anvx;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ynw;
import yqs;

public class EditWebDanceMachineVideoActivity
  extends EditVideoActivity
  implements View.OnClickListener
{
  public static int a;
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString = "https://qun.qq.com/qqweb/m/qun/qun_activity/dance-game.html";
  private yqs jdField_a_of_type_Yqs;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "?ddcat=%s&ddid=%s&uuid=%s&md5=%s&uin=%s&nick=%s&score=%s&percent=%s&_wv=16778243&_bid=2932";
  private String c = "";
  private String d = "";
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    this.jdField_a_of_type_Yqs.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (RelativeLayout)findViewById(2131364154);
    paramBundle.removeAllViews();
    paramBundle.getLayoutParams().height = ScreenUtil.dip2px(70.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(8.0F);
    localGradientDrawable.setStroke(0, Color.parseColor("#12B7F5"));
    FadedButton localFadedButton = new FadedButton(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.dip2px(40.0F));
    int i = ScreenUtil.dip2px(15.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setBackgroundDrawable(localGradientDrawable);
    localFadedButton.setTextSize(1, 18.0F);
    localFadedButton.setTextColor(-1);
    localFadedButton.setText(anvx.a(2131703424));
    localFadedButton.setGravity(17);
    localFadedButton.setOnClickListener(this);
    paramBundle.addView(localFadedButton);
    this.jdField_a_of_type_Yqs = new yqs();
    paramBundle = "";
    if ((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) {
      paramBundle = ((EditTakeVideoSource)this.jdField_a_of_type_Ynw.a.mEditSource).jdField_b_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Yqs.a(this, paramBundle, this.jdField_a_of_type_Ynw.a.mEditSource.getSourcePath(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Ynw);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Yqs != null) {
      this.jdField_a_of_type_Yqs.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Yqs.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebDanceMachineVideoActivity
 * JD-Core Version:    0.7.0.1
 */