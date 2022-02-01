package com.tencent.biz.qqcircle.publish.activity;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

class QCircleLabelPart$5
  implements Observer<UIStateData<List<FeedCloudMeta.StTagInfo>>>
{
  QCircleLabelPart$5(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(@Nullable UIStateData<List<FeedCloudMeta.StTagInfo>> paramUIStateData)
  {
    String str = paramUIStateData.f();
    if ((QCircleLabelPart.a(this.a).c() != null) && (!TextUtils.isEmpty(str)))
    {
      if (!QCircleLabelPart.a(this.a).c().equals(str))
      {
        if (QLog.isColorLevel())
        {
          paramUIStateData = new StringBuilder();
          paramUIStateData.append("onChanged... req:");
          paramUIStateData.append(QCircleLabelPart.a(this.a).c());
          paramUIStateData.append(" rsp:");
          paramUIStateData.append(str);
          QLog.d("[QcirclePublish]QCircleLabelPart", 2, paramUIStateData.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChanged... req:");
        localStringBuilder.append(QCircleLabelPart.a(this.a).c());
        localStringBuilder.append(" rsp:");
        localStringBuilder.append(str);
        QLog.d("[QcirclePublish]QCircleLabelPart", 2, localStringBuilder.toString());
      }
    }
    int i = paramUIStateData.c();
    if (i != 0) {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {}
      }
      else
      {
        QCircleLabelPart.a(this.a, paramUIStateData);
        return;
      }
    }
    QCircleLabelPart.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.5
 * JD-Core Version:    0.7.0.1
 */