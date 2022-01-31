import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class bjpm
{
  private static ArrayList<bjrc> a = new ArrayList();
  
  public static bjrm a(String paramString, bjrl parambjrl, bjrk parambjrk)
  {
    if (paramString.equals(bjpq.class.getName())) {
      return new bjpq(parambjrl, parambjrk);
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent size: " + a.size());
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bjrc localbjrc = (bjrc)localIterator.next();
      if (localbjrc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localbjrc.hashCode());
        }
        localbjrc.u();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(bjpq.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130843771);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
  
  public static void a(bjrc parambjrc)
  {
    a.remove(parambjrc);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + a.size() + " newCode=" + parambjrc.hashCode());
    }
  }
  
  public static void a(LWMotionEvent paramLWMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent size: " + a.size());
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bjrc localbjrc = (bjrc)localIterator.next();
      if (localbjrc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localbjrc.hashCode());
        }
        localbjrc.a(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(bjrc parambjrc)
  {
    a.add(parambjrc);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + a.size() + " newCode=" + parambjrc.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpm
 * JD-Core Version:    0.7.0.1
 */