package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

abstract interface StoryPlayerImpl$Ui
{
  public abstract View a();
  
  public abstract void finish();
  
  public abstract Activity getActivity();
  
  public abstract Context getContext();
  
  public abstract void startActivity(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.Ui
 * JD-Core Version:    0.7.0.1
 */