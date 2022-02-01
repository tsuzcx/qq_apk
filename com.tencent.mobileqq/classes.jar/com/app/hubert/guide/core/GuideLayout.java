package com.app.hubert.guide.core;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.app.hubert.guide.listener.OnHighlightDrewListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.guide.model.RelativeGuide;
import java.util.Iterator;
import java.util.List;

public class GuideLayout
  extends FrameLayout
{
  public static final int DEFAULT_BACKGROUND_COLOR = -1308622848;
  private Controller controller;
  private float downX;
  private float downY;
  public GuidePage guidePage;
  private GuideLayout.OnGuideLayoutDismissListener listener;
  private Paint mPaint;
  private int touchSlop;
  
  private GuideLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private GuideLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public GuideLayout(Context paramContext, GuidePage paramGuidePage, Controller paramController)
  {
    super(paramContext);
    init();
    setGuidePage(paramGuidePage);
    this.controller = paramController;
  }
  
  private void addCustomToLayout(GuidePage paramGuidePage)
  {
    int i = 0;
    removeAllViews();
    int j = paramGuidePage.getLayoutResId();
    if (j != 0)
    {
      View localView1 = LayoutInflater.from(getContext()).inflate(j, this, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject = paramGuidePage.getClickToDismissIds();
      if ((localObject != null) && (localObject.length > 0))
      {
        j = localObject.length;
        if (i < j)
        {
          int k = localObject[i];
          View localView2 = localView1.findViewById(k);
          if (localView2 != null) {
            localView2.setOnClickListener(new GuideLayout.2(this));
          }
          for (;;)
          {
            i += 1;
            break;
            Log.w("NewbieGuide", "can't find the view by id : " + k + " which used to remove guide page");
          }
        }
      }
      localObject = paramGuidePage.getOnLayoutInflatedListener();
      if (localObject != null) {
        ((OnLayoutInflatedListener)localObject).onLayoutInflated(localView1, this.controller);
      }
      addView(localView1, localLayoutParams);
    }
    paramGuidePage = paramGuidePage.getRelativeGuides();
    if (paramGuidePage.size() > 0)
    {
      paramGuidePage = paramGuidePage.iterator();
      while (paramGuidePage.hasNext()) {
        addView(((RelativeGuide)paramGuidePage.next()).getGuideLayout((ViewGroup)getParent(), this.controller));
      }
    }
  }
  
  private void dismiss()
  {
    if (getParent() != null)
    {
      ((ViewGroup)getParent()).removeView(this);
      if (this.listener != null) {
        this.listener.onGuideLayoutDismiss(this);
      }
    }
  }
  
  private void drawHighlights(Canvas paramCanvas)
  {
    Object localObject = this.guidePage.getHighLights();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        HighLight localHighLight = (HighLight)((Iterator)localObject).next();
        RectF localRectF = localHighLight.getRectF((ViewGroup)getParent());
        switch (GuideLayout.4.$SwitchMap$com$app$hubert$guide$model$HighLight$Shape[localHighLight.getShape().ordinal()])
        {
        default: 
          paramCanvas.drawRect(localRectF, this.mPaint);
        }
        for (;;)
        {
          notifyDrewListener(paramCanvas, localHighLight, localRectF);
          break;
          paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localHighLight.getRadius(), this.mPaint);
          continue;
          paramCanvas.drawOval(localRectF, this.mPaint);
          continue;
          paramCanvas.drawRoundRect(localRectF, localHighLight.getRound(), localHighLight.getRound(), this.mPaint);
        }
      }
    }
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.mPaint.setXfermode(localPorterDuffXfermode);
    this.mPaint.setMaskFilter(new BlurMaskFilter(10.0F, BlurMaskFilter.Blur.INNER));
    setLayerType(1, null);
    setWillNotDraw(false);
    this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void notifyClickListener(HighLight paramHighLight)
  {
    paramHighLight = paramHighLight.getOptions();
    if ((paramHighLight != null) && (paramHighLight.onClickListener != null)) {
      paramHighLight.onClickListener.onClick(this);
    }
  }
  
  private void notifyDrewListener(Canvas paramCanvas, HighLight paramHighLight, RectF paramRectF)
  {
    paramHighLight = paramHighLight.getOptions();
    if ((paramHighLight != null) && (paramHighLight.onHighlightDrewListener != null)) {
      paramHighLight.onHighlightDrewListener.onHighlightDrew(paramCanvas, paramRectF);
    }
  }
  
  private void setGuidePage(GuidePage paramGuidePage)
  {
    this.guidePage = paramGuidePage;
    setOnClickListener(new GuideLayout.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    addCustomToLayout(this.guidePage);
    Animation localAnimation = this.guidePage.getEnterAnimation();
    if (localAnimation != null) {
      startAnimation(localAnimation);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.guidePage.getBackgroundColor();
    int i = j;
    if (j == 0) {
      i = -1308622848;
    }
    paramCanvas.drawColor(i);
    drawHighlights(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.downX = paramMotionEvent.getX();
      this.downY = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.downX) < this.touchSlop) && (Math.abs(f2 - this.downY) < this.touchSlop))
      {
        Iterator localIterator = this.guidePage.getHighLights().iterator();
        while (localIterator.hasNext())
        {
          HighLight localHighLight = (HighLight)localIterator.next();
          if (localHighLight.getRectF((ViewGroup)getParent()).contains(f1, f2))
          {
            notifyClickListener(localHighLight);
            return true;
          }
        }
        performClick();
      }
    }
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void remove()
  {
    Animation localAnimation = this.guidePage.getExitAnimation();
    if (localAnimation != null)
    {
      localAnimation.setAnimationListener(new GuideLayout.3(this));
      startAnimation(localAnimation);
      return;
    }
    dismiss();
  }
  
  public void setOnGuideLayoutDismissListener(GuideLayout.OnGuideLayoutDismissListener paramOnGuideLayoutDismissListener)
  {
    this.listener = paramOnGuideLayoutDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.app.hubert.guide.core.GuideLayout
 * JD-Core Version:    0.7.0.1
 */