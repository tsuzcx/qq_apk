import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class awdl
  implements avzh
{
  awdl(awdk paramawdk, avzd paramavzd, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.jdField_a_of_type_Avzd.a().b);
      paramString.putString("authKey", this.jdField_a_of_type_Avzd.a().jdField_a_of_type_JavaLangString);
      paramString.putLong("accountUpdateTime", this.jdField_a_of_type_Avzd.a().jdField_a_of_type_Long);
      paramString.putString("payToken", this.jdField_a_of_type_Avzd.a().c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdl
 * JD-Core Version:    0.7.0.1
 */