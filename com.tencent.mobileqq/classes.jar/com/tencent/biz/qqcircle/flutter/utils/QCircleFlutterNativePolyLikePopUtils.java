package com.tencent.biz.qqcircle.flutter.utils;

import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeInfoManger;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class QCircleFlutterNativePolyLikePopUtils
{
  public static void a(QCircleFlutterNativePolyLikePopUtils.ShowPolyLikePopWindowParam paramShowPolyLikePopWindowParam)
  {
    View localView = paramShowPolyLikePopWindowParam.a();
    if (localView == null)
    {
      QLog.d("QCircleFlutterNativePolyLikePopUtils", 2, "[show] view not is null.");
      return;
    }
    List localList = QCirclePolyLikeInfoManger.a().b();
    if (localList.isEmpty())
    {
      QLog.d("QCircleFlutterNativePolyLikePopUtils", 2, "[show] poly likes empty.");
      return;
    }
    QCirclePolyLikePopWindow localQCirclePolyLikePopWindow = new QCirclePolyLikePopWindow(paramShowPolyLikePopWindowParam.a().getContext());
    if (localQCirclePolyLikePopWindow.isShowing())
    {
      QLog.d("QCircleFlutterNativePolyLikePopUtils", 2, "[show] poly like pop window is showing.");
      return;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = paramShowPolyLikePopWindowParam.d();
    FeedCloudMeta.StFeed localStFeed;
    if (localQCircleExtraTypeInfo == null) {
      localStFeed = null;
    } else {
      localStFeed = paramShowPolyLikePopWindowParam.d().mFeed;
    }
    QCircleReportBean localQCircleReportBean = paramShowPolyLikePopWindowParam.c();
    paramShowPolyLikePopWindowParam = paramShowPolyLikePopWindowParam.b();
    localQCirclePolyLikePopWindow.a(localQCircleReportBean);
    localQCirclePolyLikePopWindow.a(localView, localView, true, paramShowPolyLikePopWindowParam, localStFeed, localList, localQCircleExtraTypeInfo);
    localQCirclePolyLikePopWindow.a();
    localQCirclePolyLikePopWindow.setOnDismissListener(new QCircleFlutterNativePolyLikePopUtils.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativePolyLikePopUtils
 * JD-Core Version:    0.7.0.1
 */