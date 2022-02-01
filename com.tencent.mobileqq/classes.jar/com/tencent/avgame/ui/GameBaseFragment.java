package com.tencent.avgame.ui;

import android.view.KeyEvent;
import com.tencent.mobileqq.app.QBaseFragment;

public class GameBaseFragment
  extends QBaseFragment
{
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public IAVGameRootContainer m()
  {
    if ((getQBaseActivity() != null) && ((getQBaseActivity() instanceof IAVGameRootContainer))) {
      return (IAVGameRootContainer)getQBaseActivity();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.GameBaseFragment
 * JD-Core Version:    0.7.0.1
 */