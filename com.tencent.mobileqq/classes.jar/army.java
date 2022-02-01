import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class army
  extends armf<armx>
{
  static armx a = new armx();
  
  public static armx c()
  {
    armx localarmx2 = (armx)aran.a().a(444);
    armx localarmx1 = localarmx2;
    if (localarmx2 == null) {
      localarmx1 = a;
    }
    return localarmx1;
  }
  
  @NonNull
  public armx a()
  {
    return a;
  }
  
  @NonNull
  public armx a(@NonNull araj[] paramArrayOfaraj)
  {
    armx localarmx = new armx();
    int m = paramArrayOfaraj.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaraj[i];
      if (j > ((araj)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((araj)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaraj[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
            localarmx.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localarmx.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            yuk.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaraj[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localarmx;
  }
  
  @NonNull
  public armx b()
  {
    return a;
  }
  
  public Class<armx> clazz()
  {
    return armx.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     army
 * JD-Core Version:    0.7.0.1
 */