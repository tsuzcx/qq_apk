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
  protected int A;
  protected int B;
  protected int C;
  protected final float D = 15.0F;
  protected int E;
  protected boolean F = false;
  protected PlayingListPreloader G = new PlayingListPreloader();
  protected String H;
  protected int I;
  public View.OnClickListener J = new QQStoryItemBuilder.1(this);
  public QQStoryItemBuilder.AIOStoryDownloadListener K = new QQStoryItemBuilder.4(this);
  private StoryVideoItem L;
  protected Context a;
  protected float[] w;
  protected Drawable x;
  protected Drawable y;
  protected int z;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramContext;
    float f = DisplayUtil.a(this.a, 15.0F);
    this.w = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
    this.x = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.y = new ColorDrawable(Color.parseColor("#00000000"));
    this.B = DisplayUtil.a(this.a, 135.0F);
    this.C = DisplayUtil.a(this.a, 19.0F);
    this.z = DisplayUtil.a(this.a, 137.0F);
    this.A = DisplayUtil.a(this.a, 218.0F);
    this.E = DisplayUtil.a(this.a, 7.0F);
    paramBaseAdapter = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBaseAdapter.d())
    {
      paramBaseAdapter.c();
      this.F = true;
    }
    this.G.a(this.K);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
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
    localQQLiveDrawableParams.mCoverLoadingDrawable = PAVideoView.V;
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
      this.H = localVideoGameInfo.b;
      boolean bool = paramStoryVideoItem.isMine();
      int i = 1;
      if (bool)
      {
        if (localVideoGameInfo.a != 1) {
          i = 3;
        }
        this.I = i;
        return;
      }
      if (localVideoGameInfo.a == 1) {
        i = 2;
      } else {
        i = 4;
      }
      this.I = i;
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
  
  private Drawable b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString)
  {
    a(paramQQStoryMsgHolder, paramString);
    Object localObject3 = paramQQStoryMsgHolder.b;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if ((paramQQStoryMsgHolder.b instanceof URLDrawable))
      {
        localObject1 = paramQQStoryMsgHolder.b.getCurrDrawable();
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
      localObject1 = PAVideoView.V;
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
      paramViewHolder = LayoutInflater.from(this.a).inflate(2131624441, paramBaseChatItemLayout, false);
      localQQStoryMsgHolder.y = ((RelativeLayout)paramViewHolder.findViewById(2131430578));
      localQQStoryMsgHolder.s = ((TextView)localQQStoryMsgHolder.y.findViewById(2131429731));
      localQQStoryMsgHolder.t = ((TextView)localQQStoryMsgHolder.y.findViewById(2131439404));
      localQQStoryMsgHolder.g = ((ImageView)localQQStoryMsgHolder.y.findViewById(2131437743));
      localQQStoryMsgHolder.w = ((ImageView)localQQStoryMsgHolder.y.findViewById(2131437985));
      localQQStoryMsgHolder.z = ((ViewGroup)localQQStoryMsgHolder.y.findViewById(2131433988));
      localQQStoryMsgHolder.A = ((TextView)localQQStoryMsgHolder.y.findViewById(2131434030));
      localQQStoryMsgHolder.B = ((TextView)localQQStoryMsgHolder.y.findViewById(2131433960));
      localQQStoryMsgHolder.x = ((AutoStartProgressBar)localQQStoryMsgHolder.y.findViewById(2131449632));
      localQQStoryMsgHolder.x.setSharpCornerCor(BubbleImageView.d);
      localQQStoryMsgHolder.c = new QQStoryItemBuilder.StoryChatVideoView(this.a);
      paramView = new RelativeLayout.LayoutParams(this.z, this.A);
      localQQStoryMsgHolder.c.setLayoutParams(paramView);
      localQQStoryMsgHolder.c.b(false);
      localQQStoryMsgHolder.c.setRadius(15.0F);
      localQQStoryMsgHolder.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.c.c(true);
      localQQStoryMsgHolder.c.setFocusable(false);
      localQQStoryMsgHolder.c.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.c.setClickable(false);
      localQQStoryMsgHolder.c.setSharpCornerCor(BubbleImageView.d);
      localQQStoryMsgHolder.y.addView(localQQStoryMsgHolder.c, 0);
      localQQStoryMsgHolder.d = new BubbleImageView(this.a);
      paramView = new RelativeLayout.LayoutParams(this.z, this.A);
      localQQStoryMsgHolder.d.setLayoutParams(paramView);
      localQQStoryMsgHolder.d.b(false);
      localQQStoryMsgHolder.d.setRadius(15.0F);
      localQQStoryMsgHolder.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.d.c(true);
      localQQStoryMsgHolder.d.setFocusable(false);
      localQQStoryMsgHolder.d.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.d.setClickable(false);
      localQQStoryMsgHolder.d.setSharpCornerCor(BubbleImageView.d);
      localQQStoryMsgHolder.y.addView(localQQStoryMsgHolder.d, 1);
      localQQStoryMsgHolder.e = new BubbleImageView(this.a);
      localQQStoryMsgHolder.e.setLayoutParams(new RelativeLayout.LayoutParams(this.z, this.A));
      localQQStoryMsgHolder.e.b(false);
      localQQStoryMsgHolder.e.setRadius(15.0F);
      localQQStoryMsgHolder.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.e.c(true);
      localQQStoryMsgHolder.e.setFocusable(false);
      localQQStoryMsgHolder.e.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.e.setClickable(false);
      localQQStoryMsgHolder.e.setVisibility(4);
      localQQStoryMsgHolder.y.addView(localQQStoryMsgHolder.e, 2);
      localQQStoryMsgHolder.f = new BubbleImageView(this.a);
      localQQStoryMsgHolder.f.setLayoutParams(new RelativeLayout.LayoutParams(this.z, this.A));
      localQQStoryMsgHolder.f.b(false);
      localQQStoryMsgHolder.f.setRadius(15.0F);
      localQQStoryMsgHolder.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localQQStoryMsgHolder.f.c(true);
      localQQStoryMsgHolder.f.setFocusable(false);
      localQQStoryMsgHolder.f.setFocusableInTouchMode(false);
      localQQStoryMsgHolder.f.setClickable(false);
      localQQStoryMsgHolder.f.setVisibility(4);
      localQQStoryMsgHolder.y.addView(localQQStoryMsgHolder.f, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      f1 = DisplayUtil.a(this.a, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localQQStoryMsgHolder.w.setBackgroundDrawable(paramView);
      localQQStoryMsgHolder.x.setRadius(15.0F, true);
      localQQStoryMsgHolder.x.setShowCorner(true);
      localQQStoryMsgHolder.x.setDrawStatus(1);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      localQQStoryMsgHolder.y.setOnClickListener(this.J);
      i = this.a.getResources().getDimensionPixelSize(2131296618);
      int k = this.z;
      int m = BaseChatItemLayout.getBubblePaddingAlignError();
      int n = this.A;
      int i1 = BaseChatItemLayout.k;
      int i2 = this.E;
      paramView = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.y.getLayoutParams();
      paramView.width = (k + m + i);
      paramView.height = (n + i1 + i2);
      localQQStoryMsgHolder.y.setLayoutParams(paramView);
    }
    paramView = localQQStoryMsgHolder.x;
    paramBaseChatItemLayout = new StringBuilder();
    paramBaseChatItemLayout.append(paramChatMessage.frienduin);
    paramBaseChatItemLayout.append(paramChatMessage.uniseq);
    paramView.setKey(paramBaseChatItemLayout.toString());
    localQQStoryMsgHolder.x.setCornerDirection(bool);
    if (localQQStoryMsgHolder.c.v != bool)
    {
      localQQStoryMsgHolder.c.v = bool;
      localQQStoryMsgHolder.d.v = bool;
      localQQStoryMsgHolder.e.v = bool;
      localQQStoryMsgHolder.f.v = bool;
      if (VersionUtils.e())
      {
        localQQStoryMsgHolder.c.a(this.z, this.A);
        localQQStoryMsgHolder.d.a(this.z, this.A);
        localQQStoryMsgHolder.e.a(this.z, this.A);
        localQQStoryMsgHolder.f.a(this.z, this.A);
      }
      localQQStoryMsgHolder.c.invalidate();
      localQQStoryMsgHolder.d.invalidate();
      localQQStoryMsgHolder.e.invalidate();
      localQQStoryMsgHolder.f.invalidate();
    }
    int i = DisplayUtil.a(this.a, localQQStoryMsgHolder.c.f);
    if ((paramChatMessage instanceof MessageForQQStory))
    {
      paramChatMessage = (MessageForQQStory)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.storyTitle)) || (TextUtils.isEmpty(paramChatMessage.storyBrief))) {
        j = 0;
      }
      if (j != 0)
      {
        paramView = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.z.getLayoutParams();
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
        paramView.width = (this.z - i);
        paramView.height = DisplayUtil.a(this.a, 42.0F);
        localQQStoryMsgHolder.z.setLayoutParams(paramView);
        localQQStoryMsgHolder.z.setVisibility(0);
        if ((GradientDrawable)localQQStoryMsgHolder.z.getBackground() == null)
        {
          paramView = new GradientDrawable();
          paramView.setCornerRadii(this.w);
          paramView.setColor(1929379840);
          localQQStoryMsgHolder.z.setBackgroundDrawable(paramView);
        }
        localQQStoryMsgHolder.A.setText(paramChatMessage.storyTitle);
        localQQStoryMsgHolder.B.setText(paramChatMessage.storyBrief);
      }
      else
      {
        localQQStoryMsgHolder.z.setVisibility(8);
      }
    }
    if (!bool)
    {
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.s.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localQQStoryMsgHolder.s.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.g.getLayoutParams();
      paramView = this.a;
      f1 = localQQStoryMsgHolder.c.f;
      float f2 = 10;
      paramChatMessage.leftMargin = DisplayUtil.a(paramView, f1 + f2);
      paramChatMessage.rightMargin = DisplayUtil.a(this.a, f2);
      localQQStoryMsgHolder.g.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.w.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localQQStoryMsgHolder.w.setLayoutParams(paramChatMessage);
      return paramViewHolder;
    }
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.s.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localQQStoryMsgHolder.s.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.g.getLayoutParams();
    paramView = this.a;
    float f1 = 10;
    paramChatMessage.leftMargin = DisplayUtil.a(paramView, f1);
    paramChatMessage.rightMargin = DisplayUtil.a(this.a, localQQStoryMsgHolder.c.f + f1);
    localQQStoryMsgHolder.g.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localQQStoryMsgHolder.w.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localQQStoryMsgHolder.w.setLayoutParams(paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryItemBuilder.QQStoryMsgHolder();
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
      JumpAction localJumpAction1 = JumpParser.a(this.d, this.a, localMessageForQQStory.msgAction);
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
    case 2131444634: 
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.d, this.f.a, "reply", localJumpAction2, bool);
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
    case 2131438943: 
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.d, this.f.a, "withdraw", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      break;
    case 2131433636: 
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
      paramContext.putInt("selection_mode", this.u);
      paramContext.putInt("forward_source_uin_type", this.f.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.a, paramChatMessage, 21);
      a(this.d, this.f.a, "forward", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1)
      {
        StoryReportor.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      break;
    case 2131431695: 
      ChatActivityFacade.b(this.a, this.d, paramChatMessage);
      a(this.d, this.f.a, "delete", localJumpAction2, bool);
      if (localMessageForQQStory.type == 3) {
        StoryReportor.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
      }
      if (localMessageForQQStory.type == 1) {
        StoryReportor.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
      }
      break;
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.a.getResources().getDimensionPixelSize(2131296618);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, i, this.E);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), this.E);
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
    if (localQQStoryMsgHolder.u == null) {
      a(localQQStoryMsgHolder, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localQQStoryMsgHolder.v.getLayoutParams();
    if (bool) {
      paramViewGroup.leftMargin = BaseChatItemLayout.getBubblePaddingAlignError();
    } else {
      paramViewGroup.leftMargin = (DisplayUtil.a(this.a, localQQStoryMsgHolder.c.f) + BaseChatItemLayout.getBubblePaddingAlignHead());
    }
    localQQStoryMsgHolder.v.setLayoutParams(paramViewGroup);
    localQQStoryMsgHolder.s.setText(localMessageForQQStory.brief);
    localQQStoryMsgHolder.v.setText(localMessageForQQStory.srcName);
    int i = localMessageForQQStory.type;
    bool = false;
    if ((i != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9))
    {
      if (localMessageForQQStory.type == 11)
      {
        localQQStoryMsgHolder.t.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip)) {
          localQQStoryMsgHolder.t.setText(localMessageForQQStory.mHeadTip);
        } else {
          localQQStoryMsgHolder.t.setText(HardCodeUtil.a(2131908527));
        }
      }
      else
      {
        localQQStoryMsgHolder.t.setVisibility(8);
      }
    }
    else
    {
      localQQStoryMsgHolder.t.setVisibility(0);
      localQQStoryMsgHolder.t.setText(HardCodeUtil.a(2131908528));
    }
    localQQStoryMsgHolder.x.setCornerDirection(paramChatMessage.isSend());
    if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
    {
      paramViewGroup = (Long)localQQStoryMsgHolder.c.getTag();
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
        localQQStoryMsgHolder.C = false;
        localQQStoryMsgHolder.d.setImageDrawable(null);
        a(localQQStoryMsgHolder.c, localMessageForQQStory.coverImgUrl, this.z, this.A, this.x);
        if (paramChatMessage != null)
        {
          b(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localQQStoryMsgHolder, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localQQStoryMsgHolder, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localQQStoryMsgHolder.c.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
    }
    else
    {
      localQQStoryMsgHolder.C = false;
      localQQStoryMsgHolder.x.setDrawStatus(2);
      localQQStoryMsgHolder.x.setVisibility(0);
      a(localQQStoryMsgHolder.c, localMessageForQQStory.coverImgUrl, this.z, this.A, this.x);
      a(localQQStoryMsgHolder.g, localMessageForQQStory.logoImgUrl, this.B, this.C, this.y);
      localQQStoryMsgHolder.d.setImageDrawable(null);
    }
    try
    {
      paramViewGroup = JumpParser.a(this.d, this.a, localMessageForQQStory.msgAction);
      if (TroopBusinessUtil.a(localMessageForQQStory) == null) {
        bool = true;
      }
      a(this.d, this.f.a, "exp", paramViewGroup, bool);
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
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.q;
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
          paramQQStoryMsgHolder = JumpParser.a(this.d, this.a, paramQQStoryMsgHolder.msgAction);
          paramQQStoryMsgHolder.a();
          a(this.d, this.f.a, "clk_play", paramQQStoryMsgHolder, bool);
          int i = this.I;
          localObject = this.H;
          if (this.L == null) {
            paramQQStoryMsgHolder = str;
          } else {
            paramQQStoryMsgHolder = this.L.mVid;
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
    ((Activity)this.a).runOnUiThread(new QQStoryItemBuilder.10(this, paramQQStoryMsgHolder, paramLong));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramQQStoryMsgHolder, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!AIOSingleReporter.a().a(paramQQStoryMsgHolder.q, "share|auto_play"))
    {
      AIOSingleReporter.a().b(paramQQStoryMsgHolder.q, "share|auto_play");
      if ((paramQQStoryMsgHolder.q instanceof MessageForQQStory))
      {
        paramInt1 = ((MessageForQQStory)paramQQStoryMsgHolder.q).type;
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
    this.L = paramStoryVideoItem;
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
      if ((!a(paramQQStoryMsgHolder.q)) && (!paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
        }
        ((Activity)this.a).runOnUiThread(new QQStoryItemBuilder.6(this, paramQQStoryMsgHolder, paramLong, paramStoryVideoItem));
        return;
      }
      ((Activity)this.a).runOnUiThread(new QQStoryItemBuilder.5(this, paramQQStoryMsgHolder));
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramStoryVideoItem);
      this.G.a((List)localObject1);
      this.G.a(paramStoryVideoItem.mVid);
      this.K.a(paramQQStoryMsgHolder, paramStoryVideoItem.mVid, paramLong);
      return;
    }
    Object localObject2 = this.G.a(paramStoryVideoItem.mVid);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith("file://")) {
        localObject1 = ((String)localObject2).substring(7);
      }
    }
    localObject2 = this.a;
    if ((localObject2 instanceof Activity)) {
      ((Activity)localObject2).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject1, paramQQStoryMsgHolder, paramStoryVideoItem, paramLong, paramBoolean));
    }
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramQQStoryMsgHolder.u = new FrameLayout(this.a);
    Object localObject = new TextView(this.a);
    ((TextView)localObject).setBackgroundResource(2130843655);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.a.getResources().getColor(2131168464));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(DisplayUtil.a(this.a, 5.0F), 0, DisplayUtil.a(this.a, 5.0F), 0);
    paramQQStoryMsgHolder.u.setOnClickListener(this.J);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramQQStoryMsgHolder.u.addView((View)localObject, localLayoutParams);
    paramQQStoryMsgHolder.v = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430578);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131430578);
    paramViewGroup.addView(paramQQStoryMsgHolder.u, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString)
  {
    StringBuilder localStringBuilder1;
    if ((TextUtils.equals(paramString, paramQQStoryMsgHolder.a)) && (paramQQStoryMsgHolder.b != null))
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
      paramQQStoryMsgHolder.a = paramString;
      paramQQStoryMsgHolder.b = null;
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramQQStoryMsgHolder.b = URLDrawable.getDrawable(paramString, PAVideoView.V, PAVideoView.V);
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
    PlayModeUtils.a(this.d, paramString, new QQStoryItemBuilder.9(this, paramQQStoryMsgHolder, paramLong, paramBoolean));
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    SLog.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramQQStoryMsgHolder, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (this.d.getShortVideoPredownloer().j.get() == 2) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > ShortVideoPreDownloader.b) {
      return false;
    }
    return NetworkUtil.isWifiConnected(this.a);
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
    localQQCustomMenu.a(2131433636, this.a.getString(2131889668), 2130839066);
    a(localQQCustomMenu, this.a, 2131444634, paramView, null);
    if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
      a(localQQCustomMenu, this.a, 2131438943, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.a, 2131431695, paramView, new Bundle());
    a(localQQCustomMenu, this.a, 2131444651, paramView, null);
    try
    {
      paramView = (MessageForQQStory)paramView;
      paramView = JumpParser.a(this.d, this.a, paramView.msgAction);
      a(this.d, this.f.a, "press", paramView, bool);
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
      }
    }
    super.a(localQQCustomMenu, this.a, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    this.G.a();
    if (this.F)
    {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
      this.F = false;
    }
    super.b();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    Object localObject = AIOUtils.b(paramView);
    if (!QQStoryItemBuilder.QQStoryMsgHolder.class.isInstance(localObject)) {
      return;
    }
    paramView = this.a;
    localObject = ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).q;
    String str1 = paramView.getString(2131886574);
    String str2 = paramView.getString(2131886575);
    if (((ChatMessage)localObject).isSendFromLocal()) {
      DialogUtil.a(paramView, 230, str1, str2, new QQStoryItemBuilder.2(this, paramView, (ChatMessage)localObject), new QQStoryItemBuilder.3(this)).show();
    }
  }
  
  protected void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    for (;;)
    {
      try
      {
        paramQQStoryMsgHolder = (MessageForQQStory)paramQQStoryMsgHolder.q;
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
          JumpParser.a(this.d, this.a, paramQQStoryMsgHolder.srcAction).a();
          paramQQStoryMsgHolder = JumpParser.a(this.d, this.a, paramQQStoryMsgHolder.msgAction);
          a(this.d, this.f.a, "clk_tail", paramQQStoryMsgHolder, bool);
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
    paramString2.mLoadingDrawable = b(paramQQStoryMsgHolder, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramQQStoryMsgHolder.c.setImageDrawable(paramString1);
  }
  
  public void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    SLog.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramQQStoryMsgHolder.e.getTag()))
    {
      SLog.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isPollVideo())
    {
      PollContainerLayout localPollContainerLayout = new PollContainerLayout(this.a);
      localPollContainerLayout.a(true);
      localPollContainerLayout.a(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.a);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.z, this.A));
      localFrameLayout.addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.z, 1073741824), View.MeasureSpec.makeMeasureSpec(this.A, 1073741824));
      localFrameLayout.layout(0, 0, this.z, this.A);
      localPollContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.z, this.A, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramQQStoryMsgHolder.e.setImageDrawable(new BitmapDrawable(this.a.getResources(), paramStoryVideoItem));
      paramQQStoryMsgHolder.e.setVisibility(0);
    }
    else
    {
      paramQQStoryMsgHolder.e.setVisibility(4);
    }
    paramQQStoryMsgHolder.e.setTag(str);
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public void c(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    SLog.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    paramStoryVideoItem = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(paramStoryVideoItem, (String)paramQQStoryMsgHolder.f.getTag()))
    {
      SLog.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", paramStoryVideoItem);
      return;
    }
    paramQQStoryMsgHolder.f.setVisibility(4);
    paramQQStoryMsgHolder.f.setTag(paramStoryVideoItem);
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */