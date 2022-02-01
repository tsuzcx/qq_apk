package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.UinTypeUtil;
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
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.peak.PeakUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.net.URL;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class PicItemBuilder
  extends BasePicItemBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener
{
  public static float c;
  public static int c;
  public static long c;
  public static float d;
  public static boolean i = false;
  public static boolean j = false;
  private long d;
  
  static
  {
    jdField_c_of_type_Int = 100;
    jdField_c_of_type_Long = 1000L;
    jdField_c_of_type_Float = 0.3F;
    jdField_d_of_type_Float = 1.0F;
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838327);
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
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
    e();
    return a(paramContext, paramMessageForPic, paramChatThumbView, paramArrayOfInt, null);
  }
  
  public static URL a(MessageForPic paramMessageForPic)
  {
    return new BasePicItemBuilder.DrawURL(paramMessageForPic).a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString3))) {}
    while (!"2854196312".equals(paramString1)) {
      return;
    }
    paramString1 = "";
    if (paramInt != -2) {}
    String str;
    switch (paramInt)
    {
    default: 
      paramString1 = "other";
      if (paramQQAppInterface.getCurrentUin() != null)
      {
        str = paramQQAppInterface.getCurrentUin();
        label84:
        if (paramString4 == null) {
          break label141;
        }
        label89:
        if (paramString2 == null) {
          break label148;
        }
      }
      break;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString3, paramString3, 0, 0, str, paramString4, paramString1, paramString2);
      return;
      paramString1 = "c2c";
      break;
      paramString1 = "group";
      break;
      paramString1 = "discuss";
      break;
      str = "";
      break label84;
      label141:
      paramString4 = "";
      break label89;
      label148:
      paramString2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(PeakUtils.b, paramBoolean3);
    Object localObject;
    if (a(paramContext, paramSessionInfo))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if (localObject == null) {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
    }
    else
    {
      if (paramMessageForReplyText == null) {
        break label220;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    for (;;)
    {
      paramBoolean2 = OCRManager.a(paramQQAppInterface.getCurrentAccountUin(), 1);
      localBundle.putBoolean("extra.OCR", paramBoolean2);
      if (paramBoolean2)
      {
        paramMessageForReplyText = OCRManager.a(paramQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty(paramMessageForReplyText)) {
          localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
        }
      }
      BasePicItemBuilder.a(paramQQAppInterface, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean1, localBundle);
      return;
      localObject = ((ChatFragment)localObject).a();
      if (localObject == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        break;
      }
      int k = ((BaseChatPie)localObject).g();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", k);
      if (k != 1) {
        break;
      }
      localObject = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localObject == null) {
        break;
      }
      ((InputMethodManager)localObject).toggleSoftInput(1, 0);
      break;
      label220:
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if ((!a(paramMessageRecord)) || (!((CameraEmoRoamingManager)paramQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).c())) {
      return;
    }
    Context localContext = paramBaseChatItemLayout.getContext();
    a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, localContext, (RelativeLayout)paramBaseChatItemLayout.findViewById(2131378558), paramQQAppInterface.getApp().getString(2131691960), null, 2130838109, a(localContext, paramSessionInfo));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, -2, paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BasePicItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramChatMessage != null))
    {
      paramHolder.c = super.a(paramHolder.c, paramHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramHolder.c, paramBaseChatItemLayout, Integer.valueOf(2131378558), paramChatMessage, -4, Boolean.valueOf(true));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramHolder = paramHolder.c;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break label95;
      }
    }
    label95:
    for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramChatMessage = null)
    {
      TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramHolder, paramChatMessage);
      return;
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, Intent paramIntent)
  {
    if (paramMessageForPic.picExtraData != null)
    {
      if (!paramMessageForPic.picExtraData.isCustomFace()) {
        break label72;
      }
      paramIntent.putExtra("forward_is_custom_face", true);
      paramIntent.putExtra("forward_cutsom_face_type", paramMessageForPic.picExtraData.customFaceType);
      paramIntent.putExtra("forward_diy_package_id", paramMessageForPic.picExtraData.emojiPkgId);
      paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
    }
    label72:
    do
    {
      do
      {
        return;
        if (paramMessageForPic.picExtraData.isHotPics())
        {
          paramIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return;
        }
        if ((paramMessageForPic.picExtraData.isStickerPics()) || (paramMessageForPic.picExtraData.isStickerAdPic()))
        {
          if (paramMessageForPic.picExtraData.isStickerPics()) {
            paramIntent.putExtra("forward_is_sticker", true);
          }
          for (;;)
          {
            paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
            paramIntent.putExtra("key_emotion_source_from", paramMessageForPic.picExtraData.from);
            paramIntent.putExtra("key_emotion_source_info", paramMessageForPic.picExtraData.source);
            paramIntent.putExtra("key_emotion_source_weburl", paramMessageForPic.picExtraData.webUrl);
            paramIntent.putExtra("key_emotion_source_iconurl", paramMessageForPic.picExtraData.iconUrl);
            paramIntent.putExtra("key_emotion_source_packagename", paramMessageForPic.picExtraData.packageName);
            paramIntent.putExtra("key_emotion_source_epid", paramMessageForPic.picExtraData.emojiPkgId);
            return;
            paramIntent.putExtra("forward_is_sticker_ad", true);
            paramIntent.putExtra("quick_send_ad_emo_jump_url", paramMessageForPic.picExtraData.mAdEmoJumpUrl);
            paramIntent.putExtra("quick_send_ad_emo_desc_str", paramMessageForPic.picExtraData.mAdEmoDescStr);
          }
        }
        if (paramMessageForPic.picExtraData.isZhitu())
        {
          paramIntent.putExtra("forward_is_zhitu", true);
          paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return;
        }
        if (!paramMessageForPic.picExtraData.isSelfieFace()) {
          break;
        }
        paramIntent.putExtra("forward_is_selfie_face", true);
        paramIntent.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
      paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
      return;
    } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
    paramIntent.putExtra("forward_send_template_pic", true);
    paramIntent.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
    paramIntent.putExtra("key_camera_material_name", paramMessageForPic.picExtraData.mTemplateName);
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(MessageForPic paramMessageForPic, BaseChatItemLayout paramBaseChatItemLayout)
  {
    DuiButtonImageView localDuiButtonImageView;
    int k;
    if ((paramBaseChatItemLayout != null) && (!HotChatUtil.a(paramMessageForPic)) && (!paramMessageForPic.isMultiMsg))
    {
      localDuiButtonImageView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131366075);
      if (((paramMessageForPic.extraflag != 32768) || (!paramMessageForPic.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramMessageForPic))) {
        break label121;
      }
      k = 1;
      if ((!paramMessageForPic.isDui) || (k != 0) || (!DuiButtonImageView.jdField_a_of_type_Boolean)) {
        break label402;
      }
      if (!paramMessageForPic.isSend()) {
        break label126;
      }
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.e();
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic, this);
      return;
      label121:
      k = 0;
      break;
      label126:
      if (localDuiButtonImageView == null)
      {
        localDuiButtonImageView = new DuiButtonImageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(8, 2131364634);
        localLayoutParams.addRule(1, 2131364634);
        localLayoutParams.bottomMargin = (BaseChatItemLayout.jdField_i_of_type_Int - AIOUtils.a(6.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localDuiButtonImageView.setId(2131366075);
        paramBaseChatItemLayout.addView(localDuiButtonImageView, localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, " message.isDui = " + paramMessageForPic.isDui + ", message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (paramMessageForPic.hasPlayedDui) {
          break label371;
        }
        paramMessageForPic.hasPlayedDui = DuiButtonImageView.a(localDuiButtonImageView);
      }
      for (;;)
      {
        label241:
        if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
          break label386;
        }
        localDuiButtonImageView.setOnClickListener(this);
        localDuiButtonImageView.setVisibility(0);
        break;
        localDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPic;
        break label241;
        label371:
        if (localDuiButtonImageView.b()) {
          DoutuConfigReporter.a(paramMessageForPic);
        }
      }
      label386:
      localDuiButtonImageView.setOnClickListener(null);
      localDuiButtonImageView.setVisibility(8);
      continue;
      label402:
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.e();
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (!((CameraEmoRoamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).c()) {}
    while (!a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a != null))
    {
      localObject = (AIOEmoticonPanelHelper)((ChatFragment)localObject).a.a(104);
      if (localObject != null) {
        ((AIOEmoticonPanelHelper)localObject).showEmoticonPanel(11);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "mTemplateId clickViewId：" + ((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
    }
    JumpUtil.b((FragmentActivity)this.jdField_a_of_type_AndroidContentContext, ((MessageForPic)paramMessageRecord).picExtraData.mTemplateId);
  }
  
  private void a(String paramString)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).b(paramString, new PicItemBuilder.2(this, paramString));
  }
  
  private static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    return (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = GeneralConfigUtils.a();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = AbsDownloader.getFilePath(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f) || (paramInt2 < f * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.checkGif()) {}
    do
    {
      return true;
      if (paramMessageForPic.picExtraData != null) {
        return paramMessageForPic.picExtraData.isEmotion();
      }
    } while (HotChatUtil.a(paramMessageForPic));
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isSelfieFace());
  }
  
  public static Intent b(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramSessionInfo = BasePicItemBuilder.a(paramMessageForPic, paramSessionInfo, paramQQAppInterface, paramContext);
    a(paramMessageForPic, paramSessionInfo);
    return paramSessionInfo;
  }
  
  private void b(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    if (b(paramMessageRecord))
    {
      String str = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoDescStr;
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramBaseChatItemLayout.getContext(), (RelativeLayout)paramBaseChatItemLayout.findViewById(2131378558), str, null, -1, true);
      new AdEmoReportUtil().a(paramQQAppInterface, paramSessionInfo, (MessageForPic)paramMessageRecord);
    }
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long < 2000L) {
      return;
    }
    this.jdField_d_of_type_Long = l;
    new AdEmoReportUtil().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)paramMessageRecord);
    paramMessageRecord = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoJumpUrl;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramMessageRecord);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).picExtraData != null) && (((MessageForPic)paramMessageRecord).picExtraData.isStickerAdPic()))
    {
      String str = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoJumpUrl;
      paramMessageRecord = ((MessageForPic)paramMessageRecord).picExtraData.mAdEmoDescStr;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord))) {
        return true;
      }
    }
    return false;
  }
  
  private void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment != null)
    {
      localBaseChatPie = localChatFragment.a();
      if (localBaseChatPie != null)
      {
        localChatFragment = null;
        if ((AIOUtils.a(paramView) instanceof BasePicItemBuilder.Holder))
        {
          localMessageForPic = (MessageForPic)((BasePicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          paramView = localChatFragment;
          if (localMessageForPic != null) {
            paramView = new DoutuItem(localMessageForPic.uuid, localMessageForPic.md5, localMessageForPic.groupFileID, localMessageForPic.rawMsgUrl, localMessageForPic.senderuin);
          }
          localBaseChatPie.a().obtainMessage(79, paramView).sendToTarget();
          DoutuConfigReporter.b();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      BaseChatPie localBaseChatPie;
      MessageForPic localMessageForPic;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  public static void e()
  {
    Object localObject;
    if (!i)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3) {
          h = localObject[0].equals("1");
        }
      }
    }
    try
    {
      jdField_c_of_type_Int = Integer.parseInt(localObject[2]);
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 100;
      }
      com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = jdField_c_of_type_Int;
      i = true;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 100;
      }
    }
  }
  
  private void e(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord == null) {
      return;
    }
    if (a(localMessageRecord))
    {
      a(localMessageRecord);
      return;
    }
    if (b(localMessageRecord))
    {
      b(localMessageRecord);
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), localMessageRecord);
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    Object localObject = AIOPicThumbSizeProcessor.a();
    int k;
    if (localObject != null)
    {
      if (((AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)localObject).jdField_a_of_type_Double <= 0.0D) {
        break label68;
      }
      k = (int)(((AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)localObject).jdField_a_of_type_Double * 100.0D);
    }
    for (;;)
    {
      localObject = "4";
      if (paramMessageForPic.istroop == 0) {
        localObject = "1";
      }
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B2A2", "0X800B2A2", k, 0, (String)localObject, "", "", "");
        return;
        label68:
        if ((!((AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)localObject).equals(new AIOPicThumbSizeProcessor().b())) && (((AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)localObject).jdField_a_of_type_Boolean)) {
          break label132;
        }
        k = 101;
        break;
        if (UinTypeUtil.g(paramMessageForPic.istroop)) {
          localObject = "2";
        } else if (UinTypeUtil.b(paramMessageForPic.istroop)) {
          localObject = "3";
        }
      }
      label132:
      k = 0;
    }
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.3(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.d(1045);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
    }
    for (;;)
    {
      localBuilder.e(paramMessageForPic.senderuin);
      localBuilder.c(paramMessageForPic.selfuin);
      localBuilder.e(paramMessageForPic.istroop);
      localBuilder.l(paramMessageForPic.getConfessTopicId());
      localBuilder.f(paramMessageForPic.md5);
      localBuilder.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localBuilder.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      localBuilder.h = true;
      Object localObject = new PicUploadInfo.RetryInfo();
      ((PicUploadInfo.RetryInfo)localObject).a = paramMessageForPic.msgseq;
      ((PicUploadInfo.RetryInfo)localObject).b = paramMessageForPic.shmsgseq;
      ((PicUploadInfo.RetryInfo)localObject).jdField_c_of_type_Long = paramMessageForPic.msgUid;
      localBuilder.a((PicUploadInfo.RetryInfo)localObject);
      localObject = paramMessageForPic.getExtInfoFromExtStr(MessageConstants.t);
      String str2 = paramMessageForPic.getExtInfoFromExtStr(MessageConstants.s);
      long l = 0L;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l = Long.parseLong((String)localObject);
        }
        if (!TextUtils.isEmpty(paramMessageForPic.thumbMsgUrl))
        {
          localObject = paramMessageForPic.thumbMsgUrl;
          localBuilder.a = new PhotoSendParams((String)localObject, paramMessageForPic.md5, "", l, (int)paramMessageForPic.height, (int)paramMessageForPic.width, str2, 1);
          localObject = PicBusiManager.a(4, 1045);
          ((PicReq)localObject).a(localBuilder.a());
          ((PicReq)localObject).a = paramMessageForPic.picExtraData;
          PicBusiManager.a((PicReq)localObject);
          return;
          localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PicItemBuilder", 2, "reuploadQzonePhoto exception:", localException);
          }
          l = 0L;
          continue;
          String str1 = paramMessageForPic.bigThumbMsgUrl;
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    if (paramViewHolder == null) {
      return paramView;
    }
    paramViewHolder = (BasePicItemBuilder.Holder)paramViewHolder;
    paramOnLongClickAndTouchListener = (MessageForPic)paramChatMessage;
    c(paramOnLongClickAndTouchListener, paramViewHolder);
    a(paramOnLongClickAndTouchListener, paramBaseChatItemLayout);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
    if (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      if (!a((MessageForPic)paramChatMessage)) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      }
      a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      return paramView;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    if (ConfessMsgUtil.a(localMessageForPic)) {}
    for (;;)
    {
      return paramQQCustomMenu;
      if (!ApolloGameUtil.a(localMessageForPic))
      {
        if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
        for (int k = 1; k == 0; k = 0) {
          return super.a(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131376948)
    {
      f(paramChatMessage);
      return;
    }
    if (paramInt == 2131371953)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 4, "picItem related click");
      }
      e(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(BasePicItemBuilder.Holder paramHolder, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL)
  {
    Object localObject = paramHolder.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getURL().getProtocol();
      if (a(this.jdField_a_of_type_AndroidContentContext, paramBoolean, ((String)localObject).equals("chatthumb"), paramArrayOfInt[0], paramArrayOfInt[1], paramURL))
      {
        paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        return;
      }
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    super.a(paramMessageForPic);
    if (paramMessageForPic.isMultiMsg)
    {
      int k = 4;
      if (paramMessageForPic.checkGif()) {
        k = 3;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", k, 0, "" + k, "", "", "");
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
  
  boolean a(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if (!ZhituManager.a(paramMessageForPic)) {
      return false;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramMessageForPic, new Bundle());
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramMessageForPic, new Bundle());
    if (!paramMessageForPic.isSend()) {
      paramQQCustomMenu.a(2131376948, this.jdField_a_of_type_AndroidContentContext.getString(2131720771), 2130848230);
    }
    return true;
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "2", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramBaseHolder = (BasePicItemBuilder.Holder)paramBaseHolder;
    if (ConfessMsgUtil.a(localMessageForPic)) {}
    do
    {
      do
      {
        return paramQQCustomMenu;
      } while (ApolloGameUtil.a(localMessageForPic));
      if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
      for (int k = 1; k != 0; k = 0)
      {
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, localMessageForPic, new Bundle());
        return paramQQCustomMenu;
      }
    } while (a(paramQQCustomMenu, localMessageForPic));
    return super.b(paramQQCustomMenu, paramChatMessage, paramBaseHolder);
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.b(paramMessageForPic);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F3A", "");
  }
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    Object localObject;
    if (!paramMessageForPic.isSendFromLocal())
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F37", "");
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        ((TroopHandler)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if ((paramMessageForPic.picExtraData == null) || (!paramMessageForPic.picExtraData.isDiyDouTu())) {
        break label197;
      }
      if (paramHolder.a()) {
        a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
      }
    }
    label197:
    do
    {
      return;
      paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramHolder.setProgressVisable(false);
      localObject = PicBusiManager.a(6, 1536, 1);
      ((PicReq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((PicReq)localObject).a(new PicItemBuilder.1(this, paramHolder));
      PicBusiManager.a((PicReq)localObject);
      return;
      if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
      {
        a(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
        return;
      }
      if (!ZhituManager.b(paramMessageForPic)) {
        break;
      }
    } while (ZhituManager.a(paramMessageForPic));
    a(paramMessageForPic, AnimationUtils.a(paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
    return;
    if (a(paramMessageForPic))
    {
      new AdEmoReportUtil().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic);
      a(paramMessageForPic, AnimationUtils.a(paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView));
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
    f(paramMessageForPic);
  }
  
  protected void b(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if ((a(paramMessageForPic)) && (EmoticonUtils.isShowRelatedEmoInAio(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      paramMessageForPic = AIORelatedEmotionConfProcessor.a();
      if ((paramMessageForPic != null) && (paramMessageForPic.a()))
      {
        paramQQCustomMenu.a(2131371953, this.jdField_a_of_type_AndroidContentContext.getString(2131718515), 2130839067);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
      }
    }
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    super.c(paramMessageForPic);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F38", "");
    if (paramMessageForPic.isMultiMsg)
    {
      int k = 1;
      if (paramMessageForPic.checkGif()) {
        k = 2;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D68", "0X8009D68", k, 0, "" + k, "", "", "");
    }
    EmoticonUtils.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramMessageForPic.md5, null);
    new AdEmoReportUtil().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForPic);
  }
  
  void c(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()) && (!paramHolder.a()))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838122);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void d(ChatMessage paramChatMessage)
  {
    super.d(paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
  }
  
  protected void d(MessageForPic paramMessageForPic)
  {
    Intent localIntent = b(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    if ((((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
      localIntent.putExtra("isBack2Root", ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().i);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, null);
    }
    for (;;)
    {
      localIntent.putExtra("key_allow_forward_photo_preview_edit", true);
      localIntent.putExtra("selection_mode", this.b);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
      if (paramMessageForPic.isMultiMsg)
      {
        int k = 4;
        if (paramMessageForPic.checkGif()) {
          k = 3;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", k, 0, "" + k, "", "", "");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F39", "");
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForPic)) {}
    label7:
    do
    {
      do
      {
        break label7;
        do
        {
          return;
        } while (!a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject == null) {
          break;
        }
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null)
        {
          localObject = (AIORelatedEmotionHelper)((BaseChatPie)localObject).a(72);
          URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramChatMessage);
          ((AIORelatedEmotionHelper)localObject).a(paramChatMessage, localURLDrawable);
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          int k = EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          String str2 = EmoticonUtils.getRelatedEmotionReportType((MessageForPic)paramChatMessage);
          if (((MessageForPic)paramChatMessage).md5 == null) {}
          for (localObject = "";; localObject = ((MessageForPic)paramChatMessage).md5)
          {
            ReportController.b(localQQAppInterface, "dc00898", "", str1, "0X800B115", "0X800B115", k, 0, str2, "", (String)localObject, EmoticonUtils.getMessageForPicUrl((MessageForPic)paramChatMessage));
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PicItemBuilder", 2, "[Related_Emotion] url: " + localURLDrawable.getURL().toString());
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "[Related_Emotion] curPie is null.");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
  }
  
  void e(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isQzonePic) {
      g(paramMessageForPic);
    }
    for (;;)
    {
      b();
      return;
      super.e(paramMessageForPic);
    }
  }
  
  protected void f(ChatMessage paramChatMessage)
  {
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      localObject = AnonymousChatHelper.a(paramChatMessage);
      if ((((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_JavaLangString == null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_Int != 2)) {
        if (QLog.isColorLevel()) {
          QLog.i("PicItemBuilder", 2, "Anonymous report : an_id is null");
        }
      }
      byte[] arrayOfByte;
      do
      {
        return;
        arrayOfByte = ((AnonymousChatHelper.AnonymousExtInfo)localObject).a();
      } while ((arrayOfByte == null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_a_of_type_Int == 2));
      localObject = URLEncoder.encode(Base64.encodeToString(arrayOfByte, 2));
      AnonymousChatHelper.a().a(paramChatMessage.frienduin, (String)localObject, paramChatMessage);
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), AnonymousChatHelper.a().a(paramChatMessage.frienduin, (String)localObject));
      return;
    }
    Object localObject = paramChatMessage.senderuin;
    NewReportPlugin.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (super.a())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int k = paramView.getId();
    if (k == 2131366075) {
      d(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      if (k == 2131364662) {
        e(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder
 * JD-Core Version:    0.7.0.1
 */