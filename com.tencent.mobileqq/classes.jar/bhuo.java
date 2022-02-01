import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;

public abstract class bhuo
  extends BaseUpdateBusiness
{
  protected abstract String a();
  
  public String a(int paramInt)
  {
    return a() + paramInt;
  }
  
  public String a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return new File(localBaseApplication.getFilesDir() + File.separator + b(), paramString).getAbsolutePath();
  }
  
  public void a(int paramInt)
  {
    startDownload(a(paramInt));
  }
  
  public boolean a(int paramInt)
  {
    return new File(b(paramInt)).exists();
  }
  
  protected abstract String b();
  
  public String b(int paramInt)
  {
    return b(a(paramInt));
  }
  
  public String b(String paramString)
  {
    return a(paramString);
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    BusinessItemInfo localBusinessItemInfo = new BusinessItemInfo();
    localBusinessItemInfo.mSaveInDir = true;
    localBusinessItemInfo.mSavePath = b(paramString);
    return localBusinessItemInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuo
 * JD-Core Version:    0.7.0.1
 */