package com.tencent.biz.qqstory.takevideo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;

public abstract class StoryCapturePart
{
  public StoryEffectsCameraCaptureFragment a;
  
  public StoryCapturePart(@NonNull StoryEffectsCameraCaptureFragment paramStoryEffectsCameraCaptureFragment)
  {
    this.a = paramStoryEffectsCameraCaptureFragment;
  }
  
  public int a()
  {
    return this.a.c();
  }
  
  public Bundle a()
  {
    return this.a.a();
  }
  
  public FragmentActivity a()
  {
    return this.a.getActivity();
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult) {}
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryCapturePart
 * JD-Core Version:    0.7.0.1
 */