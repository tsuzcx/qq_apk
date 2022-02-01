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
    TextPreviewTranslateActivity localTextPreviewTranslateActivity = (TextPreviewTranslateActivity)this.d.get();
    if (localTextPreviewTranslateActivity != null) {
      paramContainerView.setOutScrollView((ScrollView)localTextPreviewTranslateActivity.findViewById(2131445363));
    }
    paramContainerView.e = false;
    paramContainerView.c.post(new TranslateSelectableMenu.1(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131445511: 
      AIOSelectableDelegateImpl.a().a(null);
      ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
      break;
    case 2131433636: 
      MenuUtil.a((Activity)paramView.getContext(), a());
      ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
      break;
    case 2131432813: 
      if (localQQAppInterface != null) {
        MenuUtil.a((Activity)paramView.getContext(), localQQAppInterface, a());
      }
      ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
      break;
    case 2131431492: 
      try
      {
        MenuUtil.copy(a(), "TextPreview");
        ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label296;
        }
      }
      QLog.e("TranslateSelectableMenu", 2, localException.toString());
      break;
    }
    if ((paramView.getId() != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
      AIOSelectableDelegateImpl.a().n();
    }
    label296:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu
 * JD-Core Version:    0.7.0.1
 */