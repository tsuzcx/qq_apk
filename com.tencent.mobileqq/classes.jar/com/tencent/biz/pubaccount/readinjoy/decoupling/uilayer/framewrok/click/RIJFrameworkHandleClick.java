package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RIJFrameworkHandleClick
{
  private RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  private ClickHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickHandler = new RIJFrameworkHandleClick.1(this);
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ClickHandler b = new RIJFrameworkHandleClick.2(this);
  private ClickHandler c = new RIJFrameworkHandleClick.3(this);
  
  public RIJFrameworkHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramRIJDataManager;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376948), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376552), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368603), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131361878), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370293), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131377098), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362056), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380915), this.c);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ReadInJoyUtils.a(paramContext, ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public void a(View paramView)
  {
    ClickHandler localClickHandler = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localClickHandler != null)
    {
      localClickHandler.onClick(paramView);
      return;
    }
    QLog.e("RIJFrameworkHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJFrameworkHandleClick
 * JD-Core Version:    0.7.0.1
 */