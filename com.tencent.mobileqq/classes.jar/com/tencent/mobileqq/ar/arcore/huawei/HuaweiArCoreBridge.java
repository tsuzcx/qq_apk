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
  public static final float[] a = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private DisplayRotationHelper b;
  private int c = 30;
  private int d = -1;
  private int e = 36197;
  private FloatBuffer f;
  
  public Size a()
  {
    return null;
  }
  
  public FloatBuffer a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return this.f;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      this.b = new DisplayRotationHelper(BaseApplicationImpl.getContext());
    }
    this.b.a(paramInt1, paramInt2);
  }
  
  public boolean a(Context paramContext)
  {
    return paramContext != null;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onDestory");
  }
  
  public void d()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onPause");
  }
  
  public void e()
  {
    QLog.d("HuaweiArCoreBridge", 2, "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.huawei.HuaweiArCoreBridge
 * JD-Core Version:    0.7.0.1
 */