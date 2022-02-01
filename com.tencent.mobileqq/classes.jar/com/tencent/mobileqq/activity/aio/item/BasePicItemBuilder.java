package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject;
import com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject.Builder;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BasePicItemBuilder
  extends QIMTailItemBubbleBuilder
  implements Callback, ContextMenuBuilder2
{
  public static boolean h = true;
  protected MultiRichMediaSaveManager a;
  protected AioPicTransFileController a;
  protected final float b;
  boolean f = false;
  boolean g = false;
  
  public BasePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController = new AioPicTransFileController();
    this.b = paramContext.getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager = ((MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
  }
  
  private static int a(Context paramContext)
  {
    boolean bool = paramContext instanceof SplashActivity;
    int i = 2;
    if ((!bool) && (!(paramContext instanceof ChatActivity)))
    {
      if (!(paramContext instanceof ChatHistoryActivity))
      {
        if ((paramContext instanceof ChatHistory)) {
          return 2;
        }
        if ((paramContext instanceof PublicFragmentActivity))
        {
          if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
            return 2;
          }
        }
        else if ((paramContext instanceof MultiForwardActivity)) {
          return 5;
        }
        return -1;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  static Intent a(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_image_width", paramMessageForPic.width);
    localIntent.putExtra("forward_image_height", paramMessageForPic.height);
    localIntent.putExtra("forward_file_size", paramMessageForPic.size);
    localIntent.putExtra("forward_image_type", paramMessageForPic.imageType);
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPic.frienduin);
    localStringBuilder.append(paramMessageForPic.uniseq);
    localStringBuilder.append(paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_task_key", localStringBuilder.toString());
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_sender_uin", paramMessageForPic.senderuin);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    if (paramMessageForPic.picExtraData != null) {
      localIntent.putExtra("forward_photo_imagebiz_type", paramMessageForPic.picExtraData.imageBizType);
    }
    localIntent.putExtras((Bundle)localObject);
    int i;
    if ((!ActionMsgUtil.a(paramMessageForPic.msgtype)) && (paramMessageForPic.msgtype != -3001) && (paramMessageForPic.msgtype != -30002) && (paramMessageForPic.msgtype != -30003)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      i = 65537;
    } else {
      i = 1;
    }
    localObject = URLDrawableHelper.getURL(paramMessageForPic, i);
    localIntent.putExtra("forward_urldrawable", true);
    localIntent.putExtra("forward_urldrawable_thumb_url", ((URL)localObject).toString());
    localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
    paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
    localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
    localIntent.putExtra("uinname", paramSessionInfo.d);
    localIntent.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
    localIntent.putExtra("PhotoConst.MY_NICK", paramQQAppInterface.getCurrentNickname());
    localIntent.putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.e);
    localIntent.addFlags(603979776);
    localIntent.putExtra("FORWARD_MSG_FOR_PIC", paramMessageForPic);
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
    }
    else
    {
      paramQQAppInterface = null;
      paramContext = paramContext.getURL().toString();
      if (AbsDownloader.hasFile(paramContext))
      {
        paramContext = AbsDownloader.getFile(paramContext);
        paramMessageForPic = paramQQAppInterface;
        if (paramContext != null) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
      else
      {
        paramContext = AbsDownloader.getFile(URLDrawableHelper.getURL(paramMessageForPic, 65537).toString());
        paramMessageForPic = paramQQAppInterface;
        if (paramContext != null)
        {
          paramMessageForPic = paramQQAppInterface;
          if (paramContext.exists()) {
            paramMessageForPic = paramContext.getAbsolutePath();
          }
        }
      }
      localIntent.putExtra("forward_extra", paramMessageForPic);
    }
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.putExtra("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("BUSI_TYPE", 1009);
    return localIntent;
  }
  
  static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, BasePicItemBuilder.DrawURL paramDrawURL)
  {
    return new AIOPicThumbDrawableObject.Builder(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(paramDrawURL).a().a();
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
      paramBundle.putBoolean("extra.IS_HOT_CHAT", ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramChatMessage));
    }
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    String str = paramChatMessage.selfuin;
    paramView = str;
    if (paramChatMessage.isMultiMsg) {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramView = str;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramView = localAppRuntime.getAccount();
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        paramView = str;
      }
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    paramBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView != null) && (paramChatMessage.frienduin != null))
    {
      paramView = (MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      paramBoolean = paramView.a(paramChatMessage);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean);
      if (paramBoolean)
      {
        paramView = paramView.a(paramView.a(paramChatMessage));
        if ((paramView != null) && (paramView.d == 1)) {
          paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramView.c);
        }
      }
      int i = a(paramContext);
      if ((paramChatMessage instanceof MessageForPic))
      {
        paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, paramBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1, i);
      }
      else if ((paramChatMessage instanceof MessageForTroopFile))
      {
        paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, paramBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
      }
      else if ((paramChatMessage instanceof MessageForMixedMsg))
      {
        paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(paramChatMessage);
        paramSessionInfo.a(paramQQAppInterface);
        PeakUtils.a(paramContext, paramBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForMixedMsg)paramChatMessage), -1, i, true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366309, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366308, paramChatMessage, null);
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, BasePicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int i = (int)paramIHttpCommunicatorListener.getFileStatus();
      if (i != 1006)
      {
        if (i != 4001) {
          switch (i)
          {
          default: 
            if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
            {
              paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
              ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
              paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
              ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              if (!paramIHttpCommunicatorListener.a(((StringBuilder)localObject1).toString()))
              {
                paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
                ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
                paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
                ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
                paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
              }
              else
              {
                paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
              }
            }
            if (i == 1003) {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
            }
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
            return;
          }
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          localObject1 = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          ((PicProgressView)localObject1).setRadius(12.0F, true);
          ((PicProgressView)localObject1).setSharpCornerCor(BubbleImageView.a);
          ((PicProgressView)localObject1).setShowCorner(false);
          ((PicProgressView)localObject1).setCustomSize(1);
          ((PicProgressView)localObject1).setProgressBackgroudColor(2130706432);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131372696);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372696);
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372696);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372696);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = ((PicProgressView)localObject1);
        }
        localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
        ((StringBuilder)localObject2).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        ((PicProgressView)localObject1).setProgressKey(((StringBuilder)localObject2).toString());
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(paramIHttpCommunicatorListener);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && ((1001 == i) || (1002 == i))) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        }
        if (i != 1002)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(0);
          return;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a();
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        return;
      }
      if ((paramIHttpCommunicatorListener.isRawPic()) && (!this.f))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
          ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
          paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
          ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
        paramIHttpCommunicatorListener = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    }
  }
  
  private void c(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager;
    if ((localObject != null) && (paramMessageForPic != null) && (paramHolder != null))
    {
      paramMessageForPic = ((MultiRichMediaSaveManager)localObject).a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic);
      if ((localObject != null) && (((FileSaveResult)localObject).d == 1))
      {
        int i;
        if (((FileSaveResult)localObject).c < 0) {
          i = 0;
        } else if (((FileSaveResult)localObject).c > 100) {
          i = 100;
        } else {
          i = ((FileSaveResult)localObject).c;
        }
        if ((i < 100) && (!((FileSaveResult)localObject).jdField_a_of_type_Boolean) && (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) && (((FileSaveResult)localObject).jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null))
        {
          ((FileSaveResult)localObject).jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a(new BasePicItemBuilder.1(this, paramHolder, paramMessageForPic));
          this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic, (FileSaveResult)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("PicItemBuilder", 2, "show picSaveProgress");
          }
          paramMessageForPic = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramMessageForPic.setRadius(12.0F, true);
          paramMessageForPic.setSharpCornerCor(BubbleImageView.a);
          paramMessageForPic.setShowCorner(false);
          paramMessageForPic.setCustomSize(1);
          paramMessageForPic.setProgressBackgroudColor(2130706432);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131372696);
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131372696);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131372696);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131372696);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
          paramMessageForPic = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
          ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramMessageForPic.setProgressKey(((StringBuilder)localObject).toString());
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
        }
      }
    }
  }
  
  private void f(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BasePicItemBuilder.4(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
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
    localBuilder.jdField_i_of_type_Int = paramMessageForPic.extLong;
    localBuilder.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    Object localObject = new PicUploadInfo.RetryInfo();
    ((PicUploadInfo.RetryInfo)localObject).a = paramMessageForPic.msgseq;
    ((PicUploadInfo.RetryInfo)localObject).b = paramMessageForPic.shmsgseq;
    ((PicUploadInfo.RetryInfo)localObject).c = paramMessageForPic.msgUid;
    localBuilder.a((PicUploadInfo.RetryInfo)localObject);
    localBuilder.b(paramMessageForPic.uniseq);
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 5);
    ((PicReq)localObject).a(localBuilder.a());
    ((PicReq)localObject).a = paramMessageForPic.picExtraData;
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
  }
  
  private void g(MessageForPic paramMessageForPic)
  {
    Object localObject1 = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).start();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new PicFowardInfo();
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(1009);
    ((PicUploadInfo.Builder)localObject2).a(paramMessageForPic.path);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.istroop);
    ((PicUploadInfo.Builder)localObject2).c(paramMessageForPic.selfuin);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.senderuin);
    ((PicUploadInfo.Builder)localObject2).d(paramMessageForPic.frienduin);
    ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_Int = paramMessageForPic.extLong;
    ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
    ((PicUploadInfo.Builder)localObject2).c(10);
    ((PicUploadInfo.Builder)localObject2).b(paramMessageForPic.uniseq);
    ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUploadInfo.Builder)localObject2).a();
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      PicDownloadInfo.Builder localBuilder = new PicDownloadInfo.Builder();
      localBuilder.a(1009);
      localBuilder.a(paramMessageForPic.selfuin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).fowardOrgUin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).fowardOrgUinType);
      localBuilder.c(((PicFowardDbRecordData)localObject2).fowardOrgUrl);
      localBuilder.a(((PicFowardDbRecordData)localObject2).fowardOrgId);
      localBuilder.d(paramMessageForPic.md5);
      localBuilder.c(paramMessageForPic.issend);
      ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = localBuilder.a();
    }
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(3, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    ((IPicBus)QRoute.api(IPicBus.class)).launch(paramMessageForPic);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool3 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramBaseChatItemLayout.imageType);
    try
    {
      BasePicItemBuilder.Holder localHolder = (BasePicItemBuilder.Holder)paramViewHolder;
      if (localHolder == null) {
        return paramView;
      }
      localHolder.jdField_a_of_type_Boolean = bool3;
      boolean bool2 = false;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setId(2131372696);
        paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramView.e = true;
        }
        paramView.setId(2131372696);
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(12.0F);
        paramView.d(false);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(15);
        paramViewHolder.addView(paramView, localLayoutParams);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
        paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(7, 2131372696);
        localLayoutParams.addRule(8, 2131372696);
        paramViewHolder.addView(paramView, localLayoutParams);
        localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
        paramViewHolder.setOnClickListener(this);
        super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      }
      paramView = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int j = (int)Math.max(paramBaseChatItemLayout.width, paramBaseChatItemLayout.height);
      int i = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbMaxPx(bool3, ((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramBaseChatItemLayout) ^ true, j);
      j = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbMinPx(bool3, ((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramBaseChatItemLayout) ^ true, j);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      boolean bool1 = bool2;
      if (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramBaseChatItemLayout))
      {
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      paramView.setShowEdge(bool1);
      if (e) {
        paramView.setContentDescription(HardCodeUtil.a(2131708151));
      }
      if (!paramBaseChatItemLayout.isSendFromLocal()) {
        b(paramBaseChatItemLayout, localHolder, paramViewHolder, bool3);
      } else {
        a(paramBaseChatItemLayout, localHolder, paramViewHolder, bool3);
      }
      if (QLog.isColorLevel())
      {
        paramOnLongClickAndTouchListener = new StringBuilder();
        paramOnLongClickAndTouchListener.append("getView ");
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL != null) {
          paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.toString();
        } else {
          paramView = "";
        }
        paramOnLongClickAndTouchListener.append(paramView);
        paramOnLongClickAndTouchListener.append(", isDynamic=");
        paramOnLongClickAndTouchListener.append(bool3);
        paramOnLongClickAndTouchListener.append(", thumbWidth=");
        paramOnLongClickAndTouchListener.append(paramBaseChatItemLayout.thumbWidth);
        paramOnLongClickAndTouchListener.append(", thumbHeight=");
        paramOnLongClickAndTouchListener.append(paramBaseChatItemLayout.thumbHeight);
        paramOnLongClickAndTouchListener.append(", thumbMaxSize=");
        paramOnLongClickAndTouchListener.append(i);
        paramOnLongClickAndTouchListener.append(", thumbMinSize=");
        paramOnLongClickAndTouchListener.append(j);
        QLog.d("PicItemBuilder", 2, paramOnLongClickAndTouchListener.toString());
      }
      a(paramChatMessage, paramViewHolder, this);
      c(paramBaseChatItemLayout, localHolder);
      return paramViewHolder;
    }
    catch (Exception paramChatMessage)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("picitem holer Exception e= ");
      paramViewHolder.append(paramChatMessage);
      QLog.e("PicItemBuilder", 2, paramViewHolder.toString());
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("picitem holer Exception e= ");
      paramViewHolder.append(paramChatMessage);
      throw new ClassCastException(paramViewHolder.toString());
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (BasePicItemBuilder.Holder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new BasePicItemBuilder.Holder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseHolder = (BasePicItemBuilder.Holder)paramBaseHolder;
    int i = paramBaseHolder.a(paramChatMessage);
    paramBaseHolder.getClass();
    if (i != 1)
    {
      paramBaseHolder.getClass();
      if (i != 2)
      {
        paramBaseHolder.getClass();
        if (i != 4)
        {
          paramBaseHolder.getClass();
          if (i != 5) {
            return paramQQCustomMenu;
          }
        }
      }
    }
    a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
    a(paramQQCustomMenu, paramChatMessage);
    a(paramQQCustomMenu);
    return paramQQCustomMenu;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131708152);
    }
    return HardCodeUtil.a(2131708153);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367180)
      {
        d(localMessageForPic);
        return;
      }
      if (paramInt == 2131362241)
      {
        c(localMessageForPic);
        return;
      }
      if (paramInt == 2131365480)
      {
        d(paramChatMessage);
        return;
      }
      if (paramInt == 2131371603)
      {
        b(localMessageForPic);
        return;
      }
      if (paramInt == 2131376503)
      {
        e(localMessageForPic);
        return;
      }
      if (paramInt == 2131366494)
      {
        a(localMessageForPic);
        return;
      }
      if (paramInt == 2131364271)
      {
        c(paramChatMessage);
        return;
      }
      if (paramInt == 2131364263)
      {
        b(paramChatMessage);
        return;
      }
      if (paramInt == 2131371592)
      {
        super.a(2131371603, paramContext, paramChatMessage);
        return;
      }
      super.a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForPic)((BasePicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131689933, 5);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new BasePicItemBuilder.3(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  void a(BasePicItemBuilder.Holder paramHolder, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  protected void a(MessageForPic paramMessageForPic)
  {
    QfavBuilder.a(paramMessageForPic).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, paramMessageForPic.istroop);
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class)).productFromAIODynamicPic(paramMessageForPic);
    }
  }
  
  abstract void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder);
  
  protected void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    if (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    Object localObject = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    URL localURL = ((BasePicItemBuilder.DrawURL)localObject).a;
    if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, (BasePicItemBuilder.DrawURL)localObject);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = ((BasePicItemBuilder.DrawURL)localObject);
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("predownloadDynamic pic uniseq=");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          ((StringBuilder)localObject).append(" url=");
          ((StringBuilder)localObject).append(localURL);
          QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        a(paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show send pic uniseq=");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject).append(" url=");
        ((StringBuilder)localObject).append(localURL);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramMessageForPic = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramHolder.jdField_a_of_type_AndroidViewView = paramView;
    a(paramMessageForPic, paramHolder);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu)
  {
    if (AIOUtils.a(5) == 1) {
      paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if (URLDrawableHelper.hasDiskCache(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, 65537)) {
      paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu, boolean paramBoolean)
  {
    if (AIOUtils.a(1) == 1)
    {
      QQCustomMenuItem localQQCustomMenuItem = new QQCustomMenuItem(2131362241, this.jdField_a_of_type_AndroidContentContext.getString(2131693248));
      localQQCustomMenuItem.a(2130838910);
      localQQCustomMenuItem.a(paramBoolean ^ true);
      paramQQCustomMenu.a(localQQCustomMenuItem);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    long l = paramChatMessage.size;
    boolean bool2 = true;
    if (l <= 0L)
    {
      paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      boolean bool1 = bool2;
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        l = ((BaseTransProcessor)paramChatMessage).getFileStatus();
        bool1 = bool2;
        if (l != 1005L) {
          if (l == 1006L)
          {
            bool1 = bool2;
            if (!this.f) {}
          }
          else
          {
            if (l == 1004L) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    return paramChatMessage.extraflag == 32768;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    paramView = (MessageForPic)((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null) {
      if (paramView.isMultiMsg)
      {
        a(localQQCustomMenu, paramView, (ChatItemBuilder.BaseHolder)localObject);
      }
      else
      {
        b(localQQCustomMenu, paramView, (ChatItemBuilder.BaseHolder)localObject);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isSearch", true);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramView, (Bundle)localObject);
      }
    }
    return localQQCustomMenu.a();
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    paramBaseHolder = (BasePicItemBuilder.Holder)paramBaseHolder;
    this.f = true;
    int i = paramBaseHolder.a(localMessageForPic);
    paramBaseHolder.getClass();
    if (i == 1)
    {
      a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
      b(paramQQCustomMenu, localMessageForPic);
      a(paramQQCustomMenu, localMessageForPic);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, localMessageForPic, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramChatMessage, new Bundle());
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramChatMessage, new Bundle());
      a(paramQQCustomMenu);
      a(paramQQCustomMenu, paramChatMessage);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramChatMessage, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    }
    else
    {
      paramBaseHolder.getClass();
      if (i == 2)
      {
        a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
        b(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, localMessageForPic, null);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramChatMessage, new Bundle());
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramChatMessage, new Bundle());
        a(paramQQCustomMenu);
        a(paramQQCustomMenu, paramChatMessage);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramChatMessage, null);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
      }
      else
      {
        paramBaseHolder.getClass();
        if (i != 4)
        {
          paramBaseHolder.getClass();
          if (i != 5)
          {
            paramBaseHolder.getClass();
            if (i != 3) {
              break label462;
            }
            paramQQCustomMenu.a(2131364271, this.jdField_a_of_type_AndroidContentContext.getString(2131690787), 2130838901);
            if (this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              paramQQCustomMenu.a(2131364263, this.jdField_a_of_type_AndroidContentContext.getString(2131690786), 2130838900);
            }
            this.g = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            break label462;
          }
        }
        a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
        b(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramChatMessage, new Bundle());
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
      }
    }
    label462:
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramQQCustomMenu;
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    BasePicItemBuilder.2 local2 = new BasePicItemBuilder.2(this);
    AioPicTransFileController localAioPicTransFileController = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
    AioPicTransFileController.a(paramChatMessage.frienduin, local2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    super.a(2131371603, this.jdField_a_of_type_AndroidContentContext, paramMessageForPic);
  }
  
  protected abstract void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder);
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic)))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramMessageForPic.frienduin);
      ((StringBuilder)localObject2).append(paramMessageForPic.uniseq);
      ((PicProgressView)localObject1).setProgressKey(((StringBuilder)localObject2).toString());
      localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramMessageForPic.frienduin);
      ((StringBuilder)localObject2).append(paramMessageForPic.uniseq);
      ((PicProgressView)localObject1).b(((StringBuilder)localObject2).toString());
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject3 = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    Object localObject2 = ((BasePicItemBuilder.DrawURL)localObject3).a;
    int[] arrayOfInt = new int[2];
    int[] tmp168_166 = arrayOfInt;
    tmp168_166[0] = 0;
    int[] tmp172_168 = tmp168_166;
    tmp172_168[1] = 0;
    tmp172_168;
    if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject2)))
    {
      paramMessageForPic = paramHolder.jdField_a_of_type_ComTencentImageURLDrawable;
      arrayOfInt[0] = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      arrayOfInt[1] = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
    }
    else
    {
      if (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("holder.d=");
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
        ((StringBuilder)localObject1).append("==url=");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, arrayOfInt, (BasePicItemBuilder.DrawURL)localObject3);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = ((BasePicItemBuilder.DrawURL)localObject3);
      ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramMessageForPic, 2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("show receive pic uniseq=");
        ((StringBuilder)localObject3).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject3).append(" url=");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject3).toString());
      }
      paramMessageForPic = (MessageForPic)localObject1;
    }
    if (paramMessageForPic == null) {
      QLog.d("PicItemBuilder", 2, "d==null");
    }
    a(paramHolder, paramBoolean, arrayOfInt, (URL)localObject2);
    paramHolder.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void b(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic) {}
  
  protected void c(View paramView)
  {
    Object localObject = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = ((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
    if (!localMessageForPic.isSendFromLocal())
    {
      int i = paramView.getStatus();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if ((Utils.a()) && (Utils.b() < 31457280L))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708150), 0).a();
            return;
          }
          localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(paramView);
          if (localObject != null)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
            return;
          }
          if (FolderUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
            paramView.restartDownload();
          }
          return;
        }
        b(localMessageForPic, (BasePicItemBuilder.Holder)localObject);
        return;
      }
      if (!paramView.isDownloadStarted()) {
        paramView.startDownload();
      }
    }
    else
    {
      if (paramView.getStatus() == 2)
      {
        if ((Utils.a()) && (Utils.b() < 31457280L))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708154), 0).a();
          return;
        }
        String str = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(paramView);
        if (str != null)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
          return;
        }
        if (FolderUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
          paramView.restartDownload();
        }
      }
      b(localMessageForPic, (BasePicItemBuilder.Holder)localObject);
    }
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    AioPicTransFileController localAioPicTransFileController = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
    AioPicTransFileController.a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    b();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramMessageForPic, 1), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localURLDrawable, paramMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168), null, paramMessageForPic.picExtraData);
  }
  
  public void d()
  {
    super.d();
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.g = false;
    }
    this.f = false;
  }
  
  protected void d(ChatMessage paramChatMessage)
  {
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected abstract void d(MessageForPic paramMessageForPic);
  
  void e(MessageForPic paramMessageForPic)
  {
    String str = ((IPicAIO)QRoute.api(IPicAIO.class)).getSendPicFailedTip(paramMessageForPic);
    if (str != null)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      f(paramMessageForPic);
      return;
    }
    if (paramMessageForPic.picExtraFlag == 10) {
      g(paramMessageForPic);
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    BasePicItemBuilder.Holder localHolder = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    if (localHolder == null)
    {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
      return;
    }
    try
    {
      paramView = (MessageForPic)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    }
    catch (ClassCastException paramView)
    {
      QLog.e("PicItemBuilder", 2, "handleMessage(): cast exception", paramView);
      paramView = null;
    }
    if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (paramView != null))
    {
      boolean bool;
      int i;
      Object localObject;
      if ((paramInt1 == 2003) && (paramFileMsg.fileType == 65537))
      {
        bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramView.imageType);
        i = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        int j = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        localHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
        localObject = URLDrawableHelper.getURL(paramView, 65537);
        a(localHolder, bool, new int[] { i, j }, (URL)localObject);
      }
      if (((paramFileMsg.fileType == 1) || (paramFileMsg.fileType == 131075)) && (paramInt1 != 2002))
      {
        if (paramInt1 == 2001) {
          return;
        }
        if (paramView.uniseq == paramFileMsg.uniseq)
        {
          i = paramView.istroop;
          bool = paramView.isSendFromLocal();
          long l = paramView.uniseq;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("status:");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(",retCode");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append("message.uniseq：");
          ((StringBuilder)localObject).append(paramView.uniseq);
          ((StringBuilder)localObject).append(",file.uniseq:");
          ((StringBuilder)localObject).append(paramFileMsg.uniseq);
          RichMediaUtil.logUI(i, bool, 65537, String.valueOf(l), "PicItemBuilder.transf.in", ((StringBuilder)localObject).toString(), null);
          if (paramView.isSendFromLocal())
          {
            a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramView.frienduin, paramView.uniseq), localHolder);
            if (paramInt1 == 1005) {
              b();
            }
          }
          if (paramInt1 == 2003)
          {
            a(paramView, localHolder);
            paramView = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
            localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
            if (localHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
              localHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
            }
          }
        }
      }
      return;
    }
    QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364521) {
      c(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */