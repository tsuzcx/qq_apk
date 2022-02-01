package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  protected int a;
  protected Drawable a;
  public View.OnClickListener a;
  protected PlayingListPreloader a;
  public TribeShortVideoItemBuilder.AIOShortVideoDownloadListener a;
  protected DownloaderInterface a;
  protected float[] a;
  protected final float b;
  protected Context b;
  protected Drawable b;
  protected int d;
  protected int e;
  protected int f;
  protected boolean f;
  protected int g;
  
  public TribeShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TribeShortVideoItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$AIOShortVideoDownloadListener = new TribeShortVideoItemBuilder.5(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$AIOShortVideoDownloadListener);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    try
    {
      paramImageView.setImageDrawable(paramDrawable);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setImageUrl exp: ");
        paramString.append(paramImageView.toString());
        QLog.w("TribeShortVideoItemBuilder", 2, paramString.toString());
      }
    }
  }
  
  private void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, boolean paramBoolean)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = ((CropBubbleVideoView)QQVideoViewFactory.a(this.jdField_b_of_type_AndroidContentContext, paramLong, null, paramBoolean));
    a(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_Int, this.d);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusable(false);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusableInTouchMode(false);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setClickable(false);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, 0);
  }
  
  private void a(MessageForTribeShortVideo paramMessageForTribeShortVideo)
  {
    if (paramMessageForTribeShortVideo.videoWidth > paramMessageForTribeShortVideo.videoHeight)
    {
      this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      return;
    }
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, int paramInt1, int paramInt2)
  {
    paramCropBubbleVideoView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  private void c(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363798));
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
  }
  
  private void d(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380672));
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
  }
  
  private void e(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370708));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
    localGradientDrawable.setShape(0);
    float f1 = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setGradientType(0);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void f(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296386);
    int j = this.jdField_a_of_type_Int;
    int k = BaseChatItemLayout.k;
    int m = this.d;
    int n = BaseChatItemLayout.h;
    int i1 = this.g;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = (j + k + i);
    localLayoutParams.height = (m + n + i1);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = PAVideoView.a;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        return localObject;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("TribeShortVideoItemBuilder", 2, localStringBuilder.toString(), localException);
        }
        return PAVideoView.a;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCoverDrawable():  coverUrl=");
      localStringBuilder.append(paramString);
      QLog.e("TribeShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    return localException;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool = paramChatMessage.isSend();
    paramViewHolder = (TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)paramViewHolder;
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    a(localMessageForTribeShortVideo);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558821, paramBaseChatItemLayout, false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364521));
      c(paramViewHolder);
      a(paramViewHolder, paramChatMessage.uniseq, bool);
      e(paramViewHolder);
      d(paramViewHolder);
      f(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_Int, this.d);
      f(paramViewHolder);
    }
    paramBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar;
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramChatMessage.frienduin);
    paramOnLongClickAndTouchListener.append(paramChatMessage.uniseq);
    paramBaseChatItemLayout.setKey(paramOnLongClickAndTouchListener.toString());
    paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    int i = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, paramViewHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth());
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    if (!bool)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    else
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    a(paramViewHolder, paramChatMessage.uniseq, localMessageForTribeShortVideo, false);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TribeShortVideoItemBuilder.TribeShortVideoMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTribeShortVideo))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131367180)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      paramContext = new Bundle();
      if ((localMessageForTribeShortVideo.structingMsg.source_puin != null) && (!"".equals(localMessageForTribeShortVideo.structingMsg.source_puin))) {
        paramContext.putString("source_puin", localMessageForTribeShortVideo.structingMsg.source_puin);
      }
      paramContext.putInt("forward_type", 36);
      localMessageForTribeShortVideo.structingMsg.mCommentText = null;
      paramContext.putInt("structmsg_service_id", localMessageForTribeShortVideo.structingMsg.mMsgServiceID);
      paramContext.putByteArray("stuctmsg_bytes", localMessageForTribeShortVideo.structingMsg.getBytes());
      paramContext.putLong("structmsg_uniseq", localMessageForTribeShortVideo.uniseq);
      paramContext.putString("qqtribeVideoInfoExtra ", localMessageForTribeShortVideo.structingMsg.mTribeShortVideoExtra);
      paramContext.putInt("accostType", localMessageForTribeShortVideo.structingMsg.sourceAccoutType);
      paramContext.putInt("selection_mode", this.c);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    }
    ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    TribeShortVideoItemBuilder.TribeShortVideoMsgHolder localTribeShortVideoMsgHolder = (TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localTribeShortVideoMsgHolder, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localTribeShortVideoMsgHolder.b.getLayoutParams();
    if (bool) {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
    } else {
      paramViewGroup.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth()) + BaseChatItemLayout.j);
    }
    localTribeShortVideoMsgHolder.b.setLayoutParams(paramViewGroup);
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(localMessageForTribeShortVideo.themeName))
    {
      paramViewGroup = localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(localMessageForTribeShortVideo.themeName);
      paramViewGroup.setText(localStringBuilder.toString());
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
    {
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(localMessageForTribeShortVideo.srcName))
    {
      if (localMessageForTribeShortVideo.srcName.length() > 5)
      {
        paramViewGroup = localTribeShortVideoMsgHolder.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageForTribeShortVideo.srcName.substring(0, 5));
        localStringBuilder.append(HardCodeUtil.a(2131714872));
        paramViewGroup.setText(localStringBuilder.toString());
      }
      else
      {
        paramViewGroup = localTribeShortVideoMsgHolder.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageForTribeShortVideo.srcName);
        localStringBuilder.append(HardCodeUtil.a(2131714873));
        paramViewGroup.setText(localStringBuilder.toString());
      }
    }
    else
    {
      localTribeShortVideoMsgHolder.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131720488));
      localTribeShortVideoMsgHolder.b.setOnClickListener(null);
    }
    localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
    if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
    {
      paramViewGroup = (Long)localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTag();
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForTribeShortVideo.uniseq))
      {
        localTribeShortVideoMsgHolder.jdField_a_of_type_Boolean = false;
        a(localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        a(localTribeShortVideoMsgHolder, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
        localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
      }
    }
    else
    {
      localTribeShortVideoMsgHolder.jdField_a_of_type_Boolean = false;
      localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  protected void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TribeShortVideoItemBuilder onBubbleOnClick:");
        ((StringBuilder)localObject).append(paramTribeShortVideoMsgHolder.toString());
        QLog.d("TribeShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramTribeShortVideoMsgHolder.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
      return;
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramTribeShortVideoMsgHolder);
      }
    }
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramTribeShortVideoMsgHolder, paramLong));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!AIOSingleReporter.a().a(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      AIOSingleReporter.a().a(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
        paramString1 = new JSONObject();
      }
    }
    try
    {
      if (TextUtils.isEmpty(paramString2.bid)) {
        paramLong = 0L;
      } else {
        paramLong = Long.parseLong(paramString2.bid);
      }
      paramString1.put("bid", paramLong);
      if (TextUtils.isEmpty(paramString2.pid)) {
        paramTribeShortVideoMsgHolder = Integer.valueOf(0);
      } else {
        paramTribeShortVideoMsgHolder = paramString2.pid;
      }
      paramString1.put("pid", paramTribeShortVideoMsgHolder);
      if (TextUtils.isEmpty(paramString2.themeName)) {
        break label227;
      }
      paramString1.put("theme_id", paramString2.themeName);
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      label212:
      label227:
      break label212;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
    }
    paramTribeShortVideoMsgHolder = new NewIntent(this.jdField_b_of_type_AndroidContentContext, ProtoServlet.class);
    paramTribeShortVideoMsgHolder.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString1.toString());
    paramTribeShortVideoMsgHolder.putExtra("data", paramString2.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramTribeShortVideoMsgHolder);
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_SHORTVIDEO_SAVE);
    ((StringBuilder)localObject).append(paramMessageForTribeShortVideo.mVid);
    ((StringBuilder)localObject).append(".mp4");
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString()));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramTribeShortVideoMsgHolder, paramLong, paramMessageForTribeShortVideo));
      }
    }
    else
    {
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramTribeShortVideoMsgHolder));
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
      }
      a(paramMessageForTribeShortVideo, paramTribeShortVideoMsgHolder);
    }
  }
  
  protected void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842702);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130846619);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramTribeShortVideoMsgHolder.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364521);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364521);
    paramViewGroup.addView(paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    Object localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_SHORTVIDEO_SAVE));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_SHORTVIDEO_SAVE);
    ((StringBuilder)localObject1).append(paramMessageForTribeShortVideo.mVid);
    ((StringBuilder)localObject1).append(".mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File(VFSAssistantUtils.getSDKPrivatePath((String)localObject1));
    localObject2 = new DownloadTask(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((DownloadTask)localObject2).b = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.startDownload((DownloadTask)localObject2, new TribeShortVideoItemBuilder.4(this, paramTribeShortVideoMsgHolder, paramMessageForTribeShortVideo), localBundle);
  }
  
  public void a(CropBubbleVideoView paramCropBubbleVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramCropBubbleVideoView, paramInt1, paramInt2);
    paramCropBubbleVideoView.setCoverDrawable(a(paramString1));
    paramString1 = new VideoPlayParam();
    paramString1.mVideoPath = paramString2;
    paramString1.mUrls = new String[] { PAVideoView.a(paramLong) };
    paramString1.mIsLocal = true;
    paramString1.mIsLoop = true;
    paramString1.mIsMute = true;
    paramString1.mSceneId = 111;
    paramString1.mSceneName = SceneID.a(111);
    paramCropBubbleVideoView.setVideoParam(paramString1);
    paramCropBubbleVideoView.play();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    TroopBusinessUtil.a(paramView);
    localQQCustomMenu.a(2131367180, this.jdField_b_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
      a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected void b(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TribeShortVideoItemBuilder onSourceOnClick:");
        ((StringBuilder)localObject).append(paramTribeShortVideoMsgHolder.toString());
        QLog.d("TribeShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("isOpeningQunApp", false);
      ((Intent)localObject).putExtra("url", paramTribeShortVideoMsgHolder.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
      return;
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramTribeShortVideoMsgHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */