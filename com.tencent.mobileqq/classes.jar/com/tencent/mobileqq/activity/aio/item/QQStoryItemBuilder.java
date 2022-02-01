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
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageRecord;
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

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  protected int a;
  protected Drawable a;
  public View.OnClickListener a;
  protected PlayingListPreloader a;
  private StoryVideoItem a;
  public QQStoryItemBuilder.AIOStoryDownloadListener a;
  protected String a;
  protected float[] a;
  protected final float b;
  protected Context b;
  protected Drawable b;
  protected int d;
  protected int e;
  protected int f;
  protected boolean f;
  protected int g;
  protected int h;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QQStoryItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener = new QQStoryItemBuilder.4(this);
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
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
  }
  
  private Drawable a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString)
  {
    a(paramQQStoryMsgHolder, paramString);
    Object localObject3 = paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable instanceof URLDrawable))
      {
        localObject1 = paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        if ((localObject1 != null) && ((localObject1 instanceof RegionDrawable)))
        {
          localObject3 = ((RegionDrawable)localObject1).getBitmap();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject3).isRecycled())
            {
              localObject2 = new BitmapDrawable((Bitmap)localObject3);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("getBitmapDrawable(): find bitmap drawable coverUrl=");
                ((StringBuilder)localObject1).append(paramString);
                ((StringBuilder)localObject1).append(" holder=");
                ((StringBuilder)localObject1).append(paramQQStoryMsgHolder.hashCode());
                QLog.e("QQStoryItemBuilder", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localObject2;
              }
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getBitmapDrawable(): not find reginDrawable coverUrl=");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(" holder=");
            ((StringBuilder)localObject1).append(paramQQStoryMsgHolder.hashCode());
            QLog.e("QQStoryItemBuilder", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = PAVideoView.a;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBitmapDrawable(): use loading drawable coverUrl=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" holder=");
        ((StringBuilder)localObject2).append(paramQQStoryMsgHolder.hashCode());
        QLog.e("QQStoryItemBuilder", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    return localObject2;
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
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setImageUrl exp: ");
        paramString.append(paramImageView.toString());
        QLog.w("Q.qqstory.share", 2, paramString.toString());
      }
    }
  }
  
  private void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoGameInfo localVideoGameInfo = paramStoryVideoItem.getVideoGameInfo();
    if (localVideoGameInfo != null)
    {
      this.jdField_a_of_type_JavaLangString = localVideoGameInfo.jdField_a_of_type_JavaLangString;
      boolean bool = paramStoryVideoItem.isMine();
      int i = 1;
      if (bool)
      {
        if (localVideoGameInfo.jdField_a_of_type_Int != 1) {
          i = 3;
        }
        this.h = i;
        return;
      }
      if (localVideoGameInfo.jdField_a_of_type_Int == 1) {
        i = 2;
      } else {
        i = 4;
      }
      this.h = i;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, JumpAction paramJumpAction, boolean paramBoolean)
  {
    int i = -1;
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else if (paramInt == 3000) {
      paramInt = 3;
    } else {
      paramInt = -1;
    }
    if (paramJumpAction != null)
    {
      int j;
      try
      {
        paramQQAppInterface = paramJumpAction.b("unionid");
        str = paramJumpAction.b("storyid");
      }
      catch (Exception paramQQAppInterface) {}
    }
    try
    {
      j = Integer.valueOf(paramJumpAction.b("contentType")).intValue();
      i = j;
      paramJumpAction = str;
    }
    catch (Exception paramJumpAction)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        break;
        str = "2";
      }
    }
    paramJumpAction = str;
    break label98;
    paramQQAppInterface = "";
    paramJumpAction = paramQQAppInterface;
    label98:
    if (paramBoolean)
    {
      str = "1";
      StoryReportor.a("share_obj", paramString, paramInt, i, new String[] { paramQQAppInterface, paramJumpAction, str, "" });
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportClickEvent: opName=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", fromType=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", result=");
        localStringBuilder.append(i);
        localStringBuilder.append(", extra1=");
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(", extra2=");
        localStringBuilder.append(paramJumpAction);
        localStringBuilder.append(", extra3=");
        localStringBuilder.append(str);
        QLog.d("Q.qqstory.share", 2, localStringBuilder.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        }
      }
      return;
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
    int j = 1;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558821, paramBaseChatItemLayout, false);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder.findViewById(2131364521));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363798));
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371959));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370471));
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370708));
      localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367480));
      localQQStoryMsgHolder.d = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367510));
      localQQStoryMsgHolder.e = ((TextView)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367454));
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380672));
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.d);
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
      paramView = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.d);
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
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.d));
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
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.d));
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
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296386);
      int k = this.jdField_a_of_type_Int;
      int m = BaseChatItemLayout.k;
      int n = this.d;
      int i1 = BaseChatItemLayout.h;
      int i2 = this.g;
      paramView = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (k + m + i);
      paramView.height = (n + i1 + i2);
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    paramView = localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar;
    paramBaseChatItemLayout = new StringBuilder();
    paramBaseChatItemLayout.append(paramChatMessage.frienduin);
    paramBaseChatItemLayout.append(paramChatMessage.uniseq);
    paramView.setKey(paramBaseChatItemLayout.toString());
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (VersionUtils.e())
      {
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.jdField_a_of_type_Int, this.d);
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_a_of_type_Int, this.d);
        localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_a_of_type_Int, this.d);
        localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.jdField_a_of_type_Int, this.d);
      }
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
    if ((paramChatMessage instanceof MessageForQQStory))
    {
      paramChatMessage = (MessageForQQStory)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.storyTitle)) || (TextUtils.isEmpty(paramChatMessage.storyBrief))) {
        j = 0;
      }
      if (j != 0)
      {
        paramView = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
        if (!bool) {
          j = i;
        } else {
          j = 0;
        }
        paramView.leftMargin = j;
        if (!bool) {
          j = 0;
        } else {
          j = i;
        }
        paramView.rightMargin = j;
        paramView.width = (this.jdField_a_of_type_Int - i);
        paramView.height = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 42.0F);
        localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
        localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if ((GradientDrawable)localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null)
        {
          paramView = new GradientDrawable();
          paramView.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
          paramView.setColor(1929379840);
          localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramView);
        }
        localQQStoryMsgHolder.d.setText(paramChatMessage.storyTitle);
        localQQStoryMsgHolder.e.setText(paramChatMessage.storyBrief);
      }
      else
      {
        localQQStoryMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    if (!bool)
    {
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView = this.jdField_b_of_type_AndroidContentContext;
      f1 = localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a;
      float f2 = 10;
      paramChatMessage.leftMargin = DisplayUtil.a(paramView, f1 + f2);
      paramChatMessage.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, f2);
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
    paramView = this.jdField_b_of_type_AndroidContentContext;
    float f1 = 10;
    paramChatMessage.leftMargin = DisplayUtil.a(paramView, f1);
    paramChatMessage.rightMargin = DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + f1);
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
    if (this.jdField_f_of_type_Boolean)
    {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
      this.jdField_f_of_type_Boolean = false;
    }
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForQQStory))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForQQStory localMessageForQQStory = (MessageForQQStory)paramChatMessage;
    boolean bool;
    if (TroopBusinessUtil.a(paramChatMessage) == null) {
      bool = true;
    } else {
      bool = false;
    }
    JumpAction localJumpAction2;
    try
    {
      JumpAction localJumpAction1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "onMenuItemClicked exp:", localException);
      }
      localJumpAction2 = null;
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131376417: 
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "reply", localJumpAction2, bool);
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      if (localMessageForQQStory.type == 2)
      {
        StoryReportor.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      break;
    case 2131371562: 
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "withdraw", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      break;
    case 2131367180: 
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
      paramContext.putInt("selection_mode", this.c);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "forward", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      break;
    case 2131365480: 
      ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "delete", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1) {
        StoryReportor.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
      }
      break;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    Object localObject = AIOUtils.a(paramView);
    if (!QQStoryItemBuilder.QQStoryMsgHolder.class.isInstance(localObject)) {
      return;
    }
    paramView = this.jdField_b_of_type_AndroidContentContext;
    localObject = ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str1 = paramView.getString(2131689933);
    String str2 = paramView.getString(2131689934);
    if (((ChatMessage)localObject).isSendFromLocal()) {
      DialogUtil.a(paramView, 230, str1, str2, new QQStoryItemBuilder.2(this, paramView, (ChatMessage)localObject), new QQStoryItemBuilder.3(this)).show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296386);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, this.g);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, this.g);
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
    if (bool) {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
    } else {
      paramViewGroup.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j);
    }
    localQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
    localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
    localQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
    int i = localMessageForQQStory.type;
    bool = false;
    if ((i != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9))
    {
      if (localMessageForQQStory.type == 11)
      {
        localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip)) {
          localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
        } else {
          localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710853));
        }
      }
      else
      {
        localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localQQStoryMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710854));
    }
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
    if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
    {
      paramViewGroup = (Long)localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((StoryManager)SuperManager.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForQQStory.uniseq))
      {
        if (paramChatMessage != null)
        {
          b(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
      }
      else
      {
        localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localQQStoryMsgHolder, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
    }
    else
    {
      localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.e, this.jdField_f_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    try
    {
      paramViewGroup = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
      if (TroopBusinessUtil.a(localMessageForQQStory) == null) {
        bool = true;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "exp", paramViewGroup, bool);
      return;
    }
    catch (Exception paramViewGroup)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "getView report exp:", paramViewGroup);
      }
    }
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    String str = "";
    for (;;)
    {
      try
      {
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("QQStoryItemBuilder onBubbleOnClick:");
          ((StringBuilder)localObject).append(paramQQStoryMsgHolder.toString());
          QLog.d("Q.qqstory.share", 2, ((StringBuilder)localObject).toString());
        }
        if (TroopBusinessUtil.a(paramQQStoryMsgHolder) == null)
        {
          bool = true;
          paramQQStoryMsgHolder = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.msgAction);
          paramQQStoryMsgHolder.a();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_play", paramQQStoryMsgHolder, bool);
          int i = this.h;
          localObject = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
            paramQQStoryMsgHolder = str;
          } else {
            paramQQStoryMsgHolder = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
          }
          StoryReportor.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", localObject, paramQQStoryMsgHolder });
          return;
        }
      }
      catch (Exception paramQQStoryMsgHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramQQStoryMsgHolder);
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramQQStoryMsgHolder, paramLong));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramQQStoryMsgHolder, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      if ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory))
      {
        paramInt1 = ((MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
        if (paramInt1 == 1)
        {
          paramInt1 = 1;
          break label171;
        }
        if (paramInt1 == 3)
        {
          paramInt1 = 2;
          break label171;
        }
        if (paramInt1 == 4)
        {
          paramInt1 = 3;
          break label171;
        }
        if (paramInt1 == 5)
        {
          paramInt1 = 4;
          break label171;
        }
        if (paramInt1 == 6)
        {
          paramInt1 = 5;
          break label171;
        }
        if (paramInt1 == 9)
        {
          paramInt1 = 6;
          break label171;
        }
        if (paramInt1 == 12)
        {
          paramInt1 = 7;
          break label171;
        }
        if (paramInt1 == 11)
        {
          paramInt1 = 8;
          break label171;
        }
      }
      paramInt1 = 0;
      label171:
      StoryReportor.a("share", "auto_play", paramInt1, 0, new String[0]);
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetVideo: isPlayable =");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("QQStoryItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    if (!bool)
    {
      if ((!a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
        }
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramQQStoryMsgHolder, paramLong, paramStoryVideoItem));
        return;
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramQQStoryMsgHolder));
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramStoryVideoItem);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a((List)localObject1);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(paramStoryVideoItem.mVid);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$AIOStoryDownloadListener.a(paramQQStoryMsgHolder, paramStoryVideoItem.mVid, paramLong);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(paramStoryVideoItem.mVid);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith("file://")) {
        localObject1 = ((String)localObject2).substring(7);
      }
    }
    localObject2 = this.jdField_b_of_type_AndroidContentContext;
    if ((localObject2 instanceof Activity)) {
      ((Activity)localObject2).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject1, paramQQStoryMsgHolder, paramStoryVideoItem, paramLong, paramBoolean));
    }
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130842702);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramQQStoryMsgHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364521);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364521);
    paramViewGroup.addView(paramQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString)
  {
    StringBuilder localStringBuilder1;
    if ((TextUtils.equals(paramString, paramQQStoryMsgHolder.jdField_b_of_type_JavaLangString)) && (paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable != null))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("checkCoverDrawable(): reuse drawable, coverUrl=");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(" holder=");
        localStringBuilder1.append(paramQQStoryMsgHolder.hashCode());
        QLog.e("QQStoryItemBuilder", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      paramQQStoryMsgHolder.jdField_b_of_type_JavaLangString = paramString;
      paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable = null;
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramQQStoryMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("checkCoverDrawable(): reload drawable, coverUrl=");
            localStringBuilder1.append(paramString);
            localStringBuilder1.append(" holder=");
            localStringBuilder1.append(paramQQStoryMsgHolder.hashCode());
            QLog.e("QQStoryItemBuilder", 2, localStringBuilder1.toString());
            return;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("checkCoverDrawable():  getDrawable Exception, coverUrl=");
            localStringBuilder2.append(paramString);
            localStringBuilder2.append(" holder=");
            localStringBuilder2.append(paramQQStoryMsgHolder.hashCode());
            QLog.e("QQStoryItemBuilder", 2, localStringBuilder2.toString(), localException);
          }
        }
      }
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString, long paramLong, boolean paramBoolean)
  {
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new QQStoryItemBuilder.9(this, paramQQStoryMsgHolder, paramLong, paramBoolean));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    SLog.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramQQStoryMsgHolder, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > ShortVideoPreDownloader.jdField_a_of_type_Long) {
      return false;
    }
    return NetworkUtil.isWifiConnected(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    boolean bool;
    if (TroopBusinessUtil.a(paramView) == null) {
      bool = true;
    } else {
      bool = false;
    }
    localQQCustomMenu.a(2131367180, this.jdField_b_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376417, paramView, null);
    if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
      a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376430, paramView, null);
    try
    {
      paramView = (MessageForQQStory)paramView;
      paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "press", paramView, bool);
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
      }
    }
    super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    for (;;)
    {
      try
      {
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QQStoryItemBuilder onSourceOnClick:");
          localStringBuilder.append(paramQQStoryMsgHolder.toString());
          QLog.d("Q.qqstory.share", 2, localStringBuilder.toString());
        }
        if (TroopBusinessUtil.a(paramQQStoryMsgHolder) == null)
        {
          bool = true;
          JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.srcAction).a();
          paramQQStoryMsgHolder = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_tail", paramQQStoryMsgHolder, bool);
          return;
        }
      }
      catch (Exception paramQQStoryMsgHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramQQStoryMsgHolder);
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramQQStoryMsgHolder, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setImageDrawable(paramString1);
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
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.d));
      localFrameLayout.addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.d, 1073741824));
      localFrameLayout.layout(0, 0, this.jdField_a_of_type_Int, this.d);
      localPollContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.d, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    else
    {
      paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
    paramQQStoryMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
  }
  
  public void c(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    SLog.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    paramStoryVideoItem = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(paramStoryVideoItem, (String)paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      SLog.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", paramStoryVideoItem);
      return;
    }
    paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramQQStoryMsgHolder.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */