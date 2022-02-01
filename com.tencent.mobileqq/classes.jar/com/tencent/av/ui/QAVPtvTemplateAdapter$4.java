package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QAVPtvTemplateAdapter$4
  implements QavListItemBase.IClickCallback
{
  QAVPtvTemplateAdapter$4(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter) {}
  
  public void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase)
  {
    boolean bool;
    if ((System.currentTimeMillis() - this.a.jdField_a_of_type_Long < 500L) && (paramInt > 0)) {
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
      paramQavListItemBase.append(this.a.d);
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
    paramQavListItemBase.append(this.a.d);
    paramQavListItemBase.append("], seq[");
    paramQavListItemBase.append(paramLong);
    paramQavListItemBase.append("]");
    QLog.w("QAVPtvTemplateAdapter", 1, paramQavListItemBase.toString());
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    int i = this.a.d;
    paramQavListItemBase = this.a;
    paramQavListItemBase.d = paramInt;
    paramQavListItemBase.e = paramInt;
    paramQavListItemBase.a(i, paramQavListItemBase.d);
    paramQavListItemBase = this.a;
    paramQavListItemBase.a(paramQavListItemBase.d);
    paramQavListItemBase = this.a;
    paramQavListItemBase.a(paramLong, paramQavListItemBase.d);
    if (this.a.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback != null)
    {
      paramQavListItemBase = (QavListItemBase.ItemInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.a.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a(paramQavListItemBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.4
 * JD-Core Version:    0.7.0.1
 */