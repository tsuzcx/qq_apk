import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bcer
  extends bcgr
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c = "xiaoweiba";
  
  public bcer(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(View paramView)
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    if (!TextUtils.isEmpty(this.b))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = bhey.a(localQQAppInterface, paramView.getContext(), this.b);
      if (localObject == null) {
        break label173;
      }
      ((bheh)localObject).a();
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("project", bcjs.a());
        paramView.put("event_src", "client");
        paramView.put("get_src", "web");
        bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_tail").obj1(this.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(bcjs.a(UniteSearchActivity.d)).ver7(paramView.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
        return;
        label173:
        if ((!this.b.startsWith("http://")) && (!this.b.startsWith("https://"))) {
          continue;
        }
        paramView = paramView.getContext();
        localObject = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.b);
        paramView.startActivity((Intent)localObject);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + localJSONException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcer
 * JD-Core Version:    0.7.0.1
 */