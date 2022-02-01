package com.tencent.aelight.camera.aioeditor.capture.view;

import android.os.Message;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.LoadMusicStepListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class MusicProviderView$4
  implements QIMMusicConfigManager.LoadMusicStepListener
{
  MusicProviderView$4(MusicProviderView paramMusicProviderView) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onStep:");
      paramObject.append(paramInt);
      paramObject.append(" done:");
      paramObject.append(paramBoolean);
      QLog.d("MusicProviderView", 2, paramObject.toString());
    }
    if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      this.a.f.sendEmptyMessage(3);
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.a.f.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    localMessage.what = 4;
    this.a.f.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView.4
 * JD-Core Version:    0.7.0.1
 */