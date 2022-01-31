import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdot
  extends bdof
{
  private List<String> a;
  
  public bdot()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray(this.jdField_a_of_type_JavaLangString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramString.getString(i));
          i += 1;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdot
 * JD-Core Version:    0.7.0.1
 */