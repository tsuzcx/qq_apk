import com.tencent.qphone.base.util.QLog;
import cooperation.vip.VasAdvService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/VasAdvService$showAd$showAdCallback$1", "Lcooperation/vip/VasAdvService$ShowAdCallback;", "onAdShowed", "", "success", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmkj
  implements bmkg
{
  public void a(boolean paramBoolean)
  {
    VasAdvService.b(this.a).set(false);
    if (QLog.isColorLevel()) {
      QLog.d("VasAdvService", 2, "show ad result: " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkj
 * JD-Core Version:    0.7.0.1
 */