package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer
  extends FrameLayout
{
  private Queue<SnackContainer.SnackHolder> a = new LinkedList();
  private AnimationSet b;
  private final Runnable c = new SnackContainer.1(this);
  private AnimationSet d;
  
  public SnackContainer(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  SnackContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(2131446125);
    a();
  }
  
  private void a()
  {
    this.d = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.d.setInterpolator(new DecelerateInterpolator(1.5F));
    this.d.addAnimation(localTranslateAnimation);
    this.d.addAnimation(localAlphaAnimation);
    this.b = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.b.addAnimation(localTranslateAnimation);
    this.b.addAnimation(localAlphaAnimation);
    this.b.setDuration(300L);
    this.b.setAnimationListener(new SnackContainer.2(this));
  }
  
  private void a(SnackContainer.SnackHolder paramSnackHolder)
  {
    a(paramSnackHolder, false);
  }
  
  private void a(SnackContainer.SnackHolder paramSnackHolder, boolean paramBoolean)
  {
    setVisibility(0);
    c(paramSnackHolder);
    addView(paramSnackHolder.a);
    paramSnackHolder.b.setText(paramSnackHolder.d.a);
    if (paramSnackHolder.d.b != null)
    {
      paramSnackHolder.c.setVisibility(0);
      paramSnackHolder.c.setText(paramSnackHolder.d.b);
    }
    else
    {
      paramSnackHolder.c.setVisibility(8);
    }
    if (paramBoolean) {
      this.d.setDuration(0L);
    } else {
      this.d.setDuration(500L);
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772096);
    localAnimation.setDuration(500L);
    startAnimation(this.d);
    localAnimation.setStartOffset(200L);
    paramSnackHolder.c.startAnimation(localAnimation);
    paramSnackHolder.b.startAnimation(localAnimation);
    if (paramSnackHolder.d.e > 0) {
      postDelayed(this.c, paramSnackHolder.d.e);
    }
    paramSnackHolder.a.setOnTouchListener(new SnackContainer.3(this, paramSnackHolder));
  }
  
  private void b(SnackContainer.SnackHolder paramSnackHolder)
  {
    if (paramSnackHolder.e != null)
    {
      SnackBarAlert.setShowMode(false);
      paramSnackHolder.e.onHide();
    }
  }
  
  private void c(SnackContainer.SnackHolder paramSnackHolder)
  {
    if (paramSnackHolder.e != null)
    {
      SnackBarAlert.setShowMode(true);
      paramSnackHolder.e.onShow();
    }
  }
  
  public void clearSnacks(boolean paramBoolean)
  {
    this.a.clear();
    if (paramBoolean) {
      this.c.run();
    }
  }
  
  public void hide()
  {
    removeCallbacks(this.c);
    this.c.run();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public boolean isShowing()
  {
    return this.a.isEmpty() ^ true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.cancel();
    this.b.cancel();
    removeCallbacks(this.c);
    this.a.clear();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.a.isEmpty()) {
        b((SnackContainer.SnackHolder)this.a.poll());
      }
      if (!isEmpty()) {
        a((SnackContainer.SnackHolder)this.a.peek());
      } else {
        setVisibility(8);
      }
      SnackBarAlert.setShowMode(false);
    }
  }
  
  public void restoreState(Bundle paramBundle, View paramView)
  {
    paramBundle = paramBundle.getParcelableArray("SAVED_MSGS");
    if (paramBundle == null) {
      return;
    }
    int j = paramBundle.length;
    int i = 0;
    for (boolean bool = true; i < j; bool = false)
    {
      showSnack((Snack)paramBundle[i], paramView, null, bool);
      i += 1;
    }
  }
  
  public Bundle saveState()
  {
    Bundle localBundle = new Bundle();
    Snack[] arrayOfSnack = new Snack[this.a.size()];
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfSnack[i] = ((SnackContainer.SnackHolder)localIterator.next()).d;
      i += 1;
    }
    localBundle.putParcelableArray("SAVED_MSGS", arrayOfSnack);
    return localBundle;
  }
  
  public void showSnack(Snack paramSnack, View paramView, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    showSnack(paramSnack, paramView, paramOnVisibilityChangeListener, false);
  }
  
  public void showSnack(Snack paramSnack, View paramView, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener, boolean paramBoolean)
  {
    if ((paramView.getParent() != null) && (paramView.getParent() != this)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    paramSnack = new SnackContainer.SnackHolder(paramSnack, paramView, paramOnVisibilityChangeListener, null);
    this.a.offer(paramSnack);
    if (this.a.size() == 1) {
      a(paramSnack, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */