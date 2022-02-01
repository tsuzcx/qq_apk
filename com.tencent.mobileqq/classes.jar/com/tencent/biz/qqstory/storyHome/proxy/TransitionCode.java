package com.tencent.biz.qqstory.storyHome.proxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

public abstract interface TransitionCode
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(@NonNull Activity paramActivity);
  
  public abstract void a(Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.proxy.TransitionCode
 * JD-Core Version:    0.7.0.1
 */