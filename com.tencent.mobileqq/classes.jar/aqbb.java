import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqbb
  extends altm
{
  aqbb(aqba paramaqba) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<aknh> paramArrayList)
  {
    if (paramBoolean) {
      aqbd.a().a(paramArrayList);
    }
    for (;;)
    {
      aqba.a(this.a, false);
      aqba.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbb
 * JD-Core Version:    0.7.0.1
 */