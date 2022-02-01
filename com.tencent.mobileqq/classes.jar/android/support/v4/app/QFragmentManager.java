package android.support.v4.app;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class QFragmentManager
{
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  public static final String SHOULD_RESTORE_FROM_KILL = "should_restore_from_kill";
  
  public abstract void addOnBackStackChangedListener(QFragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract QFragmentTransaction beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  public abstract QFragment findFragmentById(int paramInt);
  
  public abstract QFragment findFragmentByTag(String paramString);
  
  public abstract QFragmentManager.BackStackEntry getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  public abstract QFragment getFragment(Bundle paramBundle, String paramString);
  
  public abstract List<QFragment> getFragments();
  
  @Deprecated
  public QFragmentTransaction openTransaction()
  {
    return beginTransaction();
  }
  
  public abstract void popBackStack();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract void popBackStack(String paramString, int paramInt);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate(String paramString, int paramInt);
  
  public abstract void putFragment(Bundle paramBundle, String paramString, QFragment paramQFragment);
  
  public abstract void removeOnBackStackChangedListener(QFragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract QFragment.SavedState saveFragmentInstanceState(QFragment paramQFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentManager
 * JD-Core Version:    0.7.0.1
 */