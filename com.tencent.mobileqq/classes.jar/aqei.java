import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class aqei
{
  @SerializedName("templateArray")
  public aqej[] a;
  @SerializedName("templateConfig")
  public aqek[] a;
  
  public aqei()
  {
    this.jdField_a_of_type_ArrayOfAqek = new aqek[0];
    this.jdField_a_of_type_ArrayOfAqej = new aqej[0];
  }
  
  public static aqei a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (aqei)new Gson().fromJson(paramString, aqei.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqei
 * JD-Core Version:    0.7.0.1
 */