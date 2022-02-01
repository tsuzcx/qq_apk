package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import java.util.ArrayList;

class MultiVideoEnterPageActivity$5
  extends GAudioUIObserver
{
  MultiVideoEnterPageActivity$5(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(int paramInt)
  {
    if (this.b.e()) {
      return;
    }
    this.b.c(paramInt);
  }
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    if (this.b.e()) {
      return;
    }
    this.b.a(paramLong, paramArrayList, paramInt1, paramInt2);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.b.e()) {
      return;
    }
    if (paramLong == this.b.k)
    {
      if (paramBoolean)
      {
        this.b.b(paramInt);
        return;
      }
      if (((paramInt == 10) || (paramInt == 1)) && (MultiVideoEnterPageActivity.b(this.b))) {
        this.b.a(paramInt);
      }
    }
  }
  
  protected void e()
  {
    if (this.b.e()) {
      return;
    }
    if (!this.b.z)
    {
      super.e();
      ArrayList localArrayList = this.b.u.W();
      localArrayList = this.b.u.a(localArrayList.size(), localArrayList);
      this.b.f.a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.5
 * JD-Core Version:    0.7.0.1
 */