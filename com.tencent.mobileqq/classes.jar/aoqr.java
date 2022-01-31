import org.json.JSONObject;

public class aoqr
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public aoqr()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static aoqr a(aoko[] paramArrayOfaoko)
  {
    localaoqr = new aoqr();
    int i = 0;
    try
    {
      while (i < paramArrayOfaoko.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localaoqr.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localaoqr.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localaoqr.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localaoqr.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localaoqr.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localaoqr.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localaoqr.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localaoqr.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localaoqr.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localaoqr.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localaoqr;
    }
    catch (Throwable paramArrayOfaoko)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaoko.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqr
 * JD-Core Version:    0.7.0.1
 */