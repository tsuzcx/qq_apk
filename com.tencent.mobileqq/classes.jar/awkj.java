import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class awkj
  implements bfsn
{
  awkj(awki paramawki, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = bbdh.k();
    long l2 = baxn.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Awki.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Awki.jdField_a_of_type_JavaUtilList.size()))
      {
        awoz localawoz = (awoz)this.jdField_a_of_type_Awki.jdField_a_of_type_JavaUtilList.get(i);
        awix localawix;
        JSONObject localJSONObject;
        if (awiw.b.containsKey(localawoz))
        {
          localawix = (awix)awiw.b.get(localawoz);
          if (!localawix.jdField_a_of_type_Boolean)
          {
            localawix.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", awsq.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localawix.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localawoz.b);
          localJSONObject.put("tepl", localawoz.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awsq.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localawoz.a + "").obj2(localawoz.j).ver1(localawix.jdField_a_of_type_JavaLangString).ver2(awsq.a(this.jdField_a_of_type_Awki.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiw.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(awki.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkj
 * JD-Core Version:    0.7.0.1
 */