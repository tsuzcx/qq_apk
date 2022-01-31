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

class ayrv
  implements View.OnClickListener
{
  ayrv(ayro paramayro, Context paramContext, ayot paramayot) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ayvm.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ayot.a.jdField_a_of_type_JavaLangString);
    ayig localayig;
    JSONObject localJSONObject;
    if (ayif.b.containsKey(this.jdField_a_of_type_Ayot))
    {
      localayig = (ayig)ayif.b.get(this.jdField_a_of_type_Ayot);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", aysc.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localayig.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      aysc.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localayig.jdField_a_of_type_Long + "").obj2(localayig.b).ver1(localayig.jdField_a_of_type_JavaLangString).ver2(aysc.a(this.jdField_a_of_type_Ayot.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
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
 * Qualified Name:     ayrv
 * JD-Core Version:    0.7.0.1
 */