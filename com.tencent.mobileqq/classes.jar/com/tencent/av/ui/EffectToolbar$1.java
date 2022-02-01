package com.tencent.av.ui;

import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
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
      if (AudioHelper.b())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onEffectClick, clearState, seq[");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append("], info[");
        ((StringBuilder)localObject3).append(paramItemInfo);
        ((StringBuilder)localObject3).append("]");
        QLog.w("EffectToolbar", 1, ((StringBuilder)localObject3).toString());
      }
      ((EffectController)localObject2).a(paramLong);
    }
    if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))
    {
      EffectToolbar.access$000(this.a, paramLong, null);
      this.a.mEarbackBtn.setVisibility(4);
      this.a.mApp.a().a().ae = 0;
      this.a.mApp.a().z();
      return;
    }
    if (!paramItemInfo.jdField_a_of_type_Boolean) {
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(PtvTemplateManager.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(paramItemInfo.c);
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = paramItemInfo.jdField_a_of_type_JavaLangString;
    boolean bool = this.a.isEffectBtnEnable();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEffectClick, path[");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("], bSuc[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("EffectToolbar", 1, localStringBuilder.toString());
    }
    EffectToolbar.access$000(this.a, paramLong, paramItemInfo.jdField_a_of_type_JavaLangString);
    MultiVideoRichActionReportCollection.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).a();
    int i = ((SessionInfo)localObject3).L;
    int j = ((SessionInfo)localObject3).E;
    paramLong = ((VideoController)localObject1).f();
    localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onEffectClick voiceid : ");
    ((StringBuilder)localObject3).append(paramItemInfo.d);
    QLog.i("EffectToolbar", 2, ((StringBuilder)localObject3).toString());
    this.a.mApp.a().a().ae = paramItemInfo.d;
    this.a.mApp.a().z();
    if (paramItemInfo.d > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.a);
    }
    else
    {
      this.a.mEarbackBtn.setVisibility(4);
    }
    AVEffectPendantReport.b();
    AVEffectReport.b(j, i, paramLong, (String)localObject2, ((PendantItem)localObject1).getCategory());
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")) {
      return;
    }
    VideoController localVideoController = VideoController.a();
    SessionInfo localSessionInfo = localVideoController.a();
    int i = localSessionInfo.L;
    int j = localSessionInfo.E;
    long l = localVideoController.f();
    paramItemInfo = paramItemInfo.jdField_a_of_type_JavaLangString;
    AVEffectReport.a(j, i, l, paramItemInfo, ((PendantItem)this.a.mPtvTemplateInfoMap.get(paramItemInfo)).getCategory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.1
 * JD-Core Version:    0.7.0.1
 */