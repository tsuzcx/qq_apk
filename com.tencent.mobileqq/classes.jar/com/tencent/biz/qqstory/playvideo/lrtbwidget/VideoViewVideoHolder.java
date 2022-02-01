package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.playmode.VideoPlayModeConstants;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.ImageViewLoadCallback;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.ReportData;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory.TVKSDKOnLogListener;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.Stream;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VideoViewVideoHolder
  extends VideoHolderBase
  implements View.OnClickListener
{
  private static final String[] W = { "SE", "VI", "DD", "SV", "VD", "SP", "VP", "HC" };
  public static final String[] j = { "s_Idle", "s_VideoInfo", "s_VideoInfo_OK", "s_DoodleDown", "s_DoodleDown_OK", "s_VideoFile", "s_VideoFile_OK", "s_Prepare", "s_Prepare_OK", "s_Starting", "s_Playing_OK", "s_Pause", "s_Complete_OK" };
  public static final SparseArray<int[]> k = new VideoViewVideoHolder.1();
  private Bitmap A;
  private View B;
  private TextView C;
  private Button D;
  private Button E;
  private Button F;
  private int[] G = new int[6];
  private boolean H = false;
  private String I = null;
  private int J = 0;
  private int K = 0;
  private int L = 0;
  private VideoViewVideoHolder.VideoViewListener M;
  private boolean N = false;
  private Handler O = new Handler(Looper.getMainLooper());
  private WatchVideoHandler P = new WatchVideoHandler();
  private BatchGetVideoInfo Q;
  private boolean R = false;
  private long S = 0L;
  private long T = 0L;
  private boolean U = false;
  private StoryPlayerTVKWrapper.ReportData V = new StoryPlayerTVKWrapper.ReportData();
  private Map<String, Long> X = new VideoViewVideoHolder.12(this);
  private int Y;
  private int Z;
  private long aa = 0L;
  private int ab = 0;
  private int ac = 0;
  private String ad;
  private int ae;
  private String af = null;
  private long ag;
  VideoViewVideoHolder.SingleFileDownloaderHolder l = new VideoViewVideoHolder.SingleFileDownloaderHolder(this, null);
  int m;
  Stream n = null;
  String o = null;
  public IVideoView p;
  public ImageView q = (ImageView)this.b.findViewById(2131431472);
  public ImageView r = (ImageView)this.b.findViewById(2131437985);
  public QQStoryLoadingView s;
  public QQStoryVideoPlayerErrorView t;
  public int u = 3;
  public String v;
  public StoryNewGuideDialog w;
  PlayModeUtils.ImageViewLoadCallback x = new VideoViewVideoHolder.14(this);
  private int y = 0;
  private int z;
  
  public VideoViewVideoHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.s = ((QQStoryLoadingView)paramViewGroup.findViewById(2131437622));
    this.t = ((QQStoryVideoPlayerErrorView)paramViewGroup.findViewById(2131449663));
    this.B = this.b.findViewById(2131447049);
    this.C = ((TextView)this.b.findViewById(2131447048));
    this.D = ((Button)this.b.findViewById(2131447046));
    this.D.setOnClickListener(this);
    this.E = ((Button)this.b.findViewById(2131447050));
    this.E.setOnClickListener(this);
    this.F = ((Button)this.b.findViewById(2131447047));
    this.F.setOnClickListener(this);
  }
  
  private void A()
  {
    if (!this.U) {
      return;
    }
    this.U = false;
    int i;
    if ((!i().mReportData.hasReportFirstVideoTime) && ((TextUtils.equals(this.c.b, m().b)) || (TextUtils.isEmpty(m().b)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (!i().mReportData.hasReportFirstVideoTime) {
      i().mReportData.hasReportFirstVideoTime = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    long l2 = i().mReportData.startActivityTimeStamp;
    long l3 = i().mReportData.activityOnCreateTimeStamp;
    long l4 = i().mReportData.initViewPagerUiTimeStamp;
    long l1 = i().mReportData.initViewPagerDataTimeStamp;
    localStringBuilder.append("staAct");
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" ");
    localStringBuilder.append("onCre");
    localStringBuilder.append(" ");
    localStringBuilder.append(l3 - l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("initUi");
    localStringBuilder.append(" ");
    localStringBuilder.append(l4 - l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("initData");
    localStringBuilder.append(" ");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append(" ");
    Object localObject1 = W;
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = localObject1[i1];
      if (this.X.containsKey(localObject2))
      {
        l1 = ((Long)this.X.get(localObject2)).longValue();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" ");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append(" ");
      }
      else
      {
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" ");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append(" ");
      }
      i1 += 1;
    }
    if (i != 0)
    {
      l1 = ((Long)this.X.get("HC")).longValue() - l2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913620));
      ((StringBuilder)localObject1).append(l1);
      b(((StringBuilder)localObject1).toString());
    }
    else
    {
      l1 = ((Long)this.X.get("HC")).longValue() - ((Long)this.X.get("SE")).longValue();
    }
    if (i != 0) {
      localObject1 = "CL ";
    } else {
      localObject1 = "SL ";
    }
    if (this.p.j() == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("LO ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (this.p.j() == 1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("ST ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("3 ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.p.k());
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" ");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (l())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("TVK");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("TEX");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    this.T = l1;
    StoryReportor.b("play_video", "start_wait_time", i().mReportData.from, (int)l1, new String[] { localObject1, localStringBuilder.toString(), StoryReportor.a(a()), this.c.b });
  }
  
  private void a(long paramLong, String paramString)
  {
    a("HC", SystemClock.uptimeMillis());
    this.R = true;
    SLog.b(this.a, "hideCover, hide loading view");
    this.q.setVisibility(8);
    this.s.setVisibility(8);
    x();
    SLog.d(this.a, "CheckVideoViewRealStartRunnable, %s, currentPosition=%d, outputTimeOutCount=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(VideoViewFactory.a(a()).b().a) });
    this.af = this.c.b;
    A();
    this.O.postDelayed(new VideoViewVideoHolder.11(this), 600L);
    this.M.c(this, this.p);
  }
  
  private static void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt4;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt4;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    SLog.d(this.a, "onError. %d : %s", new Object[] { Integer.valueOf(paramErrorMessage.errorCode), paramErrorMessage.errorMsg });
    if (paramErrorMessage.errorCode == 0) {
      return;
    }
    switch (paramErrorMessage.errorCode)
    {
    default: 
      return;
    case 9: 
      this.t.setVisibility(0);
      this.t.a(1);
      this.s.setVisibility(8);
      this.p.a(8);
      this.r.setVisibility(8);
      this.t.setOnTipsClickListener(new VideoViewVideoHolder.10(this));
      return;
    case 7: 
    case 14: 
      this.t.setVisibility(0);
      this.t.a(1);
      this.t.setOnTipsClickListener(null);
      this.s.setVisibility(8);
      this.p.a(8);
      this.r.setVisibility(8);
      this.t.setOnTipsClickListener(new VideoViewVideoHolder.9(this));
      return;
    case 5: 
      this.t.setVisibility(8);
      this.s.setVisibility(8);
      this.p.a(8);
      this.r.setVisibility(8);
      return;
    case 4: 
      this.t.setVisibility(0);
      paramErrorMessage = this.t;
      paramErrorMessage.setTipsText(paramErrorMessage.getResources().getString(2131897970));
      this.t.setOnTipsClickListener(null);
      this.s.setVisibility(8);
      this.p.a(8);
      this.r.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
    this.t.a(1);
    this.s.setVisibility(8);
    this.p.a(8);
    this.r.setVisibility(8);
    this.t.setOnTipsClickListener(new VideoViewVideoHolder.8(this, paramErrorMessage));
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    int i = paramStoryVideoItem.mVideoWidth;
    int i1 = paramStoryVideoItem.mVideoHeight;
    if (!TextUtils.equals(this.I, paramStoryVideoItem.mVid))
    {
      int i2 = this.J;
      int i3;
      if (i2 == i)
      {
        i3 = this.K;
        if ((i3 == i1) && (i2 > 0) && (i3 > 0) && (this.L == paramStoryVideoItem.playerScaleType)) {}
      }
      else
      {
        Object localObject1 = this.p.a();
        boolean bool = localObject1 instanceof TextureVideoView;
        int i6 = UIUtils.c(this.b.getContext());
        int i7 = UIUtils.d(this.b.getContext());
        double d5 = i;
        double d6 = i1;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double d1 = d5 / d6;
        double d2 = i6;
        double d3 = i7;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        int i11;
        int i10;
        int i9;
        int i8;
        if ((bool) && (i > 0) && (i1 > 0))
        {
          if (d1 < 1.0D) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (d4 < 1.0D) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i2 != i3) {
            bool = true;
          } else {
            bool = false;
          }
          this.H = bool;
          int i4 = i;
          int i5 = i1;
          if (this.H)
          {
            Double.isNaN(d6);
            Double.isNaN(d5);
            d1 = d6 / d5;
            i5 = i;
            i4 = i1;
          }
          float f2;
          float f1;
          float f4;
          float f3;
          if (paramStoryVideoItem.playerScaleType == 1)
          {
            f2 = i6;
            f1 = i4;
            f2 /= f1;
            f4 = i7;
            f3 = i5;
            f4 /= f3;
            if (f2 < f4)
            {
              i2 = (int)(f1 * f2);
              i3 = (int)(f3 * f2);
              i1 = (i7 - i3) / 2;
              i = 0;
            }
            else
            {
              i2 = (int)(f1 * f4);
              i3 = (int)(f3 * f4);
              i = (i6 - i2) / 2;
              i1 = 0;
            }
            i4 = i2;
            i5 = i3;
          }
          else if (d4 >= d1)
          {
            Double.isNaN(d2);
            i3 = (int)(d2 / d1);
            d1 = i7 - i3;
            Double.isNaN(d1);
            i1 = (int)(d1 * 1.0D / 2.0D + 0.5D);
            i = 0;
            i2 = i6;
          }
          else
          {
            Double.isNaN(d3);
            i2 = (int)(d3 * d1);
            d1 = i6 - i2;
            Double.isNaN(d1);
            i = (int)(d1 * 1.0D / 2.0D + 0.5D);
            i1 = 0;
            i3 = i7;
          }
          i11 = i4;
          i10 = i5;
          i9 = i;
          i8 = i1;
          i7 = i2;
          i6 = i3;
          if (this.H)
          {
            localObject2 = new Matrix();
            f3 = i3;
            f4 = i2;
            f1 = f3 / f4;
            f2 = f4 / f3;
            f4 /= 2.0F;
            f3 /= 2.0F;
            ((Matrix)localObject2).setScale(f1, f2, f4, f3);
            ((Matrix)localObject2).postRotate(90.0F, f4, f3);
            ((TextureVideoView)localObject1).setTransform((Matrix)localObject2);
            i11 = i4;
            i10 = i5;
            i9 = i;
            i8 = i1;
            i7 = i2;
            i6 = i3;
          }
        }
        else
        {
          i9 = 0;
          i8 = 0;
          i7 = -1;
          i6 = -1;
          i10 = i1;
          i11 = i;
        }
        this.I = paramStoryVideoItem.mVid;
        this.L = paramStoryVideoItem.playerScaleType;
        this.K = paramStoryVideoItem.mVideoHeight;
        this.J = paramStoryVideoItem.mVideoWidth;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913619));
        ((StringBuilder)localObject1).append(i11);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913614));
        ((StringBuilder)localObject1).append(i10);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913616));
        ((StringBuilder)localObject1).append(String.valueOf(this.H));
        b(((StringBuilder)localObject1).toString());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913613));
        ((StringBuilder)localObject2).append(paramStoryVideoItem.mVideoDuration);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913633));
        ((StringBuilder)localObject2).append(paramStoryVideoItem.mVideoBytes);
        if (paramStoryVideoItem.mIsPicture == 1) {
          localObject1 = HardCodeUtil.a(2131913627);
        } else {
          localObject1 = "";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        b(((StringBuilder)localObject2).toString());
        localObject1 = this.G;
        localObject1[0] = i11;
        localObject1[1] = i10;
        localObject1[2] = i7;
        localObject1[3] = i6;
        localObject1[4] = i9;
        localObject1[5] = i8;
        SLog.b(this.a, "updateViewParam, videoWidth/videoHeight=%d/%d, layoutWidth/layoutHeight=%d/%d, leftMargin=%d, topMargin=%d, vid=%s", new Object[] { Integer.valueOf(this.G[0]), Integer.valueOf(this.G[1]), Integer.valueOf(this.G[2]), Integer.valueOf(this.G[3]), Integer.valueOf(this.G[4]), Integer.valueOf(this.G[5]), paramStoryVideoItem.mVid });
        a(this.p.a(), i7, i6, i9, i8);
        a(this.q, i7, i6, i9, i8);
        a(this.r, i7, i6, i9, i8);
        return;
      }
    }
    this.I = paramStoryVideoItem.mVid;
  }
  
  private void a(StoryPlayerVideoData paramStoryPlayerVideoData, IVideoView paramIVideoView, int paramInt)
  {
    if (!TextUtils.equals(this.af, this.c.b)) {
      return;
    }
    String str = StoryReportor.a(a());
    StoryPlayerTVKWrapper.ReportData localReportData = paramIVideoView.b();
    long l1;
    if (localReportData.k == 0L) {
      l1 = paramIVideoView.h();
    } else {
      l1 = localReportData.k;
    }
    long l2;
    if (paramInt == 1) {
      l2 = l1;
    } else if (localReportData.k == 0L) {
      l2 = paramIVideoView.e();
    } else {
      l2 = localReportData.l;
    }
    Bosses.get().postJob(new VideoViewVideoHolder.16(this, this.a, paramStoryPlayerVideoData, l1, l2, paramInt, str));
  }
  
  private void a(String paramString, long paramLong)
  {
    if (this.U)
    {
      this.X.put(paramString, Long.valueOf(paramLong));
      y();
    }
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length;
    int i = 0;
    while (i < i1)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    if ((!TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid)))
    {
      this.P.a(paramStoryVideoItem.mVid, paramStoryVideoItem.mOwnerUid, i().mReportData.from, false, paramStoryVideoItem.mCreateTime);
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not report play, vid = ");
      ((StringBuilder)localObject2).append(paramStoryVideoItem.mVid);
      ((StringBuilder)localObject2).append(" mOwnerUid:");
      ((StringBuilder)localObject2).append(paramStoryVideoItem.mOwnerUid);
      ((StringBuilder)localObject2).append(", myUin:");
      ((StringBuilder)localObject2).append(QQStoryContext.a().i());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramStoryVideoItem.mOwnerUid;
    Object localObject1 = localObject2;
    if (this.c.a != null)
    {
      localObject1 = localObject2;
      if (this.c.a.b == 13) {
        localObject1 = this.c.a.d;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new ReadStoryVideoEvent((String)localObject1, paramStoryVideoItem);
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
    ((StoryManager)SuperManager.a(5)).k(paramStoryVideoItem.mVid);
    SLog.b(this.a, "Do play video. vid = %s", paramStoryVideoItem.mVid);
  }
  
  private void b(StoryPlayerVideoData paramStoryPlayerVideoData, IVideoView paramIVideoView, int paramInt)
  {
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.e();
    if (localStoryVideoItem == null)
    {
      SLog.e(this.a, "video info empty , report error! vid :%s", new Object[] { paramStoryPlayerVideoData.b });
      return;
    }
    if (!TextUtils.equals(this.af, this.c.b)) {
      return;
    }
    paramStoryPlayerVideoData = StoryReportor.a(a());
    StoryPlayerTVKWrapper.ReportData localReportData = paramIVideoView.b();
    long l1;
    if (localReportData.k == 0L) {
      l1 = paramIVideoView.h();
    } else {
      l1 = localReportData.k;
    }
    long l2;
    if (paramInt == 1) {
      l2 = l1;
    } else if (localReportData.k == 0L) {
      l2 = paramIVideoView.e();
    } else {
      l2 = localReportData.l;
    }
    Bosses.get().postJob(new VideoViewVideoHolder.17(this, this.a, localStoryVideoItem, l1, l2, paramInt, paramStoryPlayerVideoData));
  }
  
  private void b(@NonNull String paramString)
  {
    SLog.b(this.a, paramString);
  }
  
  private boolean b(int paramInt)
  {
    return a(paramInt, (int[])k.get(this.y));
  }
  
  private boolean c(int paramInt)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "not - main - thread");
    if (a(paramInt, (int[])k.get(this.y)))
    {
      localObject1 = this.a;
      localObject2 = j;
      SLog.d((String)localObject1, "changeState : %s => %s", new Object[] { localObject2[this.y], localObject2[paramInt] });
      this.y = paramInt;
      return true;
    }
    Object localObject1 = this.a;
    Object localObject2 = new Throwable();
    String[] arrayOfString = j;
    SLog.c((String)localObject1, (Throwable)localObject2, "changeState not allow ! current = %s, new = %s", new Object[] { arrayOfString[this.y], arrayOfString[paramInt] });
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeState ! ");
    ((StringBuilder)localObject1).append(j[this.y]);
    ((StringBuilder)localObject1).append(" -- ");
    ((StringBuilder)localObject1).append(j[paramInt]);
    CaughtExceptionReport.a(new IllegalStateException(((StringBuilder)localObject1).toString()));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeState not allow. current=");
    ((StringBuilder)localObject1).append(j[this.y]);
    ((StringBuilder)localObject1).append(", new=");
    ((StringBuilder)localObject1).append(j[paramInt]);
    AssertUtils.assertTrue(false, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.c.e();
    if (localObject == null)
    {
      s().setVisibility(8);
      return;
    }
    localObject = ((StoryVideoItem)localObject).getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).c()) && (((VideoLinkInfo)localObject).h.a()) && (i().mReportData.from != 86))
    {
      s().setVisibility(paramInt);
      return;
    }
    s().setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "not - main - thread");
    Object localObject1 = this.a;
    Object localObject2 = j;
    SLog.a((String)localObject1, "checkStateAndGoAhead. %s => %s. reset=%s", localObject2[this.y], localObject2[this.m], Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(j[this.y]);
      ((StringBuilder)localObject1).append(" - ");
      ((StringBuilder)localObject1).append(j[0]);
      this.o = ((StringBuilder)localObject1).toString();
      this.n = Stream.of("");
      this.n.map(new VideoViewVideoHolder.VideoIdleSegment(this, null)).subscribe(new VideoViewVideoHolder.2(this));
      return;
    }
    int i = this.y;
    int i1 = this.m;
    if (i == i1)
    {
      SLog.a(this.a, "checkStateAndGoAhead. DONE => %s", j[this.m]);
      return;
    }
    if (this.n != null)
    {
      SLog.d(this.a, "checkStateAndGoAhead. do nothing. waiting ...");
      return;
    }
    if (i1 == 0)
    {
      d(true);
      return;
    }
    if (i1 == 2)
    {
      if (i == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(j[0]);
        ((StringBuilder)localObject1).append(" - ");
        ((StringBuilder)localObject1).append(j[2]);
        this.o = ((StringBuilder)localObject1).toString();
        this.n = Stream.of(this.c);
        this.n.map(new VideoViewVideoHolder.CheckDataSegment(this, null)).map(new VideoViewVideoHolder.VideoInfoSegment(this, null)).subscribe(new VideoViewVideoHolder.3(this));
        return;
      }
      d(true);
      return;
    }
    if ((i1 != 8) && (i1 != 10))
    {
      if (i1 == 11)
      {
        if (i == 10)
        {
          localObject1 = this.a;
          localObject2 = j;
          SLog.a((String)localObject1, "requestChangeState. current=%s, target=%s, pause video", localObject2[this.y], localObject2[this.m]);
          c(11);
          this.p.f();
          return;
        }
        localObject1 = this.a;
        localObject2 = j;
        SLog.d((String)localObject1, "requestChangeState. current=%s, target=%s, ERROR !", new Object[] { localObject2[this.y], localObject2[this.m] });
      }
    }
    else
    {
      i = this.y;
      if (i == 0)
      {
        if (this.c != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(j[0]);
          ((StringBuilder)localObject1).append(" - ");
          ((StringBuilder)localObject1).append(j[6]);
          this.o = ((StringBuilder)localObject1).toString();
          this.n = Stream.of(this.c);
          this.n.map(new VideoViewVideoHolder.CheckDataSegment(this, null)).map(new VideoViewVideoHolder.VideoInfoSegment(this, null)).map(new VideoViewVideoHolder.DoodleSegment(this, this.l)).map(new VideoViewVideoHolder.VideoFileSegment(this, this.l, l())).subscribe(new VideoViewVideoHolder.4(this));
          return;
        }
        SLog.e(this.a, "mData is null");
        a(new ErrorMessage(0, "mData is null. un bind !"));
        return;
      }
      if (i == 2)
      {
        if (this.c != null)
        {
          localObject1 = ((StoryManager)SuperManager.a(5)).b(this.c.b);
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(j[2]);
            ((StringBuilder)localObject2).append(" - ");
            ((StringBuilder)localObject2).append(j[6]);
            this.o = ((StringBuilder)localObject2).toString();
            this.n = Stream.of(localObject1);
            this.n.map(new VideoViewVideoHolder.DoodleSegment(this, this.l)).map(new VideoViewVideoHolder.VideoFileSegment(this, this.l, l())).subscribe(new VideoViewVideoHolder.5(this));
            return;
          }
          SLog.e(this.a, "mData is null");
          a(new ErrorMessage(0, "Go To VideoFile. storyVideoItem is null. un bind !"));
          return;
        }
        SLog.e(this.a, "mData is null");
        a(new ErrorMessage(0, "Go To VideoFile. mData is null. un bind !"));
        return;
      }
      if (i < 6)
      {
        d(true);
        return;
      }
      if (i == 6)
      {
        localObject1 = ((StoryManager)SuperManager.a(5)).b(this.c.b);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(j[6]);
          ((StringBuilder)localObject2).append(" - ");
          ((StringBuilder)localObject2).append(j[8]);
          this.o = ((StringBuilder)localObject2).toString();
          this.n = Stream.of(localObject1);
          this.n.map(new VideoViewVideoHolder.VideoPrepareSegment(this, null)).subscribe(new VideoViewVideoHolder.6(this));
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("no videoInfo ");
        ((StringBuilder)localObject1).append(this.c.b);
        a(new ErrorMessage(12, ((StringBuilder)localObject1).toString()));
        return;
      }
      if ((i != 7) && (i != 9) && (i != 12))
      {
        if ((this.m == 8) && ((i == 11) || (i == 10)))
        {
          d(true);
          return;
        }
        if (this.m == 10)
        {
          i = this.y;
          if ((i == 11) || (i == 8))
          {
            localObject1 = this.a;
            localObject2 = j;
            SLog.a((String)localObject1, "requestChangeState. current=%s, target=%s, start play", localObject2[this.y], localObject2[this.m]);
            localObject1 = ((StoryManager)SuperManager.a(5)).b(this.c.b);
            if (localObject1 != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(j[this.y]);
              ((StringBuilder)localObject2).append(" - ");
              ((StringBuilder)localObject2).append(j[10]);
              this.o = ((StringBuilder)localObject2).toString();
              this.n = Stream.of(localObject1);
              this.n.map(new VideoViewVideoHolder.VideoStartSegment(this, null)).subscribe(new VideoViewVideoHolder.7(this));
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("no videoInfo ");
            ((StringBuilder)localObject1).append(this.c.b);
            a(new ErrorMessage(12, ((StringBuilder)localObject1).toString()));
            return;
          }
        }
        localObject1 = this.a;
        localObject2 = j;
        SLog.e((String)localObject1, "state error. currentTargetState = %s, currentState = %s", new Object[] { localObject2[this.m], localObject2[this.y] });
        return;
      }
    }
    try
    {
      d(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void w()
  {
    d(false);
  }
  
  private void x()
  {
    if (this.X.containsKey("SE"))
    {
      long l1 = ((Long)this.X.get("SE")).longValue();
      String[] arrayOfString = W;
      int i1 = arrayOfString.length;
      int i = 0;
      Object localObject1 = "SE";
      while (i < i1)
      {
        String str = arrayOfString[i];
        Object localObject2;
        long l2;
        if (str.equals("SE"))
        {
          localObject2 = localObject1;
          l2 = l1;
        }
        else
        {
          localObject2 = localObject1;
          l2 = l1;
          if (this.X.containsKey(str))
          {
            b(String.format((Locale)null, HardCodeUtil.a(2131913634), new Object[] { localObject1, str, Long.valueOf(((Long)this.X.get(str)).longValue() - l1) }));
            l2 = ((Long)this.X.get(str)).longValue();
            localObject2 = str;
          }
        }
        i += 1;
        localObject1 = localObject2;
        l1 = l2;
      }
      if (this.U) {
        b(String.format((Locale)null, HardCodeUtil.a(2131913615), new Object[] { Long.valueOf(((Long)this.X.get("HC")).longValue() - ((Long)this.X.get("SE")).longValue()) }));
      }
    }
  }
  
  private void y()
  {
    this.B.setVisibility(8);
    this.C.setVisibility(8);
    this.D.setVisibility(8);
    this.E.setVisibility(8);
    this.F.setVisibility(8);
  }
  
  private void z()
  {
    Object localObject = this.s;
    boolean bool1;
    if ((localObject != null) && ((((QQStoryLoadingView)localObject).getVisibility() == 0) || (this.s.getDelayVisibility() == 0))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = this.t;
    boolean bool2;
    if ((localObject != null) && (((QQStoryVideoPlayerErrorView)localObject).getVisibility() == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i = this.ae;
    int i1 = this.Y;
    int i2 = this.Z;
    int i3 = this.p.j();
    localObject = this.af;
    String str1 = this.c.b;
    String str2 = this.ad;
    String str3 = this.v;
    long l1 = this.ag;
    int i4 = this.ab;
    int i5 = this.ac;
    int i6 = i().mReportData.from;
    Long localLong = (Long)this.X.get("SE");
    StoryPlayerTVKWrapper.ReportData localReportData = new StoryPlayerTVKWrapper.ReportData(this.p.b());
    Bosses.get().postJob(new VideoViewVideoHolder.15(this, this.a, bool1, i, localLong, bool2, i1, i2, i3, (String)localObject, str1, i6, i4, i5, localReportData, l1, str2, str3));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    y();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913628));
    localStringBuilder.append(this.d);
    localStringBuilder.append("-");
    localStringBuilder.append(this.e);
    b(localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    String str;
    if (this.c != null) {
      str = this.c.b;
    } else {
      str = null;
    }
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    SLog.a(this.a, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.d), Integer.valueOf(this.e), paramStoryPlayerVideoData);
    y();
    this.X.clear();
    a(2, paramStoryPlayerVideoData.b.equals(str) ^ true, "onBind");
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, false, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool;
    if ((paramInt != 2) && (paramInt != 8) && (paramInt != 10) && (paramInt != 11) && (paramInt != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    AssertUtils.assertTrue(bool);
    String str = this.a;
    String[] arrayOfString = j;
    SLog.a(str, "requestChangeState. START. current=%s, newTarget=%s. reset=%s, reason=%s", arrayOfString[this.y], arrayOfString[paramInt], Boolean.valueOf(paramBoolean), paramString);
    if ((this.m != paramInt) || (paramBoolean))
    {
      this.m = paramInt;
      if (paramBoolean)
      {
        if (this.n != null)
        {
          SLog.a(this.a, "cancel current stream : %s. current state = %s", this.o, j[this.y]);
          this.n.cancel();
          this.o = null;
          this.n = null;
          w();
        }
        else
        {
          d(true);
        }
      }
      else if (this.n != null) {
        SLog.b(this.a, "just waiting");
      } else {
        w();
      }
    }
    str = this.a;
    arrayOfString = j;
    SLog.a(str, "requestChangeState. DONE. current=%s, newTarget=%s. reset=%s, reason=%s", arrayOfString[this.y], arrayOfString[paramInt], Boolean.valueOf(paramBoolean), paramString);
  }
  
  public void a(VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.M = paramVideoViewListener;
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean)
    {
      this.U = true;
      this.X.clear();
      a("SE", SystemClock.uptimeMillis());
      this.T = 0L;
      this.S = 0L;
      this.u = 3;
      this.ae = 1;
      this.s.setVisibility(8);
      this.s.setVisibilityDelay(0, 1000L, "onSelectedChanged true");
      StoryReportor.b("play_video", "onSelectedState", 0, 0, new String[] { j[this.y] });
      a(10, "selected");
      StoryReportor.a("play_video", "exp", 0, 0, new String[] { "", "", "", this.c.b });
    }
    else
    {
      this.R = false;
      u();
      z();
      this.af = null;
      this.X.clear();
      this.s.setVisibility(8);
      r().setVisibility(8);
      s().setVisibility(8);
      a(0, true, "unSelected");
    }
    this.ab = 0;
    this.aa = 0L;
    this.ac = 0;
  }
  
  public void c(boolean paramBoolean)
  {
    SLog.d(this.a, "setRepeatWhilePlayDone = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.N = paramBoolean;
  }
  
  protected void d()
  {
    super.d();
    Activity localActivity = a();
    if (l()) {
      this.p = new ProgressVideoViewWrapper(new VideoViewTVKImpl(localActivity, String.valueOf(System.identityHashCode(this))));
    } else {
      this.p = new ProgressVideoViewWrapper(new VideoViewTextureImpl(localActivity, String.valueOf(System.identityHashCode(this))));
    }
    SLog.a(this.a, "create video view, use-TVK=%s videoView=%s", Boolean.valueOf(l()), this.p);
    ((ViewGroup)this.b).addView(this.p.a(), 0, new RelativeLayout.LayoutParams(-1, -1));
    a(new VideoViewVideoHolder.13(this));
  }
  
  public void e()
  {
    super.e();
    a(0, true, "unBind");
    StoryNewGuideDialog localStoryNewGuideDialog = this.w;
    if (localStoryNewGuideDialog != null) {
      localStoryNewGuideDialog.dismiss();
    }
  }
  
  public void h()
  {
    if ((this.y == 11) && (r().getVisibility() != 0)) {
      a(10, "call resume");
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    case 2131447048: 
    case 2131447049: 
    default: 
      break;
    case 2131447050: 
      localObject1 = ((VideoServerInfoManager)SuperManager.a(4)).f();
      if ((localObject1 != null) && (this.v != null))
      {
        localObject2 = ((DownloadUrlManager)SuperManager.a(28)).b(URLUtil.a(this.v, "authkey", (String)localObject1).replace("https://", "http://"));
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject1 = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("VideoUrl(");
          localStringBuilder.append(this.c.b);
          localStringBuilder.append(")");
          localObject2 = ClipData.newPlainText(localStringBuilder.toString(), localObject2[0]);
          ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
          ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
          QQToast.makeText(paramView.getContext(), 2131892028, 0).show();
        }
      }
      break;
    case 2131447047: 
      localObject1 = FileCacheUtils.a(this.c.b, 0, false, false);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).setDataAndType(Uri.parse(((File)localObject1).getParent()), "resource/folder");
        try
        {
          if (((Intent)localObject2).resolveActivityInfo(a().getPackageManager(), 0) != null) {
            a((Intent)localObject2);
          } else {
            QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131913631), 0).show();
          }
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          localActivityNotFoundException.printStackTrace();
        }
      }
      break;
    case 2131447046: 
      ClipboardManager localClipboardManager = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("VideoInfo(");
      ((StringBuilder)localObject2).append(this.c.b);
      ((StringBuilder)localObject2).append(")");
      localObject2 = ClipData.newPlainText(((StringBuilder)localObject2).toString(), this.c.b);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, (ClipData)localObject2);
      localClipboardManager.setPrimaryClip((ClipData)localObject2);
      QQToast.makeText(paramView.getContext(), 2131892028, 0).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    if ((this.y == 10) && (r().getVisibility() != 0)) {
      a(11, "call Pause");
    }
  }
  
  public int q()
  {
    if (this.c.d())
    {
      int i = this.y;
      if (i == 10)
      {
        if (this.s.getVisibility() == 0)
        {
          SLog.d(this.a, "toggle video, PLAYING = > PAUSE. ignore because loading while playing");
          return 0;
        }
        SLog.d(this.a, "toggle video, PLAYING = > PAUSE");
        r().setVisibility(0);
        a(11, "toggle pause");
        this.s.setVisibility(8);
        d(0);
        StoryReportor.a("play_video", "exp_tips", 0, 0, new String[] { "", "", "", this.c.b });
        return 2;
      }
      if ((i == 11) && (r().getVisibility() == 0))
      {
        SLog.d(this.a, "toggle video, PAUSE = > PLAYING");
        r().setVisibility(8);
        a(10, "toggle start");
        d(8);
        return 1;
      }
      SLog.d(this.a, "toggle video, ignore. isPlaying=%s, hideCover=%s, visibility=%d", new Object[] { Boolean.valueOf(this.p.i()), Boolean.valueOf(this.R), Integer.valueOf(r().getVisibility()) });
      d(8);
    }
    return 0;
  }
  
  protected View r()
  {
    VideoPauseVideoHolder localVideoPauseVideoHolder = (VideoPauseVideoHolder)a(VideoPauseVideoHolder.class);
    if (localVideoPauseVideoHolder != null) {
      return localVideoPauseVideoHolder.j;
    }
    return new View(a());
  }
  
  protected View s()
  {
    VideoForwardVideoHolder localVideoForwardVideoHolder = (VideoForwardVideoHolder)a(VideoForwardVideoHolder.class);
    if (localVideoForwardVideoHolder != null) {
      return localVideoForwardVideoHolder.b;
    }
    return new View(a());
  }
  
  public boolean t()
  {
    if ((g()) && (f()))
    {
      if (this.f == null) {
        return false;
      }
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      StoryNewGuideDialog localStoryNewGuideDialog;
      if ((this.f.f.size() > 1) && (!localStoryConfigManager.h()))
      {
        p();
        localStoryNewGuideDialog = this.w;
        if (localStoryNewGuideDialog != null) {
          localStoryNewGuideDialog.dismiss();
        }
        this.w = new StoryNewGuideDialog(a());
        this.w.a(true);
        this.w.a(HardCodeUtil.a(2131913621));
        this.w.setOnDismissListener(new VideoViewVideoHolder.OnNewGuideDialogDismissListener(this, this.N));
        this.w.show();
        localStoryConfigManager.a(true);
        return true;
      }
      if ((c().getAdapter().getCount() > 1) && (!localStoryConfigManager.i()))
      {
        p();
        localStoryNewGuideDialog = this.w;
        if (localStoryNewGuideDialog != null) {
          localStoryNewGuideDialog.dismiss();
        }
        this.w = new StoryNewGuideDialog(a());
        this.w.a(HardCodeUtil.a(2131913623));
        this.w.setOnDismissListener(new VideoViewVideoHolder.OnNewGuideDialogDismissListener(this, this.N));
        this.w.show();
        localStoryConfigManager.b(true);
        return true;
      }
    }
    return false;
  }
  
  public void u()
  {
    if (!this.c.d()) {
      return;
    }
    int i = i().mReportData.from;
    if (VideoPlayModeConstants.a(i)) {
      b(this.c, this.p, this.u);
    } else {
      a(this.c, this.p, this.u);
    }
    SLog.a(this.a, "report video player done! vid :%s , from :%d , op_result: %d", this.c.b, Integer.valueOf(i), Integer.valueOf(this.u));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder
 * JD-Core Version:    0.7.0.1
 */