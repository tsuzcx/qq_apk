package com.tencent.av.ui.effect.toolbar.newversion;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.opengl.effects.TipsInfo;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

class Avatar2dToolbarV2$7
  implements IEffectCallback
{
  Avatar2dToolbarV2$7(Avatar2dToolbarV2 paramAvatar2dToolbarV2) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (paramItemInfo.f == 6)
    {
      Avatar2dToolbarV2.access$302(this.a, paramItemInfo);
      if ((paramItemInfo.m == null) && (Avatar2dToolbarV2.access$000(this.a).j()))
      {
        Avatar2dToolbarV2.access$400(this.a).a(new Object[] { Integer.valueOf(9050), Long.valueOf(AudioHelper.c()), Boolean.valueOf(false), paramItemInfo.a });
        Avatar2dToolbarV2.access$000(this.a).a(false);
      }
      else if ((paramItemInfo.m != null) && (!Avatar2dToolbarV2.access$000(this.a).j()))
      {
        if (this.a.hasCameraPermission())
        {
          Avatar2dToolbarV2.access$500(this.a).a(new Object[] { Integer.valueOf(9050), Long.valueOf(AudioHelper.c()), Boolean.valueOf(true), paramItemInfo.a });
          Avatar2dToolbarV2.access$000(this.a).a(true);
        }
        else
        {
          this.a.showPermissionTip();
        }
      }
      if (Avatar2dToolbarV2.access$600(this.a)) {
        Avatar2dToolbarV2.access$700(this.a, paramItemInfo, paramLong);
      }
    }
    else if (paramItemInfo.f == 7)
    {
      Avatar2dItem localAvatar2dItem = (Avatar2dItem)Avatar2dToolbarV2.access$000(this.a).c();
      if (localAvatar2dItem != null)
      {
        localAvatar2dItem.i(this.a.getBgMaterialPath(paramItemInfo.a));
        localAvatar2dItem.j(paramItemInfo.a);
        return;
      }
      TipsInfo.a().b(BaseApplication.getContext().getString(2131893206));
      TipsInfo.a().a(1500);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (paramItemInfo.f == 7)
    {
      Avatar2dToolbarV2.access$200(this.a).i(paramItemInfo.a);
      Avatar2dToolbarV2.access$200(this.a).e(paramItemInfo.a);
      if (!"0".equals(paramItemInfo.a)) {
        ReportController.b(null, "dc00898", "", "", "0X800BCDC", "0X800BCDC", 0, 0, "", "", paramItemInfo.l, "");
      }
    }
    else if (paramItemInfo.f == 6)
    {
      if (!"0".equals(paramItemInfo.a))
      {
        int i;
        if (Avatar2dToolbarV2.access$000(this.a).c() == null) {
          i = 2;
        } else {
          i = 1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ReportController.b(null, "dc00898", "", "", "0X800BCDB", "0X800BCDB", 0, 0, localStringBuilder.toString(), "", paramItemInfo.l, "");
      }
      Avatar2dToolbarV2.access$200(this.a).d(paramItemInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2.7
 * JD-Core Version:    0.7.0.1
 */