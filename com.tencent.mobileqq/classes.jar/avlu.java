import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class avlu
  implements artx
{
  avlu(avkt paramavkt, String paramString) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i("NearbyProfileDisplayPanel", 1, "onDownloadSucess() called with: filePath = [" + paramString + "], fileSize = [" + paramLong + "], extData = [" + paramBundle + "]");
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlu
 * JD-Core Version:    0.7.0.1
 */