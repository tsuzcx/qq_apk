import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class bbiv
  implements bkld
{
  bbiv(bbiu parambbiu, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = bgln.k();
    long l2 = bggq.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Bbiu.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Bbiu.jdField_a_of_type_JavaUtilList.size()))
      {
        bbnp localbbnp = (bbnp)this.jdField_a_of_type_Bbiu.jdField_a_of_type_JavaUtilList.get(i);
        bbhe localbbhe;
        JSONObject localJSONObject;
        if (bbhd.b.containsKey(localbbnp))
        {
          localbbhe = (bbhe)bbhd.b.get(localbbnp);
          if (!localbbhe.jdField_a_of_type_Boolean)
          {
            localbbhe.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", bbrf.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localbbhe.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localbbnp.b);
          localJSONObject.put("tepl", localbbnp.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bbrf.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localbbnp.a + "").obj2(localbbnp.j).ver1(localbbhe.jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.jdField_a_of_type_Bbiu.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbhd.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(bbiu.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiv
 * JD-Core Version:    0.7.0.1
 */