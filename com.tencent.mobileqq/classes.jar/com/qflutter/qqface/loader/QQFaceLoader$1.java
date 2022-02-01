package com.qflutter.qqface.loader;

import android.os.Handler;
import android.text.TextUtils;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import io.flutter.plugin.common.MethodChannel.Result;

class QQFaceLoader$1
  implements Runnable
{
  QQFaceLoader$1(QQFaceLoader paramQQFaceLoader, QQFaceParam paramQQFaceParam, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$qqFaceParam.account)) && (QQFaceLoader.access$200(this.this$0) != null))
    {
      QQFaceNativeData localQQFaceNativeData = QQFaceLoader.access$200(this.this$0).getFaceData(this.val$qqFaceParam);
      QQFaceLoader.access$300(this.this$0).post(new QQFaceLoader.1.2(this, localQQFaceNativeData));
      return;
    }
    QQFaceLoader.access$300(this.this$0).post(new QQFaceLoader.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqface.loader.QQFaceLoader.1
 * JD-Core Version:    0.7.0.1
 */