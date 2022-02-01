import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bikg
  implements bitu
{
  public bikg(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Biau != null) && (this.a.jdField_a_of_type_Biau.isShowing())) {
      this.a.jdField_a_of_type_Biau.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Biau != null) && (this.a.jdField_a_of_type_Biau.isShowing())) {
      this.a.jdField_a_of_type_Biau.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Abdx == null)
        {
          this.a.jdField_a_of_type_Abdx = new abdx(this.a);
          this.a.jdField_a_of_type_Abdx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690511));
          this.a.jdField_a_of_type_Abdx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690510, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Abdx.a(this.a);
        }
        if (this.a.jdField_a_of_type_Abdx.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Abdx.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bgpa == null) {
          this.a.jdField_a_of_type_Bgpa = bglp.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690514), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690515), 2131690728, 2131694081, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bgpa.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bgpa.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bgpa.show();
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
    QQToast.a(biip.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikg
 * JD-Core Version:    0.7.0.1
 */