import android.os.Bundle;
import com.tencent.qqinterface.CommonCallback;

class aqpf
  implements msk
{
  aqpf(aqpc paramaqpc, msj parammsj, CommonCallback paramCommonCallback) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.jdField_a_of_type_Aqpc.a.a(this.jdField_a_of_type_Msj.a(), this.jdField_a_of_type_Msj.a(), paramLong, 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOnline", paramBoolean);
    localBundle.putString("videoUrl", paramString1);
    localBundle.putString("vid", paramString2);
    localBundle.putLong("timeConsume", paramLong);
    localBundle.putString("mqqApi", paramString3);
    this.jdField_a_of_type_ComTencentQqinterfaceCommonCallback.onResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqpf
 * JD-Core Version:    0.7.0.1
 */