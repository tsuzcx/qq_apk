package com.tencent.av.ui.effect.toolbar.oldversion;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class Avatar2dToolbar$1
  implements IEffectCallback
{
  Avatar2dToolbar$1(Avatar2dToolbar paramAvatar2dToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(Avatar2dToolbar.access$700(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(Avatar2dToolbar.access$100(this.a), paramLong);
    Avatar2dToolbar.access$202(this.a, paramItemInfo);
    Object localObject = paramItemInfo.m;
    Integer localInteger = Integer.valueOf(9050);
    if ((localObject == null) && (Avatar2dToolbar.access$000(this.a).j()))
    {
      Avatar2dToolbar.access$300(this.a).a(new Object[] { localInteger, Long.valueOf(AudioHelper.c()), Boolean.valueOf(false), paramItemInfo.a });
      Avatar2dToolbar.access$000(this.a).a(false);
    }
    else if ((paramItemInfo.m != null) && (!Avatar2dToolbar.access$000(this.a).j()))
    {
      Avatar2dToolbar.access$400(this.a).a(new Object[] { localInteger, Long.valueOf(AudioHelper.c()), Boolean.valueOf(true), paramItemInfo.a });
      Avatar2dToolbar.access$000(this.a).a(true);
    }
    if ((Avatar2dToolbar.access$500(this.a)) && (paramItemInfo.m != null)) {
      Avatar2dToolbar.access$600(this.a, paramItemInfo, paramLong);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onEffectUserClick] type=");
    ((StringBuilder)localObject).append(paramItemInfo.f);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramItemInfo.toString());
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.d("Avatar2dToolbar", 1, (String)localObject);
    if (!"0".equals(paramItemInfo.a))
    {
      if (Avatar2dToolbar.access$000(this.a).c() == null) {
        i = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      ReportController.b(null, "dc00898", "", "", "0X800BCDB", "0X800BCDB", 0, 0, ((StringBuilder)localObject).toString(), "", paramItemInfo.l, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.Avatar2dToolbar.1
 * JD-Core Version:    0.7.0.1
 */