import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class asfp
  extends anmu
{
  asfp(asfo paramasfo) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<amgn> paramArrayList)
  {
    if (paramBoolean) {
      asfr.a().a(paramArrayList);
    }
    for (;;)
    {
      asfo.a(this.a, false);
      asfo.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfp
 * JD-Core Version:    0.7.0.1
 */