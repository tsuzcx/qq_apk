import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atct
  implements ymm
{
  atct(atcs paramatcs, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Atcs.isDestroy) {}
    do
    {
      return;
      paramBundle = String.format("{\"result\":%d, \"errMsg\":\"%s\", \"uin\":\"%s\"}", new Object[] { Integer.valueOf(paramBundle.getInt("result", -1)), paramBundle.getString("errMsg"), paramBundle.getString("retUin") });
      this.jdField_a_of_type_Atcs.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    } while (!QLog.isColorLevel());
    QLog.e("ConnectApiPlugin", 2, new Object[] { "handleJsRequest callback:", paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atct
 * JD-Core Version:    0.7.0.1
 */