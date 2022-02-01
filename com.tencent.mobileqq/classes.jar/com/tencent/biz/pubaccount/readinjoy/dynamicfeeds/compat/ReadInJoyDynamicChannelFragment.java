package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bltz;
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
import pdg;
import pdt;
import pdw;
import pdx;
import pfa;
import pfd;
import pfh;
import qyv;

public class ReadInJoyDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bltz jdField_a_of_type_Bltz = new pdx(this);
  private TopBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo;
  private pdt jdField_a_of_type_Pdt;
  private pfh jdField_a_of_type_Pfh = new pdw(this);
  private int e = 1;
  
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
    if ((paramTopBannerInfo == null) || (paramTopBannerInfo.mChannelId != this.jdField_b_of_type_Int)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo = paramTopBannerInfo;
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "refreshBanner mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      h();
    } while (paramTopBannerInfo.isDynamicItemsEmpty());
    if (paramTopBannerInfo.dynamicItems.size() > 0)
    {
      int i = 0;
      label71:
      if (i < paramTopBannerInfo.dynamicItems.size())
      {
        qyv localqyv = (qyv)paramTopBannerInfo.dynamicItems.get(i);
        if ((localqyv == null) || (TextUtils.isEmpty(localqyv.a))) {
          break label190;
        }
        QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "json = ", localqyv.a });
        ProteusItemView localProteusItemView = pdg.a(this.jdField_a_of_type_Pdt.a(), a(), pdg.a(localqyv.a));
        pdg.a(localProteusItemView, this.jdField_a_of_type_Pdt.a(), a(), localqyv.a);
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
  
  private void m()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDynamicChannelFragment.3(this), 3000L);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      m();
      pfa.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, position = ", Integer.valueOf(paramInt) });
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.size()))
    {
      qyv localqyv = (qyv)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.dynamicItems.get(paramInt);
      if ((localqyv != null) && (!TextUtils.isEmpty(localqyv.a)))
      {
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if (paramViewHolder != null)
        {
          QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "onBindHeader, json = ", localqyv.a });
          pdg.a(paramViewHolder, this.jdField_a_of_type_Pdt.a(), a(), localqyv.a);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pdt.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    pfa.a().a(this.jdField_b_of_type_Int, null, -1, true, false, this.e, null, -1L, null, this.c, 0L, 0L, null, paramInt, false, null, 0, null);
    this.e += 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Pdt = new pdt(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Pdt);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bltz);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Pdt != null)
    {
      QLog.d("ReadInJoyDynamicChannelFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_Pdt.a());
      this.jdField_a_of_type_Pdt.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pfd.a().b(this.jdField_a_of_type_Pfh);
    if (this.jdField_a_of_type_Pdt != null) {
      this.jdField_a_of_type_Pdt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */