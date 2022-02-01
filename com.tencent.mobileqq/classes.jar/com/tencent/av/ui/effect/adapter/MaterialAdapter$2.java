package com.tencent.av.ui.effect.adapter;

import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.IClickCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MaterialAdapter$2
  implements QavListItemBase.IClickCallback
{
  MaterialAdapter$2(MaterialAdapter paramMaterialAdapter) {}
  
  public void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase)
  {
    boolean bool;
    if ((System.currentTimeMillis() - this.a.f < 500L) && (paramInt > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramQavListItemBase = new StringBuilder();
      paramQavListItemBase.append("onItemClicked begin, position[");
      paramQavListItemBase.append(paramInt);
      paramQavListItemBase.append("], mCurSelectedPosition[");
      paramQavListItemBase.append(this.a.a);
      paramQavListItemBase.append("], ignore[");
      paramQavListItemBase.append(bool);
      paramQavListItemBase.append("], seq[");
      paramQavListItemBase.append(paramLong);
      paramQavListItemBase.append("]");
      QLog.w("MaterialAdapter", 1, paramQavListItemBase.toString());
    }
    if (bool) {
      return;
    }
    paramQavListItemBase = new StringBuilder();
    paramQavListItemBase.append("onItemClicked valid, position[");
    paramQavListItemBase.append(paramInt);
    paramQavListItemBase.append("], mCurSelectedPosition[");
    paramQavListItemBase.append(this.a.a);
    paramQavListItemBase.append("], seq[");
    paramQavListItemBase.append(paramLong);
    paramQavListItemBase.append("]");
    QLog.w("MaterialAdapter", 1, paramQavListItemBase.toString());
    this.a.f = System.currentTimeMillis();
    paramQavListItemBase = this.a;
    paramQavListItemBase.a = paramInt;
    paramQavListItemBase.b = paramInt;
    paramQavListItemBase.a(paramLong, paramQavListItemBase.a);
    if (this.a.e != null)
    {
      paramQavListItemBase = (QavListItemBase.ItemInfo)MaterialAdapter.a(this.a).get(paramInt);
      this.a.e.a(paramQavListItemBase);
    }
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.adapter.MaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */