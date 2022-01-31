package com.tencent.mobileqq.activity.selectable;

import actj;
import adfy;
import aibn;
import aibx;
import aich;
import aici;
import aicj;
import ajya;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import axqy;
import ayle;
import aylf;
import aylg;
import bbfj;
import bbmf;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.List;

public class TextPreviewMenu
  extends aibx<TextPreviewActivity>
{
  private int jdField_a_of_type_Int = -1;
  protected Dialog a;
  private aylg jdField_a_of_type_Aylg = new aici(this);
  protected TextPreviewMenu.ProgressView a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -2;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 4;
    }
    return 3;
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
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
    paramTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new aich(this, paramTextPreviewActivity));
    paramTextPreviewActivity.j.setOnClickListener(this);
    paramTextPreviewActivity.k.setOnClickListener(this);
    paramTextPreviewActivity.l.setOnClickListener(this);
    paramTextPreviewActivity.m.setOnClickListener(this);
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextPreviewActivity.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
    localLayoutParams.bottomMargin = actj.a(paramInt1, paramTextPreviewActivity.getResources());
    localLayoutParams.leftMargin = actj.a(paramInt2, paramTextPreviewActivity.getResources());
    localLayoutParams.rightMargin = actj.a(paramInt2, paramTextPreviewActivity.getResources());
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
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setParticipleItems(paramList);
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.a();
        localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.b();
        a(localTextPreviewActivity, 60, 10);
      }
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131714884), 0).a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    TextPreviewActivity localTextPreviewActivity;
    do
    {
      do
      {
        return;
        localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      } while (localTextPreviewActivity == null);
      if (!bbfj.d(localTextPreviewActivity))
      {
        bcql.a(localTextPreviewActivity, ajya.a(2131714874), 0).b(localTextPreviewActivity.getResources().getDimensionPixelSize(2131298865));
        return;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    ((aylf)localTextPreviewActivity.app.a(161)).a(localTextPreviewActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    d();
  }
  
  private void d()
  {
    Activity localActivity = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        break label138;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(localActivity);
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(localActivity);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new aicj(localActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(ajya.a(2131714885));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      label138:
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void f()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localTextPreviewActivity != null)
    {
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      localTextPreviewActivity.i.setVisibility(0);
      localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setVisibility(0);
      a(localTextPreviewActivity, 135, 20);
    }
  }
  
  public void a(bbmf parambbmf)
  {
    parambbmf.a(2131364824, ajya.a(2131714879), 2130838597);
    parambbmf.a(2131366632, ajya.a(2131714877), 2130838606);
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      parambbmf.a(2131365928, ajya.a(2131714880), 2130838605);
      return;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != -2))
      {
        parambbmf.a(2131375125, ajya.a(2131714886), 2130838610);
        continue;
        TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localTextPreviewActivity != null) && (localTextPreviewActivity.app != null) && (!this.jdField_b_of_type_JavaLangString.equals(localTextPreviewActivity.app.getCurrentAccountUin()))) {
          parambbmf.a(2131375125, ajya.a(2131714878), 2130838610);
        }
      }
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
    paramTextPreviewActivity.app.addObserver(this.jdField_a_of_type_Aylg);
  }
  
  public void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    int i = a(this.jdField_b_of_type_Int);
    axqy.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "dc00898", "", "", "0X8009EFF", "0X8009EFF", i, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localTextPreviewActivity != null)
    {
      if (localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          f();
        }
        return bool;
      }
    }
    return false;
  }
  
  public void b(ContainerView paramContainerView)
  {
    super.b(paramContainerView);
    paramContainerView = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((paramContainerView != null) && (paramContainerView.app != null)) {
      paramContainerView.app.removeObserver(this.jdField_a_of_type_Aylg);
    }
    e();
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    MessageRecord localMessageRecord;
    int i;
    if (localTextPreviewActivity == null)
    {
      localMessageRecord = null;
      i = 0;
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      if ((paramView.getId() != 2131375791) && (aibn.a().c())) {
        aibn.a().d();
      }
      do
      {
        for (;;)
        {
          return;
          localMessageRecord = localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          break;
          i = 1;
          adfy.a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, 2);
          try
          {
            ayle.a(a(), "TextPreview");
            if (i == 0) {
              break label244;
            }
            axqy.b(localQQAppInterface, "dc00898", "", "", "0X800A356", "0X800A356", 0, 0, "", "", "", "");
          }
          catch (Exception paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("TextPreviewMenu", 2, paramView.toString());
      return;
      label244:
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009F00", "0X8009F00", 0, 0, "", "", "", "");
      continue;
      adfy.a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, 3);
      ayle.a((Activity)paramView.getContext(), a());
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009F01", "0X8009F01", 0, 0, "", "", "", "");
      continue;
      adfy.a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, 4);
      if (localQQAppInterface != null) {
        ayle.a((Activity)paramView.getContext(), localQQAppInterface, a());
      }
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009F02", "0X8009F02", 0, 0, "", "", "", "");
      continue;
      aibn.a().a(null);
      continue;
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.setResult(14001, localTextPreviewActivity.getIntent());
        localTextPreviewActivity.finish();
        axqy.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 4, 0, "", "", "", "");
        continue;
        if (localTextPreviewActivity != null)
        {
          localTextPreviewActivity.b(a());
          axqy.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 5, 0, "", "", "", "");
          continue;
          c();
          axqy.b(localTextPreviewActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 1, 0, "", "", "", "");
          continue;
          localTextPreviewActivity.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu
 * JD-Core Version:    0.7.0.1
 */