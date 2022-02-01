package com.tencent.av.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class EffectSettingBtn
{
  WeakReference<AVActivity> a;
  VideoAppInterface b;
  View c;
  RelativeLayout d;
  PopupWindow e;
  boolean f;
  boolean g;
  private Runnable h;
  private Runnable i;
  
  private void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(this.b, paramLong);
    this.c.postDelayed(this.i, 3000L);
  }
  
  private void a(TextView paramTextView)
  {
    if (this.d.findViewById(2131449286) != null)
    {
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.measure(0, 0);
    int j = paramTextView.getMeasuredWidth();
    int k = paramTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.c.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt1 = new int[2];
    this.d.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt2 = new int[2];
    localObject[0] -= arrayOfInt1[0];
    localObject[1] -= arrayOfInt1[1];
    float f1 = (arrayOfInt2[0] * 2 + this.c.getWidth() - j) / 2;
    float f2 = arrayOfInt2[1] - k + AIOUtils.b(0, this.c.getResources());
    QLog.d("qav_face_guide", 1, String.format("host(%s, %s), Parent(%s, %s), cur(%s, %s), dest(%s, %s), textview(%s, %s)", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(arrayOfInt1[0]), Integer.valueOf(arrayOfInt1[1]), Integer.valueOf(arrayOfInt2[0]), Integer.valueOf(arrayOfInt2[1]), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j), Integer.valueOf(k) }));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(5);
    ((RelativeLayout.LayoutParams)localObject).addRule(6);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)f1, (int)f2, 0, 0);
    this.d.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (AudioHelper.a(0) == 1) {
      return true;
    }
    if (paramBoolean)
    {
      VideoAppInterface localVideoAppInterface = this.b;
      if (localVideoAppInterface == null) {
        return false;
      }
      if (localVideoAppInterface.b().k().bJ) {
        return false;
      }
      if (!UITools.c(this.b)) {
        return false;
      }
    }
    if (this.c.getVisibility() != 0) {
      return false;
    }
    if (!this.c.isEnabled()) {
      return false;
    }
    return EffectsRenderController.e();
  }
  
  private void b(TextView paramTextView)
  {
    this.e = new PopupWindow(this.c.getContext());
    this.e.setBackgroundDrawable(null);
    this.e.setContentView(paramTextView);
    this.e.setWidth(-2);
    this.e.setHeight(-2);
    this.e.setOutsideTouchable(this.f);
    this.e.setAnimationStyle(2131953330);
    paramTextView.measure(0, 0);
    int k = paramTextView.getMeasuredWidth();
    int j = paramTextView.getMeasuredHeight();
    paramTextView = new int[2];
    this.c.getLocationOnScreen(paramTextView);
    k = (paramTextView[0] * 2 + this.c.getWidth() - k) / 2;
    int m = paramTextView[1];
    int n = AIOUtils.b(0, this.c.getResources());
    this.e.showAtLocation(this.c, 0, k, m - j + n);
    QLog.d("qav_face_guide", 1, "showUserGuide_PopupWindow");
  }
  
  private void d()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      localObject = (TextView)((RelativeLayout)localObject).findViewById(2131449286);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        ((TextView)localObject).setOnClickListener(null);
      }
    }
    this.c.removeCallbacks(this.h);
  }
  
  private void e()
  {
    if (!a(true)) {
      return;
    }
    Object localObject1 = (AVActivity)this.a.get();
    if (localObject1 == null) {
      return;
    }
    TextView localTextView = null;
    Object localObject2 = this.d;
    if (localObject2 != null) {
      localTextView = (TextView)((RelativeLayout)localObject2).findViewById(2131449286);
    }
    if (localTextView == null) {
      return;
    }
    int j = ((AVActivity)localObject1).getWindow().getDecorView().getWidth();
    int k = ((AVActivity)localObject1).getWindow().getDecorView().getHeight();
    localTextView.measure(0, 0);
    int m = localTextView.getMeasuredWidth();
    localTextView.getMeasuredHeight();
    localObject1 = new int[2];
    this.c.getLocationInWindow((int[])localObject1);
    int n = localObject1[0];
    int i1 = localObject1[1];
    localObject1 = (RelativeLayout)localTextView.getParent();
    localObject2 = new int[2];
    ((RelativeLayout)localObject1).getLocationInWindow((int[])localObject2);
    int i2 = j - localObject2[0] - ((RelativeLayout)localObject1).getWidth();
    int i3 = k - localObject2[1] - ((RelativeLayout)localObject1).getHeight();
    float f1 = j - n - this.c.getWidth() / 2 - m / 2 - i2 + AIOUtils.b(0.0F, this.c.getResources());
    float f2 = k - i1 - i3 - AIOUtils.b(11.0F, this.c.getResources());
    localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, (int)f1, (int)f2);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("qav_face_guide, location_Host[");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("], hostTop[");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("], hostRight[");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("], hostBottom[");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("], offsetDP_right[");
    ((StringBuilder)localObject1).append(0.0F);
    ((StringBuilder)localObject1).append("], offsetDP_bottom[");
    ((StringBuilder)localObject1).append(11.0F);
    ((StringBuilder)localObject1).append("], pos_right[");
    ((StringBuilder)localObject1).append(f1);
    ((StringBuilder)localObject1).append("], pos_bottom[");
    ((StringBuilder)localObject1).append(f2);
    ((StringBuilder)localObject1).append("], hostID[");
    ((StringBuilder)localObject1).append(this.c.getId());
    ((StringBuilder)localObject1).append("], Width[");
    ((StringBuilder)localObject1).append(this.c.getWidth());
    ((StringBuilder)localObject1).append("], Height[");
    ((StringBuilder)localObject1).append(this.c.getHeight());
    ((StringBuilder)localObject1).append("], textViewWidth[");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append("], parentRight[");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append("], parentBottom[");
    ((StringBuilder)localObject1).append(i3);
    ((StringBuilder)localObject1).append("]");
    QLog.e("qav_face_guide", 1, ((StringBuilder)localObject1).toString());
    localTextView.getViewTreeObserver().addOnPreDrawListener(new EffectSettingBtn.4(this, localTextView));
    d();
    if (this.d == null) {
      b(localTextView);
    } else {
      a(localTextView);
    }
    localTextView.setOnClickListener(new EffectSettingBtn.5(this));
  }
  
  public void a()
  {
    this.b.b().k().bJ = true;
    UITools.b(this.b);
    d();
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    d();
    this.a = null;
    this.b = null;
    this.c.removeCallbacks(this.i);
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn
 * JD-Core Version:    0.7.0.1
 */