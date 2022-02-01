package com.tencent.TMG.ptt;

class PttManager$3
  implements TokenFetcher.Voice2TextListener
{
  PttManager$3(PttManager paramPttManager, PttListener.Voice2TextListener paramVoice2TextListener, String paramString) {}
  
  public void onCompleted(int paramInt, String paramString, TokenFetcher.Voice2TextInfo paramVoice2TextInfo)
  {
    if ((paramInt == 0) && (paramVoice2TextInfo != null)) {
      paramString = paramVoice2TextInfo.text;
    } else {
      paramString = null;
    }
    paramVoice2TextInfo = this.val$listener;
    if (paramVoice2TextInfo != null) {
      paramVoice2TextInfo.onCompleted(paramInt, this.val$voiceUrl, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.3
 * JD-Core Version:    0.7.0.1
 */