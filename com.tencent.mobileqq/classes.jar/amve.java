import org.json.JSONObject;

public class amve
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public amve()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amve a(amph[] paramArrayOfamph)
  {
    localamve = new amve();
    int i = 0;
    try
    {
      while (i < paramArrayOfamph.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localamve.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localamve.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localamve.b = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localamve.b);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localamve.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localamve.c);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localamve.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localamve.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localamve;
    }
    catch (Throwable paramArrayOfamph)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfamph.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */