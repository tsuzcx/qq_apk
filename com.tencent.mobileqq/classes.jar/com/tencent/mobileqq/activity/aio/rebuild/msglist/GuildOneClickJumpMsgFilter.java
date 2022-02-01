package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi.MsgSeqItem;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class GuildOneClickJumpMsgFilter
  implements IMsgLoader
{
  public static int a;
  public static HashSet<Long> b;
  
  public static void a()
  {
    try
    {
      ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).resetCurAioLatestMsgSeqItem();
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(@NonNull AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    long l = b(paramAIOContext, paramList);
    paramAIOContext.a().getMessageFacade().s().a(paramAIOContext.O().a).a(paramAIOContext.O().b, paramAIOContext.O().a, l);
    paramAIOContext = paramList.iterator();
    while (paramAIOContext.hasNext()) {
      if (((ChatMessage)paramAIOContext.next()).shmsgseq < l) {
        paramAIOContext.remove();
      }
    }
  }
  
  private void a(@NonNull AIOContext paramAIOContext, List<ChatMessage> paramList, ListUI paramListUI, JumpState paramJumpState1, JumpState paramJumpState2)
  {
    if ((paramJumpState1 == JumpState.END) && ((paramJumpState2 == JumpState.GRAY_TIP_ABOVE) || (paramJumpState2 == JumpState.PULL_UP_FAILURE) || (paramJumpState2 == JumpState.JUMP_SUCCESS)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildOneClickJumpMsgFilter", 2, "remove useless message from aioMsgPool when change JumpState into END");
      }
      OneClickJumpUtil.a(paramAIOContext.a());
      a(paramAIOContext, paramList);
      ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).setGuildListUIJumpStateEND(paramListUI);
    }
  }
  
  private void a(@NonNull AIOContext paramAIOContext, List<ChatMessage> paramList, JumpState paramJumpState1, JumpState paramJumpState2)
  {
    int i;
    if (paramJumpState1 == JumpState.JUMP_SUCCESS) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      c(paramList);
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() != 0)
      {
        b = new HashSet();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.next();
          if (localMessageRecord != null) {
            b.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
        }
        return;
      }
      b = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void a(List<ChatMessage> paramList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = null;
      int i = 0;
      while ((paramList != null) && (i < paramList.size()))
      {
        int j = i % 100;
        if (j == 0)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramString);
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("NO.");
        localStringBuilder2.append(i);
        localStringBuilder2.append(", seq = ");
        localStringBuilder2.append(((ChatMessage)paramList.get(i)).shmsgseq);
        localStringBuilder2.append(", ");
        localStringBuilder1.append(localStringBuilder2.toString());
        if ((j == 99) || (i == paramList.size() - 1)) {
          QLog.d("GuildOneClickJumpMsgFilter", 2, localStringBuilder1.toString());
        }
        i += 1;
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      if (b != null)
      {
        bool = b.contains(Long.valueOf(paramLong));
        if (bool)
        {
          bool = true;
          break label30;
        }
      }
      boolean bool = false;
      label30:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(@NonNull AIOContext paramAIOContext)
  {
    IGuildFocusChannelService localIGuildFocusChannelService = (IGuildFocusChannelService)paramAIOContext.a().getRuntimeService(IGuildFocusChannelService.class, "");
    if (localIGuildFocusChannelService != null) {
      return localIGuildFocusChannelService.isHugeChannel(paramAIOContext.O().b);
    }
    return false;
  }
  
  private long b(@NonNull AIOContext paramAIOContext, @NonNull List<ChatMessage> paramList)
  {
    long l1 = ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq;
    String str = ((IGPSService)paramAIOContext.a().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    paramAIOContext = paramAIOContext.O().b;
    IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getOnlinePushLatestMsgSeqItem(paramAIOContext);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAioEndContinueSeq, selfTid = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", channelId = ");
      localStringBuilder.append(paramAIOContext);
      localStringBuilder.append(", msgSeqItem = ");
      if (localMsgSeqItem == null) {
        paramAIOContext = "null";
      } else {
        paramAIOContext = localMsgSeqItem.toString();
      }
      localStringBuilder.append(paramAIOContext);
      QLog.d("GuildOneClickJumpMsgFilter", 2, localStringBuilder.toString());
    }
    int i = paramList.size() - 1;
    long l2;
    for (;;)
    {
      l2 = l1;
      if (i < 0) {
        break;
      }
      paramAIOContext = (ChatMessage)paramList.get(i);
      if (((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(paramAIOContext)) {
        l1 = paramAIOContext.shmsgseq;
      }
      for (;;)
      {
        break;
        int j = 0;
        boolean bool2 = false;
        if ((localMsgSeqItem != null) && (localMsgSeqItem.b < paramAIOContext.shmsgseq))
        {
          l1 = paramAIOContext.shmsgseq;
          boolean bool1 = bool2;
          if (paramAIOContext.senderuin != null)
          {
            bool1 = bool2;
            if (paramAIOContext.senderuin.equals(str)) {
              bool1 = true;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAioEndContinueSeq, Msg = ");
          localStringBuilder.append(paramAIOContext.getBaseInfoString());
          localStringBuilder.append(", isSelf = ");
          localStringBuilder.append(bool1);
          QLog.d("GuildOneClickJumpMsgFilter", 2, localStringBuilder.toString());
          l2 = l1;
          if (!bool1) {
            break label481;
          }
        }
        else
        {
          l2 = l1;
          if (localMsgSeqItem != null)
          {
            l2 = l1;
            if (localMsgSeqItem.b == paramAIOContext.shmsgseq)
            {
              l2 = paramAIOContext.shmsgseq;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getAioEndContinueSeq, start msg = ");
              localStringBuilder.append(paramAIOContext.getBaseInfoString());
              QLog.d("GuildOneClickJumpMsgFilter", 2, localStringBuilder.toString());
            }
          }
          if (l2 - paramAIOContext.shmsgseq > 1L)
          {
            l1 = l2 - 1L;
            while (l1 > paramAIOContext.shmsgseq) {
              if (a(l1)) {
                l1 -= 1L;
              } else {
                j = 1;
              }
            }
            if (j != 0) {
              return l2;
            }
          }
          l1 = paramAIOContext.shmsgseq;
        }
      }
      i -= 1;
    }
    label481:
    return l2;
  }
  
  private IGuildAioMsgFilterApi.MsgSeqItem b(List<ChatMessage> paramList)
  {
    IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = new IGuildAioMsgFilterApi.MsgSeqItem();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      if ((localChatMessage != null) && (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(localChatMessage))) {
        try
        {
          localMsgSeqItem.c = Long.parseLong(localChatMessage.getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
          localMsgSeqItem.b = localChatMessage.shmsgseq;
          localMsgSeqItem.a = localChatMessage.uniseq;
          return localMsgSeqItem;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAIOList, e = ");
          localStringBuilder.append(localNumberFormatException);
          QLog.d("GuildOneClickJumpMsgFilter", 1, localStringBuilder.toString());
        }
      }
      i -= 1;
    }
    return localMsgSeqItem;
  }
  
  private void b()
  {
    Object localObject = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getLatestMsgSeqItem();
    IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getReadLatestMsgSeqItem();
    if (localObject == null) {
      return;
    }
    if (localMsgSeqItem == null) {
      a = (int)((IGuildAioMsgFilterApi.MsgSeqItem)localObject).c;
    } else if (((IGuildAioMsgFilterApi.MsgSeqItem)localObject).c > localMsgSeqItem.c) {
      a = (int)(((IGuildAioMsgFilterApi.MsgSeqItem)localObject).c - localMsgSeqItem.c);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUnreadCount, mLatestMsgSeqItem = ");
      localStringBuilder.append(localObject);
      localStringBuilder.append("mReadLatestMsgSeqItem = ");
      localObject = localMsgSeqItem;
      if (localMsgSeqItem == null) {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      QLog.d("GuildOneClickJumpMsgFilter", 2, localStringBuilder.toString());
    }
  }
  
  private void b(@NonNull AIOContext paramAIOContext)
  {
    IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem1 = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getLatestMsgSeqItem();
    IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem2 = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getCurAioLatestMsgSeqItem();
    boolean bool;
    if ((localMsgSeqItem1 != null) && (localMsgSeqItem2 != null) && (localMsgSeqItem1.a != localMsgSeqItem2.a)) {
      bool = true;
    } else {
      bool = false;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new GuildOneClickJumpMsgFilter.1(this, localMsgSeqItem1, localMsgSeqItem2, bool, paramAIOContext));
      return;
    }
    if (localMsgSeqItem1 != null)
    {
      if (localMsgSeqItem2 == null) {
        return;
      }
      if (bool != paramAIOContext.e().b().e()) {
        paramAIOContext.e().b().a(bool);
      }
    }
  }
  
  private int c(@NonNull AIOContext paramAIOContext)
  {
    int i = paramAIOContext.e().b().s();
    int j = paramAIOContext.e().b().v();
    int k = paramAIOContext.e().b().u();
    int m = paramAIOContext.e().b().k();
    int n = paramAIOContext.e().b().w();
    int i1 = n - j - i;
    int i2 = i1 - (k - j) - m;
    if (QLog.isColorLevel())
    {
      paramAIOContext = new StringBuilder();
      paramAIOContext.append("getAIOList, footerCnt = ");
      paramAIOContext.append(i);
      paramAIOContext.append(", headerCnt = ");
      paramAIOContext.append(j);
      paramAIOContext.append(", firstVisibleItem = ");
      paramAIOContext.append(k);
      paramAIOContext.append(", visibleItemCount = ");
      paramAIOContext.append(m);
      paramAIOContext.append(", totalItemCount = ");
      paramAIOContext.append(n);
      paramAIOContext.append(", listSize = ");
      paramAIOContext.append(i1);
      paramAIOContext.append(", bottomCount = ");
      paramAIOContext.append(i2);
      QLog.d("GuildOneClickJumpMsgFilter", 2, paramAIOContext.toString());
    }
    return i2;
  }
  
  private void c(List<ChatMessage> paramList)
  {
    long l = d(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ChatMessage)paramList.next()).shmsgseq > l) {
        paramList.remove();
      }
    }
  }
  
  private long d(@NonNull List<ChatMessage> paramList)
  {
    long l1 = ((ChatMessage)paramList.get(0)).shmsgseq;
    int i = 0;
    while (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      if (((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(localChatMessage))
      {
        l1 = localChatMessage.shmsgseq;
      }
      else
      {
        if (localChatMessage.shmsgseq - l1 > 1L)
        {
          long l2 = l1 + 1L;
          while (l2 < localChatMessage.shmsgseq) {
            if (a(l2))
            {
              l2 += 1L;
            }
            else
            {
              j = 1;
              break label122;
            }
          }
          int j = 0;
          label122:
          if (j != 0) {
            return l1;
          }
        }
        l1 = localChatMessage.shmsgseq;
      }
      i += 1;
    }
    return l1;
  }
  
  public boolean a(@NonNull AIOContext paramAIOContext, boolean paramBoolean, List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      Object localObject4 = paramAIOContext.e().d().f();
      Object localObject1 = paramAIOContext.e().b();
      if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject1))
      {
        if (localObject4 == null) {
          return false;
        }
        if (!((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildListUIJumpStateMachineControllerIsNotNull(localObject1)) {
          return false;
        }
        ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).updateLatestMsgSeqItem(b(paramList), false);
        a(paramList, "getAIOList before");
        Object localObject2 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getJumpStateFromGuildListUI(localObject1);
        Object localObject3 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getJumpLastStateFromGuildListUI(localObject1);
        long l = ((AioTips)localObject4).h;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getAIOList, isFromUpdate = ");
          ((StringBuilder)localObject4).append(paramBoolean);
          ((StringBuilder)localObject4).append(", listSize = ");
          ((StringBuilder)localObject4).append(paramList.size());
          ((StringBuilder)localObject4).append(", curState = ");
          ((StringBuilder)localObject4).append(localObject2);
          ((StringBuilder)localObject4).append(", lastState = ");
          ((StringBuilder)localObject4).append(localObject3);
          ((StringBuilder)localObject4).append(", firstSeq = ");
          ((StringBuilder)localObject4).append(l);
          QLog.d("GuildOneClickJumpMsgFilter", 2, ((StringBuilder)localObject4).toString());
        }
        a(paramAIOContext, paramList, (JumpState)localObject2, (JumpState)localObject3);
        a(paramAIOContext, paramList, (ListUI)localObject1, (JumpState)localObject2, (JumpState)localObject3);
        int i = c(paramAIOContext);
        paramBoolean = a(paramAIOContext);
        if (i > 0)
        {
          if (paramBoolean) {
            c(paramList);
          }
          b();
        }
        else
        {
          if (paramBoolean) {
            a(paramAIOContext, paramList);
          }
          a = 0;
        }
        ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).updateCurAioLatestMsgSeqItem(b(paramList), true);
        if (paramBoolean) {
          b(paramAIOContext);
        }
        ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).updateReadLatestMsgSeqItem(((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getCurAioLatestMsgSeqItem(), false);
        if (QLog.isColorLevel())
        {
          localObject3 = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getLatestMsgSeqItem();
          localObject2 = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getCurAioLatestMsgSeqItem();
          localObject1 = ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).getReadLatestMsgSeqItem();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getAIOList, latestItem = ");
          paramAIOContext = (AIOContext)localObject3;
          if (localObject3 == null) {
            paramAIOContext = "";
          }
          ((StringBuilder)localObject4).append(paramAIOContext);
          ((StringBuilder)localObject4).append(", curAIOItem = ");
          paramAIOContext = (AIOContext)localObject2;
          if (localObject2 == null) {
            paramAIOContext = "";
          }
          ((StringBuilder)localObject4).append(paramAIOContext);
          ((StringBuilder)localObject4).append(", readItem = ");
          paramAIOContext = (AIOContext)localObject1;
          if (localObject1 == null) {
            paramAIOContext = "";
          }
          ((StringBuilder)localObject4).append(paramAIOContext);
          QLog.d("GuildOneClickJumpMsgFilter", 2, ((StringBuilder)localObject4).toString());
        }
        a(paramList, "getAIOList after");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildOneClickJumpMsgFilter
 * JD-Core Version:    0.7.0.1
 */