package com.tencent.av.ui.effect.toolbar.newversion;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class PendantToolbar$2
  implements IEffectCallback
{
  PendantToolbar$2(PendantToolbar paramPendantToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(PendantToolbar.access$800(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(PendantToolbar.access$400(this.a), paramLong);
    Object localObject1 = VideoController.f().m(false);
    if (localObject1 != null)
    {
      if (AudioHelper.e())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onEffectClick, clearState, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("], info[");
        ((StringBuilder)localObject2).append(paramItemInfo);
        ((StringBuilder)localObject2).append("]");
        QLog.w("PendantToolbar", 1, ((StringBuilder)localObject2).toString());
      }
      ((EffectController)localObject1).a(paramLong);
    }
    if (paramItemInfo.a.equals("0"))
    {
      PendantToolbar.access$500(this.a, paramLong, null);
      PendantToolbar.access$600(this.a).b().k().cs = 0;
      PendantToolbar.access$700(this.a).b().am();
      return;
    }
    if (!paramItemInfo.d) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PtvTemplateManager.b);
    ((StringBuilder)localObject1).append(paramItemInfo.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = paramItemInfo.a;
    boolean bool = this.a.isEffectBtnNormal();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onEffectClick, path[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], bSuc[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w("PendantToolbar", 1, ((StringBuilder)localObject2).toString());
    }
    PendantToolbar.access$500(this.a, paramLong, paramItemInfo.a);
    if (PendantToolbar.access$200(this.a).v() != 0)
    {
      int i = VideoController.f().k().aQ;
      paramItemInfo = (PendantItem)PendantToolbar.access$000(this.a).b(paramItemInfo.a);
      AVEffectReport.b(i, paramItemInfo.getCategoryName(), paramItemInfo.getName());
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (!PendantToolbar.access$200(this.a).a((ArrayList)PendantToolbar.access$200(this.a).c(), paramItemInfo))
    {
      PendantToolbar.access$200(this.a).c().add(1, paramItemInfo);
      i = PendantToolbar.access$200(this.a).c().size();
      if (i > 20)
      {
        i -= 1;
        while (i > 19)
        {
          PendantToolbar.access$200(this.a).c().remove(i);
          i -= 1;
        }
      }
    }
    PendantToolbar.access$200(this.a).b(paramItemInfo.a);
    PendantToolbar.access$200(this.a).j();
    PendantToolbar.access$200(this.a).p();
    if (paramItemInfo.a.equals("0")) {
      return;
    }
    int i = VideoController.f().k().aQ;
    paramItemInfo = (PendantItem)PendantToolbar.access$000(this.a).b(paramItemInfo.a);
    if (PendantToolbar.access$200(this.a).v() == 0)
    {
      PendantToolbar.access$300(this.a, paramItemInfo);
      return;
    }
    AVEffectReport.a(i, paramItemInfo.getCategoryName(), paramItemInfo.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar.2
 * JD-Core Version:    0.7.0.1
 */