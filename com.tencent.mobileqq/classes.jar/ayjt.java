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

class ayjt
  implements View.OnClickListener
{
  ayjt(ayjr paramayjr, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    ayvm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_Ayjr.jdField_a_of_type_Ayoi.m);
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", aysc.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      aysc.a(paramView, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_Ayjr.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(aysc.a(this.jdField_a_of_type_Ayjr.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(ayjr.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjt
 * JD-Core Version:    0.7.0.1
 */