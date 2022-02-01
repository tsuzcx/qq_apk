package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import anzj;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import oyy;
import pqc;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<pqc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oyy jdField_a_of_type_Oyy;
  private List<pqc> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131369501));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Oyy = new oyy(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Oyy);
      setTitle(anzj.a(2131711982));
      d();
    }
  }
  
  private void b()
  {
    pqc localpqc = new pqc();
    localpqc.jdField_b_of_type_JavaLangString = anzj.a(2131711938);
    localpqc.jdField_a_of_type_JavaLangString = "open_reason";
    localpqc.c = ((String)bnrf.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bnrf.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpqc.d = anzj.a(2131711678);
    }
    for (;;)
    {
      localpqc.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpqc.jdField_b_of_type_JavaUtilList.add("");
      localpqc.jdField_b_of_type_JavaUtilList.add(anzj.a(2131711597));
      localpqc.jdField_b_of_type_JavaUtilList.add(anzj.a(2131711615));
      localpqc.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpqc.jdField_a_of_type_JavaUtilList.add("");
      localpqc.jdField_a_of_type_JavaUtilList.add("1");
      localpqc.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpqc);
      return;
      if ("0".equals(str)) {
        localpqc.d = anzj.a(2131711987);
      } else {
        localpqc.d = "";
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
            pqc localpqc = pqc.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpqc);
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
    this.jdField_a_of_type_Oyy.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131560150;
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
        localJSONArray.put(((pqc)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bnrf.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pqc)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pqc.a();
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