package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import ssq;
import ssr;
import sss;
import sst;
import ssw;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public DiscussionHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ssr(this);
  public String a;
  public ArrayList a;
  public List a;
  private sst jdField_a_of_type_Sst;
  private ssw jdField_a_of_type_Ssw;
  public int b;
  public long b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364793));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364794));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364795));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364796));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364797));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364799));
  }
  
  private void c()
  {
    setTitle("加入多人聊天");
    setRightButton(2131432998, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ssq(this));
  }
  
  private void d()
  {
    if (NetworkUtil.d(this))
    {
      startTitleProgress();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    a(0, -160);
  }
  
  private void e()
  {
    runOnUiThread(new sss(this));
  }
  
  public void a()
  {
    if (NetworkUtil.d(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        str = "加入多人聊天失败，请稍后重试";
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = "多人聊天不存在";
      continue;
      str = "多人聊天人数已达上限";
      continue;
      str = "非法多人聊天链接";
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = "网络错误，请稍后重试";
      continue;
      if (paramInt1 == 0) {
        str = "获取多人聊天信息失败，请稍后重试";
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969035);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Ssw = new ssw(this, null);
    this.jdField_a_of_type_Sst = new sst(this, null);
    addObserver(this.jdField_a_of_type_Ssw);
    addObserver(this.jdField_a_of_type_Sst);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ssw);
    removeObserver(this.jdField_a_of_type_Sst);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034122);
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