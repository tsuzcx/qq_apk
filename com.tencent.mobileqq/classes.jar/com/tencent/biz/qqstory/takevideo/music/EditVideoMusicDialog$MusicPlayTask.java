package com.tencent.biz.qqstory.takevideo.music;

import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class EditVideoMusicDialog$MusicPlayTask
  extends TimerTask
{
  protected EditVideoMusicDialog$MusicPlayTask(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a() != null)
    {
      EditVideoMusicDialog localEditVideoMusicDialog = this.this$0;
      localEditVideoMusicDialog.b += 1;
      if ((!QLog.isColorLevel()) || (this.this$0.isShowing())) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.MusicPlayTask
 * JD-Core Version:    0.7.0.1
 */