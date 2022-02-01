import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class bhuy
  implements IVasUpdateFactory
{
  public ICmdManager getCmdManager()
  {
    return new bhur();
  }
  
  public ICommonManager getCommonManager()
  {
    return new bhus();
  }
  
  public IDbManager getDbManager()
  {
    return new bhut();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new bhuu();
  }
  
  public IVasLog getLog()
  {
    return new bhuw();
  }
  
  public IReportManager getReportManager()
  {
    return new bhux();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuy
 * JD-Core Version:    0.7.0.1
 */