import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.9.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.9.2;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class bndl
  implements bnkq
{
  bndl(bnda parambnda) {}
  
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    bnrh.b("AEBottomListPart", "loadAndHandleData---download finish, isSuccess=" + paramBoolean);
    if (!paramBoolean)
    {
      bnda.a(this.a, true);
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.1(this));
    }
    bnda.a(this.a).countDown();
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    if ((paramInt > 1) && (paramInt <= 100)) {
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndl
 * JD-Core Version:    0.7.0.1
 */