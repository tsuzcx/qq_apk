import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bprl
{
  public int a;
  public ArrayList<bprm> a;
  public ArrayList<bprm> b = new ArrayList();
  
  public bprl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bprl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bprl();
    }
    localbprl = new bprl();
    try
    {
      paramString = new JSONObject(paramString);
      localbprl.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < bprk.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(bprk.a[k]);
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
              bprm localbprm = new bprm();
              localbprm.jdField_a_of_type_JavaLangString = str;
              localbprm.c = k;
              localbprm.b = i1;
              n = i;
              if (localbprl.jdField_a_of_type_Int >= i1)
              {
                localbprm.jdField_a_of_type_Int = i;
                localbprl.jdField_a_of_type_JavaUtilArrayList.add(localbprm);
                n = i + 1;
              }
              localbprl.b.add(localbprm);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localbprl;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprl
 * JD-Core Version:    0.7.0.1
 */