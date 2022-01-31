import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class armv
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, army paramarmy)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramarmy);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, army paramarmy)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramarmy);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, army paramarmy)
  {
    armw localarmw = new armw(paramarmy);
    paramarmy = new armx(paramarmy);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localarmw, paramarmy));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bdcd.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692475, 2131692479, localarmw, paramarmy).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bdcd.a(paramContext, 230, paramString, paramCharSequence, 2131692475, 2131692479, localarmw, paramarmy).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armv
 * JD-Core Version:    0.7.0.1
 */