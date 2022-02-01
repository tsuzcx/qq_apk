package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class FriendProfileImageModel
{
  protected FriendProfileImageModel.InfoUpdateListener a;
  protected FriendProfileImageModel.ProfileImageInfo a;
  public QQAppInterface a;
  protected int b = -1;
  public String b;
  
  public FriendProfileImageModel(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public Drawable a()
  {
    return null;
  }
  
  public FriendProfileImageModel.ProfileImageInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo;
  }
  
  public abstract FriendProfileImageModel.ProfileImageInfo a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public void a(FriendProfileImageModel.InfoUpdateListener paramInfoUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener = paramInfoUpdateListener;
  }
  
  public abstract void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public int b()
  {
    return this.b;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((paramProfileImageInfo == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.a(paramProfileImageInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageModel
 * JD-Core Version:    0.7.0.1
 */