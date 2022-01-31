import android.os.Bundle;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class azbs
  implements BusinessObserver
{
  azbs(azbq paramazbq, azbz paramazbz) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Azbz.k = 1;
      this.jdField_a_of_type_Azbq.a.a(1, 1);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TribeVideoListPlayerFragment", 2, "dianZan failed!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbs
 * JD-Core Version:    0.7.0.1
 */