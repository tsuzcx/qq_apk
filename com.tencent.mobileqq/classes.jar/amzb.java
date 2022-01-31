import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzb
  extends amyi<amza>
{
  static amza a = new amza();
  
  public static amza c()
  {
    amza localamza2 = (amza)ampm.a().a(444);
    amza localamza1 = localamza2;
    if (localamza2 == null) {
      localamza1 = a;
    }
    return localamza1;
  }
  
  public int a()
  {
    return 444;
  }
  
  @NonNull
  public amza a()
  {
    return a;
  }
  
  @NonNull
  public amza a(@NonNull ampi[] paramArrayOfampi)
  {
    amza localamza = new amza();
    int m = paramArrayOfampi.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfampi[i];
      if (j > ((ampi)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((ampi)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfampi[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
            localamza.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localamza.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            veg.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfampi[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localamza;
  }
  
  public Class<amza> a()
  {
    return amza.class;
  }
  
  @NonNull
  public amza b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzb
 * JD-Core Version:    0.7.0.1
 */