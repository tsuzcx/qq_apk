package com.tencent.av.ui;

import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class EffectToolbar$1
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  EffectToolbar$1(EffectToolbar paramEffectToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject1 = VideoController.a();
    Object localObject2 = ((VideoController)localObject1).a(false);
    if (localObject2 != null)
    {
      if (AudioHelper.e()) {
        QLog.w("EffectToolbar", 1, "onEffectClick, clearState, seq[" + paramLong + "], info[" + paramItemInfo + "]");
      }
      ((EffectController)localObject2).a(paramLong);
    }
    if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))
    {
      EffectToolbar.access$000(this.a, paramLong, null);
      this.a.mEarbackBtn.setVisibility(4);
      this.a.mApp.a().a().V = 0;
      this.a.mApp.a().y();
    }
    while (!paramItemInfo.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = PtvTemplateManager.jdField_a_of_type_JavaLangString + paramItemInfo.c;
    localObject2 = paramItemInfo.jdField_a_of_type_JavaLangString;
    boolean bool = this.a.isEffectBtnEnable();
    if (QLog.isColorLevel()) {
      QLog.w("EffectToolbar", 1, "onEffectClick, path[" + (String)localObject3 + "], bSuc[" + bool + "], seq[" + paramLong + "]");
    }
    EffectToolbar.access$000(this.a, paramLong, paramItemInfo.jdField_a_of_type_JavaLangString);
    MultiVideoRichActionReportCollection.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).a();
    int i = ((SessionInfo)localObject3).N;
    int j = ((SessionInfo)localObject3).F;
    paramLong = ((VideoController)localObject1).f();
    localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    QLog.i("EffectToolbar", 2, "onEffectClick voiceid : " + paramItemInfo.d);
    this.a.mApp.a().a().V = paramItemInfo.d;
    this.a.mApp.a().y();
    if (paramItemInfo.d > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.a);
    }
    for (;;)
    {
      AVEffectPendantReport.b();
      AVEffectReport.a(j, i, paramLong, (String)localObject2, ((PendantItem)localObject1).getCategory());
      return;
      this.a.mEarbackBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.1
 * JD-Core Version:    0.7.0.1
 */