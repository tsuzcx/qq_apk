import org.json.JSONObject;

public class aqsk
{
  public int a;
  public String a;
  public int b;
  
  public aqsk()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqsk a(aqlg[] paramArrayOfaqlg)
  {
    localaqsk = new aqsk();
    int i = 0;
    try
    {
      while (i < paramArrayOfaqlg.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("preloadSwitch"))
        {
          localaqsk.jdField_a_of_type_Int = localJSONObject.optInt("preloadSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preloadswtich=" + localaqsk.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localaqsk.b = localJSONObject.optInt("preloadInterval", 30);
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed swtich=" + localaqsk.b);
          }
        }
        if (localJSONObject.has("preloadUrl"))
        {
          localaqsk.jdField_a_of_type_JavaLangString = localJSONObject.optString("preloadUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preload url=" + localaqsk.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localaqsk;
    }
    catch (Throwable paramArrayOfaqlg)
    {
      com.tencent.TMG.utils.QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaqlg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsk
 * JD-Core Version:    0.7.0.1
 */