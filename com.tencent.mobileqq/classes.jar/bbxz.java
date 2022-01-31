import android.os.Looper;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class bbxz
  implements bbye
{
  public bbxz(RegisterLHAssistant.2 param2) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(bbxx.a, 4, String.format(Locale.getDefault(), "checkVipQQStatus, needShow: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    bbxx.a(this.a.this$0, paramBoolean);
    if ((bbxx.a(this.a.this$0)) && (bbxx.a(this.a.this$0).isEnabled()) && (Thread.currentThread() == Looper.getMainLooper().getThread()) && (bbxx.a(this.a.this$0).getVisibility() == 8)) {
      this.a.this$0.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxz
 * JD-Core Version:    0.7.0.1
 */