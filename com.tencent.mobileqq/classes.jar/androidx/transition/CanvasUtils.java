package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils
{
  private static Method sInorderBarrierMethod;
  private static boolean sOrderMethodsFetched;
  private static Method sReorderBarrierMethod;
  
  @SuppressLint({"SoonBlockedPrivateApi"})
  static void enableZ(@NonNull Canvas paramCanvas, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (paramBoolean)
      {
        paramCanvas.enableZ();
        return;
      }
      paramCanvas.disableZ();
      return;
    }
    if ((Build.VERSION.SDK_INT == 28) || (!sOrderMethodsFetched)) {}
    try
    {
      sReorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
      sReorderBarrierMethod.setAccessible(true);
      sInorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
      sInorderBarrierMethod.setAccessible(true);
      label87:
      sOrderMethodsFetched = true;
      if (paramBoolean) {}
      try
      {
        if (sReorderBarrierMethod != null) {
          sReorderBarrierMethod.invoke(paramCanvas, new Object[0]);
        }
        if ((paramBoolean) || (sInorderBarrierMethod == null)) {
          break label151;
        }
        sInorderBarrierMethod.invoke(paramCanvas, new Object[0]);
        return;
      }
      catch (IllegalAccessException paramCanvas)
      {
        return;
      }
      catch (InvocationTargetException paramCanvas)
      {
        label139:
        break label139;
      }
      throw new RuntimeException(paramCanvas.getCause());
      label151:
      return;
      throw new IllegalStateException("This method doesn't work on Pie!");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.CanvasUtils
 * JD-Core Version:    0.7.0.1
 */