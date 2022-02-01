import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.3.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;

public class arvb
  implements View.OnClickListener
{
  public arvb(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
      aszk.a(BaseApplicationImpl.getContext().getString(2131694062));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aszk.a(BaseApplicationImpl.getContext().getString(2131693874));
      amqd localamqd = (amqd)MPFileVerifyPwdView.a(this.a).getBusinessHandler(8);
      MPFileVerifyPwdView.a(this.a, localamqd.a().a(3));
      MPFileVerifyPwdView.b(this.a).setEnabled(false);
      MPFileVerifyPwdView.b(this.a).setTextColor(-7829368);
      MPFileVerifyPwdView.a(this.a).schedule(new MPFileVerifyPwdView.3.1(this), 15000L);
      if (MPFileVerifyPwdView.a(this.a) != null) {
        MPFileVerifyPwdView.a(this.a).a(MPFileVerifyPwdView.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvb
 * JD-Core Version:    0.7.0.1
 */