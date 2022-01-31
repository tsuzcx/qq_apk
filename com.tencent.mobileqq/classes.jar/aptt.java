import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class aptt
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, aptw paramaptw)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramaptw);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, aptw paramaptw)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramaptw);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, aptw paramaptw)
  {
    aptu localaptu = new aptu(paramaptw);
    paramaptw = new aptv(paramaptw);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localaptu, paramaptw));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bbdj.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692399, 2131692403, localaptu, paramaptw).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bbdj.a(paramContext, 230, paramString, paramCharSequence, 2131692399, 2131692403, localaptu, paramaptw).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptt
 * JD-Core Version:    0.7.0.1
 */