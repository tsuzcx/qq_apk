package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
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
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.util.PAReportUtil.AdverInfo;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
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
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import eipc.EIPCServer;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vhh;
import vhi;
import vhj;
import vhk;
import vhl;
import vhn;
import vho;
import vhp;
import vhr;
import vht;
import vhu;
import vhv;
import vhw;
import vhx;
import vhy;
import vhz;
import via;
import vib;
import vic;
import vid;
import vie;
import vif;
import vih;
import vii;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback
{
  public static final int[] a;
  public static int b;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vhp(this);
  private StructMsgTimeReport jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private final float b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 83, 98, 108, 114, 116 };
  }
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport = new StructMsgTimeReport();
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
    return String.valueOf(jdField_b_of_type_Int);
  }
  
  private void a(long paramLong)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localVipGiftDownloadInfo != null) && (localBaseActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
        localVipGiftManager.a(localVipGiftDownloadInfo, localBaseActivity);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2130969238, null);
    ((ImageView)localView.findViewById(2131362767)).setImageResource(2130838750);
    ((TextView)localView.findViewById(2131365553)).setText("退订成功");
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new vhw(this, localDialog), 1500L);
    this.d = false;
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
          localObject2 = new PAReportUtil.AdverInfo();
          ((PAReportUtil.AdverInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((PAReportUtil.AdverInfo)localObject2).c = localJSONObject.optString("index");
          ((PAReportUtil.AdverInfo)localObject2).d = localJSONObject.optString("index_name");
          ((PAReportUtil.AdverInfo)localObject2).b = localJSONObject.optString("index_type");
          ((PAReportUtil.AdverInfo)localObject2).e = String.valueOf(HttpUtil.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList1, new vhl(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new vhn(this), AIOUtils.a(100.0F, paramActivity.getResources()));
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
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new vho(this));
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
      TroopQZoneUploadAlbumHandler localTroopQZoneUploadAlbumHandler = (TroopQZoneUploadAlbumHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localTroopQZoneUploadAlbumHandler.a(MessageUtils.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      paramMessageForStructing = new vhy(this, paramMessageForStructing, paramBaseChatItemLayout);
      paramBaseChatItemLayout.setTag(2131362038, paramMessageForStructing);
      localTroopQZoneUploadAlbumHandler.a(paramBaseChatItemLayout, paramMessageForStructing);
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130846407);
      int i = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.b;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131361882);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(-2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131361877);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131361877);
        if (!paramBoolean1) {
          break label388;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131361863);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131361855);
              if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject2);
              }
              if (localObject2 != null)
              {
                paramResources = (Resources)localObject1;
                if (localObject2.getClass() == paramAbsStructMsg.getClass()) {}
              }
              else
              {
                paramResources = null;
              }
            }
          }
        }
        localRelativeLayout.removeAllViews();
        paramAbsStructMsg = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramAbsStructMsg == null) {
          break label410;
        }
        localRelativeLayout.addView(paramAbsStructMsg);
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(10.0F, paramResources);
        if ((!paramBoolean1) || ((paramAbsStructMsg.mMsgServiceID != 83) && (paramAbsStructMsg.mMsgServiceID != 108) && (paramAbsStructMsg.mMsgServiceID != 114) && (paramAbsStructMsg.mMsgServiceID != 116)) || (TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData))) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin += AIOUtils.a(18.0F, paramResources);
        break;
        label388:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131361863);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131361877);
      }
      label410:
      paramBaseChatItemLayout.removeView(localRelativeLayout);
      paramStructingMsgViewHolder.b = null;
      return;
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.c;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131361883);
      paramBaseChatItemLayout.addView(localRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (12 - AIOUtils.a(10.0F, paramResources));
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131361877);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131361877);
      localObject = localRelativeLayout;
    }
    paramResources = ((RelativeLayout)localObject).getChildAt(0);
    paramStructMsgForGeneralShare = paramStructMsgForGeneralShare.getAdSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
    if (paramStructMsgForGeneralShare != null)
    {
      ((RelativeLayout)localObject).addView(paramStructMsgForGeneralShare);
      return;
    }
    paramBaseChatItemLayout.removeView((View)localObject);
    paramStructingMsgViewHolder.b = null;
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
      i = (int)((BaseTransProcessor)localObject).c();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).a()) || (!((BaseTransProcessor)localObject).b())) {
        break label420;
      }
      i = 1006;
    }
    label420:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131361855);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131361855);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131361855);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131361855);
      if ((paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361967) == null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
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
          localMessageProgressTextView.setId(2131361967);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_b_of_type_Float * 12.0F));
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
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
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = (TroopTopicMgr)paramQQAppInterface.getManager(97);
      } while ((paramQQAppInterface.jdField_a_of_type_Boolean) || (paramChatMessage.istroop != 1));
      localObject = (MessageForStructing)paramChatMessage;
    } while (!(((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg));
    Object localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
    if ((localObject instanceof StructMsgForAudioShare)) {}
    label178:
    while ((!paramQQAppInterface.a(((AbsShareMsg)localObject).mSourceAppid)) && (!paramQQAppInterface.a(((AbsShareMsg)localObject).mMsgUrl)) && (!paramQQAppInterface.b(Long.parseLong(paramChatMessage.senderuin))))
    {
      return true;
      if ((!(localObject instanceof StructMsgForGeneralShare)) || (!"web".equals(((AbsShareMsg)localObject).mMsgAction)) || (TextUtils.isEmpty(((AbsShareMsg)localObject).mMsgUrl)) || (TextUtils.isEmpty(((AbsShareMsg)localObject).mSourceName))) {
        break;
      }
      int i = 0;
      if (i < ((AbsShareMsg)localObject).getItemCount()) {
        if (!(((AbsShareMsg)localObject).getItemByIndex(i) instanceof StructMsgItemLayout2)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label178;
        }
        return false;
        i += 1;
        break;
      }
    }
  }
  
  private boolean a(MessageForStructing paramMessageForStructing)
  {
    AbsStructMsg localAbsStructMsg = paramMessageForStructing.structingMsg;
    boolean bool = localAbsStructMsg.hasFlag(4);
    if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException)) {
      bool = true;
    }
    for (;;)
    {
      if (((paramMessageForStructing instanceof MessageForTroopTopic)) || (localAbsStructMsg.mMsgServiceID == 76) || (localAbsStructMsg.mMsgServiceID == 91)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private void b(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2130969238, null);
    ((ImageView)localView.findViewById(2131362767)).setImageResource(2130838739);
    ((TextView)localView.findViewById(2131365553)).setText("退订失败");
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new vhx(this, localDialog), 1500L);
    this.d = false;
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
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList, new vhr(this, paramChatMessage, paramActivity, localAbsStructMsg), new vht(this), AIOUtils.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new vhu(this));
  }
  
  private void b(View paramView, ChatMessage paramChatMessage)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131368585);
    TextView localTextView2 = (TextView)paramView.findViewById(2131368586);
    TextView localTextView5 = (TextView)paramView.findViewById(2131368589);
    TextView localTextView3 = (TextView)paramView.findViewById(2131368587);
    TextView localTextView4 = (TextView)paramView.findViewById(2131368590);
    if (localTextView1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = (StructingMsgItemBuilder.ShareInfoHolder)localTextView2.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new StructingMsgItemBuilder.ShareInfoHolder(this);
      }
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).b = localTextView3;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).d = localTextView4;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).c = localTextView5;
      localTextView2.setTag(localObject1);
      localTextView3.setTag(localObject1);
      localTextView5.setTag(localObject1);
      localTextView4.setTag(localObject1);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView5.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView4.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
    } while (paramView == null);
    Object localObject1 = paramView.a(paramChatMessage);
    if (localObject1 != null) {
      if (((TroopTopicDetailInfo)localObject1).mLikeNum > 0)
      {
        localTextView3.setText(((TroopTopicDetailInfo)localObject1).mLikeNum + "");
        localTextView3.setVisibility(0);
        if (!((TroopTopicDetailInfo)localObject1).mIsZan) {
          break label389;
        }
        localObject2 = localTextView2.getContext().getResources().getDrawable(2130841490);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
        localTextView2.setOnClickListener(null);
        localTextView3.setOnClickListener(null);
        label311:
        if (((TroopTopicDetailInfo)localObject1).mCommentNum <= 0) {
          break label453;
        }
        localTextView4.setText(((TroopTopicDetailInfo)localObject1).mCommentNum + "");
        localTextView4.setVisibility(0);
        label352:
        if (((TroopTopicDetailInfo)localObject1).mCommentNum != 0) {
          break label471;
        }
        localTextView1.setVisibility(4);
      }
    }
    for (;;)
    {
      paramView.a(paramChatMessage);
      return;
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      break;
      label389:
      localObject2 = localTextView2.getContext().getResources().getDrawable(2130841489);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      localTextView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView3.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label311;
      label453:
      localTextView4.setText("");
      localTextView4.setVisibility(8);
      break label352;
      label471:
      localTextView1.setVisibility(0);
      localTextView1.setTag(localObject1);
      continue;
      paramView.a(paramChatMessage, true);
      localObject1 = localTextView2.getContext().getResources().getDrawable(2130841489);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      localTextView2.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      localTextView4.setText("");
      localTextView4.setVisibility(8);
      localTextView1.setVisibility(4);
    }
  }
  
  private boolean b(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing.isSendFromLocal()) && (paramMessageForStructing.extraflag == 32772) && (paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramMessageForStructing.structingMsg).isSdkShareMsg()) && (!((AbsShareMsg)paramMessageForStructing.structingMsg).shareData.isFinish());
  }
  
  private static boolean c(ChatMessage paramChatMessage)
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a();
    int i;
    MessageForStructing localMessageForStructing;
    AbsStructMsg localAbsStructMsg;
    Object localObject;
    if (paramView == null)
    {
      i = 1;
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = null;
      if (localMessageForStructing != null) {
        localAbsStructMsg = localMessageForStructing.structingMsg;
      }
      if (!(localMessageForStructing instanceof MessageForTroopTopic)) {
        break label251;
      }
      localObject = (MessageForTroopTopic)localMessageForStructing;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getView. structMr instanceof MessageForTroopTopic");
      }
      if (!((MessageForTroopTopic)localObject).isExpand) {
        break label940;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getView. messageForTroopTopic.isExpand = true");
      }
      localAbsStructMsg = ((MessageForTroopTopic)localObject).detailTopicContent;
    }
    label285:
    label937:
    label940:
    for (;;)
    {
      ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a((MessageRecord)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "exp_talk", 0, 0, "" + ((MessageForTroopTopic)localObject).frienduin, "", "", "");
      for (;;)
      {
        if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)localAbsStructMsg).havaPayInfoInit))
        {
          localObject = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("1"))) {
            ((StructMsgForGeneralShare)localAbsStructMsg).initPay(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
          }
        }
        if (localAbsStructMsg != null) {
          break label285;
        }
        return paramView;
        i = 2;
        break;
        label251:
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "exp");
        }
      }
      localAbsStructMsg.message = localMessageForStructing;
      paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
      int j;
      if (localAbsStructMsg.mMsgServiceID == 76)
      {
        paramInt2 = AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        j = AIOUtils.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView.setPadding(0, 0, 0, 0);
        paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, j, paramInt2, j);
      }
      paramViewGroup = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView.getTag();
      localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      if ((localAbsStructMsg instanceof AbsShareMsg))
      {
        paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
          localAbsStructMsg.addFlag(1);
        }
        paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getResources();
        boolean bool = a(localMessageForStructing);
        if (QLog.isDevelopLevel()) {
          QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
        }
        a(paramViewGroup, (BaseChatItemLayout)localObject, bool);
        a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), localAbsStructMsg, paramOnLongClickAndTouchListener, bool);
        if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsStructMsg).mHasAdSource)) {
          a(paramViewGroup, (BaseChatItemLayout)localObject, localMessageForStructing.isSend(), (StructMsgForGeneralShare)localAbsStructMsg, paramOnLongClickAndTouchListener, bool);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || ((localMessageForStructing instanceof MessageForTroopTopic)) || (localMessageForStructing.structingMsg.mMsgServiceID == 76) || (localMessageForStructing.structingMsg.mMsgServiceID == 21))
        {
          paramInt1 = paramOnLongClickAndTouchListener.getDimensionPixelSize(2131558652);
          j = paramOnLongClickAndTouchListener.getDimensionPixelSize(2131558652);
          if ((!BaseChatItemLayout.jdField_a_of_type_Boolean) || (!bool)) {
            break label937;
          }
          paramInt1 = AIOUtils.a(30.0F, paramOnLongClickAndTouchListener);
          if (((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null)
          {
            localObject = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject).jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
            if (localObject != null) {
              ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(5.0F, paramOnLongClickAndTouchListener);
            }
          }
        }
      }
      for (;;)
      {
        paramOnLongClickAndTouchListener = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).a()).getLayoutParams();
        if (paramOnLongClickAndTouchListener != null)
        {
          if (localMessageForStructing.structingMsg.mMsgServiceID == 21) {
            break label916;
          }
          paramOnLongClickAndTouchListener.setMargins(paramInt1, 0, j, 0);
        }
        for (;;)
        {
          paramView.requestLayout();
          if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
            ThreadManager.post(new vic(this, paramViewGroup), 2, null, false);
          }
          paramOnLongClickAndTouchListener = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
          if (paramOnLongClickAndTouchListener.b(paramChatMessage))
          {
            paramOnLongClickAndTouchListener.a(paramChatMessage.uniseq);
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
            paramChatMessage = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2131034305);
            paramChatMessage.setAnimationListener(new vid(this, paramViewGroup));
            paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new vie(this, paramViewGroup, paramChatMessage), 300L);
          }
          this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a(paramInt2, i);
          return paramView;
          paramInt2 = -1;
          break;
          paramOnLongClickAndTouchListener.setMargins(paramInt1, paramOnLongClickAndTouchListener.topMargin, j, paramOnLongClickAndTouchListener.bottomMargin);
        }
      }
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Bundle localBundle = new Bundle();
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    localBundle.putBoolean("isShowCommentLayout", bool);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {}
    label391:
    label2190:
    label2199:
    label2972:
    for (Object localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();; localObject3 = null)
    {
      Object localObject1;
      int i;
      if (paramView == null)
      {
        paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getResources();
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        ((RelativeLayout)localObject1).setId(2131361877);
        ((RelativeLayout)localObject1).setMinimumHeight(AIOUtils.a(44.0F, paramViewHolder));
        ((RelativeLayout)localObject1).setClickable(true);
        ((RelativeLayout)localObject1).setPadding(paramViewHolder.getDimensionPixelSize(2131558601), paramViewHolder.getDimensionPixelSize(2131558599), paramViewHolder.getDimensionPixelSize(2131558602), paramViewHolder.getDimensionPixelSize(2131558600));
        ((RelativeLayout)localObject1).setBackgroundResource(2130837589);
        paramView = new RelativeLayout.LayoutParams(-2, -2);
        i = paramViewHolder.getDimensionPixelSize(2131558652);
        paramView.setMargins(i, 0, i, 0);
        paramView.addRule(1, 2131362719);
        ((RelativeLayout)localObject1).setLayoutParams(paramView);
        if (MessageForStructing.class.isInstance(paramChatMessage)) {
          break label236;
        }
      }
      label236:
      MessageForStructing localMessageForStructing;
      Object localObject2;
      do
      {
        return localObject1;
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).removeAllViews();
        }
        localObject1 = paramView;
        break;
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        paramViewHolder = localMessageForStructing.structingMsg;
        paramViewHolder.message = localMessageForStructing;
        localObject2 = paramViewHolder;
        if (localMessageForStructing != null)
        {
          localObject2 = paramViewHolder;
          if ((localMessageForStructing instanceof MessageForTroopTopic))
          {
            paramView = (MessageForTroopTopic)localMessageForStructing;
            localObject2 = paramViewHolder;
            if (paramView.isExpand)
            {
              if (QLog.isColorLevel()) {
                QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getBubbleView. messageForTroopTopic.isExpand = true");
              }
              localObject2 = paramView.detailTopicContent;
            }
          }
        }
        if (localObject2 != null) {
          break label391;
        }
      } while (!QLog.isColorLevel());
      paramViewHolder = new StringBuilder().append("structMsg is null,msgdata:");
      if (localMessageForStructing == null) {
        paramChatMessage = "null";
      }
      for (;;)
      {
        QLog.d("structMsg", 2, paramChatMessage);
        return localObject1;
        if (localMessageForStructing.msgData == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
        }
      }
      Object localObject4;
      Object localObject5;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
      {
        if ((localObject2 instanceof StructMsgForGeneralShare))
        {
          paramViewHolder = (StructMsgForGeneralShare)localObject2;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        localBundle.putBoolean("isPublicAccount", true);
        paramViewHolder = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if ((paramViewHolder != null) && (!paramViewHolder.equals("")))
        {
          if (!TextUtils.isEmpty(paramViewHolder)) {
            ((AbsStructMsg)localObject2).templateIDForPortal = paramViewHolder;
          }
          if ((localObject2 instanceof AbsShareMsg))
          {
            paramView = ((AbsShareMsg)localObject2).getStructMsgItemLists();
            if (paramView != null)
            {
              paramView = paramView.iterator();
              while (paramView.hasNext())
              {
                localObject4 = (AbsStructMsgElement)paramView.next();
                if (!TextUtils.isEmpty(paramViewHolder)) {
                  ((AbsStructMsgElement)localObject4).r = paramViewHolder;
                }
                if ((localObject4 instanceof AbsStructMsgItem))
                {
                  localObject4 = (AbsStructMsgItem)localObject4;
                  if (((AbsStructMsgItem)localObject4).a != null)
                  {
                    localObject4 = ((AbsStructMsgItem)localObject4).a.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
                      if (!TextUtils.isEmpty(paramViewHolder)) {
                        ((AbsStructMsgElement)localObject5).r = paramViewHolder;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      ((AbsStructMsg)localObject2).uniseq = localMessageForStructing.uniseq;
      ((AbsStructMsg)localObject2).uin = localMessageForStructing.frienduin;
      ((AbsStructMsg)localObject2).uinType = localMessageForStructing.istroop;
      ((AbsStructMsg)localObject2).currentAccountUin = localMessageForStructing.selfuin;
      ((AbsStructMsg)localObject2).messageVersion = localMessageForStructing.versionCode;
      localBundle.putBoolean("isSend", localMessageForStructing.isSend());
      if (((AbsStructMsg)localObject2).uinType == 1008)
      {
        ((AbsStructMsg)localObject2).sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
        label713:
        localBundle.putInt("accostType", ((AbsStructMsg)localObject2).sourceAccoutType);
        if (((AbsStructMsg)localObject2).mMsgServiceID == 21) {
          localBundle.putInt("serviceID", ((AbsStructMsg)localObject2).mMsgServiceID);
        }
        if (StructMsgForImageShare.class.isInstance(localObject2))
        {
          paramViewHolder = (StructMsgForImageShare)localObject2;
          paramViewHolder.mIsSend = localMessageForStructing.issend;
          paramViewHolder.mUniseq = localMessageForStructing.uniseq;
          paramViewHolder.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramViewHolder = paramBaseChatItemLayout.getTag();
        if (paramViewHolder == null) {
          break label2981;
        }
      }
      label1312:
      label2981:
      for (paramViewHolder = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewHolder;; paramViewHolder = null)
      {
        if (paramViewHolder == null) {}
        for (localObject4 = new StructingMsgItemBuilder.StructingMsgViewHolder();; localObject4 = paramViewHolder) {
          for (;;)
          {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            paramViewHolder = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject5 = paramViewHolder;
            if (paramViewHolder == null)
            {
              localObject5 = (RelativeLayout)localObject1;
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject5);
            }
            if ((localMessageForStructing != null) && ((localMessageForStructing instanceof MessageForTroopTopic)))
            {
              i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
              paramBaseChatItemLayout.setPadding(i, 0, i, 0);
              paramViewHolder = (RelativeLayout.LayoutParams)((RelativeLayout)localObject5).getLayoutParams();
              paramViewHolder.setMargins(0, 0, 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
              ((RelativeLayout)localObject5).setLayoutParams(paramViewHolder);
              ((RelativeLayout)localObject5).setPadding(0, 0, 0, 0);
            }
            ((View)localObject1).setTag(localObject4);
            if (c(paramChatMessage))
            {
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_Boolean = true;
              label966:
              if (!(localObject2 instanceof StructMsgForGeneralShare)) {
                break label2199;
              }
              if (((AbsStructMsg)localObject2).mSType != null) {
                localBundle.putString("sType", ((AbsStructMsg)localObject2).mSType);
              }
              if ((!StructLongMessageDownloadProcessor.b(paramChatMessage)) && (!StructLongMessageDownloadProcessor.d(paramChatMessage))) {}
            }
            try
            {
              for (;;)
              {
                localBundle.putInt("longMsgHolderType", Integer.parseInt(localMessageForStructing.getExtInfoFromExtStr("longMsg_State")));
                String str = ((StructMsgForGeneralShare)localObject2).getLayoutStr();
                if (!a(((AbsStructMsg)localObject2).mMsgServiceID)) {
                  break label2972;
                }
                str = str + localMessageForStructing.issend;
                paramViewHolder = null;
                if (localObject3 != null) {
                  paramViewHolder = ((StructingMsgItemBuilder.ViewCache)localObject3).a(str, (ViewGroup)localObject1);
                }
                if (paramViewHolder != null) {
                  if (((AbsStructMsg)localObject2).mMsgServiceID == 61)
                  {
                    paramViewHolder = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, paramViewHolder, ((View)localObject1).getResources().getString(2131433677));
                    label1129:
                    paramView = paramViewHolder.findViewById(2131368330);
                    if (paramView != null)
                    {
                      localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
                      if ((localObject3 == null) || (!(((ChatFragment)localObject3).a() instanceof MultiForwardChatPie))) {
                        break label2966;
                      }
                      i = 1;
                      if ((!bool) || (i != 0)) {
                        break label2190;
                      }
                      b(paramView, paramChatMessage);
                      paramView.setVisibility(0);
                    }
                    label1193:
                    ((View)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
                    ((View)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
                    if (!(localObject2 instanceof AbsShareMsg)) {
                      break label2526;
                    }
                    paramView = (AbsShareMsg)localObject2;
                    paramOnLongClickAndTouchListener = paramView.getOnClickListener();
                    ((View)localObject1).setOnClickListener(new vih(this, paramView, localMessageForStructing, paramChatMessage, paramChatMessage.time, paramOnLongClickAndTouchListener));
                    if (!StructMsgForImageShare.class.isInstance(localObject2)) {
                      break label2419;
                    }
                    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                    label1274:
                    if (b(localMessageForStructing)) {
                      FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                    }
                    if (((AbsStructMsg)localObject2).mMsgServiceID != 70) {
                      break label2449;
                    }
                    ((View)localObject1).setOnClickListener(null);
                    if ((((AbsStructMsg)localObject2).mMsgServiceID == 76) || (((AbsStructMsg)localObject2).mMsgServiceID == 106))
                    {
                      ((View)localObject1).setOnClickListener(null);
                      if (((AbsStructMsg)localObject2).mMsgServiceID != 106)
                      {
                        ((View)localObject1).setOnLongClickListener(null);
                        ((View)localObject1).setOnTouchListener(null);
                      }
                    }
                    if (((AbsStructMsg)localObject2).mMsgServiceID == 79)
                    {
                      ((View)localObject1).setOnClickListener(null);
                      ((View)localObject1).setOnClickListener(new vhi(this, paramView));
                    }
                    if (((AbsStructMsg)localObject2).mMsgServiceID != 81) {}
                  }
                }
                try
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      ((RelativeLayout)localObject5).addView(paramViewHolder);
                      if (((AbsStructMsg)localObject2).mMsgServiceID == 38)
                      {
                        paramViewHolder = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
                        if (paramViewHolder != null)
                        {
                          if (!paramViewHolder.b(paramChatMessage.time)) {
                            break label2603;
                          }
                          paramViewHolder = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                          paramViewHolder.setId(2131361875);
                          paramViewHolder.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838596));
                          i = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                          new RelativeLayout.LayoutParams(-2, -2);
                          paramView = new RelativeLayout.LayoutParams(i, i);
                          paramView.addRule(13, 2131361877);
                          ((RelativeLayout)localObject5).addView(paramViewHolder, paramView);
                          e();
                        }
                      }
                      if ((localObject2 instanceof StructMsgForImageShare))
                      {
                        if (localMessageForStructing.isSendFromLocal())
                        {
                          paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
                          ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject5);
                          a(paramViewHolder, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject4);
                        }
                        paramViewHolder = ((StructMsgForImageShare)localObject2).getFirstImageElement();
                        if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                        }
                      }
                      if (((AbsStructMsg)localObject2).adverSign != 1) {
                        break label2633;
                      }
                      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                      paramView.setImageResource(2130839663);
                      paramViewHolder.setBackgroundColor(0);
                      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                      paramOnLongClickAndTouchListener.addRule(11);
                      paramOnLongClickAndTouchListener.addRule(10);
                      paramViewHolder.setLayoutParams(paramOnLongClickAndTouchListener);
                      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
                      paramOnLongClickAndTouchListener.addRule(11);
                      paramOnLongClickAndTouchListener.addRule(10);
                      paramOnLongClickAndTouchListener.setMargins(0, 12, 12, 0);
                      paramView.setLayoutParams(paramOnLongClickAndTouchListener);
                      paramViewHolder.addView(paramView);
                      if ((localObject1 instanceof RelativeLayout)) {
                        ((RelativeLayout)localObject1).addView(paramViewHolder);
                      }
                      paramOnLongClickAndTouchListener = localMessageForStructing.frienduin;
                      l = ((AbsStructMsg)localObject2).msgId;
                      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                        paramViewHolder.setOnClickListener(new vhj(this, paramView, paramChatMessage, paramOnLongClickAndTouchListener, l));
                      }
                      if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())) {
                        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
                      }
                      if ((paramBaseChatItemLayout == null) || (HotChatUtil.a(localMessageForStructing))) {
                        break;
                      }
                      paramViewHolder = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131361945);
                      if (paramViewHolder != null) {
                        break label2880;
                      }
                      paramViewHolder = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                      paramView = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                      paramView.addRule(8, 2131361877);
                      paramView.addRule(1, 2131361877);
                      paramView.bottomMargin = (BaseChatItemLayout.h - AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                      paramViewHolder.setId(2131361945);
                      paramBaseChatItemLayout.addView(paramViewHolder, paramView);
                      if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage))) {
                        break label2888;
                      }
                      i = 1;
                      if ((!paramChatMessage.isDui) || (i != 0)) {
                        break label2949;
                      }
                      if (!paramChatMessage.isSend()) {
                        break label2894;
                      }
                      paramViewHolder.setVisibility(8);
                      return localObject1;
                      paramViewHolder = localMessageForStructing.getExtInfoFromExtStr("accostType");
                      if ((paramViewHolder == null) || (paramViewHolder.equals(""))) {
                        break label713;
                      }
                      try
                      {
                        ((AbsStructMsg)localObject2).sourceAccoutType = Integer.parseInt(paramViewHolder);
                      }
                      catch (Exception paramViewHolder) {}
                    }
                    break label713;
                    ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_Boolean = false;
                    break label966;
                    paramViewHolder = ((AbsStructMsg)localObject2).getView(this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramOnLongClickAndTouchListener, localBundle);
                    break label1129;
                    if (((AbsStructMsg)localObject2).mMsgServiceID == 61) {}
                    for (paramView = AbsStructMsg.getInCompatibleView(this.jdField_a_of_type_AndroidContentContext, null, ((View)localObject1).getResources().getString(2131433677));; paramView = ((AbsStructMsg)localObject2).getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener, localBundle))
                    {
                      paramViewHolder = paramView;
                      if (localObject3 == null) {
                        break;
                      }
                      ((StructingMsgItemBuilder.ViewCache)localObject3).a(str, paramView, (ViewGroup)localObject1);
                      paramViewHolder = paramView;
                      break;
                    }
                    paramView.setVisibility(8);
                    break label1193;
                    if (((RelativeLayout)localObject5).getChildCount() > 0)
                    {
                      paramViewHolder = ((RelativeLayout)localObject5).getChildAt(0);
                      if (paramViewHolder != null)
                      {
                        paramViewHolder = paramViewHolder.getTag(2131361855);
                        if (QLog.isColorLevel()) {
                          QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + paramViewHolder);
                        }
                        if ((paramViewHolder == null) || (paramViewHolder.getClass() == localObject2.getClass())) {}
                      }
                    }
                    ((RelativeLayout)localObject5).removeAllViews();
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (((AbsStructMsg)localObject2).mMsgServiceID == 120) && ((localObject2 instanceof StructMsgForHypertext)))
                    {
                      paramViewHolder = paramChatMessage.getExtInfoFromExtStr("qidian_hypertext_click_state");
                      if ((TextUtils.isEmpty(paramViewHolder)) || (!paramViewHolder.equals("1"))) {
                        break label2398;
                      }
                      localBundle.putInt("qidian_hypertext_click_state", 1);
                    }
                    for (;;)
                    {
                      paramViewHolder = ((AbsStructMsg)localObject2).getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener, localBundle);
                      paramView = paramViewHolder.findViewById(2131368330);
                      if (paramView == null) {
                        break label2416;
                      }
                      if (!bool) {
                        break label2410;
                      }
                      b(paramView, paramChatMessage);
                      paramView.setVisibility(0);
                      break;
                      label2398:
                      localBundle.putInt("qidian_hypertext_click_state", 0);
                    }
                    label2410:
                    paramView.setVisibility(8);
                    label2416:
                    break label1193;
                    label2419:
                    if ((!StructMsgForGeneralShare.class.isInstance(localObject2)) || (!a((AbsStructMsg)localObject2))) {
                      break label1274;
                    }
                    a(paramBaseChatItemLayout, localMessageForStructing);
                    break label1274;
                    if (PAVideoStructMsgUtil.a((AbsStructMsg)localObject2))
                    {
                      ((View)localObject1).setOnClickListener(null);
                      break label1312;
                    }
                    if (((AbsStructMsg)localObject2).mMsgServiceID != 78) {
                      break label1312;
                    }
                    paramOnLongClickAndTouchListener = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
                    localObject3 = (AbsShareMsg)localObject2;
                    if (!(paramOnLongClickAndTouchListener instanceof PublicAccountChatPie)) {
                      break label1312;
                    }
                    ((View)localObject1).setOnClickListener(new vii(this, paramOnLongClickAndTouchListener, (AbsShareMsg)localObject3));
                    break label1312;
                    label2526:
                    if ((((AbsStructMsg)localObject2).mMsgServiceID == 3) || (((AbsStructMsg)localObject2).mMsgServiceID == 120)) {
                      if (a()) {
                        ((View)localObject1).setClickable(false);
                      } else {
                        ((View)localObject1).setClickable(true);
                      }
                    }
                  }
                }
                catch (IllegalStateException paramView)
                {
                  for (;;)
                  {
                    long l;
                    paramView = paramViewHolder.getParent();
                    if ((paramView != null) && ((paramView instanceof ViewGroup))) {
                      ((ViewGroup)paramView).removeAllViews();
                    }
                    ((RelativeLayout)localObject5).addView(paramViewHolder);
                    continue;
                    label2603:
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                    {
                      paramViewHolder = paramViewHolder.a();
                      label2880:
                      label2888:
                      if (paramViewHolder != null)
                      {
                        a(paramViewHolder.a);
                        continue;
                        label2633:
                        if (((AbsStructMsg)localObject2).adverSign == 2)
                        {
                          paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                          paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                          paramView.setBackgroundResource(2130839747);
                          paramView.setGravity(17);
                          i = ((AbsStructMsg)localObject2).adverSign;
                          paramView.setText("退订");
                          paramView.setTextColor(-1);
                          paramView.setTextSize(13.0F);
                          paramViewHolder.setBackgroundColor(0);
                          paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramOnLongClickAndTouchListener.addRule(11);
                          paramOnLongClickAndTouchListener.addRule(10);
                          paramViewHolder.setLayoutParams(paramOnLongClickAndTouchListener);
                          paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
                          paramOnLongClickAndTouchListener.addRule(11);
                          paramOnLongClickAndTouchListener.addRule(10);
                          paramView.setLayoutParams(paramOnLongClickAndTouchListener);
                          paramViewHolder.addView(paramView);
                          if ((localObject1 instanceof RelativeLayout)) {
                            ((RelativeLayout)localObject1).addView(paramViewHolder);
                          }
                          paramOnLongClickAndTouchListener = localMessageForStructing.frienduin;
                          l = ((AbsStructMsg)localObject2).msgId;
                          paramOnLongClickAndTouchListener = localMessageForStructing.getExtInfoFromExtStr("msg_template_id");
                          i = localMessageForStructing.istroop;
                          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                          {
                            paramViewHolder.setOnClickListener(new vhk(this, paramView, paramChatMessage, paramOnLongClickAndTouchListener));
                            continue;
                            paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                            continue;
                            i = 0;
                          }
                        }
                      }
                    }
                  }
                  label2894:
                  if (!paramChatMessage.hasPlayedDui) {
                    paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramViewHolder);
                  }
                  while (DuiButtonImageView.jdField_a_of_type_Boolean)
                  {
                    paramViewHolder.setOnClickListener(this);
                    paramViewHolder.setVisibility(0);
                    return localObject1;
                    paramViewHolder.f();
                  }
                  paramViewHolder.setOnClickListener(null);
                  paramViewHolder.setVisibility(8);
                  return localObject1;
                }
              }
              paramViewHolder.setVisibility(8);
              paramViewHolder.e();
              return localObject1;
            }
            catch (Exception paramViewHolder)
            {
              for (;;)
              {
                continue;
                i = 0;
              }
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
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 5)) {
          return (BaseBubbleBuilder.TouchDelegate)paramView.findViewById(2131361924);
        }
      } while ((((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 107));
      Object localObject = paramView.findViewById(2131361955);
      if (localObject != null) {
        return (BaseBubbleBuilder.TouchDelegate)((View)localObject).getTag(-1);
      }
      paramView = "getTouchDelegate when receipt message but the root view is null \r\n" + paramView;
      QQCatchedExceptionReporter.reportQQCatchedException(new IllegalStateException(paramView), "StructingMsgItemBuilder", paramView);
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MsgUtils.a(paramChatMessage.issend)) {
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
  
  public void a()
  {
    super.a();
    if (StructMsgForGeneralShare.receiptServer != null) {
      QIPCServerHelper.getInstance().getServer().unRegisterModule(StructMsgForGeneralShare.receiptServer);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject5 = AIOGallerySceneWithBusiness.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131361852) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext.structingMsg == null) || (!(paramContext.structingMsg instanceof StructMsgForImageShare))) {
          break label131;
        }
        paramContext = (StructMsgForImageShare)paramContext.structingMsg;
        paramChatMessage = paramContext.getFirstImageElement();
        if (paramChatMessage == null) {
          break label131;
        }
        paramChatMessage = paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject1 = URLDrawableHelper.a(paramChatMessage, 1);
        if (localObject1 != null) {
          break label81;
        }
      }
    }
    label81:
    Object localObject2;
    label131:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = URLDrawable.getDrawable((URL)localObject1, -1, -1, null, null, false);
                ((URLDrawable)localObject1).setTag(paramChatMessage);
                AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448), paramContext, null);
              } while (!AIOGallerySceneWithBusiness.a((String)localObject5));
              VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "1", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
              return;
              if (paramInt != 2131363517) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "structingMsgItem forward");
              }
            } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
            paramChatMessage = (MessageForStructing)paramChatMessage;
          } while (paramChatMessage.structingMsg == null);
          if (!(paramChatMessage.structingMsg instanceof StructMsgForImageShare)) {
            break;
          }
        } while (!((StructMsgForImageShare)paramChatMessage.structingMsg).checkImageSharePic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
        for (;;)
        {
          paramContext = new Bundle();
          if ((paramChatMessage.structingMsg.source_puin != null) && (!"".equals(paramChatMessage.structingMsg.source_puin))) {
            paramContext.putString("source_puin", paramChatMessage.structingMsg.source_puin);
          }
          paramContext.putInt("forward_type", -3);
          paramChatMessage.structingMsg.mCommentText = null;
          paramContext.putInt("structmsg_service_id", paramChatMessage.structingMsg.mMsgServiceID);
          paramContext.putByteArray("stuctmsg_bytes", paramChatMessage.structingMsg.getBytes());
          paramContext.putLong("structmsg_uniseq", paramChatMessage.uniseq);
          paramContext.putInt("accostType", paramChatMessage.structingMsg.sourceAccoutType);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(paramContext);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
          paramContext = paramChatMessage.structingMsg.mMsgUrl;
          localObject1 = paramChatMessage.senderuin;
          localObject2 = Long.toString(paramChatMessage.structingMsg.msgId);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject1, paramContext, (String)localObject2, "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramChatMessage.structingMsg.mMsgServiceID == 84) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
          }
          if (!AIOGallerySceneWithBusiness.a((String)localObject5)) {
            break;
          }
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "2", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
          return;
          if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 35))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131558448);
              QQToast.a(paramContext, "含有未下载的内容，请查看后再转发", 0).b(paramInt);
              return;
            }
            if (MultiMsgManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.uniseq)) {
              DialogUtil.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", "取消", "继续", new vhh(this, paramChatMessage), new vhv(this)).show();
            }
          }
          else if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 81))
          {
            StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "forward");
          }
        }
        if (paramInt != 2131375567) {
          break;
        }
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "5", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131375577)
    {
      super.c(paramChatMessage);
      if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "6", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramContext = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        l2 = 0L;
        l1 = l2;
        if (paramChatMessage == null) {
          break label3077;
        }
        l1 = l2;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label3077;
        }
        localObject1 = (MessageForStructing)paramChatMessage;
        l1 = l2;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label3077;
        }
        l1 = l2;
        if (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)) {
          break label3077;
        }
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        l2 = ((AbsShareMsg)localObject1).msgId;
        l1 = l2;
        if (!(localObject1 instanceof StructMsgForGeneralShare)) {
          break label3077;
        }
        localObject1 = (StructMsgForGeneralShare)localObject1;
        paramInt = StructMsgForGeneralShare.clickedItemIndex;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      AbsShareMsg localAbsShareMsg;
      int i;
      if (paramInt == 2131366776)
      {
        if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
          break;
        }
        paramContext = (MessageForStructing)paramChatMessage;
        if (paramContext.structingMsg == null) {
          break;
        }
        localAbsShareMsg = (AbsShareMsg)paramContext.structingMsg;
        if ((localAbsShareMsg instanceof StructMsgForImageShare))
        {
          i = 0;
          if (AIOGallerySceneWithBusiness.a((String)localObject5))
          {
            localObject1 = localAbsShareMsg.mMsgActionData.substring(localAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
            paramInt = i;
            if (localObject1.length < 8) {
              break label3072;
            }
            if (!localObject1[7].equals("link"))
            {
              paramInt = i;
              if (!localObject1[7].equals("scrawl_link")) {
                break label3072;
              }
            }
            i = 1;
            paramInt = i;
            if (!localObject1[7].equals("scrawl_link")) {
              break label3072;
            }
            paramInt = i;
            if (localObject1.length <= 8) {
              break label3072;
            }
            paramContext = localObject1[8];
            paramInt = 1;
          }
        }
      }
      label3072:
      for (;;)
      {
        if ((paramInt == 0) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
        {
          localObject1 = localAbsShareMsg.mMsg_A_ActionData.split("\\|");
          if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
            paramInt = 1;
          }
        }
        label1423:
        label2515:
        for (;;)
        {
          Object localObject4;
          Object localObject3;
          if (paramInt != 0)
          {
            localObject2 = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
            if (localObject2 == null) {
              break label3063;
            }
            if (((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject4 = AIOGalleryUtils.a(((StructMsgItemImage)localObject2).a());
            localObject3 = ((AIOImageData)localObject4).a(4);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = ((AIOImageData)localObject4).a(2);
            }
            if (localObject2 == null) {
              break label3063;
            }
          }
          label2268:
          label3041:
          label3061:
          label3063:
          for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
          {
            Object localObject6 = localObject1[3] + "第" + localObject1[5] + "页";
            localObject4 = "ADTAG=comic.plugin.read&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject3 = localObject4;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject3 = (String)localObject4 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            paramContext = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject3);
            new QfavBuilder(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", paramContext).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject6).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "3", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
            int j = 0;
            i = paramInt;
            paramInt = j;
            for (;;)
            {
              if ((i != 0) || (paramInt != 0)) {
                break label3061;
              }
              paramContext = QfavUtil.a((StructMsgForImageShare)localAbsShareMsg);
              if (paramContext == null) {
                break;
              }
              QfavBuilder.a(paramContext.w, localAbsShareMsg.uinType, paramContext.v, paramContext.c, paramContext.u, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
              return;
              paramInt = 0;
              break label1423;
              if (AIOGallerySceneWithBusiness.b((String)localObject5))
              {
                paramContext = AIOGallerySceneWithBusiness.b((String)localObject5);
                if ((paramContext != null) && (paramContext.length > 2))
                {
                  localObject2 = paramContext[1];
                  paramContext = paramContext[2];
                  paramContext = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
                  if (paramContext != null)
                  {
                    if (paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                      paramContext.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
                    }
                    localObject3 = AIOGalleryUtils.a(paramContext.a());
                    localObject1 = ((AIOImageData)localObject3).a(4);
                    paramContext = (Context)localObject1;
                    if (localObject1 == null) {
                      paramContext = ((AIOImageData)localObject3).a(2);
                    }
                    if (paramContext != null) {
                      paramContext.getAbsolutePath();
                    }
                  }
                  paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                  QfavBuilder.a((String)localObject2).c(paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext);
                  QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
                  paramInt = 1;
                  i = 0;
                  continue;
                  if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
                  {
                    String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
                    i = arrayOfString1.length;
                    localObject3 = null;
                    localObject2 = null;
                    localObject1 = null;
                    paramContext = null;
                    paramInt = 0;
                    if (paramInt < i)
                    {
                      String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
                      localObject4 = localObject3;
                      localObject5 = localObject2;
                      localObject6 = localObject1;
                      Object localObject7 = paramContext;
                      if (arrayOfString2.length > 1)
                      {
                        if (!arrayOfString2[0].trim().equals("lat")) {
                          break label2268;
                        }
                        localObject7 = arrayOfString2[1];
                        localObject6 = localObject1;
                        localObject5 = localObject2;
                        localObject4 = localObject3;
                      }
                      for (;;)
                      {
                        paramInt += 1;
                        localObject3 = localObject4;
                        localObject2 = localObject5;
                        localObject1 = localObject6;
                        paramContext = (Context)localObject7;
                        break;
                        if (arrayOfString2[0].trim().equals("lon"))
                        {
                          localObject6 = arrayOfString2[1];
                          localObject4 = localObject3;
                          localObject5 = localObject2;
                          localObject7 = paramContext;
                        }
                        else if (arrayOfString2[0].trim().equals("loc"))
                        {
                          localObject5 = arrayOfString2[1];
                          localObject4 = localObject3;
                          localObject6 = localObject1;
                          localObject7 = paramContext;
                        }
                        else
                        {
                          localObject4 = localObject3;
                          localObject5 = localObject2;
                          localObject6 = localObject1;
                          localObject7 = paramContext;
                          if (arrayOfString2[0].trim().equals("title"))
                          {
                            localObject4 = arrayOfString2[1];
                            localObject5 = localObject2;
                            localObject6 = localObject1;
                            localObject7 = paramContext;
                          }
                        }
                      }
                    }
                    if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                    {
                      QfavBuilder.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject3, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                      return;
                    }
                  }
                  localObject2 = QfavUtil.a(localAbsShareMsg.getXmlBytes());
                  paramContext = localAbsShareMsg.mContentCover;
                  if ((localAbsShareMsg instanceof StructMsgForAudioShare))
                  {
                    paramInt = 2;
                    i = 10;
                  }
                  for (;;)
                  {
                    QfavBuilder.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject2, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
                    return;
                    if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
                    {
                      localObject3 = (StructMsgForGeneralShare)localAbsShareMsg;
                      paramInt = 0;
                      if (paramInt < ((StructMsgForGeneralShare)localObject3).getItemCount())
                      {
                        localObject1 = ((StructMsgForGeneralShare)localObject3).getItemByIndex(paramInt);
                        if ((localObject1 instanceof StructMsgItemLayout5))
                        {
                          localObject4 = ((StructMsgItemLayout5)localObject1).a.iterator();
                          do
                          {
                            localObject1 = paramContext;
                            if (!((Iterator)localObject4).hasNext()) {
                              break;
                            }
                            localObject1 = (AbsStructMsgElement)((Iterator)localObject4).next();
                          } while (!(localObject1 instanceof StructMsgItemVideo));
                          localObject4 = (StructMsgItemVideo)localObject1;
                          paramContext = ((StructMsgItemVideo)localObject4).u;
                          localObject1 = paramContext;
                          if (!((StructMsgItemVideo)localObject4).a()) {
                            break label3041;
                          }
                          VideoReporter.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, VideoReporter.a(((StructMsgItemVideo)localObject4).k, ((StructMsgForGeneralShare)localObject3).mSourceName), ((StructMsgItemVideo)localObject4).w, "");
                        }
                        for (;;)
                        {
                          i = 2;
                          paramInt = 0;
                          break label2515;
                          paramInt += 1;
                          break label2615;
                          if (paramInt == 2131375573)
                          {
                            paramContext = (MessageForStructing)paramChatMessage;
                            if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                              break;
                            }
                            ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                            return;
                          }
                          if (paramInt == 2131375576)
                          {
                            c(paramChatMessage);
                            return;
                          }
                          if (paramInt == 2131375578)
                          {
                            ThreadManager.post(new vib(this, paramChatMessage, paramContext), 8, null, false);
                            return;
                          }
                          if (paramInt == 2131361906)
                          {
                            super.a(paramChatMessage);
                            if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
                              VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "4", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
                            }
                            if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                              break;
                            }
                            paramContext = (MessageForStructing)paramChatMessage;
                            if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                              break;
                            }
                            StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                            return;
                          }
                          if (paramInt == 2131375569)
                          {
                            paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
                            if ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor))) {
                              break;
                            }
                            ((BaseTransProcessor)paramContext).a();
                            return;
                          }
                          super.a(paramInt, paramContext, paramChatMessage);
                          return;
                          paramContext = (Context)localObject1;
                        }
                      }
                    }
                    i = 2;
                    paramInt = 0;
                  }
                }
              }
              paramInt = 0;
              i = 0;
            }
            break;
          }
        }
        label2615:
        paramContext = null;
      }
      label3077:
      paramInt = 0;
      l2 = l1;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    Object localObject1;
    Context localContext;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = AIOUtils.a(paramView);
      } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject1));
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject2 = a((ChatMessage)localObject1);
      if (localObject2 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject2);
        return;
      }
      paramView = localContext.getString(2131433635);
      localObject2 = localContext.getString(2131433636);
    } while (!((ChatMessage)localObject1).isSendFromLocal());
    DialogUtil.a(localContext, 230, paramView, (String)localObject2, new vhz(this, (ChatMessage)localObject1, localContext), new via(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    MessageForStructing localMessageForStructing;
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramChatMessage;
      boolean bool = PAVideoStructMsgUtil.a(localMessageForStructing.structingMsg);
      if (((bool) && (!localMessageForStructing.structingMsg.hasFlag(4))) || (localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108))
      {
        if ((!bool) || (localMessageForStructing.structingMsg.hasFlag(4))) {
          break label173;
        }
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558619);
        if (!paramChatMessage.isSend()) {
          break label233;
        }
        paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
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
      label173:
      if ((localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558621);
        break;
      }
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558617);
      break;
      label233:
      paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    do
    {
      return;
      if ((paramFileMsg.jdField_b_of_type_Int == 1) || (paramFileMsg.jdField_b_of_type_Int == 131075))
      {
        b(paramView, paramFileMsg, paramInt1, paramInt2);
        return;
      }
    } while (paramFileMsg.jdField_b_of_type_Int != 52);
    c(paramView, paramFileMsg, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if ((!(paramChatMessage instanceof MessageForStructing)) || (((MessageForStructing)paramChatMessage).structingMsg == null)) {}
    do
    {
      return;
      paramContext = (MessageForStructing)paramChatMessage;
      paramInt1 = paramContext.structingMsg.mMsgServiceID;
    } while ((a(paramContext)) || (paramInt1 == 83) || (paramInt1 == 108) || (paramInt1 == 114) || (paramInt1 == 98) || (paramInt1 == 97) || (paramInt1 == 5) || (paramInt1 == 106) || (paramInt1 == 107) || (paramInt1 == 122) || (paramInt1 == 116));
    paramInt1 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    if (paramChatMessage.isSend()) {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845789);
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setPadding(paramInt1, i, paramInt2, j);
      return;
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845625);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((BaseChatItemLayout.jdField_a_of_type_Boolean) && (paramChatMessage.isSendFromLocal()) && ((paramChatMessage instanceof MessageForStructing)))
    {
      AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768)))
      {
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)) {
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
        return;
      }
    }
    super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
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
              paramView = (ImageView)((StructMsgItemPAAudio.ViewHolder)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130839777);
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
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    String str1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
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
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {
      bool = false;
    }
    do
    {
      Object localObject;
      do
      {
        return bool;
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg == null) || (!StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) || (!paramChatMessage.isSendFromLocal())) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
        if (!(localObject instanceof MessageForStructing)) {
          break label219;
        }
        localObject = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {
          break label219;
        }
        localObject = ((StructMsgForImageShare)localObject).getFirstImageElement();
        if ((localObject == null) || (((StructMsgItemImage)localObject).d > 0L)) {
          break label219;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      } while (!(paramChatMessage instanceof BaseTransProcessor));
      if (((BaseTransProcessor)paramChatMessage).c() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      if ((!b((MessageForStructing)localObject)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).uniseq) != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructingMsgItemBuilder", 2, "isFailed| Sdk share msg, processor not exist.");
    return true;
    label219:
    return super.a(paramChatMessage, paramBaseChatItemLayout);
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
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    Object localObject = AIOUtils.a(paramView);
    if ((localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if (((((ViewGroup)localObject).getChildAt(i).getTag() instanceof StructMsgItemLayout10.ViewHolder)) && (a(paramXListView, paramInt, paramView, paramChatMessage)))
          {
            StructMsgItemLayout10.ViewHolder localViewHolder = (StructMsgItemLayout10.ViewHolder)((ViewGroup)localObject).getChildAt(i).getTag();
            if ((localViewHolder.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)) {
              paramAudioPlayer.a(((StructMsgItemPAAudio.ViewHolder)localViewHolder.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        }
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 86)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 70)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 91)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 97)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 98)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
      }
      if ((localMessageForStructing.isSendFromLocal()) && ((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).isSdkShareMsg()) && ((localMessageForStructing.extraflag == 32772) || (localMessageForStructing.extraflag == 32768)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq) != null) {
          localQQCustomMenu.a(2131375569, this.jdField_a_of_type_AndroidContentContext.getString(2131433639), 2130838303);
        }
        for (;;)
        {
          return localQQCustomMenu.a();
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (localStructMsgItemImage == null) {
          break label1292;
        }
        paramView = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (paramView != null) {
          break label1289;
        }
        if (localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsStructMsg);
          localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = localMessageForStructing;
        }
        localStructMsgItemImage.a(this.jdField_a_of_type_AndroidContentContext, null, null);
        paramView = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    for (;;)
    {
      int i;
      if ((paramView != null) && (URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView, 65537)))
      {
        i = 1;
        if ((paramView == null) || (paramView.imageType != 2000)) {
          break label588;
        }
      }
      label588:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label593;
        }
        return localQQCustomMenu.a();
        i = 0;
        break;
      }
      label593:
      localQQCustomMenu.a(2131361852, this.jdField_a_of_type_AndroidContentContext.getString(2131435873), 2130838311);
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          localQQCustomMenu.a(2131375573, paramView.getString(2131437014), 2130838306);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            localQQCustomMenu.a(2131375578, paramView.getString(2131435083), 2130838313);
            if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing)) {
              a(localMessageForStructing, localQQCustomMenu);
            }
            if ((!localAbsStructMsg.hasFlag(2)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (!TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) && (localAbsStructMsg.mMsgServiceID != 81)) {
              break label1245;
            }
          }
        }
      }
      for (;;)
      {
        if ((localMessageForStructing.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForStructing)))
        {
          j = 1;
          i = j;
          if (localMessageForStructing.istroop == 1)
          {
            i = j;
            if (localAbsStructMsg != null) {
              if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!"群问问".equals(localAbsStructMsg.getSourceName())))
              {
                i = j;
                if (localAbsStructMsg.mMsgUrl != null)
                {
                  i = j;
                  if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity")) {}
                }
              }
              else
              {
                i = 0;
              }
            }
          }
          if (((1008 != localMessageForStructing.istroop) || (!AppConstants.t.equals(localMessageForStructing.frienduin))) && ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("http://ti.qq.com/remind/view.html"))))
          {
            j = i;
            if (localAbsStructMsg != null)
            {
              j = i;
              if (localAbsStructMsg.mMsgUrl != null)
              {
                j = i;
                if (!localAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
              }
            }
          }
          else
          {
            j = 0;
          }
          i = j;
          if (localAbsStructMsg != null)
          {
            i = j;
            if (localAbsStructMsg.mMsgServiceID == 49) {
              i = 0;
            }
          }
          if (i != 0) {
            a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForStructing);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (localQQCustomMenu.a() == 0)) {
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106)) {
          super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        }
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "press");
        }
        return localQQCustomMenu.a();
        if (localAbsStructMsg.hasFlag(1)) {
          break;
        }
        localQQCustomMenu.a(2131363517, paramView.getString(2131435083), 2130838313);
        break;
        if (!localAbsStructMsg.hasFlag(1))
        {
          localQQCustomMenu.a(2131363517, paramView.getString(2131435083), 2130838313);
          break;
        }
        if (localAbsStructMsg.mMsgServiceID != 35) {
          break;
        }
        localQQCustomMenu.a(2131363517, paramView.getString(2131435083), 2130838313);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
        break;
        label1245:
        localQQCustomMenu.a(2131366776, paramView.getString(2131431563), 2130838312);
        continue;
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing)) {
          a(localMessageForStructing, localQQCustomMenu);
        }
      }
      label1289:
      continue;
      label1292:
      paramView = null;
    }
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
      if ((localChatMessage.uniseq == paramFileMsg.jdField_b_of_type_Long) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.jdField_b_of_type_Long);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          b();
        }
      }
    } while ((localChatMessage.uniseq != paramFileMsg.jdField_b_of_type_Long) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
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
      } while ((paramView.uniseq != paramFileMsg.jdField_b_of_type_Long) || (!paramView.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + paramView.uniseq + ", file.uniseq = " + paramFileMsg.jdField_b_of_type_Long);
      }
    } while ((paramInt1 != 1005) && (paramInt1 != 1001) && (paramInt1 != 1003) && (paramInt1 != 1004) && (paramInt1 != 1002));
    b();
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).a(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.c(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected void e()
  {
    long l1 = 1L;
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 0L) && (localVipGiftDownloadInfo.a != 0L)) {
      localVipGiftManager.a(localVipGiftDownloadInfo.a);
    }
    long l2;
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 1L))
    {
      l2 = localVipGiftManager.a - (NetConnInfoCenter.getServerTimeMillis() - localVipGiftDownloadInfo.e);
      if (l2 > 0L) {
        break label127;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new vif(this, localVipGiftDownloadInfo, localVipGiftManager), l1);
      return;
      label127:
      l1 = l2;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131361945)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] Dui Button Clicked.");
      }
      Object localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject1 == null) {
        break label206;
      }
      BaseChatPie localBaseChatPie = ((ChatFragment)localObject1).a();
      if (localBaseChatPie == null) {
        break label187;
      }
      Object localObject2 = null;
      Object localObject3 = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((MessageForStructing)localObject3).structingMsg != null)
        {
          localObject1 = localObject2;
          if ((((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))
          {
            localObject3 = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)localObject3).getFirstImageElement();
            localObject1 = localObject2;
            if (localStructMsgItemImage != null) {
              localObject1 = new DoutuItem(localStructMsgItemImage.v, localStructMsgItemImage.w, localStructMsgItemImage.c, ((StructMsgForImageShare)localObject3).rawUrl);
            }
          }
        }
      }
      localBaseChatPie.a().obtainMessage(79, localObject1).sendToTarget();
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      label187:
      if (QLog.isColorLevel())
      {
        QLog.d("StructingMsgItemBuilder", 2, "[Doutu] curPie is null.");
        continue;
        label206:
        if (QLog.isColorLevel()) {
          QLog.d("StructingMsgItemBuilder", 2, "[Doutu] chatFragment is null.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */