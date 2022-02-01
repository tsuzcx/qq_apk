import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class audn
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, audq paramaudq)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramaudq);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, audq paramaudq)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramaudq);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, audq paramaudq)
  {
    audo localaudo = new audo(paramaudq);
    paramaudq = new audp(paramaudq);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localaudo, paramaudq));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bhdj.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692203, 2131692207, localaudo, paramaudq).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bhdj.a(paramContext, 230, paramString, paramCharSequence, 2131692203, 2131692207, localaudo, paramaudq).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audn
 * JD-Core Version:    0.7.0.1
 */