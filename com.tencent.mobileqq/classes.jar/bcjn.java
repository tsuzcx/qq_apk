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

class bcjn
  implements View.OnClickListener
{
  bcjn(bcje parambcje, Context paramContext, bcgi parambcgi) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bcnc.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcgi.a.jdField_a_of_type_JavaLangString);
    bbzr localbbzr;
    JSONObject localJSONObject;
    if (bbzq.b.containsKey(this.jdField_a_of_type_Bcgi))
    {
      localbbzr = (bbzr)bbzq.b.get(this.jdField_a_of_type_Bcgi);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbzr.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbbzr.jdField_a_of_type_Long + "").obj2(localbbzr.b).ver1(localbbzr.jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.jdField_a_of_type_Bcgi.c)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
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
 * Qualified Name:     bcjn
 * JD-Core Version:    0.7.0.1
 */