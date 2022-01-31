import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class ayno
  implements View.OnClickListener
{
  ayno(aynf paramaynf, Context paramContext, aykk paramaykk) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ayrd.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aykk.a.jdField_a_of_type_JavaLangString);
    aydx localaydx;
    JSONObject localJSONObject;
    if (aydw.b.containsKey(this.jdField_a_of_type_Aykk))
    {
      localaydx = (aydx)aydw.b.get(this.jdField_a_of_type_Aykk);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", aynt.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localaydx.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      aynt.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localaydx.jdField_a_of_type_Long + "").obj2(localaydx.b).ver1(localaydx.jdField_a_of_type_JavaLangString).ver2(aynt.a(this.jdField_a_of_type_Aykk.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
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
 * Qualified Name:     ayno
 * JD-Core Version:    0.7.0.1
 */