package com.tencent.mobileqq.activity.qwallet.fragment;

import aitj;
import aiuo;
import aivc;
import aivd;
import alpo;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import bixy;
import biyf;
import biyg;
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
  public biyg a;
  private DecimalFormat a;
  protected EditText b;
  public EditText c;
  
  public BaseHbUIFragment()
  {
    this.jdField_a_of_type_Biyg = new biyg();
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
    this.jdField_a_of_type_AndroidTextTextWatcher = new aitj(this);
  }
  
  protected float a()
  {
    return bixy.a(this.b.getText().toString());
  }
  
  public abstract int a();
  
  protected abstract String a();
  
  protected void a()
  {
    this.c.setHint(aiuo.a(this.channel, this.jdField_a_of_type_Biyg, this.mActivity.a(), a()));
    b();
  }
  
  protected void a(Bundle paramBundle)
  {
    biyf.a(paramBundle, this.jdField_a_of_type_Biyg);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371293));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aivd(this.jdField_a_of_type_AndroidWidgetEditText));
    this.b = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131362556));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.b.addTextChangedListener(new aivc(this.b));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364688));
    this.c = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131370139));
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbUIFragment", 2, "bundleInfo: " + this.jdField_a_of_type_Biyg);
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    float f = a();
    if ((bixy.a(str, 0) <= 0) || (f <= 0.0F))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697238));
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(alpo.a(2131701374), new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(f) }));
    return true;
  }
  
  protected String b()
  {
    return aiuo.a(this.c);
  }
  
  protected void b()
  {
    QLog.i("BaseHbUIFragment", 2, "recv_type: " + this.jdField_a_of_type_Biyg.recv_type);
    if (biyf.b.contains(this.jdField_a_of_type_Biyg.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      ((View)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Biyg.people_num)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131701373) + this.jdField_a_of_type_Biyg.people_num + alpo.a(2131701375));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  protected boolean b()
  {
    if (bixy.a()) {
      return false;
    }
    if (bixy.a(this.b.getText().toString()) <= 0.0F)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */