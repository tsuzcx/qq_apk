package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bjxz;
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
import pit;
import pja;
import pjc;
import pjd;
import pjl;
import pjm;
import pjn;
import pjr;
import pjt;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bjxz jdField_a_of_type_Bjxz = new pjd(this);
  private pja jdField_a_of_type_Pja;
  private pjm jdField_a_of_type_Pjm = new pjc(this);
  
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
  
  private void a(int paramInt, List<pjt> paramList)
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
          pjt localpjt = (pjt)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localpjt.a, ", proteusData = ", localpjt.jdField_b_of_type_JavaLangString });
          if ((!TextUtils.isEmpty(localpjt.a)) && (!TextUtils.isEmpty(localpjt.jdField_b_of_type_JavaLangString)))
          {
            ProteusItemView localProteusItemView = pit.a(this.jdField_a_of_type_Pja.a(), a(), pit.a(localpjt.jdField_b_of_type_JavaLangString));
            pit.a(localProteusItemView, this.jdField_a_of_type_Pja.a(), a(), localpjt.jdField_b_of_type_JavaLangString);
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
      Object localObject = pjn.a();
      if (localObject != null) {
        ((pjn)localObject).a(this.jdField_b_of_type_Int, 10);
      }
      localObject = pjr.a();
      if (localObject != null)
      {
        ((pjr)localObject).a(this.jdField_b_of_type_Int);
        a(this.jdField_b_of_type_Int, ((pjr)localObject).a(this.jdField_b_of_type_Int));
        ((pjr)localObject).b(this.jdField_b_of_type_Int);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = pjr.a();
    if (localObject != null)
    {
      localObject = ((pjr)localObject).a(this.jdField_b_of_type_Int);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (pjt)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          pit.a(paramViewHolder, this.jdField_a_of_type_Pja.a(), a(), ((pjt)localObject).jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pja.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Pja = new pja(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Pja);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bjxz);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Pja != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_Pja.a());
      this.jdField_a_of_type_Pja.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pjl.a().a(this.jdField_a_of_type_Pjm);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pjl.a().b(this.jdField_a_of_type_Pjm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */