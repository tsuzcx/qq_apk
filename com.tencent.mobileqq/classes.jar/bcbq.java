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

class bcbq
  implements View.OnClickListener
{
  bcbq(bcbo parambcbo, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    bcni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_Bcbo.jdField_a_of_type_Bcgf.m);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", bcjy.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      bcjy.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_Bcbo.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(bcjy.a(this.jdField_a_of_type_Bcbo.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(bcbo.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbq
 * JD-Core Version:    0.7.0.1
 */