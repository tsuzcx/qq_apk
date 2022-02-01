package com.tencent.mobileqq.activity;

import Override;
import QQService.DiscussMemberInfo;
import aeej;
import aeek;
import aeel;
import aeem;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antl;
import anvi;
import anvx;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private aeel jdField_a_of_type_Aeel;
  private aeem jdField_a_of_type_Aeem;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public antl a;
  private anvi jdField_a_of_type_Anvi = new aeek(this);
  public String a;
  public ArrayList<String> a;
  public List<DiscussMemberInfo> a;
  public int b;
  public long b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public String c = "";
  public String d;
  public String e = "";
  public String f = "";
  
  public JoinDiscussionActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365722));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365732));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365738));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365318));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369617));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366306));
  }
  
  private void c()
  {
    setTitle(anvx.a(2131705359));
    setRightButton(2131690697, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aeej(this));
  }
  
  private void d()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Antl.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_Antl.b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    a(0, -160);
  }
  
  private void e()
  {
    runOnUiThread(new JoinDiscussionActivity.3(this));
  }
  
  public void a()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_Antl.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    a(1, -160);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    stopTitleProgress();
    String str = "";
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = anvx.a(2131705357);
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = anvx.a(2131705351);
      continue;
      str = anvx.a(2131705355);
      continue;
      str = anvx.a(2131705353);
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = anvx.a(2131705354);
      continue;
      if (paramInt1 == 0) {
        str = anvx.a(2131705352);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559339);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Aeem = new aeem(this, null);
    this.jdField_a_of_type_Aeel = new aeel(this, null);
    addObserver(this.jdField_a_of_type_Aeem);
    addObserver(this.jdField_a_of_type_Aeel);
    addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Int = paramBundle.getInt("addDisSource");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("sig");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("innerSig");
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      paramBundle = this.jdField_b_of_type_JavaLangString.toUpperCase();
      if (this.jdField_b_of_type_JavaLangString.contains("?_wv=5")) {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("?_wv=5", "");
      }
      if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.endsWith("#flyticket"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.length() - "#flyticket".length());
    }
    b();
    c();
    this.jdField_a_of_type_Antl = ((antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Aeem);
    removeObserver(this.jdField_a_of_type_Aeel);
    removeObserver(this.jdField_a_of_type_Anvi);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771978);
  }
  
  public void onClick(View paramView)
  {
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */