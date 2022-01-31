import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjgp
{
  public int a;
  public ArrayList<bjgq> a;
  public ArrayList<bjgq> b = new ArrayList();
  
  public bjgp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bjgp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bjgp();
    }
    localbjgp = new bjgp();
    try
    {
      paramString = new JSONObject(paramString);
      localbjgp.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bjgo.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bjgo.a[k]);
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
              bjgq localbjgq = new bjgq();
              localbjgq.jdField_a_of_type_JavaLangString = str;
              localbjgq.c = k;
              localbjgq.b = i1;
              n = i;
              if (localbjgp.jdField_a_of_type_Int >= i1)
              {
                localbjgq.jdField_a_of_type_Int = i;
                localbjgp.jdField_a_of_type_JavaUtilArrayList.add(localbjgq);
                n = i + 1;
              }
              localbjgp.b.add(localbjgq);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbjgp;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgp
 * JD-Core Version:    0.7.0.1
 */