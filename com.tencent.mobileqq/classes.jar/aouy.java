import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aouy
  extends aouf<aoux>
{
  static aoux a = new aoux();
  
  public static aoux c()
  {
    aoux localaoux2 = (aoux)aoks.a().a(444);
    aoux localaoux1 = localaoux2;
    if (localaoux2 == null) {
      localaoux1 = a;
    }
    return localaoux1;
  }
  
  public int a()
  {
    return 444;
  }
  
  @NonNull
  public aoux a()
  {
    return a;
  }
  
  @NonNull
  public aoux a(@NonNull aoko[] paramArrayOfaoko)
  {
    aoux localaoux = new aoux();
    int m = paramArrayOfaoko.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaoko[i];
      if (j > ((aoko)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((aoko)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaoko[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
            localaoux.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localaoux.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            wxe.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaoko[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localaoux;
  }
  
  public Class<aoux> a()
  {
    return aoux.class;
  }
  
  @NonNull
  public aoux b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouy
 * JD-Core Version:    0.7.0.1
 */