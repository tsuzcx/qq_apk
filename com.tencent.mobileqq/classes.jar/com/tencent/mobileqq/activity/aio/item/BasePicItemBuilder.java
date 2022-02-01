package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
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
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject;
import com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject.Builder;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BasePicItemBuilder
  extends QIMTailItemBubbleBuilder
  implements ContextMenuBuilder2, FileTransferManager.Callback
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
    int j = 2;
    int i;
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while ((paramContext instanceof ChatHistoryActivity));
        i = j;
      } while ((paramContext instanceof ChatHistory));
      if (!(paramContext instanceof PublicFragmentActivity)) {
        break;
      }
      i = j;
    } while ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment));
    while (!(paramContext instanceof MultiForwardActivity)) {
      return -1;
    }
    return 5;
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
    localIntent.putExtra("forward_download_image_task_key", paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop);
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
    if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label617;
      }
    }
    label617:
    for (int i = 65537;; i = 1)
    {
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
      if (!FileUtils.b(paramMessageForPic.path)) {
        break label623;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      i = 0;
      break;
    }
    label623:
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
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
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
      paramBundle.putBoolean("extra.IS_HOT_CHAT", HotChatUtil.a(paramChatMessage));
    }
    String str;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      str = paramChatMessage.selfuin;
      paramView = str;
      if (!paramChatMessage.isMultiMsg) {}
    }
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
      for (;;)
      {
        paramView.printStackTrace();
        paramView = str;
      }
      paramView = (MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      paramBoolean = paramView.a(paramChatMessage);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean);
      if (!paramBoolean) {
        break label325;
      }
      paramView = paramView.a(paramView.a(paramChatMessage));
      if ((paramView == null) || (paramView.d != 1)) {
        break label325;
      }
      paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramView.c);
      label325:
      i = a(paramContext);
      if (!(paramChatMessage instanceof MessageForPic)) {
        break label382;
      }
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    paramBundle.putString("uin", paramChatMessage.frienduin);
    paramSessionInfo = new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((paramView == null) || (paramChatMessage.frienduin == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
      }
    }
    for (;;)
    {
      return;
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      int i;
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, paramBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1, i);
      while (QLog.isColorLevel())
      {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
        return;
        label382:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          PeakUtils.a(paramContext, paramBundle, paramSessionInfo, AIOGalleryUtils.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
        }
      }
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366428, paramChatMessage, null);
    }
    while (i != 1) {
      return;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366427, paramChatMessage, null);
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, BasePicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int i = (int)paramIHttpCommunicatorListener.getFileStatus();
      switch (i)
      {
      default: 
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
            break label680;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        break;
      }
      for (;;)
      {
        if (i == 1003) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
        if ((paramIHttpCommunicatorListener.isRawPic()) && (!this.f))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = true;
        return;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          PicProgressView localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          localPicProgressView.setRadius(12.0F, true);
          localPicProgressView.setSharpCornerCor(BubbleImageView.a);
          localPicProgressView.setShowCorner(false);
          localPicProgressView.setCustomSize(1);
          localPicProgressView.setProgressBackgroudColor(2130706432);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131373117);
          localLayoutParams.addRule(8, 2131373117);
          localLayoutParams.addRule(5, 2131373117);
          localLayoutParams.addRule(7, 2131373117);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
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
        label680:
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
      }
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  private void c(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder)
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager != null) && (paramMessageForPic != null) && (paramHolder != null))
    {
      paramMessageForPic = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic);
      if ((localObject != null) && (((FileSaveResult)localObject).d == 1))
      {
        if (((FileSaveResult)localObject).c >= 0) {
          break label318;
        }
        i = 0;
      }
    }
    for (;;)
    {
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
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131373117);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131373117);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131373117);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131373117);
        ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramMessageForPic;
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean = false;
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(i);
        paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setShowProgress(true);
      }
      return;
      label318:
      if (((FileSaveResult)localObject).c > 100) {
        i = 100;
      } else {
        i = ((FileSaveResult)localObject).c;
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
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
    }
    for (;;)
    {
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
      ((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
      localObject = PicBusiManager.a(4, 5);
      ((PicReq)localObject).a(localBuilder.a());
      ((PicReq)localObject).a = paramMessageForPic.picExtraData;
      PicBusiManager.a((PicReq)localObject);
      return;
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    }
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
    ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
    ((PicUploadInfo.Builder)localObject2).b(paramMessageForPic.uniseq);
    ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUploadInfo.Builder)localObject2).a();
    if ((!FileUtils.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
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
    ((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPic.uniseq);
    paramMessageForPic = PicBusiManager.a(3, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    PicBusiManager.a(paramMessageForPic);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool2 = PeakUtils.a(paramBaseChatItemLayout.imageType);
    BasePicItemBuilder.Holder localHolder;
    try
    {
      localHolder = (BasePicItemBuilder.Holder)paramViewHolder;
      if (localHolder == null) {
        return paramView;
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
      throw new ClassCastException("picitem holer Exception e= " + paramChatMessage);
    }
    localHolder.jdField_a_of_type_Boolean = bool2;
    paramViewHolder = paramView;
    int i;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131373117);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramView.e = true;
      }
      paramView.setId(2131373117);
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
      localLayoutParams.addRule(7, 2131373117);
      localLayoutParams.addRule(8, 2131373117);
      paramViewHolder.addView(paramView, localLayoutParams);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
    }
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    int j = (int)Math.max(paramBaseChatItemLayout.width, paramBaseChatItemLayout.height);
    boolean bool1;
    if (!PicItemBuilder.a(paramBaseChatItemLayout))
    {
      bool1 = true;
      i = AIOImgThumbHelper.getAioThumbMaxPx(bool2, bool1, j);
      if (PicItemBuilder.a(paramBaseChatItemLayout)) {
        break label572;
      }
      bool1 = true;
      label342:
      j = AIOImgThumbHelper.getAioThumbMinPx(bool2, bool1, j);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if ((PicItemBuilder.a(paramBaseChatItemLayout)) || (bool2)) {
        break label578;
      }
      bool1 = true;
      label393:
      paramView.setShowEdge(bool1);
      if (e) {
        paramView.setContentDescription(HardCodeUtil.a(2131708133));
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label584;
      }
      b(paramBaseChatItemLayout, localHolder, paramViewHolder, bool2);
      label434:
      if (QLog.isColorLevel())
      {
        paramOnLongClickAndTouchListener = new StringBuilder().append("getView ");
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL == null) {
          break label598;
        }
      }
    }
    label572:
    label578:
    label584:
    label598:
    for (paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.toString();; paramView = "")
    {
      QLog.d("PicItemBuilder", 2, paramView + ", isDynamic=" + bool2 + ", thumbWidth=" + paramBaseChatItemLayout.thumbWidth + ", thumbHeight=" + paramBaseChatItemLayout.thumbHeight + ", thumbMaxSize=" + i + ", thumbMinSize=" + j);
      a(paramChatMessage, paramViewHolder, this);
      c(paramBaseChatItemLayout, localHolder);
      return paramViewHolder;
      bool1 = false;
      break;
      bool1 = false;
      break label342;
      bool1 = false;
      break label393;
      a(paramBaseChatItemLayout, localHolder, paramViewHolder, bool2);
      break label434;
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
  
  public BaseBubbleBuilder.ViewHolder a()
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
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131708134);
    }
    return HardCodeUtil.a(2131708135);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForPic localMessageForPic;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramChatMessage;
      if (paramInt == 2131367398) {
        d(localMessageForPic);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131362218)
    {
      c(localMessageForPic);
      return;
    }
    if (paramInt == 2131365636)
    {
      d(paramChatMessage);
      return;
    }
    if (paramInt == 2131371997)
    {
      b(localMessageForPic);
      return;
    }
    if (paramInt == 2131377023)
    {
      e(localMessageForPic);
      return;
    }
    if (paramInt == 2131366625)
    {
      a(localMessageForPic);
      return;
    }
    if (paramInt == 2131364373)
    {
      c(paramChatMessage);
      return;
    }
    if (paramInt == 2131364361)
    {
      b(paramChatMessage);
      return;
    }
    if (paramInt == 2131371985)
    {
      super.a(2131371997, paramContext, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((BasePicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131690018, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new BasePicItemBuilder.3(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    BasePicItemBuilder.Holder localHolder = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    if (localHolder == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            paramView = (MessageForPic)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (paramView == null))
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
              return;
            }
          }
          catch (ClassCastException paramView)
          {
            for (;;)
            {
              QLog.e("PicItemBuilder", 2, "handleMessage(): cast exception", paramView);
              paramView = null;
            }
            if ((paramInt1 == 2003) && (paramFileMsg.fileType == 65537))
            {
              boolean bool = PeakUtils.a(paramView.imageType);
              int i = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
              int j = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
              localHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
              URL localURL = URLDrawableHelper.getURL(paramView, 65537);
              a(localHolder, bool, new int[] { i, j }, localURL);
            }
          }
        } while (((paramFileMsg.fileType != 1) && (paramFileMsg.fileType != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001) || (paramView.uniseq != paramFileMsg.uniseq));
        RichMediaUtil.logUI(paramView.istroop, paramView.isSendFromLocal(), 65537, String.valueOf(paramView.uniseq), "PicItemBuilder.transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + paramView.uniseq + ",file.uniseq:" + paramFileMsg.uniseq, null);
        if (paramView.isSendFromLocal())
        {
          a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramView.frienduin, paramView.uniseq), localHolder);
          if (paramInt1 == 1005) {
            b();
          }
        }
      } while (paramInt1 != 2003);
      a(paramView, localHolder);
      paramView = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    } while (localHolder.jdField_a_of_type_ComTencentImageURLDrawable == null);
    localHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().b(paramMessageForPic, 2);
    }
  }
  
  abstract void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder);
  
  protected void a(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    if (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    BasePicItemBuilder.DrawURL localDrawURL = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    URL localURL = localDrawURL.a;
    if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, null, localDrawURL);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = localDrawURL;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "predownloadDynamic pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        }
        a(paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "show send pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
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
      paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic)
  {
    if (URLDrawableHelper.hasDiskCache(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, 65537)) {
      paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
    }
  }
  
  void a(QQCustomMenu paramQQCustomMenu, boolean paramBoolean)
  {
    boolean bool = true;
    QQCustomMenuItem localQQCustomMenuItem;
    if (AIOUtils.a(1) == 1)
    {
      localQQCustomMenuItem = new QQCustomMenuItem(2131362218, this.jdField_a_of_type_AndroidContentContext.getString(2131693294));
      localQQCustomMenuItem.a(2130839057);
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localQQCustomMenuItem.a(paramBoolean);
      paramQQCustomMenu.a(localQQCustomMenuItem);
      return;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {}
    while (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    if (paramChatMessage.size <= 0L)
    {
      paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramChatMessage).getFileStatus();
        if ((l == 1005L) || ((l == 1006L) && (!this.f)) || (l == 1004L)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    if (paramChatMessage.extraflag == 32768) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    paramView = (MessageForPic)((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label48;
      }
      a(localQQCustomMenu, paramView, (ChatItemBuilder.BaseHolder)localObject);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      label48:
      b(localQQCustomMenu, paramView, (ChatItemBuilder.BaseHolder)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSearch", true);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramView, (Bundle)localObject);
    }
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
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, localMessageForPic, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramChatMessage, new Bundle());
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramChatMessage, new Bundle());
      a(paramQQCustomMenu);
      a(paramQQCustomMenu, paramChatMessage);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramChatMessage, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    }
    for (;;)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramQQCustomMenu;
      paramBaseHolder.getClass();
      if (i == 2)
      {
        a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
        b(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu, localMessageForPic);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, localMessageForPic, null);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramChatMessage, new Bundle());
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramChatMessage, new Bundle());
        a(paramQQCustomMenu);
        a(paramQQCustomMenu, paramChatMessage);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramChatMessage, null);
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      }
      else
      {
        paramBaseHolder.getClass();
        if (i != 4)
        {
          paramBaseHolder.getClass();
          if (i != 5) {}
        }
        else
        {
          a(paramQQCustomMenu, paramBaseHolder.jdField_a_of_type_Boolean);
          b(paramQQCustomMenu, localMessageForPic);
          a(paramQQCustomMenu, localMessageForPic);
          a(paramQQCustomMenu);
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramChatMessage, new Bundle());
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
          continue;
        }
        paramBaseHolder.getClass();
        if (i == 3)
        {
          paramQQCustomMenu.a(2131364373, this.jdField_a_of_type_AndroidContentContext.getString(2131690859), 2130839048);
          if (this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            paramQQCustomMenu.a(2131364361, this.jdField_a_of_type_AndroidContentContext.getString(2131690858), 2130839047);
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
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
    super.a(2131371997, this.jdField_a_of_type_AndroidContentContext, paramMessageForPic);
  }
  
  protected abstract void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder);
  
  protected void b(MessageForPic paramMessageForPic, BasePicItemBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) && (!this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(paramMessageForPic)))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramMessageForPic.frienduin + paramMessageForPic.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
    Object localObject = new BasePicItemBuilder.DrawURL(paramMessageForPic);
    URL localURL = ((BasePicItemBuilder.DrawURL)localObject).a;
    int[] arrayOfInt = new int[2];
    int[] tmp140_138 = arrayOfInt;
    tmp140_138[0] = 0;
    int[] tmp144_140 = tmp140_138;
    tmp144_140[1] = 0;
    tmp144_140;
    if ((paramHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localURL)))
    {
      if (paramHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        QLog.d("PicItemBuilder", 2, "holder.d=" + paramHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + localURL);
      }
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPic, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, arrayOfInt, (BasePicItemBuilder.DrawURL)localObject);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(localURLDrawable);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = ((BasePicItemBuilder.DrawURL)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(paramMessageForPic, 2);
      localObject = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.d("PicItemBuilder", 2, "show receive pic uniseq=" + paramMessageForPic.uniseq + " url=" + localURL);
        localObject = localURLDrawable;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.d("PicItemBuilder", 2, "d==null");
      }
      a(paramHolder, paramBoolean, arrayOfInt, localURL);
      paramHolder.jdField_a_of_type_AndroidViewView = paramView;
      return;
      localObject = paramHolder.jdField_a_of_type_ComTencentImageURLDrawable;
      arrayOfInt[0] = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
      arrayOfInt[1] = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
    }
  }
  
  protected void b(QQCustomMenu paramQQCustomMenu, MessageForPic paramMessageForPic) {}
  
  protected void c(View paramView)
  {
    Object localObject = (BasePicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = ((BasePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
    if (!localMessageForPic.isSendFromLocal())
    {
      switch (paramView.getStatus())
      {
      default: 
      case 2: 
      case 0: 
        do
        {
          do
          {
            return;
            if ((Utils.a()) && (Utils.b() < 20971520L))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708132), 0).a();
              return;
            }
            localObject = PicDownloadExplicitError.getFailedTip(paramView);
            if (localObject != null)
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
              return;
            }
          } while (!FolderUtils.a(this.jdField_a_of_type_AndroidContentContext));
          paramView.restartDownload();
          return;
        } while (paramView.isDownloadStarted());
        paramView.startDownload();
        return;
      }
      b(localMessageForPic, (BasePicItemBuilder.Holder)localObject);
      return;
    }
    if (paramView.getStatus() == 2)
    {
      if ((Utils.a()) && (Utils.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708136), 0).a();
        return;
      }
      String str = PicDownloadExplicitError.getFailedTip(paramView);
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
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localURLDrawable, paramMessageForPic.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166), null, paramMessageForPic.picExtraData);
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
    String str = PicUploadExplicitError.getFailedTip(paramMessageForPic);
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
    }
    do
    {
      return;
      if (FileUtils.b(paramMessageForPic.path))
      {
        f(paramMessageForPic);
        return;
      }
    } while (paramMessageForPic.picExtraFlag != TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
    g(paramMessageForPic);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364634) {
      c(paramView);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */