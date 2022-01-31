import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.3.1;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Timer;

public class aoph
  implements View.OnClickListener
{
  public aoph(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.d(BaseApplicationImpl.getContext())) {
      aptx.a(BaseApplicationImpl.getContext().getString(2131694608));
    }
    do
    {
      return;
      aptx.a(BaseApplicationImpl.getContext().getString(2131694333));
      paramView = (ajum)MPFileVerifyPwdView.a(this.a).a(8);
      MPFileVerifyPwdView.a(this.a, paramView.a().a(3));
      MPFileVerifyPwdView.b(this.a).setEnabled(false);
      MPFileVerifyPwdView.b(this.a).setTextColor(-7829368);
      MPFileVerifyPwdView.a(this.a).schedule(new MPFileVerifyPwdView.3.1(this), 15000L);
    } while (MPFileVerifyPwdView.a(this.a) == null);
    MPFileVerifyPwdView.a(this.a).a(MPFileVerifyPwdView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoph
 * JD-Core Version:    0.7.0.1
 */