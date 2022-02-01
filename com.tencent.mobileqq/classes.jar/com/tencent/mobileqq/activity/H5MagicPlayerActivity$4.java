package com.tencent.mobileqq.activity;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class H5MagicPlayerActivity$4
  extends TimerTask
{
  H5MagicPlayerActivity$4(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidMediaSoundPool != null) && (this.this$0.jdField_a_of_type_AndroidMediaSoundPool.play(this.this$0.b, 1.0F, 1.0F, 0, this.this$0.jdField_a_of_type_Int - 1, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity.4
 * JD-Core Version:    0.7.0.1
 */