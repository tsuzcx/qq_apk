package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ContentFrameLayout;

class AppCompatDelegateImpl$ListMenuDecorView
  extends ContentFrameLayout
{
  public AppCompatDelegateImpl$ListMenuDecorView(AppCompatDelegateImpl paramAppCompatDelegateImpl, Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isOutOfBounds(int paramInt1, int paramInt2)
  {
    return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      this.this$0.closePanel(0);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ListMenuDecorView
 * JD-Core Version:    0.7.0.1
 */