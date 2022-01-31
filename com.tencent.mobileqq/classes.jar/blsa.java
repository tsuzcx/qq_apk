import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blsa
{
  public int a;
  public ArrayList<blsb> a;
  public ArrayList<blsb> b = new ArrayList();
  
  public blsa()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static blsa a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new blsa();
    }
    localblsa = new blsa();
    try
    {
      paramString = new JSONObject(paramString);
      localblsa.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < blrz.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(blrz.a[k]);
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
              blsb localblsb = new blsb();
              localblsb.jdField_a_of_type_JavaLangString = str;
              localblsb.c = k;
              localblsb.b = i1;
              n = i;
              if (localblsa.jdField_a_of_type_Int >= i1)
              {
                localblsb.jdField_a_of_type_Int = i;
                localblsa.jdField_a_of_type_JavaUtilArrayList.add(localblsb);
                n = i + 1;
              }
              localblsa.b.add(localblsb);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localblsa;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsa
 * JD-Core Version:    0.7.0.1
 */