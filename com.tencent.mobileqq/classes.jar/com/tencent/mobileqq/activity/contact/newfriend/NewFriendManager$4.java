package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendManager$4
  extends FriendListObserver
{
  NewFriendManager$4(NewFriendManager paramNewFriendManager) {}
  
  public void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = this.a.b();
    } while (((ArrayList)localObject).isEmpty());
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)((Iterator)localObject).next();
      if ((localNewFriendMessage instanceof FriendSystemMessage))
      {
        int i = ((FriendSystemMessage)localNewFriendMessage).a.structMsg.msg.sub_type.get();
        String str = ((FriendSystemMessage)localNewFriendMessage).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          NewFriendManager.a(this.a).getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((FriendSystemMessage)localNewFriendMessage).a.uniseq, false);
        }
      }
    }
    NewFriendManager.a(this.a).sendEmptyMessage(2);
  }
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
  
  public void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
  
  public void onMayknowStateChanged(boolean paramBoolean)
  {
    NewFriendManager.a(this.a).runOnUiThread(new NewFriendManager.4.1(this, paramBoolean));
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.4
 * JD-Core Version:    0.7.0.1
 */