import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

public abstract interface bird
  extends DownloadListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(DownloadInfo paramDownloadInfo, int paramInt);
  
  public abstract void a(List<DownloadInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bird
 * JD-Core Version:    0.7.0.1
 */