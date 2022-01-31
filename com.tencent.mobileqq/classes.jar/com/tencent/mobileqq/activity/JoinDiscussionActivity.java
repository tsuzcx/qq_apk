package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import adal;
import adam;
import adan;
import adao;
import almt;
import alox;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdee;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private adan jdField_a_of_type_Adan;
  private adao jdField_a_of_type_Adao;
  public almt a;
  private alox jdField_a_of_type_Alox = new adam(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365312));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365325));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365331));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364921));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368973));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365871));
  }
  
  private void c()
  {
    setTitle(alpo.a(2131706258));
    setRightButton(2131690648, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new adal(this));
  }
  
  private void d()
  {
    if (bdee.d(this))
    {
      startTitleProgress();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Almt.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_Almt.b(this.jdField_b_of_type_JavaLangString);
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
    if (bdee.d(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_Almt.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        str = alpo.a(2131706256);
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = alpo.a(2131706250);
      continue;
      str = alpo.a(2131706254);
      continue;
      str = alpo.a(2131706252);
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = alpo.a(2131706253);
      continue;
      if (paramInt1 == 0) {
        str = alpo.a(2131706251);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559204);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Adao = new adao(this, null);
    this.jdField_a_of_type_Adan = new adan(this, null);
    addObserver(this.jdField_a_of_type_Adao);
    addObserver(this.jdField_a_of_type_Adan);
    addObserver(this.jdField_a_of_type_Alox);
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
    this.jdField_a_of_type_Almt = ((almt)this.app.a(6));
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Adao);
    removeObserver(this.jdField_a_of_type_Adan);
    removeObserver(this.jdField_a_of_type_Alox);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */