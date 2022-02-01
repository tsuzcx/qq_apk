package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener;

public abstract interface ISceneCallback
  extends DragView.OnGestureChangeListener
{
  public abstract View a();
  
  public abstract RelativeLayout.LayoutParams a();
  
  public abstract Class<? extends AbstractPhotoListActivity> a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(View paramView);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract View b();
  
  public abstract RelativeLayout.LayoutParams b();
  
  public abstract void b();
  
  public abstract void g();
  
  public abstract void j();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.ISceneCallback
 * JD-Core Version:    0.7.0.1
 */