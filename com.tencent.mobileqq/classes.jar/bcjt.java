import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class bcjt
  implements View.OnClickListener
{
  bcjt(bcjk parambcjk, Context paramContext, bcgq parambcgq) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bcni.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcgq.a.jdField_a_of_type_JavaLangString);
    bbzy localbbzy;
    JSONObject localJSONObject;
    if (bbzx.b.containsKey(this.jdField_a_of_type_Bcgq))
    {
      localbbzy = (bbzy)bbzx.b.get(this.jdField_a_of_type_Bcgq);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bcjy.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbzy.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbbzy.jdField_a_of_type_Long + "").obj2(localbbzy.b).ver1(localbbzy.jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.jdField_a_of_type_Bcgq.c)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjt
 * JD-Core Version:    0.7.0.1
 */