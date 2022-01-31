import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qg.sdk.QGRenderer.QGEventListener;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.controller.VipQGThreeController.1;
import cooperation.vip.ar.controller.VipQGThreeController.2;
import cooperation.vip.ar.controller.VipQGThreeController.3;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bhyp
  extends bhyo
  implements bhyg, QGRenderer.QGEventListener
{
  private volatile int jdField_a_of_type_Int = 1;
  private akzz jdField_a_of_type_Akzz;
  private bdtd jdField_a_of_type_Bdtd = new bhyq(this);
  private bhyr jdField_a_of_type_Bhyr;
  private bhyt jdField_a_of_type_Bhyt;
  private VipQGGLSurfaceView jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VipQGThreeController.3(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  public bhyp(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369013));
    }
    b();
  }
  
  private String a(float[] paramArrayOfFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuilder.append(paramArrayOfFloat[i]);
      if (i != paramArrayOfFloat.length - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Bhyt == null) || (!bdte.b.get()))
    {
      QZLog.i("VipARQGThreeController", 1, "checkInValid mVipQGViewConfig = " + this.jdField_a_of_type_Bhyt + " so status = " + bdte.b.get());
      return true;
    }
    return false;
  }
  
  private void b()
  {
    ThreadManager.executeOnFileThread(new VipQGThreeController.1(this));
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new VipQGThreeController.2(this));
  }
  
  public void a(bhyt parambhyt)
  {
    this.jdField_a_of_type_Bhyt = parambhyt;
    if ((this.jdField_a_of_type_Bhyt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bhyt.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipARQGThreeController", 2, " setVipQGViewConfig config = " + parambhyt.toString());
      }
      localObject = new amwq();
      ((amwq)localObject).b = parambhyt.jdField_a_of_type_JavaLangString;
      ((amwq)localObject).c = parambhyt.c;
      bhzb.a().a((amwq)localObject, this);
      return;
    }
    Object localObject = new StringBuilder().append("setVipQGViewConfig config = null or resUrl = null , config == null : ");
    if (parambhyt == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("VipARQGThreeController", 1, bool);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bhyt != null) {
      this.jdField_a_of_type_Bhyt.b = paramString;
    }
    QZLog.i("VipARQGThreeController", 1, "qg resources load success path = " + paramString + " soStatus = " + bdte.b.get());
  }
  
  public void a(String paramString, float[] paramArrayOfFloat)
  {
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge() == null) || (paramArrayOfFloat == null))
    {
      QZLog.e("VipARQGThreeController", 1, new Object[] { "dispatchQGJSEvent float[] error" });
      return;
    }
    this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge().dispatchJSEvent(paramString, paramArrayOfFloat);
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge() == null))
    {
      QZLog.e("VipARQGThreeController", 1, new Object[] { "dispatchQGJSEvent error" });
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("modelMatrix", a(paramArrayOfFloat1));
      localJSONObject.put("viewMatrix", a(paramArrayOfFloat2));
      localJSONObject.put("projectionMatrix", a(paramArrayOfFloat3));
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getQGBridge().dispatchJSEvent("onRenderFrame", localJSONObject);
      return;
    }
    catch (JSONException paramArrayOfFloat1)
    {
      for (;;)
      {
        paramArrayOfFloat1.printStackTrace();
      }
    }
  }
  
  public void b(String paramString)
  {
    QZLog.i("VipARQGThreeController", 1, "qg resources load fail error = " + paramString + " soStatus = " + bdte.b.get());
    if (this.jdField_a_of_type_Bhyt != null) {
      this.jdField_a_of_type_Bhyt.b = "";
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.onPause();
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.onResume();
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null) && (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getModuleEngine() != null))
    {
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Bhyr);
      this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.b();
    }
    if (this.jdField_a_of_type_Akzz != null) {
      this.jdField_a_of_type_Akzz.c();
    }
  }
  
  public void onCanvasCreated()
  {
    QZLog.i("VipARQGThreeController", 1, "qg view onCanvasCreated");
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDrawFrame()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!bdte.b.get());
              QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status SO_LOAD success next status CREATE_QGVIEW" });
              this.jdField_a_of_type_Int = 2;
              return;
            } while (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView != null);
            a();
            this.jdField_a_of_type_Int = 5;
            return;
          } while ((this.jdField_a_of_type_Bhyt == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bhyt.b)) || (this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null));
          QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status JS_MODEL_LOAD success next status DRAW_FRAME mIsQGReady = " + this.jdField_b_of_type_Boolean + " mIsQGStartDraw = " + this.jdField_a_of_type_Boolean });
        } while (!this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.queueEvent(this.jdField_a_of_type_JavaLangRunnable);
      } while (!this.jdField_a_of_type_Bhyt.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Int = 4;
      return;
    } while ((this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView == null) || (!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Akzz == null) || (paramGL10 == null));
    int i = this.jdField_a_of_type_CooperationVipArWidgetVipQGGLSurfaceView.getCanvasTexture("offScreen");
    if (i != 0)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      this.jdField_a_of_type_Akzz.a(i, null, null);
      if (this.c)
      {
        bhyv.a("ar_qg_show", "1");
        this.c = false;
      }
    }
    this.jdField_a_of_type_Int = 4;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akzz != null) {
      this.jdField_a_of_type_Akzz.a(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.jdField_a_of_type_Akzz = new akzz();
    this.jdField_a_of_type_Akzz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyp
 * JD-Core Version:    0.7.0.1
 */