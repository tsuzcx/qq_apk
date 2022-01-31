package com.tencent.biz.pubaccount.readinjoy.fragment;

import ajjy;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import obf;
import oqa;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyDailySettingFragment";
  private List<oqa> jdField_a_of_type_JavaUtilList = new ArrayList();
  private obf jdField_a_of_type_Obf;
  private List<oqa> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131303148));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_Obf = new obf(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Obf);
      setTitle(ajjy.a(2131647311));
      d();
    }
  }
  
  private void b()
  {
    oqa localoqa = new oqa();
    localoqa.jdField_b_of_type_JavaLangString = ajjy.a(2131647267);
    localoqa.jdField_a_of_type_JavaLangString = "open_reason";
    localoqa.c = ((String)bgmq.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bgmq.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localoqa.d = ajjy.a(2131647007);
    }
    for (;;)
    {
      localoqa.jdField_b_of_type_JavaUtilList = new ArrayList();
      localoqa.jdField_b_of_type_JavaUtilList.add("");
      localoqa.jdField_b_of_type_JavaUtilList.add(ajjy.a(2131646926));
      localoqa.jdField_b_of_type_JavaUtilList.add(ajjy.a(2131646944));
      localoqa.jdField_a_of_type_JavaUtilList = new ArrayList();
      localoqa.jdField_a_of_type_JavaUtilList.add("");
      localoqa.jdField_a_of_type_JavaUtilList.add("1");
      localoqa.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localoqa);
      return;
      if ("0".equals(str)) {
        localoqa.d = ajjy.a(2131647316);
      } else {
        localoqa.d = "";
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
            oqa localoqa = oqa.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localoqa);
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
    this.jdField_a_of_type_Obf.notifyDataSetChanged();
  }
  
  public int getContentLayoutId()
  {
    return 2131494326;
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
        localJSONArray.put(((oqa)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bgmq.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((oqa)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    oqa.a();
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