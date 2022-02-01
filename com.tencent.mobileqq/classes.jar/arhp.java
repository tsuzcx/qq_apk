import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class arhp
{
  @SerializedName("templateArray")
  public arhq[] a;
  @SerializedName("templateConfig")
  public arhr[] a;
  
  public arhp()
  {
    this.jdField_a_of_type_ArrayOfArhr = new arhr[0];
    this.jdField_a_of_type_ArrayOfArhq = new arhq[0];
  }
  
  public static arhp a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (arhp)new Gson().fromJson(paramString, arhp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhp
 * JD-Core Version:    0.7.0.1
 */