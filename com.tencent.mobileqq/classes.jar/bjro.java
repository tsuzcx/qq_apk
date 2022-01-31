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

public class bjro
  implements IEventReceiver
{
  private final bjrr jdField_a_of_type_Bjrr = new bjrr(this);
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bjro()
  {
    stb.a().registerSubscriber(this.jdField_a_of_type_Bjrr);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.b).append(", qgloaded = ").append(bdte.b.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ved.b("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.b) || (!bdte.b.get()) || (EffectsCameraCaptureView.b() == null)) {
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
  
  public StoryQGSurfaceView a(bihx parambihx)
  {
    CameraCaptureView localCameraCaptureView = parambihx.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = vzl.b(localContext);
    int j = vzl.c(localContext);
    int k = j - parambihx.g() - parambihx.h();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    parambihx = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, mzh.b());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + parambihx.getQGBuildTimeStamp());
    return parambihx;
  }
  
  public void a()
  {
    bdte.a("1018", true, new bjrp(this));
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Bjrr);
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
 * Qualified Name:     bjro
 * JD-Core Version:    0.7.0.1
 */