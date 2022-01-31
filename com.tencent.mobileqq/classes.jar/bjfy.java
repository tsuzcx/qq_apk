import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjfy
{
  public int a;
  public ArrayList<bjfz> a;
  public ArrayList<bjfz> b = new ArrayList();
  
  public bjfy()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bjfy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bjfy();
    }
    localbjfy = new bjfy();
    try
    {
      paramString = new JSONObject(paramString);
      localbjfy.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bjfx.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bjfx.a[k]);
          int n = i;
          if (localJSONArray != null)
          {
            int m = 0;
            for (;;)
            {
              n = i;
              if (m >= localJSONArray.length()) {
                break;
              }
              String str = localJSONArray.getString(m);
              bjfz localbjfz = new bjfz();
              localbjfz.jdField_a_of_type_JavaLangString = str;
              localbjfz.c = k;
              localbjfz.b = i1;
              n = i;
              if (localbjfy.jdField_a_of_type_Int >= i1)
              {
                localbjfz.jdField_a_of_type_Int = i;
                localbjfy.jdField_a_of_type_JavaUtilArrayList.add(localbjfz);
                n = i + 1;
              }
              localbjfy.b.add(localbjfz);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbjfy;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfy
 * JD-Core Version:    0.7.0.1
 */