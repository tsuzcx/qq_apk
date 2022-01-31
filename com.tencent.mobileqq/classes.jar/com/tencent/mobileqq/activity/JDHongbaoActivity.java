package com.tencent.mobileqq.activity;

import adew;
import alnq;
import alud;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdin;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class JDHongbaoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  public AlphaAnimation a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375922));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368742));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131368832));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378645));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378643));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378642));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378644));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378698));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378826));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375900));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new adew(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367717);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 0.7F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(350L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JDHongbaoActivity", 2, "showHongbaoResult jumpUrl " + paramString);
    }
    if (!bdin.d(this)) {
      QQToast.a(this, alud.a(2131706258), 1).a();
    }
    while (paramString == null) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", true);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    setResult(-1);
    finish();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("jd_hb_title");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("jd_hb_subtitle");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("jd_hb_is_check_delay", true);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("jd_hb_detail_text");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("jd_hongbao_tips");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("jd_hb_btn_text");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("jd_hb_logo_url");
    this.g = getIntent().getStringExtra("jd_hb_detail_url");
    this.h = getIntent().getStringExtra("jd_hb_btn_url");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString + ">");
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      alnq.a(134247337, this.app);
    }
    for (;;)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getApplicationContext().getResources().getDrawable(2130844537);
      localObject = URLDrawable.getDrawable(this.jdField_f_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (localObject != null)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      alnq.a(134247333, this.app);
    }
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(new JDHongbaoActivity.1(this), 500L);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (getIntent() == null)
    {
      finish();
      return false;
    }
    setContentView(2131558648);
    a();
    b();
    c();
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(this.g);
      if (this.jdField_a_of_type_Boolean)
      {
        alnq.a(134247339, this.app);
        return;
      }
      alnq.a(134247335, this.app);
      return;
      alnq.a(134247334, this.app);
      a(this.h);
      return;
      alnq.a(134247338, this.app);
      a(this.h);
      return;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L);
    finish();
    if (this.jdField_a_of_type_Boolean)
    {
      alnq.a(134247340, this.app);
      return;
    }
    alnq.a(134247336, this.app);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JDHongbaoActivity
 * JD-Core Version:    0.7.0.1
 */