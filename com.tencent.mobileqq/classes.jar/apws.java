import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apws
  extends alox
{
  apws(apwr paramapwr) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<akis> paramArrayList)
  {
    if (paramBoolean) {
      apwu.a().a(paramArrayList);
    }
    for (;;)
    {
      apwr.a(this.a, false);
      apwr.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apws
 * JD-Core Version:    0.7.0.1
 */