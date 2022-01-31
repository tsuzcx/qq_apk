import android.os.Handler;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWProto;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class annf
  extends Handler
{
  public annf(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    RMWLog.a("RMWService", "service.handle : " + RMWProto.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     annf
 * JD-Core Version:    0.7.0.1
 */