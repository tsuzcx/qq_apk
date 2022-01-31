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
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jvm;
import jvn;
import jvo;
import jvp;
import jvq;

public class EffectSettingBtn
{
  final int jdField_a_of_type_Int = 2131365950;
  public View a;
  public PopupWindow a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public VideoAppInterface a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jvn(this);
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  private Runnable b;
  public boolean b;
  
  public EffectSettingBtn(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, RelativeLayout paramRelativeLayout, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangRunnable = new jvo(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    QLog.d("qav_face_guide", 1, "EffectSettingBtn, mParent[" + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new jvm(this));
  }
  
  private void a(TextView paramTextView)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365950) != null)
    {
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.measure(0, 0);
    int i = paramTextView.getMeasuredWidth();
    int j = paramTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt1 = new int[2];
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt2 = new int[2];
    localObject[0] -= arrayOfInt1[0];
    localObject[1] -= arrayOfInt1[1];
    float f1 = (arrayOfInt2[0] * 2 + this.jdField_a_of_type_AndroidViewView.getWidth() - i) / 2;
    int k = arrayOfInt2[1];
    float f2 = AIOUtils.a(0, this.jdField_a_of_type_AndroidViewView.getResources()) + (k - j);
    QLog.d("qav_face_guide", 1, String.format("host(%s, %s), Parent(%s, %s), cur(%s, %s), dest(%s, %s), textview(%s, %s)", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(arrayOfInt1[0]), Integer.valueOf(arrayOfInt1[1]), Integer.valueOf(arrayOfInt2[0]), Integer.valueOf(arrayOfInt2[1]), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) }));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(5);
    ((RelativeLayout.LayoutParams)localObject).addRule(6);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)f1, (int)f2, 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    }
    while ((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) || (!this.jdField_a_of_type_AndroidViewView.isEnabled()) || (!EffectsRenderController.a())) {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax) || (!UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)));
    }
    return true;
  }
  
  private void b(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramTextView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624134);
    paramTextView.measure(0, 0);
    int j = paramTextView.getMeasuredWidth();
    int i = paramTextView.getMeasuredHeight();
    paramTextView = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramTextView);
    j = (paramTextView[0] * 2 + this.jdField_a_of_type_AndroidViewView.getWidth() - j) / 2;
    int k = paramTextView[1];
    int m = AIOUtils.a(0, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, j, k - i + m);
    QLog.d("qav_face_guide", 1, "showUserGuide_PopupWindow");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365950);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        localTextView.setOnClickListener(null);
      }
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void f()
  {
    if (!a(true)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void g()
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_AndroidViewView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
  }
  
  private void h()
  {
    if (!a(true)) {}
    do
    {
      return;
      localObject3 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject3 == null);
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365950);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new TextView(this.jdField_a_of_type_AndroidViewView.getContext());
      ((TextView)localObject2).setBackgroundResource(2130840216);
      ((TextView)localObject2).setText("左右分屏，互动更有趣。");
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(1, 15.0F);
      ((TextView)localObject2).setPadding(0, 0, 0, 0);
      ((TextView)localObject2).setId(2131365950);
      ((TextView)localObject2).setPadding(AIOUtils.a(9.25F, this.jdField_a_of_type_AndroidViewView.getResources()), AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidViewView.getResources()), AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidViewView.getResources()), AIOUtils.a(14.5F, this.jdField_a_of_type_AndroidViewView.getResources()));
    }
    ((TextView)localObject2).measure(0, 0);
    int i = ((TextView)localObject2).getMeasuredWidth();
    ((TextView)localObject2).getMeasuredHeight();
    localObject1 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject1);
    int j = ((AVActivity)localObject3).getWindow().getDecorView().getWidth();
    int k = ((AVActivity)localObject3).getWindow().getDecorView().getHeight();
    Object localObject3 = new int[2];
    localObject3[0] = (j - localObject1[0]);
    localObject3[1] = (k - localObject1[1]);
    float f1 = (localObject3[0] * 2 - this.jdField_a_of_type_AndroidViewView.getWidth() - i) / 2 + AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    float f2 = localObject3[1] - AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
    localLayoutParams.setMargins(0, 0, (int)f1, (int)f2);
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    QLog.d("qav_face_guide", 1, "qav_face_guide, location_Host[" + localObject1[0] + ", " + localObject1[1] + "], location_Host_RB[" + localObject3[0] + ", " + localObject3[1] + "], offsetDP_right[" + 0.0F + "], offsetDP_bottom[" + 11.0F + "], pos_right[" + f1 + "], pos_bottom[" + f2 + "], hostID[" + this.jdField_a_of_type_AndroidViewView.getId() + "], Width[" + this.jdField_a_of_type_AndroidViewView.getWidth() + "], Height[" + this.jdField_a_of_type_AndroidViewView.getHeight() + "]");
    ((TextView)localObject2).getViewTreeObserver().addOnPreDrawListener(new jvp(this, (TextView)localObject2));
    e();
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      b((TextView)localObject2);
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new jvq(this));
      return;
      a((TextView)localObject2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax = true;
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    e();
  }
  
  public void b()
  {
    f();
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn
 * JD-Core Version:    0.7.0.1
 */