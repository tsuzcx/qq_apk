package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IBaseBubbleClickProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
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
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null) {
      return null;
    }
    return localChatFragment.a().a;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool1 = false;
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
        boolean bool3 = TextUtils.isEmpty(str1);
        paramString1 = str1;
        if (!bool3) {}
        try
        {
          paramString1 = URLDecoder.decode(str1, "UTF-8");
          bool3 = TextUtils.isEmpty(str4);
          if (bool3) {
            break label286;
          }
        }
        catch (UnsupportedEncodingException paramString1)
        {
          try
          {
            i = Integer.parseInt(str4);
            if (!TextUtils.isEmpty(str5)) {
              bool1 = "1".equals(str5);
            }
            if ((35 != i) || (TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 0)) {
              break label272;
            }
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
          catch (NumberFormatException localNumberFormatException)
          {
            QZLog.e("onGoHomePage", "parse actiontype", localNumberFormatException);
          }
          paramString1 = paramString1;
          QZLog.e("onGoHomePage", "decode actionurl", paramString1);
          paramString1 = str1;
          continue;
        }
        a(paramContext, str2, str3, bool2, bool1, paramString2);
      }
      catch (Exception paramContext)
      {
        QZLog.w(paramContext);
        return;
      }
      label272:
      return;
      label286:
      int i = 0;
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
    if (paramBaseChatItemLayout == null) {}
    do
    {
      return;
      paramViewGroup = paramBaseChatItemLayout.a(NickNameLayoutProcessor.b);
    } while ((paramChatMessage == null) || (paramViewGroup == null) || (!paramViewGroup.checkViewNonNull()));
    if ((paramChatMessage.fakeSenderType == 0) && (paramChatMessage.istroop == 1))
    {
      if ((!paramChatMessage.getChatMsgRedDotInfo().getQcircleRedDotFlag()) || (paramChatMessage.istroop != 1)) {
        break label195;
      }
      paramViewGroup.setViewVisibility(0);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setData(new Object[] { paramChatMessage.getChatMsgRedDotInfo().getQcircleJumpIconUrl() });
    }
    for (;;)
    {
      paramViewGroup = paramBaseChatItemLayout.a(NickNameLayoutProcessor.a);
      if ((paramChatMessage == null) || (paramViewGroup == null) || (!paramViewGroup.checkViewNonNull()) || (paramChatMessage.fakeSenderType != 0) || (paramChatMessage.istroop != 1)) {
        break;
      }
      if ((!paramChatMessage.getChatMsgRedDotInfo().getQzoneRedDotFlag()) || (paramChatMessage.istroop != 1)) {
        break label205;
      }
      paramViewGroup.setViewVisibility(0);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setData(new Object[] { paramChatMessage.getChatMsgRedDotInfo().getQzoneJumpIconUrl() });
      return;
      label195:
      paramViewGroup.setViewVisibility(8);
    }
    label205:
    paramViewGroup.setViewVisibility(8);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() != 2131364675) {
            break;
          }
          localChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).a;
          localObject1 = a();
        } while ((localObject1 == null) || (localChatMessage == null));
        localObject2 = localChatMessage.getChatMsgRedDotInfo().getQcircleRedDotJumpSchema();
        paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject2);
        if (paramView != null) {
          paramView.a();
        }
        paramView = ((ChatAdapter1)localObject1).a();
        AIOTroopQcircleRedDotManager.a().a(paramView, localChatMessage.senderuin);
        ((ChatAdapter1)localObject1).notifyDataSetChanged();
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(localChatMessage.senderuin, 61, 1, 2);
        return;
      } while (paramView.getId() != 2131364676);
      localChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).a;
      localObject1 = a();
    } while ((localObject1 == null) || (localChatMessage == null));
    Object localObject2 = ((ChatAdapter1)localObject1).a();
    AIOTroopQcircleRedDotManager.a().b((List)localObject2, localChatMessage.senderuin);
    ((ChatAdapter1)localObject1).notifyDataSetChanged();
    Object localObject1 = localChatMessage.getChatMsgRedDotInfo().getQzoneRedDotJumpSchema();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).startsWith("mqqzone://arouse/homepage"))) {
      a(paramView.getContext(), (String)localObject1, localChatMessage.selfuin);
    }
    while (!AIOTroopQcircleRedDotManager.d())
    {
      LpReportInfo_pf00064.report(1200, 1, 2, localChatMessage.senderuin);
      return;
      paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject1);
      if (paramView != null) {
        paramView.a();
      }
    }
    LpReportInfo_pf00064.allReport(1200, 1, 2, localChatMessage.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */