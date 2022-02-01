package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.State;

final class FragmentTransaction$Op
{
  int mCmd;
  Lifecycle.State mCurrentMaxState;
  int mEnterAnim;
  int mExitAnim;
  Fragment mFragment;
  Lifecycle.State mOldMaxState;
  int mPopEnterAnim;
  int mPopExitAnim;
  
  FragmentTransaction$Op() {}
  
  FragmentTransaction$Op(int paramInt, Fragment paramFragment)
  {
    this.mCmd = paramInt;
    this.mFragment = paramFragment;
    this.mOldMaxState = Lifecycle.State.RESUMED;
    this.mCurrentMaxState = Lifecycle.State.RESUMED;
  }
  
  FragmentTransaction$Op(int paramInt, @NonNull Fragment paramFragment, Lifecycle.State paramState)
  {
    this.mCmd = paramInt;
    this.mFragment = paramFragment;
    this.mOldMaxState = paramFragment.mMaxState;
    this.mCurrentMaxState = paramState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransaction.Op
 * JD-Core Version:    0.7.0.1
 */