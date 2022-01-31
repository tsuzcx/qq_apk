package com.tencent.mobileqq.armap.map;

import abhl;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.im.poi.LbsPackShareOption;
import com.qq.im.poi.PoiInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;

public class LbsPackShareDialog
  extends Dialog
  implements View.OnClickListener
{
  private static long jdField_a_of_type_Long;
  int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PoiInfo jdField_a_of_type_ComQqImPoiPoiInfo;
  public BaseActivity a;
  private String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public LbsPackShareDialog(Context paramContext, BaseActivity paramBaseActivity, PoiInfo paramPoiInfo, String paramString)
  {
    super(paramContext, 2131624516);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComQqImPoiPoiInfo = paramPoiInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    setContentView(2130970379);
    a();
  }
  
  public void a()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels;
    localWindow.setAttributes(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362841));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370303));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370304));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131370306));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363978));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      return;
    }
    try
    {
      super.show();
      int j = getWindow().getAttributes().width;
      int i = getWindow().getAttributes().height;
      j = (j - AIOUtils.a(320.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources())) / 2;
      i = (i - AIOUtils.a(420.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources())) / 2;
      this.jdField_a_of_type_Int = (getWindow().getAttributes().width / 2);
      this.jdField_b_of_type_Int = (getWindow().getAttributes().height / 2);
      AnimationSet localAnimationSet = new AnimationSet(false);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
      localScaleAnimation.setInterpolator(new AccelerateInterpolator());
      localScaleAnimation.setDuration(350L);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
      localAlphaAnimation.setDuration(350L);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setFillAfter(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(320.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources())) / 2;
    i = (i - AIOUtils.a(420.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new abhl(this));
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_a_of_type_Long > 0L) && (l - jdField_a_of_type_Long < 400L)) {
      return;
    }
    jdField_a_of_type_Long = l;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363978: 
      c();
      return;
    }
    new LbsPackShareOption(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.LbsPackShareDialog
 * JD-Core Version:    0.7.0.1
 */