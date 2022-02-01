package com.tencent.mobileqq.activity.aio.rebuild.msglist;

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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GuildGuestReplyHeadMsgRefresh
  implements IHeadMsgRefresher
{
  private int a(AIOContext paramAIOContext)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(paramAIOContext)) {
      return 11;
    }
    return 6;
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage, type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", unreadMsgCount: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", fistseq: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", reportType");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("ReplyHeadMsgRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 <= 200)
    {
      if (paramLong2 - paramLong1 > paramInt2)
      {
        QQToast.makeText(paramAIOContext.b(), 2131896503, 0).show(paramAIOContext.b().getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("ReplyHeadMsgRefresher", 2, "refreshHeadMessage: invalidate unread count");
        }
        if (paramInt3 == 1) {
          ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
        }
        return;
      }
      if ((int)paramLong2 >= 1L + paramLong1)
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
        paramRunnable = paramAIOContext.a().getMessageFacade().o(paramAIOContext.O().b, paramAIOContext.O().a);
        if (paramRunnable != null)
        {
          Iterator localIterator = paramRunnable.iterator();
          for (paramRunnable = null;; paramRunnable = (Runnable)localObject)
          {
            IGuildMessageUtilsApi localIGuildMessageUtilsApi;
            do
            {
              localObject = paramRunnable;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (MessageRecord)localIterator.next();
              localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
            } while ((((MessageRecord)localObject).shmsgseq != paramLong1) || (localIGuildMessageUtilsApi.isLocalOnlyMsg((MessageRecord)localObject)));
          }
        }
        localObject = null;
        if ((localObject != null) && (!UniteGrayTipMsgUtil.b((MessageRecord)localObject)))
        {
          paramInt2 = paramAIOContext.e().b().a(((MessageRecord)localObject).uniseq);
          if (paramInt2 != -1)
          {
            paramAIOContext.e().d().a(paramInt1, paramInt2, paramInt2, null, a(paramAIOContext));
            return;
          }
          if (((MessageRecord)localObject).msgtype == -2006) {
            QQToast.makeText(paramAIOContext.b(), HardCodeUtil.a(2131899208), 0).show(paramAIOContext.b().getTitleBarHeight());
          }
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
        else
        {
          QQToast.makeText(paramAIOContext.b(), 2131896503, 0).show(paramAIOContext.b().getTitleBarHeight());
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
      }
    }
    else
    {
      QQToast.makeText(paramAIOContext.b(), 2131896503, 0).show(paramAIOContext.b().getTitleBarHeight());
      if (paramInt3 == 1) {
        ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildGuestReplyHeadMsgRefresh
 * JD-Core Version:    0.7.0.1
 */