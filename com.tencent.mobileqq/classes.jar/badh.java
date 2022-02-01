import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class badh
  extends aogx
{
  badh(bade parambade) {}
  
  public void a()
  {
    if ((bade.a(this.a) != null) && (VipUtils.b(bade.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("onVipStatusChanged mOpenSVipPay=%s", new Object[] { bade.a(this.a) }));
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      if ((bade.b(this.a).compareAndSet(true, false)) && (bade.a(this.a).get())) {
        bhlq.a(bade.a(this.a), 232, null, anzj.a(2131703785), null, anzj.a(2131703793), new badi(this), null).show();
      }
      bade.c(this.a).removeObserver(bade.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badh
 * JD-Core Version:    0.7.0.1
 */