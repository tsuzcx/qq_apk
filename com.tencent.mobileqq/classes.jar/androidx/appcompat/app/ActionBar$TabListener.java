package androidx.appcompat.app;

import androidx.fragment.app.FragmentTransaction;

@Deprecated
public abstract interface ActionBar$TabListener
{
  public abstract void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction);
  
  public abstract void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction);
  
  public abstract void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBar.TabListener
 * JD-Core Version:    0.7.0.1
 */