package com.tencent.av.widget;

import android.content.Context;
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
import android.view.View.OnClickListener;
import bdla;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lfe;

public class ChildLockSign
  extends View
  implements Handler.Callback, View.OnClickListener
{
  private final int jdField_a_of_type_Int = 8;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public Handler a;
  private ChildLockSign.ChangeSignThread jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread;
  private String jdField_a_of_type_JavaLangString = "ChildLockSign";
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Bitmap c;
  
  public ChildLockSign(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
    setOnClickListener(this);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread = new ChildLockSign.ChangeSignThread(this);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread.start();
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373480);
    paramAttributeSet = getResources();
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842110);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842111);
      if (this.jdField_a_of_type_Boolean) {}
      for (this.c = this.jdField_a_of_type_AndroidGraphicsBitmap;; this.c = this.jdField_b_of_type_AndroidGraphicsBitmap)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
        return;
      }
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    setVisibility(8);
    try
    {
      Object localObject = (AVActivity)getContext();
      paramMessage = ((AVActivity)localObject).a();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).a;
      if (!paramMessage.a().x)
      {
        paramMessage.a().y = true;
        ((DoubleVideoCtrlUI)localObject).d(true);
        bdla.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        setEnabled(true);
        return false;
        paramMessage.a().y = false;
        ((DoubleVideoCtrlUI)localObject).s();
        bdla.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      setEnabled(false);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(8.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    if ((this.c != null) && (!this.c.isRecycled())) {
      paramCanvas.drawBitmap(this.c, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = Math.min(paramInt1, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "ChildLock : w = " + paramInt1 + "  h = " + paramInt2 + " min = " + this.jdField_b_of_type_Int + "  " + this.jdField_b_of_type_Int / 6 + "  " + this.jdField_b_of_type_Int / 6 + "  " + this.jdField_b_of_type_Int * 5 / 6 + "  " + this.jdField_b_of_type_Int * 5 / 6);
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Int / 6, this.jdField_b_of_type_Int / 6, this.jdField_b_of_type_Int * 5 / 6, this.jdField_b_of_type_Int * 5 / 6);
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
    }
    this.c = this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign
 * JD-Core Version:    0.7.0.1
 */