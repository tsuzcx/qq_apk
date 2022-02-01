package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.utils.StudyRoomReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class StudyRoomTipsBar
  implements View.OnClickListener, TipsBarTask
{
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public StudyRoomTipsBar(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561081, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378617));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    int i = ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    if (i > 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719559, new Object[] { i + "" }));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("StudyRoomTipsBar", 4, "update. member count :" + i + " with troopUin:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 28;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131697207, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new HashMap();
      ((HashMap)localObject).put("groupId", this.jdField_a_of_type_JavaLangString);
      ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "enter", (HashMap)localObject);
      int i = ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
      localObject = new Bundle();
      ((Bundle)localObject).putString("action", "click");
      ((Bundle)localObject).putString("page", "group_page");
      ((Bundle)localObject).putString("module", "banner");
      ((Bundle)localObject).putString("entry_type", "1");
      ((Bundle)localObject).putString("study_number", "" + i);
      StudyRoomReporter.a((Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */