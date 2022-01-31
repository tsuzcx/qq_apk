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

public class avpc
  extends avow
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  public JSONObject a;
  public String b;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = avpc.class.getSimpleName();
  }
  
  protected avpc(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramInt2;
    b(paramJSONObject);
  }
  
  protected avpc(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
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
    avjc localavjc;
    JSONObject localJSONObject;
    if (avjb.b.containsKey(this))
    {
      localavjc = (avjc)avjb.b.get(this);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", avsv.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localavjc.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("extra_info", this.b);
      localJSONObject.put("tepl", this.f);
      avsv.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.jdField_a_of_type_Long + "").obj2(this.j).ver1(this.g).ver2(avsv.a(this.c)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
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
  
  public void a(avxi paramavxi) {}
  
  public void b(JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpc
 * JD-Core Version:    0.7.0.1
 */