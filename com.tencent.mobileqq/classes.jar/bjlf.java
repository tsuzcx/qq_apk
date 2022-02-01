import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjlf
  implements bjut
{
  public bjlf(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
      this.a.jdField_a_of_type_Bjbs.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
      this.a.jdField_a_of_type_Bjbs.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Abia == null)
        {
          this.a.jdField_a_of_type_Abia = new abia(this.a);
          this.a.jdField_a_of_type_Abia.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690506));
          this.a.jdField_a_of_type_Abia.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690505, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Abia.a(this.a);
        }
        if (this.a.jdField_a_of_type_Abia.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Abia.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bhpc == null) {
          this.a.jdField_a_of_type_Bhpc = bhlq.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690509), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690510), 2131690728, 2131694098, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bhpc.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bhpc.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bhpc.show();
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
    QQToast.a(bjjo.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjlf
 * JD-Core Version:    0.7.0.1
 */