package com.tencent.mobileqq.activity.aio.voicetextpanel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVoice2TxtApi
  extends QRouteApi
{
  public abstract BaseVoicetoTextView getVoice2TxtView(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi
 * JD-Core Version:    0.7.0.1
 */