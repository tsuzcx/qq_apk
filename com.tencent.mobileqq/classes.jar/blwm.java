import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blwm
{
  public int a;
  public ArrayList<blwn> a;
  public ArrayList<blwn> b = new ArrayList();
  
  public blwm()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static blwm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new blwm();
    }
    localblwm = new blwm();
    try
    {
      paramString = new JSONObject(paramString);
      localblwm.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < blwl.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(blwl.a[k]);
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
              blwn localblwn = new blwn();
              localblwn.jdField_a_of_type_JavaLangString = str;
              localblwn.c = k;
              localblwn.b = i1;
              n = i;
              if (localblwm.jdField_a_of_type_Int >= i1)
              {
                localblwn.jdField_a_of_type_Int = i;
                localblwm.jdField_a_of_type_JavaUtilArrayList.add(localblwn);
                n = i + 1;
              }
              localblwm.b.add(localblwn);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localblwm;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwm
 * JD-Core Version:    0.7.0.1
 */