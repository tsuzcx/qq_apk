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
import bcql;
import bfpt;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import osg;
import osj;
import osm;
import qaz;
import qgw;
import qgy;
import qgz;
import qha;
import qhu;

public class FollowingListFragment
  extends Fragment
  implements bfpt, qgw<ObservableArrayList<ResultRecord>>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private List<HashMap<String, Object>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private osm jdField_a_of_type_Osm = new qgy(this);
  private qgz jdField_a_of_type_Qgz;
  private qhu jdField_a_of_type_Qhu;
  
  private void a()
  {
    a(osg.a().c());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131364192;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131367679;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131370647;
    tmp45_40;
    if ((this.jdField_a_of_type_Qhu != null) && (this.jdField_a_of_type_Qhu.a() == 1))
    {
      this.jdField_a_of_type_Qgz = new qha(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560006, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_Qgz = new qgz(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560006, arrayOfString, arrayOfInt);
  }
  
  private void a(List<qaz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qaz localqaz = (qaz)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localqaz.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localqaz.a());
      localHashMap.put("key_head_url", localqaz.b());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(str, localqaz.a())))) {
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
  
  public void a(qhu paramqhu)
  {
    this.jdField_a_of_type_Qhu = paramqhu;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qgz != null) {
      this.jdField_a_of_type_Qgz.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qgz != null) {
      this.jdField_a_of_type_Qgz.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560005, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131369321);
    a();
    paramViewGroup.setAdapter(this.jdField_a_of_type_Qgz);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131167087);
    paramViewGroup.setOverScrollMode(0);
    osj.a().a(this.jdField_a_of_type_Osm);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    osj.a().b(this.jdField_a_of_type_Osm);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject = (CheckBox)paramView.findViewById(2131364192);
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
      if ((this.jdField_a_of_type_Qhu != null) && (this.jdField_a_of_type_Qhu.a() == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qhu.b()))
        {
          paramAdapterView = getActivity().getResources().getString(2131718565, new Object[] { String.valueOf(this.jdField_a_of_type_Qhu.c()) });
          bcql.a(getActivity(), paramAdapterView, 0).a();
          return;
        }
        bcql.a(getActivity(), getActivity().getResources().getString(2131718559), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */