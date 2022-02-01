package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private JoinDiscussionActivity.FaceObserver jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$FaceObserver;
  private JoinDiscussionActivity.MyDiscussionObserver jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$MyDiscussionObserver;
  DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new JoinDiscussionActivity.2(this);
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<DiscussMemberInfo> jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  String c = "";
  String d;
  String e = "";
  String f = "";
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365723));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365733));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365739));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365322));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369575));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366363));
  }
  
  private void c()
  {
    setTitle(HardCodeUtil.a(2131705954));
    setRightButton(2131690728, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new JoinDiscussionActivity.1(this));
  }
  
  private void d()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      String str = this.jdField_a_of_type_JavaLangString;
      if ((str != null) && (str.length() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.jdField_a_of_type_JavaLangString);
        return;
      }
      str = this.jdField_b_of_type_JavaLangString;
      if ((str != null) && (str.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.jdField_b_of_type_JavaLangString);
      }
    }
    else
    {
      a(0, -160);
    }
  }
  
  private void e()
  {
    runOnUiThread(new JoinDiscussionActivity.3(this));
  }
  
  void a()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    a(1, -160);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    stopTitleProgress();
    String str;
    if (paramInt2 != -160)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 4)
        {
          if (paramInt2 != 7)
          {
            if (paramInt2 != 8)
            {
              if (paramInt1 == 1) {
                str = HardCodeUtil.a(2131705952);
              } else if (paramInt1 == 0) {
                str = HardCodeUtil.a(2131705947);
              } else {
                str = "";
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
          }
          else {
            str = HardCodeUtil.a(2131705948);
          }
        }
        else {
          str = HardCodeUtil.a(2131705950);
        }
      }
      else {
        str = HardCodeUtil.a(2131705946);
      }
    }
    else {
      str = HardCodeUtil.a(2131705949);
    }
    QQToast.a(this, str, 0).b(getTitleBarHeight());
  }
  
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
    super.doOnCreate(paramBundle);
    super.setContentView(2131559279);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$MyDiscussionObserver = new JoinDiscussionActivity.MyDiscussionObserver(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$FaceObserver = new JoinDiscussionActivity.FaceObserver(this, null);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$MyDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$FaceObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Int = paramBundle.getInt("addDisSource");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("sig");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("innerSig");
    paramBundle = this.jdField_b_of_type_JavaLangString;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.toUpperCase();
      if (this.jdField_b_of_type_JavaLangString.contains("?_wv=5")) {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("?_wv=5", "");
      }
      if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
    }
    paramBundle = this.jdField_a_of_type_JavaLangString;
    if ((paramBundle != null) && (paramBundle.endsWith("#flyticket")))
    {
      paramBundle = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = paramBundle.substring(0, paramBundle.length() - 10);
    }
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$MyDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$FaceObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771992);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */