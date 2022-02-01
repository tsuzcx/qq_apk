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

public class bkpw
  implements bays
{
  public static final String a;
  public static final String b = amtj.a(2131704505);
  private List<bayt> a;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bkpw.class.getSimpleName();
  }
  
  public bkpw(List<bayt> paramList, String paramString)
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
    return amtj.a(2131704511);
  }
  
  public List<bayt> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (batb.b.containsKey(this)))
    {
      localObject = (batc)batb.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bbda.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((batc)localObject).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bbda.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((batc)localObject).jdField_a_of_type_Long + "").obj2(((batc)localObject).b).ver1(((batc)localObject).jdField_a_of_type_JavaLangString).ver2(bbda.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + batb.jdField_a_of_type_Long));
      localObject = (BaseActivity)paramView.getContext();
      FavoriteSearchActivity.a((Context)localObject, this.c);
      bkox.a((Activity)localObject, ((BaseActivity)localObject).getAppRuntime().getAccount(), 0L);
      bbgk.a(this.c, 60, 0, paramView);
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
 * Qualified Name:     bkpw
 * JD-Core Version:    0.7.0.1
 */