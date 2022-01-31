import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ayjs
  implements bhxr
{
  ayjs(ayjr paramayjr, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = bdgk.k();
    long l2 = bdaq.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Ayjr.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Ayjr.jdField_a_of_type_JavaUtilList.size()))
      {
        ayol localayol = (ayol)this.jdField_a_of_type_Ayjr.jdField_a_of_type_JavaUtilList.get(i);
        ayig localayig;
        JSONObject localJSONObject;
        if (ayif.b.containsKey(localayol))
        {
          localayig = (ayig)ayif.b.get(localayol);
          if (!localayig.jdField_a_of_type_Boolean)
          {
            localayig.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", aysc.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localayig.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localayol.b);
          localJSONObject.put("tepl", localayol.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          aysc.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localayol.a + "").obj2(localayol.j).ver1(localayig.jdField_a_of_type_JavaLangString).ver2(aysc.a(this.jdField_a_of_type_Ayjr.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(ayjr.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjs
 * JD-Core Version:    0.7.0.1
 */