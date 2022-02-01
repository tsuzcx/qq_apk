package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bksw;
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
import pkn;
import pku;
import pkw;
import pkx;
import plf;
import plg;
import plh;
import pll;
import pln;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bksw jdField_a_of_type_Bksw = new pkx(this);
  private pku jdField_a_of_type_Pku;
  private plg jdField_a_of_type_Plg = new pkw(this);
  
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
  
  private void a(int paramInt, List<pln> paramList)
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
          pln localpln = (pln)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localpln.a, ", proteusData = ", localpln.jdField_b_of_type_JavaLangString });
          if ((!TextUtils.isEmpty(localpln.a)) && (!TextUtils.isEmpty(localpln.jdField_b_of_type_JavaLangString)))
          {
            ProteusItemView localProteusItemView = pkn.a(this.jdField_a_of_type_Pku.a(), a(), pkn.a(localpln.jdField_b_of_type_JavaLangString));
            pkn.a(localProteusItemView, this.jdField_a_of_type_Pku.a(), a(), localpln.jdField_b_of_type_JavaLangString);
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
      Object localObject = plh.a();
      if (localObject != null) {
        ((plh)localObject).a(this.jdField_b_of_type_Int, 10);
      }
      localObject = pll.a();
      if (localObject != null)
      {
        ((pll)localObject).a(this.jdField_b_of_type_Int);
        a(this.jdField_b_of_type_Int, ((pll)localObject).a(this.jdField_b_of_type_Int));
        ((pll)localObject).b(this.jdField_b_of_type_Int);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = pll.a();
    if (localObject != null)
    {
      localObject = ((pll)localObject).a(this.jdField_b_of_type_Int);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (pln)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          pkn.a(paramViewHolder, this.jdField_a_of_type_Pku.a(), a(), ((pln)localObject).jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pku.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Pku = new pku(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Pku);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bksw);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Pku != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_Pku.a());
      this.jdField_a_of_type_Pku.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    plf.a().a(this.jdField_a_of_type_Plg);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    plf.a().b(this.jdField_a_of_type_Plg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */