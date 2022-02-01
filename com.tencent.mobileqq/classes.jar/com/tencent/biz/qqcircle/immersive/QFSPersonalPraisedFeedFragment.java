package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class QFSPersonalPraisedFeedFragment
  extends QFSPersonalFeedFragment
{
  private void x()
  {
    VideoReport.setElementId(this.D, "em_xsj_profile_praise_tab");
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    x();
  }
  
  void u()
  {
    if (this.f != null)
    {
      if (this.f.h() == null) {
        return;
      }
      this.f.h().observe(this, new QFSPersonalPraisedFeedFragment.1(this));
      this.f.d().observe(this, new QFSPersonalPraisedFeedFragment.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalPraisedFeedFragment
 * JD-Core Version:    0.7.0.1
 */