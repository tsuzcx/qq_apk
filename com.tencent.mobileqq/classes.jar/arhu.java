import org.json.JSONObject;

public class arhu
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public arhu()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static arhu a(araj[] paramArrayOfaraj)
  {
    localarhu = new arhu();
    int i = 0;
    try
    {
      while (i < paramArrayOfaraj.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localarhu.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localarhu.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localarhu.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localarhu.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localarhu.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localarhu.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localarhu.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localarhu.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localarhu.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localarhu.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localarhu;
    }
    catch (Throwable paramArrayOfaraj)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaraj.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhu
 * JD-Core Version:    0.7.0.1
 */