import org.json.JSONObject;

public class aomi
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public aomi()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static aomi a(aogf[] paramArrayOfaogf)
  {
    localaomi = new aomi();
    int i = 0;
    try
    {
      while (i < paramArrayOfaogf.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localaomi.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localaomi.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localaomi.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localaomi.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localaomi.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localaomi.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localaomi.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localaomi.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localaomi.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localaomi.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localaomi;
    }
    catch (Throwable paramArrayOfaogf)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaogf.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomi
 * JD-Core Version:    0.7.0.1
 */