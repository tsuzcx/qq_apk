package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public abstract interface EditVideoUi
{
  @NonNull
  public abstract Context a();
  
  public abstract Intent a(GenerateContext paramGenerateContext);
  
  @NonNull
  public abstract View a();
  
  public abstract void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3);
  
  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong);
  
  public abstract void f();
  
  @Nullable
  public abstract Activity getActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoUi
 * JD-Core Version:    0.7.0.1
 */