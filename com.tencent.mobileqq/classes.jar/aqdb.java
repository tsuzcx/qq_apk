import org.json.JSONObject;

public class aqdb
{
  private String jdField_a_of_type_JavaLangString = "1108338344";
  private boolean jdField_a_of_type_Boolean;
  private String b = "pages/list/list";
  private String c = "";
  private String d = "";
  
  public static aqdb a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    aqdb localaqdb = new aqdb();
    if (paramJSONObject.has("enableOpenMiniCode")) {
      if (paramJSONObject.getInt("enableOpenMiniCode") != 1) {
        break label112;
      }
    }
    for (;;)
    {
      localaqdb.jdField_a_of_type_Boolean = bool;
      if (paramJSONObject.has("miniCodeAppid")) {
        localaqdb.jdField_a_of_type_JavaLangString = paramJSONObject.getString("miniCodeAppid");
      }
      if (paramJSONObject.has("miniCodePage")) {
        localaqdb.b = paramJSONObject.getString("miniCodePage");
      }
      if (paramJSONObject.has("miniCodeEnvVersion")) {
        localaqdb.c = paramJSONObject.getString("miniCodeEnvVersion");
      }
      if (paramJSONObject.has("miniCodeUrlBlackRegular")) {
        localaqdb.d = paramJSONObject.getString("miniCodeUrlBlackRegular");
      }
      return localaqdb;
      label112:
      bool = false;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdb
 * JD-Core Version:    0.7.0.1
 */