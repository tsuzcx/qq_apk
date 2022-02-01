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
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
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
  implements BaseBubbleBuilder.TouchDelegate, Callback
{
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new FlashPicItemBuilder.1(this);
  private RoundRectDrawable jdField_a_of_type_ComTencentImageRoundRectDrawable;
  protected AioPicTransFileController a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private long c;
  boolean f = false;
  private boolean g = true;
  
  public FlashPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController = new AioPicTransFileController();
    paramBaseAdapter = paramContext.getResources();
    float f1 = paramBaseAdapter.getDisplayMetrics().densityDpi / 160;
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130842642);
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramQQAppInterface instanceof BitmapDrawable))
    {
      paramQQAppInterface = ((BitmapDrawable)paramQQAppInterface).getBitmap();
    }
    else
    {
      if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
        return;
      }
      paramQQAppInterface = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
    }
    this.jdField_a_of_type_ComTencentImageRoundRectDrawable = new RoundRectDrawable(paramBaseAdapter, new RoundRectBitmap(paramQQAppInterface, f1 * 12.0F, 0, 0.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(637534208);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  private static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = AIOUtils.b(130.0F, (Resources)localObject);
    int k = AIOUtils.b(130.0F, (Resources)localObject);
    localObject = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
    String str = ((URL)localObject).toString();
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
      paramContext.mLoadingDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mFailedDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mPlayGifImage = false;
      paramContext.mGifRoundCorner = (f1 * 12.0F);
      paramContext.mMemoryCacheKeySuffix = "flashpic_";
      if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable((URL)localObject, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicDecodeHandler());
      ((URLDrawable)localObject).setIgnorePause(true);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramContext = (Context)localObject;
      if (paramChatThumbView != null)
      {
        paramChatThumbView.jdField_a_of_type_Boolean = true;
        paramContext = (Context)localObject;
      }
    }
    else
    {
      boolean bool = URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = j;
      paramContext.mRequestHeight = k;
      paramContext.mLoadingDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mFailedDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mGifRoundCorner = 12.0F;
      paramContext.mImgType = paramMessageForPic.imageType;
      paramContext.mMemoryCacheKeySuffix = "flashpic_";
      if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      paramContext = URLDrawable.getDrawable((URL)localObject, paramContext);
      paramContext.setDecodeHandler(((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicDecodeHandler());
      if ((!PicContants.jdField_a_of_type_Boolean) && (!(bool ^ true))) {
        paramContext.setAutoDownload(false);
      } else {
        paramContext.setAutoDownload(true);
      }
    }
    paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
    paramContext.setTag(paramMessageForPic);
    return paramContext;
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.a(paramMessageForPic.path);
      int i;
      if (HotChatHelper.a(paramMessageForPic)) {
        i = 1039;
      } else {
        i = 1040;
      }
      localBuilder.d(i);
      localBuilder.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localBuilder.c(1);
      } else {
        localBuilder.c(0);
      }
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
      paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, i);
      paramMessageForPic.a(localBuilder.a());
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramMessageForPic);
    }
    b();
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatFlashPicActivityClass());
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
    } else if (paramMessageForPic.istroop == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
    } else if (paramMessageForPic.istroop == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
    }
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, FlashPicItemBuilder.FlashPicHolder paramFlashPicHolder)
  {
    if (paramFlashPicHolder != null)
    {
      if (paramFlashPicHolder.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
      {
        int i = (int)((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus();
        if (paramFlashPicHolder.b)
        {
          if (i != 1006)
          {
            if (i != 4001) {
              switch (i)
              {
              default: 
                if (i == 1003) {
                  paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                }
                paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
                return;
              }
            }
            paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
            paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
            return;
          }
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          return;
        }
        switch (i)
        {
        default: 
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          return;
        case 1004: 
        case 1005: 
        case 1006: 
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          return;
        case 1003: 
          paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
          return;
        }
        paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
        paramFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
    Object localObject2;
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
        paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
        if ((localObject2 instanceof MessageForPic)) {
          paramBaseChatItemLayout = (MessageForPic)localObject2;
        }
      }
    }
    boolean bool1 = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramBaseChatItemLayout);
    localObject1 = (FlashPicItemBuilder.FlashPicHolder)paramViewHolder;
    if (paramView == null)
    {
      Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372696);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(true);
      paramView.b = false;
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).d(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372696);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372696);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131372696);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131372696);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131368022);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131693230));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167394));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131368022);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = AIOUtils.b(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject2);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = localImageView;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
    }
    else
    {
      paramViewHolder = paramView;
    }
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).b = bool1;
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.a(bool1);
    boolean bool2;
    if (bool1) {
      bool2 = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsgReaded(paramBaseChatItemLayout);
    } else {
      bool2 = HotChatHelper.b(paramBaseChatItemLayout);
    }
    paramView = URLDrawableHelper.getURL(paramBaseChatItemLayout, 65537);
    if ((bool2) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_Boolean)) {}
    while ((!bool2) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
    {
      bool1 = true;
      break;
    }
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_Boolean = bool2;
    if (bool2)
    {
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842638);
      paramView = ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      bool1 = false;
      paramView.setVisibility(0);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.jdField_a_of_type_ComTencentImageRoundRectDrawable);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    else
    {
      bool1 = false;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842639);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, null);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    }
    if (QLog.isDevelopLevel())
    {
      paramView = new StringBuilder();
      paramView.append("isReuse:");
      paramView.append(bool1);
      paramView.append(",isReaded:");
      paramView.append(bool2);
      QLog.d("FlashPicItemBuilder", 4, paramView.toString());
    }
    a(paramChatMessage, paramViewHolder, this);
    if (paramBaseChatItemLayout.isSendFromLocal())
    {
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).jdField_a_of_type_AndroidViewView = paramViewHolder;
      a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (FlashPicItemBuilder.FlashPicHolder)localObject1);
    }
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return this;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new FlashPicItemBuilder.FlashPicHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131704724);
    }
    return HardCodeUtil.a(2131704725);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131364263)
    {
      if (paramInt != 2131364271)
      {
        if (paramInt == 2131365480) {
          ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        }
      }
      else
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
        AioPicTransFileController.a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        b();
      }
    }
    else
    {
      FlashPicItemBuilder.2 local2 = new FlashPicItemBuilder.2(this);
      AioPicTransFileController localAioPicTransFileController = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController;
      AioPicTransFileController.a(paramChatMessage.frienduin, local2);
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MessageForPic)((FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131689933, 5);
      localActionSheet.addCancelButton(2131690728);
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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    long l = paramChatMessage.size;
    boolean bool = true;
    if (l <= 0L)
    {
      paramChatMessage = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return paramChatMessage.extraflag == 32768;
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
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, localMessageForPic, new Bundle());
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, localMessageForPic, new Bundle());
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
        }
        return localQQCustomMenu.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(localMessageForPic))) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, localMessageForPic, new Bundle());
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, localMessageForPic, new Bundle());
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
      }
      else
      {
        paramView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq);
        if ((paramView instanceof BaseTransProcessor))
        {
          paramView = (BaseTransProcessor)paramView;
          long l = paramView.getFileStatus();
          if ((l != 1005L) && (l != 1006L) && (l != 1004L) && (paramView.getLastFileStatus() != 1003L))
          {
            localQQCustomMenu.a(2131364271, this.jdField_a_of_type_AndroidContentContext.getString(2131690787), 2130838901);
            if (this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              localQQCustomMenu.a(2131364263, this.jdField_a_of_type_AndroidContentContext.getString(2131690786), 2130838900);
            }
            this.f = this.jdField_a_of_type_ComTencentMobileqqPicAioAioPicTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
            super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
          }
        }
        else
        {
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
        }
      }
    }
    else
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    return localQQCustomMenu.a();
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
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",retCode:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("FlashPicItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramFileMsg.fileType == 1) || (paramFileMsg.fileType == 131075)) && (paramInt1 != 2002))
    {
      if (paramInt1 == 2001) {
        return;
      }
      if ((paramInt1 != 1001) && (paramInt1 != 1000) && (paramInt1 != 4001) && (paramInt1 != 1002) && (paramInt1 != 1004) && (paramInt1 != 1005))
      {
        if ((paramInt1 == 1007) || (paramInt1 == 1003)) {
          this.g = true;
        }
      }
      else {
        this.g = false;
      }
      paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
      if (paramView != null)
      {
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
          return;
        }
        localObject = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((((MessageForPic)localObject).uniseq == paramFileMsg.uniseq) && (((MessageForPic)localObject).isSendFromLocal())) {
          a(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(((MessageForPic)localObject).frienduin, ((MessageForPic)localObject).uniseq), paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */