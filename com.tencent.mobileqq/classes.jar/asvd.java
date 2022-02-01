import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class asvd
  extends anyu
{
  asvd(asvc paramasvc) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<amsh> paramArrayList)
  {
    if (paramBoolean) {
      asvf.a().a(paramArrayList);
    }
    for (;;)
    {
      asvc.a(this.a, false);
      asvc.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvd
 * JD-Core Version:    0.7.0.1
 */