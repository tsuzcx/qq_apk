import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.ArrayList;
import java.util.List;

public class axyg
{
  public int a;
  axtb jdField_a_of_type_Axtb;
  axyv jdField_a_of_type_Axyv = new axyv();
  public axzn a;
  public ProtoReqManager a;
  public String a;
  public List<axyr> a;
  public byte[] a;
  
  public axyg()
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
      localStringBuilder.append(((axyr)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyg
 * JD-Core Version:    0.7.0.1
 */