package com.tencent.biz.qqcircle.publish.activity;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.publish.util.AlbumUtil;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QCircleMediaPart$2
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  QCircleMediaPart$2(QCircleMediaPart paramQCircleMediaPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[QcirclePublish]QCircleMediaPart", 1, new Object[] { "onChanged... localMediaInfoHashMap:", paramHashMap });
    }
    if (paramHashMap != null) {
      try
      {
        if (paramHashMap.size() > 0)
        {
          DynamicArrayList localDynamicArrayList = QCircleMediaPart.h(this.a).f;
          if (localDynamicArrayList == null) {
            return;
          }
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramHashMap.get(localDynamicArrayList.get(0));
          if (localLocalMediaInfo != null)
          {
            if (AlbumUtil.b(localLocalMediaInfo))
            {
              QCircleMediaPart.a(this.a, localLocalMediaInfo);
              return;
            }
            QCircleMediaPart.a(this.a, paramHashMap, localDynamicArrayList, localLocalMediaInfo);
            return;
          }
        }
      }
      catch (Exception paramHashMap)
      {
        QLog.e("[QcirclePublish]QCircleMediaPart", 1, paramHashMap, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleMediaPart.2
 * JD-Core Version:    0.7.0.1
 */