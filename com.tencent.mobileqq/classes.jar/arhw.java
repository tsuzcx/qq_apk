import org.json.JSONObject;

public class arhw
{
  public int a;
  public String a;
  public int b;
  
  public arhw()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static arhw a(araj[] paramArrayOfaraj)
  {
    localarhw = new arhw();
    int i = 0;
    try
    {
      while (i < paramArrayOfaraj.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("preloadSwitch"))
        {
          localarhw.jdField_a_of_type_Int = localJSONObject.optInt("preloadSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preloadswtich=" + localarhw.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localarhw.b = localJSONObject.optInt("preloadInterval", 30);
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed swtich=" + localarhw.b);
          }
        }
        if (localJSONObject.has("preloadUrl"))
        {
          localarhw.jdField_a_of_type_JavaLangString = localJSONObject.optString("preloadUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGamePreloadConfBean", 2, "onParsed preload url=" + localarhw.jdField_a_of_type_JavaLangString);
          }
        }
        i += 1;
      }
      return localarhw;
    }
    catch (Throwable paramArrayOfaraj)
    {
      com.tencent.TMG.utils.QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfaraj.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhw
 * JD-Core Version:    0.7.0.1
 */