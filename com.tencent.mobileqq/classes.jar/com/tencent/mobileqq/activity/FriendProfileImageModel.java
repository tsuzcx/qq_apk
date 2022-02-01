package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class FriendProfileImageModel
{
  public String h;
  protected FriendProfileImageModel.InfoUpdateListener i;
  protected int j = -1;
  protected FriendProfileImageModel.ProfileImageInfo k;
  public QQAppInterface l;
  
  public FriendProfileImageModel(QQAppInterface paramQQAppInterface)
  {
    this.l = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public abstract void a(int paramInt);
  
  public void a(FriendProfileImageModel.InfoUpdateListener paramInfoUpdateListener)
  {
    this.i = paramInfoUpdateListener;
  }
  
  public abstract void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public Drawable b()
  {
    return null;
  }
  
  public abstract FriendProfileImageModel.ProfileImageInfo b(int paramInt);
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public FriendProfileImageModel.ProfileImageInfo c()
  {
    return this.k;
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo == this.k)
    {
      FriendProfileImageModel.InfoUpdateListener localInfoUpdateListener = this.i;
      if (localInfoUpdateListener != null) {
        localInfoUpdateListener.a(paramProfileImageInfo);
      }
    }
  }
  
  public int d()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageModel
 * JD-Core Version:    0.7.0.1
 */