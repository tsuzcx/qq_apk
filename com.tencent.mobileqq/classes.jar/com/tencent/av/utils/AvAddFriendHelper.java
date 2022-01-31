package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import khw;

public class AvAddFriendHelper
{
  public BroadcastReceiver a;
  public VideoAppInterface a;
  public AvAddFriendHelper.IAvAddFriendCallBack a;
  
  public AvAddFriendHelper(VideoAppInterface paramVideoAppInterface, AvAddFriendHelper.IAvAddFriendCallBack paramIAvAddFriendCallBack)
  {
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper$IAvAddFriendCallBack = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new khw(this);
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.AddfrindMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper$IAvAddFriendCallBack = paramIAvAddFriendCallBack;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString, paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.AvAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */