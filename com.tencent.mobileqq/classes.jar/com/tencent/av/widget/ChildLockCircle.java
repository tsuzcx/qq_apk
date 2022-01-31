package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import kil;

public class ChildLockCircle
  extends View
  implements Handler.Callback, Animation.AnimationListener
{
  private final int jdField_a_of_type_Int = 8;
  private final long jdField_a_of_type_Long = 300L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public Handler a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private String jdField_a_of_type_JavaLangString;
  private kil jdField_a_of_type_Kil;
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
    setId(2131362512);
    setBackgroundResource(2130840174);
    paramAttributeSet = getResources();
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(2131429436);
    this.jdField_b_of_type_JavaLangString = paramAttributeSet.getString(2131429437);
    this.jdField_c_of_type_JavaLangString = paramAttributeSet.getString(2131429438);
    this.jdField_d_of_type_JavaLangString = paramAttributeSet.getString(2131429439);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130840175);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130840176);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 22.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 22.0F;
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
    this.jdField_a_of_type_Kil = new kil(this);
    this.jdField_a_of_type_Kil.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Kil.start();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Kil != null)
    {
      this.jdField_a_of_type_Kil.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Kil = null;
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
      if (!((AVActivity)getContext()).a().a().u)
      {
        ReportController.b(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("ChildLockCircle", localException.getMessage());
    }
  }
  
  public void a()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    TipsManager localTipsManager = localAVActivity.a();
    if (localTipsManager != null) {
      localTipsManager.a();
    }
    if (!localAVActivity.a().a().u) {
      setIsLock(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2131034251);
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
        break;
      }
      this.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      setVisibility(4);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
      setIsLock(false);
    }
    onAnimationEnd(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
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
      return false;
    case 0: 
      postInvalidate();
      return false;
    case 1: 
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getContext(), 2131034252);
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
    }
    try
    {
      Object localObject = (AVActivity)getContext();
      paramMessage = ((AVActivity)localObject).a();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).a;
      if (!paramMessage.a().u)
      {
        paramMessage.a().v = true;
        ((DoubleVideoCtrlUI)localObject).h(true);
        if (QLog.isColorLevel()) {
          QLog.e("ChildLockCircle", 2, "[childLock] action lock");
        }
        ReportController.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return false;
      }
      paramMessage.a().v = false;
      ((DoubleVideoCtrlUI)localObject).A();
      if (QLog.isColorLevel()) {
        QLog.e("ChildLockCircle", 2, "[childLock] action unlock");
      }
      ReportController.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
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
      paramAnimation = ((AVActivity)getContext()).a();
      if (paramAnimation != null) {
        paramAnimation.b();
      }
      this.jdField_d_of_type_Int = 0;
      paramAnimation = (ViewGroup)getParent();
      if (paramAnimation != null) {
        paramAnimation.removeView(this);
      }
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(50);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.jdField_c_of_type_Int / 100.0F), false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(this.jdField_e_of_type_JavaLangString, (this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_e_of_type_JavaLangString, 0, this.jdField_e_of_type_JavaLangString.length())) / 2.0F, this.jdField_e_of_type_Int * 17 / 24, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_e_of_type_Int = Math.min(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRectF.left);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRectF.left);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_e_of_type_Int / 3, this.jdField_e_of_type_Int / 4, this.jdField_e_of_type_Int * 2 / 3, this.jdField_e_of_type_Int * 7 / 12);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_e_of_type_Int / 12);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle
 * JD-Core Version:    0.7.0.1
 */