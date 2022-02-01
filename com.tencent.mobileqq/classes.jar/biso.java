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

public class biso
  implements DialogInterface.OnCancelListener, Handler.Callback
{
  int a;
  public bisl a;
  protected final WeakReference<Activity> a;
  protected final ArrayList<DialogInterface.OnCancelListener> a;
  protected final Handler b;
  
  public biso(Activity paramActivity)
  {
    this(paramActivity, -1);
  }
  
  public biso(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new bkys(Looper.getMainLooper(), this);
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
    if ((paramOnCancelListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnCancelListener))) {
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
    if (this.jdField_a_of_type_Bisl == null)
    {
      if (this.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_Bisl = new bisl(localActivity, 0, this.jdField_a_of_type_Int, 17);
      }
    }
    else
    {
      label159:
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label302;
      }
      this.jdField_a_of_type_Bisl.setOnCancelListener(null);
      label177:
      if (paramInt1 != 0) {
        break label332;
      }
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        break label313;
      }
      this.jdField_a_of_type_Bisl.a(localActivity.getString(2131718527));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bisl.a(false);
      this.jdField_a_of_type_Bisl.b(true);
      if (!localActivity.isFinishing()) {
        break label324;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQProgressNotifier", 4, "[" + localActivity.isFinishing() + "]");
      return;
      this.jdField_a_of_type_Bisl = new bisl(localActivity, localActivity.getResources().getDimensionPixelSize(2131299080));
      break label159;
      label302:
      this.jdField_a_of_type_Bisl.setOnCancelListener(this);
      break label177;
      label313:
      this.jdField_a_of_type_Bisl.a(paramString);
    }
    label324:
    this.jdField_a_of_type_Bisl.show();
    return;
    label332:
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.jdField_a_of_type_Bisl.a(paramString);
      this.jdField_a_of_type_Bisl.d(2130839636);
      this.jdField_a_of_type_Bisl.a(true);
      this.jdField_a_of_type_Bisl.b(false);
      if (!this.jdField_a_of_type_Bisl.isShowing())
      {
        if (!localActivity.isFinishing()) {
          break label497;
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
        break label507;
      }
    }
    label439:
    label497:
    label507:
    for (long l = paramInt2;; l = 1000L)
    {
      paramOnCancelListener.sendMessageDelayed(paramString, l);
      return;
      this.jdField_a_of_type_Bisl.a(paramString);
      this.jdField_a_of_type_Bisl.d(2130839651);
      break;
      this.jdField_a_of_type_Bisl.show();
      break label439;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing());
  }
  
  public void b()
  {
    this.b.removeMessages(1);
    this.b.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
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
          localOnCancelListener.onCancel(this.jdField_a_of_type_Bisl);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biso
 * JD-Core Version:    0.7.0.1
 */