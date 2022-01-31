import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqp
  extends aopw<aoqo>
{
  static aoqo a = new aoqo();
  
  public static aoqo c()
  {
    aoqo localaoqo2 = (aoqo)aogj.a().a(444);
    aoqo localaoqo1 = localaoqo2;
    if (localaoqo2 == null) {
      localaoqo1 = a;
    }
    return localaoqo1;
  }
  
  public int a()
  {
    return 444;
  }
  
  @NonNull
  public aoqo a()
  {
    return a;
  }
  
  @NonNull
  public aoqo a(@NonNull aogf[] paramArrayOfaogf)
  {
    aoqo localaoqo = new aoqo();
    int m = paramArrayOfaogf.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaogf[i];
      if (j > ((aogf)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((aogf)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaogf[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
            localaoqo.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localaoqo.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            wsv.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaogf[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localaoqo;
  }
  
  public Class<aoqo> a()
  {
    return aoqo.class;
  }
  
  @NonNull
  public aoqo b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqp
 * JD-Core Version:    0.7.0.1
 */