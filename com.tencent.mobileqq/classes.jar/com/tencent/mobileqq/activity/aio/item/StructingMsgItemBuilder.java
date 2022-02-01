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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
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
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager;
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
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.gamecenter.share.GameShareUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
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
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2, FileTransferManager.Callback, MediaPlayerManager.Callback
{
  public static final int[] a;
  static int c = 0;
  private StructingMsgItemBuilderMenuHelper jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilderMenuHelper;
  private StructMsgTimeReport jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport = null;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private List<StructMsgForImageShare> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final float jdField_b_of_type_Float;
  private List<AbsShareMsg> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean f = false;
  private volatile boolean g = false;
  private volatile boolean h = false;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 83, 98, 108, 114, 116, 151, 156 };
  }
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport = new StructMsgTimeReport();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilderMenuHelper = new StructingMsgItemBuilderMenuHelper(this);
  }
  
  private int a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt1 - paramInt2;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt3);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramBoolean) && (paramViewHolder.jdField_a_of_type_AndroidViewView.getParent() != null) && ((paramViewHolder.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramViewHolder.jdField_a_of_type_AndroidViewView.getParent();
      paramContext = new View(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131364634);
      localLayoutParams.addRule(5, 2131364634);
      localLayoutParams.addRule(7, 2131364634);
      localLayoutParams.addRule(8, 2131364634);
      if (paramViewHolder.jdField_b_of_type_AndroidViewView != null) {
        localRelativeLayout.removeView(paramViewHolder.jdField_b_of_type_AndroidViewView);
      }
      if (!MultiMsgUtil.a(paramChatMessage)) {
        break label172;
      }
      paramContext.setBackgroundResource(paramInt4);
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramContext;
      localRelativeLayout.addView(paramViewHolder.jdField_b_of_type_AndroidViewView, localLayoutParams);
      return i;
      label172:
      paramContext.setBackgroundResource(paramInt5);
    }
  }
  
  private View a(ChatMessage paramChatMessage, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, StructingMsgItemBuilder.ViewCache paramViewCache, Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    String str2 = ((StructMsgForGeneralShare)paramAbsStructMsg).getLayoutStr();
    String str1 = str2;
    if (a(paramAbsStructMsg.mMsgServiceID)) {
      str1 = str2 + paramMessageForStructing.issend;
    }
    paramMessageForStructing = a(paramChatMessage, paramBundle, str1);
    paramChatMessage = null;
    if (paramViewCache != null) {
      paramChatMessage = paramViewCache.a(paramMessageForStructing, paramViewGroup);
    }
    paramOnLongClickAndTouchListener = paramAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramOnLongClickAndTouchListener, paramBundle);
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
        Object localObject = localView.getTag(2131378578);
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject);
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
    if (c(paramChatMessage)) {}
    for (;;)
    {
      return paramAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
      paramView = null;
    }
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  public static String a()
  {
    return String.valueOf(c);
  }
  
  private String a(ChatMessage paramChatMessage, Bundle paramBundle, String paramString)
  {
    String str = paramString;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
        {
          str = paramString;
          if ("2711679534".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            str = paramString;
            if (!((QWalletGdtAdManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.QWALLET_GDT_AD_MANAGER)).a())
            {
              paramBundle.putBoolean("isShowQWalletPubAd", paramChatMessage.isShowQWalletPubAd);
              str = paramString + paramChatMessage.isShowQWalletPubAd;
            }
          }
        }
      }
      return str;
    }
    catch (Throwable paramChatMessage)
    {
      QLog.e("StructingMsgItemBuilder", 1, paramChatMessage, new Object[0]);
    }
    return paramString;
  }
  
  private void a(int paramInt1, AbsStructMsg paramAbsStructMsg, int paramInt2, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (((paramInt1 == 1) || (paramInt2 != paramStructingMsgViewHolder.jdField_b_of_type_Int)) && (paramAbsStructMsg.mMsgServiceID == 128)) {
      TroopReportor.a("Grp_AIO", "invite", "send_exp", 0, 0, new String[] { String.valueOf(paramAbsStructMsg.uniseq) });
    }
  }
  
  private void a(long paramLong)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localVipGiftDownloadInfo != null) && (localBaseActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
        localVipGiftManager.a(localVipGiftDownloadInfo, localBaseActivity);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559764, null);
    ((ImageView)localView.findViewById(2131368754)).setImageResource(2130839730);
    ((TextView)localView.findViewById(2131379105)).setText(HardCodeUtil.a(2131714463));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.19(this, localReportDialog), 1500L);
    this.g = false;
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
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = i;
        ((PopupMenuDialog.MenuItem)localObject2).jdField_b_of_type_Int = 0;
        if (localJSONObject.has("show_name")) {}
        for (((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new IPAReportUtil.AdverInfo();
          ((IPAReportUtil.AdverInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((IPAReportUtil.AdverInfo)localObject2).c = localJSONObject.optString("index");
          ((IPAReportUtil.AdverInfo)localObject2).d = localJSONObject.optString("index_name");
          ((IPAReportUtil.AdverInfo)localObject2).b = localJSONObject.optString("index_type");
          ((IPAReportUtil.AdverInfo)localObject2).e = String.valueOf(HttpUtil.getNetWorkType());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList1, new StructingMsgItemBuilder.13(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new StructingMsgItemBuilder.14(this), AIOUtils.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new StructingMsgItemBuilder.15(this));
  }
  
  private void a(Bundle paramBundle, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    paramAbsStructMsg.uniseq = paramMessageForStructing.uniseq;
    paramAbsStructMsg.uin = paramMessageForStructing.frienduin;
    paramAbsStructMsg.uinType = paramMessageForStructing.istroop;
    paramAbsStructMsg.currentAccountUin = paramMessageForStructing.selfuin;
    paramAbsStructMsg.messageVersion = paramMessageForStructing.versionCode;
    paramBundle.putBoolean("isSend", paramMessageForStructing.isSend());
    if (paramAbsStructMsg.uinType == 1008) {
      paramAbsStructMsg.sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
    }
    do
    {
      return;
      paramBundle = paramMessageForStructing.getExtInfoFromExtStr("accostType");
    } while ((paramBundle == null) || (paramBundle.equals("")));
    try
    {
      paramAbsStructMsg.sourceAccoutType = Integer.parseInt(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg)
  {
    BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
    if ((localBaseChatPie instanceof PublicAccountChatPie)) {
      paramView.setOnClickListener(new StructingMsgItemBuilder.10(this, localBaseChatPie, paramAbsShareMsg));
    }
  }
  
  private void a(View paramView, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramAbsShareMsg.mMsgServiceID == 81) {
      StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForStructing, "clk_play");
    }
    while (paramAbsShareMsg.mMsgServiceID != 98)
    {
      AIOUtils.o = true;
      if (!a()) {
        break;
      }
      return;
    }
    int i;
    label60:
    String str1;
    label76:
    String str3;
    if ((StructMsgItemLayout26.a(paramAbsShareMsg.mExtraData) & 0x2) != 0)
    {
      i = 1;
      if (!FaceScoreUtils.a(paramChatMessage, "isFaceScoreSecondMember")) {
        break label136;
      }
      str1 = "2";
      str3 = paramChatMessage.frienduin;
      if (i == 0) {
        break label144;
      }
    }
    label136:
    label144:
    for (String str2 = "2";; str2 = "1")
    {
      FaceScoreUtils.a("clk_obj", str3, new String[] { str1, "", "", str2 });
      break;
      i = 0;
      break label60;
      str1 = "1";
      break label76;
    }
    if ((((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER)).b(paramLong)) && (paramAbsShareMsg.mMsgServiceID == 38)) {}
    for (;;)
    {
      if ((paramMessageForStructing instanceof MessageForTroopNotification))
      {
        paramView = (MessageForTroopNotification)paramMessageForStructing;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramView.frienduin, "" + paramView.feedType, "", "");
      }
      a((MessageForStructing)paramChatMessage);
      return;
      paramOnClickListener.onClick(paramView);
    }
  }
  
  private void a(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 35)
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(paramView.jdField_a_of_type_AndroidViewView.getPaddingLeft(), 0, paramView.jdField_a_of_type_AndroidViewView.getPaddingRight(), 0);
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
    new StructMsgClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      TroopQZoneUploadAlbumHandler localTroopQZoneUploadAlbumHandler = (TroopQZoneUploadAlbumHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_QZONE_UPLOAD_ALBUM_PROGRESS_HANDLER);
      localTroopQZoneUploadAlbumHandler.a(MessageUtils.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new StructingMsgItemBuilder.21(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131379901, paramMessageForStructing);
      localTroopQZoneUploadAlbumHandler.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout1, MessageForStructing paramMessageForStructing, BaseChatItemLayout paramBaseChatItemLayout2, Resources paramResources, boolean paramBoolean)
  {
    int k;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (paramMessageForStructing.structingMsg.mMsgServiceID == 76) || (paramMessageForStructing.structingMsg.mMsgServiceID == 21))
    {
      k = paramResources.getDimensionPixelSize(2131299067);
      m = paramResources.getDimensionPixelSize(2131299067);
      if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break label206;
      }
    }
    label206:
    for (int i = 1;; i = 0)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      int j = i;
      if (localAIOLongShotHelper != null)
      {
        j = i;
        if (localAIOLongShotHelper.a()) {
          j = 0;
        }
      }
      i = k;
      if (j != 0)
      {
        j = AIOUtils.a(30.0F, paramResources);
        i = j;
        if (paramBaseChatItemLayout2.jdField_a_of_type_AndroidWidgetCheckBox != null)
        {
          paramBaseChatItemLayout2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout2.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
          i = j;
          if (paramBaseChatItemLayout2 != null)
          {
            paramBaseChatItemLayout2.leftMargin = AIOUtils.a(5.0F, paramResources);
            i = j;
          }
        }
      }
      paramBaseChatItemLayout1 = (RelativeLayout.LayoutParams)((RelativeLayout)paramBaseChatItemLayout1.b()).getLayoutParams();
      if (paramBaseChatItemLayout1 != null)
      {
        if (paramMessageForStructing.structingMsg.mMsgServiceID == 21) {
          break;
        }
        paramBaseChatItemLayout1.setMargins(i, 0, m, 0);
      }
      return;
    }
    paramBaseChatItemLayout1.setMargins(i, paramBaseChatItemLayout1.topMargin, m, paramBaseChatItemLayout1.bottomMargin);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg)) {
      FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
    }
    for (;;)
    {
      if (b(paramMessageForStructing)) {
        FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
      }
      return;
      if ((StructMsgForGeneralShare.class.isInstance(paramAbsStructMsg)) && (b(paramAbsStructMsg))) {
        a(paramBaseChatItemLayout, paramMessageForStructing);
      }
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
      return;
      paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      return;
      paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130851162);
      int i = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    Object localObject2 = paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      ((RelativeLayout)localObject1).setId(2131378558);
      paramBaseChatItemLayout.addView((View)localObject1);
    }
    Object localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    }
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(-2.0F, paramResources);
    if (paramBoolean2)
    {
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(0.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364634);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364634);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject3 = ((RelativeLayout)localObject1).getChildAt(0);
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          Object localObject4 = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((View)localObject4).getTag(2131378578);
            if (QLog.isColorLevel()) {
              QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject4);
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
      localObject2 = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, (View)localObject2);
      if (localObject2 == null) {
        break label442;
      }
      ((View)localObject2).setId(2131378559);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramStructingMsgViewHolder = new View(this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(-2, -2);
        paramBaseChatItemLayout.addRule(6, 2131378559);
        paramBaseChatItemLayout.addRule(5, 2131378559);
        paramBaseChatItemLayout.addRule(7, 2131378559);
        paramBaseChatItemLayout.addRule(8, 2131378559);
        paramStructingMsgViewHolder.setBackgroundResource(2130838082);
        ((RelativeLayout)localObject1).addView(paramStructingMsgViewHolder, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      a(paramAbsStructMsg, (RelativeLayout)localObject1);
      GameShareUtil.a((View)localObject2, (RelativeLayout)localObject1, paramBoolean1, paramResources, this.jdField_a_of_type_AndroidContentContext, paramAbsStructMsg);
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(10.0F, paramResources);
      if (!a(paramBoolean1, paramAbsStructMsg)) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin += AIOUtils.a(18.0F, paramResources);
      break;
      label442:
      paramBaseChatItemLayout.removeView((View)localObject1);
      paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localRelativeLayout.setId(2131378557);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - AIOUtils.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364634);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364634);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources, paramBaseChatItemLayout);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      paramStructingMsgViewHolder = (RelativeLayout.LayoutParams)paramStructMsgForGeneralShare.getLayoutParams();
      paramStructingMsgViewHolder.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramStructingMsgViewHolder.height = -2;
      paramStructingMsgViewHolder.width = -2;
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(ChatMessage paramChatMessage, Bundle paramBundle, AbsStructMsg paramAbsStructMsg)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
    {
      Object localObject;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        localObject = (StructMsgForGeneralShare)paramAbsStructMsg;
        paramBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
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
                paramAbsStructMsg.Z = paramChatMessage;
              }
              if ((paramAbsStructMsg instanceof AbsStructMsgItem))
              {
                paramAbsStructMsg = (AbsStructMsgItem)paramAbsStructMsg;
                if (paramAbsStructMsg.a != null)
                {
                  paramAbsStructMsg = paramAbsStructMsg.a.iterator();
                  while (paramAbsStructMsg.hasNext())
                  {
                    localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
                    if (!TextUtils.isEmpty(paramChatMessage)) {
                      ((AbsStructMsgElement)localObject).Z = paramChatMessage;
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
    if ((paramAbsStructMsg instanceof AbsShareMsg)) {
      b(paramChatMessage, paramView, paramBaseChatItemLayout, paramMessageForStructing, paramAbsStructMsg);
    }
    while ((paramAbsStructMsg.mMsgServiceID != 3) && (paramAbsStructMsg.mMsgServiceID != 120)) {
      return;
    }
    if (a())
    {
      paramView.setClickable(false);
      return;
    }
    paramView.setClickable(true);
  }
  
  private void a(ChatMessage paramChatMessage, View paramView, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    RelativeLayout localRelativeLayout;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    long l;
    if (paramAbsStructMsg.adverSign == 1)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setImageResource(2130841780);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localRelativeLayout.setOnClickListener(new StructingMsgItemBuilder.7(this, (ImageView)localObject, paramChatMessage, paramView, l));
      }
    }
    do
    {
      do
      {
        return;
      } while (paramAbsStructMsg.adverSign != 2);
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setBackgroundResource(2130841943);
      ((TextView)localObject).setGravity(17);
      int i = paramAbsStructMsg.adverSign;
      ((TextView)localObject).setText(HardCodeUtil.a(2131714457));
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(13.0F);
      localRelativeLayout.setBackgroundColor(0);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    localRelativeLayout.setOnClickListener(new StructingMsgItemBuilder.8(this, (TextView)localObject, paramChatMessage, paramView));
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int j = 1;
    int i;
    if (!HotChatUtil.a(paramMessageForStructing))
    {
      paramMessageForStructing = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131366075);
      if (paramMessageForStructing != null) {
        break label197;
      }
      paramMessageForStructing = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(8, 2131364634);
      localLayoutParams.addRule(1, 2131364634);
      localLayoutParams.bottomMargin = (BaseChatItemLayout.i - AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramMessageForStructing.setId(2131366075);
      paramBaseChatItemLayout.addView(paramMessageForStructing, localLayoutParams);
      paramBaseChatItemLayout = paramMessageForStructing;
      if (paramChatMessage.extraflag == 32768)
      {
        i = j;
        if (paramChatMessage.isSendFromLocal()) {}
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage)) {
          break label207;
        }
        i = j;
      }
    }
    for (;;)
    {
      if ((paramChatMessage.isDui) && (i == 0))
      {
        if (paramChatMessage.isSend())
        {
          paramBaseChatItemLayout.setVisibility(8);
          return;
          label197:
          paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          paramBaseChatItemLayout = paramMessageForStructing;
          break;
          label207:
          i = 0;
          continue;
        }
        if (!paramChatMessage.hasPlayedDui) {
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramBaseChatItemLayout);
        }
        while (DuiButtonImageView.jdField_a_of_type_Boolean)
        {
          paramBaseChatItemLayout.setOnClickListener(this);
          paramBaseChatItemLayout.setVisibility(0);
          return;
          if (paramBaseChatItemLayout.b()) {
            DoutuConfigReporter.a(paramChatMessage);
          }
        }
        paramBaseChatItemLayout.setOnClickListener(null);
        paramBaseChatItemLayout.setVisibility(8);
        return;
      }
    }
    paramBaseChatItemLayout.setVisibility(8);
    paramBaseChatItemLayout.e();
  }
  
  private void a(ChatMessage paramChatMessage, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
      PublicAccountEventReport.a(117, paramChatMessage, paramStructingMsgViewHolder.jdField_b_of_type_Int);
    }
  }
  
  private void a(ChatMessage paramChatMessage, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = null;
    Integer localInteger;
    if ((paramStructingMsgViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      localInteger = Integer.valueOf(2131378557);
    }
    for (;;)
    {
      paramStructingMsgViewHolder.jdField_c_of_type_AndroidViewView = super.a(paramStructingMsgViewHolder.jdField_c_of_type_AndroidViewView, paramStructingMsgViewHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramStructingMsgViewHolder.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, localInteger, paramChatMessage, -4, Boolean.valueOf(true));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramStructingMsgViewHolder = paramStructingMsgViewHolder.jdField_c_of_type_AndroidViewView;
      paramChatMessage = localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramStructingMsgViewHolder, paramChatMessage);
      return;
      if ((paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
        localInteger = Integer.valueOf(2131378558);
      } else {
        localInteger = null;
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)paramAbsStructMsg).havaPayInfoInit))
    {
      String str = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
      if ((!TextUtils.isEmpty(str)) && (str.equals("1"))) {
        ((StructMsgForGeneralShare)paramAbsStructMsg).initPay(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, RelativeLayout paramRelativeLayout)
  {
    if (paramAbsStructMsg.mMsgServiceID == 38)
    {
      paramAbsStructMsg = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      if (paramAbsStructMsg != null)
      {
        if (!paramAbsStructMsg.b(paramChatMessage.time)) {
          break label132;
        }
        paramChatMessage = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setId(2131364661);
        paramChatMessage.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839545));
        int i = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        new RelativeLayout.LayoutParams(-2, -2);
        paramAbsStructMsg = new RelativeLayout.LayoutParams(i, i);
        paramAbsStructMsg.addRule(13, 2131364634);
        paramRelativeLayout.addView(paramChatMessage, paramAbsStructMsg);
        e();
      }
    }
    label132:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0);
      paramChatMessage = paramAbsStructMsg.a();
    } while (paramChatMessage == null);
    a(paramChatMessage.a);
  }
  
  private void a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if ((paramStructingMsgViewHolder != null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (paramAbsStructMsg.hasFlag(16))) {
      ThreadManager.post(new StructingMsgItemBuilder.3(this, paramStructingMsgViewHolder), 2, null, false);
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2)
  {
    boolean bool = String.valueOf(-1000).equals(paramString2);
    Object localObject;
    if (bool)
    {
      paramString2 = HardCodeUtil.a(2131714458);
      localObject = HardCodeUtil.a(2131714459);
      if (TextUtils.isEmpty(paramString1)) {
        break label113;
      }
    }
    for (;;)
    {
      localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      ((ActionSheet)localObject).addButton(paramString2);
      ((ActionSheet)localObject).addCancelButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690800));
      ((ActionSheet)localObject).setMainTitle(paramString1);
      ((ActionSheet)localObject).setOnButtonClickListener(new StructingMsgItemBuilder.24(this, bool, paramChatMessage, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
      paramString2 = HardCodeUtil.a(2131714460);
      break;
      label113:
      paramString1 = (String)localObject;
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (StructMsgForImageShare.class.isInstance(paramAbsStructMsg))
    {
      paramAbsStructMsg = (StructMsgForImageShare)paramAbsStructMsg;
      paramAbsStructMsg.mIsSend = paramMessageForStructing.issend;
      paramAbsStructMsg.mUniseq = paramMessageForStructing.uniseq;
      paramAbsStructMsg.mMsgType = paramMessageForStructing.msgtype;
    }
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
    if ((paramAbsStructMsg instanceof StructMsgForImageShare)) {
      a(paramMessageForStructing, (StructMsgForImageShare)paramAbsStructMsg, paramStructingMsgViewHolder, paramRelativeLayout);
    }
    while ((!(paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!(paramAbsStructMsg instanceof StructMsgForAudioShare))) {
      return;
    }
    a((AbsShareMsg)paramAbsStructMsg);
  }
  
  private void a(MessageForStructing paramMessageForStructing, StructMsgForImageShare paramStructMsgForImageShare, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, RelativeLayout paramRelativeLayout)
  {
    if (paramMessageForStructing.isSendFromLocal())
    {
      paramMessageForStructing = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
      a(paramMessageForStructing, paramStructingMsgViewHolder);
    }
    paramMessageForStructing = paramStructMsgForImageShare.getFirstImageElement();
    if ((paramMessageForStructing != null) && (paramMessageForStructing.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(paramMessageForStructing.a, 2);
      ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilder.6(this, paramMessageForStructing));
    }
    a(paramStructMsgForImageShare);
  }
  
  private void a(AbsShareMsg paramAbsShareMsg)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramAbsShareMsg))
    {
      paramAbsShareMsg.report(Integer.valueOf(0));
      this.jdField_b_of_type_JavaUtilList.add(paramAbsShareMsg);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (paramAbsStructMsg.hasFlag(4))) {
      paramAbsStructMsg.addFlag(1);
    }
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
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramStructMsgForImageShare))
    {
      paramStructMsgForImageShare.report(Long.valueOf(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getLongExtra("req_share_id", 0L)));
      this.jdField_a_of_type_JavaUtilList.add(paramStructMsgForImageShare);
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, AbsStructMsg paramAbsStructMsg, Resources paramResources)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
      if (!paramAbsStructMsg.hasFlag(32)) {
        paramQQCustomMenu.a(2131367420, paramResources.getString(2131692687), 2130839059);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAbsStructMsg.hasFlag(1));
        paramQQCustomMenu.a(2131367398, paramResources.getString(2131692687), 2130839059);
        return;
      } while (paramAbsStructMsg.mMsgServiceID == 14);
      if (!paramAbsStructMsg.hasFlag(1))
      {
        paramQQCustomMenu.a(2131367398, paramResources.getString(2131692687), 2130839059);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 35);
    paramQQCustomMenu.a(2131367398, paramResources.getString(2131692687), 2130839059);
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      localObject = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)((BaseTransProcessor)localObject).getFileStatus();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).isRawPic()) || (!((BaseTransProcessor)localObject).isPause())) {
        break label368;
      }
      i = 1006;
    }
    label368:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131378578);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131378578);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131378578);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131378578);
      if ((paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378564) == null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131378564);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        a(paramStructingMsgViewHolder, i);
        return;
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
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
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt3);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramBoolean) && (paramViewHolder.jdField_a_of_type_AndroidViewView.getParent() != null) && ((paramViewHolder.jdField_a_of_type_AndroidViewView.getParent() instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramViewHolder.jdField_a_of_type_AndroidViewView.getParent();
      paramContext = new View(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131364634);
      localLayoutParams.addRule(5, 2131364634);
      localLayoutParams.addRule(7, 2131364634);
      localLayoutParams.addRule(8, 2131364634);
      if (paramViewHolder.jdField_b_of_type_AndroidViewView != null) {
        localRelativeLayout.removeView(paramViewHolder.jdField_b_of_type_AndroidViewView);
      }
      if (!MultiMsgUtil.a(paramChatMessage)) {
        break label172;
      }
      paramContext.setBackgroundResource(paramInt4);
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramContext;
      localRelativeLayout.addView(paramViewHolder.jdField_b_of_type_AndroidViewView, localLayoutParams);
      return i;
      label172:
      paramContext.setBackgroundResource(paramInt5);
    }
  }
  
  private void b(Activity paramActivity)
  {
    ReportDialog localReportDialog = new ReportDialog(paramActivity);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2131559764, null);
    ((ImageView)localView.findViewById(2131368754)).setImageResource(2130839715);
    ((TextView)localView.findViewById(2131379105)).setText(HardCodeUtil.a(2131714462));
    localReportDialog.setContentView(localView);
    localReportDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.20(this, localReportDialog), 1500L);
    this.g = false;
  }
  
  private void b(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    ArrayList localArrayList = new ArrayList();
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    Object localObject = localAbsStructMsg.adverKey;
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        if (localJSONObject.has("index"))
        {
          localMenuItem.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localMenuItem.jdField_b_of_type_Int = 0;
          if (localJSONObject.has("show_name"))
          {
            localMenuItem.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localMenuItem);
            i += 1;
          }
        }
        else
        {
          localMenuItem.jdField_a_of_type_Int = i;
          continue;
        }
        localMenuItem.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList, new StructingMsgItemBuilder.16(this, paramChatMessage, paramActivity, localAbsStructMsg), new StructingMsgItemBuilder.17(this), AIOUtils.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new StructingMsgItemBuilder.18(this));
  }
  
  private void b(View paramView, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.mMsgServiceID == 76)
    {
      int i = AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setPadding(0, 0, 0, 0);
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(i, j, i, j);
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
    }
    for (;;)
    {
      c(paramView, paramAbsStructMsg);
      a(paramView, paramAbsStructMsg, localAbsShareMsg);
      return;
      if (paramAbsStructMsg.mMsgServiceID == 78) {
        a(paramView, (AbsShareMsg)paramAbsStructMsg);
      }
    }
  }
  
  private static void b(String paramString, URL paramURL, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = true;
    paramString = AbsDownloader.getFilePath(paramURL.toString());
    QLog.d("StructingMsgItemBuilder", 1, new Object[] { "generateHdPic hdThumbFilePath=", paramString });
    if (!paramString.endsWith("_hd"))
    {
      if (!paramString.endsWith("_big400")) {
        break label136;
      }
      paramString.replace("_big400", "_hd");
    }
    while (new File(paramString).exists())
    {
      QLog.d("StructingMsgItemBuilder", 1, "hd image exists, no need compress");
      paramString = URLDrawable.getDrawable(paramURL);
      if (paramString != null)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
        ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.11(paramString));
      }
      return;
      label136:
      paramString = paramString + "_hd";
    }
    localCompressInfo.e = paramString;
    for (;;)
    {
      try
      {
        new File(paramString).getParentFile().mkdirs();
        localCompressInfo.a = paramThumbWidthHeightDP;
        if (CompressOperator.b(localCompressInfo))
        {
          paramThumbWidthHeightDP = "hd image compress success";
          QLog.d("StructingMsgItemBuilder", 1, paramThumbWidthHeightDP);
          if (localCompressInfo.e == null) {
            break;
          }
          paramString = new File(paramString);
          if (!localCompressInfo.e.equals(localCompressInfo.c)) {
            break label392;
          }
          bool = FileUtil.a(new File(localCompressInfo.c), paramString);
          QLog.d("StructingMsgItemBuilder", 1, new Object[] { "ret=", Boolean.valueOf(bool), ", thumbCI.destPath=", localCompressInfo.e, ", thumbCI.srcPath=", localCompressInfo.c });
          if ((!bool) || (GlobalImageCache.a.get(paramURL.toString()) == null)) {
            break;
          }
          GlobalImageCache.a.remove(paramURL.toString());
          paramString = URLDrawable.getDrawable(paramURL);
          if (paramString == null) {
            break;
          }
          QLog.d("StructingMsgItemBuilder", 1, "hd image invalidateSelf");
          ThreadManager.getUIHandler().post(new StructingMsgItemBuilder.12(paramString));
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("StructingMsgItemBuilder", 1, "hd image file parent create fail");
        return;
      }
      paramThumbWidthHeightDP = "hd image compress fail";
      continue;
      label392:
      boolean bool = true;
    }
  }
  
  private boolean b(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing.isSendFromLocal()) && (paramMessageForStructing.extraflag == 32772) && (paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing.structingMsg).isSdkShareMsg()) && (!((AbsShareMsg)paramMessageForStructing.structingMsg).shareData.isFinish());
  }
  
  private boolean b(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
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
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {}
    do
    {
      return false;
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    } while (!(paramChatMessage instanceof StructMsgForImageShare));
    paramChatMessage = ((StructMsgForImageShare)paramChatMessage).getFirstImageElement();
    if ((paramChatMessage != null) && (paramChatMessage.a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg instanceof StructMsgForGeneralShare))
      {
        paramChatMessage = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
        int i = 0;
        while (i < paramChatMessage.getItemCount())
        {
          if ((paramChatMessage.getItemByIndex(i) instanceof StructMsgItemLayout19)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a();
    if (paramView == null) {}
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    for (int i = 1;; i = 2)
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = localMessageForStructing.structingMsg;
      if (localAbsStructMsg != null) {
        break;
      }
      return paramView;
    }
    if (localAbsStructMsg.mMsgServiceID == 81) {
      StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
    }
    a(paramChatMessage, localAbsStructMsg);
    if ((paramView != null) && ((paramView.getTag() instanceof BaseBubbleBuilder.ViewHolder))) {}
    for (int j = ((BaseBubbleBuilder.ViewHolder)paramView.getTag()).jdField_b_of_type_Int;; j = -1)
    {
      localAbsStructMsg.message = localMessageForStructing;
      if (("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && ((localAbsStructMsg instanceof StructMsgForGeneralShare))) {
        EcShopAssistantManager.a((StructMsgForGeneralShare)localAbsStructMsg);
      }
      paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
      b(paramViewGroup, localAbsStructMsg);
      a(paramViewGroup, localAbsStructMsg);
      paramOnLongClickAndTouchListener = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewGroup.getTag();
      paramView = paramViewGroup;
      if (paramOnLongClickAndTouchListener == null) {
        break;
      }
      paramView = paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      a(i, localAbsStructMsg, j, paramOnLongClickAndTouchListener);
      if ((localAbsStructMsg instanceof AbsShareMsg)) {}
      for (paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;; paramInt2 = -1)
      {
        a(localAbsStructMsg);
        Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        boolean bool = a(localMessageForStructing);
        if (QLog.isDevelopLevel()) {
          QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
        }
        a(paramOnLongClickAndTouchListener, paramView, bool);
        a(paramOnLongClickAndTouchListener, paramView, localMessageForStructing.isSend(), localAbsStructMsg, localResources, bool);
        if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
          a(paramOnLongClickAndTouchListener, paramView, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, localResources, bool);
        }
        if ((paramOnLongClickAndTouchListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          a(paramChatMessage, paramOnLongClickAndTouchListener, paramView);
        }
        a((BaseChatItemLayout)paramViewGroup, localMessageForStructing, paramView, localResources, bool);
        paramViewGroup.requestLayout();
        a(paramChatMessage, localAbsStructMsg, paramOnLongClickAndTouchListener);
        paramView = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
        if (paramView.b(paramChatMessage))
        {
          paramView.a(paramChatMessage.uniseq);
          paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772234);
          paramView.setAnimationListener(new StructingMsgItemBuilder.1(this, paramOnLongClickAndTouchListener));
          paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewView.postDelayed(new StructingMsgItemBuilder.2(this, paramOnLongClickAndTouchListener, paramView), 300L);
        }
        this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a(paramInt2, i);
        EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramViewGroup);
        return paramViewGroup;
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = null;
    Bundle localBundle = new Bundle();
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
    }
    Object localObject2;
    Object localObject3;
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    if (paramView == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131364634);
      paramView.setMinimumHeight(AIOUtils.a(44.0F, (Resources)localObject2));
      paramView.setClickable(true);
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
      paramView.setBackgroundResource(2130838140);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      int i = ((Resources)localObject2).getDimensionPixelSize(2131299067);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131368603);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = localMessageForStructing.structingMsg;
      if (localAbsStructMsg != null) {
        break label275;
      }
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder().append("structMsg is null,msgdata:");
        if (localMessageForStructing.msgData != null) {
          break label262;
        }
      }
    }
    label262:
    for (paramChatMessage = "null";; paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length))
    {
      QLog.d("structMsg", 2, paramChatMessage);
      return paramView;
      if (!c(paramChatMessage)) {
        ((ViewGroup)paramView).removeAllViews();
      }
      break;
    }
    label275:
    localAbsStructMsg.message = localMessageForStructing;
    a(paramChatMessage, localBundle, localAbsStructMsg);
    a(localBundle, localMessageForStructing, localAbsStructMsg);
    a(localMessageForStructing, localAbsStructMsg, localBundle);
    a(localMessageForStructing, localAbsStructMsg);
    paramBaseChatItemLayout.setAddStatesFromChildren(false);
    paramViewHolder = paramBaseChatItemLayout.getTag();
    if (paramViewHolder != null) {}
    for (paramViewHolder = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewHolder;; paramViewHolder = null)
    {
      if (paramViewHolder == null) {
        paramViewHolder = a();
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        localObject3 = paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = (RelativeLayout)paramView;
          paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
          paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131378574);
        }
        paramView.setTag(paramViewHolder);
        if (d(paramChatMessage)) {
          paramViewHolder.jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
          {
            localObject1 = a(paramChatMessage, (ViewGroup)paramView, paramOnLongClickAndTouchListener, (StructingMsgItemBuilder.ViewCache)localObject1, localBundle, localMessageForStructing, localAbsStructMsg);
            paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
            paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
            a(paramChatMessage, paramView, paramBaseChatItemLayout, localMessageForStructing, localAbsStructMsg);
          }
          try
          {
            ((RelativeLayout)localObject2).addView((View)localObject1);
            a(paramChatMessage, localAbsStructMsg, (RelativeLayout)localObject2);
            a(localMessageForStructing, localAbsStructMsg, paramViewHolder, (RelativeLayout)localObject2);
            a(paramChatMessage, paramView, localMessageForStructing, localAbsStructMsg);
            f();
            a(paramChatMessage, paramBaseChatItemLayout, localMessageForStructing);
            a(paramChatMessage, paramViewHolder);
            return paramView;
            paramViewHolder.jdField_a_of_type_Boolean = false;
            continue;
            localObject1 = a(paramChatMessage, paramOnLongClickAndTouchListener, localBundle, localAbsStructMsg, (RelativeLayout)localObject2, null);
          }
          catch (IllegalStateException paramOnLongClickAndTouchListener)
          {
            for (;;)
            {
              ((ViewGroup)((View)localObject1).getParent()).removeAllViews();
              ((RelativeLayout)localObject2).addView((View)localObject1);
            }
          }
        }
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    try
    {
      ChatMessage localChatMessage = AIOUtils.a(paramView);
      if (!(localChatMessage instanceof MessageForStructing)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("StructingMsgItemBuilder", 1, paramView.getClass().getName(), localException);
          localObject = null;
        }
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg.mMsgServiceID == 5) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 137))) {
          return (BaseBubbleBuilder.TouchDelegate)paramView.findViewById(2131368937);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131376652);
      if (localObject != null) {
        return (BaseBubbleBuilder.TouchDelegate)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      CaughtExceptionReport.a(new IllegalStateException(paramView), "StructingMsgItemBuilderCatchedException" + paramView);
    }
    return null;
  }
  
  protected StructingMsgItemBuilder.StructingMsgViewHolder a()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = (MessageForStructing)paramChatMessage;
    paramChatMessage = paramBaseHolder.structingMsg;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null) {
      if (a(paramBaseHolder, paramChatMessage)) {}
    }
    while (!bool1)
    {
      return paramQQCustomMenu;
      paramBaseHolder = this.jdField_a_of_type_AndroidContentContext.getResources();
      bool1 = bool2;
      if (paramChatMessage.fwFlag != 1)
      {
        a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
        bool1 = a(paramChatMessage);
      }
    }
    paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692258), 2130839058);
    return paramQQCustomMenu;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    AbsShareMsg localAbsShareMsg;
    for (;;)
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof AbsShareMsg))) {
        break label210;
      }
      localAbsShareMsg = (AbsShareMsg)paramChatMessage;
      if (localAbsShareMsg.mMsgServiceID != 35) {
        break;
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append(paramChatMessage.mMsgBrief);
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
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
    for (;;)
    {
      label210:
      return localStringBuilder.toString();
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
    }
  }
  
  public String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      str1 = str2;
      if (paramString.length > 6) {
        str1 = paramString[5];
      }
    }
    return str1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    StructMsgForGeneralShare.unRegisterQIPC();
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilderMenuHelper.a(paramInt, paramContext, paramChatMessage)) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ChatMessage localChatMessage = ((StructingMsgItemBuilder.StructingMsgViewHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localChatMessage.isMultiMsg) {}
    Object localObject;
    do
    {
      return;
      localObject = a(localChatMessage);
      if (localObject != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject);
        return;
      }
      paramView = localContext.getString(2131690018);
      localObject = localContext.getString(2131690019);
    } while (!localChatMessage.isSendFromLocal());
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = PAVideoStructMsgUtil.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 151) || (localMessageForStructing.structingMsg.mMsgServiceID == 156))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label201;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404);
        if (!paramChatMessage.isSend()) {
          break label261;
        }
        paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, BaseChatItemLayout.i);
      }
    }
    for (;;)
    {
      if (localMessageForStructing.structingMsg.mMsgServiceID == 107)
      {
        paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView.setPadding(AIOUtils.a(1.5F, paramChatMessage), AIOUtils.a(2.0F, paramChatMessage), AIOUtils.a(1.5F, paramChatMessage), paramView.getPaddingBottom());
      }
      return;
      label201:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296405);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296409);
      break;
      label261:
      paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructingMsgItemBuilder", 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 891)
    {
      Object localObject = paramView.getTag();
      if (((localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
        BaseChatItemLayout localBaseChatItemLayout = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
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
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((paramFileMsg.fileType == 1) || (paramFileMsg.fileType == 131075))
      {
        b(paramView, paramFileMsg, paramInt1, paramInt2);
        return;
      }
    } while (paramFileMsg.fileType != 52);
    c(paramView, paramFileMsg, paramInt1, paramInt2);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramBaseChatItemLayout = (MessageForStructing)paramChatMessage;
    int i;
    int j;
    int k;
    boolean bool;
    if (a(paramBaseChatItemLayout, paramBaseChatItemLayout.structingMsg.mMsgServiceID))
    {
      paramInt1 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingRight();
      i = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingTop();
      j = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      k = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!paramChatMessage.isSend()) {
        break label144;
      }
      paramInt1 = b(paramChatMessage, paramContext, paramViewHolder, paramInt1, k, bool, 2130850414, 2130850411, 2130850410);
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setPadding(paramInt1, i, paramInt2, j);
      return;
      label144:
      paramInt2 = a(paramChatMessage, paramContext, paramViewHolder, paramInt2, k, bool, 2130850238, 2130850235, 2130850234);
    }
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).getFileMsg(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected void a(MessageForStructing paramMessageForStructing) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramXListView = AIOUtils.a(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
          {
            paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder))
            {
              paramView = (ImageView)((StructMsgItemPAAudio.ViewHolder)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_c_of_type_AndroidViewView;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130841981);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    String str1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramString1;
    String str2 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
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
    if (("replyMsg".equals(paramString8)) || ("replyCmd".equals(paramString8))) {}
    for (;;)
    {
      paramString1.putExtra("req_type", 1);
      paramString1.putExtra("req_share_id", -1);
      paramString1.putExtra("brief_key", paramString12);
      paramString1.putExtra("struct_share_key_source_icon", paramString7);
      paramString1.putExtra("struct_share_key_source_action", "plugin");
      paramString1.putExtra("struct_share_key_source_action_data", str1);
      paramString1.putExtra("struct_share_key_source_a_action_data", str1);
      paramString1.putExtra("struct_share_key_source_i_action_data", str2);
      paramString1.putExtra("forward _key_nojump", true);
      paramString2 = StructMsgFactory.a(paramString1.getExtras());
      if (paramString2 == null) {
        break;
      }
      paramString1.putExtra("stuctmsg_bytes", paramString2.getBytes());
      paramString1.putExtra("k_struct_forward", true);
      paramContext.startActivity(paramString1);
      return true;
      paramString1.putExtra("struct_share_key_content_action", paramString8);
      paramString1.putExtra("struct_share_key_content_action_DATA", paramString9);
      paramString1.putExtra("struct_share_key_content_a_action_DATA", paramString10);
      paramString1.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    }
    return false;
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof StructingMsgItemBuilder.StructingMsgViewHolder;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    Object localObject = (MessageForStructing)paramChatMessage;
    if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
    {
      localObject = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      if (localObject == null) {
        break label254;
      }
    }
    label254:
    for (localObject = ((StructMsgForImageShare)localObject).getFirstImageElement();; localObject = null)
    {
      if ((localObject != null) && (((StructMsgItemImage)localObject).d <= 0L))
      {
        paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof BaseTransProcessor))
        {
          if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
        return true;
        if (b((MessageForStructing)localObject))
        {
          if (((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
            }
            return true;
          }
        }
        else {
          if ((((MessageForStructing)localObject).structingMsg != null) && ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mMsgServiceID == 95) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage))) {
            break;
          }
        }
      }
      return super.a(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    boolean bool = paramMessageForStructing.hasFlag(4);
    if (((paramMessageForStructing instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing).mMsgException)) {
      bool = true;
    }
    for (;;)
    {
      if ((paramMessageForStructing.mMsgServiceID == 76) || (paramMessageForStructing.mMsgServiceID == 91)) {
        bool = true;
      }
      return bool;
    }
  }
  
  protected boolean a(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).mMsgException)) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 86) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 61) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 91) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 97) {
      return false;
    }
    if (paramAbsStructMsg.mMsgServiceID == 98) {
      return false;
    }
    if ((paramAbsStructMsg instanceof StructMsgForHypertext)) {
      return false;
    }
    if ((paramMessageForStructing.isSendFromLocal()) && ((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg()))
    {
      if (paramMessageForStructing.extraflag == 32772) {
        break label131;
      }
      if (paramMessageForStructing.extraflag == 32768) {
        return false;
      }
    }
    return true;
    label131:
    return false;
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
    return (!paramAbsStructMsg.hasFlag(2)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14);
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = AIOUtils.a(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
          {
            paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)) {
              return FileUtils.b(((StructMsgItemPAAudio.ViewHolder)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt += 1;
        }
      }
      return false;
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    Object localObject1 = AIOUtils.a(paramView);
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = ((ViewGroup)localObject1).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          if (((((ViewGroup)localObject1).getChildAt(paramInt2).getTag() instanceof StructMsgItemLayout10.ViewHolder)) && (a(paramXListView, paramInt1, paramView, paramChatMessage)))
          {
            Object localObject2 = (StructMsgItemLayout10.ViewHolder)((ViewGroup)localObject1).getChildAt(paramInt2).getTag();
            if ((((StructMsgItemLayout10.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder))
            {
              localObject2 = ((StructMsgItemPAAudio.ViewHolder)((StructMsgItemLayout10.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString;
              paramAudioPlayerBase.b(8);
              paramAudioPlayerBase.a((String)localObject2);
            }
          }
          paramInt2 += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForStructing)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label40;
      }
      a(localQQCustomMenu, paramView, null);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      label40:
      b(localQQCustomMenu, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg == null) || (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) || (((StructMsgForGeneralShare)paramChatMessage.structingMsg).mMsgServiceID != 95)) {
        break label105;
      }
    }
    label105:
    for (int i = 7;; i = 5)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilderMenuHelper.a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramChatMessage, null);
    return paramQQCustomMenu;
  }
  
  public void b(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void b(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
        paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
      } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == paramFileMsg.uniseq) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.uniseq);
        }
        a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != paramFileMsg.uniseq) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramFileMsg = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, paramFileMsg));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
        } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((paramView.uniseq != paramFileMsg.uniseq) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + paramFileMsg.uniseq);
      }
    } while ((paramInt1 != 1005) && (paramInt1 != 1001) && (paramInt1 != 1003) && (paramInt1 != 1004) && (paramInt1 != 1002));
    b();
  }
  
  protected void e()
  {
    long l1 = 1L;
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 0L) && (localVipGiftDownloadInfo.a != 0L)) {
      localVipGiftManager.a(localVipGiftDownloadInfo.a);
    }
    long l2;
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 1L))
    {
      l2 = localVipGiftManager.a - (NetConnInfoCenter.getServerTimeMillis() - localVipGiftDownloadInfo.e);
      if (l2 > 0L) {
        break label128;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new StructingMsgItemBuilder.4(this, localVipGiftDownloadInfo, localVipGiftManager), l1);
      return;
      label128:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    StructMsgForImageShare localStructMsgForImageShare;
    StructMsgItemImage localStructMsgItemImage;
    if (paramView.getId() == 2131366075)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        break label202;
      }
      localBaseChatPie = ((ChatFragment)localObject).a();
      if (localBaseChatPie == null) {
        break label183;
      }
      localObject = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break label221;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
      localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
      if (localStructMsgItemImage == null) {
        break label221;
      }
    }
    label183:
    label202:
    label221:
    for (Object localObject = new DoutuItem(localStructMsgItemImage.ad, localStructMsgItemImage.ae, localStructMsgItemImage.c, localStructMsgForImageShare.rawUrl, ((MessageForStructing)localObject).senderuin);; localObject = null)
    {
      localBaseChatPie.a().obtainMessage(79, localObject).sendToTarget();
      DoutuConfigReporter.b();
      for (;;)
      {
        super.onClick(paramView);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("StructingMsgItemBuilder", 2, "[Doutu] curPie is null.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("StructingMsgItemBuilder", 2, "[Doutu] chatFragment is null.");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */