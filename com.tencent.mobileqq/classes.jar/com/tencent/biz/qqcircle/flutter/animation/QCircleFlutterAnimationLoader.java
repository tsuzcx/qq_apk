package com.tencent.biz.qqcircle.flutter.animation;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadFactory;
import com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadOption;
import com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory;
import com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipOption;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QCircleFlutterAnimationLoader
{
  private Map<String, QCircleFlutterAnimationLoader.AnimationParam> a = null;
  private Map<String, String> b = null;
  private Set<QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback> c = null;
  
  private QCircleFlutterAnimationLoader()
  {
    this.b.put("singleTapAnim", "https://downv6.qq.com/video_story/qcircle/animation/rocket_single_click_new.zip");
    this.b.put("rocket1Anim", "https://downv6.qq.com/video_story/qcircle/animation/rocket1_new.zip");
    this.b.put("rocket2Anim", "https://downv6.qq.com/video_story/qcircle/animation/rocket2_new.zip");
    this.b.put("rocket3Anim", "https://downv6.qq.com/video_story/qcircle/animation/rocket3_new.zip");
    this.b.put("rocketBoomAnim", "https://downv6.qq.com/video_story/qcircle/animation/rocket_end_new.zip");
    this.b.put("pushCount", "https://downv6.qq.com/video_story/qcircle/animation/rocket_count.zip");
    this.b.put("appearAnim", "https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip");
    this.b.put("disappearAnim", "https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip");
    this.b.put("disappearBoomAnim", "https://downv6.qq.com/video_story/wezone_url/defaultmode/8417/feed_push_explode/feed_push_explode_pressed_seq_v2.zip");
  }
  
  public static QCircleFlutterAnimationLoader a()
  {
    return QCircleFlutterAnimationLoader.SingleHolder.a;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("QCircleFlutterAnimationLoader", 2, "[handlerDownloadFinish] key not is empty.");
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      QLog.d("QCircleFlutterAnimationLoader", 2, "[handlerDownloadFinish] file path");
    }
    QLog.d("QCircleFlutterAnimationLoader", 2, new Object[] { "[handlerDownloadFinish] file path: ", paramString2, " | key: ", paramString1 });
    QCircleFlutterZipOption localQCircleFlutterZipOption = QCircleFlutterZipOption.a();
    localQCircleFlutterZipOption.a(paramString2);
    localQCircleFlutterZipOption.b(paramString1);
    QCircleFlutterZipFileFactory.a().a(localQCircleFlutterZipOption, new QCircleFlutterAnimationLoader.2(this, paramBoolean));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str = (String)this.b.get(paramString);
    QCircleFlutterFileDownloadOption localQCircleFlutterFileDownloadOption = QCircleFlutterFileDownloadOption.e();
    localQCircleFlutterFileDownloadOption.b(paramString);
    localQCircleFlutterFileDownloadOption.a(str);
    localQCircleFlutterFileDownloadOption.a(true);
    QCircleFlutterFileDownloadFactory.a().a(localQCircleFlutterFileDownloadOption, new QCircleFlutterAnimationLoader.1(this, paramBoolean));
  }
  
  private void a(Map<String, QCircleFlutterAnimationLoader.AnimationParam> paramMap)
  {
    QLog.d("QCircleFlutterAnimationLoader", 2, new Object[] { "[notifyLoadAllTaskFinish] source size: ", Integer.valueOf(paramMap.size()) });
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback)localIterator.next()).a(paramMap);
    }
  }
  
  private void a(boolean paramBoolean, String paramString, QCircleFlutterAnimationLoader.AnimationParam paramAnimationParam)
  {
    if ((paramAnimationParam != null) && (paramAnimationParam.a != null)) {
      localObject = Integer.valueOf(paramAnimationParam.a.length);
    } else {
      localObject = null;
    }
    QLog.d("QCircleFlutterAnimationLoader", 2, new Object[] { "[notifyLoadSingleTaskResult] isSuccess: ", Boolean.valueOf(paramBoolean), " | key: ", paramString, " | paths size: ", localObject });
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback)((Iterator)localObject).next()).a(paramBoolean, paramString, paramAnimationParam);
    }
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      QLog.d("QCircleFlutterAnimationLoader", 2, "[handlerDownloadFail] key not is empty.");
      return;
    }
    QLog.d("QCircleFlutterAnimationLoader", 2, new Object[] { "[handlerDownloadFail] error msg: ", paramString2 });
    paramString2 = new String[0];
    this.a.put(paramString1, new QCircleFlutterAnimationLoader.AnimationParam(paramString2));
    a(false, paramString1, new QCircleFlutterAnimationLoader.AnimationParam(paramString2));
    if (paramBoolean) {
      c();
    }
  }
  
  private void c()
  {
    if (this.a.size() == this.b.size()) {
      a(this.a);
    }
  }
  
  public QCircleFlutterAnimationLoader.AnimationParam a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (QCircleFlutterAnimationLoader.AnimationParam)this.a.get(paramString);
  }
  
  public void a(QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback paramOnLoadAnimationResultCallback)
  {
    if (paramOnLoadAnimationResultCallback == null)
    {
      QLog.d("QCircleFlutterAnimationLoader", 2, "[registerDownloadAllTaskCallback] callback not is null.");
      return;
    }
    this.c.add(paramOnLoadAnimationResultCallback);
  }
  
  public void b()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      a((String)localIterator.next(), true);
    }
  }
  
  public void b(QCircleFlutterAnimationLoader.OnLoadAnimationResultCallback paramOnLoadAnimationResultCallback)
  {
    if (paramOnLoadAnimationResultCallback == null)
    {
      QLog.d("QCircleFlutterAnimationLoader", 2, "[unregisterDownloadAllTaskCallback] callback not is null.");
      return;
    }
    this.c.remove(paramOnLoadAnimationResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader
 * JD-Core Version:    0.7.0.1
 */