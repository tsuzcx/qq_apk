package com.tencent.mobileqq.activity.history;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import mqq.os.MqqHandler;

class ChatHistoryTroopMediaFragment$MediaTroopFileErrorObserver
  extends TroopFileError.TroopFileErrorObserver
{
  public ChatHistoryTroopMediaFragment$MediaTroopFileErrorObserver(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, Context paramContext, TroopFileError.TroopFileErrorFilter paramTroopFileErrorFilter, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramTroopFileErrorFilter, paramQQAppInterface);
  }
  
  protected void b(Object paramObject)
  {
    super.b(paramObject);
    if (this.a.w != null) {
      this.a.w.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment.MediaTroopFileErrorObserver
 * JD-Core Version:    0.7.0.1
 */