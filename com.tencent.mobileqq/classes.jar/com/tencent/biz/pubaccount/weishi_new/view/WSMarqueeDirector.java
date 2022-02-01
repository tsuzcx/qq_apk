package com.tencent.biz.pubaccount.weishi_new.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

@SuppressLint({"ClickableViewAccessibility"})
public class WSMarqueeDirector
  extends WSViewDirector
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private static int b = ScreenUtil.dip2px(60.0F);
  private Context c;
  private final HorizontalScrollView d;
  private final LinearLayout e;
  private final TextView f;
  private final TextView g;
  private final TextView h;
  private final TextView i;
  private final WSMarqueeDirector.MarqueeAnimAdapter j = new WSMarqueeDirector.MarqueeAnimAdapter(this, null);
  private WSMarqueeDirector.OnTextContentListener k;
  private ValueAnimator l;
  private int m;
  private boolean n = false;
  private boolean o = false;
  
  public WSMarqueeDirector(View paramView)
  {
    super(paramView);
    this.c = paramView.getContext();
    this.d = ((HorizontalScrollView)a(2131435197));
    this.e = ((LinearLayout)a(2131437494));
    this.f = ((TextView)a(2131437970));
    this.g = ((TextView)a(2131437971));
    this.h = ((TextView)a(2131437972));
    this.i = ((TextView)a(2131437973));
    this.d.setOnTouchListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.n = false;
    if (Build.VERSION.SDK_INT > 15) {
      this.e.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }
  
  public void a()
  {
    this.f.setText("");
    this.h.setText("");
    this.f.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    this.f.setVisibility(0);
    this.h.setVisibility(8);
    Drawable localDrawable = g().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.f.setCompoundDrawables(localDrawable, null, null, null);
    this.f.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.f.setText(paramString);
    this.f.setTag(paramObject);
    this.h.setCompoundDrawables(localDrawable, null, null, null);
    this.h.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.h.setText(paramString);
    this.h.setTag(paramObject);
  }
  
  public void a(WSMarqueeDirector.OnTextContentListener paramOnTextContentListener)
  {
    this.k = paramOnTextContentListener;
  }
  
  public void b()
  {
    this.g.setText("");
    this.i.setText("");
    this.g.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  public void b(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return;
    }
    this.g.setVisibility(0);
    this.i.setVisibility(8);
    Drawable localDrawable = g().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.g.setCompoundDrawables(localDrawable, null, null, null);
    this.g.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.g.setText(paramString);
    this.g.setTag(paramObject);
    this.i.setCompoundDrawables(localDrawable, null, null, null);
    this.i.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.i.setText(paramString);
    this.i.setTag(paramObject);
  }
  
  public void c()
  {
    f();
    if (!this.n)
    {
      this.o = true;
      return;
    }
    this.o = false;
    int i1 = this.d.getWidth();
    this.m = 0;
    if (!TextUtils.isEmpty(this.f.getText())) {
      this.m += this.f.getWidth();
    }
    if (!TextUtils.isEmpty(this.g.getText())) {
      this.m += this.g.getWidth();
    }
    if (this.m - i1 < 1)
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startAnim:  A text:");
    localStringBuilder.append(this.f.getText());
    localStringBuilder.append(",B text:");
    localStringBuilder.append(this.g.getText());
    localStringBuilder.append(" , A width:");
    localStringBuilder.append(this.f.getWidth());
    localStringBuilder.append(" , B width:");
    localStringBuilder.append(this.g.getWidth());
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.m);
    WSLog.a("WSMarqueeDirector", localStringBuilder.toString());
    if (this.n)
    {
      if (this.f.isShown()) {
        this.h.setVisibility(0);
      } else {
        this.h.setVisibility(8);
      }
      if (this.g.isShown()) {
        this.i.setVisibility(0);
      } else {
        this.i.setVisibility(8);
      }
      i1 = this.m * 2;
      this.l = ValueAnimator.ofInt(new int[] { 0, i1 });
      this.l.setDuration(i1 * 1000 / b + 1);
      this.l.addListener(this.j);
      this.l.addUpdateListener(this.j);
      this.l.setRepeatCount(-1);
      this.l.setInterpolator(new LinearInterpolator());
      this.l.start();
    }
  }
  
  public void d()
  {
    if (this.l == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.l.pause();
      return;
    }
    f();
  }
  
  public void e()
  {
    if (this.l == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.l.resume();
      return;
    }
    c();
  }
  
  public void f()
  {
    ValueAnimator localValueAnimator = this.l;
    if (localValueAnimator == null) {
      return;
    }
    localValueAnimator.cancel();
    this.l = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131437971: 
    case 2131437973: 
      localOnTextContentListener = this.k;
      if (localOnTextContentListener == null) {
        return;
      }
      localOnTextContentListener.b(paramView.getTag());
      return;
    }
    WSMarqueeDirector.OnTextContentListener localOnTextContentListener = this.k;
    if (localOnTextContentListener == null) {
      return;
    }
    localOnTextContentListener.a(paramView.getTag());
  }
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT > 15) {
      this.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    WSLog.a("WSMarqueeDirector", "onGlobalLayout: ");
    this.n = true;
    if (this.o) {
      c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector
 * JD-Core Version:    0.7.0.1
 */