package androidx.fragment.app;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;

class FragmentManager$StartEnterTransitionListener
  implements Fragment.OnStartEnterTransitionListener
{
  final boolean mIsBack;
  private int mNumPostponed;
  final BackStackRecord mRecord;
  
  FragmentManager$StartEnterTransitionListener(@NonNull BackStackRecord paramBackStackRecord, boolean paramBoolean)
  {
    this.mIsBack = paramBoolean;
    this.mRecord = paramBackStackRecord;
  }
  
  void cancelTransaction()
  {
    this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
  }
  
  void completeTransaction()
  {
    int i;
    if (this.mNumPostponed > 0) {
      i = 1;
    } else {
      i = 0;
    }
    Iterator localIterator = this.mRecord.mManager.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      localFragment.setOnStartEnterTransitionListener(null);
      if ((i != 0) && (localFragment.isPostponed())) {
        localFragment.startPostponedEnterTransition();
      }
    }
    this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, i ^ 0x1, true);
  }
  
  public boolean isReady()
  {
    return this.mNumPostponed == 0;
  }
  
  public void onStartEnterTransition()
  {
    this.mNumPostponed -= 1;
    if (this.mNumPostponed != 0) {
      return;
    }
    this.mRecord.mManager.scheduleCommit();
  }
  
  public void startListening()
  {
    this.mNumPostponed += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.StartEnterTransitionListener
 * JD-Core Version:    0.7.0.1
 */