import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class bgko
  implements IVasUpdateFactory
{
  public ICmdManager getCmdManager()
  {
    return new bgkh();
  }
  
  public ICommonManager getCommonManager()
  {
    return new bgki();
  }
  
  public IDbManager getDbManager()
  {
    return new bgkj();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new bgkk();
  }
  
  public IVasLog getLog()
  {
    return new bgkm();
  }
  
  public IReportManager getReportManager()
  {
    return new bgkn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgko
 * JD-Core Version:    0.7.0.1
 */