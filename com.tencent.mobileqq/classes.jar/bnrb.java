import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bnrb
{
  public int a;
  public String a;
  public List<String> a;
  public int b = 6;
  
  public bnrb()
  {
    this.jdField_a_of_type_JavaLangString = "default";
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bnrb(List<String> paramList, String paramString, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = "default";
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramJSONObject != null)
    {
      a(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_Int = 3;
    this.b = 6;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangString != null) {}
      for (paramJSONObject = paramJSONObject.getJSONObject(this.jdField_a_of_type_JavaLangString);; paramJSONObject = paramJSONObject.getJSONObject("default"))
      {
        this.jdField_a_of_type_Int = paramJSONObject.getInt("wordNum");
        this.b = paramJSONObject.getInt("pendantNum");
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrb
 * JD-Core Version:    0.7.0.1
 */