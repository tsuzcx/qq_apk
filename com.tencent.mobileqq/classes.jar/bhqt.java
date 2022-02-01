import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bhqt
  implements biaf
{
  public bhqt(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bhht != null) && (this.a.jdField_a_of_type_Bhht.isShowing())) {
      this.a.jdField_a_of_type_Bhht.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bhht != null) && (this.a.jdField_a_of_type_Bhht.isShowing())) {
      this.a.jdField_a_of_type_Bhht.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Aael == null)
        {
          this.a.jdField_a_of_type_Aael = new aael(this.a);
          this.a.jdField_a_of_type_Aael.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690546));
          this.a.jdField_a_of_type_Aael.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690545, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Aael.a(this.a);
        }
        if (this.a.jdField_a_of_type_Aael.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Aael.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690549), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690550), 2131690768, 2131694201, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
    }
    paramJSONObject = paramJSONObject.getString("msg");
    QQToast.a(bhpc.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqt
 * JD-Core Version:    0.7.0.1
 */