import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class avko
  implements bekc
{
  avko(avkn paramavkn, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = babp.k();
    long l2 = azvv.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Avkn.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Avkn.jdField_a_of_type_JavaUtilList.size()))
      {
        avpe localavpe = (avpe)this.jdField_a_of_type_Avkn.jdField_a_of_type_JavaUtilList.get(i);
        avjc localavjc;
        JSONObject localJSONObject;
        if (avjb.b.containsKey(localavpe))
        {
          localavjc = (avjc)avjb.b.get(localavpe);
          if (!localavjc.jdField_a_of_type_Boolean)
          {
            localavjc.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", avsv.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localavjc.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localavpe.b);
          localJSONObject.put("tepl", localavpe.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          avsv.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localavpe.a + "").obj2(localavpe.j).ver1(localavjc.jdField_a_of_type_JavaLangString).ver2(avsv.a(this.jdField_a_of_type_Avkn.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + avjb.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(avkn.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avko
 * JD-Core Version:    0.7.0.1
 */