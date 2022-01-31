import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class ayoo
  extends ayod
{
  public static final String a;
  public List<ayoz> a;
  public String b;
  public boolean b;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = ayon.class.getSimpleName();
  }
  
  public ayoo(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  private List<ayoz> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        localObject = new ayoz(((JSONObject)localObject).optString("word"), ((JSONObject)localObject).optString("url"));
        if (((ayoz)localObject).a()) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a(String paramString)
  {
    this.f = false;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_JavaLangString = paramString.optString("leftIconUrl");
      this.j = paramString.optString("title");
      this.k = paramString.optString("summary");
      this.jdField_b_of_type_Boolean = paramString.optBoolean("isShowArrow");
      this.l = paramString.optString("jumpUrl");
      this.m = paramString.optString("subItemLeftIconUrl");
      paramString = paramString.optJSONArray("itemList");
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilList = a(paramString);
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoo
 * JD-Core Version:    0.7.0.1
 */