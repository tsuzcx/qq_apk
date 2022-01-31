package com.tencent.mobileqq.apollo.ai;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.util.WeakReferenceHandler;

public class ApolloRecorderView
  extends ImageView
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ApolloRecorderView.OnRecordViewTouchListener jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ApolloRecorderView(Context paramContext, ApolloRecorderView.OnRecordViewTouchListener paramOnRecordViewTouchListener)
  {
    super(paramContext);
    a();
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener = paramOnRecordViewTouchListener;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    setState(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130838014);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    this.g = ViewConfiguration.getLongPressTimeout();
  }
  
  private void a()
  {
    this.c = -10400769;
    this.d = -11058203;
    this.e = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(3);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.b = AIOUtils.a(3.0F, super.getResources());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 19: 
    case 18: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Int != 3);
        VipUtils.a(null, "cmshow", "Apollo", "press_vocie", 1, 0, new String[0]);
        return false;
        setState(0);
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener.b();
      return false;
    case 15: 
      VipUtils.a(null, "cmshow", "Apollo", "press_vocie", 0, 0, new String[0]);
      setState(1);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener.a();
        paramMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(17, 0, 0);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramMessage, 60000L);
      }
      this.jdField_a_of_type_Boolean = true;
      return false;
    case 16: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener != null))
      {
        setState(3);
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener.a(false);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 9000L);
      }
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    int i = paramMessage.arg1;
    if (i == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      setState(2);
    }
    if (i > 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener.a(i);
      }
      paramMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(17, i - 1, 0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramMessage, 1000L);
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener != null))
    {
      setState(3);
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener.a(true);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 9000L);
    }
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = getWidth();
    int m = getHeight();
    int i = this.c;
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      i = this.d;
    }
    for (int j = 128;; j = 255)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      paramCanvas.drawArc(new RectF(0.0F, 0.0F, k, m), 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.save();
      paramCanvas.translate((k - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) / 2, (m - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()) / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      if (this.jdField_a_of_type_Int == 2)
      {
        this.f = ((int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 100.0F));
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
        paramCanvas.drawArc(new RectF(this.b / 2, this.b / 2, k - this.b / 2, m - this.b / 2), -90.0F, (float)(3.6D * this.f), false, this.jdField_a_of_type_AndroidGraphicsPaint);
        super.postInvalidate();
      }
      super.onDraw(paramCanvas);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView$OnRecordViewTouchListener == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(19, this.g);
      }
      else
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(15, 150L);
        continue;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 9000L);
      }
    }
  }
  
  public void setState(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.postInvalidate();
      return;
      super.setImageDrawable(null);
      continue;
      super.setImageDrawable(null);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      continue;
      super.setImageDrawable(null);
      continue;
      Drawable localDrawable = super.getResources().getDrawable(2130837975);
      super.setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ai.ApolloRecorderView
 * JD-Core Version:    0.7.0.1
 */