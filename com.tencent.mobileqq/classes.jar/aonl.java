import org.json.JSONObject;

public class aonl
{
  private String jdField_a_of_type_JavaLangString = "1108338344";
  private boolean jdField_a_of_type_Boolean;
  private String b = "pages/list/list";
  private String c = "";
  
  public static aonl a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    aonl localaonl = new aonl();
    if (paramJSONObject.has("enableOpenMiniCode")) {
      if (paramJSONObject.getInt("enableOpenMiniCode") != 1) {
        break label93;
      }
    }
    for (;;)
    {
      localaonl.jdField_a_of_type_Boolean = bool;
      if (paramJSONObject.has("miniCodeAppid")) {
        localaonl.jdField_a_of_type_JavaLangString = paramJSONObject.getString("miniCodeAppid");
      }
      if (paramJSONObject.has("miniCodePage")) {
        localaonl.b = paramJSONObject.getString("miniCodePage");
      }
      if (paramJSONObject.has("miniCodeEnvVersion")) {
        localaonl.c = paramJSONObject.getString("miniCodeEnvVersion");
      }
      return localaonl;
      label93:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonl
 * JD-Core Version:    0.7.0.1
 */