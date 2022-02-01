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

public class atig
  implements bbmx
{
  public static final String a;
  public static final String b = anni.a(2131704177);
  int jdField_a_of_type_Int = -1;
  List<bbmy> jdField_a_of_type_JavaUtilList;
  String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = atig.class.getSimpleName();
  }
  
  public atig(List<bbmy> paramList, String paramString, int paramInt)
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
    return anni.a(2131704159);
  }
  
  public List<bbmy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bbhe localbbhe;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (bbhd.b.containsKey(this)))
    {
      localbbhe = (bbhe)bbhd.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bbrf.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbhe.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bbrf.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbbhe.jdField_a_of_type_Long + "").obj2(localbbhe.b).ver1(localbbhe.jdField_a_of_type_JavaLangString).ver2(bbrf.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
      bbup.a(this.c, 100, 0, paramView);
      atvm.a("0X8006061");
      bbrf.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5B", 0, 0, null, null);
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
      bbrf.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5A", 0, 0, null, null);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atig
 * JD-Core Version:    0.7.0.1
 */