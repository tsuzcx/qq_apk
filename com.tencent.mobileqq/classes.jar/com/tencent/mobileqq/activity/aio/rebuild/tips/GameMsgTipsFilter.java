package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;

public class GameMsgTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (paramMessage.istroop == 10007)
    {
      paramIntent = new SpannableStringBuilder();
      paramAIOContext = ((IGameMsgManagerService)paramAIOContext.a().getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(RoleIdUtil.b(paramMessage));
      if ((paramAIOContext != null) && (!TextUtils.isEmpty(paramAIOContext.e)))
      {
        paramIntent.append(paramAIOContext.e);
        return paramIntent;
      }
      paramIntent.append(HardCodeUtil.a(2131889891));
      return paramIntent;
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return ((paramAIOContext.O() != null) && (paramAIOContext.O().a == 10007)) || (paramMessage.istroop == 10007);
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.GameMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */