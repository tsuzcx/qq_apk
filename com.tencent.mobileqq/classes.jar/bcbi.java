import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class bcbi
  implements View.OnClickListener
{
  bcbi(bcbg parambcbg, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    bcnc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_Bcbg.jdField_a_of_type_Bcfx.m);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      bcjs.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_Bcbg.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(bcjs.a(this.jdField_a_of_type_Bcbg.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(bcbg.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbi
 * JD-Core Version:    0.7.0.1
 */