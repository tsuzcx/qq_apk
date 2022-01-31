package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acjt;
import acju;
import aclm;
import acmv;
import adev;
import adew;
import adex;
import adey;
import adwz;
import ajhz;
import ajjy;
import ajke;
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
import aqeb;
import atpl;
import atpm;
import atpv;
import atqe;
import atqf;
import awao;
import awqx;
import awur;
import axoa;
import axou;
import axqf;
import axvn;
import axvo;
import axwd;
import azue;
import bace;
import bado;
import bakh;
import bakj;
import baky;
import bblb;
import begr;
import behe;
import bfcq;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BinderWarpper;
import java.net.URL;
import java.util.HashSet;
import xgx;

public class FlashPicItemBuilder
  extends BaseBubbleBuilder
  implements acjt, aclm
{
  public static Drawable a;
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adev(this);
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
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130841939);
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
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramResources, 2131100645);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      int i = (int)(paramResources.getDisplayMetrics().densityDpi / 160 * 12.0F);
      paramResources = new awur(paramResources.getColor(paramInt), aciy.a(130.0F, paramResources), aciy.a(102.0F, paramResources), i);
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
    int j = aciy.a(130.0F, (Resources)localObject);
    int k = aciy.a(130.0F, (Resources)localObject);
    URL localURL = axwd.a(paramMessageForPic, 65537, null);
    String str = localURL.toString();
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    if (axoa.a(str) != null)
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
      if (ajhz.a(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable(localURL, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(azue.n);
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
      paramContext.setProgressDrawable(new bblb(axwd.a(), 0, false));
      paramContext.setTag(paramMessageForPic);
      return paramContext;
      if (!axwd.a(paramContext)) {}
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
        if (ajhz.a(paramMessageForPic)) {
          paramContext.isFlashPic = true;
        }
        paramContext = URLDrawable.getDrawable(localURL, paramContext);
        paramContext.setDecodeHandler(azue.n);
        if ((!atpm.b) && (i == 0)) {
          break label326;
        }
        paramContext.setAutoDownload(true);
        break;
      }
      label326:
      paramContext.setAutoDownload(false);
    }
  }
  
  private void a(baky parambaky, adey paramadey)
  {
    if ((paramadey == null) || (paramadey.jdField_a_of_type_AndroidViewView == null)) {}
    while (!(parambaky instanceof axou)) {
      return;
    }
    int i = (int)((axou)parambaky).c();
    if (paramadey.b)
    {
      switch (i)
      {
      default: 
        if (i == 1003) {
          paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      }
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      return;
    }
    switch (i)
    {
    default: 
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    case 1000: 
    case 1001: 
    case 1002: 
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      return;
    case 1003: 
      paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramadey.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    atqe localatqe;
    int i;
    if (bace.b(paramMessageForPic.path))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      localatqe = new atqe();
      localatqe.a(paramMessageForPic.path);
      if (!ajke.a(paramMessageForPic)) {
        break label234;
      }
      i = 1039;
      localatqe.d(i);
      localatqe.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag != 1) {
        break label241;
      }
      localatqe.c(axvn.e);
    }
    for (;;)
    {
      localatqe.e(paramMessageForPic.senderuin);
      localatqe.c(paramMessageForPic.selfuin);
      localatqe.e(paramMessageForPic.istroop);
      localatqe.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localatqe.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      atqf localatqf = new atqf();
      localatqf.a = paramMessageForPic.msgseq;
      localatqf.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      localatqf.a = paramMessageForPic.msgseq;
      localatqe.a(localatqf);
      paramMessageForPic = atpl.a(4, i);
      paramMessageForPic.a(localatqe.a());
      atpl.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b();
      return;
      label234:
      i = 1040;
      break;
      label241:
      localatqe.c(axvn.d);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HotChatFlashPicActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", adwz.a(paramMessageForPic));
    localBundle.putBoolean("isreaded", false);
    localBundle.putLong("uniseq", paramMessageForPic.uniseq);
    localBundle.putString("md5", paramMessageForPic.md5);
    localBundle.putBoolean("is_send", paramMessageForPic.isSend());
    localBundle.putString("self_uin", paramMessageForPic.selfuin);
    localBundle.putInt("curtype", paramMessageForPic.istroop);
    localBundle.putBoolean("self_identify", ajke.a(paramMessageForPic));
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", xgx.a(paramView));
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (bfcq.a != null) {
        bfcq.a.b();
      }
      return;
      if (paramMessageForPic.istroop == 3000) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
      } else if (paramMessageForPic.istroop == 1) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acjt a(View paramView)
  {
    return this;
  }
  
  public acju a()
  {
    return new adey();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Object localObject1 = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
    Object localObject2;
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
        paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
        if ((localObject2 instanceof MessageForPic)) {
          paramBaseChatItemLayout = (MessageForPic)localObject2;
        }
      }
    }
    boolean bool1 = ajhz.a(paramBaseChatItemLayout);
    localObject1 = (adey)paramacju;
    paramacju = paramView;
    if (paramView == null)
    {
      Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramacju = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramacju.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131305912);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(true);
      paramView.b = false;
      paramacju.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).d(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131305912);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131305912);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131305912);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131305912);
      paramacju.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131301754);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131627716));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131101537));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131301754);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = aciy.a(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramacju.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      paramacju.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramacju.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
      ((adey)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
      ((adey)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject2);
      ((adey)localObject1).jdField_a_of_type_AndroidWidgetImageView = localImageView;
      ((adey)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
    }
    ((adey)localObject1).b = bool1;
    ((adey)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.a(bool1);
    boolean bool2;
    if (bool1)
    {
      bool2 = ajhz.b(paramBaseChatItemLayout);
      bool1 = false;
      paramView = axwd.a(paramBaseChatItemLayout, 65537);
      if ((!bool2) || (!((adey)localObject1).jdField_a_of_type_Boolean)) {
        break label694;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FlashPicItemBuilder", 4, "isReuse:" + bool1 + ",isReaded:" + bool2);
      }
      a(paramChatMessage, paramacju, this);
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        ((adey)localObject1).jdField_a_of_type_AndroidViewView = paramacju;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (adey)localObject1);
      }
      return paramacju;
      bool2 = ajke.b(paramBaseChatItemLayout);
      break;
      label694:
      if ((!bool2) && (((adey)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (((adey)localObject1).jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        bool1 = true;
      }
      else
      {
        ((adey)localObject1).jdField_a_of_type_Boolean = bool2;
        if (bool2)
        {
          ((adey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841935);
          ((adey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((adey)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.jdField_a_of_type_ComTencentImageRoundRectDrawable);
          ((adey)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = null;
        }
        else
        {
          ((adey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841936);
          ((adey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, null);
          ((adey)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
          ((adey)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131638832);
    }
    return ajjy.a(2131638833);
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
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      b();
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      adew localadew = new adew(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, localadew);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForPic)((adey)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.a(2131624443, 5);
      localbegr.c(2131625035);
      localbegr.a(new adex(this, paramView, localbegr));
      localbegr.show();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = aciy.a(paramView);
    if (!(paramView instanceof adey)) {
      return;
    }
    paramView = (adey)paramView;
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
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashPicItemBuilder", 2, "status:" + paramInt1 + ",retCode:" + paramInt2);
    }
    if (((paramaxqf.jdField_b_of_type_Int != 1) && (paramaxqf.jdField_b_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
      return;
    }
    if ((paramInt1 == 1001) || (paramInt1 == 1000) || (paramInt1 == 4001) || (paramInt1 == 1002) || (paramInt1 == 1004) || (paramInt1 == 1005)) {}
    for (this.g = false;; this.g = true) {
      do
      {
        paramView = (adey)aciy.a(paramView);
        if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
          break;
        }
        MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localMessageForPic.uniseq != paramaxqf.jdField_b_of_type_Long) || (!localMessageForPic.isSendFromLocal())) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        return;
      } while ((paramInt1 != 1007) && (paramInt1 != 1003));
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = aciy.a(paramView);
    if (!(paramView instanceof adey)) {
      return;
    }
    paramView = (adey)paramView;
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
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      } while (!(paramChatMessage instanceof axou));
      if (((axou)paramChatMessage).c() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = (adey)aciy.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.b)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) || (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
        {
          a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
          a(localbakh, localMessageForPic);
          super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
          super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
        }
        return localbakh.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic))) {
          a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        }
        a(localbakh, localMessageForPic);
        super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
        super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      return localbakh.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((paramView instanceof axou))
      {
        paramView = (axou)paramView;
        long l = paramView.c();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramView.d() == 1003L))
        {
          aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
          super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
        }
        else
        {
          localbakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            localbakh.a(2131298301, this.jdField_a_of_type_AndroidContentContext.getString(2131625145), 2130838587);
          }
          this.f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
        super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
        continue;
        aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */