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
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class EffectSettingBtn
{
  View jdField_a_of_type_AndroidViewView;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  boolean jdField_b_of_type_Boolean;
  
  private void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    this.jdField_a_of_type_AndroidViewView.postDelayed(this.b, 3000L);
  }
  
  private void a(TextView paramTextView)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380351) != null)
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
    float f2 = arrayOfInt2[1] - j + AIOUtils.b(0, this.jdField_a_of_type_AndroidViewView.getResources());
    QLog.d("qav_face_guide", 1, String.format("host(%s, %s), Parent(%s, %s), cur(%s, %s), dest(%s, %s), textview(%s, %s)", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(arrayOfInt1[0]), Integer.valueOf(arrayOfInt1[1]), Integer.valueOf(arrayOfInt2[0]), Integer.valueOf(arrayOfInt2[1]), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) }));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(5);
    ((RelativeLayout.LayoutParams)localObject).addRule(6);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)f1, (int)f2, 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (AudioHelper.a(0) == 1) {
      return true;
    }
    if (paramBoolean)
    {
      VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (localVideoAppInterface == null) {
        return false;
      }
      if (localVideoAppInterface.a().a().al) {
        return false;
      }
      if (!UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        return false;
      }
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return false;
    }
    if (!this.jdField_a_of_type_AndroidViewView.isEnabled()) {
      return false;
    }
    return EffectsRenderController.d();
  }
  
  private void b(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramTextView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131756181);
    paramTextView.measure(0, 0);
    int j = paramTextView.getMeasuredWidth();
    int i = paramTextView.getMeasuredHeight();
    paramTextView = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramTextView);
    j = (paramTextView[0] * 2 + this.jdField_a_of_type_AndroidViewView.getWidth() - j) / 2;
    int k = paramTextView[1];
    int m = AIOUtils.b(0, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, j, k - i + m);
    QLog.d("qav_face_guide", 1, "showUserGuide_PopupWindow");
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      localObject = (TextView)((RelativeLayout)localObject).findViewById(2131380351);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        ((TextView)localObject).setOnClickListener(null);
      }
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void e()
  {
    if (!a(true)) {
      return;
    }
    Object localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    TextView localTextView = null;
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject2 != null) {
      localTextView = (TextView)((RelativeLayout)localObject2).findViewById(2131380351);
    }
    if (localTextView == null) {
      return;
    }
    int i = ((AVActivity)localObject1).getWindow().getDecorView().getWidth();
    int j = ((AVActivity)localObject1).getWindow().getDecorView().getHeight();
    localTextView.measure(0, 0);
    int k = localTextView.getMeasuredWidth();
    localTextView.getMeasuredHeight();
    localObject1 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject1);
    int m = localObject1[0];
    int n = localObject1[1];
    localObject1 = (RelativeLayout)localTextView.getParent();
    localObject2 = new int[2];
    ((RelativeLayout)localObject1).getLocationInWindow((int[])localObject2);
    int i1 = i - localObject2[0] - ((RelativeLayout)localObject1).getWidth();
    int i2 = j - localObject2[1] - ((RelativeLayout)localObject1).getHeight();
    float f1 = i - m - this.jdField_a_of_type_AndroidViewView.getWidth() / 2 - k / 2 - i1 + AIOUtils.b(0.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    float f2 = j - n - i2 - AIOUtils.b(11.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, (int)f1, (int)f2);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("qav_face_guide, location_Host[");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append("], hostTop[");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append("], hostRight[");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append("], hostBottom[");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append("], offsetDP_right[");
    ((StringBuilder)localObject1).append(0.0F);
    ((StringBuilder)localObject1).append("], offsetDP_bottom[");
    ((StringBuilder)localObject1).append(11.0F);
    ((StringBuilder)localObject1).append("], pos_right[");
    ((StringBuilder)localObject1).append(f1);
    ((StringBuilder)localObject1).append("], pos_bottom[");
    ((StringBuilder)localObject1).append(f2);
    ((StringBuilder)localObject1).append("], hostID[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewView.getId());
    ((StringBuilder)localObject1).append("], Width[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewView.getWidth());
    ((StringBuilder)localObject1).append("], Height[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewView.getHeight());
    ((StringBuilder)localObject1).append("], textViewWidth[");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append("], parentRight[");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("], parentBottom[");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append("]");
    QLog.e("qav_face_guide", 1, ((StringBuilder)localObject1).toString());
    localTextView.getViewTreeObserver().addOnPreDrawListener(new EffectSettingBtn.4(this, localTextView));
    d();
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      b(localTextView);
    } else {
      a(localTextView);
    }
    localTextView.setOnClickListener(new EffectSettingBtn.5(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().al = true;
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    d();
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.b);
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn
 * JD-Core Version:    0.7.0.1
 */