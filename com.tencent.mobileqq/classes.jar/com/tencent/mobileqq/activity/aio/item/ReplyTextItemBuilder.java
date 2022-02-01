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
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.etrump.mixlayout.ETLayout;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.comment.DanmuUtil;
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
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.replymsg.ReplyItemClickListener;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ReplyTextItemBuilder
  extends TextItemBuilder
{
  protected static Drawable a = new ColorDrawable(Color.parseColor("#e1e1e5"));
  private View.OnClickListener F = new ReplyTextItemBuilder.6(this);
  protected ReplyTextItemBuilder.ViewPool w = new ReplyTextItemBuilder.ViewPool(null);
  protected OnLongClickAndTouchListener x = new ReplyTextItemBuilder.1(this);
  
  public ReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.C = new ReplyItemClickListener(this);
  }
  
  private int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth() / 2;
      int k = paramBitmap.getHeight();
      long l3 = 0L;
      long l2 = 0L;
      long l1 = l2;
      while (i < k)
      {
        int m = paramBitmap.getPixel(j, i);
        l3 += Color.red(m);
        l2 += Color.green(m);
        l1 += Color.blue(m);
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("count r=");
        paramBitmap.append(l3);
        paramBitmap.append(" g=");
        paramBitmap.append(l2);
        paramBitmap.append(" b=");
        paramBitmap.append(l1);
        paramBitmap.append(" height=");
        paramBitmap.append(k);
        QLog.d("ReplyTextItemBuilder", 2, paramBitmap.toString());
      }
      return Color.rgb((int)l3 / k, (int)l2 / k, (int)l1 / k);
    }
    return 0;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000))
    {
      if (paramLong == paramQQAppInterface.getLongAccountUin()) {
        return Long.parseLong(paramSessionInfo.b);
      }
      return paramQQAppInterface.getLongAccountUin();
    }
    return Long.parseLong(paramSessionInfo.b);
  }
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, ReplyTextItemBuilder.ReplyTextViewHolder paramReplyTextViewHolder, MessageForReplyText paramMessageForReplyText, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    paramReplyTextViewHolder.t = 0;
    Object localObject1 = this.w.a(0);
    if (localObject1 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject2 = a(paramContext);
      paramReplyTextViewHolder.a = ((ViewGroup)localObject2);
      paramReplyTextViewHolder.s = ((TextView)((ViewGroup)localObject2).findViewById(2131447354));
      paramReplyTextViewHolder.b = ((TextView)((ViewGroup)localObject2).findViewById(2131439121));
      paramReplyTextViewHolder.g = ((TextView)((ViewGroup)localObject2).findViewById(2131433662));
      paramReplyTextViewHolder.d = ((ETTextView)((ViewGroup)localObject2).findViewById(2131438908));
      paramReplyTextViewHolder.e = ((ETTextView)((ViewGroup)localObject2).findViewById(2131438922));
      ((ViewGroup)localObject2).setId(2131430607);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramReplyTextViewHolder.d);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramReplyTextViewHolder.e);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramReplyTextViewHolder.c = ((ImageView)((ViewGroup)localObject2).findViewById(2131436449));
      paramReplyTextViewHolder.c.setVisibility(4);
      paramReplyTextViewHolder.c.setContentDescription(HardCodeUtil.a(2131910887));
      localObject2 = new ETTextView(paramContext);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
      ((ETTextView)localObject2).setTextColor(paramContext.getResources().getColorStateList(2131168016));
      ((ETTextView)localObject2).setLinkTextColor(paramContext.getResources().getColorStateList(2131168008));
      ((ETTextView)localObject2).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      ((ETTextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
      ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      i = BaseChatItemLayout.getTextPaddingAlignHead();
      j = BaseChatItemLayout.getTextPaddingAlignError();
      if (paramMessageForReplyText.isSend())
      {
        i = BaseChatItemLayout.getTextPaddingAlignError();
        j = BaseChatItemLayout.getTextPaddingAlignHead();
      }
      ((ETTextView)localObject2).setPadding(i, 0, j, BaseChatItemLayout.o);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = j;
      localLayoutParams.topMargin = BaseChatItemLayout.k;
      ((LinearLayout)localObject1).addView(paramReplyTextViewHolder.a, localLayoutParams);
      ((ETTextView)localObject2).setId(2131430581);
      paramReplyTextViewHolder.v = ((TextView)localObject2);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = AIOUtils.b(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramReplyTextViewHolder.v, localLayoutParams);
      paramContext = (Context)localObject1;
    }
    else
    {
      paramContext = (Context)localObject1;
    }
    paramReplyTextViewHolder.b = ((TextView)paramContext.findViewById(2131439121));
    paramReplyTextViewHolder.s = ((TextView)paramContext.findViewById(2131447354));
    paramReplyTextViewHolder.g = ((TextView)paramContext.findViewById(2131433662));
    paramReplyTextViewHolder.d = ((ETTextView)paramContext.findViewById(2131438908));
    paramReplyTextViewHolder.e = ((ETTextView)paramContext.findViewById(2131438922));
    paramReplyTextViewHolder.v = ((ETTextView)paramContext.findViewById(2131430581));
    paramReplyTextViewHolder.a = ((ViewGroup)paramContext.findViewById(2131430607));
    paramReplyTextViewHolder.c = ((ImageView)paramContext.findViewById(2131436449));
    paramReplyTextViewHolder.c.setContentDescription(HardCodeUtil.a(2131910884));
    paramReplyTextViewHolder.c.setVisibility(4);
    paramReplyTextViewHolder.c.setImageDrawable(this.e.getResources().getDrawable(2130838262));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {
      localObject1 = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);
    } else {
      localObject1 = "";
    }
    localObject1 = VasShieldFont.a((String)localObject1);
    paramReplyTextViewHolder.s.setTypeface((Typeface)localObject1);
    paramReplyTextViewHolder.b.setTypeface((Typeface)localObject1);
    paramReplyTextViewHolder.g.setTypeface((Typeface)localObject1);
    paramReplyTextViewHolder.d.setTypeface((Typeface)localObject1);
    paramReplyTextViewHolder.e.setTypeface((Typeface)localObject1);
    if (!android.text.TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      localObject1 = ((ETTextView)paramReplyTextViewHolder.v).getETLayout();
      if (localObject1 != null) {
        ((ETLayout)localObject1).b = (paramMessageForReplyText.uniseq + 1L);
      }
    }
    ((ETTextView)paramReplyTextViewHolder.v).setFont(0, paramMessageForReplyText.uniseq);
    int i = ((ETTextView)paramReplyTextViewHolder.v).mMaxWidth;
    int j = BaseChatItemLayout.e;
    paramReplyTextViewHolder.v.setMaxWidth(j);
    paramReplyTextViewHolder.v.setTextSize(0, this.f.r);
    if (i != j) {
      ((ETTextView)paramReplyTextViewHolder.v).mMsgId = 0L;
    }
    paramReplyTextViewHolder.v.setText(paramMessageForReplyText.sb);
    if (AppSetting.e) {
      paramReplyTextViewHolder.v.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramMessageForReplyText.sb.toString()));
    }
    TroopUtils.a(this.d, this.f, this.e, paramReplyTextViewHolder.v, paramMessageForReplyText);
    a(this.e, this.d, paramReplyTextViewHolder.a, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.f);
    paramReplyTextViewHolder.f = ((BubbleImageView)paramContext.findViewById(2131447325));
    paramReplyTextViewHolder.a.setOnClickListener(this.C);
    paramReplyTextViewHolder.d.setOnClickListener(this.C);
    paramReplyTextViewHolder.f.setOnClickListener(this.C);
    paramContext.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramContext.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramReplyTextViewHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramReplyTextViewHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramReplyTextViewHolder.d.setOnTouchListener(this.x);
    paramReplyTextViewHolder.d.setOnLongClickListener(this.x);
    paramReplyTextViewHolder.f.setOnTouchListener(this.x);
    paramReplyTextViewHolder.f.setOnLongClickListener(this.x);
    localObject1 = paramReplyTextViewHolder.f;
    float f;
    if (QQTheme.isNowSimpleUI()) {
      f = 8.0F;
    } else {
      f = 15.0F;
    }
    ((BubbleImageView)localObject1).setRadius(f);
    paramReplyTextViewHolder.v.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramReplyTextViewHolder.v.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramReplyTextViewHolder.c.setOnClickListener(this.C);
    if ((paramReplyTextViewHolder.v instanceof AnimationTextView)) {
      ((AnimationTextView)paramReplyTextViewHolder.v).onDoubleClick = this.E;
    }
    if ((paramReplyTextViewHolder.d instanceof AnimationTextView)) {
      paramReplyTextViewHolder.d.onDoubleClick = this.E;
    }
    if (paramReplyTextViewHolder.w == null) {
      paramReplyTextViewHolder.w = new AIOSelectableDelegateProxy();
    }
    if ((paramContext instanceof SelectableComponent))
    {
      paramReplyTextViewHolder.w.a((SelectableComponent)paramContext);
      paramReplyTextViewHolder.w.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    paramReplyTextViewHolder.w.b(paramMessageForReplyText);
    return paramContext;
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131626737, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131439121);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131447354);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localObject = (TextView)localRelativeLayout.findViewById(2131433662);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ImmersiveUtils.setAlpha((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((TextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ImageView)localRelativeLayout.findViewById(2131436449)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131438908);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131168008));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setMaxLines(2);
    ((ETTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.b(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131438922);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131168008));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    ((ETTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((ETTextView)localObject).setMaxLines(2);
    ((ETTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.b(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  private static URLDrawable.URLDrawableOptions a(MessageForPic paramMessageForPic, int paramInt, boolean paramBoolean)
  {
    int i = paramMessageForPic.thumbWidth;
    int k = paramMessageForPic.thumbHeight;
    int j = 99;
    if ((i > 0) && (k > 0))
    {
      paramMessageForPic = a(i, k, 0.0F, paramBoolean);
      j = paramMessageForPic.a;
      i = paramMessageForPic.b;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("MessageForPic without width/height of thumb, width = ");
        paramMessageForPic.append(i);
        paramMessageForPic.append(", height = ");
        paramMessageForPic.append(k);
        QLog.d("ReplyTextItemBuilder", 2, paramMessageForPic.toString());
      }
      i = 99;
    }
    float f = paramInt / 160.0F;
    paramInt = (int)(j * f + 0.5F);
    i = (int)(i * f + 0.5F);
    paramMessageForPic = URLDrawable.URLDrawableOptions.obtain();
    paramMessageForPic.mRequestWidth = paramInt;
    paramMessageForPic.mRequestHeight = i;
    return paramMessageForPic;
  }
  
  public static URLDrawable a(Context paramContext, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, URL paramURL, Rect paramRect, File paramFile, boolean paramBoolean)
  {
    int k = paramContext.getResources().getDisplayMetrics().densityDpi;
    float f1 = k / 160.0F;
    if (paramRect != null)
    {
      i = paramRect.width();
      j = paramRect.height();
    }
    else
    {
      paramContext = new BitmapFactory.Options();
      paramContext.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(paramFile.getAbsolutePath(), paramContext);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
        }
      }
      i = paramContext.outWidth;
      j = paramContext.outHeight;
      int m = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
      if ((m != 90) && (m != 270)) {
        break label143;
      }
      i = paramContext.outHeight;
      j = paramContext.outWidth;
    }
    label143:
    paramContext = a(i, j, URLDrawableHelper.getRoundCorner() * f1, paramBoolean);
    int j = paramContext.a;
    int i = paramContext.b;
    float f3 = paramContext.d;
    j = (j * k + 80) / 160;
    i = (i * k + 80) / 160;
    f1 = f3;
    if (paramRect != null)
    {
      if (paramRect.width() < j) {
        f1 = paramRect.width();
      }
      for (float f2 = j;; f2 = i)
      {
        f1 = f3 * (f1 / f2);
        break;
        f1 = f3;
        if (paramRect.height() >= i) {
          break;
        }
        f1 = paramRect.height();
      }
    }
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
    }
    paramContext = URLDrawableHelper.getDrawable(paramURL, j, i, new EmptyDrawable(j, i), URLDrawableHelper.getFailedDrawable(), true, f1);
    paramContext.setIgnorePause(true);
    paramContext.setFadeInImage(true);
    if (paramChatThumbView != null) {
      paramChatThumbView.b = true;
    }
    if (QLog.isColorLevel())
    {
      paramChatThumbView = new StringBuilder();
      paramChatThumbView.append("getNoRoundThumbDrawableAbsDownloader cache:");
      paramChatThumbView.append(j);
      paramChatThumbView.append(",");
      paramChatThumbView.append(i);
      QLog.d("ReplyTextItemBuilder", 2, paramChatThumbView.toString());
    }
    return paramContext;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, ReplyTextItemBuilder.BasicPicInfo paramBasicPicInfo)
  {
    boolean bool1 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramMessageForPic.imageType);
    boolean bool2 = paramBasicPicInfo.g;
    URL localURL = paramBasicPicInfo.f;
    Rect localRect = paramBasicPicInfo.e;
    if (localURL == null)
    {
      paramBasicPicInfo = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      try
      {
        localURL = new URL(paramBasicPicInfo.toString());
        paramBasicPicInfo = localURL;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getThumbDrawable,using thumb,uniseq:");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(paramBasicPicInfo);
        QLog.d("ReplyTextItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramBasicPicInfo = (ReplyTextItemBuilder.BasicPicInfo)localObject;
    }
    Object localObject = paramBasicPicInfo.toString();
    int i = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.b = false;
    }
    float f = i / 160.0F;
    if (GlobalImageCache.a.get(localObject) != null)
    {
      paramChatThumbView = URLDrawableHelper.getDrawable(paramBasicPicInfo, 0, 0, null, null, true, URLDrawableHelper.getRoundCorner() * f);
      paramContext = paramChatThumbView;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = paramChatThumbView.getIntrinsicWidth();
        paramArrayOfInt[1] = paramChatThumbView.getIntrinsicHeight();
        paramContext = paramChatThumbView;
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("getNoRoundThumbDrawableAbsDownloader cache:");
          paramContext.append(paramArrayOfInt[0]);
          paramContext.append(",");
          paramContext.append(paramArrayOfInt[1]);
          QLog.d("ReplyTextItemBuilder", 2, paramContext.toString());
          paramContext = paramChatThumbView;
        }
      }
    }
    else
    {
      localObject = AbsDownloader.getFile((String)localObject);
      if (localObject != null)
      {
        paramContext = a(paramContext, paramChatThumbView, paramArrayOfInt, paramBasicPicInfo, localRect, (File)localObject, bool1);
      }
      else
      {
        boolean bool3 = URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext);
        paramChatThumbView = a(paramMessageForPic, i, bool1);
        paramChatThumbView.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
        paramChatThumbView.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
        paramChatThumbView.mPlayGifImage = bool2;
        paramChatThumbView.mGifRoundCorner = URLDrawableHelper.getRoundCorner();
        paramChatThumbView.mImgType = paramMessageForPic.imageType;
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramChatThumbView.mRequestWidth;
          paramArrayOfInt[1] = paramChatThumbView.mRequestHeight;
        }
        paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130844952);
        paramContext = URLDrawable.getDrawable(paramBasicPicInfo, paramChatThumbView);
        if (QLog.isColorLevel())
        {
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append("getNoRoundThumbDrawableautoDownload:");
          paramArrayOfInt.append(paramChatThumbView.mRequestWidth);
          paramArrayOfInt.append(",");
          paramArrayOfInt.append(paramChatThumbView.mRequestHeight);
          QLog.d("ReplyTextItemBuilder", 2, paramArrayOfInt.toString());
        }
        if ((!PicContants.a) && (!(bool3 ^ true))) {
          paramContext.setAutoDownload(false);
        } else {
          paramContext.setAutoDownload(true);
        }
        paramContext.setProgressDrawable(new PhotoProgressDrawable(i(), 0, false));
      }
    }
    paramContext.setTag(paramMessageForPic);
    if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
      ((GifDrawable)paramContext.getCurrDrawable()).mutate();
    }
    return paramContext;
  }
  
  private static ReplyTextItemBuilder.BasicPicInfo a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
    int i = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
    ReplyTextItemBuilder.BasicPicInfo localBasicPicInfo = new ReplyTextItemBuilder.BasicPicInfo();
    float f2;
    float f1;
    if ((paramInt1 >= i) && (paramInt2 >= i))
    {
      if ((paramInt1 < j) && (paramInt2 < j))
      {
        f2 = 0.0F;
        f1 = paramFloat;
        paramFloat = f2;
      }
      else
      {
        if (paramInt1 > paramInt2)
        {
          f1 = j;
          f2 = paramInt1;
        }
        else
        {
          f1 = j;
          f2 = paramInt2;
        }
        float f3 = f1 / f2;
        if (paramInt1 > paramInt2)
        {
          f2 = i;
          f1 = paramInt2;
        }
        else
        {
          f2 = i;
          f1 = paramInt1;
        }
        f2 = Math.max(f3, f2 / f1);
        paramInt1 = (int)(paramInt1 * f2 + 0.5F);
        paramInt2 = (int)(paramInt2 * f2 + 0.5F);
        f1 = paramFloat;
        paramFloat = f2;
      }
    }
    else
    {
      if (paramInt1 < paramInt2)
      {
        f1 = i / paramInt1;
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = paramInt2;
        if (paramInt2 > j) {
          paramInt1 = j;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      else
      {
        f1 = i / paramInt2;
        paramInt2 = (int)(paramInt1 * f1 + 0.5F);
        paramInt1 = paramInt2;
        if (paramInt2 > j) {
          paramInt1 = j;
        }
        paramInt2 = i;
      }
      f2 = paramFloat * f1;
      paramFloat = f1;
      f1 = f2;
    }
    localBasicPicInfo.a = paramInt1;
    localBasicPicInfo.b = paramInt2;
    localBasicPicInfo.c = paramFloat;
    localBasicPicInfo.d = f1;
    return localBasicPicInfo;
  }
  
  private static ReplyTextItemBuilder.BasicPicInfo a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    ReplyTextItemBuilder.BasicPicInfo localBasicPicInfo = new ReplyTextItemBuilder.BasicPicInfo();
    boolean bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramMessageForPic.imageType);
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      PicItemBuilder.h();
      if (PicItemBuilder.A)
      {
        localObject5 = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
        localObject1 = AbsDownloader.getFile(((URL)localObject5).toString());
        if (localObject1 == null) {}
      }
    }
    try
    {
      localObject6 = NativeGifImage.getImageSize((File)localObject1, false);
      localObject3 = localObject5;
      localObject1 = localObject6;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject3;
      label168:
      label175:
      int i;
      float f;
      int k;
      int j;
      break label168;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label175;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getThumbDrawable,using GIF_BIG,uniseq:");
      ((StringBuilder)localObject1).append(paramMessageForPic.uniseq);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(localObject5);
      QLog.d("ReplyTextItemBuilder", 2, ((StringBuilder)localObject1).toString());
      localObject3 = localObject5;
      localObject1 = localObject6;
    }
    catch (Throwable localThrowable2)
    {
      localObject4 = localObject5;
      Object localObject2 = localObject6;
      break label175;
    }
    localObject3 = null;
    Object localObject1 = localObject3;
    localBasicPicInfo.g = true;
    localBasicPicInfo.e = ((Rect)localObject1);
    localBasicPicInfo.f = ((URL)localObject3);
    localObject5 = localObject1;
    break label209;
    localObject3 = null;
    localObject5 = localObject3;
    label209:
    localObject6 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      try
      {
        localObject3 = new URL(((URL)localObject1).toString());
        localObject1 = localObject3;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
      }
      localObject6 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getThumbDrawable,using thumb,uniseq:");
        ((StringBuilder)localObject4).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject4).append(" url:");
        ((StringBuilder)localObject4).append(localObject1);
        QLog.d("ReplyTextItemBuilder", 2, ((StringBuilder)localObject4).toString());
        localObject6 = localObject1;
      }
    }
    localObject1 = ((URL)localObject6).toString();
    i = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.b = false;
    }
    f = i / 160.0F;
    if (GlobalImageCache.a.get(localObject1) != null)
    {
      paramContext = URLDrawableHelper.getDrawable((URL)localObject6, 0, 0, null, null, true, URLDrawableHelper.getRoundCorner() * f);
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
        paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("getNoRoundThumbDrawableAbsDownloader cache:");
          paramContext.append(paramArrayOfInt[0]);
          paramContext.append(",");
          paramContext.append(paramArrayOfInt[1]);
          QLog.d("ReplyTextItemBuilder", 2, paramContext.toString());
          return localBasicPicInfo;
        }
      }
    }
    else
    {
      paramContext = AbsDownloader.getFile((String)localObject1);
      if (paramContext != null)
      {
        a(paramArrayOfInt, (Rect)localObject5, bool, i, paramContext, f);
        return localBasicPicInfo;
      }
      i = paramMessageForPic.thumbWidth;
      k = paramMessageForPic.thumbHeight;
      j = 99;
      if ((i > 0) && (k > 0))
      {
        paramContext = a(i, k, 0.0F, bool);
        j = paramContext.a;
        i = paramContext.b;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("MessageForPic without width/height of thumb, width = ");
          paramContext.append(i);
          paramContext.append(", height = ");
          paramContext.append(k);
          QLog.d("ReplyTextItemBuilder", 2, paramContext.toString());
        }
        i = 99;
      }
      j = (int)(j * f + 0.5F);
      i = (int)(i * f + 0.5F);
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = j;
        paramArrayOfInt[1] = i;
      }
    }
    return localBasicPicInfo;
  }
  
  private static ReplyTextItemBuilder.MixedMessageInfo a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    int m = 0;
    Object localObject2 = "";
    int j = 0;
    boolean bool1 = false;
    Object localObject3 = null;
    int n = 0;
    Object localObject1;
    Object localObject4;
    int i;
    boolean bool2;
    for (;;)
    {
      localObject1 = localObject3;
      localObject4 = localObject2;
      i = j;
      bool2 = bool1;
      if (m >= paramMessageForMixedMsg.msgElemList.size()) {
        break;
      }
      int k;
      if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
      {
        k = n;
        localObject4 = localObject2;
        i = j;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {}
      }
      else
      {
        k = n;
        localObject4 = localObject2;
        i = j;
        if (n == 0)
        {
          if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
          {
            localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
            if (((MessageForText)localObject4).sb != null)
            {
              localObject1 = ((MessageForText)localObject4).sb.toString();
            }
            else
            {
              localObject1 = localObject2;
              if (((MessageForText)localObject4).msg != null) {
                localObject1 = ((MessageForText)localObject4).msg;
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText))
            {
              localObject1 = localObject2;
              if (((MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m)).sb != null)
              {
                localObject4 = (MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m);
                if (((MessageForReplyText)localObject4).sb != null)
                {
                  localObject1 = ((MessageForReplyText)localObject4).sb.toString();
                }
                else
                {
                  localObject1 = localObject2;
                  if (((MessageForReplyText)localObject4).msg != null) {
                    localObject1 = ((MessageForReplyText)localObject4).msg;
                  }
                }
              }
            }
          }
          k = n;
          localObject4 = localObject1;
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            k = n;
            localObject4 = localObject1;
            i = j;
            if (!((String)localObject1).equals("\n")) {
              if (bool1)
              {
                k = 1;
                i = 2;
                localObject4 = localObject1;
              }
              else
              {
                k = 1;
                i = 1;
                localObject4 = localObject1;
              }
            }
          }
        }
      }
      localObject1 = localObject3;
      bool2 = bool1;
      if ((paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForPic))
      {
        localObject1 = localObject3;
        bool2 = bool1;
        if (!bool1)
        {
          localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
          if (k != 0)
          {
            bool2 = true;
            break;
          }
          bool2 = true;
        }
      }
      m += 1;
      n = k;
      localObject3 = localObject1;
      localObject2 = localObject4;
      j = i;
      bool1 = bool2;
    }
    return new ReplyTextItemBuilder.MixedMessageInfo((MessageForPic)localObject1, (String)localObject4, i, bool2);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (FileManagerUtil.a(paramMessageRecord)) {
      paramQQAppInterface = FileManagerUtil.b((ChatMessage)paramMessageRecord);
    }
    return paramQQAppInterface;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder)
  {
    if (paramMessageRecord1 != null)
    {
      if (paramMessageRecord2 == null) {
        return null;
      }
      boolean bool1 = paramMessageRecord2 instanceof MessageForMixedMsg;
      boolean bool2 = false;
      Object localObject;
      if (bool1)
      {
        localObject = (MessageForMixedMsg)paramMessageRecord2;
        bool1 = bool2;
        if (((MessageForMixedMsg)localObject).msgElemList != null)
        {
          MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(0);
          if ((localMessageRecord instanceof MessageForPic))
          {
            int i = 1;
            while (i < ((MessageForMixedMsg)localObject).msgElemList.size())
            {
              localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
              if (((localMessageRecord instanceof MessageForText)) && (!android.text.TextUtils.isEmpty(localMessageRecord.msg)))
              {
                paramStringBuilder.append(localMessageRecord.msg);
                i += 1;
              }
              else
              {
                return null;
              }
            }
            bool1 = true;
          }
          else
          {
            bool1 = bool2;
            if ((localMessageRecord instanceof MessageForText)) {
              return null;
            }
          }
        }
        localObject = paramMessageRecord2;
      }
      else
      {
        if (((paramMessageRecord2 instanceof MessageForText)) && (!android.text.TextUtils.isEmpty(paramMessageRecord2.msg))) {
          paramStringBuilder.append(paramMessageRecord2.msg);
        }
        localObject = null;
        bool1 = false;
      }
      return a(paramQQAppInterface, paramMessageRecord1, paramMessageRecord2, paramStringBuilder, (MessageRecord)localObject, bool1);
    }
    return null;
  }
  
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder, MessageRecord paramMessageRecord3, boolean paramBoolean)
  {
    int i = 1;
    while (i < 10)
    {
      MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
      if ((localMessageRecord != null) && (localMessageRecord.isLongMsg()) && ((localMessageRecord instanceof MessageForText)))
      {
        if (!android.text.TextUtils.isEmpty(localMessageRecord.msg)) {
          paramStringBuilder.append(localMessageRecord.msg);
        }
      }
      else if (((localMessageRecord instanceof MessageForMixedMsg)) && (localMessageRecord.isLongMsg()))
      {
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
        if (paramBoolean) {
          break;
        }
        return localMessageRecord;
      }
      if (localMessageRecord == null) {
        break;
      }
      if (!localMessageRecord.isLongMsg()) {
        return paramMessageRecord3;
      }
      i += 1;
    }
    return paramMessageRecord3;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().o(paramString, paramInt);
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
    List localList = paramQQAppInterface.getMessageFacade().o(paramString, paramInt);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if ((localChatMessage.time == paramLong1) && (localChatMessage.msgUid == paramLong2))
      {
        if (!localChatMessage.mIsParsed) {
          localChatMessage.parse();
        }
        return localChatMessage;
      }
      if ((localChatMessage instanceof MessageForFile))
      {
        MessageForFile localMessageForFile = (MessageForFile)localChatMessage;
        if ((localMessageForFile.originalTime == paramLong1) && (localMessageForFile.originalMsgUid == paramLong2))
        {
          if (!localChatMessage.mIsParsed) {
            localChatMessage.parse();
          }
          return localChatMessage;
        }
      }
      i += 1;
    }
    return a(paramQQAppInterface, paramString, paramInt, paramLong3);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    boolean bool = paramMessageRecord instanceof MessageForReplyText;
    if (bool)
    {
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
      if (localMessageForReplyText.getSourceMessage() != null) {
        return localMessageForReplyText.getSourceMessage();
      }
    }
    if ((paramMessageRecord != null) && (!paramMessageRecord.isMultiMsg))
    {
      if (paramInt == 0) {
        paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid, paramSourceMsgInfo.mSourceMsgSeq);
      } else {
        paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq);
      }
      if ((paramQQAppInterface != null) && (bool)) {
        ((MessageForReplyText)paramMessageRecord).setSourceMessageRecord(paramQQAppInterface);
      }
      return paramQQAppInterface;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("REPLY getMessage  replyTextMsg=");
      paramQQAppInterface.append(paramMessageRecord);
      QLog.d("ReplyTextItemBuilder", 2, paramQQAppInterface.toString());
    }
    return null;
  }
  
  @Nullable
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = paramMessageRecord1 instanceof MessageForReplyText;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      paramMessageRecord1 = (MessageForReplyText)paramMessageRecord1;
      localObject1 = localObject2;
      if (paramMessageRecord1.isBarrageMsg)
      {
        long l = paramMessageRecord1.barrageTimeLocation;
        if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
          return DanmuUtil.a(paramContext, (int)(l / 1000L));
        }
        localObject1 = localObject2;
        if (FileManagerUtil.a(paramMessageRecord2))
        {
          paramMessageRecord1 = a(paramQQAppInterface, paramMessageRecord2);
          if ((paramMessageRecord1 instanceof MessageForFile))
          {
            paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
            localObject1 = localObject2;
            if (paramQQAppInterface != null)
            {
              localObject1 = localObject2;
              if (FileManagerUtil.c(paramQQAppInterface.fileName) == 2) {
                return DanmuUtil.a(paramContext, (int)(l / 1000L));
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if ((paramMessageRecord1 instanceof MessageForTroopFile))
            {
              paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord1);
              localObject1 = localObject2;
              if (paramQQAppInterface != null)
              {
                localObject1 = localObject2;
                if (FileManagerUtil.c(paramQQAppInterface.t) == 2) {
                  localObject1 = DanmuUtil.a(paramContext, (int)(l / 1000L));
                }
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  @Nullable
  public static String a(QQAppInterface paramQQAppInterface, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, String paramString, MessageRecord paramMessageRecord2)
  {
    Object localObject1 = "";
    boolean bool = paramMessageRecord2 instanceof MessageForFile;
    MessageForTroopFile localMessageForTroopFile = null;
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = (MessageForFile)paramMessageRecord2;
      paramQQAppInterface = localMessageForTroopFile;
      if (((MessageForFile)localObject1).fileName != null)
      {
        paramQQAppInterface = ((MessageForFile)localObject1).getSummaryMsg();
        paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
        paramSourceMsgInfo.mSourceSummaryFlag = 1;
      }
    }
    else if ((paramMessageRecord2 instanceof MessageForTroopFile))
    {
      localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord2;
      if (localMessageForTroopFile.fileName != null) {
        localObject2 = localMessageForTroopFile.getSummaryMsg();
      }
      localObject1 = localObject2;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, localMessageForTroopFile);
        localObject1 = localObject2;
        if (paramQQAppInterface != null) {
          localObject1 = paramQQAppInterface.t;
        }
      }
      localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileName");
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(HardCodeUtil.a(2131904454));
          paramQQAppInterface.append((String)localObject1);
          paramQQAppInterface = paramQQAppInterface.toString();
        }
        localObject2 = paramQQAppInterface;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSourceMsgInfo.mSourceMsgText = ((String)localObject2);
        paramSourceMsgInfo.mSourceSummaryFlag = 1;
        paramQQAppInterface = (QQAppInterface)localObject2;
      }
    }
    else
    {
      paramQQAppInterface = localMessageForTroopFile;
      if (paramMessageRecord2 != null)
      {
        try
        {
          if (!((ChatMessage)paramMessageRecord2).mIsParsed) {
            ((ChatMessage)paramMessageRecord2).parse();
          }
          if ((paramMessageRecord2 instanceof MessageForReplyText))
          {
            if (((MessageForReplyText)paramMessageRecord2).sb == null)
            {
              QLog.e("ReplyTextItemBuilder", 2, "MessageForReplyText.sb is null");
              paramQQAppInterface = (QQAppInterface)localObject1;
              if (paramMessageRecord2.msg == null) {
                break label352;
              }
              paramQQAppInterface = paramMessageRecord2.msg;
            }
            else
            {
              paramQQAppInterface = ((MessageForReplyText)paramMessageRecord2).getSummaryMsg();
            }
          }
          else {
            paramQQAppInterface = ((ChatMessage)paramMessageRecord2).getSummaryMsg();
          }
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.e("ReplyTextItemBuilder", 2, new Object[] { "msg.getSummaryMsg error, msg type=", paramMessageRecord2.getClass().getName(), paramQQAppInterface });
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
        label352:
        paramSourceMsgInfo.mSourceMsgText = paramQQAppInterface;
        paramSourceMsgInfo.mSourceSummaryFlag = 1;
      }
    }
    if (paramQQAppInterface == null) {
      paramQQAppInterface = paramSourceMsgInfo.mSourceMsgText;
    }
    paramSourceMsgInfo = paramQQAppInterface;
    if (paramMessageRecord2 != null)
    {
      paramSourceMsgInfo = paramQQAppInterface;
      if (paramMessageRecord2.shmsgseq == paramMessageRecord1.shmsgseq) {
        paramSourceMsgInfo = paramString;
      }
    }
    return paramSourceMsgInfo;
  }
  
  private static void a(Context paramContext, ChatThumbView paramChatThumbView, HasSourceMessage paramHasSourceMessage, MessageForPic paramMessageForPic)
  {
    boolean bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramMessageForPic.imageType);
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
      paramChatThumbView.setTag(2131430592, paramMessageForPic);
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp81_79 = arrayOfInt;
    tmp81_79[0] = 0;
    int[] tmp85_81 = tmp81_79;
    tmp85_81[1] = 0;
    tmp85_81;
    Object localObject = null;
    URL localURL = URLDrawableHelper.getURL(paramMessageForPic, 65537);
    try
    {
      localURL = new URL(localURL.toString());
      localObject = localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
      }
      localMalformedURLException.printStackTrace();
    }
    if (localObject == null)
    {
      paramChatThumbView.setImageDrawable(TroopFileItemBuilder.a(2, 200, 200));
      return;
    }
    localObject = a(paramContext, paramMessageForPic, paramChatThumbView, arrayOfInt);
    paramContext = a(paramContext, paramMessageForPic, paramChatThumbView, new int[] { 0, 0 }, (ReplyTextItemBuilder.BasicPicInfo)localObject);
    paramChatThumbView.setTag(2131430592, paramMessageForPic);
    if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
    {
      paramMessageForPic = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
      int j = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      int n = Math.min(CommonImgThumbHelper.getImgThumbMinPx(bool), 80);
      int i;
      if (arrayOfInt[0] > j) {
        i = j;
      } else {
        i = arrayOfInt[0];
      }
      if (arrayOfInt[1] <= j) {
        j = arrayOfInt[1];
      }
      int i1 = AIOUtils.b(95.0F, paramChatThumbView.getResources());
      int i2;
      if (i > j) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      int m;
      int k;
      if ((i2 == 0) && (i > i1))
      {
        if (i1 < n) {
          m = n;
        } else {
          m = i1;
        }
        k = arrayOfInt[1] * m / arrayOfInt[0];
      }
      else
      {
        k = j;
        m = i;
        if (i2 != 0)
        {
          k = j;
          m = i;
          if (j > i1)
          {
            if (i1 < n) {
              k = n;
            } else {
              k = i1;
            }
            m = arrayOfInt[0] * k / arrayOfInt[1];
          }
        }
      }
      paramMessageForPic.width = m;
      paramMessageForPic.height = k;
      if (paramHasSourceMessage != null)
      {
        if (paramHasSourceMessage.getSourceMsgInfo() != null)
        {
          paramHasSourceMessage.getSourceMsgInfo().replyPicWidth = m;
          paramHasSourceMessage.getSourceMsgInfo().replyPicHeight = k;
        }
        if (QLog.isColorLevel())
        {
          paramHasSourceMessage = new StringBuilder();
          paramHasSourceMessage.append("set size :");
          paramHasSourceMessage.append(arrayOfInt[0]);
          paramHasSourceMessage.append(",");
          paramHasSourceMessage.append(arrayOfInt[1]);
          paramHasSourceMessage.append(" real:");
          paramHasSourceMessage.append(m);
          paramHasSourceMessage.append(",");
          paramHasSourceMessage.append(k);
          QLog.d("ReplyTextItemBuilder", 2, paramHasSourceMessage.toString());
        }
      }
    }
    paramChatThumbView.setImageDrawable(paramContext.mutate());
    a(paramContext);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 instanceof MessageForReplyText)) {
      localObject = (MessageForReplyText)paramMessageRecord1;
    } else {
      localObject = null;
    }
    boolean bool1 = MessageForReplyText.needHideLocate((MessageForReplyText)localObject);
    Object localObject = (TextView)paramViewGroup.findViewById(2131433662);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131436449);
    boolean bool2 = a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface);
    int i = 4;
    if (bool2)
    {
      paramContext = a(paramContext, paramQQAppInterface, paramMessageRecord1, paramMessageRecord2);
      if (paramContext != null)
      {
        ((TextView)localObject).setText(paramContext);
        ((TextView)localObject).setVisibility(0);
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
      }
      if (!bool1) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    paramViewGroup = paramContext.getString(2131897216);
    if (!android.text.TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramSourceMsgInfo.mSourceMsgToUin);
      paramViewGroup.append("");
      paramMessageRecord1 = paramQQAppInterface.f(paramViewGroup.toString());
      paramViewGroup = paramSourceMsgInfo.mSourceMsgTroopName;
      paramQQAppInterface = paramViewGroup;
      if (paramMessageRecord1 != null)
      {
        paramQQAppInterface = paramViewGroup;
        if (!android.text.TextUtils.isEmpty(paramMessageRecord1.getTroopDisplayName())) {
          paramQQAppInterface = paramMessageRecord1.getTroopDisplayName();
        }
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramContext.getString(2131897215));
      paramViewGroup.append(paramQQAppInterface);
      paramViewGroup = paramViewGroup.toString();
    }
    ((TextView)localObject).setText(paramViewGroup);
    ((TextView)localObject).setVisibility(0);
    paramContext = ((BaseActivity)paramContext).getChatFragment();
    int j;
    if ((paramContext != null) && ((paramContext.k() instanceof MultiForwardChatPie))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      i = 0;
    }
    localImageView.setVisibility(i);
  }
  
  private static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131447325);
    int i = paramViewGroup.findViewById(2131439121).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.c(false);
    localBubbleImageView.setShowEdge(true);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131440281);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(HardCodeUtil.a(2131910886));
    } else {
      localBubbleImageView.setContentDescription(HardCodeUtil.a(2131910879));
    }
    Object localObject = paramViewGroup.findViewById(2131435435);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = DisplayUtil.a(paramContext, 25.0F);
    ((View)localObject).setLayoutParams(localLayoutParams);
    i = Build.VERSION.SDK_INT;
    if ((i == 19) || (i == 18)) {
      localBubbleImageView.w = true;
    }
    localObject = (ETTextView)paramViewGroup.findViewById(2131438922);
    paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131438908);
    if (localBubbleImageView.getDrawable() == null) {
      a(localBubbleImageView, paramContext, paramSourceMsgInfo);
    }
    a(localBubbleImageView, paramMessageRecord1);
    a(paramQQAppInterface, paramContext, paramViewGroup, paramMessageRecord2, paramString);
    if (paramMessageRecord2 != null)
    {
      b(paramMessageRecord2, paramSourceMsgInfo, localBubbleImageView, localTextView, paramViewGroup, (ETTextView)localObject, paramInt, paramString, paramMessageRecord1, paramContext, paramQQAppInterface, null);
      return;
    }
    if ((!paramBoolean2) && (!a(paramString)) && (paramSourceMsgInfo.mSourceSummaryFlag == 1))
    {
      localBubbleImageView.setVisibility(8);
      b(paramViewGroup, (TextView)localObject, paramInt, paramString, null);
      a(paramContext, paramQQAppInterface, localBubbleImageView, localTextView, paramMessageRecord1, paramSourceMsgInfo, (ETTextView)localObject, paramViewGroup, paramInt, paramString);
      return;
    }
    c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new ReplyTextItemBuilder.10(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, localTextView, paramInt, paramString, paramMessageRecord1, paramContext));
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    boolean bool3 = paramMessageRecord instanceof MessageForReplyText;
    if ((bool3) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ReplyItemBuilder reply:");
      ((StringBuilder)localObject1).append(paramMessageRecord);
      ((StringBuilder)localObject1).append(" sourceMsg=");
      ((StringBuilder)localObject1).append(((MessageForReplyText)paramMessageRecord).getSourceMessage());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
    }
    String str2 = TimeFormatterUtils.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    Object localObject3 = (TextView)paramViewGroup.findViewById(2131439121);
    Object localObject1 = (TextView)paramViewGroup.findViewById(2131447354);
    int i = 0;
    int j = 0;
    boolean bool1;
    if ((!paramBoolean) && (!a(paramSourceMsgInfo.mSourceMsgText))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Object localObject5 = paramSourceMsgInfo.mSourceMsgText;
    String str1;
    Object localObject4;
    Object localObject2;
    if (!android.text.TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName))
    {
      str1 = paramSourceMsgInfo.mAnonymousNickName;
      localObject4 = " ";
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    boolean bool2;
    for (;;)
    {
      localObject4 = localObject3;
      bool2 = true;
      paramBoolean = true;
      break;
      if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        localObject2 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if (localObject2 != null)
        {
          localObject2 = TroopBusinessUtil.a((MessageRecord)localObject2);
          if (localObject2 != null) {
            paramSourceMsgInfo.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).d;
          }
        }
      }
      for (;;)
      {
        str1 = " ";
        localObject2 = localObject1;
        localObject1 = str1;
        break label409;
        localObject2 = ((TextView)localObject3).getTag(2131446810);
        if ((localObject2 == null) || (((Long)localObject2).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin)) {
          break;
        }
        ((TextView)localObject3).setText(new ColorNickText((String)((TextView)localObject3).getTag(2131446809), 16).b());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(str2);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      str1 = " ";
      localObject2 = localObject1;
      ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, (TextView)localObject3, (TextView)localObject2, str2), 64, null, true);
      localObject1 = str1;
      label409:
      str1 = "";
    }
    MessageRecord localMessageRecord = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
    if (paramSourceMsgInfo.mSourceSummaryFlag == 1)
    {
      localObject3 = paramSourceMsgInfo.mSourceMsgText;
      if ((localMessageRecord instanceof MessageForPic))
      {
        paramString = (String)localObject3;
        paramBoolean = bool2;
        paramInt = i;
        if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(localMessageRecord))
        {
          if (localObject3 != null)
          {
            paramInt = ((String)localObject3).indexOf('[');
            if (paramInt >= 0)
            {
              j = ((String)localObject3).indexOf(']');
              if (j > paramInt)
              {
                paramString = ((String)localObject3).substring(paramInt, j + 1);
                paramBoolean = bool2;
                paramInt = i;
                break label621;
              }
            }
          }
          paramString = HardCodeUtil.a(2131910881);
          paramBoolean = bool2;
          paramInt = i;
        }
      }
      else
      {
        paramString = (String)localObject3;
        paramBoolean = false;
        paramInt = 1;
      }
    }
    else
    {
      if (((localMessageRecord instanceof MessageForPic)) && (bool1) && ((paramMessageRecord instanceof HasSourceMessage)))
      {
        paramInt = j;
      }
      else
      {
        paramBoolean = false;
        paramInt = 1;
      }
      paramString = a(paramQQAppInterface, paramSourceMsgInfo, paramMessageRecord, (String)localObject5, localMessageRecord);
    }
    label621:
    localObject3 = localMessageRecord;
    if (bool3)
    {
      localObject5 = (MessageForReplyText)paramMessageRecord;
      localObject3 = localMessageRecord;
      if (((MessageForReplyText)localObject5).getSourceMessage() != null) {
        localObject3 = ((MessageForReplyText)localObject5).getSourceMessage();
      }
    }
    a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, paramSessionInfo, (MessageRecord)localObject3);
    if (!android.text.TextUtils.isEmpty(str1))
    {
      ((TextView)localObject4).setTag(2131446809, str1);
      ((TextView)localObject4).setTag(2131446810, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
      ((TextView)localObject4).setText(str1);
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append((String)localObject1);
      paramSessionInfo.append(str2);
      ((TextView)localObject2).setText(paramSessionInfo.toString());
    }
    a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject3, paramBoolean, paramInt, paramString, bool1);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    HasSourceMessage localHasSourceMessage;
    if ((paramMessageRecord1 instanceof HasSourceMessage)) {
      localHasSourceMessage = (HasSourceMessage)paramMessageRecord1;
    } else {
      localHasSourceMessage = null;
    }
    if ((paramMessageRecord2 instanceof MessageForPic))
    {
      a(paramContext, paramChatThumbView, localHasSourceMessage, (MessageForPic)paramMessageRecord2);
      return;
    }
    if (FileManagerUtil.a(paramMessageRecord2))
    {
      paramContext = a(paramQQAppInterface, paramMessageRecord2);
      if ((paramContext instanceof MessageForTroopFile))
      {
        b(paramQQAppInterface, paramChatThumbView, paramContext);
        return;
      }
      if ((paramContext instanceof MessageForFile)) {
        a(paramQQAppInterface, paramChatThumbView, paramContext);
      }
    }
    else
    {
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
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, TextView paramTextView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramTextView = new ReplyTextItemBuilder.2(paramSourceMsgInfo, paramBubbleImageView, paramTextView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
    if (paramMessageRecord.istroop == 0)
    {
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramTextView);
      return;
    }
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramTextView);
  }
  
  public static void a(TextView paramTextView, int paramInt) {}
  
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
    Object localObject = paramChatThumbView.findViewById(2131447319);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131431473);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131431678);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131435246);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    paramChatThumbView.setVisibility(8);
  }
  
  public static void a(ChatThumbView paramChatThumbView, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
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
    int i = AIOUtils.b(120.0F, ((Context)localObject).getResources());
    int j = AIOUtils.b(80.0F, ((Context)localObject).getResources());
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt2 = AIOUtils.b(60.0F, ((Context)localObject).getResources());
      } else {
        paramInt2 = AIOUtils.b(120.0F, ((Context)localObject).getResources());
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 > i) {
      paramInt1 = i;
    }
    localObject = (ViewGroup)paramChatThumbView.getParent();
    if (localObject == null)
    {
      QLog.i("ReplyTextItemBuilder<QFile>", 1, "showDefaultReplyThumb: can not get imageContent");
      return;
    }
    paramChatThumbView.setVisibility(8);
    ((ViewGroup)localObject).setVisibility(0);
    paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131447319);
    if (paramChatThumbView != null) {
      paramChatThumbView.setVisibility(8);
    }
    paramChatThumbView = ((ViewGroup)localObject).findViewById(2131431678);
    if (paramChatThumbView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = j;
      paramChatThumbView.setLayoutParams(localLayoutParams);
      paramChatThumbView.setVisibility(0);
      paramChatThumbView.getBackground().setAlpha(26);
    }
    paramChatThumbView = ((ViewGroup)localObject).findViewById(2131431473);
    if (paramChatThumbView != null) {
      paramChatThumbView.setVisibility(8);
    }
    paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131435246);
    if (paramChatThumbView != null)
    {
      paramChatThumbView.setVisibility(0);
      if (paramBoolean)
      {
        paramChatThumbView.setImageResource(2130845725);
        return;
      }
      paramChatThumbView.setImageResource(2130845724);
    }
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (paramChatThumbView == null) {
      return;
    }
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
      paramString = localViewGroup.findViewById(2131431473);
      if (paramString != null)
      {
        paramChatThumbView = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
        paramString.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
        localLayoutParams.width = paramChatThumbView.width;
        localLayoutParams.height = paramChatThumbView.height;
        paramString.setLayoutParams(paramChatThumbView);
        if (QQTheme.isNowSimpleUI()) {
          paramInt1 = 2130845722;
        } else {
          paramInt1 = 2130845721;
        }
        paramString.setBackgroundResource(paramInt1);
      }
    }
    paramChatThumbView = localViewGroup.findViewById(2131431678);
    if (paramChatThumbView != null) {
      paramChatThumbView.setVisibility(8);
    }
    paramChatThumbView = (ImageView)localViewGroup.findViewById(2131435246);
    if (paramChatThumbView != null)
    {
      if (paramBoolean)
      {
        paramChatThumbView.setImageResource(2130845725);
        paramChatThumbView.setVisibility(0);
        return;
      }
      paramChatThumbView.setVisibility(8);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (FileManagerUtil.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        paramString = new StringBuilder();
        paramString.append("handleReplyTextStyle, sourceMsg uniseq[");
        paramString.append(paramMessageRecord.uniseq);
        paramString.append("]");
        QLog.i("ReplyTextItemBuilder<QFile>", 1, paramString.toString());
        paramMessageRecord = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord != null) && (paramMessageRecord.status != 16))
        {
          i = FileManagerUtil.a(FileManagerUtil.c(paramMessageRecord.fileName), 1);
          if (Build.VERSION.SDK_INT >= 21) {
            paramQQAppInterface = paramContext.getDrawable(i);
          } else {
            paramQQAppInterface = paramContext.getResources().getDrawable(i);
          }
          paramTextView.setText(paramMessageRecord.fileName);
          break label228;
        }
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramMessageRecord = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord != null)
        {
          i = FileManagerUtil.a(FileManagerUtil.c(paramMessageRecord.t), 1);
          if (Build.VERSION.SDK_INT >= 21) {
            paramQQAppInterface = paramContext.getDrawable(i);
          } else {
            paramQQAppInterface = paramContext.getResources().getDrawable(i);
          }
          paramTextView.setText(paramMessageRecord.t);
          break label228;
        }
      }
      paramQQAppInterface = null;
    }
    for (;;)
    {
      label228:
      break;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        if ((ChatHistoryStructAdapter.a(paramMessageRecord)) && (!b(paramMessageRecord)))
        {
          if (Build.VERSION.SDK_INT >= 21) {
            paramString = paramContext.getDrawable(2130845682);
          } else {
            paramString = paramContext.getResources().getDrawable(2130845682);
          }
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          paramQQAppInterface = paramString;
          if (paramMessageRecord.structingMsg == null) {
            break;
          }
          paramMessageRecord = paramMessageRecord.structingMsg.mMsgUrl;
          paramQQAppInterface = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(paramMessageRecord);
          i = AIOUtils.b(15.0F, paramContext.getResources());
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = paramString;
          localURLDrawableOptions.mFailedDrawable = paramString;
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mUseAutoScaleParams = false;
          if (!android.text.TextUtils.isEmpty(paramQQAppInterface))
          {
            paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
            paramQQAppInterface.setBounds(0, 0, i, i);
            break;
          }
          paramQQAppInterface = paramString;
          if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
            break;
          }
          paramQQAppInterface = paramString;
          if (!paramMessageRecord.contains("docs.qq.com/desktop/m")) {
            break;
          }
          paramQQAppInterface = URLDrawable.getDrawable("https://docs.qq.com/desktop/favicon.ico", localURLDrawableOptions);
          paramQQAppInterface.setBounds(0, 0, i, i);
          break;
        }
      }
      else if ((paramMessageRecord instanceof MessageForArkApp))
      {
        try
        {
          paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
          if ((paramMessageRecord == null) || (!((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramMessageRecord.appName, paramMessageRecord.appView))) {
            break label682;
          }
          if (Build.VERSION.SDK_INT >= 21) {
            paramQQAppInterface = paramContext.getDrawable(2130845682);
          } else {
            paramQQAppInterface = paramContext.getResources().getDrawable(2130845682);
          }
          paramMessageRecord = (String)((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon");
          i = AIOUtils.b(15.0F, paramContext.getResources());
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mLoadingDrawable = paramQQAppInterface;
          paramString.mFailedDrawable = paramQQAppInterface;
          paramString.mRequestWidth = i;
          paramString.mRequestHeight = i;
          paramString.mUseAutoScaleParams = false;
          if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
            continue;
          }
          paramQQAppInterface = URLDrawable.getDrawable(paramMessageRecord, paramString);
          try
          {
            paramQQAppInterface.setBounds(0, 0, i, i);
          }
          catch (Exception paramMessageRecord) {}
          paramString = new StringBuilder();
        }
        catch (Exception paramMessageRecord)
        {
          paramQQAppInterface = null;
        }
        paramString.append("handle MessageForArkApp error!");
        paramString.append(paramMessageRecord.getMessage());
        QLog.e("ReplyTextItemBuilder", 1, paramString.toString());
        continue;
      }
      label682:
      paramQQAppInterface = null;
    }
    if (paramQQAppInterface != null)
    {
      i = AIOUtils.b(15.0F, paramContext.getResources());
      int j = AIOUtils.b(4.0F, paramContext.getResources());
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
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
    paramTextView.setPadding(0, 0, 0, 0);
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setMaxLines(2);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageForReplyText paramMessageForReplyText, MessageForShortVideo paramMessageForShortVideo)
  {
    Object localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {}
    try
    {
      localObject = SVBusiUtil.a(2, 2);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).b);
      localShortVideoDownloadInfo.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
      ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
      ((ShortVideoReq)localObject).a(new ReplyTextItemBuilder.11(paramMessageForShortVideo, paramMessageForReplyText, paramQQAppInterface, paramChatThumbView));
      ShortVideoBusiManager.a((ShortVideoReq)localObject, paramQQAppInterface);
    }
    catch (Exception paramQQAppInterface)
    {
      label95:
      break label95;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "no appRuntime");
      break label127;
      b(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight, (String)localObject, paramChatThumbView);
    }
    label127:
    paramQQAppInterface = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131435246);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.setImageResource(2130845725);
      paramQQAppInterface.setVisibility(0);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setThumbNailReplyImg, sourceMsg uniseq[");
    ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
    ((StringBuilder)localObject1).append("]");
    QLog.i("ReplyTextItemBuilder<QFile>", 1, ((StringBuilder)localObject1).toString());
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localFileManagerEntity != null)
    {
      int i = FileManagerUtil.c(localFileManagerEntity.fileName);
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if ((i != 2) && (i != 0)) {
        return;
      }
      if (localFileManagerEntity.status == 16)
      {
        if (QLog.isDebugVersion())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("setThumbNailReplyImg: handle offline file but is invalid. msgSeq[");
          paramQQAppInterface.append(paramMessageRecord.msgseq);
          paramQQAppInterface.append("] msgUniseq[");
          paramQQAppInterface.append(paramMessageRecord.uniseq);
          paramQQAppInterface.append("]");
          QLog.i("ReplyTextItemBuilder<QFile>", 1, paramQQAppInterface.toString());
        }
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      localObject1 = localObject2;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
      {
        if (bool)
        {
          if (localFileManagerEntity.peerType == 3000) {
            paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
          } else {
            paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().b(localFileManagerEntity);
          }
        }
        else if (FilePicURLDrawlableHelper.i(localFileManagerEntity)) {
          paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
        } else {
          paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
        }
        localObject2 = paramQQAppInterface;
        if (!FileUtils.fileExistsAndNotEmpty(paramQQAppInterface)) {
          if ((localFileManagerEntity.imgWidth > 0) && (localFileManagerEntity.imgHeight > 0))
          {
            localObject1 = FilePicURLDrawlableHelper.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
            if (QLog.isDebugVersion())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("setThumbNailReplyImg: handle offline file set default. msgSeq[");
              ((StringBuilder)localObject2).append(paramMessageRecord.msgseq);
              ((StringBuilder)localObject2).append("] msgUniseq[");
              ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
              ((StringBuilder)localObject2).append("] width[");
              ((StringBuilder)localObject2).append(((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).a);
              ((StringBuilder)localObject2).append("]");
              QLog.i("ReplyTextItemBuilder<QFile>", 1, ((StringBuilder)localObject2).toString());
            }
            a(paramChatThumbView, bool, ((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).a, ((FilePicURLDrawlableHelper.AIOImgInfo)localObject1).b);
            localObject2 = paramQQAppInterface;
          }
          else
          {
            a(paramChatThumbView, bool, 0, 0);
            localObject2 = paramQQAppInterface;
          }
        }
      }
      if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
      {
        if ((localFileManagerEntity.imgWidth > 0) && (localFileManagerEntity.imgHeight > 0))
        {
          paramQQAppInterface = FilePicURLDrawlableHelper.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
          if (QLog.isDebugVersion())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("setThumbNailReplyImg: handle offline file set thumb. msgSeq[");
            ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
            ((StringBuilder)localObject1).append("] msgUniseq[");
            ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
            ((StringBuilder)localObject1).append("] width[");
            ((StringBuilder)localObject1).append(paramQQAppInterface.a);
            ((StringBuilder)localObject1).append("]");
            QLog.i("ReplyTextItemBuilder<QFile>", 1, ((StringBuilder)localObject1).toString());
          }
          a(paramChatThumbView, bool, paramQQAppInterface.a, paramQQAppInterface.b, (String)localObject2);
          return;
        }
        a(paramChatThumbView, bool, 0, 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord == null) && (!"0X800A36B".equals(paramString))) {
      return;
    }
    boolean bool = paramMessageRecord instanceof MessageForText;
    int j = 8;
    int i;
    if (bool) {
      i = 1;
    } else if ((paramMessageRecord instanceof MessageForPic)) {
      i = 2;
    } else if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      i = 3;
    } else if ((!(paramMessageRecord instanceof MessageForVideo)) && (!(paramMessageRecord instanceof MessageForShortVideo)))
    {
      if ((!(paramMessageRecord instanceof MessageForFile)) && (!(paramMessageRecord instanceof MessageForTroopFile)))
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          i = j;
          if (paramMessageRecord.structingMsg != null)
          {
            i = paramMessageRecord.structingMsg.mMsgServiceID;
            if (i != 33)
            {
              if (i != 95) {
                i = j;
              } else {
                i = 6;
              }
            }
            else {
              i = 7;
            }
          }
        }
        for (;;)
        {
          break label254;
          if ((paramMessageRecord instanceof MessageForArkApp)) {
            try
            {
              paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
              i = j;
              if (paramMessageRecord != null) {
                i = ((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).msgReplyFromType(paramMessageRecord.appName, paramMessageRecord.appView);
              }
            }
            catch (Exception paramMessageRecord)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("reportReplyItemEvent error for MessageForArkApp:");
              localStringBuilder.append(paramMessageRecord.getMessage());
              QLog.e("ReplyTextItemBuilder", 1, localStringBuilder.toString());
            }
          }
        }
        i = 8;
      }
      else
      {
        i = 5;
      }
    }
    else {
      i = 4;
    }
    label254:
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
  
  private static void a(int[] paramArrayOfInt, Rect paramRect, boolean paramBoolean, int paramInt, File paramFile, float paramFloat)
  {
    if (paramRect != null)
    {
      j = paramRect.width();
      i = paramRect.height();
    }
    else
    {
      paramRect = new BitmapFactory.Options();
      paramRect.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(paramFile.getAbsolutePath(), paramRect);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
        }
      }
      j = paramRect.outWidth;
      i = paramRect.outHeight;
      int k = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
      if ((k != 90) && (k != 270)) {
        break label119;
      }
      j = paramRect.outHeight;
      i = paramRect.outWidth;
    }
    label119:
    paramRect = a(j, i, URLDrawableHelper.getRoundCorner() * paramFloat, paramBoolean);
    int j = paramRect.a;
    int i = paramRect.b;
    j = (j * paramInt + 80) / 160;
    paramInt = (i * paramInt + 80) / 160;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = paramInt;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    if (paramQQAppInterface != null)
    {
      int i = FileManagerUtil.c(paramQQAppInterface.t);
      if ((i == 2) || (i == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder("sendUin= ");
      ((StringBuilder)localObject1).append(paramSourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject1).append(" toUin=");
      ((StringBuilder)localObject1).append(paramSourceMsgInfo.mSourceMsgToUin);
      ((StringBuilder)localObject1).append(" session curFin=");
      ((StringBuilder)localObject1).append(paramSessionInfo.b);
      ((StringBuilder)localObject1).append(" type=");
      ((StringBuilder)localObject1).append(paramSessionInfo.a);
      QLog.d("ReplyTextItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramSourceMsgInfo.mSourceMsgToUin);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramSourceMsgInfo.mSourceMsgSenderUin);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramSourceMsgInfo.mSourceMsgToUin <= 0L)
    {
      paramSourceMsgInfo.mSourceMsgToUin = a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo.mSourceMsgSenderUin);
      return true;
    }
    if (paramSessionInfo.a == 3000) {
      return ((String)localObject1).equals(paramSessionInfo.b);
    }
    int i = paramSessionInfo.a;
    boolean bool3 = false;
    boolean bool2 = false;
    if (i == 1)
    {
      if (((String)localObject1).equals(paramSessionInfo.b)) {
        return true;
      }
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramSessionInfo.b);
      bool1 = bool2;
      if (paramSourceMsgInfo != null)
      {
        bool1 = bool2;
        if (((String)localObject1).equals(paramSourceMsgInfo.troopcode)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((((String)localObject2).equals(paramSessionInfo.b)) && (((String)localObject1).equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return true;
    }
    boolean bool1 = bool3;
    if (((String)localObject1).equals(paramSessionInfo.b))
    {
      bool1 = bool3;
      if (((String)localObject2).equals(paramQQAppInterface.getCurrentAccountUin())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = android.text.TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramString.indexOf(HardCodeUtil.a(2131910883)) != -1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), AIOUtils.b(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, AIOUtils.b(2.0F, paramImageView.getContext().getResources()));
      }
    }
    else {
      paramString = ShortVideoItemBuilder.a(paramString, 55, 95, AIOUtils.b(2.0F, paramImageView.getContext().getResources()));
    }
    if ((paramString != null) && (paramString.getCurrent() != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
      localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
      paramImageView.setLayoutParams(localLayoutParams);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    paramImageView.setVisibility(8);
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          paramTextView1.setVisibility(0);
          paramTextView1.setText(paramString);
          if (AppSetting.e) {
            paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
          }
          paramTextView2.setVisibility(8);
          return;
        }
        paramTextView2.setVisibility(0);
        paramTextView2.setText(paramString);
        if (AppSetting.e) {
          paramTextView2.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
        }
        paramTextView1.setVisibility(8);
        return;
      }
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.e) {
        paramTextView1.setContentDescription(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView1.setVisibility(8);
    paramTextView2.setVisibility(8);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    Object localObject2 = (MessageForTroopFile)paramMessageRecord;
    ((MessageForTroopFile)localObject2).doParse();
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)localObject2);
    boolean bool1 = false;
    if (localTroopFileStatusInfo == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = FileManagerUtil.c(localTroopFileStatusInfo.t);
    boolean bool2 = true;
    if ((localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.e != 12))
    {
      Object localObject1;
      if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.n)) {
        localObject1 = localTroopFileStatusInfo.n;
      } else {
        localObject1 = localTroopFileStatusInfo.m;
      }
      if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
      {
        if (k == 2) {
          bool1 = true;
        }
        paramQQAppInterface = FilePicURLDrawlableHelper.a(((MessageForTroopFile)localObject2).width, ((MessageForTroopFile)localObject2).height, (String)localObject1);
        if (QLog.isDebugVersion())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setThumbNailReplyImg: handle troop file set thumb. msgSeq[");
          ((StringBuilder)localObject2).append(paramMessageRecord.msgseq);
          ((StringBuilder)localObject2).append("] msgUniseq[");
          ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
          ((StringBuilder)localObject2).append("] width[");
          ((StringBuilder)localObject2).append(paramQQAppInterface.a);
          ((StringBuilder)localObject2).append("]");
          QLog.i("ReplyTextItemBuilder<QFile>", 1, ((StringBuilder)localObject2).toString());
        }
        a(paramChatThumbView, bool1, paramQQAppInterface.a, paramQQAppInterface.b, (String)localObject1);
        return;
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(((MessageForTroopFile)localObject2).frienduin));
      int j = 383;
      int i = j;
      if (FilePicURLDrawlableHelper.b(((MessageForTroopFile)localObject2).width, ((MessageForTroopFile)localObject2).height))
      {
        i = j;
        if (!FileUtil.b(localTroopFileStatusInfo.m)) {
          i = 640;
        }
      }
      if (localTroopFileStatusInfo.e != 12)
      {
        if (localTroopFileStatusInfo.a != null) {
          paramQQAppInterface.a(localTroopFileStatusInfo.a, i);
        } else {
          paramQQAppInterface.a(localTroopFileStatusInfo.r, localTroopFileStatusInfo.t, localTroopFileStatusInfo.u, i);
        }
        paramChatThumbView.setTag(2131430593, new Boolean(true));
      }
      if (k == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a(paramChatThumbView, bool1, 0, 0);
      if ((((MessageForTroopFile)localObject2).width > 0) && (((MessageForTroopFile)localObject2).height > 0))
      {
        paramQQAppInterface = FilePicURLDrawlableHelper.a(((MessageForTroopFile)localObject2).width, ((MessageForTroopFile)localObject2).height, "");
        if (QLog.isDebugVersion())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setThumbNailReplyImg: handle troop file set default. msgSeq[");
          ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
          ((StringBuilder)localObject1).append("] msgUniseq[");
          ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
          ((StringBuilder)localObject1).append("] width[");
          ((StringBuilder)localObject1).append(paramQQAppInterface.a);
          ((StringBuilder)localObject1).append("]");
          QLog.i("ReplyTextItemBuilder<QFile>", 1, ((StringBuilder)localObject1).toString());
        }
        a(paramChatThumbView, bool1, paramQQAppInterface.a, paramQQAppInterface.b);
        return;
      }
      a(paramChatThumbView, bool1, 0, 0);
      return;
    }
    if (k == 2) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    a(paramChatThumbView, bool1, 0, 0);
  }
  
  private static void b(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, TextView paramTextView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = paramMessageRecord1 instanceof MessageForPic;
    boolean bool1 = true;
    int j = 1;
    if (bool2)
    {
      if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageRecord1))
      {
        paramSourceMsgInfo = paramString1;
        paramString1 = null;
        paramInt = 0;
        bool1 = false;
        i = 1;
        break label510;
      }
    }
    else {
      if (!(paramMessageRecord1 instanceof MessageForShortVideo)) {
        break label75;
      }
    }
    label75:
    do
    {
      paramSourceMsgInfo = paramString1;
      paramString1 = paramMessageRecord1;
      paramInt = 1;
      i = 0;
      break label510;
      if ((paramMessageRecord1 instanceof MessageForMixedMsg))
      {
        Object localObject = (MessageForMixedMsg)paramMessageRecord1;
        paramString1 = a((MessageForMixedMsg)localObject);
        bool1 = paramString1.d;
        localObject = ((MessageForMixedMsg)localObject).getPicMsgList();
        if (localObject == null) {
          paramInt = 0;
        } else {
          paramInt = ((List)localObject).size();
        }
        i = paramString1.c;
        localObject = paramString1.a;
        if (paramString1.b == null) {
          paramString1 = "";
        } else {
          paramString1 = paramString1.b.trim();
        }
        if (!android.text.TextUtils.isEmpty(paramString2)) {
          paramString1 = paramString2;
        }
        if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
          paramString1 = paramSourceMsgInfo.mSourceMsgText;
        }
        paramString2 = (String)localObject;
        paramSourceMsgInfo = paramString1;
        paramString1 = paramString2;
        break label510;
      }
      if ((paramMessageRecord1 instanceof MessageForLongMsg))
      {
        if (paramMessageRecord1.msgtype != -1036) {
          break;
        }
        paramString2 = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
        if (paramString2 != null)
        {
          paramSourceMsgInfo = a(paramString2);
          bool1 = paramSourceMsgInfo.d;
          paramString1 = paramString2.getPicMsgList();
          if (paramString1 == null) {
            paramInt = 0;
          } else {
            paramInt = paramString1.size();
          }
          i = paramSourceMsgInfo.c;
          paramString1 = paramSourceMsgInfo.a;
          paramSourceMsgInfo = paramSourceMsgInfo.b;
        }
        else
        {
          paramSourceMsgInfo = paramString1;
          paramString1 = null;
          bool1 = false;
          j = 0;
          i = paramInt;
          paramInt = j;
        }
        break label510;
      }
      if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
      {
        paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
        if (paramString2 != null) {
          paramString2 = paramString2.sb;
        } else {
          paramString2 = null;
        }
        if ((paramString2 != null) && (!paramSourceMsgInfo.mSourceMsgText.equals(paramString2.toString()))) {
          paramSourceMsgInfo = paramString2.toString();
        } else {
          paramSourceMsgInfo = paramString1;
        }
        break label493;
      }
      if (!FileManagerUtil.a(paramMessageRecord1)) {
        break;
      }
      paramSourceMsgInfo = a(paramQQAppInterface, paramMessageRecord1);
      if ((paramSourceMsgInfo instanceof MessageForFile))
      {
        if (b(paramQQAppInterface, paramSourceMsgInfo))
        {
          paramSourceMsgInfo = paramMessageRecord1;
          i = 0;
          bool1 = true;
          paramInt = j;
        }
        else
        {
          i = paramInt;
          paramSourceMsgInfo = null;
          paramInt = 0;
          bool1 = false;
        }
        paramString2 = paramSourceMsgInfo;
        paramSourceMsgInfo = paramString1;
        paramString1 = paramString2;
        break label510;
      }
    } while (((paramSourceMsgInfo instanceof MessageForTroopFile)) && (a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo)));
    paramSourceMsgInfo = paramString1;
    label493:
    paramString1 = null;
    j = 0;
    bool1 = false;
    int i = paramInt;
    paramInt = j;
    label510:
    if (bool1)
    {
      paramBubbleImageView.setVisibility(0);
      paramBubbleImageView.setTag(2131430593, null);
      paramString2 = (ViewGroup)paramBubbleImageView.getParent();
      if (paramString2 != null) {
        paramString2.setVisibility(0);
      }
      paramBubbleImageView.setVisibility(0);
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString1);
    }
    else
    {
      a(paramBubbleImageView);
    }
    a(paramTextView, paramInt);
    b(paramETTextView1, paramETTextView2, i, paramSourceMsgInfo, paramMessageRecord1);
    a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, paramSourceMsgInfo);
    paramMessageRecord1 = AIOUtils.b(paramETTextView1);
    if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof ReplyTextItemBuilder.ReplyTextViewHolder))) {
      ((ReplyTextItemBuilder.ReplyTextViewHolder)paramMessageRecord1).f = paramBubbleImageView;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramQQAppInterface != null) {
      if (paramQQAppInterface.status != 16)
      {
        int i = FileManagerUtil.c(paramQQAppInterface.fileName);
        if ((i == 2) || (i == 0)) {
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("renderReply: handle offline file , but invalid. msgUniseq[");
        paramQQAppInterface.append(paramMessageRecord.uniseq);
        paramQQAppInterface.append("] msgSeq[");
        paramQQAppInterface.append(paramMessageRecord.msgseq);
        paramQQAppInterface.append("]");
        QLog.i("ReplyTextItemBuilder", 2, paramQQAppInterface.toString());
      }
    }
    return false;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg != null)
      {
        int i = paramMessageRecord.structingMsg.mMsgServiceID;
        if ((i == 63) || (i == 104)) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, paramSourceMessagePulledCallBack, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static Bitmap i()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.b != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.b.get("static://GrayCommonProgress");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130841728);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.b != null)
        {
          GlobalImageCache.b.put("static://GrayCommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramView.getTag();
      if (localReplyTextViewHolder != null) {
        this.w.a(localReplyTextViewHolder.t, paramView);
      }
    }
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("text.mSourceMsgInfo为null, text:");
        paramViewHolder.append(localMessageForReplyText.toString());
        QLog.w("ReplyTextItemBuilder", 2, paramViewHolder.toString());
      }
      localReplyTextViewHolder.t = -1;
      paramView = this.w.a(-1);
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new LinearLayout(localContext);
        paramViewHolder.setOrientation(1);
        paramView = new ETTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131168016));
        paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131168008));
        paramView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        i = BaseChatItemLayout.getTextPaddingAlignHead();
        int j = BaseChatItemLayout.getTextPaddingAlignError();
        if (paramChatMessage.isSend())
        {
          i = BaseChatItemLayout.getTextPaddingAlignError();
          j = BaseChatItemLayout.getTextPaddingAlignHead();
        }
        paramView.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
        paramView.setId(2131430581);
        localReplyTextViewHolder.v = paramView;
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = AIOUtils.b(5.0F, localContext.getResources());
        paramViewHolder.addView(localReplyTextViewHolder.v, paramView);
      }
      ((ETTextView)localReplyTextViewHolder.v).setFont(0, paramChatMessage.uniseq);
      localReplyTextViewHolder.v.setTypeface(VasShieldFont.a(paramChatMessage));
      localReplyTextViewHolder.v.setTextSize(0, this.f.r);
      localReplyTextViewHolder.v.setText(localMessageForReplyText.sb);
      TroopUtils.a(this.d, this.f, this.e, localReplyTextViewHolder.v, paramChatMessage);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localReplyTextViewHolder.v.setOnTouchListener(paramOnLongClickAndTouchListener);
      localReplyTextViewHolder.v.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView = paramViewHolder;
      if ((localReplyTextViewHolder.v instanceof AnimationTextView))
      {
        ((AnimationTextView)localReplyTextViewHolder.v).onDoubleClick = this.E;
        paramView = paramViewHolder;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("reply type is");
        paramViewHolder.append(localMessageForReplyText.mSourceMsgInfo.mType);
        QLog.d("ReplyTextItemBuilder", 2, paramViewHolder.toString());
      }
      i = localMessageForReplyText.mSourceMsgInfo.mType;
      boolean bool;
      if (localMessageForReplyText.mSourceMsgInfo.oriMsgType == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramView = a(paramBaseChatItemLayout, localContext, localReplyTextViewHolder, localMessageForReplyText, paramOnLongClickAndTouchListener, bool);
    }
    if (paramView != null)
    {
      paramView.setTag(localReplyTextViewHolder);
      paramView.setPadding(0, 0, 0, 0);
      if ((AppSetting.e) && (this.f.a == 0))
      {
        paramViewHolder = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
        if (paramChatMessage.isSend())
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append(HardCodeUtil.a(2131910880));
          paramChatMessage.append(this.f.e);
          paramChatMessage.append(HardCodeUtil.a(2131910885));
          paramChatMessage.append(paramViewHolder);
          paramView.setContentDescription(paramChatMessage.toString());
          return paramView;
        }
        paramChatMessage = new StringBuilder();
        paramChatMessage.append(this.f.e);
        paramChatMessage.append(HardCodeUtil.a(2131910882));
        paramChatMessage.append(paramViewHolder);
        paramView.setContentDescription(paramChatMessage.toString());
      }
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ReplyTextItemBuilder.ReplyTextViewHolder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131433636)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ECommerceDataReportUtil.a(this.d, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.u);
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    boolean bool = AIOSelectableDelegateImpl.a().l();
    paramInt = 1;
    if (bool)
    {
      paramContext = AIOSelectableDelegateImpl.a().d();
      if (paramContext == null) {
        if (localMessageForReplyText.sb != null) {
          paramContext = localMessageForReplyText.sb.toString();
        } else {
          paramContext = localMessageForReplyText.msg;
        }
      }
    }
    for (;;)
    {
      break;
      if (paramContext.length() == AIOSelectableDelegateImpl.a().c()) {
        break;
      }
      paramInt = 0;
      break;
      if (localMessageForReplyText.sb != null) {
        paramContext = localMessageForReplyText.sb.toString();
      } else {
        paramContext = localMessageForReplyText.msg;
      }
    }
    if (paramInt != 0)
    {
      localBundle.putInt("forward_type", -6);
      localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
      ForwardMsgManager localForwardMsgManager = (ForwardMsgManager)this.d.getManager(QQManagerFactory.FORWARD_MSG_MANAGER);
      localMessageForReplyText.setSourceMessageRecord(a(this.d, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, localMessageForReplyText.mSourceMsgInfo));
      localForwardMsgManager.a(paramChatMessage);
    }
    else
    {
      localBundle.putInt("forward_type", -1);
    }
    localBundle.putString("forward_text", paramContext);
    localBundle.putInt("forward_source_uin_type", this.f.a);
    paramContext = new Intent();
    paramContext.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.e, paramContext, 21);
    ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ReplyTextItemBuilder.ReplyTextViewHolder)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.b == null)
    {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
      return;
    }
    int i = AIOUtils.b(1.0F, paramView.b.getResources());
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return;
    }
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.e - AIOUtils.b(16.0F, paramView.b.getResources());
    if (paramChatMessage.isSend())
    {
      paramView.v.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), 0, BaseChatItemLayout.getTextBubblePaddingAlignHead(), z);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.a.getLayoutParams();
      paramChatMessage.leftMargin = BaseChatItemLayout.getTextBubblePaddingAlignError();
      int k = BaseChatItemLayout.getTextBubblePaddingAlignHead();
      int m = i * 2;
      paramChatMessage.rightMargin = (k + m);
      paramChatMessage.topMargin = (y + i * 4);
      paramChatMessage.bottomMargin = 0;
      paramView.a.setLayoutParams(paramChatMessage);
      i = j - BaseChatItemLayout.getTextBubblePaddingAlignError() - BaseChatItemLayout.getTextBubblePaddingAlignHead() - m;
    }
    else
    {
      paramView.v.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), 0, BaseChatItemLayout.getTextBubblePaddingAlignError(), BaseChatItemLayout.getTextBubblePaddingAlignError());
      paramChatMessage = (LinearLayout.LayoutParams)paramView.a.getLayoutParams();
      paramChatMessage.leftMargin = (BaseChatItemLayout.getTextBubblePaddingAlignHead() + i * 2);
      paramChatMessage.rightMargin = BaseChatItemLayout.getTextBubblePaddingAlignHead();
      paramChatMessage.topMargin = (y + i * 4);
      paramChatMessage.bottomMargin = 0;
      i = j - BaseChatItemLayout.getTextBubblePaddingAlignHead() * 2;
      paramView.a.setLayoutParams(paramChatMessage);
    }
    float f1 = paramView.s.getPaint().measureText(paramView.s.getText().toString());
    float f2 = AIOUtils.b(37.0F, paramView.b.getResources());
    paramChatMessage = paramView.b;
    j = i - (int)(f1 + f2);
    paramChatMessage.setMaxWidth(j);
    paramChatMessage = (String)paramView.b.getTag(2131446809);
    paramChatMessage = com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(paramView.b, paramChatMessage, j);
    paramView.b.setText(paramChatMessage);
    paramView.g.setMaxWidth(i);
    paramView.d.setMaxWidth(i);
    paramView.e.setMaxWidth(i);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return;
    }
    paramViewHolder = BitmapFactory.decodeResource(this.e.getResources(), 2130838262);
    paramViewHolder = new BitmapDrawable(this.e.getResources(), paramViewHolder);
    int i = localMessageForReplyText.mSourceMsgInfo.mType;
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()) && (!SimpleUIUtil.e()))
    {
      if (paramBubbleInfo.l == 0)
      {
        localReplyTextViewHolder.v.setTextColor(-16777216);
        localReplyTextViewHolder.b.setTextColor(-16777216);
        localReplyTextViewHolder.s.setTextColor(-16777216);
        localReplyTextViewHolder.g.setTextColor(-16777216);
        localReplyTextViewHolder.d.setTextColor(-16777216);
        localReplyTextViewHolder.e.setTextColor(-16777216);
        paramViewHolder.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
        localReplyTextViewHolder.c.setImageDrawable(paramViewHolder);
      }
      else
      {
        localReplyTextViewHolder.v.setTextColor(paramBubbleInfo.l);
        localReplyTextViewHolder.b.setTextColor(paramBubbleInfo.l);
        localReplyTextViewHolder.s.setTextColor(paramBubbleInfo.l);
        localReplyTextViewHolder.g.setTextColor(paramBubbleInfo.l);
        localReplyTextViewHolder.d.setTextColor(paramBubbleInfo.l);
        localReplyTextViewHolder.e.setTextColor(paramBubbleInfo.l);
        paramViewHolder.setColorFilter(new PorterDuffColorFilter(paramBubbleInfo.l, PorterDuff.Mode.SRC_ATOP));
        localReplyTextViewHolder.c.setImageDrawable(paramViewHolder);
      }
      if (paramBubbleInfo.m == 0)
      {
        paramView = paramView.getResources().getColorStateList(2131168018);
        localReplyTextViewHolder.v.setLinkTextColor(paramView);
        localReplyTextViewHolder.d.setLinkTextColor(paramView);
        localReplyTextViewHolder.e.setLinkTextColor(paramView);
      }
      else
      {
        localReplyTextViewHolder.v.setLinkTextColor(paramBubbleInfo.m);
        localReplyTextViewHolder.d.setLinkTextColor(paramBubbleInfo.m);
        localReplyTextViewHolder.e.setLinkTextColor(paramBubbleInfo.m);
      }
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.s, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.b, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.d, 0.9F);
      ImmersiveUtils.setAlpha(localReplyTextViewHolder.e, 0.9F);
      if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.e, this.f, localReplyTextViewHolder.v.getCurrentTextColor(), localReplyTextViewHolder.i.q * 10000.0D) == 1))
      {
        paramView = (ETTextView)localReplyTextViewHolder.v;
        float f2 = paramView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramView.setTextColor(-1);
        paramView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
        paramViewHolder.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        localReplyTextViewHolder.c.setImageDrawable(paramViewHolder);
      }
      return;
    }
    paramView = paramView.getResources();
    if (paramChatMessage.isSend()) {
      i = 2131168020;
    } else {
      i = 2131168016;
    }
    paramBubbleInfo = paramView.getColorStateList(i);
    localReplyTextViewHolder.v.setTextColor(paramBubbleInfo);
    localReplyTextViewHolder.g.setTextColor(paramBubbleInfo);
    localReplyTextViewHolder.s.setTextColor(paramBubbleInfo);
    localReplyTextViewHolder.b.setTextColor(paramBubbleInfo);
    localReplyTextViewHolder.d.setTextColor(paramBubbleInfo);
    localReplyTextViewHolder.e.setTextColor(paramBubbleInfo);
    paramViewHolder.setColorFilter(new PorterDuffColorFilter(paramBubbleInfo.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
    localReplyTextViewHolder.c.setImageDrawable(paramViewHolder);
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramView.getColorStateList(2131168019);
    } else {
      paramViewHolder = paramView.getColorStateList(2131168018);
    }
    localReplyTextViewHolder.v.setLinkTextColor(paramViewHolder);
    localReplyTextViewHolder.d.setLinkTextColor(paramViewHolder);
    localReplyTextViewHolder.e.setLinkTextColor(paramViewHolder);
    ImmersiveUtils.setAlpha(localReplyTextViewHolder.g, 0.5F);
    ImmersiveUtils.setAlpha(localReplyTextViewHolder.b, 0.9F);
    ImmersiveUtils.setAlpha(localReplyTextViewHolder.s, 0.9F);
    ImmersiveUtils.setAlpha(localReplyTextViewHolder.d, 0.9F);
    ImmersiveUtils.setAlpha(localReplyTextViewHolder.e, 0.9F);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = ImageUtil.a(paramViewHolder.h.getBackground());
    if (paramChatMessage == null)
    {
      paramInt1 = 0;
    }
    else
    {
      paramInt2 = a(paramChatMessage);
      paramInt1 = paramInt2;
      if (!paramChatMessage.isRecycled())
      {
        paramChatMessage.recycle();
        paramInt1 = paramInt2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((paramInt1 & 0xFF0000) >> 16), " ", Integer.valueOf((paramInt1 & 0xFF00) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
    }
    if ((paramViewHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder))
    {
      paramChatMessage = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
      if (paramChatMessage.a != null)
      {
        if (((((paramInt1 & 0xFF0000) >> 16) + ((paramInt1 & 0xFF00) >> 8) + (paramInt1 & 0xFF)) / 3 < 170) && (((paramInt1 != 0) && (paramInt1 != -16777216) && (paramInt1 != -15366474)) || ("2920".equals(ThemeUtil.getCurrentThemeId()))))
        {
          paramChatMessage.a.setBackgroundDrawable(SimpleModeHelper.d(this.e.getResources()));
          return;
        }
        paramChatMessage.a.setBackgroundDrawable(SimpleModeHelper.c(this.e.getResources()));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "ReplyTextViewHolder error");
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder;
  }
  
  public void b()
  {
    this.w.a();
    super.b();
  }
  
  protected void b(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForReplyText)AIOUtils.a(paramView);
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new ReplyTextItemBuilder.7(this, paramView), new ReplyTextItemBuilder.8(this)).show();
    }
  }
  
  protected void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if (!(paramViewHolder instanceof ReplyTextItemBuilder.ReplyTextViewHolder)) {
      return;
    }
    ReplyTextItemBuilder.ReplyTextViewHolder localReplyTextViewHolder = (ReplyTextItemBuilder.ReplyTextViewHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForReplyText))
    {
      paramChatMessage = (MessageForReplyText)paramChatMessage;
      paramViewHolder = null;
      if (!android.text.TextUtils.isEmpty(paramChatMessage.sb)) {
        paramViewHolder = paramChatMessage.sb;
      }
      if ((paramViewHolder != null) && ((paramViewHolder instanceof QQText)))
      {
        paramChatMessage = (QQText)paramViewHolder;
        int j = paramViewHolder.length();
        int i = 0;
        paramViewHolder = (EmoticonSpan[])paramChatMessage.getSpans(0, j, EmoticonSpan.class);
        if ((paramViewHolder.length > 0) && (paramChatMessage.toPurePlainText().length() == 0))
        {
          j = paramViewHolder.length;
          while (i < j)
          {
            paramViewHolder[i].setSize(ScreenUtil.dip2px(26.0F));
            i += 1;
          }
          localReplyTextViewHolder.v.setText(paramChatMessage);
        }
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return super.c(paramChatMessage);
    }
    int i = localMessageForReplyText.mSourceMsgInfo.mType;
    return super.c(paramChatMessage);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ReplyTextItemBuilder.ReplyTextViewHolder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.f;
      }
    }
    return null;
  }
  
  protected boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */