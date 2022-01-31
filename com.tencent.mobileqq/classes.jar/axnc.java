import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.List;

public class axnc
  implements axmx
{
  private axmx jdField_a_of_type_Axmx;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private void a(axna paramaxna, axne paramaxne, int paramInt)
  {
    axna localaxna = new axna();
    localaxna.jdField_a_of_type_JavaUtilList.add(paramaxna.jdField_a_of_type_JavaUtilList.get(paramInt));
    localaxna.jdField_a_of_type_Long = paramaxna.jdField_a_of_type_Long;
    this.jdField_a_of_type_Axmx = new axmu();
    this.jdField_a_of_type_Axmx.a(localaxna, new axnd(this, paramInt, paramaxna, paramaxne));
  }
  
  public void a(axna paramaxna, axne paramaxne)
  {
    a(paramaxna, paramaxne, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axmx != null) {
      this.jdField_a_of_type_Axmx.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Axmx != null) {
      return this.jdField_a_of_type_Axmx.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnc
 * JD-Core Version:    0.7.0.1
 */