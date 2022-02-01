package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import anni;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import pgg;
import pxs;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<pxs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private pgg jdField_a_of_type_Pgg;
  private List<pxs> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131369410));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Pgg = new pgg(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Pgg);
      setTitle(anni.a(2131711873));
      d();
    }
  }
  
  private void b()
  {
    pxs localpxs = new pxs();
    localpxs.jdField_b_of_type_JavaLangString = anni.a(2131711829);
    localpxs.jdField_a_of_type_JavaLangString = "open_reason";
    localpxs.c = ((String)bmqa.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bmqa.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpxs.d = anni.a(2131711569);
    }
    for (;;)
    {
      localpxs.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpxs.jdField_b_of_type_JavaUtilList.add("");
      localpxs.jdField_b_of_type_JavaUtilList.add(anni.a(2131711488));
      localpxs.jdField_b_of_type_JavaUtilList.add(anni.a(2131711506));
      localpxs.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpxs.jdField_a_of_type_JavaUtilList.add("");
      localpxs.jdField_a_of_type_JavaUtilList.add("1");
      localpxs.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpxs);
      return;
      if ("0".equals(str)) {
        localpxs.d = anni.a(2131711878);
      } else {
        localpxs.d = "";
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
            pxs localpxs = pxs.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpxs);
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
    this.jdField_a_of_type_Pgg.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131560138;
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
        localJSONArray.put(((pxs)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bmqa.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pxs)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pxs.a();
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