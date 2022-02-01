import android.os.Handler;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

final class avih
  implements IHttpCommunicatorListener
{
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    avif.a().sendEmptyMessage(10000001);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    avif.a = false;
    avif.a().sendEmptyMessage(10000001);
  }
  
  public void handleRedirect(String paramString) {}
  
  public void onFlowEvent(HttpMsg paramHttpMsg) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avih
 * JD-Core Version:    0.7.0.1
 */