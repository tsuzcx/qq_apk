package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakUtils;
import java.net.URL;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PicItemBuilder
  extends BasePicItemBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener
{
  public static boolean B = false;
  public static boolean C = false;
  public static int D = 100;
  public static long E = 1000L;
  public static float F = 0.3F;
  public static float G = 1.0F;
  private long H;
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    return a(paramContext, paramMessageForPic, paramChatThumbView, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    h();
    return a(paramContext, paramMessageForPic, paramChatThumbView, paramArrayOfInt, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if ("2854196312".equals(paramString1))
      {
        if (paramInt != -2)
        {
          if (paramInt != 0) {
            if (paramInt != 1) {
              if (paramInt != 3000) {
                paramString1 = "other";
              }
            }
          }
          for (;;)
          {
            break;
            paramString1 = "discuss";
            continue;
            paramString1 = "group";
            continue;
            paramString1 = "c2c";
          }
        }
        paramString1 = "";
        String str;
        if (paramQQAppInterface.getCurrentUin() != null) {
          str = paramQQAppInterface.getCurrentUin();
        } else {
          str = "";
        }
        if (paramString4 == null) {
          paramString4 = "";
        }
        if (paramString2 == null) {
          paramString2 = "";
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString3, paramString3, 0, 0, str, paramString4, paramString1, paramString2);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(PeakUtils.b, paramBoolean3);
    if (a(paramContext, paramSessionInfo))
    {
      Object localObject = ((BaseActivity)paramContext).getChatFragment();
      if (localObject == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
      else
      {
        localObject = ((ChatFragment)localObject).k();
        if (localObject == null)
        {
          QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        }
        else
        {
          int i = ((BaseChatPie)localObject).aR();
          localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
          if (i == 1)
          {
            localObject = (InputMethodManager)paramContext.getSystemService("input_method");
            if (localObject != null) {
              ((InputMethodManager)localObject).toggleSoftInput(1, 0);
            }
          }
        }
      }
    }
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    }
    paramMessageForReplyText = (IOCRService)paramQQAppInterface.getRuntimeService(IOCRService.class, "");
    paramBoolean2 = paramMessageForReplyText.isSupportOcr(paramQQAppInterface.getCurrentAccountUin(), 1);
    localBundle.putBoolean("extra.OCR", paramBoolean2);
    if (paramBoolean2)
    {
      paramMessageForReplyText = paramMessageForReplyText.getAIOText(paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramMessageForReplyText)) {
        localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
      }
    }
    BasePicItemBuilder.a(paramQQAppInterface, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean1, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, -2, paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BasePicItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (this.d != null) && (paramChatMessage != null))
    {
      paramHolder.f = super.a(paramHolder.f, paramHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
      super.a(paramHolder.f, paramBaseChatItemLayout, Integer.valueOf(2131446456), paramChatMessage, -4, Boolean.valueOf(true));
      paramBaseChatItemLayout = this.d;
      paramHolder = paramHolder.f;
      if (this.f != null) {
        paramChatMessage = this.f.b;
      } else {
        paramChatMessage = null;
      }
      TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramHolder, paramChatMessage);
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, Intent paramIntent)
  {
    if (paramMessageForPic.picExtraData != null)
    {
      if (paramMessageForPic.picExtraData.isCustomFace())
      {
        paramIntent.putExtra("forward_is_custom_face", true);
        paramIntent.putExtra("forward_cutsom_face_type", paramMessageForPic.picExtraData.customFaceType);
        paramIntent.putExtra("forward_diy_package_id", paramMessageForPic.picExtraData.emojiPkgId);
        paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
        return;
      }
      if (paramMessageForPic.picExtraData.isHotPics())
      {
        paramIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
        paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
        return;
      }
      if ((!paramMessageForPic.picExtraData.isStickerPics()) && (!paramMessageForPic.picExtraData.isStickerAdPic()))
      {
        if (paramMessageForPic.picExtraData.isZhitu())
        {
          paramIntent.putExtra("forward_is_zhitu", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return;
        }
        if (paramMessageForPic.picExtraData.isSelfieFace())
        {
          paramIntent.putExtra("forward_is_selfie_face", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          if (!TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId)) {
            paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
          }
        }
        else if (!TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId))
        {
          paramIntent.putExtra("forward_send_template_pic", true);
          paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
          paramIntent.putExtra("key_camera_material_name", paramMessageForPic.picExtraData.mTemplateName);
        }
      }
      else
      {
        if (paramMessageForPic.picExtraData.isStickerPics())
        {
          paramIntent.putExtra("forward_is_sticker", true);
        }
        else
        {
          paramIntent.putExtra("forward_is_sticker_ad", true);
          paramIntent.putExtra("quick_send_ad_emo_jump_url", paramMessageForPic.picExtraData.mAdEmoJumpUrl);
          paramIntent.putExtra("quick_send_ad_emo_desc_str", paramMessageForPic.picExtraData.mAdEmoDescStr);
        }
        paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
        paramIntent.putExtra("key_emotion_source_from", paramMessageForPic.picExtraData.from);
        paramIntent.putExtra("key_emotion_source_info", paramMessageForPic.picExtraData.source);
        paramIntent.putExtra("key_emotion_source_weburl", paramMessageForPic.picExtraData.webUrl);
        paramIntent.putExtra("key_emotion_source_iconurl", paramMessageForPic.picExtraData.iconUrl);
        paramIntent.putExtra("key_emotion_source_packagename", paramMessageForPic.picExtraData.packageName);
        paramIntent.putExtra("key_emotion_source_epid", paramMessageForPic.picExtraData.emojiPkgId);
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.e, paramMessageForPic, this.f, paramRect);
  }
  
  private void a(MessageForPic paramMessageForPic, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramBaseChatItemLayout != null) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramMessageForPic)) && (!paramMessageForPic.isMultiMsg))
    {
      DuiButtonImageView localDuiButtonImageView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131432263);
      int i;
      if (((paramMessageForPic.extraflag == 32768) && (paramMessageForPic.isSendFromLocal())) || (this.d.getMsgCache().g(paramMessageForPic))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramMessageForPic.isDui) && (i == 0) && (DuiButtonImageView.b))
      {
        if (paramMessageForPic.isSend())
        {
          if (localDuiButtonImageView != null)
          {
            localDuiButtonImageView.setVisibility(8);
            localDuiButtonImageView.f();
          }
        }
        else
        {
          Object localObject;
          if (localDuiButtonImageView == null)
          {
            localDuiButtonImageView = new DuiButtonImageView(this.e, this.d, DoutuMsgUtil.a(paramMessageForPic));
            localObject = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.e.getResources()), AIOUtils.b(50.0F, this.e.getResources()));
            ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131430578);
            ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430578);
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (BaseChatItemLayout.l - AIOUtils.b(6.5F, this.e.getResources()));
            localDuiButtonImageView.setId(2131432263);
            paramBaseChatItemLayout.addView(localDuiButtonImageView, (ViewGroup.LayoutParams)localObject);
          }
          else
          {
            localDuiButtonImageView.f = DoutuMsgUtil.a(paramMessageForPic);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("message.hasPlayedDui = ");
            ((StringBuilder)localObject).append(paramMessageForPic.hasPlayedDui);
            QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" message.isDui = ");
            ((StringBuilder)localObject).append(paramMessageForPic.isDui);
            ((StringBuilder)localObject).append(", message.hasPlayedDui = ");
            ((StringBuilder)localObject).append(paramMessageForPic.hasPlayedDui);
            QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, ((StringBuilder)localObject).toString());
          }
          if (!paramMessageForPic.hasPlayedDui) {
            paramMessageForPic.hasPlayedDui = DuiButtonImageView.a(localDuiButtonImageView);
          } else if (localDuiButtonImageView.g()) {
            DoutuConfigReporter.a(paramMessageForPic);
          }
          if (DuiButtonImageView.b)
          {
            localDuiButtonImageView.setOnClickListener(this);
            localDuiButtonImageView.setVisibility(0);
          }
          else
          {
            localDuiButtonImageView.setOnClickListener(null);
            localDuiButtonImageView.setVisibility(8);
          }
        }
      }
      else if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.f();
      }
      a(this.d, paramBaseChatItemLayout, this.f, paramMessageForPic, this);
    }
  }
  
  private void a(String paramString)
  {
    ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).asyncFindTabEmoticonPackageById(paramString, new PicItemBuilder.2(this, paramString));
  }
  
  private static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    return (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.picExtraData != null) && (paramMessageRecord.picExtraData.isSelfieFace())) {
        return true;
      }
    }
    return false;
  }
  
  public static Intent b(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramSessionInfo = BasePicItemBuilder.a(paramMessageForPic, paramSessionInfo, paramQQAppInterface, paramContext);
    a(paramMessageForPic, paramSessionInfo);
    return paramSessionInfo;
  }
  
  private void b(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if (a(paramMessageRecord))
    {
      if (!((ICameraEmoRoamingManagerService)paramQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).isShowCameraEmoInApp()) {
        return;
      }
      Context localContext = paramBaseChatItemLayout.getContext();
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, localContext, (RelativeLayout)paramBaseChatItemLayout.findViewById(2131446456), paramQQAppInterface.getApp().getString(2131888852), null, 2130837983, a(localContext, paramSessionInfo));
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      Object localObject = (MessageForPic)paramMessageRecord;
      if ((((MessageForPic)localObject).picExtraData != null) && (((MessageForPic)localObject).picExtraData.isStickerAdPic()))
      {
        paramMessageRecord = ((MessageForPic)localObject).picExtraData.mAdEmoJumpUrl;
        localObject = ((MessageForPic)localObject).picExtraData.mAdEmoDescStr;
        if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void c(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if (b(paramMessageRecord))
    {
      MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
      String str = localMessageForPic.picExtraData.mAdEmoDescStr;
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramBaseChatItemLayout.getContext(), (RelativeLayout)paramBaseChatItemLayout.findViewById(2131446456), str, null, -1, true);
      new AdEmoReportUtil().a(paramQQAppInterface, paramSessionInfo, localMessageForPic);
    }
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (!((ICameraEmoRoamingManagerService)this.d.getRuntimeService(ICameraEmoRoamingManagerService.class)).isShowCameraEmoInApp()) {
      return;
    }
    if (a(this.e, this.f))
    {
      Object localObject = ((BaseActivity)this.e).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).c != null))
      {
        localObject = (AIOEmoticonPanelHelper)((ChatFragment)localObject).c.q(104);
        if (localObject != null) {
          ((AIOEmoticonPanelHelper)localObject).showEmoticonPanel(11);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mTemplateId clickViewId：");
        ((StringBuilder)localObject).append(((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      ((IJumpUtil)QRoute.api(IJumpUtil.class)).jumpToCameraForTakeSameGif((BaseActivity)this.e, ((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    if (l - this.H < 2000L) {
      return;
    }
    this.H = l;
    Object localObject = new AdEmoReportUtil();
    QQAppInterface localQQAppInterface = this.d;
    SessionInfo localSessionInfo = this.f;
    paramMessageRecord = (MessageForPic)paramMessageRecord;
    ((AdEmoReportUtil)localObject).b(localQQAppInterface, localSessionInfo, paramMessageRecord);
    paramMessageRecord = paramMessageRecord.picExtraData.mAdEmoJumpUrl;
    localObject = new Intent(this.e, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramMessageRecord);
    this.e.startActivity((Intent)localObject);
  }
  
  public static URL f(MessageForPic paramMessageForPic)
  {
    return new BasePicItemBuilder.DrawURL(paramMessageForPic).a;
  }
  
  private void f(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    ChatFragment localChatFragment = ((BaseActivity)this.e).getChatFragment();
    if (localChatFragment != null)
    {
      BaseChatPie localBaseChatPie = localChatFragment.k();
      if (localBaseChatPie != null)
      {
        localChatFragment = null;
        if ((AIOUtils.b(paramView) instanceof BasePicItemBuilder.Holder))
        {
          MessageForPic localMessageForPic = (MessageForPic)((BasePicItemBuilder.Holder)AIOUtils.b(paramView)).q;
          paramView = localChatFragment;
          if (localMessageForPic != null) {
            paramView = new DoutuItem(localMessageForPic.uuid, localMessageForPic.md5, localMessageForPic.groupFileID, localMessageForPic.rawMsgUrl, localMessageForPic.senderuin);
          }
          localBaseChatPie.j().obtainMessage(79, paramView).sendToTarget();
          DoutuConfigReporter.b();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
    }
  }
  
  private void g(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord == null) {
      return;
    }
    if (a(localMessageRecord))
    {
      c(localMessageRecord);
      return;
    }
    if (b(localMessageRecord))
    {
      d(localMessageRecord);
      return;
    }
    ((FlashChatManager)this.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), localMessageRecord);
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.3(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.d(1045);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(1);
    } else {
      localBuilder.c(0);
    }
    localBuilder.e(paramMessageForPic.senderuin);
    localBuilder.c(paramMessageForPic.selfuin);
    localBuilder.e(paramMessageForPic.istroop);
    localBuilder.l(paramMessageForPic.getConfessTopicId());
    localBuilder.f(paramMessageForPic.md5);
    localBuilder.A = paramMessageForPic.extLong;
    localBuilder.B = paramMessageForPic.extStr;
    localBuilder.S = true;
    Object localObject1 = new PicUploadInfo.RetryInfo();
    ((PicUploadInfo.RetryInfo)localObject1).a = paramMessageForPic.msgseq;
    ((PicUploadInfo.RetryInfo)localObject1).b = paramMessageForPic.shmsgseq;
    ((PicUploadInfo.RetryInfo)localObject1).c = paramMessageForPic.msgUid;
    localBuilder.a((PicUploadInfo.RetryInfo)localObject1);
    localObject1 = paramMessageForPic.getExtInfoFromExtStr(MessageConstants.t);
    String str = paramMessageForPic.getExtInfoFromExtStr(MessageConstants.s);
    long l2 = 0L;
    long l1 = l2;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        l1 = Long.parseLong((String)localObject1);
      }
    }
    catch (Exception localException)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "reuploadQzonePhoto exception:", localException);
        l1 = l2;
      }
    }
    if (!TextUtils.isEmpty(paramMessageForPic.thumbMsgUrl)) {
      localObject2 = paramMessageForPic.thumbMsgUrl;
    } else {
      localObject2 = paramMessageForPic.bigThumbMsgUrl;
    }
    localBuilder.R = new PhotoSendParams((String)localObject2, paramMessageForPic.md5, "", l1, (int)paramMessageForPic.height, (int)paramMessageForPic.width, str, 1);
    Object localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 1045);
    ((PicReq)localObject2).a(localBuilder.k());
    ((PicReq)localObject2).i = paramMessageForPic.picExtraData;
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject2);
  }
  
  public static void h()
  {
    Object localObject;
    if (!B)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3) {
          A = localObject[0].equals("1");
        }
      }
    }
    try
    {
      D = Integer.parseInt(localObject[2]);
      if (D >= 0) {
        break label92;
      }
      D = 100;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label87:
      break label87;
    }
    D = 100;
    label92:
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = D;
    B = true;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    if (paramViewHolder == null) {
      return paramView;
    }
    paramViewHolder = (BasePicItemBuilder.Holder)paramViewHolder;
    paramOnLongClickAndTouchListener = (MessageForPic)paramChatMessage;
    c(paramOnLongClickAndTouchListener, paramViewHolder);
    a(paramOnLongClickAndTouchListener, paramBaseChatItemLayout);
    b(this.d, paramBaseChatItemLayout, this.f, paramChatMessage, this);
    c(this.d, paramBaseChatItemLayout, this.f, paramChatMessage, this);
    if (((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramChatMessage)) {
      paramViewHolder.j.setRobotNextTipsView(true, this.e, this.d, paramChatMessage);
    } else {
      paramViewHolder.j.setRobotNextTipsView(false, this.e, this.d, paramChatMessage);
    }
    if (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramOnLongClickAndTouchListener)) {
      paramViewHolder.j.setMiniAioShieldItemTouchListener(this);
    }
    a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    return paramView;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    if (ConfessMsgUtil.b(localMessageForPic)) {
      return paramQQCustomMenu;
    }
    if ((TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info")) ^ true)) {
      return paramQQCustomMenu;
    }
    return super.a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131444659)
    {
      i(paramChatMessage);
      return;
    }
    if (paramInt == 2131438942)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 4, "picItem related click");
      }
      h(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(BasePicItemBuilder.Holder paramHolder, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL)
  {
    Object localObject = paramHolder.c;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getURL().getProtocol();
      if (a(this.e, paramBoolean, ((String)localObject).equals("chatthumb"), paramArrayOfInt[0], paramArrayOfInt[1], paramURL))
      {
        paramHolder.c.setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.e.getResources()), AIOUtils.b(6.0F, this.e.getResources()));
        paramHolder.c.setWatermarkVisibility(0);
        return;
      }
      paramHolder.c.setWatermarkVisibility(4);
      return;
    }
    paramHolder.c.setWatermarkVisibility(4);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    super.a(paramMessageForPic);
    if (paramMessageForPic.isMultiMsg)
    {
      int i;
      if (paramMessageForPic.checkGif()) {
        i = 3;
      } else {
        i = 4;
      }
      paramMessageForPic = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b(paramMessageForPic, "dc00898", "", "", "0X8009D67", "0X8009D67", i, 0, localStringBuilder.toString(), "", "", "");
    }
  }
  
  void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    c(paramMessageForPic, paramHolder);
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof BasePicItemBuilder.Holder;
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "2", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramBaseHolder = (BasePicItemBuilder.Holder)paramBaseHolder;
    if (ConfessMsgUtil.b(localMessageForPic)) {
      return paramQQCustomMenu;
    }
    if ((TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info")) ^ true))
    {
      a(paramQQCustomMenu, this.e, 2131431695, localMessageForPic, new Bundle());
      return paramQQCustomMenu;
    }
    if (c(paramQQCustomMenu, localMessageForPic)) {
      return paramQQCustomMenu;
    }
    return super.b(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.b(paramMessageForPic);
    a(this.d, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F3A", "");
  }
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    if (!paramMessageForPic.isSendFromLocal())
    {
      a(this.d, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F37", "");
      Object localObject = (ITroopPhotoHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
      if ((!TextUtils.isEmpty(this.f.b)) && (this.f.a == 1)) {
        ((ITroopPhotoHandler)localObject).a(this.f.b, true);
      }
      if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
      {
        if (paramHolder.a())
        {
          a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
          return;
        }
        paramHolder = paramHolder.j;
        paramHolder.setProgressVisable(false);
        localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(6, 1536, 1);
        ((PicReq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        ((PicReq)localObject).a(new PicItemBuilder.1(this, paramHolder));
        ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
      }
    }
    else if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
    {
      a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
      return;
    }
    if (ZhituManager.b(paramMessageForPic))
    {
      if (!ZhituManager.a(paramMessageForPic)) {
        a(paramMessageForPic, AnimationUtils.a(paramHolder.a));
      }
    }
    else
    {
      if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic))
      {
        new AdEmoReportUtil().d(this.d, this.f, paramMessageForPic);
        a(paramMessageForPic, AnimationUtils.a(paramHolder.a));
        return;
      }
      a(this.d, this.e, paramHolder.a, paramMessageForPic, this.f, false, true, true, null);
      ((IPicAIO)QRoute.api(IPicAIO.class)).reportNormalPicMsgClickEvent(paramMessageForPic);
    }
  }
  
  protected void b(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if ((((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic)) && (EmoticonPanelUtils.d(this.f.a)))
    {
      paramMessageForPic = AIORelatedEmotionConfProcessor.a();
      if ((paramMessageForPic != null) && (paramMessageForPic.a()))
      {
        paramQQCustomMenu.a(2131438942, this.e.getString(2131915659), 2130839074);
        ReportController.b(this.d, "dc00898", "", this.f.b, "0X800B114", "0X800B114", EmoticonPanelUtils.e(this.f.a), 0, "", "", "", "");
      }
    }
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    super.c(paramMessageForPic);
    ReportController.b(this.d, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    a(this.d, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F38", "");
    if (paramMessageForPic.isMultiMsg)
    {
      int i;
      if (paramMessageForPic.checkGif()) {
        i = 2;
      } else {
        i = 1;
      }
      QQAppInterface localQQAppInterface = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009D68", "0X8009D68", i, 0, localStringBuilder.toString(), "", "", "");
    }
    EmoticonOperateReport.reportFavAddEmotionEvent(this.d, 1, paramMessageForPic.md5, null);
    new AdEmoReportUtil().c(this.d, this.f, paramMessageForPic);
  }
  
  void c(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    paramHolder.d.setVisibility(8);
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()) && (!paramHolder.a()))
    {
      paramHolder.d.setImageResource(2130837995);
      paramHolder.d.setVisibility(0);
    }
  }
  
  boolean c(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if (!ZhituManager.a(paramMessageForPic)) {
      return false;
    }
    a(paramQQCustomMenu, this.e, 2131438943, paramMessageForPic, new Bundle());
    a(paramQQCustomMenu, this.e, 2131431695, paramMessageForPic, new Bundle());
    if (!paramMessageForPic.isSend()) {
      paramQQCustomMenu.a(2131444659, this.e.getString(2131918213), 2130849765);
    }
    return true;
  }
  
  protected void d(MessageForPic paramMessageForPic)
  {
    Object localObject = b(paramMessageForPic, this.f, this.d, this.e);
    if ((((this.e instanceof SplashActivity)) || ((this.e instanceof ChatActivity))) && (((BaseActivity)this.e).getChatFragment() != null)) {
      ((Intent)localObject).putExtra("isBack2Root", ((BaseActivity)this.e).getChatFragment().k().aj);
    }
    if ((this.e instanceof SplashActivity))
    {
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = AIOUtils.a((Intent)localObject, null);
    }
    else
    {
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
    ((Intent)localObject).putExtra("key_allow_forward_photo_preview_edit", true);
    ((Intent)localObject).putExtra("selection_mode", this.u);
    ForwardBaseOption.a((Activity)this.e, (Intent)localObject, 21);
    ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
    if (paramMessageForPic.isMultiMsg)
    {
      int i;
      if (paramMessageForPic.checkGif()) {
        i = 3;
      } else {
        i = 4;
      }
      localObject = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009D66", "0X8009D66", i, 0, localStringBuilder.toString(), "", "", "");
    }
    a(this.d, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F39", "");
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isQzonePic) {
      g(paramMessageForPic);
    } else {
      super.e(paramMessageForPic);
    }
    d();
  }
  
  protected void g(ChatMessage paramChatMessage)
  {
    super.g(paramChatMessage);
    ReportController.b(this.d, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForPic)) {
      return;
    }
    if (!a(this.e, this.f)) {
      return;
    }
    Object localObject1 = ((BaseActivity)this.e).getChatFragment();
    if (localObject1 != null)
    {
      localObject1 = ((ChatFragment)localObject1).k();
      if (localObject1 != null)
      {
        Object localObject3 = (AIORelatedEmotionHelper)((BaseChatPie)localObject1).q(72);
        Object localObject2 = this.e;
        localObject1 = (MessageForPic)paramChatMessage;
        localObject2 = a((Context)localObject2, (MessageForPic)localObject1);
        ((AIORelatedEmotionHelper)localObject3).a(paramChatMessage, (URLDrawable)localObject2);
        localObject3 = this.d;
        String str1 = this.f.b;
        int i = EmoticonPanelUtils.e(this.f.a);
        String str2 = EmoticonPanelUtils.a((MessageForPic)localObject1);
        if (((MessageForPic)localObject1).md5 == null) {
          paramChatMessage = "";
        } else {
          paramChatMessage = ((MessageForPic)localObject1).md5;
        }
        ReportController.b((AppRuntime)localObject3, "dc00898", "", str1, "0X800B115", "0X800B115", i, 0, str2, "", paramChatMessage, EmoticonPanelUtils.b((MessageForPic)localObject1));
        if (QLog.isColorLevel())
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append("[Related_Emotion] url: ");
          paramChatMessage.append(((URLDrawable)localObject2).getURL().toString());
          QLog.d("PicItemBuilder", 2, paramChatMessage.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "[Related_Emotion] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PicItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
    }
  }
  
  protected void i(ChatMessage paramChatMessage)
  {
    Object localObject;
    if (AnonymousChatHelper.c(paramChatMessage))
    {
      localObject = AnonymousChatHelper.g(paramChatMessage);
      if ((((AnonymousChatHelper.AnonymousExtInfo)localObject).b == null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject).a != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicItemBuilder", 2, "Anonymous report : an_id is null");
        }
        return;
      }
      byte[] arrayOfByte = ((AnonymousChatHelper.AnonymousExtInfo)localObject).a();
      if ((arrayOfByte != null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject).a != 2))
      {
        localObject = URLEncoder.encode(Base64.encodeToString(arrayOfByte, 2));
        AnonymousChatHelper.a().a(paramChatMessage.frienduin, (String)localObject, paramChatMessage);
        NewReportPlugin.a(this.d, paramChatMessage.frienduin, (String)localObject, this.d.getCurrentAccountUin(), AnonymousChatHelper.a().a(paramChatMessage.frienduin, (String)localObject));
      }
    }
    else
    {
      localObject = paramChatMessage.senderuin;
      NewReportPlugin.a((BaseActivity)this.e, (String)localObject, paramChatMessage.frienduin, this.d.getCurrentAccountUin(), NewReportPlugin.b(this.f.a), null);
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c())
    {
      int i = paramView.getId();
      if (i == 2131432263) {
        f(paramView);
      } else if (i == 2131430607) {
        g(paramView);
      }
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder
 * JD-Core Version:    0.7.0.1
 */