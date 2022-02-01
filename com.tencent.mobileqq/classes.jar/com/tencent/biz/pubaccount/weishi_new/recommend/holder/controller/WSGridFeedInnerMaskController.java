package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSGridFeedInnerMaskController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  protected stSimpleMetaFeed a;
  private KandianUrlImageView a;
  
  public WSGridFeedInnerMaskController(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_type == 1) && (WSGlobalConfig.a().a(1) == 2) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.maskImgUrl));
  }
  
  private void f()
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.maskImgUrl);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  public int b()
  {
    return 2131560537;
  }
  
  public void b()
  {
    f();
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131369394));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerMaskController
 * JD-Core Version:    0.7.0.1
 */