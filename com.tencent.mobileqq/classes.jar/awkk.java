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

class awkk
  implements View.OnClickListener
{
  awkk(awki paramawki, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    awwa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_Awki.jdField_a_of_type_Awow.m);
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", awsq.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      awsq.a(paramView, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_Awki.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(awsq.a(this.jdField_a_of_type_Awki.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(awki.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkk
 * JD-Core Version:    0.7.0.1
 */