package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import berv;
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
import off;
import ofm;
import ofo;
import ofp;
import ofx;
import ofy;
import ofz;
import ogd;
import ogf;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private berv jdField_a_of_type_Berv = new ofp(this);
  private ofm jdField_a_of_type_Ofm;
  private ofy jdField_a_of_type_Ofy = new ofo(this);
  
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
  
  private void a(int paramInt, List<ogf> paramList)
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
          ogf localogf = (ogf)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", localogf.a, ", proteusData = ", localogf.b });
          if ((!TextUtils.isEmpty(localogf.a)) && (!TextUtils.isEmpty(localogf.b)))
          {
            ProteusItemView localProteusItemView = off.a(this.jdField_a_of_type_Ofm.a(), a(), off.a(localogf.b));
            off.a(localProteusItemView, this.jdField_a_of_type_Ofm.a(), a(), localogf.b);
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
      Object localObject = ofz.a();
      if (localObject != null) {
        ((ofz)localObject).a(this.b, 10);
      }
      localObject = ogd.a();
      if (localObject != null)
      {
        ((ogd)localObject).a(this.b);
        a(this.b, ((ogd)localObject).a(this.b));
        ((ogd)localObject).b(this.b);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.b) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = ogd.a();
    if (localObject != null)
    {
      localObject = ((ogd)localObject).a(this.b);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (ogf)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          off.a(paramViewHolder, this.jdField_a_of_type_Ofm.a(), a(), ((ogf)localObject).b);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ofm.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ofm = new ofm(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.b);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ofm);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Berv);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ofm != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.b) });
      a(this.jdField_a_of_type_Ofm.a());
      this.jdField_a_of_type_Ofm.a();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ofx.a().a(this.jdField_a_of_type_Ofy);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ofx.a().b(this.jdField_a_of_type_Ofy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */