package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalItemVideoAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a();
    }
    return null;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramstSimpleMetaFeed, false, "fullscreen_videoplay", a());
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a.b());
  }
  
  private void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      if (localObject != null)
      {
        localObject = ((WSVerticalPageAdapter)localObject).a();
        if (localObject != null) {
          break label29;
        }
      }
    }
    label29:
    AbsWSVerticalPagePresenter localAbsWSVerticalPagePresenter;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b() instanceof AbsWSVerticalPagePresenter));
      localAbsWSVerticalPagePresenter = (AbsWSVerticalPagePresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    } while (localAbsWSVerticalPagePresenter.b);
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), ((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, ((WSVerticalVideoHolder)localObject).getAdapterPosition() - 1);
    localAbsWSVerticalPagePresenter.b = true;
  }
  
  private void k()
  {
    WSPlayerManager localWSPlayerManager = a();
    if ((localWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder != null)) {
      localWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView == null) {}
    while (paramInt1 == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility()) {
      return;
    }
    WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public int b()
  {
    return 2131560162;
  }
  
  public void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    a(localstSimpleMetaFeed);
    this.c.setVisibility(8);
    i();
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setVisibility(paramInt);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131381206));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131381207));
    this.c = a(2131381211);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131381204));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381209));
    this.b = a(2131381208);
    this.b.setOnClickListener(new WSVerticalItemVideoAreaController.1(this));
  }
  
  public void f()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null)
    {
      if (localWSPlayerManager.c()) {
        localWSPlayerManager.b();
      }
    }
    else {
      return;
    }
    localWSPlayerManager.c();
    j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController
 * JD-Core Version:    0.7.0.1
 */