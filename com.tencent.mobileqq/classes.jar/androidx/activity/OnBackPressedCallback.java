package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback
{
  private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList();
  private boolean mEnabled;
  
  public OnBackPressedCallback(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  void addCancellable(@NonNull Cancellable paramCancellable)
  {
    this.mCancellables.add(paramCancellable);
  }
  
  @MainThread
  public abstract void handleOnBackPressed();
  
  @MainThread
  public final boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  @MainThread
  public final void remove()
  {
    Iterator localIterator = this.mCancellables.iterator();
    while (localIterator.hasNext()) {
      ((Cancellable)localIterator.next()).cancel();
    }
  }
  
  void removeCancellable(@NonNull Cancellable paramCancellable)
  {
    this.mCancellables.remove(paramCancellable);
  }
  
  @MainThread
  public final void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.OnBackPressedCallback
 * JD-Core Version:    0.7.0.1
 */