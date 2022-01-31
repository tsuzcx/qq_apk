import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.List;

class azmv
  implements azmw
{
  azmv(azmu paramazmu, int paramInt, azms paramazms, azmw paramazmw) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, azmu.a(this.jdField_a_of_type_Azmu));
    azmu.a(this.jdField_a_of_type_Azmu, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Azms.a.size() - 1) {
        if (this.jdField_a_of_type_Azmw != null) {
          this.jdField_a_of_type_Azmw.a(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      azmu.a(this.jdField_a_of_type_Azmu, this.jdField_a_of_type_Azms, this.jdField_a_of_type_Azmw, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Azmw == null);
    this.jdField_a_of_type_Azmw.a(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmv
 * JD-Core Version:    0.7.0.1
 */