import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.Iterator;
import java.util.List;

public class azmu
  implements azmp
{
  private azmp jdField_a_of_type_Azmp;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private azms a(azms paramazms, azmt paramazmt)
  {
    azms localazms = new azms();
    localazms.jdField_a_of_type_JavaUtilList.add(paramazmt);
    localazms.jdField_a_of_type_Long = paramazms.jdField_a_of_type_Long;
    localazms.d = paramazms.d;
    return localazms;
  }
  
  private void a(azms paramazms, azmw paramazmw, int paramInt)
  {
    azms localazms = a(paramazms, (azmt)paramazms.jdField_a_of_type_JavaUtilList.get(paramInt));
    this.jdField_a_of_type_Azmp = new azml();
    this.jdField_a_of_type_Azmp.a(localazms, new azmv(this, paramInt, paramazms, paramazmw));
  }
  
  public LoadExtResult a(azms paramazms)
  {
    Object localObject = null;
    Iterator localIterator = paramazms.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramazms, (azmt)localIterator.next());
      this.jdField_a_of_type_Azmp = new azml();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_Azmp.a((azms)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(azms paramazms, azmw paramazmw)
  {
    a(paramazms, paramazmw, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Azmp != null) {
      this.jdField_a_of_type_Azmp.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Azmp != null) {
      return this.jdField_a_of_type_Azmp.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmu
 * JD-Core Version:    0.7.0.1
 */