import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import java.util.List;

public class arpz
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  
  public arpz a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public arpz a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public arpz a(List<Integer> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public MsgBackupUserData a()
  {
    return new MsgBackupUserData(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b, this.c, this.jdField_a_of_type_Int, null);
  }
  
  public arpz b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public arpz c(String paramString)
  {
    this.c = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpz
 * JD-Core Version:    0.7.0.1
 */