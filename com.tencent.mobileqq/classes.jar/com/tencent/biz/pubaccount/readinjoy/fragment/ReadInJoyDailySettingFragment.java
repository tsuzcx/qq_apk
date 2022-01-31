package com.tencent.biz.pubaccount.readinjoy.fragment;

import alpo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import oqy;
import org.json.JSONArray;
import org.json.JSONException;
import pgj;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyDailySettingFragment";
  private List<pgj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oqy jdField_a_of_type_Oqy;
  private List<pgj> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131369007));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Oqy = new oqy(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Oqy);
      setTitle(alpo.a(2131713482));
      d();
    }
  }
  
  private void b()
  {
    pgj localpgj = new pgj();
    localpgj.jdField_b_of_type_JavaLangString = alpo.a(2131713438);
    localpgj.jdField_a_of_type_JavaLangString = "open_reason";
    localpgj.c = ((String)bjxj.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bjxj.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpgj.d = alpo.a(2131713178);
    }
    for (;;)
    {
      localpgj.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpgj.jdField_b_of_type_JavaUtilList.add("");
      localpgj.jdField_b_of_type_JavaUtilList.add(alpo.a(2131713097));
      localpgj.jdField_b_of_type_JavaUtilList.add(alpo.a(2131713115));
      localpgj.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpgj.jdField_a_of_type_JavaUtilList.add("");
      localpgj.jdField_a_of_type_JavaUtilList.add("1");
      localpgj.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpgj);
      return;
      if ("0".equals(str)) {
        localpgj.d = alpo.a(2131713487);
      } else {
        localpgj.d = "";
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
            pgj localpgj = pgj.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpgj);
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
    this.jdField_a_of_type_Oqy.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131559993;
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
        localJSONArray.put(((pgj)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bjxj.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pgj)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pgj.a();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */