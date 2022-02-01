import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import java.util.List;

class bbzf
  implements bbzh
{
  bbzf(bbze parambbze, int paramInt, LoadParam paramLoadParam, bbzh parambbzh) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, bbze.a(this.jdField_a_of_type_Bbze));
    bbze.a(this.jdField_a_of_type_Bbze, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mLoadItems.size() - 1) {
        if (this.jdField_a_of_type_Bbzh != null) {
          this.jdField_a_of_type_Bbzh.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      bbze.a(this.jdField_a_of_type_Bbze, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_Bbzh, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Bbzh == null);
    this.jdField_a_of_type_Bbzh.onLoadResult(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzf
 * JD-Core Version:    0.7.0.1
 */