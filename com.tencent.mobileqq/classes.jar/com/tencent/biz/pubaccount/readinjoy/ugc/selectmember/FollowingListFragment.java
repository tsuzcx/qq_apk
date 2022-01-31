package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import bbmy;
import behi;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ogy;
import ohb;
import ohe;
import ppg;
import pvb;
import pvd;
import pve;
import pvf;
import pvz;

public class FollowingListFragment
  extends Fragment
  implements behi, pvb<ObservableArrayList<ResultRecord>>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private List<HashMap<String, Object>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ohe jdField_a_of_type_Ohe = new pvd(this);
  private pve jdField_a_of_type_Pve;
  private pvz jdField_a_of_type_Pvz;
  
  private void a()
  {
    a(ogy.a().c());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131298635;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131302061;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131304981;
    tmp45_40;
    if ((this.jdField_a_of_type_Pvz != null) && (this.jdField_a_of_type_Pvz.a() == 1))
    {
      this.jdField_a_of_type_Pve = new pvf(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131494440, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_Pve = new pve(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131494440, arrayOfString, arrayOfInt);
  }
  
  private void a(List<ppg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ppg localppg = (ppg)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localppg.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localppg.a());
      localHashMap.put("key_head_url", localppg.b());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(str, localppg.a())))) {
        localHashMap.put("key_checked", Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilList.add(localHashMap);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(pvz parampvz)
  {
    this.jdField_a_of_type_Pvz = parampvz;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pve != null) {
      this.jdField_a_of_type_Pve.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pve != null) {
      this.jdField_a_of_type_Pve.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131494439, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131303651);
    a();
    paramViewGroup.setAdapter(this.jdField_a_of_type_Pve);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131101491);
    paramViewGroup.setOverScrollMode(0);
    ohb.a().a(this.jdField_a_of_type_Ohe);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ohb.a().b(this.jdField_a_of_type_Ohe);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject = (CheckBox)paramView.findViewById(2131298635);
    if (((CheckBox)localObject).isEnabled()) {
      if (!((CheckBox)localObject).isChecked())
      {
        paramAdapterView = Boolean.valueOf(bool);
        ((CheckBox)localObject).setChecked(paramAdapterView.booleanValue());
        localObject = (Map)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((Map)localObject).put("key_checked", paramAdapterView);
        localObject = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"), 2);
        if (!paramAdapterView.booleanValue()) {
          break label142;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      }
      return;
      bool = false;
      break;
      label142:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.remove(localObject);
      continue;
      if ((this.jdField_a_of_type_Pvz != null) && (this.jdField_a_of_type_Pvz.a() == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Pvz.b()))
        {
          paramAdapterView = getActivity().getResources().getString(2131652730, new Object[] { String.valueOf(this.jdField_a_of_type_Pvz.c()) });
          bbmy.a(getActivity(), paramAdapterView, 0).a();
          return;
        }
        bbmy.a(getActivity(), getActivity().getResources().getString(2131652724), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */