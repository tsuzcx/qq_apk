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

public class auaa
  implements bcfq
{
  public static final String a;
  public static final String b = anzj.a(2131704284);
  int jdField_a_of_type_Int = -1;
  List<bcfr> jdField_a_of_type_JavaUtilList;
  String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = auaa.class.getSimpleName();
  }
  
  public auaa(List<bcfr> paramList, String paramString, int paramInt)
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
    return anzj.a(2131704266);
  }
  
  public List<bcfr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bbzy localbbzy;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (bbzx.b.containsKey(this)))
    {
      localbbzy = (bbzy)bbzx.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bcjy.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbzy.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localbbzy.jdField_a_of_type_Long + "").obj2(localbbzy.b).ver1(localbbzy.jdField_a_of_type_JavaLangString).ver2(bcjy.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
      bcni.a(this.c, 100, 0, paramView);
      aunh.a("0X8006061");
      bcjy.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5B", 0, 0, null, null);
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
      bcjy.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5A", 0, 0, null, null);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaa
 * JD-Core Version:    0.7.0.1
 */