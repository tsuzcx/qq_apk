package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil.AdverInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewWrapper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgTimeReport;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10.ViewHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout19;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, Callback, ContextMenuBuilder2, MediaPlayerManager.Callback
{
  static int a;
  public static final int[] x = { 83, 98, 108, 114, 116, 151, 156 };
  private List<StructMsgForImageShare> A = new ArrayList();
  private List<AbsShareMsg> B = new ArrayList();
  private StructingMsgItemBuilderMenuHelper C;
  private volatile boolean D = false;
  private volatile boolean E = false;
  private volatile boolean F = false;
  PopupMenuDialog w;
  private final float y;
  private StructMsgTimeReport z = null;
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.y = paramContext.getResources().getDisplayMetrics().density;
    this.z = new StructMsgTimeReport();
    this.C = new StructingMsgItemBuilderMenuHelper(this);
  }
  
  private int a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt1 - paramInt2;
    }
    paramViewHolder.h.setBackgroundResource(paramInt3);
    if ((paramBoolean) && (paramViewHolder.h.getParent() != null) && ((paramViewHolder.h.getParent() instanceof RelativeLayout)))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)paramViewHolder.h.getParent();
      paramContext = new View(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131430578);
      localLayoutParams.addRule(5, 2131430578);
      localLayoutParams.addRule(7, 2131430578);
      localLayoutParams.addRule(8, 2131430578);
      if (paramViewHolder.p != null) {
        localRelativeLayout.removeView(paramViewHolder.p);
      }
      if (MultiMsgUtil.a(paramChatMessage))
      {
        if (QQTheme.isNowSimpleUI()) {
          paramInt4 = 0;
        }
        paramContext.setBackgroundResource(paramInt4);
      }
      else
      {
        paramContext.setBackgroundResource(paramInt5);
      }
      paramViewHolder.p = paramContext;
      localRelativeLayout.addView(paramViewHolder.p, 0, localLayoutParams);
    }
    return i;
  }
  
  private View a(ChatMessage paramChatMessage, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, StructingMsgItemBuilder.ViewCache paramViewCache, Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    String str = ((StructMsgForGeneralShare)paramAbsStructMsg).getLayoutStr();
    Object localObject = str;
    if (a(paramAbsStructMsg.mMsgServiceID))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramMessageForStructing.issend);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramMessageForStructing = a(paramChatMessage, paramBundle, (String)localObject);
    paramChatMessage = null;
    if (paramViewCache != null) {
      paramChatMessage = paramViewCache.b(paramMessageForStructing, paramViewGroup);
    }
    paramOnLongClickAndTouchListener = paramAbsStructMsg.getView(this.e, paramChatMessage, paramOnLongClickAndTouchListener, paramBundle);
    if ((paramChatMessage == null) && (paramViewCache != null)) {
      paramViewCache.a(paramMessageForStructing, paramOnLongClickAndTouchListener, paramViewGroup);
    }
    return paramOnLongClickAndTouchListener;
  }
  
  private View a(ChatMessage paramChatMessage, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle, AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout, View paramView)
  {
    if (paramRelativeLayout.getChildCount() > 0)
    {
      View localView = paramRelativeLayout.getChildAt(0);
      paramView = localView;
      if (localView != null)
      {
        Object localObject = localView.getTag(2131446476);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("bindviwfor structmsg tag:");
          paramView.append(localObject);
          QLog.d("structMsg", 2, paramView.toString());
        }
        if (localObject != null)
        {
          paramView = localView;
          if (localObject.getClass() == paramAbsStructMsg.getClass()) {}
        }
        else
        {
          paramView = null;
        }
      }
    }
    paramRelativeLayout.removeAllViews();
    if (!f(paramChatMessage)) {
      paramView = null;
    }
    return paramAbsStructMsg.getView(this.e, paramView, paramOnLongClickAndTouchListener, paramBundle);
  }
  
  private String a(ChatMessage paramChatMessage, Bundle paramBundle, String paramString)
  {
    try
    {
      if ((this.f != null) && (this.f.a == 1008) && ("2711679534".equals(this.f.b)))
      {
        IQWalletGdtAdApi localIQWalletGdtAdApi = (IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class);
        paramBundle.putBoolean("isShowQWalletPubAd", paramChatMessage.isShowQWalletPubAd);
        paramBundle = new StringBuilder();
        paramBundle.append(paramString);
        paramBundle.append(paramChatMessage.isShowQWalletPubAd);
        paramChatMessage = paramBundle.toString();
        return paramChatMessage;
      }
    }
    catch (Throwable paramChatMessage)
    {
      QLog.e("StructingMsgItemBuilder", 1, paramChatMessage, new Object[0]);
    }
    return paramString;
  }
  
  private void a(int paramInt1, AbsStructMsg paramAbsStructMsg, int paramInt2, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (((paramInt1 == 1) || (paramInt2 != paramStructingMsgViewHolder.l)) && (paramAbsStructMsg.mMsgServiceID == 128)) {
      TroopReportor.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(paramAbsStructMsg.uniseq) });
    }
  }
  
  private void a(long paramLong)
  {
    if (((this.e instanceof ChatActivity)) || ((this.e instanceof SplashActivity)))
    {
      VipGiftManager localVipGiftManager = (VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.e();
      BaseActivity localBaseActivity = (BaseActivity)this.e;
      if ((localVipGiftDownloadInfo != null) && (localBaseActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(this.f.b)) && (localVipGiftDownloadInfo.f == 2L) && (paramLong == localVipGiftDownloadInfo.c)) {
        localVipGiftManager.a(localVipGiftDownloadInfo, localBaseActivity);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131625669, null);
    ((ImageView)localView.findViewById(2131435388)).setImageResource(2130839806);
    ((TextView)localView.findViewById(2131447089)).setText(HardCodeUtil.a(2131911896));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.19(this, localReportDialog), 1500L);
    this.E = false;
  }
  
  private void a(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.frienduin;
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = localAbsStructMsg.adverKey;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject2).id = i;
        ((PopupMenuDialog.MenuItem)localObject2).iconId = 0;
        if (localJSONObject.has("show_name")) {
          ((PopupMenuDialog.MenuItem)localObject2).title = localJSONObject.getString("show_name");
        } else {
          ((PopupMenuDialog.MenuItem)localObject2).title = "";
        }
        localArrayList1.add(localObject2);
        localObject2 = new IPAReportUtil.AdverInfo();
        ((IPAReportUtil.AdverInfo)localObject2).a = str;
        ((IPAReportUtil.AdverInfo)localObject2).c = localJSONObject.optString("index");
        ((IPAReportUtil.AdverInfo)localObject2).d = localJSONObject.optString("index_name");
        ((IPAReportUtil.AdverInfo)localObject2).b = localJSONObject.optString("index_type");
        ((IPAReportUtil.AdverInfo)localObject2).e = String.valueOf(HttpUtil.getNetWorkType());
        localArrayList2.add(localObject2);
        i += 1;
      }
      this.w = PopupMenuDialog.build(paramActivity, localArrayList1, new StructingMsgItemBuilder.13(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new StructingMsgItemBuilder.14(this), AIOUtils.b(100.0F, paramActivity.getResources()));
      i = paramView.getWidth() * 7 / 2;
      this.w.showAsDropDown(paramView, 0 - i, 0);
      this.w.dismiss();
      paramActivity = new int[2];
      paramView.getLocationOnScreen(paramActivity);
      this.w.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
      this.w.setOnDismissListener(new StructingMsgItemBuilder.15(this));
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void a(Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    paramAbsStructMsg.uniseq = paramMessageForStructing.uniseq;
    paramAbsStructMsg.uin = paramMessageForStructing.frienduin;
    paramAbsStructMsg.uinType = paramMessageForStructing.istroop;
    paramAbsStructMsg.currentAccountUin = paramMessageForStructing.selfuin;
    paramAbsStructMsg.messageVersion = paramMessageForStructing.versionCode;
    paramBundle.putBoolean("isSend", paramMessageForStructing.isSend());
    if (paramAbsStructMsg.uinType == 1008)
    {
      paramAbsStructMsg.sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
      return;
    }
    paramBundle = paramMessageForStructing.getExtInfoFromExtStr("accostType");
    if ((paramBundle != null) && (!paramBundle.equals(""))) {}
    try
    {
      paramAbsStructMsg.sourceAccoutType = Integer.parseInt(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg)
  {
    BaseChatPie localBaseChatPie = ((BaseActivity)this.e).getChatFragment().k();
    if ((localBaseChatPie instanceof PublicAccountChatPie)) {
      paramView.setOnClickListener(new StructingMsgItemBuilder.10(this, localBaseChatPie, paramAbsShareMsg));
    }
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramAbsShareMsg.mMsgServiceID == 81)
    {
      StoryReportor.a(this.d, this.e, paramMessageForStructing, "clk_play");
    }
    else if (paramAbsShareMsg.mMsgServiceID == 98)
    {
      int i;
      if ((StructMsgItemLayout26.d(paramAbsShareMsg.mExtraData) & 0x2) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject1 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      Object localObject2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      boolean bool = ((IFaceScoreUtils)localObject1).getFaceScoreFlag(paramChatMessage, "isFaceScoreSecondMember");
      localObject2 = "2";
      if (bool) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      IFaceScoreUtils localIFaceScoreUtils = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      String str = paramChatMessage.frienduin;
      if (i == 0) {
        localObject2 = "1";
      }
      localIFaceScoreUtils.report("clk_obj", str, new String[] { localObject1, "", "", localObject2 });
    }
    AIOUtils.q = true;
    if (c()) {
      return;
    }
    if ((!((VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER)).b(paramLong)) || (paramAbsShareMsg.mMsgServiceID != 38)) {
      paramOnClickListener.onClick(paramView);
    }
    if ((paramMessageForStructing instanceof MessageForTroopNotification))
    {
      paramView = (MessageForTroopNotification)paramMessageForStructing;
      paramAbsShareMsg = this.d;
      paramMessageForStructing = paramView.frienduin;
      paramOnClickListener = new StringBuilder();
      paramOnClickListener.append("");
      paramOnClickListener.append(paramView.feedType);
      ReportController.b(paramAbsShareMsg, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramMessageForStructing, paramOnClickListener.toString(), "", "");
    }
    b((MessageForStructing)paramChatMessage);
  }
  
  private void a(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 35)
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView.h.setPadding(paramView.h.getPaddingLeft(), 0, paramView.h.getPaddingRight(), 0);
    }
  }
  
  private void a(View paramView, AbsStructMsg paramAbsStructMsg, AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 79)
    {
      paramView.setOnClickListener(null);
      paramView.setOnClickListener(new StructingMsgItemBuilder.9(this, paramAbsShareMsg));
    }
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new StructMsgClickHandler(this.d, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      TroopQZoneUploadAlbumHandler localTroopQZoneUploadAlbumHandler = (TroopQZoneUploadAlbumHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_QZONE_UPLOAD_ALBUM_PROGRESS_HANDLER);
      localTroopQZoneUploadAlbumHandler.a(MessageUtils.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new StructingMsgItemBuilder.21(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131447967, paramMessageForStructing);
      localTroopQZoneUploadAlbumHandler.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout1, MessageForStructing paramMessageForStructing, BaseChatItemLayout paramBaseChatItemLayout2, Resources paramResources, boolean paramBoolean)
  {
    if ((this.f.a == 1008) || (paramMessageForStructing.structingMsg.mMsgServiceID == 76) || (paramMessageForStructing.structingMsg.mMsgServiceID == 21))
    {
      int k = paramResources.getDimensionPixelSize(2131299800);
      int m = paramResources.getDimensionPixelSize(2131299800);
      if ((BaseChatItemLayout.ad) && (paramBoolean)) {
        i = 1;
      } else {
        i = 0;
      }
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.f();
      int j = i;
      if (localAIOLongShotHelper != null)
      {
        j = i;
        if (localAIOLongShotHelper.c()) {
          j = 0;
        }
      }
      int i = k;
      if (j != 0)
      {
        j = AIOUtils.b(30.0F, paramResources);
        i = j;
        if (paramBaseChatItemLayout2.ac != null)
        {
          paramBaseChatItemLayout2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout2.ac.getLayoutParams();
          i = j;
          if (paramBaseChatItemLayout2 != null)
          {
            paramBaseChatItemLayout2.leftMargin = AIOUtils.b(5.0F, paramResources);
            i = j;
          }
        }
      }
      paramBaseChatItemLayout1 = (BubbleViewWrapper)paramBaseChatItemLayout1.a(BubbleViewWrapper.class);
      if (paramBaseChatItemLayout1 != null)
      {
        paramBaseChatItemLayout1 = paramBaseChatItemLayout1.c();
        if (paramBaseChatItemLayout1 != null)
        {
          paramBaseChatItemLayout1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout1.getLayoutParams();
          if (paramBaseChatItemLayout1 != null)
          {
            if (paramMessageForStructing.structingMsg.mMsgServiceID != 21)
            {
              paramBaseChatItemLayout1.setMargins(i, 0, m, 0);
              return;
            }
            paramBaseChatItemLayout1.setMargins(i, paramBaseChatItemLayout1.topMargin, m, paramBaseChatItemLayout1.bottomMargin);
          }
        }
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg)) {
      FileTransferManager.a(this.d).a(paramBaseChatItemLayout, this);
    } else if ((StructMsgForGeneralShare.class.isInstance(paramAbsStructMsg)) && (c(paramAbsStructMsg))) {
      a(paramBaseChatItemLayout, paramMessageForStructing);
    }
    if (c(paramMessageForStructing)) {
      FileTransferManager.a(this.d).a(paramBaseChatItemLayout, this);
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, int paramInt)
  {
    if (paramInt != 1001)
    {
      if (paramInt == 4001) {
        paramStructingMsgViewHolder.e.setProgress(0);
      }
    }
    else {
      paramStructingMsgViewHolder.e.setProgress(0);
    }
    paramStructingMsgViewHolder.e.a();
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.h.setBackgroundResource(2130853309);
      int i = paramStructingMsgViewHolder.a.getPaddingLeft();
      int j = paramStructingMsgViewHolder.a.getPaddingLeft();
      paramStructingMsgViewHolder.a.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramStructingMsgViewHolder.b;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.e);
      paramStructingMsgViewHolder.b = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131446456);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(0.0F, paramResources);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(10.0F, paramResources);
      if (a(paramBoolean1, paramAbsStructMsg)) {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin += AIOUtils.b(18.0F, paramResources);
      }
    }
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131430578);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131430578);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (paramStructingMsgViewHolder.a != null)
      {
        Object localObject4 = paramStructingMsgViewHolder.a.getChildAt(0);
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((View)localObject4).getTag(2131446476);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("bindviwfor structmsg tag:");
            ((StringBuilder)localObject2).append(localObject4);
            QLog.d("structMsg", 2, ((StringBuilder)localObject2).toString());
          }
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (localObject4.getClass() == paramAbsStructMsg.getClass()) {}
          }
          else
          {
            localObject2 = null;
          }
        }
      }
    }
    ((RelativeLayout)localObject1).removeAllViews();
    ((RelativeLayout)localObject1).setBackgroundDrawable(null);
    localObject2 = paramAbsStructMsg.getSourceView(this.e, (View)localObject2);
    if (localObject2 != null)
    {
      ((View)localObject2).setId(2131446457);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.d))
      {
        paramStructingMsgViewHolder = new View(this.e);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131446457);
        paramBaseChatItemLayout.addRule(5, 2131446457);
        paramBaseChatItemLayout.addRule(7, 2131446457);
        paramBaseChatItemLayout.addRule(8, 2131446457);
        paramStructingMsgViewHolder.setBackgroundResource(2130837953);
        ((RelativeLayout)localObject1).addView(paramStructingMsgViewHolder, paramBaseChatItemLayout);
      }
    }
    else
    {
      paramBaseChatItemLayout.removeView((View)localObject1);
      paramStructingMsgViewHolder.b = null;
    }
    a(paramAbsStructMsg, (RelativeLayout)localObject1);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryHandleAioSource((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.e, paramAbsStructMsg);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.e);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131446455);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - AIOUtils.b(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131430578);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430578);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.e, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramStructingMsgViewHolder = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramStructingMsgViewHolder.topMargin = UIUtils.a(this.e, 10.0F);
      paramStructingMsgViewHolder.height = -2;
      paramStructingMsgViewHolder.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramStructingMsgViewHolder.b = null;
  }
  
  private void a(ChatMessage paramChatMessage, Bundle paramBundle, AbsStructMsg paramAbsStructMsg)
  {
    if ((this.f != null) && (this.f.a == 1008))
    {
      Object localObject;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        localObject = (StructMsgForGeneralShare)paramAbsStructMsg;
        paramBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.f.b);
        paramBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.f.e);
      }
      paramBundle.putBoolean("isPublicAccount", true);
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
      if ((paramChatMessage != null) && (!paramChatMessage.equals("")))
      {
        if (!TextUtils.isEmpty(paramChatMessage)) {
          paramAbsStructMsg.templateIDForPortal = paramChatMessage;
        }
        if ((paramAbsStructMsg instanceof AbsShareMsg))
        {
          paramBundle = ((AbsShareMsg)paramAbsStructMsg).getStructMsgItemLists();
          if (paramBundle != null)
          {
            paramBundle = paramBundle.iterator();
            while (paramBundle.hasNext())
            {
              paramAbsStructMsg = (AbsStructMsgElement)paramBundle.next();
              if (!TextUtils.isEmpty(paramChatMessage)) {
                paramAbsStructMsg.am = paramChatMessage;
              }
              if ((paramAbsStructMsg instanceof AbsStructMsgItem))
              {
                paramAbsStructMsg = (AbsStructMsgItem)paramAbsStructMsg;
                if (paramAbsStructMsg.ax != null)
                {
                  paramAbsStructMsg = paramAbsStructMsg.ax.iterator();
                  while (paramAbsStructMsg.hasNext())
                  {
                    localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
                    if (!TextUtils.isEmpty(paramChatMessage)) {
                      ((AbsStructMsgElement)localObject).am = paramChatMessage;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof AbsShareMsg))
    {
      b(paramChatMessage, paramView, paramBaseChatItemLayout, paramMessageForStructing, paramAbsStructMsg);
      return;
    }
    if ((paramAbsStructMsg.mMsgServiceID == 3) || (paramAbsStructMsg.mMsgServiceID == 120))
    {
      if (c())
      {
        paramView.setClickable(false);
        return;
      }
      paramView.setClickable(true);
    }
  }
  
  private void a(ChatMessage paramChatMessage, View paramView, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    RelativeLayout localRelativeLayout;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    long l;
    if (paramAbsStructMsg.adverSign == 1)
    {
      localRelativeLayout = new RelativeLayout(this.e);
      localObject = new ImageView(this.e);
      ((ImageView)localObject).setImageResource(2130842581);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(80.0F, this.e.getResources()), AIOUtils.b(44.0F, this.e.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(0, 12, 12, 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((View)localObject);
      if ((paramView instanceof RelativeLayout)) {
        ((RelativeLayout)paramView).addView(localRelativeLayout);
      }
      paramView = paramMessageForStructing.frienduin;
      l = paramAbsStructMsg.msgId;
      if ((this.e instanceof Activity)) {
        localRelativeLayout.setOnClickListener(new StructingMsgItemBuilder.7(this, (ImageView)localObject, paramChatMessage, paramView, l));
      }
    }
    else if (paramAbsStructMsg.adverSign == 2)
    {
      localRelativeLayout = new RelativeLayout(this.e);
      localObject = new TextView(this.e);
      ((TextView)localObject).setBackgroundResource(2130842751);
      ((TextView)localObject).setGravity(17);
      int i = paramAbsStructMsg.adverSign;
      ((TextView)localObject).setText(HardCodeUtil.a(2131911890));
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(13.0F);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(80.0F, this.e.getResources()), AIOUtils.b(44.0F, this.e.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((View)localObject);
      if ((paramView instanceof RelativeLayout)) {
        ((RelativeLayout)paramView).addView(localRelativeLayout);
      }
      paramView = paramMessageForStructing.frienduin;
      l = paramAbsStructMsg.msgId;
      paramView = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      i = paramMessageForStructing.istroop;
      if ((this.e instanceof Activity)) {
        localRelativeLayout.setOnClickListener(new StructingMsgItemBuilder.8(this, (TextView)localObject, paramChatMessage, paramView));
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    if (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramMessageForStructing))
    {
      paramMessageForStructing = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131432263);
      int j = 1;
      if (paramMessageForStructing == null)
      {
        paramMessageForStructing = new DuiButtonImageView(this.e, this.d, DoutuMsgUtil.a(paramChatMessage));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.e.getResources()), AIOUtils.b(50.0F, this.e.getResources()));
        localLayoutParams.addRule(8, 2131430578);
        localLayoutParams.addRule(1, 2131430578);
        localLayoutParams.bottomMargin = (BaseChatItemLayout.l - AIOUtils.b(6.5F, this.e.getResources()));
        paramMessageForStructing.setId(2131432263);
        paramBaseChatItemLayout.addView(paramMessageForStructing, localLayoutParams);
        paramBaseChatItemLayout = paramMessageForStructing;
      }
      else
      {
        paramMessageForStructing.f = DoutuMsgUtil.a(paramChatMessage);
        paramBaseChatItemLayout = paramMessageForStructing;
      }
      int i;
      if (paramChatMessage.extraflag == 32768)
      {
        i = j;
        if (paramChatMessage.isSendFromLocal()) {}
      }
      else if (this.d.getMsgCache().g(paramChatMessage))
      {
        i = j;
      }
      else
      {
        i = 0;
      }
      if ((paramChatMessage.isDui) && (i == 0))
      {
        if (paramChatMessage.isSend())
        {
          paramBaseChatItemLayout.setVisibility(8);
          return;
        }
        if (!paramChatMessage.hasPlayedDui) {
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramBaseChatItemLayout);
        } else if (paramBaseChatItemLayout.g()) {
          DoutuConfigReporter.a(paramChatMessage);
        }
        if (DuiButtonImageView.b)
        {
          paramBaseChatItemLayout.setOnClickListener(this);
          paramBaseChatItemLayout.setVisibility(0);
          return;
        }
        paramBaseChatItemLayout.setOnClickListener(null);
        paramBaseChatItemLayout.setVisibility(8);
        return;
      }
      paramBaseChatItemLayout.setVisibility(8);
      paramBaseChatItemLayout.f();
    }
  }
  
  private void a(ChatMessage paramChatMessage, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if ((this.f.a == 1008) && (!this.l.contains(Long.valueOf(paramChatMessage.uniseq))))
    {
      this.l.add(Long.valueOf(paramChatMessage.uniseq));
      PublicAccountEventReport.a(117, paramChatMessage, paramStructingMsgViewHolder.l);
    }
  }
  
  private void a(ChatMessage paramChatMessage, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject1 = paramStructingMsgViewHolder.c;
    Object localObject2 = null;
    if ((localObject1 != null) && (paramStructingMsgViewHolder.c.getVisibility() == 0)) {
      localObject1 = Integer.valueOf(2131446455);
    }
    for (;;)
    {
      break;
      if ((paramStructingMsgViewHolder.b != null) && (paramStructingMsgViewHolder.b.getVisibility() == 0)) {
        localObject1 = Integer.valueOf(2131446456);
      } else {
        localObject1 = null;
      }
    }
    paramStructingMsgViewHolder.f = super.a(paramStructingMsgViewHolder.f, paramStructingMsgViewHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
    super.a(paramStructingMsgViewHolder.f, paramBaseChatItemLayout, (Integer)localObject1, paramChatMessage, -4, Boolean.valueOf(true));
    paramBaseChatItemLayout = this.d;
    paramStructingMsgViewHolder = paramStructingMsgViewHolder.f;
    paramChatMessage = localObject2;
    if (this.f != null) {
      paramChatMessage = this.f.b;
    }
    TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramStructingMsgViewHolder, paramChatMessage);
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      if (!paramAbsStructMsg.havaPayInfoInit)
      {
        String str = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
        if ((!TextUtils.isEmpty(str)) && (str.equals("1"))) {
          paramAbsStructMsg.initPay(this.e, paramChatMessage);
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    if (paramAbsStructMsg.mMsgServiceID == 38)
    {
      paramAbsStructMsg = (VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      if (paramAbsStructMsg != null)
      {
        if (paramAbsStructMsg.b(paramChatMessage.time))
        {
          paramChatMessage = new ProgressBar(this.e);
          paramChatMessage.setId(2131430606);
          paramChatMessage.setIndeterminateDrawable(this.e.getResources().getDrawable(2130839585));
          int i = AIOUtils.b(16.0F, this.e.getResources());
          new RelativeLayout.LayoutParams(-2, -2);
          paramAbsStructMsg = new RelativeLayout.LayoutParams(i, i);
          paramAbsStructMsg.addRule(13, 2131430578);
          paramRelativeLayout.addView(paramChatMessage, paramAbsStructMsg);
          j();
          return;
        }
        if (this.f.a == 0)
        {
          paramChatMessage = paramAbsStructMsg.e();
          if (paramChatMessage != null) {
            a(paramChatMessage.c);
          }
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if ((paramStructingMsgViewHolder != null) && (paramStructingMsgViewHolder.q == paramChatMessage) && (paramAbsStructMsg.hasFlag(16))) {
      ThreadManager.post(new StructingMsgItemBuilder.3(this, paramStructingMsgViewHolder), 2, null, false);
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2)
  {
    boolean bool = String.valueOf(-1000).equals(paramString2);
    int i;
    if (bool) {
      i = 2131911891;
    } else {
      i = 2131911893;
    }
    String str = HardCodeUtil.a(i);
    paramString2 = HardCodeUtil.a(2131911892);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramString2;
    }
    paramString2 = (ActionSheet)ActionSheetHelper.b(this.e, null);
    paramString2.addButton(str);
    paramString2.addCancelButton(this.e.getString(2131887648));
    paramString2.setMainTitle(paramString1);
    paramString2.setOnButtonClickListener(new StructingMsgItemBuilder.24(this, bool, paramChatMessage, paramString2));
    paramString2.show();
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, Bundle paramBundle)
  {
    paramBundle.putInt("accostType", paramAbsStructMsg.sourceAccoutType);
    if (paramAbsStructMsg.mMsgServiceID == 21) {
      paramBundle.putInt("serviceID", paramAbsStructMsg.mMsgServiceID);
    }
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (paramAbsStructMsg.mSType != null) {
        paramBundle.putString("sType", paramAbsStructMsg.mSType);
      }
      if ((!StructLongMessageDownloadProcessor.isPALongMsg(paramMessageForStructing)) && (!StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramMessageForStructing))) {}
    }
    try
    {
      paramBundle.putInt("longMsgHolderType", Integer.parseInt(paramMessageForStructing.getExtInfoFromExtStr("longMsg_State")));
      return;
    }
    catch (Exception paramMessageForStructing) {}
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, RelativeLayout paramRelativeLayout)
  {
    if ((paramAbsStructMsg instanceof StructMsgForImageShare))
    {
      a(paramMessageForStructing, (StructMsgForImageShare)paramAbsStructMsg, paramStructingMsgViewHolder, paramRelativeLayout);
      return;
    }
    if (((paramAbsStructMsg instanceof StructMsgForGeneralShare)) || ((paramAbsStructMsg instanceof StructMsgForAudioShare))) {
      b((AbsShareMsg)paramAbsStructMsg);
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, StructMsgForImageShare paramStructMsgForImageShare, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, RelativeLayout paramRelativeLayout)
  {
    if (paramMessageForStructing.isSendFromLocal())
    {
      paramMessageForStructing = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramStructingMsgViewHolder.a = paramRelativeLayout;
      a(paramMessageForStructing, paramStructingMsgViewHolder);
    }
    paramMessageForStructing = paramStructMsgForImageShare.getFirstImageElement();
    if ((paramMessageForStructing != null) && (paramMessageForStructing.aF != null))
    {
      ((IPicPreDownload)this.d.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramMessageForStructing.aF, 2);
      ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.6(this, paramMessageForStructing));
    }
    a(paramStructMsgForImageShare);
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setVisibility(0);
    if ((paramAbsStructMsg.mMsgUrl != null) && ((paramAbsStructMsg.mMsgUrl.startsWith("https://3gimg.qq.com/wap30/infoopstatic")) || (paramAbsStructMsg.mMsgUrl.startsWith("https://viola.qq.com/js/redpackIndex.js"))) && ("1".equals(Uri.parse(paramAbsStructMsg.mMsgUrl).getQueryParameter("hidesource")))) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  private void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (!this.A.contains(paramStructMsgForImageShare))
    {
      paramStructMsgForImageShare.report(Long.valueOf(((Activity)this.e).getIntent().getLongExtra("req_share_id", 0L)));
      this.A.add(paramStructMsgForImageShare);
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, AbsStructMsg paramAbsStructMsg, Resources paramResources)
  {
    if (this.f.a == 1008)
    {
      if (!paramAbsStructMsg.hasFlag(32))
      {
        paramQQCustomMenu.a(2131433658, paramResources.getString(2131889668), 2130839066);
        return;
      }
      if (!paramAbsStructMsg.hasFlag(1)) {
        paramQQCustomMenu.a(2131433636, paramResources.getString(2131889668), 2130839066);
      }
    }
    else
    {
      if (paramAbsStructMsg.mMsgServiceID == 14) {
        return;
      }
      if (!paramAbsStructMsg.hasFlag(1))
      {
        paramQQCustomMenu.a(2131433636, paramResources.getString(2131889668), 2130839066);
        return;
      }
      if (paramAbsStructMsg.mMsgServiceID == 35) {
        paramQQCustomMenu.a(2131433636, paramResources.getString(2131889668), 2130839066);
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (paramStructingMsgViewHolder.a == null) {
      return;
    }
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int j = (int)paramIHttpCommunicatorListener.getFileStatus();
      int i = j;
      if (j == 1004)
      {
        i = j;
        if (paramIHttpCommunicatorListener.isRawPic())
        {
          i = j;
          if (paramIHttpCommunicatorListener.isPause()) {
            i = 1006;
          }
        }
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131446476);
      localLayoutParams.addRule(8, 2131446476);
      localLayoutParams.addRule(5, 2131446476);
      localLayoutParams.addRule(7, 2131446476);
      if ((paramStructingMsgViewHolder.a != null) && (paramStructingMsgViewHolder.a.findViewById(2131446462) == null) && (paramStructingMsgViewHolder.e != null)) {
        paramStructingMsgViewHolder.a.addView(paramStructingMsgViewHolder.e, localLayoutParams);
      }
      if ((i != 1006) && (i != 4001)) {}
      switch (i)
      {
      default: 
        if (paramStructingMsgViewHolder.e == null) {
          break;
        }
        paramStructingMsgViewHolder.e.setProcessor(null);
        paramStructingMsgViewHolder.e.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
        if (paramStructingMsgViewHolder.e == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.e);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131446462);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.y * 12.0F));
          if (paramStructingMsgViewHolder.a != null) {
            paramStructingMsgViewHolder.a.addView(localMessageProgressTextView, localLayoutParams);
          }
          paramStructingMsgViewHolder.e = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.e.setProcessor(paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.e.setVisibility(0);
        a(paramStructingMsgViewHolder, i);
        return;
      }
    }
    else if (paramStructingMsgViewHolder.e != null)
    {
      paramStructingMsgViewHolder.e.setProcessor(null);
      paramStructingMsgViewHolder.e.setVisibility(4);
    }
  }
  
  private boolean a(MessageForStructing paramMessageForStructing, int paramInt)
  {
    return (!a(paramMessageForStructing)) && (paramInt != 83) && (paramInt != 151) && (paramInt != 156) && (paramInt != 108) && (paramInt != 114) && (paramInt != 98) && (paramInt != 97) && (paramInt != 5) && (paramInt != 137) && (paramInt != 106) && (paramInt != 107) && (paramInt != 122) && (paramInt != 116);
  }
  
  private boolean a(boolean paramBoolean, AbsStructMsg paramAbsStructMsg)
  {
    return (paramBoolean) && ((paramAbsStructMsg.mMsgServiceID == 83) || (paramAbsStructMsg.mMsgServiceID == 108) || (paramAbsStructMsg.mMsgServiceID == 114) || (paramAbsStructMsg.mMsgServiceID == 116) || (paramAbsStructMsg.mMsgServiceID == 151) || (paramAbsStructMsg.mMsgServiceID == 156)) && (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData));
  }
  
  private int b(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt1 - paramInt2;
    }
    paramViewHolder.h.setBackgroundResource(paramInt3);
    if ((paramBoolean) && (paramViewHolder.h.getParent() != null) && ((paramViewHolder.h.getParent() instanceof RelativeLayout)))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)paramViewHolder.h.getParent();
      paramContext = new View(paramContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131430578);
      localLayoutParams.addRule(5, 2131430578);
      localLayoutParams.addRule(7, 2131430578);
      localLayoutParams.addRule(8, 2131430578);
      if (paramViewHolder.p != null) {
        localRelativeLayout.removeView(paramViewHolder.p);
      }
      if (MultiMsgUtil.a(paramChatMessage))
      {
        if (QQTheme.isNowSimpleUI()) {
          paramInt4 = 0;
        }
        paramContext.setBackgroundResource(paramInt4);
      }
      else
      {
        paramContext.setBackgroundResource(paramInt5);
      }
      paramViewHolder.p = paramContext;
      localRelativeLayout.addView(paramViewHolder.p, 0, localLayoutParams);
    }
    return i;
  }
  
  private void b(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131625669, null);
    ((ImageView)localView.findViewById(2131435388)).setImageResource(2130839791);
    ((TextView)localView.findViewById(2131447089)).setText(HardCodeUtil.a(2131911895));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.20(this, localReportDialog), 1500L);
    this.E = false;
  }
  
  private void b(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    ArrayList localArrayList = new ArrayList();
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    Object localObject = localAbsStructMsg.adverKey;
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        if (localJSONObject.has("index")) {
          localMenuItem.id = localJSONObject.getInt("index");
        } else {
          localMenuItem.id = i;
        }
        localMenuItem.iconId = 0;
        if (localJSONObject.has("show_name")) {
          localMenuItem.title = localJSONObject.getString("show_name");
        } else {
          localMenuItem.title = "";
        }
        localArrayList.add(localMenuItem);
        i += 1;
      }
      this.w = PopupMenuDialog.build(paramActivity, localArrayList, new StructingMsgItemBuilder.16(this, paramChatMessage, paramActivity, localAbsStructMsg), new StructingMsgItemBuilder.17(this), AIOUtils.b(100.0F, paramActivity.getResources()));
      i = paramView.getWidth() * -5 / 7;
      this.w.showAsDropDown(paramView, i, 0);
      this.w.dismiss();
      paramActivity = new int[2];
      paramView.getLocationOnScreen(paramActivity);
      this.w.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
      this.w.setOnDismissListener(new StructingMsgItemBuilder.18(this));
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void b(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 76)
    {
      int i = AIOUtils.b(11.0F, this.e.getResources());
      int j = AIOUtils.b(7.5F, this.e.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView.h.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.h.getLayoutParams()).setMargins(i, j, i, j);
    }
  }
  
  private void b(ChatMessage paramChatMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)paramAbsStructMsg;
    View.OnClickListener localOnClickListener = localAbsShareMsg.getOnClickListener();
    paramView.setOnClickListener(new StructingMsgItemBuilder.5(this, localAbsShareMsg, paramMessageForStructing, paramChatMessage, paramChatMessage.time, localOnClickListener));
    a(paramBaseChatItemLayout, paramMessageForStructing, paramAbsStructMsg);
    if (PAVideoStructMsgUtil.a(paramAbsStructMsg)) {
      paramView.setOnClickListener(null);
    } else if (paramAbsStructMsg.mMsgServiceID == 78) {
      a(paramView, localAbsShareMsg);
    }
    c(paramView, paramAbsStructMsg);
    a(paramView, paramAbsStructMsg, localAbsShareMsg);
  }
  
  private void b(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg))
    {
      paramAbsStructMsg = (StructMsgForImageShare)paramAbsStructMsg;
      paramAbsStructMsg.mIsSend = paramMessageForStructing.issend;
      paramAbsStructMsg.mUniseq = paramMessageForStructing.uniseq;
      paramAbsStructMsg.mMsgType = paramMessageForStructing.msgtype;
    }
  }
  
  private void b(AbsShareMsg paramAbsShareMsg)
  {
    if (!this.B.contains(paramAbsShareMsg))
    {
      paramAbsShareMsg.report(Integer.valueOf(0));
      this.B.add(paramAbsShareMsg);
    }
  }
  
  private void b(AbsStructMsg paramAbsStructMsg)
  {
    if ((this.f != null) && (this.f.a != 1008) && (paramAbsStructMsg.hasFlag(4))) {
      paramAbsStructMsg.addFlag(1);
    }
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.u = true;
    paramString = AbsDownloader.getFilePath(paramURL.toString());
    QLog.d("StructingMsgItemBuilder", 1, new Object[] { "generateHdPic hdThumbFilePath=", paramString });
    if (!paramString.endsWith("_hd"))
    {
      if (paramString.endsWith("_big400"))
      {
        paramString.replace("_big400", "_hd");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("_hd");
        paramString = localStringBuilder.toString();
      }
      if (new File(paramString).exists())
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image exists, no need compress");
        paramString = URLDrawable.getDrawable(paramURL);
        if (paramString != null)
        {
          QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
          ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.11(paramString));
        }
        return;
      }
      localCompressInfo.l = paramString;
    }
    try
    {
      new File(paramString).getParentFile().mkdirs();
      localCompressInfo.x = paramThumbWidthHeightDP;
      if (((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail(localCompressInfo)) {
        paramThumbWidthHeightDP = "hd image compress success";
      } else {
        paramThumbWidthHeightDP = "hd image compress fail";
      }
      QLog.d("StructingMsgItemBuilder", 1, paramThumbWidthHeightDP);
      if (localCompressInfo.l == null) {
        break label416;
      }
      paramString = new File(paramString);
      boolean bool;
      if (localCompressInfo.l.equals(localCompressInfo.h)) {
        bool = FileUtil.a(new File(localCompressInfo.h), paramString);
      } else {
        bool = true;
      }
      QLog.d("StructingMsgItemBuilder", 1, new Object[] { "ret=", Boolean.valueOf(bool), ", thumbCI.destPath=", localCompressInfo.l, ", thumbCI.srcPath=", localCompressInfo.h });
      if ((!bool) || (GlobalImageCache.a.get(paramURL.toString()) == null)) {
        break label416;
      }
      GlobalImageCache.a.remove(paramURL.toString());
      paramString = URLDrawable.getDrawable(paramURL);
      if (paramString == null) {
        break label416;
      }
      QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
      ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.12(paramString));
      return;
    }
    catch (Exception paramString)
    {
      label406:
      label416:
      break label406;
    }
    QLog.d("StructingMsgItemBuilder", 1, "hd image file parent create fail");
  }
  
  private void c(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg.mMsgServiceID == 76) || (paramAbsStructMsg.mMsgServiceID == 106))
    {
      paramView.setOnClickListener(null);
      if (paramAbsStructMsg.mMsgServiceID != 106)
      {
        paramView.setOnLongClickListener(null);
        paramView.setOnTouchListener(null);
      }
    }
  }
  
  private boolean c(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing.isSendFromLocal()) && (paramMessageForStructing.extraflag == 32772) && (paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing.structingMsg).isSdkShareMsg()) && (!((AbsShareMsg)paramMessageForStructing.structingMsg).shareData.isFinish());
  }
  
  private boolean c(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (this.f != null) {
      ((IQQGameSubscribeService)this.d.getRuntimeService(IQQGameSubscribeService.class, "all")).handleSubscribeGrayTipsUi(this.f.b, paramChatMessage, paramBaseChatItemLayout, -2011);
    }
  }
  
  private boolean f(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage instanceof MessageForStructing;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    if (!(paramChatMessage instanceof StructMsgForImageShare)) {
      return false;
    }
    paramChatMessage = ((StructMsgForImageShare)paramChatMessage).getFirstImageElement();
    bool1 = bool2;
    if (paramChatMessage != null)
    {
      bool1 = bool2;
      if (paramChatMessage.c()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean g(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
      return false;
    }
    paramChatMessage = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
    int i = 0;
    while (i < paramChatMessage.getItemCount())
    {
      if ((paramChatMessage.getItemByIndex(i) instanceof StructMsgItemLayout19)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private StructMsgForGeneralShare h(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      return null;
    }
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if ((paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramChatMessage = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      if (paramChatMessage.getProgress() >= 0) {
        return paramChatMessage;
      }
    }
    return null;
  }
  
  public static String h()
  {
    return String.valueOf(a);
  }
  
  private void n()
  {
    PopupMenuDialog localPopupMenuDialog = this.w;
    if ((localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing())) {
      this.w.dismiss();
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.z.a();
    int i;
    if (paramView == null) {
      i = 1;
    } else {
      i = 2;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg == null) {
      return paramView;
    }
    if (localAbsStructMsg.mMsgServiceID == 81) {
      StoryReportor.a(this.d, this.e, localMessageForStructing, "exp");
    }
    a(paramChatMessage, localAbsStructMsg);
    int j;
    if ((paramView != null) && ((paramView.getTag() instanceof BaseBubbleBuilder.ViewHolder))) {
      j = ((BaseBubbleBuilder.ViewHolder)paramView.getTag()).l;
    } else {
      j = -1;
    }
    localAbsStructMsg.message = localMessageForStructing;
    if (("3046055438".equals(this.f.b)) && ((localAbsStructMsg instanceof StructMsgForGeneralShare))) {
      EcshopMessageApiImpl.handlePubTailMsg(localMessageForStructing);
    }
    Object localObject2;
    if (("2711679534".equals(this.f.b)) && ((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (!TextUtils.isEmpty(localAbsStructMsg.mBirthReminder)))
    {
      localObject1 = ((StructMsgForGeneralShare)localAbsStructMsg).getStructMsgItemLists();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = new StructMsgItemLayoutBirthdayReminder(localAbsStructMsg.mBirthReminder);
        ((List)localObject1).clear();
        ((List)localObject1).add(localObject2);
      }
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    b(paramView, localAbsStructMsg);
    a(paramView, localAbsStructMsg);
    paramViewGroup = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView.getTag();
    if (paramViewGroup == null) {
      return paramView;
    }
    paramOnLongClickAndTouchListener = paramViewGroup.j;
    a(i, localAbsStructMsg, j, paramViewGroup);
    if ((localAbsStructMsg instanceof AbsShareMsg)) {
      paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
    } else {
      paramInt2 = -1;
    }
    b(localAbsStructMsg);
    Object localObject1 = this.e.getResources();
    boolean bool = a(localMessageForStructing);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getView:position:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("hasHead");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("StructingMsgItemBuilder", 4, ((StringBuilder)localObject2).toString());
    }
    a(paramViewGroup, paramOnLongClickAndTouchListener, bool);
    a(paramViewGroup, paramOnLongClickAndTouchListener, localMessageForStructing.isSend(), localAbsStructMsg, (Resources)localObject1, bool);
    if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)localAbsStructMsg;
      if (((StructMsgForGeneralShare)localObject2).mHasAdSource) {
        a(paramViewGroup, paramOnLongClickAndTouchListener, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localObject2, (Resources)localObject1, bool);
      }
    }
    if ((paramViewGroup != null) && (this.d != null)) {
      a(paramChatMessage, paramViewGroup, paramOnLongClickAndTouchListener);
    }
    a((BaseChatItemLayout)paramView, localMessageForStructing, paramOnLongClickAndTouchListener, (Resources)localObject1, bool);
    paramView.requestLayout();
    a(paramChatMessage, localAbsStructMsg, paramViewGroup);
    paramOnLongClickAndTouchListener = (TroopBindPublicAccountMgr)this.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    if (paramOnLongClickAndTouchListener.b(paramChatMessage))
    {
      paramOnLongClickAndTouchListener.b(paramChatMessage.uniseq);
      paramViewGroup.h.setVisibility(8);
      paramOnLongClickAndTouchListener = AnimationUtils.loadAnimation(this.e, 2130772329);
      paramOnLongClickAndTouchListener.setAnimationListener(new StructingMsgItemBuilder.1(this, paramViewGroup));
      paramViewGroup.h.postDelayed(new StructingMsgItemBuilder.2(this, paramViewGroup, paramOnLongClickAndTouchListener), 300L);
    }
    this.z.a(paramInt2, i);
    ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).bindViewForGdtReport(this.d, paramChatMessage, paramView);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Bundle localBundle = new Bundle();
    boolean bool = this.e instanceof ChatActivity;
    RelativeLayout localRelativeLayout = null;
    Object localObject2;
    if ((!bool) && (!(this.e instanceof SplashActivity))) {
      localObject2 = null;
    } else {
      localObject2 = ((BaseActivity)this.e).getChatFragment().k().aT();
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.e.getResources();
      localObject1 = new RelativeLayout(this.e);
      ((RelativeLayout)localObject1).setId(2131430578);
      ((RelativeLayout)localObject1).setMinimumHeight(AIOUtils.b(44.0F, paramView));
      ((RelativeLayout)localObject1).setClickable(true);
      ((RelativeLayout)localObject1).setPadding(BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
      ((RelativeLayout)localObject1).setBackgroundResource(2130838013);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      int i = paramView.getDimensionPixelSize(2131299800);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131435219);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    }
    else
    {
      if (!f(paramChatMessage)) {
        ((ViewGroup)paramView).removeAllViews();
      }
      localObject1 = paramView;
    }
    paramViewHolder.j.setMiniAioShieldItemTouchListener(this);
    Object localObject3 = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)localObject3).structingMsg;
    if (localAbsStructMsg == null)
    {
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("structMsg is null,msgdata:");
        if (((MessageForStructing)localObject3).msgData == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = Integer.valueOf(((MessageForStructing)localObject3).msgData.length);
        }
        paramViewHolder.append(paramChatMessage);
        QLog.d("structMsg", 2, paramViewHolder.toString());
      }
      return localObject1;
    }
    localAbsStructMsg.message = ((MessageRecord)localObject3);
    a(paramChatMessage, localBundle, localAbsStructMsg);
    a(localBundle, (MessageForStructing)localObject3, localAbsStructMsg);
    a((MessageForStructing)localObject3, localAbsStructMsg, localBundle);
    b((MessageForStructing)localObject3, localAbsStructMsg);
    paramBaseChatItemLayout.setAddStatesFromChildren(false);
    paramViewHolder = paramBaseChatItemLayout.getTag();
    paramView = localRelativeLayout;
    if (paramViewHolder != null) {
      paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewHolder;
    }
    paramViewHolder = paramView;
    if (paramView == null) {
      paramViewHolder = i();
    }
    paramViewHolder.d = this.f;
    localRelativeLayout = paramViewHolder.a;
    paramView = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      paramView = (RelativeLayout)localObject1;
      paramViewHolder.a = paramView;
      paramViewHolder.a.setId(2131446472);
    }
    ((View)localObject1).setTag(paramViewHolder);
    if (g(paramChatMessage)) {
      paramViewHolder.g = true;
    } else {
      paramViewHolder.g = false;
    }
    if ((localAbsStructMsg instanceof StructMsgForGeneralShare)) {
      localObject2 = a(paramChatMessage, (ViewGroup)localObject1, paramOnLongClickAndTouchListener, (StructingMsgItemBuilder.ViewCache)localObject2, localBundle, (MessageForStructing)localObject3, localAbsStructMsg);
    } else {
      localObject2 = a(paramChatMessage, paramOnLongClickAndTouchListener, localBundle, localAbsStructMsg, paramView, null);
    }
    ((View)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((View)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
    a(paramChatMessage, (View)localObject1, paramBaseChatItemLayout, (MessageForStructing)localObject3, localAbsStructMsg);
    try
    {
      paramView.addView((View)localObject2);
    }
    catch (IllegalStateException paramOnLongClickAndTouchListener)
    {
      label532:
      break label532;
    }
    ((ViewGroup)((View)localObject2).getParent()).removeAllViews();
    paramView.addView((View)localObject2);
    a(paramChatMessage, localAbsStructMsg, paramView);
    a((MessageForStructing)localObject3, localAbsStructMsg, paramViewHolder, paramView);
    a(paramChatMessage, (View)localObject1, (MessageForStructing)localObject3, localAbsStructMsg);
    n();
    a(paramChatMessage, paramBaseChatItemLayout, (MessageForStructing)localObject3);
    a(paramChatMessage, paramViewHolder);
    e(paramChatMessage, paramBaseChatItemLayout);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).handleBubbleViewForGameShare(0, this.f, (MessageRecord)localObject3);
    return localObject1;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramBaseHolder.structingMsg;
    if (paramChatMessage != null)
    {
      if (!a(paramBaseHolder, paramChatMessage)) {
        return paramQQCustomMenu;
      }
      paramBaseHolder = this.e.getResources();
      if (paramChatMessage.fwFlag != 1)
      {
        a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
        bool = a(paramChatMessage);
        break label61;
      }
    }
    boolean bool = false;
    label61:
    if (bool) {
      paramQQCustomMenu.a(2131432813, this.e.getResources().getString(2131889171), 2130839065);
    }
    return paramQQCustomMenu;
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if (paramString.length > 6) {
        return paramString[5];
      }
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!this.C.a(paramInt, paramContext, paramChatMessage)) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = PAVideoStructMsgUtil.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        int i;
        if ((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) {
          i = this.e.getResources().getDimensionPixelSize(2131296615);
        } else if ((localMessageForStructing.structingMsg.mMsgServiceID != 114) && (localMessageForStructing.structingMsg.mMsgServiceID != 116)) {
          i = this.e.getResources().getDimensionPixelSize(2131296620);
        } else {
          i = this.e.getResources().getDimensionPixelSize(2131296616);
        }
        if (paramChatMessage.isSend()) {
          paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, i, BaseChatItemLayout.l);
        } else {
          paramView.setPadding(i, BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
        }
      }
      if (localMessageForStructing.structingMsg.mMsgServiceID == 107)
      {
        paramChatMessage = this.e.getResources();
        paramView.setPadding(AIOUtils.b(1.5F, paramChatMessage), AIOUtils.b(2.0F, paramChatMessage), AIOUtils.b(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateView type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",message=");
      ((StringBuilder)localObject).append(paramChatMessage);
      QLog.d("StructingMsgItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 891)
    {
      localObject = paramView.getTag();
      if (((localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).j;
        paramChatMessage = (MessageForStructing)paramChatMessage;
        AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
        if (localAbsStructMsg != null) {
          localAbsStructMsg.message = paramChatMessage;
        }
        a((StructingMsgItemBuilder.StructingMsgViewHolder)localObject, localBaseChatItemLayout, paramChatMessage.isSend(), localAbsStructMsg, paramView.getResources(), a(paramChatMessage));
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  protected void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.b(paramView);
    if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) {
      return;
    }
    paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
    if ((StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) && (paramView.a != null))
    {
      if (!MessageForStructing.class.isInstance(paramView.q)) {
        return;
      }
      Object localObject = paramView.q;
      if ((((ChatMessage)localObject).uniseq == paramFileMsg.uniseq) && (((ChatMessage)localObject).isSendFromLocal()))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleMessage status = ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", retCode = ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(", message.uniseq = ");
          localStringBuilder.append(((ChatMessage)localObject).uniseq);
          localStringBuilder.append(", file.uniseq = ");
          localStringBuilder.append(paramFileMsg.uniseq);
          QLog.d("structMsg", 2, localStringBuilder.toString());
        }
        a(((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).uniseq), paramView);
        if (paramInt1 == 1005) {
          d();
        }
      }
      if ((((ChatMessage)localObject).uniseq == paramFileMsg.uniseq) && (paramInt1 == 2003))
      {
        paramFileMsg = (MessageForStructing)localObject;
        if ((paramFileMsg.structingMsg instanceof StructMsgForImageShare))
        {
          paramView.a.removeAllViews();
          localObject = new Bundle();
          paramView.a.addView(paramFileMsg.structingMsg.getView(this.e, null, null, (Bundle)localObject));
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
    if (a(paramBaseChatItemLayout, paramBaseChatItemLayout.structingMsg.mMsgServiceID))
    {
      paramInt1 = paramViewHolder.h.getPaddingLeft();
      paramInt2 = paramViewHolder.h.getPaddingRight();
      int i = paramViewHolder.h.getPaddingTop();
      int j = paramViewHolder.h.getPaddingBottom();
      float f;
      if (QQTheme.isNowSimpleUI()) {
        f = -2.0F;
      } else {
        f = 2.0F;
      }
      int k = AIOUtils.b(f, this.e.getResources());
      boolean bool = ThemeUtil.isInNightMode(this.d);
      if (paramChatMessage.isSend()) {
        paramInt1 = b(paramChatMessage, paramContext, paramViewHolder, paramInt1, k, bool, 2130852132, 2130852129, 2130852128);
      } else {
        paramInt2 = a(paramChatMessage, paramContext, paramViewHolder, paramInt2, k, bool, 2130851950, 2130851947, 2130851946);
      }
      paramViewHolder.h.setPadding(paramInt1, i, paramInt2, j);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = AIOUtils.b(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {
      paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;
    } else {
      paramXListView = null;
    }
    if (paramXListView != null)
    {
      paramXListView = paramXListView.a;
      paramInt = 0;
      paramXListView = (ViewGroup)paramXListView.getChildAt(0);
      int i = paramXListView.getChildCount();
      while (paramInt < i)
      {
        if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
        {
          paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
          if ((paramView.a.getTag() instanceof StructMsgItemPAAudio.ViewHolder))
          {
            paramView = (ImageView)((StructMsgItemPAAudio.ViewHolder)paramView.a.getTag()).d;
            paramView.clearAnimation();
            paramView.setBackgroundResource(2130842789);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    int[] arrayOfInt = x;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
    ((StringBuilder)localObject1).append(paramString1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("&version=1");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramString1 = new Intent();
    paramString1.setClass(paramContext, ForwardRecentActivity.class);
    paramString1.putExtra("key_flag_from_plugin", true);
    paramString1.putExtra("strurt_msgid", String.valueOf(paramLong));
    paramString1.putExtra("struct_uin", paramString13);
    paramString1.putExtra("forward_type", 1001);
    paramString1.putExtra("image_url_remote", paramString4);
    paramString1.putExtra("title", paramString2);
    paramString1.putExtra("desc", paramString3);
    paramString1.putExtra("pluginName", "public_account");
    paramString1.putExtra("detail_url", paramString6);
    paramString1.putExtra("app_name", paramString5);
    if ((!"replyMsg".equals(paramString8)) && (!"replyCmd".equals(paramString8)))
    {
      paramString1.putExtra("struct_share_key_content_action", paramString8);
      paramString1.putExtra("struct_share_key_content_action_DATA", paramString9);
      paramString1.putExtra("struct_share_key_content_a_action_DATA", paramString10);
      paramString1.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    }
    paramString1.putExtra("req_type", 1);
    paramString1.putExtra("req_share_id", -1);
    paramString1.putExtra("brief_key", paramString12);
    paramString1.putExtra("struct_share_key_source_icon", paramString7);
    paramString1.putExtra("struct_share_key_source_action", "plugin");
    paramString1.putExtra("struct_share_key_source_action_data", (String)localObject1);
    paramString1.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
    paramString1.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
    paramString1.putExtra("forward _key_nojump", true);
    paramString2 = StructMsgFactory.a(paramString1.getExtras());
    if (paramString2 != null)
    {
      paramString1.putExtra("stuctmsg_bytes", paramString2.getBytes());
      paramString1.putExtra("k_struct_forward", true);
      paramContext.startActivity(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof StructingMsgItemBuilder.StructingMsgViewHolder;
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = paramChatMessage.isMultiMsg;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = (MessageForStructing)paramChatMessage;
    if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
    {
      StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localObject = null;
      if (localStructMsgForImageShare != null) {
        localObject = localStructMsgForImageShare.getFirstImageElement();
      }
      if ((localObject != null) && (((StructMsgItemImage)localObject).aC <= 0L))
      {
        paramChatMessage = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof BaseTransProcessor))
        {
          if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {
            bool1 = true;
          }
          return bool1;
        }
        return true;
      }
    }
    else if (c((MessageForStructing)localObject))
    {
      if (((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
        }
        return true;
      }
    }
    else if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mMsgServiceID == 95) && (this.d.getMsgCache().g(paramChatMessage)))
    {
      return false;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    boolean bool2 = paramMessageForStructing.hasFlag(4);
    boolean bool1 = bool2;
    if ((paramMessageForStructing instanceof AbsShareMsg))
    {
      bool1 = bool2;
      if (((AbsShareMsg)paramMessageForStructing).mMsgException) {
        bool1 = true;
      }
    }
    if ((paramMessageForStructing.mMsgServiceID == 76) || (paramMessageForStructing.mMsgServiceID == 91)) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    boolean bool = paramAbsStructMsg instanceof AbsShareMsg;
    return ((!bool) || (!((AbsShareMsg)paramAbsStructMsg).mMsgException)) && (paramAbsStructMsg.mMsgServiceID != 86) && (paramAbsStructMsg.mMsgServiceID != 61) && (paramAbsStructMsg.mMsgServiceID != 91) && (paramAbsStructMsg.mMsgServiceID != 97) && (paramAbsStructMsg.mMsgServiceID != 98) && (!(paramAbsStructMsg instanceof StructMsgForHypertext)) && ((!paramMessageForStructing.isSendFromLocal()) || (!bool) || (!((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg()) || ((paramMessageForStructing.extraflag != 32772) && (paramMessageForStructing.extraflag != 32768)));
  }
  
  public boolean a(AbsShareMsg paramAbsShareMsg)
  {
    if (paramAbsShareMsg == null) {
      return false;
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isPublicAccountUrl(paramAbsShareMsg.mMsgUrl)) {
      return true;
    }
    return ((!TextUtils.isEmpty(paramAbsShareMsg.mSource_A_ActionData)) && (paramAbsShareMsg.mSource_A_ActionData.contains("pubaccount"))) || ((!TextUtils.isEmpty(paramAbsShareMsg.mSource_I_ActionData)) && (paramAbsShareMsg.mSource_I_ActionData.contains("public_account")));
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (!paramAbsStructMsg.hasFlag(2)) && ((this.f.a != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14);
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = AIOUtils.b(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {
      paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;
    } else {
      paramXListView = null;
    }
    if (paramXListView != null)
    {
      paramXListView = (ViewGroup)paramXListView.a.getChildAt(0);
      int i = paramXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
        {
          paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
          if ((paramView.a.getTag() instanceof StructMsgItemPAAudio.ViewHolder)) {
            return FileUtils.fileExistsAndNotEmpty(((StructMsgItemPAAudio.ViewHolder)paramView.a.getTag()).a);
          }
        }
        paramInt += 1;
      }
    }
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    Object localObject1 = AIOUtils.b(paramView);
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {
      localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
    } else {
      localObject1 = null;
    }
    paramInt2 = 0;
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).a.getChildAt(0);
      int i = ((ViewGroup)localObject1).getChildCount();
      while (paramInt2 < i)
      {
        if (((((ViewGroup)localObject1).getChildAt(paramInt2).getTag() instanceof StructMsgItemLayout10.ViewHolder)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
        {
          Object localObject2 = (StructMsgItemLayout10.ViewHolder)((ViewGroup)localObject1).getChildAt(paramInt2).getTag();
          if ((((StructMsgItemLayout10.ViewHolder)localObject2).a.getTag() instanceof StructMsgItemPAAudio.ViewHolder))
          {
            localObject2 = ((StructMsgItemPAAudio.ViewHolder)((StructMsgItemLayout10.ViewHolder)localObject2).a.getTag()).a;
            paramAudioPlayerBase.a(8);
            paramAudioPlayerBase.a((String)localObject2);
          }
        }
        paramInt2 += 1;
      }
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForStructing)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null) {
      if (paramView.isMultiMsg) {
        a(localQQCustomMenu, paramView, null);
      } else {
        b(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      int j = 5;
      int i = j;
      if (paramChatMessage.structingMsg != null)
      {
        i = j;
        if ((paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))
        {
          i = j;
          if (((StructMsgForGeneralShare)paramChatMessage.structingMsg).mMsgServiceID == 95) {
            i = 7;
          }
        }
      }
      paramChatMessage = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b(paramChatMessage, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, localStringBuilder.toString(), "", "", "");
    }
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.C.a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
    a(paramQQCustomMenu, this.e, 2131444651, paramChatMessage, null);
    return paramQQCustomMenu;
  }
  
  public void b()
  {
    super.b();
    this.A.clear();
    this.B.clear();
    StructMsgForGeneralShare.unRegisterQIPC();
  }
  
  public void b(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    Context localContext = this.e;
    ChatMessage localChatMessage = ((StructingMsgItemBuilder.StructingMsgViewHolder)AIOUtils.b(paramView)).q;
    if (localChatMessage.isMultiMsg) {
      return;
    }
    Object localObject = h(localChatMessage);
    if (localObject != null)
    {
      a(paramView, (StructMsgForGeneralShare)localObject);
      return;
    }
    paramView = localContext.getString(2131886574);
    localObject = localContext.getString(2131886575);
    if (localChatMessage.isSendFromLocal())
    {
      String str1 = localChatMessage.getExtInfoFromExtStr("errorString");
      String str2 = localChatMessage.getExtInfoFromExtStr("retCode");
      String str3 = localChatMessage.getExtInfoFromExtStr("import_file_message_flag");
      if ((str3 != null) && ("import_file_message_flag_value".equals(str3)))
      {
        a(localChatMessage, str1, str2);
        return;
      }
      DialogUtil.a(localContext, 230, paramView, (String)localObject, new StructingMsgItemBuilder.22(this, localChatMessage, localContext), new StructingMsgItemBuilder.23(this)).show();
    }
  }
  
  protected void b(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.b(paramView);
    if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) {
      return;
    }
    paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
    if ((StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) && (paramView.a != null))
    {
      if (!MessageForStructing.class.isInstance(paramView.q)) {
        return;
      }
      paramView = paramView.q;
      if ((paramView.uniseq == paramFileMsg.uniseq) && (paramView.isSendFromLocal()))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleMessage status = ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", retCode = ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(", message.uniseq = ");
          localStringBuilder.append(paramView.uniseq);
          localStringBuilder.append(", file.uniseq = ");
          localStringBuilder.append(paramFileMsg.uniseq);
          QLog.d("structMsg", 2, localStringBuilder.toString());
        }
        if ((paramInt1 == 1005) || (paramInt1 == 1001) || (paramInt1 == 1003) || (paramInt1 == 1004) || (paramInt1 == 1002)) {
          d();
        }
      }
    }
  }
  
  protected void b(MessageForStructing paramMessageForStructing)
  {
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).handleBubbleViewForGameShare(1, this.f, paramMessageForStructing);
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        handleMessage(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).getFileMsg(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.c(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = AIOUtils.a(paramView);
    }
    catch (Exception localException)
    {
      QLog.e("StructingMsgItemBuilder", 1, paramView.getClass().getName(), localException);
      localObject = null;
    }
    if (!(localObject instanceof MessageForStructing)) {
      return null;
    }
    Object localObject = (MessageForStructing)localObject;
    if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg.mMsgServiceID == 5) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 137))) {
      return (BaseBubbleBuilder.TouchDelegate)paramView.findViewById(2131435571);
    }
    if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 107))
    {
      localObject = paramView.findViewById(2131444359);
      if (localObject != null) {
        return (BaseBubbleBuilder.TouchDelegate)((View)localObject).getTag(-1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTouchDelegate when receipt message but the root view is null \r\n");
      ((StringBuilder)localObject).append(paramView);
      paramView = ((StringBuilder)localObject).toString();
      localObject = new IllegalStateException(paramView);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StructingMsgItemBuilderCatchedException");
      localStringBuilder.append(paramView);
      CaughtExceptionReport.a((Throwable)localObject, localStringBuilder.toString());
    }
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    } else {
      localStringBuilder.append("发来");
    }
    paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof AbsShareMsg)))
    {
      AbsShareMsg localAbsShareMsg = (AbsShareMsg)paramChatMessage;
      if (localAbsShareMsg.mMsgServiceID == 35)
      {
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append(paramChatMessage.mMsgBrief);
        localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
        localStringBuilder.append("按钮");
        return localStringBuilder.toString();
      }
      if (localAbsShareMsg.mMsgServiceID == 107)
      {
        localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
        return localStringBuilder.toString();
      }
      if (TextUtils.isEmpty(localAbsShareMsg.getTalkBackStr()))
      {
        if ((localAbsShareMsg.mContentTitle != null) && (localAbsShareMsg.mContentTitle.trim().length() > 0)) {
          localStringBuilder.append(localAbsShareMsg.mContentTitle);
        }
        if ((localAbsShareMsg.mContentSummary != null) && (localAbsShareMsg.mContentSummary.trim().length() > 0)) {
          localStringBuilder.append(localAbsShareMsg.mContentSummary);
        }
        localStringBuilder.append("按钮");
      }
      else
      {
        localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
        localStringBuilder.append("按钮");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {
      return;
    }
    if ((paramFileMsg.fileType != 1) && (paramFileMsg.fileType != 131075))
    {
      if (paramFileMsg.fileType == 52) {
        b(paramView, paramFileMsg, paramInt1, paramInt2);
      }
    }
    else {
      a(paramView, paramFileMsg, paramInt1, paramInt2);
    }
  }
  
  protected StructingMsgItemBuilder.StructingMsgViewHolder i()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected void j()
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.d.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.e();
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.f == 0L) && (localVipGiftDownloadInfo.c != 0L)) {
      localVipGiftManager.c(localVipGiftDownloadInfo.c);
    }
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.f == 1L))
    {
      long l2 = localVipGiftManager.a - (NetConnInfoCenter.getServerTimeMillis() - localVipGiftDownloadInfo.i);
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 1L;
      }
      new Handler(this.e.getMainLooper()).postDelayed(new StructingMsgItemBuilder.4(this, localVipGiftDownloadInfo, localVipGiftManager), l1);
    }
  }
  
  int k()
  {
    return this.u;
  }
  
  protected QQAppInterface l()
  {
    return this.d;
  }
  
  protected Context m()
  {
    return this.e;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432263)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      Object localObject1 = ((BaseActivity)this.e).getChatFragment();
      if (localObject1 != null)
      {
        BaseChatPie localBaseChatPie = ((ChatFragment)localObject1).k();
        if (localBaseChatPie != null)
        {
          Object localObject2 = null;
          MessageForStructing localMessageForStructing = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)AIOUtils.b(paramView)).q;
          localObject1 = localObject2;
          if (localMessageForStructing != null)
          {
            localObject1 = localObject2;
            if (localMessageForStructing.structingMsg != null)
            {
              localObject1 = localObject2;
              if ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare))
              {
                StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
                localObject1 = localObject2;
                if (localStructMsgItemImage != null) {
                  localObject1 = new DoutuItem(localStructMsgItemImage.av, localStructMsgItemImage.aw, localStructMsgItemImage.aB, localStructMsgForImageShare.rawUrl, localMessageForStructing.senderuin);
                }
              }
            }
          }
          localBaseChatPie.j().obtainMessage(79, localObject1).sendToTarget();
          DoutuConfigReporter.b();
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("StructingMsgItemBuilder", 2, "[Doutu] curPie is null.");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] chatFragment is null.");
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */