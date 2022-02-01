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

class bbra
  implements View.OnClickListener
{
  bbra(bbqr parambbqr, Context paramContext, bbnx parambbnx) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bbup.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbnx.a.jdField_a_of_type_JavaLangString);
    bbhe localbbhe;
    JSONObject localJSONObject;
    if (bbhd.b.containsKey(this.jdField_a_of_type_Bbnx))
    {
      localbbhe = (bbhe)bbhd.b.get(this.jdField_a_of_type_Bbnx);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bbrf.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbhe.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      bbrf.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbbhe.jdField_a_of_type_Long + "").obj2(localbbhe.b).ver1(localbbhe.jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.jdField_a_of_type_Bbnx.c)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
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
 * Qualified Name:     bbra
 * JD-Core Version:    0.7.0.1
 */