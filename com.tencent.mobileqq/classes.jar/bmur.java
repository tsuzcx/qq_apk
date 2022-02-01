import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bmur
{
  public int a;
  public ArrayList<bmus> a;
  public ArrayList<bmus> b = new ArrayList();
  
  public bmur()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bmur a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bmur();
    }
    localbmur = new bmur();
    try
    {
      paramString = new JSONObject(paramString);
      localbmur.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bmuq.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bmuq.a[k]);
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
              bmus localbmus = new bmus();
              localbmus.jdField_a_of_type_JavaLangString = str;
              localbmus.c = k;
              localbmus.b = i1;
              n = i;
              if (localbmur.jdField_a_of_type_Int >= i1)
              {
                localbmus.jdField_a_of_type_Int = i;
                localbmur.jdField_a_of_type_JavaUtilArrayList.add(localbmus);
                n = i + 1;
              }
              localbmur.b.add(localbmus);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbmur;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmur
 * JD-Core Version:    0.7.0.1
 */