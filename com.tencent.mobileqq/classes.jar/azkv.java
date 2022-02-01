import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class azkv
  extends anun
{
  azkv(azks paramazks) {}
  
  public void a()
  {
    if ((azks.a(this.a) != null) && (VipUtils.b(azks.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("onVipStatusChanged mOpenSVipPay=%s", new Object[] { azks.a(this.a) }));
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      if ((azks.b(this.a).compareAndSet(true, false)) && (azks.a(this.a).get())) {
        bglp.a(azks.a(this.a), 232, null, anni.a(2131703678), null, anni.a(2131703686), new azkw(this), null).show();
      }
      azks.c(this.a).removeObserver(azks.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkv
 * JD-Core Version:    0.7.0.1
 */