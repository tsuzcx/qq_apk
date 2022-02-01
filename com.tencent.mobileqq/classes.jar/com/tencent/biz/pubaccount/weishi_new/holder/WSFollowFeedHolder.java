package com.tencent.biz.pubaccount.weishi_new.holder;

import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.follow.WSFollowTabMuteGuideController;
import com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupController;
import com.tencent.biz.pubaccount.weishi_new.like.EllipsizeOnTouchListener;
import com.tencent.biz.pubaccount.weishi_new.like.WSFriendLikeParser;
import com.tencent.biz.pubaccount.weishi_new.like.WSFriendLikeParserEntity;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class WSFollowFeedHolder
  extends WSPlayableHolder<stFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(0.5F);
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  private WSUserBusiness jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness;
  private WSFollowTabMuteGuideController jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController;
  private WSJoinGroupController jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private WSMarqueeDirector jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ArrayList<stSimpleComment> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  
  private WSFollowFeedHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131560521);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = paramWSFollowAdapter;
    j();
    l();
  }
  
  private void A()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", WSReportEvent.ActionId.g);
      return;
      i1 = 0;
    }
    a("video", WSReportEvent.ActionId.h);
  }
  
  private void B()
  {
    Object localObject = null;
    HashMap localHashMap = new HashMap();
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        localObject = localstSimpleMetaFeed.poster;
      }
      if (!WSFeedUtils.a((stSimpleMetaPerson)localObject)) {
        break label72;
      }
    }
    label72:
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("is_livenow", localObject);
      WSFollowBeaconReport.a("profile", d(), WSReportEvent.ActionId.jdField_a_of_type_JavaLangString, localHashMap, localstSimpleMetaFeed);
      return;
      localstSimpleMetaFeed = null;
      break;
    }
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.ding_count;
    }
    return 0;
  }
  
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.k);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private WSFollowFragment a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
    }
    return null;
  }
  
  public static WSFollowFeedHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowFeedHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void a(stSimpleComment paramstSimpleComment, ImageView paramImageView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      WSLog.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramImageView);
      if (bool) {
        break label162;
      }
      WSLog.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      WSLog.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramImageView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (paramImageView != null) {
        break label211;
      }
      return;
      bool = false;
      break;
      label162:
      if (paramstSimpleComment.dingNum > 1L)
      {
        WSLog.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        WSLog.c("comment", "执行取消点赞 ...............");
      }
    }
    label211:
    paramImageView.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, paramstSimpleComment);
    int i1 = 1000002;
    if (WeishiGuideUtils.a(a())) {
      i1 = 1000003;
    }
    paramImageView.jdField_a_of_type_Boolean = true;
    WSLog.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
    paramstSimpleComment = this.jdField_a_of_type_UserGrowthStFeed.feed;
    WSCommentBeaconReport.a(paramImageView.a(), d(), i1, paramstSimpleComment);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    boolean bool = WSFeedUtils.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      if (!WSFeedUtils.a(paramstSimpleMetaPerson)) {
        break label178;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      label75:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
      localTextView = this.f;
      if (!WSFeedUtils.a(paramstSimpleMetaPerson.followStatus)) {
        break label187;
      }
    }
    label178:
    label187:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.g.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(this.f.getVisibility());
      if (!h()) {
        break label192;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      i1 = 8;
      break;
      a(paramstSimpleMetaPerson, bool);
      break label75;
    }
    label192:
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    WeishiUtils.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    WSFeedUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        WSLikeAnimationManger.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      WSFeedUtils.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    WSFeedUtils.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    boolean bool = WeishiGuideUtils.a(a());
    HashMap localHashMap = new HashMap();
    localHashMap.put("label_type", String.valueOf(paramInt));
    if (bool)
    {
      a(paramString, WSReportEvent.ActionId.c, localHashMap);
      return;
    }
    a(paramString, WSReportEvent.ActionId.b, localHashMap);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      WSFollowBeaconReport.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      WSFollowBeaconReport.a(paramString1, i1, paramString2, paramMap, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (b() == 0)
    {
      WSFeedUtils.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout, this.m });
      this.i.setText(2131720704);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    VideoFeedsHelper.a(this.i, b(), "0");
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(WSFeedUtils.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label320;
        }
        bool = true;
        localImageView.setSelected(bool);
        WSFeedUtils.a(0, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(WSFeedUtils.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing != 1) {
          break label325;
        }
        bool = true;
        label229:
        ((ImageView)localObject).setSelected(bool);
        WSFeedUtils.a(0, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
      }
    }
    for (;;)
    {
      paramArrayList = a().getString(2131693536);
      localObject = a().getString(2131693537);
      paramArrayList = paramArrayList + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num + (String)localObject;
      this.m.setText(paramArrayList);
      this.m.setVisibility(0);
      return;
      label320:
      bool = false;
      break;
      label325:
      bool = false;
      break label229;
      WSFeedUtils.a(8, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
    }
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num;
    }
    return 0;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = WSFriendLikeParser.a(paramstSimpleMetaFeed, this.n.getPaint(), d());
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n.setWidth(paramstSimpleMetaFeed.jdField_a_of_type_Int);
    this.n.setText(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.n.setOnTouchListener(new EllipsizeOnTouchListener(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder));
    this.o.setText(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder == this) {
      if (paramWSPlayerManager.c()) {
        paramWSPlayerManager.b();
      }
    }
    for (;;)
    {
      g(b());
      return;
      paramWSPlayerManager.c();
      t();
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(this);
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, WSReportEvent.ActionId.jdField_a_of_type_JavaLangString);
  }
  
  private int c()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.share_info.share_num;
    }
    return 0;
  }
  
  private int d()
  {
    return WSFeedDataManager.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(getLayoutPosition()) + 1;
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a() == this.jdField_a_of_type_UserGrowthStFeed.feed;
  }
  
  private void e(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    WsCommentPresenter localWsCommentPresenter;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localWsCommentPresenter == null) {
        WSLog.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    WSLog.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      WSCommentBeaconReport.a(localWsCommentPresenter.a(), WSCommentBeaconReport.a(localWsCommentPresenter.a()) + d(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localWsCommentPresenter.a(getPosition());
      localWsCommentPresenter.a(localstSimpleMetaFeed);
      localWsCommentPresenter.a("focus", "");
      localWsCommentPresenter.b();
      WSSimpleEventBus.a().a(new WSCommentShowEvent(true));
      return;
      WSCommentBeaconReport.b(localWsCommentPresenter.a(), d(), 1000001, localstSimpleMetaFeed);
    }
  }
  
  private boolean e()
  {
    stFeed localstFeed = a();
    return (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0);
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("video", WSReportEvent.ActionId.i);
      return;
    }
    b("video");
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.c();
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", WSReportEvent.ActionId.t);
      return;
    }
    a("pausebutton", WSReportEvent.ActionId.s);
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1007008;; i1 = 1007009)
    {
      a("mutebutton", String.valueOf(i1));
      return;
    }
  }
  
  private boolean h()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null)) {
      return false;
    }
    return WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131369312));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131369314));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369327));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131369335));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131369338));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131369343));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131369323));
    this.f = ((TextView)a(2131369326));
    this.g = ((TextView)a(2131369325));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369324));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131369344));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131369322));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131369340));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131369337));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131369359));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369341));
    this.h = ((TextView)a(2131369315));
    this.i = ((TextView)a(2131369345));
    this.j = ((TextView)a(2131369342));
    this.k = ((TextView)a(2131369333));
    this.l = ((TextView)a(2131369346));
    this.p = ((TextView)a(2131369334));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131369310));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131369311));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369319));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369320));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369317));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131369318));
    this.m = ((TextView)a(2131369321));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131369366));
    this.n = ((TextView)a(2131369367));
    this.o = ((TextView)a(2131369368));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector = new WSMarqueeDirector(a(2131377320));
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController = new WSFollowTabMuteGuideController(a(), this);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void l()
  {
    WSFeedUtils.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new WSFollowFeedHolder.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new WSFollowFeedHolder.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new WSFollowFeedHolder.3(this));
  }
  
  private void m()
  {
    WSFollowFragment.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null) {
      WSLog.c("comment", "need create presenter ,holder hashCode:" + hashCode());
    }
    Activity localActivity;
    do
    {
      return;
      WSLog.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
      if ((!b()) && (!c())) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a().d();
      }
      localActivity = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a();
    } while (localActivity == null);
    WSVerticalPageFragment.a(localActivity, "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    b(false);
  }
  
  private void n()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = WSFeedUtils.a(WeishiUIUtil.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165749), "focus", false, d());
    o();
  }
  
  private void o()
  {
    if (f())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838976);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
      boolean bool;
      ImageView localImageView;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()) && (d()))
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!this.jdField_b_of_type_Boolean) {
          break label102;
        }
      }
      label102:
      for (Object localObject = null;; localObject = a())
      {
        localImageView.setBackgroundDrawable((Drawable)localObject);
        if (!this.jdField_b_of_type_Boolean) {
          break label110;
        }
        k();
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
        return;
        bool = false;
        break;
      }
      label110:
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838977);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void p()
  {
    r();
    e();
    x();
    q();
  }
  
  private void q()
  {
    boolean bool = e();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController == null) && (bool))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController = new WSJoinGroupController(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(), this);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController.a(this.jdField_b_of_type_AndroidViewViewStub);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController.f();
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
    }
    while (this.jdField_b_of_type_AndroidViewViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a(new WSFollowFeedHolder.5(this));
    stMagicBrand localstMagicBrand = this.jdField_a_of_type_UserGrowthStFeed.feed.magicBrand;
    ArrayList localArrayList = this.jdField_a_of_type_UserGrowthStFeed.feed.brands;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a(2130851352, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      if ((localstMagicBrand == null) || (TextUtils.isEmpty(localstMagicBrand.text))) {
        break label194;
      }
      if (localstMagicBrand.type != 3) {
        break label177;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
    }
    for (int i1 = 2130851346;; i1 = 2130851347)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.b(i1, localstMagicBrand.text, localstMagicBrand.schema);
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a();
      break;
      label177:
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
    }
    label194:
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.b();
  }
  
  private void s()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager == null) {
      return;
    }
    if (f())
    {
      a(localWSPlayerManager);
      c();
      return;
    }
    b(localWSPlayerManager);
  }
  
  private void t()
  {
    Object localObject;
    WSFollowFragment localWSFollowFragment;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder;
      if (localObject != null)
      {
        localObject = ((WSPlayableHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
        if (localObject != null)
        {
          localWSFollowFragment = a();
          if (localWSFollowFragment != null) {
            break label38;
          }
        }
      }
    }
    label38:
    while (localWSFollowFragment.e()) {
      return;
    }
    WSFollowBeaconReport.a((WSPlayerParam)localObject);
    localWSFollowFragment.d(true);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      WSShareParam localWSShareParam = new WSShareParam();
      localWSShareParam.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localWSShareParam.jdField_a_of_type_Int = 20;
      localWSShareParam.b = d();
      localWSShareParam.jdField_a_of_type_JavaLangString = "focus";
      localWSShareParam.c = ("dynamics_more_operations" + d());
      WeishiShareUtil.a(a(), localWSShareParam);
      b("more_operations");
    }
  }
  
  private void v()
  {
    if (!NetworkUtil.a(a()))
    {
      ToastUtil.a().a(2131720723);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      WSLog.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (WSFeedUtils.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", WSReportEvent.ActionId.r);
      WSFeedUtils.a(a(), new WSFollowFeedHolder.7(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", WSReportEvent.ActionId.q);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness.a(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void w()
  {
    if (WeishiUtils.c()) {
      return;
    }
    WSLikeAnimationManger.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    A();
  }
  
  private void x()
  {
    if (c() > 0)
    {
      VideoFeedsHelper.a(this.j, c(), "0");
      return;
    }
    this.j.setText(2131720725);
  }
  
  private void y()
  {
    WeishiShareUtil.a(this.jdField_a_of_type_UserGrowthStFeed.feed, 20, d());
    WSFeedDataManager.a().jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_UserGrowthStFeed.feed);
    WSFeedDataManager.a().b.remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.notifyItemRemoved(getAdapterPosition());
    ToastUtil.a().a(2131720705);
    z();
  }
  
  private void z()
  {
    WSPlayableHolder localWSPlayableHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(this, true, true);
    StringBuilder localStringBuilder;
    if ((localWSPlayableHolder != null) && (this == this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder))
    {
      localStringBuilder = new StringBuilder().append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
      if (localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
        break label81;
      }
    }
    label81:
    for (String str = localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; str = "videoInfo is null!")
    {
      WSLog.e("WSFollowFeedHolder", str);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(localWSPlayableHolder);
      return;
    }
  }
  
  public stFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStFeed;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a();
  }
  
  public void a()
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      WSFollowBeaconReport.a("qqgroup_float", i1, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(stFeed paramstFeed)
  {
    super.a(paramstFeed);
    if ((paramstFeed == null) || (paramstFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
    a(paramstFeed.feed.poster);
    a(paramstFeed.feed.feed_desc);
    n();
    p();
    a(paramstFeed.feed.simpleComments);
    b(paramstFeed.feed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      WSLog.d("comment", "添加评论后匹配正确, 添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = WSFeedUtils.a(2131693535, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    WSLog.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.m.setText(str);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.i());
    if (!paramWSPlayerManager.i()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(bool);
      paramWSPlayerManager = new WSPlayerMuteEvent(bool);
      WSSimpleEventBus.a().a(paramWSPlayerManager);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ImageView paramImageView)
  {
    if (!paramBoolean)
    {
      paramImageView.setSelected(true);
      return;
    }
    paramImageView.setSelected(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d();
  }
  
  public void b()
  {
    int i1 = d();
    String str = WSReportEvent.ActionId.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      WSFollowBeaconReport.a("qqgroup", i1, str, null, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView == null) || (f())) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController.f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector == null) {
      return;
    }
    if (paramBoolean)
    {
      r();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.g();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.d();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.e();
  }
  
  public void e()
  {
    this.k.setVisibility(0);
    this.p.setVisibility(8);
    this.k.setSelected(g());
    if (a() > 0)
    {
      VideoFeedsHelper.a(this.l, a(), "0");
      return;
    }
    this.l.setText(2131720722);
  }
  
  public void f()
  {
    if (h())
    {
      this.f.setVisibility(8);
      this.g.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      this.f.setVisibility(0);
      this.g.setVisibility(4);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject != null)
      {
        localObject = ((stSimpleMetaFeed)localObject).poster;
        if (localObject != null) {
          break label28;
        }
      }
    }
    label28:
    while (!WSFeedUtils.a((stSimpleMetaPerson)localObject)) {
      return;
    }
    WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, ((stSimpleMetaPerson)localObject).avatar, new WSFollowFeedHolder.8(this, (stSimpleMetaPerson)localObject));
  }
  
  public void h()
  {
    super.h();
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {}
    }
    else
    {
      return;
    }
    WSLikeAnimationManger.a().a(localstSimpleMetaFeed.id);
    WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void i()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.9(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    WSLog.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
    if ((a() != null) && (a().feed != null) && (a().feed.poster != null)) {}
    for (String str1 = a().feed.poster.id;; str1 = "")
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        WSFeedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.getTag(), 700, str1);
        B();
        continue;
        String str2 = str1;
        if (a() != null)
        {
          str2 = str1;
          if (a().feed != null)
          {
            str2 = str1;
            if (a().feed.poster != null) {
              str2 = a().feed.poster.id;
            }
          }
        }
        WSFeedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.getTag(), 700, str2);
        b("nickname");
        continue;
        v();
        continue;
        y();
        b("close");
        continue;
        s();
        continue;
        u();
        continue;
        e(true);
        continue;
        w();
        continue;
        e(false);
        continue;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_b_of_type_AndroidWidgetImageView);
          continue;
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
            a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_c_of_type_AndroidWidgetImageView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder
 * JD-Core Version:    0.7.0.1
 */