import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amix
  extends amie<amiw>
{
  static amiw a = new amiw();
  
  public static amiw c()
  {
    amiw localamiw2 = (amiw)alzw.a().a(444);
    amiw localamiw1 = localamiw2;
    if (localamiw2 == null) {
      localamiw1 = a;
    }
    return localamiw1;
  }
  
  public int a()
  {
    return 444;
  }
  
  @NonNull
  public amiw a()
  {
    return a;
  }
  
  @NonNull
  public amiw a(@NonNull alzs[] paramArrayOfalzs)
  {
    amiw localamiw = new amiw();
    int m = paramArrayOfalzs.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfalzs[i];
      if (j > ((alzs)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((alzs)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfalzs[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
            localamiw.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localamiw.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            urk.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfalzs[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localamiw;
  }
  
  public Class<amiw> a()
  {
    return amiw.class;
  }
  
  @NonNull
  public amiw b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amix
 * JD-Core Version:    0.7.0.1
 */