import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class amqw
  implements amqu, SurfaceHolder.Callback
{
  private amqv jdField_a_of_type_Amqv;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private volatile Object jdField_a_of_type_JavaLangObject;
  private volatile ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile Object jdField_b_of_type_JavaLangObject;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public amqw(SurfaceView paramSurfaceView)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView = paramSurfaceView;
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotCacheDrawing(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setDrawingCacheEnabled(false);
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotDraw(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
  }
  
  private boolean a()
  {
    c();
    return (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) && (this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_b_of_type_JavaLangObject != null);
  }
  
  private Canvas b()
  {
    Object localObject2;
    if (amox.a().a().b())
    {
      localObject2 = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockHardwareCanvas();
      return localObject2;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    e();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangObject != null)) {}
    for (;;)
    {
      try
      {
        Canvas localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().lockHardwareCanvas();
        localObject2 = localCanvas;
        if (localCanvas != null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return null;
      }
      catch (Exception localException)
      {
        amrq.a("SurfaceDanmakuView", "Exception locking surface", localException);
      }
      Object localObject1 = null;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (amox.a().a().b()) {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().unlockCanvasAndPost(paramCanvas);
    } while (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  private boolean b()
  {
    return (amql.a()) && (((Build.VERSION.SDK_INT == 23) && (a())) || (amox.a().a().b()));
  }
  
  private void c()
  {
    d();
    e();
  }
  
  private void d()
  {
    Object localObject = amox.a().a().a(SurfaceView.class, "mSurfaceLock", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((localObject instanceof ReentrantLock)) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ((ReentrantLock)localObject);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaLangObject = amox.a().a().a(SurfaceView.class, "mDrawingStopped", this.jdField_a_of_type_AndroidViewSurfaceView);
    this.jdField_b_of_type_JavaLangObject = amox.a().a().a(SurfaceView.class, "mWindow", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((this.jdField_a_of_type_JavaLangObject instanceof Boolean)) {
      this.jdField_a_of_type_Boolean = ((Boolean)this.jdField_a_of_type_JavaLangObject).booleanValue();
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidViewSurfaceView.getY();
  }
  
  public Canvas a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return b();
    }
    return this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
  }
  
  public void a()
  {
    ReentrantLock localReentrantLock = (ReentrantLock)amox.a().a().a(SurfaceView.class, "mSurfaceLock", this.jdField_a_of_type_AndroidViewSurfaceView);
    Surface localSurface = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().getSurface();
    try
    {
      Method localMethod = Surface.class.getDeclaredMethod("nativeRelease", new Class[] { Long.TYPE });
      localMethod.setAccessible(true);
      Field localField = Surface.class.getDeclaredField("mLockedObject");
      localField.setAccessible(true);
      Long localLong = (Long)localField.get(localSurface);
      amrq.c("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = " + localLong);
      if (localLong.longValue() != 0L) {
        localMethod.invoke(null, new Object[] { localLong });
      }
      localField.setLong(localSurface, 0L);
      amrq.b("surface_lock", "SurfaceDanmakuView unlock: release success");
      return;
    }
    catch (Exception localException)
    {
      amrq.a("surface_lock", "SurfaceDanmakuView unlock:release failed", localException);
      return;
    }
    finally
    {
      amrq.c("surface_lock", "SurfaceDanmakuView unlock surfaceLock = " + localReentrantLock);
      if ((localReentrantLock != null) && (localReentrantLock.isLocked()))
      {
        amrq.c("surface_lock", "SurfaceDanmakuView unlock");
        localReentrantLock.unlock();
      }
    }
  }
  
  public void a(amqv paramamqv)
  {
    this.jdField_a_of_type_Amqv = paramamqv;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void b() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Amqv != null) {
      this.jdField_a_of_type_Amqv.j();
    }
    amrq.c("SurfaceDanmakuView", "surfaceChanged, width = " + paramInt2 + ", height = " + paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_Amqv != null) {
      this.jdField_a_of_type_Amqv.i();
    }
    this.jdField_b_of_type_Boolean = b();
    amrq.c("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.jdField_b_of_type_Boolean);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_Amqv != null) {
      this.jdField_a_of_type_Amqv.k();
    }
    amrq.c("SurfaceDanmakuView", "surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amqw
 * JD-Core Version:    0.7.0.1
 */