package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieTask;
import com.tencent.qphone.base.util.QLog;

public class LoginAnimBtnView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private LottieComposition.Factory.ListenerAdapter jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private LottieTask<LottieComposition> jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginAnimBtnView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1446926;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int d = -16725252;
  private int e = 855638016;
  
  public LoginAnimBtnView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "loadLottieAnimation mLottieDrawable:" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      return;
    }
    ThreadManager.post(new LoginAnimBtnView.2(this), 5, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    setEnabled(false);
    this.jdField_c_of_type_Boolean = false;
    i();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onResume " + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (isEnabled())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onPause " + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (isEnabled()) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) && (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "pauseIfAnim");
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (isEnabled()) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) && (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "resumeIfAnim");
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "onDestroy " + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    this.jdField_c_of_type_Boolean = true;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      setBackgroundDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.clearComposition();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(null);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter.cancel();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask.removeListener(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieTask = null;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition$Factory$ListenerAdapter = null;
      }
      return;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (i != this.jdField_a_of_type_Int) || (j != this.jdField_b_of_type_Int))
        {
          int k = Math.min(i, j) / 2;
          this.jdField_a_of_type_AndroidGraphicsPath = new Path();
          this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.INVERSE_WINDING);
          this.jdField_a_of_type_AndroidGraphicsPath.addCircle(i / 2, j / 2, k, Path.Direction.CW);
          this.jdField_a_of_type_Int = i;
          this.jdField_b_of_type_Int = j;
        }
        if ((isEnabled()) && (isPressed())) {
          paramCanvas.drawColor(this.e);
        }
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      catch (Throwable paramCanvas)
      {
        QLog.e("LoginAnimBtnView", 1, "onDraw error2:" + paramCanvas.getMessage());
      }
      localOutOfMemoryError = localOutOfMemoryError;
      QLog.e("LoginAnimBtnView", 1, "onDraw error0:" + localOutOfMemoryError.getMessage());
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.clearComposition();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_a_of_type_Boolean = false;
      if (isEnabled()) {
        setBackgroundColor(this.d);
      }
      for (;;)
      {
        try
        {
          super.onDraw(paramCanvas);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("LoginAnimBtnView", 1, "onDraw error1:" + localThrowable.getMessage());
        }
        break;
        setBackgroundColor(this.jdField_c_of_type_Int);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool = isEnabled();
    super.setEnabled(paramBoolean);
    if (bool == paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "setEnabled isEnabled:" + isEnabled() + "  mLottieDrawable:" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView
 * JD-Core Version:    0.7.0.1
 */