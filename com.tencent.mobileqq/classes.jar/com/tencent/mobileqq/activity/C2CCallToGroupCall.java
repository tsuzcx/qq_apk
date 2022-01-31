package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import rrp;
import rrq;

public class C2CCallToGroupCall
  extends BaseActivity
  implements View.OnClickListener, ContactSearchResultPresenter.OnActionListener
{
  public int a;
  public Activity a;
  public Context a;
  public Intent a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  public QQAppInterface a;
  public QQProgressDialog a;
  public String a;
  Thread jdField_a_of_type_JavaLangThread = new rrq(this);
  public int b;
  public String b;
  private int c;
  public String c;
  public String d = "";
  public String e = "";
  
  public C2CCallToGroupCall()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new rrp(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.e = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramString4;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new ArrayList();
    paramString2.add(this.d);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3000, paramString1, true, true, true, null, paramString2, 1, this.jdField_b_of_type_Int);
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433967);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    this.jdField_a_of_type_JavaLangThread.setName("PhoneContactSelectActivity_addDiscussion");
    ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangThread, null, false);
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.C2CCallToGroupCall
 * JD-Core Version:    0.7.0.1
 */