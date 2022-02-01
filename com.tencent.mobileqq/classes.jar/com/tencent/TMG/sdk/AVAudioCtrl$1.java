package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback;

class AVAudioCtrl$1
  implements TraeAudioSession.ITraeAudioCallback
{
  AVAudioCtrl$1(AVAudioCtrl paramAVAudioCtrl) {}
  
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectDeviceRes");
    localStringBuilder.append(paramString);
    Log.e("SdkJni", localStringBuilder.toString());
    if (paramInt == 0)
    {
      if (!paramBoolean) {
        return;
      }
      if (paramBoolean) {
        AVAudioCtrl.access$002(this.this$0, paramString);
      }
    }
  }
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetConnectedDeviceRes");
    localStringBuilder.append(paramString);
    Log.e("SdkJni", localStringBuilder.toString());
  }
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetConnectingDeviceRes");
    localStringBuilder.append(paramString);
    Log.e("SdkJni", localStringBuilder.toString());
  }
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new StringBuilder();
    paramString2.append("onGetDeviceListRes");
    paramString2.append(paramString1);
    Log.e("SdkJni", paramString2.toString());
    if (paramInt != 0) {
      return;
    }
    AVAudioCtrl.access$102(this.this$0, paramArrayOfString);
    AVAudioCtrl.access$002(this.this$0, paramString1);
  }
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2)
  {
    AVAudioCtrl.access$502(this.this$0, paramInt2);
  }
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onRingCompletion(int paramInt, String paramString) {}
  
  public void onServiceStateUpdate(boolean paramBoolean) {}
  
  public void onStreamTypeUpdate(int paramInt)
  {
    AVAudioCtrl.access$502(this.this$0, paramInt);
  }
  
  public void onVoicecallPreprocessRes(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl.1
 * JD-Core Version:    0.7.0.1
 */