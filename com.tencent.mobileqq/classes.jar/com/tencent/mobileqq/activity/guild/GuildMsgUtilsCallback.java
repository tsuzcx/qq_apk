package com.tencent.mobileqq.activity.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi.GuildAioInfo;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageUtilsCallback;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildMsgUtilsCallback
  extends AbsGuildMessageUtilsCallback
{
  public IGuildMessageUtilsApi.GuildAioInfo a()
  {
    BaseChatPie localBaseChatPie = AIOAssist.a();
    if ((localBaseChatPie != null) && (localBaseChatPie.aE() != null) && (localBaseChatPie.aE().a == 10014))
    {
      IGuildMessageUtilsApi.GuildAioInfo localGuildAioInfo = new IGuildMessageUtilsApi.GuildAioInfo();
      localGuildAioInfo.a = localBaseChatPie.aE().c;
      localGuildAioInfo.b = localBaseChatPie.aE().b;
      return localGuildAioInfo;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    BaseChatPie localBaseChatPie = AIOAssist.a();
    if ((!TextUtils.isEmpty(paramString)) && (localBaseChatPie != null) && (localBaseChatPie.aE() != null) && (paramString.equals(localBaseChatPie.aE().b)) && (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(localBaseChatPie.bv()))) {
      return ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildChatContextGuildId(localBaseChatPie);
    }
    return "";
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("guild_at_info_list");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      paramMessageRecord = MessageForText.getTroopMemberInfoFromExtrJson(paramMessageRecord);
      if (paramMessageRecord != null)
      {
        paramMessageRecord = paramMessageRecord.iterator();
        while (paramMessageRecord.hasNext()) {
          if (((AtTroopMemberInfo)paramMessageRecord.next()).flag == 1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    BaseChatPie localBaseChatPie = AIOAssist.a();
    if ((!TextUtils.isEmpty(paramString)) && (localBaseChatPie != null) && (localBaseChatPie.aE() != null) && (paramString.equals(localBaseChatPie.aE().b)) && (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(localBaseChatPie.bv()))) {
      return ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildChatContextIsGuest(localBaseChatPie);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.guild.GuildMsgUtilsCallback
 * JD-Core Version:    0.7.0.1
 */