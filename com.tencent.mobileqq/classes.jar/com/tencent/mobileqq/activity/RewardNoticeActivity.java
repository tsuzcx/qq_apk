package com.tencent.mobileqq.activity;

import Override;
import aeus;
import aeuu;
import aeuv;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anqn;
import anqs;
import bdla;
import bhbx;
import bhde;
import bhln;
import bhlp;
import bhow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;

public class RewardNoticeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  protected long a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aeus(this);
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anqs jdField_a_of_type_Anqs = new aeuu(this);
  private bhde jdField_a_of_type_Bhde;
  bhow jdField_a_of_type_Bhow = new aeuv(this);
  protected String a;
  protected byte[] a;
  protected int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  ImageView c;
  protected String c;
  ImageView d;
  protected String d;
  protected String e;
  public String f;
  protected String g;
  
  private void e()
  {
    Object localObject = super.getIntent();
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("rewardType", 1);
    byte[] arrayOfByte1 = ((Intent)localObject).getByteArrayExtra("rewardName");
    byte[] arrayOfByte2 = ((Intent)localObject).getByteArrayExtra("rewardUrl");
    byte[] arrayOfByte3 = ((Intent)localObject).getByteArrayExtra("rewardJupWording");
    byte[] arrayOfByte4 = ((Intent)localObject).getByteArrayExtra("rewardOptWording");
    byte[] arrayOfByte5 = ((Intent)localObject).getByteArrayExtra("rewardOptUrl");
    byte[] arrayOfByte6 = ((Intent)localObject).getByteArrayExtra("rewardToastWording");
    byte[] arrayOfByte7 = ((Intent)localObject).getByteArrayExtra("rewardIconUrl");
    if (arrayOfByte1 != null) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = new String(arrayOfByte1, "UTF-8");
      if (arrayOfByte2 != null) {
        this.jdField_b_of_type_JavaLangString = new String(arrayOfByte2, "UTF-8");
      }
      if (arrayOfByte3 != null) {
        this.jdField_c_of_type_JavaLangString = new String(arrayOfByte3, "UTF-8");
      }
      if (arrayOfByte4 != null) {
        this.jdField_d_of_type_JavaLangString = new String(arrayOfByte4, "UTF-8");
      }
      if (arrayOfByte5 != null) {
        this.e = new String(arrayOfByte5, "UTF-8");
      }
      if (arrayOfByte6 != null) {
        this.f = new String(arrayOfByte6, "UTF-8");
      }
      if (arrayOfByte7 != null) {
        this.g = new String(arrayOfByte7, "UTF-8");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.BabyQ", 2, "UnsupportedEncodingException" + localUnsupportedEncodingException.toString());
          continue;
          i = 0;
        }
      }
    }
    this.jdField_a_of_type_ArrayOfByte = ((Intent)localObject).getByteArrayExtra("rewardCookie");
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("rewardFaceId", -1L);
    }
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("rewardReportType", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initData type:").append(this.jdField_a_of_type_Int).append(" name:").append(this.jdField_a_of_type_JavaLangString).append(" url:").append(bhbx.a(this.jdField_b_of_type_JavaLangString)).append(" cookie:");
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        i = this.jdField_a_of_type_ArrayOfByte.length;
        QLog.d("Q.BabyQ", 2, i + " jump:" + bhbx.a(this.jdField_c_of_type_JavaLangString) + " optWord:" + this.jdField_d_of_type_JavaLangString + " optUrl:" + bhbx.a(this.e) + " toast:" + this.f + " picUrl:" + bhbx.a(this.g) + " faceId:" + this.jdField_a_of_type_Long);
      }
    }
    else
    {
      return;
    }
  }
  
  void a()
  {
    int i = 0;
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(this, 1, 2131694253, 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {
        if (this.jdField_a_of_type_Long == -1L)
        {
          QLog.e("Q.BabyQ", 2, "receive error face id");
          i = 1;
        }
      }
      while (i != 0)
      {
        finish();
        return;
        ((VasExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.jdField_a_of_type_Long, -1, 1);
        bdla.b(this.app, "dc00898", "", "", "0X800723D", "0X800723D", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_Int == 11)
        {
          b();
          anqn.a(this.app, this.jdField_b_of_type_Int, 2);
          i = 1;
        }
        else if ((this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 13))
        {
          ((anqn)this.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b(this.jdField_a_of_type_ArrayOfByte);
          anqn.a(this.app, this.jdField_b_of_type_Int, 2);
        }
        else if (this.jdField_a_of_type_Int == 2)
        {
          d();
          bdla.b(this.app, "dc00898", "", "", "0X800724B", "0X800724B", 0, 0, "", "", "", "");
          i = 1;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.BabyQ", 2, "pickReward error type:" + this.jdField_a_of_type_Int);
          }
          i = 1;
        }
      }
    }
  }
  
  public void a(View paramView, Animation.AnimationListener paramAnimationListener, float paramFloat, long paramLong, int paramInt)
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(-paramFloat, paramFloat, 1, 0.5F, 1, 0.7F);
    localRotateAnimation.setDuration(paramLong / (paramInt + 1));
    localRotateAnimation.setRepeatMode(2);
    localRotateAnimation.setRepeatCount(paramInt);
    paramView.clearAnimation();
    paramView.startAnimation(localRotateAnimation);
    if (paramAnimationListener != null) {
      localRotateAnimation.setAnimationListener(paramAnimationListener);
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("leftViewText", super.getString(2131690499));
    super.startActivity(localIntent);
  }
  
  public void c()
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.3F, 1.06F, 0.3F, 1.06F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setStartOffset(0L);
    localScaleAnimation1.setDuration(300L);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.06F, 1.0F, 1.06F, 1.0F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setStartOffset(300L);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  void d()
  {
    String str = "";
    if (bhln.a != null) {
      str = bhln.a.jdField_a_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(str))
    {
      str = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123", new Object[] { "0", "mvip.pingtai.mobileqq.androidziliaoka.fromqita" }) + "&adtag=" + "qita";
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "gotoQQVipWeb() url = " + str);
      }
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject).putExtra("url", str);
      ((Intent)localObject).putExtra("hide_more_button", true);
      super.startActivity((Intent)localObject);
      return;
    }
    Object localObject = new StringBuilder(str);
    if (str.contains("?")) {
      ((StringBuilder)localObject).append("&platform=1");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("&qq=" + "0");
      ((StringBuilder)localObject).append("&adtag=" + "qita");
      ((StringBuilder)localObject).append("&aid=" + "mvip.pingtai.mobileqq.androidziliaoka.fromqita");
      str = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append("?platform=1");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561460);
    e();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376638));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376639));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131378500));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131376633));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376635));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376637));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364708));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131376634));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376104);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.g)) {}
    try
    {
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = DisplayUtil.dip2px(this, 75.0F);
      paramBundle.mRequestHeight = DisplayUtil.dip2px(this, 65.0F);
      paramBundle = URLDrawable.getDrawable(this.g, paramBundle);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      this.jdField_a_of_type_Bhde = new bhde(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_Bhde.sendEmptyMessageDelayed(1, 200L);
      super.addObserver(this.jdField_a_of_type_Anqs);
      super.addObserver(this.jdField_a_of_type_Bhow);
      if (this.jdField_a_of_type_Int == 2)
      {
        bdla.b(this.app, "dc00898", "", "", "0X800724A", "0X800724A", 0, 0, "", "", "", "");
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.BabyQ", 2, "load pic error" + paramBundle.toString());
        }
      }
      anqn.a(this.app, this.jdField_b_of_type_Int, 1);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Anqs);
    super.removeObserver(this.jdField_a_of_type_Bhow);
    this.jdField_a_of_type_Bhde.removeCallbacksAndMessages(null);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity
 * JD-Core Version:    0.7.0.1
 */