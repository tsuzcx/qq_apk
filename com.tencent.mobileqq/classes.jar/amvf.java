import org.json.JSONObject;

public class amvf
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public amvf()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amvf a(ampi[] paramArrayOfampi)
  {
    localamvf = new amvf();
    int i = 0;
    try
    {
      while (i < paramArrayOfampi.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localamvf.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localamvf.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localamvf.b = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localamvf.b);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localamvf.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localamvf.c);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localamvf.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localamvf.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localamvf;
    }
    catch (Throwable paramArrayOfampi)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfampi.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvf
 * JD-Core Version:    0.7.0.1
 */