package com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;

public class MvVideoViewModel
  extends ViewModel
{
  public MutableLiveData<ResourceModel> a;
  private MoviePlayer a;
  private MutableLiveData<Long> b = new MutableLiveData();
  
  public MvVideoViewModel()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public void a()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      localMoviePlayer.play();
    }
  }
  
  public void a(long paramLong)
  {
    this.b.postValue(Long.valueOf(paramLong));
  }
  
  public void a(CMTime paramCMTime)
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      localMoviePlayer.seekToTime(paramCMTime);
    }
  }
  
  public void a(MoviePlayer paramMoviePlayer)
  {
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = paramMoviePlayer;
  }
  
  public boolean a()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      return localMoviePlayer.isPlaying();
    }
    return false;
  }
  
  public void b()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      localMoviePlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel
 * JD-Core Version:    0.7.0.1
 */