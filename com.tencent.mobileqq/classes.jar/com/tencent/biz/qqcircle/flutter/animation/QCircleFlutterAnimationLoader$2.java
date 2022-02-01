package com.tencent.biz.qqcircle.flutter.animation;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory.OnZipFileListener;
import com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipOption;
import java.util.Map;

class QCircleFlutterAnimationLoader$2
  implements QCircleFlutterZipFileFactory.OnZipFileListener
{
  QCircleFlutterAnimationLoader$2(QCircleFlutterAnimationLoader paramQCircleFlutterAnimationLoader, boolean paramBoolean) {}
  
  public void a(QCircleFlutterZipOption paramQCircleFlutterZipOption, String[] paramArrayOfString)
  {
    if (paramQCircleFlutterZipOption == null) {
      paramQCircleFlutterZipOption = "";
    } else {
      paramQCircleFlutterZipOption = paramQCircleFlutterZipOption.c();
    }
    if ((!TextUtils.isEmpty(paramQCircleFlutterZipOption)) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      QCircleFlutterAnimationLoader.a(this.b).put(paramQCircleFlutterZipOption, new QCircleFlutterAnimationLoader.AnimationParam(paramArrayOfString));
      QCircleFlutterAnimationLoader.a(this.b, true, paramQCircleFlutterZipOption, new QCircleFlutterAnimationLoader.AnimationParam(paramArrayOfString));
      if (this.a) {
        QCircleFlutterAnimationLoader.b(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader.2
 * JD-Core Version:    0.7.0.1
 */