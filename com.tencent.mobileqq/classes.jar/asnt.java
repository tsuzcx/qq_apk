import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class asnt
{
  public int a;
  public String a;
  public int b;
  
  public asnt()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public asnt(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  public static String a(ArrayList<asnt> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        asnt localasnt = (asnt)paramArrayList.get(i);
        JSONObject localJSONObject;
        if (localasnt != null) {
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("tagId", localasnt.jdField_a_of_type_Int);
          localJSONObject.put("tagName", localasnt.jdField_a_of_type_JavaLangString);
          localJSONObject.put("isHotTag", localasnt.b);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("TagInfo CLASS", 2, "convertToJson error" + localException.toString());
          }
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{tagId: ").append(this.jdField_a_of_type_Int).append("}");
    localStringBuilder.append("{tagName: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    localStringBuilder.append("{isHotTag: ").append(this.b).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnt
 * JD-Core Version:    0.7.0.1
 */