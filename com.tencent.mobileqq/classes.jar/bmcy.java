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

public class bmcy
  implements IEventReceiver
{
  private final bmdb jdField_a_of_type_Bmdb = new bmdb(this);
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bmcy()
  {
    uht.a().registerSubscriber(this.jdField_a_of_type_Bmdb);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.b).append(", qgloaded = ").append(bfsz.b.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      wsv.b("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.b) || (!bfsz.b.get()) || (EffectsCameraCaptureView.b() == null)) {
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
  
  public StoryQGSurfaceView a(bkjt parambkjt)
  {
    CameraCaptureView localCameraCaptureView = parambkjt.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = xod.b(localContext);
    int j = xod.c(localContext);
    int k = j - parambkjt.f() - parambkjt.g();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    parambkjt = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, ncb.b());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + parambkjt.getQGBuildTimeStamp());
    return parambkjt;
  }
  
  public void a()
  {
    bfsz.a("1018", true, new bmcz(this));
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Bmdb);
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
 * Qualified Name:     bmcy
 * JD-Core Version:    0.7.0.1
 */