package com.qflutter.video;

import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

class QflutterVideoView$1
  implements IQflutterVideoView.StatusCallBack
{
  QflutterVideoView$1(QflutterVideoView paramQflutterVideoView) {}
  
  public void on(int paramInt, Map<String, Object> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStatus ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(paramMap);
    Log.d("QFVideoView", ((StringBuilder)localObject).toString());
    localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("maEventName", QflutterVideoView.access$000(this.this$0, paramInt, (Map)localObject));
    QflutterVideoView.access$200(this.this$0).post(new QflutterVideoView.1.1(this, (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.video.QflutterVideoView.1
 * JD-Core Version:    0.7.0.1
 */