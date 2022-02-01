package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QavBeautyMenuPanel
  extends QavMenuBaseView
{
  static final int[] a = { 2131441228, 2131441229 };
  final View b;
  final SimpleSlidingIndicator c;
  final PanelViewPage d;
  final QavBeautyMenuPanel.MyPagerAdapter e;
  boolean f = false;
  long j = 0L;
  boolean k = false;
  
  public QavBeautyMenuPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("QavBeautyMenuPanel");
    paramAttributeSet.append(AudioHelper.c());
    this.g = paramAttributeSet.toString();
    inflate(paramContext, 2131625777, this);
    Object localObject = paramContext.getResources();
    this.b = findViewById(2131446755);
    this.c = ((SimpleSlidingIndicator)this.b.findViewById(2131446094));
    paramAttributeSet = ((Resources)localObject).getDisplayMetrics();
    int n = Math.min(paramAttributeSet.widthPixels, paramAttributeSet.heightPixels);
    paramInt = ((Resources)localObject).getDimensionPixelSize(2131298326);
    int i = ((Resources)localObject).getDimensionPixelSize(2131298323);
    int m = paramInt * 2;
    int i1 = n - i - m;
    if (i1 > 20)
    {
      m = i1 / 2;
    }
    else
    {
      float f1 = m + i;
      f1 = (n - 20) / f1;
      i = (int)(i * f1);
      paramInt = (int)(paramInt * f1);
      m = (n - i - paramInt * 2) / 2;
    }
    this.c.a(paramInt, i, 0, m);
    if (QLog.isDevelopLevel()) {
      QLog.i(this.g, 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(m) }));
    }
    paramAttributeSet = ((Resources)localObject).getString(2131893149);
    localObject = ((Resources)localObject).getString(2131893150);
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.c;
    int[] arrayOfInt = a;
    localSimpleSlidingIndicator.setTabData(new String[] { paramAttributeSet, localObject }, arrayOfInt);
    this.c.setCurrentPosition(0, false);
    this.c.setOnTabListener(new QavBeautyMenuPanel.1(this));
    this.d = ((PanelViewPage)findViewById(2131439808));
    paramAttributeSet = new ArrayList(2);
    paramAttributeSet.add(new BeautyView(paramContext));
    paramAttributeSet.add(new MakeupView(paramContext));
    this.e = new QavBeautyMenuPanel.MyPagerAdapter(this, paramAttributeSet);
    this.d.setAdapter(this.e);
    this.d.setIsPagingEnabled(false);
    this.d.setCurrentItem(0, false);
    setBackgroundResource(2130843186);
  }
  
  private RedDotTextView a(int paramInt)
  {
    Object localObject = this.c.findViewById(a[paramInt]);
    if ((localObject instanceof RedTouch))
    {
      localObject = (RedTouch)localObject;
      paramInt = 0;
      while (paramInt < ((RedTouch)localObject).getChildCount())
      {
        if ((((RedTouch)localObject).getChildAt(paramInt) instanceof RedDotTextView)) {
          return (RedDotTextView)((RedTouch)localObject).getChildAt(paramInt);
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if ((!this.k) && (paramInt == 1))
    {
      this.k = true;
      AVUtil.a("0X800AA61", 0);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean)
    {
      int m = this.e.getCount();
      int i = 0;
      while (i < m)
      {
        localObject = this.e.a(i);
        if (localObject != null) {
          ((BeautyBaseView)localObject).a(paramLong, paramBoolean);
        }
        i += 1;
      }
      Object localObject = AVRedTouchUtil.a(this.h, 8);
      if (AVRedTouchUtil.a((BusinessInfoCheckUpdate.AppInfo)localObject))
      {
        RedDotTextView localRedDotTextView = a(1);
        if (localRedDotTextView != null) {
          localRedDotTextView.a(true);
        } else {
          this.c.a(a[1], (BusinessInfoCheckUpdate.AppInfo)localObject);
        }
        localObject = AVRedTouchUtil.a(8);
        this.h.l((String)localObject);
        this.f = true;
      }
      else
      {
        this.f = false;
      }
      b(this.c.getCurrentPosition());
    }
    b();
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    int m = this.e.getCount();
    int i = 0;
    while (i < m)
    {
      paramQavPanel = this.e.a(i);
      if (paramQavPanel != null) {
        paramQavPanel.setAppInterface(this.h);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    int i = this.d.getCurrentItem();
    BeautyBaseView localBeautyBaseView = this.e.a(i);
    if (localBeautyBaseView != null) {
      localBeautyBaseView.a();
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    int m = this.e.getCount();
    int i = 0;
    while (i < m)
    {
      BeautyBaseView localBeautyBaseView = this.e.a(i);
      if (localBeautyBaseView != null) {
        localBeautyBaseView.b(paramLong, paramBoolean);
      }
      i += 1;
    }
    this.k = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.j) > 200L))
    {
      this.j = l;
      BaseToolbar.keepInToolbar(this.h, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setCurSelTab(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 > 1) {
        return;
      }
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurSelTab, [(");
        localStringBuilder.append(this.d.getCurrentItem());
        localStringBuilder.append(",");
        localStringBuilder.append(this.c.getCurrentPosition());
        localStringBuilder.append(") ---> ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], anim[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], width[");
        localStringBuilder.append(this.d.getMeasuredWidth());
        localStringBuilder.append("], width[");
        localStringBuilder.append(this.d.getWidth());
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 4, localStringBuilder.toString());
      }
      if ((paramInt2 != 1) && (paramInt1 != this.c.getCurrentPosition())) {
        this.c.setCurrentPosition(paramInt1, paramBoolean);
      }
      if ((paramInt2 != 2) && (paramInt1 != this.d.getCurrentItem())) {
        this.d.setCurrentItem(paramInt1, paramBoolean);
      }
      if ((paramBoolean) && (paramInt1 == 1) && (this.f))
      {
        localObject = a(1);
        if (localObject != null) {
          ((RedDotTextView)localObject).a(false);
        } else {
          this.c.a(a[paramInt1]);
        }
        localObject = AVRedTouchUtil.a(8);
        this.h.k((String)localObject);
        this.f = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */