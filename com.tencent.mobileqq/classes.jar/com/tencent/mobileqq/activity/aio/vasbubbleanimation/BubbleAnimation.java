package com.tencent.mobileqq.activity.aio.vasbubbleanimation;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.config.business.qvip.QVipBubbleAnimationConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBubbleAnimationProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.impl.XAEngine;
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
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if ((paramChatLayoutListenerInfo == null) || (!(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder instanceof TextItemBuilder.Holder))) {
      return false;
    }
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
    if (localHolder.f == localHolder.b) {
      return true;
    }
    if (!(localHolder.d instanceof ETTextView)) {
      return false;
    }
    ((ETTextView)localHolder.d).setForeground(null);
    QVipBubbleAnimationConfig localQVipBubbleAnimationConfig = QVipBubbleAnimationProcessor.a();
    if (TextUtils.isEmpty(localQVipBubbleAnimationConfig.a)) {
      return false;
    }
    try
    {
      boolean bool = a(paramChatLayoutListenerInfo, localQVipBubbleAnimationConfig, localHolder);
      return bool;
    }
    catch (Exception paramChatLayoutListenerInfo)
    {
      QLog.e("BubbleAnimation", 1, "updateBubbleAnimation" + paramChatLayoutListenerInfo.getMessage());
    }
    return false;
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, ETTextView paramETTextView, XAEngine paramXAEngine, TextItemBuilder.Holder paramHolder)
  {
    if (paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
      return false;
    }
    String str = paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg + "default";
    paramXAEngine.setProxy(1, paramETTextView, false);
    paramXAEngine.start();
    if ((paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mNewAnimFlag) && (paramHolder.b >= paramHolder.c - 9))
    {
      paramXAEngine.notifyMonitor("$MSG_TEXT", str);
      paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mNewAnimFlag = false;
    }
    str = null;
    paramETTextView = str;
    if (paramXAEngine.findById(1) != null)
    {
      paramETTextView = str;
      if (paramXAEngine.findById(1).a() != null) {
        paramETTextView = paramXAEngine.findById(1).a().a();
      }
    }
    if ((!paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) && (paramETTextView != null)) {
      ((IDrawable)paramETTextView).a().setMirror(true);
    }
    paramHolder.f = paramHolder.b;
    return true;
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, QVipBubbleAnimationConfig paramQVipBubbleAnimationConfig, TextItemBuilder.Holder paramHolder)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = paramHolder.a;
    if (localObject1 == null) {
      return false;
    }
    localObject2 = (BubbleManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localObject2 == null) {
      return false;
    }
    localObject1 = ((BubbleManager)localObject2).a(((BubbleInfo)localObject1).a).getAbsolutePath();
    if (!a((String)localObject1 + File.separatorChar + "bubbleframe" + "/0001.9.png")) {
      return false;
    }
    return a(paramChatLayoutListenerInfo, paramQVipBubbleAnimationConfig, paramHolder, (String)localObject1, paramHolder.d.getContext());
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, QVipBubbleAnimationConfig paramQVipBubbleAnimationConfig, TextItemBuilder.Holder paramHolder, String paramString, Context paramContext)
  {
    if ((paramHolder.d instanceof ETTextView))
    {
      ETTextView localETTextView = (ETTextView)paramHolder.d;
      XAEngine localXAEngine = new XAEngine(paramContext);
      localXAEngine.setContentLayout(new FrameLayout(paramContext));
      if (a(paramString + "/xa.json")) {
        localXAEngine.initRoot(paramString);
      }
      for (;;)
      {
        return a(paramChatLayoutListenerInfo, localETTextView, localXAEngine, paramHolder);
        localXAEngine.getRuleManager().a("$PARENT_ROOT", paramString);
        localXAEngine.init(paramQVipBubbleAnimationConfig.a);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.vasbubbleanimation.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */