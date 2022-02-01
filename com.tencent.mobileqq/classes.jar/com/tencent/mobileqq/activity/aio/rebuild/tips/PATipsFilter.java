package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import java.util.Iterator;
import java.util.List;

public class PATipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    paramAIOContext = ((PAContext)paramAIOContext).R();
    if (paramAIOContext != null)
    {
      paramAIOContext = paramAIOContext.q.iterator();
      while (paramAIOContext.hasNext()) {
        if (((TroopInfo)paramAIOContext.next()).troopuin.equals(paramMessage.frienduin))
        {
          i = 1;
          break label68;
        }
      }
    }
    int i = 0;
    label68:
    return (paramMessage.istroop == 1) && (i != 0);
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.PATipsFilter
 * JD-Core Version:    0.7.0.1
 */