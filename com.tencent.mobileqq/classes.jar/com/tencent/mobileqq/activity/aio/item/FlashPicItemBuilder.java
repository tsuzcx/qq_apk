package com.tencent.mobileqq.activity.aio.item;

import aavz;
import admh;
import afqq;
import afqr;
import afsn;
import aftk;
import agsd;
import agse;
import agsf;
import agsg;
import ahsl;
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
import anud;
import anvx;
import anwf;
import avli;
import azjv;
import azjw;
import azke;
import azko;
import azkp;
import bcrg;
import bdla;
import bdoa;
import bgxc;
import bhfj;
import bhjq;
import bhjs;
import biqx;
import bkzi;
import bkzz;
import blvp;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BinderWarpper;
import java.net.URL;
import java.util.HashSet;

public class FlashPicItemBuilder
  extends BaseBubbleBuilder
  implements afqq, afsn
{
  public static Drawable a;
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agsd(this);
  private RoundRectDrawable jdField_a_of_type_ComTencentImageRoundRectDrawable;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private long jdField_c_of_type_Long;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  boolean f = false;
  private boolean g = true;
  
  public FlashPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramBaseAdapter = paramContext.getResources();
    float f1 = paramBaseAdapter.getDisplayMetrics().densityDpi / 160;
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130842597);
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
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramResources, 2131166387);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      int i = (int)(paramResources.getDisplayMetrics().densityDpi / 160 * 12.0F);
      paramResources = new bdoa(paramResources.getColor(paramInt), AIOUtils.dp2px(130.0F, paramResources), AIOUtils.dp2px(102.0F, paramResources), i);
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
    int j = AIOUtils.dp2px(130.0F, (Resources)localObject);
    int k = AIOUtils.dp2px(130.0F, (Resources)localObject);
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
      if (anud.a(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable(localURL, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(bgxc.o);
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
      paramContext.setProgressDrawable(new biqx(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
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
        if (anud.a(paramMessageForPic)) {
          paramContext.isFlashPic = true;
        }
        paramContext = URLDrawable.getDrawable(localURL, paramContext);
        paramContext.setDecodeHandler(bgxc.o);
        if ((!azjw.jdField_a_of_type_Boolean) && (i == 0)) {
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
    azko localazko;
    int i;
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      localazko = new azko();
      localazko.a(paramMessageForPic.path);
      if (!anwf.a(paramMessageForPic)) {
        break label234;
      }
      i = 1039;
      localazko.d(i);
      localazko.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag != 1) {
        break label241;
      }
      localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
    }
    for (;;)
    {
      localazko.e(paramMessageForPic.senderuin);
      localazko.c(paramMessageForPic.selfuin);
      localazko.e(paramMessageForPic.istroop);
      localazko.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localazko.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      azkp localazkp = new azkp();
      localazkp.a = paramMessageForPic.msgseq;
      localazkp.b = paramMessageForPic.shmsgseq;
      localazkp.a = paramMessageForPic.msgseq;
      localazko.a(localazkp);
      paramMessageForPic = azjv.a(4, i);
      paramMessageForPic.a(localazko.a());
      azjv.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b();
      return;
      label234:
      i = 1040;
      break;
      label241:
      localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HotChatFlashPicActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", ahsl.a(paramMessageForPic));
    localBundle.putBoolean("isreaded", false);
    localBundle.putLong("uniseq", paramMessageForPic.uniseq);
    localBundle.putString("md5", paramMessageForPic.md5);
    localBundle.putBoolean("is_send", paramMessageForPic.isSend());
    localBundle.putString("self_uin", paramMessageForPic.selfuin);
    localBundle.putInt("curtype", paramMessageForPic.istroop);
    localBundle.putBoolean("self_identify", anwf.a(paramMessageForPic));
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", aavz.a(paramView));
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (blvp.a != null) {
        blvp.a.b();
      }
      return;
      if (paramMessageForPic.istroop == 3000) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
      } else if (paramMessageForPic.istroop == 1) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, agsg paramagsg)
  {
    if ((paramagsg == null) || (paramagsg.jdField_a_of_type_AndroidViewView == null)) {}
    while (!(paramIHttpCommunicatorListener instanceof BaseTransProcessor)) {
      return;
    }
    int i = (int)((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus();
    if (paramagsg.b)
    {
      switch (i)
      {
      default: 
        if (i == 1003) {
          paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      }
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      return;
    }
    switch (i)
    {
    default: 
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    case 1000: 
    case 1001: 
    case 1002: 
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      return;
    case 1003: 
      paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramagsg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqq a(View paramView)
  {
    return this;
  }
  
  public afqr a()
  {
    return new agsg();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject1 = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
    Object localObject2;
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
        paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
        if ((localObject2 instanceof MessageForPic)) {
          paramBaseChatItemLayout = (MessageForPic)localObject2;
        }
      }
    }
    boolean bool1 = anud.a(paramBaseChatItemLayout);
    localObject1 = (agsg)paramafqr;
    paramafqr = paramView;
    if (paramView == null)
    {
      Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramafqr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafqr.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372790);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(true);
      paramView.b = false;
      paramafqr.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).d(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372790);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372790);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131372790);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131372790);
      paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131368052);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131693130));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167363));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131368052);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = AIOUtils.dp2px(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramafqr.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      paramafqr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramafqr.setOnLongClickListener(paramaftk);
      paramafqr.setOnTouchListener(paramaftk);
      ((agsg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
      ((agsg)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject2);
      ((agsg)localObject1).jdField_a_of_type_AndroidWidgetImageView = localImageView;
      ((agsg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
    }
    ((agsg)localObject1).b = bool1;
    ((agsg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.a(bool1);
    boolean bool2;
    if (bool1)
    {
      bool2 = anud.b(paramBaseChatItemLayout);
      bool1 = false;
      paramView = URLDrawableHelper.getURL(paramBaseChatItemLayout, 65537);
      if ((!bool2) || (!((agsg)localObject1).jdField_a_of_type_Boolean)) {
        break label694;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FlashPicItemBuilder", 4, "isReuse:" + bool1 + ",isReaded:" + bool2);
      }
      a(paramChatMessage, paramafqr, this);
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        ((agsg)localObject1).jdField_a_of_type_AndroidViewView = paramafqr;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (agsg)localObject1);
      }
      return paramafqr;
      bool2 = anwf.b(paramBaseChatItemLayout);
      break;
      label694:
      if ((!bool2) && (((agsg)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (((agsg)localObject1).jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        bool1 = true;
      }
      else
      {
        ((agsg)localObject1).jdField_a_of_type_Boolean = bool2;
        if (bool2)
        {
          ((agsg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842593);
          ((agsg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((agsg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.jdField_a_of_type_ComTencentImageRoundRectDrawable);
          ((agsg)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = null;
        }
        else
        {
          ((agsg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842594);
          ((agsg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, null);
          ((agsg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
          ((agsg)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return anvx.a(2131704096);
    }
    return anvx.a(2131704097);
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
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().cancelSendingPic(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().resumePendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      b();
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      agse localagse = new agse(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().cancelSendingPics(paramChatMessage.frienduin, localagse);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForPic)((agsg)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(2131689976, 5);
      localbkzi.c(2131690697);
      localbkzi.a(new agsf(this, paramView, localbkzi));
      localbkzi.show();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof agsg)) {
      return;
    }
    paramView = (agsg)paramView;
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
        paramView = (agsg)AIOUtils.getHolder(paramView);
        if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
          break;
        }
        MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localMessageForPic.uniseq != paramFileMsg.uniseq) || (!localMessageForPic.isSendFromLocal())) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        return;
      } while ((paramInt1 != 1007) && (paramInt1 != 1003));
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof agsg)) {
      return;
    }
    paramView = (agsg)paramView;
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
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      } while (!(paramChatMessage instanceof BaseTransProcessor));
      if (((BaseTransProcessor)paramChatMessage).getFileStatus() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (agsg)AIOUtils.getHolder(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.b)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) || (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
        {
          a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForPic);
          a(localbhjq, localMessageForPic);
          super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        }
        return localbhjq.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(localMessageForPic))) {
          a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForPic);
        }
        a(localbhjq, localMessageForPic);
        super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      return localbhjq.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((paramView instanceof BaseTransProcessor))
      {
        paramView = (BaseTransProcessor)paramView;
        long l = paramView.getFileStatus();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramView.getLastFileStatus() == 1003L))
        {
          admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
          super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        }
        else
        {
          localbhjq.a(2131364266, this.jdField_a_of_type_AndroidContentContext.getString(2131690755), 2130838980);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().isMutiSendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
            localbhjq.a(2131364254, this.jdField_a_of_type_AndroidContentContext.getString(2131690754), 2130838979);
          }
          this.f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().pauseSendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        }
      }
      else
      {
        admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        continue;
        admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().resumePendingPics(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */