import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class awki
  implements View.OnClickListener
{
  awki(awkg paramawkg, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    awvy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_Awkg.jdField_a_of_type_Awou.m);
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", awso.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      awso.a(paramView, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_Awkg.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(awso.a(this.jdField_a_of_type_Awkg.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(awkg.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awki
 * JD-Core Version:    0.7.0.1
 */