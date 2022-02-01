import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class anyg
  implements BusinessObserver
{
  anyg(anyb paramanyb, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "setRecommendTroopDeleted uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyg
 * JD-Core Version:    0.7.0.1
 */