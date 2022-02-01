import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.ArrayList;
import java.util.List;

public class bfau
{
  public int a;
  bevx jdField_a_of_type_Bevx;
  bfbj jdField_a_of_type_Bfbj = new bfbj();
  public bfcb a;
  public ProtoReqManager a;
  public String a;
  public List<bfbf> a;
  public byte[] a;
  
  public bfau()
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
      localStringBuilder.append(((bfbf)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfau
 * JD-Core Version:    0.7.0.1
 */