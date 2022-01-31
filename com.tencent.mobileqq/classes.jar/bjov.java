import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class bjov
{
  private static ArrayList<bjql> a = new ArrayList();
  
  public static bjqv a(String paramString, bjqu parambjqu, bjqt parambjqt)
  {
    if (paramString.equals(bjoz.class.getName())) {
      return new bjoz(parambjqu, parambjqt);
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
      bjql localbjql = (bjql)localIterator.next();
      if (localbjql != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localbjql.hashCode());
        }
        localbjql.u();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(bjoz.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130843770);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
  
  public static void a(bjql parambjql)
  {
    a.remove(parambjql);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + a.size() + " newCode=" + parambjql.hashCode());
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
      bjql localbjql = (bjql)localIterator.next();
      if (localbjql != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localbjql.hashCode());
        }
        localbjql.a(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(bjql parambjql)
  {
    a.add(parambjql);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + a.size() + " newCode=" + parambjql.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjov
 * JD-Core Version:    0.7.0.1
 */