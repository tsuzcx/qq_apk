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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.biz.qqstory.base.QQStoryHandler;
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
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298597);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298608);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (NetworkUtil.h(paramContext)) {
      return 1;
    }
    if (NetworkUtil.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, GeneralRecommendHomeFeed paramGeneralRecommendHomeFeed)
  {
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374958);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374962);
    b(paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramGeneralRecommendHomeFeed, paramGeneralRecommendHomeFeed.a().getOwner());
    a(paramBaseViewHolder, paramGeneralRecommendHomeFeed, true);
    a(paramGeneralRecommendHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167124);
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
    paramViewGroup = (VideoListLayout)paramBaseViewHolder.a(2131374991);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.jdField_b_of_type_Int, paramBaseViewHolder);
    if ((paramHotRecommendHomeFeed.a() == null) || (paramHotRecommendHomeFeed.a().size() == 0))
    {
      SLog.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId);
      paramBaseViewHolder.a.setVisibility(8);
      return paramBaseViewHolder.a();
    }
    paramBaseViewHolder.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (HotRecommendFeedAdapter)paramBaseViewHolder.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new HotRecommendFeedAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramBaseViewHolder.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramHotRecommendHomeFeed.a().size();
        paramViewGroup.a(paramHotRecommendHomeFeed.a(), paramHotRecommendHomeFeed.a());
        if (((HotRecommendFeedItem)paramHotRecommendHomeFeed.a()).mIsVideoEnd) {
          break label501;
        }
        bool = true;
        label385:
        ((StoryHomeHorizontalListView)localObject1).setLoadMoreComplete(bool);
        if (j > paramInt) {
          ((StoryHomeHorizontalListView)localObject1).post(new FeedSegment.6(this, (StoryHomeHorizontalListView)localObject1));
        }
        if (paramInt > j) {
          ((StoryHomeHorizontalListView)localObject1).a();
        }
        paramViewGroup = paramBaseViewHolder.a(2131380454);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((StoryConfigManager)SuperManager.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        StoryReportor.a("home_page", "multi_exp", 0, 0, new String[0]);
        break;
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(0);
        break label316;
        label501:
        bool = false;
        break label385;
        label507:
        paramViewGroup.setVisibility(0);
      }
    }
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, TagHomeFeed paramTagHomeFeed)
  {
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374958);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramBaseViewHolder, paramTagHomeFeed);
    a(paramInt, paramBaseViewHolder);
    a(paramBaseViewHolder, paramTagHomeFeed, true);
    a(null, paramBaseViewHolder);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167124);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    StoryReportor.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramTagHomeFeed.a()).feedId });
    return paramBaseViewHolder.a();
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, BannerHomeFeed paramBannerHomeFeed)
  {
    Object localObject = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374972);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131374943);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramBaseViewHolder.a(2131374935);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374937);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramBannerHomeFeed.a();
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, HardCodeUtil.a(2131704479), true);
    if (StoryProfileUtils.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      UIUtils.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, ImageUtil.a(1), "QQStory_main");
      a(paramInt, paramBaseViewHolder);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramBannerHomeFeed.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (FeedCommentLikeLego)paramBaseViewHolder.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new FeedCommentLikeLego(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramBannerHomeFeed, this.jdField_a_of_type_Int);
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).l();
      paramBaseViewHolder.a("commentLikeLego", localObject);
      localFrameLayout.addView(((FeedCommentLikeLego)localObject).b);
    }
    for (;;)
    {
      ((FeedCommentLikeLego)localObject).a(this);
      ((FeedCommentLikeLego)localObject).a(this);
      ((FeedCommentLikeLego)localObject).a(false);
      if (!paramBannerHomeFeed.jdField_b_of_type_Boolean) {
        StoryReportor.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramBannerHomeFeed.a()).getOwner().getUnionId(), ((BannerFeedItem)paramBannerHomeFeed.a()).feedId });
      }
      return paramBaseViewHolder.a();
      localButton.setVisibility(8);
      break;
      label518:
      localTextView4.setVisibility(0);
      localTextView4.setText(localBannerFeedItem.content);
      break label164;
      label537:
      localTextView2.setVisibility(0);
      localTextView2.setText(localBannerFeedItem.blurb);
      break label235;
      label556:
      ((FeedCommentLikeLego)localObject).a(paramBannerHomeFeed, null, paramBannerHomeFeed);
      ((FeedCommentLikeLego)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      SLog.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = UIUtils.a() / 3600;
    paramList = paramList.iterator();
    int k = 0;
    int j = n;
    if (paramList.hasNext())
    {
      localObject = (StoryVideoItem)paramList.next();
      if (TextUtils.isEmpty(((StoryVideoItem)localObject).mUserSelectLocationText)) {}
    }
    for (paramList = ((StoryVideoItem)localObject).mUserSelectLocationText;; paramList = null)
    {
      localObject = paramList;
      if (!TextUtils.isEmpty(paramList)) {
        break;
      }
      if (j != n)
      {
        return StoryListUtils.a(j, true);
        if ((k != 0) || (((StoryVideoItem)localObject).mTimeZoneOffsetMillis == 2147483647L)) {
          break label143;
        }
        k = (int)(((StoryVideoItem)localObject).mTimeZoneOffsetMillis / 3600000L);
        j = 1;
      }
      for (;;)
      {
        int m = k;
        k = j;
        j = m;
        break;
        return "";
        label143:
        m = j;
        j = k;
        k = m;
      }
    }
  }
  
  private void a(int paramInt, StoryHomeFeed paramStoryHomeFeed, String paramString, boolean paramBoolean)
  {
    if (!(paramStoryHomeFeed instanceof VideoListHomeFeed)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        SLog.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramStoryHomeFeed, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131374991);
        List localList = ((VideoListHomeFeed)paramStoryHomeFeed).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
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
    }
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, ShareGroupItem paramShareGroupItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindFeedShareGroupInfo");
    paramBaseViewHolder = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374972);
    if (paramShareGroupItem == null)
    {
      paramBaseViewHolder.setSubTitle(null);
      paramBaseViewHolder.setBadge(null);
      paramBaseViewHolder.setQIMIcon(null);
      paramBaseViewHolder.setSubTitleSuffix(null);
      paramBaseViewHolder.setButtonTxt(null);
      paramBaseViewHolder.setName(PlayModeUtils.jdField_b_of_type_JavaLangString);
      paramBaseViewHolder.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846789));
      TraceUtils.traceEnd();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = ImageUtil.d();
      paramBaseViewHolder.setAvatar(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramBaseViewHolder.setName(paramShareGroupItem.getName());
      if (paramVideoListHomeFeed.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((ShareGroupHomeFeed)paramVideoListHomeFeed).a(), paramVideoListHomeFeed.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramBaseViewHolder.setSubTitle((String)localObject1);
        paramBaseViewHolder.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramBaseViewHolder.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130847154);
      label199:
      if (paramVideoListHomeFeed.a().type == 2)
      {
        if (!paramVideoListHomeFeed.a()) {
          break label328;
        }
        a(paramBaseViewHolder, HardCodeUtil.a(2131704486), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramBaseViewHolder = paramBaseViewHolder.a();
      paramBaseViewHolder.a(null);
      paramBaseViewHolder.setVisibility(8);
      TraceUtils.traceEnd();
      return;
      paramBaseViewHolder.setAvatar(((ShareGroupIconManager)SuperManager.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130847156);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130847155);
      break label199;
      label328:
      a(paramBaseViewHolder, null, false);
    }
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
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        SLog.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = ImageDownloader.FILE.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        SLog.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!StoryListUtils.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = ImageDownloader.FILE.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      TraceUtils.traceEnd();
      return;
      if (!bool)
      {
        paramInt1 = 225;
        paramInt2 = 364;
        localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        break;
      }
      paramInt1 = 150;
      paramInt2 = 243;
      localDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break;
      label176:
      SLog.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = ThumbnailUrlHelper.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = ThumbnailUrlHelper.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
        }
      }
      else {
        label229:
        paramStoryVideoItem = str;
      }
    }
  }
  
  private void a(HotRecommendFeedItem paramHotRecommendFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.addButton(HardCodeUtil.a(2131704481), 5);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = HardCodeUtil.a(2131704482);; str = HardCodeUtil.a(2131704474))
    {
      localActionSheet.addButton(str, 5);
      localActionSheet.addButton(HardCodeUtil.a(2131704499), 5);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new FeedSegment.13(this, localActionSheet, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localActionSheet.setOnDismissListener(new FeedSegment.14(this));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      StoryReportor.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed)
  {
    if ((paramStoryHomeFeed == null) || (paramStoryHomeFeed.a() == null) || (paramStoryHomeFeed.a().getOwner() == null)) {
      AssertUtils.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
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
          AssertUtils.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramStoryHomeFeed.getOwner().getRelationType() == 2)
        {
          if (this.jdField_a_of_type_Int == 10)
          {
            j = 1;
            if (this.jdField_a_of_type_Int != 10) {
              break label186;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ShareGroupItem)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), j, k);
            return;
            j = 9;
            break;
          }
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
          if (this.jdField_a_of_type_Int == 10)
          {
            j = 2;
            if (this.jdField_a_of_type_Int != 10) {
              break label289;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((QQUserUIItem)localObject).uid, ((QQUserUIItem)localObject).qq, j, k);
            return;
            j = 9;
            break;
          }
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
    } while (!(paramStoryHomeFeed instanceof HotRecommendHomeFeed));
    label289:
    l();
    StoryReportor.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed, ShareGroupItem paramShareGroupItem)
  {
    if (ShareGroupUtil.a(paramShareGroupItem))
    {
      if (paramStoryHomeFeed.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        StoryReportor.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131704498), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new AddVideoController((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    StoryReportor.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(StoryHomeFeed paramStoryHomeFeed, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramStoryHomeFeed.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      StoryReportor.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramStoryHomeFeed.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(VideoListHomeFeed paramVideoListHomeFeed, BaseViewHolder paramBaseViewHolder) {}
  
  private void a(VideoListHomeFeed paramVideoListHomeFeed, BaseViewHolder paramBaseViewHolder, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindCommentLike");
    FeedCommentLikeLego localFeedCommentLikeLego;
    if (paramVideoListHomeFeed.a().size() > 0)
    {
      localFeedCommentLikeLego = (FeedCommentLikeLego)paramBaseViewHolder.a("commentLikeLego");
      if (localFeedCommentLikeLego != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localFeedCommentLikeLego = FeedCommentLikeLego.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramVideoListHomeFeed, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramBaseViewHolder.a("commentLikeLego", localFeedCommentLikeLego);
      paramFrameLayout.addView(localFeedCommentLikeLego.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localFeedCommentLikeLego.k();
        paramVideoListHomeFeed = paramFrameLayout.getLayoutParams();
        paramVideoListHomeFeed.height = UIUtils.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramVideoListHomeFeed);
      }
      for (;;)
      {
        TraceUtils.traceEnd();
        return;
        label132:
        localFeedCommentLikeLego = new FeedCommentLikeLego(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramVideoListHomeFeed, this.jdField_a_of_type_Int);
        break;
        paramBaseViewHolder = paramFrameLayout.getLayoutParams();
        paramBaseViewHolder.height = -2;
        paramFrameLayout.setLayoutParams(paramBaseViewHolder);
        if (localFeedCommentLikeLego.a())
        {
          localFeedCommentLikeLego.a(paramVideoListHomeFeed, paramShareGroupItem, null);
          localFeedCommentLikeLego.c(null);
        }
        for (;;)
        {
          localFeedCommentLikeLego.a(this);
          localFeedCommentLikeLego.a(this);
          if ((paramVideoListHomeFeed.a().mVideoPullType != 0) || (paramVideoListHomeFeed.a().size() <= 1)) {
            break label249;
          }
          localFeedCommentLikeLego.a(true);
          break;
          localFeedCommentLikeLego.l();
        }
        label249:
        localFeedCommentLikeLego.a(false);
      }
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846965);
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
    Object localObject2 = (VideoListLayout)paramBaseViewHolder.a(2131374991);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((FeedSegment.VideoListTouchEventHandler)paramBaseViewHolder.a("general_touch_handler")).a(paramBaseViewHolder.jdField_b_of_type_Int, paramBaseViewHolder);
    if ((paramVideoListHomeFeed.a() == null) || (paramVideoListHomeFeed.a().size() == 0))
    {
      SLog.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramVideoListHomeFeed.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      TraceUtils.traceEnd();
      return;
    }
    Object localObject1;
    if (paramVideoListHomeFeed.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (FeedItemThumbAdapter)paramBaseViewHolder.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new FeedItemThumbAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((FeedItemThumbAdapter)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramBaseViewHolder.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((FeedItemThumbAdapter)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((FeedItemThumbAdapter)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramVideoListHomeFeed.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          SLog.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramVideoListHomeFeed.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramVideoListHomeFeed.a().size() != 2) {
          break label563;
        }
        j = (UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((FeedItemThumbAdapter)localObject1).a(j, k);
        ((FeedItemThumbAdapter)localObject1).a(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramVideoListHomeFeed.a().type != 6) {
          break label642;
        }
        j = k + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298608));
        ((FeedItemThumbAdapter)localObject1).a(paramVideoListHomeFeed.a(), paramVideoListHomeFeed.a());
        if (StoryDepends.a())
        {
          if ((!this.i) || (paramBaseViewHolder.jdField_b_of_type_Int != 0) || ((!paramVideoListHomeFeed.b()) && (!paramVideoListHomeFeed.a().isFakeFeedItem()))) {
            break label660;
          }
          ((FeedItemThumbAdapter)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramVideoListHomeFeed.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (UIUtils.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((FeedItemThumbAdapter)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramVideoListHomeFeed.a().size() == 1)
      {
        j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramVideoListHomeFeed.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramVideoListHomeFeed.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((StoryDepends.a()) && (this.i) && (paramBaseViewHolder.jdField_b_of_type_Int == 0) && ((paramVideoListHomeFeed.b()) || (paramVideoListHomeFeed.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167127));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(HardCodeUtil.a(2131704493));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167127));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramVideoListHomeFeed.a().type == 3) && ((paramVideoListHomeFeed.a().getOwner() instanceof QQUserUIItem)))
          {
            paramBaseViewHolder = (QQUserUIItem)paramVideoListHomeFeed.a().getOwner();
            if ((paramBaseViewHolder.isVip) && (!paramBaseViewHolder.isSubscribe())) {
              StoryReportor.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramVideoListHomeFeed.a().type != 6) {
            break;
          }
          StoryReportor.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            SLog.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new FeedSegment.7(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          StoryVideoUploadProgressManager.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(UIUtils.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramVideoListHomeFeed.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramVideoListHomeFeed.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(UIUtils.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramVideoListHomeFeed.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo != null))
            {
              localStoryNickNameView.setFormat(HardCodeUtil.a(2131704503));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.jdField_a_of_type_JavaLangString);
            }
            else
            {
              localStoryNickNameView.setUnionId(null);
            }
          }
          localTextView.setVisibility(0);
        }
      }
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      break;
    }
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
    int j;
    if (paramBoolean)
    {
      j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846893);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        localButton.setBackgroundResource(2130846893);
      }
      j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846892);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166498));
      localButton.setPadding(0, 0, 0, 0);
    }
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
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
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
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (((QQStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.QQSTORY_MANAGER)).a())
    {
    }
    do
    {
      do
      {
        return false;
        SLog.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo == null)) {
      return false;
    }
    return true;
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
      if (URLDrawable.getDrawable(paramString, localURLDrawableOptions).getStatus() == 1) {
        return true;
      }
    }
    catch (MalformedURLException paramString)
    {
      return false;
    }
    return false;
  }
  
  public static String[] a(ShareGroupFeedItem paramShareGroupFeedItem, List<StoryVideoItem> paramList)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramShareGroupFeedItem.des)) && (paramShareGroupFeedItem.mVideoPullType == 0))
    {
      localObject = paramShareGroupFeedItem.des;
      if (paramShareGroupFeedItem.todayJoinMemberCount > 1) {
        paramList = HardCodeUtil.a(2131704504);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = HardCodeUtil.a(2131704491);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + HardCodeUtil.a(2131704496);
        paramList = str1;
      }
    }
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
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561833, paramViewGroup, false));
    paramViewGroup.a(2131380454).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374981);
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
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561938, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374972);
    paramViewGroup.a(2131374973).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374971).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131375101).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131375096).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374981);
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
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long < 100L) && (this.jdField_f_of_type_Int != -1) && (this.jdField_f_of_type_Int != 0))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return this.jdField_f_of_type_Int;
    }
    int k = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      SLog.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
      if (m != this.jdField_d_of_type_Int) {
        break label230;
      }
      if ((j <= k) && (this.jdField_e_of_type_Int <= k)) {
        break;
      }
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 0;
    }
    if (j > this.jdField_e_of_type_Int)
    {
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 2;
    }
    if (j < this.jdField_e_of_type_Int)
    {
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 1;
      label230:
      if (m > this.jdField_d_of_type_Int)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 1;
      }
      if (m < this.jdField_d_of_type_Int)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 2;
      }
    }
    this.jdField_e_of_type_Int = j;
    this.jdField_d_of_type_Int = m;
    return 0;
  }
  
  private BaseViewHolder e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561764, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374972);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374935).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374943).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    paramViewGroup.a("type", "BannerView");
    return paramViewGroup;
  }
  
  private void e(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        b(e());
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b() != 1));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
  }
  
  private void f(int paramInt)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    localActionSheet.addButton(HardCodeUtil.a(2131704488), 5);
    localActionSheet.addCancelButton(2131690800);
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
      QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131704502), 0).a();
      return;
    }
    Object localObject = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().remove(paramInt);
    if (localObject == null)
    {
      AssertUtils.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((StoryHomeFeed)localObject, "hide_done");
    String str = ((StoryHomeFeed)localObject).a().getOwner().getUnionId();
    long l;
    switch (((StoryHomeFeed)localObject).a().type)
    {
    case 4: 
    default: 
      AssertUtils.a("feed not allow unLike operation type=" + ((StoryHomeFeed)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((StoryHomeFeed)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      FeedUtils.a(str, paramInt, l);
      localObject = ((StoryHomeFeed)localObject).a().feedId;
      Bosses.get().postJob(new FeedSegment.15(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((StoryHomeFeed)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((StoryHomeFeed)localObject).a()).recommendId;
      paramInt = 10;
    }
  }
  
  private void h(int paramInt)
  {
    if (this.g) {
      d(paramInt);
    }
    while (a(paramInt) != null) {
      return;
    }
    d(paramInt);
    this.g = true;
  }
  
  private void n()
  {
    if (StoryDepends.a()) {}
    do
    {
      return;
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704489), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704497), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704490), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (NewMyStorySegment)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((NewMyStorySegment)localObject).a(false);
      }
      a().setSelection(0);
      return;
      SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void R_()
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
  
  public void T_()
  {
    super.T_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
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
  
  public int a(int paramInt)
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
    while (paramView != null)
    {
      if (paramView.getScrollY() > 0) {
        return paramView.getScrollY();
      }
      try
      {
        paramView = (ViewGroup)paramView.getParent();
      }
      catch (Exception paramView)
      {
        return 0;
      }
    }
    return 0;
  }
  
  public View a()
  {
    int j = 0;
    while (j < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().size())
    {
      localObject1 = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(j);
      if ((((StoryHomeFeed)localObject1).a().type != 1) && (((StoryHomeFeed)localObject1).a().type != 2))
      {
        j += 1;
      }
      else
      {
        localObject1 = a(j);
        if (localObject1 != null) {
          break label76;
        }
      }
    }
    for (;;)
    {
      return null;
      label76:
      localObject2 = (VideoListLayout)((BaseViewHolder)localObject1).a(2131374991);
      if (localObject2 != null) {
        break;
      }
      SLog.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374989);
      InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131704476), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramBaseViewHolder.a("feed_id", localStoryHomeFeed.a().feedId);
    View localView = paramBaseViewHolder.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localStoryHomeFeed.jdField_b_of_type_Boolean = true;
      d(paramBaseViewHolder);
      paramBaseViewHolder = new ArrayList();
      paramBaseViewHolder.add(localStoryHomeFeed);
      b(paramBaseViewHolder, 0);
      StoryReportor.b("story_home_dev", "feed_exp", localStoryHomeFeed.a().type, localStoryHomeFeed.d().size(), new String[] { localStoryHomeFeed.a().feedId });
      return localView;
      if (localStoryHomeFeed.a().type == 1)
      {
        localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralHomeFeed)localStoryHomeFeed);
      }
      else if (localStoryHomeFeed.a().type == 2)
      {
        localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (ShareGroupHomeFeed)localStoryHomeFeed);
      }
      else if (localStoryHomeFeed.a().type == 3)
      {
        localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (GeneralRecommendHomeFeed)localStoryHomeFeed);
        continue;
        localView = a(paramInt, paramBaseViewHolder, (BannerHomeFeed)localStoryHomeFeed);
        continue;
        localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (TagHomeFeed)localStoryHomeFeed);
        continue;
        localView = a(paramInt, paramBaseViewHolder, paramViewGroup, (HotRecommendHomeFeed)localStoryHomeFeed);
      }
    }
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup, GeneralHomeFeed paramGeneralHomeFeed)
  {
    SLog.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374958);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374962);
    a(paramGeneralHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramGeneralHomeFeed, paramGeneralHomeFeed.a().getOwner());
    a(paramBaseViewHolder, paramGeneralHomeFeed, true);
    a(paramInt, paramBaseViewHolder);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167124);
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
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374958);
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131374962);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, this.jdField_d_of_type_Boolean);
    a(paramInt, paramBaseViewHolder, paramShareGroupHomeFeed, ((ShareGroupFeedItem)paramShareGroupHomeFeed.a()).getOwner());
    a(paramBaseViewHolder, paramShareGroupHomeFeed, true);
    a(paramShareGroupHomeFeed, paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167124);
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
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      TraceUtils.traceEnd();
      return paramViewGroup;
      paramViewGroup = b(paramInt, paramViewGroup);
      continue;
      paramViewGroup = e(paramInt, paramViewGroup);
      continue;
      paramViewGroup = d(paramInt, paramViewGroup);
      continue;
      paramViewGroup = c(paramInt, paramViewGroup);
    }
  }
  
  protected BaseViewHolder a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((StoryHomeFeed)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      BaseViewHolder localBaseViewHolder = a(j);
      if ((localBaseViewHolder != null) && (paramString.equals(localBaseViewHolder.a("feed_id")))) {
        return localBaseViewHolder;
      }
      if (localBaseViewHolder != null)
      {
        localObject = (StoryHomeFeed)((List)localObject).get(j);
        AssertUtils.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localBaseViewHolder.a("feed_id") + " feed info=" + localObject, new Object[0]);
      }
      return null;
      j = -1;
    }
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (BaseViewHolder)localIterator.next();
        if (localObject != null)
        {
          localObject = (FeedCommentLikeLego)((BaseViewHolder)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((FeedCommentLikeLego)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374986);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374987);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131374984);
    if (localRelativeLayout == null) {
      return;
    }
    if (StoryDepends.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    switch (((StoryHomeFeed)localObject).a().type)
    {
    case 4: 
    default: 
      return;
    case 1: 
    case 2: 
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    case 5: 
      localObject = (BannerFeedItem)((StoryHomeFeed)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        SLog.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = HardCodeUtil.a(2131704478);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramBaseViewHolder);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((StoryHomeFeed)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((StoryHomeFeed)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        SLog.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = HardCodeUtil.a(2131704484);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramBaseViewHolder);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((StoryHomeFeed)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      SLog.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = HardCodeUtil.a(2131704475);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramBaseViewHolder);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, QQUserUIItem paramQQUserUIItem)
  {
    TraceUtils.traceBegin("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramBaseViewHolder.a(2131374972);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(PlayModeUtils.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846789));
      TraceUtils.traceEnd();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, ImageUtil.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramBaseViewHolder = "";
      if (paramVideoListHomeFeed.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramBaseViewHolder);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramVideoListHomeFeed.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramBaseViewHolder = localQQStoryOwnerInfoView.a();
      paramBaseViewHolder.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramVideoListHomeFeed.jdField_b_of_type_Boolean) {
        paramBaseViewHolder.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      TraceUtils.traceEnd();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramVideoListHomeFeed.a().type == 3)
      {
        paramBaseViewHolder = (GeneralRecommendFeedItem)paramVideoListHomeFeed.a();
        if (!TextUtils.isEmpty(paramBaseViewHolder.blurb))
        {
          paramBaseViewHolder = paramBaseViewHolder.blurb;
          break label152;
        }
        paramBaseViewHolder = a(paramVideoListHomeFeed.a());
        break label152;
      }
      paramBaseViewHolder = a(paramVideoListHomeFeed.a());
      break label152;
      label296:
      if (paramVideoListHomeFeed.a().type == 3) {
        if (StoryProfileUtils.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, HardCodeUtil.a(2131704492), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374965);
    TraceUtils.traceBegin("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374964);
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131374966);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131374967);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      TraceUtils.traceEnd();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846867);
      paramBaseViewHolder.setImageResource(2130846869);
      if (paramInt != 0) {
        break label165;
      }
      paramBaseViewHolder = UIUtils.a(UIUtils.a(((StoryHomeFeed)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramBaseViewHolder);
    }
    for (;;)
    {
      TraceUtils.traceEnd();
      return;
      ((ImageView)localObject1).setImageResource(2130846866);
      paramBaseViewHolder.setImageResource(2130846868);
      break;
      label165:
      paramBaseViewHolder = (StoryHomeFeed)((List)localObject2).get(paramInt - 1);
      localObject2 = (StoryHomeFeed)((List)localObject2).get(paramInt);
      localObject1 = UIUtils.a(paramBaseViewHolder.a().date);
      localObject2 = UIUtils.a(((StoryHomeFeed)localObject2).a().date);
      if (((paramBaseViewHolder instanceof HotRecommendHomeFeed)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramBaseViewHolder = UIUtils.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramBaseViewHolder);
      }
      else
      {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void a(long paramLong, String paramString, CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    int j;
    if (this.jdField_a_of_type_Int == 10)
    {
      j = 74;
      if (paramCommentLikeFeedItem.getOwner().getRelationType() == 2) {}
      paramString = null;
      if (this.jdField_a_of_type_Int != 10) {
        break label95;
      }
      paramString = new HomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = new OpenPlayerBuilder(paramString, j);
        paramString.a(c());
        StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
      }
      return;
      j = 76;
      break;
      label95:
      if (this.jdField_a_of_type_Int == 11) {
        paramString = new TroopAssistantHomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
      } else if (this.jdField_a_of_type_Int == 12) {
        paramString = new ProfileFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, QQUserUIItem paramQQUserUIItem, int paramInt)
  {
    int j = 1;
    int k = paramQQUserUIItem.isSubscribe;
    if (paramQQUserUIItem.isSubscribe())
    {
      paramInt = 0;
      paramQQUserUIItem.isSubscribe = paramInt;
      d(paramVideoListFeedItem.feedId);
      paramView = (QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      if (!paramQQUserUIItem.isVip()) {
        break label96;
      }
    }
    label96:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      StoryReportor.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.b()) {
      return;
    }
    int j;
    if (this.jdField_a_of_type_Int == 10)
    {
      j = 74;
      if (!(paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
        break label177;
      }
      paramVideoListFeedItem = (HotRecommendFeedItem)paramVideoListFeedItem;
      paramVideoListFeedItem = new OpenPlayerBuilder(new HotRecommendFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mAttachedFeedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), j);
      paramVideoListFeedItem.a(false).b(true);
      paramVideoListFeedItem.a(c());
      if (!(paramView instanceof QQStoryAutoPlayView)) {
        break label159;
      }
      StoryPlayerLauncher.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      StoryReportor.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      StoryPlayerLauncher.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
    }
    label177:
    Object localObject = null;
    String str;
    if (this.jdField_a_of_type_Int == 10)
    {
      str = paramVideoListFeedItem.feedId;
      if (!(paramVideoListFeedItem instanceof TagFeedItem)) {
        break label461;
      }
    }
    label303:
    label454:
    label461:
    for (localObject = paramStoryVideoItem.mAttachedFeedId;; localObject = str)
    {
      localObject = new HomeFeedPlayInfo(str, (String)localObject, paramStoryVideoItem.mVid, false);
      if (localObject != null)
      {
        localObject = new OpenPlayerBuilder((Serializable)localObject, j);
        ((OpenPlayerBuilder)localObject).a(c());
        localObject = ((OpenPlayerBuilder)localObject).a();
        if (74 == j) {
          ((OpenPlayerBuilder.Data)localObject).mUIStyle.bottomWidgetShowFlag = 3;
        }
        if ((paramView instanceof QQStoryAutoPlayView)) {
          StoryPlayerLauncher.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = StoryReportor.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), FeedItemThumbAdapter.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Int == 11)
        {
          localObject = new TroopAssistantHomeFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
          break;
        }
        if (this.jdField_a_of_type_Int != 12) {
          break;
        }
        localObject = new ProfileFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
        break;
        StoryPlayerLauncher.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramFeedCommentLego.c != null) && (paramFeedCommentLego.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
      paramView.setFeedItemData(paramFeedCommentLego.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramFeedCommentLego, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramFeedCommentLego.c != null) && (paramFeedCommentLego.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
      paramViewGroup.setFeedItemData(paramFeedCommentLego.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramFeedCommentLego, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
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
    paramGeneralHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131374991);
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
    boolean bool1 = true;
    SLog.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramHomeFeedData == null) {
      c(false);
    }
    do
    {
      return;
      if (paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        AssertUtils.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramHomeFeedData, new Object[0]);
        c(false);
        return;
      }
      SLog.d("Q.qqstory.home:FeedSegment", paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
        break;
      }
      c(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString != null))
      {
        a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false);
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      a(paramHomeFeedData.jdField_b_of_type_JavaUtilList, 0);
    } while (paramHomeFeedData.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramHomeFeedData.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(ShareGroupHomeFeed paramShareGroupHomeFeed, BaseViewHolder paramBaseViewHolder)
  {
    paramShareGroupHomeFeed = (VideoListLayout)paramBaseViewHolder.a(2131374991);
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
    if ((paramVideoListHomeFeed == null) || (paramVideoListHomeFeed.a() == null) || (paramVideoListHomeFeed.a().feedId == null))
    {
      SLog.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramVideoListHomeFeed.a().feedId);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder)
  {
    Object localObject = (VideoListLayout)paramBaseViewHolder.a(2131374991);
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
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131375099);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131375098);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131375101);
    TagItem localTagItem = ((TagFeedItem)paramTagHomeFeed.a()).tagItem;
    paramBaseViewHolder = (TextView)paramBaseViewHolder.a(2131375096);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166516));
      paramBaseViewHolder.setBackgroundResource(2130846893);
    }
    if (localTagItem != null)
    {
      localTextView1.setText(localTagItem.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramTagHomeFeed.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramTagHomeFeed.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramTagHomeFeed.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(FeedSegment.StoryVideoDownloadedEvent paramStoryVideoDownloadedEvent)
  {
    b(0);
  }
  
  public void a(String paramString)
  {
    SLog.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      if (paramString1.equals(localStoryHomeFeed.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localStoryHomeFeed, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      StoryHomeFeed localStoryHomeFeed;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
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
    SLog.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  public boolean a_(boolean paramBoolean)
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
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561807, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374972);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    TraceUtils.traceBegin("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a()) || (this.jdField_a_of_type_Int != 10))
    {
      TraceUtils.traceEnd();
      SLog.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a());
      return;
    }
    SLog.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label536:
    label553:
    label557:
    for (;;)
    {
      Object localObject;
      QQStoryAutoPlayView localQQStoryAutoPlayView;
      if (localIterator.hasNext())
      {
        localObject = (VideoListLayout)((BaseViewHolder)localIterator.next()).a(2131374991);
        if (localObject == null) {
          continue;
        }
        localQQStoryAutoPlayView = ((VideoListLayout)localObject).a();
        localObject = ((VideoListLayout)localObject).a();
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.getVisibility() != 0)) {}
      }
      for (;;)
      {
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.a() == null)) {
          break label557;
        }
        SLog.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374989);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = StoryListUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = StoryListUtils.a(localQQStoryAutoPlayView);
          label326:
          if ((a(localQQStoryAutoPlayView)) && (k >= j)) {
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != localQQStoryAutoPlayView)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
            }
          }
          break;
        }
        for (;;)
        {
          SLog.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = StoryListUtils.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = StoryListUtils.c(localQQStoryAutoPlayView);
          break label326;
          k = StoryListUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = StoryListUtils.b(localQQStoryAutoPlayView);
          break label326;
          SLog.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          SLog.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
          if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() == 0))
          {
            if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a()) {
              break label536;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.c();
          }
        }
        for (;;)
        {
          TraceUtils.traceEnd();
          return;
          SLog.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a());
        }
        localQQStoryAutoPlayView = null;
      }
    }
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
    ((VideoListLayout)paramBaseViewHolder.a(2131374991)).a().setVisibility(8);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    SLog.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public int c()
  {
    int j = 20002;
    if (this.jdField_a_of_type_Int == 11) {
      j = 30000;
    }
    do
    {
      return j;
      if (this.jdField_a_of_type_Int == 12) {
        return 20004;
      }
    } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity));
    return 20002;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.b(paramInt);
  }
  
  public void c(BaseViewHolder paramBaseViewHolder)
  {
    TraceUtils.traceBegin("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramBaseViewHolder);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramBaseViewHolder.a(2131374991);
    if (localVideoListLayout == null)
    {
      TraceUtils.traceEnd();
      return;
    }
    paramBaseViewHolder = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramBaseViewHolder != null) && (paramBaseViewHolder.a() != null)) {
        SLog.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramBaseViewHolder.a().getThumbUrl());
      }
      if (paramBaseViewHolder != null) {
        paramBaseViewHolder.a();
      }
      TraceUtils.traceEnd();
      return;
      paramBaseViewHolder = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramBaseViewHolder = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramBaseViewHolder = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramBaseViewHolder = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131374989);
          }
        }
      }
    }
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
    }
    for (;;)
    {
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
      return;
      SLog.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void d()
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)((BaseViewHolder)localIterator.next()).a("commentLikeLego");
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
  
  public int d_()
  {
    return 4;
  }
  
  public void e()
  {
    super.e();
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    b(0);
    AbstractGifImage.resumeAll();
  }
  
  public void e_(boolean paramBoolean)
  {
    super.e_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      h();
    }
  }
  
  public void f()
  {
    SLog.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new FeedSegment.1(this));
    SegmentList localSegmentList = a();
    String str = a();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int[] arrayOfInt1;
    int j;
    Object localObject;
    String str;
    int[] arrayOfInt2;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      paramMessage = (HomeFeedData)paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        c(false);
        return true;
      }
      b(paramMessage);
      return true;
    case 2: 
      c(true);
      return true;
    case 11: 
      arrayOfInt1 = new int[2];
      j = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
      ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
      str = (String)paramMessage.obj;
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, str), 50L);
        return true;
      }
      arrayOfInt2 = new int[2];
      a().getLocationOnScreen(arrayOfInt2);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessage = (BaseViewHolder)localIterator.next();
      } while (!str.equals((String)paramMessage.a("feed_id")));
    }
    for (;;)
    {
      if (paramMessage != null)
      {
        j = paramMessage.jdField_c_of_type_Int;
        int k = paramMessage.a().getBottom();
        int m = paramMessage.a().getTop();
        int n = arrayOfInt2[1];
        ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
        a().setSelectionFromTop(j, arrayOfInt1[1] - (k - m + n));
        return true;
      }
      AssertUtils.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a().getLocationOnScreen(arrayOfInt1);
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramMessage), 50L);
        return true;
      }
      localObject = new int[2];
      paramMessage.getLocationOnScreen((int[])localObject);
      j = localObject[1];
      j = paramMessage.getBottom() - paramMessage.getTop() + j - arrayOfInt1[1];
      a().smoothScrollBy(j, j * 2 / 3);
      return true;
      if (QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_Boolean)
      {
        SLog.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
        paramMessage = (Rect)paramMessage.obj;
        ThreadManager.getSubThreadHandler().post(new FeedSegment.9(this, paramMessage));
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, paramMessage.obj), 50L);
      return true;
      paramMessage = null;
    }
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
  
  public void i_(int paramInt)
  {
    e(paramInt);
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
    String str1 = (String)((StoryConfigManager)SuperManager.a(10)).b("mainHallConfig", "");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    for (;;)
    {
      try
      {
        str1 = new JSONObject(str1).optString("url");
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        SLog.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        SLog.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment
 * JD-Core Version:    0.7.0.1
 */