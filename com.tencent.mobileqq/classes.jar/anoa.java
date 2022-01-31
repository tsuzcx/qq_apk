import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anoa
  extends ajjh
{
  anoa(annz paramannz) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<aieq> paramArrayList)
  {
    if (paramBoolean) {
      anoc.a().a(paramArrayList);
    }
    for (;;)
    {
      annz.a(this.a, false);
      annz.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anoa
 * JD-Core Version:    0.7.0.1
 */