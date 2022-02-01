import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LWMotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class bpyj
{
  private static ArrayList<bpzz> a = new ArrayList();
  
  public static bqaj a(String paramString, bqai parambqai, bqah parambqah)
  {
    if (paramString.equals(bpyn.class.getName())) {
      return new bpyn(parambqai, parambqah);
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
      bpzz localbpzz = (bpzz)localIterator.next();
      if (localbpzz != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCExitEvent newCode= " + localbpzz.hashCode());
        }
        localbpzz.u();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString.equals(bpyn.class.getName()))
    {
      if (!paramBoolean) {
        paramActivity.getWindow().setBackgroundDrawableResource(2130844596);
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
  }
  
  public static void a(bpzz parambpzz)
  {
    a.remove(parambpzz);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "removeIPCEvent: " + a.size() + " newCode=" + parambpzz.hashCode());
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
      bpzz localbpzz = (bpzz)localIterator.next();
      if (localbpzz != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "IPC touchIPCEvent newCode= " + localbpzz.hashCode());
        }
        localbpzz.a(paramLWMotionEvent);
      }
    }
  }
  
  public static void b(bpzz parambpzz)
  {
    a.add(parambpzz);
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoCameraCaptureUnitBuilder", 2, "addIPCEventHook: " + a.size() + " newCode=" + parambpzz.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpyj
 * JD-Core Version:    0.7.0.1
 */