import org.json.JSONObject;

public class amez
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public amez()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amez a(alzs[] paramArrayOfalzs)
  {
    localamez = new amez();
    int i = 0;
    try
    {
      while (i < paramArrayOfalzs.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localamez.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localamez.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localamez.b = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localamez.b);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localamez.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localamez.c);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localamez.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localamez.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localamez;
    }
    catch (Throwable paramArrayOfalzs)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfalzs.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amez
 * JD-Core Version:    0.7.0.1
 */