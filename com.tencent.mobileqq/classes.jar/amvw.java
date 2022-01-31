import android.content.Context;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable.1;
import com.tencent.qphone.base.util.QLog;

public class amvw
  implements amvh, ARNativeBridge.ActionCallback
{
  private volatile int jdField_a_of_type_Int = 1;
  private amsu jdField_a_of_type_Amsu;
  private amvj jdField_a_of_type_Amvj;
  private amvx jdField_a_of_type_Amvx;
  private Context jdField_a_of_type_AndroidContentContext;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  public boolean a;
  private int b;
  private volatile int c = 1;
  private int d;
  private int e;
  
  public amvw(amvj paramamvj, amvx paramamvx)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Amvj = paramamvj;
    this.jdField_a_of_type_Amvx = paramamvx;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Amvj.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.jdField_a_of_type_Amvj.a(paramamvx.jdField_a_of_type_Int));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "setState, mCurState=" + this.jdField_a_of_type_Int + ", new State=" + paramInt + ", arTarget=");
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 11: 
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngine(this.jdField_b_of_type_Int, this.jdField_a_of_type_Amvx.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_Amvx.c, this.d, this.e);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(this);
      a(7);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeonSurfaceChanged(this.jdField_b_of_type_Int, this.d, this.e);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.jdField_b_of_type_Int);
      this.c = 0;
      a(11);
      return;
    case 9: 
      this.jdField_a_of_type_Amvj.a(new GeneralAR3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Amsu != null)
    {
      this.jdField_a_of_type_Amsu.b();
      this.jdField_a_of_type_Amsu.c();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(amvp paramamvp)
  {
    a((float[])paramamvp.a("TARGET_SIZE"), (float[])paramamvp.a("POSE"), (float[])paramamvp.a("CAMERA_MATRIX"), (float[])paramamvp.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.jdField_a_of_type_Amvx != null) && (this.jdField_a_of_type_Amvx.jdField_b_of_type_Int == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat3, paramArrayOfFloat4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Amvx != null) {
      return this.jdField_a_of_type_Amvx.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Amvx != null) {
      return this.jdField_a_of_type_Amvx.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Amvx.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "init");
    }
  }
  
  public void callback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    if (this.jdField_a_of_type_Amvj == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Amvj.b(3, 0);
      return;
    }
    this.jdField_a_of_type_Amvj.b(2, 0);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Amsu = new amsu(this.jdField_a_of_type_Amvx.d, "");
      a(2);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 9) && (this.jdField_b_of_type_Int != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 11)
    {
      int i = this.c + 1;
      this.c = i;
      if (i >= 2) {
        a(9);
      }
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, " + this);
    }
    if (this.jdField_a_of_type_Int == 9)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, queueEvent, " + this);
      }
      if ((this.jdField_a_of_type_Amvj != null) && (this.jdField_a_of_type_Boolean == true))
      {
        this.jdField_a_of_type_Amvj.b(1, 0);
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Amvj != null)
      {
        this.jdField_a_of_type_Amvj.a(this.jdField_a_of_type_Amvx.jdField_a_of_type_JavaLangString);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
      }
      if (this.jdField_a_of_type_Int == 9) {
        a(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvw
 * JD-Core Version:    0.7.0.1
 */