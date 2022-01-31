package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bibd;
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
import ovf;
import ovs;
import ovv;
import ovw;
import owy;
import oxb;
import oxe;
import qng;

public class ReadInJoyDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bibd jdField_a_of_type_Bibd = new ovw(this);
  private TopBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo;
  private ovs jdField_a_of_type_Ovs;
  private oxe jdField_a_of_type_Oxe = new ovv(this);
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
        qng localqng = (qng)paramTopBannerInfo.dynamicItems.get(i);
        if ((localqng == null) || (TextUtils.isEmpty(localqng.a))) {
          break label190;
        }
        QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "json = ", localqng.a });
        ProteusItemView localProteusItemView = ovf.a(this.jdField_a_of_type_Ovs.a(), a(), ovf.a(localqng.a));
        ovf.a(localProteusItemView, this.jdField_a_of_type_Ovs.a(), a(), localqng.a);
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
      owy.a().a(this.b, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, position = ", Integer.valueOf(paramInt) });
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size()))
    {
      qng localqng = (qng)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.get(paramInt);
      if ((localqng != null) && (!TextUtils.isEmpty(localqng.a)))
      {
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if (paramViewHolder != null)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, json = ", localqng.a });
          ovf.a(paramViewHolder, this.jdField_a_of_type_Ovs.a(), a(), localqng.a);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ovs.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    owy.a().a(this.b, null, -1, true, false, this.jdField_e_of_type_Int, null, -1L, null, this.jdField_c_of_type_Int, 0L, 0L, null, paramInt, false, null, 0, null);
    this.jdField_e_of_type_Int += 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ovs = new ovs(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ovs);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bibd);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ovs != null)
    {
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Ovs.a());
      this.jdField_a_of_type_Ovs.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    oxb.a().a(this.jdField_a_of_type_Oxe);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    oxb.a().b(this.jdField_a_of_type_Oxe);
    if (this.jdField_a_of_type_Ovs != null) {
      this.jdField_a_of_type_Ovs.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */