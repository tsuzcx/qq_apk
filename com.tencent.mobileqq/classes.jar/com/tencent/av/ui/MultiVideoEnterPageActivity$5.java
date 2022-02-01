package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import java.util.ArrayList;

class MultiVideoEnterPageActivity$5
  extends GAudioUIObserver
{
  MultiVideoEnterPageActivity$5(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.b()) {
      return;
    }
    this.a.c(paramInt);
  }
  
  public void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    if (this.a.b()) {
      return;
    }
    this.a.a(paramLong, paramArrayList, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.b()) {}
    do
    {
      do
      {
        return;
      } while (paramLong != this.a.jdField_a_of_type_Long);
      if (paramBoolean)
      {
        this.a.b(paramInt);
        return;
      }
    } while (((paramInt != 10) && (paramInt != 1)) || (!MultiVideoEnterPageActivity.a(this.a)));
    this.a.a(paramInt);
  }
  
  public void e()
  {
    if (this.a.b()) {}
    while (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    super.e();
    ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.e();
    localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(localArrayList.size(), localArrayList);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.5
 * JD-Core Version:    0.7.0.1
 */