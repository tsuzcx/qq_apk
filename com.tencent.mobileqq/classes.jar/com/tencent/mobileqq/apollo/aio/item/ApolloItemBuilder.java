package com.tencent.mobileqq.apollo.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils.AioOpenTips;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.meme.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.apollo.utils.AnimationDrawableUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.os.MqqHandler;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener, IApolloItemBuilder
{
  private static int D = -1;
  private static CopyOnWriteArraySet<IApolloBrickPlayer> E = new CopyOnWriteArraySet();
  private long A;
  private boolean B = false;
  private boolean C = true;
  private int F = 135;
  private int G = 135;
  private IApolloResManager H = ApolloResManagerFacade.a.a(Scene.AIO);
  private View.OnClickListener I = new ApolloItemBuilder.7(this);
  private View.OnClickListener J = new ApolloItemBuilder.8(this);
  private MessageForApollo K;
  private View.OnClickListener L = new ApolloItemBuilder.10(this);
  boolean a = true;
  protected View.OnClickListener w = new ApolloItemBuilder.9(this);
  private boolean x;
  private int y = 0;
  private long z;
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private View a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (a(paramMessageForApollo, paramHolder)) {
      return paramView;
    }
    boolean bool1 = this.x;
    int i = 0;
    if (bool1)
    {
      b(paramHolder, paramMessageForApollo.isSend());
      paramHolder.e.setOnClickListener(this.w);
      ApolloAioBubbleReportUtil.a.a(this.f, paramMessageForApollo);
      if (paramMessageForApollo.isMeme())
      {
        a(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
        return paramView;
      }
      if (paramHolder.z != null)
      {
        paramHolder.z.destroy();
        E.remove(paramHolder.z);
      }
      a(paramHolder.A, 8);
      a(paramHolder.B, 8);
      a(paramMessageForApollo, paramView, paramHolder);
      a(paramHolder.t, 8);
      a(paramHolder.v, 8);
      a(paramHolder.b, 0);
      a(paramHolder.d, 0);
      b(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
      a(paramMessageForApollo, paramBaseChatItemLayout, paramHolder, ((IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramMessageForApollo.mApolloMessage.id));
      b(paramMessageForApollo, paramHolder);
      paramBaseChatItemLayout = (ISpriteScriptManager)this.d.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramBaseChatItemLayout.getTaskHandler() != null) {
        bool1 = paramBaseChatItemLayout.getTaskHandler().a(paramMessageForApollo.uniseq);
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramBaseChatItemLayout.getSpriteContext() != null) {
        bool2 = paramBaseChatItemLayout.getSpriteContext().c();
      } else {
        bool2 = true;
      }
      a(paramMessageForApollo, paramHolder, bool1, bool2);
      d(paramMessageForApollo);
    }
    else
    {
      b(paramHolder, paramMessageForApollo.isSend());
      if (paramMessageForApollo.mApolloMessage != null) {
        paramHolder.a = paramMessageForApollo.mApolloMessage.id;
      }
      paramHolder.e.setTag(Integer.valueOf(paramHolder.a));
      paramHolder.t.setVisibility(0);
      paramHolder.t.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramHolder.t.setOnClickListener(this.I);
      paramHolder.t.setOnLongClickListener(paramOnLongClickAndTouchListener);
      a(paramHolder, paramView.getResources(), false);
      a(paramHolder.b, 8);
      a(paramHolder.c, 8);
      a(paramHolder.d, 8);
    }
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.d.getCurrentUin(), this.d) == 1) {
      i = 1;
    }
    if ((paramHolder.l == paramHolder.m - 1) && (i == 0) && (!paramMessageForApollo.isSend())) {
      b(paramMessageForApollo);
    }
    return paramView;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddMemeFailed ");
    localStringBuilder.append(paramInt);
    QLog.i("[cmshow]ApolloItemBuilder", 1, localStringBuilder.toString());
    a(this.e.getString(2131892632), -1, this.e);
  }
  
  private void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = AnimationUtils.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G))
    {
      int i = ((BaseActivity)paramContext).getChatFragment().k().aR();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
      if (i == 1)
      {
        localObject = (InputMethodManager)paramContext.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).toggleSoftInput(1, 0);
        }
      }
    }
    paramView.putBoolean("IS_APP_SHARE_PIC", true);
    paramView.putBoolean("extra.IS_FROM_MULTI_MSG", true);
    paramView.putBoolean("extra.IS_APOLLO", true);
    if (paramSessionInfo != null)
    {
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.b);
      paramView.putString("uin", paramSessionInfo.b);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.a);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.L = paramMessageForApollo.uniseq;
    paramSessionInfo.a = this.H.a((ApolloActionData)localObject, 0);
    localObject = ApolloGifDownloaderImpl.getApolloGifFilePath(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    PeakUtils.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, TextView paramTextView)
  {
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0) {
        paramTextView.setTextColor(-16777216);
      } else {
        paramTextView.setTextColor(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m == 0)
      {
        paramTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131168018));
        return;
      }
      paramTextView.setLinkTextColor(paramBubbleInfo.m);
      return;
    }
    paramBubbleInfo = paramView.getResources();
    if (paramChatMessage.isSend()) {
      paramView = paramBubbleInfo.getColorStateList(2131168020);
    } else {
      paramView = paramBubbleInfo.getColorStateList(2131168016);
    }
    if (paramView != null) {
      paramTextView.setTextColor(paramView);
    }
    if (paramChatMessage.isSend()) {
      paramView = paramBubbleInfo.getColorStateList(2131168019);
    } else {
      paramView = paramBubbleInfo.getColorStateList(2131168018);
    }
    paramTextView.setLinkTextColor(paramView);
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = (AIOEmoticonPanelHelper)paramBaseChatPie.q(104);
    if (paramBaseChatPie != null) {
      paramBaseChatPie.showEmoticonPanel(15);
    }
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder)
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)this.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (paramHolder.q.sendFailCode == ApolloConstant.m)
    {
      localApolloExtensionHandler.a(this.d.getCurrentUin(), 1L, "userClick");
      return;
    }
    if (paramHolder.q.sendFailCode == ApolloConstant.p)
    {
      localApolloExtensionHandler.a(this.d.getCurrentUin(), 128L, "userClick");
      return;
    }
    if (paramHolder.q.sendFailCode == ApolloConstant.n)
    {
      localApolloExtensionHandler.a(this.d.getCurrentUin(), 2L, "userClick");
      return;
    }
    if (paramHolder.q.sendFailCode == ApolloConstant.o) {
      ApolloContentUpdateHandler.a(this.d, 1);
    }
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder, ActionSheet paramActionSheet, ApolloActionData paramApolloActionData)
  {
    paramActionSheet.addCancelButton(2131887648);
    paramActionSheet.setOnButtonClickListener(new ApolloItemBuilder.6(this, paramHolder, paramApolloActionData, paramActionSheet));
    paramActionSheet.show();
  }
  
  static void a(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if ((paramHolder.w != null) && (!paramBoolean)) {
      paramHolder.w.setVisibility(8);
    }
    Object localObject = paramHolder.d;
    int j = 0;
    int i;
    if (localObject != null)
    {
      localObject = paramHolder.d;
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
    }
    if (paramHolder.b != null)
    {
      localObject = paramHolder.b;
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject).setVisibility(i);
    }
    if (paramHolder.t != null)
    {
      localObject = paramHolder.t;
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((URLImageView)localObject).setVisibility(i);
    }
    if (paramHolder.u != null)
    {
      localObject = paramHolder.u;
      i = j;
      if (paramBoolean) {
        i = 8;
      }
      ((ImageView)localObject).setVisibility(i);
    }
    if (paramHolder.v != null) {
      paramHolder.v.setVisibility(8);
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, ApolloItemBuilder.Holder paramHolder)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtilImpl.getDisplayActionName(this.d, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramHolder.f.append(str);
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        paramHolder.f.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          paramHolder.f.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      else if (!TextUtils.isEmpty(paramMessageForApollo.inputText))
      {
        paramHolder.f.append("：").append(paramMessageForApollo.inputText);
      }
      paramHolder.a = paramMessageForApollo.mApolloMessage.id;
    }
    paramMessageForApollo = new StringBuilder();
    paramMessageForApollo.append(HardCodeUtil.a(2131898648));
    paramMessageForApollo.append(paramHolder.f.toString());
    paramView.setContentDescription(paramMessageForApollo.toString());
    paramHolder.f.insert(0, "[a]");
    paramHolder.f.setSpan(paramHolder.g, 0, 3, 33);
    paramHolder.b.setText(paramHolder.f);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    paramBaseChatItemLayout = (MessageForApollo)paramHolder.q;
    if (paramBaseChatItemLayout.stickerWidth == 0) {
      paramBaseChatItemLayout.stickerWidth = this.F;
    } else {
      this.F = paramBaseChatItemLayout.stickerWidth;
    }
    if (paramBaseChatItemLayout.stickerHeight == 0) {
      paramBaseChatItemLayout.stickerHeight = this.G;
    } else {
      this.G = paramBaseChatItemLayout.stickerHeight;
    }
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    if (paramMessageForApollo.isSend())
    {
      i = BaseChatItemLayout.getTextPaddingAlignError();
      j = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    Object localObject;
    if (paramHolder.B == null)
    {
      localObject = new AnimationTextView(this.e);
      ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      ((AnimationTextView)localObject).setId(2131442136);
      paramHolder.e.addView((View)localObject);
      paramHolder.B = ((TextView)localObject);
    }
    if (!paramHolder.C)
    {
      paramHolder.C = true;
      int k = ViewUtils.dip2px(paramBaseChatItemLayout.stickerWidth);
      int m = ViewUtils.dip2px(paramBaseChatItemLayout.stickerHeight);
      localObject = new ApolloPlayerParams(this.e, k, m);
      paramHolder.z = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
      paramHolder.z.setParams((ApolloPlayerParams)localObject);
      localObject = paramHolder.z.getView();
      if ((localObject != null) && (((View)localObject).getParent() == null))
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, m);
        localLayoutParams.addRule(3, 2131442136);
        ((View)localObject).setPadding(i, BaseChatItemLayout.u, j, BaseChatItemLayout.v);
        paramHolder.e.addView((View)localObject, localLayoutParams);
        paramHolder.A = ((View)localObject);
      }
    }
    if (paramHolder.z != null) {
      E.add(paramHolder.z);
    }
    if (paramBaseChatItemLayout.mApolloMessage.text != null)
    {
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append(new String(paramBaseChatItemLayout.mApolloMessage.text));
      if (!TextUtils.isEmpty(paramBaseChatItemLayout.inputText)) {
        ((SpannableStringBuilder)localObject).append(paramBaseChatItemLayout.inputText);
      }
      paramHolder.B.setText((CharSequence)localObject);
      paramHolder.B.setTextColor(-1);
      paramHolder.B.setTextSize(0, this.f.r);
      paramHolder.B.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    }
    a(paramHolder.t, 8);
    a(paramHolder.v, 8);
    a(paramHolder.b, 8);
    a(paramHolder.c, 8);
    a(paramHolder.d, 8);
    if ((paramMessageForApollo.isDoubleAction()) && (CmShowWnsUtils.C())) {
      a(paramHolder.B, 0);
    } else {
      a(paramHolder.B, 8);
    }
    a(paramHolder.A, 0);
    paramHolder.z.setMessageForApollo(paramBaseChatItemLayout, this.f.a);
    paramHolder.z.start();
    a(paramHolder.y, 8);
    a(paramHolder.x, 8);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData)
  {
    int i = paramHolder.l;
    int k = paramHolder.m;
    int j = 1;
    if ((i == k - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
    {
      if (paramMessageForApollo.extraflag == 32768)
      {
        i = j;
        if (paramMessageForApollo.isSendFromLocal()) {}
      }
      else if (this.d.getMsgCache().g(paramMessageForApollo))
      {
        i = j;
      }
      else
      {
        i = 0;
      }
      if (i == 0) {
        if ((this.B) && (this.A == paramMessageForApollo.uniseq))
        {
          if ((!this.f.G) && (!(this.e instanceof MultiForwardActivity)))
          {
            if (paramMessageForApollo.isSend())
            {
              paramHolder.x.setVisibility(0);
              paramHolder.y.setVisibility(8);
              return;
            }
            paramHolder.x.setVisibility(8);
            paramHolder.y.setVisibility(0);
          }
        }
        else if ((!this.B) || (this.A != paramMessageForApollo.uniseq))
        {
          this.K = paramMessageForApollo;
          c(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.4(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
    }
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.5(paramContext, paramInt, paramString));
  }
  
  private boolean a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (this.d != null) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage == null) {
        return true;
      }
      return !(paramHolder instanceof ApolloItemBuilder.Holder);
    }
    return true;
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (m())
      {
        localAnimationDrawable = AnimationDrawableUtil.a(this.e, CmShowItemConstant.a.c());
        localAnimationDrawable.setOneShot(false);
        localAnimationDrawable.selectDrawable(0);
        localAnimationDrawable.setOneShot(false);
        return localAnimationDrawable;
      }
      localAnimationDrawable = AnimationDrawableUtil.a(this.e, CmShowItemConstant.a.a());
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    AnimationDrawable localAnimationDrawable = AnimationDrawableUtil.a(this.e, CmShowItemConstant.a.b());
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (!(paramHolder instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    a(paramHolder, false);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.x)
    {
      if (paramHolder.d == null)
      {
        localObject = new ImageView(this.e);
        ((ImageView)localObject).setId(2131442135);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(7, 2131442137);
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
        paramHolder.e.addView((View)localObject);
        paramHolder.d = ((ImageView)localObject);
      }
      if (paramHolder.b == null)
      {
        localObject = new AnimationTextView(this.e);
        ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.f);
        ((AnimationTextView)localObject).setMinWidth(ViewUtils.dip2px(73.0F));
        ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        paramHolder.e.addView((View)localObject);
        paramHolder.b = ((TextView)localObject);
      }
      paramHolder.b.setClickable(false);
      paramHolder.d.setClickable(false);
      paramHolder.s = 0;
      if (paramHolder.g == null)
      {
        localObject = new ColorDrawable(0);
        ((ColorDrawable)localObject).setBounds(0, 0, ViewUtils.dip2px(31.0F), ViewUtils.dip2px(23.0F));
        paramHolder.g = new VerticalImageSpan((Drawable)localObject);
      }
      if (paramHolder.f == null) {
        paramHolder.f = new SpannableStringBuilder();
      }
      paramHolder.b.setTextSize(0, this.f.r);
      int i = BaseChatItemLayout.getTextPaddingAlignHead();
      int j = BaseChatItemLayout.getTextPaddingAlignError();
      int k = BaseChatItemLayout.getTextPaddingAlignHead();
      if (paramBoolean)
      {
        i = BaseChatItemLayout.getTextPaddingAlignError();
        j = BaseChatItemLayout.getTextPaddingAlignHead();
        k = BaseChatItemLayout.getTextPaddingAlignError();
      }
      paramHolder.b.setPadding(k, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
      localObject = (ViewGroup.MarginLayoutParams)paramHolder.d.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(i, BaseChatItemLayout.n, 0, 0);
      ((ViewGroup.MarginLayoutParams)localObject).width = ViewUtils.dip2px(32.0F);
      ((ViewGroup.MarginLayoutParams)localObject).height = ViewUtils.dip2px(24.0F);
      paramHolder.f.clear();
      if (paramHolder.u != null) {
        paramHolder.u.setVisibility(8);
      }
    }
    else
    {
      paramHolder.e.setOnClickListener(this.J);
      if (paramHolder.t == null)
      {
        localObject = new URLImageView(this.e);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(104.0F), ViewUtils.dip2px(104.0F));
        localLayoutParams.addRule(13);
        paramHolder.e.addView((View)localObject, localLayoutParams);
        paramHolder.t = ((URLImageView)localObject);
      }
      if (paramHolder.u == null)
      {
        localObject = new ImageView(this.e);
        ((ImageView)localObject).setImageResource(2130839585);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        paramHolder.e.addView((View)localObject, localLayoutParams);
        paramHolder.u = ((ImageView)localObject);
      }
    }
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    boolean bool = this.C;
    int i = 2;
    if ((bool) && (this.f != null) && (paramMessageForApollo != null))
    {
      this.C = false;
      Object localObject1 = this.d.getCurrentAccountUin();
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("apollo_sp_key_aio_open_tips_count");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).toString();
      if (D == -1) {
        D = ((SharedPreferences)localObject2).getInt((String)localObject3, 0);
      }
      if (D >= 3) {
        return;
      }
      Object localObject4 = Calendar.getInstance();
      ((Calendar)localObject4).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      int j = ((Calendar)localObject4).get(1);
      int k = ((Calendar)localObject4).get(2);
      int m = ((Calendar)localObject4).get(5);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("apollo_sp_key_aio_open_tips_day");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(k + 1);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(m);
      localObject4 = ((StringBuilder)localObject4).toString();
      if (((SharedPreferences)localObject2).getBoolean((String)localObject4, false)) {
        return;
      }
      D += 1;
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putInt((String)localObject3, D);
      ((SharedPreferences.Editor)localObject2).putBoolean((String)localObject4, true);
      ((SharedPreferences.Editor)localObject2).commit();
      QLog.d("[cmshow]ApolloItemBuilder", 1, "showOpenCmShowTips");
      String str = this.f.b;
      long l = MessageCache.c();
      localObject3 = ApolloConfigUtils.a();
      localObject2 = ((ApolloConfigUtils.AioOpenTips)localObject3).a;
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("key_action", 65);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (!paramMessageForApollo.is3dAction()) {
        i = 1;
      }
      localStringBuilder.append(i);
      ((Bundle)localObject4).putString("key_action_DATA", localStringBuilder.toString());
      ((Bundle)localObject4).putString("textColor", "#40A0FF");
      localObject1 = new UniteGrayTipParam(str, (String)localObject1, (String)localObject2, this.f.a, -5020, 2359300, l);
      i = ((String)localObject2).indexOf(((ApolloConfigUtils.AioOpenTips)localObject3).b);
      ((UniteGrayTipParam)localObject1).a(i, ((ApolloConfigUtils.AioOpenTips)localObject3).b.length() + i, (Bundle)localObject4);
      localObject3 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(this.d, (UniteGrayTipParam)localObject1);
      UniteGrayTipMsgUtil.a(this.d, (MessageForUniteGrayTip)localObject3);
      ApolloAioBubbleReportUtil.a.a(this.d, this.f, paramMessageForApollo, (String)localObject2);
      return;
    }
    QLog.d("[cmshow]ApolloItemBuilder", 1, new Object[] { "showOpenCmShowTips, mShouldShowOpenTips=", Boolean.valueOf(this.C) });
  }
  
  private void b(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramHolder.y == null)
    {
      localImageView = new ImageView(this.e);
      localImageView.setId(2131433476);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131430578);
      localLayoutParams.addRule(15, 2131429332);
      localLayoutParams.leftMargin = 10;
      localImageView.setContentDescription(HardCodeUtil.a(2131898650));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130848998);
      paramHolder.y = localImageView;
      paramHolder.y.setOnClickListener(this.L);
    }
    if (paramHolder.x == null)
    {
      localImageView = new ImageView(this.e);
      localImageView.setId(2131433475);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(0, 2131430578);
      localLayoutParams.addRule(15, 2131429332);
      localImageView.setContentDescription(HardCodeUtil.a(2131898654));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130848998);
      paramHolder.x = localImageView;
      paramHolder.x.setOnClickListener(this.L);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131430611);
    if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramBaseChatItemLayout != null) && (paramMessageForApollo.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      paramHolder.x.setPadding(0, ViewUtils.dip2px(70.0F), 0, 0);
      paramHolder.y.setPadding(0, ViewUtils.dip2px(80.0F), 0, 0);
    }
    else
    {
      paramHolder.x.setPadding(0, ViewUtils.dip2px(30.0F), 0, 0);
      paramHolder.y.setPadding(0, ViewUtils.dip2px(30.0F), 0, 0);
    }
    paramHolder.y.setVisibility(8);
    paramHolder.x.setVisibility(8);
  }
  
  private void b(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    int i;
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.d.getCurrentUin(), this.d) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all");
    if (((!paramMessageForApollo.isSend()) && (localIApolloManagerService.isInActionPlayList(paramMessageForApollo.uniseq))) || ((!paramMessageForApollo.isSend()) && (i == 0)))
    {
      localIApolloManagerService.removeFromActionPlayList(Long.valueOf(paramMessageForApollo.uniseq).longValue());
      if (i != 0)
      {
        a(paramHolder, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloItemBuilder", 2, new Object[] { "showApolloAction status is not open:", Integer.valueOf(this.y) });
      }
    }
    else if ((paramHolder.l == paramHolder.m - 1) && ((i != 0) || ((((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.d.getCurrentUin(), this.d) == 0) && (paramMessageForApollo.isSend()) && (MessageCache.c() - paramMessageForApollo.time < 10L))))
    {
      a(paramHolder, paramMessageForApollo.isSend() ^ true);
    }
  }
  
  private AnimationDrawable c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = AnimationDrawableUtil.a(this.e, CmShowItemConstant.a.d());
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    AnimationDrawable localAnimationDrawable = AnimationDrawableUtil.a(this.e, CmShowItemConstant.a.e());
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void c(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ThreadManager.post(new ApolloItemBuilder.2(this, paramMessageForApollo, paramBaseChatItemLayout, paramHolder), 5, null, true);
  }
  
  private boolean c(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      QLog.e("[cmshow]ApolloItemBuilder", 1, "errInfo->mr is null.");
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click game msg, roomId:");
      localStringBuilder.append(paramMessageForApollo.roomId);
      QLog.d("[cmshow]ApolloItemBuilder", 2, localStringBuilder.toString());
    }
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.id != 99999)) {
      return !((IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.d.getApplication());
    }
    QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131898653), 0).show();
    return true;
  }
  
  private boolean c(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return false;
    }
    if (!((IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.e)) {
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(this.d.getCurrentUin());
    if (localApolloBaseInfo != null)
    {
      this.y = localApolloBaseInfo.apolloStatus;
      if (this.y == 2) {
        return false;
      }
    }
    int i = paramMessageForApollo.istroop;
    return SpriteUtil.a(this.d, i, this.f.b);
  }
  
  private void d(MessageForApollo paramMessageForApollo)
  {
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all");
    long l2 = 0L;
    Object localObject;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localObject = ((IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
      if (localObject != null) {
        l1 = ((ApolloBaseInfo)localObject).apolloUpdateTime;
      } else {
        l1 = 0L;
      }
      if (NetConnInfoCenter.getServerTime() - l1 > 43200L) {
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 2);
      } else if ((localObject != null) && (((ApolloBaseInfo)localObject).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS)) {
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 1);
      }
    }
    if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()))
    {
      localObject = this.d.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
      localStringBuilder.append("");
      if (!TextUtils.equals((CharSequence)localObject, localStringBuilder.toString()))
      {
        localObject = (IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
        localStringBuilder.append("");
        localObject = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(localStringBuilder.toString());
        l1 = l2;
        if (localObject != null) {
          l1 = ((ApolloBaseInfo)localObject).apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 > 43200L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.peerUin);
          ((StringBuilder)localObject).append("");
          localIApolloManagerService.addToBulkPullMap(((StringBuilder)localObject).toString(), 2);
          return;
        }
        if ((localObject != null) && (((ApolloBaseInfo)localObject).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS)) {
          localIApolloManagerService.addToBulkPullMap(((ApolloBaseInfo)localObject).uin, 1);
        }
      }
    }
  }
  
  private void e(View paramView)
  {
    BaseChatPie localBaseChatPie = k();
    if (localBaseChatPie != null)
    {
      EmoticonPanelCmShowHelper.a("1");
      localBaseChatPie.a(3);
      paramView.post(new ApolloItemBuilder.1(this, localBaseChatPie));
    }
  }
  
  private void e(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      a(1);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloItemBuilder.3(this, paramMessageForApollo));
  }
  
  private void f(MessageForApollo paramMessageForApollo)
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)this.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localApolloExtensionHandler == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(2);
    Object localObject;
    int i;
    if (!paramMessageForApollo.isSend())
    {
      localObject = ((IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
      if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
        localArrayList.add(paramMessageForApollo.senderuin);
      }
      if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
      {
        i = ((ApolloBaseInfo)localObject).apolloStatus;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apollo status is not opened uin: ");
        ((StringBuilder)localObject).append(paramMessageForApollo.senderuin);
        ((StringBuilder)localObject).append(", status: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.peerUin > 0L) && (paramMessageForApollo.mApolloMessage.peerUin != this.d.getLongAccountUin()))
    {
      localObject = (IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
      localStringBuilder.append("");
      localObject = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(localStringBuilder.toString());
      if (localObject != null) {
        if (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime <= 300L) {
          break label337;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
      localStringBuilder.append("");
      localArrayList.add(localStringBuilder.toString());
      label337:
      if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
      {
        i = ((ApolloBaseInfo)localObject).apolloStatus;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apollo status is not opened uin: ");
        ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.peerUin);
        ((StringBuilder)localObject).append(", status: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (!localArrayList.isEmpty()) {
      localApolloExtensionHandler.a((String[])localArrayList.toArray(new String[0]));
    }
  }
  
  public static void h()
  {
    Iterator localIterator = E.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).pause();
    }
  }
  
  public static void i()
  {
    Iterator localIterator = E.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).resume();
    }
  }
  
  public static void j()
  {
    Iterator localIterator = E.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).destroy();
    }
  }
  
  private BaseChatPie k()
  {
    if ((this.e instanceof BaseActivity))
    {
      ChatFragment localChatFragment = ((BaseActivity)this.e).getChatFragment();
      if (localChatFragment != null) {
        return localChatFragment.k();
      }
    }
    return null;
  }
  
  private boolean l()
  {
    return (!this.a) || (c()) || (System.currentTimeMillis() - this.z < 600L);
  }
  
  private boolean m()
  {
    return ThemeUtil.getCurrentThemeId().equals("3064");
  }
  
  private QQProgressDialog n()
  {
    if (((BaseActivity)this.e).getChatFragment().k() != null)
    {
      if (((BaseActivity)this.e).getChatFragment().k().ag == null) {
        ((BaseActivity)this.e).getChatFragment().k().ag = new QQProgressDialog(this.e);
      }
      return ((BaseActivity)this.e).getChatFragment().k().ag;
    }
    return null;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ApolloItemBuilder.Holder)paramChatMessage.getTag();
    if (this.x)
    {
      if (paramView.v != null) {
        paramView.v.setVisibility(8);
      }
      if (paramView.c != null) {
        paramView.c.setVisibility(8);
      }
      return paramChatMessage;
    }
    if (paramView.c != null) {
      paramView.c.setVisibility(8);
    }
    if (paramView.v == null)
    {
      paramViewGroup = paramView.j;
      paramOnLongClickAndTouchListener = new TextView(this.e);
      paramOnLongClickAndTouchListener.setSingleLine(true);
      paramOnLongClickAndTouchListener.setGravity(16);
      paramOnLongClickAndTouchListener.setEllipsize(TextUtils.TruncateAt.END);
      paramOnLongClickAndTouchListener.setTextColor(-1);
      paramOnLongClickAndTouchListener.setTextSize(2, 12.0F);
      paramOnLongClickAndTouchListener.setPadding(ViewUtils.dip2px(5.0F), 0, ViewUtils.dip2px(5.0F), 0);
      paramOnLongClickAndTouchListener.setBackgroundResource(2130843655);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(5, 2131430578);
      localLayoutParams.addRule(3, 2131430578);
      localLayoutParams.topMargin = ViewUtils.dip2px(-3.0F);
      localLayoutParams.leftMargin = ViewUtils.dip2px(12.0F);
      paramView.v = paramOnLongClickAndTouchListener;
      paramViewGroup.addView(paramOnLongClickAndTouchListener, localLayoutParams);
      paramView.v.setOnClickListener(this.J);
    }
    paramView.v.setVisibility(8);
    paramView.v.setText(HardCodeUtil.a(2131898655));
    paramViewGroup = this.e.getResources().getDrawable(2130838556);
    paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
    paramView.v.setCompoundDrawables(paramViewGroup, null, null, null);
    paramView.v.setPadding(ViewUtils.dip2px(5.0F), 0, ViewUtils.dip2px(5.0F), 0);
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return paramView;
    }
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if (paramView != null)
    {
      paramViewHolder = paramView;
      if (localHolder != null)
      {
        paramViewHolder = paramView;
        if (localHolder.e != null) {}
      }
    }
    else
    {
      paramViewHolder = new RelativeLayout(this.e);
      paramViewHolder.setId(2131442137);
      localHolder.e = paramViewHolder;
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage = (MessageForApollo)paramChatMessage;
    this.x = c(paramChatMessage);
    return a(paramChatMessage, localHolder, paramViewHolder, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloItemBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForApollo)) {
        return;
      }
      MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
      boolean bool = localMessageForApollo.isMeme();
      if (paramInt != 2131431695)
      {
        if (paramInt != 2131432813)
        {
          if (paramInt != 2131438943)
          {
            super.a(paramInt, paramContext, paramChatMessage);
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          ApolloAioBubbleReportUtil.a.a(this.d, this.f, localMessageForApollo, bool);
          return;
        }
        if ((localMessageForApollo != null) && (localMessageForApollo.mApolloMessage != null))
        {
          if (localMessageForApollo.isMeme()) {
            e(localMessageForApollo);
          } else {
            a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
          }
          ApolloAioBubbleReportUtil.a.b(this.f, localMessageForApollo);
        }
      }
      else
      {
        ChatActivityFacade.b(this.e, this.d, paramChatMessage);
        ApolloAioBubbleReportUtil.a.b(this.d, this.f, localMessageForApollo, bool);
      }
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.b(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramView = (ApolloItemBuilder.Holder)paramView;
    if (paramInt1 == 1)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all");
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.q, paramView.j)) {
          paramView.j.setFailedIconVisable(false, this);
        }
        localIApolloManagerService.removeFromActionDownloadList(paramView.a);
        return;
      }
      if (!localIApolloManagerService.isInActionDownloadList(paramView.a)) {
        localIApolloManagerService.addToActionDownloadList(paramView.a);
      }
      if (localIApolloManagerService.getApolloStatus(this.d.getCurrentUin()) == 2) {
        return;
      }
      paramView.j.setFailedIconVisable(true, this);
    }
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloMessageUtilImpl.markRead(paramMessageForApollo, this.d, this.f.b, this.f.a);
    }
    if ((paramView != null) && ((AIOUtils.b(paramView) instanceof ApolloItemBuilder.Holder)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        ((IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all")).removeFromActionDownloadList(paramMessageForApollo.mApolloMessage.id);
      }
      ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
      if (!super.a(paramMessageForApollo, localHolder.j)) {
        localHolder.j.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout))
      {
        if (paramMessageForApollo.actionType == 5) {
          paramView = c(paramMessageForApollo.isSend());
        } else {
          paramView = b(paramMessageForApollo.isSend());
        }
        if ((paramView != null) && (localHolder.d != null))
        {
          localHolder.d.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if (paramBubbleInfo == null) {
      return;
    }
    if (paramViewHolder.B != null) {
      a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.B);
    }
    if (paramViewHolder.b != null) {
      a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.b);
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = AIOUtils.b(paramBaseChatItemLayout2);
    if (!(localObject instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramBaseChatItemLayout2 = AIOUtils.b(paramBaseChatItemLayout1);
    if (!(paramBaseChatItemLayout2 instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    localObject = (ApolloItemBuilder.Holder)localObject;
    paramBaseChatItemLayout2 = (ApolloItemBuilder.Holder)paramBaseChatItemLayout2;
    if (((ApolloItemBuilder.Holder)localObject).a == paramBaseChatItemLayout2.a) {
      a(paramBaseChatItemLayout1, paramInt1, paramInt2);
    }
  }
  
  protected void a(ApolloItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder = (MessageForApollo)paramHolder.q;
    if (((!paramHolder.hasPlayed) || (paramInt == 2)) && (this.d != null))
    {
      Object localObject = (ISpriteScriptManager)this.d.getRuntimeService(ISpriteScriptManager.class, "all");
      ISpriteBridge localISpriteBridge = ((ISpriteScriptManager)localObject).getSpriteBridge();
      localObject = ((ISpriteScriptManager)localObject).getSpriteContext();
      if (this.y != 1) {
        ((ISpriteContext)localObject).a(true);
      }
      if (localISpriteBridge != null) {
        localISpriteBridge.a(paramInt, paramHolder);
      }
    }
  }
  
  void a(ApolloItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    if (paramHolder != null) {
      if (paramResources == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = (ViewUtils.dpToPx(URLDrawableHelper.getRoundCorner()) / 2.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramResources.getDrawable(2130838557);
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramResources.getDrawable(2130838559);
        if (!paramBoolean) {
          break label287;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(paramHolder.a + l));
        File localFile = new File(ApolloGifDownloaderImpl.getApolloGifFilePath(paramHolder.a));
        if (localFile.exists())
        {
          paramResources = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
          paramHolder.t.setImageDrawable(paramResources);
          paramHolder.u.setVisibility(8);
        }
        else
        {
          paramResources = URLDrawable.getDrawable(paramResources, (URLDrawable.URLDrawableOptions)localObject);
          paramResources.setTag(Integer.valueOf(paramHolder.a));
          paramHolder.t.setImageDrawable(paramResources);
          paramHolder.t.setURLDrawableDownListener(this);
          if (paramResources.getStatus() == 0) {
            paramHolder.u.setVisibility(0);
          } else {
            paramHolder.u.setVisibility(8);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("actionId->");
          ((StringBuilder)localObject).append(paramHolder.a);
          ((StringBuilder)localObject).append(" drawable.getStatus()->");
          ((StringBuilder)localObject).append(paramResources.getStatus());
          QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Throwable paramHolder)
      {
        QLog.e("[cmshow]ApolloItemBuilder", 1, paramHolder.getMessage());
      }
      return;
      label287:
      long l = 0L;
    }
  }
  
  protected void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramHolder.j.setUnread(false);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all");
    if ((localIApolloManagerService.isInActionDownloadList(paramHolder.a)) && (localIApolloManagerService != null) && (localIApolloManagerService.getApolloStatus(this.d.getCurrentUin()) != 2) && (paramBoolean2)) {
      paramHolder.j.setFailedIconVisable(true, this);
    }
    if (paramBoolean1)
    {
      AnimationDrawable localAnimationDrawable;
      if (paramMessageForApollo.actionType == 5) {
        localAnimationDrawable = c(paramMessageForApollo.isSend());
      } else {
        localAnimationDrawable = b(paramMessageForApollo.isSend());
      }
      if (localAnimationDrawable != null)
      {
        paramHolder.d.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
      localIApolloManagerService.removeFromActionDownloadList(paramHolder.a);
      if (!paramMessageForApollo.hasPlayed) {
        ApolloMessageUtilImpl.markRead(paramMessageForApollo, this.d, this.f.b, this.f.a);
      }
    }
    else
    {
      int i;
      if (paramMessageForApollo.actionType == 5)
      {
        if (paramMessageForApollo.isSend()) {
          i = 2130838430;
        } else {
          i = 2130838425;
        }
      }
      else if (paramMessageForApollo.isSend())
      {
        if (m()) {
          i = 2130838415;
        } else {
          i = 2130838436;
        }
      }
      else {
        i = 2130838420;
      }
      paramHolder.d.setImageResource(i);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ApolloItemBuilder.Holder))
    {
      paramObject = (ApolloItemBuilder.Holder)paramObject;
      paramObject.j.setUnread(false);
      if (paramObject.d != null)
      {
        paramObject = paramObject.d.getDrawable();
        if ((paramObject != null) && ((paramObject instanceof AnimationDrawable)))
        {
          paramObject = (AnimationDrawable)paramObject;
          paramObject.stop();
          paramObject.selectDrawable(0);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (AnonymousChatHelper.a().a(paramMessageForApollo.frienduin)) {
      return true;
    }
    int i = ((IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.d.getCurrentUin());
    return ((paramMessageForApollo.is3dAction()) && (i != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.y == 2));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    boolean bool;
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      bool = localMessageForApollo.isMeme();
      if ((this.x) && (!localMessageForApollo.is3dAction()) && (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.d.getCurrentUin(), this.d) == 1) && (!bool)) {
        localQQCustomMenu.a(2131432813, this.e.getString(2131886668), 2130838495);
      } else if ((bool) && (CmShowWnsUtils.o())) {
        localQQCustomMenu.a(2131432813, this.e.getString(2131888863), 2130838495);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
        a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
      ApolloAioBubbleReportUtil.a.a(this.d, this.f, bool, localMessageForApollo);
      a(localQQCustomMenu, paramView);
    }
    else
    {
      bool = false;
    }
    if (!bool) {
      super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    }
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("this:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", destroy(),apollo check game dialog dismiss");
      QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = E.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IApolloBrickPlayer)((Iterator)localObject).next()).destroy();
    }
    E.clear();
    ApolloAioBubbleReportUtil.a.a();
  }
  
  protected void b(View paramView)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.q.isSend())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onErrorIconClick err code: ");
        ((StringBuilder)localObject).append(paramView.q.sendFailCode);
        ((StringBuilder)localObject).append(", extraflag: ");
        ((StringBuilder)localObject).append(paramView.q.extraflag);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      a(paramView);
      Object localObject = (IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(this.d.getCurrentAccountUin());
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      ApolloActionData localApolloActionData = ((IApolloDaoManagerService)localObject).findActionById(paramView.a);
      if ((paramView.q.sendFailCode == ApolloConstant.m) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localActionSheet.setMainTitle(this.e.getResources().getString(2131886691));
        localActionSheet.addButton(this.e.getResources().getString(2131886690), 1);
        paramView.s = 1;
        QZoneVipInfoManager.a((Activity)this.e, this.d.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.q.sendFailCode == ApolloConstant.n) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localActionSheet.setMainTitle(this.e.getResources().getString(2131886691));
        localActionSheet.addButton(this.e.getResources().getString(2131886690), 1);
        paramView.s = 2;
        QZoneVipInfoManager.a((Activity)this.e, this.d.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.q.sendFailCode == ApolloConstant.p) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!((IApolloDaoManagerService)localObject).isObtainActionById(localApolloActionData.actionId))))
      {
        localActionSheet.setMainTitle(this.e.getResources().getString(2131886688));
        localActionSheet.addButton(this.e.getResources().getString(2131886687), 1);
        paramView.s = 3;
      }
      else if (paramView.q.sendFailCode == ApolloConstant.o)
      {
        localActionSheet.setMainTitle(this.e.getResources().getString(2131886689));
        paramView.s = 4;
      }
      else
      {
        if ((paramView.q.sendFailCode == 0) && (!super.a(paramView.q, paramView.j))) {
          return;
        }
        localActionSheet.addButton(this.e.getResources().getString(2131886693), 1);
      }
      a(paramView, localActionSheet, localApolloActionData);
      return;
    }
    a(paramView, 2);
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131442135);
      if (paramView != null)
      {
        int i;
        if (paramMessageForApollo.actionType == 5)
        {
          if (paramMessageForApollo.isSend()) {
            i = 2130838430;
          } else {
            i = 2130838425;
          }
        }
        else if (paramMessageForApollo.isSend())
        {
          if (m()) {
            i = 2130838415;
          } else {
            i = 2130838436;
          }
        }
        else {
          i = 2130838420;
        }
        paramView.setImageResource(i);
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForApollo))
    {
      paramChatMessage = (MessageForApollo)paramChatMessage;
      if (paramChatMessage.isMeme())
      {
        if ((paramChatMessage.istroop == 1) && (paramChatMessage.isDoubleAction()) && (CmShowWnsUtils.C())) {
          return 1;
        }
        return 0;
      }
    }
    if (this.x) {
      return 1;
    }
    return 2;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131898651));
    localStringBuilder.append(paramChatMessage.msg);
    return localStringBuilder.toString();
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.u != null) {
      paramView.u.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.u != null) {
      paramView.u.setVisibility(8);
    }
    paramView = new StringBuilder();
    paramView.append("onLoadFailed id: ");
    paramView.append(paramURLDrawable.getTag());
    paramView.append(", status: ");
    paramView.append(paramURLDrawable.getStatus());
    QLog.e("[cmshow]ApolloItemBuilder", 1, paramView.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.u != null) {
      paramView.u.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = AIOUtils.b(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramView = (ApolloItemBuilder.Holder)paramView;
    if (paramView.u != null) {
      paramView.u.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */