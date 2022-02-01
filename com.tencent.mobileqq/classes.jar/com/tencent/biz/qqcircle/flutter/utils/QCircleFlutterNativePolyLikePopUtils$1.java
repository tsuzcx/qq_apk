package com.tencent.biz.qqcircle.flutter.utils;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterPolyLikeCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

final class QCircleFlutterNativePolyLikePopUtils$1
  implements PopupWindow.OnDismissListener
{
  public void onDismiss()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterPolyLikeCloseEvent(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativePolyLikePopUtils.1
 * JD-Core Version:    0.7.0.1
 */