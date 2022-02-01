import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;

class bnkv
  extends RunnableTask
{
  bnkv(bnku parambnku, QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString, paramRunnable, paramLong);
  }
  
  public void realCancel()
  {
    bnrh.b("AEResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkv
 * JD-Core Version:    0.7.0.1
 */