package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import ptj;
import pvm;
import pvq;
import rvk;
import rvl;
import rvm;
import rvn;
import rvo;
import rvp;
import rvy;

public class ReadInJoyVideoSearchTagFragment
  extends PublicBaseFragment
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new rvl(this);
  private ArrayAdapter<TagInfo> jdField_a_of_type_AndroidWidgetArrayAdapter;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  pvq jdField_a_of_type_Pvq = new rvk(this);
  
  private void a()
  {
    getView().setOnClickListener(new rvm(this));
  }
  
  private void b()
  {
    getView().findViewById(2131364141).setOnClickListener(new rvn(this));
  }
  
  private void c()
  {
    ListView localListView = (ListView)getView().findViewById(2131370241);
    View localView = new View(getActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.jdField_a_of_type_AndroidWidgetArrayAdapter = new ArrayAdapter(getActivity(), 2131560347, new ArrayList());
    localListView.setAdapter(this.jdField_a_of_type_AndroidWidgetArrayAdapter);
    localListView.setOnItemClickListener(new rvo(this, getActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getView().findViewById(2131378485));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new rvp(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772039, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ptj.a.a(getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(2131560346, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772041);
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    rvy.a(this);
    d();
    c();
    b();
    a();
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */