package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import aazs;
import aazt;
import aazu;
import aazv;
import ajhf;
import ajjh;
import ajjy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import badq;
import bbmy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private aazu jdField_a_of_type_Aazu;
  private aazv jdField_a_of_type_Aazv;
  public ajhf a;
  private ajjh jdField_a_of_type_Ajjh = new aazt(this);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299660));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299673));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299679));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299273));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131303114));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300186));
  }
  
  private void c()
  {
    setTitle(ajjy.a(2131640090));
    setRightButton(2131625035, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aazs(this));
  }
  
  private void d()
  {
    if (badq.d(this))
    {
      startTitleProgress();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Ajhf.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_Ajhf.b(this.jdField_b_of_type_JavaLangString);
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
    if (badq.d(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_Ajhf.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        str = ajjy.a(2131640088);
      }
      break;
    }
    for (;;)
    {
      bbmy.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = ajjy.a(2131640082);
      continue;
      str = ajjy.a(2131640086);
      continue;
      str = ajjy.a(2131640084);
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = ajjy.a(2131640085);
      continue;
      if (paramInt1 == 0) {
        str = ajjy.a(2131640083);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131493592);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Aazv = new aazv(this, null);
    this.jdField_a_of_type_Aazu = new aazu(this, null);
    addObserver(this.jdField_a_of_type_Aazv);
    addObserver(this.jdField_a_of_type_Aazu);
    addObserver(this.jdField_a_of_type_Ajjh);
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
    this.jdField_a_of_type_Ajhf = ((ajhf)this.app.a(6));
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Aazv);
    removeObserver(this.jdField_a_of_type_Aazu);
    removeObserver(this.jdField_a_of_type_Ajjh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */