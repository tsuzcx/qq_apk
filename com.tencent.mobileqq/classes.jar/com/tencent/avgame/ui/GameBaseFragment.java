package com.tencent.avgame.ui;

import android.view.KeyEvent;
import com.tencent.mobileqq.app.QBaseFragment;

public class GameBaseFragment
  extends QBaseFragment
{
  public IAVGameRootContainer a()
  {
    if ((getQBaseActivity() != null) && ((getQBaseActivity() instanceof IAVGameRootContainer))) {
      return (IAVGameRootContainer)getQBaseActivity();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.GameBaseFragment
 * JD-Core Version:    0.7.0.1
 */