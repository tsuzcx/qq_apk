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

class bbct
  implements View.OnClickListener
{
  bbct(bbcm parambbcm, Context paramContext, bazs parambazs) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bbgk.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bazs.a.jdField_a_of_type_JavaLangString);
    batc localbatc;
    JSONObject localJSONObject;
    if (batb.b.containsKey(this.jdField_a_of_type_Bazs))
    {
      localbatc = (batc)batb.b.get(this.jdField_a_of_type_Bazs);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bbda.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbatc.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      bbda.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbatc.jdField_a_of_type_Long + "").obj2(localbatc.b).ver1(localbatc.jdField_a_of_type_JavaLangString).ver2(bbda.a(this.jdField_a_of_type_Bazs.c)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + batb.jdField_a_of_type_Long));
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
 * Qualified Name:     bbct
 * JD-Core Version:    0.7.0.1
 */