package com.tencent.mobileqq.activity.bless;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

public class BlessSendTextActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  protected RelativeLayout a;
  private BlessManager jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a(IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 2);
    }
  }
  
  private void b()
  {
    ((ImmersiveTitleBar2)findViewById(2131378881)).setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378784);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165357));
    findViewById(2131369233).setOnClickListener(this);
    findViewById(2131364447).setOnClickListener(this);
    findViewById(2131364053).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366076));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363331));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_a_of_type_JavaUtilArrayList.set(this.jdField_a_of_type_Int, str);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(1), "", "", "");
    finish();
    overridePendingTransition(2130772011, 2130772015);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558717);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    b();
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromoutweb", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSendTextActivity
 * JD-Core Version:    0.7.0.1
 */