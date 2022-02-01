import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class bied
  implements IVasUpdateFactory
{
  public ICmdManager getCmdManager()
  {
    return new bidw();
  }
  
  public ICommonManager getCommonManager()
  {
    return new bidx();
  }
  
  public IDbManager getDbManager()
  {
    return new bidy();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new bidz();
  }
  
  public IVasLog getLog()
  {
    return new bieb();
  }
  
  public IReportManager getReportManager()
  {
    return new biec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bied
 * JD-Core Version:    0.7.0.1
 */