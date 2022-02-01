package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil.AdverInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class StructingMsgItemBuilder$13
  implements PopupMenuDialog.OnClickActionListener
{
  StructingMsgItemBuilder$13(StructingMsgItemBuilder paramStructingMsgItemBuilder, Activity paramActivity, ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, String paramString, ArrayList paramArrayList) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    Object localObject = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity);
    ((Dialog)localObject).requestWindowFeature(1);
    ((Dialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject).setContentView(2131559764);
    ((Dialog)localObject).show();
    new Handler(this.jdField_a_of_type_AndroidAppActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.13.1(this, (Dialog)localObject), 1500L);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    if ((((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment() != null) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a() != null))
    {
      ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (((StructLongMessageDownloadProcessor.isPALongMsg(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject).uniseq);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
        break label541;
      }
    }
    label541:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId;; l = 0L)
    {
      int i = paramMenuItem.jdField_a_of_type_Int;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8006320", "0X8006320", 0, 0, "" + l, "", "" + (i + 1), paramMenuItem.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramMenuItem.jdField_a_of_type_Int)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      localObject = (IPAReportUtil.AdverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramMenuItem.jdField_a_of_type_Int);
      paramMenuItem = new JSONObject();
      try
      {
        paramMenuItem.put("puin", ((IPAReportUtil.AdverInfo)localObject).jdField_a_of_type_JavaLangString);
        paramMenuItem.put("type", ((IPAReportUtil.AdverInfo)localObject).b);
        paramMenuItem.put("index", ((IPAReportUtil.AdverInfo)localObject).c);
        paramMenuItem.put("name", ((IPAReportUtil.AdverInfo)localObject).d);
        paramMenuItem.put("net", ((IPAReportUtil.AdverInfo)localObject).e);
        paramMenuItem.put("mobile_imei", DeviceInfoUtil.a());
        paramMenuItem.put("obj", "");
        paramMenuItem.put("gdt_cli_data", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_msgClick"));
        paramMenuItem.put("view_id", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("gdt_view_id"));
        ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportClickEventForAdver(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.selfuin, paramMenuItem.toString(), "" + l);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.13
 * JD-Core Version:    0.7.0.1
 */