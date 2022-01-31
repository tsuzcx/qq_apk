import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.1;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.3;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.4;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.5;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class amuu
  implements amus
{
  private volatile int jdField_a_of_type_Int = 0;
  private amut jdField_a_of_type_Amut;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARVideoRecordButtonView jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ARVideoRecordViewProxy.1(this);
  private final String jdField_a_of_type_JavaLangString = alud.a(2131701144);
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 5000;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = "0.00M";
  private View c;
  
  public amuu(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView = ((ARVideoRecordButtonView)paramView.findViewById(2131369935));
    this.c = paramView.findViewById(2131363960);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362751);
    this.jdField_a_of_type_Boolean = amul.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.c.setOnClickListener(null);
    this.c.setOnTouchListener(new amuv(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362753));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362752));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "init self");
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation1.setDuration(paramInt1 / 2);
    int i = 0 + paramInt1 / 2;
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation2.setDuration(paramInt1 / 2);
    localTranslateAnimation2.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation2.setStartOffset(i);
    i += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2 * 2 / 3);
    localTranslateAnimation3.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation3.setDuration(paramInt1 / 2);
    localTranslateAnimation3.setStartOffset(i);
    i += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2 * 2 / 3);
    localTranslateAnimation4.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation4.setDuration(paramInt1 / 2);
    localTranslateAnimation4.setStartOffset(i);
    paramInt1 /= 2;
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    localAnimationSet.addAnimation(localTranslateAnimation3);
    localAnimationSet.addAnimation(localTranslateAnimation4);
    if (paramView != null) {
      paramView.startAnimation(localAnimationSet);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "resetToInnerTipsStatus");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setShowState(2);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("0.00M");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_b_of_type_AndroidViewView, 600, -40);
      amul.a(true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus start animation");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "show");
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      c();
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.3(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode" + paramInt);
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode mCurrentUIDisplayMode equal");
      }
      return;
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.6(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordButtonView.setProgress(paramInt1, 60000L);
    }
    ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.5(this, paramInt1, paramInt2));
  }
  
  public void a(amut paramamut)
  {
    this.jdField_a_of_type_Amut = paramamut;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordViewProxy", 2, "hide");
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
      ThreadManager.getUIHandler().post(new ARVideoRecordViewProxy.4(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuu
 * JD-Core Version:    0.7.0.1
 */