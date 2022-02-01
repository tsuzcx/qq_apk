package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.CancelDialogListener;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.participle.ParticipleObserver;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;

public class TextPreviewMenu
  extends CommonSelectableMenu<TextPreviewActivity>
{
  private int jdField_a_of_type_Int = -1;
  protected Dialog a;
  protected TextPreviewMenu.ProgressView a;
  private ParticipleObserver jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver = new TextPreviewMenu.2(this);
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = null;
  
  private int a(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1006) {
          if (paramInt != 3000)
          {
            if ((paramInt == 1020) || (paramInt == 1021)) {}
          }
          else {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    return -2;
                    return 4;
                  }
                  break;
                }
                break;
              }
              break;
            }
          }
        }
        return 3;
      }
      i = 2;
    }
    return i;
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    ECommerceDataReportUtil.a(paramQQAppInterface, paramMessageRecord, 2);
    try
    {
      MenuUtil.copy(a(), "TextPreview");
      if (paramBoolean)
      {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A356", "0X800A356", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F00", "0X8009F00", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TextPreviewMenu", 2, paramActivity.toString());
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localTextPreviewActivity != null) {
      localTextPreviewActivity.startActivityForResult(paramIntent, -1);
    }
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity)
  {
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.a(paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView);
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.setOnMenuClickListener(new TextPreviewMenu.1(this, paramTextPreviewActivity));
    paramTextPreviewActivity.j.setOnClickListener(this);
    paramTextPreviewActivity.k.setOnClickListener(this);
    paramTextPreviewActivity.l.setOnClickListener(this);
    paramTextPreviewActivity.m.setOnClickListener(this);
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextPreviewActivity.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(paramInt1, paramTextPreviewActivity.getResources());
    float f = paramInt2;
    localLayoutParams.leftMargin = AIOUtils.b(f, paramTextPreviewActivity.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(f, paramTextPreviewActivity.getResources());
    paramTextPreviewActivity.jdField_a_of_type_ComTencentWidgetScrollView.setLayoutParams(localLayoutParams);
    paramTextPreviewActivity.jdField_a_of_type_ComTencentWidgetScrollView.post(new TextPreviewMenu.3(this, paramTextPreviewActivity));
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setVisibility(8);
        localTextPreviewActivity.i.setVisibility(8);
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.setParticipleItems(paramList);
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.a();
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.b();
        a(localTextPreviewActivity, 60, 10);
      }
    }
    else
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131714681), 0).a();
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    localObject = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (!NetworkUtil.isNetSupport((Context)localObject))
      {
        QQToast.a((Context)localObject, HardCodeUtil.a(2131714671), 0).b(((TextPreviewActivity)localObject).getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((IParticipleApi)QRoute.api(IParticipleApi.class)).participleTheContent(((TextPreviewActivity)localObject).app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        d();
      }
    }
  }
  
  private void d()
  {
    Activity localActivity = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if (localDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(localActivity);
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(localActivity);
        if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
          this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new CancelDialogListener(localActivity));
      }
      else
      {
        localDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(HardCodeUtil.a(2131714682));
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void e()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      localDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void f()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localTextPreviewActivity != null)
    {
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.setVisibility(8);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.setVisibility(8);
      localTextPreviewActivity.i.setVisibility(0);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setVisibility(0);
      a(localTextPreviewActivity, 135, 20);
    }
  }
  
  public void a(TextPreviewActivity paramTextPreviewActivity, ContainerView paramContainerView)
  {
    super.a(paramTextPreviewActivity, paramContainerView);
    this.jdField_a_of_type_Int = paramTextPreviewActivity.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramTextPreviewActivity.c;
    this.jdField_a_of_type_Boolean = paramTextPreviewActivity.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Int = paramTextPreviewActivity.jdField_b_of_type_Int;
    a(paramTextPreviewActivity);
    paramTextPreviewActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131365311, HardCodeUtil.a(2131714676), 2130838903);
    paramQQCustomMenu.a(2131367180, HardCodeUtil.a(2131714674), 2130838912);
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if (i == 3000)
      {
        TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localTextPreviewActivity != null) && (localTextPreviewActivity.app != null) && (!this.jdField_b_of_type_JavaLangString.equals(localTextPreviewActivity.app.getCurrentAccountUin()))) {
          paramQQCustomMenu.a(2131376417, HardCodeUtil.a(2131714675), 2130838918);
        }
      }
    }
    else if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != -2)) {
      paramQQCustomMenu.a(2131376417, HardCodeUtil.a(2131714683), 2130838918);
    }
    paramQQCustomMenu.a(2131366494, HardCodeUtil.a(2131714677), 2130838911);
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    int i = a(this.jdField_b_of_type_Int);
    ReportController.b((AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "dc00898", "", "", "0X8009EFF", "0X8009EFF", i, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    boolean bool2 = false;
    boolean bool1 = false;
    if (localTextPreviewActivity != null)
    {
      if (localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.getVisibility() == 0) {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1)
      {
        f();
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void b(ContainerView paramContainerView)
  {
    super.b(paramContainerView);
    paramContainerView = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((paramContainerView != null) && (paramContainerView.app != null)) {
      paramContainerView.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver);
    }
    e();
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    MessageRecord localMessageRecord;
    if (localTextPreviewActivity == null) {
      localMessageRecord = null;
    } else {
      localMessageRecord = localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    }
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131377768: 
    case 2131377769: 
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.a(a());
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 5, 0, "", "", "", "");
      }
      break;
    case 2131377136: 
      AIOSelectableDelegateImpl.a().a(null);
      break;
    case 2131376417: 
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.setResult(14001, localTextPreviewActivity.getIntent());
        localTextPreviewActivity.finish();
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 4, 0, "", "", "", "");
      }
      break;
    case 2131367180: 
      ECommerceDataReportUtil.a(localQQAppInterface, localMessageRecord, 3);
      MenuUtil.a((Activity)paramView.getContext(), a());
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F01", "0X8009F01", 0, 0, "", "", "", "");
      break;
    case 2131367101: 
      if (localTextPreviewActivity != null) {
        localTextPreviewActivity.b();
      } else {
        QLog.e("TextPreviewMenu", 1, "activity is null, so activity.onClickFontSettingBtn not invoke");
      }
      break;
    case 2131367045: 
      c();
      if (localTextPreviewActivity != null) {
        ReportController.b(localTextPreviewActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 1, 0, "", "", "", "");
      } else {
        QLog.e("TextPreviewMenu", 1, "activity is null, so ReportController.reportClickEvent not invoke");
      }
      break;
    case 2131366494: 
      ECommerceDataReportUtil.a(localQQAppInterface, localMessageRecord, 4);
      if (localQQAppInterface != null) {
        MenuUtil.a((Activity)paramView.getContext(), localQQAppInterface, a());
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F02", "0X8009F02", 0, 0, "", "", "", "");
      break;
    case 2131365253: 
      bool = true;
    case 2131365311: 
      a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, bool);
    }
    if ((paramView.getId() != 2131377136) && (AIOSelectableDelegateImpl.a().c())) {
      AIOSelectableDelegateImpl.a().d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu
 * JD-Core Version:    0.7.0.1
 */