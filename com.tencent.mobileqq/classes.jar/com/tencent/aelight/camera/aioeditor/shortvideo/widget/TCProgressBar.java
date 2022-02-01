package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TCProgressBar
  extends View
{
  float jdField_a_of_type_Float;
  public int a;
  long jdField_a_of_type_Long;
  public Bitmap a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  TouchDelegate jdField_a_of_type_AndroidViewTouchDelegate = new TouchDelegate(this.jdField_a_of_type_AndroidGraphicsRect, this);
  TCProgressBar.BlinkBlock jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock = new TCProgressBar.BlinkBlock(this);
  public TCProgressBar.DelEvent a;
  TCProgressBar.DeleteImage jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage = new TCProgressBar.DeleteImage(this);
  TCProgressBar.ProgressBlock jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock = new TCProgressBar.ProgressBlock(this, true);
  ArrayList<TCProgressBar.ProgressBlock> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  boolean jdField_a_of_type_Boolean;
  public int b;
  public Bitmap b;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  ArrayList<TCProgressBar.ProgressBlock> jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  int d = 1000;
  public int e;
  int f;
  int g;
  int h = -14408659;
  int i = -16737062;
  int j = -65536;
  int k = -15000805;
  int l = ScreenUtil.dip2px(1.0F);
  int m = -1;
  int n = ScreenUtil.dip2px(5.0F);
  int o = 0;
  
  public TCProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DelEvent = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 1310991405;
    this.jdField_a_of_type_Int = 3;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130846195);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130846194);
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      this.jdField_e_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TCProgressBar.TimerRefresh(this), this.d);
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_b_of_type_Int;
    if (paramInt1 == i1) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / i1;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  void a()
  {
    int i7 = super.getWidth();
    int i6 = this.jdField_e_of_type_Int - 3;
    int i4 = i7 - i6;
    int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    int i2;
    Object localObject;
    for (;;)
    {
      i2 = i5 - 1;
      if (i1 >= i2) {
        break;
      }
      localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (((TCProgressBar.ProgressBlock)localObject).d)
      {
        ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_c_of_type_Int - ((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
        ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
        ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    int i8 = this.jdField_b_of_type_JavaUtilArrayList.size();
    i1 = 0;
    while (i1 < i8)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((TCProgressBar.ProgressBlock)localObject).d)
      {
        ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_c_of_type_Int - ((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
        ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
        ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    if (i5 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Boolean = true;
      ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Boolean = false;
      if (!((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Boolean)
      {
        i1 = this.jdField_c_of_type_Int;
        ((TCProgressBar.ProgressBlock)localObject).jdField_c_of_type_Int = i1;
        ((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int = (i1 - this.o);
      }
      if (((TCProgressBar.ProgressBlock)localObject).d)
      {
        ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_c_of_type_Int - ((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
        ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = a(((TCProgressBar.ProgressBlock)localObject).jdField_b_of_type_Int, i4);
      }
    }
    if (i5 <= 0)
    {
      i1 = i4;
      i2 = 0;
    }
    else
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      i1 = ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int;
      i2 = ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int + i1;
      i1 = i4 - i2;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock.d))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock;
      ((TCProgressBar.BlinkBlock)localObject).jdField_f_of_type_Int = i2;
      ((TCProgressBar.BlinkBlock)localObject).jdField_g_of_type_Int = this.n;
    }
    int i9 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a();
    int i3 = i5;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_e_of_type_Boolean)
    {
      i3 = i5;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.d)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage;
        ((TCProgressBar.DeleteImage)localObject).jdField_g_of_type_Int = this.jdField_e_of_type_Int;
        if (((TCProgressBar.DeleteImage)localObject).jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int = (i2 - 3);
        }
        else if ((i8 == 0) && (i9 > i2))
        {
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage;
          ((TCProgressBar.DeleteImage)localObject).jdField_f_of_type_Int = (i2 - 3);
          ((TCProgressBar.DeleteImage)localObject).jdField_a_of_type_Boolean = true;
          ((TCProgressBar.DeleteImage)localObject).jdField_c_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int < 0) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_c_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int + this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_g_of_type_Int + 1 >= i7)
        {
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage;
          ((TCProgressBar.DeleteImage)localObject).jdField_f_of_type_Int = (i7 - ((TCProgressBar.DeleteImage)localObject).jdField_g_of_type_Int);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout:delete.requestLayout");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_c_of_type_Boolean);
          QLog.d("TCProgressBar", 2, ((StringBuilder)localObject).toString());
        }
        i3 = i5;
        if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_c_of_type_Boolean)
        {
          i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
          if (i5 > 0)
          {
            localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
            ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Boolean = false;
            if (((TCProgressBar.ProgressBlock)localObject).a(i9))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
              }
              ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int + 3);
              ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Boolean = true;
            }
          }
          i3 = i5;
          if (i8 > 0)
          {
            localObject = (TCProgressBar.ProgressBlock)this.jdField_b_of_type_JavaUtilArrayList.get(i8 - 1);
            i3 = i5;
            if (((TCProgressBar.ProgressBlock)localObject).a(i9))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
              }
              ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_f_of_type_Int + 3);
              ((TCProgressBar.ProgressBlock)localObject).jdField_a_of_type_Boolean = true;
              i3 = i5;
            }
          }
        }
      }
    }
    if (i3 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i3 - 1);
      if (((TCProgressBar.ProgressBlock)localObject).h) {
        ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = (i4 - ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int);
      }
    }
    if (i8 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      if (((TCProgressBar.ProgressBlock)localObject).h) {
        ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = (i7 - ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int);
      }
      i2 = ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int + ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int;
      i1 = i4 - i2;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock.d)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock;
      ((TCProgressBar.ProgressBlock)localObject).jdField_f_of_type_Int = i2;
      ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int = i1;
      if (((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int <= 1)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock.jdField_e_of_type_Boolean = false;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock;
      ((TCProgressBar.ProgressBlock)localObject).jdField_e_of_type_Boolean = true;
      ((TCProgressBar.ProgressBlock)localObject).jdField_g_of_type_Int += i6;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    int i4 = super.getWidth();
    int i1 = super.getHeight();
    int i5 = i1 / 7;
    int i3 = i5 * 3;
    a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_e_of_type_Int = i1;
    Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    int i2 = 0;
    ((Rect)localObject).left = 0;
    ((Rect)localObject).right = i4;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = i3;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    i4 = i5 + i3;
    ((Rect)localObject).top = i4;
    ((Rect)localObject).bottom = i1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).top = i3;
    ((Rect)localObject).bottom = i4;
    i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    i1 = 0;
    while (i1 < i3)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((((TCProgressBar.ProgressBlock)localObject).d) && (((TCProgressBar.ProgressBlock)localObject).jdField_e_of_type_Boolean)) {
        ((TCProgressBar.ProgressBlock)localObject).a(paramCanvas);
      }
      i1 += 1;
    }
    i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
    i1 = i2;
    while (i1 < i3)
    {
      localObject = (TCProgressBar.ProgressBlock)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if ((((TCProgressBar.ProgressBlock)localObject).d) && (((TCProgressBar.ProgressBlock)localObject).jdField_e_of_type_Boolean)) {
        ((TCProgressBar.ProgressBlock)localObject).a(paramCanvas);
      }
      i1 += 1;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock.d) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$ProgressBlock.a(paramCanvas);
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock.d) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$BlinkBlock.a(paramCanvas);
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.d) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.top + 25) || (paramInt3 != this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramInt4 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - 25))
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.left = paramInt1;
      localRect.right = paramInt3;
      localRect.top = (paramInt2 - 25);
      localRect.bottom = (paramInt4 + 25);
      ((View)getParent()).setTouchDelegate(this.jdField_a_of_type_AndroidViewTouchDelegate);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    StringBuilder localStringBuilder;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3) {
            return true;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_CANCEL count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(paramMotionEvent);
            invalidate();
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("[@] [...]delete.enabled=");
              paramMotionEvent.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_e_of_type_Boolean);
              paramMotionEvent.append("delete.changed=");
              paramMotionEvent.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.d);
              QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
            }
            i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
            if (this.jdField_f_of_type_Int - i1 > 0) {
              this.jdField_b_of_type_Boolean = true;
            }
            paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DelEvent;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.a(this.jdField_b_of_type_Boolean);
              return true;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_MOVE count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_b_of_type_Boolean) {
            return true;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(paramMotionEvent);
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a())
          {
            i2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a();
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_c_of_type_Int < 0)
            {
              i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
              while (i1 >= 0)
              {
                paramMotionEvent = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
                if (!paramMotionEvent.b(i2)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                }
                this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
                paramMotionEvent.jdField_b_of_type_Boolean = true;
                this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                i1 -= 1;
              }
            }
            i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
            while (i1 >= 0)
            {
              paramMotionEvent = (TCProgressBar.ProgressBlock)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
              if (!paramMotionEvent.c(i2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
              }
              this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
              paramMotionEvent.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramMotionEvent);
              i1 -= 1;
            }
            invalidate();
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouchEvent:action=ACTION_UP count=");
          localStringBuilder.append(i1);
          localStringBuilder.append(" X=");
          localStringBuilder.append(f1);
          QLog.d("TCProgressBar", 2, localStringBuilder.toString());
        }
        if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_b_of_type_Boolean) {
          return true;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(paramMotionEvent);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(f1))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_UP[checkBounds:true] count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 400L) && (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) < 25.0F))
          {
            i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
            if (i1 > 0)
            {
              paramMotionEvent = (TCProgressBar.ProgressBlock)this.jdField_a_of_type_JavaUtilArrayList.remove(i1 - 1);
              paramMotionEvent.jdField_b_of_type_Boolean = true;
              this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
              if (QLog.isColorLevel())
              {
                paramMotionEvent = new StringBuilder();
                paramMotionEvent.append("onTouchEvent:action=ACTION_UP progress:[size]=");
                paramMotionEvent.append(this.jdField_a_of_type_JavaUtilArrayList.size());
                paramMotionEvent.append(" deletedList[size]=");
                paramMotionEvent.append(this.jdField_b_of_type_JavaUtilArrayList.size());
                QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
              }
            }
          }
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_a_of_type_Boolean = false;
        } else {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_a_of_type_Boolean = true;
        }
        invalidate();
        if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("[@] [...]delete.enabled=");
          paramMotionEvent.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.jdField_e_of_type_Boolean);
          paramMotionEvent.append("delete.changed=");
          paramMotionEvent.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.d);
          QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
        }
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (this.jdField_f_of_type_Int - i1 > 0) {
          this.jdField_b_of_type_Boolean = true;
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DelEvent;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(this.jdField_b_of_type_Boolean);
          return true;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTouchEvent:action=ACTION_DOWN count=");
        localStringBuilder.append(i1);
        localStringBuilder.append(" X=");
        localStringBuilder.append(f1);
        QLog.d("TCProgressBar", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_f_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(f1)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar$DeleteImage.a(paramMotionEvent);
      }
    }
    return true;
  }
  
  public void setMax(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProgress, progress = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isOver = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("TCProgressBar", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = paramInt;
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar
 * JD-Core Version:    0.7.0.1
 */