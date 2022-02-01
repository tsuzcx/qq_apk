package com.tencent.intervideo.nowproxy.ability;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowCookieEvent;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;

class SdkBaseAbilityImpl$1
  implements NowCookieEvent
{
  SdkBaseAbilityImpl$1(SdkBaseAbilityImpl paramSdkBaseAbilityImpl, Bundle paramBundle, String paramString) {}
  
  public void onCookieReady(Bundle paramBundle)
  {
    this.val$bundle.putAll(paramBundle);
    this.this$0.mCustomizedWebView.onJumpWeb(this.val$url, this.val$bundle, this.this$0.mWebcallHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl.1
 * JD-Core Version:    0.7.0.1
 */