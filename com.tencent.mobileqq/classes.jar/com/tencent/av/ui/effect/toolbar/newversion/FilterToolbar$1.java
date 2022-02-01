package com.tencent.av.ui.effect.toolbar.newversion;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.mobileqq.statistics.ReportController;

class FilterToolbar$1
  implements IEffectCallback
{
  FilterToolbar$1(FilterToolbar paramFilterToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(FilterToolbar.access$300(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(FilterToolbar.access$100(this.a), paramLong);
    if (paramItemInfo.a.equals("0"))
    {
      FilterToolbar.access$200(this.a).a(paramLong, null);
      return;
    }
    FilterItem localFilterItem = (FilterItem)FilterToolbar.access$200(this.a).b(paramItemInfo.a);
    FilterToolbar.access$200(this.a).a(paramLong, localFilterItem);
    int i = VideoController.f().k().aQ;
    if ((i != 1) && (i != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 2;
    } else {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BC06", "0X800BC06", i, 0, "", "", "", paramItemInfo.c);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    FilterToolbar.access$000(this.a).f(paramItemInfo.a);
    ReportController.b(null, "dc00898", "", "", "0X800BC19", "0X800BC19", 0, 0, "", "", "", paramItemInfo.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.FilterToolbar.1
 * JD-Core Version:    0.7.0.1
 */