package com.tencent.av.ui.effect.toolbar.oldversion;

import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class Avatar2dToolbar$2
  implements IEffectCallback
{
  Avatar2dToolbar$2(Avatar2dToolbar paramAvatar2dToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(Avatar2dToolbar.access$1000(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(Avatar2dToolbar.access$800(this.a), paramLong);
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)Avatar2dToolbar.access$000(this.a).c();
    localAvatar2dItem.j(paramItemInfo.a);
    Avatar2dToolbar.access$900(this.a).i(paramItemInfo.a);
    if (localAvatar2dItem != null)
    {
      boolean bool = "0".equals(paramItemInfo.a);
      Object localObject = null;
      if (bool)
      {
        localAvatar2dItem.i(null);
        localAvatar2dItem.j(null);
        return;
      }
      if (Avatar2dToolbar.access$000(this.a) != null)
      {
        localObject = (Avatar2dItem)Avatar2dToolbar.access$000(this.a).b(paramItemInfo.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Avatar2dToolbar.access$000(this.a).a((Avatar2dItem)localObject));
        localStringBuilder.append(((Avatar2dItem)localObject).a());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((Avatar2dItem)localObject).a());
        localStringBuilder.append(".pag");
        localObject = localStringBuilder.toString();
      }
      localAvatar2dItem.i((String)localObject);
      localAvatar2dItem.j(paramItemInfo.a);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onEffectUserClick] type=");
    localStringBuilder.append(paramItemInfo.f);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramItemInfo.toString());
    QLog.d("Avatar2dToolbar", 1, localStringBuilder.toString());
    if (!"0".equals(paramItemInfo.a)) {
      ReportController.b(null, "dc00898", "", "", "0X800BCDC", "0X800BCDC", 0, 0, "", "", paramItemInfo.l, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.Avatar2dToolbar.2
 * JD-Core Version:    0.7.0.1
 */