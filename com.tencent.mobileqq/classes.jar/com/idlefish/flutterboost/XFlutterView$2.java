package com.idlefish.flutterboost;

import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import java.util.Iterator;
import java.util.Set;

class XFlutterView$2
  implements FlutterUiDisplayListener
{
  XFlutterView$2(XFlutterView paramXFlutterView) {}
  
  public void onFlutterUiDisplayed()
  {
    XFlutterView.access$102(this.this$0, true);
    Iterator localIterator = XFlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
    }
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    XFlutterView.access$102(this.this$0, false);
    Iterator localIterator = XFlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.XFlutterView.2
 * JD-Core Version:    0.7.0.1
 */