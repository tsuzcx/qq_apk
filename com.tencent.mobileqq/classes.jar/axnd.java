import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.List;

class axnd
  implements axne
{
  axnd(axnc paramaxnc, int paramInt, axna paramaxna, axne paramaxne) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, axnc.a(this.jdField_a_of_type_Axnc));
    axnc.a(this.jdField_a_of_type_Axnc, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Axna.a.size() - 1) {
        if (this.jdField_a_of_type_Axne != null) {
          this.jdField_a_of_type_Axne.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      axnc.a(this.jdField_a_of_type_Axnc, this.jdField_a_of_type_Axna, this.jdField_a_of_type_Axne, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Axne == null);
    this.jdField_a_of_type_Axne.onLoadResult(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnd
 * JD-Core Version:    0.7.0.1
 */