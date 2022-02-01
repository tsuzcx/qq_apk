package com.tencent.av.ui.effect.toolbar.oldversion;

import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class EffectToolbar$1
  implements IEffectCallback
{
  EffectToolbar$1(EffectToolbar paramEffectToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(EffectToolbar.access$700(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(EffectToolbar.access$000(this.a), paramLong);
    Object localObject1 = VideoController.f();
    Object localObject2 = ((VideoController)localObject1).m(false);
    if (localObject2 != null)
    {
      if (AudioHelper.e())
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
    if (paramItemInfo.a.equals("0"))
    {
      EffectToolbar.access$100(this.a, paramLong, null);
      this.a.mEarbackBtn.setVisibility(4);
      EffectToolbar.access$200(this.a).b().k().cs = 0;
      EffectToolbar.access$300(this.a).b().am();
      return;
    }
    if (!paramItemInfo.d) {
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(PtvTemplateManager.b);
    ((StringBuilder)localObject2).append(paramItemInfo.c);
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = paramItemInfo.a;
    boolean bool = this.a.isEffectBtnNormal();
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
    EffectToolbar.access$100(this.a, paramLong, paramItemInfo.a);
    MultiVideoRichActionReportCollection.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).k();
    int i = ((SessionInfo)localObject3).bM;
    int j = ((SessionInfo)localObject3).aQ;
    paramLong = ((VideoController)localObject1).as();
    localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onEffectClick voiceid : ");
    ((StringBuilder)localObject3).append(paramItemInfo.j);
    QLog.i("EffectToolbar", 2, ((StringBuilder)localObject3).toString());
    EffectToolbar.access$400(this.a).b().k().cs = paramItemInfo.j;
    EffectToolbar.access$500(this.a).b().am();
    if (paramItemInfo.j > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$600(this.a);
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
    if (paramItemInfo.a.equals("0")) {
      return;
    }
    VideoController localVideoController = VideoController.f();
    SessionInfo localSessionInfo = localVideoController.k();
    int i = localSessionInfo.bM;
    int j = localSessionInfo.aQ;
    long l = localVideoController.as();
    paramItemInfo = paramItemInfo.a;
    AVEffectReport.a(j, i, l, paramItemInfo, ((PendantItem)this.a.mPtvTemplateInfoMap.get(paramItemInfo)).getCategory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.EffectToolbar.1
 * JD-Core Version:    0.7.0.1
 */