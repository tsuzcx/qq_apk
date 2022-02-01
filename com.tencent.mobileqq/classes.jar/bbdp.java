import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bbdp
{
  public String a;
  public List<String> a;
  public String b = "";
  
  public bbdp()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("qzoneName").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("updateContent").append("=").append(this.b).append("|");
    localStringBuilder.append("imgUrls").append("=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray())).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdp
 * JD-Core Version:    0.7.0.1
 */