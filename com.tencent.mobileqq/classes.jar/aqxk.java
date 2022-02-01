import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxk
  extends aqwr<aqxj>
{
  static aqxj a = new aqxj();
  
  public static aqxj c()
  {
    aqxj localaqxj2 = (aqxj)aqlk.a().a(444);
    aqxj localaqxj1 = localaqxj2;
    if (localaqxj2 == null) {
      localaqxj1 = a;
    }
    return localaqxj1;
  }
  
  @NonNull
  public aqxj a()
  {
    return a;
  }
  
  @NonNull
  public aqxj a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    aqxj localaqxj = new aqxj();
    int m = paramArrayOfaqlg.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaqlg[i];
      if (j > ((aqlg)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((aqlg)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
            localaqxj.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localaqxj.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            yqp.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localaqxj;
  }
  
  @NonNull
  public aqxj b()
  {
    return a;
  }
  
  public Class<aqxj> clazz()
  {
    return aqxj.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxk
 * JD-Core Version:    0.7.0.1
 */