import org.json.JSONObject;

public class anbw
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
  
  public static anbw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    anbw localanbw = new anbw();
    localanbw.jdField_a_of_type_Int = paramJSONObject.getInt("type");
    localanbw.jdField_a_of_type_JavaLangString = paramJSONObject.getString("color");
    localanbw.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("alpha"));
    localanbw.jdField_b_of_type_JavaLangString = paramJSONObject.getString("text");
    localanbw.c = paramJSONObject.getString("tcolor");
    localanbw.d = paramJSONObject.getString("icon");
    localanbw.f = paramJSONObject.getString("tshow");
    localanbw.e = paramJSONObject.getString("tpress");
    localanbw.jdField_b_of_type_Int = paramJSONObject.getInt("click");
    return localanbw;
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
 * Qualified Name:     anbw
 * JD-Core Version:    0.7.0.1
 */