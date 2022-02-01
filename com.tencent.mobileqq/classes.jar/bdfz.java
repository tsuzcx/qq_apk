import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import java.util.Iterator;
import java.util.List;

public class bdfz
  implements bdfw
{
  private bdfw jdField_a_of_type_Bdfw;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult;
  
  private LoadParam a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.mLoadItems.add(paramLoadItem);
    localLoadParam.mReportSeq = paramLoadParam.mReportSeq;
    localLoadParam.mCallType = paramLoadParam.mCallType;
    localLoadParam.commonFlag = paramLoadParam.commonFlag;
    return localLoadParam;
  }
  
  private void a(LoadParam paramLoadParam, bdgc parambdgc, int paramInt)
  {
    LoadParam localLoadParam = a(paramLoadParam, (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(paramInt));
    this.jdField_a_of_type_Bdfw = new bdfo();
    this.jdField_a_of_type_Bdfw.a(localLoadParam, new bdga(this, paramInt, paramLoadParam, parambdgc));
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Object localObject = null;
    Iterator localIterator = paramLoadParam.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramLoadParam, (LoadParam.LoadItem)localIterator.next());
      this.jdField_a_of_type_Bdfw = new bdfo();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_Bdfw.a((LoadParam)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadExtResult = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(LoadParam paramLoadParam, bdgc parambdgc)
  {
    a(paramLoadParam, parambdgc, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bdfw != null) {
      this.jdField_a_of_type_Bdfw.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Bdfw != null) {
      return this.jdField_a_of_type_Bdfw.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfz
 * JD-Core Version:    0.7.0.1
 */