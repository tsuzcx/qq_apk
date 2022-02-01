import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class amzb
  extends bhhe
{
  amzb(SharedPreferences paramSharedPreferences, int paramInt, amyz paramamyz) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambhhf.a() + ", httpCode: " + parambhhf.f);
    if (3 == parambhhf.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Amyz != null) {
        amyz.a(this.jdField_a_of_type_Amyz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzb
 * JD-Core Version:    0.7.0.1
 */