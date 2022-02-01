import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class angx
  extends bhyn
{
  angx(SharedPreferences paramSharedPreferences, int paramInt, angv paramangv) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambhyo.a() + ", httpCode: " + parambhyo.f);
    if (3 == parambhyo.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Angv != null) {
        angv.a(this.jdField_a_of_type_Angv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */