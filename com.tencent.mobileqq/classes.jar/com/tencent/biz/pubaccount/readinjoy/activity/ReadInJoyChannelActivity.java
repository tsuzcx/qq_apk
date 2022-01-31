package com.tencent.biz.pubaccount.readinjoy.activity;

import ajyc;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbay;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import noo;
import npx;
import ntg;
import nth;
import nvr;
import nvs;
import nvt;
import nvu;
import nvv;
import onk;
import ooe;
import osj;
import osm;
import oso;
import ost;
import otp;
import qol;
import qtu;
import qvd;
import qvn;
import rfc;
import rpl;
import vzz;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  public ntg a;
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
    paramViewGroup.setOnClickListener(new nvu(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Ntg != null) && (this.jdField_a_of_type_Ntg.a() != null) && ((this.jdField_a_of_type_Ntg instanceof nth)) && (((nth)this.jdField_a_of_type_Ntg).a() != null) && (((nth)this.jdField_a_of_type_Ntg).a().size() > 0)) {
      onk.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Ntg.a().a(), (BaseArticleInfo)((nth)this.jdField_a_of_type_Ntg).a().get(0), paramBoolean);
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
    osm.a().a(new nvs(this, paramInt));
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (bhvh.D(onk.a()))) {
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
          bhvh.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_Ntg != null)
          {
            ((nth)this.jdField_a_of_type_Ntg).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((nth)this.jdField_a_of_type_Ntg).i();
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
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131560101, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      noo.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", npx.c(), false);
      localViewGroup.setOnClickListener(new nvv(this));
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131374831);
    this.jdField_a_of_type_Ntg = new nth(this);
    ((nth)this.jdField_a_of_type_Ntg).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_Ntg.a(localViewGroup);
    this.jdField_a_of_type_Ntg.a();
    if ((b()) && ((this.jdField_a_of_type_Ntg instanceof nth))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Ntg);
    }
    if ((ThemeUtil.isInNightMode(onk.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131559985, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131372605);
    if (vzz.a(this))
    {
      paramViewGroup.setText(ajyc.a(2131712867));
      return;
    }
    paramViewGroup.setText(ajyc.a(2131712865));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = ooe.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ntg.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131377452));
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
      if ((bbay.b()) || (bbay.d())) {
        break label255;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848492);
      if ((this.leftView != null) && (c())) {
        this.leftView.setText(ajyc.a(2131712776));
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bbay.b()) && (!bbay.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bbay.d())
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ntg != null) {
      this.jdField_a_of_type_Ntg.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    qvn.a().a(this);
    this.jdField_a_of_type_Boolean = qol.b();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755146);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131559931);
    rpl.b(getIntent().getIntExtra("channel_id", -1));
    paramBundle = (oso)this.app.getManager(163);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new nvr(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      ooe.a(getIntent().getIntExtra("channel_from", 9), ooe.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.a() != null) && (!c())) {
        this.app.a().addObserver(this);
      }
      ost.b();
      ost.c();
    }
    c();
    b(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((oso)onk.a().getManager(163)).a().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Ntg != null) {
      this.jdField_a_of_type_Ntg.d();
    }
    qvn.a().b(this);
    rfc.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      ooe.a(getIntent().getIntExtra("channel_from", 9), ooe.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), ooe.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
      this.jdField_b_of_type_Long = -1L;
      if ((this.app != null) && (this.app.a() != null)) {
        this.app.a().deleteObserver(this);
      }
    }
    b(5);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Ntg.g();
    rfc.a(this).a();
    b(3);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Ntg.h();
    rfc.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((bhvh.i()) && (a())) {
      osj.a().a(56);
    }
    b(2);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bhvh.a(getAppRuntime());
    this.jdField_a_of_type_Ntg.e();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new nvt(this));
    }
    b(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    qvn.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_Ntg.f();
    b(4);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Ntg.a();
    if ((localObject != null) && (((qtu)localObject).a() != null))
    {
      localObject = ((qtu)localObject).a();
      if (((qvd)localObject).a())
      {
        ((qvd)localObject).g();
        return true;
      }
    }
    a(false);
    finish();
    return true;
  }
  
  public View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (b())
    {
      this.rightViewImg.setImageResource(2130842325);
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
      if ((!paramObservable.isSendFromLocal()) && (!otp.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */