package com.tencent.biz.qqcircle.publish.activity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishContentPart$8
  implements Observer<QCirclePublishContentPart.ContentSet>
{
  QCirclePublishContentPart$8(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void a(@NonNull QCirclePublishContentPart.ContentSet paramContentSet)
  {
    if (!TextUtils.isEmpty(paramContentSet.a))
    {
      QLog.d("[QcirclePublish]QCirclePublishContentPart", 4, new Object[] { "onChanged... text:", paramContentSet.a });
      this.a.l = paramContentSet.a;
      paramContentSet.a = this.a.a(paramContentSet.a);
      this.a.n = paramContentSet.a.length();
      this.a.f.setText(paramContentSet.a);
      ExtendEditText localExtendEditText = this.a.f;
      int i;
      if (paramContentSet.b < paramContentSet.a.length()) {
        i = paramContentSet.b;
      } else {
        i = paramContentSet.a.length();
      }
      localExtendEditText.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.8
 * JD-Core Version:    0.7.0.1
 */