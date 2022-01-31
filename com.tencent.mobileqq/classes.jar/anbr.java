import org.json.JSONObject;

public class anbr
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
  
  public static anbr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    anbr localanbr = new anbr();
    localanbr.jdField_a_of_type_Int = paramJSONObject.getInt("type");
    localanbr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("color");
    localanbr.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("alpha"));
    localanbr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("text");
    localanbr.c = paramJSONObject.getString("tcolor");
    localanbr.d = paramJSONObject.getString("icon");
    localanbr.f = paramJSONObject.getString("tshow");
    localanbr.e = paramJSONObject.getString("tpress");
    localanbr.jdField_b_of_type_Int = paramJSONObject.getInt("click");
    return localanbr;
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
 * Qualified Name:     anbr
 * JD-Core Version:    0.7.0.1
 */