import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.ArrayList;
import java.util.List;

public class bawo
{
  public int a;
  barh jdField_a_of_type_Barh;
  baxd jdField_a_of_type_Baxd = new baxd();
  public baxv a;
  public ProtoReqManager a;
  public String a;
  public List<bawz> a;
  public byte[] a;
  
  public bawo()
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
      localStringBuilder.append(((bawz)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawo
 * JD-Core Version:    0.7.0.1
 */