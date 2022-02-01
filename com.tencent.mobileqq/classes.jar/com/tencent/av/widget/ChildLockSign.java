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
import com.tencent.av.widget.api.IChildLockSignApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ChildLockSign
  extends View
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChildLockSign.ChangeSignThread jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread = null;
  private boolean jdField_a_of_type_Boolean = true;
  private Bitmap b;
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
    new ChildLockSign(paramContext);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread = new ChildLockSign.ChangeSignThread(this);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockSign$ChangeSignThread.start();
  }
  
  private void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373366);
    paramAttributeSet = getResources();
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramAttributeSet, 2130842151);
      this.b = BitmapFactory.decodeResource(paramAttributeSet, 2130842152);
      if (this.jdField_a_of_type_Boolean) {
        this.c = this.jdField_a_of_type_AndroidGraphicsBitmap;
      } else {
        this.c = this.b;
      }
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      paramAttributeSet.printStackTrace();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      setVisibility(8);
      ((IChildLockSignApi)QRoute.api(IChildLockSignApi.class)).handleSuccessMsg(getContext());
      setEnabled(true);
    }
    return false;
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
    Bitmap localBitmap = this.c;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.c, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = Math.min(paramInt1, paramInt2);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChildLock : w = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  h = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" min = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int * 5 / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int * 5 / 6);
      QLog.d("ChildLockSign", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramInt1 = this.jdField_a_of_type_Int;
    ((RectF)localObject).set(paramInt1 / 6, paramInt1 / 6, paramInt1 * 5 / 6, paramInt1 * 5 / 6);
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
    }
    this.c = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign
 * JD-Core Version:    0.7.0.1
 */