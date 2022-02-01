import com.tencent.mobileqq.app.ThreadManager;
import cooperation.gmersdk_warper.GMEAVEngineWalper.1.1;
import mqq.os.MqqHandler;

public class bmdo
  extends bmee
{
  bmdo(bmdn parambmdn) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      ThreadManager.getUIHandler().post(new GMEAVEngineWalper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdo
 * JD-Core Version:    0.7.0.1
 */