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
    localObject = QQToast.makeText((Context)localObject, localStringBuilder.toString(), 1);
    ((QQToast)localObject).setAutoTextSize();
    ((QQToast)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.AudioHelperApiImpl.3
 * JD-Core Version:    0.7.0.1
 */