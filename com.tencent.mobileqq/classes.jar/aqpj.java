import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class aqpj
  implements aqkh
{
  aqpj(aqpi paramaqpi, aqkd paramaqkd, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.jdField_a_of_type_Aqkd.a().b);
      paramString.putString("authKey", this.jdField_a_of_type_Aqkd.a().jdField_a_of_type_JavaLangString);
      paramString.putLong("accountUpdateTime", this.jdField_a_of_type_Aqkd.a().jdField_a_of_type_Long);
      paramString.putString("payToken", this.jdField_a_of_type_Aqkd.a().c);
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data", paramString);
      localBundle.putBoolean("isSuccess", true);
      localBundle.putInt("code", paramInt);
      this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = localBundle;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", false);
      paramString.putInt("code", paramInt);
      this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqpj
 * JD-Core Version:    0.7.0.1
 */