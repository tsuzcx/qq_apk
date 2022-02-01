package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stCallWeishiButton;
import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalForDramaPresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

public class WSVerticalItemBottomOperationController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  protected WSVerticalPageFragment g;
  protected TextView h;
  protected ViewGroup i;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  private ImageView m;
  private ImageView n;
  private TextView o;
  private ViewGroup p;
  private ViewStub q;
  private WSVerticalItemBottomWidgetViewController r;
  private WSVerticalVideoHolder s;
  
  public WSVerticalItemBottomOperationController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.s = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null)
    {
      this.g = paramWSVerticalVideoHolder.d;
      this.p = ((ViewGroup)paramWSVerticalVideoHolder.itemView);
    }
    WSLog.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed A()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data hashCode:");
      localStringBuilder.append(localWSVerticalItemData.hashCode());
      WSLog.c("comment", localStringBuilder.toString());
      return localWSVerticalItemData.b();
    }
    WSLog.c("comment", "data is null");
    return null;
  }
  
  private void B()
  {
    WSVerticalJumpUtils.c(this.g, A());
  }
  
  private void C()
  {
    Object localObject = A();
    WSVerticalBeaconReport.b(this.g.k(), this.g.l(), 1000001, (stSimpleMetaFeed)localObject, ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
    WSReportDC898Vertical.c();
    localObject = new WSShareParam();
    ((WSShareParam)localObject).a = A();
    ((WSShareParam)localObject).b = 3;
    ((WSShareParam)localObject).c = h();
    ((WSShareParam)localObject).d = WSVerticalBeaconReport.c(this.g.k());
    ((WSShareParam)localObject).e = this.g.l();
    ((WSShareParam)localObject).f = "forward";
    ((WSShareParam)localObject).a(this.g);
    WeishiShareUtil.a(this.a, (WSShareParam)localObject);
  }
  
  private void D()
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    WSVerticalBeaconReport.f(((WSVerticalPageFragment)localObject).k(), this.g.l(), A(), ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
    localObject = this.g.f;
    if (localObject == null)
    {
      WSLog.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    WSLog.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    ((WsCommentPresenter)localObject).a(h());
    ((WsCommentPresenter)localObject).a(WSVerticalBeaconReport.c(this.g.k()), this.g.l());
    ((WsCommentPresenter)localObject).a(A());
    ((WsCommentPresenter)localObject).i();
  }
  
  private void E()
  {
    if (WeishiUtils.o()) {
      return;
    }
    Object localObject = (WSVerticalItemData)c();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).g();
      if (localObject == null) {
        return;
      }
      boolean bool = ((WSDramaEpisodeInfo)localObject).d().dramaInfo.isFollowed;
      int i1;
      int i2;
      if (bool)
      {
        i1 = 2;
        i2 = 1003038;
      }
      else
      {
        i1 = 1;
        i2 = 1003030;
      }
      WSVerticalBeaconReport.b(this.g.k(), this.g.l(), this.g.F(), i2, a((WSVerticalPageContract.Presenter)this.g.aO_()));
      WSDramaOperationRecordManager.a(((WSDramaEpisodeInfo)localObject).a(), i1, new WSVerticalItemBottomOperationController.1(this, bool));
    }
  }
  
  private Map<String, String> a(@Nullable WSVerticalPageContract.Presenter paramPresenter)
  {
    if ((paramPresenter instanceof AbsWSVerticalPagePresenter)) {
      return ((AbsWSVerticalPagePresenter)paramPresenter).n();
    }
    return null;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((A() != null) && (A().new_icon != null) && ((A().new_icon.tag_type == 1) || (A().new_icon.tag_type == 2)))
    {
      if (this.r == null)
      {
        this.r = new WSVerticalItemBottomWidgetViewController(this.a, this.s);
        this.r.a(this.q);
      }
      this.r.a(paramWSVerticalItemData);
    }
  }
  
  private void u()
  {
    a(this.k, o());
  }
  
  private void v()
  {
    a(this.j, n());
    if (z() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.j, z(), "0");
      return;
    }
    this.j.setText(2131918126);
  }
  
  private boolean w()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private int x()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.ding_count;
    }
    return 0;
  }
  
  private int y()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    if (localstSimpleMetaFeed != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("itemInfo hashCode:");
      localStringBuilder.append(localstSimpleMetaFeed.hashCode());
      WSLog.c("comment", localStringBuilder.toString());
      return localstSimpleMetaFeed.total_comment_num;
    }
    return 0;
  }
  
  private int z()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.share_info != null)) {
      return localstSimpleMetaFeed.share_info.share_num;
    }
    return 0;
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    WSLikeAnimationManger.a().a(localstSimpleMetaFeed, h(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.o, this.m, this.n, this.p);
    WSVerticalBeaconReport.c(this.g.k(), this.g.l(), localstSimpleMetaFeed, ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  protected void b()
  {
    r();
    s();
    v();
    u();
    q();
    WSVerticalItemBottomWidgetViewController localWSVerticalItemBottomWidgetViewController = this.r;
    if (localWSVerticalItemBottomWidgetViewController != null) {
      localWSVerticalItemBottomWidgetViewController.b();
    }
  }
  
  protected void f()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    if (localstSimpleMetaFeed != null) {
      WSLikeAnimationManger.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected int i()
  {
    return 2131626081;
  }
  
  protected void j()
  {
    this.m = ((ImageView)c(2131449625));
    this.n = ((ImageView)c(2131449624));
    this.o = ((TextView)c(2131449626));
    this.i = ((ViewGroup)c(2131449622));
    this.i.setOnClickListener(this);
    this.h = ((TextView)c(2131449509));
    this.h.setOnClickListener(this);
    this.q = ((ViewStub)c(2131449486));
    this.j = ((TextView)c(2131449708));
    this.j.setOnClickListener(this);
    this.k = ((TextView)c(2131449615));
    this.k.setOnClickListener(this);
    this.l = ((TextView)c(2131432175));
    this.l.setOnClickListener(this);
  }
  
  protected boolean l()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    int i1;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.dingHidden)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return i1 ^ 0x1;
  }
  
  protected boolean m()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    int i1;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.commentHidden)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return i1 ^ 0x1;
  }
  
  protected boolean n()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = A();
    int i1;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.shareHidden)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return i1 ^ 0x1;
  }
  
  protected boolean o()
  {
    boolean bool1 = p();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (c() != null)
    {
      if (((WSVerticalItemData)c()).b() == null) {
        return false;
      }
      stCallWeishiButton localstCallWeishiButton = ((WSVerticalItemData)c()).b().weishiButton;
      bool1 = bool2;
      if (localstCallWeishiButton != null)
      {
        bool1 = bool2;
        if (localstCallWeishiButton.isShow) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131449708: 
      C();
      return;
    case 2131449622: 
      t();
      return;
    case 2131449615: 
      B();
      return;
    case 2131449509: 
      D();
      return;
    }
    E();
  }
  
  protected boolean p()
  {
    return ((this.g.aO_() instanceof AbsWSVerticalForDramaPresenter)) && (WSExpABTestManager.a().t());
  }
  
  public void q()
  {
    a(this.l, p());
    Object localObject = (WSVerticalItemData)c();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).g();
      if (localObject == null) {
        return;
      }
      String str;
      if (((WSDramaEpisodeInfo)localObject).d().dramaInfo.isFollowed)
      {
        localObject = d().getResources().getDrawable(2130853505);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        str = this.a.getResources().getString(1929838609);
      }
      else
      {
        localObject = d().getResources().getDrawable(2130853507);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        str = this.a.getResources().getString(1929838612);
      }
      this.l.setCompoundDrawables(null, (Drawable)localObject, null, null);
      this.l.setText(str);
    }
  }
  
  public void r()
  {
    a(this.i, l());
    this.m.setSelected(w());
    this.n.setVisibility(8);
    if (x() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.o, x(), "0");
      return;
    }
    this.o.setText(2131918122);
  }
  
  public void s()
  {
    a(this.h, m());
    if (y() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.h, y(), "0");
      return;
    }
    this.h.setText(2131918099);
  }
  
  public void t()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject != null)
    {
      if (((WSVerticalItemData)localObject).b() == null) {
        return;
      }
      if (WeishiUtils.o()) {
        return;
      }
      localObject = ((WSVerticalItemData)localObject).b();
      WSLikeAnimationManger.a().a((stSimpleMetaFeed)localObject, h(), this.o, this.m, this.n, this.p);
      String str1 = this.g.k();
      String str2 = this.g.l();
      int i1 = ((stSimpleMetaFeed)localObject).is_ding;
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      WSVerticalBeaconReport.a(str1, str2, bool, (stSimpleMetaFeed)localObject, ((WSVerticalPageContract.Presenter)this.g.aO_()).n());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomOperationController
 * JD-Core Version:    0.7.0.1
 */