package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class QCirclePolyLikeAllDialog$2
  implements RFWMultiDownloadHelper.MultiDownloadResultListener
{
  QCirclePolyLikeAllDialog$2(QCirclePolyLikeAllDialog paramQCirclePolyLikeAllDialog) {}
  
  public void onDownloadResult(boolean paramBoolean, Map<String, RFWMultiDownloadHelper.DownloadResult> paramMap)
  {
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = (RFWMultiDownloadHelper.DownloadResult)paramMap.get(str);
        if (!QCirclePolyLikeInfoManger.a.containsKey(str))
        {
          localObject = AnimationView.AnimationInfo.a(((RFWMultiDownloadHelper.DownloadResult)localObject).mFilePath);
          if (localObject != null)
          {
            ((AnimationView.AnimationInfo)localObject).b = 50;
            ((AnimationView.AnimationInfo)localObject).a = 2147483647;
            QCirclePolyLikeInfoManger.a.put(str, localObject);
          }
        }
      }
      QCirclePolyLikeAllDialog.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAllDialog.2
 * JD-Core Version:    0.7.0.1
 */