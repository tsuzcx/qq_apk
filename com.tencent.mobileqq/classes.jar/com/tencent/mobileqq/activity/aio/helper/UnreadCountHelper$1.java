package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.util.Pair;
import com.tencent.imcore.message.facade.unread.count.UnreadCountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class UnreadCountHelper$1
  implements Runnable
{
  UnreadCountHelper$1(UnreadCountHelper paramUnreadCountHelper) {}
  
  @NotNull
  private String a()
  {
    Object localObject = (IGuildUnreadCntService)UnreadCountHelper.a(this.this$0).getRuntimeService(IGuildUnreadCntService.class, "");
    List localList = ((IGPSService)UnreadCountHelper.a(this.this$0).getRuntimeService(IGPSService.class, "")).getGuildList();
    if (localList == null) {
      return "0";
    }
    int i = 0;
    long l2;
    for (long l1 = 0L; i < localList.size(); l1 = l2)
    {
      IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = ((IGuildUnreadCntService)localObject).getGuildUnreadCnt(((IGProGuildInfo)localList.get(i)).getGuildID());
      l2 = l1;
      if (localUnreadCntInfo.b == 1) {
        l2 = l1 + localUnreadCntInfo.a;
      }
      i += 1;
    }
    l1 -= ((Long)((IGuildUnreadCntService)localObject).getChannelUnreadCntToShow(((IGPSService)UnreadCountHelper.a(this.this$0).getRuntimeService(IGPSService.class, "")).getChannelInfo(UnreadCountHelper.d(this.this$0).b)).first).longValue();
    if (l1 <= 0L) {
      return "";
    }
    if (l1 > 99L) {
      return "99+";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("");
    return ((StringBuilder)localObject).toString();
  }
  
  public void run()
  {
    int i = QCallFacade.a(UnreadCountHelper.a(this.this$0));
    int j = UnreadCountUtil.a(UnreadCountHelper.a(this.this$0), UnreadCountHelper.b(this.this$0)) + i;
    Object localObject1 = (TempMsgBoxAIOHelper)UnreadCountHelper.c(this.this$0).q(95);
    i = j;
    if (localObject1 != null) {
      i = ((TempMsgBoxAIOHelper)localObject1).a(j);
    }
    localObject1 = "";
    Object localObject2;
    String str;
    if (i > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (i > 99) {
        localObject1 = "99+";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(UnreadCountHelper.b(this.this$0).getString(2131917002));
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      str = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901576));
      ((StringBuilder)localObject2).append(UnreadCountHelper.b(this.this$0).getString(2131917002));
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("条未读");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      str = UnreadCountHelper.b(this.this$0).getString(2131917002);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901576));
      ((StringBuilder)localObject2).append(UnreadCountHelper.b(this.this$0).getString(2131917002));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(UnreadCountHelper.c(this.this$0))) {
      localObject1 = a();
    }
    UnreadCountHelper.c(this.this$0).a(str, (String)localObject2, (String)localObject1, UnreadCountHelper.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper.1
 * JD-Core Version:    0.7.0.1
 */