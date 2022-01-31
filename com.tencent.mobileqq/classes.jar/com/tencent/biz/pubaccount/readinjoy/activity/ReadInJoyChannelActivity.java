package com.tencent.biz.pubaccount.readinjoy.activity;

import ajjy;
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
import azzu;
import bgmq;
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
import ndn;
import new;
import nhw;
import nhx;
import nkg;
import nkh;
import nki;
import nkj;
import nkk;
import obz;
import oct;
import ogy;
import ohb;
import ohd;
import ohi;
import oie;
import qcn;
import qhp;
import qiy;
import qji;
import qsq;
import rcx;
import vnd;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  public nhw a;
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
    paramViewGroup.setOnClickListener(new nkj(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Nhw != null) && (this.jdField_a_of_type_Nhw.a() != null) && ((this.jdField_a_of_type_Nhw instanceof nhx)) && (((nhx)this.jdField_a_of_type_Nhw).a() != null) && (((nhx)this.jdField_a_of_type_Nhw).a().size() > 0)) {
      obz.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_Nhw.a().a(), (BaseArticleInfo)((nhx)this.jdField_a_of_type_Nhw).a().get(0), paramBoolean);
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
    ohb.a().a(new nkh(this, paramInt));
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (bgmq.C(obz.a()))) {
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
          bgmq.c(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_Nhw != null)
          {
            ((nhx)this.jdField_a_of_type_Nhw).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((nhx)this.jdField_a_of_type_Nhw).i();
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
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131494529, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      ndn.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", new.c(), false);
      localViewGroup.setOnClickListener(new nkk(this));
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131309089);
    this.jdField_a_of_type_Nhw = new nhx(this);
    ((nhx)this.jdField_a_of_type_Nhw).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_Nhw.a(localViewGroup);
    this.jdField_a_of_type_Nhw.a();
    if ((b()) && ((this.jdField_a_of_type_Nhw instanceof nhx))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Nhw);
    }
    if ((ThemeUtil.isInNightMode(obz.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131494415, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131306893);
    if (vnd.a(this))
    {
      paramViewGroup.setText(ajjy.a(2131647079));
      return;
    }
    paramViewGroup.setText(ajjy.a(2131647077));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = oct.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Nhw.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131311638));
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
      if ((azzu.b()) || (azzu.d())) {
        break label255;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848260);
      if ((this.leftView != null) && (c())) {
        this.leftView.setText(ajjy.a(2131646988));
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
      if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!azzu.d())
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
    if (this.jdField_a_of_type_Nhw != null) {
      this.jdField_a_of_type_Nhw.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    qji.a().a(this);
    this.jdField_a_of_type_Boolean = qcn.a();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131689610);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131494361);
    rcx.b(getIntent().getIntExtra("channel_id", -1));
    paramBundle = (ohd)this.app.getManager(163);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new nkg(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      oct.a(getIntent().getIntExtra("channel_from", 9), oct.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.a() != null) && (!c())) {
        this.app.a().addObserver(this);
      }
      ohi.b();
      ohi.c();
    }
    c();
    b(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((ohd)obz.a().getManager(163)).a().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Nhw != null) {
      this.jdField_a_of_type_Nhw.d();
    }
    qji.a().b(this);
    qsq.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      oct.a(getIntent().getIntExtra("channel_from", 9), oct.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oct.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
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
    this.jdField_a_of_type_Nhw.g();
    qsq.a(this).a();
    b(3);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Nhw.h();
    qsq.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((bgmq.i()) && (a())) {
      ogy.a().a(56);
    }
    b(2);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bgmq.a(getAppRuntime());
    this.jdField_a_of_type_Nhw.e();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new nki(this));
    }
    b(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    qji.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_Nhw.f();
    b(4);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Nhw.a();
    if ((localObject != null) && (((qhp)localObject).a() != null))
    {
      localObject = ((qhp)localObject).a();
      if (((qiy)localObject).a())
      {
        ((qiy)localObject).g();
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
      this.rightViewImg.setImageResource(2130842241);
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
      if ((!paramObservable.isSendFromLocal()) && (!oie.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */