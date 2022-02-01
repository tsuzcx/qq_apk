package com.tencent.avgame.ui;

import android.view.KeyEvent;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class GameBaseFragment
  extends ReportV4Fragment
{
  public IAVGameRootContainer a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof IAVGameRootContainer))) {
      return (IAVGameRootContainer)getActivity();
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.GameBaseFragment
 * JD-Core Version:    0.7.0.1
 */