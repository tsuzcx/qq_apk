import android.app.Dialog;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyLeakHelper.2.1;
import com.tencent.mobileqq.widget.QQToast;

public final class aurf
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131707579) + "/Tencent/MobileQQ/log/", 1).a();
    paramView = ThreadManager.newFreeHandlerThread("nearby-leaker", 10);
    paramView.start();
    paramView = paramView.getLooper();
    if (paramView != null) {
      new Handler(paramView).post(new NearbyLeakHelper.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurf
 * JD-Core Version:    0.7.0.1
 */