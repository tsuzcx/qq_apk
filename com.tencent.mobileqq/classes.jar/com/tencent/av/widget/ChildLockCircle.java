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
import bdll;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import lbj;
import lff;
import mbb;
import mvy;

public class ChildLockCircle
  extends View
  implements Handler.Callback, Animation.AnimationListener
{
  private final int jdField_a_of_type_Int = 8;
  private final long jdField_a_of_type_Long = 300L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  public Handler a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ChildLockCircle.AnimatedThread jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int = 100;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  
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
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373348);
    setBackgroundResource(2130842053);
    paramAttributeSet = getResources();
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(2131694818);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(2131694819);
    this.jdField_c_of_type_JavaLangString = paramAttributeSet.getString(2131694816);
    this.jdField_d_of_type_JavaLangString = paramAttributeSet.getString(2131694817);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842044);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842038);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 12.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 12.0F;
      this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      return;
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread = new ChildLockCircle.AnimatedThread(this);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread.start();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread != null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimatedThread = null;
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
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
    try
    {
      if (!((AVActivity)getContext()).a().a().x)
      {
        bdll.b(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
        return;
      }
      bdll.b(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      lbj.e("ChildLockCircle", localException.getMessage());
    }
  }
  
  public Bitmap a(Resources paramResources, int paramInt)
  {
    int j = 2130842044;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return BitmapFactory.decodeResource(paramResources, i);
      i = 2130842038;
      continue;
      i = 2130842045;
      continue;
      i = 2130842046;
      continue;
      i = 2130842047;
      continue;
      i = 2130842048;
      continue;
      i = 2130842049;
      continue;
      i = 2130842050;
      continue;
      i = 2130842051;
      continue;
      i = 2130842052;
      continue;
      i = 2130842039;
      continue;
      i = 2130842040;
      continue;
      i = 2130842041;
      continue;
      i = 2130842042;
      continue;
      i = 2130842043;
    }
  }
  
  public void a()
  {
    if (!((AVActivity)getContext()).a().a().x)
    {
      setIsLock(true);
      return;
    }
    setIsLock(false);
  }
  
  public void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(Context paramContext)
  {
    VideoController localVideoController = ((AVActivity)getContext()).a();
    if (localVideoController != null)
    {
      localVideoController.a().t = 1;
      if (this.jdField_a_of_type_AndroidOsCountDownTimer == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer start");
        }
        this.jdField_a_of_type_AndroidOsCountDownTimer = new mvy(this, 750L, 50L, paramContext);
        this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    mbb.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    a();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130772151);
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    setVisibility(0);
    this.jdField_d_of_type_Int = 2;
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Int == 1) {
      this.jdField_d_of_type_Int = -1;
    }
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        return false;
        postInvalidate();
        return false;
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) {
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2130772152);
        }
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null)
        {
          this.jdField_d_of_type_Int = 3;
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          return false;
        }
        onAnimationEnd(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return false;
      } while (!a());
      a(getContext());
      return false;
    }
    try
    {
      Object localObject = (AVActivity)getContext();
      paramMessage = ((AVActivity)localObject).a();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).a;
      if (!paramMessage.a().x)
      {
        paramMessage.a().y = true;
        ((DoubleVideoCtrlUI)localObject).d(true);
        paramMessage.a().t = 2;
        if (QLog.isColorLevel()) {
          QLog.e("ChildLockCircle", 2, "[childLock] action lock");
        }
        bdll.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return false;
      }
      paramMessage.a().y = false;
      ((DoubleVideoCtrlUI)localObject).s();
      if (QLog.isColorLevel()) {
        QLog.e("ChildLockCircle", 2, "[childLock] action unlock");
      }
      bdll.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return false;
    }
    catch (Exception paramMessage) {}
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
      paramAnimation = (AVActivity)getContext();
      mbb.b((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_d_of_type_Int = 0;
      new Handler().post(new ChildLockCircle.2(this));
    }
    while (!paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
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
    setVisibility(0);
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_d_of_type_Int = 2;
      c();
      return;
    }
    g();
    e();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(8.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.jdField_c_of_type_Int / 100.0F), false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(this.jdField_e_of_type_JavaLangString, (this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_e_of_type_JavaLangString, 0, this.jdField_e_of_type_JavaLangString.length())) / 2.0F, this.f * 6 / 7, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (paramInt1 * 18 / 65);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (paramInt2 * 19 / 120);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramInt1 * 47 / 65);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt2 * 77 / 120);
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildLockCircle", 1, "[childLock] action : w = " + paramInt1 + "  h = " + paramInt2 + " width = " + this.jdField_e_of_type_Int);
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt1 / 8);
  }
  
  public void setIsLock(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      return;
    }
    this.jdField_c_of_type_Int = 100;
    this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle
 * JD-Core Version:    0.7.0.1
 */