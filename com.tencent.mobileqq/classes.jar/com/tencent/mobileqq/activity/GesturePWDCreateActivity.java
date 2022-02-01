package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class GesturePWDCreateActivity
  extends IphoneTitleBarActivity
{
  TextView a;
  LockPatternView b;
  Handler c = new Handler();
  int[] d = new int[9];
  int e = 0;
  String f = "";
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private View o;
  
  private void a()
  {
    this.e = 0;
    c();
  }
  
  private void b()
  {
    setTitle(2131890004);
    setLeftButton(2131887648, new GesturePWDCreateActivity.1(this));
    this.a = ((TextView)findViewById(2131434178));
    this.b = ((LockPatternView)findViewById(2131434177));
    this.b.setFillInGapCell(false);
    this.b.setTactileFeedbackEnabled(true);
    this.b.setOnPatternListener(new GesturePWDCreateActivity.2(this));
    if (this.mDensity <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      localLayoutParams.height = ((int)(this.mDensity * 240.0F));
      localLayoutParams.width = ((int)(this.mDensity * 240.0F));
      this.b.setLayoutParams(localLayoutParams);
    }
    this.g = findViewById(2131434191);
    this.h = findViewById(2131434192);
    this.i = findViewById(2131434193);
    this.j = findViewById(2131434194);
    this.k = findViewById(2131434195);
    this.l = findViewById(2131434196);
    this.m = findViewById(2131434197);
    this.n = findViewById(2131434198);
    this.o = findViewById(2131434199);
  }
  
  private void c()
  {
    if (this.d == null) {
      this.d = new int[9];
    }
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = this.d;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i1] = 0;
      i1 += 1;
    }
  }
  
  private void d()
  {
    int[] arrayOfInt = this.d;
    if ((arrayOfInt != null) && (arrayOfInt.length == 9))
    {
      if (arrayOfInt[0] == 1) {
        this.g.setBackgroundResource(2130846705);
      } else {
        this.g.setBackgroundResource(2130846704);
      }
      if (this.d[1] == 1) {
        this.h.setBackgroundResource(2130846705);
      } else {
        this.h.setBackgroundResource(2130846704);
      }
      if (this.d[2] == 1) {
        this.i.setBackgroundResource(2130846705);
      } else {
        this.i.setBackgroundResource(2130846704);
      }
      if (this.d[3] == 1) {
        this.j.setBackgroundResource(2130846705);
      } else {
        this.j.setBackgroundResource(2130846704);
      }
      if (this.d[4] == 1) {
        this.k.setBackgroundResource(2130846705);
      } else {
        this.k.setBackgroundResource(2130846704);
      }
      if (this.d[5] == 1) {
        this.l.setBackgroundResource(2130846705);
      } else {
        this.l.setBackgroundResource(2130846704);
      }
      if (this.d[6] == 1) {
        this.m.setBackgroundResource(2130846705);
      } else {
        this.m.setBackgroundResource(2130846704);
      }
      if (this.d[7] == 1) {
        this.n.setBackgroundResource(2130846705);
      } else {
        this.n.setBackgroundResource(2130846704);
      }
      if (this.d[8] == 1)
      {
        this.o.setBackgroundResource(2130846705);
        return;
      }
      this.o.setBackgroundResource(2130846704);
    }
  }
  
  void a(List<LockPatternView.Cell> paramList)
  {
    c();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (LockPatternView.Cell)paramList.next();
        if (localObject != null)
        {
          int i1 = ((LockPatternView.Cell)localObject).a() * 3 + ((LockPatternView.Cell)localObject).b();
          if (i1 >= 0)
          {
            localObject = this.d;
            if (i1 < localObject.length) {
              localObject[i1] = 1;
            }
          }
        }
      }
    }
    d();
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
    super.setContentView(2131624957);
    a();
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772007, 2130772018);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */