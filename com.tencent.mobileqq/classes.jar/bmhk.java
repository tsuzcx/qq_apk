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

public class bmhk
  implements IEventReceiver
{
  private final bmhn jdField_a_of_type_Bmhn = new bmhn(this);
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bmhk()
  {
    umc.a().registerSubscriber(this.jdField_a_of_type_Bmhn);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder().append("mIsSurfaceCreated = ").append(this.b).append(", qgloaded = ").append(bfxg.b.get()).append(", renderManager = ");
    if (EffectsCameraCaptureView.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      wxe.b("QGEnvironment", bool + ", aeRenderManager = ");
      if ((!this.b) || (!bfxg.b.get()) || (EffectsCameraCaptureView.b() == null)) {
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
  
  public StoryQGSurfaceView a(bkoa parambkoa)
  {
    CameraCaptureView localCameraCaptureView = parambkoa.a();
    Context localContext = localCameraCaptureView.getContext();
    int i = xsm.b(localContext);
    int j = xsm.c(localContext);
    int k = j - parambkoa.f() - parambkoa.g();
    if (QLog.isColorLevel()) {
      QLog.d("QGEnvironment", 2, new Object[] { "createQGGLView width:", Integer.valueOf(i), ", height:", Integer.valueOf(j), ", realHeight=", Integer.valueOf(k) });
    }
    parambkoa = new StoryQGSurfaceView(localContext, i, k, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, localCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, ncb.b());
    QLog.i("QGEnvironment", 1, "QGVersion = " + StoryQGSurfaceView.getQGVersion() + " QGBuildTimeStamp = " + parambkoa.getQGBuildTimeStamp());
    return parambkoa;
  }
  
  public void a()
  {
    bfxg.a("1018", true, new bmhl(this));
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Bmhn);
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
 * Qualified Name:     bmhk
 * JD-Core Version:    0.7.0.1
 */