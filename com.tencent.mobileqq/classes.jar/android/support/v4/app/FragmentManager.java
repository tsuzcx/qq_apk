package android.support.v4.app;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager
{
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  public static final String SHOULD_RESTORE_FROM_KILL = "should_restore_from_kill";
  
  public abstract void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract FragmentTransaction beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  public abstract Fragment findFragmentById(int paramInt);
  
  public abstract Fragment findFragmentByTag(String paramString);
  
  public abstract FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  public abstract Fragment getFragment(Bundle paramBundle, String paramString);
  
  public abstract List<Fragment> getFragments();
  
  @Deprecated
  public FragmentTransaction openTransaction()
  {
    return beginTransaction();
  }
  
  public abstract void popBackStack();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract void popBackStack(String paramString, int paramInt);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate(String paramString, int paramInt);
  
  public abstract void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment);
  
  public abstract void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */