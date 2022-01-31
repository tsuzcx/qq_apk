package com.tencent.mobileqq.activity.aio.item;

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
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import org.json.JSONObject;
import vgc;
import vgd;
import vge;
import vgf;
import vgg;
import vgh;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  protected Drawable a;
  public View.OnClickListener a;
  protected PlayingListPreloader a;
  public TribeShortVideoItemBuilder.AIOShortVideoDownloadListener a;
  protected DownloaderInterface a;
  protected float[] a;
  protected final float b;
  public int b;
  protected Context b;
  protected Drawable b;
  public int c;
  protected boolean c;
  protected int d;
  protected int e;
  protected int f;
  
  public TribeShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vgc(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$AIOShortVideoDownloadListener = new vgg(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.d = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.e = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.jdField_b_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.jdField_c_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.f = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$AIOShortVideoDownloadListener);
    ShortVideoUtils.ShortVideoPlayConfig.a();
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
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "setImageUrl exp: " + paramImageView.toString());
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public Drawable a(String paramString)
  {
    EmptyDrawable localEmptyDrawable2 = PAVideoView.a;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
        return PAVideoView.a;
      }
      EmptyDrawable localEmptyDrawable1 = localEmptyDrawable2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localEmptyDrawable2;
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
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localMessageForTribeShortVideo.videoWidth > localMessageForTribeShortVideo.videoHeight)
    {
      this.jdField_b_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.jdField_c_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      if (paramView != null) {
        break label759;
      }
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130968760, paramBaseChatItemLayout, false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131361877));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363618));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363615));
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363616));
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView = new TribeShortVideoItemBuilder.TribeShortVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.c(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setRadius(15.0F);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d(true);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusable(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusableInTouchMode(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setClickable(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, 0);
      paramBaseChatItemLayout = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramBaseChatItemLayout.setShape(0);
      float f1 = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramBaseChatItemLayout.setGradientType(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBaseChatItemLayout);
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
      j = this.jdField_b_of_type_Int;
      k = BaseChatItemLayout.j;
      m = this.jdField_c_of_type_Int;
      n = BaseChatItemLayout.g;
      i1 = this.f;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      label526:
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a);
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d != bool)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d = bool;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a(this.jdField_b_of_type_Int - i, this.jdField_c_of_type_Int - DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 3.0F));
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.invalidate();
      }
      if (bool) {
        break label878;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramViewHolder, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      this.jdField_b_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      this.jdField_c_of_type_Int = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      break;
      label759:
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
      j = this.jdField_b_of_type_Int;
      k = BaseChatItemLayout.j;
      m = this.jdField_c_of_type_Int;
      n = BaseChatItemLayout.g;
      i1 = this.f;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      break label526;
      label878:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
  }
  
  public QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 200;
    }
    localQQLiveDrawableParams.mPreviewWidth = i;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 400;
    }
    localQQLiveDrawableParams.mPreviewHeight = paramInt1;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mDataSourceType = 3;
    localQQLiveDrawableParams.mDataSource = paramString2;
    localQQLiveDrawableParams.mCoverUrl = paramString1;
    localQQLiveDrawableParams.mCoverLoadingDrawable = PAVideoView.a;
    localQQLiveDrawableParams.mLoopback = true;
    localQQLiveDrawableParams.msgUniseq = paramLong;
    return localQQLiveDrawableParams;
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
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
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
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.c(paramChatMessage);
    }
  }
  
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
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localTribeShortVideoMsgHolder.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label280;
      }
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label329;
      }
      localTribeShortVideoMsgHolder.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + "...部落");
      label175:
      localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.b)) {
        break label364;
      }
      localTribeShortVideoMsgHolder.jdField_a_of_type_Boolean = false;
      localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label280:
    label329:
    label364:
    do
    {
      return;
      paramViewGroup.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a) + BaseChatItemLayout.i);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localTribeShortVideoMsgHolder.b.setText(localMessageForTribeShortVideo.srcName + "部落");
      break label175;
      paramViewGroup = (Long)localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    localTribeShortVideoMsgHolder.jdField_a_of_type_Boolean = false;
    a(localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localTribeShortVideoMsgHolder, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramTribeShortVideoMsgHolder.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramTribeShortVideoMsgHolder.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
      return;
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramTribeShortVideoMsgHolder);
    }
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new vgh(this, paramTribeShortVideoMsgHolder, paramLong));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
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
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2.bid)) {
          continue;
        }
        paramLong = 0L;
        paramString1.put("bid", paramLong);
        if (!TextUtils.isEmpty(paramString2.pid)) {
          continue;
        }
        paramTribeShortVideoMsgHolder = Integer.valueOf(0);
        paramString1.put("pid", paramTribeShortVideoMsgHolder);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramTribeShortVideoMsgHolder)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramTribeShortVideoMsgHolder = new NewIntent(this.jdField_b_of_type_AndroidContentContext, ProtoServlet.class);
      paramTribeShortVideoMsgHolder.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramTribeShortVideoMsgHolder.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramTribeShortVideoMsgHolder);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramTribeShortVideoMsgHolder = paramString2.pid;
    }
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(AppConstants.aS + paramMessageForTribeShortVideo.mVid + ".mp4");
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new vgd(this, (String)localObject, paramTribeShortVideoMsgHolder, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new vge(this, paramTribeShortVideoMsgHolder));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramTribeShortVideoMsgHolder);
  }
  
  protected void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130840623);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130843275);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131492968));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramTribeShortVideoMsgHolder.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131361877);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131361877);
    paramViewGroup.addView(paramTribeShortVideoMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoView paramTribeShortVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl);
    paramTribeShortVideoView.setImageDrawable(URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    Object localObject1 = new File(AppConstants.aS);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = AppConstants.aS + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File((String)localObject1);
    localObject2 = new DownloadTask(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((DownloadTask)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject2, new vgf(this, paramTribeShortVideoMsgHolder, paramMessageForTribeShortVideo), localBundle);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    if (TroopBusinessUtil.a(paramView) == null) {}
    localQQCustomMenu.a(2131363499, this.jdField_b_of_type_AndroidContentContext.getString(2131435066), 2130838309);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    b(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
  
  public void b(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramTribeShortVideoMsgHolder.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", true);
      localIntent.putExtra("url", paramTribeShortVideoMsgHolder.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
      return;
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramTribeShortVideoMsgHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */