package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import anzj;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import ozs;
import pfa;
import pfd;
import pfh;
import qza;
import raa;
import rbq;
import rbr;
import rbs;
import rbt;
import rbu;
import rbv;
import rbw;
import rbx;
import rcl;
import rel;

public class ReadInJoyUgcSearchTopicFragment
  extends PublicBaseFragment
  implements AdapterView.OnItemClickListener
{
  private static final String jdField_b_of_type_JavaLangString = anzj.a(2131711856);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new rbs(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private List<Map<String, CharSequence>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private pfh jdField_a_of_type_Pfh = new rbq(this);
  private rel jdField_a_of_type_Rel;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private List<TopicInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private pfh jdField_b_of_type_Pfh = new rbr(this);
  
  private static List<Map<String, CharSequence>> a(List<TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("key_cover_url", localTopicInfo.c());
      localHashMap.put("key_title", localTopicInfo.a());
      localHashMap.put("key_summary", localTopicInfo.b());
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  private Map<String, CharSequence> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_cover_url", "create_topic");
    localHashMap.put("key_title", "#" + this.jdField_a_of_type_JavaLangString);
    localHashMap.put("key_summary", jdField_b_of_type_JavaLangString);
    return localHashMap;
  }
  
  private void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetListView.getWindowToken(), 0);
    }
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new rbt(this));
  }
  
  private void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  private void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    if ((paramList1.size() > 0) && (paramList.size() > 0) && (TextUtils.equals((CharSequence)paramList.get(0), this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList1);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(a(paramList1));
      this.jdField_a_of_type_Rel.notifyDataSetChanged();
      ozs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilList, "0");
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    if (bnrf.k())
    {
      this.jdField_b_of_type_JavaUtilList.add(TopicInfo.a().a(true).b(this.jdField_a_of_type_Long).c("https://sqimg.qq.com/qq_product_operations/kan/images/topic-cover-default.jpg").d("https://sqimg.qq.com/qq_product_operations/kan/images/topic-head-default.jpg").b(jdField_b_of_type_JavaLangString).a(this.jdField_a_of_type_JavaLangString).a());
      this.jdField_a_of_type_JavaUtilList.add(a());
    }
    this.jdField_a_of_type_Rel.notifyDataSetChanged();
    ozs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilList, "1");
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  private void b(View paramView)
  {
    paramView.findViewById(2131364042).setOnClickListener(new rbu(this));
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramView.findViewById(2131370072));
    this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370054);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366048);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new rbv(this));
    this.jdField_a_of_type_Rel = new rel(getActivity(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rel.setViewBinder(new rbw(this));
    paramView = LayoutInflater.from(getActivity()).inflate(2131560288, this.jdField_a_of_type_AndroidWidgetListView, false);
    this.jdField_a_of_type_AndroidWidgetListView.addFooterView(paramView, null, false);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Rel);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131378430));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131717256);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new rbx(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyUgcSearchTopicFragment.9(this, paramInt, paramCharSequence));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772037, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = ozs.a();
    pfd.a().a(this.jdField_a_of_type_Pfh);
    pfd.a().a(this.jdField_b_of_type_Pfh);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560293, paramViewGroup, false);
    d(paramLayoutInflater);
    c(paramLayoutInflater);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.jdField_a_of_type_Int = paramViewGroup.getInt("searchTopicFrom");
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
    pfd.a().b(this.jdField_b_of_type_Pfh);
    super.onDestroyView();
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772040);
    super.onFinish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == paramInt) {}
    while (this.jdField_a_of_type_Boolean)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() == 1) {}
    for (TopicInfo localTopicInfo1 = (TopicInfo)this.jdField_b_of_type_JavaUtilList.get(0);; localTopicInfo1 = null)
    {
      if ((localTopicInfo1 != null) && (localTopicInfo1.a()))
      {
        this.jdField_a_of_type_Boolean = true;
        pfa.a().a(localTopicInfo1);
        break;
      }
      a((TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt));
      TopicInfo localTopicInfo2 = (TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if (localTopicInfo1 != null) {}
      for (long l = localTopicInfo2.a();; l = -1L)
      {
        ozs.a("0X800980A", this.jdField_a_of_type_Int, l, "0");
        raa.a(String.valueOf(l), "1");
        break;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    rcl.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment
 * JD-Core Version:    0.7.0.1
 */