package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;

public class ARCakeTipsViewStubHolder
  extends BaseViewStubHolder
{
  private ViewGroup a;
  private TextView b;
  private final Handler c = new Handler(Looper.getMainLooper());
  private final Runnable d = new ARCakeTipsViewStubHolder.1(this);
  
  public ARCakeTipsViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  private void a(Runnable paramRunnable, long paramLong)
  {
    c();
    paramRunnable.run();
    this.c.removeCallbacks(this.d);
    this.c.postDelayed(this.d, paramLong);
    if (this.a.getVisibility() == 0) {
      return;
    }
    this.a.setAlpha(0.0F);
    this.a.setVisibility(0);
    this.a.animate().alpha(1.0F).setDuration(150L).setListener(new ARCakeTipsViewStubHolder.4(this));
  }
  
  private void b(int paramInt)
  {
    this.b.setVisibility(0);
    Context localContext = this.b.getContext();
    this.b.setText(localContext.getResources().getString(2064187635, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  private void b(Runnable paramRunnable)
  {
    a(paramRunnable, 2000L);
  }
  
  private void f()
  {
    this.b.setVisibility(0);
    this.b.setText(2064187644);
  }
  
  private void g()
  {
    if (!ap_()) {
      return;
    }
    if (this.a.getVisibility() != 0) {
      return;
    }
    this.a.animate().alpha(0.0F).setDuration(150L).setListener(new ARCakeTipsViewStubHolder.5(this));
  }
  
  public void a(int paramInt)
  {
    a(new ARCakeTipsViewStubHolder.3(this, paramInt), 10000L);
  }
  
  protected void a(View paramView)
  {
    this.a = ((ViewGroup)paramView.findViewById(2063990893));
    this.b = ((TextView)this.a.findViewById(2063991520));
    this.a.setVisibility(8);
  }
  
  public void d()
  {
    b(new ARCakeTipsViewStubHolder.2(this));
  }
  
  public void e()
  {
    this.c.removeCallbacks(this.d);
    this.c.post(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.ARCakeTipsViewStubHolder
 * JD-Core Version:    0.7.0.1
 */