package com.tencent.mobileqq.activity.qwallet.fragment;

import agzj;
import aham;
import ahay;
import ahaz;
import ajya;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import bgxb;
import bgxi;
import bgxj;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.List;

public abstract class BaseHbUIFragment
  extends BaseHbFragment
{
  protected TextWatcher a;
  public View a;
  protected Button a;
  protected EditText a;
  public bgxj a;
  private DecimalFormat a;
  protected EditText b;
  public EditText c;
  
  public BaseHbUIFragment()
  {
    this.jdField_a_of_type_Bgxj = new bgxj();
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
    this.jdField_a_of_type_AndroidTextTextWatcher = new agzj(this);
  }
  
  protected float a()
  {
    return bgxb.a(this.b.getText().toString());
  }
  
  public abstract int a();
  
  protected abstract String a();
  
  protected void a()
  {
    this.c.setHint(aham.a(this.channel, this.jdField_a_of_type_Bgxj, this.mActivity.a(), a()));
    b();
  }
  
  protected void a(Bundle paramBundle)
  {
    bgxi.a(paramBundle, this.jdField_a_of_type_Bgxj);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131370982));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ahaz(this.jdField_a_of_type_AndroidWidgetEditText));
    this.b = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131362529));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.b.addTextChangedListener(new ahay(this.b));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364610));
    this.c = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131369875));
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbUIFragment", 2, "bundleInfo: " + this.jdField_a_of_type_Bgxj);
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    float f = a();
    if ((bgxb.a(str, 0) <= 0) || (f <= 0.0F))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697063));
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(ajya.a(2131701005), new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(f) }));
    return true;
  }
  
  protected String b()
  {
    return aham.a(this.c);
  }
  
  protected void b()
  {
    QLog.i("BaseHbUIFragment", 2, "recv_type: " + this.jdField_a_of_type_Bgxj.recv_type);
    if (bgxi.b.contains(this.jdField_a_of_type_Bgxj.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      ((View)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bgxj.people_num)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(ajya.a(2131701004) + this.jdField_a_of_type_Bgxj.people_num + ajya.a(2131701006));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  protected boolean b()
  {
    if (bgxb.a()) {
      return false;
    }
    if (bgxb.a(this.b.getText().toString()) <= 0.0F)
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
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */