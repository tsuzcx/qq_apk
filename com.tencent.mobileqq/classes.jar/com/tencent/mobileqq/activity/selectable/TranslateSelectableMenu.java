package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class TranslateSelectableMenu
  extends CommonSelectableMenu<TextPreviewTranslateActivity>
{
  protected void a(ContainerView paramContainerView)
  {
    super.a(paramContainerView);
    TextPreviewTranslateActivity localTextPreviewTranslateActivity = (TextPreviewTranslateActivity)this.b.get();
    if (localTextPreviewTranslateActivity != null) {
      paramContainerView.setOutScrollView((ScrollView)localTextPreviewTranslateActivity.findViewById(2131377555));
    }
    paramContainerView.jdField_a_of_type_Boolean = false;
    paramContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.post(new TranslateSelectableMenu.1(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    ReportController.b((AppRuntime)this.a.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((paramView.getId() != 2131377708) && (AIOSelectableDelegateImpl.a().c())) {
        AIOSelectableDelegateImpl.a().d();
      }
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          try
          {
            MenuUtil.copy(a(), "TextPreview");
            ReportController.b((AppRuntime)this.a.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
          }
          catch (Exception localException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.e("TranslateSelectableMenu", 2, localException.toString());
        }
      }
      MenuUtil.a((Activity)paramView.getContext(), a());
      ReportController.b((AppRuntime)this.a.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
      continue;
      if (localException != null) {
        MenuUtil.a((Activity)paramView.getContext(), localException, a());
      }
      ReportController.b((AppRuntime)this.a.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
      continue;
      AIOSelectableDelegateImpl.a().a(null);
      ReportController.b((AppRuntime)this.a.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu
 * JD-Core Version:    0.7.0.1
 */