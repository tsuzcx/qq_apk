import org.json.JSONObject;

public class aqbn
{
  public int a;
  public String a;
  public int b;
  
  public aqbn()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqbn a(aptx[] paramArrayOfaptx)
  {
    localaqbn = new aqbn();
    int i = 0;
    try
    {
      while (i < paramArrayOfaptx.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("preloadSwitch"))
        {
          localaqbn.jdField_a_of_type_Int = localJSONObject.optInt("preloadSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preloadswtich=" + localaqbn.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localaqbn.b = localJSONObject.optInt("preloadInterval", 30);
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed swtich=" + localaqbn.b);
          }
        }
        if (localJSONObject.has("preloadUrl"))
        {
          localaqbn.jdField_a_of_type_JavaLangString = localJSONObject.optString("preloadUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preload url=" + localaqbn.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localaqbn;
    }
    catch (Throwable paramArrayOfaptx)
    {
      com.tencent.TMG.utils.QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaptx.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbn
 * JD-Core Version:    0.7.0.1
 */