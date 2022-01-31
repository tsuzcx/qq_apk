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

class awsj
  implements View.OnClickListener
{
  awsj(awsc paramawsc, Context paramContext, awph paramawph) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    awwa.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Awph.a.jdField_a_of_type_JavaLangString);
    awix localawix;
    JSONObject localJSONObject;
    if (awiw.b.containsKey(this.jdField_a_of_type_Awph))
    {
      localawix = (awix)awiw.b.get(this.jdField_a_of_type_Awph);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", awsq.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localawix.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localawix.jdField_a_of_type_Long + "").obj2(localawix.b).ver1(localawix.jdField_a_of_type_JavaLangString).ver2(awsq.a(this.jdField_a_of_type_Awph.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
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
 * Qualified Name:     awsj
 * JD-Core Version:    0.7.0.1
 */