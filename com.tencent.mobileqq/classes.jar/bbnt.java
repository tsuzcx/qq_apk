import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bbnt
  extends bbnh
{
  public static final String a;
  public List<bbkz> a;
  public String b;
  public String j;
  public String k;
  
  static
  {
    jdField_a_of_type_JavaLangString = bbnt.class.getSimpleName();
  }
  
  public bbnt(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public bbnt(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("askIcon");
      this.j = paramString.optString("headLine");
      this.k = paramString.optString("answerNumText");
      paramString = paramString.optJSONArray("answers");
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          Object localObject1 = ((JSONObject)localObject2).optString("leftIcon");
          String str1 = ((JSONObject)localObject2).optString("userNameText");
          String str2 = ((JSONObject)localObject2).optString("praiseText");
          String str3 = ((JSONObject)localObject2).optString("answerText");
          int n = ((JSONObject)localObject2).optInt("imageTotalCount");
          localObject2 = ((JSONObject)localObject2).optJSONArray("imageList");
          ArrayList localArrayList = new ArrayList();
          if (localObject2 != null)
          {
            int m = 0;
            while (m < ((JSONArray)localObject2).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(m);
              localArrayList.add(new bbna(localJSONObject.optString("url"), localJSONObject.optInt("type")));
              m += 1;
            }
          }
          localObject1 = new bbkz((String)localObject1, str1, str2, str3, n, localArrayList);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
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
 * Qualified Name:     bbnt
 * JD-Core Version:    0.7.0.1
 */