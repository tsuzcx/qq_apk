package com.tencent.biz.subscribe.framework;

import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.videostory.EventControlUtils.OnDebounceListener;
import com.tencent.superplayer.api.ISuperPlayer;

class BaseVideoView$6
  implements EventControlUtils.OnDebounceListener
{
  BaseVideoView$6(BaseVideoView paramBaseVideoView, SeekBar paramSeekBar) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    localMessage.arg2 = ((int)this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoView.a().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoView.b()) {
      this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoView.a(this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress());
    }
    this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoView.a().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.6
 * JD-Core Version:    0.7.0.1
 */