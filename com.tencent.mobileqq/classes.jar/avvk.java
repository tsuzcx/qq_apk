import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class avvk
  implements adaa
{
  avvk(avux paramavux, WeakReference paramWeakReference, Bundle paramBundle) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onPermission code = " + paramInt);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131703059), 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onFailure code = " + paramInt);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131703058), 0).a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    try
    {
      QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onSuccess");
      this.jdField_a_of_type_Avux.b = paramJSONObject.optString("access_token");
      this.jdField_a_of_type_Avux.jdField_a_of_type_JavaLangString = paramJSONObject.optString("openid");
      this.jdField_a_of_type_AndroidOsBundle.putString("access_token", this.jdField_a_of_type_Avux.b);
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.jdField_a_of_type_Avux.jdField_a_of_type_JavaLangString);
      avux.a(this.jdField_a_of_type_Avux);
      this.jdField_a_of_type_Avux.jdField_a_of_type_Avvu.b(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("XProxy|NowProxy", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvk
 * JD-Core Version:    0.7.0.1
 */