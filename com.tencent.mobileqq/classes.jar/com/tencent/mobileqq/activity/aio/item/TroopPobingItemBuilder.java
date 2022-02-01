package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class TroopPobingItemBuilder
  extends BaseBubbleBuilder
{
  public static String a;
  public static int c = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopPobingItemBuilder.2(this);
  private TroopPobingItemBuilder.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback = new TroopPobingItemBuilder.1(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopPobingItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @NotNull
  private View a(ChatMessage paramChatMessage, View paramView, MessageForTroopPobing paramMessageForTroopPobing)
  {
    if (paramMessageForTroopPobing.mTemplateId == 2003)
    {
      localObject = new TroopPobingEffectItemView(this.jdField_a_of_type_AndroidContentContext);
      ((TroopPobingEffectItemView)localObject).a(paramMessageForTroopPobing.mBrief, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback);
      ((TroopPobingEffectItemView)localObject).a(paramMessageForTroopPobing.mTemplateId, paramChatMessage.uniseq, paramChatMessage.isSend());
      return localObject;
    }
    Object localObject = new TroopPobingItemView(this.jdField_a_of_type_AndroidContentContext);
    ((TroopPobingItemView)localObject).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback);
    ((TextView)((TroopPobingItemView)localObject).findViewById(2131373302)).setText(paramMessageForTroopPobing.mBrief);
    ((TroopPobingItemView)localObject).a(paramMessageForTroopPobing.mTemplateId, paramChatMessage.isSend());
    return localObject;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131369421);
    paramView = (FrameLayout)paramView.findViewById(2131381706);
    if (paramBoolean)
    {
      i = 8;
      localView.setVisibility(i);
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int i = j;; i = 8)
    {
      paramView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (c == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        Object localObject;
        if (c == 1)
        {
          localObject = "";
          if (TroopManager.b.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
          new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + TroopUtils.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 2)
        {
          localObject = "";
          if (TroopManager.c.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (c == 3)
        {
          if (TroopManager.c.contains(paramArrayList)) {
            new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + TroopUtils.b(paramQQAppInterface, paramString2), paramArrayList }).a();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcome subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        c = 0;
      }
      paramArrayList = "";
    }
  }
  
  private boolean a(MessageForTroopPobing paramMessageForTroopPobing)
  {
    return (paramMessageForTroopPobing.mTemplateId != 2000) && (!SimpleUIUtil.a()) && (VasUpdateUtil.a());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (c == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        if (c == 1)
        {
          Object localObject = "";
          if (TroopManager.b.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + TroopUtils.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 3)
        {
          if (TroopManager.c.contains(paramArrayList)) {
            new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + TroopUtils.b(paramQQAppInterface, paramString2), paramArrayList }).a();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcomeForMixMsg subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        c = 0;
      }
      paramArrayList = "";
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopPobingItemBuilder.TroopPobingViewHolder localTroopPobingViewHolder = (TroopPobingItemBuilder.TroopPobingViewHolder)paramViewHolder;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558940, paramBaseChatItemLayout, false);
      localTroopPobingViewHolder.a = ((TextView)paramViewHolder.findViewById(2131363870));
      localTroopPobingViewHolder.b = ((TextView)paramViewHolder.findViewById(2131363892));
      localTroopPobingViewHolder.c = paramViewHolder.findViewById(2131365789);
      localTroopPobingViewHolder.d = paramViewHolder.findViewById(2131364041);
      paramView = paramViewHolder.findViewById(2131369421);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.e - AIOUtils.a(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298199);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298200);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = AIOUtils.a(20.0F, localContext.getResources());
      int m = AIOUtils.a(20.0F, localContext.getResources());
      localTroopPobingViewHolder.a.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localTroopPobingViewHolder.a.setText(paramView.mBrief);
      if (!bool)
      {
        localTroopPobingViewHolder.c.setVisibility(0);
        localTroopPobingViewHolder.d.setVisibility(0);
        localTroopPobingViewHolder.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (FrameLayout)paramViewHolder.findViewById(2131381706);
        paramBaseChatItemLayout.removeAllViews();
        a(paramViewHolder, false);
        if (a(paramView)) {
          paramBaseChatItemLayout.addView(a(paramChatMessage, paramViewHolder, paramView));
        }
        return paramViewHolder;
        localTroopPobingViewHolder.c.setVisibility(8);
        localTroopPobingViewHolder.d.setVisibility(8);
      }
      j = i;
      i = k;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopPobingItemBuilder.TroopPobingViewHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramViewHolder.a.setBackgroundResource(2130850414);
        return;
      }
      paramViewHolder.a.setBackgroundResource(2130850238);
      return;
    }
    paramViewHolder.a.setBackgroundResource(0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder
 * JD-Core Version:    0.7.0.1
 */