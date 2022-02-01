import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.aifilter.SilentMultiVideoAIFilterProxy.1;
import java.util.List;
import mqq.os.MqqHandler;

public class bnwj
  extends bnwk
{
  public bnwj(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected void a(Context paramContext, bnwb parambnwb)
  {
    List localList = a();
    ThreadManager.getSubThreadHandler().post(new SilentMultiVideoAIFilterProxy.1(this, localList, paramContext, parambnwb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwj
 * JD-Core Version:    0.7.0.1
 */