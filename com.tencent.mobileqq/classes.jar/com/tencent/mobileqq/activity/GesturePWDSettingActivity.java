package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  private FormSwitchItem a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private int h = 0;
  private int i = 0;
  private boolean j = false;
  private View.OnClickListener k = new GesturePWDSettingActivity.2(this);
  
  private void b()
  {
    setTitle(2131890014);
    this.c = findViewById(2131434186);
    this.d = findViewById(2131434183);
    this.e = findViewById(2131434200);
    this.f = findViewById(2131434188);
    this.g = findViewById(2131434184);
    this.b = findViewById(2131434187);
    this.b.setContentDescription(HardCodeUtil.a(2131903233));
    this.c.setOnClickListener(this.k);
    this.d.setOnClickListener(this.k);
    this.e.setOnClickListener(this.k);
    this.b.setOnClickListener(this.k);
    this.a = ((FormSwitchItem)findViewById(2131434201));
    this.a.setOnCheckedChangeListener(new GesturePWDSettingActivity.1(this));
  }
  
  private void c()
  {
    this.j = getIntent().getBooleanExtra("key_reset", false);
    this.h = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    int m = this.h;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          return;
        }
        this.a.setChecked(true);
        a(true);
        a();
        return;
      }
      this.a.setChecked(false);
      a(false);
      return;
    }
    if (this.j)
    {
      if ((this.leftView != null) && ((this.leftView instanceof TextView))) {
        this.leftView.setText(2131916159);
      }
      startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
      overridePendingTransition(2130772014, 2130772007);
      return;
    }
    startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
  }
  
  private void d()
  {
    this.h = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    int m = this.h;
    if ((m != 0) && (m != 1))
    {
      if (m != 2) {
        return;
      }
      a(true);
      this.a.setChecked(true);
      return;
    }
    a(false);
    this.a.setChecked(false);
  }
  
  void a()
  {
    this.i = GesturePWDUtils.getGesturePWDMode(this, this.app.getCurrentAccountUin());
    if (this.i == 21)
    {
      this.f.setVisibility(4);
      this.g.setVisibility(0);
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    this.e.setVisibility(4);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10) {
      if (paramInt2 == -1)
      {
        d();
        a();
      }
      else
      {
        finish();
        return;
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131624961);
    b();
    c();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.j)
    {
      Intent localIntent = new Intent(getActivity(), PermissionPrivacyFragment.class);
      localIntent.putExtra("key_reset", this.j);
      startActivity(localIntent);
      finish();
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected String setLastActivityName()
  {
    if (this.h == 0) {
      return getString(2131897233);
    }
    return getString(2131890014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */