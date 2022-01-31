import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.3;
import com.tencent.qphone.base.util.QLog;

public class apbx
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, apca paramapca)
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
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramapca);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, apca paramapca)
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
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramapca);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, apca paramapca)
  {
    apby localapby = new apby(paramapca);
    paramapca = new apbz(paramapca);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {}
    do
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, localapby, paramapca));
      do
      {
        return;
      } while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()));
      if ((paramCharSequence instanceof String))
      {
        babr.a(paramContext, 230, paramString, (String)paramCharSequence, 2131626797, 2131626802, localapby, paramapca).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    babr.a(paramContext, 230, paramString, paramCharSequence, 2131626797, 2131626802, localapby, paramapca).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbx
 * JD-Core Version:    0.7.0.1
 */