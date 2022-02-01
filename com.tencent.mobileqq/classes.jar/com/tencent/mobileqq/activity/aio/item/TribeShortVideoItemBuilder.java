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
  protected int A;
  protected int B;
  protected int C;
  protected final float D = 15.0F;
  protected int E;
  protected DownloaderInterface F;
  protected boolean G = false;
  protected PlayingListPreloader H = new PlayingListPreloader();
  public View.OnClickListener I = new TribeShortVideoItemBuilder.1(this);
  public TribeShortVideoItemBuilder.AIOShortVideoDownloadListener J = new TribeShortVideoItemBuilder.5(this);
  protected Context a;
  protected float[] w;
  protected Drawable x;
  protected Drawable y;
  protected int z;
  
  public TribeShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
      this.G = true;
    }
    this.F = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    this.H.a(this.J);
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
    paramTribeShortVideoMsgHolder.b = ((CropBubbleVideoView)QQVideoViewFactory.createCropBubbleView(this.a, paramLong, null, paramBoolean));
    a(paramTribeShortVideoMsgHolder.b, this.z, this.A);
    paramTribeShortVideoMsgHolder.b.setFocusable(false);
    paramTribeShortVideoMsgHolder.b.setFocusableInTouchMode(false);
    paramTribeShortVideoMsgHolder.b.setClickable(false);
    paramTribeShortVideoMsgHolder.a.addView(paramTribeShortVideoMsgHolder.b, 0);
  }
  
  private void a(MessageForTribeShortVideo paramMessageForTribeShortVideo)
  {
    if (paramMessageForTribeShortVideo.videoWidth > paramMessageForTribeShortVideo.videoHeight)
    {
      this.z = DisplayUtil.a(this.a, 218.0F);
      this.A = DisplayUtil.a(this.a, 137.0F);
      return;
    }
    this.z = DisplayUtil.a(this.a, 137.0F);
    this.A = DisplayUtil.a(this.a, 218.0F);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, int paramInt1, int paramInt2)
  {
    paramCropBubbleVideoView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  private void c(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.d = ((TextView)paramTribeShortVideoMsgHolder.a.findViewById(2131429731));
    paramTribeShortVideoMsgHolder.d.setMaxLines(1);
    paramTribeShortVideoMsgHolder.d.setSingleLine(true);
  }
  
  private void d(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.c = ((AutoStartProgressBar)paramTribeShortVideoMsgHolder.a.findViewById(2131449632));
    paramTribeShortVideoMsgHolder.c.setSharpCornerCor(BubbleImageView.d);
    paramTribeShortVideoMsgHolder.c.setRadius(15.0F, true);
    paramTribeShortVideoMsgHolder.c.setShowCorner(true);
    paramTribeShortVideoMsgHolder.c.setDrawStatus(1);
  }
  
  private void e(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    paramTribeShortVideoMsgHolder.e = ((ImageView)paramTribeShortVideoMsgHolder.a.findViewById(2131437985));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
    localGradientDrawable.setShape(0);
    float f = DisplayUtil.a(this.a, 15.0F);
    localGradientDrawable.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setGradientType(0);
    paramTribeShortVideoMsgHolder.e.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void f(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    int i = this.a.getResources().getDimensionPixelSize(2131296618);
    int j = this.z;
    int k = BaseChatItemLayout.getBubblePaddingAlignError();
    int m = this.A;
    int n = BaseChatItemLayout.k;
    int i1 = this.E;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTribeShortVideoMsgHolder.a.getLayoutParams();
    localLayoutParams.width = (j + k + i);
    localLayoutParams.height = (m + n + i1);
    paramTribeShortVideoMsgHolder.a.setLayoutParams(localLayoutParams);
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = PAVideoView.V;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = URLDrawable.getDrawable(paramString, PAVideoView.V, PAVideoView.V);
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
        return PAVideoView.V;
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
      paramView = LayoutInflater.from(this.a).inflate(2131624441, paramBaseChatItemLayout, false);
      paramViewHolder.a = ((RelativeLayout)paramView.findViewById(2131430578));
      c(paramViewHolder);
      a(paramViewHolder, paramChatMessage.uniseq, bool);
      e(paramViewHolder);
      d(paramViewHolder);
      f(paramViewHolder);
      paramViewHolder.a.setOnClickListener(this.I);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      a(paramViewHolder.b, this.z, this.A);
      f(paramViewHolder);
    }
    paramBaseChatItemLayout = paramViewHolder.c;
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramChatMessage.frienduin);
    paramOnLongClickAndTouchListener.append(paramChatMessage.uniseq);
    paramBaseChatItemLayout.setKey(paramOnLongClickAndTouchListener.toString());
    paramViewHolder.c.setCornerDirection(bool);
    int i = DisplayUtil.a(this.a, paramViewHolder.b.getTriaWidth());
    if (paramViewHolder.b.mIsSend != bool)
    {
      paramViewHolder.b.mIsSend = bool;
      paramViewHolder.b.invalidate();
    }
    if (!bool)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.d.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.d.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.e.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramViewHolder.e.setLayoutParams(paramBaseChatItemLayout);
    }
    else
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.d.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.d.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramViewHolder.e.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramViewHolder.e.setLayoutParams(paramBaseChatItemLayout);
    }
    a(paramViewHolder, paramChatMessage.uniseq, localMessageForTribeShortVideo, false);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TribeShortVideoItemBuilder.TribeShortVideoMsgHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTribeShortVideo))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131433636)
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
      paramContext.putInt("selection_mode", this.u);
      paramContext.putInt("forward_source_uin_type", this.f.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.a, paramChatMessage, 21);
      return;
    }
    ChatActivityFacade.b(this.a, this.d, paramChatMessage);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    TribeShortVideoItemBuilder.TribeShortVideoMsgHolder localTribeShortVideoMsgHolder = (TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localTribeShortVideoMsgHolder.f == null) {
      a(localTribeShortVideoMsgHolder, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localTribeShortVideoMsgHolder.g.getLayoutParams();
    if (bool) {
      paramViewGroup.leftMargin = BaseChatItemLayout.getBubblePaddingAlignError();
    } else {
      paramViewGroup.leftMargin = (DisplayUtil.a(this.a, localTribeShortVideoMsgHolder.b.getTriaWidth()) + BaseChatItemLayout.getBubblePaddingAlignHead());
    }
    localTribeShortVideoMsgHolder.g.setLayoutParams(paramViewGroup);
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(localMessageForTribeShortVideo.themeName))
    {
      paramViewGroup = localTribeShortVideoMsgHolder.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(localMessageForTribeShortVideo.themeName);
      paramViewGroup.setText(localStringBuilder.toString());
      localTribeShortVideoMsgHolder.d.setVisibility(0);
    }
    else if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
    {
      localTribeShortVideoMsgHolder.d.setText(localMessageForTribeShortVideo.brief);
      localTribeShortVideoMsgHolder.d.setVisibility(0);
    }
    else
    {
      localTribeShortVideoMsgHolder.d.setVisibility(8);
    }
    if (!TextUtils.isEmpty(localMessageForTribeShortVideo.srcName))
    {
      if (localMessageForTribeShortVideo.srcName.length() > 5)
      {
        paramViewGroup = localTribeShortVideoMsgHolder.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageForTribeShortVideo.srcName.substring(0, 5));
        localStringBuilder.append(HardCodeUtil.a(2131912371));
        paramViewGroup.setText(localStringBuilder.toString());
      }
      else
      {
        paramViewGroup = localTribeShortVideoMsgHolder.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageForTribeShortVideo.srcName);
        localStringBuilder.append(HardCodeUtil.a(2131912372));
        paramViewGroup.setText(localStringBuilder.toString());
      }
    }
    else
    {
      localTribeShortVideoMsgHolder.g.setText(this.a.getString(2131918188));
      localTribeShortVideoMsgHolder.g.setOnClickListener(null);
    }
    localTribeShortVideoMsgHolder.c.setCornerDirection(paramChatMessage.isSend());
    if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
    {
      paramViewGroup = (Long)localTribeShortVideoMsgHolder.b.getTag();
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForTribeShortVideo.uniseq))
      {
        localTribeShortVideoMsgHolder.s = false;
        a(localTribeShortVideoMsgHolder.b.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.z, this.A, this.x);
        a(localTribeShortVideoMsgHolder, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
        localTribeShortVideoMsgHolder.b.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
      }
    }
    else
    {
      localTribeShortVideoMsgHolder.s = false;
      localTribeShortVideoMsgHolder.c.setDrawStatus(2);
      localTribeShortVideoMsgHolder.c.setVisibility(0);
      a(localTribeShortVideoMsgHolder.b.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.z, this.A, this.x);
    }
  }
  
  protected void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.q;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TribeShortVideoItemBuilder onBubbleOnClick:");
        ((StringBuilder)localObject).append(paramTribeShortVideoMsgHolder.toString());
        QLog.d("TribeShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramTribeShortVideoMsgHolder.jumpUrl);
      this.a.startActivity((Intent)localObject);
      ReportController.b(this.d, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
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
    ((Activity)this.a).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramTribeShortVideoMsgHolder, paramLong));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramTribeShortVideoMsgHolder.b, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!AIOSingleReporter.a().a(paramTribeShortVideoMsgHolder.q, "video_play"))
    {
      AIOSingleReporter.a().b(paramTribeShortVideoMsgHolder.q, "video_play");
      if ((paramTribeShortVideoMsgHolder.q instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.q;
        ReportController.b(this.d, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
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
    paramTribeShortVideoMsgHolder = new NewIntent(this.a, ProtoServlet.class);
    paramTribeShortVideoMsgHolder.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString1.toString());
    paramTribeShortVideoMsgHolder.putExtra("data", paramString2.toByteArray());
    this.d.startServlet(paramTribeShortVideoMsgHolder);
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
      if ((this.a instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.a).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramTribeShortVideoMsgHolder, paramLong, paramMessageForTribeShortVideo));
      }
    }
    else
    {
      ((Activity)this.a).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramTribeShortVideoMsgHolder));
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
      }
      a(paramMessageForTribeShortVideo, paramTribeShortVideoMsgHolder);
    }
  }
  
  protected void a(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramTribeShortVideoMsgHolder.f = new FrameLayout(this.a);
    Object localObject1 = new TextView(this.a);
    ((TextView)localObject1).setBackgroundResource(2130843655);
    Object localObject2 = this.a.getResources().getDrawable(2130848171);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.a.getResources().getColor(2131168464));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(DisplayUtil.a(this.a, 5.0F), 0, DisplayUtil.a(this.a, 5.0F), 0);
    paramTribeShortVideoMsgHolder.f.setOnClickListener(this.I);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramTribeShortVideoMsgHolder.f.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramTribeShortVideoMsgHolder.g = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131430578);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131430578);
    paramViewGroup.addView(paramTribeShortVideoMsgHolder.f, (ViewGroup.LayoutParams)localObject1);
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
    ((DownloadTask)localObject2).e = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.F.startDownload((DownloadTask)localObject2, new TribeShortVideoItemBuilder.4(this, paramTribeShortVideoMsgHolder, paramMessageForTribeShortVideo), localBundle);
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
    paramString1.mSceneName = SceneID.getSceneStr(111);
    paramCropBubbleVideoView.setVideoParam(paramString1);
    paramCropBubbleVideoView.play();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    TroopBusinessUtil.a(paramView);
    localQQCustomMenu.a(2131433636, this.a.getString(2131889668), 2130839066);
    if ((paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
      a(localQQCustomMenu, this.a, 2131438943, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.a, 2131431695, paramView, new Bundle());
    a(localQQCustomMenu, this.a, 2131439015, null, null);
    super.a(localQQCustomMenu, this.a, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder)
  {
    try
    {
      paramTribeShortVideoMsgHolder = (MessageForTribeShortVideo)paramTribeShortVideoMsgHolder.q;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TribeShortVideoItemBuilder onSourceOnClick:");
        ((StringBuilder)localObject).append(paramTribeShortVideoMsgHolder.toString());
        QLog.d("TribeShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("isOpeningQunApp", false);
      ((Intent)localObject).putExtra("url", paramTribeShortVideoMsgHolder.sourceJumpUrl);
      this.a.startActivity((Intent)localObject);
      ReportController.b(this.d, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramTribeShortVideoMsgHolder.bid, paramTribeShortVideoMsgHolder.pid, "", "");
      return;
    }
    catch (Exception paramTribeShortVideoMsgHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramTribeShortVideoMsgHolder);
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */