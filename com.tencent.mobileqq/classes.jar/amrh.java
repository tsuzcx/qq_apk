import android.content.Context;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable.1;
import com.tencent.qphone.base.util.QLog;

public class amrh
  implements amqs, ARNativeBridge.ActionCallback
{
  private volatile int jdField_a_of_type_Int = 1;
  private amof jdField_a_of_type_Amof;
  private amqu jdField_a_of_type_Amqu;
  private amri jdField_a_of_type_Amri;
  private Context jdField_a_of_type_AndroidContentContext;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  public boolean a;
  private int b;
  private volatile int c = 1;
  private int d;
  private int e;
  
  public amrh(amqu paramamqu, amri paramamri)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Amqu = paramamqu;
    this.jdField_a_of_type_Amri = paramamri;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Amqu.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.jdField_a_of_type_Amqu.a(paramamri.jdField_a_of_type_Int));
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
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngine(this.jdField_b_of_type_Int, this.jdField_a_of_type_Amri.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_Amri.c, this.d, this.e);
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
      this.jdField_a_of_type_Amqu.a(new GeneralAR3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Amof != null)
    {
      this.jdField_a_of_type_Amof.b();
      this.jdField_a_of_type_Amof.c();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(amra paramamra)
  {
    a((float[])paramamra.a("TARGET_SIZE"), (float[])paramamra.a("POSE"), (float[])paramamra.a("CAMERA_MATRIX"), (float[])paramamra.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.jdField_a_of_type_Amri != null) && (this.jdField_a_of_type_Amri.jdField_b_of_type_Int == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat3, paramArrayOfFloat4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Amri != null) {
      return this.jdField_a_of_type_Amri.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Amri != null) {
      return this.jdField_a_of_type_Amri.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Amri.jdField_a_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Amqu == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Amqu.b(3, 0);
      return;
    }
    this.jdField_a_of_type_Amqu.b(2, 0);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Amof = new amof(this.jdField_a_of_type_Amri.d, "");
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
      if ((this.jdField_a_of_type_Amqu != null) && (this.jdField_a_of_type_Boolean == true))
      {
        this.jdField_a_of_type_Amqu.b(1, 0);
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Amqu != null)
      {
        this.jdField_a_of_type_Amqu.a(this.jdField_a_of_type_Amri.jdField_a_of_type_JavaLangString);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
      }
      if (this.jdField_a_of_type_Int == 9) {
        a(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrh
 * JD-Core Version:    0.7.0.1
 */