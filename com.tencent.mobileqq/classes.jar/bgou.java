import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ar.controller.VipARCameraController.3;
import cooperation.vip.ar.controller.VipARCameraController.6;
import cooperation.vip.ar.controller.VipARCameraController.7;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class bgou
  extends bgpa
{
  private int jdField_a_of_type_Int;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new bgoy(this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bgox(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgpb jdField_a_of_type_Bgpb;
  private bgpe jdField_a_of_type_Bgpe;
  private bgpf jdField_a_of_type_Bgpf;
  private bgpm jdField_a_of_type_Bgpm = new bgov(this);
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int;
  private bgpm jdField_b_of_type_Bgpm = new bgow(this);
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g = true;
  private boolean h = true;
  private boolean i;
  private boolean j;
  
  static
  {
    System.loadLibrary("c++_shared");
  }
  
  @RequiresApi(8)
  public bgou(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
    {
      bgph.a().b(this.jdField_b_of_type_Bgpm);
      this.jdField_a_of_type_Bgpb = new bgpb(paramContext, paramViewGroup);
      return;
    }
  }
  
  private float[] a(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (this.jdField_a_of_type_Int == 0)
    {
      paramFloat1 /= this.jdField_b_of_type_Int;
      paramFloat1 = this.jdField_d_of_type_Int * paramFloat1;
      f1 = paramFloat2 / this.jdField_c_of_type_Int * this.jdField_e_of_type_Int;
      paramFloat2 = paramFloat1;
    }
    for (paramFloat1 = f1;; paramFloat1 = this.jdField_e_of_type_Int - paramFloat1 * f1)
    {
      return new float[] { paramFloat2, paramFloat1 };
      paramFloat1 /= this.jdField_b_of_type_Int;
      f1 = this.jdField_e_of_type_Int;
      paramFloat2 = paramFloat2 / this.jdField_c_of_type_Int * this.jdField_d_of_type_Int;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bgpe = new bgpe();
    this.jdField_a_of_type_Bgpe.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bgpe.a();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_Bgpe.b();
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new VipARCameraController.3(this));
  }
  
  private void h()
  {
    if (!this.i)
    {
      this.i = true;
      ThreadManagerV2.getUIHandlerV2().post(new VipARCameraController.6(this));
    }
  }
  
  private void i()
  {
    if (!this.j)
    {
      this.j = true;
      ThreadManagerV2.getUIHandlerV2().post(new VipARCameraController.7(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = ((GLSurfaceView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298291));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setEGLContextClientVersion(2);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setEGLContextFactory(new bgoz(this, null));
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderer(this);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setRenderMode(1);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setPreserveEGLContextOnPause(true);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311368));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Bgpf == null) {
      this.jdField_a_of_type_Bgpf = new bgpf();
    }
    this.jdField_a_of_type_Bgpf.jdField_a_of_type_Int = bajq.a();
    this.jdField_a_of_type_Bgpf.jdField_b_of_type_Int = bajq.b();
    this.jdField_a_of_type_Bgpf.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Bgpf.c = paramString2;
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.a(this.jdField_a_of_type_Bgpf);
    }
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.a();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.c();
    }
  }
  
  public void d()
  {
    super.d();
    QLog.d("VipARCameraController", 2, "onActivityResume " + this.jdField_c_of_type_Boolean);
    this.f = true;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.a();
    }
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.d();
    }
  }
  
  public void e()
  {
    super.e();
    QLog.d("VipARCameraController", 2, "onActivityStop " + this.jdField_c_of_type_Boolean);
    this.f = false;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.b();
    }
  }
  
  public void f()
  {
    super.f();
    QLog.d("VipARCameraController", 2, "onActivityDestroy " + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.c();
    }
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.f();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      float[] arrayOfFloat;
      do
      {
        do
        {
          return;
          h();
          if (this.jdField_a_of_type_Bgpe.a(this.jdField_a_of_type_AndroidViewSurfaceHolder, false) == 0) {
            break;
          }
        } while (this.jdField_a_of_type_Bgpb == null);
        this.jdField_a_of_type_Bgpb.onDrawFrame(null);
        return;
        if (this.h)
        {
          bgph.a("ar_tar_show", "1");
          this.h = false;
        }
        i();
        if (this.jdField_a_of_type_ArrayOfFloat == null) {
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
        }
        if (this.jdField_b_of_type_ArrayOfFloat == null) {
          this.jdField_b_of_type_ArrayOfFloat = new float[16];
        }
        if (this.jdField_c_of_type_ArrayOfFloat == null) {
          this.jdField_c_of_type_ArrayOfFloat = new float[16];
        }
        Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
        Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
        Matrix.setIdentityM(this.jdField_c_of_type_ArrayOfFloat, 0);
        arrayOfFloat = this.jdField_a_of_type_Bgpe.d();
      } while (arrayOfFloat == null);
      this.jdField_b_of_type_ArrayOfFloat[0] = arrayOfFloat[0];
      this.jdField_b_of_type_ArrayOfFloat[5] = arrayOfFloat[1];
      this.jdField_b_of_type_ArrayOfFloat[10] = arrayOfFloat[2];
      Matrix.scaleM(this.jdField_c_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Bgpe.a(), 0, 1.0F / arrayOfFloat[0], 1.0F / arrayOfFloat[1], 1.0F / arrayOfFloat[2]);
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Bgpe.b(), 0, this.jdField_c_of_type_ArrayOfFloat, 0);
    } while (this.jdField_a_of_type_Bgpb == null);
    this.jdField_a_of_type_Bgpb.a(this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Bgpe.c());
    this.jdField_a_of_type_Bgpb.onDrawFrame(paramGL10);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.d("VipARCameraController", 2, "onSurfaceChanged");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClearDepthf(1.0F);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(515);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.a(0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.d("VipARCameraController", 2, "onSurfaceCreated" + this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Bgpf.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Bgpe.d();
    }
    if (this.jdField_a_of_type_Bgpb != null) {
      this.jdField_a_of_type_Bgpb.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgou
 * JD-Core Version:    0.7.0.1
 */