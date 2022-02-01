package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DataEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DataObserver;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.HeaderDataModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private ReadInJoyCGIDynamicChannelAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter;
  private DataObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDataObserver = new ReadInJoyCGIDynamicChannelFragment.1(this);
  private XRecyclerView.RefreshCallback jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback = new ReadInJoyCGIDynamicChannelFragment.2(this);
  
  public static ReadInJoyCGIDynamicChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyCGIDynamicChannelFragment localReadInJoyCGIDynamicChannelFragment = new ReadInJoyCGIDynamicChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoyCGIDynamicChannelFragment.setArguments(localBundle);
    return localReadInJoyCGIDynamicChannelFragment;
  }
  
  private void a(int paramInt, List<HeaderDataModel> paramList)
  {
    if (paramInt != this.jdField_b_of_type_Int) {}
    for (;;)
    {
      return;
      h();
      if ((paramList != null) && (paramList.size() != 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          HeaderDataModel localHeaderDataModel = (HeaderDataModel)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localHeaderDataModel.a, ", proteusData = ", localHeaderDataModel.jdField_b_of_type_JavaLangString });
          if ((!TextUtils.isEmpty(localHeaderDataModel.a)) && (!TextUtils.isEmpty(localHeaderDataModel.jdField_b_of_type_JavaLangString)))
          {
            ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.a(), a(), ProteusSupportUtilBase.a(localHeaderDataModel.jdField_b_of_type_JavaLangString));
            ProteusSupportUtilBase.a(localProteusItemView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.a(), a(), localHeaderDataModel.jdField_b_of_type_JavaLangString);
            a(localProteusItemView);
          }
        }
      }
    }
  }
  
  private void a(ConcurrentHashMap<String, DynamicChannelDataModel> paramConcurrentHashMap)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyCGIDynamicChannelFragment.3(this, paramConcurrentHashMap));
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject = DynamicChannelDataModule.a();
      if (localObject != null) {
        ((DynamicChannelDataModule)localObject).a(this.jdField_b_of_type_Int, 10);
      }
      localObject = DynamicChannelHeaderModule.a();
      if (localObject != null)
      {
        ((DynamicChannelHeaderModule)localObject).a(this.jdField_b_of_type_Int);
        a(this.jdField_b_of_type_Int, ((DynamicChannelHeaderModule)localObject).a(this.jdField_b_of_type_Int));
        ((DynamicChannelHeaderModule)localObject).b(this.jdField_b_of_type_Int);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = DynamicChannelHeaderModule.a();
    if (localObject != null)
    {
      localObject = ((DynamicChannelHeaderModule)localObject).a(this.jdField_b_of_type_Int);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (HeaderDataModel)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          ProteusSupportUtilBase.a(paramViewHolder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.a(), a(), ((HeaderDataModel)localObject).jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter = new ReadInJoyCGIDynamicChannelAdapter(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsCgiReadInJoyCGIDynamicChannelAdapter.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DataEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDataObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    DataEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDynamicfeedsDatamoduleDataObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */