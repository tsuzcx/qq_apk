import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arkc
  extends arjj<arkb>
{
  static arkb a = new arkb();
  
  public static arkb c()
  {
    arkb localarkb2 = (arkb)aqxe.a().a(444);
    arkb localarkb1 = localarkb2;
    if (localarkb2 == null) {
      localarkb1 = a;
    }
    return localarkb1;
  }
  
  @NonNull
  public arkb a()
  {
    return a;
  }
  
  @NonNull
  public arkb a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    arkb localarkb = new arkb();
    int m = paramArrayOfaqxa.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaqxa[i];
      if (j > ((aqxa)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((aqxa)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
            localarkb.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localarkb.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            ykq.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localarkb;
  }
  
  @NonNull
  public arkb b()
  {
    return a;
  }
  
  public Class<arkb> clazz()
  {
    return arkb.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkc
 * JD-Core Version:    0.7.0.1
 */