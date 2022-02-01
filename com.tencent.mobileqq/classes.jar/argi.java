import org.json.JSONObject;

public class argi
{
  private String jdField_a_of_type_JavaLangString = "1108338344";
  private boolean jdField_a_of_type_Boolean;
  private String b = "pages/list/list";
  private String c = "";
  private String d = "";
  
  public static argi a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    argi localargi = new argi();
    if (paramJSONObject.has("enableOpenMiniCode")) {
      if (paramJSONObject.getInt("enableOpenMiniCode") != 1) {
        break label112;
      }
    }
    for (;;)
    {
      localargi.jdField_a_of_type_Boolean = bool;
      if (paramJSONObject.has("miniCodeAppid")) {
        localargi.jdField_a_of_type_JavaLangString = paramJSONObject.getString("miniCodeAppid");
      }
      if (paramJSONObject.has("miniCodePage")) {
        localargi.b = paramJSONObject.getString("miniCodePage");
      }
      if (paramJSONObject.has("miniCodeEnvVersion")) {
        localargi.c = paramJSONObject.getString("miniCodeEnvVersion");
      }
      if (paramJSONObject.has("miniCodeUrlBlackRegular")) {
        localargi.d = paramJSONObject.getString("miniCodeUrlBlackRegular");
      }
      return localargi;
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
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */