import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import java.util.Iterator;
import java.util.List;

public class bdgq
  implements bdgn
{
  private bdgn jdField_a_of_type_Bdgn;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private LoadParam a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.mLoadItems.add(paramLoadItem);
    localLoadParam.mReportSeq = paramLoadParam.mReportSeq;
    localLoadParam.mCallType = paramLoadParam.mCallType;
    return localLoadParam;
  }
  
  private void a(LoadParam paramLoadParam, bdgt parambdgt, int paramInt)
  {
    LoadParam localLoadParam = a(paramLoadParam, (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(paramInt));
    this.jdField_a_of_type_Bdgn = new bdgf();
    this.jdField_a_of_type_Bdgn.a(localLoadParam, new bdgr(this, paramInt, paramLoadParam, parambdgt));
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Object localObject = null;
    Iterator localIterator = paramLoadParam.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramLoadParam, (LoadParam.LoadItem)localIterator.next());
      this.jdField_a_of_type_Bdgn = new bdgf();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_Bdgn.a((LoadParam)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(LoadParam paramLoadParam, bdgt parambdgt)
  {
    a(paramLoadParam, parambdgt, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bdgn != null) {
      this.jdField_a_of_type_Bdgn.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Bdgn != null) {
      return this.jdField_a_of_type_Bdgn.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgq
 * JD-Core Version:    0.7.0.1
 */