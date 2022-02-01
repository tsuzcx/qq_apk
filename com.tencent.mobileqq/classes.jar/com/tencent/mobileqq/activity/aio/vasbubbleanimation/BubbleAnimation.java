package com.tencent.mobileqq.activity.aio.vasbubbleanimation;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorView;
import com.tencent.xaction.openapi.api.IPublicDrawable;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IPublicView;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;

public class BubbleAnimation
{
  private static final BubbleAnimation a = new BubbleAnimation();
  
  public static BubbleAnimation a()
  {
    return a;
  }
  
  private boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleAnimation", 2, "updateBubbleAnimation");
    }
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (paramChatLayoutListenerInfo != null)
    {
      if (!(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder instanceof TextItemBuilder.Holder)) {
        return false;
      }
      Object localObject1 = (TextItemBuilder.Holder)paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
      if (((TextItemBuilder.Holder)localObject1).f == ((TextItemBuilder.Holder)localObject1).b)
      {
        if (QLog.isColorLevel())
        {
          paramChatLayoutListenerInfo = new StringBuilder();
          paramChatLayoutListenerInfo.append("BubbleAnimation can reuse , viewHolder.pos = ");
          paramChatLayoutListenerInfo.append(((TextItemBuilder.Holder)localObject1).b);
          QLog.d("BubbleAnimation", 2, paramChatLayoutListenerInfo.toString());
        }
        return true;
      }
      Object localObject2 = ((TextItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject2 != null) {
        ((View)localObject2).setForeground(null);
      }
      if (!(((TextItemBuilder.Holder)localObject1).d instanceof ETTextView)) {
        return false;
      }
      ((ETTextView)((TextItemBuilder.Holder)localObject1).d).setForeground(null);
      localObject2 = QVipBubbleAnimationProcessor.a();
      if (TextUtils.isEmpty(((QVipBubbleAnimationConfig)localObject2).a))
      {
        QLog.e("BubbleAnimation", 1, "config.json = null");
        return false;
      }
      try
      {
        boolean bool = a(paramChatLayoutListenerInfo, (QVipBubbleAnimationConfig)localObject2, (TextItemBuilder.Holder)localObject1);
        return bool;
      }
      catch (Exception paramChatLayoutListenerInfo)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateBubbleAnimation");
        ((StringBuilder)localObject1).append(paramChatLayoutListenerInfo.getMessage());
        QLog.e("BubbleAnimation", 1, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, View paramView, IXAEngine paramIXAEngine, TextItemBuilder.Holder paramHolder)
  {
    if (paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg);
    ((StringBuilder)localObject).append("default");
    localObject = ((StringBuilder)localObject).toString();
    paramIXAEngine.setProxy(1, paramView, false);
    paramIXAEngine.start();
    if ((paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mNewAnimFlag) && (paramHolder.b >= paramHolder.c - 9))
    {
      paramIXAEngine.notifyMonitor("$MSG_TEXT", localObject);
      paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mNewAnimFlag = false;
    }
    else
    {
      paramIXAEngine.notifyMonitor("$MSG_TEXT_FIRST", localObject);
    }
    localObject = null;
    paramView = (View)localObject;
    if (paramIXAEngine.findById(1) != null)
    {
      paramView = (View)localObject;
      if (paramIXAEngine.findById(1).getDecor() != null) {
        paramView = paramIXAEngine.findById(1).getDecor().getDrawable();
      }
    }
    if ((!paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) && (paramView != null)) {
      ((IPublicDrawable)paramView).getDecor().setMirror(true);
    }
    paramHolder.f = paramHolder.b;
    if (QLog.isColorLevel())
    {
      paramChatLayoutListenerInfo = new StringBuilder();
      paramChatLayoutListenerInfo.append("startBubbleAnimation viewHolder.pos : ");
      paramChatLayoutListenerInfo.append(paramHolder.b);
      QLog.d("BubbleAnimation", 2, paramChatLayoutListenerInfo.toString());
    }
    return true;
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, QVipBubbleAnimationConfig paramQVipBubbleAnimationConfig, TextItemBuilder.Holder paramHolder)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
    if (localObject1 == null) {
      return false;
    }
    localObject2 = (BubbleManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localObject2 == null) {
      return false;
    }
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append(((BubbleManager)localObject2).a(((BubbleInfo)localObject1).a).getAbsolutePath());
    localObject1 = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separatorChar);
    ((StringBuilder)localObject2).append("bubbleframe");
    ((StringBuilder)localObject2).append("/0001.9.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!a((String)localObject2))
    {
      paramChatLayoutListenerInfo = new StringBuilder();
      paramChatLayoutListenerInfo.append("isFileExists false! firstBubblePath = ");
      paramChatLayoutListenerInfo.append((String)localObject2);
      QLog.e("BubbleAnimation", 1, paramChatLayoutListenerInfo.toString());
      return false;
    }
    return a(paramChatLayoutListenerInfo, paramQVipBubbleAnimationConfig, paramHolder, (String)localObject1, paramHolder.d.getContext());
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, QVipBubbleAnimationConfig paramQVipBubbleAnimationConfig, TextItemBuilder.Holder paramHolder, String paramString, Context paramContext)
  {
    Object localObject;
    if (paramHolder.jdField_a_of_type_AndroidViewView != null) {
      localObject = paramHolder.jdField_a_of_type_AndroidViewView;
    } else if (paramHolder.d != null) {
      localObject = paramHolder.d;
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    IXAEngine localIXAEngine = XAApi.c(paramContext);
    localIXAEngine.setContentLayout(new FrameLayout(paramContext));
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append("/xa.json");
    if (a(paramContext.toString()))
    {
      localIXAEngine.initRoot(paramString);
    }
    else
    {
      localIXAEngine.getRuleManager().registerRuleLine("$PARENT_ROOT", paramString);
      localIXAEngine.init(paramQVipBubbleAnimationConfig.a);
    }
    return a(paramChatLayoutListenerInfo, (View)localObject, localIXAEngine, paramHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.vasbubbleanimation.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */