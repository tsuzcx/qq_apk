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

class avso
  implements View.OnClickListener
{
  avso(avsh paramavsh, Context paramContext, avpm paramavpm) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    avwf.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Avpm.a.jdField_a_of_type_JavaLangString);
    avjc localavjc;
    JSONObject localJSONObject;
    if (avjb.b.containsKey(this.jdField_a_of_type_Avpm))
    {
      localavjc = (avjc)avjb.b.get(this.jdField_a_of_type_Avpm);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", avsv.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localavjc.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      avsv.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localavjc.jdField_a_of_type_Long + "").obj2(localavjc.b).ver1(localavjc.jdField_a_of_type_JavaLangString).ver2(avsv.a(this.jdField_a_of_type_Avpm.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
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
 * Qualified Name:     avso
 * JD-Core Version:    0.7.0.1
 */