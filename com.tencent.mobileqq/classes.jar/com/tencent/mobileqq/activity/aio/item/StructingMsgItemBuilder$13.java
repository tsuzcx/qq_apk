package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Window;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil.AdverInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class StructingMsgItemBuilder$13
  implements PopupMenuDialog.OnClickActionListener
{
  StructingMsgItemBuilder$13(StructingMsgItemBuilder paramStructingMsgItemBuilder, Activity paramActivity, ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, String paramString, ArrayList paramArrayList) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    Object localObject1 = new ReportDialog(this.a);
    ((Dialog)localObject1).requestWindowFeature(1);
    ((Dialog)localObject1).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject1).setContentView(2131625669);
    ((Dialog)localObject1).show();
    new Handler(this.a.getMainLooper()).postDelayed(new StructingMsgItemBuilder.13.1(this, (Dialog)localObject1), 1500L);
    ChatActivityFacade.b(this.f.d, this.b);
    localObject1 = this.a;
    if ((((localObject1 instanceof SplashActivity)) || ((localObject1 instanceof ChatActivity))) && (((BaseActivity)this.a).getChatFragment() != null) && (((BaseActivity)this.a).getChatFragment().k() != null))
    {
      ((BaseActivity)this.f.e).getChatFragment().k().a(this.b);
      if ((StructLongMessageDownloadProcessor.isPALongMsg(this.b)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(this.b)))
      {
        localObject1 = this.b;
        if ((localObject1 instanceof MessageForStructing))
        {
          localObject1 = (MessageForStructing)localObject1;
          StructLongMessageDownloadProcessor.deleteTask(this.f.d, ((MessageForStructing)localObject1).uniseq);
        }
      }
      long l = 0L;
      localObject1 = this.c;
      if (localObject1 != null) {
        l = ((AbsStructMsg)localObject1).msgId;
      }
      int i = paramMenuItem.id;
      localObject1 = this.f.d;
      Object localObject2 = this.d;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(l);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i + 1);
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Pb_account_lifeservice", (String)localObject2, "0X8006320", "0X8006320", 0, 0, (String)localObject3, "", localStringBuilder.toString(), paramMenuItem.title);
      if (this.e.size() <= paramMenuItem.id) {
        return;
      }
      paramMenuItem = (IPAReportUtil.AdverInfo)this.e.get(paramMenuItem.id);
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("puin", paramMenuItem.a);
        ((JSONObject)localObject1).put("type", paramMenuItem.b);
        ((JSONObject)localObject1).put("index", paramMenuItem.c);
        ((JSONObject)localObject1).put("name", paramMenuItem.d);
        ((JSONObject)localObject1).put("net", paramMenuItem.e);
        ((JSONObject)localObject1).put("mobile_imei", DeviceInfoUtil.b());
        try
        {
          ((JSONObject)localObject1).put("obj", "");
          ((JSONObject)localObject1).put("gdt_cli_data", this.b.getExtInfoFromExtStr("gdt_msgClick"));
          ((JSONObject)localObject1).put("view_id", this.b.getExtInfoFromExtStr("gdt_view_id"));
        }
        catch (JSONException paramMenuItem) {}
        paramMenuItem.printStackTrace();
      }
      catch (JSONException paramMenuItem) {}
      paramMenuItem = (IPAReportUtil)QRoute.api(IPAReportUtil.class);
      localObject2 = this.f.d;
      localObject3 = this.b.selfuin;
      localObject1 = ((JSONObject)localObject1).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      paramMenuItem.reportClickEventForAdver((AppInterface)localObject2, (String)localObject3, (String)localObject1, localStringBuilder.toString());
      return;
    }
    this.f.d.getMessageFacade().a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.13
 * JD-Core Version:    0.7.0.1
 */