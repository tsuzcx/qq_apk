import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.22.1;
import mqq.os.MqqHandler;

public class anys
  extends ajvz
{
  public anys(EmoticonMainPanel paramEmoticonMainPanel) {}
  
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
 * Qualified Name:     anys
 * JD-Core Version:    0.7.0.1
 */