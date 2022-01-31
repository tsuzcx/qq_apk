package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
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
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import vak;
import val;
import vam;
import van;
import vao;
import vap;
import vaq;
import var;
import vas;
import vau;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public Drawable a;
  public View.OnClickListener a;
  protected PlayingListPreloader a;
  public QQStoryItemBuilder.AIOStoryDownloadListener a;
  protected float[] a;
  protected final float b;
  public int b;
  public Context b;
  protected Drawable b;
  public int c;
  protected boolean c;
  protected int d;
  protected int e;
  protected int f;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vak(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener = new vao(this);
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
    paramQQAppInterface = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramQQAppInterface.a())
    {
      paramQQAppInterface.c();
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener);
    ShortVideoUtils.ShortVideoPlayConfig.a();
  }
  
  public static Drawable a(String paramString)
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
          QLog.e("QQStoryItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
        return PAVideoView.a;
      }
      EmptyDrawable localEmptyDrawable1 = localEmptyDrawable2;
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localEmptyDrawable2;
  }
  
  public static QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
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
      QLog.w("Q.qqstory.share", 2, "setImageUrl exp: " + paramImageView.toString());
    }
  }
  
  public static void a(QQStoryItemBuilder.StoryChatVideoView paramStoryChatVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl);
    paramStoryChatVideoView.setImageDrawable(URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, JumpAction paramJumpAction, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (paramJumpAction != null) {}
      for (;;)
      {
        try
        {
          str = paramJumpAction.a("unionid");
          paramQQAppInterface = paramJumpAction.a("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(paramJumpAction.a("contentType")).intValue();
          paramJumpAction = str;
        }
        catch (Exception paramJumpAction)
        {
          paramInt = -1;
          paramJumpAction = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          StoryReportor.a("share_obj", paramString, i, paramInt, new String[] { paramJumpAction, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + paramJumpAction + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        paramJumpAction = "";
        paramQQAppInterface = "";
      }
      return;
      if (paramInt == 1) {
        i = 2;
      } else if (paramInt != 3000) {
        i = -1;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)paramViewHolder;
    boolean bool = paramChatMessage.isSend();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130968760, paramBaseChatItemLayout, false);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder.findViewById(2131361877));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363618));
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362134));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363617));
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363615));
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363616));
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setLayoutParams(paramView);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.c(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setRadius(15.0F);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d(true);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusable(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setClickable(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, 0);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 1);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      f1 = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
      int j = this.jdField_b_of_type_Int;
      int k = BaseChatItemLayout.j;
      int m = this.jdField_c_of_type_Int;
      int n = BaseChatItemLayout.g;
      int i1 = this.f;
      paramView = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (VersionUtils.e())
      {
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
    if (!bool)
    {
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
      paramChatMessage.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      return paramViewHolder;
    }
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 10);
    paramView = this.jdField_b_of_type_AndroidContentContext;
    float f1 = localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a;
    paramChatMessage.rightMargin = DisplayUtil.a(paramView, 10 + f1);
    localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryItemBuilder.QQStoryMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a();
    if (this.jdField_c_of_type_Boolean)
    {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
      this.jdField_c_of_type_Boolean = false;
    }
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForQQStory)) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
    MessageForQQStory localMessageForQQStory;
    do
    {
      boolean bool;
      Object localObject1;
      do
      {
        do
        {
          do
          {
            return;
            localMessageForQQStory = (MessageForQQStory)paramChatMessage;
            if (TroopBusinessUtil.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
                switch (paramInt)
                {
                default: 
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  bool = false;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localObject1 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("Q.qqstory.share", 2, "onMenuItemClicked exp:", localException);
                    localObject1 = localObject2;
                  }
                }
                ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "delete", (JumpAction)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  StoryReportor.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          StoryReportor.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
          return;
          paramContext = new Bundle();
          if ((localMessageForQQStory.structingMsg.source_puin != null) && (!"".equals(localMessageForQQStory.structingMsg.source_puin))) {
            paramContext.putString("source_puin", localMessageForQQStory.structingMsg.source_puin);
          }
          paramContext.putInt("forward_type", 28);
          localMessageForQQStory.structingMsg.mCommentText = null;
          paramContext.putInt("structmsg_service_id", localMessageForQQStory.structingMsg.mMsgServiceID);
          paramContext.putByteArray("stuctmsg_bytes", localMessageForQQStory.structingMsg.getBytes());
          paramContext.putLong("structmsg_uniseq", localMessageForQQStory.uniseq);
          paramContext.putInt("accostType", localMessageForQQStory.structingMsg.sourceAccoutType);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "forward", (JumpAction)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            StoryReportor.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        StoryReportor.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.a(paramChatMessage);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "withdraw", (JumpAction)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          StoryReportor.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      StoryReportor.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "reply", (JumpAction)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    StoryReportor.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    Object localObject = AIOUtils.a(paramView);
    if (!QQStoryItemBuilder.QQStoryMsgHolder.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131433618);
      str2 = paramView.getString(2131433619);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    DialogUtil.a(paramView, 230, str1, str2, new vam(this, paramView, (ChatMessage)localObject), new van(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, this.f);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, this.f);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    a((ViewGroup)paramView, paramChatMessage);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForQQStory localMessageForQQStory = (MessageForQQStory)paramChatMessage;
    localMessageForQQStory.parse();
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localQQStoryMsgHolder, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
      localQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label343;
      }
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("点击查看他的一天");
      label158:
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.b)) {
        break label416;
      }
      localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.d, this.e, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        if (TroopBusinessUtil.a(localMessageForQQStory) != null) {
          continue;
        }
        bool = true;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "exp", paramViewGroup, bool);
        return;
      }
      catch (Exception paramViewGroup)
      {
        label343:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label416:
        QLog.w("Q.qqstory.share", 2, "getView report exp:", paramViewGroup);
      }
      paramViewGroup.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.i);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
          break label158;
        }
        localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("点击查看全部视频");
        break label158;
      }
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label158;
      paramViewGroup = (Long)localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((StoryManager)SuperManager.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localQQStoryMsgHolder, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    for (;;)
    {
      try
      {
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramQQStoryMsgHolder.toString());
        }
        if (TroopBusinessUtil.a(paramQQStoryMsgHolder) == null)
        {
          bool = true;
          paramQQStoryMsgHolder = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.msgAction);
          paramQQStoryMsgHolder.b();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "clk_play", paramQQStoryMsgHolder, bool);
          return;
        }
      }
      catch (Exception paramQQStoryMsgHolder)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramQQStoryMsgHolder);
      }
      bool = false;
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new val(this, paramQQStoryMsgHolder, paramLong));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      paramInt1 = 0;
      if ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory))
      {
        paramInt1 = ((MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
        if (paramInt1 != 1) {
          break label96;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      StoryReportor.a("share", "auto_play", paramInt1, 0, new String[0]);
      return;
      label96:
      if (paramInt1 == 3) {
        paramInt1 = 2;
      } else if (paramInt1 == 4) {
        paramInt1 = 3;
      } else if (paramInt1 == 5) {
        paramInt1 = 4;
      } else if (paramInt1 == 6) {
        paramInt1 = 5;
      } else if (paramInt1 == 9) {
        paramInt1 = 6;
      } else if (paramInt1 == 12) {
        paramInt1 = 7;
      } else if (paramInt1 == 11) {
        paramInt1 = 8;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (paramBoolean))
      {
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new vap(this, paramQQStoryMsgHolder));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a((List)localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(paramStoryVideoItem.mVid);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener.a(paramQQStoryMsgHolder, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new vaq(this, paramQQStoryMsgHolder, paramLong, paramStoryVideoItem));
      return;
      String str = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.jdField_b_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new var(this, (String)localObject, paramQQStoryMsgHolder, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130840623);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131492968));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131361877);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131361877);
    paramViewGroup.addView(paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString, long paramLong, boolean paramBoolean)
  {
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new vau(this, paramQQStoryMsgHolder, paramLong, paramBoolean));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    SLog.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new vas(this, paramString2, paramQQStoryMsgHolder, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > ShortVideoPreDownloader.jdField_a_of_type_Long) {
      return false;
    }
    return NetworkUtil.h(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    boolean bool;
    if (TroopBusinessUtil.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localQQCustomMenu.a(2131363499, this.jdField_b_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      a(paramView, localQQCustomMenu);
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "press", paramView, bool);
        return localQQCustomMenu.a();
        bool = false;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
          }
        }
      }
    }
  }
  
  public void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    for (;;)
    {
      try
      {
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramQQStoryMsgHolder.toString());
        }
        if (TroopBusinessUtil.a(paramQQStoryMsgHolder) == null)
        {
          bool = true;
          JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.srcAction).b();
          paramQQStoryMsgHolder = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "clk_tail", paramQQStoryMsgHolder, bool);
          return;
        }
      }
      catch (Exception paramQQStoryMsgHolder)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramQQStoryMsgHolder);
      }
      bool = false;
    }
  }
  
  public void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    SLog.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      SLog.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isPollVideo())
    {
      PollContainerLayout localPollContainerLayout = new PollContainerLayout(this.jdField_b_of_type_AndroidContentContext);
      localPollContainerLayout.a(true);
      localPollContainerLayout.a(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      localFrameLayout.addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
      localFrameLayout.layout(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localPollContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
  
  public void c(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    SLog.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      SLog.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isInteractVideo())
    {
      InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout(this.jdField_b_of_type_AndroidContentContext);
      localInteractContainerLayout.a(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      localFrameLayout.addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
      localFrameLayout.layout(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localInteractContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */