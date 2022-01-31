import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class awox
  extends awor
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  public JSONObject a;
  public String b;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = awox.class.getSimpleName();
  }
  
  protected awox(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramInt2;
    b(paramJSONObject);
  }
  
  protected awox(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramInt2;
    b(paramJSONObject);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(View paramView)
  {
    awix localawix;
    JSONObject localJSONObject;
    if (awiw.b.containsKey(this))
    {
      localawix = (awix)awiw.b.get(this);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", awsq.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localawix.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("extra_info", this.b);
      localJSONObject.put("tepl", this.f);
      awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.jdField_a_of_type_Long + "").obj2(this.j).ver1(this.g).ver2(awsq.a(this.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
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
  
  public void a(awxd paramawxd) {}
  
  public void b(JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awox
 * JD-Core Version:    0.7.0.1
 */