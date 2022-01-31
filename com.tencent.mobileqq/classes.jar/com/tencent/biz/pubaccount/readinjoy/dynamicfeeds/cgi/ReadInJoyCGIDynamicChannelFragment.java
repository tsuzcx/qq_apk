package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import bibd;
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
import ovf;
import ovm;
import ovo;
import ovp;
import ovx;
import ovy;
import ovz;
import owd;
import owf;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private bibd jdField_a_of_type_Bibd = new ovp(this);
  private ovm jdField_a_of_type_Ovm;
  private ovy jdField_a_of_type_Ovy = new ovo(this);
  
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
  
  private void a(int paramInt, List<owf> paramList)
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
          owf localowf = (owf)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localowf.a, ", proteusData = ", localowf.b });
          if ((!TextUtils.isEmpty(localowf.a)) && (!TextUtils.isEmpty(localowf.b)))
          {
            ProteusItemView localProteusItemView = ovf.a(this.jdField_a_of_type_Ovm.a(), a(), ovf.a(localowf.b));
            ovf.a(localProteusItemView, this.jdField_a_of_type_Ovm.a(), a(), localowf.b);
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
      Object localObject = ovz.a();
      if (localObject != null) {
        ((ovz)localObject).a(this.b, 10);
      }
      localObject = owd.a();
      if (localObject != null)
      {
        ((owd)localObject).a(this.b);
        a(this.b, ((owd)localObject).a(this.b));
        ((owd)localObject).b(this.b);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = owd.a();
    if (localObject != null)
    {
      localObject = ((owd)localObject).a(this.b);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (owf)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          ovf.a(paramViewHolder, this.jdField_a_of_type_Ovm.a(), a(), ((owf)localObject).b);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ovm.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ovm = new ovm(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ovm);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Bibd);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ovm != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Ovm.a());
      this.jdField_a_of_type_Ovm.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ovx.a().a(this.jdField_a_of_type_Ovy);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ovx.a().b(this.jdField_a_of_type_Ovy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */