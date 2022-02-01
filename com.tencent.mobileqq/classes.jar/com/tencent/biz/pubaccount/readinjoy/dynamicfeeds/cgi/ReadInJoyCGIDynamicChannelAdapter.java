package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.DynamicItemViewHelperCompatBase;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelAbstractAdapter;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadInJoyCGIDynamicChannelAdapter
  extends ReadInJoyDynamicChannelAbstractAdapter<String, DynamicChannelDataModel>
{
  private DynamicItemViewHelperCompatCGI a;
  
  public ReadInJoyCGIDynamicChannelAdapter(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI = new DynamicItemViewHelperCompatCGI();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, 0);
  }
  
  public long a()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)localIterator.next();
          if (localDynamicChannelDataModel.recommendSeq <= l1) {
            break label85;
          }
          l1 = localDynamicChannelDataModel.recommendSeq;
        }
      }
    }
    label85:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a(paramInt))
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = ProteusSupportUtilBase.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), (String)localObject);
        if ((paramInt == DynamicItemViewHelperCompatBase.b) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID = ", localObject });
        localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          localObject = new ProteusItemView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
          QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "proteusItemView is null");
        }
        return new ReadInJoyCGIDynamicChannelAdapter.CustomViewHolder(this, (View)localObject);
      }
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder not the right type");
    }
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)a(paramInt);
    int i = paramBaseViewHolder.getItemViewType();
    ProteusItemView localProteusItemView = (ProteusItemView)paramBaseViewHolder.itemView;
    if (localDynamicChannelDataModel != null)
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a(i)) {
        break label156;
      }
      if (i != DynamicItemViewHelperCompatBase.b) {
        break label136;
      }
      localProteusItemView.setVisibility(8);
    }
    for (;;)
    {
      a(localDynamicChannelDataModel.uniqueID, localDynamicChannelDataModel);
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, dataModel = ", localDynamicChannelDataModel, ", proteusItemView = ", localProteusItemView, " , position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseViewHolder, paramInt, getItemId(paramInt));
      return;
      label136:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a(localProteusItemView, i, localDynamicChannelDataModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt);
      continue;
      label156:
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (DynamicChannelDataModel)a(paramInt);
    int i = DynamicItemViewHelperCompatBase.b;
    paramInt = i;
    if (localObject != null)
    {
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a((DynamicChannelDataModel)localObject))
      {
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiDynamicItemViewHelperCompatCGI.a((DynamicChannelDataModel)localObject);
        localObject = ((DynamicChannelDataModel)localObject).styleID;
        paramInt = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject);
          paramInt = i;
        }
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelAdapter
 * JD-Core Version:    0.7.0.1
 */