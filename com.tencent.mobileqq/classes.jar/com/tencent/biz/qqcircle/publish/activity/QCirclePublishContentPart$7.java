package com.tencent.biz.qqcircle.publish.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishContentPart$7
  implements TextWatcher
{
  QCirclePublishContentPart$7(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterTextChanged s:");
      ((StringBuilder)localObject).append(paramEditable.toString());
      QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, ((StringBuilder)localObject).toString());
    }
    if ((paramEditable != null) && (paramEditable.toString().equals(QCirclePublishContentPart.e(this.a)))) {
      return;
    }
    QCirclePublishContentPart.b(this.a, paramEditable.toString());
    if (paramEditable != null)
    {
      localObject = HostEmotionUtil.splash2Emo(QCircleHostTextBuilder.toPlainText(paramEditable).replaceAll(HardCodeUtil.a(2131903750), HardCodeUtil.a(2131903752)).replaceAll(HardCodeUtil.a(2131903749), "/MM").replaceAll(HardCodeUtil.a(2131914654), "/chigua"));
      QCirclePublishContentPart localQCirclePublishContentPart = this.a;
      localObject = localQCirclePublishContentPart.a((String)localObject, localQCirclePublishContentPart.m);
      QCirclePublishContentPart.k(this.a).a((String)localObject, QCirclePublishContentPart.j(this.a));
    }
    else
    {
      QCirclePublishContentPart.k(this.a).a(null, QCirclePublishContentPart.j(this.a));
    }
    this.a.a(paramEditable);
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
      QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, localStringBuilder.toString());
    }
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {}
    try
    {
      QCirclePublishContentPart.b(this.a, QCirclePublishContentPart.a(this.a, paramCharSequence, paramInt1 + paramInt2));
      if (QCirclePublishContentPart.h(this.a) == -1)
      {
        QCirclePublishContentPart.f(this.a);
      }
      else
      {
        QCirclePublishContentPart.c(this.a, paramInt1);
        QCirclePublishContentPart.a(this.a, paramCharSequence.toString().substring(QCirclePublishContentPart.h(this.a), QCirclePublishContentPart.i(this.a) + paramInt2));
      }
      if (this.a.f == null) {
        break label227;
      }
      this.a.f.setBeforeChangeLineCount(this.a.f.getLineCount());
      return;
    }
    catch (Exception paramCharSequence)
    {
      label220:
      label227:
      break label220;
    }
    QCirclePublishContentPart.f(this.a);
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
      QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, localStringBuilder.toString());
    }
    if ((paramCharSequence != null) && (paramCharSequence.toString().equals(QCirclePublishContentPart.e(this.a)))) {
      return;
    }
    if (paramCharSequence == null)
    {
      QCirclePublishContentPart.f(this.a);
      return;
    }
    if (!TextUtils.isEmpty(this.a.l))
    {
      this.a.l = null;
      return;
    }
    if ((this.a.t()) && (paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      this.a.o = true;
      HostUIHelper.openHostEnvironment(new QCirclePublishContentPart.7.1(this));
    }
    paramCharSequence = this.a;
    if (QCirclePublishContentPart.a(paramCharSequence, QCirclePublishContentPart.g(paramCharSequence), true)) {
      this.a.f.getEditableText().delete(QCirclePublishContentPart.h(this.a), QCirclePublishContentPart.i(this.a));
    }
    QCirclePublishContentPart.f(this.a);
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.7
 * JD-Core Version:    0.7.0.1
 */