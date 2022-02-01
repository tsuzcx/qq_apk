import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class azws
  extends aodb
{
  azws(azwp paramazwp) {}
  
  public void a()
  {
    if ((azwp.a(this.a) != null) && (VipUtils.b(azwp.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("onVipStatusChanged mOpenSVipPay=%s", new Object[] { azwp.a(this.a) }));
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      if ((azwp.b(this.a).compareAndSet(true, false)) && (azwp.a(this.a).get())) {
        bhdj.a(azwp.a(this.a), 232, null, anvx.a(2131704366), null, anvx.a(2131704374), new azwt(this), null).show();
      }
      azwp.c(this.a).removeObserver(azwp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azws
 * JD-Core Version:    0.7.0.1
 */