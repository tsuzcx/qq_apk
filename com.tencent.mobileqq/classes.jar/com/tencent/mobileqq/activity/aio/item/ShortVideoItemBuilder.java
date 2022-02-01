package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qqvideoplatform.VideoPlatformUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, Callback, ContextMenuBuilder2, ShortVideoConstants
{
  private static Rect C;
  private static CopyOnWriteArraySet<CropBubbleVideoView> G = new CopyOnWriteArraySet();
  private static long H = 0L;
  public static AtomicLong y = new AtomicLong(-1L);
  private ListView A;
  private Handler B;
  private QQCustomDialog D;
  private MessageForShortVideo E;
  private ShortVideoItemBuilder.CompressUpdateListenerImpl F;
  private Runnable I = new ShortVideoItemBuilder.8(this);
  private View.OnClickListener J = new ShortVideoItemBuilder.9(this);
  public int a = 0;
  boolean w = false;
  int x = -1;
  private MultiRichMediaSaveManager z;
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.A = paramAIOAnimationConatiner.getListView();
    }
    this.B = new Handler(Looper.getMainLooper());
    if (this.z == null) {
      this.z = ((MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
    this.F = new ShortVideoItemBuilder.CompressUpdateListenerImpl(this, null);
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      if (paramMessageForShortVideo == null) {
        return null;
      }
      paramView = paramView.findViewById(2131427939);
      localObject1 = localObject2;
      if ((paramView instanceof CropBubbleVideoView))
      {
        paramView = (CropBubbleVideoView)paramView;
        localObject1 = AnimationUtils.a(paramView);
        if (paramMessageForShortVideo.isSend())
        {
          ((Rect)localObject1).right = ((int)(((Rect)localObject1).right - paramView.triWidth));
          return localObject1;
        }
        ((Rect)localObject1).left = ((int)(((Rect)localObject1).left + paramView.triWidth));
      }
    }
    return localObject1;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbPicUrl(paramString);
      if (paramString != null) {
        return b(paramString.toString(), paramInt1, paramInt2, paramInt3);
      }
      QLog.d("ShortVideoItemBuilder", 2, "url  is null ");
    }
    return null;
  }
  
  private ShortVideoItemBuilder.Holder a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoItemBuilder.Holder localHolder = c(paramMessageForShortVideo.uniseq);
    if ((localHolder == null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("holder is null, seq = ");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    return localHolder;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 4)
    {
      localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
      if ((!AIOSingleReporter.a().a(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.reportVideoPlay(this.d, "0X8008E51", this.f, (MessageRecord)localObject, this.e);
        if (!AIOSingleReporter.a().c(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          AIOSingleReporter.a().d(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.reportVideoPlay(this.d, "0X8008E50", this.f, (MessageRecord)localObject, this.e);
        }
        AIOSingleReporter.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = c(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("holder == null, msgUniseq=");
        ((StringBuilder)localObject).append(paramLong);
        QLog.w("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (((MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject).q).videoFileTime > 8) {
      bool = false;
    }
    if (paramInt == 5)
    {
      this.B.postDelayed(new ShortVideoItemBuilder.10(this, bool, (ShortVideoItemBuilder.Holder)localObject), 1200L);
      return;
    }
    if ((paramInt != 7) && (paramInt != 8))
    {
      if (paramInt == 4)
      {
        this.B.removeCallbacksAndMessages(null);
        if (bool) {
          ((ShortVideoItemBuilder.Holder)localObject).t.setVisibility(8);
        } else {
          ((ShortVideoItemBuilder.Holder)localObject).t.setVisibility(0);
        }
        a((ShortVideoItemBuilder.Holder)localObject);
        ((ShortVideoItemBuilder.Holder)localObject).s.setVisibility(8);
        ((ShortVideoItemBuilder.Holder)localObject).d.setVisibility(8);
        localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
        if (localObject != null) {
          a((MessageForShortVideo)localObject, 0L);
        }
      }
    }
    else
    {
      this.B.removeCallbacksAndMessages(null);
      ((ShortVideoItemBuilder.Holder)localObject).t.setVisibility(8);
      ((ShortVideoItemBuilder.Holder)localObject).c.setVisibility(0);
      b((ShortVideoItemBuilder.Holder)localObject);
      ((ShortVideoItemBuilder.Holder)localObject).s.setVisibility(8);
      ((ShortVideoItemBuilder.Holder)localObject).d.setVisibility(0);
      if (paramInt == 8)
      {
        localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
        if (localObject != null) {
          a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
        }
      }
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayError , id = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , module = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , errorType = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" , errorCode = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" , exInfo =");
      if (paramString == null) {
        paramString = "null";
      }
      localStringBuilder.append(paramString);
      QLog.e("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramInt3 == 14011001)
    {
      paramString = this.A;
      if (paramString == null) {
        return;
      }
      paramString = AIOUtils.b(paramLong, paramString.getAdapter());
      if ((paramString instanceof MessageForShortVideo))
      {
        paramString = (MessageForShortVideo)paramString;
        paramString.videoFileStatus = 5002;
        paramString.serial();
        this.d.getMessageFacade().a(paramString.frienduin, this.f.a, paramString.uniseq, paramString.msgData);
        this.B.post(new ShortVideoItemBuilder.11(this, paramString));
      }
    }
    VideoPlatformUtils.a(paramInt3, paramVideoPlayParam);
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.g.setVisibility(0);
    paramHolder.g.setText(paramInt);
    VideoProgressView localVideoProgressView = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    localVideoProgressView.b(localStringBuilder.toString());
    paramHolder.c.setVisibility(0);
    paramHolder.c.setImageResource(2130851866);
    paramHolder.c.setDrawStatus(3);
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, View paramView, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    } else {
      localMessageForShortVideo = null;
    }
    if (localMessageForShortVideo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgForShortVideo.msgTailType=");
      localStringBuilder.append(localMessageForShortVideo.msgTailType);
      QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    if ((ShortVideoMsgTailHelper.a(this.e, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
    {
      if (paramHolder.u == null)
      {
        paramHolder.u = new TextView(this.e);
        paramHolder.u.setBackgroundResource(2130843655);
        paramHolder.u.setTextSize(1, 12.0F);
        paramHolder.u.setTextColor(this.e.getResources().getColor(2131168464));
        paramHolder.u.setText(ShortVideoMsgTailHelper.c(this.e, localMessageForShortVideo.msgTailType));
        paramHolder.u.setSingleLine();
        paramHolder.u.setGravity(16);
        paramHolder.u.setPadding(DisplayUtil.a(this.e, 5.0F), 0, DisplayUtil.a(this.e, 5.0F), 0);
        paramHolder.u.setOnClickListener(this.J);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.addRule(3, 2131430578);
        paramChatMessage.addRule(5, 2131430578);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.u, paramChatMessage);
        }
      }
      paramView = (RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams();
      if (localMessageForShortVideo.isSend()) {
        paramView.leftMargin = BaseChatItemLayout.getBubblePaddingAlignError();
      } else {
        paramView.leftMargin = BaseChatItemLayout.getBubblePaddingAlignHead();
      }
      paramHolder.u.setTag(localMessageForShortVideo);
      paramHolder.u.setVisibility(0);
      return;
    }
    if (paramHolder.u != null) {
      paramHolder.u.setVisibility(8);
    }
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, msg.uniseq = ");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    paramString = ShortVideoUtils.getThumbUrl(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if ((QLog.isColorLevel()) && (paramHolder.b != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, holder.d.getURL()=");
      ((StringBuilder)localObject).append(paramHolder.b.getURL());
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    if ((paramHolder.b != null) && (paramHolder.b.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramHolder.a.setCoverDrawable(paramHolder.b);
        return;
      }
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramHolder.b);
      return;
    }
    Object localObject = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, (Drawable)localObject, (Drawable)localObject);
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    paramHolder.a.showCover(paramString);
    paramHolder.b = paramString;
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramHolder.q;
    int i = localMessageForShortVideo.videoFileStatus;
    long l;
    if (paramHolder.a != null) {
      l = paramHolder.a.getCurPlayingPos();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("click ppv, msg.uniseq:");
      localStringBuilder.append(localMessageForShortVideo.uniseq);
      localStringBuilder.append(",fileType: ");
      localStringBuilder.append(SVUtils.a(localMessageForShortVideo.fileType));
      localStringBuilder.append(", fileStatus:");
      localStringBuilder.append(SVUtils.b(i));
      localStringBuilder.append(", playPosition:");
      localStringBuilder.append(l);
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("......click ppv, msg.uniseq:");
    ((StringBuilder)localObject).append(localMessageForShortVideo.uniseq);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = SVUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, (String)localObject, paramHolder, l, paramBoolean);
    } else {
      b(localMessageForShortVideo, localStringBuilder, i, (String)localObject, paramHolder, l, paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramHolder != null) && (paramHolder.j != null))
    {
      if (paramBoolean) {
        b(paramHolder, false, null);
      }
      paramHolder.j.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playShortVideo, msg.uniseq = ");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      ((StringBuilder)localObject).append(" , getAIOState() = ");
      ((StringBuilder)localObject).append(g());
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playShortVideo, thumbPath = ");
      if (paramString2 != null) {
        localObject = paramString2;
      } else {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    Object localObject = new VideoPlayParam();
    ((VideoPlayParam)localObject).mSceneId = 101;
    ((VideoPlayParam)localObject).mSceneName = SceneID.getSceneStr(101);
    int i = 1;
    ((VideoPlayParam)localObject).mIsMute = true;
    ((VideoPlayParam)localObject).mCallback = new ShortVideoItemBuilder.12(this, (VideoPlayParam)localObject);
    ((VideoPlayParam)localObject).mIsLocal = paramBoolean;
    ((VideoPlayParam)localObject).mIsLoop = true;
    ((VideoPlayParam)localObject).mVideoPath = paramString1;
    ((VideoPlayParam)localObject).mSavePath = SVUtils.a(paramMessageForShortVideo, "mp4");
    paramString1 = new StringBuilder();
    paramString1.append(paramMessageForShortVideo.md5);
    paramString1.append(paramMessageForShortVideo.uniseq);
    ((VideoPlayParam)localObject).mFileID = paramString1.toString();
    ((VideoPlayParam)localObject).mUrls = paramArrayOfString;
    ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
    if (paramMessageForShortVideo.videoFileTime > 8) {
      i = 0;
    }
    if (i == 0)
    {
      ((VideoPlayParam)localObject).mVideoFileTimeMs = (paramMessageForShortVideo.videoFileTime * 1000);
      ((VideoPlayParam)localObject).mMaxPlayTimeMs = 8000L;
    }
    paramHolder.a.setVideoParam((VideoPlayParam)localObject);
    paramMessageForShortVideo = a(paramInt1, paramInt2);
    if (TextUtils.isEmpty(paramString2))
    {
      paramHolder.a.setCoverDrawable(paramMessageForShortVideo);
    }
    else
    {
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramHolder.a.setCoverDrawable(paramMessageForShortVideo);
      paramHolder.b = paramMessageForShortVideo;
    }
    if (m()) {
      paramHolder.a.play();
    }
    G.add(paramHolder.a);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, Context paramContext, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G)) {
      paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((BaseActivity)paramContext).getChatFragment().k().aR());
    }
    if (paramSessionInfo.a == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.c);
    }
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    if (paramMessageForReplyText != null) {
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
    paramBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
        paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
      }
    }
    paramQQAppInterface = (MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    boolean bool = paramQQAppInterface.b(paramMessageForShortVideo);
    paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
    if (bool)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.a(paramMessageForShortVideo));
      if ((paramQQAppInterface != null) && (paramQQAppInterface.f == 1)) {
        paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramQQAppInterface.e);
      }
    }
    paramQQAppInterface = C;
    if (paramQQAppInterface != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", paramQQAppInterface);
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    paramBundle.putString("uin", paramSessionInfo.b);
    paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.d, this.f.a, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    int i;
    if ((!((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).isInPhoneCall(paramContext)) && (!paramQQAppInterface.isVideoChatting()))
    {
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.a, paramSessionInfo.b, 1001);
      }
      if (MediaPlayerManager.a(paramQQAppInterface).g()) {
        MediaPlayerManager.a(paramQQAppInterface).a(true);
      }
      a(paramQQAppInterface, paramMessageForShortVideo, paramContext, paramSessionInfo, paramBundle, paramMessageForReplyText);
      if ((paramContext instanceof SplashActivity))
      {
        i = 1;
      }
      else
      {
        if ((paramContext instanceof ChatHistoryActivity)) {}
        while (((paramContext instanceof PublicFragmentActivity)) && ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)))
        {
          i = 2;
          break;
        }
        i = -1;
      }
      str = paramMessageForShortVideo.selfuin;
      paramMessageForReplyText = str;
      if (!paramMessageForShortVideo.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramMessageForReplyText = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramMessageForReplyText = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramMessageForReplyText)
    {
      for (;;)
      {
        paramMessageForReplyText = str;
      }
    }
    if ((paramMessageForShortVideo.istroop == 0) && (Utils.c(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      PeakUtils.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, i);
    }
    else
    {
      PeakUtils.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, i);
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.a, paramSessionInfo.b, 1001);
    }
    return;
    QQToast.makeText(paramContext, 0, 2131916633, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(PeakUtils.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleVideoCompressSucceed, seq = ");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = VideoCompressProcessor.a().b(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localObject != null))
    {
      if (((VideoCompressProcessor.CompressTask)localObject).b() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.makeText(paramContext, paramContext.getResources().getString(2131916613), 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
          if ((paramContext instanceof BaseActivity))
          {
            paramContext = ((BaseActivity)paramContext).getChatFragment();
            if (paramContext != null)
            {
              paramContext = paramContext.k();
              if (paramContext != null) {
                paramContext.a(false, false);
              }
            }
          }
        }
        ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        return;
      }
      paramContext = y;
      if ((paramContext != null) && (paramContext.get() == paramMessageForShortVideo.uniseq))
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("CompressTask onPostExecute sRevokeMsRecord==mr.uniseq==");
          paramQQAppInterface.append(paramMessageForShortVideo.uniseq);
          paramQQAppInterface.append(", just return");
          QLog.i("ShortVideoItemBuilder", 2, paramQQAppInterface.toString());
        }
        return;
      }
      paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      paramContext = SVBusiUtil.a(0, 0);
      paramMessageForShortVideo = ShortVideoBusiManager.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.m = ((VideoCompressProcessor.CompressTask)localObject).c();
        paramMessageForShortVideo.w = false;
        paramContext.a(paramMessageForShortVideo);
      }
      ShortVideoBusiManager.a(paramContext, paramQQAppInterface);
      y.set(-1L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ShortVideoItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9))
      {
        if (paramInt == 5002)
        {
          a(paramHolder, 2131915835);
          QQToast.makeText(this.e, 2131916640, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
          paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
          return;
        }
        b(paramHolder);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
        return;
      }
      paramString = new StringBuilder();
      paramString.append(" fileType:video, =");
      paramString.append(SVUtils.a(paramMessageForShortVideo.fileType));
      paramStringBuilder.append(paramString.toString());
      if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
      {
        b(paramHolder);
        QQToast.makeText(this.e, 2131916641, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result:toast recv_error ");
        return;
      }
      if (paramInt == 5001)
      {
        b(paramHolder);
        QQToast.makeText(this.e, 2131916639, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result: toast file_unsafe ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramHolder, 2131915835);
        QQToast.makeText(this.e, 2131916640, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result: toast file_expired ");
        return;
      }
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" status:other, result: download ");
      return;
    }
    b(paramHolder);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private void a(FileSaveResult paramFileSaveResult, String paramString, ShortVideoItemBuilder.Holder paramHolder, ISingleFileSaveCallBack paramISingleFileSaveCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramFileSaveResult != null)
    {
      if (paramFileSaveResult.b == 0) {
        FileSaveToastUtils.a(this.e);
      } else {
        FileSaveToastUtils.b(this.e);
      }
      paramFileSaveResult.g.b(paramISingleFileSaveCallBack);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramFileSaveResult = new StringBuilder();
      paramFileSaveResult.append(paramHolder.q.frienduin);
      paramFileSaveResult.append(paramHolder.q.uniseq);
      if (paramString.equals(paramFileSaveResult.toString())) {
        paramHolder.c.setVisibility(8);
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StringBuilder paramStringBuilder, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = ((ShortVideoDownloadProcessor)paramIHttpCommunicatorListener).isPause();
    paramIHttpCommunicatorListener = new StringBuilder();
    paramIHttpCommunicatorListener.append(" processor:download, pause:");
    paramIHttpCommunicatorListener.append(bool);
    paramStringBuilder.append(paramIHttpCommunicatorListener.toString());
    if (bool)
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" pause:true, result:download ");
      return;
    }
    if (paramInt == 2005)
    {
      b(paramHolder);
      QQToast.makeText(this.e, 2131916641, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
      return;
    }
    if ((paramInt != 2002) && (paramInt != 2000) && (paramInt != 2008) && (paramInt != 2001))
    {
      if (paramInt == 5001)
      {
        b(paramHolder);
        QQToast.makeText(this.e, 2131916639, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramHolder, 2131915835);
        QQToast.makeText(this.e, 2131916640, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" status:file_expired, result:toast expired ");
        return;
      }
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" status:other, result:download ");
      return;
    }
    b(paramHolder);
  }
  
  private void a(StringBuilder paramStringBuilder, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:true ");
    if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9))
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result: play ");
      return;
    }
    paramStringBuilder.append(" fileType:video ");
    IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if (localIHttpCommunicatorListener != null)
    {
      if ((!IShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)) && (!IShortVideoForwardProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        if (ShortVideoDownloadProcessor.class.isInstance(localIHttpCommunicatorListener)) {
          paramStringBuilder.append(" processor:not up of forward, result: none");
        }
      }
      else
      {
        if (paramInt == 1005)
        {
          b(paramHolder);
          paramHolder.j.setFailedIconVisable(true, this);
          paramStringBuilder.append(" status:send_error, result:show send error ");
          return;
        }
        if ((paramInt != 1002) && (paramInt != 1001))
        {
          b(paramHolder);
          a(paramMessageForShortVideo, paramLong, paramBoolean);
          paramStringBuilder.append(" status:other, result:play ");
          return;
        }
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:process or start, result:pauseSending ");
      }
    }
    else
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" processor:null, result:play ");
    }
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localEmptyDrawable, localEmptyDrawable);
        localURLDrawable.setTag(URLDrawableDecodeHandler.b(0, 0, paramInt3));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("ShortVideoItemBuilder", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void b(ShortVideoItemBuilder.Holder paramHolder, View paramView, ChatMessage paramChatMessage)
  {
    if (f(paramHolder))
    {
      if (paramHolder.v == null)
      {
        paramHolder.v = new ImageView(this.e);
        paramHolder.v.setImageResource(2130838287);
        paramHolder.v.setId(2131430598);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = AIOUtils.b(16.0F, this.e.getResources());
        paramChatMessage.addRule(8, 2131430578);
        paramChatMessage.addRule(0, 2131430578);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.v, paramChatMessage);
        }
      }
      b(paramHolder, true, this);
      return;
    }
    b(paramHolder, false, null);
  }
  
  private void b(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramHolder.v != null)
      {
        paramHolder.v.setVisibility(0);
        paramHolder.v.setOnClickListener(paramOnClickListener);
      }
    }
    else if (paramHolder.v != null)
    {
      paramHolder.v.setVisibility(8);
      paramHolder.v.setOnClickListener(null);
    }
  }
  
  public static void b(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("handleVideoCompressFailure, seq = ");
      paramContext.append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, paramContext.toString());
    }
    if (paramQQAppInterface != null)
    {
      paramMessageForShortVideo.videoFileStatus = 1005;
      paramMessageForShortVideo.serial();
      paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ShortVideoItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName))
    {
      a(paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
      return;
    }
    b(paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
  }
  
  private void b(StringBuilder paramStringBuilder, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9))
      {
        b(paramHolder);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" fileType:not video, result:download ");
        return;
      }
      Object localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (localObject != null)
      {
        if (ShortVideoDownloadProcessor.class.isInstance(localObject))
        {
          a((IHttpCommunicatorListener)localObject, paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
          return;
        }
        if (IShortVideoUploadProcessor.class.isInstance(localObject))
        {
          b(paramHolder);
          paramHolder.j.setFailedIconVisable(true, this);
          QQToast.makeText(this.e, 2131916646, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
          paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
          return;
        }
        if (IShortVideoForwardProcessor.class.isInstance(localObject))
        {
          boolean bool = ((BaseTransProcessor)localObject).isPause();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" processor:forward, pause:");
          ((StringBuilder)localObject).append(bool);
          paramStringBuilder.append(((StringBuilder)localObject).toString());
          if (bool)
          {
            a(paramHolder, 10, false);
            c(paramMessageForShortVideo, paramHolder);
            paramStringBuilder.append(" pause:true, result:reforward ");
            return;
          }
          if (paramInt == 5001)
          {
            b(paramHolder);
            paramHolder.j.setFailedIconVisable(true, this);
            QQToast.makeText(this.e, 2131916615, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
            return;
          }
          if (paramInt == 5002)
          {
            a(paramHolder, 2131915835);
            paramHolder.j.setFailedIconVisable(true, this);
            QQToast.makeText(this.e, 2131916616, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            paramStringBuilder.append(" status:expired, result:toast expired ");
            return;
          }
          if (paramInt == 1005)
          {
            b(paramHolder);
            paramHolder.j.setFailedIconVisable(true, this);
            paramStringBuilder.append(" status:send_error, result:show send_error ");
            return;
          }
          if ((paramInt != 1002) && (paramInt != 1001))
          {
            b(paramHolder);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          a(paramMessageForShortVideo, 0L, paramBoolean);
          return;
        }
        paramStringBuilder.append(" processor:not down or forward or up, result:none ");
        return;
      }
      b(paramHolder);
      paramStringBuilder.append(" processor:null, result:download ");
      a(paramMessageForShortVideo, 0L, paramBoolean);
      return;
    }
    b(paramHolder);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(long paramLong)
  {
    return ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).isMediaMsgInQueue(this.f.b, paramLong);
  }
  
  private ShortVideoItemBuilder.Holder c(long paramLong)
  {
    Object localObject = this.A;
    if ((localObject != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, ((ListView)localObject).getAdapter());
      int j = this.A.getHeaderViewsCount();
      int k = this.A.getFirstVisiblePosition();
      int m = this.A.getLastVisiblePosition();
      if (i > -1)
      {
        localObject = AIOUtils.a(this.A, i);
        if (localObject != null)
        {
          localObject = AIOUtils.b((View)localObject);
          if ((localObject != null) && ((localObject instanceof ShortVideoItemBuilder.Holder))) {
            return (ShortVideoItemBuilder.Holder)localObject;
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", view = null");
          QLog.w("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", firstVisblePosi=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",lastVisblePosi=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(",headerCount=");
          ((StringBuilder)localObject).append(j);
          QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", posi<= -1");
        QLog.w("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private boolean c(ShortVideoItemBuilder.Holder paramHolder)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = this.z;
    if (localMultiRichMediaSaveManager != null)
    {
      paramHolder = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramHolder.q));
      return (paramHolder != null) && (paramHolder.f == 1) && (!paramHolder.a);
    }
    return false;
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    Object localObject = this.z;
    if ((localObject != null) && (paramMessageForShortVideo != null) && (paramHolder != null))
    {
      paramMessageForShortVideo = ((MultiRichMediaSaveManager)localObject).a(paramMessageForShortVideo);
      localObject = this.z.a(paramMessageForShortVideo);
      if (localObject != null)
      {
        int i = ((FileSaveResult)localObject).f;
        int k = 1;
        if (i == 1)
        {
          if (((FileSaveResult)localObject).e < 0) {
            i = 0;
          } else if (((FileSaveResult)localObject).e > 100) {
            i = 100;
          } else {
            i = ((FileSaveResult)localObject).e;
          }
          int j = k;
          if (paramHolder.c.getVisibility() != 8) {
            if ((paramHolder.c.getVisibility() == 0) && (paramHolder.c.g == 2)) {
              j = k;
            } else {
              j = 0;
            }
          }
          if ((i < 100) && (j != 0) && (!((FileSaveResult)localObject).a) && (((FileSaveResult)localObject).g != null))
          {
            ((FileSaveResult)localObject).g.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramHolder));
            this.z.a(paramMessageForShortVideo, (FileSaveResult)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
            }
            a(paramHolder, i, false);
            paramHolder.c.setVisibility(0);
          }
        }
      }
    }
  }
  
  private boolean d(ShortVideoItemBuilder.Holder paramHolder)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = this.z;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMultiRichMediaSaveManager != null)
    {
      paramHolder = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramHolder.q));
      if ((paramHolder != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramHolder != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void e(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (f(paramHolder))
    {
      if (paramHolder.v == null)
      {
        l();
        return;
      }
      if (paramHolder.v.getVisibility() != 0) {
        b(paramHolder, true, this);
      }
    }
  }
  
  private boolean f(ShortVideoItemBuilder.Holder paramHolder)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramHolder.q instanceof MessageForShortVideo)) {
      localMessageForShortVideo = (MessageForShortVideo)paramHolder.q;
    } else {
      localMessageForShortVideo = null;
    }
    boolean bool2 = false;
    if (localMessageForShortVideo == null) {
      return false;
    }
    int i;
    if ((localMessageForShortVideo.videoFileStatus != 998) && (localMessageForShortVideo.videoFileStatus != 1002) && (localMessageForShortVideo.videoFileStatus != 1001)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((!localMessageForShortVideo.isMultiMsg) && (localMessageForShortVideo.uiOperatorFlag != 2) && (localMessageForShortVideo.busiType == 0) && (localMessageForShortVideo.isSendFromLocal()) && (!paramHolder.j.b())) {
      j = 1;
    } else {
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("needShowPauseIcon seq:");
      paramHolder.append(localMessageForShortVideo.uniseq);
      paramHolder.append(", videostatus:");
      paramHolder.append(localMessageForShortVideo.videoFileStatus);
      paramHolder.append(", iconshow:");
      if ((i != 0) && (j != 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramHolder.append(bool1);
      QLog.i("ShortVideoItemBuilder", 2, paramHolder.toString());
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 21) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean f(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.videoFileStatus == 998) && (VideoCompressProcessor.a().b(paramMessageForShortVideo.uniseq) == null))
    {
      paramMessageForShortVideo = ShortVideoUtils.getShortVideoCompressPath(paramMessageForShortVideo.videoFileName, "mp4");
      if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
        FileUtils.deleteFile(paramMessageForShortVideo);
      }
      return true;
    }
    return false;
  }
  
  private boolean g(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  public static void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "pauseAllVideo");
    }
    Object localObject = G;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  private boolean h(MessageForShortVideo paramMessageForShortVideo)
  {
    return AIOVideoPlayController.a().a(this.e, 1, paramMessageForShortVideo.istroop);
  }
  
  public static void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "resumeAllVideo");
    }
    Object localObject = G;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.resume();
        }
      }
    }
  }
  
  private boolean i(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) && ((!paramMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5))))
    {
      String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      paramMessageForShortVideo = SVUtils.a(paramMessageForShortVideo, "mp4");
      if ((FileUtils.fileExistsAndNotEmpty(str)) && (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))) {
        return true;
      }
    }
    return false;
  }
  
  public static void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "releaseAllVideo");
    }
    Object localObject = G;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          G.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void l()
  {
    try
    {
      if (this.e != null)
      {
        Object localObject = ((BaseActivity)this.e).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean m()
  {
    if ((this.q != null) && ((this.q instanceof ChatXListView))) {
      return ((ChatXListView)this.q).a();
    }
    return true;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.E = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((ShortVideoItemBuilder.Holder)paramView.getTag(), paramView, paramChatMessage);
    b((ShortVideoItemBuilder.Holder)paramView.getTag(), paramView, paramChatMessage);
    if (v) {}
    try
    {
      paramChatMessage = (ShortVideoItemBuilder.Holder)paramView.getTag();
      paramChatMessage.r.append(paramChatMessage.e.getText());
      paramChatMessage.r.append(this.E.videoFileTime);
      paramChatMessage.r.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.r.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append("getBubbleView, message.uniseq = ");
      paramBaseChatItemLayout.append(paramChatMessage.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, paramBaseChatItemLayout.toString());
    }
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)paramViewHolder;
    Resources localResources = this.e.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool = paramBaseChatItemLayout.isSend();
    float f;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.e);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.createCropBubbleView(this.e, paramBaseChatItemLayout.uniseq, null, bool);
      paramView.setId(2131427939);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131911437));
      paramView.setDrawTri(QQTheme.isNowSimpleUI() ^ true);
      if (QQTheme.isNowSimpleUI()) {
        f = 8.0F;
      } else {
        f = 15.0F;
      }
      paramView.setRadius(f);
      paramViewHolder.addView(paramView);
      G.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.e);
      localVideoProgressView.setId(2131430626);
      paramViewHolder.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.e, null, 0);
      i = AIOUtils.b(50.0F, this.e.getResources());
      Object localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new LinearLayout(this.e);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.e);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131430624);
      ((TextView)localObject1).setVisibility(4);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(this.e);
      ((RelativeLayout)localObject2).setBackgroundResource(SimpleModeHelper.c());
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131427939);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.e);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.e);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.e);
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((TextView)localObject5).setTextColor(-1);
      ((TextView)localObject5).setGravity(17);
      ((TextView)localObject5).setText(2131916634);
      ((TextView)localObject5).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.b(14.0F, localResources);
      localLayoutParams.addRule(14);
      paramViewHolder.addView((View)localObject5, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      localHolder.s = localProgressBar;
      localHolder.d = ((RelativeLayout)localObject2);
      localHolder.e = ((TextView)localObject3);
      localHolder.f = ((TextView)localObject4);
      localHolder.c = localVideoProgressView;
      localHolder.g = ((TextView)localObject1);
      localHolder.t = ((TextView)localObject5);
      localHolder.a = paramView;
    }
    else
    {
      paramViewHolder = paramView;
    }
    localHolder.a.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localHolder.a.mIsSend != bool)
    {
      localHolder.a.mIsSend = bool;
      localHolder.a.invalidate();
    }
    localHolder.c.setOnClickListener(this);
    localHolder.c.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.c.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView = localHolder.c;
    if (QQTheme.isNowSimpleUI()) {
      f = 8.0F;
    } else {
      f = 15.0F;
    }
    paramView.setRadius(f, true);
    localHolder.c.setShowCorner(QQTheme.isNowSimpleUI() ^ true);
    localHolder.c.setSharpCornerCor(BubbleImageView.d);
    localHolder.c.setCornerDirection(bool);
    paramView = localHolder.c;
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramChatMessage.frienduin);
    paramOnLongClickAndTouchListener.append(paramChatMessage.uniseq);
    paramView.a(paramOnLongClickAndTouchListener.toString());
    paramChatMessage = (RelativeLayout.LayoutParams)localHolder.d.getLayoutParams();
    if (bool)
    {
      paramChatMessage.leftMargin = 0;
      paramChatMessage.rightMargin = AIOUtils.b(localHolder.a.getTriaWidth(), localResources);
    }
    else
    {
      paramChatMessage.leftMargin = AIOUtils.b(localHolder.a.getTriaWidth(), localResources);
      paramChatMessage.rightMargin = 0;
    }
    paramChatMessage = (RelativeLayout.LayoutParams)localHolder.t.getLayoutParams();
    if (bool) {
      paramChatMessage.rightMargin = (AIOUtils.b(localHolder.a.getTriaWidth(), localResources) / 2);
    } else {
      paramChatMessage.leftMargin = (AIOUtils.b(localHolder.a.getTriaWidth(), localResources) / 2);
    }
    localHolder.f.setText(ShortVideoUtils.stringForTime(paramBaseChatItemLayout.videoFileTime * 1000));
    localHolder.j.setMiniAioShieldItemTouchListener(this);
    paramChatMessage = SVUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
    paramView = ShortVideoUtils.adjustSize(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
    int i = paramView[0];
    int j = paramView[1];
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getBubbleView, msg.uniseq = ");
      paramView.append(paramBaseChatItemLayout.uniseq);
      paramView.append(" msg.thumbWidth = ");
      paramView.append(paramBaseChatItemLayout.thumbWidth);
      paramView.append(", msg.thumbHeight = ");
      paramView.append(paramBaseChatItemLayout.thumbHeight);
      paramView.append(", adjustWidth = ");
      paramView.append(i);
      paramView.append(", adjustHeight = ");
      paramView.append(j);
      QLog.d("ShortVideoItemBuilder", 2, paramView.toString());
    }
    paramView = localHolder.a.getLayoutParams();
    if (paramView == null)
    {
      paramView = new RelativeLayout.LayoutParams(i, j);
      localHolder.a.setLayoutParams(paramView);
    }
    else if ((paramView.width != i) || (paramView.height != j))
    {
      paramView.width = i;
      paramView.height = j;
      localHolder.a.setLayoutParams(paramView);
    }
    paramView = localHolder.c.getLayoutParams();
    if (paramView == null)
    {
      paramView = new LinearLayout.LayoutParams(i, j);
      localHolder.c.setLayoutParams(paramView);
    }
    else if ((paramView.width != i) || (paramView.height != j))
    {
      paramView.width = i;
      paramView.height = j;
      localHolder.c.setLayoutParams(paramView);
    }
    if (SVBusiUtil.b)
    {
      SVBusiUtil.a = System.currentTimeMillis();
      SVBusiUtil.b = false;
    }
    paramView = a(i, j);
    b(localHolder);
    d(paramBaseChatItemLayout, localHolder);
    if ((paramBaseChatItemLayout.md5 == null) && (!paramBaseChatItemLayout.checkIsHotVideo()) && (!paramBaseChatItemLayout.isCancelStatus()))
    {
      a(paramBaseChatItemLayout, localHolder, paramChatMessage, i, j);
      return paramViewHolder;
    }
    localHolder.g.setVisibility(8);
    localHolder.e.setText(ShortVideoUtils.stringForFileSize(this.e, paramBaseChatItemLayout.videoFileSize));
    localHolder.t.setVisibility(8);
    if (!a(paramChatMessage, paramBaseChatItemLayout, localHolder, i, j, paramView)) {
      return paramViewHolder;
    }
    a(paramBaseChatItemLayout, localHolder);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoItemBuilder.Holder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)paramBaseHolder;
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("getMenuItem, msg.uniseq:");
      paramChatMessage.append(localMessageForShortVideo.uniseq);
      paramChatMessage.append(",fileType===>");
      paramChatMessage.append(SVUtils.a(localMessageForShortVideo.fileType));
      paramChatMessage.append(" ===> fileStatus:");
      paramChatMessage.append(SVUtils.b(localMessageForShortVideo.videoFileStatus));
      QLog.d("ShortVideoItemBuilder", 2, paramChatMessage.toString());
    }
    a(paramQQCustomMenu, this.e, 2131439081, null, null);
    boolean bool3 = false;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
      {
        paramChatMessage = "";
        i = 1;
        break label203;
      }
      paramBaseHolder = new StringBuilder();
      paramBaseHolder.append("thumbFilePath=");
      paramBaseHolder.append(paramChatMessage);
      paramBaseHolder.append(" , not exits.");
      paramChatMessage = paramBaseHolder.toString();
    }
    else
    {
      paramChatMessage = " msg == null or md5 is empty.";
    }
    int i = 0;
    label203:
    paramBaseHolder = paramChatMessage;
    if (i != 0) {
      if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1")))
      {
        boolean bool4 = localMessageForShortVideo.checkForward();
        if (localHolder.c != null)
        {
          paramBaseHolder = localHolder.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localHolder.q.frienduin);
          localStringBuilder.append(localHolder.q.uniseq);
          if (paramBaseHolder.c(localStringBuilder.toString()))
          {
            bool1 = true;
            break label321;
          }
        }
        boolean bool1 = false;
        label321:
        boolean bool2 = bool3;
        if (localHolder.j.ah != null)
        {
          bool2 = bool3;
          if (localHolder.j.ah.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((bool4) && (!bool1) && (!bool2))
        {
          paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
          paramBaseHolder = new StringBuilder();
          paramBaseHolder.append(paramChatMessage);
          paramBaseHolder.append("inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.");
          paramChatMessage = paramBaseHolder.toString();
        }
        else
        {
          paramBaseHolder = new StringBuilder();
          paramBaseHolder.append(paramChatMessage);
          paramBaseHolder.append("progeressBarShowing=");
          paramBaseHolder.append(bool1);
          paramBaseHolder.append(", errorIconShowing=");
          paramBaseHolder.append(bool2);
          paramChatMessage = paramBaseHolder.toString();
        }
        paramBaseHolder = paramChatMessage;
      }
      else
      {
        paramBaseHolder = " not inDPCWhiteList.";
      }
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("getMenuItem: ");
      paramChatMessage.append(paramBaseHolder);
      QLog.d("ShortVideoItemBuilder", 2, paramChatMessage.toString());
    }
    if ((localMessageForShortVideo != null) && (FileUtils.fileExistsAndNotEmpty(SVUtils.a(localMessageForShortVideo, "mp4")))) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    this.w = true;
    return paramQQCustomMenu;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForShortVideo)) {
      return;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    this.x = paramInt;
    if (paramInt == 2131431695)
    {
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    }
    if (paramInt == 2131433636)
    {
      c(localMessageForShortVideo);
      if (paramChatMessage.isMultiMsg) {
        ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
      }
    }
    else if (paramInt == 2131432813)
    {
      if (i(localMessageForShortVideo))
      {
        QfavBuilder.a(localMessageForShortVideo).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
        QfavReport.a(this.d, 3, 0, paramChatMessage.istroop);
        QfavReport.a(this.d, 6, 5);
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.d, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
        }
      }
    }
    else
    {
      if (paramInt == 2131438943)
      {
        e(localMessageForShortVideo);
        return;
      }
      if (paramInt == 2131439081)
      {
        paramContext = c(paramChatMessage.uniseq);
        if (paramContext == null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("onMenuItemClicked(), mute_play, holder == null, message.uniseq = ");
            paramContext.append(paramChatMessage.uniseq);
            QLog.e("ShortVideoItemBuilder", 2, paramContext.toString());
          }
        }
        else
        {
          a(paramContext, true);
          ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
        }
      }
      else
      {
        super.a(paramInt, paramContext, paramChatMessage);
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.e.getResources().getDimensionPixelSize(2131296618);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, i, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  protected void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (c(paramHolder))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
      return;
    }
    if (b(paramHolder.q.uniseq))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("disProgress fail...video order sending! ");
        ((StringBuilder)localObject).append(paramHolder.q.uniseq);
        QLog.i("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!((VideoProgressView)localObject).c(localStringBuilder.toString()))
    {
      paramHolder.c.setVisibility(8);
      return;
    }
    paramHolder.c.setAnimRunnableListener(new ShortVideoItemBuilder.2(this, paramHolder));
  }
  
  protected void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    VideoProgressView localVideoProgressView;
    StringBuilder localStringBuilder;
    if (paramInt < 100)
    {
      paramHolder.c.setDrawStatus(1);
      localVideoProgressView = paramHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramHolder.q.frienduin);
      localStringBuilder.append(paramHolder.q.uniseq);
      localVideoProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    }
    else
    {
      paramHolder.c.setDrawStatus(1);
      localVideoProgressView = paramHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramHolder.q.frienduin);
      localStringBuilder.append(paramHolder.q.uniseq);
      localVideoProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setVideoCompressStatus(false);
    paramHolder.g.setVisibility(8);
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramHolder);
    if (d(paramHolder)) {
      return;
    }
    paramHolder = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty(paramHolder))
    {
      ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, this.a);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
      localShortVideoDownloadInfo.p = paramHolder;
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008))
      {
        if (paramMessageForShortVideo.istroop == 3000) {
          localShortVideoDownloadInfo.q = 1006;
        } else if (paramMessageForShortVideo.istroop == 1) {
          localShortVideoDownloadInfo.q = 1004;
        }
      }
      else {
        localShortVideoDownloadInfo.q = 1002;
      }
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      ShortVideoBusiManager.a(localShortVideoReq, this.d);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    boolean bool1 = TextUtils.isEmpty(paramMessageForShortVideo.md5);
    boolean bool2 = false;
    if ((!bool1) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str = SVUtils.a(paramMessageForShortVideo, "mp4");
      boolean bool3 = NetworkUtils.isMobileConnected(this.e);
      bool1 = bool2;
      if (SVBusiUtil.a != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - SVBusiUtil.a < 300000L) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlayVideo isConfirmed=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" allowPlayInXGTime=");
        localStringBuilder.append(SVBusiUtil.a);
        localStringBuilder.append(" isXGConnected = ");
        localStringBuilder.append(bool3);
        QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      if ((bool3) && (!bool1) && ((!FileUtils.fileExists(str)) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileSize >= 1048576))
      {
        if (!FreeWifiHelper.a((Activity)this.e, 3, new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
          break label378;
        }
        str = this.e.getString(2131915395);
        this.D = DialogUtil.a(this.e, 230, this.e.getString(2131915398), str, this.e.getString(2131915396), this.e.getString(2131915397), new ShortVideoItemBuilder.5(this, paramMessageForShortVideo, paramLong, paramBoolean), new ShortVideoItemBuilder.6(this));
        paramMessageForShortVideo = CUOpenCardGuideMng.a(this.e, this.d, 1, str);
        if ((paramMessageForShortVideo instanceof SpannableString)) {
          this.D.setMessageWithoutAutoLink(paramMessageForShortVideo);
        }
      }
    }
    try
    {
      this.D.show();
      return;
    }
    catch (Throwable paramMessageForShortVideo) {}
    b(paramMessageForShortVideo, paramLong, paramBoolean);
    ShortVideoUtils.reportVideoPlay(this.d, "0X8008E53", this.f, paramMessageForShortVideo, this.e);
    label378:
    return;
    QQToast.makeText(this.e, 2131916607, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
    return;
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBubbleView ，video no exits: sendFromLocal=");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.isSendFromLocal());
      ((StringBuilder)localObject).append("===>  fileType:");
      ((StringBuilder)localObject).append(SVUtils.a(paramMessageForShortVideo.fileType));
      ((StringBuilder)localObject).append(" ===> videoFileStatus:");
      ((StringBuilder)localObject).append(SVUtils.b(paramMessageForShortVideo.videoFileStatus));
      ((StringBuilder)localObject).append("===> videoFileProgress:");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.videoFileProgress);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 19) || (paramMessageForShortVideo.fileType == 20))
    {
      int i = paramMessageForShortVideo.videoFileStatus;
      if (i != 2001)
      {
        if (i != 2002)
        {
          if (i != 2004)
          {
            if (i != 5002)
            {
              switch (i)
              {
              default: 
                return;
              case 1004: 
                paramHolder.c.setVisibility(0);
                paramMessageForShortVideo = paramHolder.c;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(paramHolder.q.frienduin);
                ((StringBuilder)localObject).append(paramHolder.q.uniseq);
                paramMessageForShortVideo.b(((StringBuilder)localObject).toString());
                b(paramHolder);
                a(paramHolder, true, this);
                return;
              case 1003: 
                b(paramHolder);
                return;
              case 1002: 
                a((IHttpCommunicatorListener)localObject, paramHolder, paramMessageForShortVideo);
                return;
              }
              if (localObject == null)
              {
                paramHolder.j.setFailedIconVisable(true, this);
                b(paramHolder);
                if (QLog.isColorLevel())
                {
                  paramHolder = new StringBuilder();
                  paramHolder.append("getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:");
                  paramHolder.append(paramMessageForShortVideo.uniseq);
                  QLog.d("ShortVideoItemBuilder", 2, paramHolder.toString());
                }
              }
              else
              {
                a(paramHolder, ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10), false);
              }
            }
            else
            {
              a(paramHolder, 2131915835);
            }
          }
          else {
            b(paramHolder);
          }
        }
        else {
          b(paramHolder);
        }
      }
      else {
        b(paramHolder);
      }
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramHolder.e.setText("");
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
        if (paramMessageForShortVideo.videoFileStatus == 1005)
        {
          paramHolder.c.setDrawStatus(2);
          paramHolder.g.setVisibility(8);
          return;
        }
        paramHolder.c.setDrawStatus(1);
        paramHolder.s.setVisibility(8);
        paramHolder.t.setVisibility(8);
        paramHolder.g.setVisibility(8);
        paramHolder.c.setVisibility(0);
        if ((paramMessageForShortVideo.videoFileStatus != 998) || (f(paramMessageForShortVideo)))
        {
          paramHolder = new VideoCompressProcessor.CompressTask(this.d, this.e, paramMessageForShortVideo, this.F);
          VideoCompressProcessor.a().a(paramMessageForShortVideo.uniseq, paramHolder);
          if (QLog.isColorLevel())
          {
            paramHolder = new StringBuilder();
            paramHolder.append("getBubbleView(): msg.md5 == null, start compress task, id:");
            paramHolder.append(paramMessageForShortVideo.uniseq);
            QLog.d("ShortVideoItemBuilder", 2, paramHolder.toString());
          }
        }
        paramMessageForShortVideo = VideoCompressProcessor.a().b(paramMessageForShortVideo.uniseq);
        if (paramMessageForShortVideo != null) {
          paramMessageForShortVideo.a(this.F);
        }
      }
    }
  }
  
  public void a(FileMsg paramFileMsg, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramHolder);
    a(paramHolder);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleReceiveProcess, getAIOState() = ");
      ((StringBuilder)localObject1).append(g());
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    if (g() != 4) {
      return;
    }
    int i;
    if ((paramFileMsg.urls != null) && (h(paramMessageForShortVideo)) && (!d(paramHolder)) && (!g(paramMessageForShortVideo)))
    {
      localObject1 = paramFileMsg.urls;
      paramFileMsg = paramFileMsg.domain;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=");
        ((StringBuilder)localObject2).append(paramFileMsg);
        ((StringBuilder)localObject2).append(", videoUrls=");
        ((StringBuilder)localObject2).append(Arrays.toString((Object[])localObject1));
        QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      Object localObject3 = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      i = 0;
      int j = localObject3[0];
      int k = localObject3[1];
      while (i < 1)
      {
        if (!TextUtils.isEmpty(paramFileMsg))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localObject1[i]);
          ((StringBuilder)localObject3).append("&txhost=");
          ((StringBuilder)localObject3).append(paramFileMsg);
          localObject1[i] = ((StringBuilder)localObject3).toString();
        }
        i += 1;
      }
      a(paramHolder, false, paramMessageForShortVideo, null, (String[])localObject1, (String)localObject2, j, k);
      if ((paramMessageForShortVideo.checkIsHotVideo()) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB")))
      {
        AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8007EDB");
        ReportController.b(this.d, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      if (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X80077D9"))
      {
        i = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum(this.d, this.f.b, this.f.a);
        paramFileMsg = new JSONObject();
      }
    }
    try
    {
      paramFileMsg.put("uin", this.f.b);
      paramFileMsg.put("memNum", i);
      paramFileMsg.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label450:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(paramMessageForShortVideo.getMd5(), null, null, null, paramFileMsg), false);
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception paramHolder)
    {
      break label450;
    }
  }
  
  void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramIHttpCommunicatorListener == null)
    {
      paramHolder.j.setFailedIconVisable(true, this);
      b(paramHolder);
      if (QLog.isColorLevel())
      {
        paramIHttpCommunicatorListener = new StringBuilder();
        paramIHttpCommunicatorListener.append("getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:");
        paramIHttpCommunicatorListener.append(paramMessageForShortVideo.uniseq);
        QLog.d("ShortVideoItemBuilder", 2, paramIHttpCommunicatorListener.toString());
      }
    }
    else
    {
      if (((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).isMediaMsgInQueueNotHead(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq))
      {
        paramIHttpCommunicatorListener = paramHolder.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForShortVideo.frienduin);
        localStringBuilder.append(paramMessageForShortVideo.uniseq);
        paramIHttpCommunicatorListener.setAnimProgress(10, localStringBuilder.toString());
        paramHolder.c.setVisibility(0);
        return;
      }
      int j = paramMessageForShortVideo.videoFileProgress;
      int i = j;
      if ((paramIHttpCommunicatorListener instanceof IShortVideoUploadProcessor))
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        i = j;
        if (paramIHttpCommunicatorListener.getFileSize() != 0L) {
          i = (int)(paramIHttpCommunicatorListener.getTransferedSize() * 100L / paramIHttpCommunicatorListener.getFileSize());
        }
      }
      a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), false);
    }
  }
  
  void a(String paramString, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.checkIsHotVideo()) && (QLog.isColorLevel()))
    {
      paramMessageForShortVideo = "logHotVideoError ";
      if (paramString != null)
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("logHotVideoError ");
        paramMessageForShortVideo.append(paramString);
        paramMessageForShortVideo = paramMessageForShortVideo.toString();
      }
      QLog.d("ShortVideoItemBuilder", 2, paramMessageForShortVideo);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool1 = paramChatMessage.isMultiMsg;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus == 1005)
      {
        a("2131 msg.videoFileStatus == FileMsg.STATUS_SEND_ERROR", paramChatMessage);
        return true;
      }
      if (paramChatMessage.md5 == null) {
        return false;
      }
      int i;
      int k;
      if (paramChatMessage.uiOperatorFlag == 2)
      {
        if ((paramChatMessage.videoFileStatus != 5002) && (paramChatMessage.videoFileStatus != 5001)) {
          i = 0;
        } else {
          i = 1;
        }
        k = i;
        if (i != 0)
        {
          paramBaseChatItemLayout = new StringBuilder();
          paramBaseChatItemLayout.append("2145 forwardError = true msg.videoFileStatus is ");
          paramBaseChatItemLayout.append(paramChatMessage.videoFileStatus);
          a(paramBaseChatItemLayout.toString(), paramChatMessage);
          k = i;
        }
      }
      else
      {
        k = 0;
      }
      if ((paramChatMessage.videoFileStatus != 1005) && (paramChatMessage.extraflag != 32768))
      {
        i = 0;
      }
      else
      {
        a("2151 msg.extraflag == MessageRecordInfo.EXTRA_FLAG_SEND_FAIL sendError = true", paramChatMessage);
        i = 1;
      }
      int j = i;
      if (paramChatMessage.uiOperatorFlag == 1)
      {
        j = i;
        if (paramChatMessage.videoFileStatus == 1004)
        {
          a("2152 msg send cancel:", paramChatMessage);
          j = 1;
        }
      }
      if (d(paramChatMessage)) {
        j = 1;
      }
      if (k == 0)
      {
        bool1 = bool2;
        if (j == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    int i = paramMessageForShortVideo.videoFileStatus;
    int j = 1;
    if ((i != 998) && (paramMessageForShortVideo.videoFileStatus != 1001) && (paramMessageForShortVideo.videoFileStatus != 1002) && (paramMessageForShortVideo.videoFileStatus != 1004)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((h(paramMessageForShortVideo)) && ((!paramMessageForShortVideo.isSendFromLocal()) || (i == 0)) && (!d(paramHolder)) && (!g(paramMessageForShortVideo)) && (!b(paramMessageForShortVideo.uniseq)))
    {
      Object localObject1 = SVUtils.a(paramMessageForShortVideo, "mp4");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBubbleView(): videoPath = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new File((String)localObject1);
      boolean bool2;
      if (((File)localObject2).exists())
      {
        long l2 = ((File)localObject2).length();
        long l1;
        if (paramMessageForShortVideo.videoFileTime <= 8) {
          l1 = paramMessageForShortVideo.videoFileSize;
        } else {
          l1 = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).calculateVideoPartSize(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
        }
        boolean bool1;
        if (l2 < l1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("===> 1 video file  exits, downloadedSize =");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(", estimatedSize=");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(", needDownload=");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",videoFileTime=");
          ((StringBuilder)localObject2).append(paramMessageForShortVideo.videoFileTime);
          QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
          bool2 = bool1;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
        }
        bool2 = true;
      }
      if (bool2)
      {
        if ((NetworkUtil.isWifiConnected(this.e)) && (paramMessageForShortVideo.videoFileStatus != 5002))
        {
          localObject1 = SVBusiUtil.a(this.d, paramMessageForShortVideo, 2);
          if (localObject1 != null) {
            ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.d);
          }
        }
        else
        {
          paramHolder.c.setVisibility(0);
        }
        a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, true);
        return true;
      }
      a(paramHolder, true, paramMessageForShortVideo, (String)localObject1, null, paramString, paramInt1, paramInt2);
      if (paramMessageForShortVideo.videoFileTime <= 8) {
        paramInt1 = j;
      } else {
        paramInt1 = 0;
      }
      a(paramHolder);
      if (paramInt1 == 0) {
        paramHolder.t.setVisibility(0);
      }
      b(paramMessageForShortVideo);
      return false;
    }
    a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
    paramHolder.c.setVisibility(0);
    return true;
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString)) {
      return a(paramString, paramMessageForShortVideo, paramHolder, paramInt1, paramInt2);
    }
    if (((paramMessageForShortVideo.fileType == 7) || (paramMessageForShortVideo.fileType == 18) || (paramMessageForShortVideo.fileType == 16)) && (paramMessageForShortVideo.videoFileStatus == 5002))
    {
      paramHolder.t.setVisibility(8);
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramDrawable);
      a(paramHolder, 2131915835);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:");
        paramString.append(paramMessageForShortVideo.uniseq);
        QLog.d("ShortVideoItemBuilder", 2, paramString.toString());
        return true;
      }
    }
    else if ((paramMessageForShortVideo.extraflag != 32768) && (!d(paramHolder)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:");
        paramString.append(paramMessageForShortVideo.uniseq);
        QLog.d("ShortVideoItemBuilder", 2, paramString.toString());
      }
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramDrawable);
      paramString = SVBusiUtil.a(2, this.a);
      paramHolder = paramMessageForShortVideo.getDownloadInfo(paramString.b);
      paramHolder.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008))
      {
        if (paramMessageForShortVideo.istroop == 3000) {
          paramHolder.q = 1006;
        } else if (paramMessageForShortVideo.istroop == 1) {
          paramHolder.q = 1004;
        }
      }
      else {
        paramHolder.q = 1002;
      }
      paramHolder.r = 2;
      paramString.a(paramHolder);
      paramString.a(paramMessageForShortVideo);
      ShortVideoBusiManager.a(paramString, this.d);
    }
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (localMessageForShortVideo != null) {
      if (localMessageForShortVideo.isMultiMsg) {
        a(localQQCustomMenu, localMessageForShortVideo, paramView);
      } else {
        b(localQQCustomMenu, localMessageForShortVideo, paramView);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)paramBaseHolder;
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("getMenuItem, msg.uniseq:");
      paramChatMessage.append(localMessageForShortVideo.uniseq);
      paramChatMessage.append(",fileType===>");
      paramChatMessage.append(SVUtils.a(localMessageForShortVideo.fileType));
      paramChatMessage.append(" ===> fileStatus:");
      paramChatMessage.append(SVUtils.b(localMessageForShortVideo.videoFileStatus));
      QLog.d("ShortVideoItemBuilder", 2, paramChatMessage.toString());
    }
    a(paramQQCustomMenu, this.e, 2131439081, null, null);
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
      {
        paramChatMessage = "";
        i = 1;
        break label200;
      }
      paramBaseHolder = new StringBuilder();
      paramBaseHolder.append("thumbFilePath=");
      paramBaseHolder.append(paramChatMessage);
      paramBaseHolder.append(" , not exits.");
      paramChatMessage = paramBaseHolder.toString();
    }
    else
    {
      paramChatMessage = " msg == null or md5 is empty.";
    }
    int i = 0;
    label200:
    paramBaseHolder = paramChatMessage;
    if (i != 0) {
      if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1")))
      {
        boolean bool3 = localMessageForShortVideo.checkForward();
        if (localHolder.c != null)
        {
          paramBaseHolder = localHolder.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localHolder.q.frienduin);
          localStringBuilder.append(localHolder.q.uniseq);
          if (paramBaseHolder.c(localStringBuilder.toString()))
          {
            bool1 = true;
            break label318;
          }
        }
        boolean bool1 = false;
        label318:
        boolean bool2;
        if ((localHolder.j.ah != null) && (localHolder.j.ah.getVisibility() == 0)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if ((bool3) && (!bool1) && (!bool2))
        {
          paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
          paramBaseHolder = new StringBuilder();
          paramBaseHolder.append(paramChatMessage);
          paramBaseHolder.append("inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.");
          paramChatMessage = paramBaseHolder.toString();
        }
        else
        {
          paramBaseHolder = new StringBuilder();
          paramBaseHolder.append(paramChatMessage);
          paramBaseHolder.append("progeressBarShowing=");
          paramBaseHolder.append(bool1);
          paramBaseHolder.append(", errorIconShowing=");
          paramBaseHolder.append(bool2);
          paramChatMessage = paramBaseHolder.toString();
        }
        paramBaseHolder = paramChatMessage;
      }
      else
      {
        paramBaseHolder = " not inDPCWhiteList.";
      }
    }
    a(paramQQCustomMenu, this.e, 2131444634, localMessageForShortVideo, null);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("getMenuItem: ");
      paramChatMessage.append(paramBaseHolder);
      QLog.d("ShortVideoItemBuilder", 2, paramChatMessage.toString());
    }
    if ((localMessageForShortVideo != null) && ((localHolder.j.ah == null) || (localHolder.j.ah.getVisibility() != 0))) {
      a(paramQQCustomMenu, this.e, 2131438943, localMessageForShortVideo, new Bundle());
    }
    a(paramQQCustomMenu, this.e, 2131431695, localMessageForShortVideo, new Bundle());
    if ((localMessageForShortVideo != null) && (FileUtils.fileExistsAndNotEmpty(SVUtils.a(localMessageForShortVideo, "mp4")))) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    paramChatMessage = new Bundle();
    paramChatMessage.putBoolean("isSearch", false);
    super.a(paramQQCustomMenu, this.e, 2131449133, localMessageForShortVideo, paramChatMessage);
    a(paramQQCustomMenu, this.e, 2131444651, localMessageForShortVideo, null);
    super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
    super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
    this.w = true;
    return paramQQCustomMenu;
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.D;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing()))
    {
      this.D.dismiss();
      this.D = null;
    }
    localObject = G;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null)
        {
          long l = localCropBubbleVideoView.getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().b(Integer.valueOf(localCropBubbleVideoView.getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          localCropBubbleVideoView.releasePlayer(false);
          G.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new ShortVideoItemBuilder.7(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.reportCancelSendVideo("0X800A374", this.f.a);
      }
    }
  }
  
  protected void b(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (c(paramHolder))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
      return;
    }
    if (b(paramHolder.q.uniseq))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hideProgress fail...video order sending! ");
        ((StringBuilder)localObject).append(paramHolder.q.uniseq);
        QLog.i("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    paramHolder.g.setVisibility(8);
    Object localObject = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!((VideoProgressView)localObject).c(localStringBuilder.toString()))
    {
      paramHolder.c.setDrawStatus(2);
      return;
    }
    paramHolder.c.setAnimRunnableListener(new ShortVideoItemBuilder.1(this, paramHolder));
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.checkIsHotVideo()) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8007EDB");
      ReportController.b(this.d, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
    Object localObject;
    int i;
    if (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X80077D9"))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      i = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum((AppInterface)localObject, this.f.b, this.f.a);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("uin", this.f.b);
      ((JSONObject)localObject).put("memNum", i);
      ((JSONObject)localObject).put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label163:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(paramMessageForShortVideo.getMd5(), null, null, null, (JSONObject)localObject), false);
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.e, this.d, this.f, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.I);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadVideo：");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.toString());
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = paramMessageForShortVideo.checkIsHotVideo();
    Object localObject = paramMessageForShortVideo.videoFileName;
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!FileUtils.fileExistsAndNotEmpty((String)localObject)) && (!bool))
    {
      QQToast.makeText(this.e, 1, 2131916646, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!FileUtils.fileExistsAndNotEmpty(str)) && (!bool))
    {
      QQToast.makeText(this.e, 1, 2131916647, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.f.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramHolder = SVBusiUtil.a(1, this.a);
    paramMessageForShortVideo = ShortVideoBusiManager.a(this.a, paramMessageForShortVideo, paramHolder);
    paramMessageForShortVideo.C = bool;
    paramHolder.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(paramHolder, this.d);
  }
  
  public void b(FileMsg paramFileMsg, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      int i;
      if (paramFileMsg.fileSize != 0L)
      {
        i = (int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
        }
        i = 0;
      }
      a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), true);
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_is_long_video", true);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putInt("selection_mode", this.u);
    localBundle.putString("from_uin", SVUtils.a(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.f.a);
    localBundle.putString("from_session_uin", this.f.b);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forward menu clicked, videoPath=");
      localStringBuilder.append(str2);
      localStringBuilder.append(",videoPath = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageForShortVideo.toLogString());
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo.checkIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
    {
      localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
      localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
    }
    if (FileUtils.fileExistsAndNotEmpty(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.f.a);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.e, paramMessageForShortVideo, 21);
    ReportController.b(this.d, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reForwardVideo：");
      localStringBuilder.append(paramMessageForShortVideo.toString());
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.makeText(this.e, 1, 2131916647, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.f.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = SVBusiUtil.a(4, this.a);
      paramHolder.a(ShortVideoBusiManager.b(this.a, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.d);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
    }
  }
  
  public void c(FileMsg paramFileMsg, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = paramFileMsg.status;
    if (i != 1007)
    {
      if (i != 5001)
      {
        if (i != 5002)
        {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 2005: 
              b(paramHolder);
              if (paramFileMsg.errorCode == -5100528) {
                break;
              }
              QQToast.makeText(this.e, 2131916641, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
              return;
            case 2004: 
              b(paramHolder);
              return;
            case 2003: 
              a(paramHolder, paramMessageForShortVideo);
              return;
            case 2002: 
              a(paramFileMsg, paramHolder, paramMessageForShortVideo);
              return;
            case 2001: 
              b(paramHolder);
              paramHolder.j.setFailedIconVisable(false, this);
              return;
            }
            break;
          case 1005: 
            b(paramHolder);
            paramHolder.j.setFailedIconVisable(true, this);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1004: 
            paramFileMsg = paramHolder.c;
            paramMessageForShortVideo = new StringBuilder();
            paramMessageForShortVideo.append(paramHolder.q.frienduin);
            paramMessageForShortVideo.append(paramHolder.q.uniseq);
            paramFileMsg.b(paramMessageForShortVideo.toString());
            b(paramHolder);
            a(paramHolder, true, this);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1003: 
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("<MessageProgressView> handleVideoTrans ==> FileMsg.STATUS_SEND_FINISHED,  holder.mMessage.uniseq = ");
              paramFileMsg.append(paramHolder.q.uniseq);
              QLog.d("ShortVideoItemBuilder", 2, paramFileMsg.toString());
            }
            a(paramHolder, 100, true);
            b(paramHolder);
            b(paramHolder, false, null);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1002: 
            b(paramFileMsg, paramHolder, paramMessageForShortVideo);
            return;
          case 1001: 
            if (paramFileMsg.fileSize != 0L) {
              i = (int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize);
            } else {
              i = 0;
            }
            a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), true);
            paramHolder.j.setFailedIconVisable(false, this);
            e(paramHolder);
            return;
          }
        }
        else
        {
          a(paramHolder, 2131915835);
          if (paramMessageForShortVideo.uiOperatorFlag == 2)
          {
            paramHolder.j.setFailedIconVisable(true, this);
            QQToast.makeText(this.e, 2131916616, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          QQToast.makeText(this.e, 2131916640, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        }
      }
      else
      {
        a(paramHolder, 2131915834);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramHolder.j.setFailedIconVisable(true, this);
          QQToast.makeText(this.e, 2131916615, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        QQToast.makeText(this.e, 2131916639, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
    }
    else
    {
      b(paramHolder);
      b(paramHolder, false, null);
      VideoCompressProcessor.a().a(paramHolder.q.uniseq);
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131911445);
    }
    return HardCodeUtil.a(2131911497);
  }
  
  public void d(FileMsg paramFileMsg, ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = paramFileMsg.status;
    if (i != 2001)
    {
      int j;
      if (i != 2003)
      {
        if (i != 2005)
        {
          if (i != 5002) {
            return;
          }
          paramFileMsg = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
          i = paramFileMsg[0];
          j = paramFileMsg[1];
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(a(i, j));
          a(paramHolder, 2131915835);
          paramHolder.t.setVisibility(8);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
        }
      }
      else
      {
        paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        Object localObject = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
        j = localObject[0];
        int k = localObject[1];
        if ((h(paramMessageForShortVideo)) && (!d(paramHolder)) && (!g(paramMessageForShortVideo)))
        {
          localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
          File localFile = new File((String)localObject);
          if (localFile.exists())
          {
            long l2 = localFile.length();
            long l1;
            if (paramMessageForShortVideo.videoFileTime <= 8) {
              l1 = paramMessageForShortVideo.videoFileSize;
            } else {
              l1 = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).calculateVideoPartSize(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
            }
            if (l2 >= l1)
            {
              i = 0;
              break label277;
            }
          }
          i = 1;
          label277:
          if (i != 0)
          {
            if (NetworkUtil.isWifiConnected(this.e))
            {
              localObject = SVBusiUtil.a(this.d, paramMessageForShortVideo, 2);
              if (localObject != null) {
                ShortVideoBusiManager.a((ShortVideoReq)localObject, this.d);
              }
            }
            a(paramHolder, paramMessageForShortVideo, paramFileMsg, j, k, true);
            return;
          }
          if (paramMessageForShortVideo.videoFileTime <= 8) {
            i = 1;
          } else {
            i = 0;
          }
          a(paramHolder, true, paramMessageForShortVideo, (String)localObject, null, paramFileMsg, j, k);
          a(paramHolder);
          if (i != 0)
          {
            paramHolder.t.setVisibility(8);
            return;
          }
          paramHolder.t.setVisibility(0);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
    }
  }
  
  protected boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null) {
      if (paramMessageForShortVideo.checkIsHotVideo())
      {
        if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 2002))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("2164 msg.videoFileProgress = ");
          localStringBuilder.append(paramMessageForShortVideo.videoFileProgress);
          localStringBuilder.append(" msg.videoFileStatus = ");
          localStringBuilder.append(paramMessageForShortVideo.videoFileStatus);
          a(localStringBuilder.toString(), paramMessageForShortVideo);
          return true;
        }
      }
      else if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 998) && (paramMessageForShortVideo.isAllowAutoDown == true)) {
        return true;
      }
    }
    return false;
  }
  
  public void e(MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMenuItemClicked(): msg_revoke =>");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.toLogString());
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramMessageForShortVideo.md5 == null)
    {
      VideoCompressProcessor.a().c(paramMessageForShortVideo.uniseq);
      y.set(paramMessageForShortVideo.uniseq);
      ((QQMessageFacade)this.d.getManager(QQManagerFactory.MGR_MSG_FACADE)).a(paramMessageForShortVideo.istroop).j(paramMessageForShortVideo);
      ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      ReportController.b(this.d, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
      return;
    }
    int j = 1;
    Object localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    int i = j;
    if (localObject != null) {
      if (!IShortVideoUploadProcessor.class.isInstance(localObject))
      {
        i = j;
        if (!IShortVideoForwardProcessor.class.isInstance(localObject)) {}
      }
      else
      {
        boolean bool = ((BaseTransProcessor)localObject).isPause();
        int k = paramMessageForShortVideo.videoFileStatus;
        if ((!bool) && (k != 1002))
        {
          i = j;
          if (k != 1001) {}
        }
        else
        {
          j = 0;
          AioVideoTransFileController.d(this.d, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.d.getManager(QQManagerFactory.MGR_MSG_FACADE)).a(paramMessageForShortVideo.istroop).j(paramMessageForShortVideo);
          ReportController.b(this.d, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
            i = j;
          }
        }
      }
    }
    if (i != 0) {
      super.a(2131438943, this.e, paramMessageForShortVideo);
    }
  }
  
  public void f()
  {
    super.f();
    this.x = -1;
    this.w = false;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    try
    {
      paramView = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
      Object localObject = paramView.c;
      if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage msg.uniseq:");
        ((StringBuilder)localObject).append(localMessageForShortVideo.uniseq);
        ((StringBuilder)localObject).append(",fileType:");
        ((StringBuilder)localObject).append(SVUtils.a(paramFileMsg.fileType));
        ((StringBuilder)localObject).append(" ===> fileStatus:");
        ((StringBuilder)localObject).append(SVUtils.b(paramFileMsg.status));
        QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20))
      {
        if ((paramFileMsg.fileType == 7) || (paramFileMsg.fileType == 18) || (paramFileMsg.fileType == 16)) {
          d(paramFileMsg, paramView, localMessageForShortVideo);
        }
      }
      else {
        c(paramFileMsg, paramView, localMessageForShortVideo);
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    C = a(paramView, (MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject1).q);
    AIOUtils.q = true;
    long l1 = System.currentTimeMillis();
    long l2 = H;
    if ((l1 - l2 < 1000L) && (l1 > l2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    else
    {
      H = l1;
      if ((paramView.getId() != 2131430578) && (paramView.getId() != 2131430626))
      {
        if (paramView.getId() == 2131430598)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (!((ShortVideoItemBuilder.Holder)localObject1).q.isMultiMsg)
          {
            Object localObject2 = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(((ShortVideoItemBuilder.Holder)localObject1).q.frienduin, ((ShortVideoItemBuilder.Holder)localObject1).q.uniseq);
            if (((localObject2 instanceof IShortVideoUploadProcessor)) && (((IShortVideoUploadProcessor)localObject2).isBDHSuccess()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
              }
            }
            else
            {
              localObject2 = VideoCompressProcessor.a().b(((ShortVideoItemBuilder.Holder)localObject1).q.uniseq);
              if (localObject2 != null)
              {
                ((VideoCompressProcessor.CompressTask)localObject2).a.isPause = true;
                boolean bool = ((VideoCompressProcessor.CompressTask)localObject2).cancel(true);
                localStringBuilder.append("\n ShortVideoItemBuilder task cancel:");
                localStringBuilder.append(bool);
                localStringBuilder.append("\n md5 info:");
                localStringBuilder.append(((MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject1).q).md5);
                if ((bool) && (((MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject1).q).md5 == null))
                {
                  bool = ((VideoCompressProcessor.CompressTask)localObject2).a();
                  localStringBuilder.append("\n media codec cancel:");
                  localStringBuilder.append(bool);
                  if (bool) {
                    localStringBuilder.append("\n ffmpeg process cancel!");
                  } else {
                    localStringBuilder.append("\n ffmpeg process cancel exception!");
                  }
                }
              }
              localObject1 = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(((ShortVideoItemBuilder.Holder)localObject1).q.frienduin, ((ShortVideoItemBuilder.Holder)localObject1).q.uniseq);
              if ((localObject1 instanceof IShortVideoUploadProcessor))
              {
                ((BaseTransProcessor)localObject1).pause();
                localStringBuilder.append("\n upload process pause!");
              }
              ShortVideoUtils.reportCancelSendVideo("0X800A373", this.f.a);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("CompressTask pauseOperator info:");
                ((StringBuilder)localObject1).append(localStringBuilder.toString());
                QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
      }
      else {
        a((ShortVideoItemBuilder.Holder)localObject1, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */