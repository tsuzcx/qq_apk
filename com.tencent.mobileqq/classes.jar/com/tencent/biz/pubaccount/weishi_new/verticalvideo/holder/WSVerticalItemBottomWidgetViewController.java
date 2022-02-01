package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemBottomWidgetViewController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private stNewIconStyle jdField_a_of_type_UserGrowthStNewIconStyle;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View jdField_b_of_type_AndroidViewView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private KandianUrlImageView c;
  
  public WSVerticalItemBottomWidgetViewController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.title)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStNewIconStyle.title);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl)) {
        this.c.setImage(WeishiUtils.a(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl));
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842881);
        }
        return;
        this.c.setImageResource(2130843419);
      }
    }
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    a(true, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842881);
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
      this.jdField_a_of_type_UserGrowthStNewIconStyle = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.new_icon;
      if (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) {
        WSReportDC898Vertical.a(this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type, this.jdField_a_of_type_UserGrowthStNewIconStyle.id);
      }
    }
  }
  
  public int b()
  {
    return 2131560156;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && ((this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 1) || (this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 2)))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      int i = this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type;
      String str = this.jdField_a_of_type_UserGrowthStNewIconStyle.img_url;
      if (i == 1)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        f();
      }
      while (i != 2) {
        return;
      }
      a(false, false);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(WeishiUtils.a(str));
        return;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(WeishiUtils.a("https://isee.weishi.qq.com/qq/doudi_ban.png"));
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131381221);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131381203));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131381220));
    this.c = ((KandianUrlImageView)a(2131381223));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381222));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381221) {
      WSVerticalJumpUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomWidgetViewController
 * JD-Core Version:    0.7.0.1
 */