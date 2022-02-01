package androidx.appcompat.view.menu;

import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract interface MenuView
{
  public abstract int getWindowAnimations();
  
  public abstract void initialize(MenuBuilder paramMenuBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuView
 * JD-Core Version:    0.7.0.1
 */