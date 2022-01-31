import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class beyt
  implements bfic
{
  public beyt(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
      this.a.jdField_a_of_type_Bepp.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
      this.a.jdField_a_of_type_Bepp.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Zcp == null)
        {
          this.a.jdField_a_of_type_Zcp = new zcp(this.a);
          this.a.jdField_a_of_type_Zcp.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690532));
          this.a.jdField_a_of_type_Zcp.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690531, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Zcp.a(this.a);
        }
        if (this.a.jdField_a_of_type_Zcp.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Zcp.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bdfq == null) {
          this.a.jdField_a_of_type_Bdfq = bdcd.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690535), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690536), 2131690884, 2131694951, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bdfq.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bdfq.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bdfq.show();
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
    QQToast.a(bexd.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyt
 * JD-Core Version:    0.7.0.1
 */