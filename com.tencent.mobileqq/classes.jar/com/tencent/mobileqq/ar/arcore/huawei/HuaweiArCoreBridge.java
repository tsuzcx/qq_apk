package com.tencent.mobileqq.ar.arcore.huawei;

import android.content.Context;
import android.util.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arcore.DisplayRotationHelper;
import com.tencent.mobileqq.ar.arcore.IARCoreBridge;
import com.tencent.qphone.base.util.QLog;
import java.nio.FloatBuffer;

public class HuaweiArCoreBridge
  implements IARCoreBridge
{
  public static final float[] a;
  private int jdField_a_of_type_Int = 30;
  private DisplayRotationHelper jdField_a_of_type_ComTencentMobileqqArArcoreDisplayRotationHelper;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private int b = -1;
  private int c = 36197;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  public Size a()
  {
    return null;
  }
  
  public FloatBuffer a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return this.jdField_a_of_type_JavaNioFloatBuffer;
  }
  
  public void a()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onDestory");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArcoreDisplayRotationHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArcoreDisplayRotationHelper = new DisplayRotationHelper(BaseApplicationImpl.getContext());
    }
    this.jdField_a_of_type_ComTencentMobileqqArArcoreDisplayRotationHelper.a(paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Context paramContext)
  {
    return paramContext != null;
  }
  
  public void b()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onPause");
  }
  
  public void c()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.huawei.HuaweiArCoreBridge
 * JD-Core Version:    0.7.0.1
 */