package com.tencent.mobileqq.activity.aio.vasbubbleanimation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorView;
import com.tencent.xaction.openapi.api.IPublicDrawable;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IPublicView;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;
import java.io.File;
import org.jetbrains.annotations.NotNull;

public class BubbleAnimation
{
  private static long a;
  private static final BubbleAnimation c = new BubbleAnimation();
  private boolean b = true;
  
  private BubbleAnimation()
  {
    XAApi.e().registerAnim("physical", "com.tencent.xaction.anim.PhysicalAnim");
  }
  
  private float a(float paramFloat, Context paramContext)
  {
    if (a == 0L) {
      a = paramContext.getResources().getDisplayMetrics().widthPixels;
    }
    return paramFloat * (750.0F / (float)a) + 0.5F;
  }
  
  public static BubbleAnimation a()
  {
    return c;
  }
  
  private void a(IXAEngine paramIXAEngine, View paramView, String paramString, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, TextItemBuilder.Holder paramHolder)
  {
    if (!this.b) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    float f1 = a((paramView.getWidth() >> 1) + paramView.getX(), paramView.getContext());
    float f2 = a((paramView.getHeight() >> 1) + paramHolder.j.getTop(), paramView.getContext());
    paramIXAEngine = paramIXAEngine.getRuleManager();
    if (paramIXAEngine != null)
    {
      paramIXAEngine.registerRuleLine("$ANIM.TX", Float.valueOf(f1));
      paramIXAEngine.registerRuleLine("$ANIM.TY", Float.valueOf(f2));
    }
  }
  
  private boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  @NotNull
  private FrameLayout b(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if (!this.b) {
      return new FrameLayout(paramChatLayoutListenerInfo.f.getContext());
    }
    ViewGroup localViewGroup = (ViewGroup)paramChatLayoutListenerInfo.f.getRootView().findViewById(2131427887);
    if (localViewGroup == null) {
      return null;
    }
    FrameLayout localFrameLayout2 = (FrameLayout)localViewGroup.findViewById(2131429404);
    FrameLayout localFrameLayout1 = localFrameLayout2;
    if (localFrameLayout2 == null)
    {
      localFrameLayout1 = new FrameLayout(paramChatLayoutListenerInfo.f.getContext());
      localFrameLayout1.setId(2131429404);
      localViewGroup.addView(localFrameLayout1, new ViewGroup.LayoutParams(-1, -1));
    }
    if ((localFrameLayout1.getTag() instanceof IXAEngine)) {
      localFrameLayout1.removeAllViews();
    }
    return localFrameLayout1;
  }
  
  private boolean b()
  {
    return QVipFeatureProcessor.a().enableShootAnim;
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
      if (!(paramChatLayoutListenerInfo.g instanceof TextItemBuilder.Holder)) {
        return false;
      }
      Object localObject1 = (TextItemBuilder.Holder)paramChatLayoutListenerInfo.g;
      if (((TextItemBuilder.Holder)localObject1).C == ((TextItemBuilder.Holder)localObject1).l)
      {
        if (QLog.isColorLevel())
        {
          paramChatLayoutListenerInfo = new StringBuilder();
          paramChatLayoutListenerInfo.append("BubbleAnimation can reuse , viewHolder.pos = ");
          paramChatLayoutListenerInfo.append(((TextItemBuilder.Holder)localObject1).l);
          QLog.d("BubbleAnimation", 2, paramChatLayoutListenerInfo.toString());
        }
        return true;
      }
      Object localObject2 = ((TextItemBuilder.Holder)localObject1).h;
      if (localObject2 != null) {
        ((View)localObject2).setForeground(null);
      }
      if (!(((TextItemBuilder.Holder)localObject1).v instanceof ETTextView)) {
        return false;
      }
      ((ETTextView)((TextItemBuilder.Holder)localObject1).v).setForeground(null);
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
    if (paramChatLayoutListenerInfo.g.q == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramChatLayoutListenerInfo.g.q.msg);
    ((StringBuilder)localObject).append("default");
    localObject = ((StringBuilder)localObject).toString();
    paramIXAEngine.setProxy(1, paramView, false);
    paramIXAEngine.start();
    if ((paramChatLayoutListenerInfo.e.mNewAnimFlag) && (paramHolder.l >= paramHolder.m - 9))
    {
      a(paramIXAEngine, paramView, (String)localObject, paramChatLayoutListenerInfo, paramHolder);
      paramIXAEngine.notifyMonitor("$MSG_TEXT", localObject);
      paramChatLayoutListenerInfo.e.mNewAnimFlag = false;
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
    if ((!paramChatLayoutListenerInfo.g.q.isSend()) && (paramView != null)) {
      ((IPublicDrawable)paramView).getDecor().setMirror(true);
    }
    paramHolder.C = paramHolder.l;
    if (QLog.isColorLevel())
    {
      paramChatLayoutListenerInfo = new StringBuilder();
      paramChatLayoutListenerInfo.append("startBubbleAnimation viewHolder.pos : ");
      paramChatLayoutListenerInfo.append(paramHolder.l);
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
    Object localObject1 = paramHolder.i;
    if (localObject1 == null) {
      return false;
    }
    localObject2 = (BubbleManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localObject2 == null) {
      return false;
    }
    this.b = b();
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append(((BubbleManager)localObject2).d(((BubbleInfo)localObject1).a).getAbsolutePath());
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
    return a(paramChatLayoutListenerInfo, paramQVipBubbleAnimationConfig, paramHolder, (String)localObject1, paramHolder.v.getContext());
  }
  
  public boolean a(IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo, QVipBubbleAnimationConfig paramQVipBubbleAnimationConfig, TextItemBuilder.Holder paramHolder, String paramString, Context paramContext)
  {
    Object localObject1;
    if (paramHolder.h != null) {
      localObject1 = paramHolder.h;
    } else if (paramHolder.v != null) {
      localObject1 = paramHolder.v;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return false;
    }
    paramContext = XAApi.c(paramContext);
    Object localObject2 = b(paramChatLayoutListenerInfo);
    if (localObject2 == null) {
      return false;
    }
    paramContext.setContentLayout((ViewGroup)localObject2);
    paramContext.setTag("bubbleAnimation");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("/xa.json");
    if (a(((StringBuilder)localObject2).toString()))
    {
      paramContext.initRoot(paramString);
    }
    else
    {
      paramContext.getRuleManager().registerRuleLine("$PARENT_ROOT", paramString);
      paramContext.init(paramQVipBubbleAnimationConfig.a);
    }
    return a(paramChatLayoutListenerInfo, (View)localObject1, paramContext, paramHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.vasbubbleanimation.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */