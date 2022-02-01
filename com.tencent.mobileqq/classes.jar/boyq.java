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

public class boyq
  implements IEventReceiver
{
  private final boyt jdField_a_of_type_Boyt = new boyt(this);
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public boyq()
  {
    wfo.a().registerSubscriber(this.jdField_a_of_type_Boyt);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.b).append(", qgloaded = ").append(bjes.b.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      yqp.b("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.b) || (!bjes.b.get()) || (EffectsCameraCaptureView.b() == null)) {
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
  
  public StoryQGSurfaceView a(bncn parambncn)
  {
    CameraCaptureView localCameraCaptureView = parambncn.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = zlx.b(localContext);
    int j = zlx.c(localContext);
    int k = j - parambncn.f() - parambncn.g();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    parambncn = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, nku.b());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + parambncn.getQGBuildTimeStamp());
    return parambncn;
  }
  
  public void a()
  {
    bjes.a("1018", true, new boyr(this));
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Boyt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyq
 * JD-Core Version:    0.7.0.1
 */