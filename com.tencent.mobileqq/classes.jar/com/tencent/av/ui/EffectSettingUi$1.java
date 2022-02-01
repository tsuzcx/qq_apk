package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class EffectSettingUi$1
  implements View.OnClickListener
{
  EffectSettingUi$1(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    int k = paramView.getId();
    Object localObject = paramView.getTag(2131378276);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    int m = this.a.jdField_a_of_type_Int;
    boolean bool = this.a.a(l, k, bool);
    int i;
    if (k == 4) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (i != 0)
    {
      localObject = ((AVActivity)this.a.getContext()).a;
      if ((localObject != null) && ((localObject == null) || (((EffectFilterPanel)localObject).getVisibility() != 8))) {
        j = 0;
      } else {
        j = 1;
      }
    }
    if ((bool) && ((m != k) || (j != 0))) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(k), Long.valueOf(l) });
    }
    if (bool)
    {
      localObject = VideoController.a().a(true);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "onShow clear state");
        }
        ((EffectController)localObject).a(k);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
    if (m != k) {
      if (k == 1)
      {
        AVEffectReport.b((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool);
      }
      else if (k == 2)
      {
        AVEffectReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.a(), bool);
        if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
          this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a();
        }
      }
      else if (k == 4)
      {
        AVEffectReport.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool);
      }
      else if (k == 3)
      {
        AVEffectReport.a(this.a.a(), bool);
      }
      else if (k == 5)
      {
        DataReport.f();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.1
 * JD-Core Version:    0.7.0.1
 */