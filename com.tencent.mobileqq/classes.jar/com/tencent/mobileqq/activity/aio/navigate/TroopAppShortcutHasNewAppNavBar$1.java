package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class TroopAppShortcutHasNewAppNavBar$1
  implements Runnable
{
  TroopAppShortcutHasNewAppNavBar$1(TroopAppShortcutHasNewAppNavBar paramTroopAppShortcutHasNewAppNavBar) {}
  
  public void run()
  {
    TroopAppShortcutHasNewAppNavBar localTroopAppShortcutHasNewAppNavBar = this.this$0;
    TroopAppShortcutHasNewAppNavBar.a(localTroopAppShortcutHasNewAppNavBar, AnimationUtils.loadAnimation(localTroopAppShortcutHasNewAppNavBar.c, 2130772145));
    TroopAppShortcutHasNewAppNavBar.a(this.this$0).clearAnimation();
    TroopAppShortcutHasNewAppNavBar.a(this.this$0).startAnimation(TroopAppShortcutHasNewAppNavBar.b(this.this$0));
    TroopAppShortcutHasNewAppNavBar.b(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutHasNewAppNavBar.1
 * JD-Core Version:    0.7.0.1
 */