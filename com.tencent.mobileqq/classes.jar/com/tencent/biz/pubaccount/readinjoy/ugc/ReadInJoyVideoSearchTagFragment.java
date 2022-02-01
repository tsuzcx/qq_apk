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
import pfd;
import pfh;
import rby;
import rbz;
import rca;
import rcb;
import rcc;
import rcd;
import rcl;

public class ReadInJoyVideoSearchTagFragment
  extends PublicBaseFragment
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new rbz(this);
  private ArrayAdapter<TagInfo> jdField_a_of_type_AndroidWidgetArrayAdapter;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  pfh jdField_a_of_type_Pfh = new rby(this);
  
  private void a()
  {
    getView().setOnClickListener(new rca(this));
  }
  
  private void b()
  {
    getView().findViewById(2131364042).setOnClickListener(new rcb(this));
  }
  
  private void c()
  {
    ListView localListView = (ListView)getView().findViewById(2131370072);
    View localView = new View(getActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.jdField_a_of_type_AndroidWidgetArrayAdapter = new ArrayAdapter(getActivity(), 2131560294, new ArrayList());
    localListView.setAdapter(this.jdField_a_of_type_AndroidWidgetArrayAdapter);
    localListView.setOnItemClickListener(new rcc(this, getActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getView().findViewById(2131378430));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new rcd(this));
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
    paramActivity.overridePendingTransition(2130772037, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560293, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pfd.a().b(this.jdField_a_of_type_Pfh);
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772039);
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    rcl.a(this);
    d();
    c();
    b();
    a();
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */