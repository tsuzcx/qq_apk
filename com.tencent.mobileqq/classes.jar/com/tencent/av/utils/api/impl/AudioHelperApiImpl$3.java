package com.tencent.av.utils.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AudioHelperApiImpl$3
  implements Runnable
{
  AudioHelperApiImpl$3(AudioHelperApiImpl paramAudioHelperApiImpl, String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("de:");
    localStringBuilder.append(this.a);
    localObject = QQToast.a((Context)localObject, localStringBuilder.toString(), 1);
    ((QQToast)localObject).a();
    ((QQToast)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.AudioHelperApiImpl.3
 * JD-Core Version:    0.7.0.1
 */