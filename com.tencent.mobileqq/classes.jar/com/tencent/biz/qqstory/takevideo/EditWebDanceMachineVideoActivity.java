package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.dancemachine.WebVideoSharer;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class EditWebDanceMachineVideoActivity
  extends EditVideoActivity
  implements View.OnClickListener
{
  public static int a;
  private long jdField_a_of_type_Long = -1L;
  private WebVideoSharer jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer;
  private String jdField_a_of_type_JavaLangString = "http://qun.qq.com/qqweb/m/qun/qun_activity/dance-game.html";
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "?ddcat=%s&ddid=%s&uuid=%s&md5=%s&uin=%s&nick=%s&score=%s&percent=%s&_wv=16778243&_bid=2932";
  private String c = "";
  private String d = "";
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (RelativeLayout)findViewById(2131371911);
    paramBundle.removeAllViews();
    paramBundle.getLayoutParams().height = ScreenUtil.a(70.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(8.0F);
    localGradientDrawable.setStroke(0, Color.parseColor("#12B7F5"));
    FadedButton localFadedButton = new FadedButton(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.a(40.0F));
    int i = ScreenUtil.a(15.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setBackgroundDrawable(localGradientDrawable);
    localFadedButton.setTextSize(1, 18.0F);
    localFadedButton.setTextColor(-1);
    localFadedButton.setText("分享给好友");
    localFadedButton.setGravity(17);
    localFadedButton.setOnClickListener(this);
    paramBundle.addView(localFadedButton);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer = new WebVideoSharer();
    paramBundle = "";
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) {
      paramBundle = ((EditTakeVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).jdField_b_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer.a(this, paramBundle, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a.a(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineWebVideoSharer.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebDanceMachineVideoActivity
 * JD-Core Version:    0.7.0.1
 */