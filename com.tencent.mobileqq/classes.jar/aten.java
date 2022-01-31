import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class aten
  implements aszl
{
  aten(atem paramatem, aszh paramaszh, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.jdField_a_of_type_Aszh.a().b);
      paramString.putString("authKey", this.jdField_a_of_type_Aszh.a().jdField_a_of_type_JavaLangString);
      paramString.putLong("accountUpdateTime", this.jdField_a_of_type_Aszh.a().jdField_a_of_type_Long);
      paramString.putString("payToken", this.jdField_a_of_type_Aszh.a().c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aten
 * JD-Core Version:    0.7.0.1
 */