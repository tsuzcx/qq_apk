package com.tencent.biz.pubaccount;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class VideoAudioManager
{
  private int jdField_a_of_type_Int = -1;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
  public VideoAudioManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "doOnDestroy() , mOriginalMusicVolume = " + this.jdField_b_of_type_Int + ", mTargetMusicVolume = " + this.e);
    }
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != this.e) && (i == this.e)) {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoAudioManager
 * JD-Core Version:    0.7.0.1
 */