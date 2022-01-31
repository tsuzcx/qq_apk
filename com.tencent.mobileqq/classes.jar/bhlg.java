import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bhlg
{
  public int a;
  public ArrayList<bhlh> a;
  public ArrayList<bhlh> b = new ArrayList();
  
  public bhlg()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bhlg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bhlg();
    }
    localbhlg = new bhlg();
    try
    {
      paramString = new JSONObject(paramString);
      localbhlg.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bhlf.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bhlf.a[k]);
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
              bhlh localbhlh = new bhlh();
              localbhlh.jdField_a_of_type_JavaLangString = str;
              localbhlh.c = k;
              localbhlh.b = i1;
              n = i;
              if (localbhlg.jdField_a_of_type_Int >= i1)
              {
                localbhlh.jdField_a_of_type_Int = i;
                localbhlg.jdField_a_of_type_JavaUtilArrayList.add(localbhlh);
                n = i + 1;
              }
              localbhlg.b.add(localbhlh);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbhlg;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlg
 * JD-Core Version:    0.7.0.1
 */