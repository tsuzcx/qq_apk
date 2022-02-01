import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment.MyNetInfoHandler.1;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment.MyNetInfoHandler.2;

public class beqk
  extends beqp
{
  private beqk(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
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
 * Qualified Name:     beqk
 * JD-Core Version:    0.7.0.1
 */