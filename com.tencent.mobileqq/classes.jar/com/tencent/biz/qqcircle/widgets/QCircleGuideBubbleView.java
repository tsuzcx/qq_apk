package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QCircleGuideBubbleView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int a = 3500;
  private TextView b;
  private QCircleGuideBubbleView.BubbleHandler c;
  private boolean d;
  private QCircleGuideBubbleView.OnShowListener e;
  private QCircleGuideBubbleView.OnHideListener f;
  private QCircleGuideBubbleView.OnCloseClickListener g;
  private ImageView h;
  private ImageView i;
  private LinearLayout j;
  private View k;
  private FrameLayout l;
  private boolean m;
  private boolean n = true;
  
  public QCircleGuideBubbleView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleGuideBubbleView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCircleGuideBubbleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d()
  {
    this.c.removeMessages(1);
    this.c.removeMessages(2);
  }
  
  public void a()
  {
    d();
    if (this.d)
    {
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      startAnimation((Animation)localObject);
    }
    setVisibility(0);
    int i1 = this.a;
    if ((i1 > 0) && (!this.m) && (this.n)) {
      this.c.sendEmptyMessageDelayed(2, i1);
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((QCircleGuideBubbleView.OnShowListener)localObject).a();
    }
  }
  
  public void a(int paramInt)
  {
    d();
    this.c.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    double d1;
    double d2;
    if (paramInt1 == 0)
    {
      localObject = this.i;
      if (localObject == null) {
        return;
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.h;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      if (paramInt2 == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        d1 = paramInt2;
        d2 = paramInt3;
        Double.isNaN(d2);
        Double.isNaN(d1);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(d1 + d2 * 0.5D));
      }
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.i;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131437427);
    if (paramInt2 == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
      d1 = paramInt3;
      Double.isNaN(d1);
      d2 = paramInt2;
      Double.isNaN(d2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(d1 * 0.5D + d2));
    }
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b()
  {
    d();
    if (this.d)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(200L);
      startAnimation((Animation)localObject);
    }
    setVisibility(8);
    Object localObject = this.f;
    if (localObject != null) {
      ((QCircleGuideBubbleView.OnHideListener)localObject).a();
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public void c()
  {
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  public int getContentLineHeight()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return 0;
    }
    return localTextView.getLineHeight();
  }
  
  public int getLayoutId()
  {
    return 2131626841;
  }
  
  protected String getLogTag()
  {
    return "QCircleGuideBubbleView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434477)
    {
      this.c.sendEmptyMessage(2);
      QCircleGuideBubbleView.OnCloseClickListener localOnCloseClickListener = this.g;
      if (localOnCloseClickListener != null) {
        localOnCloseClickListener.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
    c();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131431366));
    this.j = ((LinearLayout)paramView.findViewById(2131437427));
    this.h = ((ImageView)paramView.findViewById(2131436297));
    this.i = ((ImageView)paramView.findViewById(2131436298));
    this.k = paramView.findViewById(2131434479);
    this.l = ((FrameLayout)paramView.findViewById(2131434477));
    this.c = new QCircleGuideBubbleView.BubbleHandler(this, null);
    setCloseButton(false);
  }
  
  public void setAutoClose(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setClickSpanAttribute()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    localTextView.setHighlightColor(0);
    this.b.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public void setCloseButton(boolean paramBoolean)
  {
    View localView = this.k;
    if ((localView != null) && (this.l != null))
    {
      this.m = paramBoolean;
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.l.setOnClickListener(this);
        this.l.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
      this.l.setVisibility(8);
      return;
    }
    QLog.e("QCircleGuideBubbleView", 1, "mCloseButton is null");
  }
  
  public void setMiddleBottomArrow()
  {
    if (this.h == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(3, 2131437427);
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void setNeedFadeAnim(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnCloseClickListener(QCircleGuideBubbleView.OnCloseClickListener paramOnCloseClickListener)
  {
    this.g = paramOnCloseClickListener;
  }
  
  public void setOnHideListener(QCircleGuideBubbleView.OnHideListener paramOnHideListener)
  {
    this.f = paramOnHideListener;
  }
  
  public void setOnShowListener(QCircleGuideBubbleView.OnShowListener paramOnShowListener)
  {
    this.e = paramOnShowListener;
  }
  
  public void setReportBean(Object paramObject) {}
  
  public void setShowDuration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setSpanText(SpannableString paramSpannableString)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(paramSpannableString);
    }
  }
  
  public void setStyle(int paramInt)
  {
    ImageView localImageView = this.h;
    if ((localImageView != null) && (this.b != null))
    {
      if (this.j == null) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          localImageView.setBackgroundResource(2130845463);
          this.j.setBackgroundResource(2130846080);
          this.b.setTextColor(-1);
          return;
        }
        localImageView.setBackgroundResource(2130845117);
        this.j.setBackgroundResource(2130845120);
        this.b.setTextColor(-16777216);
        return;
      }
      localImageView.setBackgroundResource(2130845116);
      this.j.setBackgroundResource(2130845118);
      this.b.setTextColor(-1);
    }
  }
  
  public void setText(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView
 * JD-Core Version:    0.7.0.1
 */