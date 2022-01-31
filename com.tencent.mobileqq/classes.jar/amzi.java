import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzi
  extends amyp<amzh>
{
  static amzh a = new amzh();
  
  public static amzh c()
  {
    amzh localamzh2 = (amzh)ampl.a().a(444);
    amzh localamzh1 = localamzh2;
    if (localamzh2 == null) {
      localamzh1 = a;
    }
    return localamzh1;
  }
  
  public int a()
  {
    return 444;
  }
  
  @NonNull
  public amzh a()
  {
    return a;
  }
  
  @NonNull
  public amzh a(@NonNull amph[] paramArrayOfamph)
  {
    amzh localamzh = new amzh();
    int m = paramArrayOfamph.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfamph[i];
      if (j > ((amph)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((amph)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfamph[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
            localamzh.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localamzh.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            ved.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfamph[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localamzh;
  }
  
  public Class<amzh> a()
  {
    return amzh.class;
  }
  
  @NonNull
  public amzh b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzi
 * JD-Core Version:    0.7.0.1
 */