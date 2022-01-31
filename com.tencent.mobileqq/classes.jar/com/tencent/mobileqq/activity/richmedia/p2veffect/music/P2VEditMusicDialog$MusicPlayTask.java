package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import ajot;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class P2VEditMusicDialog$MusicPlayTask
  extends TimerTask
{
  protected P2VEditMusicDialog$MusicPlayTask(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Ajot.a() != null)
    {
      P2VEditMusicDialog localP2VEditMusicDialog = this.this$0;
      localP2VEditMusicDialog.b += 1;
      if (QLog.isColorLevel()) {}
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.MusicPlayTask
 * JD-Core Version:    0.7.0.1
 */