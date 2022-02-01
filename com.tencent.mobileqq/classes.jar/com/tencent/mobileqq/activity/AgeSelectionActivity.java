package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  BirthdayPickHelper a;
  int b;
  int c;
  int d;
  int e;
  private Calendar f;
  private int g;
  private int h;
  private int i;
  private int j;
  private String k;
  private TextView l;
  private TextView m;
  private ActionSheet n;
  @Nullable
  private String o;
  
  public static int a(String paramString)
  {
    return Arrays.asList(NearbyProfileUtil.d).indexOf(paramString);
  }
  
  private void a()
  {
    a(this.c, this.d, this.e);
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.j);
    localIntent.putExtra("param_constellation_id", a(this.k));
    localIntent.putExtra("param_constellation", this.k);
    localIntent.putExtra("param_year", (short)this.c);
    localIntent.putExtra("param_month", (byte)this.d);
    localIntent.putExtra("param_day", (byte)this.e);
    setResult(-1, localIntent);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = (this.g - paramInt1);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.h, this.i);
    if (((Calendar)localObject1).after(localObject2)) {
      this.j -= 1;
    }
    if (this.j < 0) {
      this.j = 0;
    }
    localObject1 = this.l;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.j);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898283));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.k = Utils.b(paramInt2, paramInt3);
    this.m.setText(this.k);
  }
  
  private void b()
  {
    if (this.n == null)
    {
      this.a = new BirthdayPickHelper(getBaseContext(), this.b, false);
      this.n = ActionSheet.createMenuSheet(this);
      this.n.setCloseAutoRead(true);
      this.n.setActionContentView(this.a.a(), null);
      Object localObject = (DispatchActionMoveScrollView)this.n.findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.n.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.a.a(new AgeSelectionActivity.2(this));
    }
    if (!this.n.isShowing()) {}
    try
    {
      this.n.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean c()
  {
    return ("VAL_FROM_STATUS_MSG_TAB".equals(this.o)) || ("VAL_FROM_STATUS_SETTING".equals(this.o));
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
    super.doOnCreate(paramBundle);
    super.setContentView(2131627261);
    this.o = getIntent().getStringExtra("param_launch_from");
    this.l = ((TextView)findViewById(2131427893));
    this.m = ((TextView)findViewById(2131431246));
    findViewById(2131427897).setOnClickListener(this);
    findViewById(2131431249).setOnClickListener(this);
    setTitle(HardCodeUtil.a(2131898280));
    setLeftViewName(2131887440);
    if (c()) {
      setRightButton(2131889474, new AgeSelectionActivity.1(this));
    }
    this.f = Calendar.getInstance();
    this.f.setTimeInMillis(System.currentTimeMillis());
    this.g = this.f.get(1);
    this.h = (this.f.get(2) + 1);
    this.i = this.f.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date : %s-%s-%s ", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i) }));
    }
    this.b = getIntent().getIntExtra("param_birthday", 0);
    this.c = 2000;
    this.d = 1;
    this.e = 1;
    int i1 = this.b;
    if (i1 > 0)
    {
      this.c = ((0xFFFF0000 & i1) >>> 16);
      this.d = ((0xFF00 & i1) >>> 8);
      this.e = (i1 & 0xFF);
    }
    a(this.c, this.d, this.e);
    b();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (!c()) {
      a();
    } else if ("VAL_FROM_STATUS_MSG_TAB".equals(this.o)) {
      ReportHelperKt.a("0X800AF46");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 2131427897) || (i1 == 2131431249)) {
      b();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */