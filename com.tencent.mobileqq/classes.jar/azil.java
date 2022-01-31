import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.Iterator;
import java.util.List;

public class azil
  implements azig
{
  private azig jdField_a_of_type_Azig;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private azij a(azij paramazij, azik paramazik)
  {
    azij localazij = new azij();
    localazij.jdField_a_of_type_JavaUtilList.add(paramazik);
    localazij.jdField_a_of_type_Long = paramazij.jdField_a_of_type_Long;
    localazij.d = paramazij.d;
    return localazij;
  }
  
  private void a(azij paramazij, azin paramazin, int paramInt)
  {
    azij localazij = a(paramazij, (azik)paramazij.jdField_a_of_type_JavaUtilList.get(paramInt));
    this.jdField_a_of_type_Azig = new azic();
    this.jdField_a_of_type_Azig.a(localazij, new azim(this, paramInt, paramazij, paramazin));
  }
  
  public LoadExtResult a(azij paramazij)
  {
    Object localObject = null;
    Iterator localIterator = paramazij.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramazij, (azik)localIterator.next());
      this.jdField_a_of_type_Azig = new azic();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_Azig.a((azij)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(azij paramazij, azin paramazin)
  {
    a(paramazij, paramazin, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Azig != null) {
      this.jdField_a_of_type_Azig.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Azig != null) {
      return this.jdField_a_of_type_Azig.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azil
 * JD-Core Version:    0.7.0.1
 */