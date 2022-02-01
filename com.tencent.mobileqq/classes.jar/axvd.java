import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class axvd
{
  public static final AppRuntime.Status[] a = { AppRuntime.Status.online, AppRuntime.Status.qme, AppRuntime.Status.away, AppRuntime.Status.busy, AppRuntime.Status.dnd, AppRuntime.Status.invisiable };
  
  public static int a(AppRuntime.Status paramStatus)
  {
    switch (axve.a[paramStatus.ordinal()])
    {
    default: 
      QLog.d("Q..online.status", 1, "getButtonId changed to online , status: " + paramStatus);
    case 1: 
      return 2131361906;
    case 2: 
      return 2131361907;
    case 3: 
      return 2131361902;
    case 4: 
      return 2131361903;
    case 5: 
      return 2131361904;
    }
    return 2131361905;
  }
  
  public static Drawable a(AppRuntime.Status paramStatus)
  {
    return a(paramStatus, 0);
  }
  
  public static Drawable a(AppRuntime.Status paramStatus, int paramInt)
  {
    Object localObject = null;
    if (paramStatus != null) {}
    try
    {
      switch (axve.a[paramStatus.ordinal()])
      {
      case 1: 
        QLog.d("Q..online.status", 1, "getStatusIcon, not find status: " + paramStatus);
        paramStatus = localObject;
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        for (;;)
        {
          if ((paramStatus != null) && (paramInt > 0)) {
            paramStatus.setBounds(0, 0, paramInt, paramInt);
          }
          return paramStatus;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837555);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837557);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837546);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837548);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837551);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837553);
          continue;
          QLog.d("Q..online.status", 1, "getStatusIcon, status == null");
          paramStatus = localObject;
        }
      }
    }
    catch (Exception paramStatus)
    {
      for (;;)
      {
        QLog.d("Q..online.status", 1, "getStatusDrawable", paramStatus);
        paramStatus = localObject;
      }
    }
  }
  
  public static String a(AppRuntime.Status paramStatus)
  {
    if (paramStatus != null)
    {
      switch (axve.a[paramStatus.ordinal()])
      {
      default: 
        QLog.d("Q..online.status", 1, "getStatusName, not find status: " + paramStatus);
        return "";
      case 1: 
        return BaseApplicationImpl.getContext().getString(2131718588);
      case 2: 
        return BaseApplicationImpl.getContext().getString(2131718589);
      case 3: 
        return BaseApplicationImpl.getContext().getString(2131718578);
      case 4: 
        return BaseApplicationImpl.getContext().getString(2131718580);
      case 5: 
        return BaseApplicationImpl.getContext().getString(2131718584);
      }
      return BaseApplicationImpl.getContext().getString(2131718586);
    }
    QLog.d("Q..online.status", 1, "getStatusName, status is null");
    return "";
  }
  
  public static AppRuntime.Status a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return AppRuntime.Status.online;
    case 2: 
      return AppRuntime.Status.offline;
    case 3: 
      return AppRuntime.Status.away;
    case 4: 
      return AppRuntime.Status.invisiable;
    case 5: 
      return AppRuntime.Status.busy;
    case 6: 
      return AppRuntime.Status.qme;
    }
    return AppRuntime.Status.dnd;
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus == AppRuntime.Status.away) || (paramStatus == AppRuntime.Status.busy) || (paramStatus == AppRuntime.Status.dnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvd
 * JD-Core Version:    0.7.0.1
 */