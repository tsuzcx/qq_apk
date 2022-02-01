package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.comment.DanmuUtil;
import com.tencent.mobileqq.config.business.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HasSourceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.replymsg.ReplyItemClickListener;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ReplyTextItemBuilder
  extends TextItemBuilder
{
  protected static Drawable a;
  protected OnLongClickAndTouchListener a;
  protected ReplyTextItemBuilder.ViewPool a;
  private View.OnClickListener c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public ReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder$ViewPool = new ReplyTextItemBuilder.ViewPool(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = new ReplyTextItemBuilder.1(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ReplyTextItemBuilder.6(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ReplyItemClickListener(this);
  }
  
  private int a(Bitmap paramBitmap)
  {
    int i = 0;
    int j = 0;
    long l1 = 0L;
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth() / 2;
      int m = paramBitmap.getHeight();
      long l2 = 0L;
      long l3 = 0L;
      i = j;
      while (i < m)
      {
        j = paramBitmap.getPixel(k, i);
        l3 += Color.red(j);
        l2 += Color.green(j);
        l1 += Color.blue(j);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "count r=" + l3 + " g=" + l2 + " b=" + l1 + " height=" + m);
      }
      i = Color.rgb((int)l3 / m, (int)l2 / m, (int)l1 / m);
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      return Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (paramLong == paramQQAppInterface.getLongAccountUin()) {
      return Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return paramQQAppInterface.getLongAccountUin();
  }
  
  private static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("static://GrayCommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130841062);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("static://GrayCommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ReplyTextItemBuilder.ReplyTextViewHolder paramReplyTextViewHolder, MessageForReplyText paramMessageForReplyText, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    paramReplyTextViewHolder.e = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder$ViewPool.a(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
      paramReplyTextViewHolder.c = ((TextView)((ViewGroup)localObject3).findViewById(2131379346));
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131372115));
      paramReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject3).findViewById(2131367424));
      paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371908));
      paramReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371926));
      ((ViewGroup)localObject3).setId(2131364662);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)localObject3).findViewById(2131369714));
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713366));
      localObject3 = new ETTextView(paramContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject3);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131167052));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131167045));
      ((ETTextView)localObject3).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      ((ETTextView)localObject3).setSpannableFactory(QQText.SPANNABLE_FACTORY);
      ((ETTextView)localObject3).setMovementMethod(LinkMovementMethod.getInstance());
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      if (paramMessageForReplyText.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      ((ETTextView)localObject3).setPadding(j, 0, i, BaseChatItemLayout.n);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = j;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.h;
      ((LinearLayout)localObject1).addView(paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364637);
      paramReplyTextViewHolder.d = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramReplyTextViewHolder.d, (ViewGroup.LayoutParams)localObject2);
    }
    paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131372115));
    paramReplyTextViewHolder.c = ((TextView)((View)localObject1).findViewById(2131379346));
    paramReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131367424));
    paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371908));
    paramReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((View)localObject1).findViewById(2131371926));
    paramReplyTextViewHolder.d = ((ETTextView)((View)localObject1).findViewById(2131364637));
    paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131364662));
    paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369714));
    paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713363));
    paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838379));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = VasShieldFont.a(paramContext);
      paramReplyTextViewHolder.c.setTypeface(paramContext);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
      paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      paramReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramContext);
      if (!android.text.TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramReplyTextViewHolder.d).getETLayout();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramReplyTextViewHolder.d).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramReplyTextViewHolder.d).mMaxWidth;
      j = BaseChatItemLayout.e;
      paramReplyTextViewHolder.d.setMaxWidth(j);
      paramReplyTextViewHolder.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if (i != j) {
        ((ETTextView)paramReplyTextViewHolder.d).mMsgId = 0L;
      }
      paramReplyTextViewHolder.d.setText(paramMessageForReplyText.sb);
      if (AppSetting.d) {
        paramReplyTextViewHolder.d.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForReplyText.sb.toString()));
      }
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, paramReplyTextViewHolder.d, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)((View)localObject1).findViewById(2131379316));
      paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((View)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramReplyTextViewHolder.d.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramReplyTextViewHolder.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((paramReplyTextViewHolder.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramReplyTextViewHolder.d).onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
      if ((paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
      if (paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy == null) {
        paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
      }
      if ((localObject1 instanceof SelectableComponent))
      {
        paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a((SelectableComponent)localObject1);
        paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560820, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131372115);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131379346);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131367424);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ImmersiveUtils.setAlpha((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ImageView)localRelativeLayout.findViewById(2131369714)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371908);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167045));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.a(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371926);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167045));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.a(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  private static URLDrawable.URLDrawableOptions a(MessageForPic paramMessageForPic, int paramInt, boolean paramBoolean)
  {
    int i = 99;
    int j = paramMessageForPic.thumbWidth;
    int k = paramMessageForPic.thumbHeight;
    if ((j > 0) && (k > 0))
    {
      paramMessageForPic = a(j, k, 0.0F, paramBoolean);
      j = paramMessageForPic.jdField_a_of_type_Int;
      i = paramMessageForPic.jdField_b_of_type_Int;
    }
    for (;;)
    {
      float f = paramInt / 160.0F;
      paramInt = (int)(j * f + 0.5F);
      i = (int)(i * f + 0.5F);
      paramMessageForPic = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForPic.mRequestWidth = paramInt;
      paramMessageForPic.mRequestHeight = i;
      return paramMessageForPic;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + k);
      }
      j = 99;
    }
  }
  
  public static URLDrawable a(Context paramContext, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, URL paramURL, Rect paramRect, File paramFile, boolean paramBoolean)
  {
    int k = paramContext.getResources().getDisplayMetrics().densityDpi;
    float f1 = k / 160.0F;
    int j;
    int i;
    float f2;
    if (paramRect != null)
    {
      j = paramRect.width();
      i = paramRect.height();
      paramContext = a(j, i, f1 * 12.0F, paramBoolean);
      j = paramContext.jdField_a_of_type_Int;
      i = paramContext.jdField_b_of_type_Int;
      f2 = paramContext.jdField_b_of_type_Float;
      j = (j * k + 80) / 160;
      i = (i * k + 80) / 160;
      f1 = f2;
      if (paramRect != null)
      {
        if (paramRect.width() >= j) {
          break label338;
        }
        f1 = f2 * (paramRect.width() / j);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
        }
        paramContext = URLDrawableHelper.getDrawable(paramURL, j, i, new EmptyDrawable(j, i), URLDrawableHelper.getFailedDrawable(), true, f1);
        paramContext.setIgnorePause(true);
        paramContext.setFadeInImage(true);
        if (paramChatThumbView != null) {
          paramChatThumbView.jdField_a_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + j + "," + i);
        }
        return paramContext;
        paramContext = new BitmapFactory.Options();
        paramContext.inJustDecodeBounds = true;
        try
        {
          ImageUtil.a(paramFile.getAbsolutePath(), paramContext);
          j = paramContext.outWidth;
          i = paramContext.outHeight;
          int m = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
          if ((m != 90) && (m != 270)) {
            break;
          }
          j = paramContext.outHeight;
          i = paramContext.outWidth;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
            }
          }
        }
      }
      label338:
      f1 = f2;
      if (paramRect.height() < i) {
        f1 = f2 * (paramRect.height() / i);
      }
    }
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ReplyTextItemBuilder.BasicPicInfo paramBasicPicInfo)
  {
    boolean bool1 = PeakUtils.a(paramMessageForPic.imageType);
    boolean bool2 = paramBasicPicInfo.jdField_a_of_type_Boolean;
    URL localURL = paramBasicPicInfo.jdField_a_of_type_JavaNetURL;
    Rect localRect = paramBasicPicInfo.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject = localURL;
    if (localURL == null) {
      paramBasicPicInfo = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
    }
    try
    {
      localObject = new URL(paramBasicPicInfo.toString());
      paramBasicPicInfo = (ReplyTextItemBuilder.BasicPicInfo)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        float f;
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
        continue;
        paramBasicPicInfo = AbsDownloader.getFile(paramBasicPicInfo);
        if (paramBasicPicInfo == null) {
          break;
        }
        paramContext = a(paramContext, paramChatThumbView, paramArrayOfInt, localMalformedURLException, localRect, paramBasicPicInfo, bool1);
      }
      if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
        break label509;
      }
    }
    localObject = paramBasicPicInfo;
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + paramBasicPicInfo);
      localObject = paramBasicPicInfo;
    }
    paramBasicPicInfo = ((URL)localObject).toString();
    int j = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    f = j / 160.0F;
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramBasicPicInfo) != null)
    {
      paramContext = URLDrawableHelper.getDrawable((URL)localObject, 0, 0, null, null, true, 12.0F * f);
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
        paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
        if (QLog.isColorLevel()) {
          QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
        }
      }
      paramContext.setTag(paramMessageForPic);
      if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
        ((GifDrawable)paramContext.getCurrDrawable()).mutate();
      }
      return paramContext;
    }
    int i = 1;
    label343:
    paramChatThumbView = a(paramMessageForPic, j, bool1);
    paramChatThumbView.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
    paramChatThumbView.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
    paramChatThumbView.mPlayGifImage = bool2;
    paramChatThumbView.mGifRoundCorner = 12.0F;
    paramChatThumbView.mImgType = paramMessageForPic.imageType;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramChatThumbView.mRequestWidth;
      paramArrayOfInt[1] = paramChatThumbView.mRequestHeight;
    }
    paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130844093);
    paramContext = URLDrawable.getDrawable(localMalformedURLException, paramChatThumbView);
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableautoDownload:" + paramChatThumbView.mRequestWidth + "," + paramChatThumbView.mRequestHeight);
    }
    if ((PicContants.jdField_a_of_type_Boolean) || (i != 0)) {
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new PhotoProgressDrawable(a(), 0, false));
      break;
      label509:
      i = 0;
      break label343;
      paramContext.setAutoDownload(false);
    }
  }
  
  private static ReplyTextItemBuilder.BasicPicInfo a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
    int i = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
    ReplyTextItemBuilder.BasicPicInfo localBasicPicInfo = new ReplyTextItemBuilder.BasicPicInfo();
    float f1;
    if ((paramInt1 < i) || (paramInt2 < i)) {
      if (paramInt1 < paramInt2)
      {
        f1 = i / paramInt1;
        paramInt1 = (int)(paramInt2 * f1 + 0.5F);
        if (paramInt1 > j)
        {
          paramInt1 = j;
          paramInt2 = paramInt1;
          paramInt1 = i;
          paramFloat *= f1;
        }
      }
    }
    for (;;)
    {
      localBasicPicInfo.jdField_a_of_type_Int = paramInt1;
      localBasicPicInfo.jdField_b_of_type_Int = paramInt2;
      localBasicPicInfo.jdField_a_of_type_Float = f1;
      localBasicPicInfo.jdField_b_of_type_Float = paramFloat;
      return localBasicPicInfo;
      break;
      f1 = i / paramInt2;
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      if (paramInt1 > j) {
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 = i;
        break;
      }
      if ((paramInt1 >= j) || (paramInt2 >= j)) {
        break label162;
      }
      f1 = 0.0F;
    }
    label162:
    if (paramInt1 > paramInt2)
    {
      f1 = j / paramInt1;
      label175:
      if (paramInt1 <= paramInt2) {
        break label233;
      }
    }
    label233:
    for (float f2 = i / paramInt2;; f2 = i / paramInt1)
    {
      f1 = Math.max(f1, f2);
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      paramInt2 = (int)(paramInt2 * f1 + 0.5F);
      break;
      f1 = j / paramInt2;
      break label175;
    }
  }
  
  private static ReplyTextItemBuilder.BasicPicInfo a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    ReplyTextItemBuilder.BasicPicInfo localBasicPicInfo = new ReplyTextItemBuilder.BasicPicInfo();
    Object localObject3 = null;
    boolean bool = PeakUtils.a(paramMessageForPic.imageType);
    URL localURL2;
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      PicItemBuilder.e();
      if (PicItemBuilder.h)
      {
        localURL2 = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
        localObject1 = AbsDownloader.getFile(localURL2.toString());
        if (localObject1 != null)
        {
          try
          {
            localObject4 = NativeGifImage.getImageSize((File)localObject1, false);
            localObject3 = localObject4;
            localObject1 = localURL2;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              Object localObject4;
              label141:
              localObject2 = null;
            }
          }
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + localURL2);
              localObject1 = localURL2;
              localObject3 = localObject4;
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject3 = localMalformedURLException;
            localURL1 = localURL2;
            break label141;
          }
          localBasicPicInfo.jdField_a_of_type_Boolean = true;
          localBasicPicInfo.jdField_a_of_type_AndroidGraphicsRect = localObject3;
          localBasicPicInfo.jdField_a_of_type_JavaNetURL = ((URL)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject1 = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      }
      try
      {
        localObject4 = new URL(((URL)localObject1).toString());
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        int k;
        float f;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
          }
          localMalformedURLException.printStackTrace();
        }
        paramContext = AbsDownloader.getFile((String)localObject1);
        if (paramContext == null) {
          break label435;
        }
        a(paramArrayOfInt, localObject3, bool, k, paramContext, f);
        return localBasicPicInfo;
        int i = paramMessageForPic.thumbWidth;
        int j = paramMessageForPic.thumbHeight;
        if ((i <= 0) || (j <= 0)) {
          break label532;
        }
        paramContext = a(i, j, 0.0F, bool);
        j = paramContext.jdField_a_of_type_Int;
        for (i = paramContext.jdField_b_of_type_Int;; i = 99)
        {
          f = k / 160.0F;
          j = (int)(j * f + 0.5F);
          i = (int)(i * f + 0.5F);
          if (paramArrayOfInt == null) {
            break;
          }
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
          return localBasicPicInfo;
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i + ", height = " + j);
          }
          j = 99;
        }
      }
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
        localObject4 = localObject1;
      }
      localObject1 = ((URL)localObject4).toString();
      k = paramContext.getResources().getDisplayMetrics().densityDpi;
      if (paramChatThumbView != null) {
        paramChatThumbView.jdField_a_of_type_Boolean = false;
      }
      f = k / 160.0F;
      if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(localObject1) != null)
      {
        paramContext = URLDrawableHelper.getDrawable((URL)localObject4, 0, 0, null, null, true, 12.0F * f);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
          }
        }
        return localBasicPicInfo;
      }
      label435:
      Object localObject2;
      label532:
      URL localURL1 = null;
      break;
      localObject3 = null;
      localURL1 = null;
    }
  }
  
  private static ReplyTextItemBuilder.MixedMessageInfo a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    int m = 0;
    Object localObject3 = "";
    int n = 0;
    int j = 0;
    boolean bool1 = false;
    Object localObject4;
    int k;
    int i;
    Object localObject1;
    if (m < paramMessageForMixedMsg.msgElemList.size())
    {
      if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {}
      }
      else
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (n == 0)
        {
          if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText)) {
            break label289;
          }
          localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
          if (((MessageForText)localObject4).sb == null) {
            break label267;
          }
          localObject1 = ((MessageForText)localObject4).sb.toString();
          localObject4 = localObject1;
          k = n;
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            k = n;
            i = j;
            if (!((String)localObject1).equals("\n"))
            {
              if (!bool1) {
                break label395;
              }
              i = 2;
              k = 1;
            }
          }
        }
      }
      for (localObject4 = localObject1;; localObject4 = localObject1)
      {
        if ((!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForPic)) || (bool1)) {
          break label406;
        }
        localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        if (k == 0) {
          break label441;
        }
        localObject3 = localObject4;
        bool1 = bool2;
        label252:
        return new ReplyTextItemBuilder.MixedMessageInfo((MessageForPic)localObject1, (String)localObject3, i, bool1);
        label267:
        localObject1 = localObject3;
        if (((MessageForText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForText)localObject4).msg;
        break;
        label289:
        localObject1 = localObject3;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m)).sb == null) {
          break;
        }
        localObject4 = (MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m);
        if (((MessageForReplyText)localObject4).sb != null)
        {
          localObject1 = ((MessageForReplyText)localObject4).sb.toString();
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForReplyText)localObject4).msg;
        break;
        label395:
        k = 1;
        i = 1;
      }
      label406:
      localObject1 = localObject2;
    }
    for (;;)
    {
      m += 1;
      localObject2 = localObject1;
      localObject3 = localObject4;
      n = k;
      j = i;
      break;
      localObject1 = localObject2;
      i = j;
      break label252;
      label441:
      bool1 = true;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (FileManagerUtil.a(paramMessageRecord)) {
      paramQQAppInterface = FileManagerUtil.a((ChatMessage)paramMessageRecord);
    }
    return paramQQAppInterface;
  }
  
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder, MessageRecord paramMessageRecord3, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < 10)
      {
        localMessageRecord = paramQQAppInterface.getMessageFacade().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
        if ((localMessageRecord == null) || (!localMessageRecord.isLongMsg()) || (!(localMessageRecord instanceof MessageForText))) {
          break label93;
        }
        if (!android.text.TextUtils.isEmpty(localMessageRecord.msg)) {
          paramStringBuilder.append(localMessageRecord.msg);
        }
        if ((localMessageRecord != null) && (localMessageRecord.isLongMsg())) {
          break label197;
        }
      }
      label93:
      do
      {
        return paramMessageRecord3;
        if ((!(localMessageRecord instanceof MessageForMixedMsg)) || (!localMessageRecord.isLongMsg())) {
          break;
        }
        paramQQAppInterface = (MessageForMixedMsg)localMessageRecord;
        if (paramQQAppInterface.msgElemList != null)
        {
          i = 0;
          while (i < paramQQAppInterface.msgElemList.size())
          {
            paramMessageRecord1 = (MessageRecord)paramQQAppInterface.msgElemList.get(i);
            if ((!(paramMessageRecord1 instanceof MessageForText)) || (android.text.TextUtils.isEmpty(paramMessageRecord1.msg))) {
              break;
            }
            paramStringBuilder.append(paramMessageRecord1.msg);
            i += 1;
          }
        }
      } while (paramBoolean);
      return localMessageRecord;
      label197:
      i += 1;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, paramInt);
    int i = paramQQAppInterface.size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
      if (paramString.shmsgseq == paramLong)
      {
        if (!paramString.mIsParsed) {
          paramString.parse();
        }
        return paramString;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    List localList = paramQQAppInterface.getMessageFacade().a(paramString, paramInt);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if ((localChatMessage.time == paramLong1) && (localChatMessage.msgUid == paramLong2)) {
        if (!localChatMessage.mIsParsed) {
          localChatMessage.parse();
        }
      }
      do
      {
        return localChatMessage;
        if (!(localChatMessage instanceof MessageForFile)) {
          break;
        }
        MessageForFile localMessageForFile = (MessageForFile)localChatMessage;
        if ((localMessageForFile.originalTime != paramLong1) || (localMessageForFile.originalMsgUid != paramLong2)) {
          break;
        }
      } while (localChatMessage.mIsParsed);
      localChatMessage.parse();
      return localChatMessage;
      i += 1;
    }
    return a(paramQQAppInterface, paramString, paramInt, paramLong3);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).getSourceMessage() != null))
    {
      paramString = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
      return paramString;
    }
    if ((paramMessageRecord == null) || (paramMessageRecord.isMultiMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "REPLY getMessage  replyTextMsg=" + paramMessageRecord);
      }
      return null;
    }
    if (paramInt == 0) {}
    for (paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid, paramSourceMsgInfo.mSourceMsgSeq);; paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq))
    {
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface;
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break;
      }
      ((MessageForReplyText)paramMessageRecord).setSourceMessageRecord(paramQQAppInterface);
      return paramQQAppInterface;
    }
  }
  
  @Nullable
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l;
    if ((paramMessageRecord1 instanceof MessageForReplyText))
    {
      localObject1 = localObject2;
      if (((MessageForReplyText)paramMessageRecord1).isBarrageMsg)
      {
        l = ((MessageForReplyText)paramMessageRecord1).barrageTimeLocation;
        if (!(paramMessageRecord2 instanceof MessageForShortVideo)) {
          break label60;
        }
        localObject1 = DanmuUtil.a(paramContext, (int)(l / 1000L));
      }
    }
    label60:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!FileManagerUtil.a(paramMessageRecord2));
    paramMessageRecord1 = a(paramQQAppInterface, paramMessageRecord2);
    if ((paramMessageRecord1 instanceof MessageForFile))
    {
      paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
      if ((paramQQAppInterface == null) || (FileManagerUtil.a(paramQQAppInterface.fileName) != 2)) {
        break label188;
      }
    }
    label188:
    for (paramContext = DanmuUtil.a(paramContext, (int)(l / 1000L));; paramContext = null)
    {
      return paramContext;
      localObject1 = localObject2;
      if (!(paramMessageRecord1 instanceof MessageForTroopFile)) {
        break;
      }
      paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord1);
      localObject1 = localObject2;
      if (paramQQAppInterface == null) {
        break;
      }
      localObject1 = localObject2;
      if (FileManagerUtil.a(paramQQAppInterface.g) != 2) {
        break;
      }
      return DanmuUtil.a(paramContext, (int)(l / 1000L));
    }
  }
  
  @Nullable
  private static String a(QQAppInterface paramQQAppInterface, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, String paramString, MessageRecord paramMessageRecord2)
  {
    String str = null;
    if ((paramMessageRecord2 instanceof MessageForFile))
    {
      if (((MessageForFile)paramMessageRecord2).fileName == null) {
        break label370;
      }
      paramQQAppInterface = ((MessageForFile)paramMessageRecord2).getSummaryMsg();
      paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
      paramSourceMsgInfo.mSourceSummaryFlag = 1;
    }
    label370:
    label375:
    for (;;)
    {
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = paramSourceMsgInfo.mSourceMsgText;
      }
      if ((paramMessageRecord2 != null) && (paramMessageRecord2.shmsgseq == paramMessageRecord1.shmsgseq))
      {
        return paramString;
        if ((paramMessageRecord2 instanceof MessageForTroopFile))
        {
          if (((MessageForTroopFile)paramMessageRecord2).fileName != null) {
            str = ((MessageForTroopFile)paramMessageRecord2).getSummaryMsg();
          }
          localObject = str;
          if (android.text.TextUtils.isEmpty(str))
          {
            paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord2);
            localObject = str;
            if (paramQQAppInterface != null) {
              localObject = paramQQAppInterface.g;
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (android.text.TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileName");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
              paramQQAppInterface = HardCodeUtil.a(2131706580) + (String)localObject;
            }
          }
          if (android.text.TextUtils.isEmpty(paramQQAppInterface)) {
            break label375;
          }
          paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
          paramSourceMsgInfo.mSourceSummaryFlag = 1;
          continue;
        }
        if (paramMessageRecord2 != null) {
          for (;;)
          {
            try
            {
              if (!((ChatMessage)paramMessageRecord2).mIsParsed) {
                ((ChatMessage)paramMessageRecord2).parse();
              }
              if (!(paramMessageRecord2 instanceof MessageForReplyText)) {
                continue;
              }
              if (((MessageForReplyText)paramMessageRecord2).sb != null) {
                continue;
              }
              QLog.e("ReplyTextItemBuilder", 2, "MessageForReplyText.sb is null");
              if (paramMessageRecord2.msg == null) {
                continue;
              }
              paramQQAppInterface = paramMessageRecord2.msg;
            }
            catch (Throwable localThrowable)
            {
              paramQQAppInterface = "";
              QLog.e("ReplyTextItemBuilder", 2, new Object[] { "msg.getSummaryMsg error, msg type=", paramMessageRecord2.getClass().getName(), localThrowable });
              continue;
            }
            paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
            paramSourceMsgInfo.mSourceSummaryFlag = 1;
            break;
            paramQQAppInterface = "";
            continue;
            paramQQAppInterface = ((MessageForReplyText)paramMessageRecord2).getSummaryMsg();
            continue;
            paramQQAppInterface = ((ChatMessage)paramMessageRecord2).getSummaryMsg();
          }
        }
      }
      else
      {
        return localThrowable;
      }
      paramQQAppInterface = null;
    }
  }
  
  private static void a(Context paramContext, ChatThumbView paramChatThumbView, HasSourceMessage paramHasSourceMessage, MessageForPic paramMessageForPic)
  {
    boolean bool = PeakUtils.a(paramMessageForPic.imageType);
    if (!bool)
    {
      paramContext = PicItemBuilder.a(paramContext, paramMessageForPic, paramChatThumbView);
      if (paramContext != null)
      {
        paramChatThumbView.setAdjustViewBounds(true);
        paramChatThumbView.setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(false));
        paramChatThumbView.setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(false));
        paramChatThumbView.setImageDrawable(paramContext.mutate());
      }
      paramChatThumbView.setTag(2131364648, paramMessageForPic);
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp70_68 = arrayOfInt;
    tmp70_68[0] = 0;
    int[] tmp74_70 = tmp70_68;
    tmp74_70[1] = 0;
    tmp74_70;
    URL localURL = URLDrawableHelper.getURL(paramMessageForPic, 65537);
    try
    {
      localURL = new URL(localURL.toString());
      if (localURL == null)
      {
        paramChatThumbView.setImageDrawable(TroopFileItemBuilder.a(2, 200, 200));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
        localBasicPicInfo = null;
      }
      ReplyTextItemBuilder.BasicPicInfo localBasicPicInfo = a(paramContext, paramMessageForPic, paramChatThumbView, arrayOfInt);
      paramContext = a(paramContext, paramMessageForPic, paramChatThumbView, new int[] { 0, 0 }, localBasicPicInfo);
      paramChatThumbView.setTag(2131364648, paramMessageForPic);
      if (arrayOfInt[0] <= 0) {
        break label427;
      }
    }
    int j;
    int n;
    label251:
    int i1;
    int i2;
    label273:
    int k;
    label296:
    int m;
    if (arrayOfInt[1] > 0)
    {
      paramMessageForPic = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
      j = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      n = Math.min(CommonImgThumbHelper.getImgThumbMinPx(bool), 80);
      if (arrayOfInt[0] <= j) {
        break label440;
      }
      i = j;
      if (arrayOfInt[1] <= j) {
        break label449;
      }
      i1 = AIOUtils.a(95.0F, paramChatThumbView.getResources());
      if (i <= j) {
        break label458;
      }
      i2 = 0;
      if ((i2 != 0) || (i <= i1)) {
        break label471;
      }
      if (i1 >= n) {
        break label464;
      }
      k = n;
      m = arrayOfInt[1] * k / arrayOfInt[0];
    }
    label427:
    label440:
    label449:
    label458:
    label464:
    label471:
    do
    {
      do
      {
        paramMessageForPic.width = k;
        paramMessageForPic.height = m;
        if (paramHasSourceMessage != null)
        {
          if (paramHasSourceMessage.getSourceMsgInfo() != null)
          {
            paramHasSourceMessage.getSourceMsgInfo().replyPicWidth = k;
            paramHasSourceMessage.getSourceMsgInfo().replyPicHeight = m;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "set size :" + arrayOfInt[0] + "," + arrayOfInt[1] + " real:" + k + "," + m);
          }
        }
        paramChatThumbView.setImageDrawable(paramContext.mutate());
        a(paramContext);
        return;
        i = arrayOfInt[0];
        break;
        j = arrayOfInt[1];
        break label251;
        i2 = 1;
        break label273;
        k = i1;
        break label296;
        k = i;
        m = j;
      } while (i2 == 0);
      k = i;
      m = j;
    } while (j <= i1);
    if (i1 < n) {}
    for (int i = n;; i = i1)
    {
      k = arrayOfInt[0] * i / arrayOfInt[1];
      m = i;
      break;
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord2)
  {
    int j = 4;
    Object localObject;
    ImageView localImageView;
    if ((paramMessageRecord1 instanceof MessageForReplyText))
    {
      localObject = (MessageForReplyText)paramMessageRecord1;
      boolean bool = MessageForReplyText.needHideLocate((MessageForReplyText)localObject);
      localObject = (TextView)paramViewGroup.findViewById(2131367424);
      localImageView = (ImageView)paramViewGroup.findViewById(2131369714);
      if (!a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface)) {
        break label121;
      }
      paramContext = a(paramContext, paramQQAppInterface, paramMessageRecord1, paramMessageRecord2);
      if (paramContext == null) {
        break label105;
      }
      ((TextView)localObject).setText(paramContext);
      ((TextView)localObject).setVisibility(0);
      label83:
      if (!bool) {
        break label115;
      }
    }
    label105:
    label115:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      localObject = null;
      break;
      ((TextView)localObject).setVisibility(8);
      break label83;
    }
    label121:
    paramViewGroup = paramContext.getString(2131699093);
    if (!android.text.TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
    {
      paramMessageRecord1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSourceMsgInfo.mSourceMsgToUin + "");
      paramViewGroup = paramSourceMsgInfo.mSourceMsgTroopName;
      paramQQAppInterface = paramViewGroup;
      if (paramMessageRecord1 != null)
      {
        paramQQAppInterface = paramViewGroup;
        if (!android.text.TextUtils.isEmpty(paramMessageRecord1.getTroopDisplayName())) {
          paramQQAppInterface = paramMessageRecord1.getTroopDisplayName();
        }
      }
      paramViewGroup = paramContext.getString(2131699092) + paramQQAppInterface;
    }
    ((TextView)localObject).setText(paramViewGroup);
    ((TextView)localObject).setVisibility(0);
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    if ((paramContext != null) && ((paramContext.a() instanceof MultiForwardChatPie))) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = j;; i = 0)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
  }
  
  private static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131379316);
    int i = paramViewGroup.findViewById(2131372115).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.d(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(HardCodeUtil.a(2131713365));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131368802);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = DisplayUtil.a(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.e = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131371926);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131371908);
      if (localBubbleImageView.getDrawable() == null) {
        a(localBubbleImageView, paramContext, paramSourceMsgInfo);
      }
      a(localBubbleImageView, paramMessageRecord1);
      a(paramQQAppInterface, paramContext, paramViewGroup, paramMessageRecord2, paramString);
      if (paramMessageRecord2 == null) {
        break;
      }
      b(paramMessageRecord2, paramSourceMsgInfo, localBubbleImageView, paramViewGroup, (ETTextView)localObject, paramInt, paramString, paramMessageRecord1, paramContext, paramQQAppInterface, null);
      return;
      localBubbleImageView.setContentDescription(HardCodeUtil.a(2131713358));
    }
    if ((paramBoolean2) || (a(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new ReplyTextItemBuilder.10(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
      return;
    }
    localBubbleImageView.setVisibility(8);
    b(paramViewGroup, (TextView)localObject, paramInt, paramString, null);
    a(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, paramSourceMsgInfo, (ETTextView)localObject, paramViewGroup, paramInt, paramString);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if (((paramMessageRecord instanceof MessageForReplyText)) && (QLog.isColorLevel())) {
      QLog.d("SendMsgBtn", 2, "ReplyItemBuilder reply:" + paramMessageRecord + " sourceMsg=" + ((MessageForReplyText)paramMessageRecord).getSourceMessage());
    }
    String str = TimeFormatterUtils.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131372115);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131379346);
    boolean bool;
    Object localObject2;
    Object localObject1;
    label142:
    MessageRecord localMessageRecord;
    if ((paramBoolean) || (a(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (android.text.TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
        break label386;
      }
      localObject1 = paramSourceMsgInfo.mAnonymousNickName;
      localMessageRecord = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break label582;
      }
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (!(localMessageRecord instanceof MessageForPic)) {
        break label634;
      }
      paramString = (String)localObject2;
      if (FlashPicHelper.a(localMessageRecord))
      {
        if (localObject2 == null) {
          break label571;
        }
        paramInt = ((String)localObject2).indexOf('[');
        if (paramInt < 0) {
          break label571;
        }
        int i = ((String)localObject2).indexOf(']');
        if (i <= paramInt) {
          break label571;
        }
        paramString = ((String)localObject2).substring(paramInt, i + 1);
      }
      label237:
      paramBoolean = true;
      paramInt = 0;
    }
    for (;;)
    {
      localObject2 = localMessageRecord;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        localObject2 = localMessageRecord;
        if (localMessageForReplyText.getSourceMessage() != null) {
          localObject2 = localMessageForReplyText.getSourceMessage();
        }
      }
      a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, paramSessionInfo, (MessageRecord)localObject2);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        localTextView1.setTag(2131378901, localObject1);
        localTextView1.setTag(2131378902, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
        localTextView1.setText((CharSequence)localObject1);
        localTextView2.setText(" " + str);
      }
      a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject2, paramBoolean, paramInt, paramString, bool);
      return;
      bool = false;
      break;
      label386:
      if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        localObject1 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if (localObject1 != null)
        {
          localObject1 = TroopBusinessUtil.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            paramSourceMsgInfo.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).c;
          }
        }
        localObject1 = "";
        break label142;
      }
      localObject1 = localTextView1.getTag(2131378902);
      if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
      {
        ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str), 64, null, true);
        localObject1 = "";
        break label142;
      }
      localTextView1.setText(new ColorNickText((String)localTextView1.getTag(2131378901), 16).a());
      localTextView2.setText(" " + str);
      localObject1 = "";
      break label142;
      label571:
      paramString = HardCodeUtil.a(2131713360);
      break label237;
      label582:
      if (((localMessageRecord instanceof MessageForPic)) && (bool) && ((paramMessageRecord instanceof HasSourceMessage)))
      {
        paramBoolean = true;
        paramInt = 0;
      }
      for (;;)
      {
        paramString = a(paramQQAppInterface, paramSourceMsgInfo, paramMessageRecord, (String)localObject2, localMessageRecord);
        break;
        paramInt = 1;
        paramBoolean = false;
      }
      label634:
      paramString = (String)localObject2;
      paramInt = 1;
      paramBoolean = false;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    HasSourceMessage localHasSourceMessage = null;
    if ((paramMessageRecord1 instanceof HasSourceMessage)) {
      localHasSourceMessage = (HasSourceMessage)paramMessageRecord1;
    }
    if ((paramMessageRecord2 instanceof MessageForPic)) {
      a(paramContext, paramChatThumbView, localHasSourceMessage, (MessageForPic)paramMessageRecord2);
    }
    do
    {
      return;
      if (!FileManagerUtil.a(paramMessageRecord2)) {
        break;
      }
      paramContext = a(paramQQAppInterface, paramMessageRecord2);
      if ((paramContext instanceof MessageForTroopFile))
      {
        b(paramQQAppInterface, paramChatThumbView, paramContext);
        return;
      }
    } while (!(paramContext instanceof MessageForFile));
    a(paramQQAppInterface, paramChatThumbView, paramContext);
    return;
    if ((paramMessageRecord2 instanceof MessageForShortVideo))
    {
      a(paramQQAppInterface, paramChatThumbView, (MessageForReplyText)paramMessageRecord1, (MessageForShortVideo)paramMessageRecord2);
      return;
    }
    if ((localHasSourceMessage != null) && (localHasSourceMessage.getSourceMsgInfo() != null) && (localHasSourceMessage.getSourceMsgInfo().replyPicWidth != 0))
    {
      paramChatThumbView.setImageDrawable(TroopFileItemBuilder.a(2, 200, 200));
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new ReplyTextItemBuilder.2(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
    if (paramMessageRecord.istroop == 0)
    {
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
      return;
    }
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
  }
  
  private static void a(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().toString();
    ThreadManager.getSubThreadHandler().post(new ReplyTextItemBuilder.12(str, paramURLDrawable));
  }
  
  public static void a(ChatThumbView paramChatThumbView)
  {
    if (paramChatThumbView == null) {
      return;
    }
    paramChatThumbView.setVisibility(8);
    paramChatThumbView = (ViewGroup)paramChatThumbView.getParent();
    if (paramChatThumbView == null)
    {
      QLog.i("ReplyTextItemBuilder<QFile>", 1, "resetReplyThumbImageView: can not get imageContent");
      return;
    }
    Object localObject = paramChatThumbView.findViewById(2131379312);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365431);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365619);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131368630);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(ChatThumbView paramChatThumbView, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSourceMsgInfo.replyPicWidth == 0) {
      return;
    }
    Bitmap localBitmap;
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      paramChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      paramChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(URLDrawableHelper.getLoadingDrawable());
  }
  
  public static void a(ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramChatThumbView.getTag() == paramMessageRecord) {
        return;
      }
      paramChatThumbView.setTag(paramMessageRecord);
      a(paramChatThumbView);
      return;
    }
    catch (Exception paramChatThumbView) {}
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = paramChatThumbView.getContext();
    paramInt2 = AIOUtils.a(120.0F, ((Context)localObject).getResources());
    int i = AIOUtils.a(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = AIOUtils.a(60.0F, ((Context)localObject).getResources());
      }
    }
    for (;;)
    {
      if (paramInt1 > paramInt2) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        localObject = (ViewGroup)paramChatThumbView.getParent();
        if (localObject == null) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "showDefaultReplyThumb: can not get imageContent");
        }
        do
        {
          return;
          paramInt1 = AIOUtils.a(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131379312);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365619);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365431);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131368630);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130844501);
          return;
        }
        paramChatThumbView.setImageResource(2130844500);
        return;
      }
    }
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (paramChatThumbView == null) {}
    do
    {
      return;
      paramChatThumbView.getContext();
      ViewGroup localViewGroup = (ViewGroup)paramChatThumbView.getParent();
      if (localViewGroup == null)
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyThumbImageView: can not get imageContent");
        return;
      }
      b(paramInt1, paramInt2, paramString, paramChatThumbView);
      if (paramBoolean)
      {
        paramString = localViewGroup.findViewById(2131365431);
        if (paramString != null)
        {
          paramChatThumbView = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
          paramString.setVisibility(0);
          ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
          localLayoutParams.width = paramChatThumbView.width;
          localLayoutParams.height = paramChatThumbView.height;
          paramString.setLayoutParams(paramChatThumbView);
        }
      }
      paramChatThumbView = localViewGroup.findViewById(2131365619);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131368630);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130844501);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (FileManagerUtil.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label750;
        }
        i = FileManagerUtil.a(FileManagerUtil.a(paramMessageRecord.fileName), 1);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramQQAppInterface = paramContext.getDrawable(i);
          paramTextView.setText(paramMessageRecord.fileName);
        }
      }
    }
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        i = AIOUtils.a(15.0F, paramContext.getResources());
        int j = AIOUtils.a(4.0F, paramContext.getResources());
        paramQQAppInterface.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
        paramTextView.setGravity(16);
        paramTextView.setCompoundDrawablePadding(j);
        paramTextView.setPadding(0, 0, 0, 0);
        paramTextView.invalidate();
        paramTextView.setMaxLines(1);
        paramTextView.setIncludeFontPadding(false);
        paramTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        return;
        paramQQAppInterface = paramContext.getResources().getDrawable(i);
        break;
        if (!(paramMessageRecord instanceof MessageForTroopFile)) {
          break label750;
        }
        paramMessageRecord = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label750;
        }
        i = FileManagerUtil.a(FileManagerUtil.a(paramMessageRecord.g), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.g);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!ChatHistoryStructAdapter.a(paramMessageRecord)) || (b(paramMessageRecord))) {
            break label745;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130844460);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = TeamWorkUtils.f(paramMessageRecord);
              i = AIOUtils.a(15.0F, paramContext.getResources());
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mLoadingDrawable = paramString;
              localURLDrawableOptions.mFailedDrawable = paramString;
              localURLDrawableOptions.mRequestWidth = i;
              localURLDrawableOptions.mRequestHeight = i;
              localURLDrawableOptions.mUseAutoScaleParams = false;
              if (android.text.TextUtils.isEmpty(paramQQAppInterface)) {
                break label458;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
              paramQQAppInterface.setBounds(0, 0, i, i);
            }
          }
          for (;;)
          {
            break;
            paramString = paramContext.getResources().getDrawable(2130844460);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!android.text.TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(TeamWorkUtils.c))
              {
                paramQQAppInterface = URLDrawable.getDrawable(TeamWorkUtils.d, localURLDrawableOptions);
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
            }
          }
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          break label745;
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
              if ((paramMessageRecord == null) || (!ArkMsgReplyConfigMgr.a().a(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label745;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label691;
              }
              paramQQAppInterface = paramContext.getDrawable(2130844460);
              paramMessageRecord = ArkMsgReplyConfigMgr.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = AIOUtils.a(15.0F, paramContext.getResources());
              paramString = URLDrawable.URLDrawableOptions.obtain();
              paramString.mLoadingDrawable = paramQQAppInterface;
              paramString.mFailedDrawable = paramQQAppInterface;
              paramString.mRequestWidth = i;
              paramString.mRequestHeight = i;
              paramString.mUseAutoScaleParams = false;
              if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
                break;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramMessageRecord, paramString);
              try
              {
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
              catch (Exception paramMessageRecord) {}
            }
          }
          catch (Exception paramMessageRecord)
          {
            label691:
            paramQQAppInterface = null;
            continue;
          }
          QLog.e("ReplyTextItemBuilder", 1, "handle MessageForArkApp error!" + paramMessageRecord.getMessage());
          break;
          paramQQAppInterface = paramContext.getResources().getDrawable(2130844460);
        }
      }
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setMaxLines(2147483647);
      paramTextView.setEllipsize(null);
      return;
      label745:
      paramQQAppInterface = null;
      continue;
      label750:
      paramQQAppInterface = null;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageForReplyText paramMessageForReplyText, MessageForShortVideo paramMessageForShortVideo)
  {
    Object localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = ShortVideoBusiManager.a(2, 2);
        ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).jdField_b_of_type_Int);
        localShortVideoDownloadInfo.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
        ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
        ((ShortVideoReq)localObject).a(new ReplyTextItemBuilder.11(paramMessageForShortVideo, paramMessageForReplyText, paramQQAppInterface, paramChatThumbView));
        ShortVideoBusiManager.a((ShortVideoReq)localObject, paramQQAppInterface);
        paramQQAppInterface = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131368630);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.setImageResource(2130844501);
          paramQQAppInterface.setVisibility(0);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReplyTextItemBuilder", 2, "no appRuntime");
        continue;
      }
      b(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight, (String)localObject, paramChatThumbView);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool;
    if (localFileManagerEntity != null)
    {
      int i = FileManagerUtil.a(localFileManagerEntity.fileName);
      if (i != 2) {
        break label89;
      }
      bool = true;
      if ((i == 2) || (i == 0)) {
        break label95;
      }
    }
    label540:
    label552:
    for (;;)
    {
      return;
      label89:
      bool = false;
      break;
      label95:
      if (localFileManagerEntity.status == 16)
      {
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file but is invalid. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "]");
        }
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      Object localObject1 = localObject2;
      if (!FileUtils.b((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!FileUtils.b((String)localObject1))
      {
        if (!bool) {
          break label503;
        }
        if (localFileManagerEntity.peerType != 3000) {
          break label490;
        }
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().b(localFileManagerEntity);
        localObject2 = paramQQAppInterface;
        if (!FileUtils.b(paramQQAppInterface))
        {
          if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
            break label540;
          }
          localObject1 = FilePicURLDrawlableHelper.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + ((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).jdField_a_of_type_Int + "]");
          }
          a(paramChatThumbView, bool, ((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).jdField_a_of_type_Int, ((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).jdField_b_of_type_Int);
        }
      }
      for (localObject2 = paramQQAppInterface;; localObject2 = paramQQAppInterface)
      {
        if (!FileUtils.b((String)localObject2)) {
          break label552;
        }
        if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
          break label554;
        }
        paramQQAppInterface = FilePicURLDrawlableHelper.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
        }
        a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, (String)localObject2);
        return;
        label490:
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity);
        break;
        label503:
        if (FilePicURLDrawlableHelper.a(localFileManagerEntity))
        {
          paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
          break;
        }
        paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
        break;
        a(paramChatThumbView, bool, 0, 0);
      }
    }
    label554:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 1;
    int j = 8;
    if ((paramMessageRecord == null) && (!"0X800A36B".equals(paramString))) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForText)) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
      if ((paramMessageRecord instanceof MessageForPic))
      {
        i = 2;
      }
      else if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        i = 3;
      }
      else if (((paramMessageRecord instanceof MessageForVideo)) || ((paramMessageRecord instanceof MessageForShortVideo)))
      {
        i = 4;
      }
      else if (((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)))
      {
        i = 5;
      }
      else
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          i = j;
          if (paramMessageRecord.structingMsg != null) {
            switch (paramMessageRecord.structingMsg.mMsgServiceID)
            {
            default: 
              i = j;
            }
          }
          for (;;)
          {
            break;
            i = 6;
            continue;
            i = 7;
          }
        }
        if ((paramMessageRecord instanceof MessageForArkApp)) {
          try
          {
            paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
            i = j;
            if (paramMessageRecord != null) {
              i = ArkMsgReplyConfigMgr.a(paramMessageRecord.appName, paramMessageRecord.appView);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ReplyTextItemBuilder", 1, "reportReplyItemEvent error for MessageForArkApp:" + paramMessageRecord.getMessage());
            i = 8;
          }
        } else {
          i = 8;
        }
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, Rect paramRect, boolean paramBoolean, int paramInt, File paramFile, float paramFloat)
  {
    int j;
    int i;
    if (paramRect != null)
    {
      j = paramRect.width();
      i = paramRect.height();
    }
    for (;;)
    {
      paramRect = a(j, i, 12.0F * paramFloat, paramBoolean);
      j = paramRect.jdField_a_of_type_Int;
      i = paramRect.jdField_b_of_type_Int;
      j = (j * paramInt + 80) / 160;
      paramInt = (i * paramInt + 80) / 160;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = j;
        paramArrayOfInt[1] = paramInt;
      }
      return;
      paramRect = new BitmapFactory.Options();
      paramRect.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(paramFile.getAbsolutePath(), paramRect);
        j = paramRect.outWidth;
        i = paramRect.outHeight;
        int k = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
        if ((k != 90) && (k != 270)) {
          continue;
        }
        j = paramRect.outHeight;
        i = paramRect.outWidth;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
          }
        }
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      int i = FileManagerUtil.a(paramQQAppInterface.g);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.status == 16) {
        break label63;
      }
      int i = FileManagerUtil.a(paramQQAppInterface.fileName);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label63:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("ReplyTextItemBuilder", 2, "renderReply: handle offline file , but invalid. msgUniseq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    return false;
  }
  
  public static boolean a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "sendUin= " + paramSourceMsgInfo.mSourceMsgSenderUin + " toUin=" + paramSourceMsgInfo.mSourceMsgToUin + " session curFin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + " type=" + paramSessionInfo.jdField_a_of_type_Int);
    }
    String str1 = paramSourceMsgInfo.mSourceMsgToUin + "";
    String str2 = paramSourceMsgInfo.mSourceMsgSenderUin + "";
    if (paramSourceMsgInfo.mSourceMsgToUin <= 0L) {
      paramSourceMsgInfo.mSourceMsgToUin = a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo.mSourceMsgSenderUin);
    }
    do
    {
      do
      {
        return true;
        if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
          return str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramSourceMsgInfo != null) && (str1.equals(paramSourceMsgInfo.troopcode))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    } while (((str2.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) || ((str1.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()))));
    return false;
  }
  
  protected static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  public static boolean a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(HardCodeUtil.a(2131713362)) == -1) {
      return false;
    }
    return true;
  }
  
  private static MessageRecord b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    Object localObject = null;
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null)) {}
    MessageRecord localMessageRecord;
    do
    {
      return null;
      if (!(paramMessageRecord2 instanceof MessageForMixedMsg)) {
        break label164;
      }
      localObject = (MessageForMixedMsg)paramMessageRecord2;
      if (((MessageForMixedMsg)localObject).msgElemList == null) {
        break;
      }
      localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(0);
      if ((localMessageRecord instanceof MessageForPic))
      {
        int i = 1;
        for (;;)
        {
          bool1 = bool2;
          if (i >= ((MessageForMixedMsg)localObject).msgElemList.size()) {
            break label149;
          }
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
          if ((!(localMessageRecord instanceof MessageForText)) || (android.text.TextUtils.isEmpty(localMessageRecord.msg))) {
            break;
          }
          paramStringBuilder.append(localMessageRecord.msg);
          i += 1;
        }
      }
    } while ((localMessageRecord instanceof MessageForText));
    boolean bool1 = false;
    label149:
    localObject = paramMessageRecord2;
    for (;;)
    {
      return a(paramQQAppInterface, paramMessageRecord1, paramMessageRecord2, paramStringBuilder, (MessageRecord)localObject, bool1);
      label164:
      if (((paramMessageRecord2 instanceof MessageForText)) && (!android.text.TextUtils.isEmpty(paramMessageRecord2.msg))) {
        paramStringBuilder.append(paramMessageRecord2.msg);
      }
      bool1 = false;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      paramString = ShortVideoItemBuilder.a(paramString, 55, 95, AIOUtils.a(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), AIOUtils.a(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, AIOUtils.a(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = ColorNickManager.a(str, paramMessageRecord, ChatTextSizeSettingActivity.b() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.d) {
        paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView2.setVisibility(8);
      return;
    case 0: 
      paramTextView1.setVisibility(8);
      paramTextView2.setVisibility(8);
      return;
    case 1: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.d) {
        paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.d) {
      paramTextView2.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    localMessageForTroopFile.doParse();
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = FileManagerUtil.a(localTroopFileStatusInfo.g);
    if ((localTroopFileStatusInfo == null) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 12))
    {
      if (k == 2) {}
      for (bool = true;; bool = false)
      {
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
    }
    if (FileUtils.b(localTroopFileStatusInfo.d)) {}
    for (String str = localTroopFileStatusInfo.d; FileUtils.b(str); str = localTroopFileStatusInfo.c)
    {
      if (k == 2) {
        bool = true;
      }
      paramQQAppInterface = FilePicURLDrawlableHelper.a(localMessageForTroopFile.width, localMessageForTroopFile.height, str);
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int, str);
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(localMessageForTroopFile.frienduin));
    int j = 383;
    int i = j;
    if (FilePicURLDrawlableHelper.b(localMessageForTroopFile.width, localMessageForTroopFile.height))
    {
      i = j;
      if (!FileUtil.b(localTroopFileStatusInfo.c)) {
        i = 640;
      }
    }
    if (localTroopFileStatusInfo.jdField_b_of_type_Int != 12)
    {
      if (localTroopFileStatusInfo.a != null)
      {
        paramQQAppInterface.a(localTroopFileStatusInfo.a, i);
        paramChatThumbView.setTag(2131364649, new Boolean(true));
      }
    }
    else {
      if (k != 2) {
        break label486;
      }
    }
    label486:
    for (bool = true;; bool = false)
    {
      a(paramChatThumbView, bool, 0, 0);
      if ((localMessageForTroopFile.width <= 0) || (localMessageForTroopFile.height <= 0)) {
        break label492;
      }
      paramQQAppInterface = FilePicURLDrawlableHelper.a(localMessageForTroopFile.width, localMessageForTroopFile.height, "");
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.jdField_a_of_type_Int + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_b_of_type_Int);
      return;
      paramQQAppInterface.a(localTroopFileStatusInfo.e, localTroopFileStatusInfo.g, localTroopFileStatusInfo.h, i);
      break;
    }
    label492:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  private static void b(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = false;
    Object localObject2 = null;
    int i;
    Object localObject1;
    boolean bool1;
    if ((paramMessageRecord1 instanceof MessageForPic)) {
      if (FlashPicHelper.a(paramMessageRecord1))
      {
        i = 1;
        localObject1 = paramString1;
        bool1 = bool2;
        paramString2 = localObject2;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramBubbleImageView.setVisibility(0);
        paramBubbleImageView.setTag(2131364649, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        b(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = AIOUtils.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof ReplyTextItemBuilder.ReplyTextViewHolder))) {
          ((ReplyTextItemBuilder.ReplyTextViewHolder)paramMessageRecord1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramBubbleImageView;
        }
        return;
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        continue;
        if ((paramMessageRecord1 instanceof MessageForShortVideo))
        {
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
        }
        else if ((paramMessageRecord1 instanceof MessageForMixedMsg))
        {
          localObject1 = a((MessageForMixedMsg)paramMessageRecord1);
          bool1 = ((ReplyTextItemBuilder.MixedMessageInfo)localObject1).jdField_a_of_type_Boolean;
          i = ((ReplyTextItemBuilder.MixedMessageInfo)localObject1).jdField_a_of_type_Int;
          paramString1 = ((ReplyTextItemBuilder.MixedMessageInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          localObject1 = ((ReplyTextItemBuilder.MixedMessageInfo)localObject1).jdField_a_of_type_JavaLangString;
          if (android.text.TextUtils.isEmpty(paramString2)) {
            break label617;
          }
        }
      }
    }
    for (;;)
    {
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        paramString2 = paramSourceMsgInfo.mSourceMsgText;
      }
      localObject1 = paramString2;
      paramString2 = paramString1;
      break;
      if ((paramMessageRecord1 instanceof MessageForLongMsg))
      {
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramMessageRecord1.msgtype != -1036) {
          break;
        }
        paramSourceMsgInfo = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
        if (paramSourceMsgInfo == null) {
          break label609;
        }
        paramString1 = a(paramSourceMsgInfo);
        bool1 = paramString1.jdField_a_of_type_Boolean;
        paramInt = paramString1.jdField_a_of_type_Int;
        paramSourceMsgInfo = paramString1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        paramString1 = paramString1.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        paramString2 = paramSourceMsgInfo;
        i = paramInt;
        localObject1 = paramString1;
        break;
        if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
        {
          paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
          if (paramString2 != null) {}
          for (CharSequence localCharSequence = paramString2.sb;; localCharSequence = null)
          {
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (localCharSequence == null) {
              break;
            }
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (paramSourceMsgInfo.mSourceMsgText.equals(localCharSequence.toString())) {
              break;
            }
            localObject1 = localCharSequence.toString();
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            break;
          }
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!FileManagerUtil.a(paramMessageRecord1)) {
          break;
        }
        paramSourceMsgInfo = a(paramQQAppInterface, paramMessageRecord1);
        if ((paramSourceMsgInfo instanceof MessageForFile))
        {
          paramString2 = localObject2;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (!a(paramQQAppInterface, paramSourceMsgInfo)) {
            break;
          }
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!(paramSourceMsgInfo instanceof MessageForTroopFile)) {
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo)) {
          break;
        }
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        break;
        a(paramBubbleImageView);
        break label87;
        label609:
        paramSourceMsgInfo = null;
        bool1 = false;
      }
      label617:
      paramString2 = (String)localObject1;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg == null) {}
    }
    switch (paramMessageRecord.structingMsg.mMsgServiceID)
    {
    default: 
      return false;
    }
    return true;
  }
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return super.a(paramChatMessage);
    }
    int i = localMessageForReplyText.mSourceMsgInfo.mType;
    return super.a(paramChatMessage);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramView.getTag();
      if (localReplyTextViewHolder != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder$ViewPool.a(localReplyTextViewHolder.e, paramView);
      }
    }
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localReplyTextViewHolder.e = -1;
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder$ViewPool.a(-1);
      if (paramViewHolder != null) {
        break label654;
      }
      paramViewHolder = new LinearLayout(localContext);
      paramViewHolder.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167052));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167045));
      paramView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramView.setMaxWidth(BaseChatItemLayout.e);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      paramView.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      paramView.setId(2131364637);
      localReplyTextViewHolder.d = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = AIOUtils.a(5.0F, localContext.getResources());
      paramViewHolder.addView(localReplyTextViewHolder.d, paramView);
    }
    label654:
    for (;;)
    {
      ((ETTextView)localReplyTextViewHolder.d).setFont(0, paramChatMessage.uniseq);
      localReplyTextViewHolder.d.setTypeface(VasShieldFont.a(paramChatMessage));
      localReplyTextViewHolder.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.d.setText(localMessageForReplyText.sb);
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, localReplyTextViewHolder.d, paramChatMessage);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localReplyTextViewHolder.d.setOnTouchListener(paramOnLongClickAndTouchListener);
      localReplyTextViewHolder.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView = paramViewHolder;
      if ((localReplyTextViewHolder.d instanceof AnimationTextView))
      {
        ((AnimationTextView)localReplyTextViewHolder.d).onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        paramView = paramViewHolder;
      }
      if (paramView != null)
      {
        paramView.setTag(localReplyTextViewHolder);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.d) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          paramViewHolder = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label615;
          }
          paramView.setContentDescription(HardCodeUtil.a(2131713359) + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + HardCodeUtil.a(2131713364) + paramViewHolder);
        }
      }
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "reply type is" + localMessageForReplyText.mSourceMsgInfo.mType);
      }
      i = localMessageForReplyText.mSourceMsgInfo.mType;
      if (localMessageForReplyText.mSourceMsgInfo.oriMsgType == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramView = a(paramBaseChatItemLayout, localContext, localReplyTextViewHolder, localMessageForReplyText, paramOnLongClickAndTouchListener, bool);
        break;
      }
      label615:
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + HardCodeUtil.a(2131713361) + paramViewHolder);
      return paramView;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ReplyTextItemBuilder.ReplyTextViewHolder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ReplyTextItemBuilder.ReplyTextViewHolder(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder$ViewPool.a();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (AIOSelectableDelegateImpl.a().c())
    {
      paramContext = AIOSelectableDelegateImpl.a().b();
      if (paramContext == null) {
        if (((MessageForReplyText)localObject).sb != null)
        {
          paramContext = ((MessageForReplyText)localObject).sb.toString();
          label103:
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      label105:
      if (paramInt != 0)
      {
        localBundle.putInt("forward_type", -6);
        localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        localObject = (ForwardMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER);
        MessageRecord localMessageRecord = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((ForwardMsgManager)localObject).a(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label103;
        if (paramContext.length() != AIOSelectableDelegateImpl.a().a()) {
          break label390;
        }
        paramInt = 1;
        break label105;
        if (((MessageForReplyText)localObject).sb != null) {}
        for (paramContext = ((MessageForReplyText)localObject).sb.toString();; paramContext = ((MessageForReplyText)localObject).msg)
        {
          paramInt = 1;
          break;
        }
        localBundle.putInt("forward_type", -1);
      }
      label390:
      paramInt = 0;
    }
  }
  
  public void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690019);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ReplyTextItemBuilder.7(this, paramView), new ReplyTextItemBuilder.8(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ReplyTextItemBuilder.ReplyTextViewHolder)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.jdField_a_of_type_AndroidWidgetTextView == null) {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
    }
    int i;
    do
    {
      return;
      i = AIOUtils.a(1.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    } while (localMessageForReplyText.mSourceMsgInfo == null);
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.e - AIOUtils.a(16.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources());
    if (paramChatMessage.isSend())
    {
      paramView.d.setPadding(f, 0, e, d);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramChatMessage.leftMargin = f;
      paramChatMessage.rightMargin = (e + i * 2);
      paramChatMessage.topMargin = (jdField_c_of_type_Int + i * 4);
      paramChatMessage.bottomMargin = 0;
      paramView.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramChatMessage);
      i = j - f - e - i * 2;
    }
    for (;;)
    {
      float f = paramView.c.getPaint().measureText(paramView.c.getText().toString());
      f = AIOUtils.a(37.0F, paramView.jdField_a_of_type_AndroidWidgetTextView.getResources()) + f;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag(2131378901);
      paramChatMessage = com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(paramView.jdField_a_of_type_AndroidWidgetTextView, paramChatMessage, i - (int)f);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      paramView.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(i);
      paramView.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(i);
      return;
      paramView.d.setPadding(e, 0, f, d);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramChatMessage.leftMargin = (e + i * 2);
      paramChatMessage.rightMargin = e;
      paramChatMessage.topMargin = (i * 4 + jdField_c_of_type_Int);
      paramChatMessage.bottomMargin = 0;
      i = j - e - e;
      paramView.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramChatMessage);
    }
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
    paramViewHolder = (MessageForReplyText)paramChatMessage;
    if (paramViewHolder.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838379);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
    int i = paramViewHolder.mSourceMsgInfo.mType;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()) || (SimpleUIUtil.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131167056);
        localReplyTextViewHolder.d.setTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        localReplyTextViewHolder.c.setTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramViewHolder.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label295;
        }
      }
      label295:
      for (paramViewHolder = paramView.getColorStateList(2131167055);; paramViewHolder = paramView.getColorStateList(2131167054))
      {
        localReplyTextViewHolder.d.setLinkTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.setAlpha(localReplyTextViewHolder.c, 0.9F);
        ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        paramViewHolder = paramView.getColorStateList(2131167052);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0)
    {
      localReplyTextViewHolder.d.setTextColor(-16777216);
      localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localReplyTextViewHolder.c.setTextColor(-16777216);
      localReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label408:
      if (paramBubbleInfo.jdField_c_of_type_Int != 0) {
        break label751;
      }
      paramViewHolder = paramView.getResources().getColorStateList(2131167054);
      localReplyTextViewHolder.d.setLinkTextColor(paramViewHolder);
      localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
    }
    for (;;)
    {
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.c, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      if ((!paramBubbleInfo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localReplyTextViewHolder.d.getCurrentTextColor(), 10000.0D * localReplyTextViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) != 1)) {
        break;
      }
      paramViewHolder = (ETTextView)localReplyTextViewHolder.d;
      float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      paramViewHolder.setTextColor(-1);
      paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localReplyTextViewHolder.d.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.c.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramBubbleInfo.jdField_b_of_type_Int, PorterDuff.Mode.SRC_ATOP));
      localReplyTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label408;
      label751:
      localReplyTextViewHolder.d.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
      localReplyTextViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
      localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = ImageUtil.a(paramViewHolder.a.getBackground());
    if (paramChatMessage == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if (((paramViewHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder)) && (((ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder).jdField_a_of_type_AndroidViewViewGroup != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "ReplyTextViewHolder error");
      }
      return;
      paramInt2 = a(paramChatMessage);
      paramInt1 = paramInt2;
      if (!paramChatMessage.isRecycled())
      {
        paramChatMessage.recycle();
        paramInt1 = paramInt2;
      }
    }
    if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 >= 170) || (((paramInt1 == 0) || (paramInt1 == -16777216) || (paramInt1 == -15366474)) && (!"2920".equals(ThemeUtil.getCurrentThemeId()))))
    {
      ((ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838377));
      return;
    }
    ((ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder).jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838378));
  }
  
  public void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(paramViewHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder)) {}
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder;
    do
    {
      do
      {
        do
        {
          return;
          localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        paramViewHolder = null;
        if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
          paramViewHolder = paramChatMessage.sb;
        }
      } while ((paramViewHolder == null) || (!(paramViewHolder instanceof QQText)));
      paramChatMessage = (QQText)paramViewHolder;
      paramViewHolder = (EmoticonSpan[])paramChatMessage.getSpans(0, paramViewHolder.length(), EmoticonSpan.class);
    } while ((paramViewHolder.length <= 0) || (paramChatMessage.toPurePlainText().length() != 0));
    int j = paramViewHolder.length;
    while (i < j)
    {
      paramViewHolder[i].setSize(ScreenUtil.dip2px(26.0F));
      i += 1;
    }
    localReplyTextViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setText(paramChatMessage);
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */