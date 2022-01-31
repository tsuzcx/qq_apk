import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.22.1;
import mqq.os.MqqHandler;

public class anyn
  extends ajwb
{
  public anyn(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.p();
    }
    if ((paramObject != null) && ((paramObject instanceof Integer))) {
      ThreadManager.getUIHandler().post(new EmoticonMainPanel.22.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyn
 * JD-Core Version:    0.7.0.1
 */