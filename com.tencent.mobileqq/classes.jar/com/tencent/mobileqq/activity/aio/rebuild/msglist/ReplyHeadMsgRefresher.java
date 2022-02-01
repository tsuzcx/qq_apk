package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
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
        QQToast.a(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697693, 0).b(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("ReplyHeadMsgRefresher", 2, "refreshHeadMessage: invalidate unread count");
        }
        if (paramInt3 == 1) {
          ReplyTextItemBuilder.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        }
      }
      do
      {
        return;
        if ((int)paramLong2 < 1L + paramLong1) {
          break label162;
        }
        if (NetworkUtil.g(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
          break;
        }
        QQToast.a(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697207, 0).b(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } while (paramInt3 != 1);
      ReplyTextItemBuilder.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      return;
      paramAIOContext.a().a().a(paramLong2, paramLong1, false);
      paramAIOContext.a().a().a(paramInt1, 0, -1, paramRunnable, 6);
      return;
      label162:
      List localList = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1, 0L);
      if ((localList == null) || (localList.size() <= 0)) {
        break label442;
      }
      paramInt2 = 0;
      label208:
      if (paramInt2 >= localList.size()) {
        break label442;
      }
      paramRunnable = (MessageRecord)localList.get(paramInt2);
      if ((MsgProxyUtils.a(paramRunnable)) || ((paramRunnable instanceof MessageForSafeGrayTips))) {}
    }
    for (;;)
    {
      if ((paramRunnable != null) && (!UniteGrayTipUtil.a(paramRunnable)))
      {
        paramInt2 = paramAIOContext.a().a().a(paramRunnable.uniseq);
        if (paramInt2 != -1)
        {
          paramAIOContext.a().a().a(paramInt1, paramInt2, paramInt2, null, 6);
          return;
          paramInt2 += 1;
          break label208;
        }
        if (paramRunnable.msgtype == -2006) {
          QQToast.a(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, HardCodeUtil.a(2131701051), 0).b(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        }
        if (paramInt3 != 1) {
          break;
        }
        ReplyTextItemBuilder.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        return;
      }
      QQToast.a(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697693, 0).b(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (paramInt3 != 1) {
        break;
      }
      ReplyTextItemBuilder.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      return;
      QQToast.a(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697694, 0).b(paramAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (paramInt3 != 1) {
        break;
      }
      ReplyTextItemBuilder.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      return;
      label442:
      paramRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ReplyHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */