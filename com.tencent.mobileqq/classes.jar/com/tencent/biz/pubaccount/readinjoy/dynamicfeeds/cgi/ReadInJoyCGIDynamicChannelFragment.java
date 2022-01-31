package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bfzp;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import oqq;
import oqx;
import oqz;
import ora;
import ori;
import orj;
import ork;
import oro;
import orq;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bfzp jdField_a_of_type_Bfzp = new ora(this);
  private oqx jdField_a_of_type_Oqx;
  private orj jdField_a_of_type_Orj = new oqz(this);
  
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
  
  private void a(int paramInt, List<orq> paramList)
  {
    if (paramInt != this.b) {}
    for (;;)
    {
      return;
      h();
      if ((paramList != null) && (paramList.size() != 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          orq localorq = (orq)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localorq.a, ", proteusData = ", localorq.b });
          if ((!TextUtils.isEmpty(localorq.a)) && (!TextUtils.isEmpty(localorq.b)))
          {
            ProteusItemView localProteusItemView = oqq.a(this.jdField_a_of_type_Oqx.a(), a(), oqq.a(localorq.b));
            oqq.a(localProteusItemView, this.jdField_a_of_type_Oqx.a(), a(), localorq.b);
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
      Object localObject = ork.a();
      if (localObject != null) {
        ((ork)localObject).a(this.b, 10);
      }
      localObject = oro.a();
      if (localObject != null)
      {
        ((oro)localObject).a(this.b);
        a(this.b, ((oro)localObject).a(this.b));
        ((oro)localObject).b(this.b);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = oro.a();
    if (localObject != null)
    {
      localObject = ((oro)localObject).a(this.b);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (orq)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          oqq.a(paramViewHolder, this.jdField_a_of_type_Oqx.a(), a(), ((orq)localObject).b);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Oqx.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Oqx = new oqx(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Oqx);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bfzp);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Oqx != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Oqx.a());
      this.jdField_a_of_type_Oqx.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ori.a().a(this.jdField_a_of_type_Orj);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ori.a().b(this.jdField_a_of_type_Orj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */