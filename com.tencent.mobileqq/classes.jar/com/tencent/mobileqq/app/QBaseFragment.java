package com.tencent.mobileqq.app;

import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

public class QBaseFragment
  extends ReportAndroidXFragment
{
  QBaseFragment.IFragmentLifecycleCallback mIFragmentLifecycleCallback;
  
  public String getCIOPageName()
  {
    return getClass().getName();
  }
  
  public final QBaseActivity getQBaseActivity()
  {
    return (QBaseActivity)getActivity();
  }
  
  public void setFragmentLifecycleCallback(QBaseFragment.IFragmentLifecycleCallback paramIFragmentLifecycleCallback)
  {
    this.mIFragmentLifecycleCallback = paramIFragmentLifecycleCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseFragment
 * JD-Core Version:    0.7.0.1
 */