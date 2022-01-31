import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class apzk
  extends NativeGifImage
{
  boolean a = false;
  private boolean b = true;
  private boolean c;
  private boolean d;
  
  public apzk(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void a()
  {
    this.b = true;
    if ((QLog.isColorLevel()) && (this.a)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame start");
    }
  }
  
  public void b()
  {
    this.b = false;
    this.c = true;
    if ((QLog.isColorLevel()) && (this.a)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame stop");
    }
  }
  
  public void doApplyNextFrame()
  {
    if ((QLog.isColorLevel()) && (this.a)) {
      QLog.d("VoiceGifImage", 2, "doApplyNextFrame");
    }
    super.doApplyNextFrame();
    if (this.d)
    {
      this.d = false;
      this.c = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.b) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null)
      {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
        if ((QLog.isColorLevel()) && (this.a)) {
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running ");
        }
      }
    }
    label57:
    do
    {
      do
      {
        do
        {
          break label57;
          break label57;
          do
          {
            return;
          } while ((!QLog.isColorLevel()) || (!this.a));
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running, mFirstFrameBitmap is null");
          return;
          if (!this.c) {
            break;
          }
          if (this.mFirstFrameBitmap != null) {
            paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
          }
          for (;;)
          {
            if (sPaused) {
              break label161;
            }
            executeNewTask();
            if ((!QLog.isColorLevel()) || (!this.a)) {
              break;
            }
            QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart  !sPaused");
            return;
            if ((QLog.isColorLevel()) && (this.a)) {
              QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart, mFirstFrameBitmap is null");
            }
          }
        } while (this.mIsInPendingAction);
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      } while ((!QLog.isColorLevel()) || (!this.a));
      QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !mIsInPendingAction  !mIsInPendingAction");
      return;
      super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    } while ((!QLog.isColorLevel()) || (!this.a));
    label161:
    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw else");
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.c)
      {
        this.d = true;
        super.reset();
        if ((QLog.isColorLevel()) && (this.a)) {
          QLog.d("VoiceGifImage", 2, "getNextFrame restart");
        }
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzk
 * JD-Core Version:    0.7.0.1
 */