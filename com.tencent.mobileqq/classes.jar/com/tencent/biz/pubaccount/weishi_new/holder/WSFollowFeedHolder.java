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
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.ToastUtil;
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
  private WSFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  private WSUserBusiness jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness;
  private WSFollowTabMuteGuideController jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController;
  private WSJoinGroupController jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupController;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private WSMarqueeDirector jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
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
    super(paramViewGroup, 2131560408);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = paramWSFollowAdapter;
    i();
    k();
  }
  
  private void A()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.jdField_a_of_type_UserGrowthStFeed;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((stFeed)localObject1).feed;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localObject2 = ((stSimpleMetaFeed)localObject1).poster;
    }
    if (WSFeedUtils.a((stSimpleMetaPerson)localObject2)) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    localHashMap.put("is_livenow", localObject2);
    WSFollowBeaconReport.a("profile", d(), WSReportEvent.ActionId.jdField_a_of_type_JavaLangString, localHashMap, (stSimpleMetaFeed)localObject1);
  }
  
  private int a()
  {
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.ding_count;
    }
    return 0;
  }
  
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.m);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private WSFollowFragment a()
  {
    WSFollowAdapter localWSFollowAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
    if (localWSFollowAdapter != null) {
      return localWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
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
    if (paramstSimpleComment.isDing == 1) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("点赞前 isDing：");
    localStringBuilder.append(bool);
    localStringBuilder.append(",mComment.isDing:");
    localStringBuilder.append(paramstSimpleComment.isDing);
    localStringBuilder.append(",mComment.dingNum:");
    localStringBuilder.append(paramstSimpleComment.dingNum);
    WSLog.c("comment", localStringBuilder.toString());
    a(bool, paramImageView);
    if (!bool)
    {
      WSLog.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    else if (paramstSimpleComment.dingNum > 1L)
    {
      WSLog.c("comment", "执行点赞-1 ...............");
      paramstSimpleComment.dingNum -= 1L;
    }
    else
    {
      paramstSimpleComment.dingNum -= 1L;
      WSLog.c("comment", "执行取消点赞 ...............");
    }
    paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
    paramImageView = new StringBuilder();
    paramImageView.append("点赞后 mComment.isDing：");
    paramImageView.append(paramstSimpleComment.isDing);
    paramImageView.append(",mComment.dingNum:");
    paramImageView.append(paramstSimpleComment.dingNum);
    WSLog.c("comment", paramImageView.toString());
    paramImageView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
    if (paramImageView == null) {
      return;
    }
    paramImageView.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, paramstSimpleComment);
    int i1 = 1000002;
    if (WeishiGuideUtils.a(getContext())) {
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
    int i1;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    if (WSFeedUtils.a(paramstSimpleMetaPerson))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    }
    else
    {
      a(paramstSimpleMetaPerson, bool);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    localTextView = this.f;
    if (WSFeedUtils.a(paramstSimpleMetaPerson.followStatus)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localTextView.setVisibility(i1);
    this.g.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(this.f.getVisibility());
    if (h())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    WSPicLoader.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    WSFeedUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject != null) {
        WSLikeAnimationManger.a().a((stSimpleMetaFeed)localObject, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
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
    boolean bool = WeishiGuideUtils.a(getContext());
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
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a(paramString1, i1, paramString2, (stSimpleMetaFeed)localObject);
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = d();
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a(paramString1, i1, paramString2, paramMap, (stSimpleMetaFeed)localObject);
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (b() == 0)
    {
      WSFeedUtils.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout, this.m });
      this.i.setText(2131720423);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.i, b(), "0");
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject1 = (stSimpleComment)paramArrayList.get(0);
      if (localObject1 != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(WSFeedUtils.a(((stSimpleComment)localObject1).poster.nick, ((stSimpleComment)localObject1).wording, ((stSimpleComment)localObject1).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject1).isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ImageView)localObject2).setSelected(bool);
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
        localObject1 = this.jdField_c_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ImageView)localObject1).setSelected(bool);
        WSFeedUtils.a(0, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
      }
    }
    else
    {
      WSFeedUtils.a(8, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
    }
    paramArrayList = getContext().getString(2131693491);
    Object localObject1 = getContext().getString(2131693492);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramArrayList);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    ((StringBuilder)localObject2).append((String)localObject1);
    paramArrayList = ((StringBuilder)localObject2).toString();
    this.m.setText(paramArrayList);
    this.m.setVisibility(0);
  }
  
  private int b()
  {
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder == this)
    {
      if (paramWSPlayerManager.c())
      {
        paramWSPlayerManager.b();
      }
      else
      {
        paramWSPlayerManager.c();
        s();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(this);
    }
    g(b());
  }
  
  private void b(String paramString)
  {
    a(paramString, WSReportEvent.ActionId.jdField_a_of_type_JavaLangString);
  }
  
  private int c()
  {
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
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
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
    if ((localObject1 != null) && (((WSFollowAdapter)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStFeed.feed;
      WsCommentPresenter localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localWsCommentPresenter == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("need create presenter , holder hashCode:");
        ((StringBuilder)localObject1).append(hashCode());
        WSLog.c("comment", ((StringBuilder)localObject1).toString());
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("复用 presenter 2222222222222222222222222222222222, holder hashCode:");
      ((StringBuilder)localObject2).append(hashCode());
      WSLog.c("comment", ((StringBuilder)localObject2).toString());
      if (paramBoolean)
      {
        localObject2 = localWsCommentPresenter.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(WSCommentBeaconReport.a(localWsCommentPresenter.a()));
        localStringBuilder.append(d());
        WSCommentBeaconReport.a((String)localObject2, localStringBuilder.toString(), 1000001, (stSimpleMetaFeed)localObject1);
      }
      else
      {
        WSCommentBeaconReport.b(localWsCommentPresenter.a(), d(), 1000001, (stSimpleMetaFeed)localObject1);
      }
      localWsCommentPresenter.a(getPosition());
      localWsCommentPresenter.a((stSimpleMetaFeed)localObject1);
      localWsCommentPresenter.a("focus", "");
      localWsCommentPresenter.b();
      WSSimpleEventBus.a().a(new WSCommentShowEvent(true));
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
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    return (localstFeed != null) && (localstFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  private void h(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1007008;
    } else {
      i1 = 1007009;
    }
    a("mutebutton", String.valueOf(i1));
  }
  
  private boolean h()
  {
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localstFeed != null) && (localstFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.poster != null)) {
      return WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)getView(2131369044));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)getView(2131369046));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getView(2131369059));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getView(2131369067));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)getView(2131369070));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)getView(2131369075));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)getView(2131369055));
    this.f = ((TextView)getView(2131369058));
    this.g = ((TextView)getView(2131369057));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)getView(2131369056));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getView(2131369076));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)getView(2131369054));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)getView(2131369072));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)getView(2131369069));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)getView(2131369088));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getView(2131369073));
    this.h = ((TextView)getView(2131369047));
    this.i = ((TextView)getView(2131369077));
    this.j = ((TextView)getView(2131369074));
    this.k = ((TextView)getView(2131369065));
    this.l = ((TextView)getView(2131369078));
    this.p = ((TextView)getView(2131369066));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getView(2131369042));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getView(2131369043));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)getView(2131369051));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)getView(2131369052));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getView(2131369049));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)getView(2131369050));
    this.m = ((TextView)getView(2131369053));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getView(2131369095));
    this.n = ((TextView)getView(2131369096));
    this.o = ((TextView)getView(2131369097));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector = new WSMarqueeDirector(getView(2131376774));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController = new WSFollowTabMuteGuideController(getContext(), this);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void k()
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new WSFollowFeedHolder.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnTouchListener(new WSFollowFeedHolder.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new WSFollowFeedHolder.3(this));
  }
  
  private void l()
  {
    WSFollowFragment.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("need create presenter ,holder hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      WSLog.c("comment", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("复用 presenter 33333333333333333, holder hashCode:");
    ((StringBuilder)localObject).append(hashCode());
    WSLog.c("comment", ((StringBuilder)localObject).toString());
    if ((!b()) && (!c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a().d();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a();
    if (localObject == null) {
      return;
    }
    WSVerticalPageFragment.b(new WSVerticalPageOpenParams((Context)localObject, "follow_tab", "focus").a(getLayoutPosition()).b(4097));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    b(false);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = WSFeedUtils.a(WeishiUIUtil.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, getContext().getResources().getDrawable(2131165740), "focus", false, d());
    n();
  }
  
  private void n()
  {
    boolean bool = f();
    GradientDrawable localGradientDrawable = null;
    if (bool)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838736);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()) && (d())) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_b_of_type_Boolean = bool;
      ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (!this.jdField_b_of_type_Boolean) {
        localGradientDrawable = a();
      }
      localImageView.setBackgroundDrawable(localGradientDrawable);
      if (this.jdField_b_of_type_Boolean)
      {
        j();
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838737);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void o()
  {
    q();
    e();
    w();
    p();
  }
  
  private void p()
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
      return;
    }
    ViewStub localViewStub = this.jdField_b_of_type_AndroidViewViewStub;
    if (localViewStub != null) {
      localViewStub.setVisibility(8);
    }
  }
  
  private void q()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null)
    {
      if (((stFeed)localObject).feed == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a(new WSFollowFeedHolder.5(this));
      localObject = this.jdField_a_of_type_UserGrowthStFeed.feed.magicBrand;
      ArrayList localArrayList = this.jdField_a_of_type_UserGrowthStFeed.feed.brands;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a(2130851268, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      }
      else
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.a();
      }
      if ((localObject != null) && (!TextUtils.isEmpty(((stMagicBrand)localObject).text)))
      {
        int i1;
        if (((stMagicBrand)localObject).type == 3)
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Boolean = false;
          i1 = 2130851262;
        }
        else
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = true;
          i1 = 2130851263;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.b(i1, ((stMagicBrand)localObject).text, ((stMagicBrand)localObject).schema);
        return;
      }
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.b();
    }
  }
  
  private void r()
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
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
    if (localObject != null)
    {
      localObject = ((WSFollowAdapter)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder;
      if (localObject != null)
      {
        localObject = ((WSPlayableHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
        if (localObject != null)
        {
          WSFollowFragment localWSFollowFragment = a();
          if (localWSFollowFragment == null) {
            return;
          }
          if (!localWSFollowFragment.e())
          {
            WSFollowBeaconReport.a((WSPlayerParam)localObject);
            localWSFollowFragment.d(true);
          }
        }
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      WSShareParam localWSShareParam = new WSShareParam();
      localWSShareParam.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localWSShareParam.jdField_a_of_type_Int = 20;
      localWSShareParam.b = d();
      localWSShareParam.jdField_a_of_type_JavaLangString = "focus";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dynamics_more_operations");
      localStringBuilder.append(d());
      localWSShareParam.c = localStringBuilder.toString();
      WeishiShareUtil.a(getContext(), localWSShareParam);
      b("more_operations");
    }
  }
  
  private void u()
  {
    if (!NetworkUtil.a(getContext()))
    {
      ToastUtil.a().a(2131720447);
      return;
    }
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if ((localObject != null) && (((stFeed)localObject).feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.poster != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
      }
      localObject = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
      if (WSFeedUtils.a(((stSimpleMetaPerson)localObject).followStatus))
      {
        a("follow", WSReportEvent.ActionId.r);
        WSFeedUtils.a(getContext(), new WSFollowFeedHolder.7(this, (stSimpleMetaPerson)localObject), null);
        return;
      }
      a("follow", WSReportEvent.ActionId.q);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness.a(((stSimpleMetaPerson)localObject).id, 1);
      ((stSimpleMetaPerson)localObject).followStatus = 1;
      this.f.setVisibility(8);
      this.g.setVisibility(0);
      return;
    }
    WSLog.b("WSFollowFeedHolder", "[showFollowAction] is null");
  }
  
  private void v()
  {
    if (WeishiUtils.c()) {
      return;
    }
    WSLikeAnimationManger.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    z();
  }
  
  private void w()
  {
    if (c() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.j, c(), "0");
      return;
    }
    this.j.setText(2131720450);
  }
  
  private void x()
  {
    WeishiShareUtil.a(this.jdField_a_of_type_UserGrowthStFeed.feed, 20, d());
    WSFeedDataManager.a().jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_UserGrowthStFeed.feed);
    WSFeedDataManager.a().b.remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.notifyItemRemoved(getAdapterPosition());
    ToastUtil.a().a(2131720424);
    y();
  }
  
  private void y()
  {
    WSPlayableHolder localWSPlayableHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(this, true, true);
    if ((localWSPlayableHolder != null) && (this == this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
      String str;
      if (localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {
        str = localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;
      } else {
        str = "videoInfo is null!";
      }
      localStringBuilder.append(str);
      WSLog.e("WSFollowFeedHolder", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(localWSPlayableHolder);
    }
  }
  
  private void z()
  {
    stFeed localstFeed = this.jdField_a_of_type_UserGrowthStFeed;
    if (localstFeed != null)
    {
      if (localstFeed.feed == null) {
        return;
      }
      int i2 = this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding;
      int i1 = 1;
      if (i2 != 1) {
        i1 = 0;
      }
      if (i1 != 0)
      {
        a("video", WSReportEvent.ActionId.g);
        return;
      }
      a("video", WSReportEvent.ActionId.h);
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
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a("qqgroup_float", i1, (stSimpleMetaFeed)localObject);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    WeishiUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(stFeed paramstFeed)
  {
    super.bindData(paramstFeed);
    if (paramstFeed != null)
    {
      if (paramstFeed.feed == null) {
        return;
      }
      this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
      a(paramstFeed.feed.poster);
      a(paramstFeed.feed.feed_desc);
      m();
      o();
      a(paramstFeed.feed.simpleComments);
      b(paramstFeed.feed);
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("添加评论后匹配正确, 添加前评论size:");
      ((StringBuilder)localObject).append(paramstSimpleMetaFeed.comments.size());
      WSLog.d("comment", ((StringBuilder)localObject).toString());
    }
    Object localObject = WSFeedUtils.a(2131693490, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCommentSize, comment size: ");
    localStringBuilder.append(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    WSLog.d("comment", localStringBuilder.toString());
    this.m.setText((CharSequence)localObject);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.i());
    boolean bool = paramWSPlayerManager.i() ^ true;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(bool);
    paramWSPlayerManager = new WSPlayerMuteEvent(bool);
    WSSimpleEventBus.a().a(paramWSPlayerManager);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      return;
    }
    localImageView.setSelected(paramBoolean);
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
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a("qqgroup", i1, str, null, (stSimpleMetaFeed)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      if (f()) {
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  public void c()
  {
    WSFollowTabMuteGuideController localWSFollowTabMuteGuideController = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowWSFollowTabMuteGuideController;
    if ((localWSFollowTabMuteGuideController != null) && (this.jdField_b_of_type_Boolean)) {
      localWSFollowTabMuteGuideController.f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    WSMarqueeDirector localWSMarqueeDirector = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector;
    if (localWSMarqueeDirector == null) {
      return;
    }
    if (paramBoolean)
    {
      q();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector.c();
      return;
    }
    localWSMarqueeDirector.f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.i();
  }
  
  public void d(boolean paramBoolean)
  {
    WSMarqueeDirector localWSMarqueeDirector = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector;
    if (localWSMarqueeDirector == null) {
      return;
    }
    if (paramBoolean)
    {
      localWSMarqueeDirector.d();
      return;
    }
    localWSMarqueeDirector.e();
  }
  
  public void e()
  {
    this.k.setVisibility(0);
    this.p.setVisibility(8);
    this.k.setSelected(g());
    if (a() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.l, a(), "0");
      return;
    }
    this.l.setText(2131720446);
  }
  
  public void f()
  {
    if (h())
    {
      this.f.setVisibility(8);
      this.g.setVisibility(0);
    }
    else
    {
      this.f.setVisibility(0);
      this.g.setVisibility(4);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
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
        if (localObject == null) {
          return;
        }
        if (WSFeedUtils.a((stSimpleMetaPerson)localObject)) {
          WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, ((stSimpleMetaPerson)localObject).avatar, new WSFollowFeedHolder.8(this, (stSimpleMetaPerson)localObject));
        }
      }
    }
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.9(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onClick] view: ");
    ((StringBuilder)localObject).append(paramView);
    WSLog.b("WSFollowFeedHolder", ((StringBuilder)localObject).toString());
    if ((a() != null) && (a().feed != null) && (a().feed.poster != null)) {
      localObject = a().feed.poster.id;
    } else {
      localObject = "";
    }
    switch (paramView.getId())
    {
    case 2131369045: 
    case 2131369048: 
    case 2131369054: 
    case 2131369056: 
    case 2131369060: 
    case 2131369061: 
    case 2131369062: 
    case 2131369063: 
    case 2131369064: 
    case 2131369068: 
    case 2131369069: 
    case 2131369071: 
    case 2131369075: 
    case 2131369076: 
    default: 
    case 2131369073: 
    case 2131369074: 
      t();
      return;
    case 2131369072: 
      r();
      return;
    case 2131369070: 
      paramView = (View)localObject;
      if (a() != null)
      {
        paramView = (View)localObject;
        if (a().feed != null)
        {
          paramView = (View)localObject;
          if (a().feed.poster != null) {
            paramView = a().feed.poster.id;
          }
        }
      }
      WSFeedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.getTag(), 700, paramView);
      b("nickname");
      return;
    case 2131369065: 
    case 2131369066: 
      v();
      return;
    case 2131369057: 
    case 2131369058: 
      u();
      return;
    case 2131369055: 
      x();
      b("close");
      return;
    case 2131369051: 
    case 2131369052: 
    case 2131369053: 
      e(false);
      return;
    case 2131369050: 
      paramView = this.jdField_a_of_type_JavaUtilArrayList;
      if ((paramView != null) && (paramView.size() > 1))
      {
        a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_c_of_type_AndroidWidgetImageView);
        return;
      }
      break;
    case 2131369049: 
      paramView = this.jdField_a_of_type_JavaUtilArrayList;
      if ((paramView != null) && (paramView.size() > 0))
      {
        a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_b_of_type_AndroidWidgetImageView);
        return;
      }
      break;
    case 2131369047: 
    case 2131369077: 
      e(true);
      return;
    case 2131369044: 
    case 2131369046: 
    case 2131369059: 
    case 2131369067: 
      WSFeedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.getTag(), 700, (String)localObject);
      A();
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject == null) {
        return;
      }
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
      WSLiveAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder
 * JD-Core Version:    0.7.0.1
 */