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

class bcbh
  implements HorizontalListView.OnScrollLinstener
{
  bcbh(bcbg parambcbg, HorizontalListView paramHorizontalListView) {}
  
  public void onScroll()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    long l1 = DeviceInfoUtil.getWidth();
    long l2 = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_Bcbg.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_Bcbg.jdField_a_of_type_JavaUtilList.size()))
      {
        bcga localbcga = (bcga)this.jdField_a_of_type_Bcbg.jdField_a_of_type_JavaUtilList.get(i);
        bbzr localbbzr;
        JSONObject localJSONObject;
        if (bbzq.b.containsKey(localbcga))
        {
          localbbzr = (bbzr)bbzq.b.get(localbcga);
          if (!localbbzr.jdField_a_of_type_Boolean)
          {
            localbbzr.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", bcjs.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localbbzr.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localbcga.b);
          localJSONObject.put("tepl", localbcga.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjs.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localbcga.a + "").obj2(localbcga.j).ver1(localbbzr.jdField_a_of_type_JavaLangString).ver2(bcjs.a(this.jdField_a_of_type_Bcbg.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.a));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e(bcbg.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbh
 * JD-Core Version:    0.7.0.1
 */