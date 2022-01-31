package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aels;
import aelt;
import aenl;
import aeov;
import afia;
import afib;
import afic;
import afid;
import agem;
import alnp;
import alpo;
import alpw;
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
import asot;
import awes;
import awet;
import awfc;
import awfm;
import awfn;
import ayvc;
import azmj;
import azqp;
import bame;
import bamw;
import baoj;
import batv;
import batw;
import baul;
import bcuq;
import bdcs;
import bdec;
import bdkz;
import bdlb;
import bdlq;
import benq;
import bhpy;
import bhql;
import bilx;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BinderWarpper;
import java.net.URL;
import java.util.HashSet;
import zen;

public class FlashPicItemBuilder
  extends BaseBubbleBuilder
  implements aels, aenl
{
  public static Drawable a;
  private static final HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afia(this);
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
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130842185);
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
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramResources, 2131166282);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      int i = (int)(paramResources.getDisplayMetrics().densityDpi / 160 * 12.0F);
      paramResources = new azqp(paramResources.getColor(paramInt), aekt.a(130.0F, paramResources), aekt.a(102.0F, paramResources), i);
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
    int j = aekt.a(130.0F, (Resources)localObject);
    int k = aekt.a(130.0F, (Resources)localObject);
    URL localURL = baul.a(paramMessageForPic, 65537, null);
    String str = localURL.toString();
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    if (bame.a(str) != null)
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
      if (alnp.a(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable(localURL, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(bcuq.n);
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
      paramContext.setProgressDrawable(new benq(baul.a(), 0, false));
      paramContext.setTag(paramMessageForPic);
      return paramContext;
      if (!baul.a(paramContext)) {}
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
        if (alnp.a(paramMessageForPic)) {
          paramContext.isFlashPic = true;
        }
        paramContext = URLDrawable.getDrawable(localURL, paramContext);
        paramContext.setDecodeHandler(bcuq.n);
        if ((!awet.b) && (i == 0)) {
          break label326;
        }
        paramContext.setAutoDownload(true);
        break;
      }
      label326:
      paramContext.setAutoDownload(false);
    }
  }
  
  private void a(bdlq parambdlq, afid paramafid)
  {
    if ((paramafid == null) || (paramafid.jdField_a_of_type_AndroidViewView == null)) {}
    while (!(parambdlq instanceof bamw)) {
      return;
    }
    int i = (int)((bamw)parambdlq).c();
    if (paramafid.b)
    {
      switch (i)
      {
      default: 
        if (i == 1003) {
          paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      }
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      return;
    }
    switch (i)
    {
    default: 
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    case 1000: 
    case 1001: 
    case 1002: 
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      return;
    case 1003: 
      paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramafid.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    awfm localawfm;
    int i;
    if (bdcs.b(paramMessageForPic.path))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      localawfm = new awfm();
      localawfm.a(paramMessageForPic.path);
      if (!alpw.a(paramMessageForPic)) {
        break label234;
      }
      i = 1039;
      localawfm.d(i);
      localawfm.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag != 1) {
        break label241;
      }
      localawfm.c(batv.e);
    }
    for (;;)
    {
      localawfm.e(paramMessageForPic.senderuin);
      localawfm.c(paramMessageForPic.selfuin);
      localawfm.e(paramMessageForPic.istroop);
      localawfm.jdField_i_of_type_Int = paramMessageForPic.extLong;
      localawfm.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      awfn localawfn = new awfn();
      localawfn.a = paramMessageForPic.msgseq;
      localawfn.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      localawfn.a = paramMessageForPic.msgseq;
      localawfm.a(localawfn);
      paramMessageForPic = awes.a(4, i);
      paramMessageForPic.a(localawfm.a());
      awes.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b();
      return;
      label234:
      i = 1040;
      break;
      label241:
      localawfm.c(batv.d);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HotChatFlashPicActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", agem.a(paramMessageForPic));
    localBundle.putBoolean("isreaded", false);
    localBundle.putLong("uniseq", paramMessageForPic.uniseq);
    localBundle.putString("md5", paramMessageForPic.md5);
    localBundle.putBoolean("is_send", paramMessageForPic.isSend());
    localBundle.putString("self_uin", paramMessageForPic.selfuin);
    localBundle.putInt("curtype", paramMessageForPic.istroop);
    localBundle.putBoolean("self_identify", alpw.a(paramMessageForPic));
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", zen.a(paramView));
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (bilx.a != null) {
        bilx.a.b();
      }
      return;
      if (paramMessageForPic.istroop == 3000) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
      } else if (paramMessageForPic.istroop == 1) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aels a(View paramView)
  {
    return this;
  }
  
  public aelt a()
  {
    return new afid();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
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
    boolean bool1 = alnp.a(paramBaseChatItemLayout);
    localObject1 = (afid)paramaelt;
    paramaelt = paramView;
    if (paramView == null)
    {
      Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaelt = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaelt.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicItemBuilder.FlashPicAIOThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131371925);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(true);
      paramView.b = false;
      paramaelt.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).d(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131371925);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131371925);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131371925);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131371925);
      paramaelt.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367494);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131693459));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167192));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131367494);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = aekt.a(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramaelt.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      paramaelt.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      ((afid)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
      ((afid)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject2);
      ((afid)localObject1).jdField_a_of_type_AndroidWidgetImageView = localImageView;
      ((afid)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
    }
    ((afid)localObject1).b = bool1;
    ((afid)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.a(bool1);
    boolean bool2;
    if (bool1)
    {
      bool2 = alnp.b(paramBaseChatItemLayout);
      bool1 = false;
      paramView = baul.a(paramBaseChatItemLayout, 65537);
      if ((!bool2) || (!((afid)localObject1).jdField_a_of_type_Boolean)) {
        break label694;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FlashPicItemBuilder", 4, "isReuse:" + bool1 + ",isReaded:" + bool2);
      }
      a(paramChatMessage, paramaelt, this);
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        ((afid)localObject1).jdField_a_of_type_AndroidViewView = paramaelt;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (afid)localObject1);
      }
      return paramaelt;
      bool2 = alpw.b(paramBaseChatItemLayout);
      break;
      label694:
      if ((!bool2) && (((afid)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (((afid)localObject1).jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        bool1 = true;
      }
      else
      {
        ((afid)localObject1).jdField_a_of_type_Boolean = bool2;
        if (bool2)
        {
          ((afid)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842181);
          ((afid)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((afid)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.jdField_a_of_type_ComTencentImageRoundRectDrawable);
          ((afid)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = null;
        }
        else
        {
          ((afid)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842182);
          ((afid)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, null);
          ((afid)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
          ((afid)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdec.a(paramChatMessage.issend)) {
      return alpo.a(2131705000);
    }
    return alpo.a(2131705001);
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
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      b();
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      afib localafib = new afib(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, localafib);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForPic)((afid)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhpy.a(2131690042, 5);
      localbhpy.c(2131690648);
      localbhpy.a(new afic(this, paramView, localbhpy));
      localbhpy.show();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = aekt.a(paramView);
    if (!(paramView instanceof afid)) {
      return;
    }
    paramView = (afid)paramView;
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
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashPicItemBuilder", 2, "status:" + paramInt1 + ",retCode:" + paramInt2);
    }
    if (((parambaoj.jdField_b_of_type_Int != 1) && (parambaoj.jdField_b_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
      return;
    }
    if ((paramInt1 == 1001) || (paramInt1 == 1000) || (paramInt1 == 4001) || (paramInt1 == 1002) || (paramInt1 == 1004) || (paramInt1 == 1005)) {}
    for (this.g = false;; this.g = true) {
      do
      {
        paramView = (afid)aekt.a(paramView);
        if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
          break;
        }
        MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localMessageForPic.uniseq != parambaoj.jdField_b_of_type_Long) || (!localMessageForPic.isSendFromLocal())) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        return;
      } while ((paramInt1 != 1007) && (paramInt1 != 1003));
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = aekt.a(paramView);
    if (!(paramView instanceof afid)) {
      return;
    }
    paramView = (afid)paramView;
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
      } while (!(paramChatMessage instanceof bamw));
      if (((bamw)paramChatMessage).c() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (afid)aekt.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.b)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) || (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1))
        {
          a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
          a(localbdkz, localMessageForPic);
          super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
        }
        return localbdkz.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic))) {
          a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        }
        a(localbdkz, localMessageForPic);
        super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
        super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      return localbdkz.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((paramView instanceof bamw))
      {
        paramView = (bamw)paramView;
        long l = paramView.c();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramView.d() == 1003L))
        {
          acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
        }
        else
        {
          localbdkz.a(2131363921, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838666);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            localbdkz.a(2131363911, this.jdField_a_of_type_AndroidContentContext.getString(2131690758), 2130838665);
          }
          this.f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
        super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
        continue;
        acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */