package com.qflutter.qqface.loader;

import android.util.Log;
import com.qflutter.qqface.data.QQFaceFlutterData;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import io.flutter.plugin.common.MethodChannel.Result;

class QQFaceLoader$1$2
  implements Runnable
{
  QQFaceLoader$1$2(QQFaceLoader.1 param1, QQFaceNativeData paramQQFaceNativeData) {}
  
  public void run()
  {
    Object localObject = this.val$nativeData;
    if ((localObject != null) && (!((QQFaceNativeData)localObject).isEmpty()))
    {
      localObject = this.this$1.this$0;
      String str = this.this$1.val$qqFaceParam.getFaceId();
      QQFaceNativeData localQQFaceNativeData = this.val$nativeData;
      localObject = QQFaceLoader.access$400((QQFaceLoader)localObject, str, localQQFaceNativeData, localQQFaceNativeData.shareBitmap);
      this.this$1.val$result.success(((QQFaceFlutterData)localObject).toMap());
      return;
    }
    Log.e("QQFaceLoader", "asyncLoadQQFace, nativeData is empty");
    this.this$1.val$result.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqface.loader.QQFaceLoader.1.2
 * JD-Core Version:    0.7.0.1
 */