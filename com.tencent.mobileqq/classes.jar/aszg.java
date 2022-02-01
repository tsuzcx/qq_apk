import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class aszg
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, aszj paramaszj)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramaszj);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, aszj paramaszj)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramaszj);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, aszj paramaszj)
  {
    aszh localaszh = new aszh(paramaszj);
    paramaszj = new aszi(paramaszj);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localaszh, paramaszj));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bfur.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692113, 2131692117, localaszh, paramaszj).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bfur.a(paramContext, 230, paramString, paramCharSequence, 2131692113, 2131692117, localaszh, paramaszj).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszg
 * JD-Core Version:    0.7.0.1
 */