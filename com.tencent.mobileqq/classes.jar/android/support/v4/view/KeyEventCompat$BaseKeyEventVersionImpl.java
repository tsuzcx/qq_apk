package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

class KeyEventCompat$BaseKeyEventVersionImpl
  implements KeyEventCompat.KeyEventVersionImpl
{
  private static final int META_ALL_MASK = 247;
  private static final int META_MODIFIER_MASK = 247;
  
  private static int metaStateFilterDirectionalModifiers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 1;
    int i;
    if ((paramInt2 & paramInt3) != 0)
    {
      i = 1;
      paramInt4 |= paramInt5;
      if ((paramInt2 & paramInt4) == 0) {
        break label51;
      }
      paramInt2 = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramInt2 != 0)
        {
          throw new IllegalArgumentException("bad arguments");
          i = 0;
          break;
          label51:
          paramInt2 = 0;
          continue;
        }
        paramInt4 = paramInt1 & (paramInt4 ^ 0xFFFFFFFF);
      }
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt2 == 0);
    return paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
  }
  
  public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return paramKeyEvent.dispatch(paramCallback);
  }
  
  public Object getKeyDispatcherState(View paramView)
  {
    return null;
  }
  
  public boolean isTracking(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(paramInt1) & 0xF7, paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2;
  }
  
  public boolean metaStateHasNoModifiers(int paramInt)
  {
    return (normalizeMetaState(paramInt) & 0xF7) == 0;
  }
  
  public int normalizeMetaState(int paramInt)
  {
    if ((paramInt & 0xC0) != 0) {
      paramInt |= 0x1;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x30) != 0) {
        i = paramInt | 0x2;
      }
      return i & 0xF7;
    }
  }
  
  public void startTracking(KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */