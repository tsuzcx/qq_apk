import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bokj
{
  public int a;
  public ArrayList<bokk> a;
  public ArrayList<bokk> b = new ArrayList();
  
  public bokj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bokj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bokj();
    }
    localbokj = new bokj();
    try
    {
      paramString = new JSONObject(paramString);
      localbokj.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < boki.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(boki.a[k]);
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
              bokk localbokk = new bokk();
              localbokk.jdField_a_of_type_JavaLangString = str;
              localbokk.c = k;
              localbokk.b = i1;
              n = i;
              if (localbokj.jdField_a_of_type_Int >= i1)
              {
                localbokk.jdField_a_of_type_Int = i;
                localbokj.jdField_a_of_type_JavaUtilArrayList.add(localbokk);
                n = i + 1;
              }
              localbokj.b.add(localbokk);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbokj;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokj
 * JD-Core Version:    0.7.0.1
 */