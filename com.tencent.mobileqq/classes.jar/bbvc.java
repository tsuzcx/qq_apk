import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbvc
  implements bceo
{
  public bbvc(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
      this.a.jdField_a_of_type_Bbms.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
      this.a.jdField_a_of_type_Bbms.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Xez == null)
        {
          this.a.jdField_a_of_type_Xez = new xez(this.a);
          this.a.jdField_a_of_type_Xez.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624920));
          this.a.jdField_a_of_type_Xez.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624919, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Xez.a(this.a);
        }
        if (this.a.jdField_a_of_type_Xez.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Xez.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bafb == null) {
          this.a.jdField_a_of_type_Bafb = babr.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624923), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624924), 2131625271, 2131629116, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bafb.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bafb.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bafb.show();
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
    bbmy.a(bbtm.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbvc
 * JD-Core Version:    0.7.0.1
 */