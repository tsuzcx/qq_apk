import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class aumw
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, aumz paramaumz)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramaumz);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, aumz paramaumz)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramaumz);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, aumz paramaumz)
  {
    aumx localaumx = new aumx(paramaumz);
    paramaumz = new aumy(paramaumz);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localaumx, paramaumz));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bhlq.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692065, 2131692069, localaumx, paramaumz).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bhlq.a(paramContext, 230, paramString, paramCharSequence, 2131692065, 2131692069, localaumx, paramaumz).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumw
 * JD-Core Version:    0.7.0.1
 */