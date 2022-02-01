package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ReplyHeadMsgRefresher
  implements IHeadMsgRefresher
{
  private int a(AIOContext paramAIOContext)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(paramAIOContext)) {
      return 11;
    }
    return 6;
  }
  
  private boolean b(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    long l = paramInt2;
    Object localObject = null;
    if (paramLong2 - paramLong1 > l)
    {
      QQToast.makeText(paramAIOContext.b(), 2131895472, 0).show(paramAIOContext.b().getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d("ReplyHeadMsgRefresher", 2, "refreshHeadMessage: invalidate unread count");
      }
      if (paramInt3 == 1) {
        ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
      }
      return true;
    }
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      if (!NetworkUtil.isNetworkAvailable(paramAIOContext.b()))
      {
        QQToast.makeText(paramAIOContext.b(), 2131894999, 0).show(paramAIOContext.b().getTitleBarHeight());
        return false;
      }
      localObject = paramAIOContext.e().b();
      if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildListUIJumpStateMachineControllerIsNotNull(localObject)) {
        ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).setGuildListUIJumpStateINACTIVATED(localObject);
      }
      paramAIOContext.e().d().a(paramLong2, paramLong1, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage: fistseq = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", value = ");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("ReplyHeadMsgRefresher", 2, ((StringBuilder)localObject).toString());
      paramAIOContext.e().d().a(0, -1, paramRunnable, a(paramAIOContext), true);
      return false;
    }
    List localList = paramAIOContext.a().getMessageFacade().b(paramAIOContext.O().b, paramAIOContext.O().a, paramLong1, 0L);
    paramRunnable = (Runnable)localObject;
    if (localList != null)
    {
      paramRunnable = (Runnable)localObject;
      if (localList.size() > 0)
      {
        paramInt2 = 0;
        for (;;)
        {
          paramRunnable = (Runnable)localObject;
          if (paramInt2 >= localList.size()) {
            break;
          }
          paramRunnable = (MessageRecord)localList.get(paramInt2);
          if (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(paramRunnable)) {
            break;
          }
          paramInt2 += 1;
        }
      }
    }
    if ((paramRunnable != null) && (!UniteGrayTipMsgUtil.b(paramRunnable)))
    {
      paramInt2 = paramAIOContext.e().b().a(paramRunnable.uniseq);
      if (paramInt2 != -1)
      {
        paramRunnable = new StringBuilder();
        paramRunnable.append("refreshHeadMessage: pos = ");
        paramRunnable.append(paramInt2);
        QLog.d("ReplyHeadMsgRefresher", 2, paramRunnable.toString());
        paramAIOContext.e().d().a(paramInt1, paramInt2, paramInt2, null, a(paramAIOContext));
        return false;
      }
      if (paramRunnable.msgtype == -2006)
      {
        QQToast.makeText(paramAIOContext.b(), HardCodeUtil.a(2131899208), 0).show(paramAIOContext.b().getTitleBarHeight());
        return false;
      }
    }
    else
    {
      QQToast.makeText(paramAIOContext.b(), 2131895472, 0).show(paramAIOContext.b().getTitleBarHeight());
    }
    return false;
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(paramAIOContext))
    {
      b(paramAIOContext, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
      return;
    }
    if (paramInt2 <= 200)
    {
      if (paramLong2 - paramLong1 > paramInt2)
      {
        QQToast.makeText(paramAIOContext.b(), 2131895472, 0).show(paramAIOContext.b().getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("ReplyHeadMsgRefresher", 2, "refreshHeadMessage: invalidate unread count");
        }
        if (paramInt3 == 1) {
          ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
        }
        return;
      }
      if ((int)paramLong2 >= paramLong1 + 1L)
      {
        if (!NetworkUtil.isNetworkAvailable(paramAIOContext.b()))
        {
          QQToast.makeText(paramAIOContext.b(), 2131894999, 0).show(paramAIOContext.b().getTitleBarHeight());
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
        else
        {
          paramAIOContext.e().d().a(paramLong2, paramLong1, false);
          paramAIOContext.e().d().a(paramInt1, 0, -1, paramRunnable, a(paramAIOContext));
        }
      }
      else
      {
        List localList = paramAIOContext.a().getMessageFacade().b(paramAIOContext.O().b, paramAIOContext.O().a, paramLong1, 0L);
        if ((localList != null) && (localList.size() > 0))
        {
          paramInt2 = 0;
          while (paramInt2 < localList.size())
          {
            paramRunnable = (MessageRecord)localList.get(paramInt2);
            if ((!MsgProxyUtils.a(paramRunnable)) && (!(paramRunnable instanceof MessageForSafeGrayTips))) {
              break label302;
            }
            paramInt2 += 1;
          }
        }
        paramRunnable = null;
        label302:
        if ((paramRunnable != null) && (!UniteGrayTipMsgUtil.b(paramRunnable)))
        {
          paramInt2 = paramAIOContext.e().b().a(paramRunnable.uniseq);
          if (paramInt2 != -1)
          {
            paramAIOContext.e().d().a(paramInt1, paramInt2, paramInt2, null, a(paramAIOContext));
            return;
          }
          if (paramRunnable.msgtype == -2006) {
            QQToast.makeText(paramAIOContext.b(), HardCodeUtil.a(2131899208), 0).show(paramAIOContext.b().getTitleBarHeight());
          }
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
        else
        {
          QQToast.makeText(paramAIOContext.b(), 2131895472, 0).show(paramAIOContext.b().getTitleBarHeight());
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
      }
    }
    else
    {
      QQToast.makeText(paramAIOContext.b(), 2131895473, 0).show(paramAIOContext.b().getTitleBarHeight());
      if (paramInt3 == 1) {
        ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ReplyHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */