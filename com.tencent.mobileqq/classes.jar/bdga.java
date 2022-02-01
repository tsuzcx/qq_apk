import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import java.util.List;

class bdga
  implements bdgc
{
  bdga(bdfz parambdfz, int paramInt, LoadParam paramLoadParam, bdgc parambdgc) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, bdfz.a(this.jdField_a_of_type_Bdfz));
    bdfz.a(this.jdField_a_of_type_Bdfz, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mLoadItems.size() - 1) {
        if (this.jdField_a_of_type_Bdgc != null) {
          this.jdField_a_of_type_Bdgc.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      bdfz.a(this.jdField_a_of_type_Bdfz, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_Bdgc, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Bdgc == null);
    this.jdField_a_of_type_Bdgc.onLoadResult(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdga
 * JD-Core Version:    0.7.0.1
 */