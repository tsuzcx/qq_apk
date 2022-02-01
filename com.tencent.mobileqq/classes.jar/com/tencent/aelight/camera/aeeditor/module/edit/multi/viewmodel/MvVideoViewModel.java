package com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.tav.coremedia.CMTime;

public class MvVideoViewModel
  extends ViewModel
{
  public MutableLiveData<ResourceModel> a = new MutableLiveData();
  private MutableLiveData<Long> b = new MutableLiveData();
  private MoviePlayer c;
  
  public void a(long paramLong)
  {
    this.b.postValue(Long.valueOf(paramLong));
  }
  
  public void a(MoviePlayer paramMoviePlayer)
  {
    this.c = paramMoviePlayer;
  }
  
  public void a(CMTime paramCMTime)
  {
    MoviePlayer localMoviePlayer = this.c;
    if (localMoviePlayer != null) {
      localMoviePlayer.seekToTime(paramCMTime);
    }
  }
  
  public boolean a()
  {
    MoviePlayer localMoviePlayer = this.c;
    if (localMoviePlayer != null) {
      return localMoviePlayer.isPlaying();
    }
    return false;
  }
  
  public void b()
  {
    MoviePlayer localMoviePlayer = this.c;
    if (localMoviePlayer != null) {
      localMoviePlayer.play();
    }
  }
  
  public void c()
  {
    MoviePlayer localMoviePlayer = this.c;
    if (localMoviePlayer != null) {
      localMoviePlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel
 * JD-Core Version:    0.7.0.1
 */