import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bcfy
  extends bcga
{
  public int a;
  public bcft a;
  public CharSequence a;
  public String a;
  public List<bcft> a;
  public int b;
  
  public bcfy(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public bcfy(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangCharSequence = bcni.a(paramString.optString("firstLineText"));
      this.jdField_a_of_type_JavaLangString = paramString.optString("firstLineTextPostfix");
      Object localObject1 = paramString.optJSONObject("leftImage");
      if (localObject1 != null) {
        this.jdField_a_of_type_Bcft = new bcft(((JSONObject)localObject1).optString("url"), ((JSONObject)localObject1).optInt("type"));
      }
      this.b = paramString.optInt("allHeight");
      localObject1 = paramString.optJSONArray("imageList");
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(((JSONArray)localObject1).length());
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new bcft(((JSONObject)localObject2).optString("url"), ((JSONObject)localObject2).optInt("type"));
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      this.jdField_a_of_type_Int = paramString.optInt("imageTotalCount");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfy
 * JD-Core Version:    0.7.0.1
 */