package com.tencent.mobileqq.app;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.StatusInfoCallback;

class FrameHelperActivity$9
  implements OnLineStatusPresenter.StatusInfoCallback
{
  FrameHelperActivity$9(FrameHelperActivity paramFrameHelperActivity) {}
  
  public TextView a()
  {
    Conversation localConversation = (Conversation)this.a.a(Conversation.class);
    if (localConversation != null) {
      return localConversation.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9
 * JD-Core Version:    0.7.0.1
 */