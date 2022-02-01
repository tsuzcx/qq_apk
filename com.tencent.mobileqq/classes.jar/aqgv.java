import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgv
  extends aqgc<aqgu>
{
  static aqgu a = new aqgu();
  
  public static aqgu c()
  {
    aqgu localaqgu2 = (aqgu)apub.a().a(444);
    aqgu localaqgu1 = localaqgu2;
    if (localaqgu2 == null) {
      localaqgu1 = a;
    }
    return localaqgu1;
  }
  
  @NonNull
  public aqgu a()
  {
    return a;
  }
  
  @NonNull
  public aqgu a(@NonNull aptx[] paramArrayOfaptx)
  {
    aqgu localaqgu = new aqgu();
    int m = paramArrayOfaptx.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaptx[i];
      if (j > ((aptx)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((aptx)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaptx[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
            localaqgu.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localaqgu.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            xvv.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaptx[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localaqgu;
  }
  
  @NonNull
  public aqgu b()
  {
    return a;
  }
  
  public Class<aqgu> clazz()
  {
    return aqgu.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgv
 * JD-Core Version:    0.7.0.1
 */