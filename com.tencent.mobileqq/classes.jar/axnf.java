import com.tencent.mobileqq.soload.LoadExtResult;
import java.util.List;

class axnf
  implements axng
{
  axnf(axne paramaxne, int paramInt, axnc paramaxnc, axng paramaxng) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, axne.a(this.jdField_a_of_type_Axne));
    axne.a(this.jdField_a_of_type_Axne, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Axnc.a.size() - 1) {
        if (this.jdField_a_of_type_Axng != null) {
          this.jdField_a_of_type_Axng.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      axne.a(this.jdField_a_of_type_Axne, this.jdField_a_of_type_Axnc, this.jdField_a_of_type_Axng, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Axng == null);
    this.jdField_a_of_type_Axng.onLoadResult(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnf
 * JD-Core Version:    0.7.0.1
 */