package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public abstract class AbsWSVerticalItemBottomSubCollectionController
  extends AbsWsVerticalUIGroup
{
  protected stSimpleMetaFeed a;
  protected TextView a;
  protected WSVerticalPageFragment a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public AbsWSVerticalItemBottomSubCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.h);
    localGradientDrawable.setColor(Color.parseColor("#2F2F2F"));
    return localGradientDrawable;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().b();
  }
  
  protected abstract String a();
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData != null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  protected abstract boolean a();
  
  protected int b()
  {
    return 2131560033;
  }
  
  protected void b()
  {
    if (a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void c() {}
  
  protected void c(int paramInt)
  {
    if (a()) {
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    }
  }
  
  protected void d(int paramInt) {}
  
  protected void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131380447);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AbsWSVerticalItemBottomSubCollectionController.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380449));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380448));
    FrameLayout localFrameLayout = (FrameLayout)a(2131366907);
    this.jdField_a_of_type_AndroidWidgetTextView.setRotation(270.0F);
    localFrameLayout.setBackgroundDrawable(a());
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(WSFeedUtils.b(2131165336));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVerticalItemBottomSubCollectionController
 * JD-Core Version:    0.7.0.1
 */