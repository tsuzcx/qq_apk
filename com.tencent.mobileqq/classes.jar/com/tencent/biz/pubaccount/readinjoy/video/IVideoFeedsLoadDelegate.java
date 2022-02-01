package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;

public abstract interface IVideoFeedsLoadDelegate
{
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public abstract void a(VideoInfo paramVideoInfo);
  
  public abstract void a(DragFrameLayout paramDragFrameLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */