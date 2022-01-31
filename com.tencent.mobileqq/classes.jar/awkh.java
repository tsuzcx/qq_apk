import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class awkh
  implements bfrw
{
  awkh(awkg paramawkg, HorizontalListView paramHorizontalListView) {}
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = bbct.k();
    long l2 = bawz.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Awkg.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Awkg.jdField_a_of_type_JavaUtilList.size()))
      {
        awox localawox = (awox)this.jdField_a_of_type_Awkg.jdField_a_of_type_JavaUtilList.get(i);
        awiv localawiv;
        JSONObject localJSONObject;
        if (awiu.b.containsKey(localawox))
        {
          localawiv = (awiv)awiu.b.get(localawox);
          if (!localawiv.jdField_a_of_type_Boolean)
          {
            localawiv.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", awso.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localawiv.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localawox.b);
          localJSONObject.put("tepl", localawox.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awso.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localawox.a + "").obj2(localawox.j).ver1(localawiv.jdField_a_of_type_JavaLangString).ver2(awso.a(this.jdField_a_of_type_Awkg.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiu.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(awkg.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkh
 * JD-Core Version:    0.7.0.1
 */