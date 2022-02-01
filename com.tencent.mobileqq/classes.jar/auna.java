import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.1;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.11;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.2;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.3;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.4;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.5;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.6;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.7;
import com.tencent.mobileqq.filemanager.util.FMToastUtil.8;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class auna
{
  private static int jdField_a_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011) - (int)bhmg.a(BaseApplicationImpl.getContext(), 5.0F);
  private static Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Map<String, Long> b = new HashMap();
  
  public static void a(int paramInt)
  {
    try
    {
      if (BaseApplicationImpl.sApplication.getRuntime().isBackgroundPause) {
        return;
      }
      if (a(paramInt))
      {
        Looper localLooper = Looper.getMainLooper();
        if (Thread.currentThread() != localLooper.getThread())
        {
          new Handler(localLooper).post(new FMToastUtil.1(paramInt));
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.8(paramInt1, paramString, paramInt2));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), paramInt1, paramString, paramInt2).b(jdField_a_of_type_Int);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new FMToastUtil.11(paramContext, paramInt1, paramInt2));
  }
  
  public static void a(String paramString)
  {
    if (BaseApplicationImpl.sApplication.getRuntime().isBackgroundPause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.2(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  private static boolean a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      long l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (b.containsKey(paramString))
    {
      long l1 = ((Long)b.get(paramString)).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        b.put(paramString, Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      b.clear();
      b.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.3(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void b(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.4(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.7(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.5(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 1).b(jdField_a_of_type_Int);
  }
  
  public static void d(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.6(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auna
 * JD-Core Version:    0.7.0.1
 */