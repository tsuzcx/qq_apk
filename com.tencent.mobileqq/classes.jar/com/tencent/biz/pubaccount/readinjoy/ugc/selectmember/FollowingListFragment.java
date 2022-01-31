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
import bcpw;
import bfpc;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import osj;
import osm;
import osp;
import qbc;
import qgz;
import qhb;
import qhc;
import qhd;
import qhx;

public class FollowingListFragment
  extends Fragment
  implements bfpc, qgz<ObservableArrayList<ResultRecord>>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private List<HashMap<String, Object>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private osp jdField_a_of_type_Osp = new qhb(this);
  private qhc jdField_a_of_type_Qhc;
  private qhx jdField_a_of_type_Qhx;
  
  private void a()
  {
    a(osj.a().c());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131364193;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131367679;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131370647;
    tmp45_40;
    if ((this.jdField_a_of_type_Qhx != null) && (this.jdField_a_of_type_Qhx.a() == 1))
    {
      this.jdField_a_of_type_Qhc = new qhd(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560006, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_Qhc = new qhc(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560006, arrayOfString, arrayOfInt);
  }
  
  private void a(List<qbc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qbc localqbc = (qbc)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localqbc.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localqbc.a());
      localHashMap.put("key_head_url", localqbc.b());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(str, localqbc.a())))) {
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
  
  public void a(qhx paramqhx)
  {
    this.jdField_a_of_type_Qhx = paramqhx;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qhc != null) {
      this.jdField_a_of_type_Qhc.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qhc != null) {
      this.jdField_a_of_type_Qhc.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560005, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131369321);
    a();
    paramViewGroup.setAdapter(this.jdField_a_of_type_Qhc);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131167087);
    paramViewGroup.setOverScrollMode(0);
    osm.a().a(this.jdField_a_of_type_Osp);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    osm.a().b(this.jdField_a_of_type_Osp);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject = (CheckBox)paramView.findViewById(2131364193);
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
      if ((this.jdField_a_of_type_Qhx != null) && (this.jdField_a_of_type_Qhx.a() == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qhx.b()))
        {
          paramAdapterView = getActivity().getResources().getString(2131718554, new Object[] { String.valueOf(this.jdField_a_of_type_Qhx.c()) });
          bcpw.a(getActivity(), paramAdapterView, 0).a();
          return;
        }
        bcpw.a(getActivity(), getActivity().getResources().getString(2131718548), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */