package com.tencent.biz.pubaccount.readinjoy.activity;

import ajya;
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
import bbbm;
import bhvy;
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
import nol;
import npu;
import ntd;
import nte;
import nvo;
import nvp;
import nvq;
import nvr;
import nvs;
import onh;
import oob;
import osg;
import osj;
import osl;
import osq;
import otm;
import qoi;
import qtr;
import qva;
import qvk;
import rez;
import rpi;
import vzw;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  public ntd a;
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
    paramViewGroup.setOnClickListener(new nvr(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Ntd != null) && (this.jdField_a_of_type_Ntd.a() != null) && ((this.jdField_a_of_type_Ntd instanceof nte)) && (((nte)this.jdField_a_of_type_Ntd).a() != null) && (((nte)this.jdField_a_of_type_Ntd).a().size() > 0)) {
      onh.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Ntd.a().a(), (BaseArticleInfo)((nte)this.jdField_a_of_type_Ntd).a().get(0), paramBoolean);
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
    osj.a().a(new nvp(this, paramInt));
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (bhvy.D(onh.a()))) {
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
          bhvy.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_Ntd != null)
          {
            ((nte)this.jdField_a_of_type_Ntd).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((nte)this.jdField_a_of_type_Ntd).i();
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
      nol.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", npu.c(), false);
      localViewGroup.setOnClickListener(new nvs(this));
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131374833);
    this.jdField_a_of_type_Ntd = new nte(this);
    ((nte)this.jdField_a_of_type_Ntd).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_Ntd.a(localViewGroup);
    this.jdField_a_of_type_Ntd.a();
    if ((b()) && ((this.jdField_a_of_type_Ntd instanceof nte))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Ntd);
    }
    if ((ThemeUtil.isInNightMode(onh.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131559985, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131372607);
    if (vzw.a(this))
    {
      paramViewGroup.setText(ajya.a(2131712878));
      return;
    }
    paramViewGroup.setText(ajya.a(2131712876));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = oob.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ntd.a(true);
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
      if ((bbbm.b()) || (bbbm.d())) {
        break label255;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848498);
      if ((this.leftView != null) && (c())) {
        this.leftView.setText(ajya.a(2131712787));
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bbbm.d())
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
    if (this.jdField_a_of_type_Ntd != null) {
      this.jdField_a_of_type_Ntd.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    qvk.a().a(this);
    this.jdField_a_of_type_Boolean = qoi.b();
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
    rpi.b(getIntent().getIntExtra("channel_id", -1));
    paramBundle = (osl)this.app.getManager(163);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new nvo(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      oob.a(getIntent().getIntExtra("channel_from", 9), oob.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.a() != null) && (!c())) {
        this.app.a().addObserver(this);
      }
      osq.b();
      osq.c();
    }
    c();
    b(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((osl)onh.a().getManager(163)).a().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Ntd != null) {
      this.jdField_a_of_type_Ntd.d();
    }
    qvk.a().b(this);
    rez.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      oob.a(getIntent().getIntExtra("channel_from", 9), oob.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
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
    this.jdField_a_of_type_Ntd.g();
    rez.a(this).a();
    b(3);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Ntd.h();
    rez.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((bhvy.i()) && (a())) {
      osg.a().a(56);
    }
    b(2);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bhvy.a(getAppRuntime());
    this.jdField_a_of_type_Ntd.e();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new nvq(this));
    }
    b(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    qvk.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_Ntd.f();
    b(4);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Ntd.a();
    if ((localObject != null) && (((qtr)localObject).a() != null))
    {
      localObject = ((qtr)localObject).a();
      if (((qva)localObject).a())
      {
        ((qva)localObject).g();
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
      this.rightViewImg.setImageResource(2130842326);
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
      if ((!paramObservable.isSendFromLocal()) && (!otm.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */