import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollLinstener;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class baur
  implements HorizontalListView.OnScrollLinstener
{
  baur(bauq parambauq, HorizontalListView paramHorizontalListView) {}
  
  public void onScroll()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = DeviceInfoUtil.getWidth();
    long l2 = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Bauq.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Bauq.jdField_a_of_type_JavaUtilList.size()))
      {
        bazk localbazk = (bazk)this.jdField_a_of_type_Bauq.jdField_a_of_type_JavaUtilList.get(i);
        batc localbatc;
        JSONObject localJSONObject;
        if (batb.b.containsKey(localbazk))
        {
          localbatc = (batc)batb.b.get(localbazk);
          if (!localbatc.jdField_a_of_type_Boolean)
          {
            localbatc.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", bbda.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localbatc.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localbazk.b);
          localJSONObject.put("tepl", localbazk.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bbda.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localbazk.a + "").obj2(localbazk.j).ver1(localbatc.jdField_a_of_type_JavaLangString).ver2(bbda.a(this.jdField_a_of_type_Bauq.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + batb.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(bauq.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baur
 * JD-Core Version:    0.7.0.1
 */