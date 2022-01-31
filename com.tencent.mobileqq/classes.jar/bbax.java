import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.ArrayList;
import java.util.List;

public class bbax
{
  public int a;
  bavq jdField_a_of_type_Bavq;
  bbbm jdField_a_of_type_Bbbm = new bbbm();
  public bbce a;
  public ProtoReqManager a;
  public String a;
  public List<bbbi> a;
  public byte[] a;
  
  public bbax()
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
      localStringBuilder.append(((bbbi)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbax
 * JD-Core Version:    0.7.0.1
 */