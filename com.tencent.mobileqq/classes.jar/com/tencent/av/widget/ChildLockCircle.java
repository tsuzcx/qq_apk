package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.av.widget.api.IChildLockCircleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ChildLockCircle
  extends View
  implements Handler.Callback, Animation.AnimationListener
{
  private final int jdField_a_of_type_Int = 100;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = null;
  public Handler a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  private ChildLockCircle.AnimatedThread jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread = null;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  
  public ChildLockCircle(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Resources paramResources, int paramInt)
  {
    int j = 2130842141;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
      break;
    case 14: 
      i = 2130842140;
      break;
    case 13: 
      i = 2130842139;
      break;
    case 12: 
      i = 2130842138;
      break;
    case 11: 
      i = 2130842137;
      break;
    case 10: 
      i = 2130842136;
      break;
    case 9: 
      i = 2130842149;
      break;
    case 8: 
      i = 2130842148;
      break;
    case 7: 
      i = 2130842147;
      break;
    case 6: 
      i = 2130842146;
      break;
    case 5: 
      i = 2130842145;
      break;
    case 4: 
      i = 2130842144;
      break;
    case 3: 
      i = 2130842143;
      break;
    case 2: 
      i = 2130842142;
      break;
    case 1: 
      i = 2130842135;
    }
    return BitmapFactory.decodeResource(paramResources, i);
  }
  
  private void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(Context paramContext)
  {
    if (!((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onLockSuccess(getContext())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer start");
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer = new ChildLockCircle.1(this, 750L, 50L, paramContext);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
    }
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373363);
    setBackgroundResource(2130842150);
    paramAttributeSet = getResources();
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(2131695425);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(2131695426);
    this.jdField_c_of_type_JavaLangString = paramAttributeSet.getString(2131695423);
    this.jdField_d_of_type_JavaLangString = paramAttributeSet.getString(2131695424);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842141);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842135);
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      paramAttributeSet.printStackTrace();
    }
    paramAttributeSet = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramAttributeSet.left = 12.0F;
    paramAttributeSet.top = 12.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      return;
    }
    this.jdField_b_of_type_Int = 100;
    this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread = new ChildLockCircle.AnimatedThread(this);
    ChildLockCircle.AnimatedThread localAnimatedThread = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread;
    localAnimatedThread.jdField_a_of_type_Boolean = true;
    localAnimatedThread.start();
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread;
    if (localObject != null)
    {
      ((ChildLockCircle.AnimatedThread)localObject).jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
  }
  
  private void e()
  {
    a(1);
  }
  
  private void f()
  {
    a(2);
  }
  
  private void g()
  {
    ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onAnimationFailed(getContext());
  }
  
  public void a()
  {
    if (((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).updateText(getContext()))
    {
      b(true);
      return;
    }
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).startChildLockAnimation();
    a();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130772202);
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    setVisibility(0);
    this.jdField_c_of_type_Int = 2;
    c();
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_c_of_type_Int = -1;
    }
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage, msg.what=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("ChildLockCircle", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i == 3) && (a())) {
            a(getContext());
          }
        }
        else {
          ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).handleAnimSuccessMsg(getContext());
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) {
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130772203);
        }
        paramMessage = this.jdField_b_of_type_AndroidViewAnimationAnimation;
        if (paramMessage != null)
        {
          this.jdField_c_of_type_Int = 3;
          paramMessage.setAnimationListener(this);
          startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        else
        {
          onAnimationEnd(paramMessage);
        }
      }
    }
    else {
      postInvalidate();
    }
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      setVisibility(8);
      if (QLog.isDevelopLevel()) {
        QLog.w("ChildLockCircle", 1, "timtest onAnimationEnd animation.equals(fadeoutAnimation)");
      }
      ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onAnimationEnd();
      this.jdField_c_of_type_Int = 0;
      new Handler().post(new ChildLockCircle.2(this));
      try
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled();
        }
        if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled();
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
        return;
      }
      catch (OutOfMemoryError paramAnimation)
      {
        paramAnimation.printStackTrace();
        return;
      }
    }
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation))
    {
      setVisibility(0);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_c_of_type_Int = 2;
        c();
        return;
      }
      g();
      e();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(8.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.jdField_b_of_type_Int / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    Object localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    localObject = this.jdField_e_of_type_JavaLangString;
    paramCanvas.drawText((String)localObject, (this.jdField_d_of_type_Int - this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject, 0, ((String)localObject).length())) / 2.0F, this.jdField_e_of_type_Int * 6 / 7, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    ((RectF)localObject).left = (paramInt1 * 18 / 65);
    ((RectF)localObject).top = (paramInt2 * 19 / 120);
    ((RectF)localObject).right = (paramInt1 * 47 / 65);
    ((RectF)localObject).bottom = (paramInt2 * 77 / 120);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[childLock] action : w = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  h = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" width = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      QLog.d("ChildLockCircle", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt1 / 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle
 * JD-Core Version:    0.7.0.1
 */