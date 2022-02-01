package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.smtt.sdk.ValueCallback;

class LiteRoomWebModule$1$1
  implements ValueCallback<String>
{
  LiteRoomWebModule$1$1(LiteRoomWebModule.1 param1, JsBizAdapter.ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(String paramString)
  {
    JsBizAdapter.ValueCallback localValueCallback = this.val$valueCallback;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomWebModule.1.1
 * JD-Core Version:    0.7.0.1
 */