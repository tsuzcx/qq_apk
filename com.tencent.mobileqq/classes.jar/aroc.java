import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class aroc
  implements View.OnClickListener
{
  public aroc(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.b(this.jdField_a_of_type_OrgJsonJSONObject);
    paramView = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    if (!TextUtils.isEmpty(paramView)) {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(paramView, new String[] { String.valueOf(0) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aroc
 * JD-Core Version:    0.7.0.1
 */