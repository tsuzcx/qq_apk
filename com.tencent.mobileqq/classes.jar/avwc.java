import android.os.Bundle;
import com.tencent.qqinterface.CommonCallback;

class avwc
  implements nyz
{
  avwc(avvz paramavvz, nyy paramnyy, CommonCallback paramCommonCallback) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.jdField_a_of_type_Avvz.a.a(this.jdField_a_of_type_Nyy.a(), this.jdField_a_of_type_Nyy.a(), paramLong, 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOnline", paramBoolean);
    localBundle.putString("videoUrl", paramString1);
    localBundle.putString("vid", paramString2);
    localBundle.putLong("timeConsume", paramLong);
    localBundle.putString("mqqApi", paramString3);
    this.jdField_a_of_type_ComTencentQqinterfaceCommonCallback.onResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwc
 * JD-Core Version:    0.7.0.1
 */