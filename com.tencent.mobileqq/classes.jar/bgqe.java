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

public class bgqe
  implements awof
{
  public static final String a;
  public static final String b = ajyc.a(2131705372);
  private List<awog> a;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgqe.class.getSimpleName();
  }
  
  public bgqe(List<awog> paramList, String paramString)
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
    return ajyc.a(2131705378);
  }
  
  public List<awog> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (awiu.b.containsKey(this)))
    {
      localObject = (awiv)awiu.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", awso.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((awiv)localObject).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      awso.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((awiv)localObject).jdField_a_of_type_Long + "").obj2(((awiv)localObject).b).ver1(((awiv)localObject).jdField_a_of_type_JavaLangString).ver2(awso.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
      localObject = (BaseActivity)paramView.getContext();
      FavoriteSearchActivity.a((Context)localObject, this.c);
      bgpf.a((Activity)localObject, ((BaseActivity)localObject).getAppRuntime().getAccount(), 0L);
      awvy.a(this.c, 60, 0, paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqe
 * JD-Core Version:    0.7.0.1
 */