import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifIndex8;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class anmn
  extends NativeGifIndex8
{
  private boolean a = true;
  private boolean b;
  private boolean c;
  
  public anmn(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void a()
  {
    this.a = true;
  }
  
  public void b()
  {
    this.a = false;
    this.b = true;
  }
  
  public void doApplyNextFrame()
  {
    super.doApplyNextFrame();
    if (this.c)
    {
      this.c = false;
      this.b = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.a) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      if (!this.b) {
        break;
      }
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
    return;
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.b)
      {
        this.c = true;
        super.reset();
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anmn
 * JD-Core Version:    0.7.0.1
 */