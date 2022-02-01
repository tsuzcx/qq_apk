package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.BaseViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;

public class CTEntryController
  extends BaseViewController
{
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected CTEntryController.OnCTEntryDataChangeListener a;
  protected QQAppInterface a;
  private StudyModeChangeListener a;
  protected AlphaClickableRelativeLayout a;
  protected XListView a;
  
  public CTEntryController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new CTEntryController.1(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131378239));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131376755));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376761));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131371101));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362224));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
  }
  
  public void a(CTEntryController.OnCTEntryDataChangeListener paramOnCTEntryDataChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener = paramOnCTEntryDataChangeListener;
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    boolean bool = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return !bool;
  }
  
  public void b()
  {
    super.b();
    StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
  }
  
  public void d()
  {
    super.d();
    StudyModeManager.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
  }
  
  public void d(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryController
 * JD-Core Version:    0.7.0.1
 */