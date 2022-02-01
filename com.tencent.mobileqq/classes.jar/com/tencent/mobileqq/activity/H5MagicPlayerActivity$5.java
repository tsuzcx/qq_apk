package com.tencent.mobileqq.activity;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class H5MagicPlayerActivity$5
  extends TimerTask
{
  H5MagicPlayerActivity$5(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.i != null) && (this.this$0.i.play(this.this$0.l, 1.0F, 1.0F, 0, this.this$0.k - 1, 1.0F) == 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play failure filepath=");
      localStringBuilder.append(this.a);
      QLog.d("SoundPoolUtil", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity.5
 * JD-Core Version:    0.7.0.1
 */