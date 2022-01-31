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
  awsj(awsa paramawsa, Context paramContext, awpf paramawpf) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    awvy.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Awpf.a.jdField_a_of_type_JavaLangString);
    awiv localawiv;
    JSONObject localJSONObject;
    if (awiu.b.containsKey(this.jdField_a_of_type_Awpf))
    {
      localawiv = (awiv)awiu.b.get(this.jdField_a_of_type_Awpf);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", awso.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localawiv.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      awso.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localawiv.jdField_a_of_type_Long + "").obj2(localawiv.b).ver1(localawiv.jdField_a_of_type_JavaLangString).ver2(awso.a(this.jdField_a_of_type_Awpf.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
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