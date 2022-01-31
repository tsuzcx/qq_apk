import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bfdc
  implements bfml
{
  public bfdc(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing())) {
      this.a.jdField_a_of_type_Bety.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing())) {
      this.a.jdField_a_of_type_Bety.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Zhe == null)
        {
          this.a.jdField_a_of_type_Zhe = new zhe(this.a);
          this.a.jdField_a_of_type_Zhe.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690532));
          this.a.jdField_a_of_type_Zhe.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690531, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Zhe.a(this.a);
        }
        if (this.a.jdField_a_of_type_Zhe.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Zhe.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bdjz == null) {
          this.a.jdField_a_of_type_Bdjz = bdgm.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690535), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690536), 2131690885, 2131694953, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bdjz.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bdjz.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bdjz.show();
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
    QQToast.a(bfbm.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdc
 * JD-Core Version:    0.7.0.1
 */