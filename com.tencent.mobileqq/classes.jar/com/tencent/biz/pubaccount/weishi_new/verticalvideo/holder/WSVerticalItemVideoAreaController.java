package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemVideoAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private View b;
  private View c;
  
  public WSVerticalItemVideoAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private stSimpleMetaFeed a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return localWSVerticalItemData.a();
    }
    return null;
  }
  
  private WSPlayerManager a()
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    if ((localWSVerticalPageFragment != null) && (localWSVerticalPageFragment.a() != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a();
    }
    return null;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramstSimpleMetaFeed, false, "fullscreen_videoplay", a());
  }
  
  private void a(boolean paramBoolean)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    if (localWSVerticalPageFragment != null)
    {
      if (localWSVerticalPageFragment.b() == null) {
        return;
      }
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), paramBoolean, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    }
  }
  
  private boolean a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
    return (localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a.b());
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    if (localObject != null)
    {
      localObject = ((WSVerticalPageFragment)localObject).a();
      if (localObject != null)
      {
        localObject = ((WSVerticalPageAdapter)localObject).a();
        if (localObject == null) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b() instanceof AbsWSVerticalPagePresenter))
        {
          AbsWSVerticalPagePresenter localAbsWSVerticalPagePresenter = (AbsWSVerticalPagePresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
          if (!localAbsWSVerticalPagePresenter.c)
          {
            WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), ((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, ((WSVerticalVideoHolder)localObject).getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
            localAbsWSVerticalPagePresenter.c = true;
          }
        }
      }
    }
  }
  
  private void k()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null)
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
      if (localWSVerticalVideoHolder != null) {
        localWSPlayerManager.b(localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
      }
    }
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianUrlImageView localKandianUrlImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    if (localKandianUrlImageView == null) {
      return;
    }
    if (paramInt1 == localKandianUrlImageView.getVisibility()) {
      return;
    }
    WeishiUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected int b()
  {
    return 2131560048;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  }
  
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    a(localstSimpleMetaFeed);
    this.c.setVisibility(8);
    i();
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    View localView = this.c;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131380462));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131380463));
    this.c = a(2131380467);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131380460));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380465));
    this.b = a(2131380464);
    this.b.setOnClickListener(new WSVerticalItemVideoAreaController.1(this));
  }
  
  public void f()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null)
    {
      if (localWSPlayerManager.c())
      {
        localWSPlayerManager.b();
        a(false);
        return;
      }
      localWSPlayerManager.c();
      a(true);
      j();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void i()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController
 * JD-Core Version:    0.7.0.1
 */