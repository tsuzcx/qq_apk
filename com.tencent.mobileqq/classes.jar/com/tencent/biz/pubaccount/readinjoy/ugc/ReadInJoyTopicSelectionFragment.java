package com.tencent.biz.pubaccount.readinjoy.ugc;

import adky;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bhqp;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ors;
import owy;
import oxb;
import oxe;
import qpy;
import qqu;
import qsn;

public class ReadInJoyTopicSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bhqp
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  public List<Map<String, CharSequence>> a;
  private oxe jdField_a_of_type_Oxe = new qpy(this);
  private qsn jdField_a_of_type_Qsn;
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
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131377389);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Qsn = new qsn(getActivity(), this.jdField_a_of_type_JavaUtilList);
    paramViewGroup = (ListView)this.mContentView.findViewById(2131369552);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.addFooterView(paramLayoutInflater.inflate(2131560135, paramViewGroup, false));
    paramViewGroup.setAdapter(this.jdField_a_of_type_Qsn);
    owy.a().h(null);
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
    this.vg.a(true);
    setTitle(getString(2131718915));
    this.leftView.setText(2131690382);
    qqu.a(this);
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.jdField_a_of_type_Int);
    localIntent.putExtra("public_fragment_window_feature", 1);
    adky.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyUgcSearchTopicFragment.class, 1000);
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
    return 2131560134;
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
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    c();
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
      ors.a("0X800980A", this.jdField_a_of_type_Int, paramLong, "0");
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    a();
    oxb.a().a(this.jdField_a_of_type_Oxe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment
 * JD-Core Version:    0.7.0.1
 */