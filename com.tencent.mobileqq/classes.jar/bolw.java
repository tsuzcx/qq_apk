import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.9.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.9.2;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class bolw
  implements borc
{
  bolw(boll paramboll) {}
  
  public void a(boqu paramboqu, int paramInt)
  {
    if ((paramInt > 1) && (paramInt <= 100)) {
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.2(this, paramInt));
    }
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    bpam.b("AEBottomListPart", "loadAndHandleData---download finish, isSuccess=" + paramBoolean);
    if (!paramBoolean)
    {
      boll.a(this.a, true);
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.1(this));
    }
    boll.a(this.a).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolw
 * JD-Core Version:    0.7.0.1
 */