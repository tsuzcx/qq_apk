import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class beub
  implements DialogInterface.OnCancelListener, Handler.Callback
{
  int a;
  public bety a;
  protected final WeakReference<Activity> a;
  protected final ArrayList<DialogInterface.OnCancelListener> a;
  protected final Handler b;
  
  public beub(Activity paramActivity)
  {
    this(paramActivity, -1);
  }
  
  public beub(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new bhtd(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    if (paramOnCancelListener != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnCancelListener);
    }
    this.b.removeMessages(1);
    this.b.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.b.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_Bety == null)
    {
      if (this.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_Bety = new bety(localActivity, 0, this.jdField_a_of_type_Int, 17);
      }
    }
    else
    {
      label147:
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label290;
      }
      this.jdField_a_of_type_Bety.setOnCancelListener(null);
      label165:
      if (paramInt1 != 0) {
        break label320;
      }
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        break label301;
      }
      this.jdField_a_of_type_Bety.a(localActivity.getString(2131719785));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bety.a(false);
      this.jdField_a_of_type_Bety.b(true);
      if (!localActivity.isFinishing()) {
        break label312;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQProgressNotifier", 4, "[" + localActivity.isFinishing() + "]");
      return;
      this.jdField_a_of_type_Bety = new bety(localActivity, localActivity.getResources().getDimensionPixelSize(2131298914));
      break label147;
      label290:
      this.jdField_a_of_type_Bety.setOnCancelListener(this);
      break label165;
      label301:
      this.jdField_a_of_type_Bety.a(paramString);
    }
    label312:
    this.jdField_a_of_type_Bety.show();
    return;
    label320:
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.jdField_a_of_type_Bety.a(paramString);
      this.jdField_a_of_type_Bety.d(2130839392);
      this.jdField_a_of_type_Bety.a(true);
      this.jdField_a_of_type_Bety.b(false);
      if (!this.jdField_a_of_type_Bety.isShowing())
      {
        if (!localActivity.isFinishing()) {
          break label485;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQProgressNotifier", 4, "[" + localActivity.isFinishing() + "]");
        }
      }
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.b;
      if (paramInt2 <= 0) {
        break label495;
      }
    }
    label427:
    label485:
    label495:
    for (long l = paramInt2;; l = 1000L)
    {
      paramOnCancelListener.sendMessageDelayed(paramString, l);
      return;
      this.jdField_a_of_type_Bety.a(paramString);
      this.jdField_a_of_type_Bety.d(2130839405);
      break;
      this.jdField_a_of_type_Bety.show();
      break label427;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing());
  }
  
  public void b()
  {
    this.b.removeMessages(1);
    this.b.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    a(paramInt1, localActivity.getString(paramInt2), paramInt3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.what != 2);
        b();
      } while ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 4) && (paramMessage.arg1 != 6) && (paramMessage.arg1 != 5));
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        if ((paramMessage.arg1 == 6) || (paramMessage.arg1 == 5))
        {
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          localActivity.setResult(-1, paramMessage);
        }
        for (;;)
        {
          localActivity.finish();
          return true;
          localActivity.setResult(-1);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQProgressNotifier", 2, "handleMessage baseActivity is null");
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProgressNotifier", 4, "onCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramDialogInterface = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDialogInterface.hasNext())
      {
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)paramDialogInterface.next();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(this.jdField_a_of_type_Bety);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beub
 * JD-Core Version:    0.7.0.1
 */