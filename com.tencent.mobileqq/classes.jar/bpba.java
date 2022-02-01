import org.json.JSONObject;

public class bpba
{
  public int a;
  private bpaz a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "";
  public String m;
  
  public bpba()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
  }
  
  public bpba(JSONObject paramJSONObject)
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("poi_poster_id");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("poster_name");
    this.jdField_a_of_type_Int = paramJSONObject.getInt("poster_type");
    this.c = paramJSONObject.getString("thumb_url");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("predownload", 0);
    this.d = paramJSONObject.getString("static_url");
    paramJSONObject = paramJSONObject.getJSONObject("resource");
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("resurl", "");
    this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("md5", "");
    this.g = paramJSONObject.optString("name");
    this.h = paramJSONObject.optString("id", "");
    this.jdField_a_of_type_Boolean = bpbb.a(this.jdField_a_of_type_Int);
  }
  
  public bpaz a()
  {
    return this.jdField_a_of_type_Bpaz;
  }
  
  public void a(bpaz parambpaz)
  {
    this.jdField_a_of_type_Bpaz = parambpaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpba
 * JD-Core Version:    0.7.0.1
 */