package com.tencent.biz.qqcircle.scrollers;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVoiceEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.timer.IVideoTimerListener;
import com.tencent.biz.qqcircle.richframework.widget.timer.QCircleVideoTimerManager;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBaseVideoPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemVideoPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleTimeLineFeedItemVideoPresenter;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QCircleFeedPlayerScroller
  extends QCircleFeedBaseScroller
  implements IVideoTimerListener
{
  private static boolean g = true;
  private Set<RecyclerView.ViewHolder> h = new HashSet();
  private ArrayList<Integer> i = new ArrayList();
  private HashMap<String, Long> j = new HashMap();
  private String k = "";
  private volatile boolean l = false;
  private boolean m = false;
  private Runnable n = new QCircleFeedPlayerScroller.1(this);
  private Handler o = new Handler(Looper.getMainLooper());
  private QCircleExtraTypeInfo p = new QCircleExtraTypeInfo();
  private boolean q = true;
  private boolean r = true;
  private int s;
  private int t = 0;
  private int u;
  private int v = -1;
  private int w = -1;
  private String x = "";
  private SimpleDateFormat y = null;
  
  public QCircleFeedPlayerScroller(int paramInt)
  {
    this.s = paramInt;
    g = QCirclePluginConfig.a().w();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private QCircleFeedCleanPlayView a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && ((paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))) {
      return (QCircleFeedCleanPlayView)paramFrameLayout.getChildAt(0);
    }
    return null;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 > 0) && (paramInt2 <= paramInt1))
    {
      if (this.y == null) {
        this.y = new SimpleDateFormat("mm:ss");
      }
      return this.y.format(Integer.valueOf(paramInt1 - paramInt2));
    }
    return "";
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    if (paramStFeed.isRecomFd.get()) {
      paramStFeed = paramStFeed.recomForward.id;
    } else {
      paramStFeed = paramStFeed.id;
    }
    return paramStFeed.get();
  }
  
  private void a(FrameLayout paramFrameLayout, String paramString, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramFrameLayout == null) {
      return;
    }
    if (!(paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView)) {
      return;
    }
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = (QCircleFeedCleanPlayView)paramFrameLayout.getChildAt(0);
    if (localQCircleFeedCleanPlayView.z())
    {
      localQCircleFeedCleanPlayView.b();
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = f(paramString);
      if (localQCircleExtraTypeInfo != null) {
        paramFrameLayout = localQCircleExtraTypeInfo.mFeed;
      } else {
        paramFrameLayout = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b(paramFrameLayout).setActionType(8).setSubActionType(5);
      if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null)) {
        paramFrameLayout = localQCircleExtraTypeInfo.mFeed.poster.id.get();
      } else {
        paramFrameLayout = "";
      }
      paramFrameLayout = localDataBuilder.setToUin(paramFrameLayout);
      int i1;
      if (localQCircleExtraTypeInfo != null) {
        i1 = localQCircleExtraTypeInfo.mDataPosition;
      } else {
        i1 = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramFrameLayout.setIndex(i1).setPageId(this.s)));
    }
    QLog.d("QCircleFeedPlayerHelper", 4, new Object[] { "clean player", paramString });
    localQCircleFeedCleanPlayView.release();
    b(f(paramViewHolder), true);
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    int i1;
    if (g) {
      i1 = 2130845374;
    } else {
      i1 = 2130845385;
    }
    paramImageView.setImageResource(i1);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (paramStFeed != null)
    {
      if (paramStFeed.type.get() != 3) {
        return;
      }
      long l1 = 0L;
      String str = QCirclePluginUtil.c(paramStFeed.video.playUrl.get());
      if (this.j.containsKey(str)) {
        l1 = ((Long)this.j.get(str)).longValue();
      }
      this.t = ((int)l1);
      if (!paramBoolean) {
        return;
      }
      a(f(paramViewHolder), str, paramStFeed.id.get());
    }
  }
  
  private void a(QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView)
  {
    paramQCircleFeedCleanPlayView = (FeedCloudMeta.StFeed)paramQCircleFeedCleanPlayView.getData();
    if (paramQCircleFeedCleanPlayView == null) {
      return;
    }
    paramQCircleFeedCleanPlayView = QCirclePluginUtil.c(paramQCircleFeedCleanPlayView.video.playUrl.get());
    if (TextUtils.isEmpty(paramQCircleFeedCleanPlayView)) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoPositionLinkEvent(paramQCircleFeedCleanPlayView, i()));
  }
  
  private void a(QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, String paramString1, String paramString2)
  {
    paramQCircleFeedCleanPlayView.setReportBean(new QCircleReportBean().setPageId(this.s));
    paramQCircleFeedCleanPlayView.setBaseVideoViewListenerSets(new QCircleFeedPlayerScroller.3(this, paramQCircleFeedItemBaseVideoPresenter, paramQCircleFeedCleanPlayView, paramString1, paramString2));
    paramQCircleFeedCleanPlayView.setProgressBar(paramQCircleFeedItemBaseVideoPresenter.mProgressBar);
    paramQCircleFeedCleanPlayView.setLoadingView(paramQCircleFeedItemBaseVideoPresenter.mLoadingProgressView);
    paramQCircleFeedCleanPlayView.setVideoCover(paramQCircleFeedItemBaseVideoPresenter.mVideoCoverImg);
    paramQCircleFeedCleanPlayView.setLoopBack(true);
    paramQCircleFeedCleanPlayView.setOutPutMute(q());
    QLog.d("QCircleFeedPlayerHelper", 1, "onInitSuccess");
  }
  
  private void a(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, String paramString)
  {
    if (TextUtils.equals(this.x, paramString)) {
      return;
    }
    if (paramQCircleFeedItemBaseVideoPresenter.mProgressText != null)
    {
      paramQCircleFeedItemBaseVideoPresenter.mProgressText.setText(paramString);
      this.x = paramString;
    }
  }
  
  private void a(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, String paramString1, String paramString2)
  {
    if (paramQCircleFeedItemBaseVideoPresenter == null)
    {
      QLog.e("QCircleFeedPlayerHelper", 1, "video presenter is empty");
      return;
    }
    if ((this.b != null) && (this.m))
    {
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        QCircleToast.a(HardCodeUtil.a(2131911960), 0);
        QLog.d("QCircleFeedPlayerHelper", 1, "network not available");
        return;
      }
      if (!g(paramString2)) {
        return;
      }
      Object localObject1 = b(paramString2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("has local cache, feed play local url: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = (String)localObject1;
      }
      paramString1 = QCirclePluginUtil.c(paramString1);
      localObject1 = paramQCircleFeedItemBaseVideoPresenter.mPlayerContainer;
      Object localObject2 = paramQCircleFeedItemBaseVideoPresenter.getFeedData();
      if ((!TextUtils.isEmpty(paramString1)) && (localObject1 != null) && (localObject2 != null))
      {
        a(paramQCircleFeedItemBaseVideoPresenter, paramString2, paramString1, (FrameLayout)localObject1, (FeedCloudMeta.StFeed)localObject2);
        paramQCircleFeedItemBaseVideoPresenter = new StringBuilder();
        paramQCircleFeedItemBaseVideoPresenter.append("playInner mCurrentPlayerFeedId: ");
        paramQCircleFeedItemBaseVideoPresenter.append(this.k);
        QLog.d("QCircleFeedPlayerHelper", 4, paramQCircleFeedItemBaseVideoPresenter.toString());
        return;
      }
      QLog.d("QCircleFeedPlayerHelper", 4, "vid is empty");
      return;
    }
    QLog.d("QCircleFeedPlayerHelper", 4, "mRecyclerView is empty");
  }
  
  private void a(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, String paramString1, String paramString2, FrameLayout paramFrameLayout, FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramFrameLayout, paramString1, d(paramString1));
    paramFrameLayout = (QCircleFeedCleanPlayView)paramFrameLayout.getChildAt(0);
    paramFrameLayout.setData(paramStFeed);
    paramFrameLayout.setInitListener(new QCircleFeedPlayerScroller.2(this, paramFrameLayout, paramQCircleFeedItemBaseVideoPresenter, paramString1, paramString2));
    paramFrameLayout.setVideoPath(paramStFeed.video, this.t);
    b(paramQCircleFeedItemBaseVideoPresenter);
    this.t = 0;
    this.k = paramString1;
    a(paramQCircleFeedItemBaseVideoPresenter.mVoiceIcon);
    n();
  }
  
  private void a(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, boolean paramBoolean)
  {
    if (paramQCircleFeedItemBaseVideoPresenter == null) {
      return;
    }
    Object localObject = paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg;
    int i2 = 0;
    if (localObject != null) {
      if ((paramBoolean) && (a(paramQCircleFeedItemBaseVideoPresenter))) {
        paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg.setVisibility(0);
      } else {
        paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg.setVisibility(8);
      }
    }
    int i1;
    if (paramQCircleFeedItemBaseVideoPresenter.mVideoCoverImg != null)
    {
      localObject = paramQCircleFeedItemBaseVideoPresenter.mVideoCoverImg;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((URLImageView)localObject).setVisibility(i1);
    }
    if (paramQCircleFeedItemBaseVideoPresenter.mProgressText != null)
    {
      localObject = paramQCircleFeedItemBaseVideoPresenter.mProgressText;
      if (paramBoolean) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      ((TextView)localObject).setVisibility(i1);
    }
    if (paramQCircleFeedItemBaseVideoPresenter.mVoiceIcon != null)
    {
      paramQCircleFeedItemBaseVideoPresenter = paramQCircleFeedItemBaseVideoPresenter.mVoiceIcon;
      i1 = i2;
      if (paramBoolean) {
        i1 = 8;
      }
      paramQCircleFeedItemBaseVideoPresenter.setVisibility(i1);
    }
  }
  
  private void a(String paramString)
  {
    this.o.post(new QCircleFeedPlayerScroller.4(this, paramString));
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
    QCirclePluginConfig localQCirclePluginConfig = QCirclePluginConfig.a();
    if (localQCirclePluginConfig != null) {
      localQCirclePluginConfig.b(paramBoolean);
    }
  }
  
  private boolean a(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter)
  {
    if ((paramQCircleFeedItemBaseVideoPresenter instanceof QCircleFeedItemVideoPresenter)) {
      return QCircleConfigHelper.q() ^ true;
    }
    if ((paramQCircleFeedItemBaseVideoPresenter instanceof QCircleTimeLineFeedItemVideoPresenter)) {}
    return true;
  }
  
  private boolean a(QCircleInsFeedItemView paramQCircleInsFeedItemView)
  {
    Object localObject1 = ((FeedBlockData)paramQCircleInsFeedItemView.getData()).b();
    if (((FeedCloudMeta.StFeed)localObject1).type.get() != 3) {
      return false;
    }
    Object localObject2 = paramQCircleInsFeedItemView.getVideoPresenter().mPlayerContainer;
    if (!a((View)localObject2)) {
      return false;
    }
    localObject2 = ((FrameLayout)localObject2).getChildAt(0);
    if (!(localObject2 instanceof QCircleFeedCleanPlayView)) {
      return false;
    }
    localObject2 = (QCircleFeedCleanPlayView)localObject2;
    if (this.k.equals(a((FeedCloudMeta.StFeed)localObject1)))
    {
      if (((QCircleFeedCleanPlayView)localObject2).A())
      {
        ((QCircleFeedCleanPlayView)localObject2).setIsAutoPlay(true);
        ((QCircleFeedCleanPlayView)localObject2).h();
        ((QCircleFeedCleanPlayView)localObject2).setOutPutMute(q());
        a(paramQCircleInsFeedItemView.getVideoPresenter(), false);
        localObject1 = f(((FeedCloudMeta.StFeed)localObject1).id.get());
        if (localObject1 != null) {
          paramQCircleInsFeedItemView = ((QCircleExtraTypeInfo)localObject1).mFeed;
        } else {
          paramQCircleInsFeedItemView = null;
        }
        localObject2 = QCirclePluginReportUtil.b(paramQCircleInsFeedItemView).setActionType(8).setSubActionType(4);
        if ((localObject1 != null) && (((QCircleExtraTypeInfo)localObject1).mFeed != null)) {
          paramQCircleInsFeedItemView = ((QCircleExtraTypeInfo)localObject1).mFeed.poster.id.get();
        } else {
          paramQCircleInsFeedItemView = "";
        }
        paramQCircleInsFeedItemView = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin(paramQCircleInsFeedItemView);
        int i1;
        if (localObject1 != null) {
          i1 = ((QCircleExtraTypeInfo)localObject1).mDataPosition;
        } else {
          i1 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramQCircleInsFeedItemView.setIndex(i1).setPageId(this.s)));
        return true;
      }
    }
    else {
      a(paramQCircleInsFeedItemView.getVideoPresenter(), ((FeedCloudMeta.StFeed)localObject1).video.playUrl.get(), a((FeedCloudMeta.StFeed)localObject1));
    }
    return true;
  }
  
  private boolean a(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView)
  {
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)paramQCircleTimeLineFeedItemView.getData()).b();
    if (localStFeed.type.get() != 3)
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine is not video type");
      return false;
    }
    Object localObject = paramQCircleTimeLineFeedItemView.getVideoPresenter().mPlayerContainer.getChildAt(0);
    if (!(localObject instanceof QCircleFeedCleanPlayView)) {
      return false;
    }
    localObject = (QCircleFeedCleanPlayView)localObject;
    if (this.k.equals(a(localStFeed)))
    {
      if (((QCircleFeedCleanPlayView)localObject).A())
      {
        ((QCircleFeedCleanPlayView)localObject).setIsAutoPlay(true);
        ((QCircleFeedCleanPlayView)localObject).h();
        ((QCircleFeedCleanPlayView)localObject).setOutPutMute(q());
        a(paramQCircleTimeLineFeedItemView.getVideoPresenter(), false);
        QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView is isPausing reStart");
        return true;
      }
    }
    else
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView data change reCreate");
      a(paramQCircleTimeLineFeedItemView.getVideoPresenter(), localStFeed.video.playUrl.get(), a(localStFeed));
    }
    return true;
  }
  
  private String b(String paramString)
  {
    paramString = QCirclePluginGlobalInfo.b(paramString);
    if (paramString != null) {
      return paramString.video.playUrl.get();
    }
    return "";
  }
  
  private void b(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter)
  {
    if (paramQCircleFeedItemBaseVideoPresenter.mProgressBar != null) {
      paramQCircleFeedItemBaseVideoPresenter.mProgressBar.setVisibility(0);
    }
  }
  
  private void b(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, boolean paramBoolean)
  {
    if (paramQCircleFeedItemBaseVideoPresenter == null) {
      return;
    }
    ImageView localImageView = paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg;
    int i1 = 0;
    if (localImageView != null) {
      if ((paramBoolean) && (a(paramQCircleFeedItemBaseVideoPresenter))) {
        paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg.setVisibility(0);
      } else {
        paramQCircleFeedItemBaseVideoPresenter.mPlayIconImg.setVisibility(8);
      }
    }
    if (paramQCircleFeedItemBaseVideoPresenter.mVideoCoverImg != null)
    {
      paramQCircleFeedItemBaseVideoPresenter = paramQCircleFeedItemBaseVideoPresenter.mVideoCoverImg;
      if (!paramBoolean) {
        i1 = 8;
      }
      paramQCircleFeedItemBaseVideoPresenter.setVisibility(i1);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = d(this.k);
    Object localObject2 = e((RecyclerView.ViewHolder)localObject1);
    if ((localObject2 != null) && ((((FrameLayout)localObject2).getChildAt(0) instanceof QCircleFeedCleanPlayView)) && (a(((FrameLayout)localObject2).getChildAt(0))))
    {
      localObject2 = (QCircleFeedCleanPlayView)((FrameLayout)localObject2).getChildAt(0);
      if ((((QCircleFeedCleanPlayView)localObject2).z()) && (f((RecyclerView.ViewHolder)localObject1) != null))
      {
        ((QCircleFeedCleanPlayView)localObject2).setOutPutMute(paramBoolean);
        a(f((RecyclerView.ViewHolder)localObject1).mVoiceIcon);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("changeCurrentVoice():");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      QLog.d("QCircleFeedPlayerHelper", 1, "changeCurrentVoice():no Player");
      return;
    }
    QLog.d("QCircleFeedPlayerHelper", 1, "changeCurrentVoice():no Player");
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = a(e(paramViewHolder));
    if (localObject == null)
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "[hideVideoCover] play view should not be null.");
      return;
    }
    ((QCircleFeedCleanPlayView)localObject).setSupportSeek(false);
    if (!((QCircleFeedCleanPlayView)localObject).z())
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "[hideVideoCover] current play view state not is playing, return flow.");
      return;
    }
    localObject = ((QCircleFeedCleanPlayView)localObject).getVideoCover();
    if (localObject != null) {
      ((URLImageView)localObject).setVisibility(8);
    }
    a(f(paramViewHolder), false);
  }
  
  private void c(String paramString)
  {
    RecyclerView.ViewHolder localViewHolder = d(paramString);
    Object localObject = e(localViewHolder);
    if (localObject == null) {
      return;
    }
    if (!(((FrameLayout)localObject).getChildAt(0) instanceof QCircleFeedCleanPlayView)) {
      return;
    }
    localObject = (QCircleFeedCleanPlayView)((FrameLayout)localObject).getChildAt(0);
    if (((QCircleFeedCleanPlayView)localObject).z())
    {
      ((QCircleFeedCleanPlayView)localObject).b();
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = f(paramString);
      if (localQCircleExtraTypeInfo != null) {
        paramString = localQCircleExtraTypeInfo.mFeed;
      } else {
        paramString = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b(paramString).setActionType(8).setSubActionType(5);
      if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null)) {
        paramString = localQCircleExtraTypeInfo.mFeed.poster.id.get();
      } else {
        paramString = "";
      }
      paramString = localDataBuilder.setToUin(paramString);
      int i1;
      if (localQCircleExtraTypeInfo != null) {
        i1 = localQCircleExtraTypeInfo.mDataPosition;
      } else {
        i1 = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramString.setIndex(i1).setPageId(this.s)));
    }
    ((QCircleFeedCleanPlayView)localObject).release();
    a(f(localViewHolder), true);
  }
  
  private boolean c(View paramView)
  {
    if (!this.m) {
      return false;
    }
    if (!QCircleConfigHelper.q())
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "not wifi autoPlay return");
      return true;
    }
    if ((paramView instanceof QCircleInsFeedItemView)) {
      return a((QCircleInsFeedItemView)paramView);
    }
    if ((paramView instanceof QCircleTimeLineFeedItemView)) {
      return a((QCircleTimeLineFeedItemView)paramView);
    }
    return false;
  }
  
  private RecyclerView.ViewHolder d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if ((paramString.equals(a(g(localViewHolder)))) && (localViewHolder.getLayoutPosition() != -1)) {
        return localViewHolder;
      }
    }
    return null;
  }
  
  private boolean d(int paramInt)
  {
    return paramInt == this.s;
  }
  
  private boolean d(View paramView)
  {
    boolean bool3 = paramView instanceof BaseWidgetView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramView = (BaseWidgetView)paramView;
      bool1 = bool2;
      if ((paramView.getData() instanceof FeedBlockData))
      {
        bool1 = bool2;
        if (((FeedBlockData)paramView.getData()).b().type.get() == 3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean d(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return false;
    }
    return d(paramViewHolder.itemView);
  }
  
  private FrameLayout e(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return null;
    }
    if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((QCircleInsFeedItemView)paramViewHolder.itemView).getVideoPresenter() != null)) {
      return ((QCircleInsFeedItemView)paramViewHolder.itemView).getVideoPresenter().mPlayerContainer;
    }
    if (((paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && (((QCircleTimeLineFeedItemView)paramViewHolder.itemView).getVideoPresenter() != null)) {
      return ((QCircleTimeLineFeedItemView)paramViewHolder.itemView).getVideoPresenter().mPlayerContainer;
    }
    return null;
  }
  
  private QCircleFeedCleanPlayView e(String paramString)
  {
    return a(e(d(paramString)));
  }
  
  private QCircleExtraTypeInfo f(String paramString)
  {
    paramString = d(paramString);
    if ((paramString != null) && ((paramString.itemView instanceof QCircleInsFeedItemView)))
    {
      this.p.mFeed = ((FeedBlockData)((QCircleInsFeedItemView)paramString.itemView).getData()).b();
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.p;
      localQCircleExtraTypeInfo.mPlayScene = 1;
      localQCircleExtraTypeInfo.mDataPosition = ((QCircleInsFeedItemView)paramString.itemView).getPosition();
    }
    return this.p;
  }
  
  private QCircleFeedItemBaseVideoPresenter f(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return null;
    }
    if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((QCircleInsFeedItemView)paramViewHolder.itemView).getVideoPresenter() != null)) {
      return ((QCircleInsFeedItemView)paramViewHolder.itemView).getVideoPresenter();
    }
    if (((paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && (((QCircleTimeLineFeedItemView)paramViewHolder.itemView).getVideoPresenter() != null)) {
      return ((QCircleTimeLineFeedItemView)paramViewHolder.itemView).getVideoPresenter();
    }
    return null;
  }
  
  private FeedCloudMeta.StFeed g(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).getData() instanceof FeedBlockData))) {
      return ((FeedBlockData)((BaseWidgetView)paramViewHolder.itemView).getData()).b();
    }
    return null;
  }
  
  private boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("qcircle_fakeid_"))
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "NOT FAKE FEED CAN PLAY");
      return true;
    }
    int i1 = QCirclePluginGlobalInfo.d(paramString).intValue();
    if ((i1 != 2) && (i1 != 5))
    {
      QLog.d("QCircleFeedPlayerHelper", 1, "FAKE FEED NOT READY");
      return false;
    }
    QLog.d("QCircleFeedPlayerHelper", 1, "FAKE FEED IS READY");
    return true;
  }
  
  public static void j()
  {
    g = true;
  }
  
  private void k()
  {
    Object localObject1 = (SafeStaggeredGridLayoutManager)this.b.getLayoutManager();
    Object localObject2 = ((SafeStaggeredGridLayoutManager)localObject1).findFirstVisibleItemPositions(null);
    int[] arrayOfInt = ((SafeStaggeredGridLayoutManager)localObject1).findLastVisibleItemPositions(null);
    int i2 = localObject2[0];
    int i3 = arrayOfInt[0];
    if (i2 <= i3)
    {
      int i1 = i2;
      while (i1 <= i3)
      {
        localObject2 = ((SafeStaggeredGridLayoutManager)localObject1).findViewByPosition(i1);
        if ((localObject2 != null) && (c((View)localObject2)))
        {
          this.u = i1;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("currentPlayIndex:");
          ((StringBuilder)localObject1).append(this.u);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append("  ");
          ((StringBuilder)localObject1).append(i3);
          QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void l()
  {
    SafeGridLayoutManager localSafeGridLayoutManager = (SafeGridLayoutManager)this.b.getLayoutManager();
    if (localSafeGridLayoutManager.getSpanCount() > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unSupportSpanCount:");
      ((StringBuilder)localObject).append(localSafeGridLayoutManager.getSpanCount());
      QLog.e("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    int i1 = localSafeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
    int i2 = localSafeGridLayoutManager.findLastCompletelyVisibleItemPosition();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("firstVisibilityPos:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("    lastVisibilityPos");
    ((StringBuilder)localObject).append(i2);
    QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject).toString());
    if (i1 <= i2)
    {
      this.i.clear();
      while (i1 <= i2)
      {
        localObject = localSafeGridLayoutManager.findViewByPosition(i1);
        if (d((View)localObject))
        {
          this.i.add(Integer.valueOf(i1));
          if ((b((View)localObject)) && (c((View)localObject)))
          {
            this.u = i1;
            i1 = 1;
            break label203;
          }
        }
        i1 += 1;
      }
      i1 = 0;
      label203:
      if ((i1 == 0) && (this.i.size() > 0))
      {
        i1 = ((Integer)this.i.get(0)).intValue();
        if ((i1 == 0) && (c(localSafeGridLayoutManager.findViewByPosition(i1))))
        {
          this.u = i1;
          return;
        }
        localObject = this.i;
        i1 = ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue();
        if (c(localSafeGridLayoutManager.findViewByPosition(i1))) {
          this.u = i1;
        }
      }
    }
  }
  
  private void m()
  {
    Object localObject = (SafeLinearLayoutManager)this.b.getLayoutManager();
    int i2 = ((SafeLinearLayoutManager)localObject).findFirstVisibleItemPosition();
    int i3 = ((SafeLinearLayoutManager)localObject).findLastVisibleItemPosition();
    if (i2 <= i3)
    {
      int i1 = i2;
      while (i1 <= i3)
      {
        View localView = ((SafeLinearLayoutManager)localObject).findViewByPosition(i1);
        if ((localView != null) && (c(localView)))
        {
          this.u = i1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("currentPlayIndex:");
          ((StringBuilder)localObject).append(this.u);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append("  ");
          ((StringBuilder)localObject).append(i3);
          QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject).toString());
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void n()
  {
    RecyclerView.ViewHolder localViewHolder1 = d(this.k);
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)localIterator.next();
      if (localViewHolder2 != localViewHolder1)
      {
        FeedCloudMeta.StFeed localStFeed = g(localViewHolder2);
        if ((localStFeed != null) && (!this.k.equals(a(localStFeed)))) {
          a(e(localViewHolder2), a(localStFeed), localViewHolder2);
        }
      }
    }
  }
  
  private void o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" make sure task clear");
    QLog.d("QCircleFeedPlayerHelper", 1, localStringBuilder.toString());
    p();
    if ((!this.l) && (f()))
    {
      QCircleVideoTimerManager.a().a(this);
      this.l = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" start schedule task");
      QLog.d("QCircleFeedPlayerHelper", 1, localStringBuilder.toString());
    }
  }
  
  private void p()
  {
    if (!this.l) {
      return;
    }
    QCircleVideoTimerManager.a().b(this);
    Object localObject = this.n;
    if (localObject != null) {
      this.o.removeCallbacks((Runnable)localObject);
    }
    this.l = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" cancel task");
    QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean q()
  {
    if (this.q) {
      return g;
    }
    return this.r;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt)
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "triggerSlowScroll");
    h();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!d(paramViewHolder)) {
      return;
    }
    if (f(paramViewHolder) != null) {
      f(paramViewHolder).setPlayHelper(this);
    }
    Object localObject = g(paramViewHolder);
    this.h.add(paramViewHolder);
    a(e(paramViewHolder), a((FeedCloudMeta.StFeed)localObject), paramViewHolder);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bind position:");
    ((StringBuilder)localObject).append(paramViewHolder.getAdapterPosition());
    QLog.d("QCircleFeedPlayerHelper", 4, ((StringBuilder)localObject).toString());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    if (!d(paramViewHolder)) {
      return;
    }
    if (f(paramViewHolder) != null) {
      f(paramViewHolder).setPlayHelper(this);
    }
    if (paramStFeed == null) {
      return;
    }
    paramStFeed = a(paramStFeed);
    RecyclerView.ViewHolder localViewHolder = d(this.k);
    if (localViewHolder == paramViewHolder)
    {
      c(paramViewHolder);
      return;
    }
    if (localViewHolder == null) {
      o();
    }
    this.h.add(paramViewHolder);
    a(e(paramViewHolder), paramStFeed, paramViewHolder);
    paramStFeed = new StringBuilder();
    paramStFeed.append("onDataBind");
    paramStFeed.append(paramViewHolder.getAdapterPosition());
    QLog.d("QCircleFeedPlayerHelper", 4, paramStFeed.toString());
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    g();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0)
    {
      this.a.b();
      h();
    }
  }
  
  public void a(QCircleFeedItemVideoPresenter paramQCircleFeedItemVideoPresenter, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    String str = paramStFeed.video.playUrl.get();
    if (!TextUtils.isEmpty(str)) {
      a(paramQCircleFeedItemVideoPresenter, str, a(paramStFeed));
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, ImageView paramImageView, int paramInt)
  {
    if (paramStFeed == null) {
      return;
    }
    Object localObject = e(a(paramStFeed));
    if (localObject == null) {
      return;
    }
    g = ((QCircleFeedCleanPlayView)localObject).getOutPutMute() ^ true;
    ((QCircleFeedCleanPlayView)localObject).setOutPutMute(g);
    this.r = g;
    QCirclePluginConfig.a().b(g);
    localObject = new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramStFeed).setToUin(paramStFeed.poster.id.get()));
    int i1 = 8;
    localObject = ((QCircleLpReportDc05501.DataBuilder)localObject).setActionType(8);
    if (g) {
      i1 = 9;
    }
    localObject = ((QCircleLpReportDc05501.DataBuilder)localObject).setSubActionType(i1).setIndex(paramInt).setExt2(paramStFeed.recomInfo.recomReason.get());
    if (d(1)) {
      paramStFeed = "1";
    } else {
      paramStFeed = "2";
    }
    QCircleLpReportDc05501.report(((QCircleLpReportDc05501.DataBuilder)localObject).setExt4(paramStFeed).setPageId(this.s));
    a(paramImageView);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.j.containsKey(paramString)) {
      this.j.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("useGlobalVoiceControl:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isVoiceMute:");
    localStringBuilder.append(paramBoolean2);
    QLog.d("QCircleFeedPlayerHelper", 1, localStringBuilder.toString());
    this.q = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  public void b()
  {
    this.m = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResume mCurrentPlayFeedTag:");
    ((StringBuilder)localObject1).append(this.k);
    QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject1).toString());
    localObject1 = d(this.k);
    Object localObject2 = e((RecyclerView.ViewHolder)localObject1);
    FeedCloudMeta.StFeed localStFeed = g((RecyclerView.ViewHolder)localObject1);
    if ((localObject2 != null) && ((((FrameLayout)localObject2).getChildAt(0) instanceof QCircleFeedCleanPlayView)) && (a(((FrameLayout)localObject2).getChildAt(0))))
    {
      if ((!((QCircleFeedCleanPlayView)((FrameLayout)localObject2).getChildAt(0)).z()) && (f((RecyclerView.ViewHolder)localObject1) != null))
      {
        a((RecyclerView.ViewHolder)localObject1, localStFeed, true);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onResume play video position:");
        ((StringBuilder)localObject2).append(((RecyclerView.ViewHolder)localObject1).getAdapterPosition());
        QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      a((RecyclerView.ViewHolder)localObject1, localStFeed, false);
      o();
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!d(paramViewHolder)) {
      return;
    }
    Object localObject = g(paramViewHolder);
    if (localObject == null) {
      return;
    }
    c(a((FeedCloudMeta.StFeed)localObject));
    if (this.k.equals(a((FeedCloudMeta.StFeed)localObject))) {
      this.k = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unbind view position:");
    ((StringBuilder)localObject).append(paramViewHolder.getAdapterPosition());
    QLog.d("QCircleFeedPlayerHelper", 4, ((StringBuilder)localObject).toString());
  }
  
  public void c()
  {
    this.m = false;
    p();
    Object localObject = e(this.k);
    if ((localObject != null) && ((((QCircleFeedCleanPlayView)localObject).z()) || (!((QCircleFeedCleanPlayView)localObject).A())))
    {
      a((QCircleFeedCleanPlayView)localObject);
      ((QCircleFeedCleanPlayView)localObject).release();
      b(f(d(this.k)), true);
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = f(this.k);
      if (localQCircleExtraTypeInfo != null) {
        localObject = localQCircleExtraTypeInfo.mFeed;
      } else {
        localObject = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(8).setSubActionType(5);
      if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null)) {
        localObject = localQCircleExtraTypeInfo.mFeed.poster.id.get();
      } else {
        localObject = "";
      }
      localObject = localDataBuilder.setToUin((String)localObject);
      int i1;
      if (localQCircleExtraTypeInfo != null) {
        i1 = localQCircleExtraTypeInfo.mDataPosition;
      } else {
        i1 = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i1).setPageId(this.s)));
    }
  }
  
  public void c(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void e()
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "onDestroy");
    this.k = "";
    n();
    this.h.clear();
    this.j.clear();
    p();
    this.o.removeCallbacksAndMessages(null);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void g()
  {
    Object localObject1 = e(this.k);
    if (localObject1 != null)
    {
      if (a((View)localObject1)) {
        return;
      }
      if (((QCircleFeedCleanPlayView)localObject1).z())
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkPause stopPlay");
        ((StringBuilder)localObject2).append(this.k);
        QLog.d("QCircleFeedPlayerHelper", 1, ((StringBuilder)localObject2).toString());
        ((QCircleFeedCleanPlayView)localObject1).b();
        localObject2 = f(this.k);
        if (localObject2 != null) {
          localObject1 = ((QCircleExtraTypeInfo)localObject2).mFeed;
        } else {
          localObject1 = null;
        }
        QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(8).setSubActionType(5);
        if ((localObject2 != null) && (((QCircleExtraTypeInfo)localObject2).mFeed != null)) {
          localObject1 = ((QCircleExtraTypeInfo)localObject2).mFeed.poster.id.get();
        } else {
          localObject1 = "";
        }
        localObject1 = localDataBuilder.setToUin((String)localObject1);
        int i1;
        if (localObject2 != null) {
          i1 = ((QCircleExtraTypeInfo)localObject2).mDataPosition;
        } else {
          i1 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(i1).setPageId(this.s)));
      }
      a(f(d(this.k)), true);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVoiceEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    try
    {
      if (this.b == null) {
        return;
      }
      if ((this.b.getLayoutManager() instanceof SafeStaggeredGridLayoutManager))
      {
        k();
        return;
      }
      if ((this.b.getLayoutManager() instanceof SafeGridLayoutManager))
      {
        l();
        return;
      }
      if ((this.b.getLayoutManager() instanceof SafeLinearLayoutManager))
      {
        m();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public long i()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = e(this.k);
    if ((localQCircleFeedCleanPlayView != null) && (localQCircleFeedCleanPlayView.getSuperPlayer() != null)) {
      return localQCircleFeedCleanPlayView.getSuperPlayer().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedVoiceEvent))
    {
      int i1 = ((QCircleFeedVoiceEvent)paramSimpleBaseEvent).getEvent();
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        b(false);
        return;
      }
      b(true);
    }
  }
  
  public void x()
  {
    this.o.post(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller
 * JD-Core Version:    0.7.0.1
 */