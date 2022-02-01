import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class aqek
{
  @SerializedName("seqList")
  public int[] a;
  @SerializedName("troopType")
  public long[] a;
  
  @NotNull
  public String toString()
  {
    return "TemplateBean{troopType=" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + ", seqList=" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqek
 * JD-Core Version:    0.7.0.1
 */