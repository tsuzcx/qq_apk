package com.tencent.aelight.camera.aeeditor.view.timebar.scale;

import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.FrameSizeParam;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SecSizeParam;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SizeParam;
import java.util.ArrayList;
import java.util.List;

public class ScaleAdapter
{
  private float jdField_a_of_type_Float = 30.0F;
  private int jdField_a_of_type_Int = 30;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private Course jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleCourse = new Course();
  private SizeParam jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam;
  private ArrayList<SizeParam> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final List<Scaler> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 15;
  private long jdField_b_of_type_Long;
  
  public ScaleAdapter()
  {
    c();
  }
  
  private int a(float paramFloat)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam);
    int j = (int)(this.jdField_a_of_type_Float * paramFloat);
    if (paramFloat > 1.0F)
    {
      if (j >= this.jdField_a_of_type_Int)
      {
        i -= 1;
        if ((i >= 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          a((SizeParam)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          return 0;
        }
        return 1;
      }
      return 2;
    }
    if (paramFloat < 1.0F)
    {
      if (j <= this.jdField_b_of_type_Int)
      {
        i += 1;
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          a((SizeParam)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 1;
  }
  
  private void a(SizeParam paramSizeParam)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam = paramSizeParam;
    b();
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam;
    if (localObject != null)
    {
      int k = (int)((SizeParam)localObject).a(b() - a());
      int i = 0;
      while (i < k + 1)
      {
        localObject = new Scaler();
        int j;
        if (i % 2 == 0) {
          j = 0;
        } else {
          j = 1;
        }
        ((Scaler)localObject).b(j);
        ((Scaler)localObject).a(i);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        i += 1;
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float *= paramFloat;
  }
  
  private void c()
  {
    Object localObject = new FrameSizeParam(1.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new FrameSizeParam(1.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new FrameSizeParam(2.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new FrameSizeParam(5.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new FrameSizeParam(7.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new SecSizeParam(0.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new SecSizeParam(1.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new SecSizeParam(1.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new SecSizeParam(2.5F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new SecSizeParam(5.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam = ((SizeParam)this.jdField_a_of_type_JavaUtilArrayList.get(6));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(long paramLong)
  {
    SizeParam localSizeParam = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam;
    if (localSizeParam != null) {
      return localSizeParam.a(paramLong);
    }
    return 0.0F;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    return (int)(this.jdField_a_of_type_Float * this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(paramLong));
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(float paramFloat)
  {
    paramFloat /= this.jdField_a_of_type_Float;
    return a() + this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(paramFloat);
  }
  
  public long a(Scaler paramScaler)
  {
    if (paramScaler == null) {
      return -1L;
    }
    try
    {
      long l1 = a();
      long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(paramScaler.a());
      return l2 + l1;
    }
    catch (IllegalArgumentException paramScaler)
    {
      paramScaler.printStackTrace();
    }
    return -1L;
  }
  
  public String a(Scaler paramScaler)
  {
    if (paramScaler == null) {
      return null;
    }
    try
    {
      long l1 = a();
      long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(paramScaler.a());
      paramScaler = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(l1 + l2);
      return paramScaler;
    }
    catch (IllegalArgumentException paramScaler)
    {
      paramScaler.printStackTrace();
    }
    return null;
  }
  
  public List<Scaler> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      Course localCourse = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleCourse;
      float f2 = this.jdField_a_of_type_Float;
      float f1 = 0.0F;
      if (f2 > 0.0F) {
        f1 = localView.getScrollX() / this.jdField_a_of_type_Float;
      }
      localCourse.a(f1);
    }
  }
  
  public void a(float paramFloat)
  {
    long l = c();
    int i = a(paramFloat);
    if (i != 1)
    {
      if (i == 0)
      {
        if (paramFloat > 1.0F) {
          this.jdField_a_of_type_Float = b();
        } else {
          this.jdField_a_of_type_Float = a();
        }
      }
      else {
        b(paramFloat);
      }
      this.jdField_a_of_type_AndroidViewView.invalidate();
      i = a(l);
      this.jdField_a_of_type_AndroidViewView.scrollTo(i, 0);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam != null) {
      this.jdField_b_of_type_Long = paramLong;
    }
    b();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long b(float paramFloat)
  {
    if ((int)(a() * a(b())) <= paramFloat) {
      return b();
    }
    paramFloat /= this.jdField_a_of_type_Float;
    return a() + this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public long c()
  {
    return a() + this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleCourse.a());
  }
  
  public void c(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleSizeSizeParam = ((SizeParam)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter
 * JD-Core Version:    0.7.0.1
 */