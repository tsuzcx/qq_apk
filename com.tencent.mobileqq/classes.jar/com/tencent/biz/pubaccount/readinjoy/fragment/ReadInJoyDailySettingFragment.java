package com.tencent.biz.pubaccount.readinjoy.fragment;

import ajyc;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import omq;
import org.json.JSONArray;
import org.json.JSONException;
import pbb;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyDailySettingFragment";
  private List<pbb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private omq jdField_a_of_type_Omq;
  private List<pbb> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131368788));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Omq = new omq(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Omq);
      setTitle(ajyc.a(2131713099));
      d();
    }
  }
  
  private void b()
  {
    pbb localpbb = new pbb();
    localpbb.jdField_b_of_type_JavaLangString = ajyc.a(2131713055);
    localpbb.jdField_a_of_type_JavaLangString = "open_reason";
    localpbb.c = ((String)bhvh.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bhvh.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpbb.d = ajyc.a(2131712795);
    }
    for (;;)
    {
      localpbb.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpbb.jdField_b_of_type_JavaUtilList.add("");
      localpbb.jdField_b_of_type_JavaUtilList.add(ajyc.a(2131712714));
      localpbb.jdField_b_of_type_JavaUtilList.add(ajyc.a(2131712732));
      localpbb.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpbb.jdField_a_of_type_JavaUtilList.add("");
      localpbb.jdField_a_of_type_JavaUtilList.add("1");
      localpbb.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpbb);
      return;
      if ("0".equals(str)) {
        localpbb.d = ajyc.a(2131713104);
      } else {
        localpbb.d = "";
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
            pbb localpbb = pbb.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpbb);
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
    this.jdField_a_of_type_Omq.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131559897;
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
        localJSONArray.put(((pbb)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bhvh.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pbb)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pbb.a();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */