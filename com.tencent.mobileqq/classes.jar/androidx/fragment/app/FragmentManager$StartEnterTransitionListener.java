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
    boolean bool1 = false;
    if (this.mNumPostponed > 0) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = this.mRecord.mManager.getFragments().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Fragment)((Iterator)localObject1).next();
        ((Fragment)localObject2).setOnStartEnterTransitionListener(null);
        if ((i != 0) && (((Fragment)localObject2).isPostponed())) {
          ((Fragment)localObject2).startPostponedEnterTransition();
        }
      }
    }
    Object localObject1 = this.mRecord.mManager;
    Object localObject2 = this.mRecord;
    boolean bool2 = this.mIsBack;
    if (i == 0) {
      bool1 = true;
    }
    ((FragmentManager)localObject1).completeExecute((BackStackRecord)localObject2, bool2, bool1, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.StartEnterTransitionListener
 * JD-Core Version:    0.7.0.1
 */