import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjbq
  implements bjlh
{
  public bjbq(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
      this.a.jdField_a_of_type_Bisl.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Aatx == null)
        {
          this.a.jdField_a_of_type_Aatx = new aatx(this.a);
          this.a.jdField_a_of_type_Aatx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690621));
          this.a.jdField_a_of_type_Aatx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690620, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Aatx.a(this.a);
        }
        if (this.a.jdField_a_of_type_Aatx.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Aatx.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690624), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690625), 2131690845, 2131694399, this.a, null);
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
    QQToast.a(bizw.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbq
 * JD-Core Version:    0.7.0.1
 */