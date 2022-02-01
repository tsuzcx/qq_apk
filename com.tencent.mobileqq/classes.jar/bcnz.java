import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import java.util.List;

class bcnz
  implements bcob
{
  bcnz(bcny parambcny, int paramInt, LoadParam paramLoadParam, bcob parambcob) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, bcny.a(this.jdField_a_of_type_Bcny));
    bcny.a(this.jdField_a_of_type_Bcny, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mLoadItems.size() - 1) {
        if (this.jdField_a_of_type_Bcob != null) {
          this.jdField_a_of_type_Bcob.a(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      bcny.a(this.jdField_a_of_type_Bcny, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_Bcob, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Bcob == null);
    this.jdField_a_of_type_Bcob.a(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnz
 * JD-Core Version:    0.7.0.1
 */