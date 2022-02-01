import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.aifilter.MultiVideoAIFilterProxy.1;
import java.util.List;
import mqq.os.MqqHandler;

public class bmgp
  extends bmgv
{
  private static final String a = bmgp.class.getSimpleName();
  
  public bmgp(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected void a(Context paramContext, bmgj parambmgj)
  {
    List localList = a();
    ThreadManager.getSubThreadHandler().post(new MultiVideoAIFilterProxy.1(this, localList, paramContext, parambmgj));
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgp
 * JD-Core Version:    0.7.0.1
 */