package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryEmotionBaseFragment$4
  extends EmoticonObserver
{
  ChatHistoryEmotionBaseFragment$4(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 6) {
      return;
    }
    if (paramObject == null)
    {
      ChatHistoryEmotionBaseFragment.a(this.a).b(3);
      return;
    }
    paramObject = (EmoticonResp)paramObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EmoticonObserver resp.delEpId ：");
      localStringBuilder.append(paramObject.delEpId);
      QLog.d("EmoBatchAdded", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject.delEpId == 0) && (!TextUtils.isEmpty(paramObject.emoticonId)) && (this.a.a != null))
    {
      ((IEmoticonManagerService)this.a.a.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(paramObject.epId), paramObject.emoticonId, new ChatHistoryEmotionBaseFragment.4.1(this, paramObject));
      return;
    }
    ChatHistoryEmotionBaseFragment.a(this.a).b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */