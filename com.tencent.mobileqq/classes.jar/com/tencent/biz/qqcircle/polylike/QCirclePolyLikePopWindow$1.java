package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class QCirclePolyLikePopWindow$1
  implements RFWMultiDownloadHelper.MultiDownloadResultListener
{
  QCirclePolyLikePopWindow$1(QCirclePolyLikePopWindow paramQCirclePolyLikePopWindow) {}
  
  public void onDownloadResult(boolean paramBoolean, Map<String, RFWMultiDownloadHelper.DownloadResult> paramMap)
  {
    if (paramBoolean)
    {
      if (paramMap == null) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (RFWMultiDownloadHelper.DownloadResult)((Map.Entry)paramMap.next()).getValue();
        String str = ((RFWMultiDownloadHelper.DownloadResult)localObject1).mDownloadUrl;
        if (!QCirclePolyLikeInfoManger.a.containsKey(str))
        {
          localObject1 = ((RFWMultiDownloadHelper.DownloadResult)localObject1).mFilePath;
          Object localObject2 = AnimationView.AnimationInfo.a((String)localObject1);
          if (localObject2 != null)
          {
            ((AnimationView.AnimationInfo)localObject2).b = 40;
            ((AnimationView.AnimationInfo)localObject2).a = 2147483647;
            QCirclePolyLikeInfoManger.a.put(str, localObject2);
          }
          else
          {
            QLog.d("QCirclePolymorphicLikePopWindow", 1, "info is null");
          }
          localObject1 = AnimationDrawableFactory.a((String)localObject1);
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("lists length = ");
            ((StringBuilder)localObject2).append(localObject1.length);
            QLog.d("QCirclePolymorphicLikePopWindow", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            QLog.d("QCirclePolymorphicLikePopWindow", 1, "this is not files");
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downUrl = ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("QCirclePolymorphicLikePopWindow", 1, ((StringBuilder)localObject1).toString());
      }
      QCirclePolyLikePopWindow.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.1
 * JD-Core Version:    0.7.0.1
 */