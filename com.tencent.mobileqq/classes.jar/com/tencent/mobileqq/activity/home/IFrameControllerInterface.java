package com.tencent.mobileqq.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.ABotDragClickListener;
import com.tencent.mobileqq.app.FrameFragment;
import mqq.app.AppRuntime;

public abstract interface IFrameControllerInterface
{
  public abstract int a(int paramInt);
  
  public abstract int a(FrameFragment paramFrameFragment);
  
  public abstract void a(TextView paramTextView, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(TabFrameControllerImpl.ABotDragClickListener paramABotDragClickListener);
  
  public abstract void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment);
  
  public abstract void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt);
  
  public abstract void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, boolean paramBoolean);
  
  public abstract void a(FrameFragment paramFrameFragment);
  
  public abstract void a(FrameFragment paramFrameFragment, int paramInt);
  
  public abstract void a(FrameFragment paramFrameFragment, Intent paramIntent);
  
  public abstract void a(FrameFragment paramFrameFragment, Intent paramIntent, Bundle paramBundle, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(FrameFragment paramFrameFragment);
  
  public abstract boolean a(AppRuntime paramAppRuntime);
  
  public abstract View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, LayoutInflater paramLayoutInflater);
  
  public abstract View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, View paramView);
  
  public abstract void b(FrameFragment paramFrameFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.IFrameControllerInterface
 * JD-Core Version:    0.7.0.1
 */