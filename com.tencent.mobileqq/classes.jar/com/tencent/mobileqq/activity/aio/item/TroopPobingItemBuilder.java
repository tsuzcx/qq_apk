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
  public static int a = 0;
  public static String a = "";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopPobingItemBuilder.2(this);
  private TroopPobingItemBuilder.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback = new TroopPobingItemBuilder.1(this);
  
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
    ((TextView)((TroopPobingItemView)localObject).findViewById(2131372882)).setText(paramMessageForTroopPobing.mBrief);
    ((TroopPobingItemView)localObject).a(paramMessageForTroopPobing.mTemplateId, paramChatMessage.isSend());
    return localObject;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    View localView = paramView.findViewById(2131369149);
    paramView = (FrameLayout)paramView.findViewById(2131380939);
    int j = 8;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    int i = j;
    if (paramBoolean) {
      i = 0;
    }
    paramView.setVisibility(i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (jdField_a_of_type_Int == 0) {
      return;
    }
    if (paramArrayList.size() == 1) {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
    }
    try
    {
      try
      {
        paramArrayList = (AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2)
        {
          jdField_a_of_type_Int = 0;
          return;
        }
        i = paramArrayList.textLen;
      }
      finally
      {
        int i;
        label102:
        Object localObject2;
        StringBuilder localStringBuilder;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      break label441;
    }
    try
    {
      paramArrayList = paramString1.substring(i).trim();
      i = jdField_a_of_type_Int;
      if (i != 1) {
        break label247;
      }
      if (!TroopManager.b.contains(paramArrayList)) {
        break label501;
      }
      localObject1 = paramArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      break label441;
      localObject1 = "";
      break label102;
      localObject1 = "";
      break label270;
      paramArrayList = "";
      break label343;
    }
    new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject1, jdField_a_of_type_JavaLangString }).a();
    localObject2 = new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(paramQQAppInterface, paramString2));
    ((ReportTask)localObject2).a(new String[] { paramString2, "", localStringBuilder.toString(), localObject1 }).a();
    label247:
    if (jdField_a_of_type_Int == 2)
    {
      if (TroopManager.c.contains(paramArrayList))
      {
        localObject1 = paramArrayList;
        new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject1, jdField_a_of_type_JavaLangString }).a();
      }
    }
    else
    {
      if (jdField_a_of_type_Int == 3)
      {
        if (!TroopManager.c.contains(paramArrayList)) {
          break label515;
        }
        localObject1 = new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(TroopUtils.b(paramQQAppInterface, paramString2));
        ((ReportTask)localObject1).a(new String[] { paramString2, "", ((StringBuilder)localObject2).toString(), paramArrayList }).a();
        break label481;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("reportWelcome subString error ,content length = ");
          paramQQAppInterface.append(paramString1.length());
          QLog.d("TroopPobingItemBuilder", 2, paramQQAppInterface.toString());
        }
      }
      jdField_a_of_type_Int = 0;
      return;
      jdField_a_of_type_Int = 0;
      throw paramQQAppInterface;
      return;
    }
  }
  
  private boolean a(MessageForTroopPobing paramMessageForTroopPobing)
  {
    return (paramMessageForTroopPobing.mTemplateId != 2000) && (!SimpleUIUtil.a()) && (VasUpdateUtil.a());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (jdField_a_of_type_Int == 0) {
      return;
    }
    if (paramArrayList.size() == 1) {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
    }
    try
    {
      try
      {
        paramArrayList = (AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2)
        {
          jdField_a_of_type_Int = 0;
          return;
        }
        i = paramArrayList.textLen;
      }
      finally
      {
        int i;
        label102:
        Object localObject2;
        StringBuilder localStringBuilder;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      break label312;
    }
    try
    {
      paramArrayList = paramString1.substring(i).trim();
      i = jdField_a_of_type_Int;
      if (i != 1) {
        break label194;
      }
      if (!TroopManager.b.contains(paramArrayList)) {
        break label372;
      }
      localObject1 = paramArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      break label312;
      localObject1 = "";
      break label102;
      paramArrayList = "";
      break label214;
    }
    localObject2 = new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(paramQQAppInterface, paramString2));
    ((ReportTask)localObject2).a(new String[] { paramString2, "", localStringBuilder.toString(), localObject1 }).a();
    label194:
    if (jdField_a_of_type_Int == 3)
    {
      if (!TroopManager.c.contains(paramArrayList)) {
        break label379;
      }
      label214:
      localObject1 = new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(TroopUtils.b(paramQQAppInterface, paramString2));
      ((ReportTask)localObject1).a(new String[] { paramString2, "", ((StringBuilder)localObject2).toString(), paramArrayList }).a();
      break label352;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("reportWelcomeForMixMsg subString error ,content length = ");
        paramQQAppInterface.append(paramString1.length());
        QLog.d("TroopPobingItemBuilder", 2, paramQQAppInterface.toString());
      }
    }
    label312:
    label352:
    jdField_a_of_type_Int = 0;
    return;
    jdField_a_of_type_Int = 0;
    throw paramQQAppInterface;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopPobingItemBuilder.TroopPobingViewHolder localTroopPobingViewHolder = (TroopPobingItemBuilder.TroopPobingViewHolder)paramViewHolder;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558838, paramBaseChatItemLayout, false);
      localTroopPobingViewHolder.a = ((TextView)paramViewHolder.findViewById(2131363798));
      localTroopPobingViewHolder.b = ((TextView)paramViewHolder.findViewById(2131363820));
      localTroopPobingViewHolder.c = paramViewHolder.findViewById(2131365626);
      localTroopPobingViewHolder.d = paramViewHolder.findViewById(2131363966);
      paramView = paramViewHolder.findViewById(2131369149);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.e - AIOUtils.b(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298194);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298195);
    int j = m;
    int i = k;
    if (paramChatMessage.isSend())
    {
      i = m;
      j = k;
    }
    k = AIOUtils.b(20.0F, localContext.getResources());
    m = AIOUtils.b(20.0F, localContext.getResources());
    localTroopPobingViewHolder.a.setPadding(j, k, i, m);
    paramView = (MessageForTroopPobing)paramChatMessage;
    localTroopPobingViewHolder.a.setText(paramView.mBrief);
    if (!bool)
    {
      localTroopPobingViewHolder.c.setVisibility(0);
      localTroopPobingViewHolder.d.setVisibility(0);
      localTroopPobingViewHolder.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      localTroopPobingViewHolder.c.setVisibility(8);
      localTroopPobingViewHolder.d.setVisibility(8);
    }
    paramBaseChatItemLayout = (FrameLayout)paramViewHolder.findViewById(2131380939);
    paramBaseChatItemLayout.removeAllViews();
    a(paramViewHolder, false);
    if (a(paramView)) {
      paramBaseChatItemLayout.addView(a(paramChatMessage, paramViewHolder, paramView));
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopPobingItemBuilder.TroopPobingViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramViewHolder.a.setBackgroundResource(2130850341);
        return;
      }
      paramViewHolder.a.setBackgroundResource(2130850165);
      return;
    }
    paramViewHolder.a.setBackgroundResource(0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder
 * JD-Core Version:    0.7.0.1
 */