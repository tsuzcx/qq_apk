package com.tencent.mobileqq.activity.richmedia.view;

import ajst;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bdkf;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SensorFrameImageView
  extends URLImageView
  implements Handler.Callback
{
  private static final int g = bdkf.b(5.0F);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener = new ajst(this);
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private int jdField_b_of_type_Int;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[3];
  private int jdField_c_of_type_Int = 0;
  private Sensor jdField_c_of_type_AndroidHardwareSensor;
  private float[] jdField_c_of_type_ArrayOfFloat = new float[3];
  private int d = -1;
  private int e;
  private int f;
  
  public SensorFrameImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SensorFrameImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SensorFrameImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      QLog.d("SensorFrameImageView", 2, "path =" + (String)localObject);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1) {
        break label111;
      }
      setImageDrawable((Drawable)localObject);
      this.d = paramInt;
    }
    label111:
    while (this.jdField_c_of_type_Int != 0) {
      return;
    }
    setDecodingDrawable((URLDrawable)localObject);
    ((URLDrawable)localObject).startDownload();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.e > 0) && (paramInt1 >= 0) && (paramInt1 < this.e))
    {
      this.jdField_c_of_type_Int = paramInt2;
      switch (paramInt2)
      {
      default: 
        return;
      case 1: 
        paramInt3 = paramInt1 + paramInt3;
        paramInt2 = paramInt3;
        if (paramInt3 > this.e) {
          paramInt2 = this.e;
        }
        paramInt3 = paramInt1;
        while (paramInt3 < paramInt2)
        {
          b(paramInt3);
          paramInt3 += 1;
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = (paramInt2 - 1);
        e();
        return;
      }
      paramInt3 = paramInt1 - paramInt3;
      paramInt2 = paramInt3;
      if (paramInt3 < 0) {
        paramInt2 = 0;
      }
      paramInt3 = paramInt1;
      while (paramInt3 > paramInt2)
      {
        b(paramInt3);
        paramInt3 -= 1;
      }
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_b_of_type_Int = paramInt1;
      e();
      return;
    }
    QLog.d("SensorFrameImageView", 2, "onIndexChanged miss index=" + paramInt1);
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0))
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      QLog.d("SensorFrameImageView", 2, "path =" + (String)localObject);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).startDownload();
      }
    }
  }
  
  private void c()
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = new float[9];
    SensorManager.getRotationMatrix(arrayOfFloat2, null, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    SensorManager.getOrientation(arrayOfFloat2, arrayOfFloat1);
    this.f = Math.abs((int)Math.toDegrees(arrayOfFloat1[2]));
    if (this.f > 20) {
      this.f = 20;
    }
  }
  
  private void d()
  {
    float f1 = this.jdField_c_of_type_ArrayOfFloat[1] * 10.0F;
    int i;
    if (Math.abs(f1) >= 5.0F)
    {
      i = this.d;
      if (f1 <= 0.0F) {
        break label45;
      }
      a(i + 1, 1, (int)(f1 / 5.0F));
    }
    label45:
    while (f1 >= 0.0F) {
      return;
    }
    a(i - 1, 2, (int)(f1 * -1.0F / 5.0F));
  }
  
  private void e()
  {
    f();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  public void a()
  {
    if ((getContext() == null) && (this.e <= 0)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
          this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getContext().getSystemService("sensor"));
        }
        if ((this.jdField_a_of_type_AndroidHardwareSensor == null) && (this.jdField_a_of_type_AndroidHardwareSensorManager != null)) {
          this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
        }
        if ((this.jdField_b_of_type_AndroidHardwareSensor == null) && (this.jdField_a_of_type_AndroidHardwareSensorManager != null)) {
          this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(2);
        }
        if ((this.jdField_c_of_type_AndroidHardwareSensor == null) && (this.jdField_a_of_type_AndroidHardwareSensorManager != null)) {
          this.jdField_c_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
        }
      } while (this.jdField_a_of_type_AndroidHardwareSensorManager == null);
      QLog.d("SensorFrameImageView", 2, "register sensor event Listener");
      if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 3);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 3);
      }
    } while (this.jdField_c_of_type_AndroidHardwareSensor == null);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_c_of_type_AndroidHardwareSensor, 3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      QLog.d("SensorFrameImageView", 2, "unregister sensor event Listener");
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
      {
        if (this.jdField_c_of_type_Int == 0) {
          a(this.jdField_a_of_type_Int);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) {
            break label148;
          }
          f();
          break;
          int i;
          if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int))
          {
            i = this.jdField_a_of_type_Int + 1;
            this.jdField_a_of_type_Int = i;
            a(i);
          }
          else if ((this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int))
          {
            i = this.jdField_b_of_type_Int - 1;
            this.jdField_b_of_type_Int = i;
            a(i);
          }
        }
        label148:
        e();
      }
      else
      {
        f();
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
      {
        this.jdField_a_of_type_Boolean = true;
        setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    float f2;
    do
    {
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Float = f1;
      }
      f2 = f1 - this.jdField_a_of_type_Float;
    } while (Math.abs(f2) < g);
    this.jdField_a_of_type_Float = f1;
    int j = this.d;
    int i;
    if ((f2 > 0.0F) && (j > 0)) {
      i = j - 1;
    }
    for (;;)
    {
      QLog.d("SensorFrameImageView", 2, "onTouchEvent index=" + i);
      break;
      i = j;
      if (f2 < 0.0F)
      {
        i = j;
        if (j < this.e - 1) {
          i = j + 1;
        }
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setDecodingDrawable(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  public void setImagePathList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.e = paramList.size();
      this.d = (this.e / 2);
      a(this.d);
      a();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.e = 0;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.SensorFrameImageView
 * JD-Core Version:    0.7.0.1
 */