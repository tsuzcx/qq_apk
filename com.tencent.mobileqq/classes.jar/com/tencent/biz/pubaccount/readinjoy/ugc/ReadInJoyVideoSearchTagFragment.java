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
import java.util.ArrayList;
import osj;
import osm;
import qgb;
import qgc;
import qgd;
import qge;
import qgf;
import qgg;
import qgo;

public class ReadInJoyVideoSearchTagFragment
  extends PublicBaseFragment
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new qgc(this);
  private ArrayAdapter<TagInfo> jdField_a_of_type_AndroidWidgetArrayAdapter;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  osm jdField_a_of_type_Osm = new qgb(this);
  
  private void a()
  {
    getView().setOnClickListener(new qgd(this));
  }
  
  private void b()
  {
    getView().findViewById(2131363752).setOnClickListener(new qge(this));
  }
  
  private void c()
  {
    ListView localListView = (ListView)getView().findViewById(2131369324);
    View localView = new View(getActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.jdField_a_of_type_AndroidWidgetArrayAdapter = new ArrayAdapter(getActivity(), 2131560038, new ArrayList());
    localListView.setAdapter(this.jdField_a_of_type_AndroidWidgetArrayAdapter);
    localListView.setOnItemClickListener(new qgf(this, getActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getView().findViewById(2131376875));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new qgg(this));
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
    paramActivity.overridePendingTransition(2130772036, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131560037, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    osj.a().b(this.jdField_a_of_type_Osm);
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772038);
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    qgo.a(this);
    d();
    c();
    b();
    a();
    osj.a().a(this.jdField_a_of_type_Osm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */