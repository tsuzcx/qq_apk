import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import java.util.List;

class bdgr
  implements bdgt
{
  bdgr(bdgq parambdgq, int paramInt, LoadParam paramLoadParam, bdgt parambdgt) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, bdgq.a(this.jdField_a_of_type_Bdgq));
    bdgq.a(this.jdField_a_of_type_Bdgq, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mLoadItems.size() - 1) {
        if (this.jdField_a_of_type_Bdgt != null) {
          this.jdField_a_of_type_Bdgt.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      bdgq.a(this.jdField_a_of_type_Bdgq, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_Bdgt, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Bdgt == null);
    this.jdField_a_of_type_Bdgt.onLoadResult(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgr
 * JD-Core Version:    0.7.0.1
 */