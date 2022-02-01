import org.json.JSONObject;

public class areq
{
  public int a;
  public String a;
  public int b;
  
  public areq()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static areq a(aqxa[] paramArrayOfaqxa)
  {
    localareq = new areq();
    int i = 0;
    try
    {
      while (i < paramArrayOfaqxa.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("preloadSwitch"))
        {
          localareq.jdField_a_of_type_Int = localJSONObject.optInt("preloadSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preloadswtich=" + localareq.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localareq.b = localJSONObject.optInt("preloadInterval", 30);
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed swtich=" + localareq.b);
          }
        }
        if (localJSONObject.has("preloadUrl"))
        {
          localareq.jdField_a_of_type_JavaLangString = localJSONObject.optString("preloadUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preload url=" + localareq.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localareq;
    }
    catch (Throwable paramArrayOfaqxa)
    {
      com.tencent.TMG.utils.QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaqxa.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areq
 * JD-Core Version:    0.7.0.1
 */