import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class ankv
  extends biht
{
  ankv(SharedPreferences paramSharedPreferences, int paramInt, ankt paramankt) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambihu.a() + ", httpCode: " + parambihu.f);
    if (3 == parambihu.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Ankt != null) {
        ankt.a(this.jdField_a_of_type_Ankt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankv
 * JD-Core Version:    0.7.0.1
 */