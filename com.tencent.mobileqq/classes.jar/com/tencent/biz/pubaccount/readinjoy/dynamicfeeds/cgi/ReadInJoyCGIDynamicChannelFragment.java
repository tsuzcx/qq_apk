package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bgag;
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
import oqn;
import oqu;
import oqw;
import oqx;
import orf;
import org;
import orh;
import orl;
import orn;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bgag jdField_a_of_type_Bgag = new oqx(this);
  private oqu jdField_a_of_type_Oqu;
  private org jdField_a_of_type_Org = new oqw(this);
  
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
  
  private void a(int paramInt, List<orn> paramList)
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
          orn localorn = (orn)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localorn.a, ", proteusData = ", localorn.b });
          if ((!TextUtils.isEmpty(localorn.a)) && (!TextUtils.isEmpty(localorn.b)))
          {
            ProteusItemView localProteusItemView = oqn.a(this.jdField_a_of_type_Oqu.a(), a(), oqn.a(localorn.b));
            oqn.a(localProteusItemView, this.jdField_a_of_type_Oqu.a(), a(), localorn.b);
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
      Object localObject = orh.a();
      if (localObject != null) {
        ((orh)localObject).a(this.b, 10);
      }
      localObject = orl.a();
      if (localObject != null)
      {
        ((orl)localObject).a(this.b);
        a(this.b, ((orl)localObject).a(this.b));
        ((orl)localObject).b(this.b);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = orl.a();
    if (localObject != null)
    {
      localObject = ((orl)localObject).a(this.b);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (orn)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          oqn.a(paramViewHolder, this.jdField_a_of_type_Oqu.a(), a(), ((orn)localObject).b);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Oqu.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Oqu = new oqu(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Oqu);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bgag);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Oqu != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Oqu.a());
      this.jdField_a_of_type_Oqu.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    orf.a().a(this.jdField_a_of_type_Org);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    orf.a().b(this.jdField_a_of_type_Org);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */