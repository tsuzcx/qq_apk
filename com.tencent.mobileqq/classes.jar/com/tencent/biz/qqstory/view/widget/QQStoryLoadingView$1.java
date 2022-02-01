package com.tencent.biz.qqstory.view.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;

class QQStoryLoadingView$1
  extends Handler
{
  QQStoryLoadingView$1(QQStoryLoadingView paramQQStoryLoadingView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 0) && (i != 4) && (i != 8)) {
      return;
    }
    Object localObject = paramMessage.obj;
    String str;
    if (paramMessage.what == 8) {
      str = "GONE";
    } else if (paramMessage.what == 0) {
      str = "VISIBLE";
    } else {
      str = "INVISIBLE";
    }
    SLog.a("QQStoryLoadingView", "%s => setVisibility => %s", localObject, str);
    this.a.setVisibility(paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingView.1
 * JD-Core Version:    0.7.0.1
 */