import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class aqph
  implements aqkh
{
  aqph(aqpg paramaqpg, aqkd paramaqkd, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new Bundle(this.jdField_a_of_type_Aqkd.a().a.getExtras());
    Bundle localBundle = new Bundle();
    localBundle.putBundle("data", paramString);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("code", paramInt);
    this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = localBundle;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqph
 * JD-Core Version:    0.7.0.1
 */