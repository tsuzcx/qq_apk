import org.json.JSONObject;

public class areo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public int d;
  public int e = 168;
  
  public areo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static areo a()
  {
    return (areo)aqxe.a().a(441);
  }
  
  public static areo a(aqxa[] paramArrayOfaqxa)
  {
    localareo = new areo();
    int i = 0;
    try
    {
      if (i < paramArrayOfaqxa.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localareo.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localareo.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localareo.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localareo.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localareo.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localareo.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localareo.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localareo.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localareo.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localareo.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("hippySwitch"))
        {
          if (localJSONObject.optInt("hippySwitch", 0) != 1) {
            break label534;
          }
          bool = true;
          label330:
          localareo.jdField_a_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippySwitch=" + localareo.jdField_a_of_type_Boolean);
          }
        }
        if (localJSONObject.has("hippyPreload")) {
          if (localJSONObject.optInt("hippyPreload", 0) != 1) {
            break label539;
          }
        }
        label534:
        label539:
        for (boolean bool = true;; bool = false)
        {
          localareo.jdField_b_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippyPreload=" + localareo.jdField_b_of_type_Boolean);
          }
          if (localJSONObject.has("publicAccountSessionConfig"))
          {
            localJSONObject = localJSONObject.optJSONObject("publicAccountSessionConfig");
            if (localJSONObject != null)
            {
              localareo.d = localJSONObject.optInt("style");
              localareo.e = localJSONObject.optInt("unUsedTime", 168);
            }
            if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
              com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed publicAccountSessionConfig, sessionStyle=" + localareo.d + ", sessionUnUsedTime=" + localareo.e);
            }
          }
          i += 1;
          break;
          bool = false;
          break label330;
        }
      }
      return localareo;
    }
    catch (Throwable paramArrayOfaqxa)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaqxa.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areo
 * JD-Core Version:    0.7.0.1
 */