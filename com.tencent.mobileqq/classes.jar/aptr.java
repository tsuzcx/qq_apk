import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class aptr
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, aptu paramaptu)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramaptu);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, aptu paramaptu)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramaptu);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, aptu paramaptu)
  {
    apts localapts = new apts(paramaptu);
    paramaptu = new aptt(paramaptu);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localapts, paramaptu));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        bbcv.a(paramContext, 230, paramString, (String)paramCharSequence, 2131692399, 2131692403, localapts, paramaptu).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    bbcv.a(paramContext, 230, paramString, paramCharSequence, 2131692399, 2131692403, localapts, paramaptu).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptr
 * JD-Core Version:    0.7.0.1
 */