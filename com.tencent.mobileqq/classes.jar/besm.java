import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1;

public class besm
  extends andd
{
  besm(besj parambesj) {}
  
  protected void onGetAtAllRemianCountInfo(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    ThreadManager.getUIHandlerV2().post(new AllMemberItemViewWrapper.3.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     besm
 * JD-Core Version:    0.7.0.1
 */