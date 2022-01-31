package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bgag;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import oqn;
import ora;
import ord;
import ore;
import osg;
import osj;
import osm;
import qdk;

public class ReadInJoyDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bgag jdField_a_of_type_Bgag = new ore(this);
  private TopBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo;
  private ora jdField_a_of_type_Ora;
  private osm jdField_a_of_type_Osm = new ord(this);
  private int e;
  public final String e;
  
  public ReadInJoyDynamicChannelFragment()
  {
    this.jdField_e_of_type_JavaLangString = "ReadInJoyDynamicChannelFragment";
    this.jdField_e_of_type_Int = 1;
  }
  
  public static ReadInJoyDynamicChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyDynamicChannelFragment localReadInJoyDynamicChannelFragment = new ReadInJoyDynamicChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoyDynamicChannelFragment.setArguments(localBundle);
    return localReadInJoyDynamicChannelFragment;
  }
  
  private void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((paramTopBannerInfo == null) || (paramTopBannerInfo.mChannelId != this.b)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo = paramTopBannerInfo;
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "refreshBanner mChannelID = ", Integer.valueOf(this.b) });
      h();
    } while (paramTopBannerInfo.isDynamicItemsEmpty());
    if (paramTopBannerInfo.dynamicItems.size() > 0)
    {
      int i = 0;
      label71:
      if (i < paramTopBannerInfo.dynamicItems.size())
      {
        qdk localqdk = (qdk)paramTopBannerInfo.dynamicItems.get(i);
        if ((localqdk == null) || (TextUtils.isEmpty(localqdk.a))) {
          break label190;
        }
        QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "json = ", localqdk.a });
        ProteusItemView localProteusItemView = oqn.a(this.jdField_a_of_type_Ora.a(), a(), oqn.a(localqdk.a));
        oqn.a(localProteusItemView, this.jdField_a_of_type_Ora.a(), a(), localqdk.a);
        a(localProteusItemView);
      }
      for (;;)
      {
        i += 1;
        break label71;
        break;
        label190:
        QLog.d("ReadInJoyDynamicChannelFragment", 2, "refreshBanner, dynamicJSON is null.");
      }
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "refreshBanner, dynamicItems is null.");
  }
  
  private void a(ConcurrentHashMap<Long, BaseArticleInfo> paramConcurrentHashMap)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDynamicChannelFragment.4(this, paramConcurrentHashMap));
  }
  
  private void l()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDynamicChannelFragment.3(this), 3000L);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      l();
      osg.a().a(this.b, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, position = ", Integer.valueOf(paramInt) });
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size()))
    {
      qdk localqdk = (qdk)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.get(paramInt);
      if ((localqdk != null) && (!TextUtils.isEmpty(localqdk.a)))
      {
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if (paramViewHolder != null)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, json = ", localqdk.a });
          oqn.a(paramViewHolder, this.jdField_a_of_type_Ora.a(), a(), localqdk.a);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ora.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    osg.a().a(this.b, null, -1, true, false, this.jdField_e_of_type_Int, null, -1L, null, this.jdField_c_of_type_Int, 0L, 0L, null, paramInt, false, null, 0, null);
    this.jdField_e_of_type_Int += 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ora = new ora(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ora);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bgag);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ora != null)
    {
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Ora.a());
      this.jdField_a_of_type_Ora.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    osj.a().b(this.jdField_a_of_type_Osm);
    if (this.jdField_a_of_type_Ora != null) {
      this.jdField_a_of_type_Ora.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */