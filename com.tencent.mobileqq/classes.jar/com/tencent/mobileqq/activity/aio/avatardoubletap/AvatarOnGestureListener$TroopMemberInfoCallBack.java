package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvatarOnGestureListener$TroopMemberInfoCallBack
  implements TroopManager.ITroopMemberInfoCallBack
{
  private AvatarOnGestureListener a;
  private ChatMessage b;
  private VasAvatar c;
  private QQAppInterface d;
  
  AvatarOnGestureListener$TroopMemberInfoCallBack(VasAvatar paramVasAvatar, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, AvatarOnGestureListener paramAvatarOnGestureListener)
  {
    this.c = paramVasAvatar;
    this.b = paramChatMessage;
    this.d = paramQQAppInterface;
    this.a = paramAvatarOnGestureListener;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      int i;
      if (TextUtils.equals(this.b.senderuin, this.d.getCurrentAccountUin())) {
        i = 2131892382;
      } else {
        i = 2131892383;
      }
      QQToast.makeText(BaseApplicationImpl.getContext(), 0, i, 0).show();
      if (QLog.isColorLevel()) {
        QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() isKicked");
      }
    }
    else
    {
      AvatarOnGestureListener.a(this.a, this.c, this.b, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.AvatarOnGestureListener.TroopMemberInfoCallBack
 * JD-Core Version:    0.7.0.1
 */