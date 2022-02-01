import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class bcbp
  implements blmg
{
  bcbp(bcbo parambcbo, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = bhlo.k();
    long l2 = bhgr.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Bcbo.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Bcbo.jdField_a_of_type_JavaUtilList.size()))
      {
        bcgi localbcgi = (bcgi)this.jdField_a_of_type_Bcbo.jdField_a_of_type_JavaUtilList.get(i);
        bbzy localbbzy;
        JSONObject localJSONObject;
        if (bbzx.b.containsKey(localbcgi))
        {
          localbbzy = (bbzy)bbzx.b.get(localbcgi);
          if (!localbbzy.jdField_a_of_type_Boolean)
          {
            localbbzy.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", bcjy.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localbbzy.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localbcgi.b);
          localJSONObject.put("tepl", localbcgi.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjy.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localbcgi.a + "").obj2(localbcgi.j).ver1(localbbzy.jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.jdField_a_of_type_Bcbo.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzx.a));
          i += 1;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbp
 * JD-Core Version:    0.7.0.1
 */