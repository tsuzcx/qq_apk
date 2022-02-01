package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.view.ViewGroup;

public abstract class FlowPanel
{
  FlowActivity a;
  
  public FlowPanel(FlowActivity paramFlowActivity)
  {
    this.a = paramFlowActivity;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public abstract void a(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowPanel
 * JD-Core Version:    0.7.0.1
 */