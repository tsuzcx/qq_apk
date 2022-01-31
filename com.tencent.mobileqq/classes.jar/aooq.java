import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aooq
  implements avom
{
  public static final String a;
  public static final String b = ajjy.a(2131639596);
  int jdField_a_of_type_Int = -1;
  List<avon> jdField_a_of_type_JavaUtilList;
  String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = aooq.class.getSimpleName();
  }
  
  public aooq(List<avon> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return ajjy.a(2131639578);
  }
  
  public List<avon> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    avjc localavjc;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (avjb.b.containsKey(this)))
    {
      localavjc = (avjc)avjb.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", avsv.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localavjc.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      avsv.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localavjc.jdField_a_of_type_Long + "").obj2(localavjc.b).ver1(localavjc.jdField_a_of_type_JavaLangString).ver2(avsv.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
      avwf.a(this.c, 100, 0, paramView);
      apci.a("0X8006061");
      avsv.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5B", 0, 0, null, null);
      FileSearchActivity.a(paramView.getContext(), this.c, this.jdField_a_of_type_JavaUtilList, true, this.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > a()) {
      avsv.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5A", 0, 0, null, null);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooq
 * JD-Core Version:    0.7.0.1
 */