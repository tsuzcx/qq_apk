import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aoeq
  extends ajxj
{
  aoeq(aoep paramaoep) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<airh> paramArrayList)
  {
    if (paramBoolean) {
      aoes.a().a(paramArrayList);
    }
    for (;;)
    {
      aoep.a(this.a, false);
      aoep.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoeq
 * JD-Core Version:    0.7.0.1
 */