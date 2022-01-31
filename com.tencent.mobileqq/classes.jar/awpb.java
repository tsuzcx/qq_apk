import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class awpb
  extends awor
{
  public static final String a;
  public List<awoo> a;
  public String b;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = awpb.class.getSimpleName();
  }
  
  public awpb(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public awpb(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIconUrl");
      this.j = paramString.optString("title");
      this.k = paramString.optString("summary");
      this.l = paramString.optString("rightIconUrl");
      this.m = paramString.optString("jumpUrl");
      paramString = paramString.optJSONArray("pageInfo");
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.optJSONObject(i);
          localObject = new awoo(((JSONObject)localObject).optString("leftIconUrl"), ((JSONObject)localObject).optString("wording"));
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpb
 * JD-Core Version:    0.7.0.1
 */