package com.tencent.biz.qqcircle.flutter.animation;

import com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadFactory.OnDownloadFileListener;
import com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadOption;

class QCircleFlutterAnimationLoader$1
  implements QCircleFlutterFileDownloadFactory.OnDownloadFileListener
{
  QCircleFlutterAnimationLoader$1(QCircleFlutterAnimationLoader paramQCircleFlutterAnimationLoader, boolean paramBoolean) {}
  
  public void a(QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption, String paramString)
  {
    if (paramQCircleFlutterFileDownloadOption == null) {
      paramQCircleFlutterFileDownloadOption = "";
    } else {
      paramQCircleFlutterFileDownloadOption = paramQCircleFlutterFileDownloadOption.c();
    }
    QCircleFlutterAnimationLoader.a(this.b, paramQCircleFlutterFileDownloadOption, paramString, this.a);
  }
  
  public void b(QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption, String paramString)
  {
    if (paramQCircleFlutterFileDownloadOption == null) {
      paramQCircleFlutterFileDownloadOption = "";
    } else {
      paramQCircleFlutterFileDownloadOption = paramQCircleFlutterFileDownloadOption.c();
    }
    QCircleFlutterAnimationLoader.b(this.b, paramQCircleFlutterFileDownloadOption, paramString, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader.1
 * JD-Core Version:    0.7.0.1
 */