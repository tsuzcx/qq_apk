import org.json.JSONObject;

public class amwe
{
  private String jdField_a_of_type_JavaLangString = "1108338344";
  private boolean jdField_a_of_type_Boolean;
  private String b = "pages/list/list";
  private String c = "";
  
  public static amwe a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    amwe localamwe = new amwe();
    if (paramJSONObject.has("enableOpenMiniCode")) {
      if (paramJSONObject.getInt("enableOpenMiniCode") != 1) {
        break label93;
      }
    }
    for (;;)
    {
      localamwe.jdField_a_of_type_Boolean = bool;
      if (paramJSONObject.has("miniCodeAppid")) {
        localamwe.jdField_a_of_type_JavaLangString = paramJSONObject.getString("miniCodeAppid");
      }
      if (paramJSONObject.has("miniCodePage")) {
        localamwe.b = paramJSONObject.getString("miniCodePage");
      }
      if (paramJSONObject.has("miniCodeEnvVersion")) {
        localamwe.c = paramJSONObject.getString("miniCodeEnvVersion");
      }
      return localamwe;
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
 * Qualified Name:     amwe
 * JD-Core Version:    0.7.0.1
 */