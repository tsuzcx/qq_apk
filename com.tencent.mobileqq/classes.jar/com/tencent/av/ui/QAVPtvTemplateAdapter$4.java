package com.tencent.av.ui;

import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QAVPtvTemplateAdapter$4
  implements QavListItemBase.IClickCallback
{
  QAVPtvTemplateAdapter$4(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter) {}
  
  public void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase)
  {
    boolean bool;
    if ((System.currentTimeMillis() - this.a.p < 500L) && (paramInt > 0)) {
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
      paramQavListItemBase.append(this.a.j);
      paramQavListItemBase.append("], ignore[");
      paramQavListItemBase.append(bool);
      paramQavListItemBase.append("], seq[");
      paramQavListItemBase.append(paramLong);
      paramQavListItemBase.append("]");
      QLog.w("QAVPtvTemplateAdapter", 1, paramQavListItemBase.toString());
    }
    if (bool) {
      return;
    }
    paramQavListItemBase = new StringBuilder();
    paramQavListItemBase.append("onItemClicked valid, position[");
    paramQavListItemBase.append(paramInt);
    paramQavListItemBase.append("], mCurSelectedPosition[");
    paramQavListItemBase.append(this.a.j);
    paramQavListItemBase.append("], seq[");
    paramQavListItemBase.append(paramLong);
    paramQavListItemBase.append("]");
    QLog.w("QAVPtvTemplateAdapter", 1, paramQavListItemBase.toString());
    this.a.p = System.currentTimeMillis();
    int i = this.a.j;
    paramQavListItemBase = this.a;
    paramQavListItemBase.j = paramInt;
    paramQavListItemBase.k = paramInt;
    paramQavListItemBase.a(i, paramQavListItemBase.j);
    paramQavListItemBase = this.a;
    paramQavListItemBase.c(paramQavListItemBase.j);
    paramQavListItemBase = this.a;
    paramQavListItemBase.b(paramLong, paramQavListItemBase.j);
    if (this.a.l != null)
    {
      paramQavListItemBase = (QavListItemBase.ItemInfo)this.a.a.get(paramInt);
      this.a.l.a(paramQavListItemBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.4
 * JD-Core Version:    0.7.0.1
 */