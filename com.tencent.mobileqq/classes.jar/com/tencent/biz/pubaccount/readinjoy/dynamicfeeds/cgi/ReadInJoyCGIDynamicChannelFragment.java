package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bljk;
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
import ptq;
import ptx;
import ptz;
import pua;
import pui;
import puj;
import puk;
import puo;
import puq;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bljk jdField_a_of_type_Bljk = new pua(this);
  private ptx jdField_a_of_type_Ptx;
  private puj jdField_a_of_type_Puj = new ptz(this);
  
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
  
  private void a(int paramInt, List<puq> paramList)
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
          puq localpuq = (puq)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localpuq.a, ", proteusData = ", localpuq.jdField_b_of_type_JavaLangString });
          if ((!TextUtils.isEmpty(localpuq.a)) && (!TextUtils.isEmpty(localpuq.jdField_b_of_type_JavaLangString)))
          {
            ProteusItemView localProteusItemView = ptq.a(this.jdField_a_of_type_Ptx.a(), a(), ptq.a(localpuq.jdField_b_of_type_JavaLangString));
            ptq.a(localProteusItemView, this.jdField_a_of_type_Ptx.a(), a(), localpuq.jdField_b_of_type_JavaLangString);
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
      Object localObject = puk.a();
      if (localObject != null) {
        ((puk)localObject).a(this.jdField_b_of_type_Int, 10);
      }
      localObject = puo.a();
      if (localObject != null)
      {
        ((puo)localObject).a(this.jdField_b_of_type_Int);
        a(this.jdField_b_of_type_Int, ((puo)localObject).a(this.jdField_b_of_type_Int));
        ((puo)localObject).b(this.jdField_b_of_type_Int);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = puo.a();
    if (localObject != null)
    {
      localObject = ((puo)localObject).a(this.jdField_b_of_type_Int);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (puq)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          ptq.a(paramViewHolder, this.jdField_a_of_type_Ptx.a(), a(), ((puq)localObject).jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ptx.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ptx = new ptx(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ptx);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bljk);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ptx != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
      a(this.jdField_a_of_type_Ptx.a());
      this.jdField_a_of_type_Ptx.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pui.a().a(this.jdField_a_of_type_Puj);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pui.a().b(this.jdField_a_of_type_Puj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */