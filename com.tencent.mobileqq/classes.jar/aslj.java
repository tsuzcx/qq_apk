import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aslj
  extends anvi
{
  aslj(asli paramasli) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<amlc> paramArrayList)
  {
    if (paramBoolean) {
      asll.a().a(paramArrayList);
    }
    for (;;)
    {
      asli.a(this.a, false);
      asli.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslj
 * JD-Core Version:    0.7.0.1
 */