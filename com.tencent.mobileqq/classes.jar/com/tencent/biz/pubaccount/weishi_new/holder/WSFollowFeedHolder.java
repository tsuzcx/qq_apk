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
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSClickableSpanTouchListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
  private static final int d = WSFeedUtils.a(0.5F);
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private TextView D;
  private ViewStub E;
  private ViewStub F;
  private LinearLayout G;
  private TextView H;
  private TextView I;
  private stFeed J;
  private WSFollowAdapter K;
  private ArrayList<stSimpleComment> L;
  private TextView M;
  private GestureDetector N;
  private WSUserBusiness O;
  private WSFollowTabMuteGuideController P;
  private WSJoinGroupController Q;
  private WSMarqueeDirector R;
  private boolean S = false;
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private WSRoundedImageView e;
  private DiniFlyAnimationView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private FeedRichTextView n;
  private ViewGroup o;
  private KandianUrlImageView p;
  private ImageView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private FrameLayout w;
  private FrameLayout x;
  private FeedRichTextView y;
  private FeedRichTextView z;
  
  private WSFollowFeedHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131626453);
    this.K = paramWSFollowAdapter;
    o();
    q();
  }
  
  private boolean A()
  {
    stFeed localstFeed = i();
    return (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0);
  }
  
  private void B()
  {
    boolean bool = A();
    if ((this.Q == null) && (bool))
    {
      this.Q = new WSJoinGroupController(this.K.f(), this);
      this.Q.a(this.F);
    }
    if (bool)
    {
      this.Q.l();
      this.F.setVisibility(0);
      return;
    }
    ViewStub localViewStub = this.F;
    if (localViewStub != null) {
      localViewStub.setVisibility(8);
    }
  }
  
  private void C()
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      if (((stFeed)localObject).feed == null) {
        return;
      }
      this.R.a(new WSFollowFeedHolder.7(this));
      localObject = this.J.feed.magicBrand;
      ArrayList localArrayList = this.J.feed.brands;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.U = true;
        this.R.a(2130853530, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      }
      else
      {
        this.U = false;
        this.R.a();
      }
      if ((localObject != null) && (!TextUtils.isEmpty(((stMagicBrand)localObject).text)))
      {
        int i1;
        if (((stMagicBrand)localObject).type == 3)
        {
          this.W = true;
          this.V = false;
          i1 = 2130853524;
        }
        else
        {
          this.W = false;
          this.V = true;
          i1 = 2130853525;
        }
        this.R.b(i1, ((stMagicBrand)localObject).text, ((stMagicBrand)localObject).schema);
        return;
      }
      this.W = false;
      this.V = false;
      this.R.b();
    }
  }
  
  private void D()
  {
    WSPlayerManager localWSPlayerManager = d();
    if (localWSPlayerManager == null) {
      return;
    }
    if (G())
    {
      a(localWSPlayerManager);
      c();
      return;
    }
    b(localWSPlayerManager);
  }
  
  private void E()
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      localObject = ((WSFollowAdapter)localObject).b;
      if (localObject != null)
      {
        localObject = ((WSPlayableHolder)localObject).b;
        if (localObject != null)
        {
          WSFollowFragment localWSFollowFragment = F();
          if (localWSFollowFragment == null) {
            return;
          }
          if (!localWSFollowFragment.F())
          {
            WSFollowBeaconReport.a((WSPlayerParam)localObject);
            localWSFollowFragment.h(true);
          }
        }
      }
    }
  }
  
  private WSFollowFragment F()
  {
    WSFollowAdapter localWSFollowAdapter = this.K;
    if (localWSFollowAdapter != null) {
      return localWSFollowAdapter.a;
    }
    return null;
  }
  
  private boolean G()
  {
    return this.K.a.C();
  }
  
  private void H()
  {
    if (this.J != null)
    {
      WSShareParam localWSShareParam = new WSShareParam();
      localWSShareParam.a = this.J.feed;
      localWSShareParam.b = 20;
      localWSShareParam.c = O();
      localWSShareParam.d = "focus";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dynamics_more_operations");
      localStringBuilder.append(O());
      localWSShareParam.f = localStringBuilder.toString();
      WeishiShareUtil.a(getContext(), localWSShareParam);
      b("more_operations");
    }
  }
  
  private void I()
  {
    if (!NetworkUtil.a(getContext()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    Object localObject = this.J;
    if ((localObject != null) && (((stFeed)localObject).feed != null) && (this.J.feed.poster != null))
    {
      if (this.O == null) {
        this.O = WSUserBusiness.a();
      }
      localObject = this.J.feed.poster;
      if (WSFeedUtils.b(((stSimpleMetaPerson)localObject).followStatus))
      {
        a("follow", WSReportEvent.ActionId.r);
        WSFeedUtils.a(getContext(), new WSFollowFeedHolder.9(this, (stSimpleMetaPerson)localObject), null);
        return;
      }
      a("follow", WSReportEvent.ActionId.q);
      this.O.a(((stSimpleMetaPerson)localObject).id, 1);
      ((stSimpleMetaPerson)localObject).followStatus = 1;
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      return;
    }
    WSLog.b("WSFollowFeedHolder", "[showFollowAction] is null");
  }
  
  private void J()
  {
    if (WeishiUtils.o()) {
      return;
    }
    WSLikeAnimationManger.a().a(this.J.feed, -1, null, this.u, this.M, this.o);
    Q();
  }
  
  private void K()
  {
    if (z() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.t, z(), "0");
      return;
    }
    this.t.setText(2131918126);
  }
  
  private boolean L()
  {
    stFeed localstFeed = this.J;
    return (localstFeed != null) && (localstFeed.feed != null) && (this.J.feed.is_ding == 1);
  }
  
  private void M()
  {
    WeishiShareUtil.a(this.J.feed, 20, O());
    WSFeedDataManager.a().a.remove(this.J.feed);
    WSFeedDataManager.a().b.remove(this.J);
    this.K.getDataList().remove(this.J);
    this.K.notifyItemRemoved(getAdapterPosition());
    ToastUtil.a().a(2131918100);
    N();
  }
  
  private void N()
  {
    WSPlayableHolder localWSPlayableHolder = this.K.a.a(this, true, true);
    if ((localWSPlayableHolder != null) && (this == this.K.b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
      String str;
      if (localWSPlayableHolder.a != null) {
        str = localWSPlayableHolder.a.g;
      } else {
        str = "videoInfo is null!";
      }
      localStringBuilder.append(str);
      WSLog.e("WSFollowFeedHolder", localStringBuilder.toString());
      this.K.a(localWSPlayableHolder);
    }
  }
  
  private int O()
  {
    return WSFeedDataManager.a().f.get(getLayoutPosition()) + 1;
  }
  
  private boolean P()
  {
    stFeed localstFeed = this.J;
    if ((localstFeed != null) && (localstFeed.feed != null) && (this.J.feed.poster != null)) {
      return WSFeedUtils.b(this.J.feed.poster.followStatus);
    }
    return false;
  }
  
  private void Q()
  {
    stFeed localstFeed = this.J;
    if (localstFeed != null)
    {
      if (localstFeed.feed == null) {
        return;
      }
      int i2 = this.J.feed.is_ding;
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
  
  private void R()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.J;
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
    WSFollowBeaconReport.a("profile", O(), WSReportEvent.ActionId.a, localHashMap, (stSimpleMetaFeed)localObject1);
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
    paramImageView = this.K.a.k;
    if (paramImageView == null) {
      return;
    }
    paramImageView.h().a(this.J.feed, paramstSimpleComment);
    int i1 = 1000002;
    if (WeishiGuideUtils.a(getContext())) {
      i1 = 1000003;
    }
    paramImageView.a(true);
    WSLog.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
    paramstSimpleComment = this.J.feed;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_comment_like");
    localStringBuilder.append(O());
    WSCommentBeaconReport.a(localStringBuilder.toString(), paramImageView.a(), i1, paramstSimpleComment);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.e.setTag(paramstSimpleMetaPerson.avatarSchema);
    boolean bool = WSFeedUtils.c(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.g;
    int i1;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    if (WSFeedUtils.a(paramstSimpleMetaPerson))
    {
      this.h.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
    }
    else
    {
      a(paramstSimpleMetaPerson, bool);
    }
    this.i.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
    this.j.setText(WSFeedUtils.a(this.J.feed.createTime));
    localTextView = this.l;
    if (WSFeedUtils.b(paramstSimpleMetaPerson.followStatus)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localTextView.setVisibility(i1);
    this.m.setVisibility(4);
    this.k.setVisibility(this.l.getVisibility());
    if (P())
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    WSPicLoader.a().a(getContext(), this.e, paramstSimpleMetaPerson.avatar);
    this.h.setVisibility(8);
    WSFeedUtils.a(this.h, paramstSimpleMetaPerson.medal, paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject != null) {
        WSLikeAnimationManger.a().a((stSimpleMetaFeed)localObject, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.u, this.M, this.o);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      WSFeedUtils.a(8, new View[] { this.n });
      return;
    }
    WSFeedUtils.a(0, new View[] { this.n });
    this.n.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WSProfileFragment.a(getContext(), paramString, "at_nick");
    Object localObject = this.J;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSCommentBeaconReport.a("comment_at_out", "focus", "", paramString, paramInt, (stSimpleMetaFeed)localObject, null);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = O();
    Object localObject = this.J;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a(paramString1, i1, paramString2, (stSimpleMetaFeed)localObject);
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = O();
    Object localObject = this.J;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a(paramString1, i1, paramString2, paramMap, (stSimpleMetaFeed)localObject);
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (y() == 0)
    {
      WSFeedUtils.a(8, new View[] { this.w, this.x, this.D });
      this.s.setText(2131918099);
      return;
    }
    this.L = paramArrayList;
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.s, y(), "0");
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject1 = (stSimpleComment)paramArrayList.get(0);
      if (localObject1 != null)
      {
        this.y.setText(WSFeedUtils.a(((stSimpleComment)localObject1).poster.nick, ((stSimpleComment)localObject1).wording, ((stSimpleComment)localObject1).posterId));
        this.y.setOnTouchListener(new WSClickableSpanTouchListener());
        localObject2 = this.A;
        if (((stSimpleComment)localObject1).isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ImageView)localObject2).setSelected(bool);
        WSFeedUtils.a(0, new View[] { this.w });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.z.setText(WSFeedUtils.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.z.setOnTouchListener(new WSClickableSpanTouchListener());
        localObject1 = this.B;
        if (paramArrayList.isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ImageView)localObject1).setSelected(bool);
        WSFeedUtils.a(0, new View[] { this.x });
      }
    }
    else
    {
      WSFeedUtils.a(8, new View[] { this.x });
    }
    paramArrayList = getContext().getString(2131891044);
    Object localObject1 = getContext().getString(2131891045);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramArrayList);
    ((StringBuilder)localObject2).append(this.J.feed.total_comment_num);
    ((StringBuilder)localObject2).append((String)localObject1);
    paramArrayList = ((StringBuilder)localObject2).toString();
    this.D.setText(paramArrayList);
    this.D.setVisibility(0);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = WSFriendLikeParser.a(paramstSimpleMetaFeed, this.H.getPaint(), O());
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.c))
    {
      this.G.setVisibility(8);
      return;
    }
    this.G.setVisibility(0);
    this.H.setWidth(paramstSimpleMetaFeed.b);
    this.H.setText(paramstSimpleMetaFeed.a);
    this.H.setOnTouchListener(new EllipsizeOnTouchListener(paramstSimpleMetaFeed.a));
    this.I.setText(paramstSimpleMetaFeed.c);
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if (this.K.b == this)
    {
      if (paramWSPlayerManager.g())
      {
        paramWSPlayerManager.c();
      }
      else
      {
        paramWSPlayerManager.d();
        E();
      }
    }
    else {
      this.K.a(this);
    }
    g(m());
  }
  
  private void b(String paramString)
  {
    a(paramString, WSReportEvent.ActionId.a);
  }
  
  private void b(String paramString, int paramInt)
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
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = this.K;
    if ((localObject1 != null) && (((WSFollowAdapter)localObject1).a != null))
    {
      localObject1 = this.J.feed;
      WsCommentPresenter localWsCommentPresenter = this.K.a.k;
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
        localStringBuilder.append(O());
        WSCommentBeaconReport.b((String)localObject2, localStringBuilder.toString(), 1000001, (stSimpleMetaFeed)localObject1);
      }
      else
      {
        WSCommentBeaconReport.a(localWsCommentPresenter.a(), O(), 1000001, (stSimpleMetaFeed)localObject1);
      }
      localWsCommentPresenter.a(getPosition());
      localWsCommentPresenter.a((stSimpleMetaFeed)localObject1);
      localWsCommentPresenter.a("focus", "");
      localWsCommentPresenter.i();
      WSSimpleEventBus.a().a(new WSCommentShowEvent(true));
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("like", WSReportEvent.ActionId.i);
      return;
    }
    b("video");
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
  
  private void o()
  {
    this.e = ((WSRoundedImageView)getView(2131436007));
    this.f = ((DiniFlyAnimationView)getView(2131436009));
    this.e.setStrokeWidth(d);
    this.e.setStrokeColor(Color.parseColor("#D9D9D9"));
    this.g = ((TextView)getView(2131436022));
    this.h = ((TextView)getView(2131436030));
    this.i = ((TextView)getView(2131436033));
    this.j = ((TextView)getView(2131436038));
    this.k = ((TextView)getView(2131436018));
    this.l = ((TextView)getView(2131436021));
    this.m = ((TextView)getView(2131436020));
    this.n = ((FeedRichTextView)getView(2131436019));
    this.o = ((ViewGroup)getView(2131436039));
    this.p = ((KandianUrlImageView)getView(2131436017));
    this.C = ((ImageView)getView(2131436035));
    this.E = ((ViewStub)getView(2131436032));
    this.F = ((ViewStub)getView(2131436052));
    this.q = ((ImageView)getView(2131436036));
    this.r = ((TextView)getView(2131436010));
    this.s = ((TextView)getView(2131436040));
    this.t = ((TextView)getView(2131436037));
    this.u = ((TextView)getView(2131436028));
    this.v = ((TextView)getView(2131436041));
    this.M = ((TextView)getView(2131436029));
    this.w = ((FrameLayout)getView(2131436005));
    this.x = ((FrameLayout)getView(2131436006));
    this.y = ((FeedRichTextView)getView(2131436014));
    this.z = ((FeedRichTextView)getView(2131436015));
    this.A = ((ImageView)getView(2131436012));
    this.B = ((ImageView)getView(2131436013));
    this.D = ((TextView)getView(2131436016));
    this.G = ((LinearLayout)getView(2131436059));
    this.H = ((TextView)getView(2131436060));
    this.I = ((TextView)getView(2131436061));
    this.R = new WSMarqueeDirector(getView(2131445068));
    this.y.setRichTextDisplayType(1);
    this.z.setRichTextDisplayType(1);
  }
  
  private void p()
  {
    if ((this.P == null) && (this.K.a.D()))
    {
      this.P = new WSFollowTabMuteGuideController(getContext(), this);
      this.P.a(this.E);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void q()
  {
    WSFeedUtils.a(this, new View[] { this.e, this.i, this.g, this.h, this.f });
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.N = new GestureDetector(getContext(), new WSFollowFeedHolder.1(this));
    this.p.setOnTouchListener(new WSFollowFeedHolder.2(this));
    this.o.setOnTouchListener(new WSFollowFeedHolder.3(this));
    this.y.setOnElementClickListener(new WSFollowFeedHolder.4(this));
    this.z.setOnElementClickListener(new WSFollowFeedHolder.5(this));
  }
  
  private void r()
  {
    WSFollowFragment.j = true;
    if (this.K.a.k == null)
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
    if ((!m()) && (!n())) {
      this.K.e().n();
    }
    localObject = this.K.f();
    if (localObject == null) {
      return;
    }
    WSLauncher.VerticalPageLauncher.b(new WSVerticalPageOpenParams((Context)localObject, "follow_tab", "focus").a(getLayoutPosition()).b(4097));
    this.p.setVisibility(0);
    b(false);
  }
  
  private void s()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.height = WSFeedUtils.a(WeishiUIUtil.c(), this.J.feed.video);
    this.p.setLayoutParams(localLayoutParams);
    this.o.setLayoutParams(localLayoutParams);
    this.p.setVisibility(0);
    WSPicLoader.a().a(this.p, this.J.feed, getContext().getResources().getDrawable(2131166336), "focus", false, O());
    t();
  }
  
  private void t()
  {
    boolean bool = G();
    GradientDrawable localGradientDrawable = null;
    if (bool)
    {
      this.C.setImageResource(2130838955);
      this.C.setSelected(this.K.b());
      if ((this.K.a.D()) && (v())) {
        bool = true;
      } else {
        bool = false;
      }
      this.T = bool;
      ImageView localImageView = this.C;
      if (!this.T) {
        localGradientDrawable = u();
      }
      localImageView.setBackgroundDrawable(localGradientDrawable);
      if (this.T)
      {
        p();
        this.E.setVisibility(0);
        return;
      }
      this.E.setVisibility(8);
      return;
    }
    this.T = false;
    this.C.setImageResource(2130838956);
    this.C.setBackgroundDrawable(null);
    this.E.setVisibility(8);
  }
  
  private GradientDrawable u()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.o);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private boolean v()
  {
    return this.K.d() == this.J.feed;
  }
  
  private void w()
  {
    C();
    g();
    K();
    B();
  }
  
  private int x()
  {
    stFeed localstFeed = this.J;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
      return this.J.feed.ding_count;
    }
    return 0;
  }
  
  private int y()
  {
    stFeed localstFeed = this.J;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
      return this.J.feed.total_comment_num;
    }
    return 0;
  }
  
  private int z()
  {
    stFeed localstFeed = this.J;
    if ((localstFeed != null) && (localstFeed.feed != null)) {
      return this.J.feed.share_info.share_num;
    }
    return 0;
  }
  
  public void a()
  {
    int i1 = O();
    Object localObject = this.J;
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
    WeishiUtils.a(this.p, paramInt1, paramInt2);
  }
  
  public void a(stFeed paramstFeed)
  {
    super.bindData(paramstFeed);
    if (paramstFeed != null)
    {
      if (paramstFeed.feed == null) {
        return;
      }
      this.J = paramstFeed;
      a(paramstFeed.feed.poster);
      a(paramstFeed.feed.feed_desc);
      s();
      w();
      a(paramstFeed.feed.simpleComments);
      b(paramstFeed.feed);
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.J.feed.id.equals(paramstSimpleMetaFeed.id))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("添加评论后匹配正确, 添加前评论size:");
      ((StringBuilder)localObject).append(paramstSimpleMetaFeed.comments.size());
      WSLog.d("comment", ((StringBuilder)localObject).toString());
    }
    Object localObject = WSFeedUtils.a(2131891043, new Object[] { Integer.valueOf(this.J.feed.total_comment_num) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCommentSize, comment size: ");
    localStringBuilder.append(this.J.feed.total_comment_num);
    WSLog.d("comment", localStringBuilder.toString());
    this.D.setText((CharSequence)localObject);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.o());
    boolean bool = paramWSPlayerManager.o() ^ true;
    this.K.a(bool);
    paramWSPlayerManager = new WSPlayerMuteEvent(bool);
    WSSimpleEventBus.a().a(paramWSPlayerManager);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.C;
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
  
  public void b()
  {
    int i1 = O();
    String str = WSReportEvent.ActionId.a;
    Object localObject = this.J;
    if (localObject != null) {
      localObject = ((stFeed)localObject).feed;
    } else {
      localObject = null;
    }
    WSFollowBeaconReport.a("qqgroup", i1, str, null, (stSimpleMetaFeed)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.C != null)
    {
      if (G()) {
        return;
      }
      this.C.setSelected(paramBoolean);
    }
  }
  
  public void c()
  {
    WSFollowTabMuteGuideController localWSFollowTabMuteGuideController = this.P;
    if ((localWSFollowTabMuteGuideController != null) && (this.T)) {
      localWSFollowTabMuteGuideController.l();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    WSMarqueeDirector localWSMarqueeDirector = this.R;
    if (localWSMarqueeDirector == null) {
      return;
    }
    if (paramBoolean)
    {
      C();
      this.R.c();
      return;
    }
    localWSMarqueeDirector.f();
  }
  
  public WSPlayerManager d()
  {
    return this.K.e();
  }
  
  public void d(boolean paramBoolean)
  {
    WSMarqueeDirector localWSMarqueeDirector = this.R;
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
    this.K.a.E();
  }
  
  public boolean f()
  {
    return this.K.a.D();
  }
  
  public void g()
  {
    this.u.setVisibility(0);
    this.M.setVisibility(8);
    this.u.setSelected(L());
    if (x() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.v, x(), "0");
      return;
    }
    this.v.setText(2131918122);
  }
  
  public void h()
  {
    if (P())
    {
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      this.j.setVisibility(0);
      this.k.setVisibility(4);
      return;
    }
    this.l.setVisibility(0);
    this.m.setVisibility(4);
    this.j.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  public stFeed i()
  {
    return this.J;
  }
  
  public void j()
  {
    Object localObject = this.J;
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
          WSLiveAnimationManager.a().a(this.f, ((stSimpleMetaPerson)localObject).avatar, new WSFollowFeedHolder.10(this, (stSimpleMetaPerson)localObject));
        }
      }
    }
  }
  
  public ViewGroup k()
  {
    return this.o;
  }
  
  public void l()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.11(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onClick] view: ");
    ((StringBuilder)localObject).append(paramView);
    WSLog.b("WSFollowFeedHolder", ((StringBuilder)localObject).toString());
    if ((i() != null) && (i().feed != null)) {
      localObject = i().feed.poster;
    } else {
      localObject = null;
    }
    switch (paramView.getId())
    {
    case 2131436008: 
    case 2131436011: 
    case 2131436017: 
    case 2131436019: 
    case 2131436023: 
    case 2131436024: 
    case 2131436025: 
    case 2131436026: 
    case 2131436027: 
    case 2131436031: 
    case 2131436032: 
    case 2131436034: 
    case 2131436038: 
    case 2131436039: 
    default: 
    case 2131436036: 
    case 2131436037: 
      H();
      return;
    case 2131436035: 
      D();
      return;
    case 2131436033: 
      WSFeedUtils.a(this.K.f(), (stSchema)this.e.getTag(), 700, (stSimpleMetaPerson)localObject);
      b("nickname");
      return;
    case 2131436028: 
    case 2131436029: 
      J();
      return;
    case 2131436020: 
    case 2131436021: 
      I();
      return;
    case 2131436018: 
      M();
      b("close");
      return;
    case 2131436014: 
    case 2131436015: 
    case 2131436016: 
      e(false);
      return;
    case 2131436013: 
      paramView = this.L;
      if ((paramView != null) && (paramView.size() > 1))
      {
        a((stSimpleComment)this.L.get(1), this.B);
        return;
      }
      break;
    case 2131436012: 
      paramView = this.L;
      if ((paramView != null) && (paramView.size() > 0))
      {
        a((stSimpleComment)this.L.get(0), this.A);
        return;
      }
      break;
    case 2131436010: 
    case 2131436040: 
      e(true);
      return;
    case 2131436007: 
    case 2131436009: 
    case 2131436022: 
    case 2131436030: 
      WSFeedUtils.a(this.K.f(), (stSchema)this.e.getTag(), 700, (stSimpleMetaPerson)localObject);
      R();
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    Object localObject = this.J;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject == null) {
        return;
      }
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
      WSLiveAnimationManager.a().a(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder
 * JD-Core Version:    0.7.0.1
 */