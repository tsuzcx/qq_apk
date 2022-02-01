import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class arhd
  extends amsu
{
  arhd(arhc paramarhc) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<alnb> paramArrayList)
  {
    if (paramBoolean) {
      arhf.a().a(paramArrayList);
    }
    for (;;)
    {
      arhc.a(this.a, false);
      arhc.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhd
 * JD-Core Version:    0.7.0.1
 */