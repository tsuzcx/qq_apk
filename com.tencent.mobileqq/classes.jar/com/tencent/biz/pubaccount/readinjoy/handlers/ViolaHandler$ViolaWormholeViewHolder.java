package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.Wormhole;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView.WormholeViewLifeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;

public class ViolaHandler$ViolaWormholeViewHolder
  implements View.OnClickListener, WormholeView.WormholeViewLifeListener, VInstanceAction.VInstanceEventListener
{
  private int jdField_a_of_type_Int;
  private ViolaHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersViolaHandler;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private Wormhole jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole;
  private WormholeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView;
  
  public ViolaHandler$ViolaWormholeViewHolder(Wormhole paramWormhole, WormholeView paramWormholeView, ViolaHandler paramViolaHandler)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole = paramWormhole;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersViolaHandler = paramViolaHandler;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView = paramWormholeView;
    paramWormholeView.setLifeListener(this);
    paramWormholeView.a();
    paramWormholeView.setOnErrorViewClickListener(this);
  }
  
  private boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(paramBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.a())))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.b();
  }
  
  public void a(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(paramWormholeView.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersViolaHandler.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this);
      }
    }
  }
  
  public void b(WormholeView paramWormholeView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(paramWormholeView.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131381993) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormhole.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeId(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getWormholeData());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onError(String paramString)
  {
    if ((a(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.d();
    }
  }
  
  public void onRefreshItem(String paramString)
  {
    if (a(paramString)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.ViolaHandler.ViolaWormholeViewHolder
 * JD-Core Version:    0.7.0.1
 */