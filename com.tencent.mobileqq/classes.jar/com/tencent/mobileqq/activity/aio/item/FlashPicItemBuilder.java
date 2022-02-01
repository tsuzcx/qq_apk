package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.net.URL;
import java.util.HashSet;

public class FlashPicItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, FileTransferManager.Callback
{
  public static Drawable a;
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new FlashPicItemBuilder.1(this);
  private RoundRectDrawable jdField_a_of_type_ComTencentImageRoundRectDrawable;
  protected AioPicTransFileController a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private long jdField_c_of_type_Long;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  boolean f = false;
  private boolean g = true;
  
  public FlashPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController = new AioPicTransFileController();
    paramBaseAdapter = paramContext.getResources();
    float f1 = paramBaseAdapter.getDisplayMetrics().densityDpi / 160;
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130842743);
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramQQAppInterface instanceof BitmapDrawable)) {}
    for (paramQQAppInterface = ((BitmapDrawable)paramQQAppInterface).getBitmap();; paramQQAppInterface = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap())
    {
      this.jdField_a_of_type_ComTencentImageRoundRectDrawable = new RoundRectDrawable(paramBaseAdapter, new RoundRectBitmap(paramQQAppInterface, 12.0F * f1, 0, 0.0F));
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(637534208);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
      return;
      if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
        break;
      }
    }
  }
  
  public static Drawable a(Resources paramResources)
  {
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramResources, 2131166390);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      int i = (int)(paramResources.getDisplayMetrics().densityDpi / 160 * 12.0F);
      paramResources = new RoundedColorDrawable(paramResources.getColor(paramInt), AIOUtils.a(130.0F, paramResources), AIOUtils.a(102.0F, paramResources), i);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashPicItemBuilder", 2, "getReadedDrawable OOM");
      }
    }
    return null;
  }
  
  private static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = AIOUtils.a(130.0F, (Resources)localObject);
    int k = AIOUtils.a(130.0F, (Resources)localObject);
    URL localURL = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
    String str = localURL.toString();
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    if (AbsDownloader.getFile(str) != null)
    {
      URLDrawable.removeMemoryCacheByUrl(str);
      float f1 = i / 160;
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = j;
      paramContext.mRequestHeight = k;
      paramContext.mLoadingDrawable = a((Resources)localObject);
      paramContext.mFailedDrawable = a((Resources)localObject);
      paramContext.mPlayGifImage = false;
      paramContext.mGifRoundCorner = (f1 * 12.0F);
      paramContext.mMemoryCacheKeySuffix = "flashpic_";
      if (FlashPicHelper.a(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable(localURL, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.o);
      ((URLDrawable)localObject).setIgnorePause(true);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramContext = (Context)localObject;
      if (paramChatThumbView != null)
      {
        paramChatThumbView.jdField_a_of_type_Boolean = true;
        paramContext = (Context)localObject;
      }
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
      paramContext.setTag(paramMessageForPic);
      return paramContext;
      if (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {}
      for (i = 1;; i = 0)
      {
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        paramContext.mRequestWidth = j;
        paramContext.mRequestHeight = k;
        paramContext.mLoadingDrawable = a((Resources)localObject);
        paramContext.mFailedDrawable = a((Resources)localObject);
        paramContext.mGifRoundCorner = 12.0F;
        paramContext.mImgType = paramMessageForPic.imageType;
        paramContext.mMemoryCacheKeySuffix = "flashpic_";
        if (FlashPicHelper.a(paramMessageForPic)) {
          paramContext.isFlashPic = true;
        }
        paramContext = URLDrawable.getDrawable(localURL, paramContext);
        paramContext.setDecodeHandler(URLDrawableDecodeHandler.o);
        if ((!PicContants.jdField_a_of_type_Boolean) && (i == 0)) {
          break label326;
        }
        paramContext.setAutoDownload(true);
        break;
      }
      label326:
      paramContext.setAutoDownload(false);
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    PicUploadInfo.Builder localBuilder;
    int i;
    if (FileUtils.b(paramMessageForPic.path))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      localBuilder = new PicUploadInfo.Builder();
      localBuilder.a(paramMessageForPic.path);
      if (!HotChatHelper.a(paramMessageForPic)) {
        break label231;
      }
      i = 1039;
      localBuilder.d(i);
      localBuilder.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag != 1) {
        break label238;
      }
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
    }
    for (;;)
    {
      localBuilder.e(paramMessageForPic.senderuin);
      localBuilder.c(paramMessageForPic.selfuin);
      localBuilder.e(paramMessageForPic.istroop);
      localBuilder.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localBuilder.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.a = paramMessageForPic.msgseq;
      localRetryInfo.b = paramMessageForPic.shmsgseq;
      localRetryInfo.a = paramMessageForPic.msgseq;
      localBuilder.a(localRetryInfo);
      paramMessageForPic = PicBusiManager.a(4, i);
      paramMessageForPic.a(localBuilder.a());
      PicBusiManager.a(paramMessageForPic);
      b();
      return;
      label231:
      i = 1040;
      break;
      label238:
      localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HotChatFlashPicActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", AIOGalleryUtils.a(paramMessageForPic));
    localBundle.putBoolean("isreaded", false);
    localBundle.putLong("uniseq", paramMessageForPic.uniseq);
    localBundle.putString("md5", paramMessageForPic.md5);
    localBundle.putBoolean("is_send", paramMessageForPic.isSend());
    localBundle.putString("self_uin", paramMessageForPic.selfuin);
    localBundle.putInt("curtype", paramMessageForPic.istroop);
    localBundle.putBoolean("self_identify", HotChatHelper.a(paramMessageForPic));
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (PeakUtils.a != null) {
        PeakUtils.a.b();
      }
      return;
      if (paramMessageForPic.istroop == 3000) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
      } else if (paramMessageForPic.istroop == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, FlashPicItemBuilder.FlashPicHolder paramFlashPicHolder)
  {
    if ((paramFlashPicHolder == null) || (paramFlashPicHolder.jdField_a_of_type_AndroidViewView == null)) {}
    while (!(paramIHttpCommunicatorListener instanceof BaseTransProcessor)) {
      return;
    }
    int i = (int)((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus();
    if (paramFlashPicHolder.b)
    {
      switch (i)
      {
      default: 
        if (i == 1003) {
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      }
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      return;
    }
    switch (i)
    {
    default: 
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    case 1000: 
    case 1001: 
    case 1002: 
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      return;
    case 1003: 
      paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    Object localObject1;
    if ((!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) && (paramBaseChatItemLayout != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.istroop, paramBaseChatItemLayout.uniseq);
      if ((localObject1 instanceof MessageForPic)) {
        paramBaseChatItemLayout = (MessageForPic)localObject1;
      }
    }
    for (;;)
    {
      boolean bool1 = FlashPicHelper.a(paramBaseChatItemLayout);
      localObject1 = (FlashPicItemBuilder.FlashPicHolder)paramViewHolder;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131373117);
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(15.0F);
        paramView.d(false);
        paramView.setShowEdge(true);
        paramView.b = false;
        paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
        BubbleImageView localBubbleImageView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        localBubbleImageView.setAdjustViewBounds(true);
        localBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localBubbleImageView.setRadius(15.0F);
        localBubbleImageView.d(false);
        Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373117);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131373117);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131373117);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131373117);
        paramViewHolder.addView(localBubbleImageView, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localImageView.setId(2131368270);
        Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(14);
        ((RelativeLayout)localObject3).addView(localImageView, (ViewGroup.LayoutParams)localObject4);
        localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject4).setText(((Resources)localObject2).getText(2131693276));
        ((TextView)localObject4).setTextSize(12.0F);
        ((TextView)localObject4).setTextColor(((Resources)localObject2).getColor(2131167374));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(3, 2131368270);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = AIOUtils.a(10.0F, (Resources)localObject2);
        ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        paramViewHolder.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
        ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = localBubbleImageView;
        ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = localImageView;
        ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      }
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).b = bool1;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.a(bool1);
      boolean bool2;
      if (bool1)
      {
        bool2 = FlashPicHelper.b(paramBaseChatItemLayout);
        bool1 = false;
        paramView = URLDrawableHelper.getURL(paramBaseChatItemLayout, 65537);
        if ((!bool2) || (!((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_Boolean)) {
          break label690;
        }
        bool1 = true;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FlashPicItemBuilder", 4, "isReuse:" + bool1 + ",isReaded:" + bool2);
        }
        a(paramChatMessage, paramViewHolder, this);
        if (paramBaseChatItemLayout.isSendFromLocal())
        {
          ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidViewView = paramViewHolder;
          a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (FlashPicItemBuilder.FlashPicHolder)localObject1);
        }
        return paramViewHolder;
        bool2 = HotChatHelper.b(paramBaseChatItemLayout);
        break;
        label690:
        if ((!bool2) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
        {
          bool1 = true;
        }
        else
        {
          ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_Boolean = bool2;
          if (bool2)
          {
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842739);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.jdField_a_of_type_ComTencentImageRoundRectDrawable);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = null;
          }
          else
          {
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842740);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, null);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
            ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
          }
        }
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return this;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new FlashPicItemBuilder.FlashPicHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131704644);
    }
    return HardCodeUtil.a(2131704645);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
      AioPicTransFileController.a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      b();
      return;
      FlashPicItemBuilder.2 local2 = new FlashPicItemBuilder.2(this);
      AioPicTransFileController localAioPicTransFileController = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
      AioPicTransFileController.a(paramChatMessage.frienduin, local2);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForPic)((FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131690018, 5);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new FlashPicItemBuilder.3(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof FlashPicItemBuilder.FlashPicHolder)) {
      return;
    }
    paramView = (FlashPicItemBuilder.FlashPicHolder)paramView;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashPicItemBuilder", 2, "status:" + paramInt1 + ",retCode:" + paramInt2);
    }
    if (((paramFileMsg.fileType != 1) && (paramFileMsg.fileType != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
      return;
    }
    if ((paramInt1 == 1001) || (paramInt1 == 1000) || (paramInt1 == 4001) || (paramInt1 == 1002) || (paramInt1 == 1004) || (paramInt1 == 1005)) {}
    for (this.g = false;; this.g = true) {
      do
      {
        paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
        if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
          break;
        }
        MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localMessageForPic.uniseq != paramFileMsg.uniseq) || (!localMessageForPic.isSendFromLocal())) {
          break;
        }
        a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        return;
      } while ((paramInt1 != 1007) && (paramInt1 != 1003));
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof FlashPicItemBuilder.FlashPicHolder)) {
      return;
    }
    paramView = (FlashPicItemBuilder.FlashPicHolder)paramView;
    if (paramBoolean)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (!paramChatMessage.isSendFromLocal()) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        paramChatMessage = (MessageForPic)paramChatMessage;
        if (paramChatMessage.size > 0L) {
          break;
        }
        paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      } while (!(paramChatMessage instanceof BaseTransProcessor));
      if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.b)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) || (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
        {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, localMessageForPic, new Bundle());
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, localMessageForPic, new Bundle());
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
        }
        return localQQCustomMenu.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(localMessageForPic))) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, localMessageForPic, new Bundle());
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, localMessageForPic, new Bundle());
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      }
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      paramView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((paramView instanceof BaseTransProcessor))
      {
        paramView = (BaseTransProcessor)paramView;
        long l = paramView.getFileStatus();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramView.getLastFileStatus() == 1003L))
        {
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
        }
        else
        {
          localQQCustomMenu.a(2131364373, this.jdField_a_of_type_AndroidContentContext.getString(2131690859), 2130839048);
          if (this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            localQQCustomMenu.a(2131364361, this.jdField_a_of_type_AndroidContentContext.getString(2131690858), 2130839047);
          }
          this.f = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
        continue;
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */