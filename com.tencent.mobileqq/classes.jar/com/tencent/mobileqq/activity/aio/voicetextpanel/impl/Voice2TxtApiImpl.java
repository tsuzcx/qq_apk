package com.tencent.mobileqq.activity.aio.voicetextpanel.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;

public class Voice2TxtApiImpl
  implements IVoice2TxtApi
{
  public BaseVoicetoTextView getVoice2TxtView(Context paramContext)
  {
    return (BaseVoicetoTextView)View.inflate(paramContext, 2131624159, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.impl.Voice2TxtApiImpl
 * JD-Core Version:    0.7.0.1
 */