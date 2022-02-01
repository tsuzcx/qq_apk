package com.tencent.mobileqq.activity.qwallet.fragment;

import alau;
import alcg;
import alcv;
import alcw;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import anzj;
import bmrq;
import bmrx;
import bmry;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.text.DecimalFormat;
import java.util.List;
import nkr;

public abstract class BaseHbUIFragment
  extends BaseHbFragment
{
  protected TextWatcher a;
  public View a;
  protected Button a;
  protected EditText a;
  public bmry a;
  private DecimalFormat a;
  public nkr a;
  protected EditText b;
  public EditText c;
  
  public BaseHbUIFragment()
  {
    this.jdField_a_of_type_Bmry = new bmry();
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
    this.jdField_a_of_type_AndroidTextTextWatcher = new alau(this);
  }
  
  protected float a()
  {
    return bmrq.a(this.b.getText().toString());
  }
  
  public abstract int a();
  
  protected abstract String a();
  
  protected void a()
  {
    this.c.setHint(alcg.a(this.channel, this.jdField_a_of_type_Bmry, this.mActivity.a(), a()));
    b();
  }
  
  protected void a(Bundle paramBundle)
  {
    bmrx.a(paramBundle, this.jdField_a_of_type_Bmry);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371992));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new alcw(this.jdField_a_of_type_AndroidWidgetEditText));
    this.b = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131362668));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.b.addTextChangedListener(new alcv(this.b));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364956));
    this.c = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131370703));
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbUIFragment", 2, "bundleInfo: " + this.jdField_a_of_type_Bmry);
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    float f = a();
    if ((bmrq.a(str, 0) <= 0) || (f <= 0.0F))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131696112));
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(anzj.a(2131699917), new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(f) }));
    return true;
  }
  
  protected String b()
  {
    return alcg.a(this.c);
  }
  
  protected void b()
  {
    QLog.i("BaseHbUIFragment", 2, "recv_type: " + this.jdField_a_of_type_Bmry.recv_type);
    if (bmrx.b.contains(this.jdField_a_of_type_Bmry.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      ((View)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bmry.people_num)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(anzj.a(2131699916) + this.jdField_a_of_type_Bmry.people_num + anzj.a(2131699918));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  protected boolean b()
  {
    if (bmrq.a()) {
      return false;
    }
    if (bmrq.a(this.b.getText().toString()) <= 0.0F)
    {
      QLog.d("BaseHbUIFragment", 2, "amount error, no input!");
      return false;
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.i("BaseHbUIFragment", 2, "oncreate view enter...");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), null);
    a(getArguments());
    a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */