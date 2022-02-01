package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IBaseBubbleClickProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class QCircleHandler
  extends ChatLayoutHandler
  implements IBaseBubbleClickProcessor
{
  public QCircleHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private ChatAdapter1 a()
  {
    if (!(this.d instanceof BaseActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((BaseActivity)this.d).getChatFragment();
    if (localChatFragment == null) {
      return null;
    }
    return localChatFragment.k().V;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = Uri.parse(paramString1);
        String str2 = paramString1.getQueryParameter("uin");
        String str3 = paramString1.getQueryParameter("extinfo");
        boolean bool2 = "1".equals(paramString1.getQueryParameter("autoShowTimeLine"));
        String str4 = paramString1.getQueryParameter("actiontype");
        String str1 = paramString1.getQueryParameter("actionurl");
        String str5 = paramString1.getQueryParameter("goFirstFeed");
        bool1 = TextUtils.isEmpty(str1);
        paramString1 = str1;
        if (!bool1) {
          try
          {
            paramString1 = URLDecoder.decode(str1, "UTF-8");
          }
          catch (UnsupportedEncodingException paramString1)
          {
            QZLog.e("onGoHomePage", "decode actionurl", paramString1);
            paramString1 = str1;
          }
        }
        bool1 = TextUtils.isEmpty(str4);
        if (!bool1)
        {
          try
          {
            i = Integer.parseInt(str4);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            QZLog.e("onGoHomePage", "parse actiontype", localNumberFormatException);
            break label289;
          }
          if (TextUtils.isEmpty(str5)) {
            break label295;
          }
          bool1 = "1".equals(str5);
          if ((35 == i) && (!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 0))
          {
            paramString2 = new Intent();
            QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
            paramString2.putExtra("qqid", Long.parseLong(str2));
            paramString2.putExtra("famous_space_webview_url", paramString1);
            paramString2.putExtra("click_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(str3)) {
              paramString2.putExtra("extinfo", str3);
            }
            paramString2.putExtra("autoShowTimeLine", bool2);
            paramString2.putExtra("go_first_feed", bool1);
            QZoneApiProxy.isQzonePluginInstalledAndVersionRight(new QCircleHandler.1(this, paramContext, str2, paramString2));
            return;
          }
          a(paramContext, str2, str3, bool2, bool1, paramString2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QZLog.w(paramContext);
        return;
      }
      label289:
      int i = 0;
      continue;
      label295:
      boolean bool1 = false;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramContext == null)
    {
      QZLog.e("QZLog", "openHomePage context==null");
      return;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    localIntent.putExtra("qqid", Long.parseLong(paramString1));
    localIntent.putExtra("qzone_entry", 0);
    localIntent.putExtra("go_first_feed", paramBoolean2);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("extinfo", paramString2);
    }
    localIntent.putExtra("autoShowTimeLine", paramBoolean1);
    QZoneApiProxy.isQzonePluginInstalledAndVersionRight(new QCircleHandler.2(paramContext, paramString3, localIntent));
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if (paramBaseChatItemLayout == null) {
      return;
    }
    paramViewGroup = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.b);
    if ((paramChatMessage != null) && (paramViewGroup != null))
    {
      if (!paramViewGroup.checkViewNonNull()) {
        return;
      }
      if ((paramChatMessage.fakeSenderType == 0) && (paramChatMessage.istroop == 1)) {
        if ((paramChatMessage.getChatMsgRedDotInfo().getQcircleRedDotFlag()) && (paramChatMessage.istroop == 1))
        {
          paramViewGroup.setViewVisibility(0);
          paramViewGroup.setOnClickListener(this.e);
          paramViewGroup.setData(new Object[] { paramChatMessage.getChatMsgRedDotInfo().getQcircleJumpIconUrl() });
        }
        else
        {
          paramViewGroup.setViewVisibility(8);
        }
      }
      paramViewGroup = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.a);
      if ((paramChatMessage != null) && (paramViewGroup != null))
      {
        if (!paramViewGroup.checkViewNonNull()) {
          return;
        }
        if ((paramChatMessage.fakeSenderType == 0) && (paramChatMessage.istroop == 1))
        {
          if ((paramChatMessage.getChatMsgRedDotInfo().getQzoneRedDotFlag()) && (paramChatMessage.istroop == 1))
          {
            paramViewGroup.setViewVisibility(0);
            paramViewGroup.setOnClickListener(this.e);
            paramViewGroup.setData(new Object[] { paramChatMessage.getChatMsgRedDotInfo().getQzoneJumpIconUrl() });
            return;
          }
          paramViewGroup.setViewVisibility(8);
        }
      }
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ChatMessage localChatMessage;
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131430621)
    {
      localChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
      localObject1 = a();
      if (localObject1 != null)
      {
        if (localChatMessage == null) {
          return;
        }
        localObject2 = localChatMessage.getChatMsgRedDotInfo().getQcircleRedDotJumpSchema();
        paramView = JumpParser.a(this.b, paramView.getContext(), (String)localObject2);
        if (paramView != null) {
          paramView.a();
        }
        paramView = ((ChatAdapter1)localObject1).a();
        AIOTroopQcircleRedDotManager.a().a(paramView, localChatMessage.senderuin);
        ((ChatAdapter1)localObject1).notifyDataSetChanged();
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(localChatMessage.senderuin).setActionType(61).setSubActionType(1).setThrActionType(2));
        return;
      }
      return;
    }
    if (paramView.getId() == 2131430622)
    {
      localChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
      localObject1 = a();
      if (localObject1 != null)
      {
        if (localChatMessage == null) {
          return;
        }
        localObject2 = ((ChatAdapter1)localObject1).a();
        AIOTroopQcircleRedDotManager.a().b((List)localObject2, localChatMessage.senderuin);
        ((ChatAdapter1)localObject1).notifyDataSetChanged();
        localObject1 = localChatMessage.getChatMsgRedDotInfo().getQzoneRedDotJumpSchema();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).startsWith("mqqzone://arouse/homepage")))
        {
          a(paramView.getContext(), (String)localObject1, localChatMessage.selfuin);
        }
        else
        {
          paramView = JumpParser.a(this.b, paramView.getContext(), (String)localObject1);
          if (paramView != null) {
            paramView.a();
          }
        }
        if (!AIOTroopQcircleRedDotManager.e())
        {
          LpReportInfo_pf00064.report(1200, 1, 2, localChatMessage.senderuin);
          return;
        }
        LpReportInfo_pf00064.allReport(1200, 1, 2, localChatMessage.senderuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */