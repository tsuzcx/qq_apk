import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.ArrayList;
import java.util.List;

public class ayyp
{
  public int a;
  aytk jdField_a_of_type_Aytk;
  ayze jdField_a_of_type_Ayze = new ayze();
  public ayzw a;
  public ProtoReqManager a;
  public String a;
  public List<ayza> a;
  public byte[] a;
  
  public ayyp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder.append("index:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(((ayza)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyp
 * JD-Core Version:    0.7.0.1
 */