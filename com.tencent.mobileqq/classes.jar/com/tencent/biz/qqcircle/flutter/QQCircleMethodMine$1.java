package com.tencent.biz.qqcircle.flutter;

import android.view.View;
import com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader.AnimationParam;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

final class QQCircleMethodMine$1
  implements QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback
{
  QQCircleMethodMine$1(View paramView, MethodChannel.Result paramResult) {}
  
  public void a(Map<String, QCircleFlutterAnimationLoader.AnimationParam> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCircleMethodMine", 1, "[preloadPushAnimResource] onDownloadAllTaskFinish");
    }
    paramMap = QCircleFlutterAnimationLoader.a().a("pushCount");
    if (paramMap == null)
    {
      QLog.w("QQCircleMethodMine", 1, "[preloadPushAnimResource] invalid param");
      return;
    }
    PushCountImageRenderer.a(paramMap.a, new QQCircleMethodMine.1.1(this));
    QCircleFlutterAnimationLoader.a().b(this);
  }
  
  public void a(boolean paramBoolean, String paramString, QCircleFlutterAnimationLoader.AnimationParam paramAnimationParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.1
 * JD-Core Version:    0.7.0.1
 */