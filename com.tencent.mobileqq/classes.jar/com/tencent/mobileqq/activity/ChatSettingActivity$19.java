package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import java.lang.ref.WeakReference;

class ChatSettingActivity$19
  extends AvatarObserver
{
  ChatSettingActivity$19(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.b(this.a) != null))
    {
      if ((ChatSettingActivity.n(this.a) != 1010) && (ChatSettingActivity.n(this.a) != 1001) && (ChatSettingActivity.n(this.a) != 10002))
      {
        if (ChatSettingActivity.n(this.a) == 1006)
        {
          paramString = FaceDrawable.getMobileFaceDrawable(this.a.app, ChatSettingActivity.a(this.a), (byte)3);
          ChatSettingActivity.b(this.a).setImageDrawable(paramString);
          return;
        }
        paramString = FaceDrawable.getFaceDrawable(this.a.app, 1, ChatSettingActivity.a(this.a));
        ChatSettingActivity.a(this.a, new WeakReference(paramString));
        ChatSettingActivity.b(this.a).setImageDrawable(paramString);
        return;
      }
      paramString = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, ChatSettingActivity.a(this.a), true);
      ChatSettingActivity.a(this.a, new WeakReference(paramString));
      ChatSettingActivity.b(this.a).setImageDrawable(paramString);
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.b(this.a) != null) && (ChatSettingActivity.o(this.a) != null) && (paramString.equals(ChatSettingActivity.o(this.a))))
    {
      paramString = FaceDrawable.getMobileFaceDrawable(this.a.app, paramString, (byte)3);
      ChatSettingActivity.b(this.a).setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.19
 * JD-Core Version:    0.7.0.1
 */