import org.json.JSONObject;

public class aqbl
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  
  public aqbl()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static aqbl a(aptx[] paramArrayOfaptx)
  {
    localaqbl = new aqbl();
    int i = 0;
    try
    {
      if (i < paramArrayOfaptx.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localaqbl.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localaqbl.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localaqbl.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localaqbl.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localaqbl.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localaqbl.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localaqbl.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localaqbl.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localaqbl.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localaqbl.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("hippySwitch"))
        {
          if (localJSONObject.optInt("hippySwitch", 0) != 1) {
            break label439;
          }
          bool = true;
          label330:
          localaqbl.jdField_a_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippySwitch=" + localaqbl.jdField_a_of_type_Boolean);
          }
        }
        if (localJSONObject.has("hippyPreload")) {
          if (localJSONObject.optInt("hippyPreload", 0) != 1) {
            break label444;
          }
        }
        label439:
        label444:
        for (boolean bool = true;; bool = false)
        {
          localaqbl.jdField_b_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippyPreload=" + localaqbl.jdField_b_of_type_Boolean);
          }
          i += 1;
          break;
          bool = false;
          break label330;
        }
      }
      return localaqbl;
    }
    catch (Throwable paramArrayOfaptx)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaptx.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbl
 * JD-Core Version:    0.7.0.1
 */