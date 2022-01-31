import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class bmaw
{
  private static ArrayList<bmcm> a = new ArrayList();
  
  public static bmcw a(String paramString, bmcv parambmcv, bmcu parambmcu)
  {
    if (paramString.equals(bmba.class.getName())) {
      return new bmba(parambmcv, parambmcu);
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
      bmcm localbmcm = (bmcm)localIterator.next();
      if (localbmcm != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localbmcm.hashCode());
        }
        localbmcm.u();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(bmba.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130844114);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
  
  public static void a(bmcm parambmcm)
  {
    a.remove(parambmcm);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + a.size() + " newCode=" + parambmcm.hashCode());
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
      bmcm localbmcm = (bmcm)localIterator.next();
      if (localbmcm != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localbmcm.hashCode());
        }
        localbmcm.a(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(bmcm parambmcm)
  {
    a.add(parambmcm);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + a.size() + " newCode=" + parambmcm.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmaw
 * JD-Core Version:    0.7.0.1
 */