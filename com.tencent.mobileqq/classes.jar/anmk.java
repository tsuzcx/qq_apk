import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.9.1;
import com.tencent.mobileqq.app.FrameHelperActivity.9.2;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class anmk
  implements aypb
{
  public anmk(FrameHelperActivity paramFrameHelperActivity) {}
  
  public TextView a()
  {
    Conversation localConversation = (Conversation)this.a.a(Conversation.class);
    if (localConversation != null) {
      return localConversation.a;
    }
    return null;
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new FrameHelperActivity.9.2(this, paramDrawable, paramString));
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    Conversation localConversation = (Conversation)this.a.a(Conversation.class);
    ThreadManagerV2.getUIHandlerV2().post(new FrameHelperActivity.9.1(this, localConversation, paramDrawable, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmk
 * JD-Core Version:    0.7.0.1
 */