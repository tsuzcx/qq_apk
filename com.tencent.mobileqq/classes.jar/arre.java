import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class arre
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, arrh paramarrh)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramarrh);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, arrh paramarrh)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramarrh);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, arrh paramarrh)
  {
    arrf localarrf = new arrf(paramarrh);
    paramarrh = new arrg(paramarrh);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localarrf, paramarrh));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bdgm.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692476, 2131692480, localarrf, paramarrh).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bdgm.a(paramContext, 230, paramString, paramCharSequence, 2131692476, 2131692480, localarrf, paramarrh).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arre
 * JD-Core Version:    0.7.0.1
 */