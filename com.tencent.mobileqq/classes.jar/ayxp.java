import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask.1;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask.2;

public abstract class ayxp
{
  static final String TAG = "PreDownload.Task";
  protected QQAppInterface app;
  protected ayxs ctrl;
  public String key;
  protected Handler subHandler;
  public Object userData;
  
  protected ayxp(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.key = paramString;
    this.app = paramQQAppInterface;
    this.ctrl = ((ayxs)this.app.getManager(193));
    this.subHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public final void cancel()
  {
    this.subHandler.post(new AbsPreDownloadTask.2(this));
  }
  
  public abstract void realCancel();
  
  public abstract void realStart();
  
  public final void start()
  {
    this.subHandler.post(new AbsPreDownloadTask.1(this));
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.key + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxp
 * JD-Core Version:    0.7.0.1
 */