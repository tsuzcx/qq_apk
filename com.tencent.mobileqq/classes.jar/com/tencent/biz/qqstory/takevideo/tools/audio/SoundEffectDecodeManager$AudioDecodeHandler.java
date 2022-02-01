package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class SoundEffectDecodeManager$AudioDecodeHandler
  extends Handler
{
  public SoundEffectDecodeManager$AudioDecodeHandler(SoundEffectDecodeManager paramSoundEffectDecodeManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @RequiresApi(api=16)
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        if ((!TextUtils.isEmpty((String)paramMessage.obj)) && (FileUtils.a((String)paramMessage.obj)))
        {
          synchronized (this.a)
          {
            if (SoundEffectDecodeManager.a(this.a).containsKey(paramMessage.obj))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SoundEffectDecodeManager", 2, "has cached path : " + paramMessage.obj);
              }
              return;
            }
          }
          SoundEffectDecodeManager.a(this.a).a((String)paramMessage.obj, false);
        }
      }
      catch (Exception paramMessage)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.SoundEffectDecodeManager.AudioDecodeHandler
 * JD-Core Version:    0.7.0.1
 */