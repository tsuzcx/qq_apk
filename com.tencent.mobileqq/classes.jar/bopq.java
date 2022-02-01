import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bopq
{
  public int a;
  public ArrayList<bopr> a;
  public ArrayList<bopr> b = new ArrayList();
  
  public bopq()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bopq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bopq();
    }
    localbopq = new bopq();
    try
    {
      paramString = new JSONObject(paramString);
      localbopq.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bopp.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bopp.a[k]);
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
              bopr localbopr = new bopr();
              localbopr.jdField_a_of_type_JavaLangString = str;
              localbopr.c = k;
              localbopr.b = i1;
              n = i;
              if (localbopq.jdField_a_of_type_Int >= i1)
              {
                localbopr.jdField_a_of_type_Int = i;
                localbopq.jdField_a_of_type_JavaUtilArrayList.add(localbopr);
                n = i + 1;
              }
              localbopq.b.add(localbopr);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbopq;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopq
 * JD-Core Version:    0.7.0.1
 */