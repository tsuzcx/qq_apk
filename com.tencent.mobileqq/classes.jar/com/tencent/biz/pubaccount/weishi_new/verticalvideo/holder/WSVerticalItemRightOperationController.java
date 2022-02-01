package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.Map;

public class WSVerticalItemRightOperationController
  extends WSVerticalItemBottomOperationController
{
  @Nullable
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  
  public WSVerticalItemRightOperationController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private Map<String, String> a(@Nullable WSVerticalPageContract.Presenter paramPresenter)
  {
    if ((paramPresenter instanceof AbsWSVerticalPagePresenter)) {
      return ((AbsWSVerticalPagePresenter)paramPresenter).b();
    }
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 2130851284;
    } else {
      i = 2130851285;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
  }
  
  private void j()
  {
    WSSimpleEventBus.a().a(new WSClearModeEvent(this.jdField_a_of_type_Boolean ^ true));
    WSVerticalBeaconReport.g(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), a((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewStub)a(2131381012)).inflate());
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  protected boolean a()
  {
    return (super.a()) && (!this.jdField_a_of_type_Boolean);
  }
  
  protected int b()
  {
    return 2131560044;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
    a(this.jdField_a_of_type_AndroidViewViewGroup, a());
    a(this.jdField_a_of_type_AndroidWidgetTextView, b());
    a(this.b, c());
    a(this.c, d());
    a(this.d, e());
  }
  
  protected boolean b()
  {
    return (super.b()) && (!this.jdField_a_of_type_Boolean);
  }
  
  protected boolean c()
  {
    return (super.c()) && (!this.jdField_a_of_type_Boolean);
  }
  
  protected boolean d()
  {
    return (super.d()) && (!this.jdField_a_of_type_Boolean);
  }
  
  protected boolean e()
  {
    return (super.e()) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() != 2131380544) {
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemRightOperationController
 * JD-Core Version:    0.7.0.1
 */