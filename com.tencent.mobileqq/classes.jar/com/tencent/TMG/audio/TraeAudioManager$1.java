package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;

class TraeAudioManager$1
  implements Runnable
{
  TraeAudioManager$1(TraeAudioManager paramTraeAudioManager, Intent paramIntent, Long paramLong, String paramString, int paramInt) {}
  
  public void run()
  {
    this.val$TAMintent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    this.val$TAMintent.putExtra("PARAM_SESSIONID", this.val$TAMSessionId);
    this.val$TAMintent.putExtra("PARAM_OPERATION", this.val$TAMOperation);
    this.val$TAMintent.putExtra("PARAM_RES_ERRCODE", this.val$TAMerr);
    if (this.this$0._context != null) {
      this.this$0._context.sendBroadcast(this.val$TAMintent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.1
 * JD-Core Version:    0.7.0.1
 */