package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.KeyBoardUpCallback;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.FeedCommentLikeLego;
import com.tencent.biz.qqstory.comment.FeedCommentLikeLego.MainWidgetClickListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter.HotRecommendFeedAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter.HotRecommendFeedAdapter.OnSubscribeClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.TraceUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class FeedSegment
  extends SegmentView<HomeFeedData>
  implements Handler.Callback, FeedCommentEventHandler.KeyBoardUpCallback, FeedCommentLikeLego.MainWidgetClickListener, HomeFeedPresenter.HomeFeedPresenterListener, QQStoryAutoPlayView.StoryCoverClickListener, HotRecommendFeedAdapter.OnSubscribeClickListener, IEventReceiver
{
  private static Drawable K = new EmptyDrawable(-2631721, 180, 320);
  public static final String KEY = "FeedSegment";
  private static Drawable L = new EmptyDrawable(-2631721, 180, 320);
  private FeedSegment.GetVideoBasicInfoListReceiver A;
  private FeedSegment.TroopNickNameUpdateEventReceiver B;
  private FeedSegment.DeleteShareGroupMemberEventReceiver C;
  private FeedSegment.PlayVideoChangeReceiver D;
  private FeedSegment.GetUserInfoReceiver E;
  private LruCache<String, QQUserUIItem> F = new LruCache(1024);
  private FeedManager G;
  private final int H;
  private final int I;
  private boolean J = false;
  private boolean M = false;
  private int N = -1;
  private int O = -1;
  private long P = -1L;
  private int Q = -1;
  private boolean R = false;
  private INetInfoHandler S = new FeedSegment.10(this);
  protected int a;
  protected HomeFeedPresenter b;
  protected AutoPlayManager c;
  protected Map<String, Integer> d = new HashMap();
  protected AtomicBoolean e = new AtomicBoolean(true);
  ChildViewClickListener f = new FeedSegment.2(this);
  ChildViewClickListener g = new FeedSegment.3(this);
  ChildViewClickListener h = new FeedSegment.4(this);
  ChildViewClickListener i = new FeedSegment.5(this);
  public String j;
  public String k;
  private boolean n = true;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r;
  private StoryHomeFeed s;
  private Handler t;
  private UserManager u;
  private Activity v;
  private IMyStoryListView w;
  private QQStoryAutoPlayView x;
  private List<BaseViewHolder> y;
  private FeedSegment.StoryVideoDownloadedReceiver z;
  
  public FeedSegment(Context paramContext, Activity paramActivity, int paramInt, IMyStoryListView paramIMyStoryListView, boolean paramBoolean)
  {
    super(paramContext);
    this.v = paramActivity;
    this.w = paramIMyStoryListView;
    this.a = paramInt;
    this.q = paramBoolean;
    QQStoryContext.a();
    this.p = ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null);
    this.b = b(paramBoolean);
    this.t = new Handler(Looper.getMainLooper(), this);
    this.y = new ArrayList();
    this.z = new FeedSegment.StoryVideoDownloadedReceiver(this);
    this.A = new FeedSegment.GetVideoBasicInfoListReceiver(this);
    this.E = new FeedSegment.GetUserInfoReceiver(this);
    this.B = new FeedSegment.TroopNickNameUpdateEventReceiver(this);
    this.C = new FeedSegment.DeleteShareGroupMemberEventReceiver(this);
    this.D = new FeedSegment.PlayVideoChangeReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.z);
    StoryDispatcher.a().registerSubscriber(this.A);
    StoryDispatcher.a().registerSubscriber(this.E);
    StoryDispatcher.a().registerSubscriber(this.B);
    StoryDispatcher.a().registerSubscriber(this.C);
    StoryDispatcher.a().registerSubscriber(this.D);
    this.c = new AutoPlayManager(Looper.myLooper());
    this.b.a();
    this.u = ((UserManager)SuperManager.a(2));
    this.G = ((FeedManager)SuperManager.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.S);
    paramInt = this.a;
    if (paramInt == 10) {
      this.c.a(1);
    } else if (paramInt == 11) {
      this.c.a(2);
    } else if (paramInt == 12) {
      this.c.a(3);
    }
    this.r = false;
    this.H = paramContext.getResources().getDimensionPixelSize(2131299306);
    this.I = paramContext.getResources().getDimensionPixelSize(2131299317);
  }
  
  private int A()
  {
    if (System.currentTimeMillis() - this.P < 100L)
    {
      m = this.Q;
      if ((m != -1) && (m != 0))
      {
        this.P = System.currentTimeMillis();
        return this.Q;
      }
    }
    int i1 = UIUtils.e(this.l);
    int i2 = w().getFirstVisiblePosition();
    int m = i1 + 1;
    if (w().getChildAt(0) != null) {
      m = w().getChildAt(0).getTop();
    }
    this.P = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollToWhere firstIndex=");
    localStringBuilder.append(i2);
    localStringBuilder.append(",lastFirstIndex=");
    localStringBuilder.append(this.N);
    localStringBuilder.append(",firstTopY=");
    localStringBuilder.append(m);
    localStringBuilder.append(",lastFirstTopY=");
    localStringBuilder.append(this.O);
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    int i3 = this.N;
    if (i2 == i3)
    {
      if (m <= i1)
      {
        i3 = this.O;
        if (i3 <= i1)
        {
          if (m > i3)
          {
            this.O = m;
            this.N = i2;
            return 2;
          }
          if (m >= i3) {
            break label297;
          }
          this.O = m;
          this.N = i2;
          return 1;
        }
      }
      this.O = m;
      this.N = i2;
      return 0;
    }
    else
    {
      if (i2 > i3)
      {
        this.O = m;
        this.N = i2;
        return 1;
      }
      if (i2 < i3)
      {
        this.O = m;
        this.N = i2;
        return 2;
      }
    }
    label297:
    this.O = m;
    this.N = i2;
    return 0;
  }
  
  private void B()
  {
    if (StoryDepends.a()) {
      return;
    }
    InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.R), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.M) });
    if ((this.R) && (this.M))
    {
      Object localObject2 = p();
      Object localObject1 = new Rect();
      if (localObject2 != null)
      {
        boolean bool = ((View)localObject2).getGlobalVisibleRect((Rect)localObject1);
        int[] arrayOfInt = new int[2];
        ((View)localObject2).getLocationInWindow(arrayOfInt);
        InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131902486), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
        InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131902493), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject2).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject2).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject2)) });
      }
      else
      {
        SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
      }
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131902487), Integer.valueOf(((Rect)localObject1).top), ",bottom:", Integer.valueOf(((Rect)localObject1).bottom) });
      this.R = false;
      localObject2 = this.t;
      ((Handler)localObject2).sendMessage(((Handler)localObject2).obtainMessage(13, localObject1));
      localObject1 = (NewMyStorySegment)w().b("NewMyStorySegment");
      if (localObject1 != null) {
        ((NewMyStorySegment)localObject1).a(false);
      }
      w().setSelection(0);
    }
  }
  
  public static int a(Context paramContext)
  {
    if (NetworkUtil.isWifiConnected(paramContext)) {
      return 1;
    }
    if (NetworkUtil.isMobileNetWork(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, GeneralRecommendHomeFeed paramGeneralRecommendHomeFeed)
  {
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442660);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131442664);
    b(paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.p);
    a(paramInt, paramBaseViewHolder, paramGeneralRecommendHomeFeed, paramGeneralRecommendHomeFeed.h().getOwner());
    a(paramBaseViewHolder, paramGeneralRecommendHomeFeed, true);
    a(paramGeneralRecommendHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    if (this.p) {
      paramInt = this.l.getResources().getColor(2131168130);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", paramGeneralRecommendHomeFeed.h().feedId);
    a(paramGeneralRecommendHomeFeed, paramBaseViewHolder, localFrameLayout, null);
    if (!paramGeneralRecommendHomeFeed.g) {
      StoryReportor.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramGeneralRecommendHomeFeed.h().getOwner().getUnionId(), paramGeneralRecommendHomeFeed.h().feedId });
    }
    paramViewGroup = paramGeneralRecommendHomeFeed.h().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      StoryReportor.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, HotRecommendHomeFeed paramHotRecommendHomeFeed)
  {
    paramViewGroup = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    Object localObject1 = paramViewGroup.getSingleVideoView();
    Object localObject2 = paramViewGroup.getTimeView();
    paramViewGroup.getInfoView().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(UIUtils.a(this.l, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject2 = paramViewGroup.getVideoListView();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.f, paramBaseViewHolder);
    if ((paramHotRecommendHomeFeed.a() != null) && (paramHotRecommendHomeFeed.a().size() != 0))
    {
      paramBaseViewHolder.a.setVisibility(0);
      ((StoryHomeHorizontalListView)localObject2).setVisibility(0);
      localObject1 = (HotRecommendFeedAdapter)paramBaseViewHolder.a("general_adapter");
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null)
      {
        paramViewGroup = new HotRecommendFeedAdapter(this.l, this.v, this.a);
        paramBaseViewHolder.a("general_adapter", paramViewGroup);
        ((StoryHomeHorizontalListView)localObject2).setAdapter(paramViewGroup);
      }
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.c);
      localObject1 = (Integer)this.d.get(((HotRecommendFeedItem)paramHotRecommendHomeFeed.i()).feedId);
      if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject2).resetCurrentX(((Integer)localObject1).intValue());
        SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramHotRecommendHomeFeed.i()).feedId, localObject1);
      }
      else
      {
        ((StoryHomeHorizontalListView)localObject2).resetCurrentX(0);
      }
      ((StoryHomeHorizontalListView)localObject2).setOverScrollMode(0);
      ((StoryHomeHorizontalListView)localObject2).setDividerWidth(UIUtils.a(this.l, 10.0F));
      paramInt = paramViewGroup.getCount();
      int m = paramHotRecommendHomeFeed.a().size();
      paramViewGroup.a(paramHotRecommendHomeFeed.a(), paramHotRecommendHomeFeed.i());
      ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(((HotRecommendFeedItem)paramHotRecommendHomeFeed.i()).mIsVideoEnd ^ true);
      if (m > paramInt) {
        ((StoryHomeHorizontalListView)localObject2).post(new FeedSegment.6(this, (StoryHomeHorizontalListView)localObject2));
      }
      if (paramInt > m) {
        ((StoryHomeHorizontalListView)localObject2).a();
      }
      paramViewGroup = paramBaseViewHolder.a(2131448575);
      if (paramViewGroup.getVisibility() == 8) {
        if (TextUtils.isEmpty((String)((StoryConfigManager)SuperManager.a(10)).c("mainHallConfig", ""))) {
          paramViewGroup.setVisibility(8);
        } else {
          paramViewGroup.setVisibility(0);
        }
      }
      StoryReportor.a("home_page", "multi_exp", 0, 0, new String[0]);
    }
    else
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("that item is no video!!! feed id=");
      paramViewGroup.append(((HotRecommendFeedItem)paramHotRecommendHomeFeed.i()).feedId);
      SLog.e("Q.qqstory.home:FeedSegment", paramViewGroup.toString());
      paramBaseViewHolder.a.setVisibility(8);
    }
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, TagHomeFeed paramTagHomeFeed)
  {
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442660);
    a(paramInt, paramBaseViewHolder, this.p);
    a(paramBaseViewHolder, paramTagHomeFeed);
    a(paramInt, paramBaseViewHolder);
    a(paramBaseViewHolder, paramTagHomeFeed, true);
    a(null, paramBaseViewHolder);
    if (this.p) {
      paramInt = this.l.getResources().getColor(2131168130);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    StoryReportor.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramTagHomeFeed.i()).feedId });
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, BannerHomeFeed paramBannerHomeFeed)
  {
    Object localObject = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131442674);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).getNameView();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).getSubTitleView();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).getSubTitleSuffix();
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131442645);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).getAvatar();
    Button localButton = ((QQStoryOwnerInfoView)localObject).getRightBtn();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramBaseViewHolder.a(2131442637);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131442639);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).getIcon();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).getBadge();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramBannerHomeFeed.c();
    a(paramInt, paramBaseViewHolder, this.p);
    a((QQStoryOwnerInfoView)localObject, HardCodeUtil.a(2131899712), true);
    if (StoryProfileUtils.a(localBannerFeedItem.getOwner())) {
      localButton.setVisibility(0);
    } else {
      localButton.setVisibility(8);
    }
    if (TextUtils.isEmpty(localBannerFeedItem.content))
    {
      localTextView4.setVisibility(8);
    }
    else
    {
      localTextView4.setVisibility(0);
      localTextView4.setText(localBannerFeedItem.content);
    }
    localTextView1.setText(localBannerFeedItem.getOwner().getName());
    UIUtils.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, ImageUtil.b(1), "QQStory_main");
    a(paramInt, paramBaseViewHolder);
    localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
    if (TextUtils.isEmpty(localBannerFeedItem.blurb))
    {
      localTextView2.setVisibility(8);
    }
    else
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(localBannerFeedItem.blurb);
    }
    localTextView3.setVisibility(8);
    localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
    if (!paramBannerHomeFeed.g) {
      localStoryUserBadgeView.a();
    }
    float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
    paramInt = UIUtils.b(this.l) - UIUtils.a(this.l, 15.0F) * 2;
    int m = (int)(paramInt * f1);
    localRoundCornerImageView.getLayoutParams().width = paramInt;
    localRoundCornerImageView.getLayoutParams().height = m;
    localRoundCornerImageView.setCorner(paramInt / 80);
    a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
    localObject = (FeedCommentLikeLego)paramBaseViewHolder.a("commentLikeLego");
    if (localObject == null)
    {
      localObject = new FeedCommentLikeLego(this.l, this.v, null, paramBannerHomeFeed, this.a);
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).o();
      paramBaseViewHolder.a("commentLikeLego", localObject);
      localFrameLayout.addView(((FeedCommentLikeLego)localObject).q);
    }
    else
    {
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed, null, paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).c(null);
    }
    ((FeedCommentLikeLego)localObject).a(this);
    ((FeedCommentLikeLego)localObject).a(this);
    if (!paramBannerHomeFeed.g) {
      StoryReportor.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramBannerHomeFeed.c()).getOwner().getUnionId(), ((BannerFeedItem)paramBannerHomeFeed.c()).feedId });
    }
    return paramBaseViewHolder.a();
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    if (paramList == null)
    {
      SLog.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      return "";
    }
    Object localObject = null;
    int i2 = UIUtils.b() / 3600;
    int m = 0;
    Iterator localIterator = paramList.iterator();
    int i1 = i2;
    for (;;)
    {
      paramList = localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (StoryVideoItem)localIterator.next();
      if (!TextUtils.isEmpty(paramList.mUserSelectLocationText))
      {
        paramList = paramList.mUserSelectLocationText;
        break;
      }
      if ((m == 0) && (paramList.mTimeZoneOffsetMillis != 2147483647L))
      {
        i1 = (int)(paramList.mTimeZoneOffsetMillis / 3600000L);
        m = 1;
      }
    }
    if (!TextUtils.isEmpty(paramList)) {
      return paramList;
    }
    if (i1 != i2) {
      return StoryListUtils.a(i1, true);
    }
    return "";
  }
  
  private void a(int paramInt, StoryHomeFeed paramStoryHomeFeed, String paramString, boolean paramBoolean)
  {
    if (!(paramStoryHomeFeed instanceof VideoListHomeFeed)) {
      return;
    }
    Object localObject1 = f(paramInt);
    if (localObject1 == null)
    {
      SLog.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        this.t.postDelayed(new FeedSegment.16(this, paramInt, paramStoryHomeFeed, paramString), 300L);
      }
      return;
    }
    Object localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131442692);
    List localList = ((VideoListHomeFeed)paramStoryHomeFeed).a();
    if (localList.size() <= 2) {
      this.t.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
    }
    paramInt = 0;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
      {
        SLog.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
        localObject2 = ((VideoListLayout)localObject2).getVideoListView();
        int m = paramInt;
        if (!paramBoolean)
        {
          paramInt *= UIUtils.a(this.l, 152.0F);
          this.d.put(paramStoryHomeFeed.g().feedId, Integer.valueOf(paramInt));
          ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
          localObject1 = (FeedItemThumbAdapter)((BaseViewHolder)localObject1).a("general_adapter");
          m = paramInt;
          if (localObject1 != null)
          {
            ((FeedItemThumbAdapter)localObject1).notifyDataSetChanged();
            m = paramInt;
          }
        }
        this.t.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
        SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramStoryHomeFeed.g().feedId, Integer.valueOf(m));
        SLog.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(m));
        return;
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, ShareGroupItem paramShareGroupItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindFeedShareGroupInfo");
    paramBaseViewHolder = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131442674);
    if (paramShareGroupItem == null)
    {
      paramBaseViewHolder.setSubTitle(null);
      paramBaseViewHolder.setBadge(null);
      paramBaseViewHolder.setQIMIcon(null);
      paramBaseViewHolder.setSubTitleSuffix(null);
      paramBaseViewHolder.setButtonTxt(null);
      paramBaseViewHolder.setName(PlayModeUtils.b);
      paramBaseViewHolder.setAvatar(this.l.getResources().getDrawable(2130848221));
      TraceUtils.traceEnd();
      return;
    }
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = ImageUtil.m();
      paramBaseViewHolder.setAvatar(FaceDrawable.getFaceDrawable(QQStoryContext.k(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
    }
    else
    {
      paramBaseViewHolder.setAvatar(((ShareGroupIconManager)SuperManager.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
    }
    paramBaseViewHolder.setName(paramShareGroupItem.getName());
    if (paramVideoListHomeFeed.i().type == 2)
    {
      Object localObject2 = a((ShareGroupFeedItem)((ShareGroupHomeFeed)paramVideoListHomeFeed).i(), paramVideoListHomeFeed.a());
      localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      paramBaseViewHolder.setSubTitle((String)localObject1);
      paramBaseViewHolder.setSubTitleSuffix((String)localObject2);
    }
    Object localObject1 = paramBaseViewHolder.getBadge();
    if (paramShareGroupItem.getRelationType() == 2) {
      ((StoryUserBadgeView)localObject1).setImageResource(2130848581);
    } else if (paramShareGroupItem.isPublic()) {
      ((StoryUserBadgeView)localObject1).setImageResource(2130848583);
    } else {
      ((StoryUserBadgeView)localObject1).setImageResource(2130848582);
    }
    if (paramVideoListHomeFeed.i().type == 2) {
      if (paramVideoListHomeFeed.k()) {
        a(paramBaseViewHolder, HardCodeUtil.a(2131902483), false);
      } else {
        a(paramBaseViewHolder, null, false);
      }
    }
    ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
    ((StoryUserBadgeView)localObject1).setVisibility(0);
    ((StoryUserBadgeView)localObject1).setOnClickListener(null);
    paramBaseViewHolder = paramBaseViewHolder.getIcon();
    paramBaseViewHolder.a(null);
    paramBaseViewHolder.setVisibility(8);
    TraceUtils.traceEnd();
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString)
  {
    a(paramStoryVideoItem, paramQQStoryAutoPlayView, paramString, -1, -1);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString, int paramInt1, int paramInt2)
  {
    TraceUtils.traceBegin("Feed.setCover");
    boolean bool1 = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = K;
    }
    else if (!bool1)
    {
      paramInt1 = 225;
      paramInt2 = 364;
      localDrawable = K;
    }
    else
    {
      paramInt1 = 150;
      paramInt2 = 243;
      localDrawable = L;
    }
    boolean bool2 = TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
    String str2 = "";
    String str1 = str2;
    if (!bool2)
    {
      SLog.b("Q.qqstory.home:FeedSegment", "fake url not empty");
      str1 = ImageDownloader.FILE.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      if (!a(str1, paramInt1, paramInt2))
      {
        SLog.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
        str1 = str2;
      }
      else
      {
        SLog.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      if (StoryListUtils.a(paramStoryVideoItem.mVideoLocalThumbnailPath))
      {
        paramStoryVideoItem = ImageDownloader.FILE.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
        break label218;
      }
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool1)
        {
          paramStoryVideoItem = ThumbnailUrlHelper.c(paramStoryVideoItem.mVideoThumbnailUrl);
          break label218;
        }
        paramStoryVideoItem = ThumbnailUrlHelper.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
        break label218;
      }
    }
    paramStoryVideoItem = str1;
    label218:
    a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
    paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
    TraceUtils.traceEnd();
  }
  
  private void a(HotRecommendFeedItem paramHotRecommendFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.l);
    localActionSheet.addButton(HardCodeUtil.a(2131902478), 5);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    int m;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {
      m = 2131902479;
    } else {
      m = 2131899712;
    }
    localActionSheet.addButton(HardCodeUtil.a(m), 5);
    localActionSheet.addButton(HardCodeUtil.a(2131902495), 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new FeedSegment.13(this, localActionSheet, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
    localActionSheet.setOnDismissListener(new FeedSegment.14(this));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    StoryReportor.a("home_page", "multi_press", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed)
  {
    if ((paramStoryHomeFeed != null) && (paramStoryHomeFeed.g() != null) && (paramStoryHomeFeed.g().getOwner() != null))
    {
      if ((paramStoryHomeFeed instanceof GeneralHomeFeed))
      {
        paramStoryHomeFeed = ((GeneralHomeFeed)paramStoryHomeFeed).h().getOwner();
        StoryApi.a(this.l, 4, paramStoryHomeFeed.getUnionId());
        return;
      }
      Object localObject;
      int m;
      int i1;
      if ((paramStoryHomeFeed instanceof ShareGroupHomeFeed))
      {
        paramStoryHomeFeed = (ShareGroupFeedItem)((ShareGroupHomeFeed)paramStoryHomeFeed).i();
        localObject = paramStoryHomeFeed.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          SLog.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          AssertUtils.fail("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramStoryHomeFeed.getOwner().getRelationType() == 2)
        {
          if (this.a == 10) {
            m = 1;
          } else {
            m = 9;
          }
          if (this.a == 10) {
            i1 = 74;
          } else {
            i1 = 76;
          }
          QQStoryShareGroupProfileActivity.a(this.l, 1, ((ShareGroupItem)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), m, i1);
          return;
        }
        QQStoryShareGroupProfileActivity.a(this.v, 2, str, null, 1, 74);
        return;
      }
      if ((paramStoryHomeFeed instanceof GeneralRecommendHomeFeed))
      {
        paramStoryHomeFeed = ((GeneralRecommendHomeFeed)paramStoryHomeFeed).h();
        localObject = paramStoryHomeFeed.getOwner();
        if (paramStoryHomeFeed.getOwner().getRelationType() == 2)
        {
          if (this.a == 10) {
            m = 2;
          } else {
            m = 9;
          }
          if (this.a == 10) {
            i1 = 74;
          } else {
            i1 = 76;
          }
          QQStoryShareGroupProfileActivity.a(this.l, 1, ((QQUserUIItem)localObject).uid, ((QQUserUIItem)localObject).qq, m, i1);
          return;
        }
        StoryApi.a(this.l, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramStoryHomeFeed instanceof TagHomeFeed))
      {
        paramStoryHomeFeed = (TagFeedItem)((TagHomeFeed)paramStoryHomeFeed).i();
        StoryTagUtil.a(this.v, paramStoryHomeFeed.tagItem.a);
        return;
      }
      if ((paramStoryHomeFeed instanceof HotRecommendHomeFeed))
      {
        r();
        StoryReportor.a("home_page", "left_load_more", 0, 0, new String[0]);
      }
      return;
    }
    AssertUtils.fail("homeFeed is not refreshFinish！！", new Object[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed, ShareGroupItem paramShareGroupItem)
  {
    if (ShareGroupUtil.a(paramShareGroupItem))
    {
      int m;
      if (paramStoryHomeFeed.g().type == 4) {
        m = 3;
      } else {
        m = 1;
      }
      StoryReportor.a("share_story", "pub_limit", m, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
      QQToast.makeText(this.v, 1, HardCodeUtil.a(2131902494), 1).show();
      return;
    }
    QQStoryContext.a();
    new AddVideoController((QQAppInterface)QQStoryContext.k()).a(this.v, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    StoryReportor.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed, String paramString)
  {
    int m = paramStoryHomeFeed.g().type;
    String str;
    if (m != 3)
    {
      if (m != 5)
      {
        if (m != 6) {
          str = "";
        } else {
          str = "4";
        }
      }
      else {
        str = "3";
      }
    }
    else {
      str = "1";
    }
    StoryReportor.a("home_page", paramString, 0, 0, new String[] { str, "", "", paramStoryHomeFeed.g().feedId });
  }
  
  @Deprecated
  private void a(VideoListHomeFeed paramVideoListHomeFeed, BaseViewHolder paramBaseViewHolder) {}
  
  private void a(VideoListHomeFeed paramVideoListHomeFeed, BaseViewHolder paramBaseViewHolder, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindCommentLike");
    if (paramVideoListHomeFeed.a().size() > 0)
    {
      FeedCommentLikeLego localFeedCommentLikeLego2 = (FeedCommentLikeLego)paramBaseViewHolder.a("commentLikeLego");
      FeedCommentLikeLego localFeedCommentLikeLego1 = localFeedCommentLikeLego2;
      if (localFeedCommentLikeLego2 == null)
      {
        if (paramShareGroupItem != null) {
          localFeedCommentLikeLego1 = FeedCommentLikeLego.a(this.l, this.v, null, paramVideoListHomeFeed, this.a, paramShareGroupItem);
        } else {
          localFeedCommentLikeLego1 = new FeedCommentLikeLego(this.l, this.v, null, paramVideoListHomeFeed, this.a);
        }
        paramBaseViewHolder.a("commentLikeLego", localFeedCommentLikeLego1);
        paramFrameLayout.addView(localFeedCommentLikeLego1.q);
      }
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localFeedCommentLikeLego1.l();
        paramVideoListHomeFeed = paramFrameLayout.getLayoutParams();
        paramVideoListHomeFeed.height = UIUtils.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramVideoListHomeFeed);
      }
      else
      {
        paramBaseViewHolder = paramFrameLayout.getLayoutParams();
        paramBaseViewHolder.height = -2;
        paramFrameLayout.setLayoutParams(paramBaseViewHolder);
        if (localFeedCommentLikeLego1.n())
        {
          localFeedCommentLikeLego1.a(paramVideoListHomeFeed, paramShareGroupItem, null);
          localFeedCommentLikeLego1.c(null);
        }
        else
        {
          localFeedCommentLikeLego1.o();
        }
        localFeedCommentLikeLego1.a(this);
        localFeedCommentLikeLego1.a(this);
      }
    }
    TraceUtils.traceEnd();
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130848395);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
      return;
    }
    try
    {
      paramString1 = new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      if ((paramString1.getStatus() == 2) || (paramString1.getStatus() == 3))
      {
        InfoPrinter.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      InfoPrinter.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, boolean paramBoolean)
  {
    TraceUtils.traceBegin("FeedSegment.bindVideoList");
    Object localObject3 = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    Object localObject2 = ((VideoListLayout)localObject3).getSingleVideoView();
    TextView localTextView = ((VideoListLayout)localObject3).getTimeView();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject3).getInfoView();
    localStoryNickNameView.setMaxWidth(UIUtils.a(this.l, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject3).getVideoListView();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.f, paramBaseViewHolder);
    if ((paramVideoListHomeFeed.a() != null) && (paramVideoListHomeFeed.a().size() != 0))
    {
      Object localObject1;
      int m;
      double d1;
      int i1;
      if (paramVideoListHomeFeed.a().size() > 1)
      {
        localStoryHomeHorizontalListView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject2).setVisibility(8);
        localTextView.setVisibility(8);
        localStoryNickNameView.setUnionId(null);
        localObject2 = (FeedItemThumbAdapter)paramBaseViewHolder.a("general_adapter");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new FeedItemThumbAdapter(this.l, this.v, this.a);
          ((FeedItemThumbAdapter)localObject1).a(this.F);
          paramBaseViewHolder.a("general_adapter", localObject1);
          localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
          ((FeedItemThumbAdapter)localObject1).a(this);
        }
        ((FeedItemThumbAdapter)localObject1).a(this.c);
        if (paramBoolean)
        {
          localObject2 = (Integer)this.d.get(paramVideoListHomeFeed.i().feedId);
          if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
          {
            localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject2).intValue());
            SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramVideoListHomeFeed.i().feedId, localObject2);
          }
          else
          {
            localStoryHomeHorizontalListView.resetCurrentX(0);
          }
        }
        if (paramVideoListHomeFeed.a().size() == 2)
        {
          m = (UIUtils.b(this.l) - this.H * 2 - this.I) / 2;
          d1 = m;
          Double.isNaN(d1);
          i1 = (int)(d1 * 1.7D);
          localStoryHomeHorizontalListView.setOverScrollMode(2);
        }
        else
        {
          m = UIUtils.a(this.l, 152.0F);
          d1 = UIUtils.b(this.l);
          double d2 = m;
          Double.isNaN(d2);
          if (d1 > d2 * 2.2D)
          {
            i1 = UIUtils.a(this.l, 270.0F);
          }
          else
          {
            m = UIUtils.a(this.l, 133.0F);
            i1 = UIUtils.a(this.l, 226.0F);
          }
          localStoryHomeHorizontalListView.setOverScrollMode(0);
        }
        ((FeedItemThumbAdapter)localObject1).a(m, i1);
        ((FeedItemThumbAdapter)localObject1).a(UIUtils.a(this.l, 8.0F));
        if (paramVideoListHomeFeed.i().type == 6) {
          m = UIUtils.a(this.l, 10.0F);
        } else {
          m = UIUtils.a(this.l, 22.0F);
        }
        ((VideoListLayout)localObject3).setHorizontalViewHeight(i1 + m);
        localStoryHomeHorizontalListView.setDividerWidth(this.l.getResources().getDimensionPixelSize(2131299317));
        ((FeedItemThumbAdapter)localObject1).a(paramVideoListHomeFeed.a(), paramVideoListHomeFeed.i());
        if (StoryDepends.a()) {
          if ((this.R) && (paramBaseViewHolder.f == 0) && ((paramVideoListHomeFeed.l()) || (paramVideoListHomeFeed.i().isFakeFeedItem())))
          {
            ((FeedItemThumbAdapter)localObject1).j = true;
            this.R = false;
          }
          else
          {
            ((FeedItemThumbAdapter)localObject1).j = false;
          }
        }
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramVideoListHomeFeed.i().mIsVideoEnd ^ true);
      }
      else if (paramVideoListHomeFeed.a().size() == 1)
      {
        m = UIUtils.b(this.l) - this.H * 2;
        d1 = m;
        Double.isNaN(d1);
        i1 = (int)(d1 * 1.3D);
        ((VideoListLayout)localObject3).setSingleVideoSize(m, i1);
        ((VideoListLayout)localObject3).getSingleVideoView().getSrcImageView().setCorner(UIUtils.a(this.l, 11.0F));
        localObject3 = (StoryVideoItem)paramVideoListHomeFeed.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject2).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject2).setItemData(paramVideoListHomeFeed.i(), (StoryVideoItem)localObject3, 0);
        ((QQStoryAutoPlayView)localObject2).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject2).a(this.c);
        a((StoryVideoItem)localObject3, (QQStoryAutoPlayView)localObject2, "QQStory_feed", m, i1);
        if (((StoryVideoItem)localObject3).isUploading())
        {
          ((QQStoryAutoPlayView)localObject2).getProgressView().a(((StoryVideoItem)localObject3).mVid);
          ((QQStoryAutoPlayView)localObject2).getProgressView().a(0);
          StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject3).mVid, ((QQStoryAutoPlayView)localObject2).getProgressView());
        }
        else
        {
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
            localObject1 = ((StoryVideoItem)localObject3).mVid;
          } else {
            localObject1 = StoryVideoUploadProgressManager.a().e(((StoryVideoItem)localObject3).mVid);
          }
          ((QQStoryAutoPlayView)localObject2).getProgressView().a((String)localObject1);
          if (((QQStoryAutoPlayView)localObject2).getProgressView().b())
          {
            SLog.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject2).getProgressView().a(new FeedSegment.7(this, (String)localObject1, (QQStoryAutoPlayView)localObject2));
          }
          else
          {
            ((QQStoryAutoPlayView)localObject2).getProgressView().a(4);
            StoryVideoUploadProgressManager.a().a(((QQStoryAutoPlayView)localObject2).getProgressView());
          }
        }
        if ((StoryDepends.a()) && (this.R) && (paramBaseViewHolder.f == 0) && ((paramVideoListHomeFeed.l()) || (paramVideoListHomeFeed.i().isFakeFeedItem())))
        {
          c((View)localObject2);
          this.R = false;
        }
        if (((StoryVideoItem)localObject3).mHadRead == 1) {
          localTextView.setTextColor(this.l.getResources().getColor(2131168133));
        } else {
          localTextView.setTextColor(this.l.getResources().getColor(2131167993));
        }
        if (((StoryVideoItem)localObject3).isUploadFail())
        {
          localTextView.setText(HardCodeUtil.a(2131902489));
          localTextView.setTextColor(this.l.getResources().getColor(2131168133));
          localStoryNickNameView.setUnionId(null);
        }
        else
        {
          if (((StoryVideoItem)localObject3).mTimeZoneOffsetMillis != 2147483647L) {
            localTextView.setText(UIUtils.a(((StoryVideoItem)localObject3).mCreateTime, ((StoryVideoItem)localObject3).mTimeZoneOffsetMillis));
          } else {
            localTextView.setText(UIUtils.b(((StoryVideoItem)localObject3).mCreateTime));
          }
          if ((paramVideoListHomeFeed.i().getOwner() instanceof ShareGroupItem))
          {
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject3).mOwnerName);
          }
          else if ((paramVideoListHomeFeed.i().getOwner() instanceof TagUserItem))
          {
            localStoryNickNameView.setUnionId(null);
          }
          else if ((this.a == 10) && (a((StoryVideoItem)localObject3)) && (((StoryVideoItem)localObject3).getVideoLinkInfo().h != null))
          {
            localStoryNickNameView.setFormat(HardCodeUtil.a(2131902499));
            localStoryNickNameView.a(this.F);
            localStoryNickNameView.setUnionId(((StoryVideoItem)localObject3).getVideoLinkInfo().h.a);
          }
          else
          {
            localStoryNickNameView.setUnionId(null);
          }
          if ((paramVideoListHomeFeed.i().getOwner() instanceof TagUserItem)) {
            localTextView.setVisibility(8);
          } else {
            localTextView.setVisibility(0);
          }
        }
        if ((paramVideoListHomeFeed.i().type == 3) && ((paramVideoListHomeFeed.i().getOwner() instanceof QQUserUIItem)))
        {
          paramBaseViewHolder = (QQUserUIItem)paramVideoListHomeFeed.i().getOwner();
          if ((paramBaseViewHolder.isVip) && (!paramBaseViewHolder.isSubscribe())) {
            StoryReportor.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject3).mVid });
          }
        }
        if (paramVideoListHomeFeed.i().type == 6) {
          StoryReportor.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject3).mVid });
        }
      }
      else
      {
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject2).setVisibility(8);
        localTextView.setVisibility(8);
        localStoryNickNameView.setUnionId(null);
      }
    }
    else
    {
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append("that item is no video!!! feed id=");
      paramBaseViewHolder.append(paramVideoListHomeFeed.i().feedId);
      SLog.e("Q.qqstory.home:FeedSegment", paramBaseViewHolder.toString());
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject2).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
    }
    TraceUtils.traceEnd();
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.getRightBtn();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      UIUtils.a(localButton);
      return;
    }
    if (paramBoolean)
    {
      m = UIUtils.a(this.l, 13.0F);
      int i1 = UIUtils.a(this.l, 3.0F);
      localButton.setTextColor(this.l.getResources().getColor(2131167993));
      if (QQStoryContext.e()) {
        localButton.setBackgroundResource(2130848324);
      } else {
        localButton.setBackgroundResource(2130848323);
      }
      localButton.setPadding(m, i1, m, i1);
    }
    else
    {
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.l.getResources().getColor(2131167369));
      localButton.setPadding(0, 0, 0, 0);
    }
    if (QQStoryContext.e())
    {
      localButton.setTextColor(this.l.getResources().getColor(2131167382));
      localButton.setBackgroundResource(2130848324);
    }
    int m = UIUtils.a(this.l, 20.0F);
    UIUtils.a(localButton, m, m, m, m);
  }
  
  public static void a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mMemoryCacheKeySuffix = "q_story";
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(UIUtils.j);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<StoryHomeFeed> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = ((Integer)((StoryConfigManager)SuperManager.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    int m;
    if (i2 > 0) {
      m = i2;
    } else {
      m = 1;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = ((StoryHomeFeed)paramList.next()).j();
      if (localList != null)
      {
        int i3 = localList.size();
        int i1 = paramInt;
        while ((i1 < paramInt + m) && (i1 < i3))
        {
          localArrayList.add(((StoryVideoItem)localList.get(i1)).mVid);
          i1 += 1;
        }
      }
    }
    SLog.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i2), Integer.valueOf(m), new JSONArray(localArrayList) });
    this.c.a(localArrayList);
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {
      return false;
    }
    if (paramStoryVideoItem.getVideoLinkInfo().a != 5) {
      return false;
    }
    return paramStoryVideoItem.getVideoLinkInfo().h != null;
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      paramString = new URL(paramString);
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      return URLDrawable.getDrawable(paramString, localURLDrawableOptions).getStatus() == 1;
    }
    catch (MalformedURLException paramString) {}
    return false;
  }
  
  public static String[] a(ShareGroupFeedItem paramShareGroupFeedItem, List<StoryVideoItem> paramList)
  {
    boolean bool = TextUtils.isEmpty(paramShareGroupFeedItem.des);
    String str2 = "";
    String str1;
    if ((!bool) && (paramShareGroupFeedItem.mVideoPullType == 0))
    {
      paramList = paramShareGroupFeedItem.des;
      int m;
      if (paramShareGroupFeedItem.todayJoinMemberCount > 1) {
        m = 2131902500;
      } else {
        m = 2131902488;
      }
      str1 = HardCodeUtil.a(m);
    }
    else
    {
      String str3 = a(paramList);
      str1 = str2;
      paramList = str3;
      if (TextUtils.isEmpty(str3))
      {
        paramList = new StringBuilder();
        paramList.append(paramShareGroupFeedItem.videoCount);
        paramList.append(HardCodeUtil.a(2131902492));
        paramList = paramList.toString();
        str1 = str2;
      }
    }
    return new String[] { paramList, str1 };
  }
  
  private void b(List<StoryHomeFeed> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = ((Integer)((StoryConfigManager)SuperManager.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (i1 > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((StoryHomeFeed)paramList.next()).j();
        if (localList != null)
        {
          int i2 = localList.size();
          int m = paramInt;
          while ((m < paramInt + i1) && (m < i2))
          {
            localArrayList.add(((StoryVideoItem)localList.get(m)).mVid);
            m += 1;
          }
        }
      }
      SLog.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1), new JSONArray(localArrayList) });
      Bosses.get().postJob(new FeedSegment.8(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private BaseViewHolder c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628064, paramViewGroup, false));
    paramViewGroup.a(2131448575).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.i);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131442683);
    FeedSegment.VideoListTouchEventHandler localVideoListTouchEventHandler = new FeedSegment.VideoListTouchEventHandler(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localVideoListTouchEventHandler);
    paramViewGroup.a("general_touch_handler", localVideoListTouchEventHandler);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private void c(View paramView)
  {
    paramView.clearAnimation();
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.3F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.3F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    localAnimatorSet.setDuration(700L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(paramView);
    localAnimatorSet.start();
  }
  
  private BaseViewHolder d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628164, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131442674);
    paramViewGroup.a(2131442675).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131442673).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131442791).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131442786).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.h);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131442683);
    FeedSegment.VideoListTouchEventHandler localVideoListTouchEventHandler = new FeedSegment.VideoListTouchEventHandler(this);
    paramViewGroup.a("general_touch_handler", localVideoListTouchEventHandler);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localVideoListTouchEventHandler);
    paramViewGroup.a("type", "TagView");
    return paramViewGroup;
  }
  
  public static boolean d(int paramInt)
  {
    int m = ((QQStoryManager)PlayModeUtils.b().getManager(QQManagerFactory.QQSTORY_MANAGER)).a();
    if (m != 1) {
      if (m != 2)
      {
        if (m != 1001) {
          break label67;
        }
        SLog.b("Q.qqstory.home:FeedSegment", "");
      }
      else
      {
        if (paramInt != 1) {
          break label67;
        }
        return true;
      }
    }
    label67:
    if (paramInt != 1) {
      return paramInt == 2;
    }
    return true;
  }
  
  private BaseViewHolder e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628005, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131442674);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.getRightBtn().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131442637).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131442645).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.f);
    paramViewGroup.a("type", "BannerView");
    return paramViewGroup;
  }
  
  private void e(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      a(paramString.f, paramString, w());
    }
  }
  
  private void h(int paramInt)
  {
    if (!this.o) {
      return;
    }
    if (paramInt == 0)
    {
      c(A());
      return;
    }
    QQStoryAutoPlayView localQQStoryAutoPlayView = this.x;
    if ((localQQStoryAutoPlayView != null) && (localQQStoryAutoPlayView.getAutoPlayState() == 1)) {
      this.x.b();
    }
  }
  
  private void i(int paramInt)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.l);
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.b.i().get(paramInt);
    localActionSheet.addButton(HardCodeUtil.a(2131902485), 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new FeedSegment.11(this, localActionSheet, paramInt, localStoryHomeFeed));
    localActionSheet.setOnDismissListener(new FeedSegment.12(this, paramInt));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    a(localStoryHomeFeed, "clk_hide");
  }
  
  private void j(int paramInt)
  {
    if (!NetworkUtils.a(this.l))
    {
      QQToast.makeText(PlayModeUtils.a(), 1, HardCodeUtil.a(2131902498), 0).show();
      return;
    }
    Object localObject1 = (StoryHomeFeed)this.b.i().remove(paramInt);
    if (localObject1 == null)
    {
      AssertUtils.fail("feed is null when unLike.", new Object[0]);
      return;
    }
    a((StoryHomeFeed)localObject1, "hide_done");
    Object localObject2 = ((StoryHomeFeed)localObject1).g().getOwner().getUnionId();
    paramInt = ((StoryHomeFeed)localObject1).g().type;
    long l;
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("feed not allow unLike operation type=");
          ((StringBuilder)localObject2).append(((StoryHomeFeed)localObject1).g().type);
          AssertUtils.fail(((StringBuilder)localObject2).toString(), new Object[0]);
          return;
        }
        paramInt = 10;
        l = ((TagFeedItem)((StoryHomeFeed)localObject1).g()).recommendId;
      }
      else
      {
        paramInt = 11;
        l = ((BannerFeedItem)((StoryHomeFeed)localObject1).g()).recommendId;
      }
    }
    else
    {
      paramInt = 9;
      l = ((GeneralRecommendFeedItem)((StoryHomeFeed)localObject1).g()).recommendId;
    }
    FeedUtils.a((String)localObject2, paramInt, l);
    localObject1 = ((StoryHomeFeed)localObject1).g().feedId;
    Bosses.get().postJob(new FeedSegment.15(this, "Q.qqstory.home:FeedSegment", (String)localObject1));
    u();
  }
  
  private void k(int paramInt)
  {
    if (this.J)
    {
      g(paramInt);
      return;
    }
    if (f(paramInt) == null)
    {
      g(paramInt);
      this.J = true;
    }
  }
  
  private boolean y()
  {
    this.b.h();
    StoryReportor.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String z()
  {
    return String.valueOf(hashCode());
  }
  
  public int a()
  {
    return this.b.i().size();
  }
  
  public int a(View paramView)
  {
    if (paramView.getScrollY() > 0) {
      return paramView.getScrollY();
    }
    paramView = (ViewGroup)paramView.getParent();
    for (;;)
    {
      if (paramView != null) {
        if (paramView.getScrollY() > 0) {
          return paramView.getScrollY();
        }
      }
      try
      {
        paramView = (ViewGroup)paramView.getParent();
      }
      catch (Exception paramView) {}
    }
    return 0;
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.b.i().get(paramInt);
    paramBaseViewHolder.a("feed_id", localStoryHomeFeed.g().feedId);
    View localView = paramBaseViewHolder.a();
    int m = g_(paramInt);
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (HotRecommendHomeFeed)localStoryHomeFeed);
          }
        }
        else {
          localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (TagHomeFeed)localStoryHomeFeed);
        }
      }
      else {
        localView = a(paramInt, paramBaseViewHolder, (BannerHomeFeed)localStoryHomeFeed);
      }
    }
    else if (localStoryHomeFeed.g().type == 1) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralHomeFeed)localStoryHomeFeed);
    } else if (localStoryHomeFeed.g().type == 2) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (ShareGroupHomeFeed)localStoryHomeFeed);
    } else if (localStoryHomeFeed.g().type == 3) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralRecommendHomeFeed)localStoryHomeFeed);
    }
    localStoryHomeFeed.g = true;
    d(paramBaseViewHolder);
    paramBaseViewHolder = new ArrayList();
    paramBaseViewHolder.add(localStoryHomeFeed);
    b(paramBaseViewHolder, 0);
    StoryReportor.b("story_home_dev", "feed_exp", localStoryHomeFeed.g().type, localStoryHomeFeed.j().size(), new String[] { localStoryHomeFeed.g().feedId });
    return localView;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, GeneralHomeFeed paramGeneralHomeFeed)
  {
    SLog.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442660);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131442664);
    a(paramGeneralHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.p);
    a(paramInt, paramBaseViewHolder, paramGeneralHomeFeed, paramGeneralHomeFeed.h().getOwner());
    a(paramBaseViewHolder, paramGeneralHomeFeed, true);
    a(paramInt, paramBaseViewHolder);
    if (this.p) {
      paramInt = this.l.getResources().getColor(2131168130);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", paramGeneralHomeFeed.h().feedId);
    a(paramGeneralHomeFeed, paramBaseViewHolder);
    a(paramGeneralHomeFeed, paramBaseViewHolder, localFrameLayout, null);
    return paramBaseViewHolder.a();
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, ShareGroupHomeFeed paramShareGroupHomeFeed)
  {
    SLog.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442660);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131442664);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.p);
    a(paramInt, paramBaseViewHolder, paramShareGroupHomeFeed, ((ShareGroupFeedItem)paramShareGroupHomeFeed.i()).getOwner());
    a(paramBaseViewHolder, paramShareGroupHomeFeed, true);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    if (this.p) {
      paramInt = this.l.getResources().getColor(2131168130);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", ((ShareGroupFeedItem)paramShareGroupHomeFeed.i()).feedId);
    paramBaseViewHolder.a("group_id", ((ShareGroupFeedItem)paramShareGroupHomeFeed.i()).getOwner().shareGroupId);
    a(paramShareGroupHomeFeed, paramBaseViewHolder, localFrameLayout, ((ShareGroupFeedItem)paramShareGroupHomeFeed.i()).getOwner());
    paramShareGroupHomeFeed.g = true;
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("FeedItem.createView");
    int m = g_(paramInt);
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            paramViewGroup = b(paramInt, paramViewGroup);
          } else {
            paramViewGroup = c(paramInt, paramViewGroup);
          }
        }
        else {
          paramViewGroup = d(paramInt, paramViewGroup);
        }
      }
      else {
        paramViewGroup = e(paramInt, paramViewGroup);
      }
    }
    else {
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    paramViewGroup.a().requestLayout();
    TraceUtils.traceEnd();
    return paramViewGroup;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = this.y;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.y.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (BaseViewHolder)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (FeedCommentLikeLego)((BaseViewHolder)localObject2).a("commentLikeLego");
          if (localObject2 != null) {
            ((FeedCommentLikeLego)localObject2).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131442687);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131442688);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131442686);
    if (localRelativeLayout == null) {
      return;
    }
    if (StoryDepends.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (StoryHomeFeed)this.b.i().get(paramInt);
    paramInt = ((StoryHomeFeed)localObject).g().type;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          localObject = (TagFeedItem)((StoryHomeFeed)localObject).g();
          if (((TagFeedItem)localObject).recommendId <= 0L)
          {
            paramBaseViewHolder = new StringBuilder();
            paramBaseViewHolder.append("feed have no recommend id. feed=");
            paramBaseViewHolder.append(((TagFeedItem)localObject).feedId);
            SLog.e("Q.qqstory.home:FeedSegment", paramBaseViewHolder.toString());
            localRelativeLayout.setVisibility(8);
            localImageView.setOnClickListener(null);
            return;
          }
          if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {
            localObject = HardCodeUtil.a(2131902473);
          } else {
            localObject = ((TagFeedItem)localObject).recommendTitle;
          }
          localRelativeLayout.setVisibility(0);
          localImageView.setOnClickListener(paramBaseViewHolder);
          localTextView.setText((CharSequence)localObject);
          return;
        }
        localObject = (BannerFeedItem)((StoryHomeFeed)localObject).g();
        if (((BannerFeedItem)localObject).recommendId <= 0L)
        {
          paramBaseViewHolder = new StringBuilder();
          paramBaseViewHolder.append("feed have no recommend id. feed=");
          paramBaseViewHolder.append(((BannerFeedItem)localObject).feedId);
          SLog.e("Q.qqstory.home:FeedSegment", paramBaseViewHolder.toString());
          localRelativeLayout.setVisibility(8);
          localImageView.setOnClickListener(null);
          return;
        }
        if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {
          localObject = HardCodeUtil.a(2131902476);
        } else {
          localObject = ((BannerFeedItem)localObject).recommendTitle;
        }
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramBaseViewHolder);
        localTextView.setText((CharSequence)localObject);
        return;
      }
      if (((StoryHomeFeed)localObject).g().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((StoryHomeFeed)localObject).g();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        paramBaseViewHolder = new StringBuilder();
        paramBaseViewHolder.append("feed have no recommend id. feed=");
        paramBaseViewHolder.append(((GeneralRecommendFeedItem)localObject).feedId);
        SLog.e("Q.qqstory.home:FeedSegment", paramBaseViewHolder.toString());
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {
        localObject = HardCodeUtil.a(2131902481);
      } else {
        localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle;
      }
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramBaseViewHolder);
      localTextView.setText((CharSequence)localObject);
      return;
    }
    localRelativeLayout.setVisibility(8);
    localImageView.setOnClickListener(null);
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, QQUserUIItem paramQQUserUIItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131442674);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(PlayModeUtils.b);
      localQQStoryOwnerInfoView.setAvatar(this.l.getResources().getDrawable(2130848221));
      TraceUtils.traceEnd();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(UIUtils.a(this.l, paramQQUserUIItem.headUrl, 68, 68, ImageUtil.b(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark)) {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
    } else {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
    }
    if (paramVideoListHomeFeed.i().getOwner().getRelationType() == 2)
    {
      paramBaseViewHolder = "";
    }
    else if (paramVideoListHomeFeed.i().type == 3)
    {
      paramBaseViewHolder = (GeneralRecommendFeedItem)paramVideoListHomeFeed.i();
      if (!TextUtils.isEmpty(paramBaseViewHolder.blurb)) {
        paramBaseViewHolder = paramBaseViewHolder.blurb;
      } else {
        paramBaseViewHolder = a(paramVideoListHomeFeed.a());
      }
    }
    else
    {
      paramBaseViewHolder = a(paramVideoListHomeFeed.a());
    }
    localQQStoryOwnerInfoView.setSubTitle(paramBaseViewHolder);
    localQQStoryOwnerInfoView.setSubTitleSuffix(null);
    if (paramVideoListHomeFeed.i().type == 1) {
      a(localQQStoryOwnerInfoView, null, false);
    } else if (paramVideoListHomeFeed.i().type == 3) {
      if (StoryProfileUtils.a(paramQQUserUIItem)) {
        a(localQQStoryOwnerInfoView, HardCodeUtil.a(2131899712), true);
      } else {
        a(localQQStoryOwnerInfoView, null, false);
      }
    }
    paramBaseViewHolder = localQQStoryOwnerInfoView.getBadge();
    paramBaseViewHolder.setUnionID(paramQQUserUIItem.getUnionId(), 1);
    if (!paramVideoListHomeFeed.g) {
      paramBaseViewHolder.a();
    }
    localQQStoryOwnerInfoView.getIcon().a(paramQQUserUIItem);
    TraceUtils.traceEnd();
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131442667);
    TraceUtils.traceBegin("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131442666);
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131442668);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131442669);
    Object localObject2 = this.b.i();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      TraceUtils.traceEnd();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130848299);
      paramBaseViewHolder.setImageResource(2130848301);
    }
    else
    {
      ((ImageView)localObject1).setImageResource(2130848298);
      paramBaseViewHolder.setImageResource(2130848300);
    }
    if (paramInt == 0)
    {
      paramBaseViewHolder = UIUtils.a(DateUtils.b(((StoryHomeFeed)((List)localObject2).get(paramInt)).g().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramBaseViewHolder);
    }
    else
    {
      paramBaseViewHolder = (StoryHomeFeed)((List)localObject2).get(paramInt - 1);
      localObject2 = (StoryHomeFeed)((List)localObject2).get(paramInt);
      localObject1 = DateUtils.b(paramBaseViewHolder.g().date);
      localObject2 = DateUtils.b(((StoryHomeFeed)localObject2).g().date);
      if ((!(paramBaseViewHolder instanceof HotRecommendHomeFeed)) && (localObject1[0] == localObject2[0]) && (localObject1[1] == localObject2[1]) && (localObject1[2] == localObject2[2]))
      {
        localRelativeLayout.setVisibility(8);
      }
      else
      {
        paramBaseViewHolder = UIUtils.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramBaseViewHolder);
      }
    }
    TraceUtils.traceEnd();
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, QQUserUIItem paramQQUserUIItem, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.d()) {
      return;
    }
    int m;
    if (this.a == 10) {
      m = 74;
    } else {
      m = 76;
    }
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem))
    {
      paramVideoListFeedItem = (HotRecommendFeedItem)paramVideoListFeedItem;
      paramVideoListFeedItem = new OpenPlayerBuilder(new HotRecommendFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mAttachedFeedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), m);
      paramVideoListFeedItem.a(false).b(true);
      paramVideoListFeedItem.a(z());
      if ((paramView instanceof QQStoryAutoPlayView)) {
        StoryPlayerLauncher.a((BaseActivity)this.v, paramVideoListFeedItem.f(), ((QQStoryAutoPlayView)paramView).getSrcImageView());
      } else {
        StoryPlayerLauncher.a((BaseActivity)this.v, paramVideoListFeedItem.f(), paramView);
      }
      StoryReportor.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
    }
    Object localObject = null;
    paramInt = this.a;
    if (paramInt == 10)
    {
      String str = paramVideoListFeedItem.feedId;
      if ((paramVideoListFeedItem instanceof TagFeedItem)) {
        localObject = paramStoryVideoItem.mAttachedFeedId;
      } else {
        localObject = str;
      }
      localObject = new HomeFeedPlayInfo(str, (String)localObject, paramStoryVideoItem.mVid, false);
    }
    else if (paramInt == 11)
    {
      localObject = new TroopAssistantHomeFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
    }
    else if (paramInt == 12)
    {
      localObject = new ProfileFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
    }
    if (localObject != null)
    {
      localObject = new OpenPlayerBuilder((Serializable)localObject, m);
      ((OpenPlayerBuilder)localObject).a(z());
      localObject = ((OpenPlayerBuilder)localObject).f();
      if (74 == m) {
        ((OpenPlayerBuilder.Data)localObject).mUIStyle.bottomWidgetShowFlag = 3;
      }
      if ((paramView instanceof QQStoryAutoPlayView)) {
        StoryPlayerLauncher.a((BaseActivity)this.v, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).getSrcImageView());
      } else {
        StoryPlayerLauncher.a((BaseActivity)this.v, (OpenPlayerBuilder.Data)localObject, paramView);
      }
    }
    paramInt = StoryReportor.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
      paramView = paramVideoListFeedItem.getOwner().getUnionId();
    } else {
      paramView = "";
    }
    StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), FeedItemThumbAdapter.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.b(this.a), paramVideoListFeedItem.feedId, paramView });
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    paramViewGroup = paramFeedCommentLego.i;
    boolean bool = true;
    if ((paramViewGroup == null) || (paramFeedCommentLego.i.size() <= 1)) {
      bool = false;
    }
    paramViewGroup = this.w.h();
    paramViewGroup.setFeedItemData(paramFeedCommentLego.g, this.a, q(), bool);
    paramViewGroup.a(paramFeedCommentLego, paramCommentEntry);
    paramFeedCommentLego = this.t;
    paramFeedCommentLego.sendMessageDelayed(paramFeedCommentLego.obtainMessage(12, paramView), 150L);
  }
  
  public void a(VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if ((((Integer)((StoryConfigManager)SuperManager.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramGetVideoBasicInfoListEvent.a != null))
    {
      TVKPreloader.a();
      paramGetVideoBasicInfoListEvent = new ArrayList(paramGetVideoBasicInfoListEvent.a).iterator();
      while (paramGetVideoBasicInfoListEvent.hasNext()) {
        TVKPreloader.a(((StoryVideoItem)paramGetVideoBasicInfoListEvent.next()).mVid);
      }
    }
    c(0);
  }
  
  protected void a(GeneralHomeFeed paramGeneralHomeFeed, BaseViewHolder paramBaseViewHolder)
  {
    paramGeneralHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    if (paramGeneralHomeFeed != null)
    {
      paramGeneralHomeFeed = paramGeneralHomeFeed.getAddGroupGuide();
      if (paramGeneralHomeFeed != null) {
        paramGeneralHomeFeed.setVisibility(8);
      }
    }
  }
  
  public void a(HomeFeedData paramHomeFeedData)
  {
    SLog.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramHomeFeedData == null)
    {
      e(false);
      return;
    }
    if (paramHomeFeedData.g == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FeedSegment onFeedItemBack feedData.errorInfo=null!!,");
      ((StringBuilder)localObject).append(paramHomeFeedData);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      e(false);
      return;
    }
    SLog.d("Q.qqstory.home:FeedSegment", paramHomeFeedData.g.toString());
    if (paramHomeFeedData.g.isFail()) {
      e(false);
    } else {
      e(true);
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      String str = this.k;
      if (str != null)
      {
        a((String)localObject, str, false);
        this.j = null;
        this.k = null;
      }
    }
    this.e.set(true);
    a(paramHomeFeedData.f, 0);
    if (!paramHomeFeedData.b) {
      w().setLoadMoreComplete(b(), paramHomeFeedData.g.isSuccess(), paramHomeFeedData.a ^ true);
    }
  }
  
  protected void a(ShareGroupHomeFeed paramShareGroupHomeFeed, BaseViewHolder paramBaseViewHolder)
  {
    paramShareGroupHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    if (paramShareGroupHomeFeed != null)
    {
      paramShareGroupHomeFeed = paramShareGroupHomeFeed.getAddGroupGuide();
      if (paramShareGroupHomeFeed != null) {
        paramShareGroupHomeFeed.setVisibility(8);
      }
    }
  }
  
  public void a(VideoListHomeFeed paramVideoListHomeFeed)
  {
    SLog.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramVideoListHomeFeed);
    if ((paramVideoListHomeFeed != null) && (paramVideoListHomeFeed.i() != null) && (paramVideoListHomeFeed.i().feedId != null))
    {
      e(paramVideoListHomeFeed.i().feedId);
      return;
    }
    SLog.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder)
  {
    Object localObject = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    ((VideoListLayout)localObject).getFailedTxt().setOnClickListener(paramBaseViewHolder);
    ((VideoListLayout)localObject).getAddGroupGuide().setOnClickListener(paramBaseViewHolder);
    localObject = ((VideoListLayout)localObject).getVideoListView();
    FeedSegment.VideoListTouchEventHandler localVideoListTouchEventHandler = new FeedSegment.VideoListTouchEventHandler(this);
    paramBaseViewHolder.a("general_touch_handler", localVideoListTouchEventHandler);
    paramBaseViewHolder.a("general_adapter", null);
    paramBaseViewHolder.a(this.g);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localVideoListTouchEventHandler);
    paramBaseViewHolder.a("type", "GeneralView");
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, TagHomeFeed paramTagHomeFeed)
  {
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131442789);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131442788);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131442791);
    TagItem localTagItem = ((TagFeedItem)paramTagHomeFeed.i()).tagItem;
    paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131442786);
    if (QQStoryContext.e())
    {
      localTextView3.setTextColor(this.l.getResources().getColor(2131167387));
      paramBaseViewHolder.setBackgroundResource(2130848324);
    }
    if (localTagItem != null)
    {
      localTextView1.setText(localTagItem.a.b);
      if (!TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.i()).blurb))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((TagFeedItem)paramTagHomeFeed.i()).blurb);
      }
      else
      {
        localTextView2.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.i()).content))
      {
        localTextView3.setVisibility(0);
        localTextView3.setText(((TagFeedItem)paramTagHomeFeed.i()).content);
        return;
      }
      localTextView3.setVisibility(8);
    }
  }
  
  public void a(FeedSegment.StoryVideoDownloadedEvent paramStoryVideoDownloadedEvent)
  {
    c(0);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddFakeFeedItem:");
    localStringBuilder.append(paramString);
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    this.M = true;
    e(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.b.i().iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      if (paramString1.equals(localStoryHomeFeed.g().feedId))
      {
        this.j = null;
        this.k = null;
        k(m);
        a(m, localStoryHomeFeed, paramString2, false);
        return;
      }
      m += 1;
    }
    if (paramBoolean)
    {
      this.j = paramString1;
      this.k = paramString2;
      y();
    }
  }
  
  @NonNull
  protected HomeFeedPresenter b(boolean paramBoolean)
  {
    return new HomeFeedPresenter(this.a, this, paramBoolean);
  }
  
  protected BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628042, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131442674);
    localQQStoryOwnerInfoView.getRightBtn().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public String b()
  {
    return "FeedSegment";
  }
  
  public void b(int paramInt)
  {
    h(paramInt);
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
      a((HotRecommendFeedItem)paramVideoListFeedItem, paramStoryVideoItem);
    }
  }
  
  public void b(HomeFeedData paramHomeFeedData)
  {
    e(true);
  }
  
  protected void b(BaseViewHolder paramBaseViewHolder)
  {
    ((VideoListLayout)paramBaseViewHolder.a(2131442692)).getAddGroupGuide().setVisibility(8);
  }
  
  public void b(String paramString)
  {
    this.e.set(true);
    SLog.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    e(true);
  }
  
  public boolean b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = paramView.getHeight();
    int i1 = paramView.getWidth();
    paramView = new int[2];
    w().getLocationOnScreen(paramView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isOnScreenArea location[1]=");
    localStringBuilder.append(arrayOfInt[1]);
    localStringBuilder.append(",parentLocation[1]=");
    localStringBuilder.append(paramView[1]);
    localStringBuilder.append(",viewHeight");
    localStringBuilder.append(m);
    localStringBuilder.append(",getParentListView().getHeight()=");
    localStringBuilder.append(w().getHeight());
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    return (arrayOfInt[1] > paramView[1]) && (arrayOfInt[1] + m < paramView[1] + w().getHeight()) && (arrayOfInt[0] > -i1 / 2);
  }
  
  public void br_()
  {
    this.s = null;
    if (this.r)
    {
      Iterator localIterator = new ArrayList(this.b.i()).iterator();
      while (localIterator.hasNext())
      {
        StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
        if (((localStoryHomeFeed instanceof ShareGroupHomeFeed)) && (localStoryHomeFeed.g().getOwner().getRelationType() != 2) && (((ShareGroupItem)localStoryHomeFeed.g().getOwner()).isPublic()) && (this.s == null))
        {
          this.s = localStoryHomeFeed;
          SLog.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.s.toString());
          return;
        }
      }
      SLog.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.y.clear();
  }
  
  public boolean bt_()
  {
    return this.b.g();
  }
  
  protected void bz_()
  {
    super.bz_();
    this.e.set(true);
    QQStoryAutoPlayView localQQStoryAutoPlayView = this.x;
    if (localQQStoryAutoPlayView != null) {
      localQQStoryAutoPlayView.b();
    }
    if ((this.o) && (this.x != null))
    {
      this.c.b(2);
      this.x.i();
      this.c.b(0);
    }
    AbstractGifImage.pauseAll();
    this.J = false;
    this.b.e();
    this.b.f();
    this.J = false;
  }
  
  protected BaseViewHolder c(String paramString)
  {
    Object localObject = this.b.i();
    int m = 0;
    while (m < ((List)localObject).size())
    {
      if (TextUtils.equals(paramString, ((StoryHomeFeed)((List)localObject).get(m)).g().feedId)) {
        break label58;
      }
      m += 1;
    }
    m = -1;
    label58:
    if (m == -1) {
      return null;
    }
    BaseViewHolder localBaseViewHolder = f(m);
    if ((localBaseViewHolder != null) && (paramString.equals(localBaseViewHolder.a("feed_id")))) {
      return localBaseViewHolder;
    }
    if (localBaseViewHolder != null)
    {
      localObject = (StoryHomeFeed)((List)localObject).get(m);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data and view is not correspond. feedID=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",and holder feed id=");
      localStringBuilder.append(localBaseViewHolder.a("feed_id"));
      localStringBuilder.append(" feed info=");
      localStringBuilder.append(localObject);
      AssertUtils.fail(localStringBuilder.toString(), new Object[0]);
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    TraceUtils.traceBegin("fetchViewWhichNeedPlay");
    if ((this.o) && (this.w.i()) && (this.a == 10))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAutoPlayCondition scrollDirection=");
      ((StringBuilder)localObject1).append(paramInt);
      SLog.d("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
      Iterator localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (VideoListLayout)((BaseViewHolder)localIterator.next()).a(2131442692);
        if (localObject2 != null)
        {
          localObject1 = ((VideoListLayout)localObject2).getSingleVideoView();
          localObject2 = ((VideoListLayout)localObject2).getVideoListView();
          if ((localObject1 == null) || (((QQStoryAutoPlayView)localObject1).getVisibility() != 0)) {
            if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null)) {
              localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131442690);
            } else {
              localObject1 = null;
            }
          }
          if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getStoryVideoItem() != null))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("for holder start cover=");
            ((StringBuilder)localObject2).append(((QQStoryAutoPlayView)localObject1).getStoryVideoItem().getThumbUrl());
            SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject2).toString());
            localObject2 = this.x;
            if (localObject2 == null)
            {
              this.x = ((QQStoryAutoPlayView)localObject1);
            }
            else
            {
              int m;
              int i1;
              if (paramInt != 1)
              {
                if (paramInt != 2)
                {
                  m = StoryListUtils.a((View)localObject2);
                  i1 = StoryListUtils.a((View)localObject1);
                }
                else
                {
                  m = StoryListUtils.b((View)localObject2);
                  i1 = StoryListUtils.b((View)localObject1);
                }
              }
              else
              {
                m = StoryListUtils.c((View)localObject2);
                i1 = StoryListUtils.c((View)localObject1);
              }
              if ((b((View)localObject1)) && (m >= i1))
              {
                localObject2 = this.x;
                if (localObject2 != localObject1)
                {
                  ((QQStoryAutoPlayView)localObject2).b();
                  this.x = ((QQStoryAutoPlayView)localObject1);
                }
                else
                {
                  SLog.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
                }
              }
              else
              {
                ((QQStoryAutoPlayView)localObject1).b();
              }
              SLog.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
            }
          }
        }
      }
      if (this.x != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("FeedSegment checkAutoPlayCondition find playView index=");
        ((StringBuilder)localObject1).append(this.x.getIndexAtVideoList());
        ((StringBuilder)localObject1).append(",url=");
        ((StringBuilder)localObject1).append(this.x.getStoryVideoItem().getThumbUrl());
        SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
      }
      else
      {
        SLog.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
      }
      localObject1 = this.x;
      if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getIndexAtVideoList() == 0)) {
        if (this.x.d()) {
          this.x.c();
        } else {
          this.x.a(this.b.i());
        }
      }
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fetchViewWhichNeedPlay but needAutoPlay=");
    ((StringBuilder)localObject1).append(this.o);
    ((StringBuilder)localObject1).append(",mIView.isViewOnResume()=");
    ((StringBuilder)localObject1).append(this.w.i());
    SLog.e("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
  }
  
  public void c(BaseViewHolder paramBaseViewHolder)
  {
    TraceUtils.traceBegin("FeedSegment.onMovedToScrapHeap");
    this.y.remove(paramBaseViewHolder);
    Object localObject = (VideoListLayout)paramBaseViewHolder.a(2131442692);
    if (localObject == null)
    {
      TraceUtils.traceEnd();
      return;
    }
    paramBaseViewHolder = ((VideoListLayout)localObject).getSingleVideoView();
    localObject = ((VideoListLayout)localObject).getVideoListView();
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.getVisibility() != 0)) {
      if ((localObject != null) && (((StoryHomeHorizontalListView)localObject).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject).getChildAt(0) != null)) {
        paramBaseViewHolder = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131442690);
      } else {
        paramBaseViewHolder = null;
      }
    }
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getStoryVideoItem() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("for holder onMovedToScrapHeap cover=");
      ((StringBuilder)localObject).append(paramBaseViewHolder.getStoryVideoItem().getThumbUrl());
      SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject).toString());
    }
    if (paramBaseViewHolder != null) {
      paramBaseViewHolder.a();
    }
    TraceUtils.traceEnd();
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.m) {
      k();
    }
  }
  
  public void d(BaseViewHolder paramBaseViewHolder)
  {
    this.y.add(paramBaseViewHolder);
  }
  
  public void d(@NonNull String paramString)
  {
    if (StoryDepends.a()) {
      return;
    }
    this.R = true;
    Object localObject = p();
    Rect localRect = new Rect();
    if (localObject != null) {
      ((View)localObject).getGlobalVisibleRect(localRect);
    } else {
      SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
    InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
    localObject = new Intent(this.v, QQStoryTakeVideoCloseAnimationActivity.class);
    ((Intent)localObject).putExtra("path", paramString);
    ((Intent)localObject).putExtra("target_top", localRect.top);
    ((Intent)localObject).putExtra("target_right", localRect.right);
    ((Intent)localObject).putExtra("target_left", localRect.left);
    ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
    this.v.startActivity((Intent)localObject);
    this.v.overridePendingTransition(0, 0);
    paramString = (NewMyStorySegment)w().b("NewMyStorySegment");
    if (paramString != null) {
      paramString.a(false);
    }
    w().setSelection(0);
  }
  
  protected boolean d(boolean paramBoolean)
  {
    SLog.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.e.set(false);
    this.o = d(a(this.l));
    this.b.a(false);
    this.d.clear();
    this.G.g.clear();
    if (!paramBoolean) {
      this.r = false;
    }
    return true;
  }
  
  public void e(int paramInt)
  {
    AutoPlayManager localAutoPlayManager = this.c;
    if (localAutoPlayManager == null) {
      return;
    }
    localAutoPlayManager.b(paramInt);
  }
  
  protected int f()
  {
    return 4;
  }
  
  protected void g()
  {
    this.b.a(true);
    this.o = d(a(this.l));
    k();
  }
  
  protected int g_(int paramInt)
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.b.i().get(paramInt);
    if (localStoryHomeFeed.g().type == 1) {
      return 0;
    }
    if (localStoryHomeFeed.g().type == 3) {
      return 0;
    }
    if (localStoryHomeFeed.g().type == 2) {
      return 0;
    }
    if (localStoryHomeFeed.g().type == 5) {
      return 1;
    }
    if (localStoryHomeFeed.g().type == 6) {
      return 2;
    }
    if (localStoryHomeFeed.g().type == 7) {
      return 3;
    }
    return super.g_(paramInt);
  }
  
  protected void h()
  {
    super.h();
    StoryDispatcher.a().unRegisterSubscriber(this.z);
    StoryDispatcher.a().unRegisterSubscriber(this.A);
    StoryDispatcher.a().unRegisterSubscriber(this.E);
    StoryDispatcher.a().unRegisterSubscriber(this.B);
    StoryDispatcher.a().unRegisterSubscriber(this.C);
    StoryDispatcher.a().unRegisterSubscriber(this.D);
    this.t.removeCallbacksAndMessages(null);
    this.n = false;
    Object localObject = this.x;
    if (localObject != null) {
      ((QQStoryAutoPlayView)localObject).a();
    }
    this.c.b();
    localObject = this.y.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)((BaseViewHolder)((Iterator)localObject).next()).a("commentLikeLego");
      if (localFeedCommentLikeLego != null) {
        localFeedCommentLikeLego.c();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.S);
    this.b.b();
    StoryQQTextCacher.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 1)
    {
      if (m != 2)
      {
        switch (m)
        {
        default: 
          return true;
        case 13: 
          if (QQStoryTakeVideoCloseAnimationActivity.b)
          {
            SLog.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
            paramMessage = (Rect)paramMessage.obj;
            ThreadManager.getSubThreadHandler().post(new FeedSegment.9(this, paramMessage));
            return true;
          }
          localObject1 = this.t;
          ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(13, paramMessage.obj), 50L);
          return true;
        case 12: 
          paramMessage = (View)paramMessage.obj;
          localObject1 = new int[2];
          m = UIUtils.e(this.l);
          this.w.h().getLocationOnScreen((int[])localObject1);
          if (localObject1[1] > m * 4 / 5)
          {
            localObject1 = this.t;
            ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(12, paramMessage), 50L);
            return true;
          }
          localObject2 = new int[2];
          paramMessage.getLocationOnScreen((int[])localObject2);
          m = localObject2[1] + (paramMessage.getBottom() - paramMessage.getTop()) - localObject1[1];
          w().smoothScrollBy(m, m * 2 / 3);
          return true;
        }
        int[] arrayOfInt1 = new int[2];
        m = UIUtils.e(this.l);
        StoryInputBarView localStoryInputBarView = this.w.h();
        localStoryInputBarView.getLocationOnScreen(arrayOfInt1);
        Object localObject2 = (String)paramMessage.obj;
        if (arrayOfInt1[1] > m * 4 / 5)
        {
          paramMessage = this.t;
          paramMessage.sendMessageDelayed(paramMessage.obtainMessage(11, localObject2), 50L);
          return true;
        }
        Object localObject1 = null;
        int[] arrayOfInt2 = new int[2];
        w().getLocationOnScreen(arrayOfInt2);
        Iterator localIterator = this.y.iterator();
        do
        {
          paramMessage = (Message)localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramMessage = (BaseViewHolder)localIterator.next();
        } while (!((String)localObject2).equals((String)paramMessage.a("feed_id")));
        if (paramMessage != null)
        {
          m = paramMessage.g;
          int i1 = paramMessage.a().getBottom();
          int i2 = paramMessage.a().getTop();
          int i3 = arrayOfInt2[1];
          localStoryInputBarView.getLocationOnScreen(arrayOfInt1);
          w().setSelectionFromTop(m, arrayOfInt1[1] - (i1 - i2 + i3));
          return true;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("comment feed id is error! id=");
        paramMessage.append((String)localObject2);
        AssertUtils.assertTrue(false, paramMessage.toString());
        return true;
      }
      e(true);
      return true;
    }
    paramMessage = (HomeFeedData)paramMessage.obj;
    if ((paramMessage != null) && (!paramMessage.g.isFail()))
    {
      b(paramMessage);
      return true;
    }
    e(false);
    return true;
  }
  
  protected void i()
  {
    super.i();
    QQStoryContext.a();
    this.p = ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null);
    this.o = d(a(this.l));
    c(0);
    AbstractGifImage.resumeAll();
  }
  
  public boolean isValidate()
  {
    return this.n;
  }
  
  public void j()
  {
    SLog.b("Q.qqstory.home:FeedSegment", "tag list update");
    e(true);
  }
  
  public void k()
  {
    w().setOnLoadMoreListener(b(), new FeedSegment.1(this));
    w().setLoadMoreComplete(b(), true, bt_() ^ true);
  }
  
  public void m()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (BaseViewHolder)localIterator.next();
      SLog.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (FeedCommentLikeLego)((BaseViewHolder)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((FeedCommentLikeLego)localObject).e();
      }
    }
  }
  
  public void n()
  {
    this.d.clear();
  }
  
  public void o()
  {
    c(0);
    SLog.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    B();
    this.M = false;
  }
  
  public View p()
  {
    int m = 0;
    StringBuilder localStringBuilder;
    for (;;)
    {
      int i1 = this.b.i().size();
      localStringBuilder = null;
      localObject1 = localStringBuilder;
      if (m >= i1) {
        return localObject1;
      }
      localObject1 = (StoryHomeFeed)this.b.i().get(m);
      if ((((StoryHomeFeed)localObject1).g().type == 1) || (((StoryHomeFeed)localObject1).g().type == 2)) {
        break;
      }
      m += 1;
    }
    Object localObject1 = f(m);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131442692);
    if (localObject2 == null)
    {
      SLog.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
      return null;
    }
    localObject1 = ((VideoListLayout)localObject2).getSingleVideoView();
    localObject2 = ((VideoListLayout)localObject2).getVideoListView();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("返回了单个视频的view：");
      localStringBuilder.append(((QQStoryAutoPlayView)localObject1).getStoryVideoItem().getThumbUrl());
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { localStringBuilder.toString() });
      return localObject1;
    }
    localObject1 = localStringBuilder;
    if (localObject2 != null)
    {
      localObject1 = localStringBuilder;
      if (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0)
      {
        localObject1 = localStringBuilder;
        if (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null)
        {
          localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131442690);
          InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131902474), ((QQStoryAutoPlayView)localObject1).getStoryVideoItem().getThumbUrl() });
        }
      }
    }
    return localObject1;
  }
  
  public int q()
  {
    int m = this.a;
    if (m == 11) {
      return 30000;
    }
    if (m == 12) {
      return 20004;
    }
    if ((this.v instanceof SplashActivity)) {}
    return 20002;
  }
  
  public void r()
  {
    Object localObject1 = (StoryConfigManager)SuperManager.a(10);
    Object localObject3 = "";
    String str = (String)((StoryConfigManager)localObject1).c("mainHallConfig", "");
    localObject1 = localObject3;
    Object localObject2;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject1 = new JSONObject(str).optString("url");
      }
      catch (Exception localException)
      {
        SLog.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
    }
    if (TextUtils.isEmpty(localObject2))
    {
      SLog.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
      return;
    }
    localObject3 = new Intent(this.v, QQBrowserActivity.class);
    ((Intent)localObject3).putExtra("url", localObject2);
    this.v.startActivity((Intent)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment
 * JD-Core Version:    0.7.0.1
 */