import android.app.Dialog;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LeakHelper.2.1;

public final class bgyc
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131706007) + "/Tencent/MobileQQ/log/", 1).a();
    paramView = ThreadManager.newFreeHandlerThread("qzone-leaker", 10);
    paramView.start();
    paramView = paramView.getLooper();
    if (paramView != null) {
      new Handler(paramView).post(new LeakHelper.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgyc
 * JD-Core Version:    0.7.0.1
 */