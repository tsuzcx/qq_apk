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
import bhuw;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import owy;
import oxb;
import oxe;
import qkw;
import qsm;
import qvd;
import qve;
import qvf;
import qvz;

public class FollowingListFragment
  extends Fragment
  implements bhuw, qsm<ObservableArrayList<ResultRecord>>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private List<HashMap<String, Object>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oxe jdField_a_of_type_Oxe = new qvd(this);
  private qve jdField_a_of_type_Qve;
  private qvz jdField_a_of_type_Qvz;
  
  private void a()
  {
    a(owy.a().c());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131364256;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131367819;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131370977;
    tmp45_40;
    if ((this.jdField_a_of_type_Qvz != null) && (this.jdField_a_of_type_Qvz.a() == 1))
    {
      this.jdField_a_of_type_Qve = new qvf(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560104, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_Qve = new qve(this, getActivity(), this.jdField_a_of_type_JavaUtilList, 2131560104, arrayOfString, arrayOfInt);
  }
  
  private void a(List<qkw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qkw localqkw = (qkw)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localqkw.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localqkw.a());
      localHashMap.put("key_head_url", localqkw.b());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(str, localqkw.a())))) {
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
  
  public void a(qvz paramqvz)
  {
    this.jdField_a_of_type_Qvz = paramqvz;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qve != null) {
      this.jdField_a_of_type_Qve.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qve != null) {
      this.jdField_a_of_type_Qve.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560103, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131369573);
    a();
    paramViewGroup.setAdapter(this.jdField_a_of_type_Qve);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131167140);
    paramViewGroup.setOverScrollMode(0);
    oxb.a().a(this.jdField_a_of_type_Oxe);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject = (CheckBox)paramView.findViewById(2131364256);
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
      if ((this.jdField_a_of_type_Qvz != null) && (this.jdField_a_of_type_Qvz.a() == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qvz.b()))
        {
          paramAdapterView = getActivity().getResources().getString(2131719026, new Object[] { String.valueOf(this.jdField_a_of_type_Qvz.c()) });
          QQToast.a(getActivity(), paramAdapterView, 0).a();
          return;
        }
        QQToast.a(getActivity(), getActivity().getResources().getString(2131719020), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */