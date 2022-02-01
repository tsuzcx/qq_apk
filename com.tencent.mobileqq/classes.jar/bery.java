import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment.MyNetInfoHandler.1;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment.MyNetInfoHandler.2;

public class bery
  extends beqm
{
  private bery(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  protected void a()
  {
    ThreadManager.getUIHandlerV2().post(new WriteTogetherEditorFragment.MyNetInfoHandler.1(this));
  }
  
  protected void b()
  {
    ThreadManager.getUIHandlerV2().post(new WriteTogetherEditorFragment.MyNetInfoHandler.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bery
 * JD-Core Version:    0.7.0.1
 */