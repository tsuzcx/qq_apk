package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;

public abstract interface EditVideoUi
{
  public abstract void dismissLoadingDialog();
  
  public abstract void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3);
  
  public abstract void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean);
  
  @Nullable
  public abstract Activity getActivity();
  
  @NonNull
  public abstract Context getContext();
  
  public abstract Intent getPublishIntent(GenerateContext paramGenerateContext);
  
  @NonNull
  public abstract View getRootView();
  
  public abstract void showLoadingDialog(CharSequence paramCharSequence, boolean paramBoolean, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi
 * JD-Core Version:    0.7.0.1
 */