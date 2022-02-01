package com.tencent.biz.qqcircle.publish.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.qphone.base.util.QLog;

class QCircleLabelPart$4
  implements TextWatcher
{
  QCircleLabelPart$4(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterTextChanged s:");
      localStringBuilder.append(paramEditable.toString());
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, localStringBuilder.toString());
    }
    if (paramEditable == null) {
      return;
    }
    try
    {
      if (paramEditable.toString().equals(QCircleLabelPart.h(this.a))) {
        return;
      }
      QCircleLabelPart.d(this.a, paramEditable.toString());
      QCircleLabelPart.i(this.a);
      return;
    }
    catch (Exception paramEditable)
    {
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramEditable, new Object[0]);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("beforeTextChanged: s:");
      localStringBuilder.append(paramCharSequence.toString());
      localStringBuilder.append(" start:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" after:");
      localStringBuilder.append(paramInt3);
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, localStringBuilder.toString());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextChanged s:");
      localStringBuilder.append(paramCharSequence.toString());
      localStringBuilder.append(" start:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" before:");
      localStringBuilder.append(paramInt2);
      QLog.e("[QcirclePublish]QCircleLabelPart", 1, localStringBuilder.toString());
    }
    if (paramCharSequence == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramCharSequence.toString().equals(QCircleLabelPart.c(this.a))) {
          return;
        }
        QCircleLabelPart.b(this.a, paramCharSequence.toString());
        if ((paramInt3 != 1) || (!paramCharSequence.subSequence(paramInt1, paramInt1 + 1).toString().equals("#"))) {
          break label433;
        }
        QCirclePublishReport.a(15, 22, 0, "", "");
        QCircleLabelPart.a(this.a, paramInt1);
        if (!QCirclePublishViewModel.m()) {
          break label427;
        }
        QCircleLabelPart.a(this.a).d();
      }
      catch (Exception paramCharSequence)
      {
        QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramCharSequence, new Object[0]);
      }
      paramInt1 = this.a.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramInt1 != -1)
      {
        if (this.a.a(paramCharSequence.subSequence(paramInt1, QCircleLabelPart.d(this.a).getSelectionStart()).toString()))
        {
          QCircleLabelPart.c(this.a, paramCharSequence.subSequence(paramInt1 + 1, QCircleLabelPart.d(this.a).getSelectionStart()).toString());
          QCircleLabelPart.a(this.a, paramInt1);
        }
        else
        {
          QCircleLabelPart.c(this.a, null);
        }
      }
      else {
        QCircleLabelPart.c(this.a, null);
      }
      if ((QCircleLabelPart.e(this.a) == null) && (!bool)) {
        QCircleLabelPart.f(this.a);
      }
      if (QLog.isColorLevel())
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("mInputTag:");
        paramCharSequence.append(QCircleLabelPart.e(this.a));
        paramCharSequence.append(" mTagStartPos:");
        paramCharSequence.append(QCircleLabelPart.g(this.a));
        paramCharSequence.append(" isInsertJing:");
        paramCharSequence.append(bool);
        QLog.e("[QcirclePublish]QCircleLabelPart", 1, paramCharSequence.toString());
        return;
      }
      return;
      label427:
      boolean bool = true;
      continue;
      label433:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.4
 * JD-Core Version:    0.7.0.1
 */