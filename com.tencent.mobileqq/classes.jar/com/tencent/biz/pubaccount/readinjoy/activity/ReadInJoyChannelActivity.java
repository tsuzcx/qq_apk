package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import amtj;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import odq;
import ofe;
import oiy;
import oiz;
import olh;
import oli;
import olj;
import olk;
import pay;
import pbo;
import pil;
import pkm;
import pks;
import pkx;
import plv;
import rse;
import rsf;
import rwv;
import sdc;
import sdy;
import sek;
import snw;
import syp;
import yqu;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  public oiy a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  
  private void a(int paramInt)
  {
    runOnUiThread(new ReadInJoyChannelActivity.8(this, paramInt));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    paramViewGroup.setOnClickListener(new olj(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Oiy != null) && (this.jdField_a_of_type_Oiy.a() != null) && ((this.jdField_a_of_type_Oiy instanceof oiz)) && (((oiz)this.jdField_a_of_type_Oiy).a() != null) && (((oiz)this.jdField_a_of_type_Oiy).a().size() > 0)) {
      pay.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Oiy.a().a(), (BaseArticleInfo)((oiz)this.jdField_a_of_type_Oiy).a().get(0), paramBoolean);
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private void b(int paramInt)
  {
    VideoReport.addToDetectionWhitelist(this);
    VideoReport.setPageId(this, "118");
    VideoReport.setPageParams(this, new pil().a(Integer.valueOf(paramInt)).a());
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (bkwm.F(pay.a()))) {
      c(paramViewGroup);
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40677) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (!getIntent().getBooleanExtra("is_daily_dynamic_child_channel", false)) {
          return;
        }
        HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("channel_map_data");
        if (localHashMap != null)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localHashMap.get("channelName"));
          this.jdField_b_of_type_Boolean = "1".equals(localHashMap.get("canDownRefresh"));
          bool2 = "1".equals(localHashMap.get("canUpRefresh"));
          bool1 = "1".equals(localHashMap.get("isImmersive"));
          bkwm.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_Oiy != null)
          {
            ((oiz)this.jdField_a_of_type_Oiy).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((oiz)this.jdField_a_of_type_Oiy).i();
          }
          QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh=", Boolean.valueOf(this.jdField_b_of_type_Boolean), " mCanPullUpRefresh=", Boolean.valueOf(bool2), " mChannelName=", this.jdField_a_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh error, e=", localException.toString() });
        return;
      }
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131560375, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      odq.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", ofe.c(), false);
      localViewGroup.setOnClickListener(new olk(this));
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40830) {
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131375979);
    this.jdField_a_of_type_Oiy = new oiz(this);
    ((oiz)this.jdField_a_of_type_Oiy).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_Oiy.a(localViewGroup);
    this.jdField_a_of_type_Oiy.a();
    if ((b()) && ((this.jdField_a_of_type_Oiy instanceof oiz))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Oiy);
    }
    if ((ThemeUtil.isInNightMode(pay.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131560245, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131373655);
    if (yqu.a(this))
    {
      paramViewGroup.setText(amtj.a(2131711982));
      return;
    }
    paramViewGroup.setText(amtj.a(2131711980));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = pbo.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Oiy.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131378819));
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label276;
      }
      if ((SystemUtil.isMIUI()) || (SystemUtil.isFlyme())) {
        break label255;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849445);
      if ((this.leftView != null) && (c())) {
        this.leftView.setText(amtj.a(2131711891));
      }
      this.vg.setBackgroundColor(-1);
      a(this.vg);
      if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.jdField_a_of_type_Boolean))
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        this.vg.startAnimation(localAlphaAnimation);
      }
      return;
      label255:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label276:
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.isFlyme())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void b()
  {
    if (this.leftView != null) {
      ThreadManager.post(new ReadInJoyChannelActivity.7(this), 5, null, true);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Oiy != null) {
      this.jdField_a_of_type_Oiy.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    sek.a().a(this);
    this.jdField_a_of_type_Boolean = rwv.c();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755152);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131560194);
    int i = getIntent().getIntExtra("channel_id", -1);
    syp.b(i);
    paramBundle = (pks)this.app.getManager(163);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new olh(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      pbo.a(getIntent().getIntExtra("channel_from", 9), pbo.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.getMessageFacade() != null) && (!c())) {
        this.app.getMessageFacade().addObserver(this);
      }
      pkx.b();
      pkx.c();
      rse.a.a();
    }
    c();
    b(i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((pks)pay.a().getManager(163)).a().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Oiy != null) {
      this.jdField_a_of_type_Oiy.d();
    }
    sek.a().b(this);
    snw.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      pbo.a(getIntent().getIntExtra("channel_from", 9), pbo.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pbo.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
      this.jdField_b_of_type_Long = -1L;
      if ((this.app != null) && (this.app.getMessageFacade() != null)) {
        this.app.getMessageFacade().deleteObserver(this);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Oiy.g();
    snw.a(this).a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Oiy.h();
    snw.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((bkwm.i()) && (a())) {
      pkm.a().a(56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bkwm.a(getAppRuntime());
    this.jdField_a_of_type_Oiy.e();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new oli(this));
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    sek.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_Oiy.f();
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Oiy.a();
    if ((localObject != null) && (((sdc)localObject).a() != null))
    {
      localObject = ((sdc)localObject).a();
      if (((sdy)localObject).a())
      {
        ((sdy)localObject).j();
        return true;
      }
    }
    a(false);
    finish();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (b())
    {
      this.rightViewImg.setImageResource(2130842902);
      this.rightViewImg.setVisibility(0);
      localObject = this.rightViewImg;
    }
    return localObject;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (!plv.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */