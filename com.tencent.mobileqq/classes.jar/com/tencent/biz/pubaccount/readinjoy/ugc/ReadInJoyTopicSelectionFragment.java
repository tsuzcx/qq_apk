package com.tencent.biz.pubaccount.readinjoy.ugc;

import aevv;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bkij;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pha;
import pmh;
import pmk;
import pmn;
import rkv;
import rlr;
import rnq;

public class ReadInJoyTopicSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bkij
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  public List<Map<String, CharSequence>> a;
  private pmn jdField_a_of_type_Pmn = new rkv(this);
  private rnq jdField_a_of_type_Rnq;
  private List<TopicInfo> b = new ArrayList();
  
  public ReadInJoyTopicSelectionFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131378273);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Rnq = new rnq(getActivity(), this.jdField_a_of_type_JavaUtilList);
    paramViewGroup = (ListView)this.mContentView.findViewById(2131369965);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.addFooterView(paramLayoutInflater.inflate(2131560276, paramViewGroup, false));
    paramViewGroup.setAdapter(this.jdField_a_of_type_Rnq);
    pmh.a().h(null);
  }
  
  private void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getActivity().setResult(-1, localIntent);
    onBackEvent();
  }
  
  private static List<Map<String, CharSequence>> b(List<TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("key_cover_url", localTopicInfo.c());
      localHashMap.put("key_title", localTopicInfo.a());
      localHashMap.put("key_summary", localTopicInfo.b());
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  private void b()
  {
    this.vg.changeBg(true);
    setTitle(getString(2131717060));
    this.leftView.setText(2131690389);
    rlr.a(this);
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.jdField_a_of_type_Int);
    localIntent.putExtra("public_fragment_window_feature", 1);
    aevv.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyUgcSearchTopicFragment.class, 1000);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {
      this.jdField_a_of_type_Int = paramLayoutInflater.getInt("searchTopicFrom");
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560275;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = (TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
      if (paramIntent != null) {
        a(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      c();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.b.size())
    {
      a((TopicInfo)this.b.get(paramInt));
      paramAdapterView = (TopicInfo)this.b.get(paramInt);
      if (paramAdapterView == null) {
        break label70;
      }
    }
    label70:
    for (paramLong = paramAdapterView.a();; paramLong = -1L)
    {
      pha.a("0X800980A", this.jdField_a_of_type_Int, paramLong, "0");
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    pmk.a().b(this.jdField_a_of_type_Pmn);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    a();
    pmk.a().a(this.jdField_a_of_type_Pmn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment
 * JD-Core Version:    0.7.0.1
 */