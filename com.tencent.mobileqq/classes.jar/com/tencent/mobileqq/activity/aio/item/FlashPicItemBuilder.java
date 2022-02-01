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
  private static final HashSet<String> y = new HashSet();
  private long A;
  private Drawable B;
  private Drawable C;
  private View.OnClickListener D = new FlashPicItemBuilder.1(this);
  boolean a = false;
  protected AioPicTransFileController w = new AioPicTransFileController();
  private boolean x = true;
  private RoundRectDrawable z;
  
  public FlashPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramBaseAdapter = paramContext.getResources();
    int i = paramBaseAdapter.getDisplayMetrics().densityDpi;
    float f1 = URLDrawableHelper.getRoundCorner();
    float f2 = i / 160;
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130843595);
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
    this.z = new RoundRectDrawable(paramBaseAdapter, new RoundRectBitmap(paramQQAppInterface, f1 * f2, 0, 0.0F));
    this.B = new ColorDrawable(637534208);
    this.C = new ColorDrawable(0);
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
      paramChatThumbView.b = false;
    }
    if (AbsDownloader.getFile(str) != null)
    {
      URLDrawable.removeMemoryCacheByUrl(str);
      float f1 = URLDrawableHelper.getRoundCorner();
      float f2 = i / 160;
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = j;
      paramContext.mRequestHeight = k;
      paramContext.mLoadingDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mFailedDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
      paramContext.mPlayGifImage = false;
      paramContext.mGifRoundCorner = (f1 * f2);
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
        paramChatThumbView.b = true;
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
      paramContext.mGifRoundCorner = URLDrawableHelper.getRoundCorner();
      paramContext.mImgType = paramMessageForPic.imageType;
      paramContext.mMemoryCacheKeySuffix = "flashpic_";
      if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      paramContext = URLDrawable.getDrawable((URL)localObject, paramContext);
      paramContext.setDecodeHandler(((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicDecodeHandler());
      if ((!PicContants.a) && (!(bool ^ true))) {
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
      this.d.getMessageFacade().h(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
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
      localBuilder.A = paramMessageForPic.extLong;
      localBuilder.B = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.a = paramMessageForPic.msgseq;
      localRetryInfo.b = paramMessageForPic.shmsgseq;
      localRetryInfo.a = paramMessageForPic.msgseq;
      localBuilder.a(localRetryInfo);
      paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, i);
      paramMessageForPic.a(localBuilder.k());
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramMessageForPic);
    }
    d();
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.e, ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatFlashPicActivityClass());
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
    this.e.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      ReportController.b(this.d, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    } else if (paramMessageForPic.istroop == 3000) {
      ReportController.b(this.d, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
    } else if (paramMessageForPic.istroop == 1) {
      ReportController.b(this.d, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
    }
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, FlashPicItemBuilder.FlashPicHolder paramFlashPicHolder)
  {
    if (paramFlashPicHolder != null)
    {
      if (paramFlashPicHolder.h == null) {
        return;
      }
      if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
      {
        int i = (int)((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus();
        if (paramFlashPicHolder.g)
        {
          if (i != 1006)
          {
            if (i != 4001) {
              switch (i)
              {
              default: 
                if (i == 1003) {
                  paramFlashPicHolder.j.setFailedIconVisable(false, this);
                }
                paramFlashPicHolder.j.setProgressVisable(false);
                return;
              }
            }
            paramFlashPicHolder.j.setFailedIconVisable(false, this);
            paramFlashPicHolder.j.setProgressVisable(true);
            return;
          }
          paramFlashPicHolder.j.setProgressVisable(false);
          return;
        }
        switch (i)
        {
        default: 
          paramFlashPicHolder.j.setProgressVisable(false);
          paramFlashPicHolder.j.setFailedIconVisable(true, this);
          return;
        case 1004: 
        case 1005: 
        case 1006: 
          paramFlashPicHolder.j.setProgressVisable(false);
          paramFlashPicHolder.j.setFailedIconVisable(true, this);
          return;
        case 1003: 
          paramFlashPicHolder.j.setProgressVisable(false);
          return;
        }
        paramFlashPicHolder.j.setProgressVisable(true);
        paramFlashPicHolder.j.setFailedIconVisable(false, null);
      }
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
    Object localObject2;
    if (!(this.e instanceof SplashActivity))
    {
      paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
      if (localObject1 != null)
      {
        localObject2 = this.d.getMessageFacade().a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
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
      Object localObject3 = this.e.getResources();
      paramViewHolder = new RelativeLayout(this.e);
      paramViewHolder.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.e);
      paramView.setId(2131440242);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.c(false);
      paramView.setShowEdge(true);
      paramView.c = false;
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.e);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).c(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131440242);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131440242);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131440242);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131440242);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.e);
      ImageView localImageView = new ImageView(this.e);
      localImageView.setId(2131434867);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.e);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131890770));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131168464));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131434867);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = AIOUtils.b(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.setOnClickListener(this.D);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).a = paramView;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).b = ((BubbleImageView)localObject2);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).c = localImageView;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).d = ((TextView)localObject5);
    }
    else
    {
      paramViewHolder = paramView;
    }
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).g = bool1;
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).a.setCommonFlashPic(bool1);
    boolean bool2;
    if (bool1) {
      bool2 = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsgReaded(paramBaseChatItemLayout);
    } else {
      bool2 = HotChatHelper.b(paramBaseChatItemLayout);
    }
    paramView = URLDrawableHelper.getURL(paramBaseChatItemLayout, 65537);
    if ((bool2) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).f)) {}
    while ((!bool2) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).e != null) && (((FlashPicItemBuilder.FlashPicHolder)localObject1).e.getURL().equals(paramView)))
    {
      bool1 = true;
      break;
    }
    ((FlashPicItemBuilder.FlashPicHolder)localObject1).f = bool2;
    if (bool2)
    {
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).c.setImageResource(2130843591);
      paramView = ((FlashPicItemBuilder.FlashPicHolder)localObject1).d;
      bool1 = false;
      paramView.setVisibility(0);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).a.setImageDrawable(this.z);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).e = null;
    }
    else
    {
      bool1 = false;
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).c.setImageResource(2130843592);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).d.setVisibility(8);
      paramView = a(this.e, paramBaseChatItemLayout, null);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).a.setImageDrawable(paramView);
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).e = paramView;
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
      ((FlashPicItemBuilder.FlashPicHolder)localObject1).h = paramViewHolder;
      a(((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (FlashPicItemBuilder.FlashPicHolder)localObject1);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new FlashPicItemBuilder.FlashPicHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131430279)
    {
      if (paramInt != 2131430288)
      {
        if (paramInt == 2131431695) {
          ChatActivityFacade.b(this.e, this.d, paramChatMessage);
        }
      }
      else
      {
        paramContext = this.w;
        AioPicTransFileController.a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        this.w.b(this.f.b);
        d();
      }
    }
    else
    {
      FlashPicItemBuilder.2 local2 = new FlashPicItemBuilder.2(this);
      AioPicTransFileController localAioPicTransFileController = this.w;
      AioPicTransFileController.a(paramChatMessage.frienduin, local2);
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = AIOUtils.b(paramView);
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
      paramView.b.setImageDrawable(this.C);
      return;
    }
    paramView.b.setImageDrawable(this.B);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.b(paramView);
    if (!(paramView instanceof FlashPicItemBuilder.FlashPicHolder)) {
      return;
    }
    paramView = (FlashPicItemBuilder.FlashPicHolder)paramView;
    if (paramBoolean)
    {
      paramView.b.setImageDrawable(this.C);
      return;
    }
    paramView.b.setImageDrawable(this.B);
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
      paramChatMessage = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
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
    paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.b(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.q;
    if (paramView.g)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.e == null) || (paramView.e.getStatus() == 1))
        {
          a(localQQCustomMenu, this.e, 2131438943, localMessageForPic, new Bundle());
          a(localQQCustomMenu, this.e, 2131431695, localMessageForPic, new Bundle());
          super.a(localQQCustomMenu, this.e, 2131439015, null, null);
          super.a(localQQCustomMenu, this.e, 2131428089, null, null);
        }
        return localQQCustomMenu.d();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.d.getMsgCache().f(localMessageForPic))) {
          a(localQQCustomMenu, this.e, 2131438943, localMessageForPic, new Bundle());
        }
        a(localQQCustomMenu, this.e, 2131431695, localMessageForPic, new Bundle());
        super.a(localQQCustomMenu, this.e, 2131439015, null, null);
        super.a(localQQCustomMenu, this.e, 2131428089, null, null);
      }
      else
      {
        paramView = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq);
        if ((paramView instanceof BaseTransProcessor))
        {
          paramView = (BaseTransProcessor)paramView;
          long l = paramView.getFileStatus();
          if ((l != 1005L) && (l != 1006L) && (l != 1004L) && (paramView.getLastFileStatus() != 1003L))
          {
            localQQCustomMenu.a(2131430288, this.e.getString(2131887713), 2130839055);
            if (this.w.c(this.f.b)) {
              localQQCustomMenu.a(2131430279, this.e.getString(2131887712), 2130839054);
            }
            this.a = this.w.a(this.f.b);
          }
          else
          {
            ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
            super.a(localQQCustomMenu, this.e, 2131439015, null, null);
            super.a(localQQCustomMenu, this.e, 2131428089, null, null);
          }
        }
        else
        {
          ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
          super.a(localQQCustomMenu, this.e, 2131439015, null, null);
          super.a(localQQCustomMenu, this.e, 2131428089, null, null);
        }
      }
    }
    else
    {
      ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    }
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
  }
  
  protected void b(View paramView)
  {
    paramView = (MessageForPic)((FlashPicItemBuilder.FlashPicHolder)AIOUtils.b(paramView)).q;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new FlashPicItemBuilder.3(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return this;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131902627);
    }
    return HardCodeUtil.a(2131902628);
  }
  
  public void f()
  {
    super.f();
    if (this.a)
    {
      this.w.b(this.f.b);
      this.a = false;
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
          this.x = true;
        }
      }
      else {
        this.x = false;
      }
      paramView = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.b(paramView);
      if (paramView != null)
      {
        if (paramView.q == null) {
          return;
        }
        localObject = (MessageForPic)paramView.q;
        if ((((MessageForPic)localObject).uniseq == paramFileMsg.uniseq) && (((MessageForPic)localObject).isSendFromLocal())) {
          a(((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(((MessageForPic)localObject).frienduin, ((MessageForPic)localObject).uniseq), paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */