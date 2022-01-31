import org.json.JSONObject;

public class aoxm
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
  
  public static aoxm a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aoxm localaoxm = new aoxm();
    localaoxm.jdField_a_of_type_Int = paramJSONObject.getInt("type");
    localaoxm.jdField_a_of_type_JavaLangString = paramJSONObject.getString("color");
    localaoxm.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("alpha"));
    localaoxm.jdField_b_of_type_JavaLangString = paramJSONObject.getString("text");
    localaoxm.c = paramJSONObject.getString("tcolor");
    localaoxm.d = paramJSONObject.getString("icon");
    localaoxm.f = paramJSONObject.getString("tshow");
    localaoxm.e = paramJSONObject.getString("tpress");
    localaoxm.jdField_b_of_type_Int = paramJSONObject.getInt("click");
    return localaoxm;
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
 * Qualified Name:     aoxm
 * JD-Core Version:    0.7.0.1
 */