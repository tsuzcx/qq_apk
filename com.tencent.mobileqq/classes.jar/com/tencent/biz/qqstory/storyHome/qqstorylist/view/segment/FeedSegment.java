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
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new EmptyDrawable(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new EmptyDrawable(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private UserManager jdField_a_of_type_ComTencentBizQqstoryModelUserManager;
  private FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
  protected HomeFeedPresenter a;
  private StoryHomeFeed jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed;
  protected AutoPlayManager a;
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  ChildViewClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new FeedSegment.2(this);
  private IMyStoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView;
  private FeedSegment.DeleteShareGroupMemberEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$DeleteShareGroupMemberEventReceiver;
  private FeedSegment.GetUserInfoReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetUserInfoReceiver;
  private FeedSegment.GetVideoBasicInfoListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetVideoBasicInfoListReceiver;
  private FeedSegment.PlayVideoChangeReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$PlayVideoChangeReceiver;
  private FeedSegment.StoryVideoDownloadedReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$StoryVideoDownloadedReceiver;
  private FeedSegment.TroopNickNameUpdateEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$TroopNickNameUpdateEventReceiver;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new FeedSegment.10(this);
  public String a;
  private List<BaseViewHolder> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private final int jdField_b_of_type_Int;
  ChildViewClickListener jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new FeedSegment.3(this);
  public String b;
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  ChildViewClickListener jdField_c_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new FeedSegment.4(this);
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  ChildViewClickListener jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new FeedSegment.5(this);
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  public FeedSegment(Context paramContext, Activity paramActivity, int paramInt, IMyStoryListView paramIMyStoryListView, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$StoryVideoDownloadedReceiver = new FeedSegment.StoryVideoDownloadedReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetVideoBasicInfoListReceiver = new FeedSegment.GetVideoBasicInfoListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetUserInfoReceiver = new FeedSegment.GetUserInfoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$TroopNickNameUpdateEventReceiver = new FeedSegment.TroopNickNameUpdateEventReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$DeleteShareGroupMemberEventReceiver = new FeedSegment.DeleteShareGroupMemberEventReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$PlayVideoChangeReceiver = new FeedSegment.PlayVideoChangeReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$StoryVideoDownloadedReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetVideoBasicInfoListReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetUserInfoReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$TroopNickNameUpdateEventReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$DeleteShareGroupMemberEventReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$PlayVideoChangeReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager = new AutoPlayManager(Looper.myLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 10) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(1);
    } else if (paramInt == 11) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(2);
    } else if (paramInt == 12) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(3);
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298592);
    this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298603);
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
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374490);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374494);
    b(paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramGeneralRecommendHomeFeed, paramGeneralRecommendHomeFeed.a().getOwner());
    a(paramBaseViewHolder, paramGeneralRecommendHomeFeed, true);
    a(paramGeneralRecommendHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167149);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", paramGeneralRecommendHomeFeed.a().feedId);
    a(paramGeneralRecommendHomeFeed, paramBaseViewHolder, localFrameLayout, null);
    if (!paramGeneralRecommendHomeFeed.jdField_b_of_type_Boolean) {
      StoryReportor.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramGeneralRecommendHomeFeed.a().getOwner().getUnionId(), paramGeneralRecommendHomeFeed.a().feedId });
    }
    paramViewGroup = paramGeneralRecommendHomeFeed.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      StoryReportor.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, HotRecommendHomeFeed paramHotRecommendHomeFeed)
  {
    paramViewGroup = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject2 = paramViewGroup.a();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.jdField_b_of_type_Int, paramBaseViewHolder);
    if ((paramHotRecommendHomeFeed.a() != null) && (paramHotRecommendHomeFeed.a().size() != 0))
    {
      paramBaseViewHolder.a.setVisibility(0);
      ((StoryHomeHorizontalListView)localObject2).setVisibility(0);
      localObject1 = (HotRecommendFeedAdapter)paramBaseViewHolder.a("general_adapter");
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null)
      {
        paramViewGroup = new HotRecommendFeedAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
        paramBaseViewHolder.a("general_adapter", paramViewGroup);
        ((StoryHomeHorizontalListView)localObject2).setAdapter(paramViewGroup);
      }
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
      localObject1 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId);
      if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject2).resetCurrentX(((Integer)localObject1).intValue());
        SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId, localObject1);
      }
      else
      {
        ((StoryHomeHorizontalListView)localObject2).resetCurrentX(0);
      }
      ((StoryHomeHorizontalListView)localObject2).setOverScrollMode(0);
      ((StoryHomeHorizontalListView)localObject2).setDividerWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramInt = paramViewGroup.getCount();
      int j = paramHotRecommendHomeFeed.a().size();
      paramViewGroup.a(paramHotRecommendHomeFeed.a(), paramHotRecommendHomeFeed.a());
      ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).mIsVideoEnd ^ true);
      if (j > paramInt) {
        ((StoryHomeHorizontalListView)localObject2).post(new FeedSegment.6(this, (StoryHomeHorizontalListView)localObject2));
      }
      if (paramInt > j) {
        ((StoryHomeHorizontalListView)localObject2).a();
      }
      paramViewGroup = paramBaseViewHolder.a(2131379766);
      if (paramViewGroup.getVisibility() == 8) {
        if (TextUtils.isEmpty((String)((StoryConfigManager)SuperManager.a(10)).b("mainHallConfig", ""))) {
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
      paramViewGroup.append(((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId);
      SLog.e("Q.qqstory.home:FeedSegment", paramViewGroup.toString());
      paramBaseViewHolder.a.setVisibility(8);
    }
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, TagHomeFeed paramTagHomeFeed)
  {
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374490);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramBaseViewHolder, paramTagHomeFeed);
    a(paramInt, paramBaseViewHolder);
    a(paramBaseViewHolder, paramTagHomeFeed, true);
    a(null, paramBaseViewHolder);
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167149);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    StoryReportor.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramTagHomeFeed.a()).feedId });
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, BannerHomeFeed paramBannerHomeFeed)
  {
    Object localObject = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374504);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131374475);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramBaseViewHolder.a(2131374467);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374469);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramBannerHomeFeed.a();
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, HardCodeUtil.a(2131704569), true);
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
    UIUtils.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, ImageUtil.a(1), "QQStory_main");
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
    if (!paramBannerHomeFeed.jdField_b_of_type_Boolean) {
      localStoryUserBadgeView.a();
    }
    float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
    paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
    int j = (int)(paramInt * f1);
    localRoundCornerImageView.getLayoutParams().width = paramInt;
    localRoundCornerImageView.getLayoutParams().height = j;
    localRoundCornerImageView.setCorner(paramInt / 80);
    a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
    localObject = (FeedCommentLikeLego)paramBaseViewHolder.a("commentLikeLego");
    if (localObject == null)
    {
      localObject = new FeedCommentLikeLego(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramBannerHomeFeed, this.jdField_a_of_type_Int);
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).k();
      paramBaseViewHolder.a("commentLikeLego", localObject);
      localFrameLayout.addView(((FeedCommentLikeLego)localObject).b);
    }
    else
    {
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed, null, paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).c(null);
    }
    ((FeedCommentLikeLego)localObject).a(this);
    ((FeedCommentLikeLego)localObject).a(this);
    if (!paramBannerHomeFeed.jdField_b_of_type_Boolean) {
      StoryReportor.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramBannerHomeFeed.a()).getOwner().getUnionId(), ((BannerFeedItem)paramBannerHomeFeed.a()).feedId });
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
    int m = UIUtils.a() / 3600;
    int j = 0;
    Iterator localIterator = paramList.iterator();
    int k = m;
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
      if ((j == 0) && (paramList.mTimeZoneOffsetMillis != 2147483647L))
      {
        k = (int)(paramList.mTimeZoneOffsetMillis / 3600000L);
        j = 1;
      }
    }
    if (!TextUtils.isEmpty(paramList)) {
      return paramList;
    }
    if (k != m) {
      return StoryListUtils.a(k, true);
    }
    return "";
  }
  
  private void a(int paramInt, StoryHomeFeed paramStoryHomeFeed, String paramString, boolean paramBoolean)
  {
    if (!(paramStoryHomeFeed instanceof VideoListHomeFeed)) {
      return;
    }
    Object localObject1 = a(paramInt);
    if (localObject1 == null)
    {
      SLog.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramStoryHomeFeed, paramString), 300L);
      }
      return;
    }
    Object localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131374522);
    List localList = ((VideoListHomeFeed)paramStoryHomeFeed).a();
    if (localList.size() <= 2) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
    }
    paramInt = 0;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
      {
        SLog.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
        localObject2 = ((VideoListLayout)localObject2).a();
        int j = paramInt;
        if (!paramBoolean)
        {
          paramInt *= UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
          this.jdField_a_of_type_JavaUtilMap.put(paramStoryHomeFeed.a().feedId, Integer.valueOf(paramInt));
          ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
          localObject1 = (FeedItemThumbAdapter)((BaseViewHolder)localObject1).a("general_adapter");
          j = paramInt;
          if (localObject1 != null)
          {
            ((FeedItemThumbAdapter)localObject1).notifyDataSetChanged();
            j = paramInt;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
        SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramStoryHomeFeed.a().feedId, Integer.valueOf(j));
        SLog.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
        return;
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, ShareGroupItem paramShareGroupItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindFeedShareGroupInfo");
    paramBaseViewHolder = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374504);
    if (paramShareGroupItem == null)
    {
      paramBaseViewHolder.setSubTitle(null);
      paramBaseViewHolder.setBadge(null);
      paramBaseViewHolder.setQIMIcon(null);
      paramBaseViewHolder.setSubTitleSuffix(null);
      paramBaseViewHolder.setButtonTxt(null);
      paramBaseViewHolder.setName(PlayModeUtils.jdField_b_of_type_JavaLangString);
      paramBaseViewHolder.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846669));
      TraceUtils.traceEnd();
      return;
    }
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = ImageUtil.f();
      paramBaseViewHolder.setAvatar(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
    }
    else
    {
      paramBaseViewHolder.setAvatar(((ShareGroupIconManager)SuperManager.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
    }
    paramBaseViewHolder.setName(paramShareGroupItem.getName());
    if (paramVideoListHomeFeed.a().type == 2)
    {
      Object localObject2 = a((ShareGroupFeedItem)((ShareGroupHomeFeed)paramVideoListHomeFeed).a(), paramVideoListHomeFeed.a());
      localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      paramBaseViewHolder.setSubTitle((String)localObject1);
      paramBaseViewHolder.setSubTitleSuffix((String)localObject2);
    }
    Object localObject1 = paramBaseViewHolder.a();
    if (paramShareGroupItem.getRelationType() == 2) {
      ((StoryUserBadgeView)localObject1).setImageResource(2130847029);
    } else if (paramShareGroupItem.isPublic()) {
      ((StoryUserBadgeView)localObject1).setImageResource(2130847031);
    } else {
      ((StoryUserBadgeView)localObject1).setImageResource(2130847030);
    }
    if (paramVideoListHomeFeed.a().type == 2) {
      if (paramVideoListHomeFeed.a()) {
        a(paramBaseViewHolder, HardCodeUtil.a(2131704576), false);
      } else {
        a(paramBaseViewHolder, null, false);
      }
    }
    ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
    ((StoryUserBadgeView)localObject1).setVisibility(0);
    ((StoryUserBadgeView)localObject1).setOnClickListener(null);
    paramBaseViewHolder = paramBaseViewHolder.a();
    paramBaseViewHolder.a(null);
    paramBaseViewHolder.setVisibility(8);
    TraceUtils.traceEnd();
  }
  
  private void a(View paramView)
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
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    else if (!bool1)
    {
      paramInt1 = 225;
      paramInt2 = 364;
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    else
    {
      paramInt1 = 150;
      paramInt2 = 243;
      localDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
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
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.addButton(HardCodeUtil.a(2131704571), 5);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    int j;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {
      j = 2131704572;
    } else {
      j = 2131704564;
    }
    localActionSheet.addButton(HardCodeUtil.a(j), 5);
    localActionSheet.addButton(HardCodeUtil.a(2131704589), 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new FeedSegment.13(this, localActionSheet, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
    localActionSheet.setOnDismissListener(new FeedSegment.14(this));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    StoryReportor.a("home_page", "multi_press", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed)
  {
    if ((paramStoryHomeFeed != null) && (paramStoryHomeFeed.a() != null) && (paramStoryHomeFeed.a().getOwner() != null))
    {
      if ((paramStoryHomeFeed instanceof GeneralHomeFeed))
      {
        paramStoryHomeFeed = ((GeneralHomeFeed)paramStoryHomeFeed).a().getOwner();
        StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 4, paramStoryHomeFeed.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramStoryHomeFeed instanceof ShareGroupHomeFeed))
      {
        paramStoryHomeFeed = (ShareGroupFeedItem)((ShareGroupHomeFeed)paramStoryHomeFeed).a();
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
          if (this.jdField_a_of_type_Int == 10) {
            j = 1;
          } else {
            j = 9;
          }
          if (this.jdField_a_of_type_Int == 10) {
            k = 74;
          } else {
            k = 76;
          }
          QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ShareGroupItem)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), j, k);
          return;
        }
        QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, null, 1, 74);
        return;
      }
      if ((paramStoryHomeFeed instanceof GeneralRecommendHomeFeed))
      {
        paramStoryHomeFeed = ((GeneralRecommendHomeFeed)paramStoryHomeFeed).a();
        localObject = paramStoryHomeFeed.getOwner();
        if (paramStoryHomeFeed.getOwner().getRelationType() == 2)
        {
          if (this.jdField_a_of_type_Int == 10) {
            j = 2;
          } else {
            j = 9;
          }
          if (this.jdField_a_of_type_Int == 10) {
            k = 74;
          } else {
            k = 76;
          }
          QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((QQUserUIItem)localObject).uid, ((QQUserUIItem)localObject).qq, j, k);
          return;
        }
        StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramStoryHomeFeed instanceof TagHomeFeed))
      {
        paramStoryHomeFeed = (TagFeedItem)((TagHomeFeed)paramStoryHomeFeed).a();
        StoryTagUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryHomeFeed.tagItem.a);
        return;
      }
      if ((paramStoryHomeFeed instanceof HotRecommendHomeFeed))
      {
        l();
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
      int j;
      if (paramStoryHomeFeed.a().type == 4) {
        j = 3;
      } else {
        j = 1;
      }
      StoryReportor.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131704588), 1).a();
      return;
    }
    QQStoryContext.a();
    new AddVideoController((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    StoryReportor.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed, String paramString)
  {
    int j = paramStoryHomeFeed.a().type;
    String str;
    if (j != 3)
    {
      if (j != 5)
      {
        if (j != 6) {
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
    StoryReportor.a("home_page", paramString, 0, 0, new String[] { str, "", "", paramStoryHomeFeed.a().feedId });
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
          localFeedCommentLikeLego1 = FeedCommentLikeLego.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramVideoListHomeFeed, this.jdField_a_of_type_Int, paramShareGroupItem);
        } else {
          localFeedCommentLikeLego1 = new FeedCommentLikeLego(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramVideoListHomeFeed, this.jdField_a_of_type_Int);
        }
        paramBaseViewHolder.a("commentLikeLego", localFeedCommentLikeLego1);
        paramFrameLayout.addView(localFeedCommentLikeLego1.b);
      }
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localFeedCommentLikeLego1.j();
        paramVideoListHomeFeed = paramFrameLayout.getLayoutParams();
        paramVideoListHomeFeed.height = UIUtils.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramVideoListHomeFeed);
      }
      else
      {
        paramBaseViewHolder = paramFrameLayout.getLayoutParams();
        paramBaseViewHolder.height = -2;
        paramFrameLayout.setLayoutParams(paramBaseViewHolder);
        if (localFeedCommentLikeLego1.a())
        {
          localFeedCommentLikeLego1.a(paramVideoListHomeFeed, paramShareGroupItem, null);
          localFeedCommentLikeLego1.c(null);
        }
        else
        {
          localFeedCommentLikeLego1.k();
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
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846843);
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
    Object localObject3 = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    Object localObject2 = ((VideoListLayout)localObject3).a();
    TextView localTextView = ((VideoListLayout)localObject3).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject3).a();
    localStoryNickNameView.setMaxWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject3).a();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.jdField_b_of_type_Int, paramBaseViewHolder);
    if ((paramVideoListHomeFeed.a() != null) && (paramVideoListHomeFeed.a().size() != 0))
    {
      Object localObject1;
      int j;
      double d1;
      int k;
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
          localObject1 = new FeedItemThumbAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
          ((FeedItemThumbAdapter)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
          paramBaseViewHolder.a("general_adapter", localObject1);
          localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
          ((FeedItemThumbAdapter)localObject1).a(this);
        }
        ((FeedItemThumbAdapter)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
        if (paramBoolean)
        {
          localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramVideoListHomeFeed.a().feedId);
          if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
          {
            localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject2).intValue());
            SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramVideoListHomeFeed.a().feedId, localObject2);
          }
          else
          {
            localStoryHomeHorizontalListView.resetCurrentX(0);
          }
        }
        if (paramVideoListHomeFeed.a().size() == 2)
        {
          j = (UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
          d1 = j;
          Double.isNaN(d1);
          k = (int)(d1 * 1.7D);
          localStoryHomeHorizontalListView.setOverScrollMode(2);
        }
        else
        {
          j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
          d1 = UIUtils.a(this.jdField_a_of_type_AndroidContentContext);
          double d2 = j;
          Double.isNaN(d2);
          if (d1 > d2 * 2.2D)
          {
            k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);
          }
          else
          {
            j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
            k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 226.0F);
          }
          localStoryHomeHorizontalListView.setOverScrollMode(0);
        }
        ((FeedItemThumbAdapter)localObject1).a(j, k);
        ((FeedItemThumbAdapter)localObject1).a(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramVideoListHomeFeed.a().type == 6) {
          j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        } else {
          j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        }
        ((VideoListLayout)localObject3).setHorizontalViewHeight(k + j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298603));
        ((FeedItemThumbAdapter)localObject1).a(paramVideoListHomeFeed.a(), paramVideoListHomeFeed.a());
        if (StoryDepends.a()) {
          if ((this.i) && (paramBaseViewHolder.jdField_b_of_type_Int == 0) && ((paramVideoListHomeFeed.b()) || (paramVideoListHomeFeed.a().isFakeFeedItem())))
          {
            ((FeedItemThumbAdapter)localObject1).jdField_a_of_type_Boolean = true;
            this.i = false;
          }
          else
          {
            ((FeedItemThumbAdapter)localObject1).jdField_a_of_type_Boolean = false;
          }
        }
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramVideoListHomeFeed.a().mIsVideoEnd ^ true);
      }
      else if (paramVideoListHomeFeed.a().size() == 1)
      {
        j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        d1 = j;
        Double.isNaN(d1);
        k = (int)(d1 * 1.3D);
        ((VideoListLayout)localObject3).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject3).a().a().setCorner(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject3 = (StoryVideoItem)paramVideoListHomeFeed.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject2).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject2).setItemData(paramVideoListHomeFeed.a(), (StoryVideoItem)localObject3, 0);
        ((QQStoryAutoPlayView)localObject2).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
        a((StoryVideoItem)localObject3, (QQStoryAutoPlayView)localObject2, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject3).isUploading())
        {
          ((QQStoryAutoPlayView)localObject2).a().a(((StoryVideoItem)localObject3).mVid);
          ((QQStoryAutoPlayView)localObject2).a().a(0);
          StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject3).mVid, ((QQStoryAutoPlayView)localObject2).a());
        }
        else
        {
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
            localObject1 = ((StoryVideoItem)localObject3).mVid;
          } else {
            localObject1 = StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject3).mVid);
          }
          ((QQStoryAutoPlayView)localObject2).a().a((String)localObject1);
          if (((QQStoryAutoPlayView)localObject2).a().a())
          {
            SLog.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject2).a().a(new FeedSegment.7(this, (String)localObject1, (QQStoryAutoPlayView)localObject2));
          }
          else
          {
            ((QQStoryAutoPlayView)localObject2).a().a(4);
            StoryVideoUploadProgressManager.a().a(((QQStoryAutoPlayView)localObject2).a());
          }
        }
        if ((StoryDepends.a()) && (this.i) && (paramBaseViewHolder.jdField_b_of_type_Int == 0) && ((paramVideoListHomeFeed.b()) || (paramVideoListHomeFeed.a().isFakeFeedItem())))
        {
          a((View)localObject2);
          this.i = false;
        }
        if (((StoryVideoItem)localObject3).mHadRead == 1) {
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167152));
        } else {
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167056));
        }
        if (((StoryVideoItem)localObject3).isUploadFail())
        {
          localTextView.setText(HardCodeUtil.a(2131704583));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167152));
          localStoryNickNameView.setUnionId(null);
        }
        else
        {
          if (((StoryVideoItem)localObject3).mTimeZoneOffsetMillis != 2147483647L) {
            localTextView.setText(UIUtils.a(((StoryVideoItem)localObject3).mCreateTime, ((StoryVideoItem)localObject3).mTimeZoneOffsetMillis));
          } else {
            localTextView.setText(UIUtils.b(((StoryVideoItem)localObject3).mCreateTime));
          }
          if ((paramVideoListHomeFeed.a().getOwner() instanceof ShareGroupItem))
          {
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject3).mOwnerName);
          }
          else if ((paramVideoListHomeFeed.a().getOwner() instanceof TagUserItem))
          {
            localStoryNickNameView.setUnionId(null);
          }
          else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject3)) && (((StoryVideoItem)localObject3).getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo != null))
          {
            localStoryNickNameView.setFormat(HardCodeUtil.a(2131704593));
            localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
            localStoryNickNameView.setUnionId(((StoryVideoItem)localObject3).getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            localStoryNickNameView.setUnionId(null);
          }
          if ((paramVideoListHomeFeed.a().getOwner() instanceof TagUserItem)) {
            localTextView.setVisibility(8);
          } else {
            localTextView.setVisibility(0);
          }
        }
        if ((paramVideoListHomeFeed.a().type == 3) && ((paramVideoListHomeFeed.a().getOwner() instanceof QQUserUIItem)))
        {
          paramBaseViewHolder = (QQUserUIItem)paramVideoListHomeFeed.a().getOwner();
          if ((paramBaseViewHolder.isVip) && (!paramBaseViewHolder.isSubscribe())) {
            StoryReportor.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject3).mVid });
          }
        }
        if (paramVideoListHomeFeed.a().type == 6) {
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
      paramBaseViewHolder.append(paramVideoListHomeFeed.a().feedId);
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
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      UIUtils.a(localButton);
      return;
    }
    if (paramBoolean)
    {
      j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167056));
      if (QQStoryContext.a()) {
        localButton.setBackgroundResource(2130846772);
      } else {
        localButton.setBackgroundResource(2130846771);
      }
      localButton.setPadding(j, k, j, k);
    }
    else
    {
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
      localButton.setPadding(0, 0, 0, 0);
    }
    if (QQStoryContext.a())
    {
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166525));
      localButton.setBackgroundResource(2130846772);
    }
    int j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    UIUtils.a(localButton, j, j, j, j);
  }
  
  public static void a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mMemoryCacheKeySuffix = "q_story";
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(UIUtils.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<StoryHomeFeed> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    int j;
    if (m > 0) {
      j = m;
    } else {
      j = 1;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = ((StoryHomeFeed)paramList.next()).d();
      if (localList != null)
      {
        int n = localList.size();
        int k = paramInt;
        while ((k < paramInt + j) && (k < n))
        {
          localArrayList.add(((StoryVideoItem)localList.get(k)).mVid);
          k += 1;
        }
      }
    }
    SLog.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(localArrayList);
  }
  
  public static boolean a(int paramInt)
  {
    int j = ((QQStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.QQSTORY_MANAGER)).a();
    if (j != 1) {
      if (j != 2)
      {
        if (j != 1001) {
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
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {
      return false;
    }
    if (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) {
      return false;
    }
    return paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo != null;
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
      int j;
      if (paramShareGroupFeedItem.todayJoinMemberCount > 1) {
        j = 2131704594;
      } else {
        j = 2131704581;
      }
      str1 = HardCodeUtil.a(j);
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
        paramList.append(HardCodeUtil.a(2131704586));
        paramList = paramList.toString();
        str1 = str2;
      }
    }
    return new String[] { paramList, str1 };
  }
  
  private void b(List<StoryHomeFeed> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((StoryHomeFeed)paramList.next()).d();
        if (localList != null)
        {
          int m = localList.size();
          int j = paramInt;
          while ((j < paramInt + k) && (j < m))
          {
            localArrayList.add(((StoryVideoItem)localList.get(j)).mVid);
            j += 1;
          }
        }
      }
      SLog.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new FeedSegment.8(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.e();
    StoryReportor.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  private BaseViewHolder c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561685, paramViewGroup, false));
    paramViewGroup.a(2131379766).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374513);
    FeedSegment.VideoListTouchEventHandler localVideoListTouchEventHandler = new FeedSegment.VideoListTouchEventHandler(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localVideoListTouchEventHandler);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localVideoListTouchEventHandler);
    paramViewGroup.a("general_touch_handler", localVideoListTouchEventHandler);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private BaseViewHolder d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561785, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374504);
    paramViewGroup.a(2131374505).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374503).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374621).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374616).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374513);
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
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString.jdField_b_of_type_Int, paramString, a());
    }
  }
  
  private int e()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 100L)
    {
      j = this.jdField_f_of_type_Int;
      if ((j != -1) && (j != 0))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return this.jdField_f_of_type_Int;
      }
    }
    int k = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    int j = k + 1;
    if (a().getChildAt(0) != null) {
      j = a().getChildAt(0).getTop();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollToWhere firstIndex=");
    localStringBuilder.append(m);
    localStringBuilder.append(",lastFirstIndex=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(",firstTopY=");
    localStringBuilder.append(j);
    localStringBuilder.append(",lastFirstTopY=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    int n = this.jdField_d_of_type_Int;
    if (m == n)
    {
      if (j <= k)
      {
        n = this.jdField_e_of_type_Int;
        if (n <= k)
        {
          if (j > n)
          {
            this.jdField_e_of_type_Int = j;
            this.jdField_d_of_type_Int = m;
            return 2;
          }
          if (j >= n) {
            break label297;
          }
          this.jdField_e_of_type_Int = j;
          this.jdField_d_of_type_Int = m;
          return 1;
        }
      }
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 0;
    }
    else
    {
      if (m > n)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 1;
      }
      if (m < n)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 2;
      }
    }
    label297:
    this.jdField_e_of_type_Int = j;
    this.jdField_d_of_type_Int = m;
    return 0;
  }
  
  private BaseViewHolder e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561626, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374504);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374467).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374475).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    paramViewGroup.a("type", "BannerView");
    return paramViewGroup;
  }
  
  private void e(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      b(e());
      return;
    }
    QQStoryAutoPlayView localQQStoryAutoPlayView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
    if ((localQQStoryAutoPlayView != null) && (localQQStoryAutoPlayView.b() == 1)) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
  }
  
  private void f(int paramInt)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    localActionSheet.addButton(HardCodeUtil.a(2131704578), 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new FeedSegment.11(this, localActionSheet, paramInt, localStoryHomeFeed));
    localActionSheet.setOnDismissListener(new FeedSegment.12(this, paramInt));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    a(localStoryHomeFeed, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131704592), 0).a();
      return;
    }
    Object localObject1 = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().remove(paramInt);
    if (localObject1 == null)
    {
      AssertUtils.fail("feed is null when unLike.", new Object[0]);
      return;
    }
    a((StoryHomeFeed)localObject1, "hide_done");
    Object localObject2 = ((StoryHomeFeed)localObject1).a().getOwner().getUnionId();
    paramInt = ((StoryHomeFeed)localObject1).a().type;
    long l;
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("feed not allow unLike operation type=");
          ((StringBuilder)localObject2).append(((StoryHomeFeed)localObject1).a().type);
          AssertUtils.fail(((StringBuilder)localObject2).toString(), new Object[0]);
          return;
        }
        paramInt = 10;
        l = ((TagFeedItem)((StoryHomeFeed)localObject1).a()).recommendId;
      }
      else
      {
        paramInt = 11;
        l = ((BannerFeedItem)((StoryHomeFeed)localObject1).a()).recommendId;
      }
    }
    else
    {
      paramInt = 9;
      l = ((GeneralRecommendFeedItem)((StoryHomeFeed)localObject1).a()).recommendId;
    }
    FeedUtils.a((String)localObject2, paramInt, l);
    localObject1 = ((StoryHomeFeed)localObject1).a().feedId;
    Bosses.get().postJob(new FeedSegment.15(this, "Q.qqstory.home:FeedSegment", (String)localObject1));
    m();
  }
  
  private void h(int paramInt)
  {
    if (this.g)
    {
      d(paramInt);
      return;
    }
    if (a(paramInt) == null)
    {
      d(paramInt);
      this.g = true;
    }
  }
  
  private void n()
  {
    if (StoryDepends.a()) {
      return;
    }
    InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    if ((this.i) && (this.h))
    {
      Object localObject2 = a();
      Object localObject1 = new Rect();
      if (localObject2 != null)
      {
        boolean bool = ((View)localObject2).getGlobalVisibleRect((Rect)localObject1);
        int[] arrayOfInt = new int[2];
        ((View)localObject2).getLocationInWindow(arrayOfInt);
        InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704579), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
        InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704587), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject2).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject2).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject2)) });
      }
      else
      {
        SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
      }
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704580), Integer.valueOf(((Rect)localObject1).top), ",bottom:", Integer.valueOf(((Rect)localObject1).bottom) });
      this.i = false;
      localObject2 = this.jdField_a_of_type_AndroidOsHandler;
      ((Handler)localObject2).sendMessage(((Handler)localObject2).obtainMessage(13, localObject1));
      localObject1 = (NewMyStorySegment)a().a("NewMyStorySegment");
      if (localObject1 != null) {
        ((NewMyStorySegment)localObject1).a(false);
      }
      a().setSelection(0);
    }
  }
  
  protected void M_()
  {
    super.M_();
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    b(0);
    AbstractGifImage.resumeAll();
  }
  
  public void P_()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a()).iterator();
      while (localIterator.hasNext())
      {
        StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
        if (((localStoryHomeFeed instanceof ShareGroupHomeFeed)) && (localStoryHomeFeed.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localStoryHomeFeed.a().getOwner()).isPublic()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed == null))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed = localStoryHomeFeed;
          SLog.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelStoryHomeFeed.toString());
          return;
        }
      }
      SLog.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void R_()
  {
    super.R_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    QQStoryAutoPlayView localQQStoryAutoPlayView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
    if (localQQStoryAutoPlayView != null) {
      localQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size();
  }
  
  protected int a(int paramInt)
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    if (localStoryHomeFeed.a().type == 1) {
      return 0;
    }
    if (localStoryHomeFeed.a().type == 3) {
      return 0;
    }
    if (localStoryHomeFeed.a().type == 2) {
      return 0;
    }
    if (localStoryHomeFeed.a().type == 5) {
      return 1;
    }
    if (localStoryHomeFeed.a().type == 6) {
      return 2;
    }
    if (localStoryHomeFeed.a().type == 7) {
      return 3;
    }
    return super.a(paramInt);
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
  
  public View a()
  {
    int j = 0;
    StringBuilder localStringBuilder;
    for (;;)
    {
      int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size();
      localStringBuilder = null;
      localObject1 = localStringBuilder;
      if (j >= k) {
        return localObject1;
      }
      localObject1 = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(j);
      if ((((StoryHomeFeed)localObject1).a().type == 1) || (((StoryHomeFeed)localObject1).a().type == 2)) {
        break;
      }
      j += 1;
    }
    Object localObject1 = a(j);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131374522);
    if (localObject2 == null)
    {
      SLog.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
      return null;
    }
    localObject1 = ((VideoListLayout)localObject2).a();
    localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("返回了单个视频的view：");
      localStringBuilder.append(((QQStoryAutoPlayView)localObject1).a().getThumbUrl());
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
          localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374520);
          InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704566), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
        }
      }
    }
    return localObject1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramBaseViewHolder.a("feed_id", localStoryHomeFeed.a().feedId);
    View localView = paramBaseViewHolder.a();
    int j = a(paramInt);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
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
    else if (localStoryHomeFeed.a().type == 1) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralHomeFeed)localStoryHomeFeed);
    } else if (localStoryHomeFeed.a().type == 2) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (ShareGroupHomeFeed)localStoryHomeFeed);
    } else if (localStoryHomeFeed.a().type == 3) {
      localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralRecommendHomeFeed)localStoryHomeFeed);
    }
    localStoryHomeFeed.jdField_b_of_type_Boolean = true;
    d(paramBaseViewHolder);
    paramBaseViewHolder = new ArrayList();
    paramBaseViewHolder.add(localStoryHomeFeed);
    b(paramBaseViewHolder, 0);
    StoryReportor.b("story_home_dev", "feed_exp", localStoryHomeFeed.a().type, localStoryHomeFeed.d().size(), new String[] { localStoryHomeFeed.a().feedId });
    return localView;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, GeneralHomeFeed paramGeneralHomeFeed)
  {
    SLog.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374490);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374494);
    a(paramGeneralHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramGeneralHomeFeed, paramGeneralHomeFeed.a().getOwner());
    a(paramBaseViewHolder, paramGeneralHomeFeed, true);
    a(paramInt, paramBaseViewHolder);
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167149);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", paramGeneralHomeFeed.a().feedId);
    a(paramGeneralHomeFeed, paramBaseViewHolder);
    a(paramGeneralHomeFeed, paramBaseViewHolder, localFrameLayout, null);
    return paramBaseViewHolder.a();
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, ShareGroupHomeFeed paramShareGroupHomeFeed)
  {
    SLog.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374490);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374494);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramShareGroupHomeFeed, ((ShareGroupFeedItem)paramShareGroupHomeFeed.a()).getOwner());
    a(paramBaseViewHolder, paramShareGroupHomeFeed, true);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167149);
    } else {
      paramInt = -3355444;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramBaseViewHolder.a("feed_id", ((ShareGroupFeedItem)paramShareGroupHomeFeed.a()).feedId);
    paramBaseViewHolder.a("group_id", ((ShareGroupFeedItem)paramShareGroupHomeFeed.a()).getOwner().shareGroupId);
    a(paramShareGroupHomeFeed, paramBaseViewHolder, localFrameLayout, ((ShareGroupFeedItem)paramShareGroupHomeFeed.a()).getOwner());
    paramShareGroupHomeFeed.jdField_b_of_type_Boolean = true;
    return paramBaseViewHolder.a();
  }
  
  @NonNull
  protected HomeFeedPresenter a(boolean paramBoolean)
  {
    return new HomeFeedPresenter(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("FeedItem.createView");
    int j = a(paramInt);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
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
  
  protected BaseViewHolder a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    int j = 0;
    while (j < ((List)localObject).size())
    {
      if (TextUtils.equals(paramString, ((StoryHomeFeed)((List)localObject).get(j)).a().feedId)) {
        break label58;
      }
      j += 1;
    }
    j = -1;
    label58:
    if (j == -1) {
      return null;
    }
    BaseViewHolder localBaseViewHolder = a(j);
    if ((localBaseViewHolder != null) && (paramString.equals(localBaseViewHolder.a("feed_id")))) {
      return localBaseViewHolder;
    }
    if (localBaseViewHolder != null)
    {
      localObject = (StoryHomeFeed)((List)localObject).get(j);
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
  
  public String a()
  {
    return "FeedSegment";
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
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
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374517);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374518);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131374516);
    if (localRelativeLayout == null) {
      return;
    }
    if (StoryDepends.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramInt = ((StoryHomeFeed)localObject).a().type;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          localObject = (TagFeedItem)((StoryHomeFeed)localObject).a();
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
            localObject = HardCodeUtil.a(2131704565);
          } else {
            localObject = ((TagFeedItem)localObject).recommendTitle;
          }
          localRelativeLayout.setVisibility(0);
          localImageView.setOnClickListener(paramBaseViewHolder);
          localTextView.setText((CharSequence)localObject);
          return;
        }
        localObject = (BannerFeedItem)((StoryHomeFeed)localObject).a();
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
          localObject = HardCodeUtil.a(2131704568);
        } else {
          localObject = ((BannerFeedItem)localObject).recommendTitle;
        }
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramBaseViewHolder);
        localTextView.setText((CharSequence)localObject);
        return;
      }
      if (((StoryHomeFeed)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((StoryHomeFeed)localObject).a();
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
        localObject = HardCodeUtil.a(2131704574);
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
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374504);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(PlayModeUtils.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846669));
      TraceUtils.traceEnd();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, ImageUtil.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark)) {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
    } else {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
    }
    if (paramVideoListHomeFeed.a().getOwner().getRelationType() == 2)
    {
      paramBaseViewHolder = "";
    }
    else if (paramVideoListHomeFeed.a().type == 3)
    {
      paramBaseViewHolder = (GeneralRecommendFeedItem)paramVideoListHomeFeed.a();
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
    if (paramVideoListHomeFeed.a().type == 1) {
      a(localQQStoryOwnerInfoView, null, false);
    } else if (paramVideoListHomeFeed.a().type == 3) {
      if (StoryProfileUtils.a(paramQQUserUIItem)) {
        a(localQQStoryOwnerInfoView, HardCodeUtil.a(2131704582), true);
      } else {
        a(localQQStoryOwnerInfoView, null, false);
      }
    }
    paramBaseViewHolder = localQQStoryOwnerInfoView.a();
    paramBaseViewHolder.setUnionID(paramQQUserUIItem.getUnionId(), 1);
    if (!paramVideoListHomeFeed.jdField_b_of_type_Boolean) {
      paramBaseViewHolder.a();
    }
    localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
    TraceUtils.traceEnd();
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374497);
    TraceUtils.traceBegin("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374496);
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131374498);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131374499);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      TraceUtils.traceEnd();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846747);
      paramBaseViewHolder.setImageResource(2130846749);
    }
    else
    {
      ((ImageView)localObject1).setImageResource(2130846746);
      paramBaseViewHolder.setImageResource(2130846748);
    }
    if (paramInt == 0)
    {
      paramBaseViewHolder = UIUtils.a(DateUtils.a(((StoryHomeFeed)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramBaseViewHolder);
    }
    else
    {
      paramBaseViewHolder = (StoryHomeFeed)((List)localObject2).get(paramInt - 1);
      localObject2 = (StoryHomeFeed)((List)localObject2).get(paramInt);
      localObject1 = DateUtils.a(paramBaseViewHolder.a().date);
      localObject2 = DateUtils.a(((StoryHomeFeed)localObject2).a().date);
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
    if (UIUtils.b()) {
      return;
    }
    int j;
    if (this.jdField_a_of_type_Int == 10) {
      j = 74;
    } else {
      j = 76;
    }
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem))
    {
      paramVideoListFeedItem = (HotRecommendFeedItem)paramVideoListFeedItem;
      paramVideoListFeedItem = new OpenPlayerBuilder(new HotRecommendFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mAttachedFeedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), j);
      paramVideoListFeedItem.a(false).b(true);
      paramVideoListFeedItem.a(c());
      if ((paramView instanceof QQStoryAutoPlayView)) {
        StoryPlayerLauncher.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
      } else {
        StoryPlayerLauncher.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
      }
      StoryReportor.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
    }
    Object localObject = null;
    paramInt = this.jdField_a_of_type_Int;
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
      localObject = new OpenPlayerBuilder((Serializable)localObject, j);
      ((OpenPlayerBuilder)localObject).a(c());
      localObject = ((OpenPlayerBuilder)localObject).a();
      if (74 == j) {
        ((OpenPlayerBuilder.Data)localObject).mUIStyle.bottomWidgetShowFlag = 3;
      }
      if ((paramView instanceof QQStoryAutoPlayView)) {
        StoryPlayerLauncher.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
      } else {
        StoryPlayerLauncher.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
      }
    }
    paramInt = StoryReportor.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
      paramView = paramVideoListFeedItem.getOwner().getUnionId();
    } else {
      paramView = "";
    }
    StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), FeedItemThumbAdapter.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    paramViewGroup = paramFeedCommentLego.c;
    boolean bool = true;
    if ((paramViewGroup == null) || (paramFeedCommentLego.c.size() <= 1)) {
      bool = false;
    }
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
    paramViewGroup.setFeedItemData(paramFeedCommentLego.a, this.jdField_a_of_type_Int, c(), bool);
    paramViewGroup.a(paramFeedCommentLego, paramCommentEntry);
    paramFeedCommentLego = this.jdField_a_of_type_AndroidOsHandler;
    paramFeedCommentLego.sendMessageDelayed(paramFeedCommentLego.obtainMessage(12, paramView), 150L);
  }
  
  public void a(VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if ((((Integer)((StoryConfigManager)SuperManager.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList != null))
    {
      TVKPreloader.a();
      paramGetVideoBasicInfoListEvent = new ArrayList(paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList).iterator();
      while (paramGetVideoBasicInfoListEvent.hasNext()) {
        TVKPreloader.a(((StoryVideoItem)paramGetVideoBasicInfoListEvent.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(GeneralHomeFeed paramGeneralHomeFeed, BaseViewHolder paramBaseViewHolder)
  {
    paramGeneralHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    if (paramGeneralHomeFeed != null)
    {
      paramGeneralHomeFeed = paramGeneralHomeFeed.a();
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
      c(false);
      return;
    }
    if (paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FeedSegment onFeedItemBack feedData.errorInfo=null!!,");
      ((StringBuilder)localObject).append(paramHomeFeedData);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      c(false);
      return;
    }
    SLog.d("Q.qqstory.home:FeedSegment", paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
    if (paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
      c(false);
    } else {
      c(true);
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null)
    {
      String str = this.jdField_b_of_type_JavaLangString;
      if (str != null)
      {
        a((String)localObject, str, false);
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a(paramHomeFeedData.jdField_b_of_type_JavaUtilList, 0);
    if (!paramHomeFeedData.jdField_b_of_type_Boolean) {
      a().setLoadMoreComplete(a(), paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramHomeFeedData.jdField_a_of_type_Boolean ^ true);
    }
  }
  
  protected void a(ShareGroupHomeFeed paramShareGroupHomeFeed, BaseViewHolder paramBaseViewHolder)
  {
    paramShareGroupHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    if (paramShareGroupHomeFeed != null)
    {
      paramShareGroupHomeFeed = paramShareGroupHomeFeed.a();
      if (paramShareGroupHomeFeed != null) {
        paramShareGroupHomeFeed.setVisibility(8);
      }
    }
  }
  
  public void a(VideoListHomeFeed paramVideoListHomeFeed)
  {
    SLog.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramVideoListHomeFeed);
    if ((paramVideoListHomeFeed != null) && (paramVideoListHomeFeed.a() != null) && (paramVideoListHomeFeed.a().feedId != null))
    {
      d(paramVideoListHomeFeed.a().feedId);
      return;
    }
    SLog.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder)
  {
    Object localObject = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    ((VideoListLayout)localObject).a().setOnClickListener(paramBaseViewHolder);
    ((VideoListLayout)localObject).a().setOnClickListener(paramBaseViewHolder);
    localObject = ((VideoListLayout)localObject).a();
    FeedSegment.VideoListTouchEventHandler localVideoListTouchEventHandler = new FeedSegment.VideoListTouchEventHandler(this);
    paramBaseViewHolder.a("general_touch_handler", localVideoListTouchEventHandler);
    paramBaseViewHolder.a("general_adapter", null);
    paramBaseViewHolder.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localVideoListTouchEventHandler);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localVideoListTouchEventHandler);
    paramBaseViewHolder.a("type", "GeneralView");
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, TagHomeFeed paramTagHomeFeed)
  {
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131374619);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374618);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374621);
    TagItem localTagItem = ((TagFeedItem)paramTagHomeFeed.a()).tagItem;
    paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131374616);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166530));
      paramBaseViewHolder.setBackgroundResource(2130846772);
    }
    if (localTagItem != null)
    {
      localTextView1.setText(localTagItem.a.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.a()).blurb))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((TagFeedItem)paramTagHomeFeed.a()).blurb);
      }
      else
      {
        localTextView2.setVisibility(8);
      }
      if (!TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.a()).content))
      {
        localTextView3.setVisibility(0);
        localTextView3.setText(((TagFeedItem)paramTagHomeFeed.a()).content);
        return;
      }
      localTextView3.setVisibility(8);
    }
  }
  
  public void a(FeedSegment.StoryVideoDownloadedEvent paramStoryVideoDownloadedEvent)
  {
    b(0);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddFakeFeedItem:");
    localStringBuilder.append(paramString);
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      if (paramString1.equals(localStoryHomeFeed.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localStoryHomeFeed, paramString2, false);
        return;
      }
      j += 1;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isOnScreenArea location[1]=");
    localStringBuilder.append(arrayOfInt[1]);
    localStringBuilder.append(",parentLocation[1]=");
    localStringBuilder.append(paramView[1]);
    localStringBuilder.append(",viewHeight");
    localStringBuilder.append(j);
    localStringBuilder.append(",getParentListView().getHeight()=");
    localStringBuilder.append(a().getHeight());
    SLog.b("Q.qqstory.home:FeedSegment", localStringBuilder.toString());
    return (arrayOfInt[1] > paramView[1]) && (arrayOfInt[1] + j < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  public void a_(boolean paramBoolean)
  {
    super.a_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      h();
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    SLog.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561663, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374504);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    TraceUtils.traceBegin("fetchViewWhichNeedPlay");
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a()) && (this.jdField_a_of_type_Int == 10))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAutoPlayCondition scrollDirection=");
      ((StringBuilder)localObject1).append(paramInt);
      SLog.d("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (VideoListLayout)((BaseViewHolder)localIterator.next()).a(2131374522);
        if (localObject2 != null)
        {
          localObject1 = ((VideoListLayout)localObject2).a();
          localObject2 = ((VideoListLayout)localObject2).a();
          if ((localObject1 == null) || (((QQStoryAutoPlayView)localObject1).getVisibility() != 0)) {
            if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null)) {
              localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374520);
            } else {
              localObject1 = null;
            }
          }
          if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).a() != null))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("for holder start cover=");
            ((StringBuilder)localObject2).append(((QQStoryAutoPlayView)localObject1).a().getThumbUrl());
            SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject2).toString());
            localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
            if (localObject2 == null)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)localObject1);
            }
            else
            {
              int j;
              int k;
              if (paramInt != 1)
              {
                if (paramInt != 2)
                {
                  j = StoryListUtils.a((View)localObject2);
                  k = StoryListUtils.a((View)localObject1);
                }
                else
                {
                  j = StoryListUtils.b((View)localObject2);
                  k = StoryListUtils.b((View)localObject1);
                }
              }
              else
              {
                j = StoryListUtils.c((View)localObject2);
                k = StoryListUtils.c((View)localObject1);
              }
              if ((a((View)localObject1)) && (j >= k))
              {
                localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
                if (localObject2 != localObject1)
                {
                  ((QQStoryAutoPlayView)localObject2).b();
                  this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)localObject1);
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("FeedSegment checkAutoPlayCondition find playView index=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a());
        ((StringBuilder)localObject1).append(",url=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
        SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
      }
      else
      {
        SLog.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
      if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).a() == 0)) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a()) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.c();
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a());
        }
      }
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fetchViewWhichNeedPlay but needAutoPlay=");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject1).append(",mIView.isViewOnResume()=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a());
    SLog.e("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject1).toString());
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
      a((HotRecommendFeedItem)paramVideoListFeedItem, paramStoryVideoItem);
    }
  }
  
  public void b(HomeFeedData paramHomeFeedData)
  {
    c(true);
  }
  
  protected void b(BaseViewHolder paramBaseViewHolder)
  {
    ((VideoListLayout)paramBaseViewHolder.a(2131374522)).a().setVisibility(8);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    SLog.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public int c()
  {
    int j = this.jdField_a_of_type_Int;
    if (j == 11) {
      return 30000;
    }
    if (j == 12) {
      return 20004;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {}
    return 20002;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    AutoPlayManager localAutoPlayManager = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager;
    if (localAutoPlayManager == null) {
      return;
    }
    localAutoPlayManager.b(paramInt);
  }
  
  public void c(BaseViewHolder paramBaseViewHolder)
  {
    TraceUtils.traceBegin("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramBaseViewHolder);
    Object localObject = (VideoListLayout)paramBaseViewHolder.a(2131374522);
    if (localObject == null)
    {
      TraceUtils.traceEnd();
      return;
    }
    paramBaseViewHolder = ((VideoListLayout)localObject).a();
    localObject = ((VideoListLayout)localObject).a();
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.getVisibility() != 0)) {
      if ((localObject != null) && (((StoryHomeHorizontalListView)localObject).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject).getChildAt(0) != null)) {
        paramBaseViewHolder = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374520);
      } else {
        paramBaseViewHolder = null;
      }
    }
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.a() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("for holder onMovedToScrapHeap cover=");
      ((StringBuilder)localObject).append(paramBaseViewHolder.a().getThumbUrl());
      SLog.b("Q.qqstory.home:FeedSegment", ((StringBuilder)localObject).toString());
    }
    if (paramBaseViewHolder != null) {
      paramBaseViewHolder.a();
    }
    TraceUtils.traceEnd();
  }
  
  public void c(@NonNull String paramString)
  {
    if (StoryDepends.a()) {
      return;
    }
    this.i = true;
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null) {
      ((View)localObject).getGlobalVisibleRect(localRect);
    } else {
      SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
    InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
    localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
    ((Intent)localObject).putExtra("path", paramString);
    ((Intent)localObject).putExtra("target_top", localRect.top);
    ((Intent)localObject).putExtra("target_right", localRect.right);
    ((Intent)localObject).putExtra("target_left", localRect.left);
    ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    paramString = (NewMyStorySegment)a().a("NewMyStorySegment");
    if (paramString != null) {
      paramString.a(false);
    }
    a().setSelection(0);
  }
  
  protected void d()
  {
    super.d();
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$StoryVideoDownloadedReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetVideoBasicInfoListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$GetUserInfoReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$TroopNickNameUpdateEventReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$DeleteShareGroupMemberEventReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$PlayVideoChangeReceiver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
    if (localObject != null) {
      ((QQStoryAutoPlayView)localObject).a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a();
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)((BaseViewHolder)((Iterator)localObject).next()).a("commentLikeLego");
      if (localFeedCommentLikeLego != null) {
        localFeedCommentLikeLego.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.b();
    StoryQQTextCacher.a();
  }
  
  public void d(BaseViewHolder paramBaseViewHolder)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramBaseViewHolder);
  }
  
  protected int d_()
  {
    return 4;
  }
  
  public void f()
  {
    SLog.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  public void f_(int paramInt)
  {
    e(paramInt);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new FeedSegment.1(this));
    a().setLoadMoreComplete(a(), true, a() ^ true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 1)
    {
      if (j != 2)
      {
        switch (j)
        {
        default: 
          return true;
        case 13: 
          if (QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_Boolean)
          {
            SLog.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
            paramMessage = (Rect)paramMessage.obj;
            ThreadManager.getSubThreadHandler().post(new FeedSegment.9(this, paramMessage));
            return true;
          }
          localObject1 = this.jdField_a_of_type_AndroidOsHandler;
          ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(13, paramMessage.obj), 50L);
          return true;
        case 12: 
          paramMessage = (View)paramMessage.obj;
          localObject1 = new int[2];
          j = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a().getLocationOnScreen((int[])localObject1);
          if (localObject1[1] > j * 4 / 5)
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler;
            ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(12, paramMessage), 50L);
            return true;
          }
          localObject2 = new int[2];
          paramMessage.getLocationOnScreen((int[])localObject2);
          j = localObject2[1] + (paramMessage.getBottom() - paramMessage.getTop()) - localObject1[1];
          a().smoothScrollBy(j, j * 2 / 3);
          return true;
        }
        int[] arrayOfInt1 = new int[2];
        j = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
        StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
        localStoryInputBarView.getLocationOnScreen(arrayOfInt1);
        Object localObject2 = (String)paramMessage.obj;
        if (arrayOfInt1[1] > j * 4 / 5)
        {
          paramMessage = this.jdField_a_of_type_AndroidOsHandler;
          paramMessage.sendMessageDelayed(paramMessage.obtainMessage(11, localObject2), 50L);
          return true;
        }
        Object localObject1 = null;
        int[] arrayOfInt2 = new int[2];
        a().getLocationOnScreen(arrayOfInt2);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
          j = paramMessage.jdField_c_of_type_Int;
          int k = paramMessage.a().getBottom();
          int m = paramMessage.a().getTop();
          int n = arrayOfInt2[1];
          localStoryInputBarView.getLocationOnScreen(arrayOfInt1);
          a().setSelectionFromTop(j, arrayOfInt1[1] - (k - m + n));
          return true;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("comment feed id is error! id=");
        paramMessage.append((String)localObject2);
        AssertUtils.assertTrue(false, paramMessage.toString());
        return true;
      }
      c(true);
      return true;
    }
    paramMessage = (HomeFeedData)paramMessage.obj;
    if ((paramMessage != null) && (!paramMessage.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      b(paramMessage);
      return true;
    }
    c(false);
    return true;
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (BaseViewHolder)localIterator.next();
      SLog.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (FeedCommentLikeLego)((BaseViewHolder)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((FeedCommentLikeLego)localObject).c();
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void k()
  {
    b(0);
    SLog.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    Object localObject1 = (StoryConfigManager)SuperManager.a(10);
    Object localObject3 = "";
    String str = (String)((StoryConfigManager)localObject1).b("mainHallConfig", "");
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
    localObject3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject3).putExtra("url", localObject2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment
 * JD-Core Version:    0.7.0.1
 */