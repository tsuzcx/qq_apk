package com.tencent.av.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ChildGuideUi
{
  Resources jdField_a_of_type_AndroidContentResResources = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoControlUI jdField_a_of_type_ComTencentAvUiVideoControlUI;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  
  ChildGuideUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, VideoControlUI paramVideoControlUI, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "ChildGuideUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI = paramVideoControlUI;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "initUI");
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        ((AVActivity)localObject).getLayoutInflater().inflate(2131559683, this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_AndroidContentResResources = ((AVActivity)localObject).getResources();
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373365));
  }
  
  void a(View paramView)
  {
    if (paramView.getId() != 2131373365) {
      return;
    }
    b();
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  boolean b()
  {
    f();
    return true;
  }
  
  void c() {}
  
  boolean c()
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    boolean bool = false;
    Object localObject2 = ((BaseApplication)localObject1).getSharedPreferences("com.tencent.av.count", 0);
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    localObject1 = "DoubleVideoChildLock_ShowGuide";
    if (localVideoAppInterface != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DoubleVideoChildLock_ShowGuide");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((SharedPreferences)localObject2).getInt((String)localObject1, 0) == 0)
    {
      localObject2 = ((SharedPreferences)localObject2).edit();
      bool = true;
      ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1).commit();
    }
    return bool;
  }
  
  void d() {}
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidContentResResources == null) || (this.jdField_a_of_type_AndroidWidgetButton == null)) {
      a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.L();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.M();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ChildGuideUi
 * JD-Core Version:    0.7.0.1
 */