package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class TroopAppShortcutNavBar$1
  implements Runnable
{
  TroopAppShortcutNavBar$1(TroopAppShortcutNavBar paramTroopAppShortcutNavBar) {}
  
  public void run()
  {
    TroopAppShortcutNavBar localTroopAppShortcutNavBar = this.this$0;
    TroopAppShortcutNavBar.a(localTroopAppShortcutNavBar, AnimationUtils.loadAnimation(localTroopAppShortcutNavBar.c, 2130772145));
    TroopAppShortcutNavBar.a(this.this$0).clearAnimation();
    TroopAppShortcutNavBar.a(this.this$0).startAnimation(TroopAppShortcutNavBar.b(this.this$0));
    TroopAppShortcutNavBar.b(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1
 * JD-Core Version:    0.7.0.1
 */