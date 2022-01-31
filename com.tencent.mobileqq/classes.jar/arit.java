import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class arit
  implements aabm
{
  arit(arii paramarii, WeakReference paramWeakReference, Bundle paramBundle) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onFailure code = " + paramInt);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131703573), 0).a();
  }
  
  public void onPermission(int paramInt)
  {
    QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onPermission code = " + paramInt);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131703574), 0).a();
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    }
    try
    {
      QLog.e("XProxy|NowProxy", 1, "doraemonAPIManager call login onSuccess");
      this.jdField_a_of_type_Arii.b = paramJSONObject.optString("access_token");
      this.jdField_a_of_type_Arii.jdField_a_of_type_JavaLangString = paramJSONObject.optString("openid");
      this.jdField_a_of_type_AndroidOsBundle.putString("access_token", this.jdField_a_of_type_Arii.b);
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.jdField_a_of_type_Arii.jdField_a_of_type_JavaLangString);
      arii.a(this.jdField_a_of_type_Arii);
      this.jdField_a_of_type_Arii.jdField_a_of_type_Arjc.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("XProxy|NowProxy", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arit
 * JD-Core Version:    0.7.0.1
 */