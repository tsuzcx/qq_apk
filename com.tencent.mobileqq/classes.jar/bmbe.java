import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bmbe
  implements bcfi
{
  public static final String a;
  public static final String b = anvx.a(2131704856);
  private List<bcfj> a;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmbe.class.getSimpleName();
  }
  
  public bmbe(List<bcfj> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return anvx.a(2131704862);
  }
  
  public List<bcfj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (bbzq.b.containsKey(this)))
    {
      localObject = (bbzr)bbzq.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((bbzr)localObject).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((bbzr)localObject).jdField_a_of_type_Long + "").obj2(((bbzr)localObject).b).ver1(((bbzr)localObject).jdField_a_of_type_JavaLangString).ver2(bcjs.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
      localObject = (BaseActivity)paramView.getContext();
      FavoriteSearchActivity.a((Context)localObject, this.c);
      bmaf.a((Activity)localObject, ((BaseActivity)localObject).getAppRuntime().getAccount(), 0L);
      bcnc.a(this.c, 60, 0, paramView);
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
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbe
 * JD-Core Version:    0.7.0.1
 */