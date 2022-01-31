package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

abstract interface KeyEventCompat$KeyEventVersionImpl
{
  public abstract boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2);
  
  public abstract Object getKeyDispatcherState(View paramView);
  
  public abstract boolean isTracking(KeyEvent paramKeyEvent);
  
  public abstract boolean metaStateHasModifiers(int paramInt1, int paramInt2);
  
  public abstract boolean metaStateHasNoModifiers(int paramInt);
  
  public abstract int normalizeMetaState(int paramInt);
  
  public abstract void startTracking(KeyEvent paramKeyEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */