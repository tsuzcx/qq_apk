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
  protected ViewGroup a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  protected WSVerticalPageFragment a;
  private WSVerticalItemBottomWidgetViewController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  private TextView e;
  
  public WSVerticalItemBottomOperationController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramWSVerticalVideoHolder.itemView);
    }
    WSLog.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data hashCode:");
      localStringBuilder.append(localWSVerticalItemData.hashCode());
      WSLog.c("comment", localStringBuilder.toString());
      return localWSVerticalItemData.a();
    }
    WSLog.c("comment", "data is null");
    return null;
  }
  
  private Map<String, String> a(@Nullable WSVerticalPageContract.Presenter paramPresenter)
  {
    if ((paramPresenter instanceof AbsWSVerticalPagePresenter)) {
      return ((AbsWSVerticalPagePresenter)paramPresenter).b();
    }
    return null;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController = new WSVerticalItemBottomWidgetViewController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController.a(paramWSVerticalItemData);
    }
  }
  
  private int c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.ding_count;
    }
    return 0;
  }
  
  private int d()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
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
  
  private int e()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.share_info != null)) {
      return localstSimpleMetaFeed.share_info.share_num;
    }
    return 0;
  }
  
  private boolean f()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void j()
  {
    a(this.c, d());
  }
  
  private void k()
  {
    a(this.jdField_b_of_type_AndroidWidgetTextView, c());
    if (e() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.jdField_b_of_type_AndroidWidgetTextView, e(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720450);
  }
  
  private void l()
  {
    WSVerticalJumpUtils.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, a());
  }
  
  private void m()
  {
    Object localObject = a();
    WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), 1000001, (stSimpleMetaFeed)localObject, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    WSReportDC898Vertical.c();
    localObject = new WSShareParam();
    ((WSShareParam)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    ((WSShareParam)localObject).jdField_a_of_type_Int = 3;
    ((WSShareParam)localObject).jdField_b_of_type_Int = a();
    ((WSShareParam)localObject).jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    ((WSShareParam)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    ((WSShareParam)localObject).c = "forward";
    ((WSShareParam)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    WeishiShareUtil.a(this.jdField_a_of_type_AndroidContentContext, (WSShareParam)localObject);
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    if (localObject == null) {
      return;
    }
    WSVerticalBeaconReport.e(((WSVerticalPageFragment)localObject).a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a(), ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a;
    if (localObject == null)
    {
      WSLog.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    WSLog.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    ((WsCommentPresenter)localObject).a(a());
    ((WsCommentPresenter)localObject).a(WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    ((WsCommentPresenter)localObject).a(a());
    ((WsCommentPresenter)localObject).b();
  }
  
  private void o()
  {
    if (WeishiUtils.c()) {
      return;
    }
    Object localObject = (WSVerticalItemData)a();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).a();
      if (localObject == null) {
        return;
      }
      boolean bool = ((WSDramaEpisodeInfo)localObject).a().dramaInfo.isFollowed;
      int i;
      int j;
      if (bool)
      {
        i = 2;
        j = 1003038;
      }
      else
      {
        i = 1;
        j = 1003030;
      }
      WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), j, a((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()));
      WSDramaOperationRecordManager.a(((WSDramaEpisodeInfo)localObject).a(), i, new WSVerticalItemBottomOperationController.1(this, bool));
    }
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    WSLikeAnimationManger.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.e, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidViewViewGroup);
    WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), localstSimpleMetaFeed, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  protected boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.dingHidden)) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
  
  protected int b()
  {
    return 2131560037;
  }
  
  protected void b()
  {
    g();
    h();
    k();
    j();
    f();
    WSVerticalItemBottomWidgetViewController localWSVerticalItemBottomWidgetViewController = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomWidgetViewController;
    if (localWSVerticalItemBottomWidgetViewController != null) {
      localWSVerticalItemBottomWidgetViewController.b();
    }
  }
  
  protected boolean b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.commentHidden)) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
  
  protected void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      WSLikeAnimationManger.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected boolean c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.shareHidden)) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
  
  protected boolean d()
  {
    boolean bool1 = e();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (a() != null)
    {
      if (((WSVerticalItemData)a()).a() == null) {
        return false;
      }
      stCallWeishiButton localstCallWeishiButton = ((WSVerticalItemData)a()).a().weishiButton;
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
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131380666));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131380665));
    this.e = ((TextView)a(2131380667));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131380663));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380552));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380740));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)a(2131380656));
    this.c.setOnClickListener(this);
    this.d = ((TextView)a(2131365907));
    this.d.setOnClickListener(this);
  }
  
  protected boolean e()
  {
    return ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b() instanceof AbsWSVerticalForDramaPresenter)) && (WSExpABTestManager.a().h());
  }
  
  public void f()
  {
    a(this.d, e());
    Object localObject = (WSVerticalItemData)a();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).a();
      if (localObject == null) {
        return;
      }
      String str;
      if (((WSDramaEpisodeInfo)localObject).a().dramaInfo.isFollowed)
      {
        localObject = a().getResources().getDrawable(2130851245);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(1929707527);
      }
      else
      {
        localObject = a().getResources().getDrawable(2130851247);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(1929707530);
      }
      this.d.setCompoundDrawables(null, (Drawable)localObject, null, null);
      this.d.setText(str);
    }
  }
  
  public void g()
  {
    a(this.jdField_a_of_type_AndroidViewViewGroup, a());
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(f());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (c() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.e, c(), "0");
      return;
    }
    this.e.setText(2131720446);
  }
  
  public void h()
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, b());
    if (d() > 0)
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.jdField_a_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720423);
  }
  
  public void i()
  {
    Object localObject = (WSVerticalItemData)a();
    if (localObject != null)
    {
      if (((WSVerticalItemData)localObject).a() == null) {
        return;
      }
      if (WeishiUtils.c()) {
        return;
      }
      localObject = ((WSVerticalItemData)localObject).a();
      WSLikeAnimationManger.a().a((stSimpleMetaFeed)localObject, a(), this.e, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidViewViewGroup);
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      int i = ((stSimpleMetaFeed)localObject).is_ding;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      WSVerticalBeaconReport.a(str1, str2, bool, (stSimpleMetaFeed)localObject, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380740: 
      m();
      return;
    case 2131380663: 
      i();
      return;
    case 2131380656: 
      l();
      return;
    case 2131380552: 
      n();
      return;
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomOperationController
 * JD-Core Version:    0.7.0.1
 */