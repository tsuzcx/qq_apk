import android.content.Context;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qg.StoryQGSurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class bjqx
  implements IEventReceiver
{
  private final bjra jdField_a_of_type_Bjra = new bjra(this);
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bjqx()
  {
    ste.a().registerSubscriber(this.jdField_a_of_type_Bjra);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.b).append(", qgloaded = ").append(bdsn.b.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      veg.b("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.b) || (!bdsn.b.get()) || (EffectsCameraCaptureView.b() == null)) {
        break;
      }
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        localObject = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localObject != null) {
          ((Runnable)localObject).run();
        }
      }
    }
  }
  
  public StoryQGSurfaceView a(bihg parambihg)
  {
    CameraCaptureView localCameraCaptureView = parambihg.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = vzo.b(localContext);
    int j = vzo.c(localContext);
    int k = j - parambihg.g() - parambihg.h();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    parambihg = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, mzk.b());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + parambihg.getQGBuildTimeStamp());
    return parambihg;
  }
  
  public void a()
  {
    bdsn.a("1018", true, new bjqy(this));
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Bjra);
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.remove(paramRunnable);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjqx
 * JD-Core Version:    0.7.0.1
 */