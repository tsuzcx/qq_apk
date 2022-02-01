import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class amfp
  extends bgod
{
  amfp(SharedPreferences paramSharedPreferences, int paramInt, amfn paramamfn) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambgoe.a() + ", httpCode: " + parambgoe.f);
    if (3 == parambgoe.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Amfn != null) {
        amfn.a(this.jdField_a_of_type_Amfn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfp
 * JD-Core Version:    0.7.0.1
 */