package com.tencent.biz.pubaccount.readinjoy.fragment;

import ajya;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import omn;
import org.json.JSONArray;
import org.json.JSONException;
import pay;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyDailySettingFragment";
  private List<pay> jdField_a_of_type_JavaUtilList = new ArrayList();
  private omn jdField_a_of_type_Omn;
  private List<pay> b;
  
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
      this.jdField_a_of_type_Omn = new omn(getActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Omn);
      setTitle(ajya.a(2131713110));
      d();
    }
  }
  
  private void b()
  {
    pay localpay = new pay();
    localpay.jdField_b_of_type_JavaLangString = ajya.a(2131713066);
    localpay.jdField_a_of_type_JavaLangString = "open_reason";
    localpay.c = ((String)bhvy.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)bhvy.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localpay.d = ajya.a(2131712806);
    }
    for (;;)
    {
      localpay.jdField_b_of_type_JavaUtilList = new ArrayList();
      localpay.jdField_b_of_type_JavaUtilList.add("");
      localpay.jdField_b_of_type_JavaUtilList.add(ajya.a(2131712725));
      localpay.jdField_b_of_type_JavaUtilList.add(ajya.a(2131712743));
      localpay.jdField_a_of_type_JavaUtilList = new ArrayList();
      localpay.jdField_a_of_type_JavaUtilList.add("");
      localpay.jdField_a_of_type_JavaUtilList.add("1");
      localpay.jdField_a_of_type_JavaUtilList.add("0");
      this.jdField_b_of_type_JavaUtilList.add(localpay);
      return;
      if ("0".equals(str)) {
        localpay.d = ajya.a(2131713115);
      } else {
        localpay.d = "";
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
            pay localpay = pay.a(((JSONArray)localObject).optJSONObject(i));
            this.jdField_a_of_type_JavaUtilList.add(localpay);
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
    this.jdField_a_of_type_Omn.notifyDataSetChanged();
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
        localJSONArray.put(((pay)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      bhvy.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((pay)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    pay.a();
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