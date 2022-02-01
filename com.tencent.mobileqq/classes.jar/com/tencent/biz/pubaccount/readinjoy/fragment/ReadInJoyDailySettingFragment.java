package com.tencent.biz.pubaccount.readinjoy.fragment;

import amtj;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import pae;
import pim;
import pvw;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<pvw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private pae jdField_a_of_type_Pae;
  private List<pvw> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131369485));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Pae = new pae(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Pae);
      setTitle(amtj.a(2131712214));
      d();
    }
  }
  
  private void b()
  {
    pvw localpvw = new pvw();
    localpvw.jdField_b_of_type_JavaLangString = amtj.a(2131712170);
    localpvw.jdField_a_of_type_JavaLangString = "open_reason";
    localpvw.c = ((String)bkwm.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bkwm.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpvw.d = amtj.a(2131711910);
    }
    for (;;)
    {
      localpvw.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpvw.jdField_b_of_type_JavaUtilList.add("");
      localpvw.jdField_b_of_type_JavaUtilList.add(amtj.a(2131711829));
      localpvw.jdField_b_of_type_JavaUtilList.add(amtj.a(2131711847));
      localpvw.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpvw.jdField_a_of_type_JavaUtilList.add("");
      localpvw.jdField_a_of_type_JavaUtilList.add("1");
      localpvw.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpvw);
      return;
      if ("0".equals(str)) {
        localpvw.d = amtj.a(2131712219);
      } else {
        localpvw.d = "";
      }
    }
  }
  
  private void c()
  {
    Object localObject = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            pvw localpvw = pvw.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpvw);
            i += 1;
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    b();
    c();
    this.jdField_a_of_type_Pae.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131560157;
  }
  
  public void onDestroy()
  {
    int j = 0;
    JSONArray localJSONArray;
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pvw)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bkwm.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pvw)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pvw.a();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    pim.a.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */