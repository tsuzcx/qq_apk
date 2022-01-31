package com.tencent.mobileqq.activity.bless;

import agyc;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import azmj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

public class BlessSendTextActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  private agyc jdField_a_of_type_Agyc;
  View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  protected RelativeLayout a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 2);
    }
  }
  
  private void b()
  {
    ((ImmersiveTitleBar2)findViewById(2131377976)).setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377884);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165341));
    findViewById(2131368644).setOnClickListener(this);
    findViewById(2131364099).setOnClickListener(this);
    findViewById(2131363703).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365600));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363017));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_a_of_type_JavaUtilArrayList.set(this.jdField_a_of_type_Int, str);
      this.jdField_a_of_type_Agyc.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a()
  {
    azmj.b(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(1), "", "", "");
    finish();
    overridePendingTransition(2130771997, 2130772001);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558681);
    this.jdField_a_of_type_Agyc = ((agyc)this.app.getManager(138));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Agyc.b();
    b();
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromoutweb", false);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131364099: 
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
      c();
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {}
      for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int += 1)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
        return;
      }
    case 2131363703: 
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (paramView.equals(""))
      {
        QQToast.a(this, 2131690548, 1).a();
        return;
      }
      c();
      Intent localIntent = new Intent(this, BlessSelectMemberActivity.class);
      localIntent.putExtra("param_type", 9003);
      localIntent.putExtra("param_entrance", 15);
      localIntent.putExtra("param_only_friends", true);
      localIntent.putExtra("param_donot_need_contacts", true);
      localIntent.putExtra("param_title", getString(2131690565));
      localIntent.putExtra("param_done_button_wording", getString(2131691088));
      localIntent.putExtra("param_exit_animation", 1);
      localIntent.putExtra("param_blesstype", 1);
      localIntent.putExtra("param_blessword_content", paramView);
      startActivity(localIntent);
      overridePendingTransition(2130771992, 2130771993);
      paramView = this.app;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        azmj.b(paramView, "CliOper", "", "", "0X800618C", "0X800618C", i, 0, "", "", "", "");
        return;
        i = 0;
      }
    case 2131363017: 
      a(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken());
      return;
    }
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSendTextActivity
 * JD-Core Version:    0.7.0.1
 */