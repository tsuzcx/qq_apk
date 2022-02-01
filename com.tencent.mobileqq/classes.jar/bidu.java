import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;

public class bidu
  extends BaseUpdateBusiness
{
  private String a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return localBaseApplication.getFilesDir() + File.separator + "test_dir" + File.separator + paramString + ".zip";
  }
  
  public long getBid()
  {
    return 1000000L;
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    paramString = new BusinessItemInfo();
    paramString.mSaveInDir = false;
    paramString.mSavePath = a("test");
    return paramString;
  }
  
  public String getFrom()
  {
    return "TestUpdateBusinessV2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidu
 * JD-Core Version:    0.7.0.1
 */