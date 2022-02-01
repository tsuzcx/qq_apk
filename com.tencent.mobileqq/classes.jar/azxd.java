import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class azxd
{
  public azxe a;
  public azxg a;
  public azxh a;
  public List<String> a;
  public List<azxf> b = new ArrayList();
  
  public azxd()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("baseProfile").append("=").append(this.jdField_a_of_type_Azxe).append("|\n");
    localStringBuilder.append("personalLabels").append("=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray())).append("|\n");
    localStringBuilder.append("qZoneInfo").append("=").append(this.jdField_a_of_type_Azxg).append("|\n");
    localStringBuilder.append("nicePics").append("=").append(Arrays.toString(this.b.toArray())).append("|\n");
    localStringBuilder.append("sign").append("=").append(this.jdField_a_of_type_Azxh).append("|\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxd
 * JD-Core Version:    0.7.0.1
 */