import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class bhdt
  implements IVasUpdateFactory
{
  public ICmdManager getCmdManager()
  {
    return new bhdm();
  }
  
  public ICommonManager getCommonManager()
  {
    return new bhdn();
  }
  
  public IDbManager getDbManager()
  {
    return new bhdo();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new bhdp();
  }
  
  public IVasLog getLog()
  {
    return new bhdr();
  }
  
  public IReportManager getReportManager()
  {
    return new bhds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdt
 * JD-Core Version:    0.7.0.1
 */