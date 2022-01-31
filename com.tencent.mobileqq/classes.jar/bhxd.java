import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class bhxd
{
  private static ArrayList<bhyt> a = new ArrayList();
  
  public static bhzd a(String paramString, bhzc parambhzc, bhzb parambhzb)
  {
    if (paramString.equals(bhxh.class.getName())) {
      return new bhxh(parambhzc, parambhzb);
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
      bhyt localbhyt = (bhyt)localIterator.next();
      if (localbhyt != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localbhyt.hashCode());
        }
        localbhyt.u();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(bhxh.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130843689);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
  
  public static void a(bhyt parambhyt)
  {
    a.remove(parambhyt);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + a.size() + " newCode=" + parambhyt.hashCode());
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
      bhyt localbhyt = (bhyt)localIterator.next();
      if (localbhyt != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localbhyt.hashCode());
        }
        localbhyt.a(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(bhyt parambhyt)
  {
    a.add(parambhyt);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + a.size() + " newCode=" + parambhyt.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhxd
 * JD-Core Version:    0.7.0.1
 */