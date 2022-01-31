import android.app.Dialog;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqfav.QfavLeakHelper.2.1;

public final class birc
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131709981) + "/Tencent/MobileQQ/log/", 1).a();
    paramView = ThreadManager.newFreeHandlerThread("Qfav-leaker", 10);
    paramView.start();
    paramView = paramView.getLooper();
    if (paramView != null) {
      new Handler(paramView).post(new QfavLeakHelper.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birc
 * JD-Core Version:    0.7.0.1
 */