package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bltz;
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
import pdg;
import pdn;
import pdp;
import pdq;
import pdy;
import pdz;
import pea;
import pee;
import peg;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bltz jdField_a_of_type_Bltz = new pdq(this);
  private pdn jdField_a_of_type_Pdn;
  private pdz jdField_a_of_type_Pdz = new pdp(this);
  
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
  
  private void a(int paramInt, List<peg> paramList)
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
          peg localpeg = (peg)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localpeg.a, ", proteusData = ", localpeg.jdField_b_of_type_JavaLangString });
          if ((!TextUtils.isEmpty(localpeg.a)) && (!TextUtils.isEmpty(localpeg.jdField_b_of_type_JavaLangString)))
          {
            ProteusItemView localProteusItemView = pdg.a(this.jdField_a_of_type_Pdn.a(), a(), pdg.a(localpeg.jdField_b_of_type_JavaLangString));
            pdg.a(localProteusItemView, this.jdField_a_of_type_Pdn.a(), a(), localpeg.jdField_b_of_type_JavaLangString);
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
      Object localObject = pea.a();
      if (localObject != null) {
        ((pea)localObject).a(this.jdField_b_of_type_Int, 10);
      }
      localObject = pee.a();
      if (localObject != null)
      {
        ((pee)localObject).a(this.jdField_b_of_type_Int);
        a(this.jdField_b_of_type_Int, ((pee)localObject).a(this.jdField_b_of_type_Int));
        ((pee)localObject).b(this.jdField_b_of_type_Int);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = pee.a();
    if (localObject != null)
    {
      localObject = ((pee)localObject).a(this.jdField_b_of_type_Int);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (peg)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          pdg.a(paramViewHolder, this.jdField_a_of_type_Pdn.a(), a(), ((peg)localObject).jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pdn.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Pdn = new pdn(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Pdn);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bltz);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Pdn != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_Pdn.a());
      this.jdField_a_of_type_Pdn.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pdy.a().a(this.jdField_a_of_type_Pdz);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pdy.a().b(this.jdField_a_of_type_Pdz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */