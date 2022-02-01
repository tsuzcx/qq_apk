import org.json.JSONObject;

public class arqd
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public static arqd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    arqd localarqd = new arqd();
    localarqd.jdField_a_of_type_Int = paramJSONObject.getInt("type");
    localarqd.jdField_a_of_type_JavaLangString = paramJSONObject.getString("color");
    localarqd.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("alpha"));
    localarqd.jdField_b_of_type_JavaLangString = paramJSONObject.getString("text");
    localarqd.c = paramJSONObject.getString("tcolor");
    localarqd.d = paramJSONObject.getString("icon");
    localarqd.f = paramJSONObject.getString("tshow");
    localarqd.e = paramJSONObject.getString("tpress");
    localarqd.jdField_b_of_type_Int = paramJSONObject.getInt("click");
    return localarqd;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqd
 * JD-Core Version:    0.7.0.1
 */