package com.tencent.mobileqq.activity;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PersonalCardUrlInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;

public class RewardNoticeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  RelativeLayout a;
  RelativeLayout b;
  ImageView c;
  ImageView d;
  TextView e;
  ImageView f;
  TextView g;
  ImageView h;
  View i;
  protected int j;
  protected String k;
  protected String l;
  protected byte[] m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected long s;
  protected int t;
  Handler.Callback u = new RewardNoticeActivity.1(this);
  BabyQObserver v = new RewardNoticeActivity.2(this);
  IApolloExtensionObserver w = new RewardNoticeActivity.3(this);
  private CustomHandler x;
  
  private void e()
  {
    Object localObject1 = super.getIntent();
    this.j = ((Intent)localObject1).getIntExtra("rewardType", 1);
    Object localObject2 = ((Intent)localObject1).getByteArrayExtra("rewardName");
    byte[] arrayOfByte1 = ((Intent)localObject1).getByteArrayExtra("rewardUrl");
    byte[] arrayOfByte2 = ((Intent)localObject1).getByteArrayExtra("rewardJupWording");
    byte[] arrayOfByte3 = ((Intent)localObject1).getByteArrayExtra("rewardOptWording");
    byte[] arrayOfByte4 = ((Intent)localObject1).getByteArrayExtra("rewardOptUrl");
    byte[] arrayOfByte5 = ((Intent)localObject1).getByteArrayExtra("rewardToastWording");
    byte[] arrayOfByte6 = ((Intent)localObject1).getByteArrayExtra("rewardIconUrl");
    if (localObject2 != null) {}
    try
    {
      this.k = new String((byte[])localObject2, "UTF-8");
      if (arrayOfByte1 != null) {
        this.l = new String(arrayOfByte1, "UTF-8");
      }
      if (arrayOfByte2 != null) {
        this.n = new String(arrayOfByte2, "UTF-8");
      }
      if (arrayOfByte3 != null) {
        this.o = new String(arrayOfByte3, "UTF-8");
      }
      if (arrayOfByte4 != null) {
        this.p = new String(arrayOfByte4, "UTF-8");
      }
      if (arrayOfByte5 != null) {
        this.q = new String(arrayOfByte5, "UTF-8");
      }
      if (arrayOfByte6 == null) {
        break label256;
      }
      this.r = new String(arrayOfByte6, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label215:
      int i1;
      break label215;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("UnsupportedEncodingException");
      ((StringBuilder)localObject2).append(arrayOfByte1.toString());
      QLog.e("Q.BabyQ", 2, ((StringBuilder)localObject2).toString());
    }
    label256:
    this.m = ((Intent)localObject1).getByteArrayExtra("rewardCookie");
    if (this.j == 1) {
      this.s = ((Intent)localObject1).getLongExtra("rewardFaceId", -1L);
    }
    this.t = ((Intent)localObject1).getIntExtra("rewardReportType", -1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initData type:");
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append(" name:");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(MessageRecordUtil.a(this.l));
      ((StringBuilder)localObject1).append(" cookie:");
      localObject2 = this.m;
      if (localObject2 != null) {
        i1 = localObject2.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(" jump:");
      ((StringBuilder)localObject1).append(MessageRecordUtil.a(this.n));
      ((StringBuilder)localObject1).append(" optWord:");
      ((StringBuilder)localObject1).append(this.o);
      ((StringBuilder)localObject1).append(" optUrl:");
      ((StringBuilder)localObject1).append(MessageRecordUtil.a(this.p));
      ((StringBuilder)localObject1).append(" toast:");
      ((StringBuilder)localObject1).append(this.q);
      ((StringBuilder)localObject1).append(" picUrl:");
      ((StringBuilder)localObject1).append(MessageRecordUtil.a(this.r));
      ((StringBuilder)localObject1).append(" faceId:");
      ((StringBuilder)localObject1).append(this.s);
      QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  void a()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
    int i1 = 0;
    if (!bool)
    {
      QQToast.makeText(this, 1, 2131892102, 0).show(getTitleBarHeight());
      return;
    }
    int i2 = this.j;
    if (i2 == 1)
    {
      if (this.s == -1L)
      {
        QLog.e("Q.BabyQ", 2, "receive error face id");
      }
      else
      {
        ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.s, -1, 1);
        ReportController.b(this.app, "dc00898", "", "", "0X800723D", "0X800723D", 0, 0, "", "", "", "");
        break label279;
      }
    }
    else if (i2 == 11)
    {
      b();
      BabyQHandler.a(this.app, this.t, 2);
    }
    else
    {
      if ((i2 == 12) || (i2 == 13)) {
        break label247;
      }
      if (i2 == 2)
      {
        d();
        ReportController.b(this.app, "dc00898", "", "", "0X800724B", "0X800724B", 0, 0, "", "", "", "");
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pickReward error type:");
        localStringBuilder.append(this.j);
        QLog.e("Q.BabyQ", 2, localStringBuilder.toString());
      }
    }
    i1 = 1;
    break label279;
    label247:
    ((BabyQHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b(this.m);
    BabyQHandler.a(this.app, this.t, 2);
    label279:
    if (i1 != 0) {
      finish();
    }
  }
  
  void a(View paramView, Animation.AnimationListener paramAnimationListener, float paramFloat, long paramLong, int paramInt)
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
  
  void b()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.l);
    localIntent.putExtra("leftViewText", super.getString(2131887440));
    super.startActivity(localIntent);
  }
  
  void c()
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
    this.i.startAnimation(localAnimationSet);
  }
  
  void d()
  {
    Object localObject1;
    if (ClubContentJsonTask.o != null) {
      localObject1 = ClubContentJsonTask.o.a;
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123", new Object[] { "0", "mvip.pingtai.mobileqq.androidziliaoka.fromqita" }));
      ((StringBuilder)localObject1).append("&adtag=");
      ((StringBuilder)localObject1).append("qita");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = new StringBuilder((String)localObject1);
      if (((String)localObject1).contains("?")) {
        ((StringBuilder)localObject2).append("&platform=1");
      } else {
        ((StringBuilder)localObject2).append("?platform=1");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&qq=");
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&adtag=");
      ((StringBuilder)localObject1).append("qita");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&aid=");
      ((StringBuilder)localObject1).append("mvip.pingtai.mobileqq.androidziliaoka.fromqita");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoQQVipWeb() url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    super.startActivity((Intent)localObject2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627765);
    e();
    this.b = ((RelativeLayout)super.findViewById(2131444757));
    this.a = ((RelativeLayout)super.findViewById(2131444758));
    this.c = ((ImageView)super.findViewById(2131446840));
    this.d = ((ImageView)super.findViewById(2131444752));
    this.e = ((TextView)super.findViewById(2131444754));
    this.g = ((TextView)super.findViewById(2131444756));
    this.f = ((ImageView)super.findViewById(2131430817));
    this.h = ((ImageView)super.findViewById(2131444753));
    this.i = super.findViewById(2131444179);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setText(this.k);
    if (!TextUtils.isEmpty(this.n)) {
      this.e.setText(this.n);
    }
    if (!TextUtils.isEmpty(this.r)) {
      try
      {
        paramBundle = URLDrawable.URLDrawableOptions.obtain();
        paramBundle.mRequestWidth = DisplayUtil.a(this, 75.0F);
        paramBundle.mRequestHeight = DisplayUtil.a(this, 65.0F);
        paramBundle = URLDrawable.getDrawable(this.r, paramBundle);
        this.h.setImageDrawable(paramBundle);
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("load pic error");
          localStringBuilder.append(paramBundle.toString());
          QLog.w("Q.BabyQ", 2, localStringBuilder.toString());
        }
      }
    }
    this.x = new CustomHandler(Looper.getMainLooper(), this.u);
    this.x.sendEmptyMessageDelayed(1, 200L);
    super.addObserver(this.v);
    super.addObserver(this.w);
    if (this.j == 2)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X800724A", "0X800724A", 0, 0, "", "", "", "");
      return true;
    }
    BabyQHandler.a(this.app, this.t, 1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.v);
    super.removeObserver(this.w);
    this.x.removeCallbacksAndMessages(null);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430817)
    {
      if (i1 == 2131444754) {
        a();
      }
    }
    else {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity
 * JD-Core Version:    0.7.0.1
 */