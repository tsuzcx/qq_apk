package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RIJVideoHandleClick
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  private ClickHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickHandler = new RIJVideoHandleClick.4(this);
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ClickHandler b = new RIJVideoHandleClick.5(this);
  private ClickHandler c = new RIJVideoHandleClick.6(this);
  private ClickHandler d = new RIJVideoHandleClick.7(this);
  private ClickHandler e = new RIJVideoHandleClick.8(this);
  private ClickHandler f = new RIJVideoHandleClick.9(this);
  private ClickHandler g = new RIJVideoHandleClick.10(this);
  private ClickHandler h = new RIJVideoHandleClick.11(this);
  private ClickHandler i = new RIJVideoHandleClick.12(this);
  private ClickHandler j = new RIJVideoHandleClick.13(this);
  private ClickHandler k = new RIJVideoHandleClick.14(this);
  private ClickHandler l = new RIJVideoHandleClick.15(this);
  
  public RIJVideoHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramRIJDataManager;
    this.jdField_a_of_type_AndroidContentContext = paramRIJDataManager.a().a();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376557), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368858), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131381320), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370263), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131377067), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370262), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131377066), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368729), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131381401), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131366888), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131381485), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131381394), this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131373650), this.g);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370295), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131377100), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368055), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368057), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368859), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362057), this.k);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362136), this.l);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (VideoFeedsViewHolder)paramView.getTag();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(((VideoFeedsViewHolder)localObject).a);
    ReadinJoyActionUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (ArticleInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), 56, paramBoolean);
    ReadinJoyActionUtil.a((Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (ArticleInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), 56, paramBoolean, null);
    VideoHandler.a(paramView);
  }
  
  public void a(View paramView)
  {
    ClickHandler localClickHandler = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localClickHandler != null)
    {
      localClickHandler.onClick(paramView);
      return;
    }
    QLog.e("RIJVideoHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() == 2131368858)
    {
      b(paramView);
      return true;
    }
    return false;
  }
  
  public void b(View paramView)
  {
    paramView = (VideoFeedsViewHolder)paramView.getTag();
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramView.a);
    if (paramView == null) {
      return;
    }
    RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidContentContext, 2, new RIJVideoHandleClick.3(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick
 * JD-Core Version:    0.7.0.1
 */