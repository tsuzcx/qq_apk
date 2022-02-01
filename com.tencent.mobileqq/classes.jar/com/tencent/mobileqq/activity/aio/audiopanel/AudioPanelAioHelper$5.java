package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class AudioPanelAioHelper$5
  implements Runnable
{
  AudioPanelAioHelper$5(AudioPanelAioHelper paramAudioPanelAioHelper, boolean paramBoolean) {}
  
  public void run()
  {
    AudioPanelAioHelper.a(this.this$0).b(true);
    AudioPanelAioHelper.a(this.this$0).ah();
    ((AudioPanelAioHelper)AudioPanelAioHelper.a(this.this$0).a(128)).g(0);
    AudioPanelAioHelper.a(this.this$0).jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (this.a)
    {
      ((AudioPanelAioHelper)AudioPanelAioHelper.a(this.this$0).a(128)).c();
      return;
    }
    QQToast.a(AudioPanelAioHelper.a(this.this$0).getApp(), 2131689977, 1).b(AudioPanelAioHelper.a(this.this$0).jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper.5
 * JD-Core Version:    0.7.0.1
 */