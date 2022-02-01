import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class atvb
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, atve paramatve)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramatve);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, atve paramatve)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramatve);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, atve paramatve)
  {
    atvc localatvc = new atvc(paramatve);
    paramatve = new atvd(paramatve);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localatvc, paramatve));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bglp.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692060, 2131692064, localatvc, paramatve).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bglp.a(paramContext, 230, paramString, paramCharSequence, 2131692060, 2131692064, localatvc, paramatve).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvb
 * JD-Core Version:    0.7.0.1
 */