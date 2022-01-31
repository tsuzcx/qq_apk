import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bczr
  implements bdje
{
  public bczr(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())) {
      this.a.jdField_a_of_type_Bcqf.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())) {
      this.a.jdField_a_of_type_Bcqf.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_Xnw == null)
        {
          this.a.jdField_a_of_type_Xnw = new xnw(this.a);
          this.a.jdField_a_of_type_Xnw.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690481));
          this.a.jdField_a_of_type_Xnw.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690480, new Object[] { this.a.e }), this.a);
          this.a.jdField_a_of_type_Xnw.a(this.a);
        }
        if (this.a.jdField_a_of_type_Xnw.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Xnw.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_Bbgu == null) {
          this.a.jdField_a_of_type_Bbgu = bbdj.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690484), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690485), 2131690832, 2131694794, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_Bbgu.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_Bbgu.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_Bbgu.show();
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
    bcql.a(bcyb.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bczr
 * JD-Core Version:    0.7.0.1
 */