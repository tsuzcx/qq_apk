package com.tencent.mobileqq.apollo.touch;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class LightGameTouchManager
  implements ICMTouchManager
{
  private View jdField_a_of_type_AndroidViewView;
  private IRenderRunner jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner;
  private LightGameTouchManager.TouchEvent jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent = new LightGameTouchManager.TouchEvent();
  private ApolloRender jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender;
  private ApolloRenderDriver jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderDriver;
  
  public LightGameTouchManager(View paramView, IRenderRunner paramIRenderRunner, ApolloRender paramApolloRender, ApolloRenderDriver paramApolloRenderDriver)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner = paramIRenderRunner;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender = paramApolloRender;
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderDriver = paramApolloRenderDriver;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent != null)
    {
      int i = 0;
      while (i < 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i] = 0.0F;
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i] = 0.0F;
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] = 0;
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int >= 4) {
      return;
    }
    int i = paramMotionEvent.getAction();
    int j = 0;
    if ((i & 0xFF) == 5) {
      i = paramMotionEvent.getActionIndex();
    } else {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int] = paramMotionEvent.getX(i);
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int] = (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - paramMotionEvent.getY(i));
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int] = paramMotionEvent.getPointerId(i);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent;
    ((LightGameTouchManager.TouchEvent)localObject).jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int <= 0) {
      return;
    }
    localObject = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    float[] arrayOfFloat = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    int[] arrayOfInt1 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    int[] arrayOfInt2 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    i = j;
    while (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int)
    {
      localObject[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i];
      arrayOfFloat[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i];
      arrayOfInt1[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i];
      arrayOfInt2[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.runRenderTask(new LightGameTouchManager.1(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  private void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderDriver != null) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderDriver.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderDriver.a.execScriptString("mainTicker.paused = false;");
      }
      ApolloSurfaceView.nativeTouchInput(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.getSavaWrapper().mDirector, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      paramArrayOfFloat2 = new StringBuilder();
      paramArrayOfFloat2.append("send touch event err e=");
      paramArrayOfFloat2.append(paramArrayOfFloat1.toString());
      QLog.e("[cmshow][apollo]LightGameTouchManager", 1, paramArrayOfFloat2.toString());
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    try
    {
      i = paramMotionEvent.getAction();
      k = 0;
      if ((i & 0xFF) != 6) {
        break label528;
      }
      i = paramMotionEvent.getActionIndex();
      j = i;
      if ((paramMotionEvent.getAction() & 0xFF) != 1) {
        break label533;
      }
      j = -1;
    }
    catch (Throwable localThrowable)
    {
      int k;
      int j;
      label45:
      Object localObject;
      float[] arrayOfFloat;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      paramMotionEvent.recycle();
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("send touch event err e=");
      paramMotionEvent.append(localThrowable.toString());
      QLog.e("[cmshow][apollo]LightGameTouchManager", 1, paramMotionEvent.toString());
      return;
    }
    if (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int)
    {
      if (j == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] = 1;
        break label538;
      }
      if (paramMotionEvent.getPointerId(j) != this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i]) {
        break label538;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i] = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i]));
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i] = (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i])));
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int <= 0) {
      return;
    }
    localObject = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    arrayOfFloat = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    arrayOfInt1 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    arrayOfInt2 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int)
      {
        localObject[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i];
        arrayOfFloat[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i];
        arrayOfInt1[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i];
        arrayOfInt2[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i];
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.runRenderTask(new LightGameTouchManager.2(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
        i = k;
        if (j == -1)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int = 0;
          return;
        }
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] != 1) {
          break label545;
        }
        while (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int - 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat;
          arrayOfFloat = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat;
          j = i + 1;
          localObject[i] = arrayOfFloat[j];
          this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[j];
          this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[j];
          this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[j];
          i = j;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent;
        ((LightGameTouchManager.TouchEvent)localObject).jdField_a_of_type_Int -= 1;
      }
      paramMotionEvent.recycle();
      return;
      label528:
      i = 0;
      break;
      label533:
      i = 0;
      break label45;
      label538:
      i += 1;
      break label45;
      label545:
      i += 1;
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    while ((i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int) && (i <= paramMotionEvent.getPointerCount() - 1) && (i < 4))
    {
      int k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i]);
      if ((k > paramMotionEvent.getPointerCount() - 1) || (k < 0)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("move event index =");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(",event.count=");
        ((StringBuilder)localObject).append(paramMotionEvent.getPointerCount());
        QLog.d("[cmshow][apollo]LightGameTouchManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramMotionEvent.getX(k) != this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i]) || (paramMotionEvent.getY(k) != this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i]))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i] = paramMotionEvent.getX(k);
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i] = (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - paramMotionEvent.getY(k));
        this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i] = 3;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int <= 0) {
      return;
    }
    Object localObject = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    float[] arrayOfFloat = new float[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    int[] arrayOfInt1 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    int[] arrayOfInt2 = new int[this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int];
    i = j;
    while (i < this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int)
    {
      localObject[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfFloat[i];
      arrayOfFloat[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfFloat[i];
      arrayOfInt1[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_ArrayOfInt[i];
      arrayOfInt2[i] = this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner.runRenderTask(new LightGameTouchManager.3(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  public void a(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              if (i != 5)
              {
                if (i != 6) {
                  return true;
                }
              }
              else
              {
                a(MotionEvent.obtain(paramMotionEvent));
                return true;
              }
            }
          }
          else
          {
            if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
              this.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            c(MotionEvent.obtain(paramMotionEvent));
            return true;
          }
        }
        b(MotionEvent.obtain(paramMotionEvent));
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int >= 4)
      {
        QLog.e("[cmshow][apollo]LightGameTouchManager", 1, "touch down is over 4");
        return true;
      }
      a(MotionEvent.obtain(paramMotionEvent));
      return true;
    }
    catch (Throwable paramMotionEvent)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchLightGameTouchManager$TouchEvent.jdField_a_of_type_Int = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch event err e=");
      localStringBuilder.append(paramMotionEvent.toString());
      QLog.e("[cmshow][apollo]LightGameTouchManager", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.LightGameTouchManager
 * JD-Core Version:    0.7.0.1
 */