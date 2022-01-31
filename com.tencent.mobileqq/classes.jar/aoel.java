import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aoel
  extends ajxl
{
  aoel(aoek paramaoek) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<airj> paramArrayList)
  {
    if (paramBoolean) {
      aoen.a().a(paramArrayList);
    }
    for (;;)
    {
      aoek.a(this.a, false);
      aoek.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoel
 * JD-Core Version:    0.7.0.1
 */