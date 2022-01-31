import android.os.Bundle;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bbec
  implements BusinessObserver
{
  bbec(bbea parambbea, bbej parambbej) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bbej.k = 1;
      this.jdField_a_of_type_Bbea.a.a(1, 1);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TribeVideoListPlayerFragment", 2, "dianZan failed!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbec
 * JD-Core Version:    0.7.0.1
 */