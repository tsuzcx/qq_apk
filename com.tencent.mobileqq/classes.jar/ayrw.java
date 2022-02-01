import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ayrw
  extends anam
{
  ayrw(ayrt paramayrt) {}
  
  public void a()
  {
    if ((ayrt.a(this.a) != null) && (VipUtils.b(ayrt.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("onVipStatusChanged mOpenSVipPay=%s", new Object[] { ayrt.a(this.a) }));
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      if ((ayrt.b(this.a).compareAndSet(true, false)) && (ayrt.a(this.a).get())) {
        bfur.a(ayrt.a(this.a), 232, null, amtj.a(2131704015), null, amtj.a(2131704023), new ayrx(this), null).show();
      }
      ayrt.c(this.a).removeObserver(ayrt.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrw
 * JD-Core Version:    0.7.0.1
 */