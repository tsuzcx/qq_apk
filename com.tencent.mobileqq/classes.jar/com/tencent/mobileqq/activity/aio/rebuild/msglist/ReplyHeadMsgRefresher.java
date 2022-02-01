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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ReplyHeadMsgRefresher
  implements IHeadMsgRefresher
{
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if (paramInt2 <= 200)
    {
      if (paramLong2 - paramLong1 > paramInt2)
      {
        QQToast.a(paramAIOContext.a(), 2131697699, 0).b(paramAIOContext.a().getTitleBarHeight());
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
        if (!NetworkUtil.isNetworkAvailable(paramAIOContext.a()))
        {
          QQToast.a(paramAIOContext.a(), 2131697226, 0).b(paramAIOContext.a().getTitleBarHeight());
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
        else
        {
          paramAIOContext.a().a().a(paramLong2, paramLong1, false);
          paramAIOContext.a().a().a(paramInt1, 0, -1, paramRunnable, 6);
        }
      }
      else
      {
        List localList = paramAIOContext.a().getMessageFacade().a(paramAIOContext.a().jdField_a_of_type_JavaLangString, paramAIOContext.a().jdField_a_of_type_Int, paramLong1, 0L);
        if ((localList != null) && (localList.size() > 0))
        {
          paramInt2 = 0;
          while (paramInt2 < localList.size())
          {
            paramRunnable = (MessageRecord)localList.get(paramInt2);
            if ((!MsgProxyUtils.a(paramRunnable)) && (!(paramRunnable instanceof MessageForSafeGrayTips))) {
              break label265;
            }
            paramInt2 += 1;
          }
        }
        paramRunnable = null;
        label265:
        if ((paramRunnable != null) && (!UniteGrayTipMsgUtil.a(paramRunnable)))
        {
          paramInt2 = paramAIOContext.a().a().a(paramRunnable.uniseq);
          if (paramInt2 != -1)
          {
            paramAIOContext.a().a().a(paramInt1, paramInt2, paramInt2, null, 6);
            return;
          }
          if (paramRunnable.msgtype == -2006) {
            QQToast.a(paramAIOContext.a(), HardCodeUtil.a(2131701194), 0).b(paramAIOContext.a().getTitleBarHeight());
          }
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
        else
        {
          QQToast.a(paramAIOContext.a(), 2131697699, 0).b(paramAIOContext.a().getTitleBarHeight());
          if (paramInt3 == 1) {
            ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
          }
        }
      }
    }
    else
    {
      QQToast.a(paramAIOContext.a(), 2131697700, 0).b(paramAIOContext.a().getTitleBarHeight());
      if (paramInt3 == 1) {
        ReplyTextItemBuilder.a(paramAIOContext.a(), null, "0X800A36B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ReplyHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */