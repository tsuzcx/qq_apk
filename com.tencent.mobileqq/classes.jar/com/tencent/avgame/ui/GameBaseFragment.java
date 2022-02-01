package com.tencent.avgame.ui;

import android.view.KeyEvent;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import njb;

public class GameBaseFragment
  extends ReportV4Fragment
{
  public njb a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof njb))) {
      return (njb)getActivity();
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.GameBaseFragment
 * JD-Core Version:    0.7.0.1
 */