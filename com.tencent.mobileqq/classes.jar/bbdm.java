import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bbdm
{
  public azzl a;
  public bbdn a;
  public bbdp a;
  public bbdq a;
  public List<String> a;
  public List<bbdo> b = new ArrayList();
  
  public bbdm()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("baseProfile").append("=").append(this.jdField_a_of_type_Bbdn).append("|\n");
    localStringBuilder.append("personalLabels").append("=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray())).append("|\n");
    localStringBuilder.append("qZoneInfo").append("=").append(this.jdField_a_of_type_Bbdp).append("|\n");
    localStringBuilder.append("nicePics").append("=").append(Arrays.toString(this.b.toArray())).append("|\n");
    localStringBuilder.append("sign").append("=").append(this.jdField_a_of_type_Bbdq).append("|\n");
    localStringBuilder.append("askAnonymously").append("=").append(this.jdField_a_of_type_Azzl).append("|\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdm
 * JD-Core Version:    0.7.0.1
 */