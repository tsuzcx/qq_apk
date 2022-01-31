package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

class KeyEventCompat$EclairKeyEventVersionImpl
  extends KeyEventCompat.BaseKeyEventVersionImpl
{
  public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return KeyEventCompatEclair.dispatch(paramKeyEvent, paramCallback, paramObject1, paramObject2);
  }
  
  public Object getKeyDispatcherState(View paramView)
  {
    return KeyEventCompatEclair.getKeyDispatcherState(paramView);
  }
  
  public boolean isTracking(KeyEvent paramKeyEvent)
  {
    return KeyEventCompatEclair.isTracking(paramKeyEvent);
  }
  
  public void startTracking(KeyEvent paramKeyEvent)
  {
    KeyEventCompatEclair.startTracking(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat.EclairKeyEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */