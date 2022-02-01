package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryEmotionBaseFragment$4
  extends EmoticonObserver
{
  ChatHistoryEmotionBaseFragment$4(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramObject == null)
    {
      ChatHistoryEmotionBaseFragment.a(this.a).b(3);
      return;
    }
    paramObject = (EmoticonResp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "EmoticonObserver resp.delEpId ：" + paramObject.delEpId);
    }
    if ((paramBoolean) && (paramObject.delEpId == 0) && (!TextUtils.isEmpty(paramObject.emoticonId)) && (this.a.a != null))
    {
      ((EmoticonManager)this.a.a.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(paramObject.epId), paramObject.emoticonId, new ChatHistoryEmotionBaseFragment.4.1(this, paramObject));
      return;
    }
    ChatHistoryEmotionBaseFragment.a(this.a).b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */